package com.sdp.mc.integration.fos.dto.request;

import java.math.BigDecimal;

/**
 * 贷款转账参数
 * 
 * @author wangjingao.william
 * **/
public class DebitTransferRequestDTO {
	/**
	 * 业务订单号
	 * **/
	private String bizId;
	/**
	 * 个人会员号
	 * **/
	private String memberId;
	/**
	 * 个人储值帐号，授信会员户
	 * **/
	private String creditAccountId;
	/**
	 * 个人储值帐号，个人账户基本户
	 * **/
	private String publicAccountId;
	/**
	 * 个人储值帐号，利息户
	 * **/
	private String interestAccountId;
	/** 借款-必传 **/
	private BigDecimal debitLimitAmount;
	/** 手续费 **/
	private BigDecimal fee;
	/** 利息 **/
	private BigDecimal interest;
	/** 批次号，申请配资必传 **/
	private String batchNo;
	public String getBizId() {
		return bizId;
	}
	public void setBizId(String bizId) {
		this.bizId = bizId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getCreditAccountId() {
		return creditAccountId;
	}
	public void setCreditAccountId(String creditAccountId) {
		this.creditAccountId = creditAccountId;
	}
	public String getPublicAccountId() {
		return publicAccountId;
	}
	public void setPublicAccountId(String publicAccountId) {
		this.publicAccountId = publicAccountId;
	}
	public String getInterestAccountId() {
		return interestAccountId;
	}
	public void setInterestAccountId(String interestAccountId) {
		this.interestAccountId = interestAccountId;
	}
	public BigDecimal getDebitLimitAmount() {
		return debitLimitAmount;
	}
	public void setDebitLimitAmount(BigDecimal debitLimitAmount) {
		this.debitLimitAmount = debitLimitAmount;
	}
	public BigDecimal getFee() {
		return fee;
	}
	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}
	public BigDecimal getInterest() {
		return interest;
	}
	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
}
