package com.sdp.withdraw.vo.merchant;

import java.io.Serializable;
import java.util.Map;

public class SynMerchantRequest implements Serializable {
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 3649337144144157859L;
	/**
	 * 合同ID 非必填
	 */
	private Long mcId;
	/**
	 *  商户号 必填
	 */
    private String merchantNo;
    /**
     * 商户类型 必填
     */
    private String merchantType;
    /**
     * 商户名称 必填
     */
    private String merchantName;
    /**
     * 商户状态 必填
     */
    private String status;
    /**
     * 行业编码  必填
     */
    private String mcc;
    /**
     * 一级代理商ID 必填
     */
    private Long promoterId;
    
    /**
     * 最后一级代理商类型 非必填
     */
    private String lastLevelPromoterType;
    /**
     * 最后一级代理商商户号非 必填
     */
    private String lastLevelPromoterNo;
    
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
	public Long getPromoterId() {
		return promoterId;
	}
	public void setPromoterId(Long promoterId) {
		this.promoterId = promoterId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public SynMerchantRequest(Long mcId, String merchantNo,  String merchantType, String merchantName, String status,
			Long promoterId) {
		super();
		this.mcId = mcId;
		this.merchantNo = merchantNo;
		this.merchantType = merchantType;
		this.merchantName = merchantName;
		this.status = status;
		this.promoterId = promoterId;
	}
	public SynMerchantRequest() {
		super();
	}
	public String getMcc() {
		return mcc;
	}
	public void setMcc(String mcc) {
		this.mcc = mcc;
	}
	public String getLastLevelPromoterNo() {
		return lastLevelPromoterNo;
	}
	public void setLastLevelPromoterNo(String lastLevelPromoterNo) {
		this.lastLevelPromoterNo = lastLevelPromoterNo;
	}
	public String getLastLevelPromoterType() {
		return lastLevelPromoterType;
	}
	public void setLastLevelPromoterType(String lastLevelPromoterType) {
		this.lastLevelPromoterType = lastLevelPromoterType;
	}
	public SynMerchantRequest(Long mcId, String merchantNo, String merchantType, String merchantName, String status, String mcc, Long promoterId,
			String lastLevelPromoterType, String lastLevelPromoterNo) {
		super();
		this.mcId = mcId;
		this.merchantNo = merchantNo;
		this.merchantType = merchantType;
		this.merchantName = merchantName;
		this.status = status;
		this.mcc = mcc;
		this.promoterId = promoterId;
		this.lastLevelPromoterType = lastLevelPromoterType;
		this.lastLevelPromoterNo = lastLevelPromoterNo;
	}
	/**
	 * 扩展信息  key :creditAuthentication 信用认证 map ：key，creditCTFCount 信用认证卡的数量
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