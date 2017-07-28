package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.math.BigDecimal;
import java.util.Date;

public class WithdrawCostConfigDO extends BaseDO {
    /**
     * This field corresponds to the database column FW_WITHDRAW_COST_CONFIG.ID
     * column comments ID
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    private Long id;

    /**
     * This field corresponds to the database column FW_WITHDRAW_COST_CONFIG.TYPE
     * column comments 配置类型（1: 默认,2:限定）
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    private Integer type;

    /**
     * This field corresponds to the database column FW_WITHDRAW_COST_CONFIG.MERCHANT_TYPE
     * column comments 商户类型
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    private String merchantType;

    /**
     * This field corresponds to the database column FW_WITHDRAW_COST_CONFIG.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    private String merchantNo;

    /**
     * This field corresponds to the database column FW_WITHDRAW_COST_CONFIG.WD_COST
     * column comments 提现费用
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    private BigDecimal wdCost;

    /**
     * This field corresponds to the database column FW_WITHDRAW_COST_CONFIG.WD_PROMOTER_SPLITTING_SCALE
     * column comments 代理商分润比例
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    private BigDecimal wdPromoterSplittingScale;

    /**
     * This field corresponds to the database column FW_WITHDRAW_COST_CONFIG.STATUS
     * column comments 状态(1: 有效，0：失效)
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    private Integer status;

    /**
     * This field corresponds to the database column FW_WITHDRAW_COST_CONFIG.OPERATOR_ID
     * column comments 操作人ID
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    private String operatorId;

    /**
     * This field corresponds to the database column FW_WITHDRAW_COST_CONFIG.OPERATOR_NAME
     * column comments 操作人名称
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    private String operatorName;

    /**
     * This field corresponds to the database column FW_WITHDRAW_COST_CONFIG.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_COST_CONFIG.UPDATE_TIME
     * column comments 更新时间
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    private Date updateTime;

    /**
     * This method returns the value of the database column FW_WITHDRAW_COST_CONFIG.ID
     *
     * @return the value of FW_WITHDRAW_COST_CONFIG.ID
     * column comments ID
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_COST_CONFIG.ID
     *
     * @param id the value for FW_WITHDRAW_COST_CONFIG.ID
     * column comments ID
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_COST_CONFIG.TYPE
     *
     * @return the value of FW_WITHDRAW_COST_CONFIG.TYPE
     * column comments 配置类型（1: 默认,2:限定）
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_COST_CONFIG.TYPE
     *
     * @param type the value for FW_WITHDRAW_COST_CONFIG.TYPE
     * column comments 配置类型（1: 默认,2:限定）
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_COST_CONFIG.MERCHANT_TYPE
     *
     * @return the value of FW_WITHDRAW_COST_CONFIG.MERCHANT_TYPE
     * column comments 商户类型
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public String getMerchantType() {
        return merchantType;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_COST_CONFIG.MERCHANT_TYPE
     *
     * @param merchantType the value for FW_WITHDRAW_COST_CONFIG.MERCHANT_TYPE
     * column comments 商户类型
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType == null ? null : merchantType.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_COST_CONFIG.MERCHANT_NO
     *
     * @return the value of FW_WITHDRAW_COST_CONFIG.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_COST_CONFIG.MERCHANT_NO
     *
     * @param merchantNo the value for FW_WITHDRAW_COST_CONFIG.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_COST_CONFIG.WD_COST
     *
     * @return the value of FW_WITHDRAW_COST_CONFIG.WD_COST
     * column comments 提现费用
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public BigDecimal getWdCost() {
        return wdCost;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_COST_CONFIG.WD_COST
     *
     * @param wdCost the value for FW_WITHDRAW_COST_CONFIG.WD_COST
     * column comments 提现费用
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void setWdCost(BigDecimal wdCost) {
        this.wdCost = wdCost;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_COST_CONFIG.WD_PROMOTER_SPLITTING_SCALE
     *
     * @return the value of FW_WITHDRAW_COST_CONFIG.WD_PROMOTER_SPLITTING_SCALE
     * column comments 代理商分润比例
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public BigDecimal getWdPromoterSplittingScale() {
        return wdPromoterSplittingScale;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_COST_CONFIG.WD_PROMOTER_SPLITTING_SCALE
     *
     * @param wdPromoterSplittingScale the value for FW_WITHDRAW_COST_CONFIG.WD_PROMOTER_SPLITTING_SCALE
     * column comments 代理商分润比例
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void setWdPromoterSplittingScale(BigDecimal wdPromoterSplittingScale) {
        this.wdPromoterSplittingScale = wdPromoterSplittingScale;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_COST_CONFIG.STATUS
     *
     * @return the value of FW_WITHDRAW_COST_CONFIG.STATUS
     * column comments 状态(1: 有效，0：失效)
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_COST_CONFIG.STATUS
     *
     * @param status the value for FW_WITHDRAW_COST_CONFIG.STATUS
     * column comments 状态(1: 有效，0：失效)
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_COST_CONFIG.OPERATOR_ID
     *
     * @return the value of FW_WITHDRAW_COST_CONFIG.OPERATOR_ID
     * column comments 操作人ID
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_COST_CONFIG.OPERATOR_ID
     *
     * @param operatorId the value for FW_WITHDRAW_COST_CONFIG.OPERATOR_ID
     * column comments 操作人ID
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_COST_CONFIG.OPERATOR_NAME
     *
     * @return the value of FW_WITHDRAW_COST_CONFIG.OPERATOR_NAME
     * column comments 操作人名称
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_COST_CONFIG.OPERATOR_NAME
     *
     * @param operatorName the value for FW_WITHDRAW_COST_CONFIG.OPERATOR_NAME
     * column comments 操作人名称
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_COST_CONFIG.CREATE_TIME
     *
     * @return the value of FW_WITHDRAW_COST_CONFIG.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_COST_CONFIG.CREATE_TIME
     *
     * @param createTime the value for FW_WITHDRAW_COST_CONFIG.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_COST_CONFIG.UPDATE_TIME
     *
     * @return the value of FW_WITHDRAW_COST_CONFIG.UPDATE_TIME
     * column comments 更新时间
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_COST_CONFIG.UPDATE_TIME
     *
     * @param updateTime the value for FW_WITHDRAW_COST_CONFIG.UPDATE_TIME
     * column comments 更新时间
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}