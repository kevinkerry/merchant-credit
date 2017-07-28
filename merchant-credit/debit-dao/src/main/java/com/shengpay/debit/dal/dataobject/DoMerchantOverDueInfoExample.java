package com.shengpay.debit.dal.dataobject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoMerchantOverDueInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DoMerchantOverDueInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected DoMerchantOverDueInfoExample(DoMerchantOverDueInfoExample example) {
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

        public Criteria andBorrowOrderIdIsNull() {
            addCriterion("BORROW_ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andBorrowOrderIdIsNotNull() {
            addCriterion("BORROW_ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowOrderIdEqualTo(Long value) {
            addCriterion("BORROW_ORDER_ID =", value, "borrowOrderId");
            return (Criteria) this;
        }

        public Criteria andBorrowOrderIdNotEqualTo(Long value) {
            addCriterion("BORROW_ORDER_ID <>", value, "borrowOrderId");
            return (Criteria) this;
        }

        public Criteria andBorrowOrderIdGreaterThan(Long value) {
            addCriterion("BORROW_ORDER_ID >", value, "borrowOrderId");
            return (Criteria) this;
        }

        public Criteria andBorrowOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("BORROW_ORDER_ID >=", value, "borrowOrderId");
            return (Criteria) this;
        }

        public Criteria andBorrowOrderIdLessThan(Long value) {
            addCriterion("BORROW_ORDER_ID <", value, "borrowOrderId");
            return (Criteria) this;
        }

        public Criteria andBorrowOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("BORROW_ORDER_ID <=", value, "borrowOrderId");
            return (Criteria) this;
        }

        public Criteria andBorrowOrderIdIn(List<Long> values) {
            addCriterion("BORROW_ORDER_ID in", values, "borrowOrderId");
            return (Criteria) this;
        }

        public Criteria andBorrowOrderIdNotIn(List<Long> values) {
            addCriterion("BORROW_ORDER_ID not in", values, "borrowOrderId");
            return (Criteria) this;
        }

        public Criteria andBorrowOrderIdBetween(Long value1, Long value2) {
            addCriterion("BORROW_ORDER_ID between", value1, value2, "borrowOrderId");
            return (Criteria) this;
        }

        public Criteria andBorrowOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("BORROW_ORDER_ID not between", value1, value2, "borrowOrderId");
            return (Criteria) this;
        }

        public Criteria andCalDateIsNull() {
            addCriterion("CAL_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCalDateIsNotNull() {
            addCriterion("CAL_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCalDateEqualTo(Date value) {
            addCriterion("CAL_DATE =", value, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateNotEqualTo(Date value) {
            addCriterion("CAL_DATE <>", value, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateGreaterThan(Date value) {
            addCriterion("CAL_DATE >", value, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CAL_DATE >=", value, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateLessThan(Date value) {
            addCriterion("CAL_DATE <", value, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateLessThanOrEqualTo(Date value) {
            addCriterion("CAL_DATE <=", value, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateIn(List<Date> values) {
            addCriterion("CAL_DATE in", values, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateNotIn(List<Date> values) {
            addCriterion("CAL_DATE not in", values, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateBetween(Date value1, Date value2) {
            addCriterion("CAL_DATE between", value1, value2, "calDate");
            return (Criteria) this;
        }

        public Criteria andCalDateNotBetween(Date value1, Date value2) {
            addCriterion("CAL_DATE not between", value1, value2, "calDate");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}