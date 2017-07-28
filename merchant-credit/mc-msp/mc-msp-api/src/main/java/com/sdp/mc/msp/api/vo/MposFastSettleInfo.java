package com.sdp.mc.msp.api.vo;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MposFastSettleInfo implements Serializable {

	private static final long serialVersionUID = -8837630952608175191L;

	/**
	 * 商户号
	 */
	private String merchantNo;
	/**
	 * Pos商户号
	 */
	private String posMerchantNo;
	/**
	 * 是否开通快速结算
	 */
	private String fastSettleFlag;
	/**
	 * 是否自动快速结算
	 */
	private String autoFastSettleFlag;

	/**
	 * 快速结算申请最小限额
	 */
	private BigDecimal fastSettleMinLimit;

	/**
	 * 每日快速结算开始时间
	 */
	private String fastSettleStartTime;

	/**
	 * 每日快速结算结束时间
	 */
	private String fastSettleEndTIme;

	/**
	 * 访问成功标示
	 */
	private String code;
	/**
	 * 垫资方类型
	 */
	private String loaningType;
	public String getLoaningType() {
		return loaningType;
	}

	public void setLoaningType(String loaningType) {
		this.loaningType = loaningType;
	}

	/**
	 * 异常信息
	 */
	private String errorMsg;

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getPosMerchantNo() {
		return posMerchantNo;
	}

	public void setPosMerchantNo(String posMerchantNo) {
		this.posMerchantNo = posMerchantNo;
	}

	public String getFastSettleFlag() {
		return fastSettleFlag;
	}

	public void setFastSettleFlag(String fastSettleFlag) {
		this.fastSettleFlag = fastSettleFlag;
	}

	public String getAutoFastSettleFlag() {
		return autoFastSettleFlag;
	}

	public void setAutoFastSettleFlag(String autoFastSettleFlag) {
		this.autoFastSettleFlag = autoFastSettleFlag;
	}

	public BigDecimal getFastSettleMinLimit() {
		return fastSettleMinLimit;
	}

	public void setFastSettleMinLimit(BigDecimal fastSettleMinLimit) {
		this.fastSettleMinLimit = fastSettleMinLimit;
	}

	public String getFastSettleStartTime() {
		return fastSettleStartTime;
	}

	public void setFastSettleStartTime(String fastSettleStartTime) {
		this.fastSettleStartTime = fastSettleStartTime;
	}

	public String getFastSettleEndTIme() {
		return fastSettleEndTIme;
	}

	public void setFastSettleEndTIme(String fastSettleEndTIme) {
		this.fastSettleEndTIme = fastSettleEndTIme;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}





}