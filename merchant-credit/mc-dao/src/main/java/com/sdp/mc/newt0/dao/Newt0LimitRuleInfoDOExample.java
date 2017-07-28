package com.sdp.mc.newt0.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Newt0LimitRuleInfoDOExample extends QueryBase {
    /**
     * This field corresponds to the database column NEWT0_LIMIT_RULE_INFO.ID
     * column comments 规则的ID
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    private Long id;

    /**
     * This field corresponds to the database column NEWT0_LIMIT_RULE_INFO.RULE_NAME
     * column comments 规则名称（应用场景）
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    private String ruleName;

    /**
     * This field corresponds to the database column NEWT0_LIMIT_RULE_INFO.RULE_LAMBDA
     * column comments 规则表达式
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    private String ruleLambda;

    /**
     * This field corresponds to the database column NEWT0_LIMIT_RULE_INFO.LAMBDA_DESC
     * column comments 表达式描述
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    private String lambdaDesc;

    /**
     * This field corresponds to the database column NEWT0_LIMIT_RULE_INFO.STATUS
     * column comments 状态   0：停用 1：启用
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    private Integer status;

    /**
     * This field corresponds to the database column NEWT0_LIMIT_RULE_INFO.CREATE_DATE
     * column comments 创建时间
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    private Date createDate;

    /**
     * This field corresponds to the database column NEWT0_LIMIT_RULE_INFO.UPDATE_DATE
     * column comments 修改时间
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    private Date updateDate;

    /**
     * This field corresponds to the database table NEWT0_LIMIT_RULE_INFO
     * table comments 商户额度规则信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table NEWT0_LIMIT_RULE_INFO
     * table comments 商户额度规则信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table NEWT0_LIMIT_RULE_INFO
     * table comments 商户额度规则信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table NEWT0_LIMIT_RULE_INFO
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public Newt0LimitRuleInfoDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column NEWT0_LIMIT_RULE_INFO.ID
     *
     * @return the value of NEWT0_LIMIT_RULE_INFO.ID
     * column comments 规则的ID
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column NEWT0_LIMIT_RULE_INFO.ID
     *
     * @param id the value for NEWT0_LIMIT_RULE_INFO.ID
     * column comments 规则的ID
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column NEWT0_LIMIT_RULE_INFO.RULE_NAME
     *
     * @return the value of NEWT0_LIMIT_RULE_INFO.RULE_NAME
     * column comments 规则名称（应用场景）
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public String getRuleName() {
        return ruleName;
    }

    /**
     * This method sets the value of the database column NEWT0_LIMIT_RULE_INFO.RULE_NAME
     *
     * @param ruleName the value for NEWT0_LIMIT_RULE_INFO.RULE_NAME
     * column comments 规则名称（应用场景）
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName == null ? null : ruleName.trim();
    }

    /**
     * This method returns the value of the database column NEWT0_LIMIT_RULE_INFO.RULE_LAMBDA
     *
     * @return the value of NEWT0_LIMIT_RULE_INFO.RULE_LAMBDA
     * column comments 规则表达式
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public String getRuleLambda() {
        return ruleLambda;
    }

    /**
     * This method sets the value of the database column NEWT0_LIMIT_RULE_INFO.RULE_LAMBDA
     *
     * @param ruleLambda the value for NEWT0_LIMIT_RULE_INFO.RULE_LAMBDA
     * column comments 规则表达式
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public void setRuleLambda(String ruleLambda) {
        this.ruleLambda = ruleLambda == null ? null : ruleLambda.trim();
    }

    /**
     * This method returns the value of the database column NEWT0_LIMIT_RULE_INFO.LAMBDA_DESC
     *
     * @return the value of NEWT0_LIMIT_RULE_INFO.LAMBDA_DESC
     * column comments 表达式描述
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public String getLambdaDesc() {
        return lambdaDesc;
    }

    /**
     * This method sets the value of the database column NEWT0_LIMIT_RULE_INFO.LAMBDA_DESC
     *
     * @param lambdaDesc the value for NEWT0_LIMIT_RULE_INFO.LAMBDA_DESC
     * column comments 表达式描述
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public void setLambdaDesc(String lambdaDesc) {
        this.lambdaDesc = lambdaDesc == null ? null : lambdaDesc.trim();
    }

    /**
     * This method returns the value of the database column NEWT0_LIMIT_RULE_INFO.STATUS
     *
     * @return the value of NEWT0_LIMIT_RULE_INFO.STATUS
     * column comments 状态   0：停用 1：启用
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column NEWT0_LIMIT_RULE_INFO.STATUS
     *
     * @param status the value for NEWT0_LIMIT_RULE_INFO.STATUS
     * column comments 状态   0：停用 1：启用
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column NEWT0_LIMIT_RULE_INFO.CREATE_DATE
     *
     * @return the value of NEWT0_LIMIT_RULE_INFO.CREATE_DATE
     * column comments 创建时间
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method sets the value of the database column NEWT0_LIMIT_RULE_INFO.CREATE_DATE
     *
     * @param createDate the value for NEWT0_LIMIT_RULE_INFO.CREATE_DATE
     * column comments 创建时间
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method returns the value of the database column NEWT0_LIMIT_RULE_INFO.UPDATE_DATE
     *
     * @return the value of NEWT0_LIMIT_RULE_INFO.UPDATE_DATE
     * column comments 修改时间
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method sets the value of the database column NEWT0_LIMIT_RULE_INFO.UPDATE_DATE
     *
     * @param updateDate the value for NEWT0_LIMIT_RULE_INFO.UPDATE_DATE
     * column comments 修改时间
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method corresponds to the database table NEWT0_LIMIT_RULE_INFO
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table NEWT0_LIMIT_RULE_INFO
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table NEWT0_LIMIT_RULE_INFO
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table NEWT0_LIMIT_RULE_INFO
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table NEWT0_LIMIT_RULE_INFO
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table NEWT0_LIMIT_RULE_INFO
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table NEWT0_LIMIT_RULE_INFO
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table NEWT0_LIMIT_RULE_INFO
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table NEWT0_LIMIT_RULE_INFO
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table NEWT0_LIMIT_RULE_INFO
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table NEWT0_LIMIT_RULE_INFO
     * table comment :商户额度规则信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
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

        public Criteria andRuleNameIsNull() {
            addCriterion("RULE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRuleNameIsNotNull() {
            addCriterion("RULE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRuleNameEqualTo(String value) {
            addCriterion("RULE_NAME =", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameNotEqualTo(String value) {
            addCriterion("RULE_NAME <>", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameGreaterThan(String value) {
            addCriterion("RULE_NAME >", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameGreaterThanOrEqualTo(String value) {
            addCriterion("RULE_NAME >=", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameLessThan(String value) {
            addCriterion("RULE_NAME <", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameLessThanOrEqualTo(String value) {
            addCriterion("RULE_NAME <=", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameLike(String value) {
            addCriterion("RULE_NAME like", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameNotLike(String value) {
            addCriterion("RULE_NAME not like", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameIn(List<String> values) {
            addCriterion("RULE_NAME in", values, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameNotIn(List<String> values) {
            addCriterion("RULE_NAME not in", values, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameBetween(String value1, String value2) {
            addCriterion("RULE_NAME between", value1, value2, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameNotBetween(String value1, String value2) {
            addCriterion("RULE_NAME not between", value1, value2, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleLambdaIsNull() {
            addCriterion("RULE_LAMBDA is null");
            return (Criteria) this;
        }

        public Criteria andRuleLambdaIsNotNull() {
            addCriterion("RULE_LAMBDA is not null");
            return (Criteria) this;
        }

        public Criteria andRuleLambdaEqualTo(String value) {
            addCriterion("RULE_LAMBDA =", value, "ruleLambda");
            return (Criteria) this;
        }

        public Criteria andRuleLambdaNotEqualTo(String value) {
            addCriterion("RULE_LAMBDA <>", value, "ruleLambda");
            return (Criteria) this;
        }

        public Criteria andRuleLambdaGreaterThan(String value) {
            addCriterion("RULE_LAMBDA >", value, "ruleLambda");
            return (Criteria) this;
        }

        public Criteria andRuleLambdaGreaterThanOrEqualTo(String value) {
            addCriterion("RULE_LAMBDA >=", value, "ruleLambda");
            return (Criteria) this;
        }

        public Criteria andRuleLambdaLessThan(String value) {
            addCriterion("RULE_LAMBDA <", value, "ruleLambda");
            return (Criteria) this;
        }

        public Criteria andRuleLambdaLessThanOrEqualTo(String value) {
            addCriterion("RULE_LAMBDA <=", value, "ruleLambda");
            return (Criteria) this;
        }

        public Criteria andRuleLambdaLike(String value) {
            addCriterion("RULE_LAMBDA like", value, "ruleLambda");
            return (Criteria) this;
        }

        public Criteria andRuleLambdaNotLike(String value) {
            addCriterion("RULE_LAMBDA not like", value, "ruleLambda");
            return (Criteria) this;
        }

        public Criteria andRuleLambdaIn(List<String> values) {
            addCriterion("RULE_LAMBDA in", values, "ruleLambda");
            return (Criteria) this;
        }

        public Criteria andRuleLambdaNotIn(List<String> values) {
            addCriterion("RULE_LAMBDA not in", values, "ruleLambda");
            return (Criteria) this;
        }

        public Criteria andRuleLambdaBetween(String value1, String value2) {
            addCriterion("RULE_LAMBDA between", value1, value2, "ruleLambda");
            return (Criteria) this;
        }

        public Criteria andRuleLambdaNotBetween(String value1, String value2) {
            addCriterion("RULE_LAMBDA not between", value1, value2, "ruleLambda");
            return (Criteria) this;
        }

        public Criteria andLambdaDescIsNull() {
            addCriterion("LAMBDA_DESC is null");
            return (Criteria) this;
        }

        public Criteria andLambdaDescIsNotNull() {
            addCriterion("LAMBDA_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andLambdaDescEqualTo(String value) {
            addCriterion("LAMBDA_DESC =", value, "lambdaDesc");
            return (Criteria) this;
        }

        public Criteria andLambdaDescNotEqualTo(String value) {
            addCriterion("LAMBDA_DESC <>", value, "lambdaDesc");
            return (Criteria) this;
        }

        public Criteria andLambdaDescGreaterThan(String value) {
            addCriterion("LAMBDA_DESC >", value, "lambdaDesc");
            return (Criteria) this;
        }

        public Criteria andLambdaDescGreaterThanOrEqualTo(String value) {
            addCriterion("LAMBDA_DESC >=", value, "lambdaDesc");
            return (Criteria) this;
        }

        public Criteria andLambdaDescLessThan(String value) {
            addCriterion("LAMBDA_DESC <", value, "lambdaDesc");
            return (Criteria) this;
        }

        public Criteria andLambdaDescLessThanOrEqualTo(String value) {
            addCriterion("LAMBDA_DESC <=", value, "lambdaDesc");
            return (Criteria) this;
        }

        public Criteria andLambdaDescLike(String value) {
            addCriterion("LAMBDA_DESC like", value, "lambdaDesc");
            return (Criteria) this;
        }

        public Criteria andLambdaDescNotLike(String value) {
            addCriterion("LAMBDA_DESC not like", value, "lambdaDesc");
            return (Criteria) this;
        }

        public Criteria andLambdaDescIn(List<String> values) {
            addCriterion("LAMBDA_DESC in", values, "lambdaDesc");
            return (Criteria) this;
        }

        public Criteria andLambdaDescNotIn(List<String> values) {
            addCriterion("LAMBDA_DESC not in", values, "lambdaDesc");
            return (Criteria) this;
        }

        public Criteria andLambdaDescBetween(String value1, String value2) {
            addCriterion("LAMBDA_DESC between", value1, value2, "lambdaDesc");
            return (Criteria) this;
        }

        public Criteria andLambdaDescNotBetween(String value1, String value2) {
            addCriterion("LAMBDA_DESC not between", value1, value2, "lambdaDesc");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("UPDATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("UPDATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("UPDATE_DATE =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("UPDATE_DATE <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("UPDATE_DATE >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATE >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("UPDATE_DATE <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATE <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("UPDATE_DATE in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("UPDATE_DATE not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATE between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATE not between", value1, value2, "updateDate");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table NEWT0_LIMIT_RULE_INFO
     *
     * @mbggenerated do_not_delete_during_merge Sun Dec 20 09:53:28 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table NEWT0_LIMIT_RULE_INFO
     * table comment :商户额度规则信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}