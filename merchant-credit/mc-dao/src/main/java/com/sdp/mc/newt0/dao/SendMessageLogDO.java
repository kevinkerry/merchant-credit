package com.sdp.mc.newt0.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.util.Date;

public class SendMessageLogDO extends BaseDO {
    /**
     * This field corresponds to the database column TB_SEND_MESSAGE_LOG.ID
     * column comments 用户唯一标识，对当前公众号唯一 
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    private Long id;

    /**
     * This field corresponds to the database column TB_SEND_MESSAGE_LOG.PHONE
     * column comments 发送手机号
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    private String phone;

    /**
     * This field corresponds to the database column TB_SEND_MESSAGE_LOG.TEMPLATE_CODE
     * column comments 短信模板编码
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    private String templateCode;

    /**
     * This field corresponds to the database column TB_SEND_MESSAGE_LOG.MESSAGE_INFO
     * column comments 短信内容
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    private String messageInfo;

    /**
     * This field corresponds to the database column TB_SEND_MESSAGE_LOG.SEND_STATE
     * column comments 发送状态
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    private String sendState;

    /**
     * This field corresponds to the database column TB_SEND_MESSAGE_LOG.SEND_RESULT_INFO
     * column comments 成功失败信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    private String sendResultInfo;

    /**
     * This field corresponds to the database column TB_SEND_MESSAGE_LOG.OPERATOR
     * column comments null
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    private String operator;

    /**
     * This field corresponds to the database column TB_SEND_MESSAGE_LOG.OPERATOR_ID
     * column comments null
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    private String operatorId;

    /**
     * This field corresponds to the database column TB_SEND_MESSAGE_LOG.CREATED_AT
     * column comments null
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    private Date createdAt;

    /**
     * This field corresponds to the database column TB_SEND_MESSAGE_LOG.UPDATED_AT
     * column comments null
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    private Date updatedAt;

    /**
     * This field corresponds to the database column TB_SEND_MESSAGE_LOG.EXT1
     * column comments null
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    private String ext1;

    /**
     * This field corresponds to the database column TB_SEND_MESSAGE_LOG.EXT2
     * column comments null
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    private String ext2;

    /**
     * This method returns the value of the database column TB_SEND_MESSAGE_LOG.ID
     *
     * @return the value of TB_SEND_MESSAGE_LOG.ID
     * column comments 用户唯一标识，对当前公众号唯一 
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
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
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }
}