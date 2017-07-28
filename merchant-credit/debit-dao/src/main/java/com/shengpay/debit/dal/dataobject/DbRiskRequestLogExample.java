package com.shengpay.debit.dal.dataobject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbRiskRequestLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DbRiskRequestLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected DbRiskRequestLogExample(DbRiskRequestLogExample example) {
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

        public Criteria andLineApplyOrderIdIsNull() {
            addCriterion("LINE_APPLY_ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andLineApplyOrderIdIsNotNull() {
            addCriterion("LINE_APPLY_ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLineApplyOrderIdEqualTo(Long value) {
            addCriterion("LINE_APPLY_ORDER_ID =", value, "lineApplyOrderId");
            return (Criteria) this;
        }

        public Criteria andLineApplyOrderIdNotEqualTo(Long value) {
            addCriterion("LINE_APPLY_ORDER_ID <>", value, "lineApplyOrderId");
            return (Criteria) this;
        }

        public Criteria andLineApplyOrderIdGreaterThan(Long value) {
            addCriterion("LINE_APPLY_ORDER_ID >", value, "lineApplyOrderId");
            return (Criteria) this;
        }

        public Criteria andLineApplyOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("LINE_APPLY_ORDER_ID >=", value, "lineApplyOrderId");
            return (Criteria) this;
        }

        public Criteria andLineApplyOrderIdLessThan(Long value) {
            addCriterion("LINE_APPLY_ORDER_ID <", value, "lineApplyOrderId");
            return (Criteria) this;
        }

        public Criteria andLineApplyOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("LINE_APPLY_ORDER_ID <=", value, "lineApplyOrderId");
            return (Criteria) this;
        }

        public Criteria andLineApplyOrderIdIn(List<Long> values) {
            addCriterion("LINE_APPLY_ORDER_ID in", values, "lineApplyOrderId");
            return (Criteria) this;
        }

        public Criteria andLineApplyOrderIdNotIn(List<Long> values) {
            addCriterion("LINE_APPLY_ORDER_ID not in", values, "lineApplyOrderId");
            return (Criteria) this;
        }

        public Criteria andLineApplyOrderIdBetween(Long value1, Long value2) {
            addCriterion("LINE_APPLY_ORDER_ID between", value1, value2, "lineApplyOrderId");
            return (Criteria) this;
        }

        public Criteria andLineApplyOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("LINE_APPLY_ORDER_ID not between", value1, value2, "lineApplyOrderId");
            return (Criteria) this;
        }

        public Criteria andRequestMsgIsNull() {
            addCriterion("REQUEST_MSG is null");
            return (Criteria) this;
        }

        public Criteria andRequestMsgIsNotNull() {
            addCriterion("REQUEST_MSG is not null");
            return (Criteria) this;
        }

        public Criteria andRequestMsgEqualTo(String value) {
            addCriterion("REQUEST_MSG =", value, "requestMsg");
            return (Criteria) this;
        }

        public Criteria andRequestMsgNotEqualTo(String value) {
            addCriterion("REQUEST_MSG <>", value, "requestMsg");
            return (Criteria) this;
        }

        public Criteria andRequestMsgGreaterThan(String value) {
            addCriterion("REQUEST_MSG >", value, "requestMsg");
            return (Criteria) this;
        }

        public Criteria andRequestMsgGreaterThanOrEqualTo(String value) {
            addCriterion("REQUEST_MSG >=", value, "requestMsg");
            return (Criteria) this;
        }

        public Criteria andRequestMsgLessThan(String value) {
            addCriterion("REQUEST_MSG <", value, "requestMsg");
            return (Criteria) this;
        }

        public Criteria andRequestMsgLessThanOrEqualTo(String value) {
            addCriterion("REQUEST_MSG <=", value, "requestMsg");
            return (Criteria) this;
        }

        public Criteria andRequestMsgLike(String value) {
            addCriterion("REQUEST_MSG like", value, "requestMsg");
            return (Criteria) this;
        }

        public Criteria andRequestMsgNotLike(String value) {
            addCriterion("REQUEST_MSG not like", value, "requestMsg");
            return (Criteria) this;
        }

        public Criteria andRequestMsgIn(List<String> values) {
            addCriterion("REQUEST_MSG in", values, "requestMsg");
            return (Criteria) this;
        }

        public Criteria andRequestMsgNotIn(List<String> values) {
            addCriterion("REQUEST_MSG not in", values, "requestMsg");
            return (Criteria) this;
        }

        public Criteria andRequestMsgBetween(String value1, String value2) {
            addCriterion("REQUEST_MSG between", value1, value2, "requestMsg");
            return (Criteria) this;
        }

        public Criteria andRequestMsgNotBetween(String value1, String value2) {
            addCriterion("REQUEST_MSG not between", value1, value2, "requestMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgIsNull() {
            addCriterion("RESPONSE_MSG is null");
            return (Criteria) this;
        }

        public Criteria andResponseMsgIsNotNull() {
            addCriterion("RESPONSE_MSG is not null");
            return (Criteria) this;
        }

        public Criteria andResponseMsgEqualTo(String value) {
            addCriterion("RESPONSE_MSG =", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgNotEqualTo(String value) {
            addCriterion("RESPONSE_MSG <>", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgGreaterThan(String value) {
            addCriterion("RESPONSE_MSG >", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgGreaterThanOrEqualTo(String value) {
            addCriterion("RESPONSE_MSG >=", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgLessThan(String value) {
            addCriterion("RESPONSE_MSG <", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgLessThanOrEqualTo(String value) {
            addCriterion("RESPONSE_MSG <=", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgLike(String value) {
            addCriterion("RESPONSE_MSG like", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgNotLike(String value) {
            addCriterion("RESPONSE_MSG not like", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgIn(List<String> values) {
            addCriterion("RESPONSE_MSG in", values, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgNotIn(List<String> values) {
            addCriterion("RESPONSE_MSG not in", values, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgBetween(String value1, String value2) {
            addCriterion("RESPONSE_MSG between", value1, value2, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgNotBetween(String value1, String value2) {
            addCriterion("RESPONSE_MSG not between", value1, value2, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseStatusIsNull() {
            addCriterion("RESPONSE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andResponseStatusIsNotNull() {
            addCriterion("RESPONSE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andResponseStatusEqualTo(String value) {
            addCriterion("RESPONSE_STATUS =", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusNotEqualTo(String value) {
            addCriterion("RESPONSE_STATUS <>", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusGreaterThan(String value) {
            addCriterion("RESPONSE_STATUS >", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusGreaterThanOrEqualTo(String value) {
            addCriterion("RESPONSE_STATUS >=", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusLessThan(String value) {
            addCriterion("RESPONSE_STATUS <", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusLessThanOrEqualTo(String value) {
            addCriterion("RESPONSE_STATUS <=", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusLike(String value) {
            addCriterion("RESPONSE_STATUS like", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusNotLike(String value) {
            addCriterion("RESPONSE_STATUS not like", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusIn(List<String> values) {
            addCriterion("RESPONSE_STATUS in", values, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusNotIn(List<String> values) {
            addCriterion("RESPONSE_STATUS not in", values, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusBetween(String value1, String value2) {
            addCriterion("RESPONSE_STATUS between", value1, value2, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusNotBetween(String value1, String value2) {
            addCriterion("RESPONSE_STATUS not between", value1, value2, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andNotifyMsgIsNull() {
            addCriterion("NOTIFY_MSG is null");
            return (Criteria) this;
        }

        public Criteria andNotifyMsgIsNotNull() {
            addCriterion("NOTIFY_MSG is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyMsgEqualTo(String value) {
            addCriterion("NOTIFY_MSG =", value, "notifyMsg");
            return (Criteria) this;
        }

        public Criteria andNotifyMsgNotEqualTo(String value) {
            addCriterion("NOTIFY_MSG <>", value, "notifyMsg");
            return (Criteria) this;
        }

        public Criteria andNotifyMsgGreaterThan(String value) {
            addCriterion("NOTIFY_MSG >", value, "notifyMsg");
            return (Criteria) this;
        }

        public Criteria andNotifyMsgGreaterThanOrEqualTo(String value) {
            addCriterion("NOTIFY_MSG >=", value, "notifyMsg");
            return (Criteria) this;
        }

        public Criteria andNotifyMsgLessThan(String value) {
            addCriterion("NOTIFY_MSG <", value, "notifyMsg");
            return (Criteria) this;
        }

        public Criteria andNotifyMsgLessThanOrEqualTo(String value) {
            addCriterion("NOTIFY_MSG <=", value, "notifyMsg");
            return (Criteria) this;
        }

        public Criteria andNotifyMsgLike(String value) {
            addCriterion("NOTIFY_MSG like", value, "notifyMsg");
            return (Criteria) this;
        }

        public Criteria andNotifyMsgNotLike(String value) {
            addCriterion("NOTIFY_MSG not like", value, "notifyMsg");
            return (Criteria) this;
        }

        public Criteria andNotifyMsgIn(List<String> values) {
            addCriterion("NOTIFY_MSG in", values, "notifyMsg");
            return (Criteria) this;
        }

        public Criteria andNotifyMsgNotIn(List<String> values) {
            addCriterion("NOTIFY_MSG not in", values, "notifyMsg");
            return (Criteria) this;
        }

        public Criteria andNotifyMsgBetween(String value1, String value2) {
            addCriterion("NOTIFY_MSG between", value1, value2, "notifyMsg");
            return (Criteria) this;
        }

        public Criteria andNotifyMsgNotBetween(String value1, String value2) {
            addCriterion("NOTIFY_MSG not between", value1, value2, "notifyMsg");
            return (Criteria) this;
        }

        public Criteria andNotifyStatusIsNull() {
            addCriterion("NOTIFY_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andNotifyStatusIsNotNull() {
            addCriterion("NOTIFY_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyStatusEqualTo(String value) {
            addCriterion("NOTIFY_STATUS =", value, "notifyStatus");
            return (Criteria) this;
        }

        public Criteria andNotifyStatusNotEqualTo(String value) {
            addCriterion("NOTIFY_STATUS <>", value, "notifyStatus");
            return (Criteria) this;
        }

        public Criteria andNotifyStatusGreaterThan(String value) {
            addCriterion("NOTIFY_STATUS >", value, "notifyStatus");
            return (Criteria) this;
        }

        public Criteria andNotifyStatusGreaterThanOrEqualTo(String value) {
            addCriterion("NOTIFY_STATUS >=", value, "notifyStatus");
            return (Criteria) this;
        }

        public Criteria andNotifyStatusLessThan(String value) {
            addCriterion("NOTIFY_STATUS <", value, "notifyStatus");
            return (Criteria) this;
        }

        public Criteria andNotifyStatusLessThanOrEqualTo(String value) {
            addCriterion("NOTIFY_STATUS <=", value, "notifyStatus");
            return (Criteria) this;
        }

        public Criteria andNotifyStatusLike(String value) {
            addCriterion("NOTIFY_STATUS like", value, "notifyStatus");
            return (Criteria) this;
        }

        public Criteria andNotifyStatusNotLike(String value) {
            addCriterion("NOTIFY_STATUS not like", value, "notifyStatus");
            return (Criteria) this;
        }

        public Criteria andNotifyStatusIn(List<String> values) {
            addCriterion("NOTIFY_STATUS in", values, "notifyStatus");
            return (Criteria) this;
        }

        public Criteria andNotifyStatusNotIn(List<String> values) {
            addCriterion("NOTIFY_STATUS not in", values, "notifyStatus");
            return (Criteria) this;
        }

        public Criteria andNotifyStatusBetween(String value1, String value2) {
            addCriterion("NOTIFY_STATUS between", value1, value2, "notifyStatus");
            return (Criteria) this;
        }

        public Criteria andNotifyStatusNotBetween(String value1, String value2) {
            addCriterion("NOTIFY_STATUS not between", value1, value2, "notifyStatus");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeIsNull() {
            addCriterion("NOTIFY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeIsNotNull() {
            addCriterion("NOTIFY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeEqualTo(Date value) {
            addCriterion("NOTIFY_TIME =", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeNotEqualTo(Date value) {
            addCriterion("NOTIFY_TIME <>", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeGreaterThan(Date value) {
            addCriterion("NOTIFY_TIME >", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("NOTIFY_TIME >=", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeLessThan(Date value) {
            addCriterion("NOTIFY_TIME <", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("NOTIFY_TIME <=", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeIn(List<Date> values) {
            addCriterion("NOTIFY_TIME in", values, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeNotIn(List<Date> values) {
            addCriterion("NOTIFY_TIME not in", values, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeBetween(Date value1, Date value2) {
            addCriterion("NOTIFY_TIME between", value1, value2, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("NOTIFY_TIME not between", value1, value2, "notifyTime");
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

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}