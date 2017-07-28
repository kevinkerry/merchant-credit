package com.sdp.mc.common.enums;

public enum AuditInfoStateEnum {

	WAIT_AUDIT(1, "待审核"), AUDITING(2, "审核中"), AUDITED(3, "审核通过"),REJECT(4, "审核未通过"),OVERDUE(5, "申请过期"),UNDO(6, "申请过期");

	private int status;
	private String desc;

	private AuditInfoStateEnum(int status, String desc) {
		this.status = status;
		this.desc = desc;
	}

	public int getStatus() {
		return status;
	}

	public String getDesc() {
		return desc;
	}

}
