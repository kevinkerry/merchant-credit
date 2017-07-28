package com.sdp.mc.common.vo;

import java.io.Serializable;
import java.util.Map;

public class ErrorMessageVO<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private boolean isSuccess;
	private String errorCode;
	private String errorMessage;
	private Map<String, Object> params;// json返回参数
	private T entity;

	public ErrorMessageVO(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public ErrorMessageVO(boolean isSuccess, String errorCode, String errorMessage) {
		this.isSuccess = isSuccess;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public ErrorMessageVO(boolean isSuccess, String errorCode, String errorMessage, Map<String, Object> params) {
		this.isSuccess = isSuccess;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.params = params;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
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

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	@Override
	public String toString() {
		return "ErrorMessageVO [isSuccess=" + isSuccess + ", errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}

}
