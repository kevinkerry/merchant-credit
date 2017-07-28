package com.sdp.mc.view.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sdp.emall.common.dao.QueryBase;

public class ViewPromoterInfoDTOExample extends QueryBase {
	 /**
     * This field corresponds to the database column VIEW_PROMOTER_INFO.PROMOTER_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    private Long promoterId;

    /**
     * This field corresponds to the database column VIEW_PROMOTER_INFO.PROMOTER_MERCHANT_NO
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    private String promoterMerchantNo;

    /**
     * This field corresponds to the database column VIEW_PROMOTER_INFO.PROMOTER_NAME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    private String promoterName;

    /**
     * This field corresponds to the database column VIEW_PROMOTER_INFO.PROMOTER_TYPE
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    private String promoterType;

    /**
     * This field corresponds to the database column VIEW_PROMOTER_INFO.PROMOTER_FS_FLAG
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    private Integer promoterFsFlag;

    /**
     * This field corresponds to the database column VIEW_PROMOTER_INFO.PROMOTER_FS_LIMIT
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    private BigDecimal promoterFsLimit;

    /**
     * This field corresponds to the database column VIEW_PROMOTER_INFO.PROMOTER_FS_MARGIN
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    private BigDecimal promoterFsMargin;

    /**
     * This field corresponds to the database column VIEW_PROMOTER_INFO.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column VIEW_PROMOTER_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column VIEW_PROMOTER_INFO.LOANING_TYPE
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    private Integer loaningType;

    /**
     * This field corresponds to the database column VIEW_PROMOTER_INFO.PROMOTER_BIZ_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    private Long promoterBizId;

    /**
     * This field corresponds to the database table VIEW_PROMOTER_INFO
     * table comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table VIEW_PROMOTER_INFO
     * table comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table VIEW_PROMOTER_INFO
     * table comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table VIEW_PROMOTER_INFO
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public ViewPromoterInfoDTOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column VIEW_PROMOTER_INFO.PROMOTER_ID
     *
     * @return the value of VIEW_PROMOTER_INFO.PROMOTER_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public Long getPromoterId() {
        return promoterId;
    }

    /**
     * This method sets the value of the database column VIEW_PROMOTER_INFO.PROMOTER_ID
     *
     * @param promoterId the value for VIEW_PROMOTER_INFO.PROMOTER_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void setPromoterId(Long promoterId) {
        this.promoterId = promoterId;
    }

    /**
     * This method returns the value of the database column VIEW_PROMOTER_INFO.PROMOTER_MERCHANT_NO
     *
     * @return the value of VIEW_PROMOTER_INFO.PROMOTER_MERCHANT_NO
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public String getPromoterMerchantNo() {
        return promoterMerchantNo;
    }

    /**
     * This method sets the value of the database column VIEW_PROMOTER_INFO.PROMOTER_MERCHANT_NO
     *
     * @param promoterMerchantNo the value for VIEW_PROMOTER_INFO.PROMOTER_MERCHANT_NO
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void setPromoterMerchantNo(String promoterMerchantNo) {
        this.promoterMerchantNo = promoterMerchantNo == null ? null : promoterMerchantNo.trim();
    }

    /**
     * This method returns the value of the database column VIEW_PROMOTER_INFO.PROMOTER_NAME
     *
     * @return the value of VIEW_PROMOTER_INFO.PROMOTER_NAME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public String getPromoterName() {
        return promoterName;
    }

    /**
     * This method sets the value of the database column VIEW_PROMOTER_INFO.PROMOTER_NAME
     *
     * @param promoterName the value for VIEW_PROMOTER_INFO.PROMOTER_NAME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void setPromoterName(String promoterName) {
        this.promoterName = promoterName == null ? null : promoterName.trim();
    }

    /**
     * This method returns the value of the database column VIEW_PROMOTER_INFO.PROMOTER_TYPE
     *
     * @return the value of VIEW_PROMOTER_INFO.PROMOTER_TYPE
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public String getPromoterType() {
        return promoterType;
    }

    /**
     * This method sets the value of the database column VIEW_PROMOTER_INFO.PROMOTER_TYPE
     *
     * @param promoterType the value for VIEW_PROMOTER_INFO.PROMOTER_TYPE
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void setPromoterType(String promoterType) {
        this.promoterType = promoterType == null ? null : promoterType.trim();
    }

    /**
     * This method returns the value of the database column VIEW_PROMOTER_INFO.PROMOTER_FS_FLAG
     *
     * @return the value of VIEW_PROMOTER_INFO.PROMOTER_FS_FLAG
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public Integer getPromoterFsFlag() {
        return promoterFsFlag;
    }

    /**
     * This method sets the value of the database column VIEW_PROMOTER_INFO.PROMOTER_FS_FLAG
     *
     * @param promoterFsFlag the value for VIEW_PROMOTER_INFO.PROMOTER_FS_FLAG
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void setPromoterFsFlag(Integer promoterFsFlag) {
        this.promoterFsFlag = promoterFsFlag;
    }

    /**
     * This method returns the value of the database column VIEW_PROMOTER_INFO.PROMOTER_FS_LIMIT
     *
     * @return the value of VIEW_PROMOTER_INFO.PROMOTER_FS_LIMIT
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public BigDecimal getPromoterFsLimit() {
        return promoterFsLimit;
    }

    /**
     * This method sets the value of the database column VIEW_PROMOTER_INFO.PROMOTER_FS_LIMIT
     *
     * @param promoterFsLimit the value for VIEW_PROMOTER_INFO.PROMOTER_FS_LIMIT
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void setPromoterFsLimit(BigDecimal promoterFsLimit) {
        this.promoterFsLimit = promoterFsLimit;
    }

    /**
     * This method returns the value of the database column VIEW_PROMOTER_INFO.PROMOTER_FS_MARGIN
     *
     * @return the value of VIEW_PROMOTER_INFO.PROMOTER_FS_MARGIN
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public BigDecimal getPromoterFsMargin() {
        return promoterFsMargin;
    }

    /**
     * This method sets the value of the database column VIEW_PROMOTER_INFO.PROMOTER_FS_MARGIN
     *
     * @param promoterFsMargin the value for VIEW_PROMOTER_INFO.PROMOTER_FS_MARGIN
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void setPromoterFsMargin(BigDecimal promoterFsMargin) {
        this.promoterFsMargin = promoterFsMargin;
    }

    /**
     * This method returns the value of the database column VIEW_PROMOTER_INFO.CREATE_TIME
     *
     * @return the value of VIEW_PROMOTER_INFO.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column VIEW_PROMOTER_INFO.CREATE_TIME
     *
     * @param createTime the value for VIEW_PROMOTER_INFO.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column VIEW_PROMOTER_INFO.UPDATE_TIME
     *
     * @return the value of VIEW_PROMOTER_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column VIEW_PROMOTER_INFO.UPDATE_TIME
     *
     * @param updateTime the value for VIEW_PROMOTER_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column VIEW_PROMOTER_INFO.LOANING_TYPE
     *
     * @return the value of VIEW_PROMOTER_INFO.LOANING_TYPE
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public Integer getLoaningType() {
        return loaningType;
    }

    /**
     * This method sets the value of the database column VIEW_PROMOTER_INFO.LOANING_TYPE
     *
     * @param loaningType the value for VIEW_PROMOTER_INFO.LOANING_TYPE
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void setLoaningType(Integer loaningType) {
        this.loaningType = loaningType;
    }

    /**
     * This method returns the value of the database column VIEW_PROMOTER_INFO.PROMOTER_BIZ_ID
     *
     * @return the value of VIEW_PROMOTER_INFO.PROMOTER_BIZ_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public Long getPromoterBizId() {
        return promoterBizId;
    }

    /**
     * This method sets the value of the database column VIEW_PROMOTER_INFO.PROMOTER_BIZ_ID
     *
     * @param promoterBizId the value for VIEW_PROMOTER_INFO.PROMOTER_BIZ_ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void setPromoterBizId(Long promoterBizId) {
        this.promoterBizId = promoterBizId;
    }

    /**
     * This method corresponds to the database table VIEW_PROMOTER_INFO
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table VIEW_PROMOTER_INFO
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table VIEW_PROMOTER_INFO
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table VIEW_PROMOTER_INFO
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table VIEW_PROMOTER_INFO
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table VIEW_PROMOTER_INFO
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table VIEW_PROMOTER_INFO
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table VIEW_PROMOTER_INFO
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table VIEW_PROMOTER_INFO
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table VIEW_PROMOTER_INFO
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table VIEW_PROMOTER_INFO
     * table comment :null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
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

        public Criteria andPromoterMerchantNoEqualTo(String value) {
            addCriterion("PROMOTER_MERCHANT_NO =", value, "promoterMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPromoterMerchantNoNotEqualTo(String value) {
            addCriterion("PROMOTER_MERCHANT_NO <>", value, "promoterMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPromoterMerchantNoGreaterThan(String value) {
            addCriterion("PROMOTER_MERCHANT_NO >", value, "promoterMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPromoterMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("PROMOTER_MERCHANT_NO >=", value, "promoterMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPromoterMerchantNoLessThan(String value) {
            addCriterion("PROMOTER_MERCHANT_NO <", value, "promoterMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPromoterMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("PROMOTER_MERCHANT_NO <=", value, "promoterMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPromoterMerchantNoLike(String value) {
            addCriterion("PROMOTER_MERCHANT_NO like", value, "promoterMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPromoterMerchantNoNotLike(String value) {
            addCriterion("PROMOTER_MERCHANT_NO not like", value, "promoterMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPromoterMerchantNoIn(List<String> values) {
            addCriterion("PROMOTER_MERCHANT_NO in", values, "promoterMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPromoterMerchantNoNotIn(List<String> values) {
            addCriterion("PROMOTER_MERCHANT_NO not in", values, "promoterMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPromoterMerchantNoBetween(String value1, String value2) {
            addCriterion("PROMOTER_MERCHANT_NO between", value1, value2, "promoterMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPromoterMerchantNoNotBetween(String value1, String value2) {
            addCriterion("PROMOTER_MERCHANT_NO not between", value1, value2, "promoterMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPromoterNameIsNull() {
            addCriterion("PROMOTER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPromoterNameIsNotNull() {
            addCriterion("PROMOTER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPromoterNameEqualTo(String value) {
            addCriterion("PROMOTER_NAME =", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameNotEqualTo(String value) {
            addCriterion("PROMOTER_NAME <>", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameGreaterThan(String value) {
            addCriterion("PROMOTER_NAME >", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameGreaterThanOrEqualTo(String value) {
            addCriterion("PROMOTER_NAME >=", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameLessThan(String value) {
            addCriterion("PROMOTER_NAME <", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameLessThanOrEqualTo(String value) {
            addCriterion("PROMOTER_NAME <=", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameLike(String value) {
            addCriterion("PROMOTER_NAME like", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameNotLike(String value) {
            addCriterion("PROMOTER_NAME not like", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameIn(List<String> values) {
            addCriterion("PROMOTER_NAME in", values, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameNotIn(List<String> values) {
            addCriterion("PROMOTER_NAME not in", values, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameBetween(String value1, String value2) {
            addCriterion("PROMOTER_NAME between", value1, value2, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameNotBetween(String value1, String value2) {
            addCriterion("PROMOTER_NAME not between", value1, value2, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterTypeIsNull() {
            addCriterion("PROMOTER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPromoterTypeIsNotNull() {
            addCriterion("PROMOTER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPromoterTypeEqualTo(String value) {
            addCriterion("PROMOTER_TYPE =", value, "promoterType");
            return (Criteria) this;
        }

        public Criteria andPromoterTypeNotEqualTo(String value) {
            addCriterion("PROMOTER_TYPE <>", value, "promoterType");
            return (Criteria) this;
        }

        public Criteria andPromoterTypeGreaterThan(String value) {
            addCriterion("PROMOTER_TYPE >", value, "promoterType");
            return (Criteria) this;
        }

        public Criteria andPromoterTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PROMOTER_TYPE >=", value, "promoterType");
            return (Criteria) this;
        }

        public Criteria andPromoterTypeLessThan(String value) {
            addCriterion("PROMOTER_TYPE <", value, "promoterType");
            return (Criteria) this;
        }

        public Criteria andPromoterTypeLessThanOrEqualTo(String value) {
            addCriterion("PROMOTER_TYPE <=", value, "promoterType");
            return (Criteria) this;
        }

        public Criteria andPromoterTypeLike(String value) {
            addCriterion("PROMOTER_TYPE like", value, "promoterType");
            return (Criteria) this;
        }

        public Criteria andPromoterTypeNotLike(String value) {
            addCriterion("PROMOTER_TYPE not like", value, "promoterType");
            return (Criteria) this;
        }

        public Criteria andPromoterTypeIn(List<String> values) {
            addCriterion("PROMOTER_TYPE in", values, "promoterType");
            return (Criteria) this;
        }

        public Criteria andPromoterTypeNotIn(List<String> values) {
            addCriterion("PROMOTER_TYPE not in", values, "promoterType");
            return (Criteria) this;
        }

        public Criteria andPromoterTypeBetween(String value1, String value2) {
            addCriterion("PROMOTER_TYPE between", value1, value2, "promoterType");
            return (Criteria) this;
        }

        public Criteria andPromoterTypeNotBetween(String value1, String value2) {
            addCriterion("PROMOTER_TYPE not between", value1, value2, "promoterType");
            return (Criteria) this;
        }

        public Criteria andPromoterFsFlagIsNull() {
            addCriterion("PROMOTER_FS_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andPromoterFsFlagIsNotNull() {
            addCriterion("PROMOTER_FS_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andPromoterFsFlagEqualTo(Integer value) {
            addCriterion("PROMOTER_FS_FLAG =", value, "promoterFsFlag");
            return (Criteria) this;
        }

        public Criteria andPromoterFsFlagNotEqualTo(Integer value) {
            addCriterion("PROMOTER_FS_FLAG <>", value, "promoterFsFlag");
            return (Criteria) this;
        }

        public Criteria andPromoterFsFlagGreaterThan(Integer value) {
            addCriterion("PROMOTER_FS_FLAG >", value, "promoterFsFlag");
            return (Criteria) this;
        }

        public Criteria andPromoterFsFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("PROMOTER_FS_FLAG >=", value, "promoterFsFlag");
            return (Criteria) this;
        }

        public Criteria andPromoterFsFlagLessThan(Integer value) {
            addCriterion("PROMOTER_FS_FLAG <", value, "promoterFsFlag");
            return (Criteria) this;
        }

        public Criteria andPromoterFsFlagLessThanOrEqualTo(Integer value) {
            addCriterion("PROMOTER_FS_FLAG <=", value, "promoterFsFlag");
            return (Criteria) this;
        }

        public Criteria andPromoterFsFlagIn(List<Integer> values) {
            addCriterion("PROMOTER_FS_FLAG in", values, "promoterFsFlag");
            return (Criteria) this;
        }

        public Criteria andPromoterFsFlagNotIn(List<Integer> values) {
            addCriterion("PROMOTER_FS_FLAG not in", values, "promoterFsFlag");
            return (Criteria) this;
        }

        public Criteria andPromoterFsFlagBetween(Integer value1, Integer value2) {
            addCriterion("PROMOTER_FS_FLAG between", value1, value2, "promoterFsFlag");
            return (Criteria) this;
        }

        public Criteria andPromoterFsFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("PROMOTER_FS_FLAG not between", value1, value2, "promoterFsFlag");
            return (Criteria) this;
        }

        public Criteria andPromoterFsLimitIsNull() {
            addCriterion("PROMOTER_FS_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andPromoterFsLimitIsNotNull() {
            addCriterion("PROMOTER_FS_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andPromoterFsLimitEqualTo(BigDecimal value) {
            addCriterion("PROMOTER_FS_LIMIT =", value, "promoterFsLimit");
            return (Criteria) this;
        }

        public Criteria andPromoterFsLimitNotEqualTo(BigDecimal value) {
            addCriterion("PROMOTER_FS_LIMIT <>", value, "promoterFsLimit");
            return (Criteria) this;
        }

        public Criteria andPromoterFsLimitGreaterThan(BigDecimal value) {
            addCriterion("PROMOTER_FS_LIMIT >", value, "promoterFsLimit");
            return (Criteria) this;
        }

        public Criteria andPromoterFsLimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROMOTER_FS_LIMIT >=", value, "promoterFsLimit");
            return (Criteria) this;
        }

        public Criteria andPromoterFsLimitLessThan(BigDecimal value) {
            addCriterion("PROMOTER_FS_LIMIT <", value, "promoterFsLimit");
            return (Criteria) this;
        }

        public Criteria andPromoterFsLimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROMOTER_FS_LIMIT <=", value, "promoterFsLimit");
            return (Criteria) this;
        }

        public Criteria andPromoterFsLimitIn(List<BigDecimal> values) {
            addCriterion("PROMOTER_FS_LIMIT in", values, "promoterFsLimit");
            return (Criteria) this;
        }

        public Criteria andPromoterFsLimitNotIn(List<BigDecimal> values) {
            addCriterion("PROMOTER_FS_LIMIT not in", values, "promoterFsLimit");
            return (Criteria) this;
        }

        public Criteria andPromoterFsLimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROMOTER_FS_LIMIT between", value1, value2, "promoterFsLimit");
            return (Criteria) this;
        }

        public Criteria andPromoterFsLimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROMOTER_FS_LIMIT not between", value1, value2, "promoterFsLimit");
            return (Criteria) this;
        }

        public Criteria andPromoterFsMarginIsNull() {
            addCriterion("PROMOTER_FS_MARGIN is null");
            return (Criteria) this;
        }

        public Criteria andPromoterFsMarginIsNotNull() {
            addCriterion("PROMOTER_FS_MARGIN is not null");
            return (Criteria) this;
        }

        public Criteria andPromoterFsMarginEqualTo(BigDecimal value) {
            addCriterion("PROMOTER_FS_MARGIN =", value, "promoterFsMargin");
            return (Criteria) this;
        }

        public Criteria andPromoterFsMarginNotEqualTo(BigDecimal value) {
            addCriterion("PROMOTER_FS_MARGIN <>", value, "promoterFsMargin");
            return (Criteria) this;
        }

        public Criteria andPromoterFsMarginGreaterThan(BigDecimal value) {
            addCriterion("PROMOTER_FS_MARGIN >", value, "promoterFsMargin");
            return (Criteria) this;
        }

        public Criteria andPromoterFsMarginGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROMOTER_FS_MARGIN >=", value, "promoterFsMargin");
            return (Criteria) this;
        }

        public Criteria andPromoterFsMarginLessThan(BigDecimal value) {
            addCriterion("PROMOTER_FS_MARGIN <", value, "promoterFsMargin");
            return (Criteria) this;
        }

        public Criteria andPromoterFsMarginLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROMOTER_FS_MARGIN <=", value, "promoterFsMargin");
            return (Criteria) this;
        }

        public Criteria andPromoterFsMarginIn(List<BigDecimal> values) {
            addCriterion("PROMOTER_FS_MARGIN in", values, "promoterFsMargin");
            return (Criteria) this;
        }

        public Criteria andPromoterFsMarginNotIn(List<BigDecimal> values) {
            addCriterion("PROMOTER_FS_MARGIN not in", values, "promoterFsMargin");
            return (Criteria) this;
        }

        public Criteria andPromoterFsMarginBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROMOTER_FS_MARGIN between", value1, value2, "promoterFsMargin");
            return (Criteria) this;
        }

        public Criteria andPromoterFsMarginNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROMOTER_FS_MARGIN not between", value1, value2, "promoterFsMargin");
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

        public Criteria andPromoterBizIdIsNull() {
            addCriterion("PROMOTER_BIZ_ID is null");
            return (Criteria) this;
        }

        public Criteria andPromoterBizIdIsNotNull() {
            addCriterion("PROMOTER_BIZ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPromoterBizIdEqualTo(Long value) {
            addCriterion("PROMOTER_BIZ_ID =", value, "promoterBizId");
            return (Criteria) this;
        }

        public Criteria andPromoterBizIdNotEqualTo(Long value) {
            addCriterion("PROMOTER_BIZ_ID <>", value, "promoterBizId");
            return (Criteria) this;
        }

        public Criteria andPromoterBizIdGreaterThan(Long value) {
            addCriterion("PROMOTER_BIZ_ID >", value, "promoterBizId");
            return (Criteria) this;
        }

        public Criteria andPromoterBizIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PROMOTER_BIZ_ID >=", value, "promoterBizId");
            return (Criteria) this;
        }

        public Criteria andPromoterBizIdLessThan(Long value) {
            addCriterion("PROMOTER_BIZ_ID <", value, "promoterBizId");
            return (Criteria) this;
        }

        public Criteria andPromoterBizIdLessThanOrEqualTo(Long value) {
            addCriterion("PROMOTER_BIZ_ID <=", value, "promoterBizId");
            return (Criteria) this;
        }

        public Criteria andPromoterBizIdIn(List<Long> values) {
            addCriterion("PROMOTER_BIZ_ID in", values, "promoterBizId");
            return (Criteria) this;
        }

        public Criteria andPromoterBizIdNotIn(List<Long> values) {
            addCriterion("PROMOTER_BIZ_ID not in", values, "promoterBizId");
            return (Criteria) this;
        }

        public Criteria andPromoterBizIdBetween(Long value1, Long value2) {
            addCriterion("PROMOTER_BIZ_ID between", value1, value2, "promoterBizId");
            return (Criteria) this;
        }

        public Criteria andPromoterBizIdNotBetween(Long value1, Long value2) {
            addCriterion("PROMOTER_BIZ_ID not between", value1, value2, "promoterBizId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table VIEW_PROMOTER_INFO
     *
     * @mbggenerated do_not_delete_during_merge Wed Aug 17 13:50:23 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table VIEW_PROMOTER_INFO
     * table comment :null
     *
     * @mbggenerated Wed Aug 17 13:50:23 CST 2016
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