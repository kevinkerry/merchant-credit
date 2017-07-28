package com.sdp.mc.common.web;

/**
 * 商户信息
 * @author heyi.alex
 *
 */
public class MerchantPromoterInfo {

	/**
	 * 商户号
	 */
	private String merchantNo;

	/**
	 * 商户名称
	 */
	private String merchantName;

	/**
	 * 代理商商户号
	 */
	private String promoterNo;

	/**
	 * 代理商名称
	 */
	private String promoterName;

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

	public String getPromoterNo() {
		return promoterNo;
	}

	public void setPromoterNo(String promoterNo) {
		this.promoterNo = promoterNo;
	}

	public String getPromoterName() {
		return promoterName;
	}

	public void setPromoterName(String promoterName) {
		this.promoterName = promoterName;
	}

}
