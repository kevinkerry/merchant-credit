package com.shengpay.debit.common.enums;
/**
 * 批处理状态
 * @author wangmindong
 * 2015年12月3日 16:11:17
 */
public enum WithholdBatchOpStatusEnum {
	BATCH_INIT("001","初始"),
	BATCH_WITHHOLD("002","代扣中"),
	BATCH_PROCESSING("003","处理中"),
	BATCH_COMPLETE("004","完成")
	;
	public final String code;
	public final String desc;

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	WithholdBatchOpStatusEnum(String code,String desc){
		this.code = code;
		this.desc = desc;
	}

	public static WithholdBatchOpStatusEnum parse(String code) {
		for (WithholdBatchOpStatusEnum temp : WithholdBatchOpStatusEnum.values()) {
			if (temp.getCode().equals(code)) {
				return temp;
			}
		}
		return null;
	}
}
