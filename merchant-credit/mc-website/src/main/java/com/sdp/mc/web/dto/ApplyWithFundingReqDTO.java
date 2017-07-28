package com.sdp.mc.web.dto;

/**
 * 配资请求信息
 */
public class ApplyWithFundingReqDTO {

	private String certSerialNo;
	private String encryptedKey;
	private String password;

	private String withFundingFeeRate; // 配资费率
	private String validCredit;// 剩余额度
	private String fundingFee; // 配资手续费
	private String fundingAmount; // 配资金额

	public String getCertSerialNo() {
		return certSerialNo;
	}

	public void setCertSerialNo(String certSerialNo) {
		this.certSerialNo = certSerialNo;
	}

	public String getEncryptedKey() {
		return encryptedKey;
	}

	public void setEncryptedKey(String encryptedKey) {
		this.encryptedKey = encryptedKey;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWithFundingFeeRate() {
		return withFundingFeeRate;
	}

	public void setWithFundingFeeRate(String withFundingFeeRate) {
		this.withFundingFeeRate = withFundingFeeRate;
	}

	public String getValidCredit() {
		return validCredit;
	}

	public void setValidCredit(String validCredit) {
		this.validCredit = validCredit;
	}

	public String getFundingFee() {
		return fundingFee;
	}

	public void setFundingFee(String fundingFee) {
		this.fundingFee = fundingFee;
	}

	public String getFundingAmount() {
		return fundingAmount;
	}

	public void setFundingAmount(String fundingAmount) {
		this.fundingAmount = fundingAmount;
	}

}
