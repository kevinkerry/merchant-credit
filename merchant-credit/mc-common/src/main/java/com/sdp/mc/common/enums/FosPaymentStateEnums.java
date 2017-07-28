package com.sdp.mc.common.enums;

public enum FosPaymentStateEnums {
	// C-批量付款失败需退款 S-成功 P-处理中 F-处理失败
	/**
	 * 批量付款失败需退款
	 */
	C("C", "批量付款失败需退款"),
	/**
	 * 成功
	 */
	S("S", "成功"),
	/**
	 * 处理中
	 */
	P("P", "处理中"),
	/**
	 * 处理失败
	 */
	F("F", "处理失败"),
	/**
	 * 调fos异常
	 */
	E("E", "fos异常，我方自定义的"),;
	public final String code;
	public final String desc;

	FosPaymentStateEnums(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
