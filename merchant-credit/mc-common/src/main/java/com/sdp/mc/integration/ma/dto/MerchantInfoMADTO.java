package com.sdp.mc.integration.ma.dto;

public class MerchantInfoMADTO {

	private String merchantNo;
	private String merchantId;
	private String memberId;
	private Long merchantType;
	private String merchantName;
	private String ptid;
	private Long merchantStatus;

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Long getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(Long merchantType) {
		this.merchantType = merchantType;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getPtid() {
		return ptid;
	}

	public void setPtid(String ptid) {
		this.ptid = ptid;
	}

	public Long getMerchantStatus() {
		return merchantStatus;
	}

	public void setMerchantStatus(Long merchantStatus) {
		this.merchantStatus = merchantStatus;
	}

}
