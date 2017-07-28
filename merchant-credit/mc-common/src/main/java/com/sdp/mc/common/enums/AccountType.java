package com.sdp.mc.common.enums;

public enum AccountType {

	B_BASE_ACCOUNT(201L, "商户基本户"),
	/**
	 * 101
	 */
	C_BASE_ACCOUNT(101L, "个人基本户"),
	/**
	 * 216 保证金账户
	 */
	MARGIN_ACCOUNT(216L, "保证金账户"),
	/**
	 * 217 mpos保证金账户
	 */
	MARGIN_ACCOUNT_MPOS(217L, "MPOS保证金账户"),
	/**
	 * 218 云收银保证金账户
	 */
	MARGIN_ACCOUNT_EASYPAY(218L, "云收银保证金账户"),
	
	CREDIT_ACCOUNT(281L, "配资授信账户"),
	/**
	 * 181	天天贷-授信专用账户
	 */
	TTD_CREDIT_SPECIAL_ACCOUNT(181L, "天天贷-授信专用账户"),
	/**
	 * 182	天天贷-授信利息专用账户
	 */
	TTD_CREDIT_INTEREST_ACCOUNT(182L, "天天贷-授信利息专用账户"),
	;
	public final long code;
	public final String name;

	AccountType(long code, String name) {
		this.code = code;
		this.name = name;
	}

	public static AccountType getByCode(long code) {
		for (AccountType temp : AccountType.values()) {
			if (temp.code == code) {
				return temp;
			}
		}
		return null;
	}
}
