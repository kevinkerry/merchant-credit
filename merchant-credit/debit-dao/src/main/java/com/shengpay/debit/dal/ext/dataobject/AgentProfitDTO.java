package com.shengpay.debit.dal.ext.dataobject;

import java.math.BigDecimal;
import java.util.Date;

public class AgentProfitDTO {

	private String merchantName; // 商户名称
	private String merchantNo; // 商户号
	private Date debitDate;// 借款有效期
	private Date applyDate; // 借款申请日期
	private BigDecimal debitAmount; // 借款本金
	private BigDecimal borrowDays; // 借款期限
	private Date startTime; // 起息日
	private Date endTime; // 到期日
	private String profitStatus; // 分润状态
	private BigDecimal profitAmount;// 分润金额

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public Date getDebitDate() {
		return debitDate;
	}

	public void setDebitDate(Date debitDate) {
		this.debitDate = debitDate;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getProfitStatus() {
		return profitStatus;
	}

	public void setProfitStatus(String profitStatus) {
		this.profitStatus = profitStatus;
	}

	public BigDecimal getProfitAmount() {
		return profitAmount;
	}

	public void setProfitAmount(BigDecimal profitAmount) {
		this.profitAmount = profitAmount;
	}

}
