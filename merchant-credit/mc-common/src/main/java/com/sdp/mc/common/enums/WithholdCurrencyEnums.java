package com.sdp.mc.common.enums;

/**
 *
 * @author liutao
 *
 */
public enum WithholdCurrencyEnums {
	/**
	 * 人民币
	 */
	RMB("RMB", "人民币"),CNY("CNY", "人民币"),
	/**
	 * 日元
	 */
	JPY("JPY", "日元"),
	/**
	 * 美元
	 */
	USD("USD", "美元"),
	/**
	 * 加拿大元
	 */
	CAD("CAD", "加拿大元"),
	/**
	 * 英镑
	 */
	GBP("GBP", "英镑"),
	/**
	 * 澳元
	 */
	AUD("AUD", "澳元"),
	/**
	 * 港币
	 */
	HKD("HKD", "港币"),
	/**
	 * 欧元
	 */
	EUR("EUR", "欧元"),
	/**
	 * 新加坡元
	 */
	SGD("SGD", "新加坡元"),
	/**
	 * 瑞士法郎
	 */
	CHF("CHF", "瑞士法郎");
	WithholdCurrencyEnums(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public final String code;
	public final String desc;

}
