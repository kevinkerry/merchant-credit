package com.sdp.mc.common.enums;

import com.sdp.mc.common.constant.MerchantCreditConstant;

public enum CheckPayPwdEnums {

	/**
	 * "002", "参数错误"
	 */
	error_002("002", "参数错误", MerchantCreditConstant.MC_SPDEDITALL_CHECK_ERROR_INPUT_ERROR),
	/**
	 * "003", "参数错误"
	 */
	error_003("003", "参数错误", MerchantCreditConstant.MC_SPDEDITALL_CHECK_ERROR_INPUT_ERROR),
	/**
	 * "004", "接口权限错误"
	 */
	error_004("004", "接口权限错误", MerchantCreditConstant.MC_SPDEDITALL_CHECK_ERROR_INPUT_ERROR),
	/**
	 * "005", "接口兼容错误"
	 */
	error_005("005", "接口兼容错误", MerchantCreditConstant.MC_SPDEDITALL_CHECK_ERROR_INPUT_ERROR),
	/**
	 * "006", "处理失败"
	 */
	error_006("006", "处理失败", MerchantCreditConstant.MC_SPDEDITALL_CHECK_ERROR_INPUT_ERROR),
	/**
	 * "009", "不存在的记录"
	 */
	error_009("009", "不存在的记录", MerchantCreditConstant.MC_SPDEDITALL_CHECK_ERROR_INPUT_ERROR),
	/**
	 * "010", "鉴权失败"
	 */
	error_010("010", "鉴权失败", MerchantCreditConstant.MC_SPDEDITALL_CHECK_ERROR_INPUT_ERROR),
	/**
	 * "010", "支付密码为空"
	 */
	error_999("999", "异常失败[解密失败]", "支付密码不能为空"),
	/**
	 * "256", "支付密码输入错误"
	 */
	PWD_IS_WORNG("256", "支付密码输入错误", MerchantCreditConstant.MC_SPDEDITALL_CHECK_ERROR_INPUT_ERROR),
	/**
	 * "007", "超过允许的最大个数"
	 */
	error_007("007", "超过允许的最大个数", MerchantCreditConstant.MC_SPDEDITALL_CHECK_ERROR_LOCK),
	/**
	 * "264", "支付密码输错多次已锁定，请3小时后再试"
	 */
	ACCOUNT_LOCK("264", "支付密码输错多次已锁定，请3小时后再试", MerchantCreditConstant.MC_SPDEDITALL_CHECK_ERROR_LOCK),
	/**
	 * "0", "成功"
	 */
	SUCCESS("0", "", "");
	public final String code;
	public final String msg;
	public final String desc;

	private CheckPayPwdEnums(String code, String msg, String desc) {
		this.code = code;
		this.msg = msg;
		this.desc = desc;
	}

	public static CheckPayPwdEnums getEnumsByCode(String code) {
		CheckPayPwdEnums payPwdEnums[] = CheckPayPwdEnums.values();
		for (CheckPayPwdEnums checkPayPwdEnums : payPwdEnums) {
			if (checkPayPwdEnums.code.equalsIgnoreCase(code)) return checkPayPwdEnums;
		}
		return null;
	}
}
