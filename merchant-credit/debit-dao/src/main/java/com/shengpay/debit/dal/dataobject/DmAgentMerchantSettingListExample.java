package com.shengpay.debit.dal.dataobject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DmAgentMerchantSettingListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DmAgentMerchantSettingListExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected DmAgentMerchantSettingListExample(DmAgentMerchantSettingListExample example) {
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

        public Criteria andAgentMerchantNoIsNull() {
            addCriterion("AGENT_MERCHANT_NO is null");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNoIsNotNull() {
            addCriterion("AGENT_MERCHANT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNoEqualTo(String value) {
            addCriterion("AGENT_MERCHANT_NO =", value, "agentMerchantNo");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNoNotEqualTo(String value) {
            addCriterion("AGENT_MERCHANT_NO <>", value, "agentMerchantNo");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNoGreaterThan(String value) {
            addCriterion("AGENT_MERCHANT_NO >", value, "agentMerchantNo");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("AGENT_MERCHANT_NO >=", value, "agentMerchantNo");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNoLessThan(String value) {
            addCriterion("AGENT_MERCHANT_NO <", value, "agentMerchantNo");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("AGENT_MERCHANT_NO <=", value, "agentMerchantNo");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNoLike(String value) {
            addCriterion("AGENT_MERCHANT_NO like", value, "agentMerchantNo");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNoNotLike(String value) {
            addCriterion("AGENT_MERCHANT_NO not like", value, "agentMerchantNo");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNoIn(List<String> values) {
            addCriterion("AGENT_MERCHANT_NO in", values, "agentMerchantNo");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNoNotIn(List<String> values) {
            addCriterion("AGENT_MERCHANT_NO not in", values, "agentMerchantNo");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNoBetween(String value1, String value2) {
            addCriterion("AGENT_MERCHANT_NO between", value1, value2, "agentMerchantNo");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNoNotBetween(String value1, String value2) {
            addCriterion("AGENT_MERCHANT_NO not between", value1, value2, "agentMerchantNo");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNameIsNull() {
            addCriterion("AGENT_MERCHANT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNameIsNotNull() {
            addCriterion("AGENT_MERCHANT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNameEqualTo(String value) {
            addCriterion("AGENT_MERCHANT_NAME =", value, "agentMerchantName");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNameNotEqualTo(String value) {
            addCriterion("AGENT_MERCHANT_NAME <>", value, "agentMerchantName");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNameGreaterThan(String value) {
            addCriterion("AGENT_MERCHANT_NAME >", value, "agentMerchantName");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNameGreaterThanOrEqualTo(String value) {
            addCriterion("AGENT_MERCHANT_NAME >=", value, "agentMerchantName");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNameLessThan(String value) {
            addCriterion("AGENT_MERCHANT_NAME <", value, "agentMerchantName");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNameLessThanOrEqualTo(String value) {
            addCriterion("AGENT_MERCHANT_NAME <=", value, "agentMerchantName");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNameLike(String value) {
            addCriterion("AGENT_MERCHANT_NAME like", value, "agentMerchantName");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNameNotLike(String value) {
            addCriterion("AGENT_MERCHANT_NAME not like", value, "agentMerchantName");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNameIn(List<String> values) {
            addCriterion("AGENT_MERCHANT_NAME in", values, "agentMerchantName");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNameNotIn(List<String> values) {
            addCriterion("AGENT_MERCHANT_NAME not in", values, "agentMerchantName");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNameBetween(String value1, String value2) {
            addCriterion("AGENT_MERCHANT_NAME between", value1, value2, "agentMerchantName");
            return (Criteria) this;
        }

        public Criteria andAgentMerchantNameNotBetween(String value1, String value2) {
            addCriterion("AGENT_MERCHANT_NAME not between", value1, value2, "agentMerchantName");
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

        public Criteria andExtInfoIsNull() {
            addCriterion("EXT_INFO is null");
            return (Criteria) this;
        }

        public Criteria andExtInfoIsNotNull() {
            addCriterion("EXT_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andExtInfoEqualTo(String value) {
            addCriterion("EXT_INFO =", value, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoNotEqualTo(String value) {
            addCriterion("EXT_INFO <>", value, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoGreaterThan(String value) {
            addCriterion("EXT_INFO >", value, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoGreaterThanOrEqualTo(String value) {
            addCriterion("EXT_INFO >=", value, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoLessThan(String value) {
            addCriterion("EXT_INFO <", value, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoLessThanOrEqualTo(String value) {
            addCriterion("EXT_INFO <=", value, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoLike(String value) {
            addCriterion("EXT_INFO like", value, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoNotLike(String value) {
            addCriterion("EXT_INFO not like", value, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoIn(List<String> values) {
            addCriterion("EXT_INFO in", values, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoNotIn(List<String> values) {
            addCriterion("EXT_INFO not in", values, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoBetween(String value1, String value2) {
            addCriterion("EXT_INFO between", value1, value2, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoNotBetween(String value1, String value2) {
            addCriterion("EXT_INFO not between", value1, value2, "extInfo");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}