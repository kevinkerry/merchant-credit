package com.sdp.mc.web.dto;

public class MarginOpReqDTO {

	String morId;
	String createTime;
	String opType;
	String amount;
	String status;
	String statusName;

	public String getMorId() {
		return morId;
	}

	public void setMorId(String morId) {
		this.morId = morId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getOpType() {
		return opType;
	}

	public void setOpType(String opType) {
		this.opType = opType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}
