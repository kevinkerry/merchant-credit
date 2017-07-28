package com.sdp.mc.common.enums;


/**
       提现费率状态
 *
 */
public enum MerchantLimitRuleStatusEnums {
	EFFECTIVITY(1, "有效"),
	LOSE_EFFICACY(0, "失效");
	public final int code;
	public final String desc;

	MerchantLimitRuleStatusEnums(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	public static MerchantLimitRuleStatusEnums getEnumsByCode(int code) {
		MerchantLimitRuleStatusEnums enums[] = MerchantLimitRuleStatusEnums.values();
		for (MerchantLimitRuleStatusEnums en : enums) {
			if (en.code==code) return en;
		}
		return null;
	}

}
