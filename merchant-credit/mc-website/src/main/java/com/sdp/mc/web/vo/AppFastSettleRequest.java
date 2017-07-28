package com.sdp.mc.web.vo;

public class AppFastSettleRequest {

	private String merchantId;
	private String merchantNo;
	private String promoterId;
	private String promoterNo;
	private String mcType;
	
	private String autoFastSettle;

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getPromoterId() {
		return promoterId;
	}

	public void setPromoterId(String promoterId) {
		this.promoterId = promoterId;
	}

	public String getPromoterNo() {
		return promoterNo;
	}

	public void setPromoterNo(String promoterNo) {
		this.promoterNo = promoterNo;
	}

	public String getMcType() {
		return mcType;
	}

	public void setMcType(String mcType) {
		this.mcType = mcType;
	}

	public String getAutoFastSettle() {
		return autoFastSettle;
	}

	public void setAutoFastSettle(String autoFastSettle) {
		this.autoFastSettle = autoFastSettle;
	}

}
