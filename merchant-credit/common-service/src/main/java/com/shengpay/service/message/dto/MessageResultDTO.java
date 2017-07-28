package com.shengpay.service.message.dto;

public class MessageResultDTO {
	/**
	 * 成功 1，失败 0
	 */
	private String resultCode;

	/**
	 * 返回信息
	 */
	private String resultMessage;

	/**
	 * 额外返回信息
	 */
	private String extResultMessage;

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

	public String getExtResultMessage() {
		return extResultMessage;
	}

	public void setExtResultMessage(String extResultMessage) {
		this.extResultMessage = extResultMessage;
	}

}
