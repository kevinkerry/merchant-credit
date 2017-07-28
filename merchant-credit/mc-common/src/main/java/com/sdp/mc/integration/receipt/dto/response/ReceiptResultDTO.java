package com.sdp.mc.integration.receipt.dto.response;

public class ReceiptResultDTO {
	 /**
     * 凭证号
     */
    private String receiptNo;
    /**
     * 结果代码: S - 成功, F - 失败, E - 异常
     */
    private String resultCode;
    /**
     * 结果描述
     */
    private String resultMessage;
    /**
     * JSON格式的扩展信息
     */
    private String extendInfo;

	public String getReceiptNo() {
		return receiptNo;
	}
	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	public String getExtendInfo() {
		return extendInfo;
	}
	public void setExtendInfo(String extendInfo) {
		this.extendInfo = extendInfo;
	}
    
}
