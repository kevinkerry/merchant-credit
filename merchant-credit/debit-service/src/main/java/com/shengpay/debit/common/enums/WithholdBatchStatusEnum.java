package com.shengpay.debit.common.enums;
public enum WithholdBatchStatusEnum {
	INIT("0","初始"),
	UPLOAD_REQUEST_ING("1","上传中"),
	READY_CALL_MTC("2","待调用接口"),
	CALL_MTC_ING("3","调用接口中"),
	READY_BEEN_CALLBACK("4","待回调通知"),
	CALLBACK_ING("5","回调通知中"),
	READY_DOWNLOAD_FROM_FTP("6","待从FTP下载文件"),
	DOWNLOAD_FROM_FTP_ING("7","从FTP下载文件中"),
	READY_READER_RESULT_FILE("8","待解析文件"),
	READER_RESULT_FILE_ING("9","解析文件中"),
	READY_UPLOAD_TO_MTC_FTP("10","待上传结果文件到小文件"),
	UPLOAD_RESULT_FILE_ING("11","上传结果文件到小文件中"),
	SUCESS("100","成功")

	;
	public final String code;
	public final String desc;

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	WithholdBatchStatusEnum(String code,String desc){
		this.code = code;
		this.desc = desc;
	}

	public static WithholdBatchStatusEnum parse(String code) {
		for (WithholdBatchStatusEnum temp : WithholdBatchStatusEnum.values()) {
			if (temp.getCode().equals(code)) {
				return temp;
			}
		}
		return null;
	}
}
