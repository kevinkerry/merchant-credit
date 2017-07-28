package com.sdp.mc.common.vo;

import java.io.Serializable;
import java.util.Date;

public class MCProductInfo implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String productCode;
	private String payCode;
	private String bizCode;
	private String beginTime;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getPayCode() {
		return payCode;
	}

	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}

	public String getBizCode() {
		return bizCode;
	}

	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	private String endTime;
}
