package com.sdp.mc.common.enums.withdraw;

public enum QuotaOpTypeEnums {
	/**
	 * POS商户/POS代理商：1；
	 */
	MERCHANT_QUOTA_OP_TYPE(1, "商户额度操作"),
	PMT_MERCHANT_QUOTA_OP_TYPE(2, "代理商额度操作"),
	SDP_MERCHANT_QUOTA_OP_TYPE(3, "盛付通额度操作");

	public final int code;
	public final String desc;

	QuotaOpTypeEnums(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
