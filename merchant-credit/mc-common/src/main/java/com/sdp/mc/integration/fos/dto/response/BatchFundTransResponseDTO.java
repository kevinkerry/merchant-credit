package com.sdp.mc.integration.fos.dto.response;

import java.util.List;

public class BatchFundTransResponseDTO {

	private boolean isSuccess;
	private String returnCode;
	private String returnMsg;
	private List<RemitTransferResponseDTO> paymentResultList;

	public BatchFundTransResponseDTO(boolean isSuccess, String returnCode, String returnMsg) {
		this.isSuccess = isSuccess;
		this.returnCode = returnCode;
		this.returnMsg = returnMsg;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getReturnMsg() {
		return returnMsg;
	}
	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	public List<RemitTransferResponseDTO> getPaymentResultList() {
		return paymentResultList;
	}
	public void setPaymentResultList(List<RemitTransferResponseDTO> paymentResultList) {
		this.paymentResultList = paymentResultList;
	}
}
