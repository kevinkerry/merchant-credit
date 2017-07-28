package com.sdp.mc.common.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum StatusAvailableEnums {

	/**
	 * 有效
	 */
	AVAILABLE("1", "有效"),
	/**
	 * 无效
	 */
	UNAVAILABLE("0", "无效"), ;
	private static Logger logger = LoggerFactory.getLogger(StatusAvailableEnums.class);

	public final String code;
	public final String desc;

	StatusAvailableEnums(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static String valueOfCode(String code) {
		for (StatusAvailableEnums status : values()) {
			if (status.getCode().equals(code)) return status.getDesc();
		}
		logger.error("SettleMerchantStatusEnums status cannot be resolved for code .");
		return code;
	}
}
