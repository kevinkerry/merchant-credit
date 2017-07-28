package com.sdp.mc.dao.userloginlog;

import java.util.Date;


/**
 * MSP用户登录日志
 * @author dengxb
 * @date 2014-2-14 下午04:04:31
 */
public class McUserLoginLogEO{
	/**
	 * id
	 */
	private Long id;
	
	/**
	 * 会员账号
	 */
	private String memberId;
	
	/**
	 * 操作员ID
	 */
	private String operatorId;
	
	/**
	 * 操作员名称
	 */
	private String operatorLoginName;
	
	/**
	 * 管理员名称
	 */
	private String adminLoginName;
	
	/**
	 * 商户号
	 */
	private String merchantNo;
	
	/**
	 * 商户名称
	 */
	private String merchantName;
	
	/**
	 * 商户类型
	 */
	private String merchantType;
	
	/**
	 * 是否集团商户
	 */
	private Boolean groupMerchant;
	
	/**
	 * 登录ip
	 */
	private String loginIp;
	
	/**
	 * 浏览器类型
	 */
	private String browserName;
	
	/**
	 * 操作系统类型
	 */
	private String osName;
	
	/**
	 * user-agent
	 */
	private String userAgent;
	
	/**
	 * 登录时间
	 */
	private Date loginTime;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorLoginName() {
		return operatorLoginName;
	}

	public void setOperatorLoginName(String operatorLoginName) {
		this.operatorLoginName = operatorLoginName;
	}

	public String getAdminLoginName() {
		return adminLoginName;
	}

	public void setAdminLoginName(String adminLoginName) {
		this.adminLoginName = adminLoginName;
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

	public String getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}

	public Boolean getGroupMerchant() {
		return groupMerchant;
	}

	public void setGroupMerchant(Boolean groupMerchant) {
		this.groupMerchant = groupMerchant;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getBrowserName() {
		return browserName;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}
	
	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
}