package com.sdp.mc.newt0.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Newt0McLimitChangeDtlDOExample extends QueryBase {
    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_DTL.CHANGE_ID
     * column comments 变更ID
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    private Long changeId;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_DTL.REQ_ID
     * column comments 请求ID
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    private Long reqId;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_DTL.MC_NO
     * column comments 商户号
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    private String mcNo;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_DTL.POS_MC_TYPE
     * column comments 商户类型
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    private String posMcType;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_DTL.STATUS
     * column comments 变更状态 0：初始  1：变更成功  2：变更失败
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    private Integer status;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_DTL.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_DTL.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_DTL.MAX_LIMIT
     * column comments 最高额度
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    private BigDecimal maxLimit;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_DTL.MIN_LIMIT
     * column comments 最低额度
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    private BigDecimal minLimit;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_DTL.MESSAGE
     * column comments 变更消息
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    private String message;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_DTL.CFM_ID
     * column comments 修改变更表的ID
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    private Long cfmId;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_DTL.LIMIT_TYPE
     * column comments 额度类型(0 or null:临时额度,1:永久额度)
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    private String limitType;

    /**
     * This field corresponds to the database table NEWT0_MC_LIMIT_CHANGE_DTL
     * table comments 商户额度变更明细
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table NEWT0_MC_LIMIT_CHANGE_DTL
     * table comments 商户额度变更明细
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table NEWT0_MC_LIMIT_CHANGE_DTL
     * table comments 商户额度变更明细
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table NEWT0_MC_LIMIT_CHANGE_DTL
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public Newt0McLimitChangeDtlDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.CHANGE_ID
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_DTL.CHANGE_ID
     * column comments 变更ID
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public Long getChangeId() {
        return changeId;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.CHANGE_ID
     *
     * @param changeId the value for NEWT0_MC_LIMIT_CHANGE_DTL.CHANGE_ID
     * column comments 变更ID
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public void setChangeId(Long changeId) {
        this.changeId = changeId;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.REQ_ID
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_DTL.REQ_ID
     * column comments 请求ID
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public Long getReqId() {
        return reqId;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.REQ_ID
     *
     * @param reqId the value for NEWT0_MC_LIMIT_CHANGE_DTL.REQ_ID
     * column comments 请求ID
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.MC_NO
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_DTL.MC_NO
     * column comments 商户号
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public String getMcNo() {
        return mcNo;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.MC_NO
     *
     * @param mcNo the value for NEWT0_MC_LIMIT_CHANGE_DTL.MC_NO
     * column comments 商户号
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public void setMcNo(String mcNo) {
        this.mcNo = mcNo == null ? null : mcNo.trim();
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.POS_MC_TYPE
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_DTL.POS_MC_TYPE
     * column comments 商户类型
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public String getPosMcType() {
        return posMcType;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.POS_MC_TYPE
     *
     * @param posMcType the value for NEWT0_MC_LIMIT_CHANGE_DTL.POS_MC_TYPE
     * column comments 商户类型
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public void setPosMcType(String posMcType) {
        this.posMcType = posMcType == null ? null : posMcType.trim();
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.STATUS
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_DTL.STATUS
     * column comments 变更状态 0：初始  1：变更成功  2：变更失败
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.STATUS
     *
     * @param status the value for NEWT0_MC_LIMIT_CHANGE_DTL.STATUS
     * column comments 变更状态 0：初始  1：变更成功  2：变更失败
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.CREATE_TIME
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_DTL.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.CREATE_TIME
     *
     * @param createTime the value for NEWT0_MC_LIMIT_CHANGE_DTL.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.UPDATE_TIME
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_DTL.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.UPDATE_TIME
     *
     * @param updateTime the value for NEWT0_MC_LIMIT_CHANGE_DTL.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.MAX_LIMIT
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_DTL.MAX_LIMIT
     * column comments 最高额度
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public BigDecimal getMaxLimit() {
        return maxLimit;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.MAX_LIMIT
     *
     * @param maxLimit the value for NEWT0_MC_LIMIT_CHANGE_DTL.MAX_LIMIT
     * column comments 最高额度
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public void setMaxLimit(BigDecimal maxLimit) {
        this.maxLimit = maxLimit;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.MIN_LIMIT
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_DTL.MIN_LIMIT
     * column comments 最低额度
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public BigDecimal getMinLimit() {
        return minLimit;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.MIN_LIMIT
     *
     * @param minLimit the value for NEWT0_MC_LIMIT_CHANGE_DTL.MIN_LIMIT
     * column comments 最低额度
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public void setMinLimit(BigDecimal minLimit) {
        this.minLimit = minLimit;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.MESSAGE
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_DTL.MESSAGE
     * column comments 变更消息
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.MESSAGE
     *
     * @param message the value for NEWT0_MC_LIMIT_CHANGE_DTL.MESSAGE
     * column comments 变更消息
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.CFM_ID
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_DTL.CFM_ID
     * column comments 修改变更表的ID
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public Long getCfmId() {
        return cfmId;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.CFM_ID
     *
     * @param cfmId the value for NEWT0_MC_LIMIT_CHANGE_DTL.CFM_ID
     * column comments 修改变更表的ID
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public void setCfmId(Long cfmId) {
        this.cfmId = cfmId;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.LIMIT_TYPE
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_DTL.LIMIT_TYPE
     * column comments 额度类型(0 or null:临时额度,1:永久额度)
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public String getLimitType() {
        return limitType;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.LIMIT_TYPE
     *
     * @param limitType the value for NEWT0_MC_LIMIT_CHANGE_DTL.LIMIT_TYPE
     * column comments 额度类型(0 or null:临时额度,1:永久额度)
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public void setLimitType(String limitType) {
        this.limitType = limitType == null ? null : limitType.trim();
    }

    /**
     * This method corresponds to the database table NEWT0_MC_LIMIT_CHANGE_DTL
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table NEWT0_MC_LIMIT_CHANGE_DTL
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table NEWT0_MC_LIMIT_CHANGE_DTL
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table NEWT0_MC_LIMIT_CHANGE_DTL
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table NEWT0_MC_LIMIT_CHANGE_DTL
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table NEWT0_MC_LIMIT_CHANGE_DTL
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table NEWT0_MC_LIMIT_CHANGE_DTL
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table NEWT0_MC_LIMIT_CHANGE_DTL
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table NEWT0_MC_LIMIT_CHANGE_DTL
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table NEWT0_MC_LIMIT_CHANGE_DTL
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table NEWT0_MC_LIMIT_CHANGE_DTL
     * table comment :商户额度变更明细
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
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

        public Criteria andChangeIdIsNull() {
            addCriterion("CHANGE_ID is null");
            return (Criteria) this;
        }

        public Criteria andChangeIdIsNotNull() {
            addCriterion("CHANGE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChangeIdEqualTo(Long value) {
            addCriterion("CHANGE_ID =", value, "changeId");
            return (Criteria) this;
        }

        public Criteria andChangeIdNotEqualTo(Long value) {
            addCriterion("CHANGE_ID <>", value, "changeId");
            return (Criteria) this;
        }

        public Criteria andChangeIdGreaterThan(Long value) {
            addCriterion("CHANGE_ID >", value, "changeId");
            return (Criteria) this;
        }

        public Criteria andChangeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("CHANGE_ID >=", value, "changeId");
            return (Criteria) this;
        }

        public Criteria andChangeIdLessThan(Long value) {
            addCriterion("CHANGE_ID <", value, "changeId");
            return (Criteria) this;
        }

        public Criteria andChangeIdLessThanOrEqualTo(Long value) {
            addCriterion("CHANGE_ID <=", value, "changeId");
            return (Criteria) this;
        }

        public Criteria andChangeIdIn(List<Long> values) {
            addCriterion("CHANGE_ID in", values, "changeId");
            return (Criteria) this;
        }

        public Criteria andChangeIdNotIn(List<Long> values) {
            addCriterion("CHANGE_ID not in", values, "changeId");
            return (Criteria) this;
        }

        public Criteria andChangeIdBetween(Long value1, Long value2) {
            addCriterion("CHANGE_ID between", value1, value2, "changeId");
            return (Criteria) this;
        }

        public Criteria andChangeIdNotBetween(Long value1, Long value2) {
            addCriterion("CHANGE_ID not between", value1, value2, "changeId");
            return (Criteria) this;
        }

        public Criteria andReqIdIsNull() {
            addCriterion("REQ_ID is null");
            return (Criteria) this;
        }

        public Criteria andReqIdIsNotNull() {
            addCriterion("REQ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andReqIdEqualTo(Long value) {
            addCriterion("REQ_ID =", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdNotEqualTo(Long value) {
            addCriterion("REQ_ID <>", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdGreaterThan(Long value) {
            addCriterion("REQ_ID >", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REQ_ID >=", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdLessThan(Long value) {
            addCriterion("REQ_ID <", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdLessThanOrEqualTo(Long value) {
            addCriterion("REQ_ID <=", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdIn(List<Long> values) {
            addCriterion("REQ_ID in", values, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdNotIn(List<Long> values) {
            addCriterion("REQ_ID not in", values, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdBetween(Long value1, Long value2) {
            addCriterion("REQ_ID between", value1, value2, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdNotBetween(Long value1, Long value2) {
            addCriterion("REQ_ID not between", value1, value2, "reqId");
            return (Criteria) this;
        }

        public Criteria andMcNoIsNull() {
            addCriterion("MC_NO is null");
            return (Criteria) this;
        }

        public Criteria andMcNoIsNotNull() {
            addCriterion("MC_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMcNoEqualTo(String value) {
            addCriterion("MC_NO =", value, "mcNo");
            return (Criteria) this;
        }

        public Criteria andMcNoNotEqualTo(String value) {
            addCriterion("MC_NO <>", value, "mcNo");
            return (Criteria) this;
        }

        public Criteria andMcNoGreaterThan(String value) {
            addCriterion("MC_NO >", value, "mcNo");
            return (Criteria) this;
        }

        public Criteria andMcNoGreaterThanOrEqualTo(String value) {
            addCriterion("MC_NO >=", value, "mcNo");
            return (Criteria) this;
        }

        public Criteria andMcNoLessThan(String value) {
            addCriterion("MC_NO <", value, "mcNo");
            return (Criteria) this;
        }

        public Criteria andMcNoLessThanOrEqualTo(String value) {
            addCriterion("MC_NO <=", value, "mcNo");
            return (Criteria) this;
        }

        public Criteria andMcNoLike(String value) {
            addCriterion("MC_NO like", value, "mcNo");
            return (Criteria) this;
        }

        public Criteria andMcNoNotLike(String value) {
            addCriterion("MC_NO not like", value, "mcNo");
            return (Criteria) this;
        }

        public Criteria andMcNoIn(List<String> values) {
            addCriterion("MC_NO in", values, "mcNo");
            return (Criteria) this;
        }

        public Criteria andMcNoNotIn(List<String> values) {
            addCriterion("MC_NO not in", values, "mcNo");
            return (Criteria) this;
        }

        public Criteria andMcNoBetween(String value1, String value2) {
            addCriterion("MC_NO between", value1, value2, "mcNo");
            return (Criteria) this;
        }

        public Criteria andMcNoNotBetween(String value1, String value2) {
            addCriterion("MC_NO not between", value1, value2, "mcNo");
            return (Criteria) this;
        }

        public Criteria andPosMcTypeIsNull() {
            addCriterion("POS_MC_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPosMcTypeIsNotNull() {
            addCriterion("POS_MC_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPosMcTypeEqualTo(String value) {
            addCriterion("POS_MC_TYPE =", value, "posMcType");
            return (Criteria) this;
        }

        public Criteria andPosMcTypeNotEqualTo(String value) {
            addCriterion("POS_MC_TYPE <>", value, "posMcType");
            return (Criteria) this;
        }

        public Criteria andPosMcTypeGreaterThan(String value) {
            addCriterion("POS_MC_TYPE >", value, "posMcType");
            return (Criteria) this;
        }

        public Criteria andPosMcTypeGreaterThanOrEqualTo(String value) {
            addCriterion("POS_MC_TYPE >=", value, "posMcType");
            return (Criteria) this;
        }

        public Criteria andPosMcTypeLessThan(String value) {
            addCriterion("POS_MC_TYPE <", value, "posMcType");
            return (Criteria) this;
        }

        public Criteria andPosMcTypeLessThanOrEqualTo(String value) {
            addCriterion("POS_MC_TYPE <=", value, "posMcType");
            return (Criteria) this;
        }

        public Criteria andPosMcTypeLike(String value) {
            addCriterion("POS_MC_TYPE like", value, "posMcType");
            return (Criteria) this;
        }

        public Criteria andPosMcTypeNotLike(String value) {
            addCriterion("POS_MC_TYPE not like", value, "posMcType");
            return (Criteria) this;
        }

        public Criteria andPosMcTypeIn(List<String> values) {
            addCriterion("POS_MC_TYPE in", values, "posMcType");
            return (Criteria) this;
        }

        public Criteria andPosMcTypeNotIn(List<String> values) {
            addCriterion("POS_MC_TYPE not in", values, "posMcType");
            return (Criteria) this;
        }

        public Criteria andPosMcTypeBetween(String value1, String value2) {
            addCriterion("POS_MC_TYPE between", value1, value2, "posMcType");
            return (Criteria) this;
        }

        public Criteria andPosMcTypeNotBetween(String value1, String value2) {
            addCriterion("POS_MC_TYPE not between", value1, value2, "posMcType");
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

        public Criteria andMaxLimitIsNull() {
            addCriterion("MAX_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andMaxLimitIsNotNull() {
            addCriterion("MAX_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andMaxLimitEqualTo(BigDecimal value) {
            addCriterion("MAX_LIMIT =", value, "maxLimit");
            return (Criteria) this;
        }

        public Criteria andMaxLimitNotEqualTo(BigDecimal value) {
            addCriterion("MAX_LIMIT <>", value, "maxLimit");
            return (Criteria) this;
        }

        public Criteria andMaxLimitGreaterThan(BigDecimal value) {
            addCriterion("MAX_LIMIT >", value, "maxLimit");
            return (Criteria) this;
        }

        public Criteria andMaxLimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MAX_LIMIT >=", value, "maxLimit");
            return (Criteria) this;
        }

        public Criteria andMaxLimitLessThan(BigDecimal value) {
            addCriterion("MAX_LIMIT <", value, "maxLimit");
            return (Criteria) this;
        }

        public Criteria andMaxLimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MAX_LIMIT <=", value, "maxLimit");
            return (Criteria) this;
        }

        public Criteria andMaxLimitIn(List<BigDecimal> values) {
            addCriterion("MAX_LIMIT in", values, "maxLimit");
            return (Criteria) this;
        }

        public Criteria andMaxLimitNotIn(List<BigDecimal> values) {
            addCriterion("MAX_LIMIT not in", values, "maxLimit");
            return (Criteria) this;
        }

        public Criteria andMaxLimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAX_LIMIT between", value1, value2, "maxLimit");
            return (Criteria) this;
        }

        public Criteria andMaxLimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAX_LIMIT not between", value1, value2, "maxLimit");
            return (Criteria) this;
        }

        public Criteria andMinLimitIsNull() {
            addCriterion("MIN_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andMinLimitIsNotNull() {
            addCriterion("MIN_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andMinLimitEqualTo(BigDecimal value) {
            addCriterion("MIN_LIMIT =", value, "minLimit");
            return (Criteria) this;
        }

        public Criteria andMinLimitNotEqualTo(BigDecimal value) {
            addCriterion("MIN_LIMIT <>", value, "minLimit");
            return (Criteria) this;
        }

        public Criteria andMinLimitGreaterThan(BigDecimal value) {
            addCriterion("MIN_LIMIT >", value, "minLimit");
            return (Criteria) this;
        }

        public Criteria andMinLimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MIN_LIMIT >=", value, "minLimit");
            return (Criteria) this;
        }

        public Criteria andMinLimitLessThan(BigDecimal value) {
            addCriterion("MIN_LIMIT <", value, "minLimit");
            return (Criteria) this;
        }

        public Criteria andMinLimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MIN_LIMIT <=", value, "minLimit");
            return (Criteria) this;
        }

        public Criteria andMinLimitIn(List<BigDecimal> values) {
            addCriterion("MIN_LIMIT in", values, "minLimit");
            return (Criteria) this;
        }

        public Criteria andMinLimitNotIn(List<BigDecimal> values) {
            addCriterion("MIN_LIMIT not in", values, "minLimit");
            return (Criteria) this;
        }

        public Criteria andMinLimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MIN_LIMIT between", value1, value2, "minLimit");
            return (Criteria) this;
        }

        public Criteria andMinLimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MIN_LIMIT not between", value1, value2, "minLimit");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("MESSAGE is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("MESSAGE is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("MESSAGE =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("MESSAGE <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("MESSAGE >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("MESSAGE >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("MESSAGE <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("MESSAGE <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("MESSAGE like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("MESSAGE not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("MESSAGE in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("MESSAGE not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("MESSAGE between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("MESSAGE not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andCfmIdIsNull() {
            addCriterion("CFM_ID is null");
            return (Criteria) this;
        }

        public Criteria andCfmIdIsNotNull() {
            addCriterion("CFM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCfmIdEqualTo(Long value) {
            addCriterion("CFM_ID =", value, "cfmId");
            return (Criteria) this;
        }

        public Criteria andCfmIdNotEqualTo(Long value) {
            addCriterion("CFM_ID <>", value, "cfmId");
            return (Criteria) this;
        }

        public Criteria andCfmIdGreaterThan(Long value) {
            addCriterion("CFM_ID >", value, "cfmId");
            return (Criteria) this;
        }

        public Criteria andCfmIdGreaterThanOrEqualTo(Long value) {
            addCriterion("CFM_ID >=", value, "cfmId");
            return (Criteria) this;
        }

        public Criteria andCfmIdLessThan(Long value) {
            addCriterion("CFM_ID <", value, "cfmId");
            return (Criteria) this;
        }

        public Criteria andCfmIdLessThanOrEqualTo(Long value) {
            addCriterion("CFM_ID <=", value, "cfmId");
            return (Criteria) this;
        }

        public Criteria andCfmIdIn(List<Long> values) {
            addCriterion("CFM_ID in", values, "cfmId");
            return (Criteria) this;
        }

        public Criteria andCfmIdNotIn(List<Long> values) {
            addCriterion("CFM_ID not in", values, "cfmId");
            return (Criteria) this;
        }

        public Criteria andCfmIdBetween(Long value1, Long value2) {
            addCriterion("CFM_ID between", value1, value2, "cfmId");
            return (Criteria) this;
        }

        public Criteria andCfmIdNotBetween(Long value1, Long value2) {
            addCriterion("CFM_ID not between", value1, value2, "cfmId");
            return (Criteria) this;
        }

        public Criteria andLimitTypeIsNull() {
            addCriterion("LIMIT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andLimitTypeIsNotNull() {
            addCriterion("LIMIT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLimitTypeEqualTo(String value) {
            addCriterion("LIMIT_TYPE =", value, "limitType");
            return (Criteria) this;
        }

        public Criteria andLimitTypeNotEqualTo(String value) {
            addCriterion("LIMIT_TYPE <>", value, "limitType");
            return (Criteria) this;
        }

        public Criteria andLimitTypeGreaterThan(String value) {
            addCriterion("LIMIT_TYPE >", value, "limitType");
            return (Criteria) this;
        }

        public Criteria andLimitTypeGreaterThanOrEqualTo(String value) {
            addCriterion("LIMIT_TYPE >=", value, "limitType");
            return (Criteria) this;
        }

        public Criteria andLimitTypeLessThan(String value) {
            addCriterion("LIMIT_TYPE <", value, "limitType");
            return (Criteria) this;
        }

        public Criteria andLimitTypeLessThanOrEqualTo(String value) {
            addCriterion("LIMIT_TYPE <=", value, "limitType");
            return (Criteria) this;
        }

        public Criteria andLimitTypeLike(String value) {
            addCriterion("LIMIT_TYPE like", value, "limitType");
            return (Criteria) this;
        }

        public Criteria andLimitTypeNotLike(String value) {
            addCriterion("LIMIT_TYPE not like", value, "limitType");
            return (Criteria) this;
        }

        public Criteria andLimitTypeIn(List<String> values) {
            addCriterion("LIMIT_TYPE in", values, "limitType");
            return (Criteria) this;
        }

        public Criteria andLimitTypeNotIn(List<String> values) {
            addCriterion("LIMIT_TYPE not in", values, "limitType");
            return (Criteria) this;
        }

        public Criteria andLimitTypeBetween(String value1, String value2) {
            addCriterion("LIMIT_TYPE between", value1, value2, "limitType");
            return (Criteria) this;
        }

        public Criteria andLimitTypeNotBetween(String value1, String value2) {
            addCriterion("LIMIT_TYPE not between", value1, value2, "limitType");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table NEWT0_MC_LIMIT_CHANGE_DTL
     *
     * @mbggenerated do_not_delete_during_merge Mon Aug 08 14:06:22 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table NEWT0_MC_LIMIT_CHANGE_DTL
     * table comment :商户额度变更明细
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
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