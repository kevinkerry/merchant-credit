package com.sdp.withdraw.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.dto.StatisticsWithdrawInfoDTO;
import com.sdp.mc.common.enums.withdraw.WithdrawReqStatusEnums;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqDOExample;
import com.sdp.withdraw.dao.WithdrawReqDOExample.Criteria;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDO;
import com.sdp.withdraw.enums.ReturnCodeEnums;
import com.sdp.withdraw.manager.WithdrawReqManager;
import com.sdp.withdraw.manager.ext.ExtWithdrawReqManager;
import com.sdp.withdraw.service.BaseService;
import com.sdp.withdraw.service.WithdrawReqFosDetailService;
import com.sdp.withdraw.service.WithdrawReqService;
import com.sdp.withdraw.service.WithdrawRetryService;
import com.sdp.withdraw.vo.WithdrawResult;
import com.sdp.withdraw.worker.WithdrawServiceCallbackHandler;

@Service("WithdrawReqService")
public class WithdrawReqServiceImpl extends BaseService implements WithdrawReqService {
	private Logger logger = LoggerFactory.getLogger(WithdrawReqServiceImpl.class);
	@Autowired
	private WithdrawReqManager withdrawReqManager;

	@Autowired
	private ExtWithdrawReqManager extWithdrawReqManager;

	@Autowired
	private WithdrawServiceCallbackHandler withdrawServiceCallbackHandler;

	@Autowired
	private WithdrawRetryService withdrawRetryService;

	@Autowired
	private WithdrawReqFosDetailService withdrawReqFosDetailService;

	@Override
	public WithdrawReqDO queryWithdrawReqByReqId(Long reqId) {
		return withdrawReqManager.selectByPrimaryKey(reqId);
	}

	@Override
	public WithdrawReqDO insertWithdrawReq(WithdrawReqDO withdrawReqDO) throws Exception {

		withdrawReqDO.setStatus(WithdrawReqStatusEnums.INIT.code);// 状态初始
		withdrawReqDO.setApplyTime(withdrawReqDO.getApplyTime()==null?new Date():withdrawReqDO.getApplyTime());

		// 计算出款手续费
		BigDecimal calculatePoundage = withdrawFee(withdrawReqDO.getWithdrawAmount(), withdrawReqDO.getWithdrawFee());
		if(calculatePoundage!=null&&calculatePoundage.compareTo(BigDecimal.ZERO)>0&&calculatePoundage.compareTo(new BigDecimal(0.01))<0){
			calculatePoundage=new BigDecimal(0.01);
		}
		// 分润费率
		BigDecimal splittingRate = splittingRate(withdrawReqDO.getMerchantNo());
		// 分润金额
		BigDecimal calculateSplittingFee = calculateSplittingFee(WithdrawConstant.reqTypePOS==withdrawReqDO.getReqType()?
				withdrawReqDO.getOriginalAmount():withdrawReqDO.getWithdrawAmount(), splittingRate);
		withdrawReqDO.setWithdrawFee(withdrawReqDO.getWithdrawFee().setScale(4,  BigDecimal.ROUND_HALF_UP));
		withdrawReqDO.setWithdrawCost(calculatePoundage.setScale(2,BigDecimal.ROUND_HALF_UP));
		withdrawReqDO.setSplittingFee(splittingRate);
		withdrawReqDO.setSplittingFee(calculateSplittingFee);
		withdrawReqDO.setRetryTimes(0);
		withdrawReqDO.setCreateTime(new Date());
		withdrawReqManager.insert(withdrawReqDO);
		return withdrawReqDO;
	}

	@Override
	public List<WithdrawReqDO> queryWithdrawByOrderNoAndAppID(Map<String, Object> paramMap) {
		WithdrawReqDOExample example = new WithdrawReqDOExample();
		Criteria criteria = example.createCriteria();
		if (paramMap.containsKey("appid") && StringUtils.isNotBlank(paramMap.get("appid").toString()))
			criteria.andAppIdEqualTo(paramMap.get("appid").toString());
		if (paramMap.containsKey("orderNo") && StringUtils.isNotBlank(paramMap.get("orderNo").toString()))
			criteria.andOrderNoEqualTo(paramMap.get("orderNo").toString());
		if (paramMap.containsKey("withdrawType") && StringUtils.isNotBlank(paramMap.get("withdrawType").toString()))
			criteria.andWithdrawTypeEqualTo(Integer.valueOf(paramMap.get("withdrawType").toString()));
		List<WithdrawReqDO> list = withdrawReqManager.selectByExample(example);
		if (list.size() > 0)
			return list;
		else return null;
	}

