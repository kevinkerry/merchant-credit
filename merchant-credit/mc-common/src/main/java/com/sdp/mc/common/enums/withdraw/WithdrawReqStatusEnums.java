package com.sdp.mc.common.enums.withdraw;

/**
 * FOS请求订单状态
 * @author wangmindong
 *
 */
public enum WithdrawReqStatusEnums {
	/**
	 * 1 初始状态
	 */
	INIT(1, "初始状态"),
	/**
	 * 0 出款成功
	 */
	SUCCESS(0, "出款成功"),
	/**
	 * 2处理中
	 */
	WAITTING(2, "处理中"),
	/**
	 * 9 出款失败
	 */
	FAIL(9,"出款失败");

	public final Integer code;
	public final String desc;

	WithdrawReqStatusEnums(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
