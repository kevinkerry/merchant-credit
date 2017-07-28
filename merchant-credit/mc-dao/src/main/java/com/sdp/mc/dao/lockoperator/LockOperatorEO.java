package com.sdp.mc.dao.lockoperator;

import java.util.Date;

/**
 * 锁定操作员
 * @author liuxi.xiliu
 */
public class LockOperatorEO {
	/**
	 * id
	 */
	private Long id;
	
	/**
	 * 操作员id
	 */
	private String operatorId;
	
	/**
	 * 操作员名称
	 */
	private String operatorName;
	
	/**
	 * 商户号
	 */
	private String merchantNo;
	
	/**
	 * 商户名称
	 */
	private String merchantType;
	
	/**
	 * 锁定状态
	 */
	private Integer lockStatus;
	
	/**
	 * 客户端ip
	 */
	private String clientIp;

	/**
	 * 说定说明
	 */
	private String lockMemo;
	
	/**
	 * 锁定时间
	 */
	private Date lockTime;
	
	/**
	 * 版本
	 */
	private Long version;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 最后更新时间
	 */
	private Date lastUpdateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
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

	public Integer getLockStatus() {
		return lockStatus;
	}

	public void setLockStatus(Integer lockStatus) {
		this.lockStatus = lockStatus;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getLockMemo() {
		return lockMemo;
	}

	public void setLockMemo(String lockMemo) {
		this.lockMemo = lockMemo;
	}

	public Date getLockTime() {
		return lockTime;
	}

	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
}
