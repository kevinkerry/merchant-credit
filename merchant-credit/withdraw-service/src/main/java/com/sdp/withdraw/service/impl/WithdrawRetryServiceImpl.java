package com.sdp.withdraw.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.dto.WithdrawCoreServiceDTO;
import com.sdp.mc.common.dto.WithdrawFailRetryRuleDTO;
import com.sdp.mc.common.enums.withdraw.LogOPTypeEnums;
import com.sdp.mc.common.enums.withdraw.LogRecordTypeEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawOrderStatusEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawReqStatusEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawRetryPlanExecuteStatusEnums;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.integration.fos.dto.response.WithdrawT0QueryResponseDTO;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDO;
import com.sdp.withdraw.dao.WithdrawRetryPlanDO;
import com.sdp.withdraw.dao.WithdrawRetryPlanDOExample;
import com.sdp.withdraw.enums.ReturnCodeEnums;
import com.sdp.withdraw.manager.WithdrawReqManager;
import com.sdp.withdraw.manager.WithdrawRetryPlanManager;
import com.sdp.withdraw.manager.ext.ExtWithdrawRetryPlanManager;
import com.sdp.withdraw.service.OpLogRecordService;
import com.sdp.withdraw.service.WithDrawBaseService;
import com.sdp.withdraw.service.WithdrawCallQueueService;
import com.sdp.withdraw.service.WithdrawFailService;
import com.sdp.withdraw.service.WithdrawReqFosDetailService;
import com.sdp.withdraw.service.WithdrawReqService;
import com.sdp.withdraw.service.WithdrawRetryService;
import com.sdp.withdraw.service.WithdrawT0ServiceQueryService;
import com.sdp.withdraw.service.WithdrawT0ServiceService;
import com.shengpay.commons.core.utils.StringUtils;
import com.shengpay.facade.fos.FOSFacade;

@Service("WithdrawRetryService")
public class WithdrawRetryServiceImpl extends WithDrawBaseService implements WithdrawRetryService {
	private Logger logger = LoggerFactory.getLogger(WithdrawRetryServiceImpl.class);
	@Autowired
	private WithdrawRetryPlanManager withdrawRetryPlanManager = null;
	@Autowired
	private ExtWithdrawRetryPlanManager extWithdrawRetryPlanManager = null;
	@Autowired
	private WithdrawReqFosDetailService withdrawReqFosDetailService = null;
	@Autowired
	private WithdrawReqService withdrawReqService = null;
	@Autowired
	private FOSFacade fosFacade = null;
	@Autowired
	private WithdrawCallQueueService withdrawCallQueueService = null;
	@Autowired
	private WithdrawFailService withdrawFailService = null;
	@Autowired
	private WithdrawT0ServiceQueryService withdrawT0ServiceQueryService = null;

	@Autowired
	private WithdrawT0ServiceService withdrawT0ServiceService = null;

	@Autowired
	private WithdrawReqManager withdrawReqManager;
	@Autowired
	private OpLogRecordService opLogRecordService;

	@Override
	public List<WithdrawRetryPlanDO> queryNonexecutionRetryPlanByReqId(Long reqId) {
		WithdrawRetryPlanDOExample example = new WithdrawRetryPlanDOExample();
		WithdrawRetryPlanDOExample.Criteria criteria = example.createCriteria();
		example.setReqId(reqId);
		criteria.andExecuteStartTimeLessThan(new Date());
		criteria.andExecuteStatusNotEqualTo(WithdrawRetryPlanExecuteStatusEnums.EXECUTE_FINISH.code);
		return this.withdrawRetryPlanManager.selectByExample(example);
	}

