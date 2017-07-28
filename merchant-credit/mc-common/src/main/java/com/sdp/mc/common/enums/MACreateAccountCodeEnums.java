package com.sdp.mc.common.enums;

import com.sdp.mc.common.constant.MerchantCreditConstant;

public enum MACreateAccountCodeEnums {

	error_295("295", "账户类型和会员类型不匹配[个人商户会员不能创建类型为216的账户]", MerchantCreditConstant.MC_MA_216_ACCOUNT_ERROR_295);
	public final String code;
	public final String msg;
	public final String desc;

	private MACreateAccountCodeEnums(String code, String msg, String desc) {
		this.code = code;
		this.msg = msg;
		this.desc = desc;
	}

	public static MACreateAccountCodeEnums getMACreateAccountCodeEnumsByCode(String code) {
		MACreateAccountCodeEnums accountCodeEnums[] = MACreateAccountCodeEnums.values();
		for (MACreateAccountCodeEnums maCreateAccountCodeEnums : accountCodeEnums) {
			if (maCreateAccountCodeEnums.code.equalsIgnoreCase(code)) return maCreateAccountCodeEnums;
		}
		return null;
	}

}
