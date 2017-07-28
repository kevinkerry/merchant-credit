package com.sdp.mc.newt0.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.util.Date;

public class MessageTemplateDO extends BaseDO {
    /**
     * This field corresponds to the database column TB_MESSAGE_TEMPLATE.ID
     * column comments 用户唯一标识，对当前公众号唯一 
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    private Long id;

    /**
     * This field corresponds to the database column TB_MESSAGE_TEMPLATE.TEMPLATE_CODE
     * column comments 短信模板编码
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    private String templateCode;

    /**
     * This field corresponds to the database column TB_MESSAGE_TEMPLATE.TEMPLATE_INFO
     * column comments 短信模板内容
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    private String templateInfo;

    /**
     * This field corresponds to the database column TB_MESSAGE_TEMPLATE.SEND_RULE
     * column comments 短信发送规则
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    private String sendRule;

    /**
     * This field corresponds to the database column TB_MESSAGE_TEMPLATE.OPERATOR
     * column comments 操作员
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    private String operator;

    /**
     * This field corresponds to the database column TB_MESSAGE_TEMPLATE.OPERATOR_ID
     * column comments 操作员ID
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    private String operatorId;

    /**
     * This field corresponds to the database column TB_MESSAGE_TEMPLATE.CREATED_AT
     * column comments 创建时间
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    private Date createdAt;

    /**
     * This field corresponds to the database column TB_MESSAGE_TEMPLATE.UPDATED_AT
     * column comments 更新时间
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    private Date updatedAt;

    /**
     * This field corresponds to the database column TB_MESSAGE_TEMPLATE.EXT1
     * column comments 备用字段1
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    private String ext1;

    /**
     * This field corresponds to the database column TB_MESSAGE_TEMPLATE.EXT2
     * column comments 备用字段2
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    private String ext2;

    /**
     * This method returns the value of the database column TB_MESSAGE_TEMPLATE.ID
     *
     * @return the value of TB_MESSAGE_TEMPLATE.ID
     * column comments 用户唯一标识，对当前公众号唯一 
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }
}