package com.sdp.mc.integration.msp;

public class MerchantInfoDTO extends PromoterInfoDTO {

	private String merchantId;
	/** 可用额度 **/
	private String fastSettleLimit;
	
	/** 最小额度**/
	private String fastSettleMinLimit;
	
	/**
	 * 快速结算工作日费率
	 */
	private String fastSettleWorkdayFee;
	/**
	 * 快速结算节假日费率
	 */
	private String fastSettleHolidayFee;
	/**
	 * pos商户号
	 */
	private String posMerchantNo;
	/**
	 * 商户号
	 */
	private String merchantNo;
	private String mcc;
	private String mcTypeName;
	/**
	 * 0001：POS商户; 0006:mPOS商户
	 */
	private String mcType;
	/**
	 * 销售类型 0：分销 1：直销
	 */
	private String posmMposSalesType;
	private String posmRelyElecSignFlag;
	/**
	 * 终端数量
	 */
	private String terminalCount;
	
	/**
	 * 是否自动快速结算(0:否，1:是)
	 */
	private Integer autoFastSettle;
	
	
	/**
	 * 商户手机号
	 */
	private String merchantPhone;

	public String getFastSettleLimit() {
		return fastSettleLimit;
	}

	public void setFastSettleLimit(String fastSettleLimit) {
		this.fastSettleLimit = fastSettleLimit;
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

	public String getMcTypeName() {
		return mcTypeName;
	}

	public void setMcTypeName(String mcTypeName) {
		this.mcTypeName = mcTypeName;
	}

	public String getMcType() {
		return mcType;
	}

	public void setMcType(String mcType) {
		this.mcType = mcType;
	}

	public String getPosmMposSalesType() {
		return posmMposSalesType;
	}

	public void setPosmMposSalesType(String posmMposSalesType) {
		this.posmMposSalesType = posmMposSalesType;
	}

	public String getPosmRelyElecSignFlag() {
		return posmRelyElecSignFlag;
	}

	public void setPosmRelyElecSignFlag(String posmRelyElecSignFlag) {
		this.posmRelyElecSignFlag = posmRelyElecSignFlag;
	}

	public String getTerminalCount() {
		return terminalCount;
	}

	public void setTerminalCount(String terminalCount) {
		this.terminalCount = terminalCount;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getFastSettleWorkdayFee() {
		return fastSettleWorkdayFee;
	}

	public void setFastSettleWorkdayFee(String fastSettleWorkdayFee) {
		this.fastSettleWorkdayFee = fastSettleWorkdayFee;
	}

	public String getFastSettleHolidayFee() {
		return fastSettleHolidayFee;
	}

	public void setFastSettleHolidayFee(String fastSettleHolidayFee) {
		this.fastSettleHolidayFee = fastSettleHolidayFee;
	}

	public String getMcc() {
		return mcc;
	}

	public void setMcc(String mcc) {
		this.mcc = mcc;
	}

	public String getFastSettleMinLimit() {
		return fastSettleMinLimit;
	}

	public void setFastSettleMinLimit(String fastSettleMinLimit) {
		this.fastSettleMinLimit = fastSettleMinLimit;
	}

	public Integer getAutoFastSettle() {
		return autoFastSettle;
	}

	public void setAutoFastSettle(Integer autoFastSettle) {
		this.autoFastSettle = autoFastSettle;
	}


	public String getMerchantPhone() {
		return merchantPhone;
	}

	public void setMerchantPhone(String merchantPhone) {
		this.merchantPhone = merchantPhone;
	}
	

}
