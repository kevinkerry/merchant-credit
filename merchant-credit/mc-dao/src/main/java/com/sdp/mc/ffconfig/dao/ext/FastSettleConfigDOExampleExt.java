package com.sdp.mc.ffconfig.dao.ext;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.sdp.mc.ffconfig.dao.FastSettleConfigDOExample;

public class FastSettleConfigDOExampleExt extends FastSettleConfigDOExample {
	private static final long serialVersionUID = 1L;
	/**
	 * 商户名称
	 */
	private String merchantName;
	/**
	 * 商户号
	 */
	private String merchantNo;
	/**
	 * pos商户号
	 */
	private String posMerchantNo;
	/**
	 * 商户类型--就是商户的合同类型0001,0005,0006
	 */
	private String merchantType;
	/**
	 * 商户状态---正常/关闭
	 */
	private String merchantStatus;
	/**
	 * 拓展商名称
	 */
	private String promoterName;

	/**
	 * 拓展方商户号
	 */
	private String promoterMerchantNo;
	/**
	 * 商户当日最高限额---
	 */
	private Long maxLimitAmountStart;
	/**
	 * 商户当日最高限额---
	 */
	private Long maxLimitAmountEnd;
	/**
	 * 申请开通快速结算时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTimeStart;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTimeEnd;
	/**
	 * 是否开通快速结算
	 */
	private String merchantFastSettleFlag;

	public String getMerchantFastSettleFlag() {
		return merchantFastSettleFlag;
	}

	public void setMerchantFastSettleFlag(String merchantFastSettleFlag) {
		this.merchantFastSettleFlag = merchantFastSettleFlag;
	}

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

	public String getPromoterName() {
		return promoterName;
	}

	public void setPromoterName(String promoterName) {
		this.promoterName = promoterName;
	}

	public String getPromoterMerchantNo() {
		return promoterMerchantNo;
	}

	public void setPromoterMerchantNo(String promoterMerchantNo) {
		this.promoterMerchantNo = promoterMerchantNo;
	}

	public String getPosMerchantNo() {
		return posMerchantNo;
	}

	public void setPosMerchantNo(String posMerchantNo) {
		this.posMerchantNo = posMerchantNo;
	}

	public String getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}

	public String getMerchantStatus() {
		return merchantStatus;
	}

	public void setMerchantStatus(String merchantStatus) {
		this.merchantStatus = merchantStatus;
	}

	public Long getMaxLimitAmountStart() {
		return maxLimitAmountStart;
	}

	public void setMaxLimitAmountStart(Long maxLimitAmountStart) {
		this.maxLimitAmountStart = maxLimitAmountStart;
	}

	public Long getMaxLimitAmountEnd() {
		return maxLimitAmountEnd;
	}

	public void setMaxLimitAmountEnd(Long maxLimitAmountEnd) {
		this.maxLimitAmountEnd = maxLimitAmountEnd;
	}

	public Date getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeStart(Date createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}
}
