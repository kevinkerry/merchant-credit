package com.shengpay.debit.dal.dataobject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoMeCreditLinesApplyInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DoMeCreditLinesApplyInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected DoMeCreditLinesApplyInfoExample(DoMeCreditLinesApplyInfoExample example) {
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

        public Criteria andInputKindIsNull() {
            addCriterion("INPUT_KIND is null");
            return (Criteria) this;
        }

        public Criteria andInputKindIsNotNull() {
            addCriterion("INPUT_KIND is not null");
            return (Criteria) this;
        }

        public Criteria andInputKindEqualTo(String value) {
            addCriterion("INPUT_KIND =", value, "inputKind");
            return (Criteria) this;
        }

        public Criteria andInputKindNotEqualTo(String value) {
            addCriterion("INPUT_KIND <>", value, "inputKind");
            return (Criteria) this;
        }

        public Criteria andInputKindGreaterThan(String value) {
            addCriterion("INPUT_KIND >", value, "inputKind");
            return (Criteria) this;
        }

        public Criteria andInputKindGreaterThanOrEqualTo(String value) {
            addCriterion("INPUT_KIND >=", value, "inputKind");
            return (Criteria) this;
        }

        public Criteria andInputKindLessThan(String value) {
            addCriterion("INPUT_KIND <", value, "inputKind");
            return (Criteria) this;
        }

        public Criteria andInputKindLessThanOrEqualTo(String value) {
            addCriterion("INPUT_KIND <=", value, "inputKind");
            return (Criteria) this;
        }

        public Criteria andInputKindLike(String value) {
            addCriterion("INPUT_KIND like", value, "inputKind");
            return (Criteria) this;
        }

        public Criteria andInputKindNotLike(String value) {
            addCriterion("INPUT_KIND not like", value, "inputKind");
            return (Criteria) this;
        }

        public Criteria andInputKindIn(List<String> values) {
            addCriterion("INPUT_KIND in", values, "inputKind");
            return (Criteria) this;
        }

        public Criteria andInputKindNotIn(List<String> values) {
            addCriterion("INPUT_KIND not in", values, "inputKind");
            return (Criteria) this;
        }

        public Criteria andInputKindBetween(String value1, String value2) {
            addCriterion("INPUT_KIND between", value1, value2, "inputKind");
            return (Criteria) this;
        }

        public Criteria andInputKindNotBetween(String value1, String value2) {
            addCriterion("INPUT_KIND not between", value1, value2, "inputKind");
            return (Criteria) this;
        }

        public Criteria andInputCodeIsNull() {
            addCriterion("INPUT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andInputCodeIsNotNull() {
            addCriterion("INPUT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andInputCodeEqualTo(String value) {
            addCriterion("INPUT_CODE =", value, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeNotEqualTo(String value) {
            addCriterion("INPUT_CODE <>", value, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeGreaterThan(String value) {
            addCriterion("INPUT_CODE >", value, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeGreaterThanOrEqualTo(String value) {
            addCriterion("INPUT_CODE >=", value, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeLessThan(String value) {
            addCriterion("INPUT_CODE <", value, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeLessThanOrEqualTo(String value) {
            addCriterion("INPUT_CODE <=", value, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeLike(String value) {
            addCriterion("INPUT_CODE like", value, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeNotLike(String value) {
            addCriterion("INPUT_CODE not like", value, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeIn(List<String> values) {
            addCriterion("INPUT_CODE in", values, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeNotIn(List<String> values) {
            addCriterion("INPUT_CODE not in", values, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeBetween(String value1, String value2) {
            addCriterion("INPUT_CODE between", value1, value2, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeNotBetween(String value1, String value2) {
            addCriterion("INPUT_CODE not between", value1, value2, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputValueIsNull() {
            addCriterion("INPUT_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andInputValueIsNotNull() {
            addCriterion("INPUT_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andInputValueEqualTo(String value) {
            addCriterion("INPUT_VALUE =", value, "inputValue");
            return (Criteria) this;
        }

        public Criteria andInputValueNotEqualTo(String value) {
            addCriterion("INPUT_VALUE <>", value, "inputValue");
            return (Criteria) this;
        }

        public Criteria andInputValueGreaterThan(String value) {
            addCriterion("INPUT_VALUE >", value, "inputValue");
            return (Criteria) this;
        }

        public Criteria andInputValueGreaterThanOrEqualTo(String value) {
            addCriterion("INPUT_VALUE >=", value, "inputValue");
            return (Criteria) this;
        }

        public Criteria andInputValueLessThan(String value) {
            addCriterion("INPUT_VALUE <", value, "inputValue");
            return (Criteria) this;
        }

        public Criteria andInputValueLessThanOrEqualTo(String value) {
            addCriterion("INPUT_VALUE <=", value, "inputValue");
            return (Criteria) this;
        }

        public Criteria andInputValueLike(String value) {
            addCriterion("INPUT_VALUE like", value, "inputValue");
            return (Criteria) this;
        }

        public Criteria andInputValueNotLike(String value) {
            addCriterion("INPUT_VALUE not like", value, "inputValue");
            return (Criteria) this;
        }

        public Criteria andInputValueIn(List<String> values) {
            addCriterion("INPUT_VALUE in", values, "inputValue");
            return (Criteria) this;
        }

        public Criteria andInputValueNotIn(List<String> values) {
            addCriterion("INPUT_VALUE not in", values, "inputValue");
            return (Criteria) this;
        }

        public Criteria andInputValueBetween(String value1, String value2) {
            addCriterion("INPUT_VALUE between", value1, value2, "inputValue");
            return (Criteria) this;
        }

        public Criteria andInputValueNotBetween(String value1, String value2) {
            addCriterion("INPUT_VALUE not between", value1, value2, "inputValue");
            return (Criteria) this;
        }

        public Criteria andInputTypeIsNull() {
            addCriterion("INPUT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andInputTypeIsNotNull() {
            addCriterion("INPUT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andInputTypeEqualTo(String value) {
            addCriterion("INPUT_TYPE =", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeNotEqualTo(String value) {
            addCriterion("INPUT_TYPE <>", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeGreaterThan(String value) {
            addCriterion("INPUT_TYPE >", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeGreaterThanOrEqualTo(String value) {
            addCriterion("INPUT_TYPE >=", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeLessThan(String value) {
            addCriterion("INPUT_TYPE <", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeLessThanOrEqualTo(String value) {
            addCriterion("INPUT_TYPE <=", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeLike(String value) {
            addCriterion("INPUT_TYPE like", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeNotLike(String value) {
            addCriterion("INPUT_TYPE not like", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeIn(List<String> values) {
            addCriterion("INPUT_TYPE in", values, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeNotIn(List<String> values) {
            addCriterion("INPUT_TYPE not in", values, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeBetween(String value1, String value2) {
            addCriterion("INPUT_TYPE between", value1, value2, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeNotBetween(String value1, String value2) {
            addCriterion("INPUT_TYPE not between", value1, value2, "inputType");
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