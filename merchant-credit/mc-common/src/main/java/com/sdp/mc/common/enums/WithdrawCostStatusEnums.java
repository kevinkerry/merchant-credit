package com.sdp.mc.common.enums;


/**
       提现费率状态
 *
 */
public enum WithdrawCostStatusEnums {
	EFFECTIVITY(1, "有效"),
	LOSE_EFFICACY(0, "失效");
	public final int code;
	public final String desc;

	WithdrawCostStatusEnums(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	public static WithdrawCostStatusEnums getEnumsByCode(int code) {
		WithdrawCostStatusEnums enums[] = WithdrawCostStatusEnums.values();
		for (WithdrawCostStatusEnums en : enums) {
			if (en.code==code) return en;
		}
		return null;
	}

}