	@Override
	public List<WithdrawRetryPlanDO> queryWaitExecutionRetryPlanByReqId(Long reqId) {
		WithdrawRetryPlanDOExample example = new WithdrawRetryPlanDOExample();
		if (reqId != null) {
			example.setReqId(reqId);
		}
		WithdrawRetryPlanDOExample.Criteria criteria = example.createCriteria();
		criteria.andExecuteStartTimeLessThan(new Date());
		example.setExecuteStatus(WithdrawRetryPlanExecuteStatusEnums.EXECUTE_WAIT.code);
		return this.withdrawRetryPlanManager.selectByExample(example);
	}

	@Override
	public List<WithdrawRetryPlanDO> queryWaitExecutionRetryPlan() {
		return queryWaitExecutionRetryPlanByReqId(null);
	}

	@Override
	public int updateDataStatus(Long planId, Integer sourceStatus, Integer targetStatus) {
		if ((sourceStatus == null)) {
			WithdrawRetryPlanDO planDo = withdrawRetryPlanManager.selectByPrimaryKey(planId);
			planDo.setExecuteStatus(targetStatus);
			if (planDo.getExecuteTime() == null) {
				planDo.setExecuteTime(new Date());
			}
			planDo.setUpdateTime(new Date());
			withdrawRetryPlanManager.updateByPrimaryKey(planDo);
		} else  {
			WithdrawRetryPlanDO planDo = new WithdrawRetryPlanDO();
			planDo.setExecuteStatus(targetStatus);
			if (WithdrawRetryPlanExecuteStatusEnums.EXECUTE_WAIT.code.equals(sourceStatus)) {
				planDo.setExecuteTime(new Date());
			}
			planDo.setUpdateTime(new Date());
			WithdrawRetryPlanDOExample example = new WithdrawRetryPlanDOExample();
			example.createCriteria().andExecuteStatusEqualTo(sourceStatus).andPlanIdEqualTo(planId);
			return extWithdrawRetryPlanManager.updateByExampleSelective(planDo, example);
		} 
		return 1;
	}

	@Override
	public void createDate(WithdrawRetryPlanDO panDo) {
		withdrawRetryPlanManager.insert(panDo);

	}

	@Override
	public void buildWithdrawFailRetryPlan(WithdrawReqDO reqDo, String remitVoucherNo, WithdrawFailRetryRuleDTO retryRule) {
		buildWithdrawFailRetryPlan(reqDo, remitVoucherNo, retryRule.getRuleContent(), retryRule.getExecuteTime());
	}

	public void buildWithdrawFailRetryPlan(WithdrawReqDO reqDo, String remitVoucherNo, String ruleContent, Date executeTime) {
		WithdrawRetryPlanDO panDo = new WithdrawRetryPlanDO();
		panDo.setCreateTime(new Date());
		panDo.setExecuteStatus(WithdrawRetryPlanExecuteStatusEnums.EXECUTE_WAIT.code);
		panDo.setReqId(reqDo.getReqId());
		panDo.setExecuteRemitVoucherNo(this.generateRemitVoucherNo(reqDo.getProductCode(), reqDo.getPaymentCode(), reqDo.getRetryTimes(),
				reqDo.getReqId()));
		panDo.setCurrentRemitVoucherNo(remitVoucherNo);
		panDo.setExecuteStartTime(executeTime);
		panDo.setRetryExecuteTimes(reqDo.getRetryTimes());
		if (ruleContent != null) {
			panDo.setRetryRule(ruleContent);
		}
		this.createDate(panDo);
	}

	@Override
	public void buildHandRetryPlan(WithdrawReqDO reqDo, String remitVoucherNo) {
		buildWithdrawFailRetryPlan(reqDo, remitVoucherNo, null, new Date());
	}

