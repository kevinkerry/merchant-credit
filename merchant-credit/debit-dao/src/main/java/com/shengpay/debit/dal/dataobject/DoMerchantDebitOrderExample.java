package com.shengpay.debit.dal.dataobject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoMerchantDebitOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DoMerchantDebitOrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected DoMerchantDebitOrderExample(DoMerchantDebitOrderExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
        this.distinct = example.distinct;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<String> criteriaWithoutValue;

        protected List<Map<String, Object>> criteriaWithSingleValue;

        protected List<Map<String, Object>> criteriaWithListValue;

        protected List<Map<String, Object>> criteriaWithBetweenValue;

        protected GeneratedCriteria() {
            super();
            criteriaWithoutValue = new ArrayList<String>();
            criteriaWithSingleValue = new ArrayList<Map<String, Object>>();
            criteriaWithListValue = new ArrayList<Map<String, Object>>();
            criteriaWithBetweenValue = new ArrayList<Map<String, Object>>();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List<String> getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List<Map<String, Object>> getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List<Map<String, Object>> getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List<Map<String, Object>> getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List<? extends Object> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List<Object> list = new ArrayList<Object>();
            list.add(value1);
            list.add(value2);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
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

        public Criteria andMerchantNameIsNull() {
            addCriterion("MERCHANT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIsNotNull() {
            addCriterion("MERCHANT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantNameEqualTo(String value) {
            addCriterion("MERCHANT_NAME =", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotEqualTo(String value) {
            addCriterion("MERCHANT_NAME <>", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameGreaterThan(String value) {
            addCriterion("MERCHANT_NAME >", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_NAME >=", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLessThan(String value) {
            addCriterion("MERCHANT_NAME <", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_NAME <=", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLike(String value) {
            addCriterion("MERCHANT_NAME like", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotLike(String value) {
            addCriterion("MERCHANT_NAME not like", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIn(List<String> values) {
            addCriterion("MERCHANT_NAME in", values, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotIn(List<String> values) {
            addCriterion("MERCHANT_NAME not in", values, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameBetween(String value1, String value2) {
            addCriterion("MERCHANT_NAME between", value1, value2, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_NAME not between", value1, value2, "merchantName");
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

        public Criteria andDebitAmountIsNull() {
            addCriterion("DEBIT_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andDebitAmountIsNotNull() {
            addCriterion("DEBIT_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andDebitAmountEqualTo(BigDecimal value) {
            addCriterion("DEBIT_AMOUNT =", value, "debitAmount");
            return (Criteria) this;
        }

        public Criteria andDebitAmountNotEqualTo(BigDecimal value) {
            addCriterion("DEBIT_AMOUNT <>", value, "debitAmount");
            return (Criteria) this;
        }

        public Criteria andDebitAmountGreaterThan(BigDecimal value) {
            addCriterion("DEBIT_AMOUNT >", value, "debitAmount");
            return (Criteria) this;
        }

        public Criteria andDebitAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DEBIT_AMOUNT >=", value, "debitAmount");
            return (Criteria) this;
        }

        public Criteria andDebitAmountLessThan(BigDecimal value) {
            addCriterion("DEBIT_AMOUNT <", value, "debitAmount");
            return (Criteria) this;
        }

        public Criteria andDebitAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DEBIT_AMOUNT <=", value, "debitAmount");
            return (Criteria) this;
        }

        public Criteria andDebitAmountIn(List<BigDecimal> values) {
            addCriterion("DEBIT_AMOUNT in", values, "debitAmount");
            return (Criteria) this;
        }

        public Criteria andDebitAmountNotIn(List<BigDecimal> values) {
            addCriterion("DEBIT_AMOUNT not in", values, "debitAmount");
            return (Criteria) this;
        }

        public Criteria andDebitAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEBIT_AMOUNT between", value1, value2, "debitAmount");
            return (Criteria) this;
        }

        public Criteria andDebitAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEBIT_AMOUNT not between", value1, value2, "debitAmount");
            return (Criteria) this;
        }

        public Criteria andPurposerIsNull() {
            addCriterion("PURPOSER is null");
            return (Criteria) this;
        }

        public Criteria andPurposerIsNotNull() {
            addCriterion("PURPOSER is not null");
            return (Criteria) this;
        }

        public Criteria andPurposerEqualTo(String value) {
            addCriterion("PURPOSER =", value, "purposer");
            return (Criteria) this;
        }

        public Criteria andPurposerNotEqualTo(String value) {
            addCriterion("PURPOSER <>", value, "purposer");
            return (Criteria) this;
        }

        public Criteria andPurposerGreaterThan(String value) {
            addCriterion("PURPOSER >", value, "purposer");
            return (Criteria) this;
        }

        public Criteria andPurposerGreaterThanOrEqualTo(String value) {
            addCriterion("PURPOSER >=", value, "purposer");
            return (Criteria) this;
        }

        public Criteria andPurposerLessThan(String value) {
            addCriterion("PURPOSER <", value, "purposer");
            return (Criteria) this;
        }

        public Criteria andPurposerLessThanOrEqualTo(String value) {
            addCriterion("PURPOSER <=", value, "purposer");
            return (Criteria) this;
        }

        public Criteria andPurposerLike(String value) {
            addCriterion("PURPOSER like", value, "purposer");
            return (Criteria) this;
        }

        public Criteria andPurposerNotLike(String value) {
            addCriterion("PURPOSER not like", value, "purposer");
            return (Criteria) this;
        }

        public Criteria andPurposerIn(List<String> values) {
            addCriterion("PURPOSER in", values, "purposer");
            return (Criteria) this;
        }

        public Criteria andPurposerNotIn(List<String> values) {
            addCriterion("PURPOSER not in", values, "purposer");
            return (Criteria) this;
        }

        public Criteria andPurposerBetween(String value1, String value2) {
            addCriterion("PURPOSER between", value1, value2, "purposer");
            return (Criteria) this;
        }

        public Criteria andPurposerNotBetween(String value1, String value2) {
            addCriterion("PURPOSER not between", value1, value2, "purposer");
            return (Criteria) this;
        }

        public Criteria andPromoterNoIsNull() {
            addCriterion("PROMOTER_NO is null");
            return (Criteria) this;
        }

        public Criteria andPromoterNoIsNotNull() {
            addCriterion("PROMOTER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPromoterNoEqualTo(String value) {
            addCriterion("PROMOTER_NO =", value, "promoterNo");
            return (Criteria) this;
        }

        public Criteria andPromoterNoNotEqualTo(String value) {
            addCriterion("PROMOTER_NO <>", value, "promoterNo");
            return (Criteria) this;
        }

        public Criteria andPromoterNoGreaterThan(String value) {
            addCriterion("PROMOTER_NO >", value, "promoterNo");
            return (Criteria) this;
        }

        public Criteria andPromoterNoGreaterThanOrEqualTo(String value) {
            addCriterion("PROMOTER_NO >=", value, "promoterNo");
            return (Criteria) this;
        }

        public Criteria andPromoterNoLessThan(String value) {
            addCriterion("PROMOTER_NO <", value, "promoterNo");
            return (Criteria) this;
        }

        public Criteria andPromoterNoLessThanOrEqualTo(String value) {
            addCriterion("PROMOTER_NO <=", value, "promoterNo");
            return (Criteria) this;
        }

        public Criteria andPromoterNoLike(String value) {
            addCriterion("PROMOTER_NO like", value, "promoterNo");
            return (Criteria) this;
        }

        public Criteria andPromoterNoNotLike(String value) {
            addCriterion("PROMOTER_NO not like", value, "promoterNo");
            return (Criteria) this;
        }

        public Criteria andPromoterNoIn(List<String> values) {
            addCriterion("PROMOTER_NO in", values, "promoterNo");
            return (Criteria) this;
        }

        public Criteria andPromoterNoNotIn(List<String> values) {
            addCriterion("PROMOTER_NO not in", values, "promoterNo");
            return (Criteria) this;
        }

        public Criteria andPromoterNoBetween(String value1, String value2) {
            addCriterion("PROMOTER_NO between", value1, value2, "promoterNo");
            return (Criteria) this;
        }

        public Criteria andPromoterNoNotBetween(String value1, String value2) {
            addCriterion("PROMOTER_NO not between", value1, value2, "promoterNo");
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

        public Criteria andApplyDateIsNull() {
            addCriterion("APPLY_DATE is null");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNotNull() {
            addCriterion("APPLY_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDateEqualTo(Date value) {
            addCriterion("APPLY_DATE =", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotEqualTo(Date value) {
            addCriterion("APPLY_DATE <>", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThan(Date value) {
            addCriterion("APPLY_DATE >", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("APPLY_DATE >=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThan(Date value) {
            addCriterion("APPLY_DATE <", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThanOrEqualTo(Date value) {
            addCriterion("APPLY_DATE <=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateIn(List<Date> values) {
            addCriterion("APPLY_DATE in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotIn(List<Date> values) {
            addCriterion("APPLY_DATE not in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateBetween(Date value1, Date value2) {
            addCriterion("APPLY_DATE between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotBetween(Date value1, Date value2) {
            addCriterion("APPLY_DATE not between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andResultTimeIsNull() {
            addCriterion("RESULT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andResultTimeIsNotNull() {
            addCriterion("RESULT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andResultTimeEqualTo(Date value) {
            addCriterion("RESULT_TIME =", value, "resultTime");
            return (Criteria) this;
        }

        public Criteria andResultTimeNotEqualTo(Date value) {
            addCriterion("RESULT_TIME <>", value, "resultTime");
            return (Criteria) this;
        }

        public Criteria andResultTimeGreaterThan(Date value) {
            addCriterion("RESULT_TIME >", value, "resultTime");
            return (Criteria) this;
        }

        public Criteria andResultTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RESULT_TIME >=", value, "resultTime");
            return (Criteria) this;
        }

        public Criteria andResultTimeLessThan(Date value) {
            addCriterion("RESULT_TIME <", value, "resultTime");
            return (Criteria) this;
        }

        public Criteria andResultTimeLessThanOrEqualTo(Date value) {
            addCriterion("RESULT_TIME <=", value, "resultTime");
            return (Criteria) this;
        }

        public Criteria andResultTimeIn(List<Date> values) {
            addCriterion("RESULT_TIME in", values, "resultTime");
            return (Criteria) this;
        }

        public Criteria andResultTimeNotIn(List<Date> values) {
            addCriterion("RESULT_TIME not in", values, "resultTime");
            return (Criteria) this;
        }

        public Criteria andResultTimeBetween(Date value1, Date value2) {
            addCriterion("RESULT_TIME between", value1, value2, "resultTime");
            return (Criteria) this;
        }

        public Criteria andResultTimeNotBetween(Date value1, Date value2) {
            addCriterion("RESULT_TIME not between", value1, value2, "resultTime");
            return (Criteria) this;
        }

        public Criteria andTransferTimeIsNull() {
            addCriterion("TRANSFER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andTransferTimeIsNotNull() {
            addCriterion("TRANSFER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTransferTimeEqualTo(Date value) {
            addCriterion("TRANSFER_TIME =", value, "transferTime");
            return (Criteria) this;
        }

        public Criteria andTransferTimeNotEqualTo(Date value) {
            addCriterion("TRANSFER_TIME <>", value, "transferTime");
            return (Criteria) this;
        }

        public Criteria andTransferTimeGreaterThan(Date value) {
            addCriterion("TRANSFER_TIME >", value, "transferTime");
            return (Criteria) this;
        }

        public Criteria andTransferTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("TRANSFER_TIME >=", value, "transferTime");
            return (Criteria) this;
        }

        public Criteria andTransferTimeLessThan(Date value) {
            addCriterion("TRANSFER_TIME <", value, "transferTime");
            return (Criteria) this;
        }

        public Criteria andTransferTimeLessThanOrEqualTo(Date value) {
            addCriterion("TRANSFER_TIME <=", value, "transferTime");
            return (Criteria) this;
        }

        public Criteria andTransferTimeIn(List<Date> values) {
            addCriterion("TRANSFER_TIME in", values, "transferTime");
            return (Criteria) this;
        }

        public Criteria andTransferTimeNotIn(List<Date> values) {
            addCriterion("TRANSFER_TIME not in", values, "transferTime");
            return (Criteria) this;
        }

        public Criteria andTransferTimeBetween(Date value1, Date value2) {
            addCriterion("TRANSFER_TIME between", value1, value2, "transferTime");
            return (Criteria) this;
        }

        public Criteria andTransferTimeNotBetween(Date value1, Date value2) {
            addCriterion("TRANSFER_TIME not between", value1, value2, "transferTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andOverDueTimeIsNull() {
            addCriterion("OVER_DUE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOverDueTimeIsNotNull() {
            addCriterion("OVER_DUE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOverDueTimeEqualTo(Date value) {
            addCriterion("OVER_DUE_TIME =", value, "overDueTime");
            return (Criteria) this;
        }

        public Criteria andOverDueTimeNotEqualTo(Date value) {
            addCriterion("OVER_DUE_TIME <>", value, "overDueTime");
            return (Criteria) this;
        }

        public Criteria andOverDueTimeGreaterThan(Date value) {
            addCriterion("OVER_DUE_TIME >", value, "overDueTime");
            return (Criteria) this;
        }

        public Criteria andOverDueTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OVER_DUE_TIME >=", value, "overDueTime");
            return (Criteria) this;
        }

        public Criteria andOverDueTimeLessThan(Date value) {
            addCriterion("OVER_DUE_TIME <", value, "overDueTime");
            return (Criteria) this;
        }

        public Criteria andOverDueTimeLessThanOrEqualTo(Date value) {
            addCriterion("OVER_DUE_TIME <=", value, "overDueTime");
            return (Criteria) this;
        }

        public Criteria andOverDueTimeIn(List<Date> values) {
            addCriterion("OVER_DUE_TIME in", values, "overDueTime");
            return (Criteria) this;
        }

        public Criteria andOverDueTimeNotIn(List<Date> values) {
            addCriterion("OVER_DUE_TIME not in", values, "overDueTime");
            return (Criteria) this;
        }

        public Criteria andOverDueTimeBetween(Date value1, Date value2) {
            addCriterion("OVER_DUE_TIME between", value1, value2, "overDueTime");
            return (Criteria) this;
        }

        public Criteria andOverDueTimeNotBetween(Date value1, Date value2) {
            addCriterion("OVER_DUE_TIME not between", value1, value2, "overDueTime");
            return (Criteria) this;
        }

        public Criteria andInterestAmountIsNull() {
            addCriterion("INTEREST_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andInterestAmountIsNotNull() {
            addCriterion("INTEREST_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andInterestAmountEqualTo(BigDecimal value) {
            addCriterion("INTEREST_AMOUNT =", value, "interestAmount");
            return (Criteria) this;
        }

        public Criteria andInterestAmountNotEqualTo(BigDecimal value) {
            addCriterion("INTEREST_AMOUNT <>", value, "interestAmount");
            return (Criteria) this;
        }

        public Criteria andInterestAmountGreaterThan(BigDecimal value) {
            addCriterion("INTEREST_AMOUNT >", value, "interestAmount");
            return (Criteria) this;
        }

        public Criteria andInterestAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INTEREST_AMOUNT >=", value, "interestAmount");
            return (Criteria) this;
        }

        public Criteria andInterestAmountLessThan(BigDecimal value) {
            addCriterion("INTEREST_AMOUNT <", value, "interestAmount");
            return (Criteria) this;
        }

        public Criteria andInterestAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INTEREST_AMOUNT <=", value, "interestAmount");
            return (Criteria) this;
        }

        public Criteria andInterestAmountIn(List<BigDecimal> values) {
            addCriterion("INTEREST_AMOUNT in", values, "interestAmount");
            return (Criteria) this;
        }

        public Criteria andInterestAmountNotIn(List<BigDecimal> values) {
            addCriterion("INTEREST_AMOUNT not in", values, "interestAmount");
            return (Criteria) this;
        }

        public Criteria andInterestAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INTEREST_AMOUNT between", value1, value2, "interestAmount");
            return (Criteria) this;
        }

        public Criteria andInterestAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INTEREST_AMOUNT not between", value1, value2, "interestAmount");
            return (Criteria) this;
        }

        public Criteria andBorrowDaysIsNull() {
            addCriterion("BORROW_DAYS is null");
            return (Criteria) this;
        }

        public Criteria andBorrowDaysIsNotNull() {
            addCriterion("BORROW_DAYS is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowDaysEqualTo(BigDecimal value) {
            addCriterion("BORROW_DAYS =", value, "borrowDays");
            return (Criteria) this;
        }

        public Criteria andBorrowDaysNotEqualTo(BigDecimal value) {
            addCriterion("BORROW_DAYS <>", value, "borrowDays");
            return (Criteria) this;
        }

        public Criteria andBorrowDaysGreaterThan(BigDecimal value) {
            addCriterion("BORROW_DAYS >", value, "borrowDays");
            return (Criteria) this;
        }

        public Criteria andBorrowDaysGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BORROW_DAYS >=", value, "borrowDays");
            return (Criteria) this;
        }

        public Criteria andBorrowDaysLessThan(BigDecimal value) {
            addCriterion("BORROW_DAYS <", value, "borrowDays");
            return (Criteria) this;
        }

        public Criteria andBorrowDaysLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BORROW_DAYS <=", value, "borrowDays");
            return (Criteria) this;
        }

        public Criteria andBorrowDaysIn(List<BigDecimal> values) {
            addCriterion("BORROW_DAYS in", values, "borrowDays");
            return (Criteria) this;
        }

        public Criteria andBorrowDaysNotIn(List<BigDecimal> values) {
            addCriterion("BORROW_DAYS not in", values, "borrowDays");
            return (Criteria) this;
        }

        public Criteria andBorrowDaysBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BORROW_DAYS between", value1, value2, "borrowDays");
            return (Criteria) this;
        }

        public Criteria andBorrowDaysNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BORROW_DAYS not between", value1, value2, "borrowDays");
            return (Criteria) this;
        }

        public Criteria andServiceAmountIsNull() {
            addCriterion("SERVICE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andServiceAmountIsNotNull() {
            addCriterion("SERVICE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andServiceAmountEqualTo(BigDecimal value) {
            addCriterion("SERVICE_AMOUNT =", value, "serviceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAmountNotEqualTo(BigDecimal value) {
            addCriterion("SERVICE_AMOUNT <>", value, "serviceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAmountGreaterThan(BigDecimal value) {
            addCriterion("SERVICE_AMOUNT >", value, "serviceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SERVICE_AMOUNT >=", value, "serviceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAmountLessThan(BigDecimal value) {
            addCriterion("SERVICE_AMOUNT <", value, "serviceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SERVICE_AMOUNT <=", value, "serviceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAmountIn(List<BigDecimal> values) {
            addCriterion("SERVICE_AMOUNT in", values, "serviceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAmountNotIn(List<BigDecimal> values) {
            addCriterion("SERVICE_AMOUNT not in", values, "serviceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SERVICE_AMOUNT between", value1, value2, "serviceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SERVICE_AMOUNT not between", value1, value2, "serviceAmount");
            return (Criteria) this;
        }

        public Criteria andInterestRateDayIsNull() {
            addCriterion("INTEREST_RATE_DAY is null");
            return (Criteria) this;
        }

        public Criteria andInterestRateDayIsNotNull() {
            addCriterion("INTEREST_RATE_DAY is not null");
            return (Criteria) this;
        }

        public Criteria andInterestRateDayEqualTo(BigDecimal value) {
            addCriterion("INTEREST_RATE_DAY =", value, "interestRateDay");
            return (Criteria) this;
        }

        public Criteria andInterestRateDayNotEqualTo(BigDecimal value) {
            addCriterion("INTEREST_RATE_DAY <>", value, "interestRateDay");
            return (Criteria) this;
        }

        public Criteria andInterestRateDayGreaterThan(BigDecimal value) {
            addCriterion("INTEREST_RATE_DAY >", value, "interestRateDay");
            return (Criteria) this;
        }

        public Criteria andInterestRateDayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INTEREST_RATE_DAY >=", value, "interestRateDay");
            return (Criteria) this;
        }

        public Criteria andInterestRateDayLessThan(BigDecimal value) {
            addCriterion("INTEREST_RATE_DAY <", value, "interestRateDay");
            return (Criteria) this;
        }

        public Criteria andInterestRateDayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INTEREST_RATE_DAY <=", value, "interestRateDay");
            return (Criteria) this;
        }

        public Criteria andInterestRateDayIn(List<BigDecimal> values) {
            addCriterion("INTEREST_RATE_DAY in", values, "interestRateDay");
            return (Criteria) this;
        }

        public Criteria andInterestRateDayNotIn(List<BigDecimal> values) {
            addCriterion("INTEREST_RATE_DAY not in", values, "interestRateDay");
            return (Criteria) this;
        }

        public Criteria andInterestRateDayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INTEREST_RATE_DAY between", value1, value2, "interestRateDay");
            return (Criteria) this;
        }

        public Criteria andInterestRateDayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INTEREST_RATE_DAY not between", value1, value2, "interestRateDay");
            return (Criteria) this;
        }

        public Criteria andRealAmountIsNull() {
            addCriterion("REAL_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andRealAmountIsNotNull() {
            addCriterion("REAL_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andRealAmountEqualTo(BigDecimal value) {
            addCriterion("REAL_AMOUNT =", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountNotEqualTo(BigDecimal value) {
            addCriterion("REAL_AMOUNT <>", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountGreaterThan(BigDecimal value) {
            addCriterion("REAL_AMOUNT >", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REAL_AMOUNT >=", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountLessThan(BigDecimal value) {
            addCriterion("REAL_AMOUNT <", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REAL_AMOUNT <=", value, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountIn(List<BigDecimal> values) {
            addCriterion("REAL_AMOUNT in", values, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountNotIn(List<BigDecimal> values) {
            addCriterion("REAL_AMOUNT not in", values, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REAL_AMOUNT between", value1, value2, "realAmount");
            return (Criteria) this;
        }

        public Criteria andRealAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REAL_AMOUNT not between", value1, value2, "realAmount");
            return (Criteria) this;
        }

        public Criteria andOverDueAmountIsNull() {
            addCriterion("OVER_DUE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andOverDueAmountIsNotNull() {
            addCriterion("OVER_DUE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andOverDueAmountEqualTo(BigDecimal value) {
            addCriterion("OVER_DUE_AMOUNT =", value, "overDueAmount");
            return (Criteria) this;
        }

        public Criteria andOverDueAmountNotEqualTo(BigDecimal value) {
            addCriterion("OVER_DUE_AMOUNT <>", value, "overDueAmount");
            return (Criteria) this;
        }

        public Criteria andOverDueAmountGreaterThan(BigDecimal value) {
            addCriterion("OVER_DUE_AMOUNT >", value, "overDueAmount");
            return (Criteria) this;
        }

        public Criteria andOverDueAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OVER_DUE_AMOUNT >=", value, "overDueAmount");
            return (Criteria) this;
        }

        public Criteria andOverDueAmountLessThan(BigDecimal value) {
            addCriterion("OVER_DUE_AMOUNT <", value, "overDueAmount");
            return (Criteria) this;
        }

        public Criteria andOverDueAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OVER_DUE_AMOUNT <=", value, "overDueAmount");
            return (Criteria) this;
        }

        public Criteria andOverDueAmountIn(List<BigDecimal> values) {
            addCriterion("OVER_DUE_AMOUNT in", values, "overDueAmount");
            return (Criteria) this;
        }

        public Criteria andOverDueAmountNotIn(List<BigDecimal> values) {
            addCriterion("OVER_DUE_AMOUNT not in", values, "overDueAmount");
            return (Criteria) this;
        }

        public Criteria andOverDueAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OVER_DUE_AMOUNT between", value1, value2, "overDueAmount");
            return (Criteria) this;
        }

        public Criteria andOverDueAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OVER_DUE_AMOUNT not between", value1, value2, "overDueAmount");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeIsNull() {
            addCriterion("ORGANIZATION_CODE is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeIsNotNull() {
            addCriterion("ORGANIZATION_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeEqualTo(String value) {
            addCriterion("ORGANIZATION_CODE =", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeNotEqualTo(String value) {
            addCriterion("ORGANIZATION_CODE <>", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeGreaterThan(String value) {
            addCriterion("ORGANIZATION_CODE >", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ORGANIZATION_CODE >=", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeLessThan(String value) {
            addCriterion("ORGANIZATION_CODE <", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeLessThanOrEqualTo(String value) {
            addCriterion("ORGANIZATION_CODE <=", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeLike(String value) {
            addCriterion("ORGANIZATION_CODE like", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeNotLike(String value) {
            addCriterion("ORGANIZATION_CODE not like", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeIn(List<String> values) {
            addCriterion("ORGANIZATION_CODE in", values, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeNotIn(List<String> values) {
            addCriterion("ORGANIZATION_CODE not in", values, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeBetween(String value1, String value2) {
            addCriterion("ORGANIZATION_CODE between", value1, value2, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeNotBetween(String value1, String value2) {
            addCriterion("ORGANIZATION_CODE not between", value1, value2, "organizationCode");
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

        public Criteria andRepaymentTimeIsNull() {
            addCriterion("REPAYMENT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimeIsNotNull() {
            addCriterion("REPAYMENT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimeEqualTo(Date value) {
            addCriterion("REPAYMENT_TIME =", value, "repaymentTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimeNotEqualTo(Date value) {
            addCriterion("REPAYMENT_TIME <>", value, "repaymentTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimeGreaterThan(Date value) {
            addCriterion("REPAYMENT_TIME >", value, "repaymentTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("REPAYMENT_TIME >=", value, "repaymentTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimeLessThan(Date value) {
            addCriterion("REPAYMENT_TIME <", value, "repaymentTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimeLessThanOrEqualTo(Date value) {
            addCriterion("REPAYMENT_TIME <=", value, "repaymentTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimeIn(List<Date> values) {
            addCriterion("REPAYMENT_TIME in", values, "repaymentTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimeNotIn(List<Date> values) {
            addCriterion("REPAYMENT_TIME not in", values, "repaymentTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimeBetween(Date value1, Date value2) {
            addCriterion("REPAYMENT_TIME between", value1, value2, "repaymentTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentTimeNotBetween(Date value1, Date value2) {
            addCriterion("REPAYMENT_TIME not between", value1, value2, "repaymentTime");
            return (Criteria) this;
        }

        public Criteria andDueRepaymentTimeIsNull() {
            addCriterion("DUE_REPAYMENT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDueRepaymentTimeIsNotNull() {
            addCriterion("DUE_REPAYMENT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDueRepaymentTimeEqualTo(Date value) {
            addCriterion("DUE_REPAYMENT_TIME =", value, "dueRepaymentTime");
            return (Criteria) this;
        }

        public Criteria andDueRepaymentTimeNotEqualTo(Date value) {
            addCriterion("DUE_REPAYMENT_TIME <>", value, "dueRepaymentTime");
            return (Criteria) this;
        }

        public Criteria andDueRepaymentTimeGreaterThan(Date value) {
            addCriterion("DUE_REPAYMENT_TIME >", value, "dueRepaymentTime");
            return (Criteria) this;
        }

        public Criteria andDueRepaymentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DUE_REPAYMENT_TIME >=", value, "dueRepaymentTime");
            return (Criteria) this;
        }

        public Criteria andDueRepaymentTimeLessThan(Date value) {
            addCriterion("DUE_REPAYMENT_TIME <", value, "dueRepaymentTime");
            return (Criteria) this;
        }

        public Criteria andDueRepaymentTimeLessThanOrEqualTo(Date value) {
            addCriterion("DUE_REPAYMENT_TIME <=", value, "dueRepaymentTime");
            return (Criteria) this;
        }

        public Criteria andDueRepaymentTimeIn(List<Date> values) {
            addCriterion("DUE_REPAYMENT_TIME in", values, "dueRepaymentTime");
            return (Criteria) this;
        }

        public Criteria andDueRepaymentTimeNotIn(List<Date> values) {
            addCriterion("DUE_REPAYMENT_TIME not in", values, "dueRepaymentTime");
            return (Criteria) this;
        }

        public Criteria andDueRepaymentTimeBetween(Date value1, Date value2) {
            addCriterion("DUE_REPAYMENT_TIME between", value1, value2, "dueRepaymentTime");
            return (Criteria) this;
        }

        public Criteria andDueRepaymentTimeNotBetween(Date value1, Date value2) {
            addCriterion("DUE_REPAYMENT_TIME not between", value1, value2, "dueRepaymentTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}