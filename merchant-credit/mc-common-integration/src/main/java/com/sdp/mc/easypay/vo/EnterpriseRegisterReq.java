package com.sdp.mc.easypay.vo;

public class EnterpriseRegisterReq {
	private String merchantStatus;
	private EnterpriseRegisterBaseInfo baseInfo;
	private EnterpriseRegisterAuthInfo authInfo;
	private EnterpriseBankCardInfo bankCardInfo;

	public String getMerchantStatus() {
		return merchantStatus;
	}

	public void setMerchantStatus(String merchantStatus) {
		this.merchantStatus = merchantStatus;
	}

	public EnterpriseRegisterBaseInfo getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(EnterpriseRegisterBaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}

	public EnterpriseRegisterAuthInfo getAuthInfo() {
		return authInfo;
	}

	public void setAuthInfo(EnterpriseRegisterAuthInfo authInfo) {
		this.authInfo = authInfo;
	}

	public EnterpriseBankCardInfo getBankCardInfo() {
		return bankCardInfo;
	}

	public void setBankCardInfo(EnterpriseBankCardInfo bankCardInfo) {
		this.bankCardInfo = bankCardInfo;
	}

}
