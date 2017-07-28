package com.sdp.withdraw.vo.ratio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class WithdrawRatioResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2494051798866697424L;

	private String ratioId;
	/*
	 * 商户号
	 */
	private String merchantNo;
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

	public WithdrawRatioResult(String merchantNo, int withDrawRatioStatus, int withDrawRatioType, BigDecimal workDayWithDrawRatio,
			BigDecimal holidayWithDrawRatio, Date effectiveTime, Date expireTime) {
		super();
		this.merchantNo = merchantNo;
		this.withDrawRatioStatus = withDrawRatioStatus;
		this.withDrawRatioType = withDrawRatioType;
		this.workDayWithDrawRatio = workDayWithDrawRatio;
		this.holidayWithDrawRatio = holidayWithDrawRatio;
		this.effectiveTime = effectiveTime;
		this.expireTime = expireTime;
	}

	public WithdrawRatioResult(String ratioId, int withDrawRatioStatus, int withDrawRatioType, BigDecimal workDayWithDrawRatio,
			BigDecimal holidayWithDrawRatio) {
		super();
		this.ratioId = ratioId;
		this.withDrawRatioStatus = withDrawRatioStatus;
		this.withDrawRatioType = withDrawRatioType;
		this.workDayWithDrawRatio = workDayWithDrawRatio;
		this.holidayWithDrawRatio = holidayWithDrawRatio;
	}

	public WithdrawRatioResult() {
		super();
	}

	public String getRatioId() {
		return ratioId;
	}

	public void setRatioId(String ratioId) {
		this.ratioId = ratioId;
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

}
