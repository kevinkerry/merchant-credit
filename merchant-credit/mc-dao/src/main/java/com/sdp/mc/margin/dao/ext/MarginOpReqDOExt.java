package com.sdp.mc.margin.dao.ext;

import com.sdp.mc.margin.dao.MarginOpReqDO;

public class MarginOpReqDOExt extends MarginOpReqDO {

	private static final long serialVersionUID = 1L;

	/**
	 * 代理商id
	 * **/
	private Long promoterId;
	/**
	 * 商户号
	 */
	private String mcMerchantNo;
	/**
	 * 商户号
	 */
	private String mcMerchantName;

	/**
	 * 代理商快速结算服务状态
	 */
	private Integer pStatus;

	/**
	 * 合同类型(0001:POS商户,0002:机具方,0003:拓展商)
	 */
	private String mcType;

	public Long getPromoterId() {
		return promoterId;
	}

	public void setPromoterId(Long promoterId) {
		this.promoterId = promoterId;
	}

	public String getMcMerchantNo() {
		return mcMerchantNo;
	}

	public void setMcMerchantNo(String mcMerchantNo) {
		this.mcMerchantNo = mcMerchantNo;
	}

	public String getMcMerchantName() {
		return mcMerchantName;
	}

	public void setMcMerchantName(String mcMerchantName) {
		this.mcMerchantName = mcMerchantName;
	}

	public Integer getpStatus() {
		return pStatus;
	}

	public void setpStatus(Integer pStatus) {
		this.pStatus = pStatus;
	}

	public String getMcType() {
		return mcType;
	}

	public void setMcType(String mcType) {
		this.mcType = mcType;
	}
}
