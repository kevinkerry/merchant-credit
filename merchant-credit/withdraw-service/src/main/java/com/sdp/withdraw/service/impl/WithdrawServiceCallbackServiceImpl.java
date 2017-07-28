package com.sdp.withdraw.service.impl;

import java.util.Date;

import net.sf.json.JSONObject;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.enums.withdraw.WithdrawOrderStatusEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawReqStatusEnums;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.integration.fos.dto.response.OrderResults;
import com.sdp.mc.integration.fos.dto.response.WithdrawBackOrderStatusDTO;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDO;
import com.sdp.withdraw.dao.WithdrawRetryPlanDO;
import com.sdp.withdraw.enums.ReturnCodeEnums;
import com.sdp.withdraw.service.LimitationService;
import com.sdp.withdraw.service.WithdrawFailService;
import com.sdp.withdraw.service.WithdrawReqFosDetailService;
import com.sdp.withdraw.service.WithdrawReqService;
import com.sdp.withdraw.service.WithdrawRetryService;
import com.sdp.withdraw.service.WithdrawServiceCallbackService;
import com.sdp.withdraw.service.splitting.WithdrawSplittingSerivce;
import com.shengpay.commons.core.utils.StringUtils;

@Service("WithdrawServiceCallbackService")
public class WithdrawServiceCallbackServiceImpl implements WithdrawServiceCallbackService {
	private Logger logger = LoggerFactory.getLogger(WithdrawServiceCallbackServiceImpl.class);

	@Autowired
	private LimitationService limitationService;
	@Autowired
	private WithdrawReqFosDetailService withdrawReqFosDetailService;
	@Autowired
	private WithdrawReqService withdrawReqService;
	@Autowired
	private WithdrawFailService withdrawFailService;
	@Autowired
	private WithdrawRetryService withdrawRetryService;
	
	@Autowired
	private WithdrawSplittingSerivce withdrawSplittingSerivce;
    
