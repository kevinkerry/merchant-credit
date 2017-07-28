package com.sdp.mc.integration.fos.dto.request;

import java.math.BigDecimal;

/**
 * 配资授信转账请求dto
 * **/
public class CreditTransferRequestDTO {

	/**
	 * 代理商会员号-必传
	 * **/
	private String promoterMemberId;
	/**
	 * 代理商储值帐号-281专户必传
	 * **/
	private String promoterCreditAccountId;
	/**
	 * 代理商储值帐号-201专户必传手续费从基本户扣
	 * **/
	private String promoterPublicAccountId;
	/** 授信额度-必传 **/
	private BigDecimal creditAmount;
	/** 手续费 **/
	private BigDecimal fee; 
	/** 批次号，申请配资必传 **/
	private String batchNo;
	/** 授信变更记录id--重试才传 */
	private Long creditFosId;
	/** fos手续费转账id */
	private Long feeFosId;
	
	public String getPromoterMemberId() {
		return promoterMemberId;
	}
	public void setPromoterMemberId(String promoterMemberId) {
		this.promoterMemberId = promoterMemberId;
	}
	public String getPromoterCreditAccountId() {
		return promoterCreditAccountId;
	}
	public void setPromoterCreditAccountId(String promoterCreditAccountId) {
		this.promoterCreditAccountId = promoterCreditAccountId;
	}
	public String getPromoterPublicAccountId() {
		return promoterPublicAccountId;
	}
	public void setPromoterPublicAccountId(String promoterPublicAccountId) {
		this.promoterPublicAccountId = promoterPublicAccountId;
	}
	public BigDecimal getCreditAmount() {
		return creditAmount;
	}
	public void setCreditAmount(BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}
	public BigDecimal getFee() {
		return fee;
	}
	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public Long getCreditFosId() {
		return creditFosId;
	}
	public void setCreditFosId(Long creditFosId) {
		this.creditFosId = creditFosId;
	}
	public Long getFeeFosId() {
		return feeFosId;
	}
	public void setFeeFosId(Long feeFosId) {
		this.feeFosId = feeFosId;
	}
}
