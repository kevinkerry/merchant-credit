package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WithdrawRatioInfoDOExample extends QueryBase {
    /**
     * This field corresponds to the database column FW_WITHDRAW_RATIO_INFO.ID
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    private Long id;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RATIO_INFO.BIZ_ID
     * column comments 业务ID
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    private Long bizId;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RATIO_INFO.RATIO_TYPE
     * column comments 费率类型
POS/T+0结算费率：10；
MPOS/T+0结算费率：20；
MPOS/T+1结算费率：21；
MPOS/D+1结算费率：22；

     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    private Integer ratioType;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RATIO_INFO.STATUS
     * column comments 状态
生效：1；
失效：0；
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    private Integer status;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RATIO_INFO.WORK_DAY_RATIO
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    private BigDecimal workDayRatio;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RATIO_INFO.HOLIDAY_RATIO
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    private BigDecimal holidayRatio;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RATIO_INFO.EFFECTIVE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    private Date effectiveTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RATIO_INFO.EXPIRE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    private Date expireTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RATIO_INFO.CRETE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    private Date creteTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RATIO_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    private Date updateTime;

    /**
     * This field corresponds to the database table FW_WITHDRAW_RATIO_INFO
     * table comments 提现出款费率信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table FW_WITHDRAW_RATIO_INFO
     * table comments 提现出款费率信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table FW_WITHDRAW_RATIO_INFO
     * table comments 提现出款费率信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table FW_WITHDRAW_RATIO_INFO
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public WithdrawRatioInfoDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RATIO_INFO.ID
     *
     * @return the value of FW_WITHDRAW_RATIO_INFO.ID
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RATIO_INFO.ID
     *
     * @param id the value for FW_WITHDRAW_RATIO_INFO.ID
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RATIO_INFO.BIZ_ID
     *
     * @return the value of FW_WITHDRAW_RATIO_INFO.BIZ_ID
     * column comments 业务ID
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public Long getBizId() {
        return bizId;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RATIO_INFO.BIZ_ID
     *
     * @param bizId the value for FW_WITHDRAW_RATIO_INFO.BIZ_ID
     * column comments 业务ID
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RATIO_INFO.RATIO_TYPE
     *
     * @return the value of FW_WITHDRAW_RATIO_INFO.RATIO_TYPE
     * column comments 费率类型
POS/T+0结算费率：10；
MPOS/T+0结算费率：20；
MPOS/T+1结算费率：21；
MPOS/D+1结算费率：22；

     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public Integer getRatioType() {
        return ratioType;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RATIO_INFO.RATIO_TYPE
     *
     * @param ratioType the value for FW_WITHDRAW_RATIO_INFO.RATIO_TYPE
     * column comments 费率类型
POS/T+0结算费率：10；
MPOS/T+0结算费率：20；
MPOS/T+1结算费率：21；
MPOS/D+1结算费率：22；

     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public void setRatioType(Integer ratioType) {
        this.ratioType = ratioType;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RATIO_INFO.STATUS
     *
     * @return the value of FW_WITHDRAW_RATIO_INFO.STATUS
     * column comments 状态
生效：1；
失效：0；
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RATIO_INFO.STATUS
     *
     * @param status the value for FW_WITHDRAW_RATIO_INFO.STATUS
     * column comments 状态
生效：1；
失效：0；
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RATIO_INFO.WORK_DAY_RATIO
     *
     * @return the value of FW_WITHDRAW_RATIO_INFO.WORK_DAY_RATIO
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public BigDecimal getWorkDayRatio() {
        return workDayRatio;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RATIO_INFO.WORK_DAY_RATIO
     *
     * @param workDayRatio the value for FW_WITHDRAW_RATIO_INFO.WORK_DAY_RATIO
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public void setWorkDayRatio(BigDecimal workDayRatio) {
        this.workDayRatio = workDayRatio;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RATIO_INFO.HOLIDAY_RATIO
     *
     * @return the value of FW_WITHDRAW_RATIO_INFO.HOLIDAY_RATIO
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public BigDecimal getHolidayRatio() {
        return holidayRatio;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RATIO_INFO.HOLIDAY_RATIO
     *
     * @param holidayRatio the value for FW_WITHDRAW_RATIO_INFO.HOLIDAY_RATIO
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public void setHolidayRatio(BigDecimal holidayRatio) {
        this.holidayRatio = holidayRatio;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RATIO_INFO.EFFECTIVE_TIME
     *
     * @return the value of FW_WITHDRAW_RATIO_INFO.EFFECTIVE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public Date getEffectiveTime() {
        return effectiveTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RATIO_INFO.EFFECTIVE_TIME
     *
     * @param effectiveTime the value for FW_WITHDRAW_RATIO_INFO.EFFECTIVE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RATIO_INFO.EXPIRE_TIME
     *
     * @return the value of FW_WITHDRAW_RATIO_INFO.EXPIRE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RATIO_INFO.EXPIRE_TIME
     *
     * @param expireTime the value for FW_WITHDRAW_RATIO_INFO.EXPIRE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RATIO_INFO.CRETE_TIME
     *
     * @return the value of FW_WITHDRAW_RATIO_INFO.CRETE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public Date getCreteTime() {
        return creteTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RATIO_INFO.CRETE_TIME
     *
     * @param creteTime the value for FW_WITHDRAW_RATIO_INFO.CRETE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public void setCreteTime(Date creteTime) {
        this.creteTime = creteTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RATIO_INFO.UPDATE_TIME
     *
     * @return the value of FW_WITHDRAW_RATIO_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RATIO_INFO.UPDATE_TIME
     *
     * @param updateTime the value for FW_WITHDRAW_RATIO_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_RATIO_INFO
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_RATIO_INFO
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_RATIO_INFO
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_RATIO_INFO
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_RATIO_INFO
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_RATIO_INFO
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_RATIO_INFO
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_RATIO_INFO
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_RATIO_INFO
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_RATIO_INFO
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WITHDRAW_RATIO_INFO
     * table comment :提现出款费率信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
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

        public Criteria andRatioTypeIsNull() {
            addCriterion("RATIO_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRatioTypeIsNotNull() {
            addCriterion("RATIO_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRatioTypeEqualTo(Integer value) {
            addCriterion("RATIO_TYPE =", value, "ratioType");
            return (Criteria) this;
        }

        public Criteria andRatioTypeNotEqualTo(Integer value) {
            addCriterion("RATIO_TYPE <>", value, "ratioType");
            return (Criteria) this;
        }

        public Criteria andRatioTypeGreaterThan(Integer value) {
            addCriterion("RATIO_TYPE >", value, "ratioType");
            return (Criteria) this;
        }

        public Criteria andRatioTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("RATIO_TYPE >=", value, "ratioType");
            return (Criteria) this;
        }

        public Criteria andRatioTypeLessThan(Integer value) {
            addCriterion("RATIO_TYPE <", value, "ratioType");
            return (Criteria) this;
        }

        public Criteria andRatioTypeLessThanOrEqualTo(Integer value) {
            addCriterion("RATIO_TYPE <=", value, "ratioType");
            return (Criteria) this;
        }

        public Criteria andRatioTypeIn(List<Integer> values) {
            addCriterion("RATIO_TYPE in", values, "ratioType");
            return (Criteria) this;
        }

        public Criteria andRatioTypeNotIn(List<Integer> values) {
            addCriterion("RATIO_TYPE not in", values, "ratioType");
            return (Criteria) this;
        }

        public Criteria andRatioTypeBetween(Integer value1, Integer value2) {
            addCriterion("RATIO_TYPE between", value1, value2, "ratioType");
            return (Criteria) this;
        }

        public Criteria andRatioTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("RATIO_TYPE not between", value1, value2, "ratioType");
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

        public Criteria andWorkDayRatioIsNull() {
            addCriterion("WORK_DAY_RATIO is null");
            return (Criteria) this;
        }

        public Criteria andWorkDayRatioIsNotNull() {
            addCriterion("WORK_DAY_RATIO is not null");
            return (Criteria) this;
        }

        public Criteria andWorkDayRatioEqualTo(BigDecimal value) {
            addCriterion("WORK_DAY_RATIO =", value, "workDayRatio");
            return (Criteria) this;
        }

        public Criteria andWorkDayRatioNotEqualTo(BigDecimal value) {
            addCriterion("WORK_DAY_RATIO <>", value, "workDayRatio");
            return (Criteria) this;
        }

        public Criteria andWorkDayRatioGreaterThan(BigDecimal value) {
            addCriterion("WORK_DAY_RATIO >", value, "workDayRatio");
            return (Criteria) this;
        }

        public Criteria andWorkDayRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WORK_DAY_RATIO >=", value, "workDayRatio");
            return (Criteria) this;
        }

        public Criteria andWorkDayRatioLessThan(BigDecimal value) {
            addCriterion("WORK_DAY_RATIO <", value, "workDayRatio");
            return (Criteria) this;
        }

        public Criteria andWorkDayRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WORK_DAY_RATIO <=", value, "workDayRatio");
            return (Criteria) this;
        }

        public Criteria andWorkDayRatioIn(List<BigDecimal> values) {
            addCriterion("WORK_DAY_RATIO in", values, "workDayRatio");
            return (Criteria) this;
        }

        public Criteria andWorkDayRatioNotIn(List<BigDecimal> values) {
            addCriterion("WORK_DAY_RATIO not in", values, "workDayRatio");
            return (Criteria) this;
        }

        public Criteria andWorkDayRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WORK_DAY_RATIO between", value1, value2, "workDayRatio");
            return (Criteria) this;
        }

        public Criteria andWorkDayRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WORK_DAY_RATIO not between", value1, value2, "workDayRatio");
            return (Criteria) this;
        }

        public Criteria andHolidayRatioIsNull() {
            addCriterion("HOLIDAY_RATIO is null");
            return (Criteria) this;
        }

        public Criteria andHolidayRatioIsNotNull() {
            addCriterion("HOLIDAY_RATIO is not null");
            return (Criteria) this;
        }

        public Criteria andHolidayRatioEqualTo(BigDecimal value) {
            addCriterion("HOLIDAY_RATIO =", value, "holidayRatio");
            return (Criteria) this;
        }

        public Criteria andHolidayRatioNotEqualTo(BigDecimal value) {
            addCriterion("HOLIDAY_RATIO <>", value, "holidayRatio");
            return (Criteria) this;
        }

        public Criteria andHolidayRatioGreaterThan(BigDecimal value) {
            addCriterion("HOLIDAY_RATIO >", value, "holidayRatio");
            return (Criteria) this;
        }

        public Criteria andHolidayRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HOLIDAY_RATIO >=", value, "holidayRatio");
            return (Criteria) this;
        }

        public Criteria andHolidayRatioLessThan(BigDecimal value) {
            addCriterion("HOLIDAY_RATIO <", value, "holidayRatio");
            return (Criteria) this;
        }

        public Criteria andHolidayRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HOLIDAY_RATIO <=", value, "holidayRatio");
            return (Criteria) this;
        }

        public Criteria andHolidayRatioIn(List<BigDecimal> values) {
            addCriterion("HOLIDAY_RATIO in", values, "holidayRatio");
            return (Criteria) this;
        }

        public Criteria andHolidayRatioNotIn(List<BigDecimal> values) {
            addCriterion("HOLIDAY_RATIO not in", values, "holidayRatio");
            return (Criteria) this;
        }

        public Criteria andHolidayRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOLIDAY_RATIO between", value1, value2, "holidayRatio");
            return (Criteria) this;
        }

        public Criteria andHolidayRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOLIDAY_RATIO not between", value1, value2, "holidayRatio");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeIsNull() {
            addCriterion("EFFECTIVE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeIsNotNull() {
            addCriterion("EFFECTIVE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEqualTo(Date value) {
            addCriterion("EFFECTIVE_TIME =", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeNotEqualTo(Date value) {
            addCriterion("EFFECTIVE_TIME <>", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeGreaterThan(Date value) {
            addCriterion("EFFECTIVE_TIME >", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EFFECTIVE_TIME >=", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeLessThan(Date value) {
            addCriterion("EFFECTIVE_TIME <", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("EFFECTIVE_TIME <=", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeIn(List<Date> values) {
            addCriterion("EFFECTIVE_TIME in", values, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeNotIn(List<Date> values) {
            addCriterion("EFFECTIVE_TIME not in", values, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeBetween(Date value1, Date value2) {
            addCriterion("EFFECTIVE_TIME between", value1, value2, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("EFFECTIVE_TIME not between", value1, value2, "effectiveTime");
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

        public Criteria andCreteTimeIsNull() {
            addCriterion("CRETE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreteTimeIsNotNull() {
            addCriterion("CRETE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreteTimeEqualTo(Date value) {
            addCriterion("CRETE_TIME =", value, "creteTime");
            return (Criteria) this;
        }

        public Criteria andCreteTimeNotEqualTo(Date value) {
            addCriterion("CRETE_TIME <>", value, "creteTime");
            return (Criteria) this;
        }

        public Criteria andCreteTimeGreaterThan(Date value) {
            addCriterion("CRETE_TIME >", value, "creteTime");
            return (Criteria) this;
        }

        public Criteria andCreteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CRETE_TIME >=", value, "creteTime");
            return (Criteria) this;
        }

        public Criteria andCreteTimeLessThan(Date value) {
            addCriterion("CRETE_TIME <", value, "creteTime");
            return (Criteria) this;
        }

        public Criteria andCreteTimeLessThanOrEqualTo(Date value) {
            addCriterion("CRETE_TIME <=", value, "creteTime");
            return (Criteria) this;
        }

        public Criteria andCreteTimeIn(List<Date> values) {
            addCriterion("CRETE_TIME in", values, "creteTime");
            return (Criteria) this;
        }

        public Criteria andCreteTimeNotIn(List<Date> values) {
            addCriterion("CRETE_TIME not in", values, "creteTime");
            return (Criteria) this;
        }

        public Criteria andCreteTimeBetween(Date value1, Date value2) {
            addCriterion("CRETE_TIME between", value1, value2, "creteTime");
            return (Criteria) this;
        }

        public Criteria andCreteTimeNotBetween(Date value1, Date value2) {
            addCriterion("CRETE_TIME not between", value1, value2, "creteTime");
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
     * This class corresponds to the database table FW_WITHDRAW_RATIO_INFO
     *
     * @mbggenerated do_not_delete_during_merge Fri Mar 11 19:55:30 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WITHDRAW_RATIO_INFO
     * table comment :提现出款费率信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
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