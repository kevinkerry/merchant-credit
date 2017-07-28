package com.sdp.mc.newt0.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewT0AuditInfoDOExample extends QueryBase {
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
     * This field corresponds to the database table NEWT0_AUDIT_INFO
     * table comments 审核表
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table NEWT0_AUDIT_INFO
     * table comments 审核表
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table NEWT0_AUDIT_INFO
     * table comments 审核表
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table NEWT0_AUDIT_INFO
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public NewT0AuditInfoDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

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

    /**
     * This method corresponds to the database table NEWT0_AUDIT_INFO
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table NEWT0_AUDIT_INFO
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table NEWT0_AUDIT_INFO
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table NEWT0_AUDIT_INFO
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table NEWT0_AUDIT_INFO
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table NEWT0_AUDIT_INFO
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table NEWT0_AUDIT_INFO
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table NEWT0_AUDIT_INFO
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table NEWT0_AUDIT_INFO
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table NEWT0_AUDIT_INFO
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table NEWT0_AUDIT_INFO
     * table comment :审核表
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andObjNoIsNull() {
            addCriterion("OBJ_NO is null");
            return (Criteria) this;
        }

        public Criteria andObjNoIsNotNull() {
            addCriterion("OBJ_NO is not null");
            return (Criteria) this;
        }

        public Criteria andObjNoEqualTo(String value) {
            addCriterion("OBJ_NO =", value, "objNo");
            return (Criteria) this;
        }

        public Criteria andObjNoNotEqualTo(String value) {
            addCriterion("OBJ_NO <>", value, "objNo");
            return (Criteria) this;
        }

        public Criteria andObjNoGreaterThan(String value) {
            addCriterion("OBJ_NO >", value, "objNo");
            return (Criteria) this;
        }

        public Criteria andObjNoGreaterThanOrEqualTo(String value) {
            addCriterion("OBJ_NO >=", value, "objNo");
            return (Criteria) this;
        }

        public Criteria andObjNoLessThan(String value) {
            addCriterion("OBJ_NO <", value, "objNo");
            return (Criteria) this;
        }

        public Criteria andObjNoLessThanOrEqualTo(String value) {
            addCriterion("OBJ_NO <=", value, "objNo");
            return (Criteria) this;
        }

        public Criteria andObjNoLike(String value) {
            addCriterion("OBJ_NO like", value, "objNo");
            return (Criteria) this;
        }

        public Criteria andObjNoNotLike(String value) {
            addCriterion("OBJ_NO not like", value, "objNo");
            return (Criteria) this;
        }

        public Criteria andObjNoIn(List<String> values) {
            addCriterion("OBJ_NO in", values, "objNo");
            return (Criteria) this;
        }

        public Criteria andObjNoNotIn(List<String> values) {
            addCriterion("OBJ_NO not in", values, "objNo");
            return (Criteria) this;
        }

        public Criteria andObjNoBetween(String value1, String value2) {
            addCriterion("OBJ_NO between", value1, value2, "objNo");
            return (Criteria) this;
        }

        public Criteria andObjNoNotBetween(String value1, String value2) {
            addCriterion("OBJ_NO not between", value1, value2, "objNo");
            return (Criteria) this;
        }

        public Criteria andObjIdIsNull() {
            addCriterion("OBJ_ID is null");
            return (Criteria) this;
        }

        public Criteria andObjIdIsNotNull() {
            addCriterion("OBJ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andObjIdEqualTo(Long value) {
            addCriterion("OBJ_ID =", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdNotEqualTo(Long value) {
            addCriterion("OBJ_ID <>", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdGreaterThan(Long value) {
            addCriterion("OBJ_ID >", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdGreaterThanOrEqualTo(Long value) {
            addCriterion("OBJ_ID >=", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdLessThan(Long value) {
            addCriterion("OBJ_ID <", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdLessThanOrEqualTo(Long value) {
            addCriterion("OBJ_ID <=", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdIn(List<Long> values) {
            addCriterion("OBJ_ID in", values, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdNotIn(List<Long> values) {
            addCriterion("OBJ_ID not in", values, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdBetween(Long value1, Long value2) {
            addCriterion("OBJ_ID between", value1, value2, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdNotBetween(Long value1, Long value2) {
            addCriterion("OBJ_ID not between", value1, value2, "objId");
            return (Criteria) this;
        }

        public Criteria andObjTypeIsNull() {
            addCriterion("OBJ_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andObjTypeIsNotNull() {
            addCriterion("OBJ_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andObjTypeEqualTo(Integer value) {
            addCriterion("OBJ_TYPE =", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeNotEqualTo(Integer value) {
            addCriterion("OBJ_TYPE <>", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeGreaterThan(Integer value) {
            addCriterion("OBJ_TYPE >", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("OBJ_TYPE >=", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeLessThan(Integer value) {
            addCriterion("OBJ_TYPE <", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeLessThanOrEqualTo(Integer value) {
            addCriterion("OBJ_TYPE <=", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeIn(List<Integer> values) {
            addCriterion("OBJ_TYPE in", values, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeNotIn(List<Integer> values) {
            addCriterion("OBJ_TYPE not in", values, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeBetween(Integer value1, Integer value2) {
            addCriterion("OBJ_TYPE between", value1, value2, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("OBJ_TYPE not between", value1, value2, "objType");
            return (Criteria) this;
        }

        public Criteria andOpTypeIsNull() {
            addCriterion("OP_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOpTypeIsNotNull() {
            addCriterion("OP_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOpTypeEqualTo(Integer value) {
            addCriterion("OP_TYPE =", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotEqualTo(Integer value) {
            addCriterion("OP_TYPE <>", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeGreaterThan(Integer value) {
            addCriterion("OP_TYPE >", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("OP_TYPE >=", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeLessThan(Integer value) {
            addCriterion("OP_TYPE <", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeLessThanOrEqualTo(Integer value) {
            addCriterion("OP_TYPE <=", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeIn(List<Integer> values) {
            addCriterion("OP_TYPE in", values, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotIn(List<Integer> values) {
            addCriterion("OP_TYPE not in", values, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeBetween(Integer value1, Integer value2) {
            addCriterion("OP_TYPE between", value1, value2, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("OP_TYPE not between", value1, value2, "opType");
            return (Criteria) this;
        }

        public Criteria andRequestLogIsNull() {
            addCriterion("REQUEST_LOG is null");
            return (Criteria) this;
        }

        public Criteria andRequestLogIsNotNull() {
            addCriterion("REQUEST_LOG is not null");
            return (Criteria) this;
        }

        public Criteria andRequestLogEqualTo(String value) {
            addCriterion("REQUEST_LOG =", value, "requestLog");
            return (Criteria) this;
        }

        public Criteria andRequestLogNotEqualTo(String value) {
            addCriterion("REQUEST_LOG <>", value, "requestLog");
            return (Criteria) this;
        }

        public Criteria andRequestLogGreaterThan(String value) {
            addCriterion("REQUEST_LOG >", value, "requestLog");
            return (Criteria) this;
        }

        public Criteria andRequestLogGreaterThanOrEqualTo(String value) {
            addCriterion("REQUEST_LOG >=", value, "requestLog");
            return (Criteria) this;
        }

        public Criteria andRequestLogLessThan(String value) {
            addCriterion("REQUEST_LOG <", value, "requestLog");
            return (Criteria) this;
        }

        public Criteria andRequestLogLessThanOrEqualTo(String value) {
            addCriterion("REQUEST_LOG <=", value, "requestLog");
            return (Criteria) this;
        }

        public Criteria andRequestLogLike(String value) {
            addCriterion("REQUEST_LOG like", value, "requestLog");
            return (Criteria) this;
        }

        public Criteria andRequestLogNotLike(String value) {
            addCriterion("REQUEST_LOG not like", value, "requestLog");
            return (Criteria) this;
        }

        public Criteria andRequestLogIn(List<String> values) {
            addCriterion("REQUEST_LOG in", values, "requestLog");
            return (Criteria) this;
        }

        public Criteria andRequestLogNotIn(List<String> values) {
            addCriterion("REQUEST_LOG not in", values, "requestLog");
            return (Criteria) this;
        }

        public Criteria andRequestLogBetween(String value1, String value2) {
            addCriterion("REQUEST_LOG between", value1, value2, "requestLog");
            return (Criteria) this;
        }

        public Criteria andRequestLogNotBetween(String value1, String value2) {
            addCriterion("REQUEST_LOG not between", value1, value2, "requestLog");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("OPERATOR is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("OPERATOR is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("OPERATOR =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("OPERATOR <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("OPERATOR >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATOR >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("OPERATOR <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("OPERATOR <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("OPERATOR like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("OPERATOR not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("OPERATOR in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("OPERATOR not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("OPERATOR between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("OPERATOR not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNull() {
            addCriterion("OPERATOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNotNull() {
            addCriterion("OPERATOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdEqualTo(String value) {
            addCriterion("OPERATOR_ID =", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotEqualTo(String value) {
            addCriterion("OPERATOR_ID <>", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThan(String value) {
            addCriterion("OPERATOR_ID >", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATOR_ID >=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThan(String value) {
            addCriterion("OPERATOR_ID <", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThanOrEqualTo(String value) {
            addCriterion("OPERATOR_ID <=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLike(String value) {
            addCriterion("OPERATOR_ID like", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotLike(String value) {
            addCriterion("OPERATOR_ID not like", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIn(List<String> values) {
            addCriterion("OPERATOR_ID in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotIn(List<String> values) {
            addCriterion("OPERATOR_ID not in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdBetween(String value1, String value2) {
            addCriterion("OPERATOR_ID between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotBetween(String value1, String value2) {
            addCriterion("OPERATOR_ID not between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNull() {
            addCriterion("EXPIRE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNotNull() {
            addCriterion("EXPIRE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeEqualTo(Date value) {
            addCriterion("EXPIRE_TIME =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(Date value) {
            addCriterion("EXPIRE_TIME <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(Date value) {
            addCriterion("EXPIRE_TIME >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EXPIRE_TIME >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(Date value) {
            addCriterion("EXPIRE_TIME <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(Date value) {
            addCriterion("EXPIRE_TIME <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<Date> values) {
            addCriterion("EXPIRE_TIME in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<Date> values) {
            addCriterion("EXPIRE_TIME not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(Date value1, Date value2) {
            addCriterion("EXPIRE_TIME between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(Date value1, Date value2) {
            addCriterion("EXPIRE_TIME not between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andMcTypeIsNull() {
            addCriterion("MCTYPE is null");
            return (Criteria) this;
        }

        public Criteria andMcTypeIsNotNull() {
            addCriterion("MCTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMcTypeEqualTo(String value) {
            addCriterion("MCTYPE =", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeNotEqualTo(String value) {
            addCriterion("MCTYPE <>", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeGreaterThan(String value) {
            addCriterion("MCTYPE >", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MCTYPE >=", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeLessThan(String value) {
            addCriterion("MCTYPE <", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeLessThanOrEqualTo(String value) {
            addCriterion("MCTYPE <=", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeLike(String value) {
            addCriterion("MCTYPE like", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeNotLike(String value) {
            addCriterion("MCTYPE not like", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeIn(List<String> values) {
            addCriterion("MCTYPE in", values, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeNotIn(List<String> values) {
            addCriterion("MCTYPE not in", values, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeBetween(String value1, String value2) {
            addCriterion("MCTYPE between", value1, value2, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeNotBetween(String value1, String value2) {
            addCriterion("MCTYPE not between", value1, value2, "mcType");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNull() {
            addCriterion("AUDIT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNotNull() {
            addCriterion("AUDIT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeEqualTo(Date value) {
            addCriterion("AUDIT_TIME =", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotEqualTo(Date value) {
            addCriterion("AUDIT_TIME <>", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThan(Date value) {
            addCriterion("AUDIT_TIME >", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("AUDIT_TIME >=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThan(Date value) {
            addCriterion("AUDIT_TIME <", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("AUDIT_TIME <=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIn(List<Date> values) {
            addCriterion("AUDIT_TIME in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotIn(List<Date> values) {
            addCriterion("AUDIT_TIME not in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeBetween(Date value1, Date value2) {
            addCriterion("AUDIT_TIME between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("AUDIT_TIME not between", value1, value2, "auditTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table NEWT0_AUDIT_INFO
     *
     * @mbggenerated do_not_delete_during_merge Mon Jun 06 17:21:26 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table NEWT0_AUDIT_INFO
     * table comment :审核表
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}