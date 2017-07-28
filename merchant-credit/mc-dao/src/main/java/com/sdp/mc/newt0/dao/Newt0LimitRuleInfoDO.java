package com.sdp.mc.newt0.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.util.Date;

public class Newt0LimitRuleInfoDO extends BaseDO {
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
}