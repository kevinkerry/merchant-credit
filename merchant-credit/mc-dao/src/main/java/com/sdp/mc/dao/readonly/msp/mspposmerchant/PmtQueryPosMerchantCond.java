package com.sdp.mc.dao.readonly.msp.mspposmerchant;

import com.sdp.mc.common.base.dao.BaseCond;


/**
 * 代理商查询POS商户，参数
 * @author liuxi.xiliu
 */
public class PmtQueryPosMerchantCond extends BaseCond{
	/**
	 * 商户名称
	 */
	private String merchantName;
	
	/**
	 * POS商户号
	 */
	private String posMerchantNo;
	
	/**
	 * 商户号
	 */
	private String merchantNo;
	
	/**
	 * 商户类型
	 */
	private String type;
	
	/**
	 * 商户状态
	 */
	private String status;
	
	/**
	 * mcc
	 */
	private String mcc;
	
	/**
	 * mcc名称
	 */
	private String msh$mcc;
	
	/**
	 * 省份id
	 */
	private String provinceId;
	
	/**
	 * 省份名称
	 */
	private String msh$provinceId;
	
	/**
	 * 城市id
	 */
	private String cityId;
	
	/**
	 * 城市名称
	 */
	private String msh$cityId;

	/**
	 * 绑定的操作员id
	 */
	private String pmtBindOperatorId;
	
	/**
	 * 操作员名称
	 */
	private String msh$pmtBindOperatorId;

	/**
	 * 代理商的会员id
	 */
	private String pmtMemberId;

	/**
	 * 代理商id
	 */
	private String pmtMerchantNo;
	private String pmtType;

	/**
	 * 推广员
	 */
	private String pmtPromoterName;
	
	/**
	 * 是否开启快速结算服务
	 */
	private String fastSettleFlag;
	
	/**
	 * 快速结算服务状态
	 */
	private String msh$fastSettleFlag;
	
	private Long promoterId;
	
	
	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getPosMerchantNo() {
		return posMerchantNo;
	}

	public void setPosMerchantNo(String posMerchantNo) {
		this.posMerchantNo = posMerchantNo;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMcc() {
		return mcc;
	}

	public void setMcc(String mcc) {
		this.mcc = mcc;
	}
	
	public String getMsh$mcc() {
		return msh$mcc;
	}

	public void setMsh$mcc(String msh$mcc) {
		this.msh$mcc = msh$mcc;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	
	public String getMsh$provinceId() {
		return msh$provinceId;
	}

	public void setMsh$provinceId(String msh$provinceId) {
		this.msh$provinceId = msh$provinceId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	
	public String getMsh$cityId() {
		return msh$cityId;
	}

	public void setMsh$cityId(String msh$cityId) {
		this.msh$cityId = msh$cityId;
	}

	public String getPmtBindOperatorId() {
		return pmtBindOperatorId;
	}

	public void setPmtBindOperatorId(String pmtBindOperatorId) {
		this.pmtBindOperatorId = pmtBindOperatorId;
	}
	
	public String getMsh$pmtBindOperatorId() {
		return msh$pmtBindOperatorId;
	}

	public void setMsh$pmtBindOperatorId(String msh$pmtBindOperatorId) {
		this.msh$pmtBindOperatorId = msh$pmtBindOperatorId;
	}

	public String getPmtMemberId() {
		return pmtMemberId;
	}

	public void setPmtMemberId(String pmtMemberId) {
		this.pmtMemberId = pmtMemberId;
	}

	public String getPmtMerchantNo() {
		return pmtMerchantNo;
	}

	public void setPmtMerchantNo(String pmtMerchantNo) {
		this.pmtMerchantNo = pmtMerchantNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPmtPromoterName() {
		return pmtPromoterName;
	}

	public void setPmtPromoterName(String pmtPromoterName) {
		this.pmtPromoterName = pmtPromoterName;
	}

	public String getFastSettleFlag() {
		return fastSettleFlag;
	}

	public void setFastSettleFlag(String fastSettleFlag) {
		this.fastSettleFlag = fastSettleFlag;
	}

	public String getMsh$fastSettleFlag() {
		return msh$fastSettleFlag;
	}

	public void setMsh$fastSettleFlag(String msh$fastSettleFlag) {
		this.msh$fastSettleFlag = msh$fastSettleFlag;
	}

	public String getPmtType() {
		return pmtType;
	}

	public void setPmtType(String pmtType) {
		this.pmtType = pmtType;
	}

	public Long getPromoterId() {
		return promoterId;
	}

	public void setPromoterId(Long promoterId) {
		this.promoterId = promoterId;
	}
	
	
	
}
