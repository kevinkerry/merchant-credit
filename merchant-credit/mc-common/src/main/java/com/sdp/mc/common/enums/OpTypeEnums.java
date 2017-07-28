package com.sdp.mc.common.enums;

public enum OpTypeEnums {

	/**
	 * 开通
	 */
	OPEN(1, "开通"),
	/**
	 * 关闭
	 */
	CLOSE(2, "关闭"),
	/**
	 * 追加保证金
	 */
	ADD(3, "追加保证金"),
	/**
	 * 修改保证金
	 */
	MODIFY(12, "修改保证金"),
	/**
	 * 退回保证金
	 */
	REDEEMED(4, "退回保证金"),
	/**
	 * 修改商户快速结算配置
	 */
	MERCHANT_FASTSETTLE_CONFIG_OP(5, "修改商户快速结算配置"),
	/**
	 * 代理商配资申请
	 */
	PROMOTER_WITHCAPITAL_APPLY(6, "代理商配资申请"),
	/**
	 * 代理商配资恢复
	 */
	PROMOTER_WITHCAPITAL_RESUME(7, "代理商配资恢复"),

	/**
	 * 自动修改商户快速结算额度
	 */
	MERCHANT_FASTSETTLE_AUTO_CHANGE(8, "修改商户快速结算配置"),

	/**
	 * 后台拓展方在线申请管理--修改
	 */
	PROMOTER_FASTSETTLE_CHANGE(9, "修改拓展方快速结算配置"),
	/**
	 * 后台拓展方在线申请管理--修改
	 */
	MERCHANT_FASTSETTLE_BATCH_OP(10, "批量修改商户快速结算配置"),
	/**
	 * 盛付通垫资代理商临时调额
	 */
	SHENGPAY_PROMPTER_ADJUST_LIMIT(11, "盛付通垫资代理商临时调额");;

	public final int code;
	public final String desc;

	OpTypeEnums(int code, String desc) {
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
