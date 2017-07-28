package com.sdp.mc.common.enums.withdraw;

/**
 * 钱包出款状态
 *
 * @author wangmindong
 */
public enum WalletWithdrawStatusEnums {

	/**
	 * 初始化
	 */
	INIT(1, "待出款"),
	/**
	 * 出款成功
	 */
	SUCCESS(0, "出款成功"),
	/**
	 * 处理中
	 */
	WAITTING(2, "出款中"),
	/**
	 * 出款失败
	 */
	FAIL(9, "出款失败"),
	
	FAIL_DEALWITH(-99, "失败已处理")
	;

	public final int code;
	public final String desc;

	WalletWithdrawStatusEnums(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
