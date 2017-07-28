package com.sdp.mc.newt0.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Newt0SdpRemainBalanceDOExample extends QueryBase {
    /**
     * This field corresponds to the database column NEWT0_SDP_REMAIN_BALANCE.ID
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    private Long id;

    /**
     * This field corresponds to the database column NEWT0_SDP_REMAIN_BALANCE.START_TIME
     * column comments 生效开始日
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    private Date startTime;

    /**
     * This field corresponds to the database column NEWT0_SDP_REMAIN_BALANCE.QUOTA
     * column comments 配资额度
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    private BigDecimal quota;

    /**
     * This field corresponds to the database column NEWT0_SDP_REMAIN_BALANCE.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    private Date createTime;

    /**
     * This field corresponds to the database column NEWT0_SDP_REMAIN_BALANCE.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column NEWT0_SDP_REMAIN_BALANCE.END_TIME
     * column comments 生效结束日
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    private Date endTime;

    /**
     * This field corresponds to the database column NEWT0_SDP_REMAIN_BALANCE.CAN_USE_QUOTA
     * column comments 可使用额度
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    private BigDecimal canUseQuota;

    /**
     * This field corresponds to the database column NEWT0_SDP_REMAIN_BALANCE.FROZEN_QUOTA
     * column comments 冻结额度
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    private BigDecimal frozenQuota;

    /**
     * This field corresponds to the database column NEWT0_SDP_REMAIN_BALANCE.USED_QUOTA
     * column comments 已使用额度
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    private BigDecimal usedQuota;

    /**
     * This field corresponds to the database table NEWT0_SDP_REMAIN_BALANCE
     * table comments 盛付通全资日历
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table NEWT0_SDP_REMAIN_BALANCE
     * table comments 盛付通全资日历
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table NEWT0_SDP_REMAIN_BALANCE
     * table comments 盛付通全资日历
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table NEWT0_SDP_REMAIN_BALANCE
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public Newt0SdpRemainBalanceDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column NEWT0_SDP_REMAIN_BALANCE.ID
     *
     * @return the value of NEWT0_SDP_REMAIN_BALANCE.ID
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column NEWT0_SDP_REMAIN_BALANCE.ID
     *
     * @param id the value for NEWT0_SDP_REMAIN_BALANCE.ID
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column NEWT0_SDP_REMAIN_BALANCE.START_TIME
     *
     * @return the value of NEWT0_SDP_REMAIN_BALANCE.START_TIME
     * column comments 生效开始日
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * This method sets the value of the database column NEWT0_SDP_REMAIN_BALANCE.START_TIME
     *
     * @param startTime the value for NEWT0_SDP_REMAIN_BALANCE.START_TIME
     * column comments 生效开始日
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * This method returns the value of the database column NEWT0_SDP_REMAIN_BALANCE.QUOTA
     *
     * @return the value of NEWT0_SDP_REMAIN_BALANCE.QUOTA
     * column comments 配资额度
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public BigDecimal getQuota() {
        return quota;
    }

    /**
     * This method sets the value of the database column NEWT0_SDP_REMAIN_BALANCE.QUOTA
     *
     * @param quota the value for NEWT0_SDP_REMAIN_BALANCE.QUOTA
     * column comments 配资额度
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public void setQuota(BigDecimal quota) {
        this.quota = quota;
    }

    /**
     * This method returns the value of the database column NEWT0_SDP_REMAIN_BALANCE.CREATE_TIME
     *
     * @return the value of NEWT0_SDP_REMAIN_BALANCE.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column NEWT0_SDP_REMAIN_BALANCE.CREATE_TIME
     *
     * @param createTime the value for NEWT0_SDP_REMAIN_BALANCE.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column NEWT0_SDP_REMAIN_BALANCE.UPDATE_TIME
     *
     * @return the value of NEWT0_SDP_REMAIN_BALANCE.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column NEWT0_SDP_REMAIN_BALANCE.UPDATE_TIME
     *
     * @param updateTime the value for NEWT0_SDP_REMAIN_BALANCE.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column NEWT0_SDP_REMAIN_BALANCE.END_TIME
     *
     * @return the value of NEWT0_SDP_REMAIN_BALANCE.END_TIME
     * column comments 生效结束日
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method sets the value of the database column NEWT0_SDP_REMAIN_BALANCE.END_TIME
     *
     * @param endTime the value for NEWT0_SDP_REMAIN_BALANCE.END_TIME
     * column comments 生效结束日
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method returns the value of the database column NEWT0_SDP_REMAIN_BALANCE.CAN_USE_QUOTA
     *
     * @return the value of NEWT0_SDP_REMAIN_BALANCE.CAN_USE_QUOTA
     * column comments 可使用额度
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public BigDecimal getCanUseQuota() {
        return canUseQuota;
    }

    /**
     * This method sets the value of the database column NEWT0_SDP_REMAIN_BALANCE.CAN_USE_QUOTA
     *
     * @param canUseQuota the value for NEWT0_SDP_REMAIN_BALANCE.CAN_USE_QUOTA
     * column comments 可使用额度
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public void setCanUseQuota(BigDecimal canUseQuota) {
        this.canUseQuota = canUseQuota;
    }

    /**
     * This method returns the value of the database column NEWT0_SDP_REMAIN_BALANCE.FROZEN_QUOTA
     *
     * @return the value of NEWT0_SDP_REMAIN_BALANCE.FROZEN_QUOTA
     * column comments 冻结额度
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public BigDecimal getFrozenQuota() {
        return frozenQuota;
    }

    /**
     * This method sets the value of the database column NEWT0_SDP_REMAIN_BALANCE.FROZEN_QUOTA
     *
     * @param frozenQuota the value for NEWT0_SDP_REMAIN_BALANCE.FROZEN_QUOTA
     * column comments 冻结额度
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public void setFrozenQuota(BigDecimal frozenQuota) {
        this.frozenQuota = frozenQuota;
    }

    /**
     * This method returns the value of the database column NEWT0_SDP_REMAIN_BALANCE.USED_QUOTA
     *
     * @return the value of NEWT0_SDP_REMAIN_BALANCE.USED_QUOTA
     * column comments 已使用额度
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public BigDecimal getUsedQuota() {
        return usedQuota;
    }

    /**
     * This method sets the value of the database column NEWT0_SDP_REMAIN_BALANCE.USED_QUOTA
     *
     * @param usedQuota the value for NEWT0_SDP_REMAIN_BALANCE.USED_QUOTA
     * column comments 已使用额度
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public void setUsedQuota(BigDecimal usedQuota) {
        this.usedQuota = usedQuota;
    }

    /**
     * This method corresponds to the database table NEWT0_SDP_REMAIN_BALANCE
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table NEWT0_SDP_REMAIN_BALANCE
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table NEWT0_SDP_REMAIN_BALANCE
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table NEWT0_SDP_REMAIN_BALANCE
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table NEWT0_SDP_REMAIN_BALANCE
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table NEWT0_SDP_REMAIN_BALANCE
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table NEWT0_SDP_REMAIN_BALANCE
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table NEWT0_SDP_REMAIN_BALANCE
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table NEWT0_SDP_REMAIN_BALANCE
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table NEWT0_SDP_REMAIN_BALANCE
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table NEWT0_SDP_REMAIN_BALANCE
     * table comment :盛付通全资日历
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
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

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andQuotaIsNull() {
            addCriterion("QUOTA is null");
            return (Criteria) this;
        }

        public Criteria andQuotaIsNotNull() {
            addCriterion("QUOTA is not null");
            return (Criteria) this;
        }

        public Criteria andQuotaEqualTo(BigDecimal value) {
            addCriterion("QUOTA =", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaNotEqualTo(BigDecimal value) {
            addCriterion("QUOTA <>", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaGreaterThan(BigDecimal value) {
            addCriterion("QUOTA >", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QUOTA >=", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaLessThan(BigDecimal value) {
            addCriterion("QUOTA <", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QUOTA <=", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaIn(List<BigDecimal> values) {
            addCriterion("QUOTA in", values, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaNotIn(List<BigDecimal> values) {
            addCriterion("QUOTA not in", values, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QUOTA between", value1, value2, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QUOTA not between", value1, value2, "quota");
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

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andCanUseQuotaIsNull() {
            addCriterion("CAN_USE_QUOTA is null");
            return (Criteria) this;
        }

        public Criteria andCanUseQuotaIsNotNull() {
            addCriterion("CAN_USE_QUOTA is not null");
            return (Criteria) this;
        }

        public Criteria andCanUseQuotaEqualTo(BigDecimal value) {
            addCriterion("CAN_USE_QUOTA =", value, "canUseQuota");
            return (Criteria) this;
        }

        public Criteria andCanUseQuotaNotEqualTo(BigDecimal value) {
            addCriterion("CAN_USE_QUOTA <>", value, "canUseQuota");
            return (Criteria) this;
        }

        public Criteria andCanUseQuotaGreaterThan(BigDecimal value) {
            addCriterion("CAN_USE_QUOTA >", value, "canUseQuota");
            return (Criteria) this;
        }

        public Criteria andCanUseQuotaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CAN_USE_QUOTA >=", value, "canUseQuota");
            return (Criteria) this;
        }

        public Criteria andCanUseQuotaLessThan(BigDecimal value) {
            addCriterion("CAN_USE_QUOTA <", value, "canUseQuota");
            return (Criteria) this;
        }

        public Criteria andCanUseQuotaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CAN_USE_QUOTA <=", value, "canUseQuota");
            return (Criteria) this;
        }

        public Criteria andCanUseQuotaIn(List<BigDecimal> values) {
            addCriterion("CAN_USE_QUOTA in", values, "canUseQuota");
            return (Criteria) this;
        }

        public Criteria andCanUseQuotaNotIn(List<BigDecimal> values) {
            addCriterion("CAN_USE_QUOTA not in", values, "canUseQuota");
            return (Criteria) this;
        }

        public Criteria andCanUseQuotaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CAN_USE_QUOTA between", value1, value2, "canUseQuota");
            return (Criteria) this;
        }

        public Criteria andCanUseQuotaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CAN_USE_QUOTA not between", value1, value2, "canUseQuota");
            return (Criteria) this;
        }

        public Criteria andFrozenQuotaIsNull() {
            addCriterion("FROZEN_QUOTA is null");
            return (Criteria) this;
        }

        public Criteria andFrozenQuotaIsNotNull() {
            addCriterion("FROZEN_QUOTA is not null");
            return (Criteria) this;
        }

        public Criteria andFrozenQuotaEqualTo(BigDecimal value) {
            addCriterion("FROZEN_QUOTA =", value, "frozenQuota");
            return (Criteria) this;
        }

        public Criteria andFrozenQuotaNotEqualTo(BigDecimal value) {
            addCriterion("FROZEN_QUOTA <>", value, "frozenQuota");
            return (Criteria) this;
        }

        public Criteria andFrozenQuotaGreaterThan(BigDecimal value) {
            addCriterion("FROZEN_QUOTA >", value, "frozenQuota");
            return (Criteria) this;
        }

        public Criteria andFrozenQuotaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FROZEN_QUOTA >=", value, "frozenQuota");
            return (Criteria) this;
        }

        public Criteria andFrozenQuotaLessThan(BigDecimal value) {
            addCriterion("FROZEN_QUOTA <", value, "frozenQuota");
            return (Criteria) this;
        }

        public Criteria andFrozenQuotaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FROZEN_QUOTA <=", value, "frozenQuota");
            return (Criteria) this;
        }

        public Criteria andFrozenQuotaIn(List<BigDecimal> values) {
            addCriterion("FROZEN_QUOTA in", values, "frozenQuota");
            return (Criteria) this;
        }

        public Criteria andFrozenQuotaNotIn(List<BigDecimal> values) {
            addCriterion("FROZEN_QUOTA not in", values, "frozenQuota");
            return (Criteria) this;
        }

        public Criteria andFrozenQuotaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FROZEN_QUOTA between", value1, value2, "frozenQuota");
            return (Criteria) this;
        }

        public Criteria andFrozenQuotaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FROZEN_QUOTA not between", value1, value2, "frozenQuota");
            return (Criteria) this;
        }

        public Criteria andUsedQuotaIsNull() {
            addCriterion("USED_QUOTA is null");
            return (Criteria) this;
        }

        public Criteria andUsedQuotaIsNotNull() {
            addCriterion("USED_QUOTA is not null");
            return (Criteria) this;
        }

        public Criteria andUsedQuotaEqualTo(BigDecimal value) {
            addCriterion("USED_QUOTA =", value, "usedQuota");
            return (Criteria) this;
        }

        public Criteria andUsedQuotaNotEqualTo(BigDecimal value) {
            addCriterion("USED_QUOTA <>", value, "usedQuota");
            return (Criteria) this;
        }

        public Criteria andUsedQuotaGreaterThan(BigDecimal value) {
            addCriterion("USED_QUOTA >", value, "usedQuota");
            return (Criteria) this;
        }

        public Criteria andUsedQuotaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("USED_QUOTA >=", value, "usedQuota");
            return (Criteria) this;
        }

        public Criteria andUsedQuotaLessThan(BigDecimal value) {
            addCriterion("USED_QUOTA <", value, "usedQuota");
            return (Criteria) this;
        }

        public Criteria andUsedQuotaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("USED_QUOTA <=", value, "usedQuota");
            return (Criteria) this;
        }

        public Criteria andUsedQuotaIn(List<BigDecimal> values) {
            addCriterion("USED_QUOTA in", values, "usedQuota");
            return (Criteria) this;
        }

        public Criteria andUsedQuotaNotIn(List<BigDecimal> values) {
            addCriterion("USED_QUOTA not in", values, "usedQuota");
            return (Criteria) this;
        }

        public Criteria andUsedQuotaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USED_QUOTA between", value1, value2, "usedQuota");
            return (Criteria) this;
        }

        public Criteria andUsedQuotaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USED_QUOTA not between", value1, value2, "usedQuota");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table NEWT0_SDP_REMAIN_BALANCE
     *
     * @mbggenerated do_not_delete_during_merge Thu Oct 01 17:24:53 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table NEWT0_SDP_REMAIN_BALANCE
     * table comment :盛付通全资日历
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
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