	@Override
	public void executeRetryJob() {
		// TODO 查询待重试的计划
		List<WithdrawRetryPlanDO> retryPlanList = queryWaitExecutionRetryPlan();
		if (retryPlanList == null || retryPlanList.isEmpty()) { return; }
		// TODO 循环重试计划
		for (WithdrawRetryPlanDO plan : retryPlanList) {
			boolean isFrozenQuota=false;
			if (plan == null) {
				continue;
			}
			Long reqId = plan.getReqId();
			WithdrawReqDO reqDo = withdrawReqService.queryWithdrawReqByReqId(reqId);
			if (reqDo == null) {
				logger.info("WithdrawRetryServiceImpl #executeRetryJob reqDo is null, plan:" + ToStringBuilder.reflectionToString(plan));
				this.updateDataStatus(plan.getPlanId(), WithdrawRetryPlanExecuteStatusEnums.EXECUTE_WAIT.code,
						WithdrawRetryPlanExecuteStatusEnums.EXECUTE_FINISH.code);
				continue;
			}
			try {
				// 已经出款成功
				if (WithdrawReqStatusEnums.SUCCESS.code.equals(reqDo.getStatus())) {
					logger.info("WithdrawRetryServiceImpl #executeRetryJob withdraw success, plan:" + ToStringBuilder.reflectionToString(plan));
					this.updateDataStatus(plan.getPlanId(), WithdrawRetryPlanExecuteStatusEnums.EXECUTE_WAIT.code,
							WithdrawRetryPlanExecuteStatusEnums.EXECUTE_FINISH.code);
					continue;
				}
				
				// TODO 查询上一次调用的出款状态
				WithdrawReqFosDetailDO detailDo = this.withdrawReqFosDetailService.queryWithdrawReqFosDetailByRemitVoucherNo(plan
						.getCurrentRemitVoucherNo());
				// 判断之前发起的状态（重新调用查询接口进行查询）
				if (detailDo != null && !isFosReqFail(reqDo, detailDo)) {
					this.updateDataStatus(plan.getPlanId(), WithdrawRetryPlanExecuteStatusEnums.EXECUTE_WAIT.code,
							WithdrawRetryPlanExecuteStatusEnums.EXECUTE_FINISH.code);
					logger.info("WithdrawRetryServiceImpl #executeRetryJob req fos is not fail, plan:" + ToStringBuilder.reflectionToString(plan));
					continue;
				}
				//钱包余额
				BigDecimal walletBalance=queryWalletBalance(reqDo.getMemberId());
				if(walletBalance==null||walletBalance.compareTo(reqDo.getWithdrawAmount())<0){
					logger.info("WithdrawRetryServiceImpl #executeRetryJob walletBalance not enough, walletBalance"+walletBalance+", plan:" + ToStringBuilder.reflectionToString(plan));
					this.updateDataStatus(plan.getPlanId(), WithdrawRetryPlanExecuteStatusEnums.EXECUTE_WAIT.code,
							WithdrawRetryPlanExecuteStatusEnums.EXECUTE_FINISH.code);
					this.withdrawFailService.withdrawFailDealWith(reqId, plan.getExecuteRemitVoucherNo(), ReturnCodeEnums.FW_MERCHANT_WALLETBALACE_ISENOUGH.code);
					continue;
				}
				
				// 已经出款失败 更新为出款中
				if (WithdrawReqStatusEnums.FAIL.code.equals(reqDo.getStatus())) {
					int row=withdrawReqService.updateStatus(reqDo, WithdrawReqStatusEnums.FAIL.code, WithdrawReqStatusEnums.WAITTING.code);
					if(row<=0){
						logger.info("WithdrawRetryServiceImpl #executeRetryJob update req status is fail, plan:" + ToStringBuilder.reflectionToString(plan));
						this.updateDataStatus(plan.getPlanId(), WithdrawRetryPlanExecuteStatusEnums.EXECUTE_WAIT.code,
								WithdrawRetryPlanExecuteStatusEnums.EXECUTE_FINISH.code);
						continue;
					}else{
						
					}
				}
				// TODO 判断三个金额是否满足
				// 先锁额度 如果失败判断商户额度，代理商额度，出款总额度
				// 锁额度 实时出款锁额度
				if (reqDo.getWithdrawType() != null && WithdrawConstant.withdrawTypeRealTime.equals(reqDo.getWithdrawType().toString())) {
					ErrorMessageVO<Object> vo = checkWithdrawAmount(reqDo.getMerchantNo(), reqDo.getWithdrawAmount(), reqDo.getMcType(),
							String.valueOf(reqDo.getWithdrawType()));
					if (!vo.isSuccess()) {// 额度不满足要求
						this.updateDataStatus(plan.getPlanId(), null, WithdrawRetryPlanExecuteStatusEnums.EXECUTE_FINISH.code);
						this.withdrawFailService.withdrawFailDealWith(reqId, plan.getExecuteRemitVoucherNo(), vo.getErrorCode());
						logger.info("WithdrawRetryServiceImpl #executeRetryJob balance is not enough, PlanId:" + plan.getPlanId() + "MerchantNo:"
								+ reqDo.getMerchantNo() + " msg：" + vo.getErrorMessage());
						continue;
					}else{
						isFrozenQuota=true;
					}
				} else {// TODO 普通出款 处理未定
				}
				// TODO 更新执行计划为执行中
				int rows = this.updateDataStatus(plan.getPlanId(), WithdrawRetryPlanExecuteStatusEnums.EXECUTE_WAIT.code,
						WithdrawRetryPlanExecuteStatusEnums.EXECUTE_ING.code);
				if (rows == 0) {// 数据更新失败 乐观锁更新 防止数据重复重试
					logger.info("WithdrawRetryServiceImpl #executeRetryJob plan is enforced, plan:" + ToStringBuilder.reflectionToString(plan));
					limitationService.restoreFrozenQuota(reqDo.getMerchantNo(), reqDo.getMcType(), reqDo.getWithdrawAmount());
					isFrozenQuota=false;
					this.updateDataStatus(plan.getPlanId(), WithdrawRetryPlanExecuteStatusEnums.EXECUTE_ING.code,
							WithdrawRetryPlanExecuteStatusEnums.EXECUTE_FINISH.code);
					continue;
				}
				// 发起重试
				initiateRetry(plan, reqId, reqDo,isFrozenQuota);
			} catch (Exception e) {
                if(isFrozenQuota){
                	limitationService.restoreFrozenQuota(reqDo.getMerchantNo(), reqDo.getMcType(), reqDo.getWithdrawAmount());
                }
				this.updateDataStatus(plan.getPlanId(), null, WithdrawRetryPlanExecuteStatusEnums.EXECUTE_FINISH.code);
				this.withdrawFailService.withdrawFailDealWith(reqId, plan.getExecuteRemitVoucherNo(), ReturnCodeEnums.FW_CORE_DATA_ERROR.code);
				logger.error("WithdrawRetryServiceImpl executeRetryJob for plan Exception,plan:" +ToStringBuilder.reflectionToString(plan) , e);
			}
		}

	}

