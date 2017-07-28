package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RemitFeeReqDoExample extends QueryBase {
    /**
     * This field corresponds to the database column FW_REMIT_WITHDRAWFEE_REQ.REMIT_ID
     * column comments 申请ID
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    private Long remitId;

    /**
     * This field corresponds to the database column FW_REMIT_WITHDRAWFEE_REQ.REQ_ID
     * column comments 出款ID
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    private Long reqId;

    /**
     * This field corresponds to the database column FW_REMIT_WITHDRAWFEE_REQ.MT_ID
     * column comments 转账记录ID
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    private Long mtId;

    /**
     * This field corresponds to the database column FW_REMIT_WITHDRAWFEE_REQ.REMITAMOUNT
     * column comments 退费金额
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    private BigDecimal remitamount;

    /**
     * This field corresponds to the database column FW_REMIT_WITHDRAWFEE_REQ.STATUS
     * column comments 状态（初始-3 退费中-4 退费成功-5 退费失败-99）
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    private String status;

    /**
     * This field corresponds to the database column FW_REMIT_WITHDRAWFEE_REQ.OPERTATOR
     * column comments 操作人
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    private String opertator;

    /**
     * This field corresponds to the database column FW_REMIT_WITHDRAWFEE_REQ.CREATE_TIME
     * column comments 申请时间
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column FW_REMIT_WITHDRAWFEE_REQ.UPDATE_TIME
     * column comments 最后操作时间
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    private Date updateTime;

    /**
     * This field corresponds to the database table FW_REMIT_WITHDRAWFEE_REQ
     * table comments 退款记录
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table FW_REMIT_WITHDRAWFEE_REQ
     * table comments 退款记录
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table FW_REMIT_WITHDRAWFEE_REQ
     * table comments 退款记录
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table FW_REMIT_WITHDRAWFEE_REQ
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public RemitFeeReqDoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column FW_REMIT_WITHDRAWFEE_REQ.REMIT_ID
     *
     * @return the value of FW_REMIT_WITHDRAWFEE_REQ.REMIT_ID
     * column comments 申请ID
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public Long getRemitId() {
        return remitId;
    }

    /**
     * This method sets the value of the database column FW_REMIT_WITHDRAWFEE_REQ.REMIT_ID
     *
     * @param remitId the value for FW_REMIT_WITHDRAWFEE_REQ.REMIT_ID
     * column comments 申请ID
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public void setRemitId(Long remitId) {
        this.remitId = remitId;
    }

    /**
     * This method returns the value of the database column FW_REMIT_WITHDRAWFEE_REQ.REQ_ID
     *
     * @return the value of FW_REMIT_WITHDRAWFEE_REQ.REQ_ID
     * column comments 出款ID
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public Long getReqId() {
        return reqId;
    }

    /**
     * This method sets the value of the database column FW_REMIT_WITHDRAWFEE_REQ.REQ_ID
     *
     * @param reqId the value for FW_REMIT_WITHDRAWFEE_REQ.REQ_ID
     * column comments 出款ID
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    /**
     * This method returns the value of the database column FW_REMIT_WITHDRAWFEE_REQ.MT_ID
     *
     * @return the value of FW_REMIT_WITHDRAWFEE_REQ.MT_ID
     * column comments 转账记录ID
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public Long getMtId() {
        return mtId;
    }

    /**
     * This method sets the value of the database column FW_REMIT_WITHDRAWFEE_REQ.MT_ID
     *
     * @param mtId the value for FW_REMIT_WITHDRAWFEE_REQ.MT_ID
     * column comments 转账记录ID
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public void setMtId(Long mtId) {
        this.mtId = mtId;
    }

    /**
     * This method returns the value of the database column FW_REMIT_WITHDRAWFEE_REQ.REMITAMOUNT
     *
     * @return the value of FW_REMIT_WITHDRAWFEE_REQ.REMITAMOUNT
     * column comments 退费金额
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public BigDecimal getRemitamount() {
        return remitamount;
    }

    /**
     * This method sets the value of the database column FW_REMIT_WITHDRAWFEE_REQ.REMITAMOUNT
     *
     * @param remitamount the value for FW_REMIT_WITHDRAWFEE_REQ.REMITAMOUNT
     * column comments 退费金额
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public void setRemitamount(BigDecimal remitamount) {
        this.remitamount = remitamount;
    }

    /**
     * This method returns the value of the database column FW_REMIT_WITHDRAWFEE_REQ.STATUS
     *
     * @return the value of FW_REMIT_WITHDRAWFEE_REQ.STATUS
     * column comments 状态（初始-3 退费中-4 退费成功-5 退费失败-99）
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column FW_REMIT_WITHDRAWFEE_REQ.STATUS
     *
     * @param status the value for FW_REMIT_WITHDRAWFEE_REQ.STATUS
     * column comments 状态（初始-3 退费中-4 退费成功-5 退费失败-99）
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method returns the value of the database column FW_REMIT_WITHDRAWFEE_REQ.OPERTATOR
     *
     * @return the value of FW_REMIT_WITHDRAWFEE_REQ.OPERTATOR
     * column comments 操作人
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public String getOpertator() {
        return opertator;
    }

    /**
     * This method sets the value of the database column FW_REMIT_WITHDRAWFEE_REQ.OPERTATOR
     *
     * @param opertator the value for FW_REMIT_WITHDRAWFEE_REQ.OPERTATOR
     * column comments 操作人
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public void setOpertator(String opertator) {
        this.opertator = opertator == null ? null : opertator.trim();
    }

    /**
     * This method returns the value of the database column FW_REMIT_WITHDRAWFEE_REQ.CREATE_TIME
     *
     * @return the value of FW_REMIT_WITHDRAWFEE_REQ.CREATE_TIME
     * column comments 申请时间
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column FW_REMIT_WITHDRAWFEE_REQ.CREATE_TIME
     *
     * @param createTime the value for FW_REMIT_WITHDRAWFEE_REQ.CREATE_TIME
     * column comments 申请时间
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column FW_REMIT_WITHDRAWFEE_REQ.UPDATE_TIME
     *
     * @return the value of FW_REMIT_WITHDRAWFEE_REQ.UPDATE_TIME
     * column comments 最后操作时间
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column FW_REMIT_WITHDRAWFEE_REQ.UPDATE_TIME
     *
     * @param updateTime the value for FW_REMIT_WITHDRAWFEE_REQ.UPDATE_TIME
     * column comments 最后操作时间
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method corresponds to the database table FW_REMIT_WITHDRAWFEE_REQ
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table FW_REMIT_WITHDRAWFEE_REQ
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table FW_REMIT_WITHDRAWFEE_REQ
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table FW_REMIT_WITHDRAWFEE_REQ
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table FW_REMIT_WITHDRAWFEE_REQ
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table FW_REMIT_WITHDRAWFEE_REQ
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table FW_REMIT_WITHDRAWFEE_REQ
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_REMIT_WITHDRAWFEE_REQ
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_REMIT_WITHDRAWFEE_REQ
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_REMIT_WITHDRAWFEE_REQ
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_REMIT_WITHDRAWFEE_REQ
     * table comment :退款记录
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
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

        public Criteria andRemitIdIsNull() {
            addCriterion("REMIT_ID is null");
            return (Criteria) this;
        }

        public Criteria andRemitIdIsNotNull() {
            addCriterion("REMIT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRemitIdEqualTo(Long value) {
            addCriterion("REMIT_ID =", value, "remitId");
            return (Criteria) this;
        }

        public Criteria andRemitIdNotEqualTo(Long value) {
            addCriterion("REMIT_ID <>", value, "remitId");
            return (Criteria) this;
        }

        public Criteria andRemitIdGreaterThan(Long value) {
            addCriterion("REMIT_ID >", value, "remitId");
            return (Criteria) this;
        }

        public Criteria andRemitIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REMIT_ID >=", value, "remitId");
            return (Criteria) this;
        }

        public Criteria andRemitIdLessThan(Long value) {
            addCriterion("REMIT_ID <", value, "remitId");
            return (Criteria) this;
        }

        public Criteria andRemitIdLessThanOrEqualTo(Long value) {
            addCriterion("REMIT_ID <=", value, "remitId");
            return (Criteria) this;
        }

        public Criteria andRemitIdIn(List<Long> values) {
            addCriterion("REMIT_ID in", values, "remitId");
            return (Criteria) this;
        }

        public Criteria andRemitIdNotIn(List<Long> values) {
            addCriterion("REMIT_ID not in", values, "remitId");
            return (Criteria) this;
        }

        public Criteria andRemitIdBetween(Long value1, Long value2) {
            addCriterion("REMIT_ID between", value1, value2, "remitId");
            return (Criteria) this;
        }

        public Criteria andRemitIdNotBetween(Long value1, Long value2) {
            addCriterion("REMIT_ID not between", value1, value2, "remitId");
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

        public Criteria andMtIdIsNull() {
            addCriterion("MT_ID is null");
            return (Criteria) this;
        }

        public Criteria andMtIdIsNotNull() {
            addCriterion("MT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMtIdEqualTo(Long value) {
            addCriterion("MT_ID =", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdNotEqualTo(Long value) {
            addCriterion("MT_ID <>", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdGreaterThan(Long value) {
            addCriterion("MT_ID >", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdGreaterThanOrEqualTo(Long value) {
            addCriterion("MT_ID >=", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdLessThan(Long value) {
            addCriterion("MT_ID <", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdLessThanOrEqualTo(Long value) {
            addCriterion("MT_ID <=", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdIn(List<Long> values) {
            addCriterion("MT_ID in", values, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdNotIn(List<Long> values) {
            addCriterion("MT_ID not in", values, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdBetween(Long value1, Long value2) {
            addCriterion("MT_ID between", value1, value2, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdNotBetween(Long value1, Long value2) {
            addCriterion("MT_ID not between", value1, value2, "mtId");
            return (Criteria) this;
        }

        public Criteria andRemitamountIsNull() {
            addCriterion("REMITAMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andRemitamountIsNotNull() {
            addCriterion("REMITAMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andRemitamountEqualTo(BigDecimal value) {
            addCriterion("REMITAMOUNT =", value, "remitamount");
            return (Criteria) this;
        }

        public Criteria andRemitamountNotEqualTo(BigDecimal value) {
            addCriterion("REMITAMOUNT <>", value, "remitamount");
            return (Criteria) this;
        }

        public Criteria andRemitamountGreaterThan(BigDecimal value) {
            addCriterion("REMITAMOUNT >", value, "remitamount");
            return (Criteria) this;
        }

        public Criteria andRemitamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REMITAMOUNT >=", value, "remitamount");
            return (Criteria) this;
        }

        public Criteria andRemitamountLessThan(BigDecimal value) {
            addCriterion("REMITAMOUNT <", value, "remitamount");
            return (Criteria) this;
        }

        public Criteria andRemitamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REMITAMOUNT <=", value, "remitamount");
            return (Criteria) this;
        }

        public Criteria andRemitamountIn(List<BigDecimal> values) {
            addCriterion("REMITAMOUNT in", values, "remitamount");
            return (Criteria) this;
        }

        public Criteria andRemitamountNotIn(List<BigDecimal> values) {
            addCriterion("REMITAMOUNT not in", values, "remitamount");
            return (Criteria) this;
        }

        public Criteria andRemitamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REMITAMOUNT between", value1, value2, "remitamount");
            return (Criteria) this;
        }

        public Criteria andRemitamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REMITAMOUNT not between", value1, value2, "remitamount");
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

        public Criteria andOpertatorIsNull() {
            addCriterion("OPERTATOR is null");
            return (Criteria) this;
        }

        public Criteria andOpertatorIsNotNull() {
            addCriterion("OPERTATOR is not null");
            return (Criteria) this;
        }

        public Criteria andOpertatorEqualTo(String value) {
            addCriterion("OPERTATOR =", value, "opertator");
            return (Criteria) this;
        }

        public Criteria andOpertatorNotEqualTo(String value) {
            addCriterion("OPERTATOR <>", value, "opertator");
            return (Criteria) this;
        }

        public Criteria andOpertatorGreaterThan(String value) {
            addCriterion("OPERTATOR >", value, "opertator");
            return (Criteria) this;
        }

        public Criteria andOpertatorGreaterThanOrEqualTo(String value) {
            addCriterion("OPERTATOR >=", value, "opertator");
            return (Criteria) this;
        }

        public Criteria andOpertatorLessThan(String value) {
            addCriterion("OPERTATOR <", value, "opertator");
            return (Criteria) this;
        }

        public Criteria andOpertatorLessThanOrEqualTo(String value) {
            addCriterion("OPERTATOR <=", value, "opertator");
            return (Criteria) this;
        }

        public Criteria andOpertatorLike(String value) {
            addCriterion("OPERTATOR like", value, "opertator");
            return (Criteria) this;
        }

        public Criteria andOpertatorNotLike(String value) {
            addCriterion("OPERTATOR not like", value, "opertator");
            return (Criteria) this;
        }

        public Criteria andOpertatorIn(List<String> values) {
            addCriterion("OPERTATOR in", values, "opertator");
            return (Criteria) this;
        }

        public Criteria andOpertatorNotIn(List<String> values) {
            addCriterion("OPERTATOR not in", values, "opertator");
            return (Criteria) this;
        }

        public Criteria andOpertatorBetween(String value1, String value2) {
            addCriterion("OPERTATOR between", value1, value2, "opertator");
            return (Criteria) this;
        }

        public Criteria andOpertatorNotBetween(String value1, String value2) {
            addCriterion("OPERTATOR not between", value1, value2, "opertator");
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
     * This class corresponds to the database table FW_REMIT_WITHDRAWFEE_REQ
     *
     * @mbggenerated do_not_delete_during_merge Mon Apr 25 15:42:27 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_REMIT_WITHDRAWFEE_REQ
     * table comment :退款记录
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
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