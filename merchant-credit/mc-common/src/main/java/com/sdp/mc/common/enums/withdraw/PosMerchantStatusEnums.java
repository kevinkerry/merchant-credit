package com.sdp.mc.common.enums.withdraw;

import java.util.ArrayList;
import java.util.List;


public enum PosMerchantStatusEnums {
	MC_STATUS_UNACTIVE("0", "待审核"),
	MC_STATUS_CONFIRM("1", "已审核"),
	MC_STATUS_SIGNOFF("2", "预约终止"),
	MC_STATUS_ACTIVE("3", "已激活"),
	MC_STATUS_DELETE("4", "已删除"), ;
	public final String code;
	public final String desc;

	PosMerchantStatusEnums(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public static PosMerchantStatusEnums getMerchantTypeByCode(String code) {
		PosMerchantStatusEnums merchantTypeEnums[] = PosMerchantStatusEnums.values();
		for (PosMerchantStatusEnums enums : merchantTypeEnums) {
			if (enums.code.equalsIgnoreCase(code)) return enums;
		}
		return null;
	}
	
	public static List<String> getUnusableStatus() {
		PosMerchantStatusEnums enums[] = PosMerchantStatusEnums.values();
		List<String> list=new ArrayList<String>();
		for (PosMerchantStatusEnums en : enums) {
			if (!en.code.equals(PosMerchantStatusEnums.MC_STATUS_ACTIVE.code)){
				list.add(en.code);
			}
		}
		return list;
	}
	
}
