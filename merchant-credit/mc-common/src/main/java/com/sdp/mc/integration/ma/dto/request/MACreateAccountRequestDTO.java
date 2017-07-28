package com.sdp.mc.integration.ma.dto.request;

import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.integration.ma.dto.MABaseDTO;

public class MACreateAccountRequestDTO extends MABaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * sdp会员号
	 * **/
	private String memberId;
	/**
	 * 账户类型
	 */
	private AccountType accountType;
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

}