	private boolean isFosReqFail(WithdrawReqDO reqDo, WithdrawReqFosDetailDO detailDo) {
		WithdrawT0QueryResponseDTO responseDTO = withdrawT0ServiceQueryService.queryWithdrawInfo(detailDo.getRemitVoucherNo());
		String withdrawStatus = withdrawT0ServiceQueryService.dealwithFosWithdrawQueryResponse(responseDTO, reqDo, detailDo);
		// TODO 如果出款成功或出款中，更新请求的相关和上次调用的状态，如果出款失败或查询无数据，继续走重试流程
		Date applyDay = reqDo.getCreateTime();
		ErrorMessageVO<Object> vo = null;
		if (reqDo.getWithdrawType() != null && WithdrawConstant.withdrawTypeRealTime.equals(reqDo.getWithdrawType().toString())) {
			WithdrawRetryPlanDO planDO = queryRetryPlanInfoByReqIdAndRemitVoucherNo(detailDo.getReqId(), detailDo.getRemitVoucherNo());
			if (planDO != null && StringUtils.isBlank(planDO.getRetryRule()) && planDO.getExecuteTime() != null) {// 手动重试的，判断额度按照当前的任务执行的时间
				applyDay = planDO.getExecuteTime();
			}
			vo = limitationService.isQuotoShare(reqDo.getMerchantNo(), reqDo.getMcType(), applyDay, new Date());
		}
		if (WithdrawOrderStatusEnums.SUCCESS.code.equals(withdrawStatus)) {
			// 将额度修改已经使用
			if (vo != null && vo.isSuccess()) {
				this.limitationService.usefrozenQuotaByIsQuotoShare(reqDo.getMerchantNo(), reqDo.getMcType(), reqDo.getWithdrawAmount(), applyDay);
			}
			return false;
		} else if (WithdrawOrderStatusEnums.WAITTING.code.equals(withdrawStatus)) {// 处理中
			return false;
		} else {// 如果失败，进入出款重试

		}
		return true;
	}

