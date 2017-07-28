package com.sdp.mc.common.enums.withdraw;

/**
 * FOS出款订单状态
 *
 * @author wangmindong
 */
public enum WithdrawOrderStatusEnums {

	/**
	 * 初始化
	 */
	INIT("1", "初始状态"),
	/**
	 * 出款成功
	 */
	SUCCESS("0", "出款成功"),
	/**
	 * 处理中
	 */
	WAITTING("2", "处理中"),
	/**
	 * 出款失败
	 */
	FAIL("9", "出款失败");

	public final String code;
	public final String desc;

	WithdrawOrderStatusEnums(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
