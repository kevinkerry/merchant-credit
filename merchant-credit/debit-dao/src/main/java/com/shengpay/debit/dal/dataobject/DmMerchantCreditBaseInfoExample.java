package com.shengpay.debit.dal.dataobject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DmMerchantCreditBaseInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DmMerchantCreditBaseInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected DmMerchantCreditBaseInfoExample(DmMerchantCreditBaseInfoExample example) {
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

        public Criteria andMemberIdIsNull() {
            addCriterion("MEMBER_ID is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("MEMBER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(String value) {
            addCriterion("MEMBER_ID =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(String value) {
            addCriterion("MEMBER_ID <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(String value) {
            addCriterion("MEMBER_ID >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(String value) {
            addCriterion("MEMBER_ID >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(String value) {
            addCriterion("MEMBER_ID <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(String value) {
            addCriterion("MEMBER_ID <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLike(String value) {
            addCriterion("MEMBER_ID like", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotLike(String value) {
            addCriterion("MEMBER_ID not like", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<String> values) {
            addCriterion("MEMBER_ID in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<String> values) {
            addCriterion("MEMBER_ID not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(String value1, String value2) {
            addCriterion("MEMBER_ID between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(String value1, String value2) {
            addCriterion("MEMBER_ID not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andWalletAccountIsNull() {
            addCriterion("WALLET_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andWalletAccountIsNotNull() {
            addCriterion("WALLET_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andWalletAccountEqualTo(String value) {
            addCriterion("WALLET_ACCOUNT =", value, "walletAccount");
            return (Criteria) this;
        }

        public Criteria andWalletAccountNotEqualTo(String value) {
            addCriterion("WALLET_ACCOUNT <>", value, "walletAccount");
            return (Criteria) this;
        }

        public Criteria andWalletAccountGreaterThan(String value) {
            addCriterion("WALLET_ACCOUNT >", value, "walletAccount");
            return (Criteria) this;
        }

        public Criteria andWalletAccountGreaterThanOrEqualTo(String value) {
            addCriterion("WALLET_ACCOUNT >=", value, "walletAccount");
            return (Criteria) this;
        }

        public Criteria andWalletAccountLessThan(String value) {
            addCriterion("WALLET_ACCOUNT <", value, "walletAccount");
            return (Criteria) this;
        }

        public Criteria andWalletAccountLessThanOrEqualTo(String value) {
            addCriterion("WALLET_ACCOUNT <=", value, "walletAccount");
            return (Criteria) this;
        }

        public Criteria andWalletAccountLike(String value) {
            addCriterion("WALLET_ACCOUNT like", value, "walletAccount");
            return (Criteria) this;
        }

        public Criteria andWalletAccountNotLike(String value) {
            addCriterion("WALLET_ACCOUNT not like", value, "walletAccount");
            return (Criteria) this;
        }

        public Criteria andWalletAccountIn(List<String> values) {
            addCriterion("WALLET_ACCOUNT in", values, "walletAccount");
            return (Criteria) this;
        }

        public Criteria andWalletAccountNotIn(List<String> values) {
            addCriterion("WALLET_ACCOUNT not in", values, "walletAccount");
            return (Criteria) this;
        }

        public Criteria andWalletAccountBetween(String value1, String value2) {
            addCriterion("WALLET_ACCOUNT between", value1, value2, "walletAccount");
            return (Criteria) this;
        }

        public Criteria andWalletAccountNotBetween(String value1, String value2) {
            addCriterion("WALLET_ACCOUNT not between", value1, value2, "walletAccount");
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

        public Criteria andMerchantExtInfoIsNull() {
            addCriterion("MERCHANT_EXT_INFO is null");
            return (Criteria) this;
        }

        public Criteria andMerchantExtInfoIsNotNull() {
            addCriterion("MERCHANT_EXT_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantExtInfoEqualTo(String value) {
            addCriterion("MERCHANT_EXT_INFO =", value, "merchantExtInfo");
            return (Criteria) this;
        }

        public Criteria andMerchantExtInfoNotEqualTo(String value) {
            addCriterion("MERCHANT_EXT_INFO <>", value, "merchantExtInfo");
            return (Criteria) this;
        }

        public Criteria andMerchantExtInfoGreaterThan(String value) {
            addCriterion("MERCHANT_EXT_INFO >", value, "merchantExtInfo");
            return (Criteria) this;
        }

        public Criteria andMerchantExtInfoGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_EXT_INFO >=", value, "merchantExtInfo");
            return (Criteria) this;
        }

        public Criteria andMerchantExtInfoLessThan(String value) {
            addCriterion("MERCHANT_EXT_INFO <", value, "merchantExtInfo");
            return (Criteria) this;
        }

        public Criteria andMerchantExtInfoLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_EXT_INFO <=", value, "merchantExtInfo");
            return (Criteria) this;
        }

        public Criteria andMerchantExtInfoLike(String value) {
            addCriterion("MERCHANT_EXT_INFO like", value, "merchantExtInfo");
            return (Criteria) this;
        }

        public Criteria andMerchantExtInfoNotLike(String value) {
            addCriterion("MERCHANT_EXT_INFO not like", value, "merchantExtInfo");
            return (Criteria) this;
        }

        public Criteria andMerchantExtInfoIn(List<String> values) {
            addCriterion("MERCHANT_EXT_INFO in", values, "merchantExtInfo");
            return (Criteria) this;
        }

        public Criteria andMerchantExtInfoNotIn(List<String> values) {
            addCriterion("MERCHANT_EXT_INFO not in", values, "merchantExtInfo");
            return (Criteria) this;
        }

        public Criteria andMerchantExtInfoBetween(String value1, String value2) {
            addCriterion("MERCHANT_EXT_INFO between", value1, value2, "merchantExtInfo");
            return (Criteria) this;
        }

        public Criteria andMerchantExtInfoNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_EXT_INFO not between", value1, value2, "merchantExtInfo");
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