package com.sdp.withdraw.vo.merchant;

import java.io.Serializable;

public class QueryPromoterRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2678616690073392837L;
	private Long mcId;
    private String merchantNo;
    private String merchantType;
    private String merchantName;
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
    
}