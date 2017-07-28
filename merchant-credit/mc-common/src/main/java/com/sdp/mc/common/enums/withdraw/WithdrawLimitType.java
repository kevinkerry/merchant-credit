package com.sdp.mc.common.enums.withdraw;

public enum WithdrawLimitType {

	/**
	 * POS商户/MPOS商户：1；
	 */
	POS_MPOS_MERCHANT_TYPE("1", "POS商户/MPOS商户"),
	/**
	 * POS代理商/MPOS代理商：2；
	 */
	POS_MPOS_PROMOTO_MERCHANT_TYPE("2", "POS代理商/MPOS代理商");

	public final String code;
	public final String desc;

	WithdrawLimitType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
