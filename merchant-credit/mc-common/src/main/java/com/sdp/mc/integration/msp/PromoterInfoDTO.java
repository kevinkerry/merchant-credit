package com.sdp.mc.integration.msp;

public class PromoterInfoDTO extends MspBaseDTO {
	/** msp系统代理商id **/
	private long promoterId;
	/** 代理商-商户号 **/
	private String promoterNo;
	/**
	 * 类型 '0003' 普通POS商户 '0007' mPOS商户
	 */
	private String promoterType;
	private String businessManager;
	/** 保证金金额 **/
	private String fastSettleMargin;
	/** (代理商当日总额度)可用额度 **/
	private String fastSettleLimit;
	/** 可配置额度 **/
	private String fastConfigureLimit;
	/**
	 * 快速结算比例额度
	 */
	private String fastSettleRatio;

	/**
	 * 代理商剩余可配置额度
	 */
	private String remainConfigureLimit;
	/**
	 * 剩余可用额度 - 调用交易接口获得--实际剩余额度
	 */
	private String validCredit;

	/**
	 * 垫资方
	 */
	private Integer loaningType;
	
	private Integer pmtLevel;

	public String getRemainConfigureLimit() {
		return remainConfigureLimit;
	}

	public void setRemainConfigureLimit(String remainConfigureLimit) {
		this.remainConfigureLimit = remainConfigureLimit;
	}

	public String getValidCredit() {
		return validCredit;
	}

	public void setValidCredit(String validCredit) {
		this.validCredit = validCredit;
	}

	public String getPromoterType() {
		return promoterType;
	}

	public void setPromoterType(String promoterType) {
		this.promoterType = promoterType;
	}

	public String getPromoterNo() {
		return promoterNo;
	}

	public void setPromoterNo(String promoterNo) {
		this.promoterNo = promoterNo;
	}

	public long getPromoterId() {
		return promoterId;
	}

	public void setPromoterId(long promoterId) {
		this.promoterId = promoterId;
	}

	public String getFastSettleMargin() {
		return fastSettleMargin;
	}

	public void setFastSettleMargin(String fastSettleMargin) {
		this.fastSettleMargin = fastSettleMargin;
	}

	public String getFastSettleLimit() {
		return fastSettleLimit;
	}

	public void setFastSettleLimit(String fastSettleLimit) {
		this.fastSettleLimit = fastSettleLimit;
	}

	public String getFastConfigureLimit() {
		return fastConfigureLimit;
	}

	public void setFastConfigureLimit(String fastConfigureLimit) {
		this.fastConfigureLimit = fastConfigureLimit;
	}

	public String getFastSettleRatio() {
		return fastSettleRatio;
	}

	public void setFastSettleRatio(String fastSettleRatio) {
		this.fastSettleRatio = fastSettleRatio;
	}

	public String getBusinessManager() {
		return businessManager;
	}

	public void setBusinessManager(String businessManager) {
		this.businessManager = businessManager;
	}

	public Integer getLoaningType() {
		return loaningType;
	}

	public void setLoaningType(Integer loaningType) {
		this.loaningType = loaningType;
	}
	
	

	public Integer getPmtLevel() {
		return pmtLevel;
	}

	public void setPmtLevel(Integer pmtLevel) {
		this.pmtLevel = pmtLevel;
	}

	@Override
	public String toString() {
		return "PromoterInfoDTO [promoterId=" + promoterId + ", promoterNo=" + promoterNo + ", promoterType=" + promoterType + ", businessManager=" + businessManager + ", fastSettleMargin="
				+ fastSettleMargin + ", fastSettleLimit=" + fastSettleLimit + ", fastConfigureLimit=" + fastConfigureLimit + ", fastSettleRatio=" + fastSettleRatio + ", remainConfigureLimit="
				+ remainConfigureLimit + ", validCredit=" + validCredit + ", loaningType=" + loaningType + "]";
	}

}
