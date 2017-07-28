package com.sdp.mc.common.enums.withdraw;


/**
 * 代理商类型
 * 2016年3月15日 12:40:04
 */
public enum PmtTypeEnums {


	/**
	 * POS代理商：1；
	 */
	PMT_POS_MERCHANT_TYPE("0003", "POS代理商"),
	/**
	 * MPOS代理商：2；
	 */
	PMT_EASYPAY_MERCHANT_TYPE("0101", "云收银代理商"),
	PMT_MPOS_MERCHANT_TYPE("0007", "MPOS代理商");

	public final String code;
	public final String desc;

	PmtTypeEnums(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public static PmtTypeEnums getPmtTypeEnums(String mcType){
		if (mcType ==null) {
			return null;
		}
		PmtTypeEnums pmtTypeEnums[] = PmtTypeEnums.values();
		for (PmtTypeEnums pmtType : pmtTypeEnums) {
			if (pmtType.getCode().equals(mcType)) {
				return pmtType;
			}
		}
		return null;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
}
