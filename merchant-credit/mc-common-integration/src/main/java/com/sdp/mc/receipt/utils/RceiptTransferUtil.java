package com.sdp.mc.receipt.utils;

import org.apache.commons.lang.StringUtils;

import com.sdp.mc.integration.receipt.dto.request.FundOutReceiptSubmitRequestDTO;
import com.sdp.mc.integration.receipt.dto.response.ReceiptResultDTO;
import com.shengpay.receipt.model.FundOutReceiptSubmitRequest;
import com.shengpay.receipt.model.ReceiptResult;
/**
 * 出款凭证参数转换工具类
 * @author zhangyulong
 *
 */
public class RceiptTransferUtil {
	/**
	 * 生成出款凭证提交请求参数
	 * @param requestDTO
	 * @return
	 */
	public static FundOutReceiptSubmitRequest buildFundOutReceiptSubmitRequest(FundOutReceiptSubmitRequestDTO requestDTO){
		FundOutReceiptSubmitRequest request = new FundOutReceiptSubmitRequest();
		if(requestDTO != null){
			if(StringUtils.isBlank(requestDTO.getAppCode()) && StringUtils.isBlank(requestDTO.getAppOrderNo()) 
					&& StringUtils.isBlank(requestDTO.getBizCode()) && StringUtils.isBlank(requestDTO.getAppOrderNoRef())
					&& StringUtils.isBlank(requestDTO.getPayeeMemberId()) && 
					StringUtils.isBlank(requestDTO.getPayeeAccountNo()) && StringUtils.isBlank(requestDTO.getBankAccountName()) 
					&& StringUtils.isBlank(requestDTO.getBankAccountNo()) && requestDTO.getPayableAmount() == null 
					&& StringUtils.isBlank(requestDTO.getExtendInfo())){
				return null;
			}
			request.setAppCode(requestDTO.getAppCode());
			request.setBizCode(requestDTO.getBizCode());
			request.setAppOrderNo(requestDTO.getAppOrderNo());
			request.setAppOrderNoRef(requestDTO.getAppOrderNoRef());
			request.setPayeeMemberId(requestDTO.getPayeeMemberId());
			request.setPayeeAccountNo(requestDTO.getPayeeAccountNo());
			request.setBankAccountName(requestDTO.getBankAccountName());
			request.setBankAccountNo(requestDTO.getBankAccountNo());
			request.setPayableAmount(requestDTO.getPayableAmount());
			request.setExtendInfo(requestDTO.getExtendInfo());
		}
		return request;
	}
	
	/**
	 * 生成出款凭证提交响应参数
	 * @param receiptResult
	 * @return
	 */
	public static ReceiptResultDTO buildReceiptResultDTO(ReceiptResult receiptResult){
		if(receiptResult != null){
			ReceiptResultDTO requestDTO = new ReceiptResultDTO();
			requestDTO.setReceiptNo(receiptResult.getReceiptNo());
			requestDTO.setResultCode(receiptResult.getResultCode());
			requestDTO.setResultMessage(receiptResult.getResultMessage());
			requestDTO.setExtendInfo(receiptResult.getExtendInfo());
			return requestDTO;
		}else{
			return null;
		}
	}
}
