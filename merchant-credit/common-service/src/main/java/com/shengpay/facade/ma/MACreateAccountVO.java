package com.shengpay.facade.ma;

import com.sdp.mc.common.vo.ErrorMessageVO;

public class MACreateAccountVO extends ErrorMessageVO {

	public MACreateAccountVO(boolean isSuccess) {
		super(isSuccess);
	}
	public MACreateAccountVO(boolean isSuccess, String errorCode, String errorMessage) {
		super(isSuccess, errorCode, errorMessage);
	}
	private static final long serialVersionUID = 1L;
	/** 储值帐号id **/
	private String accountId;
	/** 开户业务记录id **/
	private Long bizAccountId;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Long getBizAccountId() {
		return bizAccountId;
	}

	public void setBizAccountId(Long bizAccountId) {
		this.bizAccountId = bizAccountId;
	}
}
