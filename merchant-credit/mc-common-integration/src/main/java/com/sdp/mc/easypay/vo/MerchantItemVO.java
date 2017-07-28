package com.sdp.mc.easypay.vo;

import java.math.BigDecimal;
import java.util.Date;




import com.alibaba.fastjson.annotation.JSONField;
import com.shengpay.commons.core.utils.StringUtils;

public class MerchantItemVO {

	
	private String  merchantNo;
	
	private String merchantName;
	
	private BigDecimal rate;
	
	private String registerStatus;
	
	private String realNameStatus;
	
	private String operator;
	
	@JSONField (format="yyyy-MM-dd HH:mm:ss")  
	private Date createDate;

	private String qrCode;
	
	private String alStatus;
	
	private String wxStatus;
	
	private String secondProxy;
	
	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getRegisterStatus() {
		return this.registerStatus;
	}

	public void setRegisterStatus(String registerStatus) {
		this.registerStatus = registerStatus;
	}

	public String getRealNameStatus() {
		if(StringUtils.isBlank(realNameStatus)){
			return "尚未提交";
		}
		return this.realNameStatus;
		
	}

	public void setRealNameStatus(String realNameStatus) {
		this.realNameStatus = realNameStatus;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getAlStatus() {
		return alStatus;
	}

	public void setAlStatus(String alStatus) {
		this.alStatus = alStatus;
	}

	public String getWxStatus() {
		return wxStatus;
	}

	public void setWxStatus(String wxStatus) {
		this.wxStatus = wxStatus;
	}

	public String getSecondProxy() {
		return secondProxy;
	}

	public void setSecondProxy(String secondProxy) {
		this.secondProxy = secondProxy;
	}
	
}
