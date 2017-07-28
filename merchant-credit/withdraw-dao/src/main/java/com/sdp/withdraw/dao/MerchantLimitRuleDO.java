package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.math.BigDecimal;
import java.util.Date;

public class MerchantLimitRuleDO extends BaseDO {
    /**
     * This field corresponds to the database column FW_MERCHANT_LIMIT_RULE.ID
     * column comments ID
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    private Long id;

    /**
     * This field corresponds to the database column FW_MERCHANT_LIMIT_RULE.TYPE
     * column comments 配置类型（1: 默认,2:限定）
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    private Integer type;

    /**
     * This field corresponds to the database column FW_MERCHANT_LIMIT_RULE.MERCHANT_TYPE
     * column comments 商户类型
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    private String merchantType;

    /**
     * This field corresponds to the database column FW_MERCHANT_LIMIT_RULE.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    private String merchantNo;

    /**
     * This field corresponds to the database column FW_MERCHANT_LIMIT_RULE.LIMIT
     * column comments 额度
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    private BigDecimal limit;

    /**
     * This field corresponds to the database column FW_MERCHANT_LIMIT_RULE.STATUS
     * column comments 状态(1: 有效，0：失效)
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    private Integer status;

    /**
     * This field corresponds to the database column FW_MERCHANT_LIMIT_RULE.OPERATOR_ID
     * column comments 操作人ID
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    private String operatorId;

    /**
     * This field corresponds to the database column FW_MERCHANT_LIMIT_RULE.OPERATOR_NAME
     * column comments 操作人名称
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    private String operatorName;

    /**
     * This field corresponds to the database column FW_MERCHANT_LIMIT_RULE.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    private Date createTime;

    /**
     * This field corresponds to the database column FW_MERCHANT_LIMIT_RULE.UPDATE_TIME
     * column comments 更新时间
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    private Date updateTime;

    /**
     * This method returns the value of the database column FW_MERCHANT_LIMIT_RULE.ID
     *
     * @return the value of FW_MERCHANT_LIMIT_RULE.ID
     * column comments ID
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_LIMIT_RULE.ID
     *
     * @param id the value for FW_MERCHANT_LIMIT_RULE.ID
     * column comments ID
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_LIMIT_RULE.TYPE
     *
     * @return the value of FW_MERCHANT_LIMIT_RULE.TYPE
     * column comments 配置类型（1: 默认,2:限定）
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_LIMIT_RULE.TYPE
     *
     * @param type the value for FW_MERCHANT_LIMIT_RULE.TYPE
     * column comments 配置类型（1: 默认,2:限定）
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_LIMIT_RULE.MERCHANT_TYPE
     *
     * @return the value of FW_MERCHANT_LIMIT_RULE.MERCHANT_TYPE
     * column comments 商户类型
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public String getMerchantType() {
        return merchantType;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_LIMIT_RULE.MERCHANT_TYPE
     *
     * @param merchantType the value for FW_MERCHANT_LIMIT_RULE.MERCHANT_TYPE
     * column comments 商户类型
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType == null ? null : merchantType.trim();
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_LIMIT_RULE.MERCHANT_NO
     *
     * @return the value of FW_MERCHANT_LIMIT_RULE.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_LIMIT_RULE.MERCHANT_NO
     *
     * @param merchantNo the value for FW_MERCHANT_LIMIT_RULE.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_LIMIT_RULE.LIMIT
     *
     * @return the value of FW_MERCHANT_LIMIT_RULE.LIMIT
     * column comments 额度
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public BigDecimal getLimit() {
        return limit;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_LIMIT_RULE.LIMIT
     *
     * @param limit the value for FW_MERCHANT_LIMIT_RULE.LIMIT
     * column comments 额度
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_LIMIT_RULE.STATUS
     *
     * @return the value of FW_MERCHANT_LIMIT_RULE.STATUS
     * column comments 状态(1: 有效，0：失效)
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_LIMIT_RULE.STATUS
     *
     * @param status the value for FW_MERCHANT_LIMIT_RULE.STATUS
     * column comments 状态(1: 有效，0：失效)
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_LIMIT_RULE.OPERATOR_ID
     *
     * @return the value of FW_MERCHANT_LIMIT_RULE.OPERATOR_ID
     * column comments 操作人ID
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_LIMIT_RULE.OPERATOR_ID
     *
     * @param operatorId the value for FW_MERCHANT_LIMIT_RULE.OPERATOR_ID
     * column comments 操作人ID
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_LIMIT_RULE.OPERATOR_NAME
     *
     * @return the value of FW_MERCHANT_LIMIT_RULE.OPERATOR_NAME
     * column comments 操作人名称
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_LIMIT_RULE.OPERATOR_NAME
     *
     * @param operatorName the value for FW_MERCHANT_LIMIT_RULE.OPERATOR_NAME
     * column comments 操作人名称
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_LIMIT_RULE.CREATE_TIME
     *
     * @return the value of FW_MERCHANT_LIMIT_RULE.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_LIMIT_RULE.CREATE_TIME
     *
     * @param createTime the value for FW_MERCHANT_LIMIT_RULE.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column FW_MERCHANT_LIMIT_RULE.UPDATE_TIME
     *
     * @return the value of FW_MERCHANT_LIMIT_RULE.UPDATE_TIME
     * column comments 更新时间
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column FW_MERCHANT_LIMIT_RULE.UPDATE_TIME
     *
     * @param updateTime the value for FW_MERCHANT_LIMIT_RULE.UPDATE_TIME
     * column comments 更新时间
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}