package com.sdp.mc.promoter.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PromoterFastSettleSwitchDOExample extends QueryBase {
    /**
     * This field corresponds to the database column TB_PROMOTER_FS_REQ.PFR_ID
     * column comments null
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    private Long pfrId;

    /**
     * This field corresponds to the database column TB_PROMOTER_FS_REQ.PROMOTER_ID
     * column comments 代理商编号
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    private Long promoterId;

    /**
     * This field corresponds to the database column TB_PROMOTER_FS_REQ.TYPE
     * column comments 操作类型
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    private Integer type;

    /**
     * This field corresponds to the database column TB_PROMOTER_FS_REQ.STATUS
     * column comments 状态
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    private Integer status;

    /**
     * This field corresponds to the database column TB_PROMOTER_FS_REQ.MARGIN_ACCOUNT
     * column comments 保证金账户-accountId
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    private String marginAccount;

    /**
     * This field corresponds to the database column TB_PROMOTER_FS_REQ.MAQ_ID
     * column comments 开户记录ID
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    private Long maqId;

    /**
     * This field corresponds to the database column TB_PROMOTER_FS_REQ.FCM_ID
     * column comments 最新的配置修改记录ID
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    private Long fcmId;

    /**
     * This field corresponds to the database column TB_PROMOTER_FS_REQ.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    private Date createTime;

    /**
     * This field corresponds to the database column TB_PROMOTER_FS_REQ.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column TB_PROMOTER_FS_REQ.MARGIN_MEMBER_ID
     * column comments 代理商memberId
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    private String marginMemberId;

    /**
     * This field corresponds to the database table TB_PROMOTER_FS_REQ
     * table comments 代理商快速结算 开通/关闭
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table TB_PROMOTER_FS_REQ
     * table comments 代理商快速结算 开通/关闭
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table TB_PROMOTER_FS_REQ
     * table comments 代理商快速结算 开通/关闭
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table TB_PROMOTER_FS_REQ
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public PromoterFastSettleSwitchDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column TB_PROMOTER_FS_REQ.PFR_ID
     *
     * @return the value of TB_PROMOTER_FS_REQ.PFR_ID
     * column comments null
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public Long getPfrId() {
        return pfrId;
    }

    /**
     * This method sets the value of the database column TB_PROMOTER_FS_REQ.PFR_ID
     *
     * @param pfrId the value for TB_PROMOTER_FS_REQ.PFR_ID
     * column comments null
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public void setPfrId(Long pfrId) {
        this.pfrId = pfrId;
    }

    /**
     * This method returns the value of the database column TB_PROMOTER_FS_REQ.PROMOTER_ID
     *
     * @return the value of TB_PROMOTER_FS_REQ.PROMOTER_ID
     * column comments 代理商编号
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public Long getPromoterId() {
        return promoterId;
    }

    /**
     * This method sets the value of the database column TB_PROMOTER_FS_REQ.PROMOTER_ID
     *
     * @param promoterId the value for TB_PROMOTER_FS_REQ.PROMOTER_ID
     * column comments 代理商编号
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public void setPromoterId(Long promoterId) {
        this.promoterId = promoterId;
    }

    /**
     * This method returns the value of the database column TB_PROMOTER_FS_REQ.TYPE
     *
     * @return the value of TB_PROMOTER_FS_REQ.TYPE
     * column comments 操作类型
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method sets the value of the database column TB_PROMOTER_FS_REQ.TYPE
     *
     * @param type the value for TB_PROMOTER_FS_REQ.TYPE
     * column comments 操作类型
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method returns the value of the database column TB_PROMOTER_FS_REQ.STATUS
     *
     * @return the value of TB_PROMOTER_FS_REQ.STATUS
     * column comments 状态
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column TB_PROMOTER_FS_REQ.STATUS
     *
     * @param status the value for TB_PROMOTER_FS_REQ.STATUS
     * column comments 状态
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column TB_PROMOTER_FS_REQ.MARGIN_ACCOUNT
     *
     * @return the value of TB_PROMOTER_FS_REQ.MARGIN_ACCOUNT
     * column comments 保证金账户-accountId
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public String getMarginAccount() {
        return marginAccount;
    }

    /**
     * This method sets the value of the database column TB_PROMOTER_FS_REQ.MARGIN_ACCOUNT
     *
     * @param marginAccount the value for TB_PROMOTER_FS_REQ.MARGIN_ACCOUNT
     * column comments 保证金账户-accountId
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public void setMarginAccount(String marginAccount) {
        this.marginAccount = marginAccount == null ? null : marginAccount.trim();
    }

    /**
     * This method returns the value of the database column TB_PROMOTER_FS_REQ.MAQ_ID
     *
     * @return the value of TB_PROMOTER_FS_REQ.MAQ_ID
     * column comments 开户记录ID
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public Long getMaqId() {
        return maqId;
    }

    /**
     * This method sets the value of the database column TB_PROMOTER_FS_REQ.MAQ_ID
     *
     * @param maqId the value for TB_PROMOTER_FS_REQ.MAQ_ID
     * column comments 开户记录ID
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public void setMaqId(Long maqId) {
        this.maqId = maqId;
    }

    /**
     * This method returns the value of the database column TB_PROMOTER_FS_REQ.FCM_ID
     *
     * @return the value of TB_PROMOTER_FS_REQ.FCM_ID
     * column comments 最新的配置修改记录ID
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public Long getFcmId() {
        return fcmId;
    }

    /**
     * This method sets the value of the database column TB_PROMOTER_FS_REQ.FCM_ID
     *
     * @param fcmId the value for TB_PROMOTER_FS_REQ.FCM_ID
     * column comments 最新的配置修改记录ID
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public void setFcmId(Long fcmId) {
        this.fcmId = fcmId;
    }

    /**
     * This method returns the value of the database column TB_PROMOTER_FS_REQ.CREATE_TIME
     *
     * @return the value of TB_PROMOTER_FS_REQ.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column TB_PROMOTER_FS_REQ.CREATE_TIME
     *
     * @param createTime the value for TB_PROMOTER_FS_REQ.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column TB_PROMOTER_FS_REQ.UPDATE_TIME
     *
     * @return the value of TB_PROMOTER_FS_REQ.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column TB_PROMOTER_FS_REQ.UPDATE_TIME
     *
     * @param updateTime the value for TB_PROMOTER_FS_REQ.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column TB_PROMOTER_FS_REQ.MARGIN_MEMBER_ID
     *
     * @return the value of TB_PROMOTER_FS_REQ.MARGIN_MEMBER_ID
     * column comments 代理商memberId
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public String getMarginMemberId() {
        return marginMemberId;
    }

    /**
     * This method sets the value of the database column TB_PROMOTER_FS_REQ.MARGIN_MEMBER_ID
     *
     * @param marginMemberId the value for TB_PROMOTER_FS_REQ.MARGIN_MEMBER_ID
     * column comments 代理商memberId
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public void setMarginMemberId(String marginMemberId) {
        this.marginMemberId = marginMemberId == null ? null : marginMemberId.trim();
    }

    /**
     * This method corresponds to the database table TB_PROMOTER_FS_REQ
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table TB_PROMOTER_FS_REQ
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table TB_PROMOTER_FS_REQ
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table TB_PROMOTER_FS_REQ
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table TB_PROMOTER_FS_REQ
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table TB_PROMOTER_FS_REQ
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table TB_PROMOTER_FS_REQ
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_PROMOTER_FS_REQ
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_PROMOTER_FS_REQ
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_PROMOTER_FS_REQ
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_PROMOTER_FS_REQ
     * table comment :代理商快速结算 开通/关闭
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
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

        public Criteria andPfrIdIsNull() {
            addCriterion("PFR_ID is null");
            return (Criteria) this;
        }

        public Criteria andPfrIdIsNotNull() {
            addCriterion("PFR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPfrIdEqualTo(Long value) {
            addCriterion("PFR_ID =", value, "pfrId");
            return (Criteria) this;
        }

        public Criteria andPfrIdNotEqualTo(Long value) {
            addCriterion("PFR_ID <>", value, "pfrId");
            return (Criteria) this;
        }

        public Criteria andPfrIdGreaterThan(Long value) {
            addCriterion("PFR_ID >", value, "pfrId");
            return (Criteria) this;
        }

        public Criteria andPfrIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PFR_ID >=", value, "pfrId");
            return (Criteria) this;
        }

        public Criteria andPfrIdLessThan(Long value) {
            addCriterion("PFR_ID <", value, "pfrId");
            return (Criteria) this;
        }

        public Criteria andPfrIdLessThanOrEqualTo(Long value) {
            addCriterion("PFR_ID <=", value, "pfrId");
            return (Criteria) this;
        }

        public Criteria andPfrIdIn(List<Long> values) {
            addCriterion("PFR_ID in", values, "pfrId");
            return (Criteria) this;
        }

        public Criteria andPfrIdNotIn(List<Long> values) {
            addCriterion("PFR_ID not in", values, "pfrId");
            return (Criteria) this;
        }

        public Criteria andPfrIdBetween(Long value1, Long value2) {
            addCriterion("PFR_ID between", value1, value2, "pfrId");
            return (Criteria) this;
        }

        public Criteria andPfrIdNotBetween(Long value1, Long value2) {
            addCriterion("PFR_ID not between", value1, value2, "pfrId");
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

        public Criteria andMarginAccountIsNull() {
            addCriterion("MARGIN_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andMarginAccountIsNotNull() {
            addCriterion("MARGIN_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andMarginAccountEqualTo(String value) {
            addCriterion("MARGIN_ACCOUNT =", value, "marginAccount");
            return (Criteria) this;
        }

        public Criteria andMarginAccountNotEqualTo(String value) {
            addCriterion("MARGIN_ACCOUNT <>", value, "marginAccount");
            return (Criteria) this;
        }

        public Criteria andMarginAccountGreaterThan(String value) {
            addCriterion("MARGIN_ACCOUNT >", value, "marginAccount");
            return (Criteria) this;
        }

        public Criteria andMarginAccountGreaterThanOrEqualTo(String value) {
            addCriterion("MARGIN_ACCOUNT >=", value, "marginAccount");
            return (Criteria) this;
        }

        public Criteria andMarginAccountLessThan(String value) {
            addCriterion("MARGIN_ACCOUNT <", value, "marginAccount");
            return (Criteria) this;
        }

        public Criteria andMarginAccountLessThanOrEqualTo(String value) {
            addCriterion("MARGIN_ACCOUNT <=", value, "marginAccount");
            return (Criteria) this;
        }

        public Criteria andMarginAccountLike(String value) {
            addCriterion("MARGIN_ACCOUNT like", value, "marginAccount");
            return (Criteria) this;
        }

        public Criteria andMarginAccountNotLike(String value) {
            addCriterion("MARGIN_ACCOUNT not like", value, "marginAccount");
            return (Criteria) this;
        }

        public Criteria andMarginAccountIn(List<String> values) {
            addCriterion("MARGIN_ACCOUNT in", values, "marginAccount");
            return (Criteria) this;
        }

        public Criteria andMarginAccountNotIn(List<String> values) {
            addCriterion("MARGIN_ACCOUNT not in", values, "marginAccount");
            return (Criteria) this;
        }

        public Criteria andMarginAccountBetween(String value1, String value2) {
            addCriterion("MARGIN_ACCOUNT between", value1, value2, "marginAccount");
            return (Criteria) this;
        }

        public Criteria andMarginAccountNotBetween(String value1, String value2) {
            addCriterion("MARGIN_ACCOUNT not between", value1, value2, "marginAccount");
            return (Criteria) this;
        }

        public Criteria andMaqIdIsNull() {
            addCriterion("MAQ_ID is null");
            return (Criteria) this;
        }

        public Criteria andMaqIdIsNotNull() {
            addCriterion("MAQ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMaqIdEqualTo(Long value) {
            addCriterion("MAQ_ID =", value, "maqId");
            return (Criteria) this;
        }

        public Criteria andMaqIdNotEqualTo(Long value) {
            addCriterion("MAQ_ID <>", value, "maqId");
            return (Criteria) this;
        }

        public Criteria andMaqIdGreaterThan(Long value) {
            addCriterion("MAQ_ID >", value, "maqId");
            return (Criteria) this;
        }

        public Criteria andMaqIdGreaterThanOrEqualTo(Long value) {
            addCriterion("MAQ_ID >=", value, "maqId");
            return (Criteria) this;
        }

        public Criteria andMaqIdLessThan(Long value) {
            addCriterion("MAQ_ID <", value, "maqId");
            return (Criteria) this;
        }

        public Criteria andMaqIdLessThanOrEqualTo(Long value) {
            addCriterion("MAQ_ID <=", value, "maqId");
            return (Criteria) this;
        }

        public Criteria andMaqIdIn(List<Long> values) {
            addCriterion("MAQ_ID in", values, "maqId");
            return (Criteria) this;
        }

        public Criteria andMaqIdNotIn(List<Long> values) {
            addCriterion("MAQ_ID not in", values, "maqId");
            return (Criteria) this;
        }

        public Criteria andMaqIdBetween(Long value1, Long value2) {
            addCriterion("MAQ_ID between", value1, value2, "maqId");
            return (Criteria) this;
        }

        public Criteria andMaqIdNotBetween(Long value1, Long value2) {
            addCriterion("MAQ_ID not between", value1, value2, "maqId");
            return (Criteria) this;
        }

        public Criteria andFcmIdIsNull() {
            addCriterion("FCM_ID is null");
            return (Criteria) this;
        }

        public Criteria andFcmIdIsNotNull() {
            addCriterion("FCM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFcmIdEqualTo(Long value) {
            addCriterion("FCM_ID =", value, "fcmId");
            return (Criteria) this;
        }

        public Criteria andFcmIdNotEqualTo(Long value) {
            addCriterion("FCM_ID <>", value, "fcmId");
            return (Criteria) this;
        }

        public Criteria andFcmIdGreaterThan(Long value) {
            addCriterion("FCM_ID >", value, "fcmId");
            return (Criteria) this;
        }

        public Criteria andFcmIdGreaterThanOrEqualTo(Long value) {
            addCriterion("FCM_ID >=", value, "fcmId");
            return (Criteria) this;
        }

        public Criteria andFcmIdLessThan(Long value) {
            addCriterion("FCM_ID <", value, "fcmId");
            return (Criteria) this;
        }

        public Criteria andFcmIdLessThanOrEqualTo(Long value) {
            addCriterion("FCM_ID <=", value, "fcmId");
            return (Criteria) this;
        }

        public Criteria andFcmIdIn(List<Long> values) {
            addCriterion("FCM_ID in", values, "fcmId");
            return (Criteria) this;
        }

        public Criteria andFcmIdNotIn(List<Long> values) {
            addCriterion("FCM_ID not in", values, "fcmId");
            return (Criteria) this;
        }

        public Criteria andFcmIdBetween(Long value1, Long value2) {
            addCriterion("FCM_ID between", value1, value2, "fcmId");
            return (Criteria) this;
        }

        public Criteria andFcmIdNotBetween(Long value1, Long value2) {
            addCriterion("FCM_ID not between", value1, value2, "fcmId");
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

        public Criteria andMarginMemberIdIsNull() {
            addCriterion("MARGIN_MEMBER_ID is null");
            return (Criteria) this;
        }

        public Criteria andMarginMemberIdIsNotNull() {
            addCriterion("MARGIN_MEMBER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMarginMemberIdEqualTo(String value) {
            addCriterion("MARGIN_MEMBER_ID =", value, "marginMemberId");
            return (Criteria) this;
        }

        public Criteria andMarginMemberIdNotEqualTo(String value) {
            addCriterion("MARGIN_MEMBER_ID <>", value, "marginMemberId");
            return (Criteria) this;
        }

        public Criteria andMarginMemberIdGreaterThan(String value) {
            addCriterion("MARGIN_MEMBER_ID >", value, "marginMemberId");
            return (Criteria) this;
        }

        public Criteria andMarginMemberIdGreaterThanOrEqualTo(String value) {
            addCriterion("MARGIN_MEMBER_ID >=", value, "marginMemberId");
            return (Criteria) this;
        }

        public Criteria andMarginMemberIdLessThan(String value) {
            addCriterion("MARGIN_MEMBER_ID <", value, "marginMemberId");
            return (Criteria) this;
        }

        public Criteria andMarginMemberIdLessThanOrEqualTo(String value) {
            addCriterion("MARGIN_MEMBER_ID <=", value, "marginMemberId");
            return (Criteria) this;
        }

        public Criteria andMarginMemberIdLike(String value) {
            addCriterion("MARGIN_MEMBER_ID like", value, "marginMemberId");
            return (Criteria) this;
        }

        public Criteria andMarginMemberIdNotLike(String value) {
            addCriterion("MARGIN_MEMBER_ID not like", value, "marginMemberId");
            return (Criteria) this;
        }

        public Criteria andMarginMemberIdIn(List<String> values) {
            addCriterion("MARGIN_MEMBER_ID in", values, "marginMemberId");
            return (Criteria) this;
        }

        public Criteria andMarginMemberIdNotIn(List<String> values) {
            addCriterion("MARGIN_MEMBER_ID not in", values, "marginMemberId");
            return (Criteria) this;
        }

        public Criteria andMarginMemberIdBetween(String value1, String value2) {
            addCriterion("MARGIN_MEMBER_ID between", value1, value2, "marginMemberId");
            return (Criteria) this;
        }

        public Criteria andMarginMemberIdNotBetween(String value1, String value2) {
            addCriterion("MARGIN_MEMBER_ID not between", value1, value2, "marginMemberId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_PROMOTER_FS_REQ
     *
     * @mbggenerated do_not_delete_during_merge Tue Mar 31 17:37:57 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_PROMOTER_FS_REQ
     * table comment :代理商快速结算 开通/关闭
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
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