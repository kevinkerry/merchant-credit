package com.sdp.mc.easypay.vo;

import java.math.BigDecimal;
import java.util.List;

import com.shengpay.commons.core.utils.StringUtils;

public class MerchantDetailVO {

	private String merchantNo;

	private String phoneNo;

	// 商户地址信息
	private String provinceName;

	// 省编码
	private String provinceCode;

	// 市名称
	private String cityName;

	// 市编码
	private String cityCode;

	private String detailAddress;

	private String merchantName;

	private String idNo;

	private String storeName;

	private BigDecimal rate;

	private String accountName;

	private String bankName;

	private String branchName;

	private String settleCardNo;

	private String registerStatus;

	private String realNameStatus;

	private List<MerchantPayChannel> payChannels;
	
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getSettleCardNo() {
		return settleCardNo;
	}

	public void setSettleCardNo(String settleCardNo) {
		this.settleCardNo = settleCardNo;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getRegisterStatus() {
		return registerStatus;
	}

	public void setRegisterStatus(String registerStatus) {
		this.registerStatus = registerStatus;
	}

	public String getRealNameStatus() {
		if(StringUtils.isBlank(realNameStatus)){
			return "尚未提交";
		}
		return realNameStatus;
	}

	public void setRealNameStatus(String realNameStatus) {
		this.realNameStatus = realNameStatus;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public List<MerchantPayChannel> getPayChannels() {
		return payChannels;
	}

	public void setPayChannels(List<MerchantPayChannel> payChannels) {
		this.payChannels = payChannels;
	}

}
