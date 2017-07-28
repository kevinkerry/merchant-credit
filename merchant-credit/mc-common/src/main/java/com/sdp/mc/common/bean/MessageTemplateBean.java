package com.sdp.mc.common.bean;

import java.util.Date;

import com.sdp.emall.common.dao.QueryBase;

public class MessageTemplateBean extends QueryBase {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	public String getTemplateInfo() {
		return templateInfo;
	}

	public void setTemplateInfo(String templateInfo) {
		this.templateInfo = templateInfo;
	}

	public String getSendRule() {
		return sendRule;
	}

	public void setSendRule(String sendRule) {
		this.sendRule = sendRule;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}





}