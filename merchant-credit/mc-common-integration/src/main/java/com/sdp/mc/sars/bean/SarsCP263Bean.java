package com.sdp.mc.sars.bean;

import java.util.Date;

public class SarsCP263Bean extends SarsParentBean {

	private static final String checkPoint = "CP263";

	public SarsCP263Bean(String merchantNo, String amount, Date date) {
		super(checkPoint);
		this.merchantNo = merchantNo;
		this.amount = amount;
		this.orderTime = date2Str(date);
	}

	// merchantNo 商户名
	// amount 金额
	// orderTime 申请时间

	/**
	 * 商户号
	 */
	private String merchantNo;
	/**
	 * 金额
	 */
	private String amount;
	/**
	 * 申请时间
	 */
	private String orderTime;

	/**
	 * 商户号
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * 金额
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * 金额
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * 商户号
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * 申请时间
	 */
	public String getOrderTime() {
		return orderTime;
	}

	/**
	 * 申请时间
	 */
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

}
