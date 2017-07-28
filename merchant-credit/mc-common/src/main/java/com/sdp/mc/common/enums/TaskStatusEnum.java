package com.sdp.mc.common.enums;
/**
*@author: wushiyu
*@date:2017年4月26日 下午1:29:28
*@version 1.0
*@description:定时任务状态
*/
public enum TaskStatusEnum {
	WAIT_RUNNING(1,"待执行"),
	RUNNIING(2,"执行中"),
	WAIT_RETRY(3,"重试"),
	RUNNING_FAIL(4,"执行失败"),
	RUNNING_STOPPED(5,"终止"),
	RUNNING_SUCCESS(0,"执行成功");
	
	private final int code;
	
	private final String message;

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	private TaskStatusEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	
	
	

}
