package com.shengpay.debit.dal.dataobject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbOrganizationInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DbOrganizationInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected DbOrganizationInfoExample(DbOrganizationInfoExample example) {
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

        public Criteria andOrgnizationCodeIsNull() {
            addCriterion("ORGNIZATION_CODE is null");
            return (Criteria) this;
        }

        public Criteria andOrgnizationCodeIsNotNull() {
            addCriterion("ORGNIZATION_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andOrgnizationCodeEqualTo(String value) {
            addCriterion("ORGNIZATION_CODE =", value, "orgnizationCode");
            return (Criteria) this;
        }

        public Criteria andOrgnizationCodeNotEqualTo(String value) {
            addCriterion("ORGNIZATION_CODE <>", value, "orgnizationCode");
            return (Criteria) this;
        }

        public Criteria andOrgnizationCodeGreaterThan(String value) {
            addCriterion("ORGNIZATION_CODE >", value, "orgnizationCode");
            return (Criteria) this;
        }

        public Criteria andOrgnizationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ORGNIZATION_CODE >=", value, "orgnizationCode");
            return (Criteria) this;
        }

        public Criteria andOrgnizationCodeLessThan(String value) {
            addCriterion("ORGNIZATION_CODE <", value, "orgnizationCode");
            return (Criteria) this;
        }

        public Criteria andOrgnizationCodeLessThanOrEqualTo(String value) {
            addCriterion("ORGNIZATION_CODE <=", value, "orgnizationCode");
            return (Criteria) this;
        }

        public Criteria andOrgnizationCodeLike(String value) {
            addCriterion("ORGNIZATION_CODE like", value, "orgnizationCode");
            return (Criteria) this;
        }

        public Criteria andOrgnizationCodeNotLike(String value) {
            addCriterion("ORGNIZATION_CODE not like", value, "orgnizationCode");
            return (Criteria) this;
        }

        public Criteria andOrgnizationCodeIn(List<String> values) {
            addCriterion("ORGNIZATION_CODE in", values, "orgnizationCode");
            return (Criteria) this;
        }

        public Criteria andOrgnizationCodeNotIn(List<String> values) {
            addCriterion("ORGNIZATION_CODE not in", values, "orgnizationCode");
            return (Criteria) this;
        }

        public Criteria andOrgnizationCodeBetween(String value1, String value2) {
            addCriterion("ORGNIZATION_CODE between", value1, value2, "orgnizationCode");
            return (Criteria) this;
        }

        public Criteria andOrgnizationCodeNotBetween(String value1, String value2) {
            addCriterion("ORGNIZATION_CODE not between", value1, value2, "orgnizationCode");
            return (Criteria) this;
        }

        public Criteria andOrgnizationNameIsNull() {
            addCriterion("ORGNIZATION_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOrgnizationNameIsNotNull() {
            addCriterion("ORGNIZATION_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOrgnizationNameEqualTo(String value) {
            addCriterion("ORGNIZATION_NAME =", value, "orgnizationName");
            return (Criteria) this;
        }

        public Criteria andOrgnizationNameNotEqualTo(String value) {
            addCriterion("ORGNIZATION_NAME <>", value, "orgnizationName");
            return (Criteria) this;
        }

        public Criteria andOrgnizationNameGreaterThan(String value) {
            addCriterion("ORGNIZATION_NAME >", value, "orgnizationName");
            return (Criteria) this;
        }

        public Criteria andOrgnizationNameGreaterThanOrEqualTo(String value) {
            addCriterion("ORGNIZATION_NAME >=", value, "orgnizationName");
            return (Criteria) this;
        }

        public Criteria andOrgnizationNameLessThan(String value) {
            addCriterion("ORGNIZATION_NAME <", value, "orgnizationName");
            return (Criteria) this;
        }

        public Criteria andOrgnizationNameLessThanOrEqualTo(String value) {
            addCriterion("ORGNIZATION_NAME <=", value, "orgnizationName");
            return (Criteria) this;
        }

        public Criteria andOrgnizationNameLike(String value) {
            addCriterion("ORGNIZATION_NAME like", value, "orgnizationName");
            return (Criteria) this;
        }

        public Criteria andOrgnizationNameNotLike(String value) {
            addCriterion("ORGNIZATION_NAME not like", value, "orgnizationName");
            return (Criteria) this;
        }

        public Criteria andOrgnizationNameIn(List<String> values) {
            addCriterion("ORGNIZATION_NAME in", values, "orgnizationName");
            return (Criteria) this;
        }

        public Criteria andOrgnizationNameNotIn(List<String> values) {
            addCriterion("ORGNIZATION_NAME not in", values, "orgnizationName");
            return (Criteria) this;
        }

        public Criteria andOrgnizationNameBetween(String value1, String value2) {
            addCriterion("ORGNIZATION_NAME between", value1, value2, "orgnizationName");
            return (Criteria) this;
        }

        public Criteria andOrgnizationNameNotBetween(String value1, String value2) {
            addCriterion("ORGNIZATION_NAME not between", value1, value2, "orgnizationName");
            return (Criteria) this;
        }

        public Criteria andOrgnizationDescIsNull() {
            addCriterion("ORGNIZATION_DESC is null");
            return (Criteria) this;
        }

        public Criteria andOrgnizationDescIsNotNull() {
            addCriterion("ORGNIZATION_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andOrgnizationDescEqualTo(String value) {
            addCriterion("ORGNIZATION_DESC =", value, "orgnizationDesc");
            return (Criteria) this;
        }

        public Criteria andOrgnizationDescNotEqualTo(String value) {
            addCriterion("ORGNIZATION_DESC <>", value, "orgnizationDesc");
            return (Criteria) this;
        }

        public Criteria andOrgnizationDescGreaterThan(String value) {
            addCriterion("ORGNIZATION_DESC >", value, "orgnizationDesc");
            return (Criteria) this;
        }

        public Criteria andOrgnizationDescGreaterThanOrEqualTo(String value) {
            addCriterion("ORGNIZATION_DESC >=", value, "orgnizationDesc");
            return (Criteria) this;
        }

        public Criteria andOrgnizationDescLessThan(String value) {
            addCriterion("ORGNIZATION_DESC <", value, "orgnizationDesc");
            return (Criteria) this;
        }

        public Criteria andOrgnizationDescLessThanOrEqualTo(String value) {
            addCriterion("ORGNIZATION_DESC <=", value, "orgnizationDesc");
            return (Criteria) this;
        }

        public Criteria andOrgnizationDescLike(String value) {
            addCriterion("ORGNIZATION_DESC like", value, "orgnizationDesc");
            return (Criteria) this;
        }

        public Criteria andOrgnizationDescNotLike(String value) {
            addCriterion("ORGNIZATION_DESC not like", value, "orgnizationDesc");
            return (Criteria) this;
        }

        public Criteria andOrgnizationDescIn(List<String> values) {
            addCriterion("ORGNIZATION_DESC in", values, "orgnizationDesc");
            return (Criteria) this;
        }

        public Criteria andOrgnizationDescNotIn(List<String> values) {
            addCriterion("ORGNIZATION_DESC not in", values, "orgnizationDesc");
            return (Criteria) this;
        }

        public Criteria andOrgnizationDescBetween(String value1, String value2) {
            addCriterion("ORGNIZATION_DESC between", value1, value2, "orgnizationDesc");
            return (Criteria) this;
        }

        public Criteria andOrgnizationDescNotBetween(String value1, String value2) {
            addCriterion("ORGNIZATION_DESC not between", value1, value2, "orgnizationDesc");
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