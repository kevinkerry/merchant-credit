package com.sdp.withdraw.vo.ratio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class WithdrawRatioRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7615538126468103885L;
	private Integer ratioId;
	/*
	 * 商户号
	 */
	private String merchantNo;
	private String merchantType;
	/**
	 * 提现费率状态
	 */
	private int withDrawRatioStatus;
	/**
	 * 提现费率类型
	 */
	private int withDrawRatioType;
	/**
	 * 工作日费率
	 */
	private BigDecimal workDayWithDrawRatio;
	/**
	 * 非工作费率
	 */
	private BigDecimal holidayWithDrawRatio;
	/**
	 * 生效时间
	 */
	private Date effectiveTime;
	/**
	 * 失效时间
	 */
	private Date expireTime;

	public WithdrawRatioRequest() {
	}

	public WithdrawRatioRequest(String merchantNo, String merchantType) {
		super();
		this.merchantNo = merchantNo;
		this.merchantType = merchantType;
	}

	public WithdrawRatioRequest(String merchantNo, String merchantType, int withDrawRatioType, BigDecimal workDayWithDrawRatio,
			BigDecimal holidayWithDrawRatio) {
		super();
		this.merchantNo = merchantNo;
		this.withDrawRatioType = withDrawRatioType;
		this.workDayWithDrawRatio = workDayWithDrawRatio;
		this.holidayWithDrawRatio = holidayWithDrawRatio;
		this.merchantType = merchantType;
	}
	public WithdrawRatioRequest(String merchantNo, String merchantType, int withDrawRatioType, BigDecimal workDayWithDrawRatio,
			BigDecimal holidayWithDrawRatio, Integer ratioId) {
		super();
		this.ratioId = ratioId;
		this.merchantNo = merchantNo;
		this.withDrawRatioType = withDrawRatioType;
		this.workDayWithDrawRatio = workDayWithDrawRatio;
		this.holidayWithDrawRatio = holidayWithDrawRatio;
		this.merchantType = merchantType;
	}

	public WithdrawRatioRequest(String merchantNo, String merchantType, int withDrawRatioStatus, int withDrawRatioType) {
		super();
		this.merchantNo = merchantNo;
		this.withDrawRatioStatus = withDrawRatioStatus;
		this.withDrawRatioType = withDrawRatioType;
		this.merchantType = merchantType;
	}

	public WithdrawRatioRequest(String merchantNo, String merchantType, int withDrawRatioType, Date effectiveTime, Date expireTime) {
		super();
		this.merchantNo = merchantNo;
		this.withDrawRatioType = withDrawRatioType;
		this.effectiveTime = effectiveTime;
		this.expireTime = expireTime;
		this.merchantType = merchantType;
	}

	public WithdrawRatioRequest(Integer ratioId, int withDrawRatioStatus, int withDrawRatioType, BigDecimal workDayWithDrawRatio,
			BigDecimal holidayWithDrawRatio, Date effectiveTime, Date expireTime) {
		super();
		this.ratioId = ratioId;
		this.withDrawRatioStatus = withDrawRatioStatus;
		this.withDrawRatioType = withDrawRatioType;
		this.workDayWithDrawRatio = workDayWithDrawRatio;
		this.holidayWithDrawRatio = holidayWithDrawRatio;
		this.effectiveTime = effectiveTime;
		this.expireTime = expireTime;
	}

	public Integer getRatioId() {
		return ratioId;
	}

	public void setRatioId(Integer ratioId) {
		this.ratioId = ratioId;
	}

	public String getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}

	public BigDecimal getWorkDayWithDrawRatio() {
		return workDayWithDrawRatio;
	}

	public void setWorkDayWithDrawRatio(BigDecimal workDayWithDrawRatio) {
		this.workDayWithDrawRatio = workDayWithDrawRatio;
	}

	public BigDecimal getHolidayWithDrawRatio() {
		return holidayWithDrawRatio;
	}

	public void setHolidayWithDrawRatio(BigDecimal holidayWithDrawRatio) {
		this.holidayWithDrawRatio = holidayWithDrawRatio;
	}

	public Date getEffectiveTime() {
		return effectiveTime;
	}

	public void setEffectiveTime(Date effectiveTime) {
		this.effectiveTime = effectiveTime;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public int getWithDrawRatioStatus() {
		return withDrawRatioStatus;
	}

	public void setWithDrawRatioStatus(int withDrawRatioStatus) {
		this.withDrawRatioStatus = withDrawRatioStatus;
	}

	public int getWithDrawRatioType() {
		return withDrawRatioType;
	}

	public void setWithDrawRatioType(int withDrawRatioType) {
		this.withDrawRatioType = withDrawRatioType;
	}

}
