package com.sdp.mc.common.enums;


/**
       提现费率类型
 *
 */
public enum WithdrawCostTypeEnums {
	DEFAULT(1, "默认"),
	DEFINITIVE(2, "限定");
	public final int code;
	public final String desc;

	WithdrawCostTypeEnums(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	public static WithdrawCostTypeEnums getEnumsByCode(int code) {
		WithdrawCostTypeEnums enums[] = WithdrawCostTypeEnums.values();
		for (WithdrawCostTypeEnums en : enums) {
			if (en.code==code) return en;
		}
		return null;
	}

}
