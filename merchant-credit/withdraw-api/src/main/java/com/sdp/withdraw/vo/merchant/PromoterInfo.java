package com.sdp.withdraw.vo.merchant;

import java.io.Serializable;
import java.math.BigDecimal;

public class PromoterInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2678616690073392837L;
	private Long mcId;
    private String merchantNo;
    private String merchantType;
    private String merchantName;
    private Integer fastSettleFlag;
    private Integer loaningType;
    private BigDecimal fastSettleLimit;
    private BigDecimal fastSettleMarginLimit;
	public Long getMcId() {
		return mcId;
	}
	public void setMcId(Long mcId) {
		this.mcId = mcId;
	}
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	public String getMerchantType() {
		return merchantType;
	}
	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public Integer getFastSettleFlag() {
		return fastSettleFlag;
	}
	public void setFastSettleFlag(Integer fastSettleFlag) {
		this.fastSettleFlag = fastSettleFlag;
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
	public BigDecimal getFastSettleMarginLimit() {
		return fastSettleMarginLimit;
	}
	public void setFastSettleMarginLimit(BigDecimal fastSettleMarginLimit) {
		this.fastSettleMarginLimit = fastSettleMarginLimit;
	}
    
    
    
}