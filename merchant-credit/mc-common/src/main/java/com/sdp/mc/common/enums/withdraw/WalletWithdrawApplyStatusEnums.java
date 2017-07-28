package com.sdp.mc.common.enums.withdraw;

/**
 * 钱包出款状态
 *
 * @author wangmindong
 */
public enum WalletWithdrawApplyStatusEnums {

	/**
	 * 出款成功
	 */
	SUCCESS("0", "申请成功"),
	/**
	 * 出款失败
	 */
	FAIL("9", "申请失败");

	public final String code;
	public final String desc;

	WalletWithdrawApplyStatusEnums(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
