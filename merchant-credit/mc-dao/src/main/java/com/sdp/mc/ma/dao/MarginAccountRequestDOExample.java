package com.sdp.mc.ma.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MarginAccountRequestDOExample extends QueryBase {
    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.ID
     * column comments null
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private Long id;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.STATUS
     * column comments 0：初始化
1：成功
-1：失败
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private String status;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.SOURCE_ID
     * column comments zf号
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private String sourceId;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private String merchantNo;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.MEMBER_ID
     * column comments 商户会员号
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private String memberId;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.ACCOUNT_ID
     * column comments 储值账户id
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private String accountId;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.REQUEST_NO
     * column comments 请求流水号
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private String requestNo;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.APP_IP
     * column comments 应用服务器ip
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private String appIp;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.REQUEST_OPERATOR
     * column comments 操作员id
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private String requestOperator;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.USER_IP
     * column comments 用户ip
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private String userIp;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.RESPONSE_CODE
     * column comments 0：成功
非0：失败
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private String responseCode;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.RESPONSE_MESSAGE
     * column comments 响应描述
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private String responseMessage;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.REQUEST_TIME
     * column comments 请求时间
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private Date requestTime;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.RESPONSE_TIME
     * column comments 响应时间
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private Date responseTime;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.ACCOUNT_TYPE
     * column comments 账户类型
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private Long accountType;

    /**
     * This field corresponds to the database table TB_MARGIN_ACCOUNT_REQ
     * table comments 保证金账户开户记录
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table TB_MARGIN_ACCOUNT_REQ
     * table comments 保证金账户开户记录
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table TB_MARGIN_ACCOUNT_REQ
     * table comments 保证金账户开户记录
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table TB_MARGIN_ACCOUNT_REQ
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public MarginAccountRequestDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.ID
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.ID
     * column comments null
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.ID
     *
     * @param id the value for TB_MARGIN_ACCOUNT_REQ.ID
     * column comments null
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.STATUS
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.STATUS
     * column comments 0：初始化
1：成功
-1：失败
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.STATUS
     *
     * @param status the value for TB_MARGIN_ACCOUNT_REQ.STATUS
     * column comments 0：初始化
1：成功
-1：失败
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.SOURCE_ID
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.SOURCE_ID
     * column comments zf号
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.SOURCE_ID
     *
     * @param sourceId the value for TB_MARGIN_ACCOUNT_REQ.SOURCE_ID
     * column comments zf号
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId == null ? null : sourceId.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.MERCHANT_NO
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.MERCHANT_NO
     *
     * @param merchantNo the value for TB_MARGIN_ACCOUNT_REQ.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.MEMBER_ID
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.MEMBER_ID
     * column comments 商户会员号
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.MEMBER_ID
     *
     * @param memberId the value for TB_MARGIN_ACCOUNT_REQ.MEMBER_ID
     * column comments 商户会员号
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.ACCOUNT_ID
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.ACCOUNT_ID
     * column comments 储值账户id
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.ACCOUNT_ID
     *
     * @param accountId the value for TB_MARGIN_ACCOUNT_REQ.ACCOUNT_ID
     * column comments 储值账户id
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.REQUEST_NO
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.REQUEST_NO
     * column comments 请求流水号
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String getRequestNo() {
        return requestNo;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.REQUEST_NO
     *
     * @param requestNo the value for TB_MARGIN_ACCOUNT_REQ.REQUEST_NO
     * column comments 请求流水号
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo == null ? null : requestNo.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.APP_IP
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.APP_IP
     * column comments 应用服务器ip
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String getAppIp() {
        return appIp;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.APP_IP
     *
     * @param appIp the value for TB_MARGIN_ACCOUNT_REQ.APP_IP
     * column comments 应用服务器ip
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setAppIp(String appIp) {
        this.appIp = appIp == null ? null : appIp.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.REQUEST_OPERATOR
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.REQUEST_OPERATOR
     * column comments 操作员id
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String getRequestOperator() {
        return requestOperator;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.REQUEST_OPERATOR
     *
     * @param requestOperator the value for TB_MARGIN_ACCOUNT_REQ.REQUEST_OPERATOR
     * column comments 操作员id
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setRequestOperator(String requestOperator) {
        this.requestOperator = requestOperator == null ? null : requestOperator.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.USER_IP
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.USER_IP
     * column comments 用户ip
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String getUserIp() {
        return userIp;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.USER_IP
     *
     * @param userIp the value for TB_MARGIN_ACCOUNT_REQ.USER_IP
     * column comments 用户ip
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setUserIp(String userIp) {
        this.userIp = userIp == null ? null : userIp.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.RESPONSE_CODE
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.RESPONSE_CODE
     * column comments 0：成功
非0：失败
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.RESPONSE_CODE
     *
     * @param responseCode the value for TB_MARGIN_ACCOUNT_REQ.RESPONSE_CODE
     * column comments 0：成功
非0：失败
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode == null ? null : responseCode.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.RESPONSE_MESSAGE
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.RESPONSE_MESSAGE
     * column comments 响应描述
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String getResponseMessage() {
        return responseMessage;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.RESPONSE_MESSAGE
     *
     * @param responseMessage the value for TB_MARGIN_ACCOUNT_REQ.RESPONSE_MESSAGE
     * column comments 响应描述
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage == null ? null : responseMessage.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.REQUEST_TIME
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.REQUEST_TIME
     * column comments 请求时间
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public Date getRequestTime() {
        return requestTime;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.REQUEST_TIME
     *
     * @param requestTime the value for TB_MARGIN_ACCOUNT_REQ.REQUEST_TIME
     * column comments 请求时间
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.RESPONSE_TIME
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.RESPONSE_TIME
     * column comments 响应时间
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public Date getResponseTime() {
        return responseTime;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.RESPONSE_TIME
     *
     * @param responseTime the value for TB_MARGIN_ACCOUNT_REQ.RESPONSE_TIME
     * column comments 响应时间
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.ACCOUNT_TYPE
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.ACCOUNT_TYPE
     * column comments 账户类型
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public Long getAccountType() {
        return accountType;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.ACCOUNT_TYPE
     *
     * @param accountType the value for TB_MARGIN_ACCOUNT_REQ.ACCOUNT_TYPE
     * column comments 账户类型
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setAccountType(Long accountType) {
        this.accountType = accountType;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_ACCOUNT_REQ
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_ACCOUNT_REQ
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_ACCOUNT_REQ
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_ACCOUNT_REQ
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_ACCOUNT_REQ
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_ACCOUNT_REQ
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table TB_MARGIN_ACCOUNT_REQ
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_ACCOUNT_REQ
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_ACCOUNT_REQ
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_MARGIN_ACCOUNT_REQ
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_MARGIN_ACCOUNT_REQ
     * table comment :保证金账户开户记录
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
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

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNull() {
            addCriterion("SOURCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNotNull() {
            addCriterion("SOURCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSourceIdEqualTo(String value) {
            addCriterion("SOURCE_ID =", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotEqualTo(String value) {
            addCriterion("SOURCE_ID <>", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThan(String value) {
            addCriterion("SOURCE_ID >", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThanOrEqualTo(String value) {
            addCriterion("SOURCE_ID >=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThan(String value) {
            addCriterion("SOURCE_ID <", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThanOrEqualTo(String value) {
            addCriterion("SOURCE_ID <=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLike(String value) {
            addCriterion("SOURCE_ID like", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotLike(String value) {
            addCriterion("SOURCE_ID not like", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdIn(List<String> values) {
            addCriterion("SOURCE_ID in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotIn(List<String> values) {
            addCriterion("SOURCE_ID not in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdBetween(String value1, String value2) {
            addCriterion("SOURCE_ID between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotBetween(String value1, String value2) {
            addCriterion("SOURCE_ID not between", value1, value2, "sourceId");
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

        public Criteria andRequestNoIsNull() {
            addCriterion("REQUEST_NO is null");
            return (Criteria) this;
        }

        public Criteria andRequestNoIsNotNull() {
            addCriterion("REQUEST_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRequestNoEqualTo(String value) {
            addCriterion("REQUEST_NO =", value, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoNotEqualTo(String value) {
            addCriterion("REQUEST_NO <>", value, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoGreaterThan(String value) {
            addCriterion("REQUEST_NO >", value, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoGreaterThanOrEqualTo(String value) {
            addCriterion("REQUEST_NO >=", value, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoLessThan(String value) {
            addCriterion("REQUEST_NO <", value, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoLessThanOrEqualTo(String value) {
            addCriterion("REQUEST_NO <=", value, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoLike(String value) {
            addCriterion("REQUEST_NO like", value, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoNotLike(String value) {
            addCriterion("REQUEST_NO not like", value, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoIn(List<String> values) {
            addCriterion("REQUEST_NO in", values, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoNotIn(List<String> values) {
            addCriterion("REQUEST_NO not in", values, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoBetween(String value1, String value2) {
            addCriterion("REQUEST_NO between", value1, value2, "requestNo");
            return (Criteria) this;
        }

        public Criteria andRequestNoNotBetween(String value1, String value2) {
            addCriterion("REQUEST_NO not between", value1, value2, "requestNo");
            return (Criteria) this;
        }

        public Criteria andAppIpIsNull() {
            addCriterion("APP_IP is null");
            return (Criteria) this;
        }

        public Criteria andAppIpIsNotNull() {
            addCriterion("APP_IP is not null");
            return (Criteria) this;
        }

        public Criteria andAppIpEqualTo(String value) {
            addCriterion("APP_IP =", value, "appIp");
            return (Criteria) this;
        }

        public Criteria andAppIpNotEqualTo(String value) {
            addCriterion("APP_IP <>", value, "appIp");
            return (Criteria) this;
        }

        public Criteria andAppIpGreaterThan(String value) {
            addCriterion("APP_IP >", value, "appIp");
            return (Criteria) this;
        }

        public Criteria andAppIpGreaterThanOrEqualTo(String value) {
            addCriterion("APP_IP >=", value, "appIp");
            return (Criteria) this;
        }

        public Criteria andAppIpLessThan(String value) {
            addCriterion("APP_IP <", value, "appIp");
            return (Criteria) this;
        }

        public Criteria andAppIpLessThanOrEqualTo(String value) {
            addCriterion("APP_IP <=", value, "appIp");
            return (Criteria) this;
        }

        public Criteria andAppIpLike(String value) {
            addCriterion("APP_IP like", value, "appIp");
            return (Criteria) this;
        }

        public Criteria andAppIpNotLike(String value) {
            addCriterion("APP_IP not like", value, "appIp");
            return (Criteria) this;
        }

        public Criteria andAppIpIn(List<String> values) {
            addCriterion("APP_IP in", values, "appIp");
            return (Criteria) this;
        }

        public Criteria andAppIpNotIn(List<String> values) {
            addCriterion("APP_IP not in", values, "appIp");
            return (Criteria) this;
        }

        public Criteria andAppIpBetween(String value1, String value2) {
            addCriterion("APP_IP between", value1, value2, "appIp");
            return (Criteria) this;
        }

        public Criteria andAppIpNotBetween(String value1, String value2) {
            addCriterion("APP_IP not between", value1, value2, "appIp");
            return (Criteria) this;
        }

        public Criteria andRequestOperatorIsNull() {
            addCriterion("REQUEST_OPERATOR is null");
            return (Criteria) this;
        }

        public Criteria andRequestOperatorIsNotNull() {
            addCriterion("REQUEST_OPERATOR is not null");
            return (Criteria) this;
        }

        public Criteria andRequestOperatorEqualTo(String value) {
            addCriterion("REQUEST_OPERATOR =", value, "requestOperator");
            return (Criteria) this;
        }

        public Criteria andRequestOperatorNotEqualTo(String value) {
            addCriterion("REQUEST_OPERATOR <>", value, "requestOperator");
            return (Criteria) this;
        }

        public Criteria andRequestOperatorGreaterThan(String value) {
            addCriterion("REQUEST_OPERATOR >", value, "requestOperator");
            return (Criteria) this;
        }

        public Criteria andRequestOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("REQUEST_OPERATOR >=", value, "requestOperator");
            return (Criteria) this;
        }

        public Criteria andRequestOperatorLessThan(String value) {
            addCriterion("REQUEST_OPERATOR <", value, "requestOperator");
            return (Criteria) this;
        }

        public Criteria andRequestOperatorLessThanOrEqualTo(String value) {
            addCriterion("REQUEST_OPERATOR <=", value, "requestOperator");
            return (Criteria) this;
        }

        public Criteria andRequestOperatorLike(String value) {
            addCriterion("REQUEST_OPERATOR like", value, "requestOperator");
            return (Criteria) this;
        }

        public Criteria andRequestOperatorNotLike(String value) {
            addCriterion("REQUEST_OPERATOR not like", value, "requestOperator");
            return (Criteria) this;
        }

        public Criteria andRequestOperatorIn(List<String> values) {
            addCriterion("REQUEST_OPERATOR in", values, "requestOperator");
            return (Criteria) this;
        }

        public Criteria andRequestOperatorNotIn(List<String> values) {
            addCriterion("REQUEST_OPERATOR not in", values, "requestOperator");
            return (Criteria) this;
        }

        public Criteria andRequestOperatorBetween(String value1, String value2) {
            addCriterion("REQUEST_OPERATOR between", value1, value2, "requestOperator");
            return (Criteria) this;
        }

        public Criteria andRequestOperatorNotBetween(String value1, String value2) {
            addCriterion("REQUEST_OPERATOR not between", value1, value2, "requestOperator");
            return (Criteria) this;
        }

        public Criteria andUserIpIsNull() {
            addCriterion("USER_IP is null");
            return (Criteria) this;
        }

        public Criteria andUserIpIsNotNull() {
            addCriterion("USER_IP is not null");
            return (Criteria) this;
        }

        public Criteria andUserIpEqualTo(String value) {
            addCriterion("USER_IP =", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpNotEqualTo(String value) {
            addCriterion("USER_IP <>", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpGreaterThan(String value) {
            addCriterion("USER_IP >", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpGreaterThanOrEqualTo(String value) {
            addCriterion("USER_IP >=", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpLessThan(String value) {
            addCriterion("USER_IP <", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpLessThanOrEqualTo(String value) {
            addCriterion("USER_IP <=", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpLike(String value) {
            addCriterion("USER_IP like", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpNotLike(String value) {
            addCriterion("USER_IP not like", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpIn(List<String> values) {
            addCriterion("USER_IP in", values, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpNotIn(List<String> values) {
            addCriterion("USER_IP not in", values, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpBetween(String value1, String value2) {
            addCriterion("USER_IP between", value1, value2, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpNotBetween(String value1, String value2) {
            addCriterion("USER_IP not between", value1, value2, "userIp");
            return (Criteria) this;
        }

        public Criteria andResponseCodeIsNull() {
            addCriterion("RESPONSE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andResponseCodeIsNotNull() {
            addCriterion("RESPONSE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andResponseCodeEqualTo(String value) {
            addCriterion("RESPONSE_CODE =", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeNotEqualTo(String value) {
            addCriterion("RESPONSE_CODE <>", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeGreaterThan(String value) {
            addCriterion("RESPONSE_CODE >", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("RESPONSE_CODE >=", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeLessThan(String value) {
            addCriterion("RESPONSE_CODE <", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeLessThanOrEqualTo(String value) {
            addCriterion("RESPONSE_CODE <=", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeLike(String value) {
            addCriterion("RESPONSE_CODE like", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeNotLike(String value) {
            addCriterion("RESPONSE_CODE not like", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeIn(List<String> values) {
            addCriterion("RESPONSE_CODE in", values, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeNotIn(List<String> values) {
            addCriterion("RESPONSE_CODE not in", values, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeBetween(String value1, String value2) {
            addCriterion("RESPONSE_CODE between", value1, value2, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeNotBetween(String value1, String value2) {
            addCriterion("RESPONSE_CODE not between", value1, value2, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseMessageIsNull() {
            addCriterion("RESPONSE_MESSAGE is null");
            return (Criteria) this;
        }

        public Criteria andResponseMessageIsNotNull() {
            addCriterion("RESPONSE_MESSAGE is not null");
            return (Criteria) this;
        }

        public Criteria andResponseMessageEqualTo(String value) {
            addCriterion("RESPONSE_MESSAGE =", value, "responseMessage");
            return (Criteria) this;
        }

        public Criteria andResponseMessageNotEqualTo(String value) {
            addCriterion("RESPONSE_MESSAGE <>", value, "responseMessage");
            return (Criteria) this;
        }

        public Criteria andResponseMessageGreaterThan(String value) {
            addCriterion("RESPONSE_MESSAGE >", value, "responseMessage");
            return (Criteria) this;
        }

        public Criteria andResponseMessageGreaterThanOrEqualTo(String value) {
            addCriterion("RESPONSE_MESSAGE >=", value, "responseMessage");
            return (Criteria) this;
        }

        public Criteria andResponseMessageLessThan(String value) {
            addCriterion("RESPONSE_MESSAGE <", value, "responseMessage");
            return (Criteria) this;
        }

        public Criteria andResponseMessageLessThanOrEqualTo(String value) {
            addCriterion("RESPONSE_MESSAGE <=", value, "responseMessage");
            return (Criteria) this;
        }

        public Criteria andResponseMessageLike(String value) {
            addCriterion("RESPONSE_MESSAGE like", value, "responseMessage");
            return (Criteria) this;
        }

        public Criteria andResponseMessageNotLike(String value) {
            addCriterion("RESPONSE_MESSAGE not like", value, "responseMessage");
            return (Criteria) this;
        }

        public Criteria andResponseMessageIn(List<String> values) {
            addCriterion("RESPONSE_MESSAGE in", values, "responseMessage");
            return (Criteria) this;
        }

        public Criteria andResponseMessageNotIn(List<String> values) {
            addCriterion("RESPONSE_MESSAGE not in", values, "responseMessage");
            return (Criteria) this;
        }

        public Criteria andResponseMessageBetween(String value1, String value2) {
            addCriterion("RESPONSE_MESSAGE between", value1, value2, "responseMessage");
            return (Criteria) this;
        }

        public Criteria andResponseMessageNotBetween(String value1, String value2) {
            addCriterion("RESPONSE_MESSAGE not between", value1, value2, "responseMessage");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIsNull() {
            addCriterion("REQUEST_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIsNotNull() {
            addCriterion("REQUEST_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRequestTimeEqualTo(Date value) {
            addCriterion("REQUEST_TIME =", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotEqualTo(Date value) {
            addCriterion("REQUEST_TIME <>", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeGreaterThan(Date value) {
            addCriterion("REQUEST_TIME >", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("REQUEST_TIME >=", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeLessThan(Date value) {
            addCriterion("REQUEST_TIME <", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeLessThanOrEqualTo(Date value) {
            addCriterion("REQUEST_TIME <=", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIn(List<Date> values) {
            addCriterion("REQUEST_TIME in", values, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotIn(List<Date> values) {
            addCriterion("REQUEST_TIME not in", values, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeBetween(Date value1, Date value2) {
            addCriterion("REQUEST_TIME between", value1, value2, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotBetween(Date value1, Date value2) {
            addCriterion("REQUEST_TIME not between", value1, value2, "requestTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeIsNull() {
            addCriterion("RESPONSE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andResponseTimeIsNotNull() {
            addCriterion("RESPONSE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andResponseTimeEqualTo(Date value) {
            addCriterion("RESPONSE_TIME =", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeNotEqualTo(Date value) {
            addCriterion("RESPONSE_TIME <>", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeGreaterThan(Date value) {
            addCriterion("RESPONSE_TIME >", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RESPONSE_TIME >=", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeLessThan(Date value) {
            addCriterion("RESPONSE_TIME <", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeLessThanOrEqualTo(Date value) {
            addCriterion("RESPONSE_TIME <=", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeIn(List<Date> values) {
            addCriterion("RESPONSE_TIME in", values, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeNotIn(List<Date> values) {
            addCriterion("RESPONSE_TIME not in", values, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeBetween(Date value1, Date value2) {
            addCriterion("RESPONSE_TIME between", value1, value2, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeNotBetween(Date value1, Date value2) {
            addCriterion("RESPONSE_TIME not between", value1, value2, "responseTime");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_MARGIN_ACCOUNT_REQ
     *
     * @mbggenerated do_not_delete_during_merge Fri May 29 18:06:19 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_MARGIN_ACCOUNT_REQ
     * table comment :保证金账户开户记录
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
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