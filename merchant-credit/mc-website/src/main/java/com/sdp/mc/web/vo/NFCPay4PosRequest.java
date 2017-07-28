package com.sdp.mc.web.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class NFCPay4PosRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	private String token;
	private String orderNo;
	private String sendTime;
	private String orderAmount;
	private String buyerIp;
	private String merchentId;
	private String signType;
	private String signMsg;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getBuyerIp() {
		return buyerIp;
	}

	public void setBuyerIp(String buyerIp) {
		this.buyerIp = buyerIp;
	}

	public String getMerchentId() {
		return merchentId;
	}

	public void setMerchentId(String merchentId) {
		this.merchentId = merchentId;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getSignMsg() {
		return signMsg;
	}

	public void setSignMsg(String signMsg) {
		this.signMsg = signMsg;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
