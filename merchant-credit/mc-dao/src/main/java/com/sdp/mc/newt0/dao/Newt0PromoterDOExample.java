package com.sdp.mc.newt0.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Newt0PromoterDOExample extends QueryBase {
    /**
     * This field corresponds to the database column NEWT0_PROMOTER.ID
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    private Long id;

    /**
     * This field corresponds to the database column NEWT0_PROMOTER.PROMOTER_ID
     * column comments 代理商编号
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    private Long promoterId;

    /**
     * This field corresponds to the database column NEWT0_PROMOTER.PROMOTER_MERCHANT_NO
     * column comments 代理商商户号
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    private Long promoterMerchantNo;

    /**
     * This field corresponds to the database column NEWT0_PROMOTER.LOANING_TYPE
     * column comments 垫资方
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    private Integer loaningType;

    /**
     * This field corresponds to the database column NEWT0_PROMOTER.VALID_CREDIT
     * column comments 剩余可用额度
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    private BigDecimal validCredit;

    /**
     * This field corresponds to the database column NEWT0_PROMOTER.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    private Date createTime;

    /**
     * This field corresponds to the database column NEWT0_PROMOTER.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    private Date updateTime;

    /**
     * This field corresponds to the database table NEWT0_PROMOTER
     * table comments 代理商基础信息
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table NEWT0_PROMOTER
     * table comments 代理商基础信息
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table NEWT0_PROMOTER
     * table comments 代理商基础信息
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table NEWT0_PROMOTER
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public Newt0PromoterDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column NEWT0_PROMOTER.ID
     *
     * @return the value of NEWT0_PROMOTER.ID
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column NEWT0_PROMOTER.ID
     *
     * @param id the value for NEWT0_PROMOTER.ID
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column NEWT0_PROMOTER.PROMOTER_ID
     *
     * @return the value of NEWT0_PROMOTER.PROMOTER_ID
     * column comments 代理商编号
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public Long getPromoterId() {
        return promoterId;
    }

    /**
     * This method sets the value of the database column NEWT0_PROMOTER.PROMOTER_ID
     *
     * @param promoterId the value for NEWT0_PROMOTER.PROMOTER_ID
     * column comments 代理商编号
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public void setPromoterId(Long promoterId) {
        this.promoterId = promoterId;
    }

    /**
     * This method returns the value of the database column NEWT0_PROMOTER.PROMOTER_MERCHANT_NO
     *
     * @return the value of NEWT0_PROMOTER.PROMOTER_MERCHANT_NO
     * column comments 代理商商户号
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public Long getPromoterMerchantNo() {
        return promoterMerchantNo;
    }

    /**
     * This method sets the value of the database column NEWT0_PROMOTER.PROMOTER_MERCHANT_NO
     *
     * @param promoterMerchantNo the value for NEWT0_PROMOTER.PROMOTER_MERCHANT_NO
     * column comments 代理商商户号
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public void setPromoterMerchantNo(Long promoterMerchantNo) {
        this.promoterMerchantNo = promoterMerchantNo;
    }

    /**
     * This method returns the value of the database column NEWT0_PROMOTER.LOANING_TYPE
     *
     * @return the value of NEWT0_PROMOTER.LOANING_TYPE
     * column comments 垫资方
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public Integer getLoaningType() {
        return loaningType;
    }

    /**
     * This method sets the value of the database column NEWT0_PROMOTER.LOANING_TYPE
     *
     * @param loaningType the value for NEWT0_PROMOTER.LOANING_TYPE
     * column comments 垫资方
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public void setLoaningType(Integer loaningType) {
        this.loaningType = loaningType;
    }

    /**
     * This method returns the value of the database column NEWT0_PROMOTER.VALID_CREDIT
     *
     * @return the value of NEWT0_PROMOTER.VALID_CREDIT
     * column comments 剩余可用额度
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public BigDecimal getValidCredit() {
        return validCredit;
    }

    /**
     * This method sets the value of the database column NEWT0_PROMOTER.VALID_CREDIT
     *
     * @param validCredit the value for NEWT0_PROMOTER.VALID_CREDIT
     * column comments 剩余可用额度
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public void setValidCredit(BigDecimal validCredit) {
        this.validCredit = validCredit;
    }

    /**
     * This method returns the value of the database column NEWT0_PROMOTER.CREATE_TIME
     *
     * @return the value of NEWT0_PROMOTER.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column NEWT0_PROMOTER.CREATE_TIME
     *
     * @param createTime the value for NEWT0_PROMOTER.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column NEWT0_PROMOTER.UPDATE_TIME
     *
     * @return the value of NEWT0_PROMOTER.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column NEWT0_PROMOTER.UPDATE_TIME
     *
     * @param updateTime the value for NEWT0_PROMOTER.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method corresponds to the database table NEWT0_PROMOTER
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table NEWT0_PROMOTER
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table NEWT0_PROMOTER
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table NEWT0_PROMOTER
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table NEWT0_PROMOTER
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table NEWT0_PROMOTER
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table NEWT0_PROMOTER
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table NEWT0_PROMOTER
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
     * This method corresponds to the database table NEWT0_PROMOTER
     *
     * @mbggenerated Thu Oct 01 17:24:53 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table NEWT0_PROMOTER
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
     * This class corresponds to the database table NEWT0_PROMOTER
     * table comment :代理商基础信息
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

        public Criteria andPromoterIdIsNull() {
            addCriterion("PROMOTER_ID is null");
            return (Criteria) this;
        }

        public Criteria andPromoterIdIsNotNull() {
            addCriterion("PROMOTER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPromoterIdEqualTo(Long value) {
            addCriterion("PROMOTER_ID =", value, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdNotEqualTo(Long value) {
            addCriterion("PROMOTER_ID <>", value, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdGreaterThan(Long value) {
            addCriterion("PROMOTER_ID >", value, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PROMOTER_ID >=", value, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdLessThan(Long value) {
            addCriterion("PROMOTER_ID <", value, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdLessThanOrEqualTo(Long value) {
            addCriterion("PROMOTER_ID <=", value, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdIn(List<Long> values) {
            addCriterion("PROMOTER_ID in", values, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdNotIn(List<Long> values) {
            addCriterion("PROMOTER_ID not in", values, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdBetween(Long value1, Long value2) {
            addCriterion("PROMOTER_ID between", value1, value2, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdNotBetween(Long value1, Long value2) {
            addCriterion("PROMOTER_ID not between", value1, value2, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterMerchantNoIsNull() {
            addCriterion("PROMOTER_MERCHANT_NO is null");
            return (Criteria) this;
        }

        public Criteria andPromoterMerchantNoIsNotNull() {
            addCriterion("PROMOTER_MERCHANT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPromoterMerchantNoEqualTo(Long value) {
            addCriterion("PROMOTER_MERCHANT_NO =", value, "promoterMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPromoterMerchantNoNotEqualTo(Long value) {
            addCriterion("PROMOTER_MERCHANT_NO <>", value, "promoterMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPromoterMerchantNoGreaterThan(Long value) {
            addCriterion("PROMOTER_MERCHANT_NO >", value, "promoterMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPromoterMerchantNoGreaterThanOrEqualTo(Long value) {
            addCriterion("PROMOTER_MERCHANT_NO >=", value, "promoterMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPromoterMerchantNoLessThan(Long value) {
            addCriterion("PROMOTER_MERCHANT_NO <", value, "promoterMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPromoterMerchantNoLessThanOrEqualTo(Long value) {
            addCriterion("PROMOTER_MERCHANT_NO <=", value, "promoterMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPromoterMerchantNoIn(List<Long> values) {
            addCriterion("PROMOTER_MERCHANT_NO in", values, "promoterMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPromoterMerchantNoNotIn(List<Long> values) {
            addCriterion("PROMOTER_MERCHANT_NO not in", values, "promoterMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPromoterMerchantNoBetween(Long value1, Long value2) {
            addCriterion("PROMOTER_MERCHANT_NO between", value1, value2, "promoterMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPromoterMerchantNoNotBetween(Long value1, Long value2) {
            addCriterion("PROMOTER_MERCHANT_NO not between", value1, value2, "promoterMerchantNo");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeIsNull() {
            addCriterion("LOANING_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeIsNotNull() {
            addCriterion("LOANING_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeEqualTo(Integer value) {
            addCriterion("LOANING_TYPE =", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeNotEqualTo(Integer value) {
            addCriterion("LOANING_TYPE <>", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeGreaterThan(Integer value) {
            addCriterion("LOANING_TYPE >", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOANING_TYPE >=", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeLessThan(Integer value) {
            addCriterion("LOANING_TYPE <", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeLessThanOrEqualTo(Integer value) {
            addCriterion("LOANING_TYPE <=", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeIn(List<Integer> values) {
            addCriterion("LOANING_TYPE in", values, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeNotIn(List<Integer> values) {
            addCriterion("LOANING_TYPE not in", values, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeBetween(Integer value1, Integer value2) {
            addCriterion("LOANING_TYPE between", value1, value2, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("LOANING_TYPE not between", value1, value2, "loaningType");
            return (Criteria) this;
        }

        public Criteria andValidCreditIsNull() {
            addCriterion("VALID_CREDIT is null");
            return (Criteria) this;
        }

        public Criteria andValidCreditIsNotNull() {
            addCriterion("VALID_CREDIT is not null");
            return (Criteria) this;
        }

        public Criteria andValidCreditEqualTo(BigDecimal value) {
            addCriterion("VALID_CREDIT =", value, "validCredit");
            return (Criteria) this;
        }

        public Criteria andValidCreditNotEqualTo(BigDecimal value) {
            addCriterion("VALID_CREDIT <>", value, "validCredit");
            return (Criteria) this;
        }

        public Criteria andValidCreditGreaterThan(BigDecimal value) {
            addCriterion("VALID_CREDIT >", value, "validCredit");
            return (Criteria) this;
        }

        public Criteria andValidCreditGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("VALID_CREDIT >=", value, "validCredit");
            return (Criteria) this;
        }

        public Criteria andValidCreditLessThan(BigDecimal value) {
            addCriterion("VALID_CREDIT <", value, "validCredit");
            return (Criteria) this;
        }

        public Criteria andValidCreditLessThanOrEqualTo(BigDecimal value) {
            addCriterion("VALID_CREDIT <=", value, "validCredit");
            return (Criteria) this;
        }

        public Criteria andValidCreditIn(List<BigDecimal> values) {
            addCriterion("VALID_CREDIT in", values, "validCredit");
            return (Criteria) this;
        }

        public Criteria andValidCreditNotIn(List<BigDecimal> values) {
            addCriterion("VALID_CREDIT not in", values, "validCredit");
            return (Criteria) this;
        }

        public Criteria andValidCreditBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("VALID_CREDIT between", value1, value2, "validCredit");
            return (Criteria) this;
        }

        public Criteria andValidCreditNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("VALID_CREDIT not between", value1, value2, "validCredit");
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
     * This class corresponds to the database table NEWT0_PROMOTER
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
     * This class corresponds to the database table NEWT0_PROMOTER
     * table comment :代理商基础信息
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