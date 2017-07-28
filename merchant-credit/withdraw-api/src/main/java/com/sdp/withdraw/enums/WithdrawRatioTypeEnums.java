package com.sdp.withdraw.enums;

/**
 * 费率类型
 * 
 * @author ganquan
 * 
 */
public enum WithdrawRatioTypeEnums {
	
	/**
	 * POS/T+0结算费率：1；
	 */
	POS_T1_SETTLE_RATIO(1, "POS/T+1结算费率"),
	/**
	 * POS/T+0结算费率：10；
	 */
	POS_T0_SETTLE_RATIO(10, "POS/T+0结算费率"),
	/**
	 * MPOS/T+0结算费率：20；
	 */
	MPOS_T0_SETTLE_RATIO(20, "MPOS/T+0结算费率"),
	/**
	 * MPOS/T+1结算费率：21；
	 */
	MPOS_T1_SETTLE_RATIO(21, "MPOS/T+1结算费率"),
	/**
	 * MPOS/D+1结算费率：22；
	 */
	MPOS_D1_SETTLE_RATIO(22, "MPOS/D+1结算费率"),
	/**
	 * 云收银/T+0结算费率：30；
	 */
	EASYPAY_T0_SETTLE_RATIO(30, "云收银/T+0结算费率"), 
	;

	public final int code;
	public final String desc;

	WithdrawRatioTypeEnums(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
