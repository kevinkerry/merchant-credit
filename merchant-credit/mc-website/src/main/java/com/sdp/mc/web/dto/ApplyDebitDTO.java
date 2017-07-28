package com.sdp.mc.web.dto;

import java.math.BigDecimal;

/**
 * 借款申请DTO
 */
public class ApplyDebitDTO {

	private BigDecimal debitAmount; // 借款金额
	private BigDecimal borrowDays; // 借款期限
	private BigDecimal interestAmount; // 借款利息
	private BigDecimal serviceAmount; // 期初服务费
	private String purposer;// 借款用途
	private BigDecimal interestRateDay; // 日息利率
	private BigDecimal canUseAmount; // 可用额度

	private String certSerialNo;
	private String encryptedKey;
	private String password;

	public BigDecimal getCanUseAmount() {
		return canUseAmount;
	}

	public void setCanUseAmount(BigDecimal canUseAmount) {
		this.canUseAmount = canUseAmount;
	}

	public BigDecimal getInterestRateDay() {
		return interestRateDay;
	}

	public void setInterestRateDay(BigDecimal interestRateDay) {
		this.interestRateDay = interestRateDay;
	}

	public BigDecimal getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(BigDecimal debitAmount) {
		this.debitAmount = debitAmount;
	}

	public BigDecimal getBorrowDays() {
		return borrowDays;
	}

	public void setBorrowDays(BigDecimal borrowDays) {
		this.borrowDays = borrowDays;
	}

	public BigDecimal getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(BigDecimal interestAmount) {
		this.interestAmount = interestAmount;
	}

	public BigDecimal getServiceAmount() {
		return serviceAmount;
	}

	public void setServiceAmount(BigDecimal serviceAmount) {
		this.serviceAmount = serviceAmount;
	}

	public String getPurposer() {
		return purposer;
	}

	public void setPurposer(String purposer) {
		this.purposer = purposer;
	}

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

}
