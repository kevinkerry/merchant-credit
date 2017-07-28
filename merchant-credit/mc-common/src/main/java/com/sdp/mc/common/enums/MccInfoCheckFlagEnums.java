package com.sdp.mc.common.enums;


public enum MccInfoCheckFlagEnums {


	MCC_CHECK_FLAGE_EFFECTIVE(1L,"可选择"),
	MCC_CHECK_FLAGE_INVALID(0L,"不可选择"),;

	public final Long code;
	public final String msg;

	private MccInfoCheckFlagEnums(Long code, String errmsg) {
		this.code = code;
		this.msg = errmsg;
	}

	public static MccInfoCheckFlagEnums getEnumsByCode(Long code) {
		if (code==null) {return null;}
		MccInfoCheckFlagEnums returnCodeEnums[] = MccInfoCheckFlagEnums.values();
		for (MccInfoCheckFlagEnums enums : returnCodeEnums) {
			if (enums.code.intValue()==code.intValue()) return enums;
		}
		return null;
	}
}
