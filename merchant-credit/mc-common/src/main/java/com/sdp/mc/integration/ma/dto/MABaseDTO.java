package com.sdp.mc.integration.ma.dto;

import java.io.Serializable;
import java.util.Date;

public class MABaseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 请求序列号
	 */
	private String requestNo;

	/**
	 * 请求时间，日期时间
	 */
	private Date requestTime;
	
	/**
	 * 请求来源,zf号
	 */
	private String sourceId;
	
	/**
	 * 请求操作员
	 */
	private String requestOperator;

	/** 服务器ip **/
	private String appIp;
	
	/** 用户IP **/
	private String userIp;

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getRequestOperator() {
		return requestOperator;
	}

	public void setRequestOperator(String requestOperator) {
		this.requestOperator = requestOperator;
	}

	public String getAppIp() {
		return appIp;
	}

	public void setAppIp(String appIp) {
		this.appIp = appIp;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

}
