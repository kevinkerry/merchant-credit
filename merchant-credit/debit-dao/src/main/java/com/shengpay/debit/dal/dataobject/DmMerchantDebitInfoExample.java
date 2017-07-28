package com.shengpay.debit.dal.dataobject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DmMerchantDebitInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DmMerchantDebitInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected DmMerchantDebitInfoExample(DmMerchantDebitInfoExample example) {
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

        public Criteria andCanUseAmountIsNull() {
            addCriterion("CAN_USE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andCanUseAmountIsNotNull() {
            addCriterion("CAN_USE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCanUseAmountEqualTo(BigDecimal value) {
            addCriterion("CAN_USE_AMOUNT =", value, "canUseAmount");
            return (Criteria) this;
        }

        public Criteria andCanUseAmountNotEqualTo(BigDecimal value) {
            addCriterion("CAN_USE_AMOUNT <>", value, "canUseAmount");
            return (Criteria) this;
        }

        public Criteria andCanUseAmountGreaterThan(BigDecimal value) {
            addCriterion("CAN_USE_AMOUNT >", value, "canUseAmount");
            return (Criteria) this;
        }

        public Criteria andCanUseAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CAN_USE_AMOUNT >=", value, "canUseAmount");
            return (Criteria) this;
        }

        public Criteria andCanUseAmountLessThan(BigDecimal value) {
            addCriterion("CAN_USE_AMOUNT <", value, "canUseAmount");
            return (Criteria) this;
        }

        public Criteria andCanUseAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CAN_USE_AMOUNT <=", value, "canUseAmount");
            return (Criteria) this;
        }

        public Criteria andCanUseAmountIn(List<BigDecimal> values) {
            addCriterion("CAN_USE_AMOUNT in", values, "canUseAmount");
            return (Criteria) this;
        }

        public Criteria andCanUseAmountNotIn(List<BigDecimal> values) {
            addCriterion("CAN_USE_AMOUNT not in", values, "canUseAmount");
            return (Criteria) this;
        }

        public Criteria andCanUseAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CAN_USE_AMOUNT between", value1, value2, "canUseAmount");
            return (Criteria) this;
        }

        public Criteria andCanUseAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CAN_USE_AMOUNT not between", value1, value2, "canUseAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountIsNull() {
            addCriterion("USED_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andUsedAmountIsNotNull() {
            addCriterion("USED_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andUsedAmountEqualTo(BigDecimal value) {
            addCriterion("USED_AMOUNT =", value, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountNotEqualTo(BigDecimal value) {
            addCriterion("USED_AMOUNT <>", value, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountGreaterThan(BigDecimal value) {
            addCriterion("USED_AMOUNT >", value, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("USED_AMOUNT >=", value, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountLessThan(BigDecimal value) {
            addCriterion("USED_AMOUNT <", value, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("USED_AMOUNT <=", value, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountIn(List<BigDecimal> values) {
            addCriterion("USED_AMOUNT in", values, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountNotIn(List<BigDecimal> values) {
            addCriterion("USED_AMOUNT not in", values, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USED_AMOUNT between", value1, value2, "usedAmount");
            return (Criteria) this;
        }

        public Criteria andUsedAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USED_AMOUNT not between", value1, value2, "usedAmount");
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

        public Criteria andFrozenAmountIsNull() {
            addCriterion("FROZEN_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountIsNotNull() {
            addCriterion("FROZEN_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountEqualTo(BigDecimal value) {
            addCriterion("FROZEN_AMOUNT =", value, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountNotEqualTo(BigDecimal value) {
            addCriterion("FROZEN_AMOUNT <>", value, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountGreaterThan(BigDecimal value) {
            addCriterion("FROZEN_AMOUNT >", value, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FROZEN_AMOUNT >=", value, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountLessThan(BigDecimal value) {
            addCriterion("FROZEN_AMOUNT <", value, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FROZEN_AMOUNT <=", value, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountIn(List<BigDecimal> values) {
            addCriterion("FROZEN_AMOUNT in", values, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountNotIn(List<BigDecimal> values) {
            addCriterion("FROZEN_AMOUNT not in", values, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FROZEN_AMOUNT between", value1, value2, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andFrozenAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FROZEN_AMOUNT not between", value1, value2, "frozenAmount");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartTimeIsNull() {
            addCriterion("EFFECTIVE_START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartTimeIsNotNull() {
            addCriterion("EFFECTIVE_START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartTimeEqualTo(Date value) {
            addCriterion("EFFECTIVE_START_TIME =", value, "effectiveStartTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartTimeNotEqualTo(Date value) {
            addCriterion("EFFECTIVE_START_TIME <>", value, "effectiveStartTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartTimeGreaterThan(Date value) {
            addCriterion("EFFECTIVE_START_TIME >", value, "effectiveStartTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EFFECTIVE_START_TIME >=", value, "effectiveStartTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartTimeLessThan(Date value) {
            addCriterion("EFFECTIVE_START_TIME <", value, "effectiveStartTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("EFFECTIVE_START_TIME <=", value, "effectiveStartTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartTimeIn(List<Date> values) {
            addCriterion("EFFECTIVE_START_TIME in", values, "effectiveStartTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartTimeNotIn(List<Date> values) {
            addCriterion("EFFECTIVE_START_TIME not in", values, "effectiveStartTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartTimeBetween(Date value1, Date value2) {
            addCriterion("EFFECTIVE_START_TIME between", value1, value2, "effectiveStartTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("EFFECTIVE_START_TIME not between", value1, value2, "effectiveStartTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndTimeIsNull() {
            addCriterion("EFFECTIVE_END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndTimeIsNotNull() {
            addCriterion("EFFECTIVE_END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndTimeEqualTo(Date value) {
            addCriterion("EFFECTIVE_END_TIME =", value, "effectiveEndTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndTimeNotEqualTo(Date value) {
            addCriterion("EFFECTIVE_END_TIME <>", value, "effectiveEndTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndTimeGreaterThan(Date value) {
            addCriterion("EFFECTIVE_END_TIME >", value, "effectiveEndTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EFFECTIVE_END_TIME >=", value, "effectiveEndTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndTimeLessThan(Date value) {
            addCriterion("EFFECTIVE_END_TIME <", value, "effectiveEndTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("EFFECTIVE_END_TIME <=", value, "effectiveEndTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndTimeIn(List<Date> values) {
            addCriterion("EFFECTIVE_END_TIME in", values, "effectiveEndTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndTimeNotIn(List<Date> values) {
            addCriterion("EFFECTIVE_END_TIME not in", values, "effectiveEndTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndTimeBetween(Date value1, Date value2) {
            addCriterion("EFFECTIVE_END_TIME between", value1, value2, "effectiveEndTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("EFFECTIVE_END_TIME not between", value1, value2, "effectiveEndTime");
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

        public Criteria andLendWalletAccountIsNull() {
            addCriterion("LEND_WALLET_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andLendWalletAccountIsNotNull() {
            addCriterion("LEND_WALLET_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andLendWalletAccountEqualTo(String value) {
            addCriterion("LEND_WALLET_ACCOUNT =", value, "lendWalletAccount");
            return (Criteria) this;
        }

        public Criteria andLendWalletAccountNotEqualTo(String value) {
            addCriterion("LEND_WALLET_ACCOUNT <>", value, "lendWalletAccount");
            return (Criteria) this;
        }

        public Criteria andLendWalletAccountGreaterThan(String value) {
            addCriterion("LEND_WALLET_ACCOUNT >", value, "lendWalletAccount");
            return (Criteria) this;
        }

        public Criteria andLendWalletAccountGreaterThanOrEqualTo(String value) {
            addCriterion("LEND_WALLET_ACCOUNT >=", value, "lendWalletAccount");
            return (Criteria) this;
        }

        public Criteria andLendWalletAccountLessThan(String value) {
            addCriterion("LEND_WALLET_ACCOUNT <", value, "lendWalletAccount");
            return (Criteria) this;
        }

        public Criteria andLendWalletAccountLessThanOrEqualTo(String value) {
            addCriterion("LEND_WALLET_ACCOUNT <=", value, "lendWalletAccount");
            return (Criteria) this;
        }

        public Criteria andLendWalletAccountLike(String value) {
            addCriterion("LEND_WALLET_ACCOUNT like", value, "lendWalletAccount");
            return (Criteria) this;
        }

        public Criteria andLendWalletAccountNotLike(String value) {
            addCriterion("LEND_WALLET_ACCOUNT not like", value, "lendWalletAccount");
            return (Criteria) this;
        }

        public Criteria andLendWalletAccountIn(List<String> values) {
            addCriterion("LEND_WALLET_ACCOUNT in", values, "lendWalletAccount");
            return (Criteria) this;
        }

        public Criteria andLendWalletAccountNotIn(List<String> values) {
            addCriterion("LEND_WALLET_ACCOUNT not in", values, "lendWalletAccount");
            return (Criteria) this;
        }

        public Criteria andLendWalletAccountBetween(String value1, String value2) {
            addCriterion("LEND_WALLET_ACCOUNT between", value1, value2, "lendWalletAccount");
            return (Criteria) this;
        }

        public Criteria andLendWalletAccountNotBetween(String value1, String value2) {
            addCriterion("LEND_WALLET_ACCOUNT not between", value1, value2, "lendWalletAccount");
            return (Criteria) this;
        }

        public Criteria andCreditAccountIsNull() {
            addCriterion("CREDIT_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andCreditAccountIsNotNull() {
            addCriterion("CREDIT_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCreditAccountEqualTo(String value) {
            addCriterion("CREDIT_ACCOUNT =", value, "creditAccount");
            return (Criteria) this;
        }

        public Criteria andCreditAccountNotEqualTo(String value) {
            addCriterion("CREDIT_ACCOUNT <>", value, "creditAccount");
            return (Criteria) this;
        }

        public Criteria andCreditAccountGreaterThan(String value) {
            addCriterion("CREDIT_ACCOUNT >", value, "creditAccount");
            return (Criteria) this;
        }

        public Criteria andCreditAccountGreaterThanOrEqualTo(String value) {
            addCriterion("CREDIT_ACCOUNT >=", value, "creditAccount");
            return (Criteria) this;
        }

        public Criteria andCreditAccountLessThan(String value) {
            addCriterion("CREDIT_ACCOUNT <", value, "creditAccount");
            return (Criteria) this;
        }

        public Criteria andCreditAccountLessThanOrEqualTo(String value) {
            addCriterion("CREDIT_ACCOUNT <=", value, "creditAccount");
            return (Criteria) this;
        }

        public Criteria andCreditAccountLike(String value) {
            addCriterion("CREDIT_ACCOUNT like", value, "creditAccount");
            return (Criteria) this;
        }

        public Criteria andCreditAccountNotLike(String value) {
            addCriterion("CREDIT_ACCOUNT not like", value, "creditAccount");
            return (Criteria) this;
        }

        public Criteria andCreditAccountIn(List<String> values) {
            addCriterion("CREDIT_ACCOUNT in", values, "creditAccount");
            return (Criteria) this;
        }

        public Criteria andCreditAccountNotIn(List<String> values) {
            addCriterion("CREDIT_ACCOUNT not in", values, "creditAccount");
            return (Criteria) this;
        }

        public Criteria andCreditAccountBetween(String value1, String value2) {
            addCriterion("CREDIT_ACCOUNT between", value1, value2, "creditAccount");
            return (Criteria) this;
        }

        public Criteria andCreditAccountNotBetween(String value1, String value2) {
            addCriterion("CREDIT_ACCOUNT not between", value1, value2, "creditAccount");
            return (Criteria) this;
        }

        public Criteria andInterestAccountIsNull() {
            addCriterion("INTEREST_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andInterestAccountIsNotNull() {
            addCriterion("INTEREST_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andInterestAccountEqualTo(String value) {
            addCriterion("INTEREST_ACCOUNT =", value, "interestAccount");
            return (Criteria) this;
        }

        public Criteria andInterestAccountNotEqualTo(String value) {
            addCriterion("INTEREST_ACCOUNT <>", value, "interestAccount");
            return (Criteria) this;
        }

        public Criteria andInterestAccountGreaterThan(String value) {
            addCriterion("INTEREST_ACCOUNT >", value, "interestAccount");
            return (Criteria) this;
        }

        public Criteria andInterestAccountGreaterThanOrEqualTo(String value) {
            addCriterion("INTEREST_ACCOUNT >=", value, "interestAccount");
            return (Criteria) this;
        }

        public Criteria andInterestAccountLessThan(String value) {
            addCriterion("INTEREST_ACCOUNT <", value, "interestAccount");
            return (Criteria) this;
        }

        public Criteria andInterestAccountLessThanOrEqualTo(String value) {
            addCriterion("INTEREST_ACCOUNT <=", value, "interestAccount");
            return (Criteria) this;
        }

        public Criteria andInterestAccountLike(String value) {
            addCriterion("INTEREST_ACCOUNT like", value, "interestAccount");
            return (Criteria) this;
        }

        public Criteria andInterestAccountNotLike(String value) {
            addCriterion("INTEREST_ACCOUNT not like", value, "interestAccount");
            return (Criteria) this;
        }

        public Criteria andInterestAccountIn(List<String> values) {
            addCriterion("INTEREST_ACCOUNT in", values, "interestAccount");
            return (Criteria) this;
        }

        public Criteria andInterestAccountNotIn(List<String> values) {
            addCriterion("INTEREST_ACCOUNT not in", values, "interestAccount");
            return (Criteria) this;
        }

        public Criteria andInterestAccountBetween(String value1, String value2) {
            addCriterion("INTEREST_ACCOUNT between", value1, value2, "interestAccount");
            return (Criteria) this;
        }

        public Criteria andInterestAccountNotBetween(String value1, String value2) {
            addCriterion("INTEREST_ACCOUNT not between", value1, value2, "interestAccount");
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

        public Criteria andMerchantMemberIdIsNull() {
            addCriterion("MERCHANT_MEMBER_ID is null");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdIsNotNull() {
            addCriterion("MERCHANT_MEMBER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdEqualTo(String value) {
            addCriterion("MERCHANT_MEMBER_ID =", value, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdNotEqualTo(String value) {
            addCriterion("MERCHANT_MEMBER_ID <>", value, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdGreaterThan(String value) {
            addCriterion("MERCHANT_MEMBER_ID >", value, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_MEMBER_ID >=", value, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdLessThan(String value) {
            addCriterion("MERCHANT_MEMBER_ID <", value, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_MEMBER_ID <=", value, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdLike(String value) {
            addCriterion("MERCHANT_MEMBER_ID like", value, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdNotLike(String value) {
            addCriterion("MERCHANT_MEMBER_ID not like", value, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdIn(List<String> values) {
            addCriterion("MERCHANT_MEMBER_ID in", values, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdNotIn(List<String> values) {
            addCriterion("MERCHANT_MEMBER_ID not in", values, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdBetween(String value1, String value2) {
            addCriterion("MERCHANT_MEMBER_ID between", value1, value2, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantMemberIdNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_MEMBER_ID not between", value1, value2, "merchantMemberId");
            return (Criteria) this;
        }

        public Criteria andMerchantWallerAccountIsNull() {
            addCriterion("MERCHANT_WALLER_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andMerchantWallerAccountIsNotNull() {
            addCriterion("MERCHANT_WALLER_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantWallerAccountEqualTo(String value) {
            addCriterion("MERCHANT_WALLER_ACCOUNT =", value, "merchantWallerAccount");
            return (Criteria) this;
        }

        public Criteria andMerchantWallerAccountNotEqualTo(String value) {
            addCriterion("MERCHANT_WALLER_ACCOUNT <>", value, "merchantWallerAccount");
            return (Criteria) this;
        }

        public Criteria andMerchantWallerAccountGreaterThan(String value) {
            addCriterion("MERCHANT_WALLER_ACCOUNT >", value, "merchantWallerAccount");
            return (Criteria) this;
        }

        public Criteria andMerchantWallerAccountGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_WALLER_ACCOUNT >=", value, "merchantWallerAccount");
            return (Criteria) this;
        }

        public Criteria andMerchantWallerAccountLessThan(String value) {
            addCriterion("MERCHANT_WALLER_ACCOUNT <", value, "merchantWallerAccount");
            return (Criteria) this;
        }

        public Criteria andMerchantWallerAccountLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_WALLER_ACCOUNT <=", value, "merchantWallerAccount");
            return (Criteria) this;
        }

        public Criteria andMerchantWallerAccountLike(String value) {
            addCriterion("MERCHANT_WALLER_ACCOUNT like", value, "merchantWallerAccount");
            return (Criteria) this;
        }

        public Criteria andMerchantWallerAccountNotLike(String value) {
            addCriterion("MERCHANT_WALLER_ACCOUNT not like", value, "merchantWallerAccount");
            return (Criteria) this;
        }

        public Criteria andMerchantWallerAccountIn(List<String> values) {
            addCriterion("MERCHANT_WALLER_ACCOUNT in", values, "merchantWallerAccount");
            return (Criteria) this;
        }

        public Criteria andMerchantWallerAccountNotIn(List<String> values) {
            addCriterion("MERCHANT_WALLER_ACCOUNT not in", values, "merchantWallerAccount");
            return (Criteria) this;
        }

        public Criteria andMerchantWallerAccountBetween(String value1, String value2) {
            addCriterion("MERCHANT_WALLER_ACCOUNT between", value1, value2, "merchantWallerAccount");
            return (Criteria) this;
        }

        public Criteria andMerchantWallerAccountNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_WALLER_ACCOUNT not between", value1, value2, "merchantWallerAccount");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}