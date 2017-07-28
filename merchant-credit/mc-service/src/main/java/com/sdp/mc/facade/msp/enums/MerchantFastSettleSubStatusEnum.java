package com.sdp.mc.facade.msp.enums;

public enum MerchantFastSettleSubStatusEnum {
	SUBMITTED("0","已提交"),
	SETTLED("1","已结算"),
	CAN_REMIT_SETTLE_FEE("2","已结算可退费"),
	REMIT_SETTLE_FEE_PROCESSING("3","退费中"),
	REMIT_SETTLE_FEE_SUCCESS("4","退费成功"),
	REMIT_SETTLE_FEE_FAILURE("5","退费失败"),
	MSP_EXCEPTION("6","MSP异常订单"),//为还原额度而用
	SETTLED_FAIL("7","出款失败"),
	;
	
	MerchantFastSettleSubStatusEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public final String code;
	public final String desc;
	
	public String getCode() {
		return code;
	}
	public String getDesc() {
		return desc;
	}
	
	
}
