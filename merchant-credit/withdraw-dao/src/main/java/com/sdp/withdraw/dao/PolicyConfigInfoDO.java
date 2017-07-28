package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.math.BigDecimal;
import java.util.Date;

public class PolicyConfigInfoDO extends BaseDO {
    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.ID
     * column comments 主键
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private Long id;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.POLICY_ID
     * column comments 政策编码
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private String policyId;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.FAST_SETTLE_FLAG
     * column comments 快速结算标示 1 有效   0失效
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private Integer fastSettleFlag;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.AUTO_FAST_SETTLE_FLAG
     * column comments 自动快速结算标示 1 有效   0失效
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private Integer autoFastSettleFlag;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.FAST_SETTLE_LIMIT
     * column comments 快速结算额度
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private BigDecimal fastSettleLimit;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.HOLIDAY_RATIO
     * column comments 节假日费率
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private BigDecimal holidayRatio;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.WORKDAY_RATIO
     * column comments 工作日费率
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private BigDecimal workdayRatio;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.POMOTER_MODIFY_FLAG
     * column comments 代理商修改标示
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private Integer promoterModifyFlag;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.STATUS
     * column comments 状态  1 有效   0失效
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private Integer status;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private Date createTime;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.CREATE_OPERATOR
     * column comments 创建者信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private String createOperator;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.UPDATE_OPERATOR
     * column comments 修改最好修改
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private String updateOperator;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.POLICY_NAME
     * column comments 政策名称
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private String policyName;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.POLICY_TYPE
     * column comments 政策类型 1：政策类 2：MCC类
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private Integer policyType;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.DEPEND_CREDIT_AUTH_FLAG
     * column comments 依赖信用认证标示 1：需要 0：不需要
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private Integer dependCreditAuthFlag;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.WITHDRAW_COST
     * column comments 提现费用
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private BigDecimal withdrawCost;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.QUOTA_TYPE
     * column comments 额度类型 1：临时 2：永久
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private Integer quotaType;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.OA_TXN_WITHDRAW_COST
     * column comments 扫码交易提现费
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private BigDecimal oaTxnWithdrawCost;

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.ID
     *
     * @return the value of FW_POLICY_CONFIG_INFO.ID
     * column comments 主键
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.ID
     *
     * @param id the value for FW_POLICY_CONFIG_INFO.ID
     * column comments 主键
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.POLICY_ID
     *
     * @return the value of FW_POLICY_CONFIG_INFO.POLICY_ID
     * column comments 政策编码
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public String getPolicyId() {
        return policyId;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.POLICY_ID
     *
     * @param policyId the value for FW_POLICY_CONFIG_INFO.POLICY_ID
     * column comments 政策编码
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setPolicyId(String policyId) {
        this.policyId = policyId == null ? null : policyId.trim();
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.FAST_SETTLE_FLAG
     *
     * @return the value of FW_POLICY_CONFIG_INFO.FAST_SETTLE_FLAG
     * column comments 快速结算标示 1 有效   0失效
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public Integer getFastSettleFlag() {
        return fastSettleFlag;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.FAST_SETTLE_FLAG
     *
     * @param fastSettleFlag the value for FW_POLICY_CONFIG_INFO.FAST_SETTLE_FLAG
     * column comments 快速结算标示 1 有效   0失效
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setFastSettleFlag(Integer fastSettleFlag) {
        this.fastSettleFlag = fastSettleFlag;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.AUTO_FAST_SETTLE_FLAG
     *
     * @return the value of FW_POLICY_CONFIG_INFO.AUTO_FAST_SETTLE_FLAG
     * column comments 自动快速结算标示 1 有效   0失效
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public Integer getAutoFastSettleFlag() {
        return autoFastSettleFlag;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.AUTO_FAST_SETTLE_FLAG
     *
     * @param autoFastSettleFlag the value for FW_POLICY_CONFIG_INFO.AUTO_FAST_SETTLE_FLAG
     * column comments 自动快速结算标示 1 有效   0失效
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setAutoFastSettleFlag(Integer autoFastSettleFlag) {
        this.autoFastSettleFlag = autoFastSettleFlag;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.FAST_SETTLE_LIMIT
     *
     * @return the value of FW_POLICY_CONFIG_INFO.FAST_SETTLE_LIMIT
     * column comments 快速结算额度
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public BigDecimal getFastSettleLimit() {
        return fastSettleLimit;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.FAST_SETTLE_LIMIT
     *
     * @param fastSettleLimit the value for FW_POLICY_CONFIG_INFO.FAST_SETTLE_LIMIT
     * column comments 快速结算额度
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setFastSettleLimit(BigDecimal fastSettleLimit) {
        this.fastSettleLimit = fastSettleLimit;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.HOLIDAY_RATIO
     *
     * @return the value of FW_POLICY_CONFIG_INFO.HOLIDAY_RATIO
     * column comments 节假日费率
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public BigDecimal getHolidayRatio() {
        return holidayRatio;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.HOLIDAY_RATIO
     *
     * @param holidayRatio the value for FW_POLICY_CONFIG_INFO.HOLIDAY_RATIO
     * column comments 节假日费率
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setHolidayRatio(BigDecimal holidayRatio) {
        this.holidayRatio = holidayRatio;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.WORKDAY_RATIO
     *
     * @return the value of FW_POLICY_CONFIG_INFO.WORKDAY_RATIO
     * column comments 工作日费率
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public BigDecimal getWorkdayRatio() {
        return workdayRatio;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.WORKDAY_RATIO
     *
     * @param workdayRatio the value for FW_POLICY_CONFIG_INFO.WORKDAY_RATIO
     * column comments 工作日费率
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setWorkdayRatio(BigDecimal workdayRatio) {
        this.workdayRatio = workdayRatio;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.POMOTER_MODIFY_FLAG
     *
     * @return the value of FW_POLICY_CONFIG_INFO.POMOTER_MODIFY_FLAG
     * column comments 代理商修改标示
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public Integer getPromoterModifyFlag() {
        return promoterModifyFlag;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.POMOTER_MODIFY_FLAG
     *
     * @param promoterModifyFlag the value for FW_POLICY_CONFIG_INFO.POMOTER_MODIFY_FLAG
     * column comments 代理商修改标示
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setPromoterModifyFlag(Integer promoterModifyFlag) {
        this.promoterModifyFlag = promoterModifyFlag;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.STATUS
     *
     * @return the value of FW_POLICY_CONFIG_INFO.STATUS
     * column comments 状态  1 有效   0失效
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.STATUS
     *
     * @param status the value for FW_POLICY_CONFIG_INFO.STATUS
     * column comments 状态  1 有效   0失效
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.CREATE_TIME
     *
     * @return the value of FW_POLICY_CONFIG_INFO.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.CREATE_TIME
     *
     * @param createTime the value for FW_POLICY_CONFIG_INFO.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.UPDATE_TIME
     *
     * @return the value of FW_POLICY_CONFIG_INFO.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.UPDATE_TIME
     *
     * @param updateTime the value for FW_POLICY_CONFIG_INFO.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.CREATE_OPERATOR
     *
     * @return the value of FW_POLICY_CONFIG_INFO.CREATE_OPERATOR
     * column comments 创建者信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public String getCreateOperator() {
        return createOperator;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.CREATE_OPERATOR
     *
     * @param createOperator the value for FW_POLICY_CONFIG_INFO.CREATE_OPERATOR
     * column comments 创建者信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setCreateOperator(String createOperator) {
        this.createOperator = createOperator == null ? null : createOperator.trim();
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.UPDATE_OPERATOR
     *
     * @return the value of FW_POLICY_CONFIG_INFO.UPDATE_OPERATOR
     * column comments 修改最好修改
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public String getUpdateOperator() {
        return updateOperator;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.UPDATE_OPERATOR
     *
     * @param updateOperator the value for FW_POLICY_CONFIG_INFO.UPDATE_OPERATOR
     * column comments 修改最好修改
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setUpdateOperator(String updateOperator) {
        this.updateOperator = updateOperator == null ? null : updateOperator.trim();
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.POLICY_NAME
     *
     * @return the value of FW_POLICY_CONFIG_INFO.POLICY_NAME
     * column comments 政策名称
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public String getPolicyName() {
        return policyName;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.POLICY_NAME
     *
     * @param policyName the value for FW_POLICY_CONFIG_INFO.POLICY_NAME
     * column comments 政策名称
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setPolicyName(String policyName) {
        this.policyName = policyName == null ? null : policyName.trim();
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.POLICY_TYPE
     *
     * @return the value of FW_POLICY_CONFIG_INFO.POLICY_TYPE
     * column comments 政策类型 1：政策类 2：MCC类
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public Integer getPolicyType() {
        return policyType;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.POLICY_TYPE
     *
     * @param policyType the value for FW_POLICY_CONFIG_INFO.POLICY_TYPE
     * column comments 政策类型 1：政策类 2：MCC类
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setPolicyType(Integer policyType) {
        this.policyType = policyType;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.DEPEND_CREDIT_AUTH_FLAG
     *
     * @return the value of FW_POLICY_CONFIG_INFO.DEPEND_CREDIT_AUTH_FLAG
     * column comments 依赖信用认证标示 1：需要 0：不需要
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public Integer getDependCreditAuthFlag() {
        return dependCreditAuthFlag;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.DEPEND_CREDIT_AUTH_FLAG
     *
     * @param dependCreditAuthFlag the value for FW_POLICY_CONFIG_INFO.DEPEND_CREDIT_AUTH_FLAG
     * column comments 依赖信用认证标示 1：需要 0：不需要
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setDependCreditAuthFlag(Integer dependCreditAuthFlag) {
        this.dependCreditAuthFlag = dependCreditAuthFlag;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.WITHDRAW_COST
     *
     * @return the value of FW_POLICY_CONFIG_INFO.WITHDRAW_COST
     * column comments 提现费用
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public BigDecimal getWithdrawCost() {
        return withdrawCost;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.WITHDRAW_COST
     *
     * @param withdrawCost the value for FW_POLICY_CONFIG_INFO.WITHDRAW_COST
     * column comments 提现费用
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setWithdrawCost(BigDecimal withdrawCost) {
        this.withdrawCost = withdrawCost;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.QUOTA_TYPE
     *
     * @return the value of FW_POLICY_CONFIG_INFO.QUOTA_TYPE
     * column comments 额度类型 1：临时 2：永久
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public Integer getQuotaType() {
        return quotaType;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.QUOTA_TYPE
     *
     * @param quotaType the value for FW_POLICY_CONFIG_INFO.QUOTA_TYPE
     * column comments 额度类型 1：临时 2：永久
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setQuotaType(Integer quotaType) {
        this.quotaType = quotaType;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.OA_TXN_WITHDRAW_COST
     *
     * @return the value of FW_POLICY_CONFIG_INFO.OA_TXN_WITHDRAW_COST
     * column comments 扫码交易提现费
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public BigDecimal getOaTxnWithdrawCost() {
        return oaTxnWithdrawCost;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.OA_TXN_WITHDRAW_COST
     *
     * @param oaTxnWithdrawCost the value for FW_POLICY_CONFIG_INFO.OA_TXN_WITHDRAW_COST
     * column comments 扫码交易提现费
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setOaTxnWithdrawCost(BigDecimal oaTxnWithdrawCost) {
        this.oaTxnWithdrawCost = oaTxnWithdrawCost;
    }
}