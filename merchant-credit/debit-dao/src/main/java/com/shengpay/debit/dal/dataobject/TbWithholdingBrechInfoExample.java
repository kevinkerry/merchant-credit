package com.shengpay.debit.dal.dataobject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TbWithholdingBrechInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbWithholdingBrechInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected TbWithholdingBrechInfoExample(TbWithholdingBrechInfoExample example) {
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

        public Criteria andTotalCountIsNull() {
            addCriterion("TOTAL_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andTotalCountIsNotNull() {
            addCriterion("TOTAL_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCountEqualTo(String value) {
            addCriterion("TOTAL_COUNT =", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotEqualTo(String value) {
            addCriterion("TOTAL_COUNT <>", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountGreaterThan(String value) {
            addCriterion("TOTAL_COUNT >", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountGreaterThanOrEqualTo(String value) {
            addCriterion("TOTAL_COUNT >=", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountLessThan(String value) {
            addCriterion("TOTAL_COUNT <", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountLessThanOrEqualTo(String value) {
            addCriterion("TOTAL_COUNT <=", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountLike(String value) {
            addCriterion("TOTAL_COUNT like", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotLike(String value) {
            addCriterion("TOTAL_COUNT not like", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountIn(List<String> values) {
            addCriterion("TOTAL_COUNT in", values, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotIn(List<String> values) {
            addCriterion("TOTAL_COUNT not in", values, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountBetween(String value1, String value2) {
            addCriterion("TOTAL_COUNT between", value1, value2, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotBetween(String value1, String value2) {
            addCriterion("TOTAL_COUNT not between", value1, value2, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNull() {
            addCriterion("TOTAL_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("TOTAL_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(BigDecimal value) {
            addCriterion("TOTAL_AMOUNT =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_AMOUNT <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_AMOUNT >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_AMOUNT >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(BigDecimal value) {
            addCriterion("TOTAL_AMOUNT <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_AMOUNT <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<BigDecimal> values) {
            addCriterion("TOTAL_AMOUNT in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_AMOUNT not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_AMOUNT between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_AMOUNT not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andSucessCountIsNull() {
            addCriterion("SUCESS_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andSucessCountIsNotNull() {
            addCriterion("SUCESS_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andSucessCountEqualTo(String value) {
            addCriterion("SUCESS_COUNT =", value, "sucessCount");
            return (Criteria) this;
        }

        public Criteria andSucessCountNotEqualTo(String value) {
            addCriterion("SUCESS_COUNT <>", value, "sucessCount");
            return (Criteria) this;
        }

        public Criteria andSucessCountGreaterThan(String value) {
            addCriterion("SUCESS_COUNT >", value, "sucessCount");
            return (Criteria) this;
        }

        public Criteria andSucessCountGreaterThanOrEqualTo(String value) {
            addCriterion("SUCESS_COUNT >=", value, "sucessCount");
            return (Criteria) this;
        }

        public Criteria andSucessCountLessThan(String value) {
            addCriterion("SUCESS_COUNT <", value, "sucessCount");
            return (Criteria) this;
        }

        public Criteria andSucessCountLessThanOrEqualTo(String value) {
            addCriterion("SUCESS_COUNT <=", value, "sucessCount");
            return (Criteria) this;
        }

        public Criteria andSucessCountLike(String value) {
            addCriterion("SUCESS_COUNT like", value, "sucessCount");
            return (Criteria) this;
        }

        public Criteria andSucessCountNotLike(String value) {
            addCriterion("SUCESS_COUNT not like", value, "sucessCount");
            return (Criteria) this;
        }

        public Criteria andSucessCountIn(List<String> values) {
            addCriterion("SUCESS_COUNT in", values, "sucessCount");
            return (Criteria) this;
        }

        public Criteria andSucessCountNotIn(List<String> values) {
            addCriterion("SUCESS_COUNT not in", values, "sucessCount");
            return (Criteria) this;
        }

        public Criteria andSucessCountBetween(String value1, String value2) {
            addCriterion("SUCESS_COUNT between", value1, value2, "sucessCount");
            return (Criteria) this;
        }

        public Criteria andSucessCountNotBetween(String value1, String value2) {
            addCriterion("SUCESS_COUNT not between", value1, value2, "sucessCount");
            return (Criteria) this;
        }

        public Criteria andFailCountIsNull() {
            addCriterion("FAIL_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andFailCountIsNotNull() {
            addCriterion("FAIL_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andFailCountEqualTo(String value) {
            addCriterion("FAIL_COUNT =", value, "failCount");
            return (Criteria) this;
        }

        public Criteria andFailCountNotEqualTo(String value) {
            addCriterion("FAIL_COUNT <>", value, "failCount");
            return (Criteria) this;
        }

        public Criteria andFailCountGreaterThan(String value) {
            addCriterion("FAIL_COUNT >", value, "failCount");
            return (Criteria) this;
        }

        public Criteria andFailCountGreaterThanOrEqualTo(String value) {
            addCriterion("FAIL_COUNT >=", value, "failCount");
            return (Criteria) this;
        }

        public Criteria andFailCountLessThan(String value) {
            addCriterion("FAIL_COUNT <", value, "failCount");
            return (Criteria) this;
        }

        public Criteria andFailCountLessThanOrEqualTo(String value) {
            addCriterion("FAIL_COUNT <=", value, "failCount");
            return (Criteria) this;
        }

        public Criteria andFailCountLike(String value) {
            addCriterion("FAIL_COUNT like", value, "failCount");
            return (Criteria) this;
        }

        public Criteria andFailCountNotLike(String value) {
            addCriterion("FAIL_COUNT not like", value, "failCount");
            return (Criteria) this;
        }

        public Criteria andFailCountIn(List<String> values) {
            addCriterion("FAIL_COUNT in", values, "failCount");
            return (Criteria) this;
        }

        public Criteria andFailCountNotIn(List<String> values) {
            addCriterion("FAIL_COUNT not in", values, "failCount");
            return (Criteria) this;
        }

        public Criteria andFailCountBetween(String value1, String value2) {
            addCriterion("FAIL_COUNT between", value1, value2, "failCount");
            return (Criteria) this;
        }

        public Criteria andFailCountNotBetween(String value1, String value2) {
            addCriterion("FAIL_COUNT not between", value1, value2, "failCount");
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

        public Criteria andResultCodeIsNull() {
            addCriterion("RESULT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andResultCodeIsNotNull() {
            addCriterion("RESULT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andResultCodeEqualTo(String value) {
            addCriterion("RESULT_CODE =", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotEqualTo(String value) {
            addCriterion("RESULT_CODE <>", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeGreaterThan(String value) {
            addCriterion("RESULT_CODE >", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeGreaterThanOrEqualTo(String value) {
            addCriterion("RESULT_CODE >=", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeLessThan(String value) {
            addCriterion("RESULT_CODE <", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeLessThanOrEqualTo(String value) {
            addCriterion("RESULT_CODE <=", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeLike(String value) {
            addCriterion("RESULT_CODE like", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotLike(String value) {
            addCriterion("RESULT_CODE not like", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeIn(List<String> values) {
            addCriterion("RESULT_CODE in", values, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotIn(List<String> values) {
            addCriterion("RESULT_CODE not in", values, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeBetween(String value1, String value2) {
            addCriterion("RESULT_CODE between", value1, value2, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotBetween(String value1, String value2) {
            addCriterion("RESULT_CODE not between", value1, value2, "resultCode");
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

        public Criteria andBatchTimeIsNull() {
            addCriterion("BATCH_TIME is null");
            return (Criteria) this;
        }

        public Criteria andBatchTimeIsNotNull() {
            addCriterion("BATCH_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andBatchTimeEqualTo(Date value) {
            addCriterion("BATCH_TIME =", value, "batchTime");
            return (Criteria) this;
        }

        public Criteria andBatchTimeNotEqualTo(Date value) {
            addCriterion("BATCH_TIME <>", value, "batchTime");
            return (Criteria) this;
        }

        public Criteria andBatchTimeGreaterThan(Date value) {
            addCriterion("BATCH_TIME >", value, "batchTime");
            return (Criteria) this;
        }

        public Criteria andBatchTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("BATCH_TIME >=", value, "batchTime");
            return (Criteria) this;
        }

        public Criteria andBatchTimeLessThan(Date value) {
            addCriterion("BATCH_TIME <", value, "batchTime");
            return (Criteria) this;
        }

        public Criteria andBatchTimeLessThanOrEqualTo(Date value) {
            addCriterion("BATCH_TIME <=", value, "batchTime");
            return (Criteria) this;
        }

        public Criteria andBatchTimeIn(List<Date> values) {
            addCriterion("BATCH_TIME in", values, "batchTime");
            return (Criteria) this;
        }

        public Criteria andBatchTimeNotIn(List<Date> values) {
            addCriterion("BATCH_TIME not in", values, "batchTime");
            return (Criteria) this;
        }

        public Criteria andBatchTimeBetween(Date value1, Date value2) {
            addCriterion("BATCH_TIME between", value1, value2, "batchTime");
            return (Criteria) this;
        }

        public Criteria andBatchTimeNotBetween(Date value1, Date value2) {
            addCriterion("BATCH_TIME not between", value1, value2, "batchTime");
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

        public Criteria andOperneridIsNull() {
            addCriterion("OPERNERID is null");
            return (Criteria) this;
        }

        public Criteria andOperneridIsNotNull() {
            addCriterion("OPERNERID is not null");
            return (Criteria) this;
        }

        public Criteria andOperneridEqualTo(String value) {
            addCriterion("OPERNERID =", value, "opernerid");
            return (Criteria) this;
        }

        public Criteria andOperneridNotEqualTo(String value) {
            addCriterion("OPERNERID <>", value, "opernerid");
            return (Criteria) this;
        }

        public Criteria andOperneridGreaterThan(String value) {
            addCriterion("OPERNERID >", value, "opernerid");
            return (Criteria) this;
        }

        public Criteria andOperneridGreaterThanOrEqualTo(String value) {
            addCriterion("OPERNERID >=", value, "opernerid");
            return (Criteria) this;
        }

        public Criteria andOperneridLessThan(String value) {
            addCriterion("OPERNERID <", value, "opernerid");
            return (Criteria) this;
        }

        public Criteria andOperneridLessThanOrEqualTo(String value) {
            addCriterion("OPERNERID <=", value, "opernerid");
            return (Criteria) this;
        }

        public Criteria andOperneridLike(String value) {
            addCriterion("OPERNERID like", value, "opernerid");
            return (Criteria) this;
        }

        public Criteria andOperneridNotLike(String value) {
            addCriterion("OPERNERID not like", value, "opernerid");
            return (Criteria) this;
        }

        public Criteria andOperneridIn(List<String> values) {
            addCriterion("OPERNERID in", values, "opernerid");
            return (Criteria) this;
        }

        public Criteria andOperneridNotIn(List<String> values) {
            addCriterion("OPERNERID not in", values, "opernerid");
            return (Criteria) this;
        }

        public Criteria andOperneridBetween(String value1, String value2) {
            addCriterion("OPERNERID between", value1, value2, "opernerid");
            return (Criteria) this;
        }

        public Criteria andOperneridNotBetween(String value1, String value2) {
            addCriterion("OPERNERID not between", value1, value2, "opernerid");
            return (Criteria) this;
        }

        public Criteria andOpernernameIsNull() {
            addCriterion("OPERNERNAME is null");
            return (Criteria) this;
        }

        public Criteria andOpernernameIsNotNull() {
            addCriterion("OPERNERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andOpernernameEqualTo(String value) {
            addCriterion("OPERNERNAME =", value, "opernername");
            return (Criteria) this;
        }

        public Criteria andOpernernameNotEqualTo(String value) {
            addCriterion("OPERNERNAME <>", value, "opernername");
            return (Criteria) this;
        }

        public Criteria andOpernernameGreaterThan(String value) {
            addCriterion("OPERNERNAME >", value, "opernername");
            return (Criteria) this;
        }

        public Criteria andOpernernameGreaterThanOrEqualTo(String value) {
            addCriterion("OPERNERNAME >=", value, "opernername");
            return (Criteria) this;
        }

        public Criteria andOpernernameLessThan(String value) {
            addCriterion("OPERNERNAME <", value, "opernername");
            return (Criteria) this;
        }

        public Criteria andOpernernameLessThanOrEqualTo(String value) {
            addCriterion("OPERNERNAME <=", value, "opernername");
            return (Criteria) this;
        }

        public Criteria andOpernernameLike(String value) {
            addCriterion("OPERNERNAME like", value, "opernername");
            return (Criteria) this;
        }

        public Criteria andOpernernameNotLike(String value) {
            addCriterion("OPERNERNAME not like", value, "opernername");
            return (Criteria) this;
        }

        public Criteria andOpernernameIn(List<String> values) {
            addCriterion("OPERNERNAME in", values, "opernername");
            return (Criteria) this;
        }

        public Criteria andOpernernameNotIn(List<String> values) {
            addCriterion("OPERNERNAME not in", values, "opernername");
            return (Criteria) this;
        }

        public Criteria andOpernernameBetween(String value1, String value2) {
            addCriterion("OPERNERNAME between", value1, value2, "opernername");
            return (Criteria) this;
        }

        public Criteria andOpernernameNotBetween(String value1, String value2) {
            addCriterion("OPERNERNAME not between", value1, value2, "opernername");
            return (Criteria) this;
        }

        public Criteria andBiztypeIsNull() {
            addCriterion("BIZTYPE is null");
            return (Criteria) this;
        }

        public Criteria andBiztypeIsNotNull() {
            addCriterion("BIZTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBiztypeEqualTo(String value) {
            addCriterion("BIZTYPE =", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotEqualTo(String value) {
            addCriterion("BIZTYPE <>", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeGreaterThan(String value) {
            addCriterion("BIZTYPE >", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeGreaterThanOrEqualTo(String value) {
            addCriterion("BIZTYPE >=", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeLessThan(String value) {
            addCriterion("BIZTYPE <", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeLessThanOrEqualTo(String value) {
            addCriterion("BIZTYPE <=", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeLike(String value) {
            addCriterion("BIZTYPE like", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotLike(String value) {
            addCriterion("BIZTYPE not like", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeIn(List<String> values) {
            addCriterion("BIZTYPE in", values, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotIn(List<String> values) {
            addCriterion("BIZTYPE not in", values, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeBetween(String value1, String value2) {
            addCriterion("BIZTYPE between", value1, value2, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotBetween(String value1, String value2) {
            addCriterion("BIZTYPE not between", value1, value2, "biztype");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}