	// 发起重试
	private void initiateRetry(WithdrawRetryPlanDO plan, Long reqId, WithdrawReqDO reqDo, boolean isFrozenQuota) {
		WithdrawCoreServiceDTO serviceDTO = new WithdrawCoreServiceDTO();
		// TODO 查询出款到卡的信息
		ErrorMessageVO<Object> messageVo = withdrawT0ServiceService.bulidCoreData(reqDo, serviceDTO);
		if (messageVo.isSuccess()) {
			// TODO 构件调用核心出款服务的数据，添加到服务调用的MQ中
			if (StringUtils.notBlank(serviceDTO.getRemitVoucherNo())) {
				serviceDTO.setRemitVoucherNo(plan.getExecuteRemitVoucherNo());
				if (!this.withdrawCallQueueService.addCallWithdrawCoreServiceDate(serviceDTO)) {// 如果添加MA失败，走失败处理流程
					limitationService.restoreFrozenQuota(reqDo.getMerchantNo(), reqDo.getMcType(), reqDo.getWithdrawAmount());
					isFrozenQuota=false;
					this.withdrawFailService.withdrawFailDealWith(serviceDTO,
							ReturnCodeEnums.FW_CALL_CORE_WITHDRAW_EXCEPTION.code);
				}
				;
				this.updateDataStatus(plan.getPlanId(), WithdrawRetryPlanExecuteStatusEnums.EXECUTE_ING.code,
						WithdrawRetryPlanExecuteStatusEnums.EXECUTE_FINISH.code);
				logger.error("WithdrawRetryServiceImpl executeRetryJob addCallWithdrawCoreServiceDate success");
			} else {// 如果请求核心数据队列为空
				logger.error("WithdrawRetryServiceImpl executeRetryJob addCallWithdrawCoreServiceDate error data is null");
				limitationService.restoreFrozenQuota(reqDo.getMerchantNo(), reqDo.getMcType(), reqDo.getWithdrawAmount());
				isFrozenQuota=false;
				this.updateDataStatus(plan.getPlanId(), null, WithdrawRetryPlanExecuteStatusEnums.EXECUTE_FINISH.code);
				this.withdrawFailService.withdrawFailDealWith(serviceDTO, ReturnCodeEnums.FW_FOS_DATA_FAILS.code);
			}
		} else {
			this.updateDataStatus(plan.getPlanId(), null, WithdrawRetryPlanExecuteStatusEnums.EXECUTE_FINISH.code);
			limitationService.restoreFrozenQuota(reqDo.getMerchantNo(), reqDo.getMcType(), reqDo.getWithdrawAmount());
			isFrozenQuota=false;
			this.withdrawFailService.withdrawFailDealWith(serviceDTO, messageVo.getErrorCode(),messageVo.getErrorMessage());
		}
	}

