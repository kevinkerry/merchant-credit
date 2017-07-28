package com.sdp.mc.integration.ma.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商户余额dto
 * **/
public class MerchantBalanceDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 商户号对应的会员号 **/
	private String memberId;

	/** 对公基本户id **/
	private String publicAccountId;
	/** 对公基本户余额 **/
	private BigDecimal publicAccountBalance;
	/** 对公基本户状态 **/
	private int publicAccountStatus;

	/** 保证金账户id **/
	private String marginAccountId;
	/** 保证金账户余额 **/
	private BigDecimal marginAccountBalance;
	/** 保证金账户状态 **/
	private int marginAccountStatus;

	/** 配资授信账户id **/
	private String creditAccountId;
	/** 配资授信账户余额 **/
	private BigDecimal creditAccountBalance;
	/** 配资授信账户状态 **/
	private int creditAccountStatus;

	/** 商户号对应的会员号 **/
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/** 对公基本户id **/
	public String getPublicAccountId() {
		return publicAccountId;
	}

	public void setPublicAccountId(String publicAccountId) {
		this.publicAccountId = publicAccountId;
	}

	/** 对公基本户余额 **/
	public BigDecimal getPublicAccountBalance() {
		return publicAccountBalance;
	}

	public void setPublicAccountBalance(BigDecimal publicAccountBalance) {
		this.publicAccountBalance = publicAccountBalance;
	}

	/** 保证金账户id **/
	public String getMarginAccountId() {
		return marginAccountId;
	}

	public void setMarginAccountId(String marginAccountId) {
		this.marginAccountId = marginAccountId;
	}

	/** 保证金账户余额 **/
	public BigDecimal getMarginAccountBalance() {
		return marginAccountBalance;
	}

	public void setMarginAccountBalance(BigDecimal marginAccountBalance) {
		this.marginAccountBalance = marginAccountBalance;
	}

	public String getCreditAccountId() {
		return creditAccountId;
	}

	public void setCreditAccountId(String creditAccountId) {
		this.creditAccountId = creditAccountId;
	}

	public BigDecimal getCreditAccountBalance() {
		return creditAccountBalance;
	}

	public void setCreditAccountBalance(BigDecimal creditAccountBalance) {
		this.creditAccountBalance = creditAccountBalance;
	}

	public int getPublicAccountStatus() {
		return publicAccountStatus;
	}

	public void setPublicAccountStatus(int publicAccountStatus) {
		this.publicAccountStatus = publicAccountStatus;
	}

	public int getMarginAccountStatus() {
		return marginAccountStatus;
	}

	public void setMarginAccountStatus(int marginAccountStatus) {
		this.marginAccountStatus = marginAccountStatus;
	}

	public int getCreditAccountStatus() {
		return creditAccountStatus;
	}

	public void setCreditAccountStatus(int creditAccountStatus) {
		this.creditAccountStatus = creditAccountStatus;
	}

}
