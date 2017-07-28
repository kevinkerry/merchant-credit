package com.sdp.mc.sars.bean;

import java.util.Date;
/**
 * 风控，商户关闭快速结算的接入点
 * @author liyantao01
 *
 */
public class SarsCP285Bean extends SarsParentBean {

	private static final String checkPoint = "CP285";

	public SarsCP285Bean(String merchantNo,Date date) {
		super(checkPoint);
		this.merchantNo = merchantNo;
		this.orderTime = date2Str(date);
	}

	/**
	 * 商户号
	 */
	private String merchantNo;
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
