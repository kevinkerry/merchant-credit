package com.sdp.withdraw.vo.merchant;

import java.io.Serializable;
import java.math.BigDecimal;

public class MerchantInfo implements Serializable {
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 3649337144144157859L;
	private Long mcId;
    private String merchantNo;
    private String merchantType;
    private String merchantName;
    private Integer fastSettleFlag;
    private BigDecimal fastSettleLimit;
    private BigDecimal fastSettleMinLimit;
    private String phone;
    private Integer autoFastSettleFlag;
    private Long promoterId;
	
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
	public BigDecimal getFastSettleLimit() {
		return fastSettleLimit;
	}
	public void setFastSettleLimit(BigDecimal fastSettleLimit) {
		this.fastSettleLimit = fastSettleLimit;
	}
	public BigDecimal getFastSettleMinLimit() {
		return fastSettleMinLimit;
	}
	public void setFastSettleMinLimit(BigDecimal fastSettleMinLimit) {
		this.fastSettleMinLimit = fastSettleMinLimit;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getAutoFastSettleFlag() {
		return autoFastSettleFlag;
	}
	public void setAutoFastSettleFlag(Integer autoFastSettleFlag) {
		this.autoFastSettleFlag = autoFastSettleFlag;
	}
	public Long getPromoterId() {
		return promoterId;
	}
	public void setPromoterId(Long promoterId) {
		this.promoterId = promoterId;
	}
   
    
}