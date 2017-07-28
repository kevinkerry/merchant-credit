package com.sdp.mc.service.msp.promoter;

import java.math.BigDecimal;

public class PromoterTO {
	/**
	 * 拓展方商户号
	 */
	private String promoterNo;
	/**
	 * 拓展商名称
	 */
	private String promoterName;
	
	/**
	 * 拓展商类型
	 */
	private String promoterType;
	
	/**
	 * 商务经理
	 */
	private String mcManager;
	
	/**
	 * 状态
	 */
	private String mcStatus;
	
	/**
	 * 拓展区域（城市）
	 */
	private String cityDistrictId;
	
	/**
	 * 限制行业
	 */
	private String limitedMcc;
	
	/**
	 * 创建时间
	 */
	private String createdTime;
	
	/**
	 * 拓展商Id
	 */
	public String promoterId;
	
	/**
	 * 应收保证金
	 */
	private BigDecimal depositmarginReceivable;
	
	/**
	 * 快速结算保证金
	 */
	private BigDecimal fastSettleMargin;
	/**
	 * 快速结算可配置额度
	 */
	private BigDecimal fastConfigureLimit;
	/**
	 * 快速结算额度
	 */
	private BigDecimal fastSettleLimit;
	
	/**
	 * 是否开启快速结算
	 */
	private Integer pmtFastSettleFlag;
	
	/**
	 * 快速结算额度比例
	 */
	private BigDecimal pmtFastSettleRatio;
	
	/**
	 * GET 快速结算额度比例
	 */
	public BigDecimal getPmtFastSettleRatio() {
		return pmtFastSettleRatio;
	}

	/**
	 * SET 快速结算额度比例
	 */
	public void setPmtFastSettleRatio(BigDecimal pmtFastSettleRatio) {
		this.pmtFastSettleRatio = pmtFastSettleRatio;
	}

	public Integer getPmtFastSettleFlag() {
		return pmtFastSettleFlag;
	}

	public void setPmtFastSettleFlag(Integer pmtFastSettleFlag) {
		this.pmtFastSettleFlag = pmtFastSettleFlag;
	}

	public BigDecimal getFastSettleMargin() {
		return fastSettleMargin;
	}

	public void setFastSettleMargin(BigDecimal fastSettleMargin) {
		this.fastSettleMargin = fastSettleMargin;
	}

	public BigDecimal getFastConfigureLimit() {
		return fastConfigureLimit;
	}

	public void setFastConfigureLimit(BigDecimal fastConfigureLimit) {
		this.fastConfigureLimit = fastConfigureLimit;
	}

	public BigDecimal getFastSettleLimit() {
		return fastSettleLimit;
	}

	public void setFastSettleLimit(BigDecimal fastSettleLimit) {
		this.fastSettleLimit = fastSettleLimit;
	}

	public String getPromoterId() {
		return promoterId;
	}

	public void setPromoterId(String promoterId) {
		this.promoterId = promoterId;
	}

	public BigDecimal getDepositmarginReceivable() {
		return depositmarginReceivable;
	}

	public void setDepositmarginReceivable(BigDecimal depositmarginReceivable) {
		this.depositmarginReceivable = depositmarginReceivable;
	}

	public String getPromoterNo() {
		return promoterNo;
	}
	public void setPromoterNo(String promoterNo) {
		this.promoterNo = promoterNo;
	}
	public String getPromoterName() {
		return promoterName;
	}
	public void setPromoterName(String promoterName) {
		this.promoterName = promoterName;
	}
	public String getPromoterType() {
		return promoterType;
	}
	public void setPromoterType(String promoterType) {
		this.promoterType = promoterType;
	}
	public String getMcManager() {
		return mcManager;
	}
	public void setMcManager(String mcManager) {
		this.mcManager = mcManager;
	}
	public String getMcStatus() {
		return mcStatus;
	}
	public void setMcStatus(String mcStatus) {
		this.mcStatus = mcStatus;
	}
	public String getCityDistrictId() {
		return cityDistrictId;
	}
	public void setCityDistrictId(String cityDistrictId) {
		this.cityDistrictId = cityDistrictId;
	}
	public String getLimitedMcc() {
		return limitedMcc;
	}
	public void setLimitedMcc(String limitedMcc) {
		this.limitedMcc = limitedMcc;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	
	
}
