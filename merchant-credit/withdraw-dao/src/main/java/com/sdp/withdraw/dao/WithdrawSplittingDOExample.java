package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WithdrawSplittingDOExample extends QueryBase {
    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.ID
     * column comments null
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private Long id;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.REQ_ID
     * column comments null
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private Long reqId;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.BASE_COST
     * column comments 基本费用
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal baseCost;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.BASE_COST_SPLITTING_SCALE
     * column comments 代理商分润比例
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal baseCostSplittingScale;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.BASE_COST_SHENGPAY_SPLITTING
     * column comments 盛付通分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal baseCostShengpaySplitting;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.BASE_COST_PROMOTER_SPLITTING
     * column comments 代理商分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal baseCostPromoterSplitting;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.WD_COST
     * column comments 提现费用
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal wdCost;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.WD_COST_SPLITTING_SCALE
     * column comments 代理商提现分润比例
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal wdCostSplittingScale;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.WD_COST_SHENGPAY_SPLITTING
     * column comments 提现费用盛付通分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal wdCostShengpaySplitting;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.WD_COST_PROMOTER_SPLITTING
     * column comments 提现费用代理商分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal wdCostPromoterSplitting;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.PLATFORM_COST
     * column comments 平台成本
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal platformCost;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.SHENGPAY_TOTAL_COST
     * column comments 盛付通总分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal shengpayTotalCost;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.PROMOTER_TOTAL_COST
     * column comments 代理商总分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal promoterTotalCost;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.DAY_SETTLE_AWARD
     * column comments 日结算量奖励
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal daySettleAward;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.MONTH_ACTIVE_AWARD
     * column comments 月激活量奖励
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal monthActiveAward;

    /**
     * This field corresponds to the database table FW_WITHDRAW_SPLITTING
     * table comments 出款分润表
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table FW_WITHDRAW_SPLITTING
     * table comments 出款分润表
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table FW_WITHDRAW_SPLITTING
     * table comments 出款分润表
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table FW_WITHDRAW_SPLITTING
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public WithdrawSplittingDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.ID
     *
     * @return the value of FW_WITHDRAW_SPLITTING.ID
     * column comments null
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.ID
     *
     * @param id the value for FW_WITHDRAW_SPLITTING.ID
     * column comments null
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.REQ_ID
     *
     * @return the value of FW_WITHDRAW_SPLITTING.REQ_ID
     * column comments null
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public Long getReqId() {
        return reqId;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.REQ_ID
     *
     * @param reqId the value for FW_WITHDRAW_SPLITTING.REQ_ID
     * column comments null
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.BASE_COST
     *
     * @return the value of FW_WITHDRAW_SPLITTING.BASE_COST
     * column comments 基本费用
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getBaseCost() {
        return baseCost;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.BASE_COST
     *
     * @param baseCost the value for FW_WITHDRAW_SPLITTING.BASE_COST
     * column comments 基本费用
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setBaseCost(BigDecimal baseCost) {
        this.baseCost = baseCost;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.BASE_COST_SPLITTING_SCALE
     *
     * @return the value of FW_WITHDRAW_SPLITTING.BASE_COST_SPLITTING_SCALE
     * column comments 代理商分润比例
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getBaseCostSplittingScale() {
        return baseCostSplittingScale;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.BASE_COST_SPLITTING_SCALE
     *
     * @param baseCostSplittingScale the value for FW_WITHDRAW_SPLITTING.BASE_COST_SPLITTING_SCALE
     * column comments 代理商分润比例
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setBaseCostSplittingScale(BigDecimal baseCostSplittingScale) {
        this.baseCostSplittingScale = baseCostSplittingScale;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.BASE_COST_SHENGPAY_SPLITTING
     *
     * @return the value of FW_WITHDRAW_SPLITTING.BASE_COST_SHENGPAY_SPLITTING
     * column comments 盛付通分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getBaseCostShengpaySplitting() {
        return baseCostShengpaySplitting;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.BASE_COST_SHENGPAY_SPLITTING
     *
     * @param baseCostShengpaySplitting the value for FW_WITHDRAW_SPLITTING.BASE_COST_SHENGPAY_SPLITTING
     * column comments 盛付通分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setBaseCostShengpaySplitting(BigDecimal baseCostShengpaySplitting) {
        this.baseCostShengpaySplitting = baseCostShengpaySplitting;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.BASE_COST_PROMOTER_SPLITTING
     *
     * @return the value of FW_WITHDRAW_SPLITTING.BASE_COST_PROMOTER_SPLITTING
     * column comments 代理商分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getBaseCostPromoterSplitting() {
        return baseCostPromoterSplitting;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.BASE_COST_PROMOTER_SPLITTING
     *
     * @param baseCostPromoterSplitting the value for FW_WITHDRAW_SPLITTING.BASE_COST_PROMOTER_SPLITTING
     * column comments 代理商分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setBaseCostPromoterSplitting(BigDecimal baseCostPromoterSplitting) {
        this.baseCostPromoterSplitting = baseCostPromoterSplitting;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.WD_COST
     *
     * @return the value of FW_WITHDRAW_SPLITTING.WD_COST
     * column comments 提现费用
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getWdCost() {
        return wdCost;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.WD_COST
     *
     * @param wdCost the value for FW_WITHDRAW_SPLITTING.WD_COST
     * column comments 提现费用
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setWdCost(BigDecimal wdCost) {
        this.wdCost = wdCost;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.WD_COST_SPLITTING_SCALE
     *
     * @return the value of FW_WITHDRAW_SPLITTING.WD_COST_SPLITTING_SCALE
     * column comments 代理商提现分润比例
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getWdCostSplittingScale() {
        return wdCostSplittingScale;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.WD_COST_SPLITTING_SCALE
     *
     * @param wdCostSplittingScale the value for FW_WITHDRAW_SPLITTING.WD_COST_SPLITTING_SCALE
     * column comments 代理商提现分润比例
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setWdCostSplittingScale(BigDecimal wdCostSplittingScale) {
        this.wdCostSplittingScale = wdCostSplittingScale;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.WD_COST_SHENGPAY_SPLITTING
     *
     * @return the value of FW_WITHDRAW_SPLITTING.WD_COST_SHENGPAY_SPLITTING
     * column comments 提现费用盛付通分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getWdCostShengpaySplitting() {
        return wdCostShengpaySplitting;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.WD_COST_SHENGPAY_SPLITTING
     *
     * @param wdCostShengpaySplitting the value for FW_WITHDRAW_SPLITTING.WD_COST_SHENGPAY_SPLITTING
     * column comments 提现费用盛付通分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setWdCostShengpaySplitting(BigDecimal wdCostShengpaySplitting) {
        this.wdCostShengpaySplitting = wdCostShengpaySplitting;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.WD_COST_PROMOTER_SPLITTING
     *
     * @return the value of FW_WITHDRAW_SPLITTING.WD_COST_PROMOTER_SPLITTING
     * column comments 提现费用代理商分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getWdCostPromoterSplitting() {
        return wdCostPromoterSplitting;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.WD_COST_PROMOTER_SPLITTING
     *
     * @param wdCostPromoterSplitting the value for FW_WITHDRAW_SPLITTING.WD_COST_PROMOTER_SPLITTING
     * column comments 提现费用代理商分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setWdCostPromoterSplitting(BigDecimal wdCostPromoterSplitting) {
        this.wdCostPromoterSplitting = wdCostPromoterSplitting;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.PLATFORM_COST
     *
     * @return the value of FW_WITHDRAW_SPLITTING.PLATFORM_COST
     * column comments 平台成本
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getPlatformCost() {
        return platformCost;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.PLATFORM_COST
     *
     * @param platformCost the value for FW_WITHDRAW_SPLITTING.PLATFORM_COST
     * column comments 平台成本
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setPlatformCost(BigDecimal platformCost) {
        this.platformCost = platformCost;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.SHENGPAY_TOTAL_COST
     *
     * @return the value of FW_WITHDRAW_SPLITTING.SHENGPAY_TOTAL_COST
     * column comments 盛付通总分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getShengpayTotalCost() {
        return shengpayTotalCost;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.SHENGPAY_TOTAL_COST
     *
     * @param shengpayTotalCost the value for FW_WITHDRAW_SPLITTING.SHENGPAY_TOTAL_COST
     * column comments 盛付通总分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setShengpayTotalCost(BigDecimal shengpayTotalCost) {
        this.shengpayTotalCost = shengpayTotalCost;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.PROMOTER_TOTAL_COST
     *
     * @return the value of FW_WITHDRAW_SPLITTING.PROMOTER_TOTAL_COST
     * column comments 代理商总分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getPromoterTotalCost() {
        return promoterTotalCost;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.PROMOTER_TOTAL_COST
     *
     * @param promoterTotalCost the value for FW_WITHDRAW_SPLITTING.PROMOTER_TOTAL_COST
     * column comments 代理商总分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setPromoterTotalCost(BigDecimal promoterTotalCost) {
        this.promoterTotalCost = promoterTotalCost;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.CREATE_TIME
     *
     * @return the value of FW_WITHDRAW_SPLITTING.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.CREATE_TIME
     *
     * @param createTime the value for FW_WITHDRAW_SPLITTING.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.UPDATE_TIME
     *
     * @return the value of FW_WITHDRAW_SPLITTING.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.UPDATE_TIME
     *
     * @param updateTime the value for FW_WITHDRAW_SPLITTING.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.DAY_SETTLE_AWARD
     *
     * @return the value of FW_WITHDRAW_SPLITTING.DAY_SETTLE_AWARD
     * column comments 日结算量奖励
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getDaySettleAward() {
        return daySettleAward;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.DAY_SETTLE_AWARD
     *
     * @param daySettleAward the value for FW_WITHDRAW_SPLITTING.DAY_SETTLE_AWARD
     * column comments 日结算量奖励
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setDaySettleAward(BigDecimal daySettleAward) {
        this.daySettleAward = daySettleAward;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.MONTH_ACTIVE_AWARD
     *
     * @return the value of FW_WITHDRAW_SPLITTING.MONTH_ACTIVE_AWARD
     * column comments 月激活量奖励
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getMonthActiveAward() {
        return monthActiveAward;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.MONTH_ACTIVE_AWARD
     *
     * @param monthActiveAward the value for FW_WITHDRAW_SPLITTING.MONTH_ACTIVE_AWARD
     * column comments 月激活量奖励
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setMonthActiveAward(BigDecimal monthActiveAward) {
        this.monthActiveAward = monthActiveAward;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_SPLITTING
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_SPLITTING
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_SPLITTING
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_SPLITTING
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_SPLITTING
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_SPLITTING
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_SPLITTING
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_SPLITTING
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_SPLITTING
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_SPLITTING
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WITHDRAW_SPLITTING
     * table comment :出款分润表
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
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

        public Criteria andBaseCostIsNull() {
            addCriterion("BASE_COST is null");
            return (Criteria) this;
        }

        public Criteria andBaseCostIsNotNull() {
            addCriterion("BASE_COST is not null");
            return (Criteria) this;
        }

        public Criteria andBaseCostEqualTo(BigDecimal value) {
            addCriterion("BASE_COST =", value, "baseCost");
            return (Criteria) this;
        }

        public Criteria andBaseCostNotEqualTo(BigDecimal value) {
            addCriterion("BASE_COST <>", value, "baseCost");
            return (Criteria) this;
        }

        public Criteria andBaseCostGreaterThan(BigDecimal value) {
            addCriterion("BASE_COST >", value, "baseCost");
            return (Criteria) this;
        }

        public Criteria andBaseCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BASE_COST >=", value, "baseCost");
            return (Criteria) this;
        }

        public Criteria andBaseCostLessThan(BigDecimal value) {
            addCriterion("BASE_COST <", value, "baseCost");
            return (Criteria) this;
        }

        public Criteria andBaseCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BASE_COST <=", value, "baseCost");
            return (Criteria) this;
        }

        public Criteria andBaseCostIn(List<BigDecimal> values) {
            addCriterion("BASE_COST in", values, "baseCost");
            return (Criteria) this;
        }

        public Criteria andBaseCostNotIn(List<BigDecimal> values) {
            addCriterion("BASE_COST not in", values, "baseCost");
            return (Criteria) this;
        }

        public Criteria andBaseCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BASE_COST between", value1, value2, "baseCost");
            return (Criteria) this;
        }

        public Criteria andBaseCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BASE_COST not between", value1, value2, "baseCost");
            return (Criteria) this;
        }

        public Criteria andBaseCostSplittingScaleIsNull() {
            addCriterion("BASE_COST_SPLITTING_SCALE is null");
            return (Criteria) this;
        }

        public Criteria andBaseCostSplittingScaleIsNotNull() {
            addCriterion("BASE_COST_SPLITTING_SCALE is not null");
            return (Criteria) this;
        }

        public Criteria andBaseCostSplittingScaleEqualTo(BigDecimal value) {
            addCriterion("BASE_COST_SPLITTING_SCALE =", value, "baseCostSplittingScale");
            return (Criteria) this;
        }

        public Criteria andBaseCostSplittingScaleNotEqualTo(BigDecimal value) {
            addCriterion("BASE_COST_SPLITTING_SCALE <>", value, "baseCostSplittingScale");
            return (Criteria) this;
        }

        public Criteria andBaseCostSplittingScaleGreaterThan(BigDecimal value) {
            addCriterion("BASE_COST_SPLITTING_SCALE >", value, "baseCostSplittingScale");
            return (Criteria) this;
        }

        public Criteria andBaseCostSplittingScaleGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BASE_COST_SPLITTING_SCALE >=", value, "baseCostSplittingScale");
            return (Criteria) this;
        }

        public Criteria andBaseCostSplittingScaleLessThan(BigDecimal value) {
            addCriterion("BASE_COST_SPLITTING_SCALE <", value, "baseCostSplittingScale");
            return (Criteria) this;
        }

        public Criteria andBaseCostSplittingScaleLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BASE_COST_SPLITTING_SCALE <=", value, "baseCostSplittingScale");
            return (Criteria) this;
        }

        public Criteria andBaseCostSplittingScaleIn(List<BigDecimal> values) {
            addCriterion("BASE_COST_SPLITTING_SCALE in", values, "baseCostSplittingScale");
            return (Criteria) this;
        }

        public Criteria andBaseCostSplittingScaleNotIn(List<BigDecimal> values) {
            addCriterion("BASE_COST_SPLITTING_SCALE not in", values, "baseCostSplittingScale");
            return (Criteria) this;
        }

        public Criteria andBaseCostSplittingScaleBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BASE_COST_SPLITTING_SCALE between", value1, value2, "baseCostSplittingScale");
            return (Criteria) this;
        }

        public Criteria andBaseCostSplittingScaleNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BASE_COST_SPLITTING_SCALE not between", value1, value2, "baseCostSplittingScale");
            return (Criteria) this;
        }

        public Criteria andBaseCostShengpaySplittingIsNull() {
            addCriterion("BASE_COST_SHENGPAY_SPLITTING is null");
            return (Criteria) this;
        }

        public Criteria andBaseCostShengpaySplittingIsNotNull() {
            addCriterion("BASE_COST_SHENGPAY_SPLITTING is not null");
            return (Criteria) this;
        }

        public Criteria andBaseCostShengpaySplittingEqualTo(BigDecimal value) {
            addCriterion("BASE_COST_SHENGPAY_SPLITTING =", value, "baseCostShengpaySplitting");
            return (Criteria) this;
        }

        public Criteria andBaseCostShengpaySplittingNotEqualTo(BigDecimal value) {
            addCriterion("BASE_COST_SHENGPAY_SPLITTING <>", value, "baseCostShengpaySplitting");
            return (Criteria) this;
        }

        public Criteria andBaseCostShengpaySplittingGreaterThan(BigDecimal value) {
            addCriterion("BASE_COST_SHENGPAY_SPLITTING >", value, "baseCostShengpaySplitting");
            return (Criteria) this;
        }

        public Criteria andBaseCostShengpaySplittingGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BASE_COST_SHENGPAY_SPLITTING >=", value, "baseCostShengpaySplitting");
            return (Criteria) this;
        }

        public Criteria andBaseCostShengpaySplittingLessThan(BigDecimal value) {
            addCriterion("BASE_COST_SHENGPAY_SPLITTING <", value, "baseCostShengpaySplitting");
            return (Criteria) this;
        }

        public Criteria andBaseCostShengpaySplittingLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BASE_COST_SHENGPAY_SPLITTING <=", value, "baseCostShengpaySplitting");
            return (Criteria) this;
        }

        public Criteria andBaseCostShengpaySplittingIn(List<BigDecimal> values) {
            addCriterion("BASE_COST_SHENGPAY_SPLITTING in", values, "baseCostShengpaySplitting");
            return (Criteria) this;
        }

        public Criteria andBaseCostShengpaySplittingNotIn(List<BigDecimal> values) {
            addCriterion("BASE_COST_SHENGPAY_SPLITTING not in", values, "baseCostShengpaySplitting");
            return (Criteria) this;
        }

        public Criteria andBaseCostShengpaySplittingBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BASE_COST_SHENGPAY_SPLITTING between", value1, value2, "baseCostShengpaySplitting");
            return (Criteria) this;
        }

        public Criteria andBaseCostShengpaySplittingNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BASE_COST_SHENGPAY_SPLITTING not between", value1, value2, "baseCostShengpaySplitting");
            return (Criteria) this;
        }

        public Criteria andBaseCostPromoterSplittingIsNull() {
            addCriterion("BASE_COST_PROMOTER_SPLITTING is null");
            return (Criteria) this;
        }

        public Criteria andBaseCostPromoterSplittingIsNotNull() {
            addCriterion("BASE_COST_PROMOTER_SPLITTING is not null");
            return (Criteria) this;
        }

        public Criteria andBaseCostPromoterSplittingEqualTo(BigDecimal value) {
            addCriterion("BASE_COST_PROMOTER_SPLITTING =", value, "baseCostPromoterSplitting");
            return (Criteria) this;
        }

        public Criteria andBaseCostPromoterSplittingNotEqualTo(BigDecimal value) {
            addCriterion("BASE_COST_PROMOTER_SPLITTING <>", value, "baseCostPromoterSplitting");
            return (Criteria) this;
        }

        public Criteria andBaseCostPromoterSplittingGreaterThan(BigDecimal value) {
            addCriterion("BASE_COST_PROMOTER_SPLITTING >", value, "baseCostPromoterSplitting");
            return (Criteria) this;
        }

        public Criteria andBaseCostPromoterSplittingGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BASE_COST_PROMOTER_SPLITTING >=", value, "baseCostPromoterSplitting");
            return (Criteria) this;
        }

        public Criteria andBaseCostPromoterSplittingLessThan(BigDecimal value) {
            addCriterion("BASE_COST_PROMOTER_SPLITTING <", value, "baseCostPromoterSplitting");
            return (Criteria) this;
        }

        public Criteria andBaseCostPromoterSplittingLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BASE_COST_PROMOTER_SPLITTING <=", value, "baseCostPromoterSplitting");
            return (Criteria) this;
        }

        public Criteria andBaseCostPromoterSplittingIn(List<BigDecimal> values) {
            addCriterion("BASE_COST_PROMOTER_SPLITTING in", values, "baseCostPromoterSplitting");
            return (Criteria) this;
        }

        public Criteria andBaseCostPromoterSplittingNotIn(List<BigDecimal> values) {
            addCriterion("BASE_COST_PROMOTER_SPLITTING not in", values, "baseCostPromoterSplitting");
            return (Criteria) this;
        }

        public Criteria andBaseCostPromoterSplittingBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BASE_COST_PROMOTER_SPLITTING between", value1, value2, "baseCostPromoterSplitting");
            return (Criteria) this;
        }

        public Criteria andBaseCostPromoterSplittingNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BASE_COST_PROMOTER_SPLITTING not between", value1, value2, "baseCostPromoterSplitting");
            return (Criteria) this;
        }

        public Criteria andWdCostIsNull() {
            addCriterion("WD_COST is null");
            return (Criteria) this;
        }

        public Criteria andWdCostIsNotNull() {
            addCriterion("WD_COST is not null");
            return (Criteria) this;
        }

        public Criteria andWdCostEqualTo(BigDecimal value) {
            addCriterion("WD_COST =", value, "wdCost");
            return (Criteria) this;
        }

        public Criteria andWdCostNotEqualTo(BigDecimal value) {
            addCriterion("WD_COST <>", value, "wdCost");
            return (Criteria) this;
        }

        public Criteria andWdCostGreaterThan(BigDecimal value) {
            addCriterion("WD_COST >", value, "wdCost");
            return (Criteria) this;
        }

        public Criteria andWdCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WD_COST >=", value, "wdCost");
            return (Criteria) this;
        }

        public Criteria andWdCostLessThan(BigDecimal value) {
            addCriterion("WD_COST <", value, "wdCost");
            return (Criteria) this;
        }

        public Criteria andWdCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WD_COST <=", value, "wdCost");
            return (Criteria) this;
        }

        public Criteria andWdCostIn(List<BigDecimal> values) {
            addCriterion("WD_COST in", values, "wdCost");
            return (Criteria) this;
        }

        public Criteria andWdCostNotIn(List<BigDecimal> values) {
            addCriterion("WD_COST not in", values, "wdCost");
            return (Criteria) this;
        }

        public Criteria andWdCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WD_COST between", value1, value2, "wdCost");
            return (Criteria) this;
        }

        public Criteria andWdCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WD_COST not between", value1, value2, "wdCost");
            return (Criteria) this;
        }

        public Criteria andWdCostSplittingScaleIsNull() {
            addCriterion("WD_COST_SPLITTING_SCALE is null");
            return (Criteria) this;
        }

        public Criteria andWdCostSplittingScaleIsNotNull() {
            addCriterion("WD_COST_SPLITTING_SCALE is not null");
            return (Criteria) this;
        }

        public Criteria andWdCostSplittingScaleEqualTo(BigDecimal value) {
            addCriterion("WD_COST_SPLITTING_SCALE =", value, "wdCostSplittingScale");
            return (Criteria) this;
        }

        public Criteria andWdCostSplittingScaleNotEqualTo(BigDecimal value) {
            addCriterion("WD_COST_SPLITTING_SCALE <>", value, "wdCostSplittingScale");
            return (Criteria) this;
        }

        public Criteria andWdCostSplittingScaleGreaterThan(BigDecimal value) {
            addCriterion("WD_COST_SPLITTING_SCALE >", value, "wdCostSplittingScale");
            return (Criteria) this;
        }

        public Criteria andWdCostSplittingScaleGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WD_COST_SPLITTING_SCALE >=", value, "wdCostSplittingScale");
            return (Criteria) this;
        }

        public Criteria andWdCostSplittingScaleLessThan(BigDecimal value) {
            addCriterion("WD_COST_SPLITTING_SCALE <", value, "wdCostSplittingScale");
            return (Criteria) this;
        }

        public Criteria andWdCostSplittingScaleLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WD_COST_SPLITTING_SCALE <=", value, "wdCostSplittingScale");
            return (Criteria) this;
        }

        public Criteria andWdCostSplittingScaleIn(List<BigDecimal> values) {
            addCriterion("WD_COST_SPLITTING_SCALE in", values, "wdCostSplittingScale");
            return (Criteria) this;
        }

        public Criteria andWdCostSplittingScaleNotIn(List<BigDecimal> values) {
            addCriterion("WD_COST_SPLITTING_SCALE not in", values, "wdCostSplittingScale");
            return (Criteria) this;
        }

        public Criteria andWdCostSplittingScaleBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WD_COST_SPLITTING_SCALE between", value1, value2, "wdCostSplittingScale");
            return (Criteria) this;
        }

        public Criteria andWdCostSplittingScaleNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WD_COST_SPLITTING_SCALE not between", value1, value2, "wdCostSplittingScale");
            return (Criteria) this;
        }

        public Criteria andWdCostShengpaySplittingIsNull() {
            addCriterion("WD_COST_SHENGPAY_SPLITTING is null");
            return (Criteria) this;
        }

        public Criteria andWdCostShengpaySplittingIsNotNull() {
            addCriterion("WD_COST_SHENGPAY_SPLITTING is not null");
            return (Criteria) this;
        }

        public Criteria andWdCostShengpaySplittingEqualTo(BigDecimal value) {
            addCriterion("WD_COST_SHENGPAY_SPLITTING =", value, "wdCostShengpaySplitting");
            return (Criteria) this;
        }

        public Criteria andWdCostShengpaySplittingNotEqualTo(BigDecimal value) {
            addCriterion("WD_COST_SHENGPAY_SPLITTING <>", value, "wdCostShengpaySplitting");
            return (Criteria) this;
        }

        public Criteria andWdCostShengpaySplittingGreaterThan(BigDecimal value) {
            addCriterion("WD_COST_SHENGPAY_SPLITTING >", value, "wdCostShengpaySplitting");
            return (Criteria) this;
        }

        public Criteria andWdCostShengpaySplittingGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WD_COST_SHENGPAY_SPLITTING >=", value, "wdCostShengpaySplitting");
            return (Criteria) this;
        }

        public Criteria andWdCostShengpaySplittingLessThan(BigDecimal value) {
            addCriterion("WD_COST_SHENGPAY_SPLITTING <", value, "wdCostShengpaySplitting");
            return (Criteria) this;
        }

        public Criteria andWdCostShengpaySplittingLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WD_COST_SHENGPAY_SPLITTING <=", value, "wdCostShengpaySplitting");
            return (Criteria) this;
        }

        public Criteria andWdCostShengpaySplittingIn(List<BigDecimal> values) {
            addCriterion("WD_COST_SHENGPAY_SPLITTING in", values, "wdCostShengpaySplitting");
            return (Criteria) this;
        }

        public Criteria andWdCostShengpaySplittingNotIn(List<BigDecimal> values) {
            addCriterion("WD_COST_SHENGPAY_SPLITTING not in", values, "wdCostShengpaySplitting");
            return (Criteria) this;
        }

        public Criteria andWdCostShengpaySplittingBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WD_COST_SHENGPAY_SPLITTING between", value1, value2, "wdCostShengpaySplitting");
            return (Criteria) this;
        }

        public Criteria andWdCostShengpaySplittingNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WD_COST_SHENGPAY_SPLITTING not between", value1, value2, "wdCostShengpaySplitting");
            return (Criteria) this;
        }

        public Criteria andWdCostPromoterSplittingIsNull() {
            addCriterion("WD_COST_PROMOTER_SPLITTING is null");
            return (Criteria) this;
        }

        public Criteria andWdCostPromoterSplittingIsNotNull() {
            addCriterion("WD_COST_PROMOTER_SPLITTING is not null");
            return (Criteria) this;
        }

        public Criteria andWdCostPromoterSplittingEqualTo(BigDecimal value) {
            addCriterion("WD_COST_PROMOTER_SPLITTING =", value, "wdCostPromoterSplitting");
            return (Criteria) this;
        }

        public Criteria andWdCostPromoterSplittingNotEqualTo(BigDecimal value) {
            addCriterion("WD_COST_PROMOTER_SPLITTING <>", value, "wdCostPromoterSplitting");
            return (Criteria) this;
        }

        public Criteria andWdCostPromoterSplittingGreaterThan(BigDecimal value) {
            addCriterion("WD_COST_PROMOTER_SPLITTING >", value, "wdCostPromoterSplitting");
            return (Criteria) this;
        }

        public Criteria andWdCostPromoterSplittingGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WD_COST_PROMOTER_SPLITTING >=", value, "wdCostPromoterSplitting");
            return (Criteria) this;
        }

        public Criteria andWdCostPromoterSplittingLessThan(BigDecimal value) {
            addCriterion("WD_COST_PROMOTER_SPLITTING <", value, "wdCostPromoterSplitting");
            return (Criteria) this;
        }

        public Criteria andWdCostPromoterSplittingLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WD_COST_PROMOTER_SPLITTING <=", value, "wdCostPromoterSplitting");
            return (Criteria) this;
        }

        public Criteria andWdCostPromoterSplittingIn(List<BigDecimal> values) {
            addCriterion("WD_COST_PROMOTER_SPLITTING in", values, "wdCostPromoterSplitting");
            return (Criteria) this;
        }

        public Criteria andWdCostPromoterSplittingNotIn(List<BigDecimal> values) {
            addCriterion("WD_COST_PROMOTER_SPLITTING not in", values, "wdCostPromoterSplitting");
            return (Criteria) this;
        }

        public Criteria andWdCostPromoterSplittingBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WD_COST_PROMOTER_SPLITTING between", value1, value2, "wdCostPromoterSplitting");
            return (Criteria) this;
        }

        public Criteria andWdCostPromoterSplittingNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WD_COST_PROMOTER_SPLITTING not between", value1, value2, "wdCostPromoterSplitting");
            return (Criteria) this;
        }

        public Criteria andPlatformCostIsNull() {
            addCriterion("PLATFORM_COST is null");
            return (Criteria) this;
        }

        public Criteria andPlatformCostIsNotNull() {
            addCriterion("PLATFORM_COST is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformCostEqualTo(BigDecimal value) {
            addCriterion("PLATFORM_COST =", value, "platformCost");
            return (Criteria) this;
        }

        public Criteria andPlatformCostNotEqualTo(BigDecimal value) {
            addCriterion("PLATFORM_COST <>", value, "platformCost");
            return (Criteria) this;
        }

        public Criteria andPlatformCostGreaterThan(BigDecimal value) {
            addCriterion("PLATFORM_COST >", value, "platformCost");
            return (Criteria) this;
        }

        public Criteria andPlatformCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PLATFORM_COST >=", value, "platformCost");
            return (Criteria) this;
        }

        public Criteria andPlatformCostLessThan(BigDecimal value) {
            addCriterion("PLATFORM_COST <", value, "platformCost");
            return (Criteria) this;
        }

        public Criteria andPlatformCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PLATFORM_COST <=", value, "platformCost");
            return (Criteria) this;
        }

        public Criteria andPlatformCostIn(List<BigDecimal> values) {
            addCriterion("PLATFORM_COST in", values, "platformCost");
            return (Criteria) this;
        }

        public Criteria andPlatformCostNotIn(List<BigDecimal> values) {
            addCriterion("PLATFORM_COST not in", values, "platformCost");
            return (Criteria) this;
        }

        public Criteria andPlatformCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PLATFORM_COST between", value1, value2, "platformCost");
            return (Criteria) this;
        }

        public Criteria andPlatformCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PLATFORM_COST not between", value1, value2, "platformCost");
            return (Criteria) this;
        }

        public Criteria andShengpayTotalCostIsNull() {
            addCriterion("SHENGPAY_TOTAL_COST is null");
            return (Criteria) this;
        }

        public Criteria andShengpayTotalCostIsNotNull() {
            addCriterion("SHENGPAY_TOTAL_COST is not null");
            return (Criteria) this;
        }

        public Criteria andShengpayTotalCostEqualTo(BigDecimal value) {
            addCriterion("SHENGPAY_TOTAL_COST =", value, "shengpayTotalCost");
            return (Criteria) this;
        }

        public Criteria andShengpayTotalCostNotEqualTo(BigDecimal value) {
            addCriterion("SHENGPAY_TOTAL_COST <>", value, "shengpayTotalCost");
            return (Criteria) this;
        }

        public Criteria andShengpayTotalCostGreaterThan(BigDecimal value) {
            addCriterion("SHENGPAY_TOTAL_COST >", value, "shengpayTotalCost");
            return (Criteria) this;
        }

        public Criteria andShengpayTotalCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SHENGPAY_TOTAL_COST >=", value, "shengpayTotalCost");
            return (Criteria) this;
        }

        public Criteria andShengpayTotalCostLessThan(BigDecimal value) {
            addCriterion("SHENGPAY_TOTAL_COST <", value, "shengpayTotalCost");
            return (Criteria) this;
        }

        public Criteria andShengpayTotalCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SHENGPAY_TOTAL_COST <=", value, "shengpayTotalCost");
            return (Criteria) this;
        }

        public Criteria andShengpayTotalCostIn(List<BigDecimal> values) {
            addCriterion("SHENGPAY_TOTAL_COST in", values, "shengpayTotalCost");
            return (Criteria) this;
        }

        public Criteria andShengpayTotalCostNotIn(List<BigDecimal> values) {
            addCriterion("SHENGPAY_TOTAL_COST not in", values, "shengpayTotalCost");
            return (Criteria) this;
        }

        public Criteria andShengpayTotalCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SHENGPAY_TOTAL_COST between", value1, value2, "shengpayTotalCost");
            return (Criteria) this;
        }

        public Criteria andShengpayTotalCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SHENGPAY_TOTAL_COST not between", value1, value2, "shengpayTotalCost");
            return (Criteria) this;
        }

        public Criteria andPromoterTotalCostIsNull() {
            addCriterion("PROMOTER_TOTAL_COST is null");
            return (Criteria) this;
        }

        public Criteria andPromoterTotalCostIsNotNull() {
            addCriterion("PROMOTER_TOTAL_COST is not null");
            return (Criteria) this;
        }

        public Criteria andPromoterTotalCostEqualTo(BigDecimal value) {
            addCriterion("PROMOTER_TOTAL_COST =", value, "promoterTotalCost");
            return (Criteria) this;
        }

        public Criteria andPromoterTotalCostNotEqualTo(BigDecimal value) {
            addCriterion("PROMOTER_TOTAL_COST <>", value, "promoterTotalCost");
            return (Criteria) this;
        }

        public Criteria andPromoterTotalCostGreaterThan(BigDecimal value) {
            addCriterion("PROMOTER_TOTAL_COST >", value, "promoterTotalCost");
            return (Criteria) this;
        }

        public Criteria andPromoterTotalCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROMOTER_TOTAL_COST >=", value, "promoterTotalCost");
            return (Criteria) this;
        }

        public Criteria andPromoterTotalCostLessThan(BigDecimal value) {
            addCriterion("PROMOTER_TOTAL_COST <", value, "promoterTotalCost");
            return (Criteria) this;
        }

        public Criteria andPromoterTotalCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROMOTER_TOTAL_COST <=", value, "promoterTotalCost");
            return (Criteria) this;
        }

        public Criteria andPromoterTotalCostIn(List<BigDecimal> values) {
            addCriterion("PROMOTER_TOTAL_COST in", values, "promoterTotalCost");
            return (Criteria) this;
        }

        public Criteria andPromoterTotalCostNotIn(List<BigDecimal> values) {
            addCriterion("PROMOTER_TOTAL_COST not in", values, "promoterTotalCost");
            return (Criteria) this;
        }

        public Criteria andPromoterTotalCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROMOTER_TOTAL_COST between", value1, value2, "promoterTotalCost");
            return (Criteria) this;
        }

        public Criteria andPromoterTotalCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROMOTER_TOTAL_COST not between", value1, value2, "promoterTotalCost");
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

        public Criteria andDaySettleAwardIsNull() {
            addCriterion("DAY_SETTLE_AWARD is null");
            return (Criteria) this;
        }

        public Criteria andDaySettleAwardIsNotNull() {
            addCriterion("DAY_SETTLE_AWARD is not null");
            return (Criteria) this;
        }

        public Criteria andDaySettleAwardEqualTo(BigDecimal value) {
            addCriterion("DAY_SETTLE_AWARD =", value, "daySettleAward");
            return (Criteria) this;
        }

        public Criteria andDaySettleAwardNotEqualTo(BigDecimal value) {
            addCriterion("DAY_SETTLE_AWARD <>", value, "daySettleAward");
            return (Criteria) this;
        }

        public Criteria andDaySettleAwardGreaterThan(BigDecimal value) {
            addCriterion("DAY_SETTLE_AWARD >", value, "daySettleAward");
            return (Criteria) this;
        }

        public Criteria andDaySettleAwardGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DAY_SETTLE_AWARD >=", value, "daySettleAward");
            return (Criteria) this;
        }

        public Criteria andDaySettleAwardLessThan(BigDecimal value) {
            addCriterion("DAY_SETTLE_AWARD <", value, "daySettleAward");
            return (Criteria) this;
        }

        public Criteria andDaySettleAwardLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DAY_SETTLE_AWARD <=", value, "daySettleAward");
            return (Criteria) this;
        }

        public Criteria andDaySettleAwardIn(List<BigDecimal> values) {
            addCriterion("DAY_SETTLE_AWARD in", values, "daySettleAward");
            return (Criteria) this;
        }

        public Criteria andDaySettleAwardNotIn(List<BigDecimal> values) {
            addCriterion("DAY_SETTLE_AWARD not in", values, "daySettleAward");
            return (Criteria) this;
        }

        public Criteria andDaySettleAwardBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DAY_SETTLE_AWARD between", value1, value2, "daySettleAward");
            return (Criteria) this;
        }

        public Criteria andDaySettleAwardNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DAY_SETTLE_AWARD not between", value1, value2, "daySettleAward");
            return (Criteria) this;
        }

        public Criteria andMonthActiveAwardIsNull() {
            addCriterion("MONTH_ACTIVE_AWARD is null");
            return (Criteria) this;
        }

        public Criteria andMonthActiveAwardIsNotNull() {
            addCriterion("MONTH_ACTIVE_AWARD is not null");
            return (Criteria) this;
        }

        public Criteria andMonthActiveAwardEqualTo(BigDecimal value) {
            addCriterion("MONTH_ACTIVE_AWARD =", value, "monthActiveAward");
            return (Criteria) this;
        }

        public Criteria andMonthActiveAwardNotEqualTo(BigDecimal value) {
            addCriterion("MONTH_ACTIVE_AWARD <>", value, "monthActiveAward");
            return (Criteria) this;
        }

        public Criteria andMonthActiveAwardGreaterThan(BigDecimal value) {
            addCriterion("MONTH_ACTIVE_AWARD >", value, "monthActiveAward");
            return (Criteria) this;
        }

        public Criteria andMonthActiveAwardGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MONTH_ACTIVE_AWARD >=", value, "monthActiveAward");
            return (Criteria) this;
        }

        public Criteria andMonthActiveAwardLessThan(BigDecimal value) {
            addCriterion("MONTH_ACTIVE_AWARD <", value, "monthActiveAward");
            return (Criteria) this;
        }

        public Criteria andMonthActiveAwardLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MONTH_ACTIVE_AWARD <=", value, "monthActiveAward");
            return (Criteria) this;
        }

        public Criteria andMonthActiveAwardIn(List<BigDecimal> values) {
            addCriterion("MONTH_ACTIVE_AWARD in", values, "monthActiveAward");
            return (Criteria) this;
        }

        public Criteria andMonthActiveAwardNotIn(List<BigDecimal> values) {
            addCriterion("MONTH_ACTIVE_AWARD not in", values, "monthActiveAward");
            return (Criteria) this;
        }

        public Criteria andMonthActiveAwardBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONTH_ACTIVE_AWARD between", value1, value2, "monthActiveAward");
            return (Criteria) this;
        }

        public Criteria andMonthActiveAwardNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONTH_ACTIVE_AWARD not between", value1, value2, "monthActiveAward");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WITHDRAW_SPLITTING
     *
     * @mbggenerated do_not_delete_during_merge Mon Jul 18 13:16:35 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WITHDRAW_SPLITTING
     * table comment :出款分润表
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
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