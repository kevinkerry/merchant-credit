package com.shengpay.debit.common.enums;
/**
 * 批处理状态
 * @author wangmindong
 * 2015年12月3日 16:11:17
 */
public enum WithholdCardTypeEnum {
	/**
	 * 借记卡
	 */
	JIEJI_CARD(1,"01","借记卡"),
	/**
	 * 贷记卡
	 */
	DAIJI_CARD(2,"01","贷记卡"),
	/**
	 * 存折
	 */
	CUNZHE_CARD(3,"03","存折"),
	/**
	 * 公司银行账户(暂不支持)
	 */
	CARD_COMPLETE(4,"04","公司银行账户(暂不支持)")
	;
	public final Integer code;
	public final String value;
	public final String desc;

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	WithholdCardTypeEnum(Integer code,String value,String desc){
		this.code = code;
		this.value=value;
		this.desc = desc;
	}

	public static WithholdCardTypeEnum getEnumsByCode(Integer code) {
		for (WithholdCardTypeEnum temp : WithholdCardTypeEnum.values()) {
			if (temp.getCode().equals(code)) {
				return temp;
			}
		}
		return null;
	}
	public static WithholdCardTypeEnum getEnumsByValue(String value) {
		for (WithholdCardTypeEnum temp : WithholdCardTypeEnum.values()) {
			if (temp.getValue().equals(value)) {
				return temp;
			}
		}
		return null;
	}
}
