package com.shengpay.debit.dal.dataobject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TbWithholdingOrderInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbWithholdingOrderInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected TbWithholdingOrderInfoExample(TbWithholdingOrderInfoExample example) {
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

        public Criteria andMerchantOrderNoIsNull() {
            addCriterion("MERCHANT_ORDER_NO is null");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoIsNotNull() {
            addCriterion("MERCHANT_ORDER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoEqualTo(String value) {
            addCriterion("MERCHANT_ORDER_NO =", value, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoNotEqualTo(String value) {
            addCriterion("MERCHANT_ORDER_NO <>", value, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoGreaterThan(String value) {
            addCriterion("MERCHANT_ORDER_NO >", value, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_ORDER_NO >=", value, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoLessThan(String value) {
            addCriterion("MERCHANT_ORDER_NO <", value, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_ORDER_NO <=", value, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoLike(String value) {
            addCriterion("MERCHANT_ORDER_NO like", value, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoNotLike(String value) {
            addCriterion("MERCHANT_ORDER_NO not like", value, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoIn(List<String> values) {
            addCriterion("MERCHANT_ORDER_NO in", values, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoNotIn(List<String> values) {
            addCriterion("MERCHANT_ORDER_NO not in", values, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoBetween(String value1, String value2) {
            addCriterion("MERCHANT_ORDER_NO between", value1, value2, "merchantOrderNo");
            return (Criteria) this;
        }

        public Criteria andMerchantOrderNoNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_ORDER_NO not between", value1, value2, "merchantOrderNo");
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

        public Criteria andBatchNoIsNull() {
            addCriterion("BATCH_NO is null");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNotNull() {
            addCriterion("BATCH_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("BATCH_NO =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotEqualTo(String value) {
            addCriterion("BATCH_NO <>", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThan(String value) {
            addCriterion("BATCH_NO >", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("BATCH_NO >=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThan(String value) {
            addCriterion("BATCH_NO <", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThanOrEqualTo(String value) {
            addCriterion("BATCH_NO <=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLike(String value) {
            addCriterion("BATCH_NO like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotLike(String value) {
            addCriterion("BATCH_NO not like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoIn(List<String> values) {
            addCriterion("BATCH_NO in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotIn(List<String> values) {
            addCriterion("BATCH_NO not in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoBetween(String value1, String value2) {
            addCriterion("BATCH_NO between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotBetween(String value1, String value2) {
            addCriterion("BATCH_NO not between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNull() {
            addCriterion("ORDER_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNotNull() {
            addCriterion("ORDER_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountEqualTo(BigDecimal value) {
            addCriterion("ORDER_AMOUNT =", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotEqualTo(BigDecimal value) {
            addCriterion("ORDER_AMOUNT <>", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThan(BigDecimal value) {
            addCriterion("ORDER_AMOUNT >", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ORDER_AMOUNT >=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThan(BigDecimal value) {
            addCriterion("ORDER_AMOUNT <", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ORDER_AMOUNT <=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIn(List<BigDecimal> values) {
            addCriterion("ORDER_AMOUNT in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotIn(List<BigDecimal> values) {
            addCriterion("ORDER_AMOUNT not in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORDER_AMOUNT between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORDER_AMOUNT not between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("BANK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("BANK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("BANK_NAME =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("BANK_NAME <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("BANK_NAME >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_NAME >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("BANK_NAME <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("BANK_NAME <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("BANK_NAME like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("BANK_NAME not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("BANK_NAME in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("BANK_NAME not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("BANK_NAME between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("BANK_NAME not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andChNameIsNull() {
            addCriterion("CH_NAME is null");
            return (Criteria) this;
        }

        public Criteria andChNameIsNotNull() {
            addCriterion("CH_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andChNameEqualTo(String value) {
            addCriterion("CH_NAME =", value, "chName");
            return (Criteria) this;
        }

        public Criteria andChNameNotEqualTo(String value) {
            addCriterion("CH_NAME <>", value, "chName");
            return (Criteria) this;
        }

        public Criteria andChNameGreaterThan(String value) {
            addCriterion("CH_NAME >", value, "chName");
            return (Criteria) this;
        }

        public Criteria andChNameGreaterThanOrEqualTo(String value) {
            addCriterion("CH_NAME >=", value, "chName");
            return (Criteria) this;
        }

        public Criteria andChNameLessThan(String value) {
            addCriterion("CH_NAME <", value, "chName");
            return (Criteria) this;
        }

        public Criteria andChNameLessThanOrEqualTo(String value) {
            addCriterion("CH_NAME <=", value, "chName");
            return (Criteria) this;
        }

        public Criteria andChNameLike(String value) {
            addCriterion("CH_NAME like", value, "chName");
            return (Criteria) this;
        }

        public Criteria andChNameNotLike(String value) {
            addCriterion("CH_NAME not like", value, "chName");
            return (Criteria) this;
        }

        public Criteria andChNameIn(List<String> values) {
            addCriterion("CH_NAME in", values, "chName");
            return (Criteria) this;
        }

        public Criteria andChNameNotIn(List<String> values) {
            addCriterion("CH_NAME not in", values, "chName");
            return (Criteria) this;
        }

        public Criteria andChNameBetween(String value1, String value2) {
            addCriterion("CH_NAME between", value1, value2, "chName");
            return (Criteria) this;
        }

        public Criteria andChNameNotBetween(String value1, String value2) {
            addCriterion("CH_NAME not between", value1, value2, "chName");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNull() {
            addCriterion("CARD_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNotNull() {
            addCriterion("CARD_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCardTypeEqualTo(String value) {
            addCriterion("CARD_TYPE =", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotEqualTo(String value) {
            addCriterion("CARD_TYPE <>", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThan(String value) {
            addCriterion("CARD_TYPE >", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CARD_TYPE >=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThan(String value) {
            addCriterion("CARD_TYPE <", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThanOrEqualTo(String value) {
            addCriterion("CARD_TYPE <=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLike(String value) {
            addCriterion("CARD_TYPE like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotLike(String value) {
            addCriterion("CARD_TYPE not like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIn(List<String> values) {
            addCriterion("CARD_TYPE in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotIn(List<String> values) {
            addCriterion("CARD_TYPE not in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeBetween(String value1, String value2) {
            addCriterion("CARD_TYPE between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotBetween(String value1, String value2) {
            addCriterion("CARD_TYPE not between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNull() {
            addCriterion("CARD_NO is null");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNotNull() {
            addCriterion("CARD_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCardNoEqualTo(String value) {
            addCriterion("CARD_NO =", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotEqualTo(String value) {
            addCriterion("CARD_NO <>", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThan(String value) {
            addCriterion("CARD_NO >", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("CARD_NO >=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThan(String value) {
            addCriterion("CARD_NO <", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThanOrEqualTo(String value) {
            addCriterion("CARD_NO <=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLike(String value) {
            addCriterion("CARD_NO like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotLike(String value) {
            addCriterion("CARD_NO not like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoIn(List<String> values) {
            addCriterion("CARD_NO in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotIn(List<String> values) {
            addCriterion("CARD_NO not in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoBetween(String value1, String value2) {
            addCriterion("CARD_NO between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotBetween(String value1, String value2) {
            addCriterion("CARD_NO not between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andPaperTypeIsNull() {
            addCriterion("PAPER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPaperTypeIsNotNull() {
            addCriterion("PAPER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPaperTypeEqualTo(String value) {
            addCriterion("PAPER_TYPE =", value, "paperType");
            return (Criteria) this;
        }

        public Criteria andPaperTypeNotEqualTo(String value) {
            addCriterion("PAPER_TYPE <>", value, "paperType");
            return (Criteria) this;
        }

        public Criteria andPaperTypeGreaterThan(String value) {
            addCriterion("PAPER_TYPE >", value, "paperType");
            return (Criteria) this;
        }

        public Criteria andPaperTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PAPER_TYPE >=", value, "paperType");
            return (Criteria) this;
        }

        public Criteria andPaperTypeLessThan(String value) {
            addCriterion("PAPER_TYPE <", value, "paperType");
            return (Criteria) this;
        }

        public Criteria andPaperTypeLessThanOrEqualTo(String value) {
            addCriterion("PAPER_TYPE <=", value, "paperType");
            return (Criteria) this;
        }

        public Criteria andPaperTypeLike(String value) {
            addCriterion("PAPER_TYPE like", value, "paperType");
            return (Criteria) this;
        }

        public Criteria andPaperTypeNotLike(String value) {
            addCriterion("PAPER_TYPE not like", value, "paperType");
            return (Criteria) this;
        }

        public Criteria andPaperTypeIn(List<String> values) {
            addCriterion("PAPER_TYPE in", values, "paperType");
            return (Criteria) this;
        }

        public Criteria andPaperTypeNotIn(List<String> values) {
            addCriterion("PAPER_TYPE not in", values, "paperType");
            return (Criteria) this;
        }

        public Criteria andPaperTypeBetween(String value1, String value2) {
            addCriterion("PAPER_TYPE between", value1, value2, "paperType");
            return (Criteria) this;
        }

        public Criteria andPaperTypeNotBetween(String value1, String value2) {
            addCriterion("PAPER_TYPE not between", value1, value2, "paperType");
            return (Criteria) this;
        }

        public Criteria andPaperNoIsNull() {
            addCriterion("PAPER_NO is null");
            return (Criteria) this;
        }

        public Criteria andPaperNoIsNotNull() {
            addCriterion("PAPER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPaperNoEqualTo(String value) {
            addCriterion("PAPER_NO =", value, "paperNo");
            return (Criteria) this;
        }

        public Criteria andPaperNoNotEqualTo(String value) {
            addCriterion("PAPER_NO <>", value, "paperNo");
            return (Criteria) this;
        }

        public Criteria andPaperNoGreaterThan(String value) {
            addCriterion("PAPER_NO >", value, "paperNo");
            return (Criteria) this;
        }

        public Criteria andPaperNoGreaterThanOrEqualTo(String value) {
            addCriterion("PAPER_NO >=", value, "paperNo");
            return (Criteria) this;
        }

        public Criteria andPaperNoLessThan(String value) {
            addCriterion("PAPER_NO <", value, "paperNo");
            return (Criteria) this;
        }

        public Criteria andPaperNoLessThanOrEqualTo(String value) {
            addCriterion("PAPER_NO <=", value, "paperNo");
            return (Criteria) this;
        }

        public Criteria andPaperNoLike(String value) {
            addCriterion("PAPER_NO like", value, "paperNo");
            return (Criteria) this;
        }

        public Criteria andPaperNoNotLike(String value) {
            addCriterion("PAPER_NO not like", value, "paperNo");
            return (Criteria) this;
        }

        public Criteria andPaperNoIn(List<String> values) {
            addCriterion("PAPER_NO in", values, "paperNo");
            return (Criteria) this;
        }

        public Criteria andPaperNoNotIn(List<String> values) {
            addCriterion("PAPER_NO not in", values, "paperNo");
            return (Criteria) this;
        }

        public Criteria andPaperNoBetween(String value1, String value2) {
            addCriterion("PAPER_NO between", value1, value2, "paperNo");
            return (Criteria) this;
        }

        public Criteria andPaperNoNotBetween(String value1, String value2) {
            addCriterion("PAPER_NO not between", value1, value2, "paperNo");
            return (Criteria) this;
        }

        public Criteria andPostscriptIsNull() {
            addCriterion("POSTSCRIPT is null");
            return (Criteria) this;
        }

        public Criteria andPostscriptIsNotNull() {
            addCriterion("POSTSCRIPT is not null");
            return (Criteria) this;
        }

        public Criteria andPostscriptEqualTo(String value) {
            addCriterion("POSTSCRIPT =", value, "postscript");
            return (Criteria) this;
        }

        public Criteria andPostscriptNotEqualTo(String value) {
            addCriterion("POSTSCRIPT <>", value, "postscript");
            return (Criteria) this;
        }

        public Criteria andPostscriptGreaterThan(String value) {
            addCriterion("POSTSCRIPT >", value, "postscript");
            return (Criteria) this;
        }

        public Criteria andPostscriptGreaterThanOrEqualTo(String value) {
            addCriterion("POSTSCRIPT >=", value, "postscript");
            return (Criteria) this;
        }

        public Criteria andPostscriptLessThan(String value) {
            addCriterion("POSTSCRIPT <", value, "postscript");
            return (Criteria) this;
        }

        public Criteria andPostscriptLessThanOrEqualTo(String value) {
            addCriterion("POSTSCRIPT <=", value, "postscript");
            return (Criteria) this;
        }

        public Criteria andPostscriptLike(String value) {
            addCriterion("POSTSCRIPT like", value, "postscript");
            return (Criteria) this;
        }

        public Criteria andPostscriptNotLike(String value) {
            addCriterion("POSTSCRIPT not like", value, "postscript");
            return (Criteria) this;
        }

        public Criteria andPostscriptIn(List<String> values) {
            addCriterion("POSTSCRIPT in", values, "postscript");
            return (Criteria) this;
        }

        public Criteria andPostscriptNotIn(List<String> values) {
            addCriterion("POSTSCRIPT not in", values, "postscript");
            return (Criteria) this;
        }

        public Criteria andPostscriptBetween(String value1, String value2) {
            addCriterion("POSTSCRIPT between", value1, value2, "postscript");
            return (Criteria) this;
        }

        public Criteria andPostscriptNotBetween(String value1, String value2) {
            addCriterion("POSTSCRIPT not between", value1, value2, "postscript");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
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

        public Criteria andSucessTimeIsNull() {
            addCriterion("SUCESS_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSucessTimeIsNotNull() {
            addCriterion("SUCESS_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSucessTimeEqualTo(Date value) {
            addCriterion("SUCESS_TIME =", value, "sucessTime");
            return (Criteria) this;
        }

        public Criteria andSucessTimeNotEqualTo(Date value) {
            addCriterion("SUCESS_TIME <>", value, "sucessTime");
            return (Criteria) this;
        }

        public Criteria andSucessTimeGreaterThan(Date value) {
            addCriterion("SUCESS_TIME >", value, "sucessTime");
            return (Criteria) this;
        }

        public Criteria andSucessTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SUCESS_TIME >=", value, "sucessTime");
            return (Criteria) this;
        }

        public Criteria andSucessTimeLessThan(Date value) {
            addCriterion("SUCESS_TIME <", value, "sucessTime");
            return (Criteria) this;
        }

        public Criteria andSucessTimeLessThanOrEqualTo(Date value) {
            addCriterion("SUCESS_TIME <=", value, "sucessTime");
            return (Criteria) this;
        }

        public Criteria andSucessTimeIn(List<Date> values) {
            addCriterion("SUCESS_TIME in", values, "sucessTime");
            return (Criteria) this;
        }

        public Criteria andSucessTimeNotIn(List<Date> values) {
            addCriterion("SUCESS_TIME not in", values, "sucessTime");
            return (Criteria) this;
        }

        public Criteria andSucessTimeBetween(Date value1, Date value2) {
            addCriterion("SUCESS_TIME between", value1, value2, "sucessTime");
            return (Criteria) this;
        }

        public Criteria andSucessTimeNotBetween(Date value1, Date value2) {
            addCriterion("SUCESS_TIME not between", value1, value2, "sucessTime");
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

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andExtIsNull() {
            addCriterion("EXT is null");
            return (Criteria) this;
        }

        public Criteria andExtIsNotNull() {
            addCriterion("EXT is not null");
            return (Criteria) this;
        }

        public Criteria andExtEqualTo(String value) {
            addCriterion("EXT =", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtNotEqualTo(String value) {
            addCriterion("EXT <>", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtGreaterThan(String value) {
            addCriterion("EXT >", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtGreaterThanOrEqualTo(String value) {
            addCriterion("EXT >=", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtLessThan(String value) {
            addCriterion("EXT <", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtLessThanOrEqualTo(String value) {
            addCriterion("EXT <=", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtLike(String value) {
            addCriterion("EXT like", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtNotLike(String value) {
            addCriterion("EXT not like", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtIn(List<String> values) {
            addCriterion("EXT in", values, "ext");
            return (Criteria) this;
        }

        public Criteria andExtNotIn(List<String> values) {
            addCriterion("EXT not in", values, "ext");
            return (Criteria) this;
        }

        public Criteria andExtBetween(String value1, String value2) {
            addCriterion("EXT between", value1, value2, "ext");
            return (Criteria) this;
        }

        public Criteria andExtNotBetween(String value1, String value2) {
            addCriterion("EXT not between", value1, value2, "ext");
            return (Criteria) this;
        }

        public Criteria andInitordernoIsNull() {
            addCriterion("INITORDERNO is null");
            return (Criteria) this;
        }

        public Criteria andInitordernoIsNotNull() {
            addCriterion("INITORDERNO is not null");
            return (Criteria) this;
        }

        public Criteria andInitordernoEqualTo(String value) {
            addCriterion("INITORDERNO =", value, "initorderno");
            return (Criteria) this;
        }

        public Criteria andInitordernoNotEqualTo(String value) {
            addCriterion("INITORDERNO <>", value, "initorderno");
            return (Criteria) this;
        }

        public Criteria andInitordernoGreaterThan(String value) {
            addCriterion("INITORDERNO >", value, "initorderno");
            return (Criteria) this;
        }

        public Criteria andInitordernoGreaterThanOrEqualTo(String value) {
            addCriterion("INITORDERNO >=", value, "initorderno");
            return (Criteria) this;
        }

        public Criteria andInitordernoLessThan(String value) {
            addCriterion("INITORDERNO <", value, "initorderno");
            return (Criteria) this;
        }

        public Criteria andInitordernoLessThanOrEqualTo(String value) {
            addCriterion("INITORDERNO <=", value, "initorderno");
            return (Criteria) this;
        }

        public Criteria andInitordernoLike(String value) {
            addCriterion("INITORDERNO like", value, "initorderno");
            return (Criteria) this;
        }

        public Criteria andInitordernoNotLike(String value) {
            addCriterion("INITORDERNO not like", value, "initorderno");
            return (Criteria) this;
        }

        public Criteria andInitordernoIn(List<String> values) {
            addCriterion("INITORDERNO in", values, "initorderno");
            return (Criteria) this;
        }

        public Criteria andInitordernoNotIn(List<String> values) {
            addCriterion("INITORDERNO not in", values, "initorderno");
            return (Criteria) this;
        }

        public Criteria andInitordernoBetween(String value1, String value2) {
            addCriterion("INITORDERNO between", value1, value2, "initorderno");
            return (Criteria) this;
        }

        public Criteria andInitordernoNotBetween(String value1, String value2) {
            addCriterion("INITORDERNO not between", value1, value2, "initorderno");
            return (Criteria) this;
        }

        public Criteria andFailordernoIsNull() {
            addCriterion("FAILORDERNO is null");
            return (Criteria) this;
        }

        public Criteria andFailordernoIsNotNull() {
            addCriterion("FAILORDERNO is not null");
            return (Criteria) this;
        }

        public Criteria andFailordernoEqualTo(String value) {
            addCriterion("FAILORDERNO =", value, "failorderno");
            return (Criteria) this;
        }

        public Criteria andFailordernoNotEqualTo(String value) {
            addCriterion("FAILORDERNO <>", value, "failorderno");
            return (Criteria) this;
        }

        public Criteria andFailordernoGreaterThan(String value) {
            addCriterion("FAILORDERNO >", value, "failorderno");
            return (Criteria) this;
        }

        public Criteria andFailordernoGreaterThanOrEqualTo(String value) {
            addCriterion("FAILORDERNO >=", value, "failorderno");
            return (Criteria) this;
        }

        public Criteria andFailordernoLessThan(String value) {
            addCriterion("FAILORDERNO <", value, "failorderno");
            return (Criteria) this;
        }

        public Criteria andFailordernoLessThanOrEqualTo(String value) {
            addCriterion("FAILORDERNO <=", value, "failorderno");
            return (Criteria) this;
        }

        public Criteria andFailordernoLike(String value) {
            addCriterion("FAILORDERNO like", value, "failorderno");
            return (Criteria) this;
        }

        public Criteria andFailordernoNotLike(String value) {
            addCriterion("FAILORDERNO not like", value, "failorderno");
            return (Criteria) this;
        }

        public Criteria andFailordernoIn(List<String> values) {
            addCriterion("FAILORDERNO in", values, "failorderno");
            return (Criteria) this;
        }

        public Criteria andFailordernoNotIn(List<String> values) {
            addCriterion("FAILORDERNO not in", values, "failorderno");
            return (Criteria) this;
        }

        public Criteria andFailordernoBetween(String value1, String value2) {
            addCriterion("FAILORDERNO between", value1, value2, "failorderno");
            return (Criteria) this;
        }

        public Criteria andFailordernoNotBetween(String value1, String value2) {
            addCriterion("FAILORDERNO not between", value1, value2, "failorderno");
            return (Criteria) this;
        }

        public Criteria andErrorcodeIsNull() {
            addCriterion("ERRORCODE is null");
            return (Criteria) this;
        }

        public Criteria andErrorcodeIsNotNull() {
            addCriterion("ERRORCODE is not null");
            return (Criteria) this;
        }

        public Criteria andErrorcodeEqualTo(String value) {
            addCriterion("ERRORCODE =", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeNotEqualTo(String value) {
            addCriterion("ERRORCODE <>", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeGreaterThan(String value) {
            addCriterion("ERRORCODE >", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeGreaterThanOrEqualTo(String value) {
            addCriterion("ERRORCODE >=", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeLessThan(String value) {
            addCriterion("ERRORCODE <", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeLessThanOrEqualTo(String value) {
            addCriterion("ERRORCODE <=", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeLike(String value) {
            addCriterion("ERRORCODE like", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeNotLike(String value) {
            addCriterion("ERRORCODE not like", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeIn(List<String> values) {
            addCriterion("ERRORCODE in", values, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeNotIn(List<String> values) {
            addCriterion("ERRORCODE not in", values, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeBetween(String value1, String value2) {
            addCriterion("ERRORCODE between", value1, value2, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeNotBetween(String value1, String value2) {
            addCriterion("ERRORCODE not between", value1, value2, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrormsgIsNull() {
            addCriterion("ERRORMSG is null");
            return (Criteria) this;
        }

        public Criteria andErrormsgIsNotNull() {
            addCriterion("ERRORMSG is not null");
            return (Criteria) this;
        }

        public Criteria andErrormsgEqualTo(String value) {
            addCriterion("ERRORMSG =", value, "errormsg");
            return (Criteria) this;
        }

        public Criteria andErrormsgNotEqualTo(String value) {
            addCriterion("ERRORMSG <>", value, "errormsg");
            return (Criteria) this;
        }

        public Criteria andErrormsgGreaterThan(String value) {
            addCriterion("ERRORMSG >", value, "errormsg");
            return (Criteria) this;
        }

        public Criteria andErrormsgGreaterThanOrEqualTo(String value) {
            addCriterion("ERRORMSG >=", value, "errormsg");
            return (Criteria) this;
        }

        public Criteria andErrormsgLessThan(String value) {
            addCriterion("ERRORMSG <", value, "errormsg");
            return (Criteria) this;
        }

        public Criteria andErrormsgLessThanOrEqualTo(String value) {
            addCriterion("ERRORMSG <=", value, "errormsg");
            return (Criteria) this;
        }

        public Criteria andErrormsgLike(String value) {
            addCriterion("ERRORMSG like", value, "errormsg");
            return (Criteria) this;
        }

        public Criteria andErrormsgNotLike(String value) {
            addCriterion("ERRORMSG not like", value, "errormsg");
            return (Criteria) this;
        }

        public Criteria andErrormsgIn(List<String> values) {
            addCriterion("ERRORMSG in", values, "errormsg");
            return (Criteria) this;
        }

        public Criteria andErrormsgNotIn(List<String> values) {
            addCriterion("ERRORMSG not in", values, "errormsg");
            return (Criteria) this;
        }

        public Criteria andErrormsgBetween(String value1, String value2) {
            addCriterion("ERRORMSG between", value1, value2, "errormsg");
            return (Criteria) this;
        }

        public Criteria andErrormsgNotBetween(String value1, String value2) {
            addCriterion("ERRORMSG not between", value1, value2, "errormsg");
            return (Criteria) this;
        }

        public Criteria andPayablefeeIsNull() {
            addCriterion("PAYABLEFEE is null");
            return (Criteria) this;
        }

        public Criteria andPayablefeeIsNotNull() {
            addCriterion("PAYABLEFEE is not null");
            return (Criteria) this;
        }

        public Criteria andPayablefeeEqualTo(String value) {
            addCriterion("PAYABLEFEE =", value, "payablefee");
            return (Criteria) this;
        }

        public Criteria andPayablefeeNotEqualTo(String value) {
            addCriterion("PAYABLEFEE <>", value, "payablefee");
            return (Criteria) this;
        }

        public Criteria andPayablefeeGreaterThan(String value) {
            addCriterion("PAYABLEFEE >", value, "payablefee");
            return (Criteria) this;
        }

        public Criteria andPayablefeeGreaterThanOrEqualTo(String value) {
            addCriterion("PAYABLEFEE >=", value, "payablefee");
            return (Criteria) this;
        }

        public Criteria andPayablefeeLessThan(String value) {
            addCriterion("PAYABLEFEE <", value, "payablefee");
            return (Criteria) this;
        }

        public Criteria andPayablefeeLessThanOrEqualTo(String value) {
            addCriterion("PAYABLEFEE <=", value, "payablefee");
            return (Criteria) this;
        }

        public Criteria andPayablefeeLike(String value) {
            addCriterion("PAYABLEFEE like", value, "payablefee");
            return (Criteria) this;
        }

        public Criteria andPayablefeeNotLike(String value) {
            addCriterion("PAYABLEFEE not like", value, "payablefee");
            return (Criteria) this;
        }

        public Criteria andPayablefeeIn(List<String> values) {
            addCriterion("PAYABLEFEE in", values, "payablefee");
            return (Criteria) this;
        }

        public Criteria andPayablefeeNotIn(List<String> values) {
            addCriterion("PAYABLEFEE not in", values, "payablefee");
            return (Criteria) this;
        }

        public Criteria andPayablefeeBetween(String value1, String value2) {
            addCriterion("PAYABLEFEE between", value1, value2, "payablefee");
            return (Criteria) this;
        }

        public Criteria andPayablefeeNotBetween(String value1, String value2) {
            addCriterion("PAYABLEFEE not between", value1, value2, "payablefee");
            return (Criteria) this;
        }

        public Criteria andReceivablefeeIsNull() {
            addCriterion("RECEIVABLEFEE is null");
            return (Criteria) this;
        }

        public Criteria andReceivablefeeIsNotNull() {
            addCriterion("RECEIVABLEFEE is not null");
            return (Criteria) this;
        }

        public Criteria andReceivablefeeEqualTo(String value) {
            addCriterion("RECEIVABLEFEE =", value, "receivablefee");
            return (Criteria) this;
        }

        public Criteria andReceivablefeeNotEqualTo(String value) {
            addCriterion("RECEIVABLEFEE <>", value, "receivablefee");
            return (Criteria) this;
        }

        public Criteria andReceivablefeeGreaterThan(String value) {
            addCriterion("RECEIVABLEFEE >", value, "receivablefee");
            return (Criteria) this;
        }

        public Criteria andReceivablefeeGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVABLEFEE >=", value, "receivablefee");
            return (Criteria) this;
        }

        public Criteria andReceivablefeeLessThan(String value) {
            addCriterion("RECEIVABLEFEE <", value, "receivablefee");
            return (Criteria) this;
        }

        public Criteria andReceivablefeeLessThanOrEqualTo(String value) {
            addCriterion("RECEIVABLEFEE <=", value, "receivablefee");
            return (Criteria) this;
        }

        public Criteria andReceivablefeeLike(String value) {
            addCriterion("RECEIVABLEFEE like", value, "receivablefee");
            return (Criteria) this;
        }

        public Criteria andReceivablefeeNotLike(String value) {
            addCriterion("RECEIVABLEFEE not like", value, "receivablefee");
            return (Criteria) this;
        }

        public Criteria andReceivablefeeIn(List<String> values) {
            addCriterion("RECEIVABLEFEE in", values, "receivablefee");
            return (Criteria) this;
        }

        public Criteria andReceivablefeeNotIn(List<String> values) {
            addCriterion("RECEIVABLEFEE not in", values, "receivablefee");
            return (Criteria) this;
        }

        public Criteria andReceivablefeeBetween(String value1, String value2) {
            addCriterion("RECEIVABLEFEE between", value1, value2, "receivablefee");
            return (Criteria) this;
        }

        public Criteria andReceivablefeeNotBetween(String value1, String value2) {
            addCriterion("RECEIVABLEFEE not between", value1, value2, "receivablefee");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("CURRENCY is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("CURRENCY is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("CURRENCY =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("CURRENCY <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("CURRENCY >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENCY >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("CURRENCY <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("CURRENCY <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("CURRENCY like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("CURRENCY not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("CURRENCY in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("CURRENCY not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("CURRENCY between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("CURRENCY not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andWalletnoIsNull() {
            addCriterion("WALLETNO is null");
            return (Criteria) this;
        }

        public Criteria andWalletnoIsNotNull() {
            addCriterion("WALLETNO is not null");
            return (Criteria) this;
        }

        public Criteria andWalletnoEqualTo(String value) {
            addCriterion("WALLETNO =", value, "walletno");
            return (Criteria) this;
        }

        public Criteria andWalletnoNotEqualTo(String value) {
            addCriterion("WALLETNO <>", value, "walletno");
            return (Criteria) this;
        }

        public Criteria andWalletnoGreaterThan(String value) {
            addCriterion("WALLETNO >", value, "walletno");
            return (Criteria) this;
        }

        public Criteria andWalletnoGreaterThanOrEqualTo(String value) {
            addCriterion("WALLETNO >=", value, "walletno");
            return (Criteria) this;
        }

        public Criteria andWalletnoLessThan(String value) {
            addCriterion("WALLETNO <", value, "walletno");
            return (Criteria) this;
        }

        public Criteria andWalletnoLessThanOrEqualTo(String value) {
            addCriterion("WALLETNO <=", value, "walletno");
            return (Criteria) this;
        }

        public Criteria andWalletnoLike(String value) {
            addCriterion("WALLETNO like", value, "walletno");
            return (Criteria) this;
        }

        public Criteria andWalletnoNotLike(String value) {
            addCriterion("WALLETNO not like", value, "walletno");
            return (Criteria) this;
        }

        public Criteria andWalletnoIn(List<String> values) {
            addCriterion("WALLETNO in", values, "walletno");
            return (Criteria) this;
        }

        public Criteria andWalletnoNotIn(List<String> values) {
            addCriterion("WALLETNO not in", values, "walletno");
            return (Criteria) this;
        }

        public Criteria andWalletnoBetween(String value1, String value2) {
            addCriterion("WALLETNO between", value1, value2, "walletno");
            return (Criteria) this;
        }

        public Criteria andWalletnoNotBetween(String value1, String value2) {
            addCriterion("WALLETNO not between", value1, value2, "walletno");
            return (Criteria) this;
        }

        public Criteria andPlanwithholddateIsNull() {
            addCriterion("PLANWITHHOLDDATE is null");
            return (Criteria) this;
        }

        public Criteria andPlanwithholddateIsNotNull() {
            addCriterion("PLANWITHHOLDDATE is not null");
            return (Criteria) this;
        }

        public Criteria andPlanwithholddateEqualTo(Date value) {
            addCriterion("PLANWITHHOLDDATE =", value, "planwithholddate");
            return (Criteria) this;
        }

        public Criteria andPlanwithholddateNotEqualTo(Date value) {
            addCriterion("PLANWITHHOLDDATE <>", value, "planwithholddate");
            return (Criteria) this;
        }

        public Criteria andPlanwithholddateGreaterThan(Date value) {
            addCriterion("PLANWITHHOLDDATE >", value, "planwithholddate");
            return (Criteria) this;
        }

        public Criteria andPlanwithholddateGreaterThanOrEqualTo(Date value) {
            addCriterion("PLANWITHHOLDDATE >=", value, "planwithholddate");
            return (Criteria) this;
        }

        public Criteria andPlanwithholddateLessThan(Date value) {
            addCriterion("PLANWITHHOLDDATE <", value, "planwithholddate");
            return (Criteria) this;
        }

        public Criteria andPlanwithholddateLessThanOrEqualTo(Date value) {
            addCriterion("PLANWITHHOLDDATE <=", value, "planwithholddate");
            return (Criteria) this;
        }

        public Criteria andPlanwithholddateIn(List<Date> values) {
            addCriterion("PLANWITHHOLDDATE in", values, "planwithholddate");
            return (Criteria) this;
        }

        public Criteria andPlanwithholddateNotIn(List<Date> values) {
            addCriterion("PLANWITHHOLDDATE not in", values, "planwithholddate");
            return (Criteria) this;
        }

        public Criteria andPlanwithholddateBetween(Date value1, Date value2) {
            addCriterion("PLANWITHHOLDDATE between", value1, value2, "planwithholddate");
            return (Criteria) this;
        }

        public Criteria andPlanwithholddateNotBetween(Date value1, Date value2) {
            addCriterion("PLANWITHHOLDDATE not between", value1, value2, "planwithholddate");
            return (Criteria) this;
        }

        public Criteria andMobelIsNull() {
            addCriterion("MOBEL is null");
            return (Criteria) this;
        }

        public Criteria andMobelIsNotNull() {
            addCriterion("MOBEL is not null");
            return (Criteria) this;
        }

        public Criteria andMobelEqualTo(String value) {
            addCriterion("MOBEL =", value, "mobel");
            return (Criteria) this;
        }

        public Criteria andMobelNotEqualTo(String value) {
            addCriterion("MOBEL <>", value, "mobel");
            return (Criteria) this;
        }

        public Criteria andMobelGreaterThan(String value) {
            addCriterion("MOBEL >", value, "mobel");
            return (Criteria) this;
        }

        public Criteria andMobelGreaterThanOrEqualTo(String value) {
            addCriterion("MOBEL >=", value, "mobel");
            return (Criteria) this;
        }

        public Criteria andMobelLessThan(String value) {
            addCriterion("MOBEL <", value, "mobel");
            return (Criteria) this;
        }

        public Criteria andMobelLessThanOrEqualTo(String value) {
            addCriterion("MOBEL <=", value, "mobel");
            return (Criteria) this;
        }

        public Criteria andMobelLike(String value) {
            addCriterion("MOBEL like", value, "mobel");
            return (Criteria) this;
        }

        public Criteria andMobelNotLike(String value) {
            addCriterion("MOBEL not like", value, "mobel");
            return (Criteria) this;
        }

        public Criteria andMobelIn(List<String> values) {
            addCriterion("MOBEL in", values, "mobel");
            return (Criteria) this;
        }

        public Criteria andMobelNotIn(List<String> values) {
            addCriterion("MOBEL not in", values, "mobel");
            return (Criteria) this;
        }

        public Criteria andMobelBetween(String value1, String value2) {
            addCriterion("MOBEL between", value1, value2, "mobel");
            return (Criteria) this;
        }

        public Criteria andMobelNotBetween(String value1, String value2) {
            addCriterion("MOBEL not between", value1, value2, "mobel");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNull() {
            addCriterion("MEMBERID is null");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNotNull() {
            addCriterion("MEMBERID is not null");
            return (Criteria) this;
        }

        public Criteria andMemberidEqualTo(String value) {
            addCriterion("MEMBERID =", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotEqualTo(String value) {
            addCriterion("MEMBERID <>", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThan(String value) {
            addCriterion("MEMBERID >", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThanOrEqualTo(String value) {
            addCriterion("MEMBERID >=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThan(String value) {
            addCriterion("MEMBERID <", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThanOrEqualTo(String value) {
            addCriterion("MEMBERID <=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLike(String value) {
            addCriterion("MEMBERID like", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotLike(String value) {
            addCriterion("MEMBERID not like", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidIn(List<String> values) {
            addCriterion("MEMBERID in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotIn(List<String> values) {
            addCriterion("MEMBERID not in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidBetween(String value1, String value2) {
            addCriterion("MEMBERID between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotBetween(String value1, String value2) {
            addCriterion("MEMBERID not between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andPtIsNull() {
            addCriterion("PT is null");
            return (Criteria) this;
        }

        public Criteria andPtIsNotNull() {
            addCriterion("PT is not null");
            return (Criteria) this;
        }

        public Criteria andPtEqualTo(String value) {
            addCriterion("PT =", value, "pt");
            return (Criteria) this;
        }

        public Criteria andPtNotEqualTo(String value) {
            addCriterion("PT <>", value, "pt");
            return (Criteria) this;
        }

        public Criteria andPtGreaterThan(String value) {
            addCriterion("PT >", value, "pt");
            return (Criteria) this;
        }

        public Criteria andPtGreaterThanOrEqualTo(String value) {
            addCriterion("PT >=", value, "pt");
            return (Criteria) this;
        }

        public Criteria andPtLessThan(String value) {
            addCriterion("PT <", value, "pt");
            return (Criteria) this;
        }

        public Criteria andPtLessThanOrEqualTo(String value) {
            addCriterion("PT <=", value, "pt");
            return (Criteria) this;
        }

        public Criteria andPtLike(String value) {
            addCriterion("PT like", value, "pt");
            return (Criteria) this;
        }

        public Criteria andPtNotLike(String value) {
            addCriterion("PT not like", value, "pt");
            return (Criteria) this;
        }

        public Criteria andPtIn(List<String> values) {
            addCriterion("PT in", values, "pt");
            return (Criteria) this;
        }

        public Criteria andPtNotIn(List<String> values) {
            addCriterion("PT not in", values, "pt");
            return (Criteria) this;
        }

        public Criteria andPtBetween(String value1, String value2) {
            addCriterion("PT between", value1, value2, "pt");
            return (Criteria) this;
        }

        public Criteria andPtNotBetween(String value1, String value2) {
            addCriterion("PT not between", value1, value2, "pt");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}