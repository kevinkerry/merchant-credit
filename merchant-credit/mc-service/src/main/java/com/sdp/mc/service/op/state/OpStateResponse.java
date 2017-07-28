package com.sdp.mc.service.op.state;

public class OpStateResponse {

	private boolean success;

	private String errorCode;
	private String message;

	public OpStateResponse() {
	}

	public OpStateResponse(boolean success, String errorCode, String message) {
		this.success = success;
		this.errorCode = errorCode;
		this.message = message;
	}

	public static OpStateResponse genSuccessResponse(String message) {
		return new OpStateResponse(true, null, message);
	}

	public static OpStateResponse genFailureResponse(String errorCode, String message) {
		return new OpStateResponse(false, errorCode, message);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "OpStateResponse [success=" + success + ", " + (errorCode != null ? "errorCode=" + errorCode + ", " : "")
				+ (message != null ? "message=" + message : "") + "]";
	}

}