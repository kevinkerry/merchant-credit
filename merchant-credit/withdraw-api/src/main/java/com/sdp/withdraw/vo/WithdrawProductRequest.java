package com.sdp.withdraw.vo;

import java.io.Serializable;

public class WithdrawProductRequest implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 3541849023350473680L;
	/**
	 * 商户号
	 */
	private String merchantNo;
	/**
	 * 商户类型
	 */
	private String mcType;

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

}
