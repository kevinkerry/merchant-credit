package com.sdp.mc.integration.ma.dto.response;

import com.sdp.mc.integration.ma.dto.MABaseDTO;

public class MACreateAccountResponseDTO extends MABaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 是否创建成功
	 * **/
	private boolean isSuccess;
	/**
	 * 储值账户id
	 * **/
	private String accountId;
	/**
	 * 返回码
	 */
	private String responseCode;

	/**
	 * 返回消息描述
	 */
	private String responseMessage;
	/**
	 * 请求序列号
	 */
	private String requestNo;

	public MACreateAccountResponseDTO(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public boolean isSuccess() {
		return isSuccess;
	}
}
