package com.sdp.mc.common.enums.withdraw;

/**
 * FOS请求订单状态
 * @author wangmindong
 *
 */
public enum WithdrawFosPaymentStateEnums {

	SUCCESS("S", "出款成功"), 
	WAITTING("P", "处理中"), 
	FAIL("F", "出款失败");

	public final String code;
	public final String desc;

	WithdrawFosPaymentStateEnums(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
