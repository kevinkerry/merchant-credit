package com.sdp.mc.mcbizaccount.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BizApplyOpenAccountDOExample extends QueryBase {
    /**
     * This field corresponds to the database column MC_APPLY_OPEN_ACCOUNT.ID
     * column comments null
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    private Long id;

    /**
     * This field corresponds to the database column MC_APPLY_OPEN_ACCOUNT.ACCOUNT_TYPE
     * column comments 账户类型(216保证金账户,281授信专户)
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    private Long accountType;

    /**
     * This field corresponds to the database column MC_APPLY_OPEN_ACCOUNT.PROMOTER_ID
     * column comments 代理商编号
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    private Long promoterId;

    /**
     * This field corresponds to the database column MC_APPLY_OPEN_ACCOUNT.MERCHANT_NO
     * column comments 代理商商户号
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    private String merchantNo;

    /**
     * This field corresponds to the database column MC_APPLY_OPEN_ACCOUNT.PROMOTER_NAME
     * column comments 代理商名称
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    private String promoterName;

    /**
     * This field corresponds to the database column MC_APPLY_OPEN_ACCOUNT.ACCOUNT_ID
     * column comments 账户-accountId
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    private String accountId;

    /**
     * This field corresponds to the database column MC_APPLY_OPEN_ACCOUNT.MEMBER_ID
     * column comments 代理商memberId
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    private String memberId;

    /**
     * This field corresponds to the database column MC_APPLY_OPEN_ACCOUNT.STATUS
     * column comments 状态
0初始化,1开户中,2开户成功,3开户失败
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    private Integer status;

    /**
     * This field corresponds to the database column MC_APPLY_OPEN_ACCOUNT.BIZ_ID
     * column comments 开户表id
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    private Long bizId;

    /**
     * This field corresponds to the database column MC_APPLY_OPEN_ACCOUNT.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    private Date createTime;

    /**
     * This field corresponds to the database column MC_APPLY_OPEN_ACCOUNT.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    private Date updateTime;

    /**
     * This field corresponds to the database table MC_APPLY_OPEN_ACCOUNT
     * table comments 业务层通用开户记录表
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table MC_APPLY_OPEN_ACCOUNT
     * table comments 业务层通用开户记录表
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table MC_APPLY_OPEN_ACCOUNT
     * table comments 业务层通用开户记录表
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table MC_APPLY_OPEN_ACCOUNT
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public BizApplyOpenAccountDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column MC_APPLY_OPEN_ACCOUNT.ID
     *
     * @return the value of MC_APPLY_OPEN_ACCOUNT.ID
     * column comments null
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column MC_APPLY_OPEN_ACCOUNT.ID
     *
     * @param id the value for MC_APPLY_OPEN_ACCOUNT.ID
     * column comments null
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column MC_APPLY_OPEN_ACCOUNT.ACCOUNT_TYPE
     *
     * @return the value of MC_APPLY_OPEN_ACCOUNT.ACCOUNT_TYPE
     * column comments 账户类型(216保证金账户,281授信专户)
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public Long getAccountType() {
        return accountType;
    }

    /**
     * This method sets the value of the database column MC_APPLY_OPEN_ACCOUNT.ACCOUNT_TYPE
     *
     * @param accountType the value for MC_APPLY_OPEN_ACCOUNT.ACCOUNT_TYPE
     * column comments 账户类型(216保证金账户,281授信专户)
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void setAccountType(Long accountType) {
        this.accountType = accountType;
    }

    /**
     * This method returns the value of the database column MC_APPLY_OPEN_ACCOUNT.PROMOTER_ID
     *
     * @return the value of MC_APPLY_OPEN_ACCOUNT.PROMOTER_ID
     * column comments 代理商编号
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public Long getPromoterId() {
        return promoterId;
    }

    /**
     * This method sets the value of the database column MC_APPLY_OPEN_ACCOUNT.PROMOTER_ID
     *
     * @param promoterId the value for MC_APPLY_OPEN_ACCOUNT.PROMOTER_ID
     * column comments 代理商编号
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void setPromoterId(Long promoterId) {
        this.promoterId = promoterId;
    }

    /**
     * This method returns the value of the database column MC_APPLY_OPEN_ACCOUNT.MERCHANT_NO
     *
     * @return the value of MC_APPLY_OPEN_ACCOUNT.MERCHANT_NO
     * column comments 代理商商户号
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * This method sets the value of the database column MC_APPLY_OPEN_ACCOUNT.MERCHANT_NO
     *
     * @param merchantNo the value for MC_APPLY_OPEN_ACCOUNT.MERCHANT_NO
     * column comments 代理商商户号
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * This method returns the value of the database column MC_APPLY_OPEN_ACCOUNT.PROMOTER_NAME
     *
     * @return the value of MC_APPLY_OPEN_ACCOUNT.PROMOTER_NAME
     * column comments 代理商名称
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public String getPromoterName() {
        return promoterName;
    }

    /**
     * This method sets the value of the database column MC_APPLY_OPEN_ACCOUNT.PROMOTER_NAME
     *
     * @param promoterName the value for MC_APPLY_OPEN_ACCOUNT.PROMOTER_NAME
     * column comments 代理商名称
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void setPromoterName(String promoterName) {
        this.promoterName = promoterName == null ? null : promoterName.trim();
    }

    /**
     * This method returns the value of the database column MC_APPLY_OPEN_ACCOUNT.ACCOUNT_ID
     *
     * @return the value of MC_APPLY_OPEN_ACCOUNT.ACCOUNT_ID
     * column comments 账户-accountId
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * This method sets the value of the database column MC_APPLY_OPEN_ACCOUNT.ACCOUNT_ID
     *
     * @param accountId the value for MC_APPLY_OPEN_ACCOUNT.ACCOUNT_ID
     * column comments 账户-accountId
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * This method returns the value of the database column MC_APPLY_OPEN_ACCOUNT.MEMBER_ID
     *
     * @return the value of MC_APPLY_OPEN_ACCOUNT.MEMBER_ID
     * column comments 代理商memberId
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * This method sets the value of the database column MC_APPLY_OPEN_ACCOUNT.MEMBER_ID
     *
     * @param memberId the value for MC_APPLY_OPEN_ACCOUNT.MEMBER_ID
     * column comments 代理商memberId
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    /**
     * This method returns the value of the database column MC_APPLY_OPEN_ACCOUNT.STATUS
     *
     * @return the value of MC_APPLY_OPEN_ACCOUNT.STATUS
     * column comments 状态
0初始化,1开户中,2开户成功,3开户失败
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column MC_APPLY_OPEN_ACCOUNT.STATUS
     *
     * @param status the value for MC_APPLY_OPEN_ACCOUNT.STATUS
     * column comments 状态
0初始化,1开户中,2开户成功,3开户失败
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column MC_APPLY_OPEN_ACCOUNT.BIZ_ID
     *
     * @return the value of MC_APPLY_OPEN_ACCOUNT.BIZ_ID
     * column comments 开户表id
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public Long getBizId() {
        return bizId;
    }

    /**
     * This method sets the value of the database column MC_APPLY_OPEN_ACCOUNT.BIZ_ID
     *
     * @param bizId the value for MC_APPLY_OPEN_ACCOUNT.BIZ_ID
     * column comments 开户表id
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    /**
     * This method returns the value of the database column MC_APPLY_OPEN_ACCOUNT.CREATE_TIME
     *
     * @return the value of MC_APPLY_OPEN_ACCOUNT.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column MC_APPLY_OPEN_ACCOUNT.CREATE_TIME
     *
     * @param createTime the value for MC_APPLY_OPEN_ACCOUNT.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column MC_APPLY_OPEN_ACCOUNT.UPDATE_TIME
     *
     * @return the value of MC_APPLY_OPEN_ACCOUNT.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column MC_APPLY_OPEN_ACCOUNT.UPDATE_TIME
     *
     * @param updateTime the value for MC_APPLY_OPEN_ACCOUNT.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method corresponds to the database table MC_APPLY_OPEN_ACCOUNT
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table MC_APPLY_OPEN_ACCOUNT
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table MC_APPLY_OPEN_ACCOUNT
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table MC_APPLY_OPEN_ACCOUNT
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table MC_APPLY_OPEN_ACCOUNT
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table MC_APPLY_OPEN_ACCOUNT
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table MC_APPLY_OPEN_ACCOUNT
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table MC_APPLY_OPEN_ACCOUNT
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table MC_APPLY_OPEN_ACCOUNT
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table MC_APPLY_OPEN_ACCOUNT
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table MC_APPLY_OPEN_ACCOUNT
     * table comment :业务层通用开户记录表
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
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

        public Criteria andAccountTypeIsNull() {
            addCriterion("ACCOUNT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNotNull() {
            addCriterion("ACCOUNT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeEqualTo(Long value) {
            addCriterion("ACCOUNT_TYPE =", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotEqualTo(Long value) {
            addCriterion("ACCOUNT_TYPE <>", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThan(Long value) {
            addCriterion("ACCOUNT_TYPE >", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("ACCOUNT_TYPE >=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThan(Long value) {
            addCriterion("ACCOUNT_TYPE <", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThanOrEqualTo(Long value) {
            addCriterion("ACCOUNT_TYPE <=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIn(List<Long> values) {
            addCriterion("ACCOUNT_TYPE in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotIn(List<Long> values) {
            addCriterion("ACCOUNT_TYPE not in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeBetween(Long value1, Long value2) {
            addCriterion("ACCOUNT_TYPE between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotBetween(Long value1, Long value2) {
            addCriterion("ACCOUNT_TYPE not between", value1, value2, "accountType");
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

        public Criteria andAccountIdIsNull() {
            addCriterion("ACCOUNT_ID is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("ACCOUNT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(String value) {
            addCriterion("ACCOUNT_ID =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(String value) {
            addCriterion("ACCOUNT_ID <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(String value) {
            addCriterion("ACCOUNT_ID >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_ID >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(String value) {
            addCriterion("ACCOUNT_ID <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_ID <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLike(String value) {
            addCriterion("ACCOUNT_ID like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotLike(String value) {
            addCriterion("ACCOUNT_ID not like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<String> values) {
            addCriterion("ACCOUNT_ID in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<String> values) {
            addCriterion("ACCOUNT_ID not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(String value1, String value2) {
            addCriterion("ACCOUNT_ID between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT_ID not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNull() {
            addCriterion("MEMBER_ID is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("MEMBER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(String value) {
            addCriterion("MEMBER_ID =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(String value) {
            addCriterion("MEMBER_ID <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(String value) {
            addCriterion("MEMBER_ID >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(String value) {
            addCriterion("MEMBER_ID >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(String value) {
            addCriterion("MEMBER_ID <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(String value) {
            addCriterion("MEMBER_ID <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLike(String value) {
            addCriterion("MEMBER_ID like", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotLike(String value) {
            addCriterion("MEMBER_ID not like", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<String> values) {
            addCriterion("MEMBER_ID in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<String> values) {
            addCriterion("MEMBER_ID not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(String value1, String value2) {
            addCriterion("MEMBER_ID between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(String value1, String value2) {
            addCriterion("MEMBER_ID not between", value1, value2, "memberId");
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
     * This class corresponds to the database table MC_APPLY_OPEN_ACCOUNT
     *
     * @mbggenerated do_not_delete_during_merge Mon Jun 01 17:30:15 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table MC_APPLY_OPEN_ACCOUNT
     * table comment :业务层通用开户记录表
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
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