package com.shengpay.service.hessian.merchant.bean;

import java.io.Serializable;

import com.sdp.withdraw.vo.merchant.SynMerchantRequest;

public class SynMerchantFailBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private SynMerchantRequest synMerchantRequest;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SynMerchantRequest getSynMerchantRequest() {
		return synMerchantRequest;
	}

	public void setSynMerchantRequest(SynMerchantRequest synMerchantRequest) {
		this.synMerchantRequest = synMerchantRequest;
	}

	public SynMerchantFailBean(String message, SynMerchantRequest synMerchantRequest) {
		super();
		this.message = message;
		this.synMerchantRequest = synMerchantRequest;
	}

	public SynMerchantFailBean() {
		super();
	}

}
