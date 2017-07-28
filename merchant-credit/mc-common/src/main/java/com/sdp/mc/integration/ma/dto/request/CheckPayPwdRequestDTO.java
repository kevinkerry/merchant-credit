package com.sdp.mc.integration.ma.dto.request;

import java.io.Serializable;

public class CheckPayPwdRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 操作员Id
	 */
	private String operatorId;
	/**
	 * 账户ID
	 */
	private String accountId;
	/**
	 * 支付密码,必填
	 */
	private String password;
	/**
	 * 登录名
	 * **/
	private String loginName;
	/**
	 * 支付用户ip
	 * **/
	private String userIp;

	/**
	 * 支付控件 enKey
	 */
	private String enKey;
	/**
	 * 支付控件 enKey
	 */
	private String certNo;

	public String getEnKey() {
		return enKey;
	}

	public void setEnKey(String enKey) {
		this.enKey = enKey;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	@Override
	public String toString() {
		return "CheckPayPwdRequestDTO [operatorId=" + operatorId + ", accountId=" + accountId + ", password=" + password + ", loginName=" + loginName
				+ ", userIp=" + userIp + ", enKey=" + enKey + ", certNo=" + certNo + "]";
	}

}
