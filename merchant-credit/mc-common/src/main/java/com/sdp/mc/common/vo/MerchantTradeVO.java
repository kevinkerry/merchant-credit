package com.sdp.mc.common.vo;

import java.math.BigDecimal;
/**
 * 调用数据组提供接口返回对象
 * @author liutao
 *
 */
public class MerchantTradeVO {
	/**
	 * 月份
	 */
	private int month;
	/**
	 * 商户号
	 */
	private String merchantNo;
	/**
	 * 交易金额
	 */
	private BigDecimal amount;

	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


}
