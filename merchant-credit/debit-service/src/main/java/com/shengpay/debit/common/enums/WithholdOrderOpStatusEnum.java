package com.shengpay.debit.common.enums;
/**
 * 代扣订单状态
 * @author wangmindong
 * 2015年12月3日 16:12:40
 */
public enum WithholdOrderOpStatusEnum {
	/**
	 * 初始
	 */
	ORDER_INIT("001","初始"),
	/**
	 * 待调用
	 */
	ORDER_WAIT_CALL("002","待调用"),
	/**
	 * 接口调用失败
	 */
	ORDER_WAIT_FAILL("003","接口调用失败"),
	/**
	 * 待回调
	 */
	ORDER_INVOK_CALLBACK("004","待回调"),
	/**
	 * 成功
	 */
	ORDER_SUCCESS("005","成功"),
	/**
	 * 失败
	 */
	ORDER_FAILL("006","失败"),
	/**
	 * 作废
	 */
	ORDER_ABOLISH("007","作废"),
	/**
	 * 过期
	 */
	ORDER_TIMEOUT("008","过期")
	;
	public final String code;
	public final String desc;

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	WithholdOrderOpStatusEnum(String code,String desc){
		this.code = code;
		this.desc = desc;
	}

	public static WithholdOrderOpStatusEnum parse(String code) {
		for (WithholdOrderOpStatusEnum temp : WithholdOrderOpStatusEnum.values()) {
			if (temp.getCode().equals(code)) {
				return temp;
			}
		}
		return null;
	}
}
