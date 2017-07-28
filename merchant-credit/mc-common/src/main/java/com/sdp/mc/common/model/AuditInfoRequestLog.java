package com.sdp.mc.common.model;

import java.math.BigDecimal;

import net.sf.json.JSONObject;

public class AuditInfoRequestLog {

	private int opType;// 操作类型
	private BigDecimal fastSettleMargin;// 保证金金额
	private Integer loaningType;
	// 审核说明
	private String auditDesc;
	// 结果结果 0 拒绝 1审核通过
	private String auditResult;
	// 审批通过额度字段
	private BigDecimal auditLimit;

	public int getOpType() {
		return opType;
	}

	public void setOpType(int opType) {
		this.opType = opType;
	}

	public BigDecimal getFastSettleMargin() {
		return fastSettleMargin;
	}

	public void setFastSettleMargin(BigDecimal fastSettleMargin) {
		this.fastSettleMargin = fastSettleMargin;
	}

	public String convertToJsonString() {
		return JSONObject.fromObject(this).toString();
	}

	public Integer getLoaningType() {
		return loaningType;
	}

	public void setLoaningType(Integer loaningType) {
		this.loaningType = loaningType;
	}

	public String getAuditDesc() {
		return auditDesc;
	}

	public void setAuditDesc(String auditDesc) {
		this.auditDesc = auditDesc;
	}

	public String getAuditResult() {
		return auditResult;
	}

	public void setAuditResult(String auditResult) {
		this.auditResult = auditResult;
	}

	public BigDecimal getAuditLimit() {
		return auditLimit;
	}

	public void setAuditLimit(BigDecimal auditLimit) {
		this.auditLimit = auditLimit;
	}

}
