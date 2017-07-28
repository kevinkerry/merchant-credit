package com.sdp.mc.common.bean;

import java.io.Serializable;

public class RetryRulePO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -643376518764584590L;
    
	private String errorCode;//错误码
	private String codeKey;//对应的KEY
	private Integer retryTimes; //重试次数
	private Integer timeInterval;//时间间隔
	private String description;//描述
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getCodeKey() {
		return codeKey;
	}
	public void setCodeKey(String codeKey) {
		this.codeKey = codeKey;
	}
	public Integer getRetryTimes() {
		return retryTimes;
	}
	public void setRetryTimes(Integer retryTimes) {
		this.retryTimes = retryTimes;
	}
	public Integer getTimeInterval() {
		return timeInterval;
	}
	public void setTimeInterval(Integer timeInterval) {
		this.timeInterval = timeInterval;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public RetryRulePO(String errorCode, String codeKey, String retryTimes, String timeInterval, String description) {
		this.errorCode = errorCode;
		this.codeKey = codeKey;
		this.retryTimes = Integer.parseInt(retryTimes);
		this.timeInterval = Integer.parseInt(timeInterval);
		this.description = description;
	}
	public RetryRulePO() {
		super();
	}
	@Override
	public String toString() {
		return "RetryRulePO [errorCode=" + errorCode + ", codeKey=" + codeKey + ", retryTimes=" + retryTimes + ", timeInterval=" + timeInterval
				+ ", description=" + description + "]";
	}
	
	
	
	
	
}