	@Transactional
	public ErrorMessageVO<Object> retryWithdraw(Long reqId, String remitVoucherNo) {
		WithdrawReqDO reqDo = withdrawReqManager.selectByPrimaryKey(reqId);
		return dealwithRetryWithdraw(reqDo, remitVoucherNo);

	}

	private ErrorMessageVO<Object> dealwithRetryWithdraw(WithdrawReqDO reqDo, String remitVoucherNo) {
		try {
			Integer retryTimes = 0;
			if (reqDo != null) {
				// 是否在服务发起时间
				if (reqDo.getWithdrawType() != null && WithdrawConstant.withdrawTypeRealTime.equals(reqDo.getWithdrawType().toString())) {
					ErrorMessageVO<Object> vo = timeFrame(new Date(), reqDo.getMerchantNo(), reqDo.getMcType());
					if (!vo.isSuccess()) { return new ErrorMessageVO<Object>(false, "-1", vo.getErrorMessage()); }
				}
				retryTimes = (reqDo.getRetryTimes() != null ? reqDo.getRetryTimes() : 0) + 1;
				Integer relult = withdrawReqService.updateWithdrawReq(reqDo.getReqId(), WithdrawReqStatusEnums.WAITTING.code, retryTimes);
				if (relult == 1) {
					reqDo = withdrawReqManager.selectByPrimaryKey(reqDo.getReqId());
					List<WithdrawRetryPlanDO> retryPlanList = queryNonexecutionRetryPlanByReqId(reqDo.getReqId());
					if (retryPlanList == null || retryPlanList.isEmpty()) {// 没有待执行
																			// 的重试任务，形成重试计划
						buildHandRetryPlan(reqDo, remitVoucherNo);
					}
				} else {
					return new ErrorMessageVO<Object>(false, "-1", "更新状态失败");
				}
			} else {
				return new ErrorMessageVO<Object>(false, "-1", "订单不存在");
			}
		} catch (Exception e) {
			logger.error("WithdrawRetryServiceImpl .retryWithdraw.error:" + e);
			return new ErrorMessageVO<Object>(false, "-1", "系统繁忙，请稍后再试");
		}
		return new ErrorMessageVO<Object>(true, "1", "重试成功");
	}

	@Override
	public WithdrawRetryPlanDO queryRetryPlanInfoByReqIdAndRemitVoucherNo(Long reqId, String remitVoucherNo) {
		WithdrawRetryPlanDOExample example = new WithdrawRetryPlanDOExample();
		example.setReqId(reqId);
		example.setExecuteRemitVoucherNo(remitVoucherNo);
		example.createCriteria().andExecuteStartTimeLessThan(new Date());
		example.createCriteria().andExecuteStatusNotEqualTo(WithdrawRetryPlanExecuteStatusEnums.EXECUTE_FINISH.code);
		example.setOrderByClause("EXECUTE_START_TIME DESC");
		List<WithdrawRetryPlanDO> list = this.withdrawRetryPlanManager.selectByQuery(example);
		if (list != null && !list.isEmpty()) { return list.get(0); }
		return null;
	}

	@Override
	@Transactional
	public ErrorMessageVO<Object> retryWithdraw(Long reqId, String remitVoucherNo, String operator, String operatorId) throws Exception {
		WithdrawReqDO reqDo = withdrawReqManager.selectByPrimaryKey(reqId);
		ErrorMessageVO<Object> vo = dealwithRetryWithdraw(reqDo, remitVoucherNo);
		if (vo.isSuccess()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("withdrawReq", reqDo);
			map.put("operator", operator);
			map.put("operatorId", operatorId);
			boolean flag = this.opLogRecordService.createOpLogRecord(map, LogRecordTypeEnums.WITHDRAW_RETRY_OP.code, LogOPTypeEnums.CREATE.code);
			if (!flag) { throw new Exception("createOpLogRecord Exception"); }
		}
		return vo;
	}

}
