package com.shengpay.debit.common.enums;
/**
 * 委托扣费回调订单状态
 * @author wangmindong
 * 2015年12月3日 16:11:17
 */
public enum WithholdTransStatusEnum {
	PROCESSING("00","等待付款中"),
	SUCC("01","付款成功"),
	FAIL("02","付款失败"),
	TIMEOUT("03","过期"),
	REFUNDPROCESSING("04","退款中"),
	REFUNDSUCC("05","退款成功"),
	REFUNDFAIL("06","退款失败")
	;
	public final String code;
	public final String desc;

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	WithholdTransStatusEnum(String code,String desc){
		this.code = code;
		this.desc = desc;
	}

	public static WithholdTransStatusEnum parse(String code) {
		for (WithholdTransStatusEnum temp : WithholdTransStatusEnum.values()) {
			if (temp.getCode().equals(code)) {
				return temp;
			}
		}
		return null;
	}
}
