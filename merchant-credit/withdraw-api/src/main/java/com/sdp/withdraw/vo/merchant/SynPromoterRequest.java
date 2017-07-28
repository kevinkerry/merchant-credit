package com.sdp.withdraw.vo.merchant;

import java.io.Serializable;
import java.util.Map;

public class SynPromoterRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2678616690073392837L;
	/**
	 * 代理商合同ID 必填
	 */
	private Long mcId;
	/**
	 * 代理商商户号 必填
	 */
    private String merchantNo;
    /**
     * 代理商类型 必填
     */
    private String merchantType;
    /**
     * 代理商名称 必填
     */
    private String merchantName;
    /**
     * 代理商状态 必填
     */
    private String status;
    /**
     * 代理商 级别 非必填
     */
    private String level;
    /**
     * 上一层代理商商户号  非必填
     */
    private String parentMerchantNo;
    /**
     * 上一层代理商商户号类型  非必填
     */
    private String parentMerchantType;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public SynPromoterRequest(Long mcId, String merchantNo, String merchantType, String merchantName, String status) {
		super();
		this.mcId = mcId;
		this.merchantNo = merchantNo;
		this.merchantType = merchantType;
		this.merchantName = merchantName;
		this.status = status;
	}
	public SynPromoterRequest() {
		super();
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getParentMerchantNo() {
		return parentMerchantNo;
	}
	public void setParentMerchantNo(String parentMerchantNo) {
		this.parentMerchantNo = parentMerchantNo;
	}
	public String getParentMerchantType() {
		return parentMerchantType;
	}
	public void setParentMerchantType(String parentMerchantType) {
		this.parentMerchantType = parentMerchantType;
	}
	public SynPromoterRequest(Long mcId, String merchantNo, String merchantType, String merchantName, String status, String level,
			String parentMerchantNo, String parentMerchantType) {
		super();
		this.mcId = mcId;
		this.merchantNo = merchantNo;
		this.merchantType = merchantType;
		this.merchantName = merchantName;
		this.status = status;
		this.level = level;
		this.parentMerchantNo = parentMerchantNo;
		this.parentMerchantType = parentMerchantType;
	}
	/**
	 * 扩展信息  
	 *     
	 */
	private Map<String,Map<String,String>> extendInfo;

	public Map<String, Map<String, String>> getExtendInfo() {
		return extendInfo;
	}
	public void setExtendInfo(Map<String, Map<String, String>> extendInfo) {
		this.extendInfo = extendInfo;
	}
	

	
    
    
    
    
}