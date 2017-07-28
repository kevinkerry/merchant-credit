package com.sdp.mc.integration.fos.enums;

/**
 * fos产品码
 *
 * **/
public enum FOSProductCodeEnum {
	MC_FOS_MARGIN_PRODUCT_CODE("10020010", "216保证金账户产品码"),
	MC_FOS_CREDIT_PRODUCT_CODE("30060009", "281配资授信专户产品码"),
	MC_FOS_LOAN_PRODUCT_CODE("30060008", "pos贷款产品码"),
	MC_FOS_NEWT0_REMIT_FEE_PRODUCT_CODE("30060010", "新T0退结算手续费");

	public final String code;
	public final String name;

	FOSProductCodeEnum(final String code, final String name) {
		this.code = code;
		this.name = name;
	}

	public static FOSProductCodeEnum parse(String code) {
		for (FOSProductCodeEnum temp : FOSProductCodeEnum.values()) {
			if (temp.code.equals(code)) {
				return temp;
			}
		}
		return null;
	}
}
