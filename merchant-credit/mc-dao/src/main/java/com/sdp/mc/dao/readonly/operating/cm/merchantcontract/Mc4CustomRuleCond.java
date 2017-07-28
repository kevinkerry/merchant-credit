package com.sdp.mc.dao.readonly.operating.cm.merchantcontract;

import com.sdp.mc.common.base.dao.BaseCond;


public class Mc4CustomRuleCond extends BaseCond {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String merchantNo;

	private String mcType;
	
	private String status;

	
	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getMcType() {
		return mcType;
	}

	public void setMcType(String mcType) {
		this.mcType = mcType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
