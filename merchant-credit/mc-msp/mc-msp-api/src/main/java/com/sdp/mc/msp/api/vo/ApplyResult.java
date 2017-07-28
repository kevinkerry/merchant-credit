package com.sdp.mc.msp.api.vo;


import java.io.Serializable;

public class ApplyResult implements Serializable {

	private static final long serialVersionUID = -8837630952608175191L;

	/**
	 * 商户号
	 */
	private String merchantNo;
	/**
	 * Pos商户号
	 */
	private String posMerchantNo;
	/**
	 * 访问成功标示
	 */
	private String code;

	/**
	 * 异常信息
	 */
	private String errorMsg;

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getPosMerchantNo() {
		return posMerchantNo;
	}

	public void setPosMerchantNo(String posMerchantNo) {
		this.posMerchantNo = posMerchantNo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}





}