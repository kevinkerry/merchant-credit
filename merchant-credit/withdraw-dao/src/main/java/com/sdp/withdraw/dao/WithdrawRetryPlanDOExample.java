package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WithdrawRetryPlanDOExample extends QueryBase {
    /**
     * This field corresponds to the database column FW_WITHDRAW_RETRY_PLAN.PLAN_ID
     * column comments 计划ID
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    private Long planId;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RETRY_PLAN.REQ_ID
     * column comments 业务单的请求ID
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    private Long reqId;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RETRY_PLAN.CURRENT_REMIT_VOUCHER_NO
     * column comments 当前的支付订单号
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    private String currentRemitVoucherNo;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RETRY_PLAN.EXECUTE_REMIT_VOUCHER_NO
     * column comments 计划执行的支付订单号
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    private String executeRemitVoucherNo;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RETRY_PLAN.RETRY_RULE
     * column comments 重试规则
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    private String retryRule;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RETRY_PLAN.RETRY_EXECUTE_TIMES
     * column comments 计划执行任务是第几次重试
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    private Integer retryExecuteTimes;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RETRY_PLAN.EXECUTE_START_TIME
     * column comments 执行重试的开始时间点
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    private Date executeStartTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RETRY_PLAN.EXECUTE_STATUS
     * column comments 执行状态0 待执行 1执行中 2 执行结束
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    private Integer executeStatus;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RETRY_PLAN.EXECUTE_TIME
     * column comments 执行时间
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    private Date executeTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RETRY_PLAN.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RETRY_PLAN.UPDATE_TIME
     * column comments 最后修改时间
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    private Date updateTime;

    /**
     * This field corresponds to the database table FW_WITHDRAW_RETRY_PLAN
     * table comments 出款服务重试计划表
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table FW_WITHDRAW_RETRY_PLAN
     * table comments 出款服务重试计划表
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table FW_WITHDRAW_RETRY_PLAN
     * table comments 出款服务重试计划表
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table FW_WITHDRAW_RETRY_PLAN
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public WithdrawRetryPlanDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RETRY_PLAN.PLAN_ID
     *
     * @return the value of FW_WITHDRAW_RETRY_PLAN.PLAN_ID
     * column comments 计划ID
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public Long getPlanId() {
        return planId;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RETRY_PLAN.PLAN_ID
     *
     * @param planId the value for FW_WITHDRAW_RETRY_PLAN.PLAN_ID
     * column comments 计划ID
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RETRY_PLAN.REQ_ID
     *
     * @return the value of FW_WITHDRAW_RETRY_PLAN.REQ_ID
     * column comments 业务单的请求ID
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public Long getReqId() {
        return reqId;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RETRY_PLAN.REQ_ID
     *
     * @param reqId the value for FW_WITHDRAW_RETRY_PLAN.REQ_ID
     * column comments 业务单的请求ID
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RETRY_PLAN.CURRENT_REMIT_VOUCHER_NO
     *
     * @return the value of FW_WITHDRAW_RETRY_PLAN.CURRENT_REMIT_VOUCHER_NO
     * column comments 当前的支付订单号
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public String getCurrentRemitVoucherNo() {
        return currentRemitVoucherNo;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RETRY_PLAN.CURRENT_REMIT_VOUCHER_NO
     *
     * @param currentRemitVoucherNo the value for FW_WITHDRAW_RETRY_PLAN.CURRENT_REMIT_VOUCHER_NO
     * column comments 当前的支付订单号
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void setCurrentRemitVoucherNo(String currentRemitVoucherNo) {
        this.currentRemitVoucherNo = currentRemitVoucherNo == null ? null : currentRemitVoucherNo.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RETRY_PLAN.EXECUTE_REMIT_VOUCHER_NO
     *
     * @return the value of FW_WITHDRAW_RETRY_PLAN.EXECUTE_REMIT_VOUCHER_NO
     * column comments 计划执行的支付订单号
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public String getExecuteRemitVoucherNo() {
        return executeRemitVoucherNo;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RETRY_PLAN.EXECUTE_REMIT_VOUCHER_NO
     *
     * @param executeRemitVoucherNo the value for FW_WITHDRAW_RETRY_PLAN.EXECUTE_REMIT_VOUCHER_NO
     * column comments 计划执行的支付订单号
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void setExecuteRemitVoucherNo(String executeRemitVoucherNo) {
        this.executeRemitVoucherNo = executeRemitVoucherNo == null ? null : executeRemitVoucherNo.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RETRY_PLAN.RETRY_RULE
     *
     * @return the value of FW_WITHDRAW_RETRY_PLAN.RETRY_RULE
     * column comments 重试规则
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public String getRetryRule() {
        return retryRule;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RETRY_PLAN.RETRY_RULE
     *
     * @param retryRule the value for FW_WITHDRAW_RETRY_PLAN.RETRY_RULE
     * column comments 重试规则
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void setRetryRule(String retryRule) {
        this.retryRule = retryRule == null ? null : retryRule.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RETRY_PLAN.RETRY_EXECUTE_TIMES
     *
     * @return the value of FW_WITHDRAW_RETRY_PLAN.RETRY_EXECUTE_TIMES
     * column comments 计划执行任务是第几次重试
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public Integer getRetryExecuteTimes() {
        return retryExecuteTimes;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RETRY_PLAN.RETRY_EXECUTE_TIMES
     *
     * @param retryExecuteTimes the value for FW_WITHDRAW_RETRY_PLAN.RETRY_EXECUTE_TIMES
     * column comments 计划执行任务是第几次重试
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void setRetryExecuteTimes(Integer retryExecuteTimes) {
        this.retryExecuteTimes = retryExecuteTimes;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RETRY_PLAN.EXECUTE_START_TIME
     *
     * @return the value of FW_WITHDRAW_RETRY_PLAN.EXECUTE_START_TIME
     * column comments 执行重试的开始时间点
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public Date getExecuteStartTime() {
        return executeStartTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RETRY_PLAN.EXECUTE_START_TIME
     *
     * @param executeStartTime the value for FW_WITHDRAW_RETRY_PLAN.EXECUTE_START_TIME
     * column comments 执行重试的开始时间点
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void setExecuteStartTime(Date executeStartTime) {
        this.executeStartTime = executeStartTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RETRY_PLAN.EXECUTE_STATUS
     *
     * @return the value of FW_WITHDRAW_RETRY_PLAN.EXECUTE_STATUS
     * column comments 执行状态0 待执行 1执行中 2 执行结束
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public Integer getExecuteStatus() {
        return executeStatus;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RETRY_PLAN.EXECUTE_STATUS
     *
     * @param executeStatus the value for FW_WITHDRAW_RETRY_PLAN.EXECUTE_STATUS
     * column comments 执行状态0 待执行 1执行中 2 执行结束
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void setExecuteStatus(Integer executeStatus) {
        this.executeStatus = executeStatus;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RETRY_PLAN.EXECUTE_TIME
     *
     * @return the value of FW_WITHDRAW_RETRY_PLAN.EXECUTE_TIME
     * column comments 执行时间
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public Date getExecuteTime() {
        return executeTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RETRY_PLAN.EXECUTE_TIME
     *
     * @param executeTime the value for FW_WITHDRAW_RETRY_PLAN.EXECUTE_TIME
     * column comments 执行时间
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void setExecuteTime(Date executeTime) {
        this.executeTime = executeTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RETRY_PLAN.CREATE_TIME
     *
     * @return the value of FW_WITHDRAW_RETRY_PLAN.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RETRY_PLAN.CREATE_TIME
     *
     * @param createTime the value for FW_WITHDRAW_RETRY_PLAN.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RETRY_PLAN.UPDATE_TIME
     *
     * @return the value of FW_WITHDRAW_RETRY_PLAN.UPDATE_TIME
     * column comments 最后修改时间
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RETRY_PLAN.UPDATE_TIME
     *
     * @param updateTime the value for FW_WITHDRAW_RETRY_PLAN.UPDATE_TIME
     * column comments 最后修改时间
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_RETRY_PLAN
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_RETRY_PLAN
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_RETRY_PLAN
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_RETRY_PLAN
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_RETRY_PLAN
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_RETRY_PLAN
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_RETRY_PLAN
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_RETRY_PLAN
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_RETRY_PLAN
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_RETRY_PLAN
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WITHDRAW_RETRY_PLAN
     * table comment :出款服务重试计划表
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
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

        public Criteria andPlanIdIsNull() {
            addCriterion("PLAN_ID is null");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNotNull() {
            addCriterion("PLAN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPlanIdEqualTo(Long value) {
            addCriterion("PLAN_ID =", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotEqualTo(Long value) {
            addCriterion("PLAN_ID <>", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThan(Long value) {
            addCriterion("PLAN_ID >", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PLAN_ID >=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThan(Long value) {
            addCriterion("PLAN_ID <", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThanOrEqualTo(Long value) {
            addCriterion("PLAN_ID <=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdIn(List<Long> values) {
            addCriterion("PLAN_ID in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotIn(List<Long> values) {
            addCriterion("PLAN_ID not in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdBetween(Long value1, Long value2) {
            addCriterion("PLAN_ID between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotBetween(Long value1, Long value2) {
            addCriterion("PLAN_ID not between", value1, value2, "planId");
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

        public Criteria andCurrentRemitVoucherNoIsNull() {
            addCriterion("CURRENT_REMIT_VOUCHER_NO is null");
            return (Criteria) this;
        }

        public Criteria andCurrentRemitVoucherNoIsNotNull() {
            addCriterion("CURRENT_REMIT_VOUCHER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentRemitVoucherNoEqualTo(String value) {
            addCriterion("CURRENT_REMIT_VOUCHER_NO =", value, "currentRemitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andCurrentRemitVoucherNoNotEqualTo(String value) {
            addCriterion("CURRENT_REMIT_VOUCHER_NO <>", value, "currentRemitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andCurrentRemitVoucherNoGreaterThan(String value) {
            addCriterion("CURRENT_REMIT_VOUCHER_NO >", value, "currentRemitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andCurrentRemitVoucherNoGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENT_REMIT_VOUCHER_NO >=", value, "currentRemitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andCurrentRemitVoucherNoLessThan(String value) {
            addCriterion("CURRENT_REMIT_VOUCHER_NO <", value, "currentRemitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andCurrentRemitVoucherNoLessThanOrEqualTo(String value) {
            addCriterion("CURRENT_REMIT_VOUCHER_NO <=", value, "currentRemitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andCurrentRemitVoucherNoLike(String value) {
            addCriterion("CURRENT_REMIT_VOUCHER_NO like", value, "currentRemitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andCurrentRemitVoucherNoNotLike(String value) {
            addCriterion("CURRENT_REMIT_VOUCHER_NO not like", value, "currentRemitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andCurrentRemitVoucherNoIn(List<String> values) {
            addCriterion("CURRENT_REMIT_VOUCHER_NO in", values, "currentRemitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andCurrentRemitVoucherNoNotIn(List<String> values) {
            addCriterion("CURRENT_REMIT_VOUCHER_NO not in", values, "currentRemitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andCurrentRemitVoucherNoBetween(String value1, String value2) {
            addCriterion("CURRENT_REMIT_VOUCHER_NO between", value1, value2, "currentRemitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andCurrentRemitVoucherNoNotBetween(String value1, String value2) {
            addCriterion("CURRENT_REMIT_VOUCHER_NO not between", value1, value2, "currentRemitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andExecuteRemitVoucherNoIsNull() {
            addCriterion("EXECUTE_REMIT_VOUCHER_NO is null");
            return (Criteria) this;
        }

        public Criteria andExecuteRemitVoucherNoIsNotNull() {
            addCriterion("EXECUTE_REMIT_VOUCHER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteRemitVoucherNoEqualTo(String value) {
            addCriterion("EXECUTE_REMIT_VOUCHER_NO =", value, "executeRemitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andExecuteRemitVoucherNoNotEqualTo(String value) {
            addCriterion("EXECUTE_REMIT_VOUCHER_NO <>", value, "executeRemitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andExecuteRemitVoucherNoGreaterThan(String value) {
            addCriterion("EXECUTE_REMIT_VOUCHER_NO >", value, "executeRemitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andExecuteRemitVoucherNoGreaterThanOrEqualTo(String value) {
            addCriterion("EXECUTE_REMIT_VOUCHER_NO >=", value, "executeRemitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andExecuteRemitVoucherNoLessThan(String value) {
            addCriterion("EXECUTE_REMIT_VOUCHER_NO <", value, "executeRemitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andExecuteRemitVoucherNoLessThanOrEqualTo(String value) {
            addCriterion("EXECUTE_REMIT_VOUCHER_NO <=", value, "executeRemitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andExecuteRemitVoucherNoLike(String value) {
            addCriterion("EXECUTE_REMIT_VOUCHER_NO like", value, "executeRemitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andExecuteRemitVoucherNoNotLike(String value) {
            addCriterion("EXECUTE_REMIT_VOUCHER_NO not like", value, "executeRemitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andExecuteRemitVoucherNoIn(List<String> values) {
            addCriterion("EXECUTE_REMIT_VOUCHER_NO in", values, "executeRemitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andExecuteRemitVoucherNoNotIn(List<String> values) {
            addCriterion("EXECUTE_REMIT_VOUCHER_NO not in", values, "executeRemitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andExecuteRemitVoucherNoBetween(String value1, String value2) {
            addCriterion("EXECUTE_REMIT_VOUCHER_NO between", value1, value2, "executeRemitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andExecuteRemitVoucherNoNotBetween(String value1, String value2) {
            addCriterion("EXECUTE_REMIT_VOUCHER_NO not between", value1, value2, "executeRemitVoucherNo");
            return (Criteria) this;
        }

        public Criteria andRetryRuleIsNull() {
            addCriterion("RETRY_RULE is null");
            return (Criteria) this;
        }

        public Criteria andRetryRuleIsNotNull() {
            addCriterion("RETRY_RULE is not null");
            return (Criteria) this;
        }

        public Criteria andRetryRuleEqualTo(String value) {
            addCriterion("RETRY_RULE =", value, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleNotEqualTo(String value) {
            addCriterion("RETRY_RULE <>", value, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleGreaterThan(String value) {
            addCriterion("RETRY_RULE >", value, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleGreaterThanOrEqualTo(String value) {
            addCriterion("RETRY_RULE >=", value, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleLessThan(String value) {
            addCriterion("RETRY_RULE <", value, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleLessThanOrEqualTo(String value) {
            addCriterion("RETRY_RULE <=", value, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleLike(String value) {
            addCriterion("RETRY_RULE like", value, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleNotLike(String value) {
            addCriterion("RETRY_RULE not like", value, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleIn(List<String> values) {
            addCriterion("RETRY_RULE in", values, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleNotIn(List<String> values) {
            addCriterion("RETRY_RULE not in", values, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleBetween(String value1, String value2) {
            addCriterion("RETRY_RULE between", value1, value2, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryRuleNotBetween(String value1, String value2) {
            addCriterion("RETRY_RULE not between", value1, value2, "retryRule");
            return (Criteria) this;
        }

        public Criteria andRetryExecuteTimesIsNull() {
            addCriterion("RETRY_EXECUTE_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andRetryExecuteTimesIsNotNull() {
            addCriterion("RETRY_EXECUTE_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andRetryExecuteTimesEqualTo(Integer value) {
            addCriterion("RETRY_EXECUTE_TIMES =", value, "retryExecuteTimes");
            return (Criteria) this;
        }

        public Criteria andRetryExecuteTimesNotEqualTo(Integer value) {
            addCriterion("RETRY_EXECUTE_TIMES <>", value, "retryExecuteTimes");
            return (Criteria) this;
        }

        public Criteria andRetryExecuteTimesGreaterThan(Integer value) {
            addCriterion("RETRY_EXECUTE_TIMES >", value, "retryExecuteTimes");
            return (Criteria) this;
        }

        public Criteria andRetryExecuteTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("RETRY_EXECUTE_TIMES >=", value, "retryExecuteTimes");
            return (Criteria) this;
        }

        public Criteria andRetryExecuteTimesLessThan(Integer value) {
            addCriterion("RETRY_EXECUTE_TIMES <", value, "retryExecuteTimes");
            return (Criteria) this;
        }

        public Criteria andRetryExecuteTimesLessThanOrEqualTo(Integer value) {
            addCriterion("RETRY_EXECUTE_TIMES <=", value, "retryExecuteTimes");
            return (Criteria) this;
        }

        public Criteria andRetryExecuteTimesIn(List<Integer> values) {
            addCriterion("RETRY_EXECUTE_TIMES in", values, "retryExecuteTimes");
            return (Criteria) this;
        }

        public Criteria andRetryExecuteTimesNotIn(List<Integer> values) {
            addCriterion("RETRY_EXECUTE_TIMES not in", values, "retryExecuteTimes");
            return (Criteria) this;
        }

        public Criteria andRetryExecuteTimesBetween(Integer value1, Integer value2) {
            addCriterion("RETRY_EXECUTE_TIMES between", value1, value2, "retryExecuteTimes");
            return (Criteria) this;
        }

        public Criteria andRetryExecuteTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("RETRY_EXECUTE_TIMES not between", value1, value2, "retryExecuteTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteStartTimeIsNull() {
            addCriterion("EXECUTE_START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andExecuteStartTimeIsNotNull() {
            addCriterion("EXECUTE_START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteStartTimeEqualTo(Date value) {
            addCriterion("EXECUTE_START_TIME =", value, "executeStartTime");
            return (Criteria) this;
        }

        public Criteria andExecuteStartTimeNotEqualTo(Date value) {
            addCriterion("EXECUTE_START_TIME <>", value, "executeStartTime");
            return (Criteria) this;
        }

        public Criteria andExecuteStartTimeGreaterThan(Date value) {
            addCriterion("EXECUTE_START_TIME >", value, "executeStartTime");
            return (Criteria) this;
        }

        public Criteria andExecuteStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EXECUTE_START_TIME >=", value, "executeStartTime");
            return (Criteria) this;
        }

        public Criteria andExecuteStartTimeLessThan(Date value) {
            addCriterion("EXECUTE_START_TIME <", value, "executeStartTime");
            return (Criteria) this;
        }

        public Criteria andExecuteStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("EXECUTE_START_TIME <=", value, "executeStartTime");
            return (Criteria) this;
        }

        public Criteria andExecuteStartTimeIn(List<Date> values) {
            addCriterion("EXECUTE_START_TIME in", values, "executeStartTime");
            return (Criteria) this;
        }

        public Criteria andExecuteStartTimeNotIn(List<Date> values) {
            addCriterion("EXECUTE_START_TIME not in", values, "executeStartTime");
            return (Criteria) this;
        }

        public Criteria andExecuteStartTimeBetween(Date value1, Date value2) {
            addCriterion("EXECUTE_START_TIME between", value1, value2, "executeStartTime");
            return (Criteria) this;
        }

        public Criteria andExecuteStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("EXECUTE_START_TIME not between", value1, value2, "executeStartTime");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusIsNull() {
            addCriterion("EXECUTE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusIsNotNull() {
            addCriterion("EXECUTE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusEqualTo(Integer value) {
            addCriterion("EXECUTE_STATUS =", value, "executeStatus");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusNotEqualTo(Integer value) {
            addCriterion("EXECUTE_STATUS <>", value, "executeStatus");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusGreaterThan(Integer value) {
            addCriterion("EXECUTE_STATUS >", value, "executeStatus");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXECUTE_STATUS >=", value, "executeStatus");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusLessThan(Integer value) {
            addCriterion("EXECUTE_STATUS <", value, "executeStatus");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusLessThanOrEqualTo(Integer value) {
            addCriterion("EXECUTE_STATUS <=", value, "executeStatus");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusIn(List<Integer> values) {
            addCriterion("EXECUTE_STATUS in", values, "executeStatus");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusNotIn(List<Integer> values) {
            addCriterion("EXECUTE_STATUS not in", values, "executeStatus");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusBetween(Integer value1, Integer value2) {
            addCriterion("EXECUTE_STATUS between", value1, value2, "executeStatus");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("EXECUTE_STATUS not between", value1, value2, "executeStatus");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeIsNull() {
            addCriterion("EXECUTE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeIsNotNull() {
            addCriterion("EXECUTE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeEqualTo(Date value) {
            addCriterion("EXECUTE_TIME =", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeNotEqualTo(Date value) {
            addCriterion("EXECUTE_TIME <>", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeGreaterThan(Date value) {
            addCriterion("EXECUTE_TIME >", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EXECUTE_TIME >=", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeLessThan(Date value) {
            addCriterion("EXECUTE_TIME <", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeLessThanOrEqualTo(Date value) {
            addCriterion("EXECUTE_TIME <=", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeIn(List<Date> values) {
            addCriterion("EXECUTE_TIME in", values, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeNotIn(List<Date> values) {
            addCriterion("EXECUTE_TIME not in", values, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeBetween(Date value1, Date value2) {
            addCriterion("EXECUTE_TIME between", value1, value2, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeNotBetween(Date value1, Date value2) {
            addCriterion("EXECUTE_TIME not between", value1, value2, "executeTime");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WITHDRAW_RETRY_PLAN
     *
     * @mbggenerated do_not_delete_during_merge Fri Mar 11 19:55:47 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WITHDRAW_RETRY_PLAN
     * table comment :出款服务重试计划表
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
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