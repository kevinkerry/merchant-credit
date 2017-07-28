package com.shengpay.debit.dal.dataobject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoMerchantCreditLinesApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DoMerchantCreditLinesApplyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected DoMerchantCreditLinesApplyExample(DoMerchantCreditLinesApplyExample example) {
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

        public Criteria andApplyStatusIsNull() {
            addCriterion("APPLY_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIsNotNull() {
            addCriterion("APPLY_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andApplyStatusEqualTo(String value) {
            addCriterion("APPLY_STATUS =", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotEqualTo(String value) {
            addCriterion("APPLY_STATUS <>", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusGreaterThan(String value) {
            addCriterion("APPLY_STATUS >", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_STATUS >=", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusLessThan(String value) {
            addCriterion("APPLY_STATUS <", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusLessThanOrEqualTo(String value) {
            addCriterion("APPLY_STATUS <=", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusLike(String value) {
            addCriterion("APPLY_STATUS like", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotLike(String value) {
            addCriterion("APPLY_STATUS not like", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIn(List<String> values) {
            addCriterion("APPLY_STATUS in", values, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotIn(List<String> values) {
            addCriterion("APPLY_STATUS not in", values, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusBetween(String value1, String value2) {
            addCriterion("APPLY_STATUS between", value1, value2, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotBetween(String value1, String value2) {
            addCriterion("APPLY_STATUS not between", value1, value2, "applyStatus");
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

        public Criteria andApplyMerchantInfoIsNull() {
            addCriterion("APPLY_MERCHANT_INFO is null");
            return (Criteria) this;
        }

        public Criteria andApplyMerchantInfoIsNotNull() {
            addCriterion("APPLY_MERCHANT_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andApplyMerchantInfoEqualTo(String value) {
            addCriterion("APPLY_MERCHANT_INFO =", value, "applyMerchantInfo");
            return (Criteria) this;
        }

        public Criteria andApplyMerchantInfoNotEqualTo(String value) {
            addCriterion("APPLY_MERCHANT_INFO <>", value, "applyMerchantInfo");
            return (Criteria) this;
        }

        public Criteria andApplyMerchantInfoGreaterThan(String value) {
            addCriterion("APPLY_MERCHANT_INFO >", value, "applyMerchantInfo");
            return (Criteria) this;
        }

        public Criteria andApplyMerchantInfoGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_MERCHANT_INFO >=", value, "applyMerchantInfo");
            return (Criteria) this;
        }

        public Criteria andApplyMerchantInfoLessThan(String value) {
            addCriterion("APPLY_MERCHANT_INFO <", value, "applyMerchantInfo");
            return (Criteria) this;
        }

        public Criteria andApplyMerchantInfoLessThanOrEqualTo(String value) {
            addCriterion("APPLY_MERCHANT_INFO <=", value, "applyMerchantInfo");
            return (Criteria) this;
        }

        public Criteria andApplyMerchantInfoLike(String value) {
            addCriterion("APPLY_MERCHANT_INFO like", value, "applyMerchantInfo");
            return (Criteria) this;
        }

        public Criteria andApplyMerchantInfoNotLike(String value) {
            addCriterion("APPLY_MERCHANT_INFO not like", value, "applyMerchantInfo");
            return (Criteria) this;
        }

        public Criteria andApplyMerchantInfoIn(List<String> values) {
            addCriterion("APPLY_MERCHANT_INFO in", values, "applyMerchantInfo");
            return (Criteria) this;
        }

        public Criteria andApplyMerchantInfoNotIn(List<String> values) {
            addCriterion("APPLY_MERCHANT_INFO not in", values, "applyMerchantInfo");
            return (Criteria) this;
        }

        public Criteria andApplyMerchantInfoBetween(String value1, String value2) {
            addCriterion("APPLY_MERCHANT_INFO between", value1, value2, "applyMerchantInfo");
            return (Criteria) this;
        }

        public Criteria andApplyMerchantInfoNotBetween(String value1, String value2) {
            addCriterion("APPLY_MERCHANT_INFO not between", value1, value2, "applyMerchantInfo");
            return (Criteria) this;
        }

        public Criteria andMerchantApplyAgentTimeIsNull() {
            addCriterion("MERCHANT_APPLY_AGENT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andMerchantApplyAgentTimeIsNotNull() {
            addCriterion("MERCHANT_APPLY_AGENT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantApplyAgentTimeEqualTo(Date value) {
            addCriterion("MERCHANT_APPLY_AGENT_TIME =", value, "merchantApplyAgentTime");
            return (Criteria) this;
        }

        public Criteria andMerchantApplyAgentTimeNotEqualTo(Date value) {
            addCriterion("MERCHANT_APPLY_AGENT_TIME <>", value, "merchantApplyAgentTime");
            return (Criteria) this;
        }

        public Criteria andMerchantApplyAgentTimeGreaterThan(Date value) {
            addCriterion("MERCHANT_APPLY_AGENT_TIME >", value, "merchantApplyAgentTime");
            return (Criteria) this;
        }

        public Criteria andMerchantApplyAgentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MERCHANT_APPLY_AGENT_TIME >=", value, "merchantApplyAgentTime");
            return (Criteria) this;
        }

        public Criteria andMerchantApplyAgentTimeLessThan(Date value) {
            addCriterion("MERCHANT_APPLY_AGENT_TIME <", value, "merchantApplyAgentTime");
            return (Criteria) this;
        }

        public Criteria andMerchantApplyAgentTimeLessThanOrEqualTo(Date value) {
            addCriterion("MERCHANT_APPLY_AGENT_TIME <=", value, "merchantApplyAgentTime");
            return (Criteria) this;
        }

        public Criteria andMerchantApplyAgentTimeIn(List<Date> values) {
            addCriterion("MERCHANT_APPLY_AGENT_TIME in", values, "merchantApplyAgentTime");
            return (Criteria) this;
        }

        public Criteria andMerchantApplyAgentTimeNotIn(List<Date> values) {
            addCriterion("MERCHANT_APPLY_AGENT_TIME not in", values, "merchantApplyAgentTime");
            return (Criteria) this;
        }

        public Criteria andMerchantApplyAgentTimeBetween(Date value1, Date value2) {
            addCriterion("MERCHANT_APPLY_AGENT_TIME between", value1, value2, "merchantApplyAgentTime");
            return (Criteria) this;
        }

        public Criteria andMerchantApplyAgentTimeNotBetween(Date value1, Date value2) {
            addCriterion("MERCHANT_APPLY_AGENT_TIME not between", value1, value2, "merchantApplyAgentTime");
            return (Criteria) this;
        }

        public Criteria andIsAgnetGuaranteeIsNull() {
            addCriterion("IS_AGNET_GUARANTEE is null");
            return (Criteria) this;
        }

        public Criteria andIsAgnetGuaranteeIsNotNull() {
            addCriterion("IS_AGNET_GUARANTEE is not null");
            return (Criteria) this;
        }

        public Criteria andIsAgnetGuaranteeEqualTo(String value) {
            addCriterion("IS_AGNET_GUARANTEE =", value, "isAgnetGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsAgnetGuaranteeNotEqualTo(String value) {
            addCriterion("IS_AGNET_GUARANTEE <>", value, "isAgnetGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsAgnetGuaranteeGreaterThan(String value) {
            addCriterion("IS_AGNET_GUARANTEE >", value, "isAgnetGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsAgnetGuaranteeGreaterThanOrEqualTo(String value) {
            addCriterion("IS_AGNET_GUARANTEE >=", value, "isAgnetGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsAgnetGuaranteeLessThan(String value) {
            addCriterion("IS_AGNET_GUARANTEE <", value, "isAgnetGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsAgnetGuaranteeLessThanOrEqualTo(String value) {
            addCriterion("IS_AGNET_GUARANTEE <=", value, "isAgnetGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsAgnetGuaranteeLike(String value) {
            addCriterion("IS_AGNET_GUARANTEE like", value, "isAgnetGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsAgnetGuaranteeNotLike(String value) {
            addCriterion("IS_AGNET_GUARANTEE not like", value, "isAgnetGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsAgnetGuaranteeIn(List<String> values) {
            addCriterion("IS_AGNET_GUARANTEE in", values, "isAgnetGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsAgnetGuaranteeNotIn(List<String> values) {
            addCriterion("IS_AGNET_GUARANTEE not in", values, "isAgnetGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsAgnetGuaranteeBetween(String value1, String value2) {
            addCriterion("IS_AGNET_GUARANTEE between", value1, value2, "isAgnetGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsAgnetGuaranteeNotBetween(String value1, String value2) {
            addCriterion("IS_AGNET_GUARANTEE not between", value1, value2, "isAgnetGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsNeedAgnetGuaranteeIsNull() {
            addCriterion("IS_NEED_AGNET_GUARANTEE is null");
            return (Criteria) this;
        }

        public Criteria andIsNeedAgnetGuaranteeIsNotNull() {
            addCriterion("IS_NEED_AGNET_GUARANTEE is not null");
            return (Criteria) this;
        }

        public Criteria andIsNeedAgnetGuaranteeEqualTo(String value) {
            addCriterion("IS_NEED_AGNET_GUARANTEE =", value, "isNeedAgnetGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsNeedAgnetGuaranteeNotEqualTo(String value) {
            addCriterion("IS_NEED_AGNET_GUARANTEE <>", value, "isNeedAgnetGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsNeedAgnetGuaranteeGreaterThan(String value) {
            addCriterion("IS_NEED_AGNET_GUARANTEE >", value, "isNeedAgnetGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsNeedAgnetGuaranteeGreaterThanOrEqualTo(String value) {
            addCriterion("IS_NEED_AGNET_GUARANTEE >=", value, "isNeedAgnetGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsNeedAgnetGuaranteeLessThan(String value) {
            addCriterion("IS_NEED_AGNET_GUARANTEE <", value, "isNeedAgnetGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsNeedAgnetGuaranteeLessThanOrEqualTo(String value) {
            addCriterion("IS_NEED_AGNET_GUARANTEE <=", value, "isNeedAgnetGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsNeedAgnetGuaranteeLike(String value) {
            addCriterion("IS_NEED_AGNET_GUARANTEE like", value, "isNeedAgnetGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsNeedAgnetGuaranteeNotLike(String value) {
            addCriterion("IS_NEED_AGNET_GUARANTEE not like", value, "isNeedAgnetGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsNeedAgnetGuaranteeIn(List<String> values) {
            addCriterion("IS_NEED_AGNET_GUARANTEE in", values, "isNeedAgnetGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsNeedAgnetGuaranteeNotIn(List<String> values) {
            addCriterion("IS_NEED_AGNET_GUARANTEE not in", values, "isNeedAgnetGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsNeedAgnetGuaranteeBetween(String value1, String value2) {
            addCriterion("IS_NEED_AGNET_GUARANTEE between", value1, value2, "isNeedAgnetGuarantee");
            return (Criteria) this;
        }

        public Criteria andIsNeedAgnetGuaranteeNotBetween(String value1, String value2) {
            addCriterion("IS_NEED_AGNET_GUARANTEE not between", value1, value2, "isNeedAgnetGuarantee");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeIsNull() {
            addCriterion("APPLY_START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeIsNotNull() {
            addCriterion("APPLY_START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeEqualTo(Date value) {
            addCriterion("APPLY_START_TIME =", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeNotEqualTo(Date value) {
            addCriterion("APPLY_START_TIME <>", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeGreaterThan(Date value) {
            addCriterion("APPLY_START_TIME >", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("APPLY_START_TIME >=", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeLessThan(Date value) {
            addCriterion("APPLY_START_TIME <", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("APPLY_START_TIME <=", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeIn(List<Date> values) {
            addCriterion("APPLY_START_TIME in", values, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeNotIn(List<Date> values) {
            addCriterion("APPLY_START_TIME not in", values, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeBetween(Date value1, Date value2) {
            addCriterion("APPLY_START_TIME between", value1, value2, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("APPLY_START_TIME not between", value1, value2, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyRiskTimeIsNull() {
            addCriterion("APPLY_RISK_TIME is null");
            return (Criteria) this;
        }

        public Criteria andApplyRiskTimeIsNotNull() {
            addCriterion("APPLY_RISK_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andApplyRiskTimeEqualTo(Date value) {
            addCriterion("APPLY_RISK_TIME =", value, "applyRiskTime");
            return (Criteria) this;
        }

        public Criteria andApplyRiskTimeNotEqualTo(Date value) {
            addCriterion("APPLY_RISK_TIME <>", value, "applyRiskTime");
            return (Criteria) this;
        }

        public Criteria andApplyRiskTimeGreaterThan(Date value) {
            addCriterion("APPLY_RISK_TIME >", value, "applyRiskTime");
            return (Criteria) this;
        }

        public Criteria andApplyRiskTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("APPLY_RISK_TIME >=", value, "applyRiskTime");
            return (Criteria) this;
        }

        public Criteria andApplyRiskTimeLessThan(Date value) {
            addCriterion("APPLY_RISK_TIME <", value, "applyRiskTime");
            return (Criteria) this;
        }

        public Criteria andApplyRiskTimeLessThanOrEqualTo(Date value) {
            addCriterion("APPLY_RISK_TIME <=", value, "applyRiskTime");
            return (Criteria) this;
        }

        public Criteria andApplyRiskTimeIn(List<Date> values) {
            addCriterion("APPLY_RISK_TIME in", values, "applyRiskTime");
            return (Criteria) this;
        }

        public Criteria andApplyRiskTimeNotIn(List<Date> values) {
            addCriterion("APPLY_RISK_TIME not in", values, "applyRiskTime");
            return (Criteria) this;
        }

        public Criteria andApplyRiskTimeBetween(Date value1, Date value2) {
            addCriterion("APPLY_RISK_TIME between", value1, value2, "applyRiskTime");
            return (Criteria) this;
        }

        public Criteria andApplyRiskTimeNotBetween(Date value1, Date value2) {
            addCriterion("APPLY_RISK_TIME not between", value1, value2, "applyRiskTime");
            return (Criteria) this;
        }

        public Criteria andRiskAnswerTimeIsNull() {
            addCriterion("RISK_ANSWER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRiskAnswerTimeIsNotNull() {
            addCriterion("RISK_ANSWER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRiskAnswerTimeEqualTo(Date value) {
            addCriterion("RISK_ANSWER_TIME =", value, "riskAnswerTime");
            return (Criteria) this;
        }

        public Criteria andRiskAnswerTimeNotEqualTo(Date value) {
            addCriterion("RISK_ANSWER_TIME <>", value, "riskAnswerTime");
            return (Criteria) this;
        }

        public Criteria andRiskAnswerTimeGreaterThan(Date value) {
            addCriterion("RISK_ANSWER_TIME >", value, "riskAnswerTime");
            return (Criteria) this;
        }

        public Criteria andRiskAnswerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RISK_ANSWER_TIME >=", value, "riskAnswerTime");
            return (Criteria) this;
        }

        public Criteria andRiskAnswerTimeLessThan(Date value) {
            addCriterion("RISK_ANSWER_TIME <", value, "riskAnswerTime");
            return (Criteria) this;
        }

        public Criteria andRiskAnswerTimeLessThanOrEqualTo(Date value) {
            addCriterion("RISK_ANSWER_TIME <=", value, "riskAnswerTime");
            return (Criteria) this;
        }

        public Criteria andRiskAnswerTimeIn(List<Date> values) {
            addCriterion("RISK_ANSWER_TIME in", values, "riskAnswerTime");
            return (Criteria) this;
        }

        public Criteria andRiskAnswerTimeNotIn(List<Date> values) {
            addCriterion("RISK_ANSWER_TIME not in", values, "riskAnswerTime");
            return (Criteria) this;
        }

        public Criteria andRiskAnswerTimeBetween(Date value1, Date value2) {
            addCriterion("RISK_ANSWER_TIME between", value1, value2, "riskAnswerTime");
            return (Criteria) this;
        }

        public Criteria andRiskAnswerTimeNotBetween(Date value1, Date value2) {
            addCriterion("RISK_ANSWER_TIME not between", value1, value2, "riskAnswerTime");
            return (Criteria) this;
        }

        public Criteria andMerchantSendDataTimeIsNull() {
            addCriterion("MERCHANT_SEND_DATA_TIME is null");
            return (Criteria) this;
        }

        public Criteria andMerchantSendDataTimeIsNotNull() {
            addCriterion("MERCHANT_SEND_DATA_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantSendDataTimeEqualTo(Date value) {
            addCriterion("MERCHANT_SEND_DATA_TIME =", value, "merchantSendDataTime");
            return (Criteria) this;
        }

        public Criteria andMerchantSendDataTimeNotEqualTo(Date value) {
            addCriterion("MERCHANT_SEND_DATA_TIME <>", value, "merchantSendDataTime");
            return (Criteria) this;
        }

        public Criteria andMerchantSendDataTimeGreaterThan(Date value) {
            addCriterion("MERCHANT_SEND_DATA_TIME >", value, "merchantSendDataTime");
            return (Criteria) this;
        }

        public Criteria andMerchantSendDataTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MERCHANT_SEND_DATA_TIME >=", value, "merchantSendDataTime");
            return (Criteria) this;
        }

        public Criteria andMerchantSendDataTimeLessThan(Date value) {
            addCriterion("MERCHANT_SEND_DATA_TIME <", value, "merchantSendDataTime");
            return (Criteria) this;
        }

        public Criteria andMerchantSendDataTimeLessThanOrEqualTo(Date value) {
            addCriterion("MERCHANT_SEND_DATA_TIME <=", value, "merchantSendDataTime");
            return (Criteria) this;
        }

        public Criteria andMerchantSendDataTimeIn(List<Date> values) {
            addCriterion("MERCHANT_SEND_DATA_TIME in", values, "merchantSendDataTime");
            return (Criteria) this;
        }

        public Criteria andMerchantSendDataTimeNotIn(List<Date> values) {
            addCriterion("MERCHANT_SEND_DATA_TIME not in", values, "merchantSendDataTime");
            return (Criteria) this;
        }

        public Criteria andMerchantSendDataTimeBetween(Date value1, Date value2) {
            addCriterion("MERCHANT_SEND_DATA_TIME between", value1, value2, "merchantSendDataTime");
            return (Criteria) this;
        }

        public Criteria andMerchantSendDataTimeNotBetween(Date value1, Date value2) {
            addCriterion("MERCHANT_SEND_DATA_TIME not between", value1, value2, "merchantSendDataTime");
            return (Criteria) this;
        }

        public Criteria andBorrowTimeIsNull() {
            addCriterion("BORROW_TIME is null");
            return (Criteria) this;
        }

        public Criteria andBorrowTimeIsNotNull() {
            addCriterion("BORROW_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowTimeEqualTo(Date value) {
            addCriterion("BORROW_TIME =", value, "borrowTime");
            return (Criteria) this;
        }

        public Criteria andBorrowTimeNotEqualTo(Date value) {
            addCriterion("BORROW_TIME <>", value, "borrowTime");
            return (Criteria) this;
        }

        public Criteria andBorrowTimeGreaterThan(Date value) {
            addCriterion("BORROW_TIME >", value, "borrowTime");
            return (Criteria) this;
        }

        public Criteria andBorrowTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("BORROW_TIME >=", value, "borrowTime");
            return (Criteria) this;
        }

        public Criteria andBorrowTimeLessThan(Date value) {
            addCriterion("BORROW_TIME <", value, "borrowTime");
            return (Criteria) this;
        }

        public Criteria andBorrowTimeLessThanOrEqualTo(Date value) {
            addCriterion("BORROW_TIME <=", value, "borrowTime");
            return (Criteria) this;
        }

        public Criteria andBorrowTimeIn(List<Date> values) {
            addCriterion("BORROW_TIME in", values, "borrowTime");
            return (Criteria) this;
        }

        public Criteria andBorrowTimeNotIn(List<Date> values) {
            addCriterion("BORROW_TIME not in", values, "borrowTime");
            return (Criteria) this;
        }

        public Criteria andBorrowTimeBetween(Date value1, Date value2) {
            addCriterion("BORROW_TIME between", value1, value2, "borrowTime");
            return (Criteria) this;
        }

        public Criteria andBorrowTimeNotBetween(Date value1, Date value2) {
            addCriterion("BORROW_TIME not between", value1, value2, "borrowTime");
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

        public Criteria andRiskLevelIsNull() {
            addCriterion("RISK_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andRiskLevelIsNotNull() {
            addCriterion("RISK_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andRiskLevelEqualTo(String value) {
            addCriterion("RISK_LEVEL =", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelNotEqualTo(String value) {
            addCriterion("RISK_LEVEL <>", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelGreaterThan(String value) {
            addCriterion("RISK_LEVEL >", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelGreaterThanOrEqualTo(String value) {
            addCriterion("RISK_LEVEL >=", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelLessThan(String value) {
            addCriterion("RISK_LEVEL <", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelLessThanOrEqualTo(String value) {
            addCriterion("RISK_LEVEL <=", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelLike(String value) {
            addCriterion("RISK_LEVEL like", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelNotLike(String value) {
            addCriterion("RISK_LEVEL not like", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelIn(List<String> values) {
            addCriterion("RISK_LEVEL in", values, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelNotIn(List<String> values) {
            addCriterion("RISK_LEVEL not in", values, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelBetween(String value1, String value2) {
            addCriterion("RISK_LEVEL between", value1, value2, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelNotBetween(String value1, String value2) {
            addCriterion("RISK_LEVEL not between", value1, value2, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andLendAmountIsNull() {
            addCriterion("LEND_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andLendAmountIsNotNull() {
            addCriterion("LEND_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andLendAmountEqualTo(BigDecimal value) {
            addCriterion("LEND_AMOUNT =", value, "lendAmount");
            return (Criteria) this;
        }

        public Criteria andLendAmountNotEqualTo(BigDecimal value) {
            addCriterion("LEND_AMOUNT <>", value, "lendAmount");
            return (Criteria) this;
        }

        public Criteria andLendAmountGreaterThan(BigDecimal value) {
            addCriterion("LEND_AMOUNT >", value, "lendAmount");
            return (Criteria) this;
        }

        public Criteria andLendAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LEND_AMOUNT >=", value, "lendAmount");
            return (Criteria) this;
        }

        public Criteria andLendAmountLessThan(BigDecimal value) {
            addCriterion("LEND_AMOUNT <", value, "lendAmount");
            return (Criteria) this;
        }

        public Criteria andLendAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LEND_AMOUNT <=", value, "lendAmount");
            return (Criteria) this;
        }

        public Criteria andLendAmountIn(List<BigDecimal> values) {
            addCriterion("LEND_AMOUNT in", values, "lendAmount");
            return (Criteria) this;
        }

        public Criteria andLendAmountNotIn(List<BigDecimal> values) {
            addCriterion("LEND_AMOUNT not in", values, "lendAmount");
            return (Criteria) this;
        }

        public Criteria andLendAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LEND_AMOUNT between", value1, value2, "lendAmount");
            return (Criteria) this;
        }

        public Criteria andLendAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LEND_AMOUNT not between", value1, value2, "lendAmount");
            return (Criteria) this;
        }

        public Criteria andPolicyStartTimeIsNull() {
            addCriterion("POLICY_START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPolicyStartTimeIsNotNull() {
            addCriterion("POLICY_START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyStartTimeEqualTo(Date value) {
            addCriterion("POLICY_START_TIME =", value, "policyStartTime");
            return (Criteria) this;
        }

        public Criteria andPolicyStartTimeNotEqualTo(Date value) {
            addCriterion("POLICY_START_TIME <>", value, "policyStartTime");
            return (Criteria) this;
        }

        public Criteria andPolicyStartTimeGreaterThan(Date value) {
            addCriterion("POLICY_START_TIME >", value, "policyStartTime");
            return (Criteria) this;
        }

        public Criteria andPolicyStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("POLICY_START_TIME >=", value, "policyStartTime");
            return (Criteria) this;
        }

        public Criteria andPolicyStartTimeLessThan(Date value) {
            addCriterion("POLICY_START_TIME <", value, "policyStartTime");
            return (Criteria) this;
        }

        public Criteria andPolicyStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("POLICY_START_TIME <=", value, "policyStartTime");
            return (Criteria) this;
        }

        public Criteria andPolicyStartTimeIn(List<Date> values) {
            addCriterion("POLICY_START_TIME in", values, "policyStartTime");
            return (Criteria) this;
        }

        public Criteria andPolicyStartTimeNotIn(List<Date> values) {
            addCriterion("POLICY_START_TIME not in", values, "policyStartTime");
            return (Criteria) this;
        }

        public Criteria andPolicyStartTimeBetween(Date value1, Date value2) {
            addCriterion("POLICY_START_TIME between", value1, value2, "policyStartTime");
            return (Criteria) this;
        }

        public Criteria andPolicyStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("POLICY_START_TIME not between", value1, value2, "policyStartTime");
            return (Criteria) this;
        }

        public Criteria andPolicyEndTimeIsNull() {
            addCriterion("POLICY_END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPolicyEndTimeIsNotNull() {
            addCriterion("POLICY_END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyEndTimeEqualTo(Date value) {
            addCriterion("POLICY_END_TIME =", value, "policyEndTime");
            return (Criteria) this;
        }

        public Criteria andPolicyEndTimeNotEqualTo(Date value) {
            addCriterion("POLICY_END_TIME <>", value, "policyEndTime");
            return (Criteria) this;
        }

        public Criteria andPolicyEndTimeGreaterThan(Date value) {
            addCriterion("POLICY_END_TIME >", value, "policyEndTime");
            return (Criteria) this;
        }

        public Criteria andPolicyEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("POLICY_END_TIME >=", value, "policyEndTime");
            return (Criteria) this;
        }

        public Criteria andPolicyEndTimeLessThan(Date value) {
            addCriterion("POLICY_END_TIME <", value, "policyEndTime");
            return (Criteria) this;
        }

        public Criteria andPolicyEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("POLICY_END_TIME <=", value, "policyEndTime");
            return (Criteria) this;
        }

        public Criteria andPolicyEndTimeIn(List<Date> values) {
            addCriterion("POLICY_END_TIME in", values, "policyEndTime");
            return (Criteria) this;
        }

        public Criteria andPolicyEndTimeNotIn(List<Date> values) {
            addCriterion("POLICY_END_TIME not in", values, "policyEndTime");
            return (Criteria) this;
        }

        public Criteria andPolicyEndTimeBetween(Date value1, Date value2) {
            addCriterion("POLICY_END_TIME between", value1, value2, "policyEndTime");
            return (Criteria) this;
        }

        public Criteria andPolicyEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("POLICY_END_TIME not between", value1, value2, "policyEndTime");
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

        public Criteria andLendWallerAccountIsNull() {
            addCriterion("LEND_WALLER_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andLendWallerAccountIsNotNull() {
            addCriterion("LEND_WALLER_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andLendWallerAccountEqualTo(String value) {
            addCriterion("LEND_WALLER_ACCOUNT =", value, "lendWallerAccount");
            return (Criteria) this;
        }

        public Criteria andLendWallerAccountNotEqualTo(String value) {
            addCriterion("LEND_WALLER_ACCOUNT <>", value, "lendWallerAccount");
            return (Criteria) this;
        }

        public Criteria andLendWallerAccountGreaterThan(String value) {
            addCriterion("LEND_WALLER_ACCOUNT >", value, "lendWallerAccount");
            return (Criteria) this;
        }

        public Criteria andLendWallerAccountGreaterThanOrEqualTo(String value) {
            addCriterion("LEND_WALLER_ACCOUNT >=", value, "lendWallerAccount");
            return (Criteria) this;
        }

        public Criteria andLendWallerAccountLessThan(String value) {
            addCriterion("LEND_WALLER_ACCOUNT <", value, "lendWallerAccount");
            return (Criteria) this;
        }

        public Criteria andLendWallerAccountLessThanOrEqualTo(String value) {
            addCriterion("LEND_WALLER_ACCOUNT <=", value, "lendWallerAccount");
            return (Criteria) this;
        }

        public Criteria andLendWallerAccountLike(String value) {
            addCriterion("LEND_WALLER_ACCOUNT like", value, "lendWallerAccount");
            return (Criteria) this;
        }

        public Criteria andLendWallerAccountNotLike(String value) {
            addCriterion("LEND_WALLER_ACCOUNT not like", value, "lendWallerAccount");
            return (Criteria) this;
        }

        public Criteria andLendWallerAccountIn(List<String> values) {
            addCriterion("LEND_WALLER_ACCOUNT in", values, "lendWallerAccount");
            return (Criteria) this;
        }

        public Criteria andLendWallerAccountNotIn(List<String> values) {
            addCriterion("LEND_WALLER_ACCOUNT not in", values, "lendWallerAccount");
            return (Criteria) this;
        }

        public Criteria andLendWallerAccountBetween(String value1, String value2) {
            addCriterion("LEND_WALLER_ACCOUNT between", value1, value2, "lendWallerAccount");
            return (Criteria) this;
        }

        public Criteria andLendWallerAccountNotBetween(String value1, String value2) {
            addCriterion("LEND_WALLER_ACCOUNT not between", value1, value2, "lendWallerAccount");
            return (Criteria) this;
        }

        public Criteria andLendMemberIdIsNull() {
            addCriterion("LEND_MEMBER_ID is null");
            return (Criteria) this;
        }

        public Criteria andLendMemberIdIsNotNull() {
            addCriterion("LEND_MEMBER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLendMemberIdEqualTo(String value) {
            addCriterion("LEND_MEMBER_ID =", value, "lendMemberId");
            return (Criteria) this;
        }

        public Criteria andLendMemberIdNotEqualTo(String value) {
            addCriterion("LEND_MEMBER_ID <>", value, "lendMemberId");
            return (Criteria) this;
        }

        public Criteria andLendMemberIdGreaterThan(String value) {
            addCriterion("LEND_MEMBER_ID >", value, "lendMemberId");
            return (Criteria) this;
        }

        public Criteria andLendMemberIdGreaterThanOrEqualTo(String value) {
            addCriterion("LEND_MEMBER_ID >=", value, "lendMemberId");
            return (Criteria) this;
        }

        public Criteria andLendMemberIdLessThan(String value) {
            addCriterion("LEND_MEMBER_ID <", value, "lendMemberId");
            return (Criteria) this;
        }

        public Criteria andLendMemberIdLessThanOrEqualTo(String value) {
            addCriterion("LEND_MEMBER_ID <=", value, "lendMemberId");
            return (Criteria) this;
        }

        public Criteria andLendMemberIdLike(String value) {
            addCriterion("LEND_MEMBER_ID like", value, "lendMemberId");
            return (Criteria) this;
        }

        public Criteria andLendMemberIdNotLike(String value) {
            addCriterion("LEND_MEMBER_ID not like", value, "lendMemberId");
            return (Criteria) this;
        }

        public Criteria andLendMemberIdIn(List<String> values) {
            addCriterion("LEND_MEMBER_ID in", values, "lendMemberId");
            return (Criteria) this;
        }

        public Criteria andLendMemberIdNotIn(List<String> values) {
            addCriterion("LEND_MEMBER_ID not in", values, "lendMemberId");
            return (Criteria) this;
        }

        public Criteria andLendMemberIdBetween(String value1, String value2) {
            addCriterion("LEND_MEMBER_ID between", value1, value2, "lendMemberId");
            return (Criteria) this;
        }

        public Criteria andLendMemberIdNotBetween(String value1, String value2) {
            addCriterion("LEND_MEMBER_ID not between", value1, value2, "lendMemberId");
            return (Criteria) this;
        }

        public Criteria andLendLoginNameIsNull() {
            addCriterion("LEND_LOGIN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andLendLoginNameIsNotNull() {
            addCriterion("LEND_LOGIN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andLendLoginNameEqualTo(String value) {
            addCriterion("LEND_LOGIN_NAME =", value, "lendLoginName");
            return (Criteria) this;
        }

        public Criteria andLendLoginNameNotEqualTo(String value) {
            addCriterion("LEND_LOGIN_NAME <>", value, "lendLoginName");
            return (Criteria) this;
        }

        public Criteria andLendLoginNameGreaterThan(String value) {
            addCriterion("LEND_LOGIN_NAME >", value, "lendLoginName");
            return (Criteria) this;
        }

        public Criteria andLendLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("LEND_LOGIN_NAME >=", value, "lendLoginName");
            return (Criteria) this;
        }

        public Criteria andLendLoginNameLessThan(String value) {
            addCriterion("LEND_LOGIN_NAME <", value, "lendLoginName");
            return (Criteria) this;
        }

        public Criteria andLendLoginNameLessThanOrEqualTo(String value) {
            addCriterion("LEND_LOGIN_NAME <=", value, "lendLoginName");
            return (Criteria) this;
        }

        public Criteria andLendLoginNameLike(String value) {
            addCriterion("LEND_LOGIN_NAME like", value, "lendLoginName");
            return (Criteria) this;
        }

        public Criteria andLendLoginNameNotLike(String value) {
            addCriterion("LEND_LOGIN_NAME not like", value, "lendLoginName");
            return (Criteria) this;
        }

        public Criteria andLendLoginNameIn(List<String> values) {
            addCriterion("LEND_LOGIN_NAME in", values, "lendLoginName");
            return (Criteria) this;
        }

        public Criteria andLendLoginNameNotIn(List<String> values) {
            addCriterion("LEND_LOGIN_NAME not in", values, "lendLoginName");
            return (Criteria) this;
        }

        public Criteria andLendLoginNameBetween(String value1, String value2) {
            addCriterion("LEND_LOGIN_NAME between", value1, value2, "lendLoginName");
            return (Criteria) this;
        }

        public Criteria andLendLoginNameNotBetween(String value1, String value2) {
            addCriterion("LEND_LOGIN_NAME not between", value1, value2, "lendLoginName");
            return (Criteria) this;
        }

        public Criteria andAuditorNameIsNull() {
            addCriterion("AUDITOR_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAuditorNameIsNotNull() {
            addCriterion("AUDITOR_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAuditorNameEqualTo(String value) {
            addCriterion("AUDITOR_NAME =", value, "auditorName");
            return (Criteria) this;
        }

        public Criteria andAuditorNameNotEqualTo(String value) {
            addCriterion("AUDITOR_NAME <>", value, "auditorName");
            return (Criteria) this;
        }

        public Criteria andAuditorNameGreaterThan(String value) {
            addCriterion("AUDITOR_NAME >", value, "auditorName");
            return (Criteria) this;
        }

        public Criteria andAuditorNameGreaterThanOrEqualTo(String value) {
            addCriterion("AUDITOR_NAME >=", value, "auditorName");
            return (Criteria) this;
        }

        public Criteria andAuditorNameLessThan(String value) {
            addCriterion("AUDITOR_NAME <", value, "auditorName");
            return (Criteria) this;
        }

        public Criteria andAuditorNameLessThanOrEqualTo(String value) {
            addCriterion("AUDITOR_NAME <=", value, "auditorName");
            return (Criteria) this;
        }

        public Criteria andAuditorNameLike(String value) {
            addCriterion("AUDITOR_NAME like", value, "auditorName");
            return (Criteria) this;
        }

        public Criteria andAuditorNameNotLike(String value) {
            addCriterion("AUDITOR_NAME not like", value, "auditorName");
            return (Criteria) this;
        }

        public Criteria andAuditorNameIn(List<String> values) {
            addCriterion("AUDITOR_NAME in", values, "auditorName");
            return (Criteria) this;
        }

        public Criteria andAuditorNameNotIn(List<String> values) {
            addCriterion("AUDITOR_NAME not in", values, "auditorName");
            return (Criteria) this;
        }

        public Criteria andAuditorNameBetween(String value1, String value2) {
            addCriterion("AUDITOR_NAME between", value1, value2, "auditorName");
            return (Criteria) this;
        }

        public Criteria andAuditorNameNotBetween(String value1, String value2) {
            addCriterion("AUDITOR_NAME not between", value1, value2, "auditorName");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberidIsNull() {
            addCriterion("MERCHANT_MEMBERID is null");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberidIsNotNull() {
            addCriterion("MERCHANT_MEMBERID is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberidEqualTo(String value) {
            addCriterion("MERCHANT_MEMBERID =", value, "merchantMemberid");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberidNotEqualTo(String value) {
            addCriterion("MERCHANT_MEMBERID <>", value, "merchantMemberid");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberidGreaterThan(String value) {
            addCriterion("MERCHANT_MEMBERID >", value, "merchantMemberid");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberidGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_MEMBERID >=", value, "merchantMemberid");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberidLessThan(String value) {
            addCriterion("MERCHANT_MEMBERID <", value, "merchantMemberid");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberidLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_MEMBERID <=", value, "merchantMemberid");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberidLike(String value) {
            addCriterion("MERCHANT_MEMBERID like", value, "merchantMemberid");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberidNotLike(String value) {
            addCriterion("MERCHANT_MEMBERID not like", value, "merchantMemberid");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberidIn(List<String> values) {
            addCriterion("MERCHANT_MEMBERID in", values, "merchantMemberid");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberidNotIn(List<String> values) {
            addCriterion("MERCHANT_MEMBERID not in", values, "merchantMemberid");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberidBetween(String value1, String value2) {
            addCriterion("MERCHANT_MEMBERID between", value1, value2, "merchantMemberid");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberidNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_MEMBERID not between", value1, value2, "merchantMemberid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}