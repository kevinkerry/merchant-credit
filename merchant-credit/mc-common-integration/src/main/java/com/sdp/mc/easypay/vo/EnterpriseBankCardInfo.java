package com.sdp.mc.easypay.vo;

import java.io.Serializable;

/**
 * 银行卡信息
 */
public class EnterpriseBankCardInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 819218015462243342L;
	// 手机号
	private String phone;
	// 身份证
	private String identityId;
	// 银行卡
	private String bankCard;
	// 开户行编码
	private String bankCode;
	// 开户行名称
	private String bankName;
	// 支行编码
	private String branchCode;
	// 支行名称
	private String branchName;
	// 省编码
	private String provinceCode;
	// 省名称
	private String provinceName;
	// 市编码
	private String cityCode;
	// 市名称
	private String cityName;
	// 账户名称
	private String accountName;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdentityId() {
		return identityId;
	}

	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}

	public String getBankCard() {
		return bankCard;
	}

	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

}
