package com.sdp.mc.common.model;

import java.io.Serializable;
import java.math.BigDecimal;

import net.sf.json.JSONObject;

public class AuditInfoRequestAdustLog implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 6231944212602514271L;
	// 申请额度
	private BigDecimal applyLimit;
	// 申请原因
	private String applyCause;
	// 附件材料地址
	private String attachment;
	// 审核说明
	private String auditDesc;
	// 结果结果 0 拒绝  1审核通过
	private String auditResult;
	// 审批通过额度字段
	private BigDecimal auditLimit;
	private String fileName;
	private String contentType;
	
	private String undoCause;
	private String undoOperator;
	private String undoOperatorId;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public BigDecimal getApplyLimit() {
		return applyLimit;
	}

	public void setApplyLimit(BigDecimal applyLimit) {
		this.applyLimit = applyLimit;
	}

	public String getApplyCause() {
		return applyCause;
	}

	public void setApplyCause(String applyCause) {
		this.applyCause = applyCause;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
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
	public String convertToJsonString() {
		return JSONObject.fromObject(this).toString();
	}

	public String getUndoCause() {
		return undoCause;
	}

	public void setUndoCause(String undoCause) {
		this.undoCause = undoCause;
	}

	public String getUndoOperator() {
		return undoOperator;
	}

	public void setUndoOperator(String undoOperator) {
		this.undoOperator = undoOperator;
	}

	public String getUndoOperatorId() {
		return undoOperatorId;
	}

	public void setUndoOperatorId(String undoOperatorId) {
		this.undoOperatorId = undoOperatorId;
	}
	
	
}