	@Override
	public int updateDataMessage(WithdrawReqDO reqdo, ErrorMessageVO<Object> vo) {
		try {
			reqdo.setErrorCode(vo.getErrorCode());
			reqdo.setErrorMsg(vo.getErrorMessage());
			reqdo.setUpdateTime(new Date());
			int resultSum = withdrawReqManager.updateByPrimaryKeySelective(reqdo);
			logger.info("WithdrawReqServiceImpl#updateData resultSum:" + resultSum + "reqdo" + ToStringBuilder.reflectionToString(reqdo));
			return resultSum;
		} catch (Exception e) {
			logger.error("WithdrawReqServiceImpl#updateData is error " + e.getMessage(), e);
			return 0;
		}

	}
	@Override
	public int updateDataStatusFail(long reqId, String errorCode,String errorMessage) {
		try {
			WithdrawReqDOExample example = new WithdrawReqDOExample();
			Criteria criteria = example.createCriteria();
			criteria.andReqIdEqualTo(reqId).andStatusEqualTo(WithdrawReqStatusEnums.WAITTING.code);
			WithdrawReqDO reqdo=new WithdrawReqDO();
			reqdo.setReqId(reqId);
			reqdo.setStatus(WithdrawReqStatusEnums.FAIL.code);
			reqdo.setErrorCode(errorCode);
			reqdo.setErrorMsg(errorMessage);
			reqdo.setUpdateTime(new Date());
			int resultSum = this.extWithdrawReqManager.updateByExampleSelective(reqdo, example);
			logger.info("WithdrawReqServiceImpl#updateData resultSum:" + resultSum + "reqdo" + ToStringBuilder.reflectionToString(reqdo));
			return resultSum;
		} catch (Exception e) {
			logger.error("WithdrawReqServiceImpl#updateData is error " + e.getMessage(), e);
			return 0;
		}
		
	}

	@Override
	public void updateData(WithdrawReqDO reqDo) {
		this.withdrawReqManager.updateByPrimaryKey(reqDo);
	}

	@Override
	public void initiateCallback(WithdrawReqDO reqDo, String remitVoucherNo) {
		if (reqDo.getCallbackAddress() != null) {
			// 如果规则不在发起重试，判断是否有回掉地址，如果有回掉地址，发起回调
			this.withdrawServiceCallbackHandler.execute(reqDo.getReqId(), remitVoucherNo);
		}

	}

	@Override
	public void initiateCallback(Long reqId, String remitVoucherNo) {
		WithdrawReqDO reqDo = queryWithdrawReqByReqId(reqId);
		initiateCallback(reqDo, remitVoucherNo);
	}

	@Override
	public List<WithdrawReqDO> selectByExample(WithdrawReqDOExample example) {
		// TODO Auto-generated method stub
		return withdrawReqManager.selectByExample(example);
	}

	@Override
	public int updateByExample(WithdrawReqDO record, WithdrawReqDOExample example) {
		// TODO Auto-generated method stub
		return extWithdrawReqManager.updateByExample(record, example);
	}

	/**
	 * 后台重试放款更新状态，暂不考虑并发问题
	 */
	public int updateWithdrawReq(Long reqId, Integer status, Integer retryTimes) throws Exception {
		logger.info("WithdrawReqServiceImpl#updateWithdrawReq reqId:" + reqId + ";status:" + status + ";retryTimes:" + retryTimes);
		WithdrawReqDO reqdo = new WithdrawReqDO();
		reqdo.setReqId(reqId);
		reqdo.setStatus(status);
		reqdo.setRetryTimes(retryTimes);
		reqdo.setUpdateTime(new Date());
		return withdrawReqManager.updateByPrimaryKeySelective(reqdo);
	}

	@Override
	public WithdrawResult getWithdrawResult(WithdrawReqDO reqDo, WithdrawReqFosDetailDO detailDo) {
		WithdrawResult result=new WithdrawResult();
		beanMapper.map(detailDo, result);
		beanMapper.map(reqDo, result);
		return result;
	}

