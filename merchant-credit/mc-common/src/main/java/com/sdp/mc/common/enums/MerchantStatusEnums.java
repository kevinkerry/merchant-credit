package com.sdp.mc.common.enums;

/**
       商户状态
 *
 */
public enum MerchantStatusEnums {
	UNACTIVE(0L, "未激活"),
	ACTIVE(1L, "激活"),
	LOCK(2L, "锁定"), 
	CANCEL(3L, "注销");
	
	public final Long code;
	public final String desc;

	MerchantStatusEnums(Long code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public static MerchantStatusEnums getEnumsByCode(Long code) {
		MerchantStatusEnums enums[] = MerchantStatusEnums.values();
		for (MerchantStatusEnums en : enums) {
			if (en.code.equals(code)) return en;
		}
		return null;
	}
	
	

}
