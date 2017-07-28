package com.sdp.mc.common.vo;

public class MerchantFastSettleVO {

	/**
	 * 商户号
	 */
	private String merchantId;
	/**
	 * 快速结算标志
	 */
	private String fastSettleFlag;
	/**
	 * 快速结算额度
	 */
	private String fastSettleLimit;
	/**
	 * 工作日费率
	 */
	private String workdayFee;
	/**
	 * 非工作日费率
	 */
	private String holidayFee;

	/**
	 * 申请快速结算订单号
	 */
	private String txnOrderNos;
	/**
	 * pos 商户号
	 */
	private String posMerchantNo;

	/**
	 * 结算费率
	 */
	private String feeRate;
	/**
	 * 自动结算
	 */
	private String autoFastSettle;

	/**
	 * 商户手机
	 * @return
	 */
	private String merchantPhone;

	/**
	 * 垫资类型
	 * @return
	 */
	private String objType;
	/**
	 * 代理商号
	 */
	private String promoterId;
	/**
	 * 商户类型
	 */
	private String mcType;
	
	private String promoterType;
	
	/**
	 * 商户号
	 */
	private String merchantNo;
	
	private Integer loaningType;

	public String getPromoterId() {
		return promoterId;
	}

	public void setPromoterId(String promoterId) {
		this.promoterId = promoterId;
	}

	public String getTxnOrderNos() {
		return txnOrderNos;
	}

	public void setTxnOrderNos(String txnOrderNos) {
		this.txnOrderNos = txnOrderNos;
	}

	public String getPosMerchantNo() {
		return posMerchantNo;
	}

	public void setPosMerchantNo(String posMerchantNo) {
		this.posMerchantNo = posMerchantNo;
	}

	public String getFeeRate() {
		return feeRate;
	}

	public void setFeeRate(String feeRate) {
		this.feeRate = feeRate;
	}


	public String getAutoFastSettle() {
		return autoFastSettle;
	}

	public void setAutoFastSettle(String autoFastSettle) {
		this.autoFastSettle = autoFastSettle;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getFastSettleFlag() {
		return fastSettleFlag;
	}

	public void setFastSettleFlag(String fastSettleFlag) {
		this.fastSettleFlag = fastSettleFlag;
	}

	public String getFastSettleLimit() {
		return fastSettleLimit;
	}

	public void setFastSettleLimit(String fastSettleLimit) {
		this.fastSettleLimit = fastSettleLimit;
	}

	public String getWorkdayFee() {
		return workdayFee;
	}

	public void setWorkdayFee(String workdayFee) {
		this.workdayFee = workdayFee;
	}

	public String getHolidayFee() {
		return holidayFee;
	}

	public void setHolidayFee(String holidayFee) {
		this.holidayFee = holidayFee;
	}

	public String getMerchantPhone() {
		return merchantPhone;
	}

	public void setMerchantPhone(String merchantPhone) {
		this.merchantPhone = merchantPhone;
	}


	public String getObjType() {
		return objType;
	}

	public void setObjType(String objType) {
		this.objType = objType;
	}

	public String getMcType() {
		return mcType;
	}

	public void setMcType(String mcType) {
		this.mcType = mcType;
	}
	
	

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	
	
	
	

	public Integer getLoaningType() {
		return loaningType;
	}

	public void setLoaningType(Integer loaningType) {
		this.loaningType = loaningType;
	}

	public MerchantFastSettleVO(String merchantId, String fastSettleFlag, String fastSettleLimit, String workdayFee, String holidayFee,
			String autoFastSettle, String merchantPhone, String mcType, String merchantNo) {
		super();
		this.merchantId = merchantId;
		this.fastSettleFlag = fastSettleFlag;
		this.fastSettleLimit = fastSettleLimit;
		this.workdayFee = workdayFee;
		this.holidayFee = holidayFee;
		this.autoFastSettle = autoFastSettle;
		this.merchantPhone = merchantPhone;
		this.mcType = mcType;
		this.merchantNo = merchantNo;
	}
	

	public MerchantFastSettleVO() {
		super();
	}
	

	public String getPromoterType() {
		return promoterType;
	}

	public void setPromoterType(String promoterType) {
		this.promoterType = promoterType;
	}

	@Override
	public String toString() {
		return "MerchantFastSettleVO [merchantId=" + merchantId + ", fastSettleFlag=" + fastSettleFlag + ", fastSettleLimit=" + fastSettleLimit
				+ ", workdayFee=" + workdayFee + ", holidayFee=" + holidayFee + ", txnOrderNos=" + txnOrderNos + ", posMerchantNo=" + posMerchantNo
				+ ", feeRate=" + feeRate + ", autoFastSettle=" + autoFastSettle + ", merchantPhone=" + merchantPhone + ", objType=" + objType
				+ ", promoterId=" + promoterId + ", mcType=" + mcType + ", promoterType=" + promoterType + ", merchantNo=" + merchantNo
				+ ", loaningType=" + loaningType + "]";
	}

}
