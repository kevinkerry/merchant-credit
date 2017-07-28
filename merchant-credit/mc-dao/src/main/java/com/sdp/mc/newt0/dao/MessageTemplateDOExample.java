package com.sdp.mc.newt0.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageTemplateDOExample extends QueryBase {
    /**
     * This field corresponds to the database column TB_MESSAGE_TEMPLATE.ID
     * column comments 用户唯一标识，对当前公众号唯一 
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    private Long id;

    /**
     * This field corresponds to the database column TB_MESSAGE_TEMPLATE.TEMPLATE_CODE
     * column comments 短信模板编码
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    private String templateCode;

    /**
     * This field corresponds to the database column TB_MESSAGE_TEMPLATE.TEMPLATE_INFO
     * column comments 短信模板内容
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    private String templateInfo;

    /**
     * This field corresponds to the database column TB_MESSAGE_TEMPLATE.SEND_RULE
     * column comments 短信发送规则
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    private String sendRule;

    /**
     * This field corresponds to the database column TB_MESSAGE_TEMPLATE.OPERATOR
     * column comments 操作员
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    private String operator;

    /**
     * This field corresponds to the database column TB_MESSAGE_TEMPLATE.OPERATOR_ID
     * column comments 操作员ID
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    private String operatorId;

    /**
     * This field corresponds to the database column TB_MESSAGE_TEMPLATE.CREATED_AT
     * column comments 创建时间
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    private Date createdAt;

    /**
     * This field corresponds to the database column TB_MESSAGE_TEMPLATE.UPDATED_AT
     * column comments 更新时间
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    private Date updatedAt;

    /**
     * This field corresponds to the database column TB_MESSAGE_TEMPLATE.EXT1
     * column comments 备用字段1
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    private String ext1;

    /**
     * This field corresponds to the database column TB_MESSAGE_TEMPLATE.EXT2
     * column comments 备用字段2
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    private String ext2;

    /**
     * This field corresponds to the database table TB_MESSAGE_TEMPLATE
     * table comments 短信模板表
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table TB_MESSAGE_TEMPLATE
     * table comments 短信模板表
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table TB_MESSAGE_TEMPLATE
     * table comments 短信模板表
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table TB_MESSAGE_TEMPLATE
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public MessageTemplateDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column TB_MESSAGE_TEMPLATE.ID
     *
     * @return the value of TB_MESSAGE_TEMPLATE.ID
     * column comments 用户唯一标识，对当前公众号唯一 
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column TB_MESSAGE_TEMPLATE.ID
     *
     * @param id the value for TB_MESSAGE_TEMPLATE.ID
     * column comments 用户唯一标识，对当前公众号唯一 
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column TB_MESSAGE_TEMPLATE.TEMPLATE_CODE
     *
     * @return the value of TB_MESSAGE_TEMPLATE.TEMPLATE_CODE
     * column comments 短信模板编码
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String getTemplateCode() {
        return templateCode;
    }

    /**
     * This method sets the value of the database column TB_MESSAGE_TEMPLATE.TEMPLATE_CODE
     *
     * @param templateCode the value for TB_MESSAGE_TEMPLATE.TEMPLATE_CODE
     * column comments 短信模板编码
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode == null ? null : templateCode.trim();
    }

    /**
     * This method returns the value of the database column TB_MESSAGE_TEMPLATE.TEMPLATE_INFO
     *
     * @return the value of TB_MESSAGE_TEMPLATE.TEMPLATE_INFO
     * column comments 短信模板内容
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String getTemplateInfo() {
        return templateInfo;
    }

    /**
     * This method sets the value of the database column TB_MESSAGE_TEMPLATE.TEMPLATE_INFO
     *
     * @param templateInfo the value for TB_MESSAGE_TEMPLATE.TEMPLATE_INFO
     * column comments 短信模板内容
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setTemplateInfo(String templateInfo) {
        this.templateInfo = templateInfo == null ? null : templateInfo.trim();
    }

    /**
     * This method returns the value of the database column TB_MESSAGE_TEMPLATE.SEND_RULE
     *
     * @return the value of TB_MESSAGE_TEMPLATE.SEND_RULE
     * column comments 短信发送规则
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String getSendRule() {
        return sendRule;
    }

    /**
     * This method sets the value of the database column TB_MESSAGE_TEMPLATE.SEND_RULE
     *
     * @param sendRule the value for TB_MESSAGE_TEMPLATE.SEND_RULE
     * column comments 短信发送规则
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setSendRule(String sendRule) {
        this.sendRule = sendRule == null ? null : sendRule.trim();
    }

    /**
     * This method returns the value of the database column TB_MESSAGE_TEMPLATE.OPERATOR
     *
     * @return the value of TB_MESSAGE_TEMPLATE.OPERATOR
     * column comments 操作员
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method sets the value of the database column TB_MESSAGE_TEMPLATE.OPERATOR
     *
     * @param operator the value for TB_MESSAGE_TEMPLATE.OPERATOR
     * column comments 操作员
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * This method returns the value of the database column TB_MESSAGE_TEMPLATE.OPERATOR_ID
     *
     * @return the value of TB_MESSAGE_TEMPLATE.OPERATOR_ID
     * column comments 操作员ID
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * This method sets the value of the database column TB_MESSAGE_TEMPLATE.OPERATOR_ID
     *
     * @param operatorId the value for TB_MESSAGE_TEMPLATE.OPERATOR_ID
     * column comments 操作员ID
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    /**
     * This method returns the value of the database column TB_MESSAGE_TEMPLATE.CREATED_AT
     *
     * @return the value of TB_MESSAGE_TEMPLATE.CREATED_AT
     * column comments 创建时间
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method sets the value of the database column TB_MESSAGE_TEMPLATE.CREATED_AT
     *
     * @param createdAt the value for TB_MESSAGE_TEMPLATE.CREATED_AT
     * column comments 创建时间
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method returns the value of the database column TB_MESSAGE_TEMPLATE.UPDATED_AT
     *
     * @return the value of TB_MESSAGE_TEMPLATE.UPDATED_AT
     * column comments 更新时间
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method sets the value of the database column TB_MESSAGE_TEMPLATE.UPDATED_AT
     *
     * @param updatedAt the value for TB_MESSAGE_TEMPLATE.UPDATED_AT
     * column comments 更新时间
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method returns the value of the database column TB_MESSAGE_TEMPLATE.EXT1
     *
     * @return the value of TB_MESSAGE_TEMPLATE.EXT1
     * column comments 备用字段1
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * This method sets the value of the database column TB_MESSAGE_TEMPLATE.EXT1
     *
     * @param ext1 the value for TB_MESSAGE_TEMPLATE.EXT1
     * column comments 备用字段1
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    /**
     * This method returns the value of the database column TB_MESSAGE_TEMPLATE.EXT2
     *
     * @return the value of TB_MESSAGE_TEMPLATE.EXT2
     * column comments 备用字段2
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * This method sets the value of the database column TB_MESSAGE_TEMPLATE.EXT2
     *
     * @param ext2 the value for TB_MESSAGE_TEMPLATE.EXT2
     * column comments 备用字段2
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    /**
     * This method corresponds to the database table TB_MESSAGE_TEMPLATE
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table TB_MESSAGE_TEMPLATE
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table TB_MESSAGE_TEMPLATE
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table TB_MESSAGE_TEMPLATE
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table TB_MESSAGE_TEMPLATE
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table TB_MESSAGE_TEMPLATE
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table TB_MESSAGE_TEMPLATE
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_MESSAGE_TEMPLATE
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_MESSAGE_TEMPLATE
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_MESSAGE_TEMPLATE
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_MESSAGE_TEMPLATE
     * table comment :短信模板表
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
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

        public Criteria andTemplateCodeIsNull() {
            addCriterion("TEMPLATE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeIsNotNull() {
            addCriterion("TEMPLATE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeEqualTo(String value) {
            addCriterion("TEMPLATE_CODE =", value, "templateCode");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeNotEqualTo(String value) {
            addCriterion("TEMPLATE_CODE <>", value, "templateCode");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeGreaterThan(String value) {
            addCriterion("TEMPLATE_CODE >", value, "templateCode");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeGreaterThanOrEqualTo(String value) {
            addCriterion("TEMPLATE_CODE >=", value, "templateCode");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeLessThan(String value) {
            addCriterion("TEMPLATE_CODE <", value, "templateCode");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeLessThanOrEqualTo(String value) {
            addCriterion("TEMPLATE_CODE <=", value, "templateCode");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeLike(String value) {
            addCriterion("TEMPLATE_CODE like", value, "templateCode");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeNotLike(String value) {
            addCriterion("TEMPLATE_CODE not like", value, "templateCode");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeIn(List<String> values) {
            addCriterion("TEMPLATE_CODE in", values, "templateCode");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeNotIn(List<String> values) {
            addCriterion("TEMPLATE_CODE not in", values, "templateCode");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeBetween(String value1, String value2) {
            addCriterion("TEMPLATE_CODE between", value1, value2, "templateCode");
            return (Criteria) this;
        }

        public Criteria andTemplateCodeNotBetween(String value1, String value2) {
            addCriterion("TEMPLATE_CODE not between", value1, value2, "templateCode");
            return (Criteria) this;
        }

        public Criteria andTemplateInfoIsNull() {
            addCriterion("TEMPLATE_INFO is null");
            return (Criteria) this;
        }

        public Criteria andTemplateInfoIsNotNull() {
            addCriterion("TEMPLATE_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateInfoEqualTo(String value) {
            addCriterion("TEMPLATE_INFO =", value, "templateInfo");
            return (Criteria) this;
        }

        public Criteria andTemplateInfoNotEqualTo(String value) {
            addCriterion("TEMPLATE_INFO <>", value, "templateInfo");
            return (Criteria) this;
        }

        public Criteria andTemplateInfoGreaterThan(String value) {
            addCriterion("TEMPLATE_INFO >", value, "templateInfo");
            return (Criteria) this;
        }

        public Criteria andTemplateInfoGreaterThanOrEqualTo(String value) {
            addCriterion("TEMPLATE_INFO >=", value, "templateInfo");
            return (Criteria) this;
        }

        public Criteria andTemplateInfoLessThan(String value) {
            addCriterion("TEMPLATE_INFO <", value, "templateInfo");
            return (Criteria) this;
        }

        public Criteria andTemplateInfoLessThanOrEqualTo(String value) {
            addCriterion("TEMPLATE_INFO <=", value, "templateInfo");
            return (Criteria) this;
        }

        public Criteria andTemplateInfoLike(String value) {
            addCriterion("TEMPLATE_INFO like", value, "templateInfo");
            return (Criteria) this;
        }

        public Criteria andTemplateInfoNotLike(String value) {
            addCriterion("TEMPLATE_INFO not like", value, "templateInfo");
            return (Criteria) this;
        }

        public Criteria andTemplateInfoIn(List<String> values) {
            addCriterion("TEMPLATE_INFO in", values, "templateInfo");
            return (Criteria) this;
        }

        public Criteria andTemplateInfoNotIn(List<String> values) {
            addCriterion("TEMPLATE_INFO not in", values, "templateInfo");
            return (Criteria) this;
        }

        public Criteria andTemplateInfoBetween(String value1, String value2) {
            addCriterion("TEMPLATE_INFO between", value1, value2, "templateInfo");
            return (Criteria) this;
        }

        public Criteria andTemplateInfoNotBetween(String value1, String value2) {
            addCriterion("TEMPLATE_INFO not between", value1, value2, "templateInfo");
            return (Criteria) this;
        }

        public Criteria andSendRuleIsNull() {
            addCriterion("SEND_RULE is null");
            return (Criteria) this;
        }

        public Criteria andSendRuleIsNotNull() {
            addCriterion("SEND_RULE is not null");
            return (Criteria) this;
        }

        public Criteria andSendRuleEqualTo(String value) {
            addCriterion("SEND_RULE =", value, "sendRule");
            return (Criteria) this;
        }

        public Criteria andSendRuleNotEqualTo(String value) {
            addCriterion("SEND_RULE <>", value, "sendRule");
            return (Criteria) this;
        }

        public Criteria andSendRuleGreaterThan(String value) {
            addCriterion("SEND_RULE >", value, "sendRule");
            return (Criteria) this;
        }

        public Criteria andSendRuleGreaterThanOrEqualTo(String value) {
            addCriterion("SEND_RULE >=", value, "sendRule");
            return (Criteria) this;
        }

        public Criteria andSendRuleLessThan(String value) {
            addCriterion("SEND_RULE <", value, "sendRule");
            return (Criteria) this;
        }

        public Criteria andSendRuleLessThanOrEqualTo(String value) {
            addCriterion("SEND_RULE <=", value, "sendRule");
            return (Criteria) this;
        }

        public Criteria andSendRuleLike(String value) {
            addCriterion("SEND_RULE like", value, "sendRule");
            return (Criteria) this;
        }

        public Criteria andSendRuleNotLike(String value) {
            addCriterion("SEND_RULE not like", value, "sendRule");
            return (Criteria) this;
        }

        public Criteria andSendRuleIn(List<String> values) {
            addCriterion("SEND_RULE in", values, "sendRule");
            return (Criteria) this;
        }

        public Criteria andSendRuleNotIn(List<String> values) {
            addCriterion("SEND_RULE not in", values, "sendRule");
            return (Criteria) this;
        }

        public Criteria andSendRuleBetween(String value1, String value2) {
            addCriterion("SEND_RULE between", value1, value2, "sendRule");
            return (Criteria) this;
        }

        public Criteria andSendRuleNotBetween(String value1, String value2) {
            addCriterion("SEND_RULE not between", value1, value2, "sendRule");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("OPERATOR is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("OPERATOR is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("OPERATOR =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("OPERATOR <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("OPERATOR >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATOR >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("OPERATOR <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("OPERATOR <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("OPERATOR like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("OPERATOR not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("OPERATOR in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("OPERATOR not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("OPERATOR between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("OPERATOR not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNull() {
            addCriterion("OPERATOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNotNull() {
            addCriterion("OPERATOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdEqualTo(String value) {
            addCriterion("OPERATOR_ID =", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotEqualTo(String value) {
            addCriterion("OPERATOR_ID <>", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThan(String value) {
            addCriterion("OPERATOR_ID >", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATOR_ID >=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThan(String value) {
            addCriterion("OPERATOR_ID <", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThanOrEqualTo(String value) {
            addCriterion("OPERATOR_ID <=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLike(String value) {
            addCriterion("OPERATOR_ID like", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotLike(String value) {
            addCriterion("OPERATOR_ID not like", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIn(List<String> values) {
            addCriterion("OPERATOR_ID in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotIn(List<String> values) {
            addCriterion("OPERATOR_ID not in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdBetween(String value1, String value2) {
            addCriterion("OPERATOR_ID between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotBetween(String value1, String value2) {
            addCriterion("OPERATOR_ID not between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("CREATED_AT is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("CREATED_AT is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("CREATED_AT =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("CREATED_AT <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("CREATED_AT >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATED_AT >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("CREATED_AT <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("CREATED_AT <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("CREATED_AT in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("CREATED_AT not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("CREATED_AT between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("CREATED_AT not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("UPDATED_AT is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("UPDATED_AT is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("UPDATED_AT =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("UPDATED_AT <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("UPDATED_AT >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATED_AT >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("UPDATED_AT <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("UPDATED_AT <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("UPDATED_AT in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("UPDATED_AT not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("UPDATED_AT between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("UPDATED_AT not between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andExt1IsNull() {
            addCriterion("EXT1 is null");
            return (Criteria) this;
        }

        public Criteria andExt1IsNotNull() {
            addCriterion("EXT1 is not null");
            return (Criteria) this;
        }

        public Criteria andExt1EqualTo(String value) {
            addCriterion("EXT1 =", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotEqualTo(String value) {
            addCriterion("EXT1 <>", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThan(String value) {
            addCriterion("EXT1 >", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThanOrEqualTo(String value) {
            addCriterion("EXT1 >=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThan(String value) {
            addCriterion("EXT1 <", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThanOrEqualTo(String value) {
            addCriterion("EXT1 <=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Like(String value) {
            addCriterion("EXT1 like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotLike(String value) {
            addCriterion("EXT1 not like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1In(List<String> values) {
            addCriterion("EXT1 in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotIn(List<String> values) {
            addCriterion("EXT1 not in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Between(String value1, String value2) {
            addCriterion("EXT1 between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotBetween(String value1, String value2) {
            addCriterion("EXT1 not between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt2IsNull() {
            addCriterion("EXT2 is null");
            return (Criteria) this;
        }

        public Criteria andExt2IsNotNull() {
            addCriterion("EXT2 is not null");
            return (Criteria) this;
        }

        public Criteria andExt2EqualTo(String value) {
            addCriterion("EXT2 =", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotEqualTo(String value) {
            addCriterion("EXT2 <>", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThan(String value) {
            addCriterion("EXT2 >", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThanOrEqualTo(String value) {
            addCriterion("EXT2 >=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThan(String value) {
            addCriterion("EXT2 <", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThanOrEqualTo(String value) {
            addCriterion("EXT2 <=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Like(String value) {
            addCriterion("EXT2 like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotLike(String value) {
            addCriterion("EXT2 not like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2In(List<String> values) {
            addCriterion("EXT2 in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotIn(List<String> values) {
            addCriterion("EXT2 not in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Between(String value1, String value2) {
            addCriterion("EXT2 between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotBetween(String value1, String value2) {
            addCriterion("EXT2 not between", value1, value2, "ext2");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_MESSAGE_TEMPLATE
     *
     * @mbggenerated do_not_delete_during_merge Mon Oct 12 13:53:07 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_MESSAGE_TEMPLATE
     * table comment :短信模板表
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
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