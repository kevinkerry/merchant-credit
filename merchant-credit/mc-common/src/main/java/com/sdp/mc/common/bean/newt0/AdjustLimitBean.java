package com.sdp.mc.common.bean.newt0;

import java.io.Serializable;
import java.util.Date;

import com.sdp.mc.common.enums.LoaningTypeEnum;
import com.sdp.mc.common.model.AuditInfoRequestAdustLog;
import com.sdp.mc.common.util.DateUtil;

/**
 * 申请临时调额
 *
 * @author liutao
 *
 */
public class AdjustLimitBean implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private AuditInfoRequestAdustLog  reqBean=new AuditInfoRequestAdustLog();

	public AuditInfoRequestAdustLog getReqBean() {
		return reqBean;
	}
	public void setReqBean(AuditInfoRequestAdustLog reqBean) {
		this.reqBean = reqBean;
	}
	 /**
	  * 代理商垫资方类型 0代理商垫资 1盛付通垫资
	  */
	 private LoaningTypeEnum loaningType;
	 /**
	 * 申请时间，页面显示需要
	 */

	/**
	 * ID
	 */
	private Long id;

	/**
	 *商户号
	 */
	private String objNo;

	/**
	 *对象ID
	 */
	private Long objId;

	/**
	 *对象类型
	 */
	private Integer objType;

	/**
	 *操作类型
	 */
	private Integer opType;

	/**
	 *请求信息json
	 */
	private String requestLog;

	/**
	 *状态：1待审核,2审核中,3已审核,4拒绝
	 */
	private Integer status;

	/**
	 *更新时间
	 */
	private Date createTime;

	/**
     */
	private Date updateTime;

	/**
	 *操作员
	 */
	private String operator;

	/**
	 *操作员ID
	 */
	private String operatorId;

	/**
	 *过期时间
	 */
	private Date expireTime;

	/**
	 *商户类型
	 */
	private String mcType;

	/**
	 *审批时间
	 */
	private Date auditTime;

	/**
	 * 申请时间
	 */
	private String applyTimeStr;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getObjNo() {
		return objNo;
	}
	public void setObjNo(String objNo) {
		this.objNo = objNo;
	}
	public Long getObjId() {
		return objId;
	}
	public void setObjId(Long objId) {
		this.objId = objId;
	}
	public Integer getObjType() {
		return objType;
	}
	public void setObjType(Integer objType) {
		this.objType = objType;
	}
	public Integer getOpType() {
		return opType;
	}
	public void setOpType(Integer opType) {
		this.opType = opType;
	}
	public String getRequestLog() {
		return requestLog;
	}
	public void setRequestLog(String requestLog) {
		this.requestLog = requestLog;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	public String getMcType() {
		return mcType;
	}
	public void setMcType(String mcType) {
		this.mcType = mcType;
	}
	public Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	public LoaningTypeEnum getLoaningType() {
		return loaningType;
	}
	public void setLoaningType(LoaningTypeEnum loaningType) {
		this.loaningType = loaningType;
	}
	public String getApplyTimeStr() {
		return DateUtil.formatDate(this.createTime, DateUtil.default_pattern);
	}
	public void setApplyTimeStr(String applyTimeStr) {
		this.applyTimeStr = applyTimeStr;
	}
//	private String applyLimit;
//	private String applyCause;
//
//	public String getApplyLimit() {
//		return applyLimit;
//	}
//	public void setApplyLimit(String applyLimit) {
//		this.applyLimit = applyLimit;
//	}
//	public String getApplyCause() {
//		return applyCause;
//	}
//	public void setApplyCause(String applyCause) {
//		this.applyCause = applyCause;
//	}

}
