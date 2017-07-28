package com.sdp.mc.common.enums.withdraw;


public enum LogRecordTypeEnums {
	/**
	 * mpos商户快速结算提现
	 */
	MPOS_MERCHANT_WITHDRAW("MPOS_MERCHANT_WITHDRAW", "mpos商户快速结算提现"),
	/**
	 * pos商户快速结算提现
	 */
	POS_MERCHANT_WITHDRAW("POS_MERCHANT_WITHDRAW", "pos商户快速结算提现"),

	/**
	 * 同步额度记录
	 */
	SYNC_MERCHANT_WITHDRAW("SYNC_MERCHANT_WITHDRAW","同步额度记录"),
	/**
	 *冻结 额度
	 */
	FROZEN_QUOTA_LIMITATION("FROZEN_QUOTA_LIMITATION","冻结额度"),
	/**
	 * 解冻额度
	 */
	FROZEN_QUOTA_RESTORE("FROZEN_QUOTA_RESTORE","解冻额度"),
	/**
	 * 额度使用
	 */
	FROZEN_QUOTA_USED("FROZEN_QUOTA_USED","额度使用"),
	/**
	 * 提现费率变更
	 */
	WITHDRAW_RATIO_MERGE("WITHDRAW_RATIO_MERGE","提现费率变更"),
	/**
	 * 提现费率变更
	 */
	WITHDRAW_RETRY_OP("WITHDRAW_RETRY_OP","出款重试操作"),
	;
	public final String code;
	public final String desc;

	LogRecordTypeEnums(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public static LogRecordTypeEnums getLogRecordTypeEnums(String code) {
		if (code == null) {
			return null;
		}
		LogRecordTypeEnums logRecordTypeEnums[] = LogRecordTypeEnums.values();
		for (LogRecordTypeEnums logEnum : logRecordTypeEnums) {
			if (logEnum.getCode().equals(code)) {
				return logEnum;
			}
		}
		return null;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

//	C：CREATE；U：UPDATE；D：DELETE；
}
