package com.shengpay.debit.dal.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DoBorrowMoneyPO extends DoMerchantDebitOrderPO implements Serializable {
	/**
	 * 授信额度
	 */
	private BigDecimal totalAmount;
	/**
	 * 已用额度
	 */
	private BigDecimal usedAmount;
	/**
	 * 额度生效开始日期
	 */
	private Date effectiveStartTime;
	/**
	 * 额度生效结束日期
	 */
	private Date effectiveEndTime;
	/**
	 * 逾期天数
	 */
	private Integer overDueDays;
	/**
	 * 是否逾期
	 */
	private boolean isOverDue;

	/**
	 * 代理商承诺
	 */
	private String isAgnetGuarantee;

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getUsedAmount() {
		return usedAmount;
	}

	public void setUsedAmount(BigDecimal usedAmount) {
		this.usedAmount = usedAmount;
	}

	public Date getEffectiveStartTime() {
		return effectiveStartTime;
	}

	public void setEffectiveStartTime(Date effectiveStartTime) {
		this.effectiveStartTime = effectiveStartTime;
	}

	public Date getEffectiveEndTime() {
		return effectiveEndTime;
	}

	public void setEffectiveEndTime(Date effectiveEndTime) {
		this.effectiveEndTime = effectiveEndTime;
	}

	public Integer getOverDueDays() {
		return overDueDays;
	}

	public void setOverDueDays(Integer overDueDays) {
		this.overDueDays = overDueDays;
	}
	public boolean getIsOverDue() {
		return isOverDue;
	}
	public boolean isOverDue() {
		return isOverDue;
	}

	public void setOverDue(boolean isOverDue) {
		this.isOverDue = isOverDue;
	}

	public String isAgnetGuarantee() {
		return isAgnetGuarantee;
	}
	public String getIsAgnetGuarantee() {
		return isAgnetGuarantee;
	}
	public void setAgnetGuarantee(String isAgnetGuarantee) {
		this.isAgnetGuarantee = isAgnetGuarantee;
	}
}
