package com.sdp.withdraw.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import com.sdp.withdraw.util.SignUtil;

public class WithdrawCheckRequest implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = -4384897751949789903L;
	/**
//	 * 应用编码
//	 */
//	private String appId;
//	/**
//	 * 业务订单号
//	 */
//	private String orderNo;
	/**
	 * 商户号
	 */
	private String merchantNo;
	/**
	 * 商户类型
	 */
	private String mcType;
	/**
	 * 原始额度
	 */
	private BigDecimal originalAmount;


//	public String getAppId() {
//		return appId;
//	}
//
//	public void setAppId(String appId) {
//		this.appId = appId;
//	}
//
//	public String getOrderNo() {
//		return orderNo;
//	}
//
//	public void setOrderNo(String orderNo) {
//		this.orderNo = orderNo;
//	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getMcType() {
		return mcType;
	}

	public void setMcType(String mcType) {
		this.mcType = mcType;
	}

	public BigDecimal getOriginalAmount() {
		return originalAmount;
	}

	public void setOriginalAmount(BigDecimal originalAmount) {
		this.originalAmount = originalAmount;
	}
}
