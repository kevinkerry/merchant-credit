package com.sdp.mc.margin.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MarginOpReqDOExample extends QueryBase {
    /**
     * This field corresponds to the database column TB_MARGIN_OP_REQ.MOR_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    private Long morId;

    /**
     * This field corresponds to the database column TB_MARGIN_OP_REQ.PROMOTER_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    private Long promoterId;

    /**
     * This field corresponds to the database column TB_MARGIN_OP_REQ.OP_TYPE
     * column comments 1：追加保证金
2：回退保证金
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    private Integer opType;

    /**
     * This field corresponds to the database column TB_MARGIN_OP_REQ.STATUS
     * column comments 追加：
0：初始化
101：转账成功
-101：转账失败
102：配置更改成功（退款申请成功）
-102：配置更改失败

退回
0：初始化
201：配置更改成功（退款申请成功）
-201：配置更改失败
202：转账成功
-202：转账失败

     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    private Integer status;

    /**
     * This field corresponds to the database column TB_MARGIN_OP_REQ.AMOUNT
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    private BigDecimal amount;

    /**
     * This field corresponds to the database column TB_MARGIN_OP_REQ.REDEEMED_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    private Date redeemedTime;

    /**
     * This field corresponds to the database column TB_MARGIN_OP_REQ.MT_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    private String mtId;

    /**
     * This field corresponds to the database column TB_MARGIN_OP_REQ.MT_ID_HIS
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    private String mtIdHis;

    /**
     * This field corresponds to the database column TB_MARGIN_OP_REQ.FCM_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    private Long fcmId;

    /**
     * This field corresponds to the database column TB_MARGIN_OP_REQ.FCM_ID_HIS
     * column comments 配置更改记录历史
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    private String fcmIdHis;

    /**
     * This field corresponds to the database column TB_MARGIN_OP_REQ.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    private Date createTime;

    /**
     * This field corresponds to the database column TB_MARGIN_OP_REQ.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    private Date updateTime;

    /**
     * This field corresponds to the database table TB_MARGIN_OP_REQ
     * table comments 代理商保证金追加/退回记录
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table TB_MARGIN_OP_REQ
     * table comments 代理商保证金追加/退回记录
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table TB_MARGIN_OP_REQ
     * table comments 代理商保证金追加/退回记录
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table TB_MARGIN_OP_REQ
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public MarginOpReqDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_OP_REQ.MOR_ID
     *
     * @return the value of TB_MARGIN_OP_REQ.MOR_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public Long getMorId() {
        return morId;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_OP_REQ.MOR_ID
     *
     * @param morId the value for TB_MARGIN_OP_REQ.MOR_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setMorId(Long morId) {
        this.morId = morId;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_OP_REQ.PROMOTER_ID
     *
     * @return the value of TB_MARGIN_OP_REQ.PROMOTER_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public Long getPromoterId() {
        return promoterId;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_OP_REQ.PROMOTER_ID
     *
     * @param promoterId the value for TB_MARGIN_OP_REQ.PROMOTER_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setPromoterId(Long promoterId) {
        this.promoterId = promoterId;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_OP_REQ.OP_TYPE
     *
     * @return the value of TB_MARGIN_OP_REQ.OP_TYPE
     * column comments 1：追加保证金
2：回退保证金
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public Integer getOpType() {
        return opType;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_OP_REQ.OP_TYPE
     *
     * @param opType the value for TB_MARGIN_OP_REQ.OP_TYPE
     * column comments 1：追加保证金
2：回退保证金
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setOpType(Integer opType) {
        this.opType = opType;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_OP_REQ.STATUS
     *
     * @return the value of TB_MARGIN_OP_REQ.STATUS
     * column comments 追加：
0：初始化
101：转账成功
-101：转账失败
102：配置更改成功（退款申请成功）
-102：配置更改失败

退回
0：初始化
201：配置更改成功（退款申请成功）
-201：配置更改失败
202：转账成功
-202：转账失败

     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_OP_REQ.STATUS
     *
     * @param status the value for TB_MARGIN_OP_REQ.STATUS
     * column comments 追加：
0：初始化
101：转账成功
-101：转账失败
102：配置更改成功（退款申请成功）
-102：配置更改失败

退回
0：初始化
201：配置更改成功（退款申请成功）
-201：配置更改失败
202：转账成功
-202：转账失败

     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_OP_REQ.AMOUNT
     *
     * @return the value of TB_MARGIN_OP_REQ.AMOUNT
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_OP_REQ.AMOUNT
     *
     * @param amount the value for TB_MARGIN_OP_REQ.AMOUNT
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_OP_REQ.REDEEMED_TIME
     *
     * @return the value of TB_MARGIN_OP_REQ.REDEEMED_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public Date getRedeemedTime() {
        return redeemedTime;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_OP_REQ.REDEEMED_TIME
     *
     * @param redeemedTime the value for TB_MARGIN_OP_REQ.REDEEMED_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setRedeemedTime(Date redeemedTime) {
        this.redeemedTime = redeemedTime;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_OP_REQ.MT_ID
     *
     * @return the value of TB_MARGIN_OP_REQ.MT_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public String getMtId() {
        return mtId;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_OP_REQ.MT_ID
     *
     * @param mtId the value for TB_MARGIN_OP_REQ.MT_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setMtId(String mtId) {
        this.mtId = mtId == null ? null : mtId.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_OP_REQ.MT_ID_HIS
     *
     * @return the value of TB_MARGIN_OP_REQ.MT_ID_HIS
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public String getMtIdHis() {
        return mtIdHis;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_OP_REQ.MT_ID_HIS
     *
     * @param mtIdHis the value for TB_MARGIN_OP_REQ.MT_ID_HIS
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setMtIdHis(String mtIdHis) {
        this.mtIdHis = mtIdHis == null ? null : mtIdHis.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_OP_REQ.FCM_ID
     *
     * @return the value of TB_MARGIN_OP_REQ.FCM_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public Long getFcmId() {
        return fcmId;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_OP_REQ.FCM_ID
     *
     * @param fcmId the value for TB_MARGIN_OP_REQ.FCM_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setFcmId(Long fcmId) {
        this.fcmId = fcmId;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_OP_REQ.FCM_ID_HIS
     *
     * @return the value of TB_MARGIN_OP_REQ.FCM_ID_HIS
     * column comments 配置更改记录历史
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public String getFcmIdHis() {
        return fcmIdHis;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_OP_REQ.FCM_ID_HIS
     *
     * @param fcmIdHis the value for TB_MARGIN_OP_REQ.FCM_ID_HIS
     * column comments 配置更改记录历史
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setFcmIdHis(String fcmIdHis) {
        this.fcmIdHis = fcmIdHis == null ? null : fcmIdHis.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_OP_REQ.CREATE_TIME
     *
     * @return the value of TB_MARGIN_OP_REQ.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_OP_REQ.CREATE_TIME
     *
     * @param createTime the value for TB_MARGIN_OP_REQ.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_OP_REQ.UPDATE_TIME
     *
     * @return the value of TB_MARGIN_OP_REQ.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_OP_REQ.UPDATE_TIME
     *
     * @param updateTime the value for TB_MARGIN_OP_REQ.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_OP_REQ
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_OP_REQ
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_OP_REQ
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_OP_REQ
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_OP_REQ
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_OP_REQ
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table TB_MARGIN_OP_REQ
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_OP_REQ
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_OP_REQ
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_OP_REQ
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_MARGIN_OP_REQ
     * table comment :代理商保证金追加/退回记录
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
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

        public Criteria andMorIdIsNull() {
            addCriterion("MOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andMorIdIsNotNull() {
            addCriterion("MOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMorIdEqualTo(Long value) {
            addCriterion("MOR_ID =", value, "morId");
            return (Criteria) this;
        }

        public Criteria andMorIdNotEqualTo(Long value) {
            addCriterion("MOR_ID <>", value, "morId");
            return (Criteria) this;
        }

        public Criteria andMorIdGreaterThan(Long value) {
            addCriterion("MOR_ID >", value, "morId");
            return (Criteria) this;
        }

        public Criteria andMorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("MOR_ID >=", value, "morId");
            return (Criteria) this;
        }

        public Criteria andMorIdLessThan(Long value) {
            addCriterion("MOR_ID <", value, "morId");
            return (Criteria) this;
        }

        public Criteria andMorIdLessThanOrEqualTo(Long value) {
            addCriterion("MOR_ID <=", value, "morId");
            return (Criteria) this;
        }

        public Criteria andMorIdIn(List<Long> values) {
            addCriterion("MOR_ID in", values, "morId");
            return (Criteria) this;
        }

        public Criteria andMorIdNotIn(List<Long> values) {
            addCriterion("MOR_ID not in", values, "morId");
            return (Criteria) this;
        }

        public Criteria andMorIdBetween(Long value1, Long value2) {
            addCriterion("MOR_ID between", value1, value2, "morId");
            return (Criteria) this;
        }

        public Criteria andMorIdNotBetween(Long value1, Long value2) {
            addCriterion("MOR_ID not between", value1, value2, "morId");
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

        public Criteria andOpTypeIsNull() {
            addCriterion("OP_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOpTypeIsNotNull() {
            addCriterion("OP_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOpTypeEqualTo(Integer value) {
            addCriterion("OP_TYPE =", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotEqualTo(Integer value) {
            addCriterion("OP_TYPE <>", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeGreaterThan(Integer value) {
            addCriterion("OP_TYPE >", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("OP_TYPE >=", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeLessThan(Integer value) {
            addCriterion("OP_TYPE <", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeLessThanOrEqualTo(Integer value) {
            addCriterion("OP_TYPE <=", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeIn(List<Integer> values) {
            addCriterion("OP_TYPE in", values, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotIn(List<Integer> values) {
            addCriterion("OP_TYPE not in", values, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeBetween(Integer value1, Integer value2) {
            addCriterion("OP_TYPE between", value1, value2, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("OP_TYPE not between", value1, value2, "opType");
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

        public Criteria andAmountIsNull() {
            addCriterion("AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andRedeemedTimeIsNull() {
            addCriterion("REDEEMED_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRedeemedTimeIsNotNull() {
            addCriterion("REDEEMED_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRedeemedTimeEqualTo(Date value) {
            addCriterion("REDEEMED_TIME =", value, "redeemedTime");
            return (Criteria) this;
        }

        public Criteria andRedeemedTimeNotEqualTo(Date value) {
            addCriterion("REDEEMED_TIME <>", value, "redeemedTime");
            return (Criteria) this;
        }

        public Criteria andRedeemedTimeGreaterThan(Date value) {
            addCriterion("REDEEMED_TIME >", value, "redeemedTime");
            return (Criteria) this;
        }

        public Criteria andRedeemedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("REDEEMED_TIME >=", value, "redeemedTime");
            return (Criteria) this;
        }

        public Criteria andRedeemedTimeLessThan(Date value) {
            addCriterion("REDEEMED_TIME <", value, "redeemedTime");
            return (Criteria) this;
        }

        public Criteria andRedeemedTimeLessThanOrEqualTo(Date value) {
            addCriterion("REDEEMED_TIME <=", value, "redeemedTime");
            return (Criteria) this;
        }

        public Criteria andRedeemedTimeIn(List<Date> values) {
            addCriterion("REDEEMED_TIME in", values, "redeemedTime");
            return (Criteria) this;
        }

        public Criteria andRedeemedTimeNotIn(List<Date> values) {
            addCriterion("REDEEMED_TIME not in", values, "redeemedTime");
            return (Criteria) this;
        }

        public Criteria andRedeemedTimeBetween(Date value1, Date value2) {
            addCriterion("REDEEMED_TIME between", value1, value2, "redeemedTime");
            return (Criteria) this;
        }

        public Criteria andRedeemedTimeNotBetween(Date value1, Date value2) {
            addCriterion("REDEEMED_TIME not between", value1, value2, "redeemedTime");
            return (Criteria) this;
        }

        public Criteria andMtIdIsNull() {
            addCriterion("MT_ID is null");
            return (Criteria) this;
        }

        public Criteria andMtIdIsNotNull() {
            addCriterion("MT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMtIdEqualTo(String value) {
            addCriterion("MT_ID =", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdNotEqualTo(String value) {
            addCriterion("MT_ID <>", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdGreaterThan(String value) {
            addCriterion("MT_ID >", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdGreaterThanOrEqualTo(String value) {
            addCriterion("MT_ID >=", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdLessThan(String value) {
            addCriterion("MT_ID <", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdLessThanOrEqualTo(String value) {
            addCriterion("MT_ID <=", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdIn(List<String> values) {
            addCriterion("MT_ID in", values, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdNotIn(List<String> values) {
            addCriterion("MT_ID not in", values, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdBetween(String value1, String value2) {
            addCriterion("MT_ID between", value1, value2, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdNotBetween(String value1, String value2) {
            addCriterion("MT_ID not between", value1, value2, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdHisIsNull() {
            addCriterion("MT_ID_HIS is null");
            return (Criteria) this;
        }

        public Criteria andMtIdHisIsNotNull() {
            addCriterion("MT_ID_HIS is not null");
            return (Criteria) this;
        }

        public Criteria andMtIdHisEqualTo(String value) {
            addCriterion("MT_ID_HIS =", value, "mtIdHis");
            return (Criteria) this;
        }

        public Criteria andMtIdHisNotEqualTo(String value) {
            addCriterion("MT_ID_HIS <>", value, "mtIdHis");
            return (Criteria) this;
        }

        public Criteria andMtIdHisGreaterThan(String value) {
            addCriterion("MT_ID_HIS >", value, "mtIdHis");
            return (Criteria) this;
        }

        public Criteria andMtIdHisGreaterThanOrEqualTo(String value) {
            addCriterion("MT_ID_HIS >=", value, "mtIdHis");
            return (Criteria) this;
        }

        public Criteria andMtIdHisLessThan(String value) {
            addCriterion("MT_ID_HIS <", value, "mtIdHis");
            return (Criteria) this;
        }

        public Criteria andMtIdHisLessThanOrEqualTo(String value) {
            addCriterion("MT_ID_HIS <=", value, "mtIdHis");
            return (Criteria) this;
        }

        public Criteria andMtIdHisLike(String value) {
            addCriterion("MT_ID_HIS like", value, "mtIdHis");
            return (Criteria) this;
        }

        public Criteria andMtIdHisNotLike(String value) {
            addCriterion("MT_ID_HIS not like", value, "mtIdHis");
            return (Criteria) this;
        }

        public Criteria andMtIdHisIn(List<String> values) {
            addCriterion("MT_ID_HIS in", values, "mtIdHis");
            return (Criteria) this;
        }

        public Criteria andMtIdHisNotIn(List<String> values) {
            addCriterion("MT_ID_HIS not in", values, "mtIdHis");
            return (Criteria) this;
        }

        public Criteria andMtIdHisBetween(String value1, String value2) {
            addCriterion("MT_ID_HIS between", value1, value2, "mtIdHis");
            return (Criteria) this;
        }

        public Criteria andMtIdHisNotBetween(String value1, String value2) {
            addCriterion("MT_ID_HIS not between", value1, value2, "mtIdHis");
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

        public Criteria andFcmIdHisIsNull() {
            addCriterion("FCM_ID_HIS is null");
            return (Criteria) this;
        }

        public Criteria andFcmIdHisIsNotNull() {
            addCriterion("FCM_ID_HIS is not null");
            return (Criteria) this;
        }

        public Criteria andFcmIdHisEqualTo(String value) {
            addCriterion("FCM_ID_HIS =", value, "fcmIdHis");
            return (Criteria) this;
        }

        public Criteria andFcmIdHisNotEqualTo(String value) {
            addCriterion("FCM_ID_HIS <>", value, "fcmIdHis");
            return (Criteria) this;
        }

        public Criteria andFcmIdHisGreaterThan(String value) {
            addCriterion("FCM_ID_HIS >", value, "fcmIdHis");
            return (Criteria) this;
        }

        public Criteria andFcmIdHisGreaterThanOrEqualTo(String value) {
            addCriterion("FCM_ID_HIS >=", value, "fcmIdHis");
            return (Criteria) this;
        }

        public Criteria andFcmIdHisLessThan(String value) {
            addCriterion("FCM_ID_HIS <", value, "fcmIdHis");
            return (Criteria) this;
        }

        public Criteria andFcmIdHisLessThanOrEqualTo(String value) {
            addCriterion("FCM_ID_HIS <=", value, "fcmIdHis");
            return (Criteria) this;
        }

        public Criteria andFcmIdHisLike(String value) {
            addCriterion("FCM_ID_HIS like", value, "fcmIdHis");
            return (Criteria) this;
        }

        public Criteria andFcmIdHisNotLike(String value) {
            addCriterion("FCM_ID_HIS not like", value, "fcmIdHis");
            return (Criteria) this;
        }

        public Criteria andFcmIdHisIn(List<String> values) {
            addCriterion("FCM_ID_HIS in", values, "fcmIdHis");
            return (Criteria) this;
        }

        public Criteria andFcmIdHisNotIn(List<String> values) {
            addCriterion("FCM_ID_HIS not in", values, "fcmIdHis");
            return (Criteria) this;
        }

        public Criteria andFcmIdHisBetween(String value1, String value2) {
            addCriterion("FCM_ID_HIS between", value1, value2, "fcmIdHis");
            return (Criteria) this;
        }

        public Criteria andFcmIdHisNotBetween(String value1, String value2) {
            addCriterion("FCM_ID_HIS not between", value1, value2, "fcmIdHis");
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
     * This class corresponds to the database table TB_MARGIN_OP_REQ
     *
     * @mbggenerated do_not_delete_during_merge Mon Mar 30 13:57:53 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_MARGIN_OP_REQ
     * table comment :代理商保证金追加/退回记录
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
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