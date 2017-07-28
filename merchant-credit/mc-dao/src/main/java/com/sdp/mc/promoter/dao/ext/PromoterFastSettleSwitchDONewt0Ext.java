package com.sdp.mc.promoter.dao.ext;

import java.math.BigDecimal;

import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDO;

public class PromoterFastSettleSwitchDONewt0Ext extends PromoterFastSettleSwitchDO {
	private static final long serialVersionUID = 1L;
	/**
	 * 商户ID
	 */
	private Long mcMerchantId;
	/**
	 * 商户号
	 */
	private String mcMerchantNo;
	/**
	 * 商户名称
	 */
	private String mcMerchantName;

	/**
	 * 代理商名称
	 * **/
	private String promoterName;
	/**
	 * msp系统快速结算状态(1:允许快速结算    0:不允许快速结算)
	 * **/
	private Integer mspFastSettleFlag;
	/**
	 * 合同状态
	 */
	private String mcStatus;

	/**
	 * 合同类型(0003:POS商户,0007:mPOS拓展商)
	 */
	private String mcType;

	/**
	 * 商户电话
	 */
	private String merchantPhone;
	/**
	 * 垫资方
	 */
	private Integer loaningType;
	
	/**
	 * 快速结算额度
	 */
	public BigDecimal fastSettleLimit;

	/**
	 * 审核：1存在待审核或者审核中纪录
	 */
	public Integer auditStatus;
	
	public String getMcMerchantNo() {
		return mcMerchantNo;
	}

	public void setMcMerchantNo(String mcMerchantNo) {
		this.mcMerchantNo = mcMerchantNo;
	}

	public String getMcStatus() {
		return mcStatus;
	}

	public void setMcStatus(String mcStatus) {
		this.mcStatus = mcStatus;
	}

	public String getMcType() {
		return mcType;
	}

	public void setMcType(String mcType) {
		this.mcType = mcType;
	}

	public String getMcMerchantName() {
		return mcMerchantName;
	}

	public void setMcMerchantName(String mcMerchantName) {
		this.mcMerchantName = mcMerchantName;
	}

	public String getPromoterName() {
		return promoterName;
	}

	public void setPromoterName(String promoterName) {
		this.promoterName = promoterName;
	}

	public Integer getMspFastSettleFlag() {
		return mspFastSettleFlag;
	}

	public void setMspFastSettleFlag(Integer mspFastSettleFlag) {
		this.mspFastSettleFlag = mspFastSettleFlag;
	}



	public String getMerchantPhone() {
		return merchantPhone;
	}

	public void setMerchantPhone(String merchantPhone) {
		this.merchantPhone = merchantPhone;
	}

	public Long getMcMerchantId() {
		return mcMerchantId;
	}

	public void setMcMerchantId(Long mcMerchantId) {
		this.mcMerchantId = mcMerchantId;
	}

	public Integer getLoaningType() {
		return loaningType;
	}

	public void setLoaningType(Integer loaningType) {
		this.loaningType = loaningType;
	}

	public BigDecimal getFastSettleLimit() {
		return fastSettleLimit;
	}

	public void setFastSettleLimit(BigDecimal fastSettleLimit) {
		this.fastSettleLimit = fastSettleLimit;
	}

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

}
