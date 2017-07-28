package com.sdp.mc.integration.ma.dto;

/**
 * 个人用户member和walletAccount信息
 * @author heyi.alex
 *
 */
public class PersionalInfoDTO {

	private String loginName;

	private String memberId;

	private String walletAccount;

	private String operatorId;

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getWalletAccount() {
		return walletAccount;
	}

	public void setWalletAccount(String walletAccount) {
		this.walletAccount = walletAccount;
	}

	@Override
	public String toString() {
		return "PersionalInfoDTO [loginName=" + loginName + ", memberId="
				+ memberId + ", walletAccount=" + walletAccount + "]";
	}

}
