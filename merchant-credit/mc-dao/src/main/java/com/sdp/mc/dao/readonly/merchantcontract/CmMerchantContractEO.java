package com.sdp.mc.dao.readonly.merchantcontract;

import java.util.Date;

/**
 * 商户抽象合同信息（MC）实体对象
 * @author liuxi.xiliu
 */
public class CmMerchantContractEO {
	/**
	 * 账号(邮箱或手机号)
	 */
	protected String mcLoginAccount;

	/**
	 * 注册账号类型(1:邮箱，2:手机号)
	 */
	protected Long mcRegType;

	/**
	 * 证件类型(1:营业执照/身份证 2:户口本 3:护照 4：军官证 5:回乡证。默认传：1)
	 */
	protected Long mcCertiType;

	/**
	 * 证件编码
	 */
	protected String mcCertiValue;

	/**
	 * 合同开始时间
	 */
	protected Date mcContractBeginDate;

	/**
	 * 合同结束时间
	 */
	protected Date mcContractEndDate;

	/**
	 * 合同实际结束时间
	 */
	protected Date mcContractRealEndDate;

	/**
	 * 商户合同主键
	 */
	protected Long mcId;

	/**
	 * 商户号
	 */
	protected String mcMerchantNo;

	/**
	 * 合同号
	 */
	protected String mcContractNo;

	/**
	 * 合同状态
	 */
	protected String mcStatus;

	/**
	 * 合同类型(0001:POS商户,0002:机具方,0003:拓展商)
	 */
	protected String mcType;

	/**
	 * 版本号
	 */
	protected Long mcVersion;

	/**
	 * 创建时间
	 */
	protected Date mcCreateTime;

	/**
	 * 最后修改时间
	 */
	protected Date mcLastUpdateTime;

	/**
	 * 商户名称
	 */
	protected String mcMerchantName;

	public String getMcLoginAccount() {
		return mcLoginAccount;
	}

	public void setMcLoginAccount(String mcLoginAccount) {
		this.mcLoginAccount = mcLoginAccount;
	}

	public Long getMcRegType() {
		return mcRegType;
	}

	public void setMcRegType(Long mcRegType) {
		this.mcRegType = mcRegType;
	}

	public Long getMcCertiType() {
		return mcCertiType;
	}

	public void setMcCertiType(Long mcCertiType) {
		this.mcCertiType = mcCertiType;
	}

	public String getMcCertiValue() {
		return mcCertiValue;
	}

	public void setMcCertiValue(String mcCertiValue) {
		this.mcCertiValue = mcCertiValue;
	}

	public Date getMcContractBeginDate() {
		return mcContractBeginDate;
	}

	public void setMcContractBeginDate(Date mcContractBeginDate) {
		this.mcContractBeginDate = mcContractBeginDate;
	}

	public Date getMcContractEndDate() {
		return mcContractEndDate;
	}

	public void setMcContractEndDate(Date mcContractEndDate) {
		this.mcContractEndDate = mcContractEndDate;
	}

	public Date getMcContractRealEndDate() {
		return mcContractRealEndDate;
	}

	public void setMcContractRealEndDate(Date mcContractRealEndDate) {
		this.mcContractRealEndDate = mcContractRealEndDate;
	}

	public Long getMcId() {
		return mcId;
	}

	public void setMcId(Long mcId) {
		this.mcId = mcId;
	}

	public String getMcMerchantNo() {
		return mcMerchantNo;
	}

	public void setMcMerchantNo(String mcMerchantNo) {
		this.mcMerchantNo = mcMerchantNo;
	}

	public String getMcContractNo() {
		return mcContractNo;
	}

	public void setMcContractNo(String mcContractNo) {
		this.mcContractNo = mcContractNo;
	}

	public String getMcStatus() {
		return mcStatus;
	}

	public void setMcStatus(String mcStatus) {
		this.mcStatus = mcStatus;
	}

	public String getMcType() {
		return mcType;
	}

	public void setMcType(String mcType) {
		this.mcType = mcType;
	}

	public Long getMcVersion() {
		return mcVersion;
	}

	public void setMcVersion(Long mcVersion) {
		this.mcVersion = mcVersion;
	}

	public Date getMcCreateTime() {
		return mcCreateTime;
	}

	public void setMcCreateTime(Date mcCreateTime) {
		this.mcCreateTime = mcCreateTime;
	}

	public Date getMcLastUpdateTime() {
		return mcLastUpdateTime;
	}

	public void setMcLastUpdateTime(Date mcLastUpdateTime) {
		this.mcLastUpdateTime = mcLastUpdateTime;
	}

	public String getMcMerchantName() {
		return mcMerchantName;
	}

	public void setMcMerchantName(String mcMerchantName) {
		this.mcMerchantName = mcMerchantName;
	}
}