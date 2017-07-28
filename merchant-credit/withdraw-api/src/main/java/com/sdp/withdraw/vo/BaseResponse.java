package com.sdp.withdraw.vo;

import java.io.Serializable;

public class BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5407609099737922593L;

	/**
	 * 响应编码
	 */
	private String errorCode;
	/**
	 * 响应编码描述
	 */
	private String errorMsg;
	

	public BaseResponse() {
		super();
	}

	public BaseResponse(String errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
