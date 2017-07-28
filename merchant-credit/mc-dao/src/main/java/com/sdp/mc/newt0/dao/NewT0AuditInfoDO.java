package com.sdp.mc.newt0.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.util.Date;

public class NewT0AuditInfoDO extends BaseDO {
    /**
     * This field corresponds to the database column NEWT0_AUDIT_INFO.ID
     * column comments null
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    private Long id;

    /**
     * This field corresponds to the database column NEWT0_AUDIT_INFO.OBJ_NO
     * column comments 商户号
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    private String objNo;

    /**
     * This field corresponds to the database column NEWT0_AUDIT_INFO.OBJ_ID
     * column comments 对象ID
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    private Long objId;

    /**
     * This field corresponds to the database column NEWT0_AUDIT_INFO.OBJ_TYPE
     * column comments 对象类型
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    private Integer objType;

    /**
     * This field corresponds to the database column NEWT0_AUDIT_INFO.OP_TYPE
     * column comments 操作类型
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    private Integer opType;

    /**
     * This field corresponds to the database column NEWT0_AUDIT_INFO.REQUEST_LOG
     * column comments 请求信息json
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    private String requestLog;

    /**
     * This field corresponds to the database column NEWT0_AUDIT_INFO.STATUS
     * column comments 状态：1待审核,2审核中,3已审核,4拒绝
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    private Integer status;

    /**
     * This field corresponds to the database column NEWT0_AUDIT_INFO.CREATE_TIME
     * column comments 更新时间
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column NEWT0_AUDIT_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column NEWT0_AUDIT_INFO.OPERATOR
     * column comments 操作员
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    private String operator;

    /**
     * This field corresponds to the database column NEWT0_AUDIT_INFO.OPERATOR_ID
     * column comments 操作员ID
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    private String operatorId;

    /**
     * This field corresponds to the database column NEWT0_AUDIT_INFO.EXPIRE_TIME
     * column comments 过期时间
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    private Date expireTime;

    /**
     * This field corresponds to the database column NEWT0_AUDIT_INFO.MCTYPE
     * column comments 商户类型
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    private String mcType;

    /**
     * This field corresponds to the database column NEWT0_AUDIT_INFO.AUDIT_TIME
     * column comments 审批时间
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    private Date auditTime;

    /**
     * This method returns the value of the database column NEWT0_AUDIT_INFO.ID
     *
     * @return the value of NEWT0_AUDIT_INFO.ID
     * column comments null
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column NEWT0_AUDIT_INFO.ID
     *
     * @param id the value for NEWT0_AUDIT_INFO.ID
     * column comments null
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column NEWT0_AUDIT_INFO.OBJ_NO
     *
     * @return the value of NEWT0_AUDIT_INFO.OBJ_NO
     * column comments 商户号
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public String getObjNo() {
        return objNo;
    }

    /**
     * This method sets the value of the database column NEWT0_AUDIT_INFO.OBJ_NO
     *
     * @param objNo the value for NEWT0_AUDIT_INFO.OBJ_NO
     * column comments 商户号
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public void setObjNo(String objNo) {
        this.objNo = objNo == null ? null : objNo.trim();
    }

    /**
     * This method returns the value of the database column NEWT0_AUDIT_INFO.OBJ_ID
     *
     * @return the value of NEWT0_AUDIT_INFO.OBJ_ID
     * column comments 对象ID
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public Long getObjId() {
        return objId;
    }

    /**
     * This method sets the value of the database column NEWT0_AUDIT_INFO.OBJ_ID
     *
     * @param objId the value for NEWT0_AUDIT_INFO.OBJ_ID
     * column comments 对象ID
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public void setObjId(Long objId) {
        this.objId = objId;
    }

    /**
     * This method returns the value of the database column NEWT0_AUDIT_INFO.OBJ_TYPE
     *
     * @return the value of NEWT0_AUDIT_INFO.OBJ_TYPE
     * column comments 对象类型
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public Integer getObjType() {
        return objType;
    }

    /**
     * This method sets the value of the database column NEWT0_AUDIT_INFO.OBJ_TYPE
     *
     * @param objType the value for NEWT0_AUDIT_INFO.OBJ_TYPE
     * column comments 对象类型
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public void setObjType(Integer objType) {
        this.objType = objType;
    }

    /**
     * This method returns the value of the database column NEWT0_AUDIT_INFO.OP_TYPE
     *
     * @return the value of NEWT0_AUDIT_INFO.OP_TYPE
     * column comments 操作类型
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public Integer getOpType() {
        return opType;
    }

    /**
     * This method sets the value of the database column NEWT0_AUDIT_INFO.OP_TYPE
     *
     * @param opType the value for NEWT0_AUDIT_INFO.OP_TYPE
     * column comments 操作类型
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public void setOpType(Integer opType) {
        this.opType = opType;
    }

    /**
     * This method returns the value of the database column NEWT0_AUDIT_INFO.REQUEST_LOG
     *
     * @return the value of NEWT0_AUDIT_INFO.REQUEST_LOG
     * column comments 请求信息json
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public String getRequestLog() {
        return requestLog;
    }

    /**
     * This method sets the value of the database column NEWT0_AUDIT_INFO.REQUEST_LOG
     *
     * @param requestLog the value for NEWT0_AUDIT_INFO.REQUEST_LOG
     * column comments 请求信息json
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public void setRequestLog(String requestLog) {
        this.requestLog = requestLog == null ? null : requestLog.trim();
    }

    /**
     * This method returns the value of the database column NEWT0_AUDIT_INFO.STATUS
     *
     * @return the value of NEWT0_AUDIT_INFO.STATUS
     * column comments 状态：1待审核,2审核中,3已审核,4拒绝
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column NEWT0_AUDIT_INFO.STATUS
     *
     * @param status the value for NEWT0_AUDIT_INFO.STATUS
     * column comments 状态：1待审核,2审核中,3已审核,4拒绝
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column NEWT0_AUDIT_INFO.CREATE_TIME
     *
     * @return the value of NEWT0_AUDIT_INFO.CREATE_TIME
     * column comments 更新时间
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column NEWT0_AUDIT_INFO.CREATE_TIME
     *
     * @param createTime the value for NEWT0_AUDIT_INFO.CREATE_TIME
     * column comments 更新时间
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column NEWT0_AUDIT_INFO.UPDATE_TIME
     *
     * @return the value of NEWT0_AUDIT_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column NEWT0_AUDIT_INFO.UPDATE_TIME
     *
     * @param updateTime the value for NEWT0_AUDIT_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column NEWT0_AUDIT_INFO.OPERATOR
     *
     * @return the value of NEWT0_AUDIT_INFO.OPERATOR
     * column comments 操作员
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method sets the value of the database column NEWT0_AUDIT_INFO.OPERATOR
     *
     * @param operator the value for NEWT0_AUDIT_INFO.OPERATOR
     * column comments 操作员
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * This method returns the value of the database column NEWT0_AUDIT_INFO.OPERATOR_ID
     *
     * @return the value of NEWT0_AUDIT_INFO.OPERATOR_ID
     * column comments 操作员ID
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * This method sets the value of the database column NEWT0_AUDIT_INFO.OPERATOR_ID
     *
     * @param operatorId the value for NEWT0_AUDIT_INFO.OPERATOR_ID
     * column comments 操作员ID
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    /**
     * This method returns the value of the database column NEWT0_AUDIT_INFO.EXPIRE_TIME
     *
     * @return the value of NEWT0_AUDIT_INFO.EXPIRE_TIME
     * column comments 过期时间
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * This method sets the value of the database column NEWT0_AUDIT_INFO.EXPIRE_TIME
     *
     * @param expireTime the value for NEWT0_AUDIT_INFO.EXPIRE_TIME
     * column comments 过期时间
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * This method returns the value of the database column NEWT0_AUDIT_INFO.MCTYPE
     *
     * @return the value of NEWT0_AUDIT_INFO.MCTYPE
     * column comments 商户类型
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public String getMcType() {
        return mcType;
    }

    /**
     * This method sets the value of the database column NEWT0_AUDIT_INFO.MCTYPE
     *
     * @param mcType the value for NEWT0_AUDIT_INFO.MCTYPE
     * column comments 商户类型
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public void setMcType(String mcType) {
        this.mcType = mcType == null ? null : mcType.trim();
    }

    /**
     * This method returns the value of the database column NEWT0_AUDIT_INFO.AUDIT_TIME
     *
     * @return the value of NEWT0_AUDIT_INFO.AUDIT_TIME
     * column comments 审批时间
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * This method sets the value of the database column NEWT0_AUDIT_INFO.AUDIT_TIME
     *
     * @param auditTime the value for NEWT0_AUDIT_INFO.AUDIT_TIME
     * column comments 审批时间
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }
}