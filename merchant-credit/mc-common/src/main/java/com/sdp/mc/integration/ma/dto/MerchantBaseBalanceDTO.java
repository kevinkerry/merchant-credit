package com.sdp.mc.integration.ma.dto;

import java.math.BigDecimal;

public class MerchantBaseBalanceDTO {
	/** 商户号对应的会员号 **/
	private String memberId;
	/** 账户id **/
	private String accountId;
	/** 账户余额 **/
	private BigDecimal accountBalance;
	/** 账户状态 **/
	private int accountStatus;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
	public int getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(int accountStatus) {
		this.accountStatus = accountStatus;
	}
}
