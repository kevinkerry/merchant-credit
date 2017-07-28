package com.sdp.mc.integration.msp.response;

public class MspResponseDTO {

	/**
	 * 1成功
	 * 0失败
	 * **/
	private int code;
	private String errorMsg;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