	@Override
	//@Transactional
	public void dealwithFosCallBack(WithdrawBackOrderStatusDTO responseDto) {
		logger.info("#dealwithFosCallBack,responseDto:" + ToStringBuilder.reflectionToString(responseDto));
		if(responseDto==null||responseDto.getOrderResults()==null||responseDto.getOrderResults().isEmpty()){
			logger.info("#dealwithFosCallBack,responseDto is null");
			return;
		}
		OrderResults orderResult = responseDto.getOrderResults().get(0);
		logger.info("#dealwithFosCallBack,orderResult:" + ToStringBuilder.reflectionToString(orderResult));
		String remitVoucherNo = orderResult.getRemitVoucherNo();
		String returnCode = orderResult.getReturnCode();
		String returnMessage = orderResult.getReturnMsg();
//		String returnCode = "05057";
//		String returnMessage = "交易不存在";
		if (StringUtils.isBlank(returnCode) || StringUtils.isBlank(remitVoucherNo)) {
			logger.error("#dealwithFosCallBack response param validate is error~~");
			return;
		}

		// TODO 1、根据单号查询订单状态
		WithdrawReqFosDetailDO withdrawReqFosDetail = withdrawReqFosDetailService.queryWithdrawReqFosDetailByRemitVoucherNo(remitVoucherNo);
		//
		if (withdrawReqFosDetail == null) {
			logger.info("#dealwithFosCallBack remitVoucherNo [" + remitVoucherNo + "] not exsit~~");
			return;
		}
		if (WithdrawOrderStatusEnums.INIT.code.equals(withdrawReqFosDetail.getWithdrawStatus())||WithdrawOrderStatusEnums.SUCCESS.code.equals(withdrawReqFosDetail.getWithdrawStatus())) {
			logger.info("#dealwithFosCallBack remitVoucherNo:{} Detail status:{}",new Object[]{remitVoucherNo,withdrawReqFosDetail.getWithdrawStatus()});
			return;
		}
		if (WithdrawOrderStatusEnums.FAIL.code.equals(withdrawReqFosDetail.getWithdrawStatus())&&!ReturnCodeEnums.FW_SUCCESS.code.equals(returnCode)) {
			logger.info("#dealwithFosCallBack remitVoucherNo:{} detailWithdrawStatus is :{}  ,returnCode:{}",new Object[]{remitVoucherNo,withdrawReqFosDetail.getWithdrawStatus(),returnCode});
			return;
		}
		Long reqId = withdrawReqFosDetail.getReqId();
		// 根据reqId查询POS请求记录
		WithdrawReqDO withdrawReqDO = withdrawReqService.queryWithdrawReqByReqId(reqId);
		if (withdrawReqDO == null) {
			logger.info("#dealwithFosCallBack query request recored by reqID " + reqId + " result is null");
			return;
		}
		if (WithdrawReqStatusEnums.INIT.code.equals(withdrawReqDO.getStatus())||WithdrawReqStatusEnums.SUCCESS.code.equals(withdrawReqDO.getStatus())) {
			logger.info("#dealwithFosCallBack reqId{" + reqId + "} status  is " + withdrawReqDO.getStatus());
			return;
		}
		if (WithdrawReqStatusEnums.FAIL.code.equals(withdrawReqDO.getStatus())&&!ReturnCodeEnums.FW_SUCCESS.code.equals(returnCode)) {
			logger.info("#dealwithFosCallBack reqId:{} withdrawReq status is :{}  ,returnCode:{}",new Object[]{reqId,withdrawReqDO.getStatus(),returnCode});
			return;
		}
		

		// 判断额度是否共享
		Date applyDay = withdrawReqDO.getCreateTime();
		ErrorMessageVO<Object> quotaShareMessage = null;
		if (withdrawReqDO.getWithdrawType() != null && WithdrawConstant.withdrawTypeRealTime.equals(withdrawReqDO.getWithdrawType().toString())) {
			WithdrawRetryPlanDO planDO = withdrawRetryService.queryRetryPlanInfoByReqIdAndRemitVoucherNo(reqId, remitVoucherNo);
			if (planDO != null && StringUtils.isBlank(planDO.getRetryRule()) && planDO.getExecuteTime() != null) {// 手动重试的，判断额度按照当前的任务执行的时间
				applyDay = planDO.getExecuteTime();
			}
			quotaShareMessage = limitationService.isQuotoShare(withdrawReqDO.getMerchantNo(), withdrawReqDO.getMcType(), applyDay, new Date());
		}
		String orderRseultStr = JSONObject.fromObject(orderResult).toString();
		if (ReturnCodeEnums.FW_SUCCESS.code.equals(returnCode)) {// 出款成功
			// 额度是否共享
			if (quotaShareMessage != null && quotaShareMessage.isSuccess()) {
				limitationService.usefrozenQuotaByIsQuotoShare(withdrawReqDO.getMerchantNo(), withdrawReqDO.getMcType(),
						withdrawReqDO.getWithdrawAmount(), applyDay);
			}
			// TODO 更新
			withdrawReqFosDetailService.updateReqAndOrderDetailInfoByWithdrawSuccess(withdrawReqFosDetail, withdrawReqDO, orderRseultStr);
			withdrawSplittingSerivce.computeWithdrawSplitting(withdrawReqDO);
			this.withdrawReqService.initiateCallback(withdrawReqDO, remitVoucherNo);
			logger.info("#dealwithFosCallBack remitVoucherNo [" + remitVoucherNo + "] success ");
		} else {// 出款失败
			withdrawReqFosDetailService.updateDataForWaiting(withdrawReqFosDetail.getDetailId(), returnCode, orderResult.getReturnMsg(),
					WithdrawOrderStatusEnums.FAIL.code, orderRseultStr);
			if (quotaShareMessage != null && quotaShareMessage.isSuccess()) {
				limitationService.restoreFrozenQuotaByIsQuotoShare(withdrawReqDO.getMerchantNo(), withdrawReqDO.getMcType(),
						withdrawReqDO.getWithdrawAmount(), applyDay);
			}
			this.withdrawFailService.withdrawFailDealWith(reqId, remitVoucherNo, returnCode, returnMessage);
			logger.info("#dealwithFosCallBack  remitVoucherNo [" + remitVoucherNo + "] fail, response:"
					+ ToStringBuilder.reflectionToString(responseDto));

		}

	}
}
