package com.sdp.withdraw.service.impl;

import java.util.Date;

import net.sf.json.JSONObject;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.FosPaymentStateEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawOrderStatusEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawReqStatusEnums;
import com.sdp.mc.integration.fos.dto.request.WithdrawT0QueryRequestDTO;
import com.sdp.mc.integration.fos.dto.response.WithdrawT0QueryResponseDTO;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDO;
import com.sdp.withdraw.enums.ReturnCodeEnums;
import com.sdp.withdraw.service.BaseService;
import com.sdp.withdraw.service.WithdrawReqFosDetailService;
import com.sdp.withdraw.service.WithdrawReqService;
import com.sdp.withdraw.service.WithdrawT0ServiceQueryService;
import com.sdp.withdraw.service.splitting.WithdrawSplittingSerivce;
import com.shengpay.commons.core.utils.StringUtils;
import com.shengpay.facade.fos.FOSFacade;

@Service("WithdrawT0ServiceQueryService")
public class WithdrawT0ServiceQueryServiceImpl extends BaseService implements WithdrawT0ServiceQueryService {
	private Logger logger = LoggerFactory.getLogger(WithdrawT0ServiceQueryServiceImpl.class);

	@Autowired
	private FOSFacade fosFacade = null;
	@Autowired
	private WithdrawReqService withdrawReqService = null;
	@Autowired
	private WithdrawReqFosDetailService withdrawReqFosDetailService = null;
	@Autowired
	private WithdrawSplittingSerivce withdrawSplittingSerivce = null;

	@Override
	public WithdrawT0QueryResponseDTO queryWithdrawInfo(String remitVoucherNo) {
		WithdrawReqFosDetailDO detail = withdrawReqFosDetailService.queryWithdrawReqFosDetailByRemitVoucherNo(remitVoucherNo);
		return queryWithdrawInfo(detail);
	}

	@Override
	public WithdrawT0QueryResponseDTO queryWithdrawInfo(WithdrawReqFosDetailDO detail) {
		if (detail != null && StringUtils.notBlank(detail.getRemitVoucherNo())) {
			WithdrawT0QueryRequestDTO request = new WithdrawT0QueryRequestDTO();
			request.setRemitVoucherNo(detail.getRemitVoucherNo());
			request.setPaymentCode(detail.getPaymentCode());
			request.setProductCode(detail.getProductCode());
			request.setSourceCode(getAppId());
			return fosFacade.withdrawQuery(request);
		} else {
			logger.info("WithdrawT0ServiceQueryServiceImpl #queryWithdrawInfo detail is null");
		}
		return null;
	}

	@Override
	public String dealwithFosWithdrawQueryResponse(WithdrawT0QueryResponseDTO responseDTO, WithdrawReqDO withdrawReqDO,
			WithdrawReqFosDetailDO detailDo) {
		if (responseDTO != null&&detailDo!=null) {
			logger.info("WithdrawT0ServiceQueryServiceImpl #dealwithFosWithdrawQueryResponse responseDTO:"
					+ ToStringBuilder.reflectionToString(responseDTO));
			// TODO 如果出款成功或出款中，更新请求的相关和上次调用的状态，如果出款失败或查询无数据，继续走重试流程
			if (responseDTO.getPaymentResult() != null
					&& FosPaymentStateEnums.S.code.equalsIgnoreCase(responseDTO.getPaymentResult().getPaymentState())) {
				// 如果出款成功
				updateWithdrawStatus(withdrawReqDO, WithdrawReqStatusEnums.SUCCESS.code);
				updateWithdrawReqFosDetail(detailDo, WithdrawOrderStatusEnums.SUCCESS.code);
				// 发起回调
				withdrawSplittingSerivce.computeWithdrawSplitting(withdrawReqDO);
				this.withdrawReqService.initiateCallback(withdrawReqDO, detailDo.getRemitVoucherNo());
				return WithdrawOrderStatusEnums.SUCCESS.code;
			} else if (responseDTO.getPaymentResult() != null
					&& (FosPaymentStateEnums.P.code.equalsIgnoreCase(responseDTO.getPaymentResult().getPaymentState()) || StringUtils
							.isBlank(responseDTO.getPaymentResult().getPaymentState()))) {
				// 如果出款中 更新状态为出款中
				updateWithdrawStatus(withdrawReqDO, WithdrawReqStatusEnums.WAITTING.code);
				updateWithdrawReqFosDetail(detailDo, WithdrawOrderStatusEnums.WAITTING.code);
				return WithdrawOrderStatusEnums.WAITTING.code;
			} else if (responseDTO.getPaymentResult() != null) {// 如果失败 执行重试
				setErrorInfo(detailDo, responseDTO);
			}
			if (ReturnCodeEnums.INVALID_ORDER_NO.code.equals(responseDTO.getReturnCode())) {// 订单或批次未找到
				detailDo.setReturnCode(responseDTO.getReturnCode());
				detailDo.setReturnMsg(responseDTO.getReturnMsg());
			}
		}
		updateWithdrawReqFosDetail(detailDo, WithdrawOrderStatusEnums.FAIL.code);
		return WithdrawOrderStatusEnums.FAIL.code;
	}

	private void setErrorInfo(WithdrawReqFosDetailDO detailDo, WithdrawT0QueryResponseDTO responseDTO) {
		String returnCode = null;
		if (responseDTO != null && responseDTO.getPaymentResult() != null && responseDTO.getPaymentResult().getExtension() != null) {
			returnCode = responseDTO.getPaymentResult().getExtension().get("RETURN_CODE") != null ? responseDTO.getPaymentResult().getExtension()
					.get("RETURN_CODE").toString() : responseDTO.getPaymentResult().getReturnCode();
			try {
				String extention = JSONObject.fromObject(responseDTO.getPaymentResult().getExtension()).toString();
				detailDo.setExtention(extention);
				detailDo.setReturnMsg(responseDTO.getPaymentResult().getReturnMsg());
			} catch (Exception e) {
				logger.info("WithdrawT0ServiceQueryServiceImpl #setErrorInfo JSONObject.fromObject is Exception："+e.getMessage());
			}
		}
		detailDo.setReturnCode(returnCode);

	}

	private void updateWithdrawReqFosDetail(WithdrawReqFosDetailDO detailDo, String status) {
		if(!status.equals(detailDo.getWithdrawStatus())){
			detailDo.setWithdrawStatus(status);
			detailDo.setUpdateTime(new Date());
			this.withdrawReqFosDetailService.updateData(detailDo);
		}
	}

	private void updateWithdrawStatus(WithdrawReqDO withdrawReqDO, int status) {
		if(status!=withdrawReqDO.getStatus().intValue()){
			withdrawReqDO.setUpdateTime(new Date());
			withdrawReqDO.setStatus(status);
			if (WithdrawReqStatusEnums.SUCCESS.code == status) {
				// 更新出款时间（到卡时间）
				if (withdrawReqDO.getWithdrawTime() == null) {
					withdrawReqDO.setWithdrawTime(new Date());
				}
				withdrawReqDO.setErrorCode(ReturnCodeEnums.FW_SUCCESS.code);
				withdrawReqDO.setErrorMsg(ReturnCodeEnums.FW_SUCCESS.msg);
			}
			withdrawReqService.updateData(withdrawReqDO);
		}

	}

}
