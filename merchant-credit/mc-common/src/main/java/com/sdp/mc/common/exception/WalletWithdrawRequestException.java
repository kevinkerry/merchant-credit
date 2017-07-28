package com.sdp.mc.common.exception;

public class WalletWithdrawRequestException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorCode=null;
	private String errorMessage=null;
	public WalletWithdrawRequestException(String message) {
		super(message);
	}
	
	public WalletWithdrawRequestException() {
		super();
	}

	public WalletWithdrawRequestException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
}
