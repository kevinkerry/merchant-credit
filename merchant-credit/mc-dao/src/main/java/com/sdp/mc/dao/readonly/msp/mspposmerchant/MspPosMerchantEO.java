package com.sdp.mc.dao.readonly.msp.mspposmerchant;

import java.math.BigDecimal;


/**
 * (msp)POS商户表
 * @author liuxi.xiliu
 */
public class MspPosMerchantEO {
	/**
	 * id
	 */
	private Long id;
	
	/**
	 * pos商户的盛付通商户号
	 */
	private String merchantNo;
	
	/**
	 * 商户名称
	 */
	private String merchantName;

	/**
	 * POS商户号
	 */
	private String posMerchantNo;
	
	/**
	 * pos商户的类型
	 */
	private String type;
	
	/**
	 * 商户状态
	 */
	private String status;
	
	/**
	 * 会员id
	 */
	private String memberId;
	
	/**
	 * mcc
	 */
	private String mcc;
	
	/**
	 * 行业名称
	 */
	private String mccName;
	
	/**
	 * 省份id
	 */
	private Long provinceId;
	
	/**
	 * 省份名称
	 */
	private String provinceName;
	
	/**
	 * 城市id
	 */
	private Long cityId;
	
	/**
	 * 城市名称
	 */
	private String cityName;
	
	/**
	 * 地址
	 */
	private String address;
	
	/**
	 * 代理商商户号
	 */
	private String pmtMerchantNo;
	
	/**
	 * 代理商名称 
	 */
	private String pmtMerchantName;

	/**
	 * 代理商商户类型
	 */
	private String pmtType;
	
	/**
	 * 代理商会员id
	 */
	private String pmtMemberId;
	
	/**
	 * 绑定的(代理商的)操作员id
	 */
	private String pmtBindOperatorId;
	
	/**
	 * 绑定的(代理商的)操作员名称
	 */
	private String pmtBindOperatorName;
	
	/**
	 * 版本
	 */
	private String version;
	
	/**
	 * 创建时间
	 */
	private String createTime;
	
	/**
	 * 最后更新时间
	 */
	private String lastUpdateTime;

	/**
	 * 推广员名称
	 */
	private String pmtPromoterName;
	
	/**
	 * 是否开启快速结算服务
	 */
	private Boolean fastSettleFlag;
	
	/**
	 * 快速结算服务单日最高额度
	 */
	private BigDecimal fastSettleLimit;
	
	/**
	 * 商户分组标识
	 */
	private String groupTag;
	
	/**
	 * 商户别名
	 */
	private String aliasName;
	
	/**
	 * 工作日费率
	 * **/
	private BigDecimal workdayFee;
	/**
	 * 非工作日费率
	 * **/
	private BigDecimal holidayFee;
	
	/**
	 * 是否开通自动快速结算
	 */
	private Integer autoFastSettleFlag;
	
	/**
	 * 是否开启快速结算服务(上面有个boolean，感觉不对)
	 */
	private Integer newFastSettleFlag;
	
	/**
	 * 最低额度限制
	 */
	private BigDecimal fastSettleMinLimit;
	
	/**
	 * 商户手机号
	 */
	private String handPhoneNo;
	
	private String lastLevelPromoterNo;
	
	/**
	 * 是否开启快速结算服务(上面有个boolean，感觉不对)
	 */
	private Integer certType;
	
	private String certNo;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getPosMerchantNo() {
		return posMerchantNo;
	}

	public void setPosMerchantNo(String posMerchantNo) {
		this.posMerchantNo = posMerchantNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMcc() {
		return mcc;
	}

	public void setMcc(String mcc) {
		this.mcc = mcc;
	}

	public String getMccName() {
		return mccName;
	}

	public void setMccName(String mccName) {
		this.mccName = mccName;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPmtMerchantNo() {
		return pmtMerchantNo;
	}

	public void setPmtMerchantNo(String pmtMerchantNo) {
		this.pmtMerchantNo = pmtMerchantNo;
	}

	public String getPmtMerchantName() {
		return pmtMerchantName;
	}

	public void setPmtMerchantName(String pmtMerchantName) {
		this.pmtMerchantName = pmtMerchantName;
	}

	public String getPmtType() {
		return pmtType;
	}

	public void setPmtType(String pmtType) {
		this.pmtType = pmtType;
	}

	public String getPmtMemberId() {
		return pmtMemberId;
	}

	public void setPmtMemberId(String pmtMemberId) {
		this.pmtMemberId = pmtMemberId;
	}

	public String getPmtBindOperatorId() {
		return pmtBindOperatorId;
	}

	public void setPmtBindOperatorId(String pmtBindOperatorId) {
		this.pmtBindOperatorId = pmtBindOperatorId;
	}

	public String getPmtBindOperatorName() {
		return pmtBindOperatorName;
	}

	public void setPmtBindOperatorName(String pmtBindOperatorName) {
		this.pmtBindOperatorName = pmtBindOperatorName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getPmtPromoterName() {
		return pmtPromoterName;
	}

	public void setPmtPromoterName(String pmtPromoterName) {
		this.pmtPromoterName = pmtPromoterName;
	}

	public Boolean getFastSettleFlag() {
		return fastSettleFlag;
	}

	public void setFastSettleFlag(Boolean fastSettleFlag) {
		this.fastSettleFlag = fastSettleFlag;
	}

	public BigDecimal getFastSettleLimit() {
		return fastSettleLimit;
	}

	public void setFastSettleLimit(BigDecimal fastSettleLimit) {
		this.fastSettleLimit = fastSettleLimit;
	}

	public String getGroupTag() {
		return groupTag;
	}

	public void setGroupTag(String groupTag) {
		this.groupTag = groupTag;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public BigDecimal getWorkdayFee() {
		return workdayFee;
	}

	public void setWorkdayFee(BigDecimal workdayFee) {
		this.workdayFee = workdayFee;
	}

	public BigDecimal getHolidayFee() {
		return holidayFee;
	}

	public void setHolidayFee(BigDecimal holidayFee) {
		this.holidayFee = holidayFee;
	}

	public Integer getAutoFastSettleFlag() {
		return autoFastSettleFlag;
	}

	public void setAutoFastSettleFlag(Integer autoFastSettleFlag) {
		this.autoFastSettleFlag = autoFastSettleFlag;
	}

	public Integer getNewFastSettleFlag() {
		return newFastSettleFlag;
	}

	public void setNewFastSettleFlag(Integer newFastSettleFlag) {
		this.newFastSettleFlag = newFastSettleFlag;
	}

	public BigDecimal getFastSettleMinLimit() {
		return fastSettleMinLimit;
	}

	public void setFastSettleMinLimit(BigDecimal fastSettleMinLimit) {
		this.fastSettleMinLimit = fastSettleMinLimit;
	}

	public String getHandPhoneNo() {
		return handPhoneNo;
	}

	public void setHandPhoneNo(String handPhoneNo) {
		this.handPhoneNo = handPhoneNo;
	}

	public String getLastLevelPromoterNo() {
		return lastLevelPromoterNo;
	}

	public void setLastLevelPromoterNo(String lastLevelPromoterNo) {
		this.lastLevelPromoterNo = lastLevelPromoterNo;
	}

	public Integer getCertType() {
		return certType;
	}

	public void setCertType(Integer certType) {
		this.certType = certType;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	
	
}
