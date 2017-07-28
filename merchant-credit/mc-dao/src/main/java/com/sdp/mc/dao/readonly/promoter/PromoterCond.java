package com.sdp.mc.dao.readonly.promoter;

import com.sdp.mc.common.base.dao.BaseCond;

/**
 * @author zhangguoliang.burt
 *	拓展商查询条件
 */
public class PromoterCond extends BaseCond {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 拓展商商户类型
	 */
	private String promoterType;
	
	/**
	 * 拓展商名称
	 */
	private String promoterName;
	
	/**
	 * 拓展商商户号
	 */
	private String promoterNo;
	
	/**
	 * 商务经理
	 */
	private String businessManager;
	
	/**
	 * 拓展商状态
	 */
	private String status;
	
	/**
	 * 省份Id
	 */
	private String provinceDistrictId;
	
	/**
	 * 城市Id
	 */
	private String cityDistrictId;
	
	private String countryId;
	
	/**
	 * 创建时间的起始
	 */
	private String createTimeStartStr;
	
	/**
	 * 创建时间的终止
	 */
	private String createTimeEndStr;
	/**
	 * 代理商开通快速结算标示
	 */
	private String pmtFastSettleFlag;
	/**
	 * 代理商垫资方类型
	 */
	private String loaningType;
	

	public String getPromoterType() {
		return promoterType;
	}

	public void setPromoterType(String promoterType) {
		this.promoterType = promoterType;
	}

	public String getPromoterName() {
		return promoterName;
	}

	public void setPromoterName(String promoterName) {
		this.promoterName = promoterName;
	}

	public String getPromoterNo() {
		return promoterNo;
	}

	public void setPromoterNo(String promoterNo) {
		this.promoterNo = promoterNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProvinceDistrictId() {
		return provinceDistrictId;
	}

	public void setProvinceDistrictId(String provinceDistrictId) {
		this.provinceDistrictId = provinceDistrictId;
	}

	public String getCityDistrictId() {
		return cityDistrictId;
	}

	public void setCityDistrictId(String cityDistrictId) {
		this.cityDistrictId = cityDistrictId;
	}

	public String getCreateTimeStartStr() {
		return createTimeStartStr;
	}

	public void setCreateTimeStartStr(String createTimeStartStr) {
		this.createTimeStartStr = createTimeStartStr;
	}

	public String getCreateTimeEndStr() {
		return createTimeEndStr;
	}

	public void setCreateTimeEndStr(String createTimeEndStr) {
		this.createTimeEndStr = createTimeEndStr;
	}

	public String getBusinessManager() {
		return businessManager;
	}

	public void setBusinessManager(String businessManager) {
		this.businessManager = businessManager;
	}
	
	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	
	

	public String getPmtFastSettleFlag() {
		return pmtFastSettleFlag;
	}

	public void setPmtFastSettleFlag(String pmtFastSettleFlag) {
		this.pmtFastSettleFlag = pmtFastSettleFlag;
	}

	public String getLoaningType() {
		return loaningType;
	}

	public void setLoaningType(String loaningType) {
		this.loaningType = loaningType;
	}

	public PromoterCond(){}
}
