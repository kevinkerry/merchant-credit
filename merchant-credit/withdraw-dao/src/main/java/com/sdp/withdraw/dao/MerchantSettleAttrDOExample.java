package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MerchantSettleAttrDOExample extends QueryBase {
    /**
     * This field corresponds to the database column FW_MERCHANT_SETTLE_ATTR.ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    private Long id;

    /**
     * This field corresponds to the database column FW_MERCHANT_SETTLE_ATTR.BIZ_TYPE
     * column comments 结算类型T0/T1/D1
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    private Integer bizType;

    /**
     * This field corresponds to the database column FW_MERCHANT_SETTLE_ATTR.FIRST_OPEN_TIME
     * column comments 首次开通时间
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    private Date firstOpenTime;

    /**
     * This field corresponds to the database column FW_MERCHANT_SETTLE_ATTR.MERCHANT_NO
     * column comments 扩展字段1
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    private String merchantNo;

    /**
     * This field corresponds to the database column FW_MERCHANT_SETTLE_ATTR.MERCHANT_TYPE
     * column comments 扩展字段2
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    private String merchantType;

    /**
     * This field corresponds to the database column FW_MERCHANT_SETTLE_ATTR.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column FW_MERCHANT_SETTLE_ATTR.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column FW_MERCHANT_SETTLE_ATTR.BIZ_ID
     * column comments 商户的业务ID
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    private Long bizId;

    /**
     * This field corresponds to the database column FW_MERCHANT_SETTLE_ATTR.EXT1
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    private String ext1;

    /**
     * This field corresponds to the database column FW_MERCHANT_SETTLE_ATTR.EXT2
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    private String ext2;

    /**
     * This field corresponds to the database table FW_MERCHANT_SETTLE_ATTR
     * table comments 业务首次开通时间配置信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table FW_MERCHANT_SETTLE_ATTR
     * table comments 业务首次开通时间配置信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table FW_MERCHANT_SETTLE_ATTR
     * table comments 业务首次开通时间配置信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table FW_MERCHANT_SETTLE_ATTR
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public MerchantSettleAttrDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_SETTLE_ATTR.ID
     *
     * @return the value of FW_MERCHANT_SETTLE_ATTR.ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_SETTLE_ATTR.ID
     *
     * @param id the value for FW_MERCHANT_SETTLE_ATTR.ID
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_SETTLE_ATTR.BIZ_TYPE
     *
     * @return the value of FW_MERCHANT_SETTLE_ATTR.BIZ_TYPE
     * column comments 结算类型T0/T1/D1
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public Integer getBizType() {
        return bizType;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_SETTLE_ATTR.BIZ_TYPE
     *
     * @param bizType the value for FW_MERCHANT_SETTLE_ATTR.BIZ_TYPE
     * column comments 结算类型T0/T1/D1
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_SETTLE_ATTR.FIRST_OPEN_TIME
     *
     * @return the value of FW_MERCHANT_SETTLE_ATTR.FIRST_OPEN_TIME
     * column comments 首次开通时间
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public Date getFirstOpenTime() {
        return firstOpenTime;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_SETTLE_ATTR.FIRST_OPEN_TIME
     *
     * @param firstOpenTime the value for FW_MERCHANT_SETTLE_ATTR.FIRST_OPEN_TIME
     * column comments 首次开通时间
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public void setFirstOpenTime(Date firstOpenTime) {
        this.firstOpenTime = firstOpenTime;
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_SETTLE_ATTR.MERCHANT_NO
     *
     * @return the value of FW_MERCHANT_SETTLE_ATTR.MERCHANT_NO
     * column comments 扩展字段1
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_SETTLE_ATTR.MERCHANT_NO
     *
     * @param merchantNo the value for FW_MERCHANT_SETTLE_ATTR.MERCHANT_NO
     * column comments 扩展字段1
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_SETTLE_ATTR.MERCHANT_TYPE
     *
     * @return the value of FW_MERCHANT_SETTLE_ATTR.MERCHANT_TYPE
     * column comments 扩展字段2
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public String getMerchantType() {
        return merchantType;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_SETTLE_ATTR.MERCHANT_TYPE
     *
     * @param merchantType the value for FW_MERCHANT_SETTLE_ATTR.MERCHANT_TYPE
     * column comments 扩展字段2
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType == null ? null : merchantType.trim();
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_SETTLE_ATTR.CREATE_TIME
     *
     * @return the value of FW_MERCHANT_SETTLE_ATTR.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_SETTLE_ATTR.CREATE_TIME
     *
     * @param createTime the value for FW_MERCHANT_SETTLE_ATTR.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_SETTLE_ATTR.UPDATE_TIME
     *
     * @return the value of FW_MERCHANT_SETTLE_ATTR.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_SETTLE_ATTR.UPDATE_TIME
     *
     * @param updateTime the value for FW_MERCHANT_SETTLE_ATTR.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_SETTLE_ATTR.BIZ_ID
     *
     * @return the value of FW_MERCHANT_SETTLE_ATTR.BIZ_ID
     * column comments 商户的业务ID
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public Long getBizId() {
        return bizId;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_SETTLE_ATTR.BIZ_ID
     *
     * @param bizId the value for FW_MERCHANT_SETTLE_ATTR.BIZ_ID
     * column comments 商户的业务ID
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_SETTLE_ATTR.EXT1
     *
     * @return the value of FW_MERCHANT_SETTLE_ATTR.EXT1
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_SETTLE_ATTR.EXT1
     *
     * @param ext1 the value for FW_MERCHANT_SETTLE_ATTR.EXT1
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_SETTLE_ATTR.EXT2
     *
     * @return the value of FW_MERCHANT_SETTLE_ATTR.EXT2
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_SETTLE_ATTR.EXT2
     *
     * @param ext2 the value for FW_MERCHANT_SETTLE_ATTR.EXT2
     * column comments null
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    /**
     * This method corresponds to the database table FW_MERCHANT_SETTLE_ATTR
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table FW_MERCHANT_SETTLE_ATTR
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table FW_MERCHANT_SETTLE_ATTR
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table FW_MERCHANT_SETTLE_ATTR
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table FW_MERCHANT_SETTLE_ATTR
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table FW_MERCHANT_SETTLE_ATTR
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table FW_MERCHANT_SETTLE_ATTR
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_MERCHANT_SETTLE_ATTR
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_MERCHANT_SETTLE_ATTR
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_MERCHANT_SETTLE_ATTR
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_MERCHANT_SETTLE_ATTR
     * table comment :业务首次开通时间配置信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
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

        public Criteria andFirstOpenTimeIsNull() {
            addCriterion("FIRST_OPEN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andFirstOpenTimeIsNotNull() {
            addCriterion("FIRST_OPEN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andFirstOpenTimeEqualTo(Date value) {
            addCriterion("FIRST_OPEN_TIME =", value, "firstOpenTime");
            return (Criteria) this;
        }

        public Criteria andFirstOpenTimeNotEqualTo(Date value) {
            addCriterion("FIRST_OPEN_TIME <>", value, "firstOpenTime");
            return (Criteria) this;
        }

        public Criteria andFirstOpenTimeGreaterThan(Date value) {
            addCriterion("FIRST_OPEN_TIME >", value, "firstOpenTime");
            return (Criteria) this;
        }

        public Criteria andFirstOpenTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("FIRST_OPEN_TIME >=", value, "firstOpenTime");
            return (Criteria) this;
        }

        public Criteria andFirstOpenTimeLessThan(Date value) {
            addCriterion("FIRST_OPEN_TIME <", value, "firstOpenTime");
            return (Criteria) this;
        }

        public Criteria andFirstOpenTimeLessThanOrEqualTo(Date value) {
            addCriterion("FIRST_OPEN_TIME <=", value, "firstOpenTime");
            return (Criteria) this;
        }

        public Criteria andFirstOpenTimeIn(List<Date> values) {
            addCriterion("FIRST_OPEN_TIME in", values, "firstOpenTime");
            return (Criteria) this;
        }

        public Criteria andFirstOpenTimeNotIn(List<Date> values) {
            addCriterion("FIRST_OPEN_TIME not in", values, "firstOpenTime");
            return (Criteria) this;
        }

        public Criteria andFirstOpenTimeBetween(Date value1, Date value2) {
            addCriterion("FIRST_OPEN_TIME between", value1, value2, "firstOpenTime");
            return (Criteria) this;
        }

        public Criteria andFirstOpenTimeNotBetween(Date value1, Date value2) {
            addCriterion("FIRST_OPEN_TIME not between", value1, value2, "firstOpenTime");
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

        public Criteria andExt1IsNull() {
            addCriterion("EXT1 is null");
            return (Criteria) this;
        }

        public Criteria andExt1IsNotNull() {
            addCriterion("EXT1 is not null");
            return (Criteria) this;
        }

        public Criteria andExt1EqualTo(String value) {
            addCriterion("EXT1 =", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotEqualTo(String value) {
            addCriterion("EXT1 <>", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThan(String value) {
            addCriterion("EXT1 >", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThanOrEqualTo(String value) {
            addCriterion("EXT1 >=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThan(String value) {
            addCriterion("EXT1 <", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThanOrEqualTo(String value) {
            addCriterion("EXT1 <=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Like(String value) {
            addCriterion("EXT1 like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotLike(String value) {
            addCriterion("EXT1 not like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1In(List<String> values) {
            addCriterion("EXT1 in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotIn(List<String> values) {
            addCriterion("EXT1 not in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Between(String value1, String value2) {
            addCriterion("EXT1 between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotBetween(String value1, String value2) {
            addCriterion("EXT1 not between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt2IsNull() {
            addCriterion("EXT2 is null");
            return (Criteria) this;
        }

        public Criteria andExt2IsNotNull() {
            addCriterion("EXT2 is not null");
            return (Criteria) this;
        }

        public Criteria andExt2EqualTo(String value) {
            addCriterion("EXT2 =", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotEqualTo(String value) {
            addCriterion("EXT2 <>", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThan(String value) {
            addCriterion("EXT2 >", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThanOrEqualTo(String value) {
            addCriterion("EXT2 >=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThan(String value) {
            addCriterion("EXT2 <", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThanOrEqualTo(String value) {
            addCriterion("EXT2 <=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Like(String value) {
            addCriterion("EXT2 like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotLike(String value) {
            addCriterion("EXT2 not like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2In(List<String> values) {
            addCriterion("EXT2 in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotIn(List<String> values) {
            addCriterion("EXT2 not in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Between(String value1, String value2) {
            addCriterion("EXT2 between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotBetween(String value1, String value2) {
            addCriterion("EXT2 not between", value1, value2, "ext2");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_MERCHANT_SETTLE_ATTR
     *
     * @mbggenerated do_not_delete_during_merge Wed Aug 17 13:25:50 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_MERCHANT_SETTLE_ATTR
     * table comment :业务首次开通时间配置信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
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