	@Override
	public void updateStatusWithdrawing(WithdrawReqDO withdrawReqDO) {
		withdrawReqDO.setStatus(WithdrawReqStatusEnums.WAITTING.code);
		withdrawReqDO.setErrorCode(ReturnCodeEnums.FW_MC_T0_ING.code);
		withdrawReqDO.setErrorMsg(ReturnCodeEnums.FW_MC_T0_ING.msg);
		withdrawReqDO.setUpdateTime(new Date());
		withdrawReqManager.updateByPrimaryKeySelective(withdrawReqDO);
	}

	@Override
	public ErrorMessageVO<Object> dealwithExistsWithdraw(WithdrawReqDO reqDo) {
		ErrorMessageVO<Object> vo = new ErrorMessageVO<Object>(true, reqDo.getErrorCode(), reqDo.getErrorMsg());
		// 根据状态更新
		/**
		 * 查询之前出款状态，出款成功，更新状态，返回出款成功； 出款失败或者查询不到数据，更新重试次数加1，状态为处理中,
		 * 形成重试计划数据，执行时间为当前时间，
		 */
		if (WithdrawReqStatusEnums.SUCCESS.code.equals(reqDo.getStatus())||WithdrawReqStatusEnums.WAITTING.code.equals(reqDo.getStatus())) {
			// 返回出款成功 // 出款中
			return vo;
		} else if (WithdrawReqStatusEnums.FAIL.code.equals(reqDo.getStatus())) {
			// 出款失败，发起重试
			WithdrawReqFosDetailDO detailDo=withdrawReqFosDetailService.queryLastDetailByReqId(reqDo.getReqId());
			withdrawRetryService.retryWithdraw(reqDo.getReqId(), detailDo!=null?detailDo.getRemitVoucherNo():"");
			vo = new ErrorMessageVO<Object>(true, ReturnCodeEnums.FW_MC_T0_ING.code, ReturnCodeEnums.FW_MC_T0_ING.msg);
			return vo;
		}else{
//			return vo;
			//既不是成功，也不是失败返回之前发起的异常信息
			return new ErrorMessageVO<Object>(true, ReturnCodeEnums.FW_MC_T0_ING.code, ReturnCodeEnums.FW_MC_T0_ING.msg);
		}

	}

	@Override
	public int updateStatus(WithdrawReqDO reqDo, Integer sourceStatus, Integer targetStatus) {
		WithdrawReqDO record=new WithdrawReqDO();
		record.setStatus(targetStatus);
		WithdrawReqDOExample example=new WithdrawReqDOExample();
		example.createCriteria().andReqIdEqualTo(reqDo.getReqId()).andStatusEqualTo(sourceStatus);
		return extWithdrawReqManager.updateByExampleSelective(record, example);
	}

	@Override
	public Integer updateByPrimaryKeySelective(WithdrawReqDO reqDo) {
		return withdrawReqManager.updateByPrimaryKeySelective(reqDo);
	}

	@Override
	public StatisticsWithdrawInfoDTO statisticsPromoterMerchantWithdrawInfo(Long promoterId) {
		// TODO Auto-generated method stub
		return extWithdrawReqManager.statisticsPromoterMerchantWithdrawInfo(promoterId);
	}
	@Override
	public List<StatisticsWithdrawInfoDTO> statisticsPromoterWithdrawInfo(Long promoterId) {
		// TODO Auto-generated method stub
		return extWithdrawReqManager.statisticsPromoterWithdrawInfo(promoterId);
	}
	@Override
	public List<StatisticsWithdrawInfoDTO> statisticsMerchantWithdrawInfo(Long merchantBizId) {
		// TODO Auto-generated method stub
		return extWithdrawReqManager.statisticsMerchantWithdrawInfo(merchantBizId);
	}

	@Override
	public List<WithdrawReqDO> queryStatusDisagreeInfo() {
		// TODO Auto-generated method stub
		return extWithdrawReqManager.queryStatusDisagreeInfo();
	}

	@Override
	public int updateReqLastDetailId(Long reqId, Long lastDetailId) {
		WithdrawReqDO record=new WithdrawReqDO();
		record.setReqId(reqId);
		record.setLastDetailId(lastDetailId);
		record.setUpdateTime(new Date());
		return withdrawReqManager.updateByPrimaryKeySelective(record);
	}
}
