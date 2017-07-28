package com.sdp.mc.web.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class NFCPay4PosResponse extends BaseResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private String transNo;
	private String orderNo;
	private String orderAmount;
	private String paidAmount;
	private String status;

	public String getTransNo() {
		return transNo;
	}

	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static NFCPay4PosResponse buildFail(String msg) {
		NFCPay4PosResponse response = new NFCPay4PosResponse();
		response.setSuccess(false);
		response.setErrorMsg(msg);
		return response;
	}

	public static NFCPay4PosResponse buildSuccess() {
		NFCPay4PosResponse response = new NFCPay4PosResponse();
		response.setSuccess(true);
		response.setErrorMsg("成功");
		return response;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
