package com.sdp.mc.dao.readonly.promoter;


public class PromoterEO extends PromoterEOAbstract {

	/**
	 * 业务层通用开户记录表id
	 * **/
	private Long applyOpenAccountId;
	/**
	 * 业务层通用开户记录表状态
	 * **/
	private Integer applyOpenAccountStatus;
	/**
	 * 垫资方
	 */
	private Integer loaningType;
	/**
	 * 商户号
	 */
	private String merchantNo;

	private String pmtParentMerchantNo;
	
	private Integer pmtLevel;
	
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	public Long getApplyOpenAccountId() {
		return applyOpenAccountId;
	}
	public void setApplyOpenAccountId(Long applyOpenAccountId) {
		this.applyOpenAccountId = applyOpenAccountId;
	}
	public Integer getApplyOpenAccountStatus() {
		return applyOpenAccountStatus;
	}
	public void setApplyOpenAccountStatus(Integer applyOpenAccountStatus) {
		this.applyOpenAccountStatus = applyOpenAccountStatus;
	}
	public Integer getLoaningType() {
		return loaningType;
	}
	public void setLoaningType(Integer loaningType) {
		this.loaningType = loaningType;
	}
	public String getPmtParentMerchantNo() {
		return pmtParentMerchantNo;
	}
	public void setPmtParentMerchantNo(String pmtParentMerchantNo) {
		this.pmtParentMerchantNo = pmtParentMerchantNo;
	}
	public Integer getPmtLevel() {
		return pmtLevel;
	}
	public void setPmtLevel(Integer pmtLevel) {
		this.pmtLevel = pmtLevel;
	}
	
}
