package com.sdp.mc.common.enums.withdraw;

/**
 * 冻结额度操作类型
 * @author wangmindong
 *
 */
public enum FrozenQuotaTypeEnums {

	FROZEN_QUOTA_RESTORE("1", "解冻操作"),
	FROZEN_QUOTA_LIMITATION("2", "冻结操作"),
	FROZEN_QUOTA_USED("3", "冻结使用操作");

	public final String code;
	public final String desc;

	FrozenQuotaTypeEnums(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
