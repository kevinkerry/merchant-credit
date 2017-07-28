package com.sdp.mc.common.enums;

/**
 *
 * @author ganquan // 退回 0：初始化 201：配置更改成功（退款申请成功） -201：配置更改失败 202：转账成功 -202：转账失败
 */
public enum MarginOpRedeemEnums {
	// 0 -> 201 ->220 -> 202
	/**
	 * 0：初始化
	 */
	INIT(0, "初始化"),
	/**
	 * 201：配置更改成功（退款申请成功）
	 */
	CONFIGURE_SUCCESS(201, "配置更改成功（退款申请成功）"),
	/**
	 * -201：配置更改失败
	 */
	CONFIGURE_FAILURE(-201, "配置更改失败"),
	/**
	 * 202：转账成功
	 */
	TRANSFER_SUCCESS(202, "转账成功"),
	/**
	 * -202：转账失败
	 */
	TRANSFER_FAILURE(-202, "转账失败"),

	/**
	 * 220:审核通过
	 */

	AUDITING_SUCCESS(220,"审核通过"),
	/**
	 * -220:审核未通过
	 */
	AUDITING_ERROR(-220,"审核未通过"),

	/**
	 * -300：拒绝放款
	 */
	LOAIN_REFUSE(-300,"拒绝放款"),
	/**
	 * -9999：忽略，不作为统计数据
	 */
	NEGLECT (-9999,"忽略，不作为统计数据");


	public final int code;
	public final String desc;

	MarginOpRedeemEnums(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
}
