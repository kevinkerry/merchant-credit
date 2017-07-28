package com.sdp.mc.newt0.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SendMessageLogDOExample extends QueryBase {
    /**
     * This field corresponds to the database column TB_SEND_MESSAGE_LOG.ID
     * column comments 用户唯一标识，对当前公众号唯一 
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    private Long id;

    /**
     * This field corresponds to the database column TB_SEND_MESSAGE_LOG.PHONE
     * column comments 发送手机号
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    private String phone;

    /**
     * This field corresponds to the database column TB_SEND_MESSAGE_LOG.TEMPLATE_CODE
     * column comments 短信模板编码
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    private String templateCode;

    /**
     * This field corresponds to the database column TB_SEND_MESSAGE_LOG.MESSAGE_INFO
     * column comments 短信内容
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    private String messageInfo;

    /**
     * This field corresponds to the database column TB_SEND_MESSAGE_LOG.SEND_STATE
     * column comments 发送状态
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    private String sendState;

    /**
     * This field corresponds to the database column TB_SEND_MESSAGE_LOG.SEND_RESULT_INFO
     * column comments 成功失败信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    private String sendResultInfo;

    /**
     * This field corresponds to the database column TB_SEND_MESSAGE_LOG.OPERATOR
     * column comments null
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    private String operator;

    /**
     * This field corresponds to the database column TB_SEND_MESSAGE_LOG.OPERATOR_ID
     * column comments null
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    private String operatorId;

    /**
     * This field corresponds to the database column TB_SEND_MESSAGE_LOG.CREATED_AT
     * column comments null
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    private Date createdAt;

    /**
     * This field corresponds to the database column TB_SEND_MESSAGE_LOG.UPDATED_AT
     * column comments null
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    private Date updatedAt;

    /**
     * This field corresponds to the database column TB_SEND_MESSAGE_LOG.EXT1
     * column comments null
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    private String ext1;

    /**
     * This field corresponds to the database column TB_SEND_MESSAGE_LOG.EXT2
     * column comments null
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    private String ext2;

    /**
     * This field corresponds to the database table TB_SEND_MESSAGE_LOG
     * table comments 短信发送日志表
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table TB_SEND_MESSAGE_LOG
     * table comments 短信发送日志表
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table TB_SEND_MESSAGE_LOG
     * table comments 短信发送日志表
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table TB_SEND_MESSAGE_LOG
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public SendMessageLogDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column TB_SEND_MESSAGE_LOG.ID
     *
     * @return the value of TB_SEND_MESSAGE_LOG.ID
     * column comments 用户唯一标识，对当前公众号唯一 
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column TB_SEND_MESSAGE_LOG.ID
     *
     * @param id the value for TB_SEND_MESSAGE_LOG.ID
     * column comments 用户唯一标识，对当前公众号唯一 
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column TB_SEND_MESSAGE_LOG.PHONE
     *
     * @return the value of TB_SEND_MESSAGE_LOG.PHONE
     * column comments 发送手机号
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method sets the value of the database column TB_SEND_MESSAGE_LOG.PHONE
     *
     * @param phone the value for TB_SEND_MESSAGE_LOG.PHONE
     * column comments 发送手机号
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method returns the value of the database column TB_SEND_MESSAGE_LOG.TEMPLATE_CODE
     *
     * @return the value of TB_SEND_MESSAGE_LOG.TEMPLATE_CODE
     * column comments 短信模板编码
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String getTemplateCode() {
        return templateCode;
    }

    /**
     * This method sets the value of the database column TB_SEND_MESSAGE_LOG.TEMPLATE_CODE
     *
     * @param templateCode the value for TB_SEND_MESSAGE_LOG.TEMPLATE_CODE
     * column comments 短信模板编码
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode == null ? null : templateCode.trim();
    }

    /**
     * This method returns the value of the database column TB_SEND_MESSAGE_LOG.MESSAGE_INFO
     *
     * @return the value of TB_SEND_MESSAGE_LOG.MESSAGE_INFO
     * column comments 短信内容
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String getMessageInfo() {
        return messageInfo;
    }

    /**
     * This method sets the value of the database column TB_SEND_MESSAGE_LOG.MESSAGE_INFO
     *
     * @param messageInfo the value for TB_SEND_MESSAGE_LOG.MESSAGE_INFO
     * column comments 短信内容
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo == null ? null : messageInfo.trim();
    }

    /**
     * This method returns the value of the database column TB_SEND_MESSAGE_LOG.SEND_STATE
     *
     * @return the value of TB_SEND_MESSAGE_LOG.SEND_STATE
     * column comments 发送状态
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String getSendState() {
        return sendState;
    }

    /**
     * This method sets the value of the database column TB_SEND_MESSAGE_LOG.SEND_STATE
     *
     * @param sendState the value for TB_SEND_MESSAGE_LOG.SEND_STATE
     * column comments 发送状态
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setSendState(String sendState) {
        this.sendState = sendState == null ? null : sendState.trim();
    }

    /**
     * This method returns the value of the database column TB_SEND_MESSAGE_LOG.SEND_RESULT_INFO
     *
     * @return the value of TB_SEND_MESSAGE_LOG.SEND_RESULT_INFO
     * column comments 成功失败信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String getSendResultInfo() {
        return sendResultInfo;
    }

    /**
     * This method sets the value of the database column TB_SEND_MESSAGE_LOG.SEND_RESULT_INFO
     *
     * @param sendResultInfo the value for TB_SEND_MESSAGE_LOG.SEND_RESULT_INFO
     * column comments 成功失败信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setSendResultInfo(String sendResultInfo) {
        this.sendResultInfo = sendResultInfo == null ? null : sendResultInfo.trim();
    }

    /**
     * This method returns the value of the database column TB_SEND_MESSAGE_LOG.OPERATOR
     *
     * @return the value of TB_SEND_MESSAGE_LOG.OPERATOR
     * column comments null
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method sets the value of the database column TB_SEND_MESSAGE_LOG.OPERATOR
     *
     * @param operator the value for TB_SEND_MESSAGE_LOG.OPERATOR
     * column comments null
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * This method returns the value of the database column TB_SEND_MESSAGE_LOG.OPERATOR_ID
     *
     * @return the value of TB_SEND_MESSAGE_LOG.OPERATOR_ID
     * column comments null
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * This method sets the value of the database column TB_SEND_MESSAGE_LOG.OPERATOR_ID
     *
     * @param operatorId the value for TB_SEND_MESSAGE_LOG.OPERATOR_ID
     * column comments null
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    /**
     * This method returns the value of the database column TB_SEND_MESSAGE_LOG.CREATED_AT
     *
     * @return the value of TB_SEND_MESSAGE_LOG.CREATED_AT
     * column comments null
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method sets the value of the database column TB_SEND_MESSAGE_LOG.CREATED_AT
     *
     * @param createdAt the value for TB_SEND_MESSAGE_LOG.CREATED_AT
     * column comments null
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method returns the value of the database column TB_SEND_MESSAGE_LOG.UPDATED_AT
     *
     * @return the value of TB_SEND_MESSAGE_LOG.UPDATED_AT
     * column comments null
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method sets the value of the database column TB_SEND_MESSAGE_LOG.UPDATED_AT
     *
     * @param updatedAt the value for TB_SEND_MESSAGE_LOG.UPDATED_AT
     * column comments null
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method returns the value of the database column TB_SEND_MESSAGE_LOG.EXT1
     *
     * @return the value of TB_SEND_MESSAGE_LOG.EXT1
     * column comments null
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * This method sets the value of the database column TB_SEND_MESSAGE_LOG.EXT1
     *
     * @param ext1 the value for TB_SEND_MESSAGE_LOG.EXT1
     * column comments null
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    /**
     * This method returns the value of the database column TB_SEND_MESSAGE_LOG.EXT2
     *
     * @return the value of TB_SEND_MESSAGE_LOG.EXT2
     * column comments null
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * This method sets the value of the database column TB_SEND_MESSAGE_LOG.EXT2
     *
     * @param ext2 the value for TB_SEND_MESSAGE_LOG.EXT2
     * column comments null
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    /**
     * This method corresponds to the database table TB_SEND_MESSAGE_LOG
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table TB_SEND_MESSAGE_LOG
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table TB_SEND_MESSAGE_LOG
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table TB_SEND_MESSAGE_LOG
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table TB_SEND_MESSAGE_LOG
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table TB_SEND_MESSAGE_LOG
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table TB_SEND_MESSAGE_LOG
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_SEND_MESSAGE_LOG
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
     * This method corresponds to the database table TB_SEND_MESSAGE_LOG
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_SEND_MESSAGE_LOG
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
     * This class corresponds to the database table TB_SEND_MESSAGE_LOG
     * table comment :短信发送日志表
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

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
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

        public Criteria andMessageInfoIsNull() {
            addCriterion("MESSAGE_INFO is null");
            return (Criteria) this;
        }

        public Criteria andMessageInfoIsNotNull() {
            addCriterion("MESSAGE_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andMessageInfoEqualTo(String value) {
            addCriterion("MESSAGE_INFO =", value, "messageInfo");
            return (Criteria) this;
        }

        public Criteria andMessageInfoNotEqualTo(String value) {
            addCriterion("MESSAGE_INFO <>", value, "messageInfo");
            return (Criteria) this;
        }

        public Criteria andMessageInfoGreaterThan(String value) {
            addCriterion("MESSAGE_INFO >", value, "messageInfo");
            return (Criteria) this;
        }

        public Criteria andMessageInfoGreaterThanOrEqualTo(String value) {
            addCriterion("MESSAGE_INFO >=", value, "messageInfo");
            return (Criteria) this;
        }

        public Criteria andMessageInfoLessThan(String value) {
            addCriterion("MESSAGE_INFO <", value, "messageInfo");
            return (Criteria) this;
        }

        public Criteria andMessageInfoLessThanOrEqualTo(String value) {
            addCriterion("MESSAGE_INFO <=", value, "messageInfo");
            return (Criteria) this;
        }

        public Criteria andMessageInfoLike(String value) {
            addCriterion("MESSAGE_INFO like", value, "messageInfo");
            return (Criteria) this;
        }

        public Criteria andMessageInfoNotLike(String value) {
            addCriterion("MESSAGE_INFO not like", value, "messageInfo");
            return (Criteria) this;
        }

        public Criteria andMessageInfoIn(List<String> values) {
            addCriterion("MESSAGE_INFO in", values, "messageInfo");
            return (Criteria) this;
        }

        public Criteria andMessageInfoNotIn(List<String> values) {
            addCriterion("MESSAGE_INFO not in", values, "messageInfo");
            return (Criteria) this;
        }

        public Criteria andMessageInfoBetween(String value1, String value2) {
            addCriterion("MESSAGE_INFO between", value1, value2, "messageInfo");
            return (Criteria) this;
        }

        public Criteria andMessageInfoNotBetween(String value1, String value2) {
            addCriterion("MESSAGE_INFO not between", value1, value2, "messageInfo");
            return (Criteria) this;
        }

        public Criteria andSendStateIsNull() {
            addCriterion("SEND_STATE is null");
            return (Criteria) this;
        }

        public Criteria andSendStateIsNotNull() {
            addCriterion("SEND_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andSendStateEqualTo(String value) {
            addCriterion("SEND_STATE =", value, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateNotEqualTo(String value) {
            addCriterion("SEND_STATE <>", value, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateGreaterThan(String value) {
            addCriterion("SEND_STATE >", value, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateGreaterThanOrEqualTo(String value) {
            addCriterion("SEND_STATE >=", value, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateLessThan(String value) {
            addCriterion("SEND_STATE <", value, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateLessThanOrEqualTo(String value) {
            addCriterion("SEND_STATE <=", value, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateLike(String value) {
            addCriterion("SEND_STATE like", value, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateNotLike(String value) {
            addCriterion("SEND_STATE not like", value, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateIn(List<String> values) {
            addCriterion("SEND_STATE in", values, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateNotIn(List<String> values) {
            addCriterion("SEND_STATE not in", values, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateBetween(String value1, String value2) {
            addCriterion("SEND_STATE between", value1, value2, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateNotBetween(String value1, String value2) {
            addCriterion("SEND_STATE not between", value1, value2, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendResultInfoIsNull() {
            addCriterion("SEND_RESULT_INFO is null");
            return (Criteria) this;
        }

        public Criteria andSendResultInfoIsNotNull() {
            addCriterion("SEND_RESULT_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andSendResultInfoEqualTo(String value) {
            addCriterion("SEND_RESULT_INFO =", value, "sendResultInfo");
            return (Criteria) this;
        }

        public Criteria andSendResultInfoNotEqualTo(String value) {
            addCriterion("SEND_RESULT_INFO <>", value, "sendResultInfo");
            return (Criteria) this;
        }

        public Criteria andSendResultInfoGreaterThan(String value) {
            addCriterion("SEND_RESULT_INFO >", value, "sendResultInfo");
            return (Criteria) this;
        }

        public Criteria andSendResultInfoGreaterThanOrEqualTo(String value) {
            addCriterion("SEND_RESULT_INFO >=", value, "sendResultInfo");
            return (Criteria) this;
        }

        public Criteria andSendResultInfoLessThan(String value) {
            addCriterion("SEND_RESULT_INFO <", value, "sendResultInfo");
            return (Criteria) this;
        }

        public Criteria andSendResultInfoLessThanOrEqualTo(String value) {
            addCriterion("SEND_RESULT_INFO <=", value, "sendResultInfo");
            return (Criteria) this;
        }

        public Criteria andSendResultInfoLike(String value) {
            addCriterion("SEND_RESULT_INFO like", value, "sendResultInfo");
            return (Criteria) this;
        }

        public Criteria andSendResultInfoNotLike(String value) {
            addCriterion("SEND_RESULT_INFO not like", value, "sendResultInfo");
            return (Criteria) this;
        }

        public Criteria andSendResultInfoIn(List<String> values) {
            addCriterion("SEND_RESULT_INFO in", values, "sendResultInfo");
            return (Criteria) this;
        }

        public Criteria andSendResultInfoNotIn(List<String> values) {
            addCriterion("SEND_RESULT_INFO not in", values, "sendResultInfo");
            return (Criteria) this;
        }

        public Criteria andSendResultInfoBetween(String value1, String value2) {
            addCriterion("SEND_RESULT_INFO between", value1, value2, "sendResultInfo");
            return (Criteria) this;
        }

        public Criteria andSendResultInfoNotBetween(String value1, String value2) {
            addCriterion("SEND_RESULT_INFO not between", value1, value2, "sendResultInfo");
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
     * This class corresponds to the database table TB_SEND_MESSAGE_LOG
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
     * This class corresponds to the database table TB_SEND_MESSAGE_LOG
     * table comment :短信发送日志表
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