package com.sdp.mc.integration.ma.dto;

public class Promoter4MADTO {

	// 代理商商户号
	private String merchantNo;
	// 代理商商户对应的会员id
	private String memberId;
	// 默认操作员id
	private String defaultOperatorId;
	
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getDefaultOperatorId() {
		return defaultOperatorId;
	}
	public void setDefaultOperatorId(String defaultOperatorId) {
		this.defaultOperatorId = defaultOperatorId;
	}
}
