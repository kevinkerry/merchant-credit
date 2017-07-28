package com.mc.service.api.enums;


/**
       白名单类型
 *
 */
public enum WhiteTypeEnums {
	FEE(1, "费率"),
	AUTO_UPDATE_MERCHANT_LIMIT(2, "永久额度"),
	HOLIDAYS_LIMIT(3, "节假日额度"),
	MERCHANT_LIMIT_NO_ENOUGH_REMIND_MERCHANT(4, "商户额度不足不提醒商户"),
	PROMOTER_LIMIT_NO_ENOUGH_REMIND_MERCHANT(5, "代理商额度不足不提醒商户"),
	PROMOTER_LIMIT_NO_ENOUGH_REMIND_PROMOTER(6, "代理商额度不足不提醒代理商"),
	CREDIT_AUTHENTICATION_LIMIT(7, "信用认证额度"),
	DEFAULT_OPEN_FAST_SETTLE_LIMIT(8, "开户额度"),
	PROMOTER_MIN_MARGIN(9, "代理商特殊保证金"),
	MINUS_PROFITS_PROMOTER(10, "结算负分润配置"),
	;
//	DEFAULT(0, "0");
	public final Integer code;
	public final String desc;

	WhiteTypeEnums(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	public static WhiteTypeEnums getEnumsByCode(Integer code) {
		WhiteTypeEnums enums[] = WhiteTypeEnums.values();
		for (WhiteTypeEnums en : enums) {
			if (en.code.equals(code)) return en;
		}
		return null;
	}

}
