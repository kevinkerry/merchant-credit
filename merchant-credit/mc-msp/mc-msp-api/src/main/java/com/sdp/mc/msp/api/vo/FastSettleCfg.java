package com.sdp.mc.msp.api.vo;


import java.io.Serializable;
import java.math.BigDecimal;

public class FastSettleCfg implements Serializable {
	
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
	 * //	代理商ID	
	 */
	private String promoterId;
	/**
	 * //	快速结算标示	
	 */
	private boolean fastSettleFlag;
	/**
	 * //	总金额	
	 */
	private BigDecimal credit;
	/**
	 * //	可用额度	
	 */
	private BigDecimal validCredit;
	/**
	 * //	手续费率
	 */
	private BigDecimal feeRate;	
	/**
	 * //	最低金额	
	 */
	private BigDecimal floorAmt;
	/**
	 * 返回码：默认00
            00-成功
            01-商户无权限或配置错误
            12-商户快速结算规则未配置或已失效,
            99-未知错误
	 */
	private String checkResultCode;		

	
	/**
	 * 访问成功标示
	 */
	private String code;
	
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
	

	public String getPromoterId() {
		return promoterId;
	}

	public void setPromoterId(String promoterId) {
		this.promoterId = promoterId;
	}

	public boolean isFastSettleFlag() {
		return fastSettleFlag;
	}

	public void setFastSettleFlag(boolean fastSettleFlag) {
		this.fastSettleFlag = fastSettleFlag;
	}

	public BigDecimal getCredit() {
		return credit;
	}

	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}

	public BigDecimal getValidCredit() {
		return validCredit;
	}

	public void setValidCredit(BigDecimal validCredit) {
		this.validCredit = validCredit;
	}

	public BigDecimal getFeeRate() {
		return feeRate;
	}

	public void setFeeRate(BigDecimal feeRate) {
		this.feeRate = feeRate;
	}

	public BigDecimal getFloorAmt() {
		return floorAmt;
	}

	public void setFloorAmt(BigDecimal floorAmt) {
		this.floorAmt = floorAmt;
	}

	public String getCheckResultCode() {
		return checkResultCode;
	}

	public void setCheckResultCode(String checkResultCode) {
		this.checkResultCode = checkResultCode;
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