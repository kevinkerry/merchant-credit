package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WithdrawReqExtraInfoDOExample extends QueryBase {
    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_EXTRA_INFO.ID
     * column comments 主键
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    private Long id;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_EXTRA_INFO.REQ_ID
     * column comments 出款请求的ID
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    private Long reqId;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_EXTRA_INFO.POST_PAID_FLAG
     * column comments 后付费标示 1：后付费，0：非后付费
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    private Integer postPaidFlag;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_EXTRA_INFO.INIT_WITHDRAW_AMOUNT
     * column comments 初始的请求的出款金额
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    private BigDecimal initWithdrawAmount;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE1
     * column comments 扩展字段1
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    private String extraValue1;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE2
     * column comments 扩展字段2
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    private String extraValue2;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE3
     * column comments 扩展字段3
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    private String extraValue3;

    /**
     * This field corresponds to the database table FW_WITHDRAW_REQ_EXTRA_INFO
     * table comments 出款扩展信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table FW_WITHDRAW_REQ_EXTRA_INFO
     * table comments 出款扩展信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table FW_WITHDRAW_REQ_EXTRA_INFO
     * table comments 出款扩展信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ_EXTRA_INFO
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public WithdrawReqExtraInfoDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.ID
     *
     * @return the value of FW_WITHDRAW_REQ_EXTRA_INFO.ID
     * column comments 主键
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.ID
     *
     * @param id the value for FW_WITHDRAW_REQ_EXTRA_INFO.ID
     * column comments 主键
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.REQ_ID
     *
     * @return the value of FW_WITHDRAW_REQ_EXTRA_INFO.REQ_ID
     * column comments 出款请求的ID
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public Long getReqId() {
        return reqId;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.REQ_ID
     *
     * @param reqId the value for FW_WITHDRAW_REQ_EXTRA_INFO.REQ_ID
     * column comments 出款请求的ID
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.POST_PAID_FLAG
     *
     * @return the value of FW_WITHDRAW_REQ_EXTRA_INFO.POST_PAID_FLAG
     * column comments 后付费标示 1：后付费，0：非后付费
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public Integer getPostPaidFlag() {
        return postPaidFlag;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.POST_PAID_FLAG
     *
     * @param postPaidFlag the value for FW_WITHDRAW_REQ_EXTRA_INFO.POST_PAID_FLAG
     * column comments 后付费标示 1：后付费，0：非后付费
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public void setPostPaidFlag(Integer postPaidFlag) {
        this.postPaidFlag = postPaidFlag;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.INIT_WITHDRAW_AMOUNT
     *
     * @return the value of FW_WITHDRAW_REQ_EXTRA_INFO.INIT_WITHDRAW_AMOUNT
     * column comments 初始的请求的出款金额
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public BigDecimal getInitWithdrawAmount() {
        return initWithdrawAmount;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.INIT_WITHDRAW_AMOUNT
     *
     * @param initWithdrawAmount the value for FW_WITHDRAW_REQ_EXTRA_INFO.INIT_WITHDRAW_AMOUNT
     * column comments 初始的请求的出款金额
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public void setInitWithdrawAmount(BigDecimal initWithdrawAmount) {
        this.initWithdrawAmount = initWithdrawAmount;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE1
     *
     * @return the value of FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE1
     * column comments 扩展字段1
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public String getExtraValue1() {
        return extraValue1;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE1
     *
     * @param extraValue1 the value for FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE1
     * column comments 扩展字段1
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public void setExtraValue1(String extraValue1) {
        this.extraValue1 = extraValue1 == null ? null : extraValue1.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE2
     *
     * @return the value of FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE2
     * column comments 扩展字段2
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public String getExtraValue2() {
        return extraValue2;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE2
     *
     * @param extraValue2 the value for FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE2
     * column comments 扩展字段2
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public void setExtraValue2(String extraValue2) {
        this.extraValue2 = extraValue2 == null ? null : extraValue2.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE3
     *
     * @return the value of FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE3
     * column comments 扩展字段3
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public String getExtraValue3() {
        return extraValue3;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE3
     *
     * @param extraValue3 the value for FW_WITHDRAW_REQ_EXTRA_INFO.EXTRA_VALUE3
     * column comments 扩展字段3
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public void setExtraValue3(String extraValue3) {
        this.extraValue3 = extraValue3 == null ? null : extraValue3.trim();
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ_EXTRA_INFO
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ_EXTRA_INFO
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ_EXTRA_INFO
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ_EXTRA_INFO
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ_EXTRA_INFO
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ_EXTRA_INFO
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ_EXTRA_INFO
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ_EXTRA_INFO
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ_EXTRA_INFO
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ_EXTRA_INFO
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WITHDRAW_REQ_EXTRA_INFO
     * table comment :出款扩展信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
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

        public Criteria andPostPaidFlagIsNull() {
            addCriterion("POST_PAID_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andPostPaidFlagIsNotNull() {
            addCriterion("POST_PAID_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andPostPaidFlagEqualTo(Integer value) {
            addCriterion("POST_PAID_FLAG =", value, "postPaidFlag");
            return (Criteria) this;
        }

        public Criteria andPostPaidFlagNotEqualTo(Integer value) {
            addCriterion("POST_PAID_FLAG <>", value, "postPaidFlag");
            return (Criteria) this;
        }

        public Criteria andPostPaidFlagGreaterThan(Integer value) {
            addCriterion("POST_PAID_FLAG >", value, "postPaidFlag");
            return (Criteria) this;
        }

        public Criteria andPostPaidFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("POST_PAID_FLAG >=", value, "postPaidFlag");
            return (Criteria) this;
        }

        public Criteria andPostPaidFlagLessThan(Integer value) {
            addCriterion("POST_PAID_FLAG <", value, "postPaidFlag");
            return (Criteria) this;
        }

        public Criteria andPostPaidFlagLessThanOrEqualTo(Integer value) {
            addCriterion("POST_PAID_FLAG <=", value, "postPaidFlag");
            return (Criteria) this;
        }

        public Criteria andPostPaidFlagIn(List<Integer> values) {
            addCriterion("POST_PAID_FLAG in", values, "postPaidFlag");
            return (Criteria) this;
        }

        public Criteria andPostPaidFlagNotIn(List<Integer> values) {
            addCriterion("POST_PAID_FLAG not in", values, "postPaidFlag");
            return (Criteria) this;
        }

        public Criteria andPostPaidFlagBetween(Integer value1, Integer value2) {
            addCriterion("POST_PAID_FLAG between", value1, value2, "postPaidFlag");
            return (Criteria) this;
        }

        public Criteria andPostPaidFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("POST_PAID_FLAG not between", value1, value2, "postPaidFlag");
            return (Criteria) this;
        }

        public Criteria andInitWithdrawAmountIsNull() {
            addCriterion("INIT_WITHDRAW_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andInitWithdrawAmountIsNotNull() {
            addCriterion("INIT_WITHDRAW_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andInitWithdrawAmountEqualTo(BigDecimal value) {
            addCriterion("INIT_WITHDRAW_AMOUNT =", value, "initWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andInitWithdrawAmountNotEqualTo(BigDecimal value) {
            addCriterion("INIT_WITHDRAW_AMOUNT <>", value, "initWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andInitWithdrawAmountGreaterThan(BigDecimal value) {
            addCriterion("INIT_WITHDRAW_AMOUNT >", value, "initWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andInitWithdrawAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INIT_WITHDRAW_AMOUNT >=", value, "initWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andInitWithdrawAmountLessThan(BigDecimal value) {
            addCriterion("INIT_WITHDRAW_AMOUNT <", value, "initWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andInitWithdrawAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INIT_WITHDRAW_AMOUNT <=", value, "initWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andInitWithdrawAmountIn(List<BigDecimal> values) {
            addCriterion("INIT_WITHDRAW_AMOUNT in", values, "initWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andInitWithdrawAmountNotIn(List<BigDecimal> values) {
            addCriterion("INIT_WITHDRAW_AMOUNT not in", values, "initWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andInitWithdrawAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INIT_WITHDRAW_AMOUNT between", value1, value2, "initWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andInitWithdrawAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INIT_WITHDRAW_AMOUNT not between", value1, value2, "initWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andExtraValue1IsNull() {
            addCriterion("EXTRA_VALUE1 is null");
            return (Criteria) this;
        }

        public Criteria andExtraValue1IsNotNull() {
            addCriterion("EXTRA_VALUE1 is not null");
            return (Criteria) this;
        }

        public Criteria andExtraValue1EqualTo(String value) {
            addCriterion("EXTRA_VALUE1 =", value, "extraValue1");
            return (Criteria) this;
        }

        public Criteria andExtraValue1NotEqualTo(String value) {
            addCriterion("EXTRA_VALUE1 <>", value, "extraValue1");
            return (Criteria) this;
        }

        public Criteria andExtraValue1GreaterThan(String value) {
            addCriterion("EXTRA_VALUE1 >", value, "extraValue1");
            return (Criteria) this;
        }

        public Criteria andExtraValue1GreaterThanOrEqualTo(String value) {
            addCriterion("EXTRA_VALUE1 >=", value, "extraValue1");
            return (Criteria) this;
        }

        public Criteria andExtraValue1LessThan(String value) {
            addCriterion("EXTRA_VALUE1 <", value, "extraValue1");
            return (Criteria) this;
        }

        public Criteria andExtraValue1LessThanOrEqualTo(String value) {
            addCriterion("EXTRA_VALUE1 <=", value, "extraValue1");
            return (Criteria) this;
        }

        public Criteria andExtraValue1Like(String value) {
            addCriterion("EXTRA_VALUE1 like", value, "extraValue1");
            return (Criteria) this;
        }

        public Criteria andExtraValue1NotLike(String value) {
            addCriterion("EXTRA_VALUE1 not like", value, "extraValue1");
            return (Criteria) this;
        }

        public Criteria andExtraValue1In(List<String> values) {
            addCriterion("EXTRA_VALUE1 in", values, "extraValue1");
            return (Criteria) this;
        }

        public Criteria andExtraValue1NotIn(List<String> values) {
            addCriterion("EXTRA_VALUE1 not in", values, "extraValue1");
            return (Criteria) this;
        }

        public Criteria andExtraValue1Between(String value1, String value2) {
            addCriterion("EXTRA_VALUE1 between", value1, value2, "extraValue1");
            return (Criteria) this;
        }

        public Criteria andExtraValue1NotBetween(String value1, String value2) {
            addCriterion("EXTRA_VALUE1 not between", value1, value2, "extraValue1");
            return (Criteria) this;
        }

        public Criteria andExtraValue2IsNull() {
            addCriterion("EXTRA_VALUE2 is null");
            return (Criteria) this;
        }

        public Criteria andExtraValue2IsNotNull() {
            addCriterion("EXTRA_VALUE2 is not null");
            return (Criteria) this;
        }

        public Criteria andExtraValue2EqualTo(String value) {
            addCriterion("EXTRA_VALUE2 =", value, "extraValue2");
            return (Criteria) this;
        }

        public Criteria andExtraValue2NotEqualTo(String value) {
            addCriterion("EXTRA_VALUE2 <>", value, "extraValue2");
            return (Criteria) this;
        }

        public Criteria andExtraValue2GreaterThan(String value) {
            addCriterion("EXTRA_VALUE2 >", value, "extraValue2");
            return (Criteria) this;
        }

        public Criteria andExtraValue2GreaterThanOrEqualTo(String value) {
            addCriterion("EXTRA_VALUE2 >=", value, "extraValue2");
            return (Criteria) this;
        }

        public Criteria andExtraValue2LessThan(String value) {
            addCriterion("EXTRA_VALUE2 <", value, "extraValue2");
            return (Criteria) this;
        }

        public Criteria andExtraValue2LessThanOrEqualTo(String value) {
            addCriterion("EXTRA_VALUE2 <=", value, "extraValue2");
            return (Criteria) this;
        }

        public Criteria andExtraValue2Like(String value) {
            addCriterion("EXTRA_VALUE2 like", value, "extraValue2");
            return (Criteria) this;
        }

        public Criteria andExtraValue2NotLike(String value) {
            addCriterion("EXTRA_VALUE2 not like", value, "extraValue2");
            return (Criteria) this;
        }

        public Criteria andExtraValue2In(List<String> values) {
            addCriterion("EXTRA_VALUE2 in", values, "extraValue2");
            return (Criteria) this;
        }

        public Criteria andExtraValue2NotIn(List<String> values) {
            addCriterion("EXTRA_VALUE2 not in", values, "extraValue2");
            return (Criteria) this;
        }

        public Criteria andExtraValue2Between(String value1, String value2) {
            addCriterion("EXTRA_VALUE2 between", value1, value2, "extraValue2");
            return (Criteria) this;
        }

        public Criteria andExtraValue2NotBetween(String value1, String value2) {
            addCriterion("EXTRA_VALUE2 not between", value1, value2, "extraValue2");
            return (Criteria) this;
        }

        public Criteria andExtraValue3IsNull() {
            addCriterion("EXTRA_VALUE3 is null");
            return (Criteria) this;
        }

        public Criteria andExtraValue3IsNotNull() {
            addCriterion("EXTRA_VALUE3 is not null");
            return (Criteria) this;
        }

        public Criteria andExtraValue3EqualTo(String value) {
            addCriterion("EXTRA_VALUE3 =", value, "extraValue3");
            return (Criteria) this;
        }

        public Criteria andExtraValue3NotEqualTo(String value) {
            addCriterion("EXTRA_VALUE3 <>", value, "extraValue3");
            return (Criteria) this;
        }

        public Criteria andExtraValue3GreaterThan(String value) {
            addCriterion("EXTRA_VALUE3 >", value, "extraValue3");
            return (Criteria) this;
        }

        public Criteria andExtraValue3GreaterThanOrEqualTo(String value) {
            addCriterion("EXTRA_VALUE3 >=", value, "extraValue3");
            return (Criteria) this;
        }

        public Criteria andExtraValue3LessThan(String value) {
            addCriterion("EXTRA_VALUE3 <", value, "extraValue3");
            return (Criteria) this;
        }

        public Criteria andExtraValue3LessThanOrEqualTo(String value) {
            addCriterion("EXTRA_VALUE3 <=", value, "extraValue3");
            return (Criteria) this;
        }

        public Criteria andExtraValue3Like(String value) {
            addCriterion("EXTRA_VALUE3 like", value, "extraValue3");
            return (Criteria) this;
        }

        public Criteria andExtraValue3NotLike(String value) {
            addCriterion("EXTRA_VALUE3 not like", value, "extraValue3");
            return (Criteria) this;
        }

        public Criteria andExtraValue3In(List<String> values) {
            addCriterion("EXTRA_VALUE3 in", values, "extraValue3");
            return (Criteria) this;
        }

        public Criteria andExtraValue3NotIn(List<String> values) {
            addCriterion("EXTRA_VALUE3 not in", values, "extraValue3");
            return (Criteria) this;
        }

        public Criteria andExtraValue3Between(String value1, String value2) {
            addCriterion("EXTRA_VALUE3 between", value1, value2, "extraValue3");
            return (Criteria) this;
        }

        public Criteria andExtraValue3NotBetween(String value1, String value2) {
            addCriterion("EXTRA_VALUE3 not between", value1, value2, "extraValue3");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WITHDRAW_REQ_EXTRA_INFO
     *
     * @mbggenerated do_not_delete_during_merge Tue Aug 30 09:37:59 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WITHDRAW_REQ_EXTRA_INFO
     * table comment :出款扩展信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
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