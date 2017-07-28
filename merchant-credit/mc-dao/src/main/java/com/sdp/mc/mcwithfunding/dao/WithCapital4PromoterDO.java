package com.sdp.mc.mcwithfunding.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.math.BigDecimal;
import java.util.Date;

public class WithCapital4PromoterDO extends BaseDO {
    /**
     * This field corresponds to the database column MC_WITH_CAPITAL_4PROMOTER.ID
     * column comments null
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    private Long id;

    /**
     * This field corresponds to the database column MC_WITH_CAPITAL_4PROMOTER.MC_TYPE
     * column comments 代理商类型,0003POS拓展商,0007mPOS拓展商
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    private String mcType;

    /**
     * This field corresponds to the database column MC_WITH_CAPITAL_4PROMOTER.PROMOTER_ID
     * column comments 代理商id
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    private Long promoterId;

    /**
     * This field corresponds to the database column MC_WITH_CAPITAL_4PROMOTER.MERCHANT_NO
     * column comments 代理商商户号
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    private String merchantNo;

    /**
     * This field corresponds to the database column MC_WITH_CAPITAL_4PROMOTER.PROMOTER_NAME
     * column comments 代理商名称
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    private String promoterName;

    /**
     * This field corresponds to the database column MC_WITH_CAPITAL_4PROMOTER.APPLY_DATETIME
     * column comments 申请时间
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    private Date applyDatetime;

    /**
     * This field corresponds to the database column MC_WITH_CAPITAL_4PROMOTER.AMOUNT
     * column comments 配资金额
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    private BigDecimal amount;

    /**
     * This field corresponds to the database column MC_WITH_CAPITAL_4PROMOTER.FEE_RATIO
     * column comments 配资费率
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    private String feeRatio;

    /**
     * This field corresponds to the database column MC_WITH_CAPITAL_4PROMOTER.FEE
     * column comments 配资费用
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    private BigDecimal fee;

    /**
     * This field corresponds to the database column MC_WITH_CAPITAL_4PROMOTER.CREDIT_FOS_ID
     * column comments fos授信转账id
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    private Long creditFosId;

    /**
     * This field corresponds to the database column MC_WITH_CAPITAL_4PROMOTER.CREDIT_CHANGE_ID
     * column comments 授信变更记录id
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    private Long creditChangeId;

    /**
     * This field corresponds to the database column MC_WITH_CAPITAL_4PROMOTER.REVERSAL_FOS_ID
     * column comments fos冲正转账id
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    private Long reversalFosId;

    /**
     * This field corresponds to the database column MC_WITH_CAPITAL_4PROMOTER.REVERSAL_CHANGE_ID
     * column comments 冲正变更记录id
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    private Long reversalChangeId;

    /**
     * This field corresponds to the database column MC_WITH_CAPITAL_4PROMOTER.STATUS
     * column comments 状态: 0初始化,1处理中,2fos配资成功,3fos配资失败,4msp额度修改成功,5额度修改失败,6msp额度修改成功,7msp额度配置修改失败,8fos冲正成功,9fos冲正失败
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    private Integer status;

    /**
     * This field corresponds to the database column MC_WITH_CAPITAL_4PROMOTER.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column MC_WITH_CAPITAL_4PROMOTER.BATCH_NO
     * column comments fos批量转账批次号
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    private String batchNo;

    /**
     * This field corresponds to the database column MC_WITH_CAPITAL_4PROMOTER.FEE_FOS_ID
     * column comments fos手续费转账id
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    private Long feeFosId;

    /**
     * This field corresponds to the database column MC_WITH_CAPITAL_4PROMOTER.RECOVERY_DATE
     * column comments 恢复配资额度日期
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    private Date recoveryDate;

    /**
     * This field corresponds to the database column MC_WITH_CAPITAL_4PROMOTER.RETRY_TIMES_4MSP
     * column comments msp恢复额度失败重试次数
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    private Integer retryTimes4msp;

    /**
     * This method returns the value of the database column MC_WITH_CAPITAL_4PROMOTER.ID
     *
     * @return the value of MC_WITH_CAPITAL_4PROMOTER.ID
     * column comments null
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column MC_WITH_CAPITAL_4PROMOTER.ID
     *
     * @param id the value for MC_WITH_CAPITAL_4PROMOTER.ID
     * column comments null
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column MC_WITH_CAPITAL_4PROMOTER.MC_TYPE
     *
     * @return the value of MC_WITH_CAPITAL_4PROMOTER.MC_TYPE
     * column comments 代理商类型,0003POS拓展商,0007mPOS拓展商
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public String getMcType() {
        return mcType;
    }

    /**
     * This method sets the value of the database column MC_WITH_CAPITAL_4PROMOTER.MC_TYPE
     *
     * @param mcType the value for MC_WITH_CAPITAL_4PROMOTER.MC_TYPE
     * column comments 代理商类型,0003POS拓展商,0007mPOS拓展商
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public void setMcType(String mcType) {
        this.mcType = mcType == null ? null : mcType.trim();
    }

    /**
     * This method returns the value of the database column MC_WITH_CAPITAL_4PROMOTER.PROMOTER_ID
     *
     * @return the value of MC_WITH_CAPITAL_4PROMOTER.PROMOTER_ID
     * column comments 代理商id
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public Long getPromoterId() {
        return promoterId;
    }

    /**
     * This method sets the value of the database column MC_WITH_CAPITAL_4PROMOTER.PROMOTER_ID
     *
     * @param promoterId the value for MC_WITH_CAPITAL_4PROMOTER.PROMOTER_ID
     * column comments 代理商id
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public void setPromoterId(Long promoterId) {
        this.promoterId = promoterId;
    }

    /**
     * This method returns the value of the database column MC_WITH_CAPITAL_4PROMOTER.MERCHANT_NO
     *
     * @return the value of MC_WITH_CAPITAL_4PROMOTER.MERCHANT_NO
     * column comments 代理商商户号
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * This method sets the value of the database column MC_WITH_CAPITAL_4PROMOTER.MERCHANT_NO
     *
     * @param merchantNo the value for MC_WITH_CAPITAL_4PROMOTER.MERCHANT_NO
     * column comments 代理商商户号
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * This method returns the value of the database column MC_WITH_CAPITAL_4PROMOTER.PROMOTER_NAME
     *
     * @return the value of MC_WITH_CAPITAL_4PROMOTER.PROMOTER_NAME
     * column comments 代理商名称
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public String getPromoterName() {
        return promoterName;
    }

    /**
     * This method sets the value of the database column MC_WITH_CAPITAL_4PROMOTER.PROMOTER_NAME
     *
     * @param promoterName the value for MC_WITH_CAPITAL_4PROMOTER.PROMOTER_NAME
     * column comments 代理商名称
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public void setPromoterName(String promoterName) {
        this.promoterName = promoterName == null ? null : promoterName.trim();
    }

    /**
     * This method returns the value of the database column MC_WITH_CAPITAL_4PROMOTER.APPLY_DATETIME
     *
     * @return the value of MC_WITH_CAPITAL_4PROMOTER.APPLY_DATETIME
     * column comments 申请时间
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public Date getApplyDatetime() {
        return applyDatetime;
    }

    /**
     * This method sets the value of the database column MC_WITH_CAPITAL_4PROMOTER.APPLY_DATETIME
     *
     * @param applyDatetime the value for MC_WITH_CAPITAL_4PROMOTER.APPLY_DATETIME
     * column comments 申请时间
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public void setApplyDatetime(Date applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    /**
     * This method returns the value of the database column MC_WITH_CAPITAL_4PROMOTER.AMOUNT
     *
     * @return the value of MC_WITH_CAPITAL_4PROMOTER.AMOUNT
     * column comments 配资金额
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * This method sets the value of the database column MC_WITH_CAPITAL_4PROMOTER.AMOUNT
     *
     * @param amount the value for MC_WITH_CAPITAL_4PROMOTER.AMOUNT
     * column comments 配资金额
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * This method returns the value of the database column MC_WITH_CAPITAL_4PROMOTER.FEE_RATIO
     *
     * @return the value of MC_WITH_CAPITAL_4PROMOTER.FEE_RATIO
     * column comments 配资费率
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public String getFeeRatio() {
        return feeRatio;
    }

    /**
     * This method sets the value of the database column MC_WITH_CAPITAL_4PROMOTER.FEE_RATIO
     *
     * @param feeRatio the value for MC_WITH_CAPITAL_4PROMOTER.FEE_RATIO
     * column comments 配资费率
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public void setFeeRatio(String feeRatio) {
        this.feeRatio = feeRatio == null ? null : feeRatio.trim();
    }

    /**
     * This method returns the value of the database column MC_WITH_CAPITAL_4PROMOTER.FEE
     *
     * @return the value of MC_WITH_CAPITAL_4PROMOTER.FEE
     * column comments 配资费用
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public BigDecimal getFee() {
        return fee;
    }

    /**
     * This method sets the value of the database column MC_WITH_CAPITAL_4PROMOTER.FEE
     *
     * @param fee the value for MC_WITH_CAPITAL_4PROMOTER.FEE
     * column comments 配资费用
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    /**
     * This method returns the value of the database column MC_WITH_CAPITAL_4PROMOTER.CREDIT_FOS_ID
     *
     * @return the value of MC_WITH_CAPITAL_4PROMOTER.CREDIT_FOS_ID
     * column comments fos授信转账id
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public Long getCreditFosId() {
        return creditFosId;
    }

    /**
     * This method sets the value of the database column MC_WITH_CAPITAL_4PROMOTER.CREDIT_FOS_ID
     *
     * @param creditFosId the value for MC_WITH_CAPITAL_4PROMOTER.CREDIT_FOS_ID
     * column comments fos授信转账id
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public void setCreditFosId(Long creditFosId) {
        this.creditFosId = creditFosId;
    }

    /**
     * This method returns the value of the database column MC_WITH_CAPITAL_4PROMOTER.CREDIT_CHANGE_ID
     *
     * @return the value of MC_WITH_CAPITAL_4PROMOTER.CREDIT_CHANGE_ID
     * column comments 授信变更记录id
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public Long getCreditChangeId() {
        return creditChangeId;
    }

    /**
     * This method sets the value of the database column MC_WITH_CAPITAL_4PROMOTER.CREDIT_CHANGE_ID
     *
     * @param creditChangeId the value for MC_WITH_CAPITAL_4PROMOTER.CREDIT_CHANGE_ID
     * column comments 授信变更记录id
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public void setCreditChangeId(Long creditChangeId) {
        this.creditChangeId = creditChangeId;
    }

    /**
     * This method returns the value of the database column MC_WITH_CAPITAL_4PROMOTER.REVERSAL_FOS_ID
     *
     * @return the value of MC_WITH_CAPITAL_4PROMOTER.REVERSAL_FOS_ID
     * column comments fos冲正转账id
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public Long getReversalFosId() {
        return reversalFosId;
    }

    /**
     * This method sets the value of the database column MC_WITH_CAPITAL_4PROMOTER.REVERSAL_FOS_ID
     *
     * @param reversalFosId the value for MC_WITH_CAPITAL_4PROMOTER.REVERSAL_FOS_ID
     * column comments fos冲正转账id
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public void setReversalFosId(Long reversalFosId) {
        this.reversalFosId = reversalFosId;
    }

    /**
     * This method returns the value of the database column MC_WITH_CAPITAL_4PROMOTER.REVERSAL_CHANGE_ID
     *
     * @return the value of MC_WITH_CAPITAL_4PROMOTER.REVERSAL_CHANGE_ID
     * column comments 冲正变更记录id
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public Long getReversalChangeId() {
        return reversalChangeId;
    }

    /**
     * This method sets the value of the database column MC_WITH_CAPITAL_4PROMOTER.REVERSAL_CHANGE_ID
     *
     * @param reversalChangeId the value for MC_WITH_CAPITAL_4PROMOTER.REVERSAL_CHANGE_ID
     * column comments 冲正变更记录id
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public void setReversalChangeId(Long reversalChangeId) {
        this.reversalChangeId = reversalChangeId;
    }

    /**
     * This method returns the value of the database column MC_WITH_CAPITAL_4PROMOTER.STATUS
     *
     * @return the value of MC_WITH_CAPITAL_4PROMOTER.STATUS
     * column comments 状态: 0初始化,1处理中,2fos配资成功,3fos配资失败,4msp额度修改成功,5额度修改失败,6msp额度修改成功,7msp额度配置修改失败,8fos冲正成功,9fos冲正失败
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column MC_WITH_CAPITAL_4PROMOTER.STATUS
     *
     * @param status the value for MC_WITH_CAPITAL_4PROMOTER.STATUS
     * column comments 状态: 0初始化,1处理中,2fos配资成功,3fos配资失败,4msp额度修改成功,5额度修改失败,6msp额度修改成功,7msp额度配置修改失败,8fos冲正成功,9fos冲正失败
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column MC_WITH_CAPITAL_4PROMOTER.UPDATE_TIME
     *
     * @return the value of MC_WITH_CAPITAL_4PROMOTER.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column MC_WITH_CAPITAL_4PROMOTER.UPDATE_TIME
     *
     * @param updateTime the value for MC_WITH_CAPITAL_4PROMOTER.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column MC_WITH_CAPITAL_4PROMOTER.BATCH_NO
     *
     * @return the value of MC_WITH_CAPITAL_4PROMOTER.BATCH_NO
     * column comments fos批量转账批次号
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * This method sets the value of the database column MC_WITH_CAPITAL_4PROMOTER.BATCH_NO
     *
     * @param batchNo the value for MC_WITH_CAPITAL_4PROMOTER.BATCH_NO
     * column comments fos批量转账批次号
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    /**
     * This method returns the value of the database column MC_WITH_CAPITAL_4PROMOTER.FEE_FOS_ID
     *
     * @return the value of MC_WITH_CAPITAL_4PROMOTER.FEE_FOS_ID
     * column comments fos手续费转账id
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public Long getFeeFosId() {
        return feeFosId;
    }

    /**
     * This method sets the value of the database column MC_WITH_CAPITAL_4PROMOTER.FEE_FOS_ID
     *
     * @param feeFosId the value for MC_WITH_CAPITAL_4PROMOTER.FEE_FOS_ID
     * column comments fos手续费转账id
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public void setFeeFosId(Long feeFosId) {
        this.feeFosId = feeFosId;
    }

    /**
     * This method returns the value of the database column MC_WITH_CAPITAL_4PROMOTER.RECOVERY_DATE
     *
     * @return the value of MC_WITH_CAPITAL_4PROMOTER.RECOVERY_DATE
     * column comments 恢复配资额度日期
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public Date getRecoveryDate() {
        return recoveryDate;
    }

    /**
     * This method sets the value of the database column MC_WITH_CAPITAL_4PROMOTER.RECOVERY_DATE
     *
     * @param recoveryDate the value for MC_WITH_CAPITAL_4PROMOTER.RECOVERY_DATE
     * column comments 恢复配资额度日期
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public void setRecoveryDate(Date recoveryDate) {
        this.recoveryDate = recoveryDate;
    }

    /**
     * This method returns the value of the database column MC_WITH_CAPITAL_4PROMOTER.RETRY_TIMES_4MSP
     *
     * @return the value of MC_WITH_CAPITAL_4PROMOTER.RETRY_TIMES_4MSP
     * column comments msp恢复额度失败重试次数
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public Integer getRetryTimes4msp() {
        return retryTimes4msp;
    }

    /**
     * This method sets the value of the database column MC_WITH_CAPITAL_4PROMOTER.RETRY_TIMES_4MSP
     *
     * @param retryTimes4msp the value for MC_WITH_CAPITAL_4PROMOTER.RETRY_TIMES_4MSP
     * column comments msp恢复额度失败重试次数
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public void setRetryTimes4msp(Integer retryTimes4msp) {
        this.retryTimes4msp = retryTimes4msp;
    }
}