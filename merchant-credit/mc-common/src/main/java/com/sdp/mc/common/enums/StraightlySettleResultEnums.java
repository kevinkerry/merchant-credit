package com.sdp.mc.common.enums;

public enum StraightlySettleResultEnums {
	/**
	 * -1:初始
	 */
	INIT("-1", "初始"),
	/**
	 * 00： 成功
	 */
	RESULT_00("00", "成功"),
	/**
	 * 01:商户无权限，或配制错误
	 */
	RESULT_01("01", "商户无权限，或配制错误"),
	/***
	 * 02:代理商无权限，或配制错误
	 */
	RESULT_02("02", "代理商无权限，或配制错误"),
	/**
	 * 03:商户额度不足
	 */
	RESULT_03("03", "商户额度不足"),
	/**
	 * 04:代理商额度不足
	 */
	RESULT_04("04", "代理商额度不足"),
	/**
	 * 05:存在非法订单（存在被暂停、或者已生成结算单、或退货订单）
	 */
	RESULT_05("05", "存在非法订单（存在被暂停、或者已生成结算单、或退货订单）"),
	/**
	 * 06:请求订单数太多（最多999）
	 */
	RESULT_06("06", "请求订单数太多（最多999）"),
	/**
	 * 07:入账失败
	 */
	RESULT_07("07", "入账失败"),
	/**
	 * 08:结算失败
	 */
	RESULT_08("08", "结算失败"),
	/**
	 * 09:提交金额低于下限
	 */
	RESULT_09("09", "提交金额低于下限"),
	/**
	 * 11:当前时段不允许发起快速结算
	 */
	RESULT_11("11", "当前时段不允许发起快速结算"),
	/**
	 * 99:未知错误
	 */
	RESULT_99("99", "未知错误"),
	/**
	 * "-2":"系统异常"
	 */
	RESULT_ERROR("-2", "系统异常"), ;
	public final String code;
	public final String msg;

	private StraightlySettleResultEnums(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
