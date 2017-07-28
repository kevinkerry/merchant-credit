package com.sdp.withdraw.service.impl;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdp.mc.common.bean.RetryRulePO;
import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.dto.WithdrawCoreServiceDTO;
import com.sdp.mc.common.dto.WithdrawFailRetryRuleDTO;
import com.sdp.mc.common.enums.withdraw.WithdrawReqStatusEnums;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDO;
import com.sdp.withdraw.dao.WithdrawRetryPlanDO;
import com.sdp.withdraw.enums.ReturnCodeEnums;
import com.sdp.withdraw.rule.WithdrawFailRetryRuleUtils;
import com.sdp.withdraw.service.WithDrawBaseService;
import com.sdp.withdraw.service.WithdrawFailService;
import com.sdp.withdraw.service.WithdrawReqFosDetailService;
import com.sdp.withdraw.service.WithdrawReqService;
import com.sdp.withdraw.service.WithdrawRetryService;
import com.sdp.withdraw.worker.WithdrawServiceCallbackHandler;

@Service("WithdrawFailService")
public class WithdrawFailServiceImpl extends WithDrawBaseService implements WithdrawFailService {
	private Logger logger = LoggerFactory.getLogger(WithdrawFailServiceImpl.class);

	@Autowired
	private WithdrawServiceCallbackHandler withdrawServiceCallbackHandler = null;

	@Autowired
	private WithdrawRetryService withdrawRetryService = null;
	@Autowired
	private WithdrawReqService withdrawReqService = null;
	@Autowired
	private WithdrawReqFosDetailService withdrawReqFosDetailService = null;

	@Override
	@Transactional
	public void withdrawFailDealWith(WithdrawCoreServiceDTO serviceDTO, String errorCode) {
		
		this.withdrawFailDealWith(serviceDTO, errorCode,ReturnCodeEnums.getEnumsByCode(errorCode)==null?"":ReturnCodeEnums.getEnumsByCode(errorCode).msg);

	}
	@Override
	@Transactional
	public void withdrawFailDealWith(WithdrawCoreServiceDTO serviceDTO, String errorCode, String errorMessage){
		logger.info(String.format("WithdrawFailServiceImpl #withdrawFailDealWith: serviceDTO:%s,errorCode: %s,errorMessage: %s",
				ToStringBuilder.reflectionToString(serviceDTO), errorCode,errorMessage));
		Long reqId = serviceDTO.getReqId();
		String remitVoucherNo = serviceDTO.getRemitVoucherNo();
		Integer reqStatus = withdrawFailDealWith(reqId, remitVoucherNo, errorCode,errorMessage);
		if (reqId != null && reqStatus != null && WithdrawReqStatusEnums.FAIL.code .equals(reqStatus)) {
			WithdrawReqFosDetailDO detail = withdrawReqFosDetailService.queryLastDetailByReqId(reqId);
			if (detail == null) {
				serviceDTO.setReturnCode(errorCode);
				serviceDTO.setReturnMsg(errorMessage);
				withdrawReqFosDetailService.createWithdrawFailDetail(serviceDTO);
				//TODO 暂时资管拦截的失败不再记录最后请求fos的记录
				//withdrawReqService.updateReqLastDetailId(reqId, serviceDTO.getDetailId());
			}
		}
		
	}

	@Override
	@Transactional
	public Integer withdrawFailDealWith(Long reqId, String remitVoucherNo, String errorCode) {
		return withdrawFailDealWith(reqId, remitVoucherNo, errorCode,ReturnCodeEnums.getEnumsByCode(errorCode)==null?"":ReturnCodeEnums.getEnumsByCode(errorCode).msg);

	}
	@Override
	@Transactional
	public Integer withdrawFailDealWith(Long reqId, String remitVoucherNo, String errorCode,String errorMessage) {
		logger.info(String.format("WithdrawFailServiceImpl #withdrawFailDealWith: reqID:%d,remitVoucherNo: %s,errorCode: %s,errorMessage: %s", reqId, remitVoucherNo,
				errorCode,errorMessage));
		// 查询请求的重试计划
		List<WithdrawRetryPlanDO> retryPlanList = withdrawRetryService.queryNonexecutionRetryPlanByReqId(reqId);
		if (retryPlanList == null || retryPlanList.isEmpty()) {
			// 如果没有待执行和执行中的重试任务，查询出款出款失败的 重试规则
			WithdrawReqDO reqDo = withdrawReqService.queryWithdrawReqByReqId(reqId);
			if (reqDo == null) { return null; }
			WithdrawFailRetryRuleDTO retryRule = queryWithdrawFailRetryRule(errorCode, reqDo.getRetryTimes(), reqDo.getWithdrawType().toString(),
					reqDo.getMerchantNo(), reqDo.getMcType());
			if (retryRule != null && retryRule.isRetry()) {
				// 如果规则需要发起重试 更新请求数据 的重试次数，最好更新时间，出款状态为：出款中
				reqDo.setStatus(WithdrawReqStatusEnums.WAITTING.code);
				reqDo.setRetryTimes((reqDo.getRetryTimes() == null ? 0 : reqDo.getRetryTimes()) + 1);
				updateWithdrawReq(reqDo);
				// 形成重试计划的数据
				withdrawRetryService.buildWithdrawFailRetryPlan(reqDo, remitVoucherNo, retryRule);
				return reqDo.getStatus();
			} else {
				reqDo.setStatus(WithdrawReqStatusEnums.FAIL.code);
				reqDo.setErrorCode(errorCode);
				reqDo.setErrorMsg(errorMessage);
				updateWithdrawReq(reqDo);
				withdrawReqService.initiateCallback(reqDo, remitVoucherNo);
				logger.info(String.format("WithdrawFailServiceImpl #withdrawFailDealWith: reqID:%d,remitVoucherNo: %s,errorCode: %s, not RetryPlan",
						reqId, remitVoucherNo, errorCode));
				return reqDo.getStatus();
			}
			
		} else {
			logger.info(String.format(
					"WithdrawFailServiceImpl #withdrawFailDealWith: reqID:%d,remitVoucherNo: %s,errorCode: %s, exists NonexecutionRetryPlan", reqId,
					remitVoucherNo, errorCode));
		}
		return null;
		// 有未完成的重试计划，状态暂不处理
		
	}

	@Override
	public WithdrawFailRetryRuleDTO queryWithdrawFailRetryRule(String errorCode, Integer retryTimes, String withdrawType, String merchantNo,
			String mcType) {
		Date executeDate = WithdrawFailRetryRuleUtils.getRetryDate(errorCode, retryTimes == null ? 0 : retryTimes);
		if (executeDate != null) {
			ErrorMessageVO<Object> vo = null;
			if (withdrawType != null && WithdrawConstant.withdrawTypeRealTime.equals(withdrawType)) {
				vo = timeFrame(executeDate, merchantNo, mcType);
			}
			if (vo == null || vo.isSuccess()) {
				RetryRulePO po = WithdrawFailRetryRuleUtils.getRetryRule(errorCode);
				String jsonPo = JSONObject.fromObject(po).toString();
				WithdrawFailRetryRuleDTO dto = new WithdrawFailRetryRuleDTO(po.getErrorCode(), po.getDescription(), jsonPo, executeDate, true);
				return dto;
			}
		}
		return null;
	}

	private void updateWithdrawReq(WithdrawReqDO reqDo) {
		reqDo.setUpdateTime(new Date());
		withdrawReqService.updateData(reqDo);

	}

}
