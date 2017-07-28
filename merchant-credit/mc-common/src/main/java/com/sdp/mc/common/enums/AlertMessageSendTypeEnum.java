package com.sdp.mc.common.enums;


public enum AlertMessageSendTypeEnum {

	//邮件警报
	MAIL_ALERT(1,"邮件警报"),
	//手机短信警报
	SMS_ALERT(2,"手机短信警报"),
	;
	public final int code;

	public final String message;

	AlertMessageSendTypeEnum(int code,String message ) {
		this.code = code;
		this.message = message;
	}

	public static AlertMessageSendTypeEnum getByCode(long code) {
		for (AlertMessageSendTypeEnum s : values()) {
			if (s.code == code) {
				return s;
			}
		}
		return null;
	}

	public int getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}



	public int getStatusCode() {
		return this.code;
	}

	public String getStatusMessage() {
		return this.message;
	}

}
