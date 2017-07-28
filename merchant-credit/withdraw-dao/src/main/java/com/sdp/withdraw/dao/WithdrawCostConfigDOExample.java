package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WithdrawCostConfigDOExample extends QueryBase {
    /**
     * This field corresponds to the database column FW_WITHDRAW_COST_CONFIG.ID
     * column comments ID
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    private Long id;

    /**
     * This field corresponds to the database column FW_WITHDRAW_COST_CONFIG.TYPE
     * column comments 配置类型（1: 默认,2:限定）
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    private Integer type;

    /**
     * This field corresponds to the database column FW_WITHDRAW_COST_CONFIG.MERCHANT_TYPE
     * column comments 商户类型
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    private String merchantType;

    /**
     * This field corresponds to the database column FW_WITHDRAW_COST_CONFIG.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    private String merchantNo;

    /**
     * This field corresponds to the database column FW_WITHDRAW_COST_CONFIG.WD_COST
     * column comments 提现费用
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    private BigDecimal wdCost;

    /**
     * This field corresponds to the database column FW_WITHDRAW_COST_CONFIG.WD_PROMOTER_SPLITTING_SCALE
     * column comments 代理商分润比例
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    private BigDecimal wdPromoterSplittingScale;

    /**
     * This field corresponds to the database column FW_WITHDRAW_COST_CONFIG.STATUS
     * column comments 状态(1: 有效，0：失效)
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    private Integer status;

    /**
     * This field corresponds to the database column FW_WITHDRAW_COST_CONFIG.OPERATOR_ID
     * column comments 操作人ID
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    private String operatorId;

    /**
     * This field corresponds to the database column FW_WITHDRAW_COST_CONFIG.OPERATOR_NAME
     * column comments 操作人名称
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    private String operatorName;

    /**
     * This field corresponds to the database column FW_WITHDRAW_COST_CONFIG.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_COST_CONFIG.UPDATE_TIME
     * column comments 更新时间
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    private Date updateTime;

    /**
     * This field corresponds to the database table FW_WITHDRAW_COST_CONFIG
     * table comments null
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table FW_WITHDRAW_COST_CONFIG
     * table comments null
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table FW_WITHDRAW_COST_CONFIG
     * table comments null
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table FW_WITHDRAW_COST_CONFIG
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public WithdrawCostConfigDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_COST_CONFIG.ID
     *
     * @return the value of FW_WITHDRAW_COST_CONFIG.ID
     * column comments ID
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_COST_CONFIG.ID
     *
     * @param id the value for FW_WITHDRAW_COST_CONFIG.ID
     * column comments ID
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_COST_CONFIG.TYPE
     *
     * @return the value of FW_WITHDRAW_COST_CONFIG.TYPE
     * column comments 配置类型（1: 默认,2:限定）
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_COST_CONFIG.TYPE
     *
     * @param type the value for FW_WITHDRAW_COST_CONFIG.TYPE
     * column comments 配置类型（1: 默认,2:限定）
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_COST_CONFIG.MERCHANT_TYPE
     *
     * @return the value of FW_WITHDRAW_COST_CONFIG.MERCHANT_TYPE
     * column comments 商户类型
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public String getMerchantType() {
        return merchantType;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_COST_CONFIG.MERCHANT_TYPE
     *
     * @param merchantType the value for FW_WITHDRAW_COST_CONFIG.MERCHANT_TYPE
     * column comments 商户类型
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType == null ? null : merchantType.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_COST_CONFIG.MERCHANT_NO
     *
     * @return the value of FW_WITHDRAW_COST_CONFIG.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_COST_CONFIG.MERCHANT_NO
     *
     * @param merchantNo the value for FW_WITHDRAW_COST_CONFIG.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_COST_CONFIG.WD_COST
     *
     * @return the value of FW_WITHDRAW_COST_CONFIG.WD_COST
     * column comments 提现费用
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public BigDecimal getWdCost() {
        return wdCost;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_COST_CONFIG.WD_COST
     *
     * @param wdCost the value for FW_WITHDRAW_COST_CONFIG.WD_COST
     * column comments 提现费用
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void setWdCost(BigDecimal wdCost) {
        this.wdCost = wdCost;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_COST_CONFIG.WD_PROMOTER_SPLITTING_SCALE
     *
     * @return the value of FW_WITHDRAW_COST_CONFIG.WD_PROMOTER_SPLITTING_SCALE
     * column comments 代理商分润比例
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public BigDecimal getWdPromoterSplittingScale() {
        return wdPromoterSplittingScale;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_COST_CONFIG.WD_PROMOTER_SPLITTING_SCALE
     *
     * @param wdPromoterSplittingScale the value for FW_WITHDRAW_COST_CONFIG.WD_PROMOTER_SPLITTING_SCALE
     * column comments 代理商分润比例
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void setWdPromoterSplittingScale(BigDecimal wdPromoterSplittingScale) {
        this.wdPromoterSplittingScale = wdPromoterSplittingScale;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_COST_CONFIG.STATUS
     *
     * @return the value of FW_WITHDRAW_COST_CONFIG.STATUS
     * column comments 状态(1: 有效，0：失效)
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_COST_CONFIG.STATUS
     *
     * @param status the value for FW_WITHDRAW_COST_CONFIG.STATUS
     * column comments 状态(1: 有效，0：失效)
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_COST_CONFIG.OPERATOR_ID
     *
     * @return the value of FW_WITHDRAW_COST_CONFIG.OPERATOR_ID
     * column comments 操作人ID
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_COST_CONFIG.OPERATOR_ID
     *
     * @param operatorId the value for FW_WITHDRAW_COST_CONFIG.OPERATOR_ID
     * column comments 操作人ID
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_COST_CONFIG.OPERATOR_NAME
     *
     * @return the value of FW_WITHDRAW_COST_CONFIG.OPERATOR_NAME
     * column comments 操作人名称
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_COST_CONFIG.OPERATOR_NAME
     *
     * @param operatorName the value for FW_WITHDRAW_COST_CONFIG.OPERATOR_NAME
     * column comments 操作人名称
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_COST_CONFIG.CREATE_TIME
     *
     * @return the value of FW_WITHDRAW_COST_CONFIG.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_COST_CONFIG.CREATE_TIME
     *
     * @param createTime the value for FW_WITHDRAW_COST_CONFIG.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_COST_CONFIG.UPDATE_TIME
     *
     * @return the value of FW_WITHDRAW_COST_CONFIG.UPDATE_TIME
     * column comments 更新时间
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_COST_CONFIG.UPDATE_TIME
     *
     * @param updateTime the value for FW_WITHDRAW_COST_CONFIG.UPDATE_TIME
     * column comments 更新时间
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_COST_CONFIG
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_COST_CONFIG
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_COST_CONFIG
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_COST_CONFIG
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_COST_CONFIG
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_COST_CONFIG
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_COST_CONFIG
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_COST_CONFIG
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_COST_CONFIG
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_COST_CONFIG
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WITHDRAW_COST_CONFIG
     * table comment :null
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
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

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeIsNull() {
            addCriterion("MERCHANT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeIsNotNull() {
            addCriterion("MERCHANT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeEqualTo(String value) {
            addCriterion("MERCHANT_TYPE =", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeNotEqualTo(String value) {
            addCriterion("MERCHANT_TYPE <>", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeGreaterThan(String value) {
            addCriterion("MERCHANT_TYPE >", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_TYPE >=", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeLessThan(String value) {
            addCriterion("MERCHANT_TYPE <", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_TYPE <=", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeLike(String value) {
            addCriterion("MERCHANT_TYPE like", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeNotLike(String value) {
            addCriterion("MERCHANT_TYPE not like", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeIn(List<String> values) {
            addCriterion("MERCHANT_TYPE in", values, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeNotIn(List<String> values) {
            addCriterion("MERCHANT_TYPE not in", values, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeBetween(String value1, String value2) {
            addCriterion("MERCHANT_TYPE between", value1, value2, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_TYPE not between", value1, value2, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIsNull() {
            addCriterion("MERCHANT_NO is null");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIsNotNull() {
            addCriterion("MERCHANT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantNoEqualTo(String value) {
            addCriterion("MERCHANT_NO =", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotEqualTo(String value) {
            addCriterion("MERCHANT_NO <>", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoGreaterThan(String value) {
            addCriterion("MERCHANT_NO >", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_NO >=", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLessThan(String value) {
            addCriterion("MERCHANT_NO <", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_NO <=", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLike(String value) {
            addCriterion("MERCHANT_NO like", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotLike(String value) {
            addCriterion("MERCHANT_NO not like", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIn(List<String> values) {
            addCriterion("MERCHANT_NO in", values, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotIn(List<String> values) {
            addCriterion("MERCHANT_NO not in", values, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoBetween(String value1, String value2) {
            addCriterion("MERCHANT_NO between", value1, value2, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_NO not between", value1, value2, "merchantNo");
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

        public Criteria andWdPromoterSplittingScaleIsNull() {
            addCriterion("WD_PROMOTER_SPLITTING_SCALE is null");
            return (Criteria) this;
        }

        public Criteria andWdPromoterSplittingScaleIsNotNull() {
            addCriterion("WD_PROMOTER_SPLITTING_SCALE is not null");
            return (Criteria) this;
        }

        public Criteria andWdPromoterSplittingScaleEqualTo(BigDecimal value) {
            addCriterion("WD_PROMOTER_SPLITTING_SCALE =", value, "wdPromoterSplittingScale");
            return (Criteria) this;
        }

        public Criteria andWdPromoterSplittingScaleNotEqualTo(BigDecimal value) {
            addCriterion("WD_PROMOTER_SPLITTING_SCALE <>", value, "wdPromoterSplittingScale");
            return (Criteria) this;
        }

        public Criteria andWdPromoterSplittingScaleGreaterThan(BigDecimal value) {
            addCriterion("WD_PROMOTER_SPLITTING_SCALE >", value, "wdPromoterSplittingScale");
            return (Criteria) this;
        }

        public Criteria andWdPromoterSplittingScaleGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WD_PROMOTER_SPLITTING_SCALE >=", value, "wdPromoterSplittingScale");
            return (Criteria) this;
        }

        public Criteria andWdPromoterSplittingScaleLessThan(BigDecimal value) {
            addCriterion("WD_PROMOTER_SPLITTING_SCALE <", value, "wdPromoterSplittingScale");
            return (Criteria) this;
        }

        public Criteria andWdPromoterSplittingScaleLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WD_PROMOTER_SPLITTING_SCALE <=", value, "wdPromoterSplittingScale");
            return (Criteria) this;
        }

        public Criteria andWdPromoterSplittingScaleIn(List<BigDecimal> values) {
            addCriterion("WD_PROMOTER_SPLITTING_SCALE in", values, "wdPromoterSplittingScale");
            return (Criteria) this;
        }

        public Criteria andWdPromoterSplittingScaleNotIn(List<BigDecimal> values) {
            addCriterion("WD_PROMOTER_SPLITTING_SCALE not in", values, "wdPromoterSplittingScale");
            return (Criteria) this;
        }

        public Criteria andWdPromoterSplittingScaleBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WD_PROMOTER_SPLITTING_SCALE between", value1, value2, "wdPromoterSplittingScale");
            return (Criteria) this;
        }

        public Criteria andWdPromoterSplittingScaleNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WD_PROMOTER_SPLITTING_SCALE not between", value1, value2, "wdPromoterSplittingScale");
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

        public Criteria andOperatorNameIsNull() {
            addCriterion("OPERATOR_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNotNull() {
            addCriterion("OPERATOR_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameEqualTo(String value) {
            addCriterion("OPERATOR_NAME =", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotEqualTo(String value) {
            addCriterion("OPERATOR_NAME <>", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThan(String value) {
            addCriterion("OPERATOR_NAME >", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATOR_NAME >=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThan(String value) {
            addCriterion("OPERATOR_NAME <", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThanOrEqualTo(String value) {
            addCriterion("OPERATOR_NAME <=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLike(String value) {
            addCriterion("OPERATOR_NAME like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotLike(String value) {
            addCriterion("OPERATOR_NAME not like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIn(List<String> values) {
            addCriterion("OPERATOR_NAME in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotIn(List<String> values) {
            addCriterion("OPERATOR_NAME not in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameBetween(String value1, String value2) {
            addCriterion("OPERATOR_NAME between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotBetween(String value1, String value2) {
            addCriterion("OPERATOR_NAME not between", value1, value2, "operatorName");
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
     * This class corresponds to the database table FW_WITHDRAW_COST_CONFIG
     *
     * @mbggenerated do_not_delete_during_merge Mon Jul 11 16:59:00 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WITHDRAW_COST_CONFIG
     * table comment :null
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
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