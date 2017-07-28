package com.sdp.mc.easypay.vo;

import java.math.BigDecimal;

public class QrCodeRateVO {

	private String qrCode;

	private BigDecimal rate;

	private String status;

	private String childMerchantNo;

	private String childMerchantName;

	private String allowStatus;

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getChildMerchantNo() {
		return childMerchantNo;
	}

	public void setChildMerchantNo(String childMerchantNo) {
		this.childMerchantNo = childMerchantNo;
	}

	public String getChildMerchantName() {
		return childMerchantName;
	}

	public void setChildMerchantName(String childMerchantName) {
		this.childMerchantName = childMerchantName;
	}

	public String getAllowStatus() {
		return allowStatus;
	}

	public void setAllowStatus(String allowStatus) {
		this.allowStatus = allowStatus;
	}

}
