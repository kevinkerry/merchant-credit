package com.sdp.mc.common.enums.withdraw;

public enum RatioRulsTypeEnums {

	D1_RATIO_RULS_SETTLE_RATIO(1L, "D1"),
	T1_RATIO_RULS_SETTLE_RATIO(2L, "T1"),
	T0_RATIO_RULS_SETTLE_RATIO(5L, "T0");

	public final Long code;
	public final String desc;

	RatioRulsTypeEnums(Long code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
