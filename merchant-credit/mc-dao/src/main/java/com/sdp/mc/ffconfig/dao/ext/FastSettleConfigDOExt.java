package com.sdp.mc.ffconfig.dao.ext;

import java.math.BigDecimal;

import com.sdp.mc.ffconfig.dao.FastSettleConfigDO;

public class FastSettleConfigDOExt extends FastSettleConfigDO {

	private static final long serialVersionUID = 1L;

	/**
	 * 商户表id
	 * **/
	private Long merchantId;
	/**
	 * 代理商id
	 * **/
	private Long promoterId;
	/**
	 * 商户名称
	 */
	private String mcMerchantName;
	/**
	 * 商户号
	 */
	private String mcMerchantNo;
	/**
	 * POS商户号
	 */
	private String posMerchantNo;

	/**
	 * 合同状态
	 */
	private String mcStatus;

	/**
	 * 合同类型(0001:POS商户,0005:miniPOS商户,0006:mPOS商户)
	 */
	private String mcType;

	/**
	 * 商户当日最高限额
	 */
	private BigDecimal limitAmount;

	/**
	 * 拓展方名称
	 */
	private String promoterName;
	/**
	 * 拓展方商户号
	 */
	private String promoterMerchantNo;
	/**
	 * 商户是否开通快速结算
	 */
	private String fast_settle_flag;
	/**
	 * 代理商是否开通快速结算
	 */
	private String pmt_fast_settle_flag;
	/**
	 * 代理商快速结算额度
	 */
	private String pmt_fast_settle_limit;
	/**
	 * 代理商快速结算保证金
	 */
	private String pmt_fast_settle_margin;
	/**
	 * 商户是否开通快速结算
	 */
	private String merchantFastSettleFlag;
	
	private String mcc;

	public String getFast_settle_flag() {
		return fast_settle_flag;
	}

	public String getMerchantFastSettleFlag() {
		return merchantFastSettleFlag;
	}

	public void setMerchantFastSettleFlag(String merchantFastSettleFlag) {
		this.merchantFastSettleFlag = merchantFastSettleFlag;
	}

	public void setFast_settle_flag(String fast_settle_flag) {
		this.fast_settle_flag = fast_settle_flag;
	}

	public String getPmt_fast_settle_flag() {
		return pmt_fast_settle_flag;
	}

	public void setPmt_fast_settle_flag(String pmt_fast_settle_flag) {
		this.pmt_fast_settle_flag = pmt_fast_settle_flag;
	}

	public String getPmt_fast_settle_limit() {
		return pmt_fast_settle_limit;
	}

	public void setPmt_fast_settle_limit(String pmt_fast_settle_limit) {
		this.pmt_fast_settle_limit = pmt_fast_settle_limit;
	}

	public String getPmt_fast_settle_margin() {
		return pmt_fast_settle_margin;
	}

	public void setPmt_fast_settle_margin(String pmt_fast_settle_margin) {
		this.pmt_fast_settle_margin = pmt_fast_settle_margin;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public Long getPromoterId() {
		return promoterId;
	}

	public void setPromoterId(Long promoterId) {
		this.promoterId = promoterId;
	}

	public String getMcMerchantName() {
		return mcMerchantName;
	}

	public void setMcMerchantName(String mcMerchantName) {
		this.mcMerchantName = mcMerchantName;
	}

	public String getMcMerchantNo() {
		return mcMerchantNo;
	}

	public void setMcMerchantNo(String mcMerchantNo) {
		this.mcMerchantNo = mcMerchantNo;
	}

	public String getPosMerchantNo() {
		return posMerchantNo;
	}

	public void setPosMerchantNo(String posMerchantNo) {
		this.posMerchantNo = posMerchantNo;
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

	public BigDecimal getLimitAmount() {
		return limitAmount;
	}

	public void setLimitAmount(BigDecimal limitAmount) {
		this.limitAmount = limitAmount;
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

	public String getMcc() {
		return mcc;
	}

	public void setMcc(String mcc) {
		this.mcc = mcc;
	}
	
}