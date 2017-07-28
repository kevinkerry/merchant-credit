package com.shengpay.debit.dal.dataobject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbNormalSettingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DbNormalSettingExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected DbNormalSettingExample(DbNormalSettingExample example) {
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

        public Criteria andSettingKeyIsNull() {
            addCriterion("SETTING_KEY is null");
            return (Criteria) this;
        }

        public Criteria andSettingKeyIsNotNull() {
            addCriterion("SETTING_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andSettingKeyEqualTo(String value) {
            addCriterion("SETTING_KEY =", value, "settingKey");
            return (Criteria) this;
        }

        public Criteria andSettingKeyNotEqualTo(String value) {
            addCriterion("SETTING_KEY <>", value, "settingKey");
            return (Criteria) this;
        }

        public Criteria andSettingKeyGreaterThan(String value) {
            addCriterion("SETTING_KEY >", value, "settingKey");
            return (Criteria) this;
        }

        public Criteria andSettingKeyGreaterThanOrEqualTo(String value) {
            addCriterion("SETTING_KEY >=", value, "settingKey");
            return (Criteria) this;
        }

        public Criteria andSettingKeyLessThan(String value) {
            addCriterion("SETTING_KEY <", value, "settingKey");
            return (Criteria) this;
        }

        public Criteria andSettingKeyLessThanOrEqualTo(String value) {
            addCriterion("SETTING_KEY <=", value, "settingKey");
            return (Criteria) this;
        }

        public Criteria andSettingKeyLike(String value) {
            addCriterion("SETTING_KEY like", value, "settingKey");
            return (Criteria) this;
        }

        public Criteria andSettingKeyNotLike(String value) {
            addCriterion("SETTING_KEY not like", value, "settingKey");
            return (Criteria) this;
        }

        public Criteria andSettingKeyIn(List<String> values) {
            addCriterion("SETTING_KEY in", values, "settingKey");
            return (Criteria) this;
        }

        public Criteria andSettingKeyNotIn(List<String> values) {
            addCriterion("SETTING_KEY not in", values, "settingKey");
            return (Criteria) this;
        }

        public Criteria andSettingKeyBetween(String value1, String value2) {
            addCriterion("SETTING_KEY between", value1, value2, "settingKey");
            return (Criteria) this;
        }

        public Criteria andSettingKeyNotBetween(String value1, String value2) {
            addCriterion("SETTING_KEY not between", value1, value2, "settingKey");
            return (Criteria) this;
        }

        public Criteria andSettingValueIsNull() {
            addCriterion("SETTING_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andSettingValueIsNotNull() {
            addCriterion("SETTING_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andSettingValueEqualTo(String value) {
            addCriterion("SETTING_VALUE =", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueNotEqualTo(String value) {
            addCriterion("SETTING_VALUE <>", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueGreaterThan(String value) {
            addCriterion("SETTING_VALUE >", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueGreaterThanOrEqualTo(String value) {
            addCriterion("SETTING_VALUE >=", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueLessThan(String value) {
            addCriterion("SETTING_VALUE <", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueLessThanOrEqualTo(String value) {
            addCriterion("SETTING_VALUE <=", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueLike(String value) {
            addCriterion("SETTING_VALUE like", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueNotLike(String value) {
            addCriterion("SETTING_VALUE not like", value, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueIn(List<String> values) {
            addCriterion("SETTING_VALUE in", values, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueNotIn(List<String> values) {
            addCriterion("SETTING_VALUE not in", values, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueBetween(String value1, String value2) {
            addCriterion("SETTING_VALUE between", value1, value2, "settingValue");
            return (Criteria) this;
        }

        public Criteria andSettingValueNotBetween(String value1, String value2) {
            addCriterion("SETTING_VALUE not between", value1, value2, "settingValue");
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

        public Criteria andSettingDescIsNull() {
            addCriterion("SETTING_DESC is null");
            return (Criteria) this;
        }

        public Criteria andSettingDescIsNotNull() {
            addCriterion("SETTING_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andSettingDescEqualTo(String value) {
            addCriterion("SETTING_DESC =", value, "settingDesc");
            return (Criteria) this;
        }

        public Criteria andSettingDescNotEqualTo(String value) {
            addCriterion("SETTING_DESC <>", value, "settingDesc");
            return (Criteria) this;
        }

        public Criteria andSettingDescGreaterThan(String value) {
            addCriterion("SETTING_DESC >", value, "settingDesc");
            return (Criteria) this;
        }

        public Criteria andSettingDescGreaterThanOrEqualTo(String value) {
            addCriterion("SETTING_DESC >=", value, "settingDesc");
            return (Criteria) this;
        }

        public Criteria andSettingDescLessThan(String value) {
            addCriterion("SETTING_DESC <", value, "settingDesc");
            return (Criteria) this;
        }

        public Criteria andSettingDescLessThanOrEqualTo(String value) {
            addCriterion("SETTING_DESC <=", value, "settingDesc");
            return (Criteria) this;
        }

        public Criteria andSettingDescLike(String value) {
            addCriterion("SETTING_DESC like", value, "settingDesc");
            return (Criteria) this;
        }

        public Criteria andSettingDescNotLike(String value) {
            addCriterion("SETTING_DESC not like", value, "settingDesc");
            return (Criteria) this;
        }

        public Criteria andSettingDescIn(List<String> values) {
            addCriterion("SETTING_DESC in", values, "settingDesc");
            return (Criteria) this;
        }

        public Criteria andSettingDescNotIn(List<String> values) {
            addCriterion("SETTING_DESC not in", values, "settingDesc");
            return (Criteria) this;
        }

        public Criteria andSettingDescBetween(String value1, String value2) {
            addCriterion("SETTING_DESC between", value1, value2, "settingDesc");
            return (Criteria) this;
        }

        public Criteria andSettingDescNotBetween(String value1, String value2) {
            addCriterion("SETTING_DESC not between", value1, value2, "settingDesc");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}