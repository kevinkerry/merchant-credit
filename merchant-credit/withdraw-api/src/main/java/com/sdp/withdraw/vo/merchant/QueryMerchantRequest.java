package com.sdp.withdraw.vo.merchant;

import java.io.Serializable;

public class QueryMerchantRequest implements Serializable {
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 3649337144144157859L;
	private Long mcId;
    private String merchantNo;
    private String merchantType;
    private String merchantName;
    private Integer fastSettleFlag;
    private Integer autoFastSettleFlag;
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
	public Integer getAutoFastSettleFlag() {
		return autoFastSettleFlag;
	}
	public void setAutoFastSettleFlag(Integer autoFastSettleFlag) {
		this.autoFastSettleFlag = autoFastSettleFlag;
	}
	
   
    
}