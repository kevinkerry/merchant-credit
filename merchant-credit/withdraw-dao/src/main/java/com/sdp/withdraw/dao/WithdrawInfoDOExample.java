package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WithdrawInfoDOExample extends QueryBase {
    /**
     * This field corresponds to the database column FW_WITHDRAW_INFO.ID
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    private Long id;

    /**
     * This field corresponds to the database column FW_WITHDRAW_INFO.LIMITATION_TYPE
     * column comments 额度类型
快速结算提现额度：0；
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    private Integer limitationType;

    /**
     * This field corresponds to the database column FW_WITHDRAW_INFO.BIZ_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    private Long bizId;

    /**
     * This field corresponds to the database column FW_WITHDRAW_INFO.BIZ_TYPE
     * column comments 
POS商户/POS代理商：1；
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    private Integer bizType;

    /**
     * This field corresponds to the database column FW_WITHDRAW_INFO.LIMITATION
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    private BigDecimal limitation;

    /**
     * This field corresponds to the database column FW_WITHDRAW_INFO.FORZEN_LIMITATION
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    private BigDecimal forzenLimitation;

    /**
     * This field corresponds to the database column FW_WITHDRAW_INFO.USED_LIMITATION
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    private BigDecimal usedLimitation;

    /**
     * This field corresponds to the database column FW_WITHDRAW_INFO.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    private Date updateTime;

    /**
     * This field corresponds to the database table FW_WITHDRAW_INFO
     * table comments 提现出款额度信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table FW_WITHDRAW_INFO
     * table comments 提现出款额度信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table FW_WITHDRAW_INFO
     * table comments 提现出款额度信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table FW_WITHDRAW_INFO
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public WithdrawInfoDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_INFO.ID
     *
     * @return the value of FW_WITHDRAW_INFO.ID
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_INFO.ID
     *
     * @param id the value for FW_WITHDRAW_INFO.ID
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_INFO.LIMITATION_TYPE
     *
     * @return the value of FW_WITHDRAW_INFO.LIMITATION_TYPE
     * column comments 额度类型
快速结算提现额度：0；
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public Integer getLimitationType() {
        return limitationType;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_INFO.LIMITATION_TYPE
     *
     * @param limitationType the value for FW_WITHDRAW_INFO.LIMITATION_TYPE
     * column comments 额度类型
快速结算提现额度：0；
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public void setLimitationType(Integer limitationType) {
        this.limitationType = limitationType;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_INFO.BIZ_ID
     *
     * @return the value of FW_WITHDRAW_INFO.BIZ_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public Long getBizId() {
        return bizId;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_INFO.BIZ_ID
     *
     * @param bizId the value for FW_WITHDRAW_INFO.BIZ_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_INFO.BIZ_TYPE
     *
     * @return the value of FW_WITHDRAW_INFO.BIZ_TYPE
     * column comments 
POS商户/POS代理商：1；
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public Integer getBizType() {
        return bizType;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_INFO.BIZ_TYPE
     *
     * @param bizType the value for FW_WITHDRAW_INFO.BIZ_TYPE
     * column comments 
POS商户/POS代理商：1；
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_INFO.LIMITATION
     *
     * @return the value of FW_WITHDRAW_INFO.LIMITATION
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public BigDecimal getLimitation() {
        return limitation;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_INFO.LIMITATION
     *
     * @param limitation the value for FW_WITHDRAW_INFO.LIMITATION
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public void setLimitation(BigDecimal limitation) {
        this.limitation = limitation;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_INFO.FORZEN_LIMITATION
     *
     * @return the value of FW_WITHDRAW_INFO.FORZEN_LIMITATION
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public BigDecimal getForzenLimitation() {
        return forzenLimitation;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_INFO.FORZEN_LIMITATION
     *
     * @param forzenLimitation the value for FW_WITHDRAW_INFO.FORZEN_LIMITATION
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public void setForzenLimitation(BigDecimal forzenLimitation) {
        this.forzenLimitation = forzenLimitation;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_INFO.USED_LIMITATION
     *
     * @return the value of FW_WITHDRAW_INFO.USED_LIMITATION
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public BigDecimal getUsedLimitation() {
        return usedLimitation;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_INFO.USED_LIMITATION
     *
     * @param usedLimitation the value for FW_WITHDRAW_INFO.USED_LIMITATION
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public void setUsedLimitation(BigDecimal usedLimitation) {
        this.usedLimitation = usedLimitation;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_INFO.CREATE_TIME
     *
     * @return the value of FW_WITHDRAW_INFO.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_INFO.CREATE_TIME
     *
     * @param createTime the value for FW_WITHDRAW_INFO.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_INFO.UPDATE_TIME
     *
     * @return the value of FW_WITHDRAW_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_INFO.UPDATE_TIME
     *
     * @param updateTime the value for FW_WITHDRAW_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_INFO
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_INFO
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_INFO
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_INFO
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_INFO
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_INFO
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_INFO
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_INFO
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_INFO
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_INFO
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WITHDRAW_INFO
     * table comment :提现出款额度信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
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

        public Criteria andLimitationTypeIsNull() {
            addCriterion("LIMITATION_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andLimitationTypeIsNotNull() {
            addCriterion("LIMITATION_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLimitationTypeEqualTo(Integer value) {
            addCriterion("LIMITATION_TYPE =", value, "limitationType");
            return (Criteria) this;
        }

        public Criteria andLimitationTypeNotEqualTo(Integer value) {
            addCriterion("LIMITATION_TYPE <>", value, "limitationType");
            return (Criteria) this;
        }

        public Criteria andLimitationTypeGreaterThan(Integer value) {
            addCriterion("LIMITATION_TYPE >", value, "limitationType");
            return (Criteria) this;
        }

        public Criteria andLimitationTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("LIMITATION_TYPE >=", value, "limitationType");
            return (Criteria) this;
        }

        public Criteria andLimitationTypeLessThan(Integer value) {
            addCriterion("LIMITATION_TYPE <", value, "limitationType");
            return (Criteria) this;
        }

        public Criteria andLimitationTypeLessThanOrEqualTo(Integer value) {
            addCriterion("LIMITATION_TYPE <=", value, "limitationType");
            return (Criteria) this;
        }

        public Criteria andLimitationTypeIn(List<Integer> values) {
            addCriterion("LIMITATION_TYPE in", values, "limitationType");
            return (Criteria) this;
        }

        public Criteria andLimitationTypeNotIn(List<Integer> values) {
            addCriterion("LIMITATION_TYPE not in", values, "limitationType");
            return (Criteria) this;
        }

        public Criteria andLimitationTypeBetween(Integer value1, Integer value2) {
            addCriterion("LIMITATION_TYPE between", value1, value2, "limitationType");
            return (Criteria) this;
        }

        public Criteria andLimitationTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("LIMITATION_TYPE not between", value1, value2, "limitationType");
            return (Criteria) this;
        }

        public Criteria andBizIdIsNull() {
            addCriterion("BIZ_ID is null");
            return (Criteria) this;
        }

        public Criteria andBizIdIsNotNull() {
            addCriterion("BIZ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBizIdEqualTo(Long value) {
            addCriterion("BIZ_ID =", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotEqualTo(Long value) {
            addCriterion("BIZ_ID <>", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdGreaterThan(Long value) {
            addCriterion("BIZ_ID >", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdGreaterThanOrEqualTo(Long value) {
            addCriterion("BIZ_ID >=", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdLessThan(Long value) {
            addCriterion("BIZ_ID <", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdLessThanOrEqualTo(Long value) {
            addCriterion("BIZ_ID <=", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdIn(List<Long> values) {
            addCriterion("BIZ_ID in", values, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotIn(List<Long> values) {
            addCriterion("BIZ_ID not in", values, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdBetween(Long value1, Long value2) {
            addCriterion("BIZ_ID between", value1, value2, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotBetween(Long value1, Long value2) {
            addCriterion("BIZ_ID not between", value1, value2, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizTypeIsNull() {
            addCriterion("BIZ_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBizTypeIsNotNull() {
            addCriterion("BIZ_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBizTypeEqualTo(Integer value) {
            addCriterion("BIZ_TYPE =", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotEqualTo(Integer value) {
            addCriterion("BIZ_TYPE <>", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeGreaterThan(Integer value) {
            addCriterion("BIZ_TYPE >", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("BIZ_TYPE >=", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeLessThan(Integer value) {
            addCriterion("BIZ_TYPE <", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeLessThanOrEqualTo(Integer value) {
            addCriterion("BIZ_TYPE <=", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeIn(List<Integer> values) {
            addCriterion("BIZ_TYPE in", values, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotIn(List<Integer> values) {
            addCriterion("BIZ_TYPE not in", values, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeBetween(Integer value1, Integer value2) {
            addCriterion("BIZ_TYPE between", value1, value2, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("BIZ_TYPE not between", value1, value2, "bizType");
            return (Criteria) this;
        }

        public Criteria andLimitationIsNull() {
            addCriterion("LIMITATION is null");
            return (Criteria) this;
        }

        public Criteria andLimitationIsNotNull() {
            addCriterion("LIMITATION is not null");
            return (Criteria) this;
        }

        public Criteria andLimitationEqualTo(BigDecimal value) {
            addCriterion("LIMITATION =", value, "limitation");
            return (Criteria) this;
        }

        public Criteria andLimitationNotEqualTo(BigDecimal value) {
            addCriterion("LIMITATION <>", value, "limitation");
            return (Criteria) this;
        }

        public Criteria andLimitationGreaterThan(BigDecimal value) {
            addCriterion("LIMITATION >", value, "limitation");
            return (Criteria) this;
        }

        public Criteria andLimitationGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LIMITATION >=", value, "limitation");
            return (Criteria) this;
        }

        public Criteria andLimitationLessThan(BigDecimal value) {
            addCriterion("LIMITATION <", value, "limitation");
            return (Criteria) this;
        }

        public Criteria andLimitationLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LIMITATION <=", value, "limitation");
            return (Criteria) this;
        }

        public Criteria andLimitationIn(List<BigDecimal> values) {
            addCriterion("LIMITATION in", values, "limitation");
            return (Criteria) this;
        }

        public Criteria andLimitationNotIn(List<BigDecimal> values) {
            addCriterion("LIMITATION not in", values, "limitation");
            return (Criteria) this;
        }

        public Criteria andLimitationBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LIMITATION between", value1, value2, "limitation");
            return (Criteria) this;
        }

        public Criteria andLimitationNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LIMITATION not between", value1, value2, "limitation");
            return (Criteria) this;
        }

        public Criteria andForzenLimitationIsNull() {
            addCriterion("FORZEN_LIMITATION is null");
            return (Criteria) this;
        }

        public Criteria andForzenLimitationIsNotNull() {
            addCriterion("FORZEN_LIMITATION is not null");
            return (Criteria) this;
        }

        public Criteria andForzenLimitationEqualTo(BigDecimal value) {
            addCriterion("FORZEN_LIMITATION =", value, "forzenLimitation");
            return (Criteria) this;
        }

        public Criteria andForzenLimitationNotEqualTo(BigDecimal value) {
            addCriterion("FORZEN_LIMITATION <>", value, "forzenLimitation");
            return (Criteria) this;
        }

        public Criteria andForzenLimitationGreaterThan(BigDecimal value) {
            addCriterion("FORZEN_LIMITATION >", value, "forzenLimitation");
            return (Criteria) this;
        }

        public Criteria andForzenLimitationGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FORZEN_LIMITATION >=", value, "forzenLimitation");
            return (Criteria) this;
        }

        public Criteria andForzenLimitationLessThan(BigDecimal value) {
            addCriterion("FORZEN_LIMITATION <", value, "forzenLimitation");
            return (Criteria) this;
        }

        public Criteria andForzenLimitationLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FORZEN_LIMITATION <=", value, "forzenLimitation");
            return (Criteria) this;
        }

        public Criteria andForzenLimitationIn(List<BigDecimal> values) {
            addCriterion("FORZEN_LIMITATION in", values, "forzenLimitation");
            return (Criteria) this;
        }

        public Criteria andForzenLimitationNotIn(List<BigDecimal> values) {
            addCriterion("FORZEN_LIMITATION not in", values, "forzenLimitation");
            return (Criteria) this;
        }

        public Criteria andForzenLimitationBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FORZEN_LIMITATION between", value1, value2, "forzenLimitation");
            return (Criteria) this;
        }

        public Criteria andForzenLimitationNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FORZEN_LIMITATION not between", value1, value2, "forzenLimitation");
            return (Criteria) this;
        }

        public Criteria andUsedLimitationIsNull() {
            addCriterion("USED_LIMITATION is null");
            return (Criteria) this;
        }

        public Criteria andUsedLimitationIsNotNull() {
            addCriterion("USED_LIMITATION is not null");
            return (Criteria) this;
        }

        public Criteria andUsedLimitationEqualTo(BigDecimal value) {
            addCriterion("USED_LIMITATION =", value, "usedLimitation");
            return (Criteria) this;
        }

        public Criteria andUsedLimitationNotEqualTo(BigDecimal value) {
            addCriterion("USED_LIMITATION <>", value, "usedLimitation");
            return (Criteria) this;
        }

        public Criteria andUsedLimitationGreaterThan(BigDecimal value) {
            addCriterion("USED_LIMITATION >", value, "usedLimitation");
            return (Criteria) this;
        }

        public Criteria andUsedLimitationGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("USED_LIMITATION >=", value, "usedLimitation");
            return (Criteria) this;
        }

        public Criteria andUsedLimitationLessThan(BigDecimal value) {
            addCriterion("USED_LIMITATION <", value, "usedLimitation");
            return (Criteria) this;
        }

        public Criteria andUsedLimitationLessThanOrEqualTo(BigDecimal value) {
            addCriterion("USED_LIMITATION <=", value, "usedLimitation");
            return (Criteria) this;
        }

        public Criteria andUsedLimitationIn(List<BigDecimal> values) {
            addCriterion("USED_LIMITATION in", values, "usedLimitation");
            return (Criteria) this;
        }

        public Criteria andUsedLimitationNotIn(List<BigDecimal> values) {
            addCriterion("USED_LIMITATION not in", values, "usedLimitation");
            return (Criteria) this;
        }

        public Criteria andUsedLimitationBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USED_LIMITATION between", value1, value2, "usedLimitation");
            return (Criteria) this;
        }

        public Criteria andUsedLimitationNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USED_LIMITATION not between", value1, value2, "usedLimitation");
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
     * This class corresponds to the database table FW_WITHDRAW_INFO
     *
     * @mbggenerated do_not_delete_during_merge Mon Mar 14 10:34:42 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WITHDRAW_INFO
     * table comment :提现出款额度信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
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