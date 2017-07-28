package com.sdp.mc.common.enums;

public enum WithholdTypeEnums {

	/**
	 * 新加坡元
	 */
	BANK_CARD_WITHDRAW("1", "银行卡代扣"),
	/**
	 * 瑞士法郎
	 */
	WALLET_WITHDRAW("2", "盛付通钱包代扣");
	WithholdTypeEnums(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public final String code;
	public final String desc;
}
