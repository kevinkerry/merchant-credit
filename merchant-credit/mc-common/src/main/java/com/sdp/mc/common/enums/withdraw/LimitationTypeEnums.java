package com.sdp.mc.common.enums.withdraw;

/**
 * 额度类型
 * 
 * @author ganquan
 * 
 */
public enum LimitationTypeEnums {
	/**
	 * 快速结算提现额度：0；
	 */
	FASTSETTLE_LIMITATION(0, "快速结算提现额度");
	public final int code;
	public final String desc;

	LimitationTypeEnums(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
