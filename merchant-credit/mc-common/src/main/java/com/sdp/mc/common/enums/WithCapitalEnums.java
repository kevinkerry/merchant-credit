package com.sdp.mc.common.enums;

/**
 * 配资状态
 * 0初始化,
 * 1处理中,
 * 2fos配资成功,
 * 3fos配资失败,
 * 4msp额度修改成功,
 * 5额度修改失败,
 * 6msp额度修改成功,
 * 7msp额度配置修改失败',
 * 8fos冲正成功,
 * 9fos冲正失败;

 */
public enum WithCapitalEnums {

	INIT(0, "初始化"),
    PROCESSING(1, "处理中"),
    FOS_TRANSFER_SUCCESS(2, "fos配资成功"),
    FOS_TRANSFER_FAIL(3, "fos配资失败"),
    MSP_FAST_SETTLE_LIMIT_ADD_SUCCESS(4,"msp快速结算额度修改成功"),
    MSP_FAST_SETTLE_LIMIT_ADD_FAILURE(5,"msp快速结算额度修改失败"),
    MSP_FAST_SETTLE_LIMIT_RESET_SUCCESS(6,"msp快速结算额度恢复成功"),
    MSP_FAST_SETTLE_LIMIT_RESET_FAILURE(7,"msp快速结算额度恢复失败"),
    FOS_REFUND_SUCCESS(8,"fos冲正成功"),
    FOS_REFUND_FAIL(9,"fos冲正失败"),
    FEE_REFUND_SUCCESS(10,"手续费已退款"),
    ;

	public final int code;
	public final String desc;

	private WithCapitalEnums(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static WithCapitalEnums parse(int code) {
		for (WithCapitalEnums temp : WithCapitalEnums.values()) {
			if (temp.code == code) {
				return temp;
			}
		}
		return null;
	}

}
