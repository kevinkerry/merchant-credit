package com.sdp.mc.common.enums.withdraw;

/**
 * FOS请求订单状态
 * @author wangmindong
 *
 */
public enum RemitWithdrawFeeStatusEnums {
	/**
	 * 0 初始状态
	 */
	INIT(0, "待退费"),
	/**
	 * 1退款中
	 */
	REMITING(1, "退费中"),

	/**
	 * 2退款失败
	 */
	FAIL(2,"退费失败"),
	/**
	 * 3 退款成功
	 */
	SUCCESS(3, "退费成功");

	public final Integer code;
	public final String desc;

	RemitWithdrawFeeStatusEnums(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
