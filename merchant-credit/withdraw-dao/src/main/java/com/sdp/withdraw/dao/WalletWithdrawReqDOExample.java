package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WalletWithdrawReqDOExample extends QueryBase {
    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.REQ_ID
     * column comments 请求ID
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private Long reqId;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.APP_ID
     * column comments 数据来源的应用ID
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private String appId;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.ORDER_NO
     * column comments 订单号
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private String orderNo;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.MEMBER_ID
     * column comments 会员ID
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private String memberId;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.MEMBER_NO
     * column comments 出款的会员号，如果是线下出款是商户号
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private String memberNo;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.MEMBER_TYPE
     * column comments 出款会员的类型，POS商户：0001； mPOS商户：0006；
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private String memberType;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.WITHDRAW_AMOUNT
     * column comments 可出款金额
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private BigDecimal withdrawAmount;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.ORIGINAL_AMOUNT
     * column comments 原始收单金额
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private BigDecimal originalAmount;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.TRACE_NO
     * column comments 出款的请求的跟踪号
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private Long traceNo;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.EXTENTION
     * column comments 扩展信息
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private String extention;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.STATUS
     * column comments 状态，0：出款成功，1：待出款 2：出款中  9：出款失败
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private Integer status;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.CALLBACK_ADDRESS
     * column comments 回掉地址
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private String callbackAddress;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column FW_WALLET_WITHDRAW_REQ.UPDATE_TIME
     * column comments 最后修改时间
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    private Date updateTime;

    /**
     * This field corresponds to the database table FW_WALLET_WITHDRAW_REQ
     * table comments 钱包出款请求表
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table FW_WALLET_WITHDRAW_REQ
     * table comments 钱包出款请求表
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table FW_WALLET_WITHDRAW_REQ
     * table comments 钱包出款请求表
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table FW_WALLET_WITHDRAW_REQ
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public WalletWithdrawReqDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.REQ_ID
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.REQ_ID
     * column comments 请求ID
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public Long getReqId() {
        return reqId;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.REQ_ID
     *
     * @param reqId the value for FW_WALLET_WITHDRAW_REQ.REQ_ID
     * column comments 请求ID
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.APP_ID
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.APP_ID
     * column comments 数据来源的应用ID
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public String getAppId() {
        return appId;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.APP_ID
     *
     * @param appId the value for FW_WALLET_WITHDRAW_REQ.APP_ID
     * column comments 数据来源的应用ID
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.ORDER_NO
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.ORDER_NO
     * column comments 订单号
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.ORDER_NO
     *
     * @param orderNo the value for FW_WALLET_WITHDRAW_REQ.ORDER_NO
     * column comments 订单号
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.MEMBER_ID
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.MEMBER_ID
     * column comments 会员ID
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.MEMBER_ID
     *
     * @param memberId the value for FW_WALLET_WITHDRAW_REQ.MEMBER_ID
     * column comments 会员ID
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.MEMBER_NO
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.MEMBER_NO
     * column comments 出款的会员号，如果是线下出款是商户号
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public String getMemberNo() {
        return memberNo;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.MEMBER_NO
     *
     * @param memberNo the value for FW_WALLET_WITHDRAW_REQ.MEMBER_NO
     * column comments 出款的会员号，如果是线下出款是商户号
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.MEMBER_TYPE
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.MEMBER_TYPE
     * column comments 出款会员的类型，POS商户：0001； mPOS商户：0006；
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public String getMemberType() {
        return memberType;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.MEMBER_TYPE
     *
     * @param memberType the value for FW_WALLET_WITHDRAW_REQ.MEMBER_TYPE
     * column comments 出款会员的类型，POS商户：0001； mPOS商户：0006；
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setMemberType(String memberType) {
        this.memberType = memberType == null ? null : memberType.trim();
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.WITHDRAW_AMOUNT
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.WITHDRAW_AMOUNT
     * column comments 可出款金额
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public BigDecimal getWithdrawAmount() {
        return withdrawAmount;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.WITHDRAW_AMOUNT
     *
     * @param withdrawAmount the value for FW_WALLET_WITHDRAW_REQ.WITHDRAW_AMOUNT
     * column comments 可出款金额
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setWithdrawAmount(BigDecimal withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.ORIGINAL_AMOUNT
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.ORIGINAL_AMOUNT
     * column comments 原始收单金额
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.ORIGINAL_AMOUNT
     *
     * @param originalAmount the value for FW_WALLET_WITHDRAW_REQ.ORIGINAL_AMOUNT
     * column comments 原始收单金额
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setOriginalAmount(BigDecimal originalAmount) {
        this.originalAmount = originalAmount;
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.TRACE_NO
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.TRACE_NO
     * column comments 出款的请求的跟踪号
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public Long getTraceNo() {
        return traceNo;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.TRACE_NO
     *
     * @param traceNo the value for FW_WALLET_WITHDRAW_REQ.TRACE_NO
     * column comments 出款的请求的跟踪号
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setTraceNo(Long traceNo) {
        this.traceNo = traceNo;
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.EXTENTION
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.EXTENTION
     * column comments 扩展信息
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public String getExtention() {
        return extention;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.EXTENTION
     *
     * @param extention the value for FW_WALLET_WITHDRAW_REQ.EXTENTION
     * column comments 扩展信息
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setExtention(String extention) {
        this.extention = extention == null ? null : extention.trim();
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.STATUS
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.STATUS
     * column comments 状态，0：出款成功，1：待出款 2：出款中  9：出款失败
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.STATUS
     *
     * @param status the value for FW_WALLET_WITHDRAW_REQ.STATUS
     * column comments 状态，0：出款成功，1：待出款 2：出款中  9：出款失败
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.CALLBACK_ADDRESS
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.CALLBACK_ADDRESS
     * column comments 回掉地址
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public String getCallbackAddress() {
        return callbackAddress;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.CALLBACK_ADDRESS
     *
     * @param callbackAddress the value for FW_WALLET_WITHDRAW_REQ.CALLBACK_ADDRESS
     * column comments 回掉地址
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setCallbackAddress(String callbackAddress) {
        this.callbackAddress = callbackAddress == null ? null : callbackAddress.trim();
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.CREATE_TIME
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.CREATE_TIME
     *
     * @param createTime the value for FW_WALLET_WITHDRAW_REQ.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column FW_WALLET_WITHDRAW_REQ.UPDATE_TIME
     *
     * @return the value of FW_WALLET_WITHDRAW_REQ.UPDATE_TIME
     * column comments 最后修改时间
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column FW_WALLET_WITHDRAW_REQ.UPDATE_TIME
     *
     * @param updateTime the value for FW_WALLET_WITHDRAW_REQ.UPDATE_TIME
     * column comments 最后修改时间
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method corresponds to the database table FW_WALLET_WITHDRAW_REQ
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table FW_WALLET_WITHDRAW_REQ
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table FW_WALLET_WITHDRAW_REQ
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table FW_WALLET_WITHDRAW_REQ
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table FW_WALLET_WITHDRAW_REQ
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table FW_WALLET_WITHDRAW_REQ
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table FW_WALLET_WITHDRAW_REQ
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WALLET_WITHDRAW_REQ
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WALLET_WITHDRAW_REQ
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WALLET_WITHDRAW_REQ
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WALLET_WITHDRAW_REQ
     * table comment :钱包出款请求表
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
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

        public Criteria andAppIdIsNull() {
            addCriterion("APP_ID is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("APP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("APP_ID =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("APP_ID <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("APP_ID >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("APP_ID >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("APP_ID <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("APP_ID <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("APP_ID like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("APP_ID not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("APP_ID in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("APP_ID not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("APP_ID between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("APP_ID not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("ORDER_NO is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("ORDER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("ORDER_NO =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("ORDER_NO <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("ORDER_NO >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_NO >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("ORDER_NO <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("ORDER_NO <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("ORDER_NO like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("ORDER_NO not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("ORDER_NO in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("ORDER_NO not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("ORDER_NO between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("ORDER_NO not between", value1, value2, "orderNo");
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

        public Criteria andMemberNoIsNull() {
            addCriterion("MEMBER_NO is null");
            return (Criteria) this;
        }

        public Criteria andMemberNoIsNotNull() {
            addCriterion("MEMBER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMemberNoEqualTo(String value) {
            addCriterion("MEMBER_NO =", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoNotEqualTo(String value) {
            addCriterion("MEMBER_NO <>", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoGreaterThan(String value) {
            addCriterion("MEMBER_NO >", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoGreaterThanOrEqualTo(String value) {
            addCriterion("MEMBER_NO >=", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoLessThan(String value) {
            addCriterion("MEMBER_NO <", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoLessThanOrEqualTo(String value) {
            addCriterion("MEMBER_NO <=", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoLike(String value) {
            addCriterion("MEMBER_NO like", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoNotLike(String value) {
            addCriterion("MEMBER_NO not like", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoIn(List<String> values) {
            addCriterion("MEMBER_NO in", values, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoNotIn(List<String> values) {
            addCriterion("MEMBER_NO not in", values, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoBetween(String value1, String value2) {
            addCriterion("MEMBER_NO between", value1, value2, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoNotBetween(String value1, String value2) {
            addCriterion("MEMBER_NO not between", value1, value2, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberTypeIsNull() {
            addCriterion("MEMBER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMemberTypeIsNotNull() {
            addCriterion("MEMBER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMemberTypeEqualTo(String value) {
            addCriterion("MEMBER_TYPE =", value, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeNotEqualTo(String value) {
            addCriterion("MEMBER_TYPE <>", value, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeGreaterThan(String value) {
            addCriterion("MEMBER_TYPE >", value, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MEMBER_TYPE >=", value, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeLessThan(String value) {
            addCriterion("MEMBER_TYPE <", value, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeLessThanOrEqualTo(String value) {
            addCriterion("MEMBER_TYPE <=", value, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeLike(String value) {
            addCriterion("MEMBER_TYPE like", value, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeNotLike(String value) {
            addCriterion("MEMBER_TYPE not like", value, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeIn(List<String> values) {
            addCriterion("MEMBER_TYPE in", values, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeNotIn(List<String> values) {
            addCriterion("MEMBER_TYPE not in", values, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeBetween(String value1, String value2) {
            addCriterion("MEMBER_TYPE between", value1, value2, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeNotBetween(String value1, String value2) {
            addCriterion("MEMBER_TYPE not between", value1, value2, "memberType");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountIsNull() {
            addCriterion("WITHDRAW_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountIsNotNull() {
            addCriterion("WITHDRAW_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountEqualTo(BigDecimal value) {
            addCriterion("WITHDRAW_AMOUNT =", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountNotEqualTo(BigDecimal value) {
            addCriterion("WITHDRAW_AMOUNT <>", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountGreaterThan(BigDecimal value) {
            addCriterion("WITHDRAW_AMOUNT >", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WITHDRAW_AMOUNT >=", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountLessThan(BigDecimal value) {
            addCriterion("WITHDRAW_AMOUNT <", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WITHDRAW_AMOUNT <=", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountIn(List<BigDecimal> values) {
            addCriterion("WITHDRAW_AMOUNT in", values, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountNotIn(List<BigDecimal> values) {
            addCriterion("WITHDRAW_AMOUNT not in", values, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WITHDRAW_AMOUNT between", value1, value2, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WITHDRAW_AMOUNT not between", value1, value2, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountIsNull() {
            addCriterion("ORIGINAL_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountIsNotNull() {
            addCriterion("ORIGINAL_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountEqualTo(BigDecimal value) {
            addCriterion("ORIGINAL_AMOUNT =", value, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountNotEqualTo(BigDecimal value) {
            addCriterion("ORIGINAL_AMOUNT <>", value, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountGreaterThan(BigDecimal value) {
            addCriterion("ORIGINAL_AMOUNT >", value, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ORIGINAL_AMOUNT >=", value, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountLessThan(BigDecimal value) {
            addCriterion("ORIGINAL_AMOUNT <", value, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ORIGINAL_AMOUNT <=", value, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountIn(List<BigDecimal> values) {
            addCriterion("ORIGINAL_AMOUNT in", values, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountNotIn(List<BigDecimal> values) {
            addCriterion("ORIGINAL_AMOUNT not in", values, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORIGINAL_AMOUNT between", value1, value2, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORIGINAL_AMOUNT not between", value1, value2, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andTraceNoIsNull() {
            addCriterion("TRACE_NO is null");
            return (Criteria) this;
        }

        public Criteria andTraceNoIsNotNull() {
            addCriterion("TRACE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andTraceNoEqualTo(Long value) {
            addCriterion("TRACE_NO =", value, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoNotEqualTo(Long value) {
            addCriterion("TRACE_NO <>", value, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoGreaterThan(Long value) {
            addCriterion("TRACE_NO >", value, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoGreaterThanOrEqualTo(Long value) {
            addCriterion("TRACE_NO >=", value, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoLessThan(Long value) {
            addCriterion("TRACE_NO <", value, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoLessThanOrEqualTo(Long value) {
            addCriterion("TRACE_NO <=", value, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoIn(List<Long> values) {
            addCriterion("TRACE_NO in", values, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoNotIn(List<Long> values) {
            addCriterion("TRACE_NO not in", values, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoBetween(Long value1, Long value2) {
            addCriterion("TRACE_NO between", value1, value2, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoNotBetween(Long value1, Long value2) {
            addCriterion("TRACE_NO not between", value1, value2, "traceNo");
            return (Criteria) this;
        }

        public Criteria andExtentionIsNull() {
            addCriterion("EXTENTION is null");
            return (Criteria) this;
        }

        public Criteria andExtentionIsNotNull() {
            addCriterion("EXTENTION is not null");
            return (Criteria) this;
        }

        public Criteria andExtentionEqualTo(String value) {
            addCriterion("EXTENTION =", value, "extention");
            return (Criteria) this;
        }

        public Criteria andExtentionNotEqualTo(String value) {
            addCriterion("EXTENTION <>", value, "extention");
            return (Criteria) this;
        }

        public Criteria andExtentionGreaterThan(String value) {
            addCriterion("EXTENTION >", value, "extention");
            return (Criteria) this;
        }

        public Criteria andExtentionGreaterThanOrEqualTo(String value) {
            addCriterion("EXTENTION >=", value, "extention");
            return (Criteria) this;
        }

        public Criteria andExtentionLessThan(String value) {
            addCriterion("EXTENTION <", value, "extention");
            return (Criteria) this;
        }

        public Criteria andExtentionLessThanOrEqualTo(String value) {
            addCriterion("EXTENTION <=", value, "extention");
            return (Criteria) this;
        }

        public Criteria andExtentionLike(String value) {
            addCriterion("EXTENTION like", value, "extention");
            return (Criteria) this;
        }

        public Criteria andExtentionNotLike(String value) {
            addCriterion("EXTENTION not like", value, "extention");
            return (Criteria) this;
        }

        public Criteria andExtentionIn(List<String> values) {
            addCriterion("EXTENTION in", values, "extention");
            return (Criteria) this;
        }

        public Criteria andExtentionNotIn(List<String> values) {
            addCriterion("EXTENTION not in", values, "extention");
            return (Criteria) this;
        }

        public Criteria andExtentionBetween(String value1, String value2) {
            addCriterion("EXTENTION between", value1, value2, "extention");
            return (Criteria) this;
        }

        public Criteria andExtentionNotBetween(String value1, String value2) {
            addCriterion("EXTENTION not between", value1, value2, "extention");
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

        public Criteria andCallbackAddressIsNull() {
            addCriterion("CALLBACK_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressIsNotNull() {
            addCriterion("CALLBACK_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressEqualTo(String value) {
            addCriterion("CALLBACK_ADDRESS =", value, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressNotEqualTo(String value) {
            addCriterion("CALLBACK_ADDRESS <>", value, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressGreaterThan(String value) {
            addCriterion("CALLBACK_ADDRESS >", value, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressGreaterThanOrEqualTo(String value) {
            addCriterion("CALLBACK_ADDRESS >=", value, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressLessThan(String value) {
            addCriterion("CALLBACK_ADDRESS <", value, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressLessThanOrEqualTo(String value) {
            addCriterion("CALLBACK_ADDRESS <=", value, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressLike(String value) {
            addCriterion("CALLBACK_ADDRESS like", value, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressNotLike(String value) {
            addCriterion("CALLBACK_ADDRESS not like", value, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressIn(List<String> values) {
            addCriterion("CALLBACK_ADDRESS in", values, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressNotIn(List<String> values) {
            addCriterion("CALLBACK_ADDRESS not in", values, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressBetween(String value1, String value2) {
            addCriterion("CALLBACK_ADDRESS between", value1, value2, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressNotBetween(String value1, String value2) {
            addCriterion("CALLBACK_ADDRESS not between", value1, value2, "callbackAddress");
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
     * This class corresponds to the database table FW_WALLET_WITHDRAW_REQ
     *
     * @mbggenerated do_not_delete_during_merge Wed Nov 23 10:26:15 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WALLET_WITHDRAW_REQ
     * table comment :钱包出款请求表
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
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