package com.sdp.mc.easypay.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class TradeItemVO {


	private String orderNo;
	
	private String  merchantNo;
	
	private String merchantName;
	
	@JSONField(format="yyyy-MM-dd HH:mm:ss")  
	private Date payTime;
	
	private BigDecimal payAmount;
	
	private BigDecimal fee;
	
	private BigDecimal rate;
	
	private String payStatus;
	
	private String payType;
	
	private String payProduct;
	
	private String payMethod;
	
	private String operator;
	
	private String notes;
	
	private String payChannel;
	
	private String secondProxy;

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}


	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getPayMethod() {
		return this.payMethod;
	}
	public String getPayProduct() {
		return this.payProduct;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getPayChannel() {
		return payChannel;
	}

	public void setPayChannel(String payChannel) {
		this.payChannel = payChannel;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public void setPayProduct(String payProduct) {
		this.payProduct = payProduct;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getSecondProxy() {
		return secondProxy;
	}

	public void setSecondProxy(String secondProxy) {
		this.secondProxy = secondProxy;
	}
	

}
