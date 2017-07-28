package com.sdp.mc.mcwithfunding.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WithCapital4PromoterDOExample extends QueryBase {
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
     * This field corresponds to the database table MC_WITH_CAPITAL_4PROMOTER
     * table comments 代理商配资记录表
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table MC_WITH_CAPITAL_4PROMOTER
     * table comments 代理商配资记录表
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table MC_WITH_CAPITAL_4PROMOTER
     * table comments 代理商配资记录表
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table MC_WITH_CAPITAL_4PROMOTER
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public WithCapital4PromoterDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

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

    /**
     * This method corresponds to the database table MC_WITH_CAPITAL_4PROMOTER
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table MC_WITH_CAPITAL_4PROMOTER
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table MC_WITH_CAPITAL_4PROMOTER
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table MC_WITH_CAPITAL_4PROMOTER
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table MC_WITH_CAPITAL_4PROMOTER
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table MC_WITH_CAPITAL_4PROMOTER
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table MC_WITH_CAPITAL_4PROMOTER
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table MC_WITH_CAPITAL_4PROMOTER
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table MC_WITH_CAPITAL_4PROMOTER
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table MC_WITH_CAPITAL_4PROMOTER
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table MC_WITH_CAPITAL_4PROMOTER
     * table comment :代理商配资记录表
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
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

        public Criteria andMcTypeIsNull() {
            addCriterion("MC_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMcTypeIsNotNull() {
            addCriterion("MC_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMcTypeEqualTo(String value) {
            addCriterion("MC_TYPE =", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeNotEqualTo(String value) {
            addCriterion("MC_TYPE <>", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeGreaterThan(String value) {
            addCriterion("MC_TYPE >", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MC_TYPE >=", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeLessThan(String value) {
            addCriterion("MC_TYPE <", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeLessThanOrEqualTo(String value) {
            addCriterion("MC_TYPE <=", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeLike(String value) {
            addCriterion("MC_TYPE like", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeNotLike(String value) {
            addCriterion("MC_TYPE not like", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeIn(List<String> values) {
            addCriterion("MC_TYPE in", values, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeNotIn(List<String> values) {
            addCriterion("MC_TYPE not in", values, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeBetween(String value1, String value2) {
            addCriterion("MC_TYPE between", value1, value2, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeNotBetween(String value1, String value2) {
            addCriterion("MC_TYPE not between", value1, value2, "mcType");
            return (Criteria) this;
        }

        public Criteria andPromoterIdIsNull() {
            addCriterion("PROMOTER_ID is null");
            return (Criteria) this;
        }

        public Criteria andPromoterIdIsNotNull() {
            addCriterion("PROMOTER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPromoterIdEqualTo(Long value) {
            addCriterion("PROMOTER_ID =", value, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdNotEqualTo(Long value) {
            addCriterion("PROMOTER_ID <>", value, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdGreaterThan(Long value) {
            addCriterion("PROMOTER_ID >", value, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PROMOTER_ID >=", value, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdLessThan(Long value) {
            addCriterion("PROMOTER_ID <", value, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdLessThanOrEqualTo(Long value) {
            addCriterion("PROMOTER_ID <=", value, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdIn(List<Long> values) {
            addCriterion("PROMOTER_ID in", values, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdNotIn(List<Long> values) {
            addCriterion("PROMOTER_ID not in", values, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdBetween(Long value1, Long value2) {
            addCriterion("PROMOTER_ID between", value1, value2, "promoterId");
            return (Criteria) this;
        }

        public Criteria andPromoterIdNotBetween(Long value1, Long value2) {
            addCriterion("PROMOTER_ID not between", value1, value2, "promoterId");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIsNull() {
            addCriterion("MERCHANT_NO is null");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIsNotNull() {
            addCriterion("MERCHANT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantNoEqualTo(String value) {
            addCriterion("MERCHANT_NO =", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotEqualTo(String value) {
            addCriterion("MERCHANT_NO <>", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoGreaterThan(String value) {
            addCriterion("MERCHANT_NO >", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_NO >=", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLessThan(String value) {
            addCriterion("MERCHANT_NO <", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_NO <=", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLike(String value) {
            addCriterion("MERCHANT_NO like", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotLike(String value) {
            addCriterion("MERCHANT_NO not like", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIn(List<String> values) {
            addCriterion("MERCHANT_NO in", values, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotIn(List<String> values) {
            addCriterion("MERCHANT_NO not in", values, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoBetween(String value1, String value2) {
            addCriterion("MERCHANT_NO between", value1, value2, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_NO not between", value1, value2, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andPromoterNameIsNull() {
            addCriterion("PROMOTER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPromoterNameIsNotNull() {
            addCriterion("PROMOTER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPromoterNameEqualTo(String value) {
            addCriterion("PROMOTER_NAME =", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameNotEqualTo(String value) {
            addCriterion("PROMOTER_NAME <>", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameGreaterThan(String value) {
            addCriterion("PROMOTER_NAME >", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameGreaterThanOrEqualTo(String value) {
            addCriterion("PROMOTER_NAME >=", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameLessThan(String value) {
            addCriterion("PROMOTER_NAME <", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameLessThanOrEqualTo(String value) {
            addCriterion("PROMOTER_NAME <=", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameLike(String value) {
            addCriterion("PROMOTER_NAME like", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameNotLike(String value) {
            addCriterion("PROMOTER_NAME not like", value, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameIn(List<String> values) {
            addCriterion("PROMOTER_NAME in", values, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameNotIn(List<String> values) {
            addCriterion("PROMOTER_NAME not in", values, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameBetween(String value1, String value2) {
            addCriterion("PROMOTER_NAME between", value1, value2, "promoterName");
            return (Criteria) this;
        }

        public Criteria andPromoterNameNotBetween(String value1, String value2) {
            addCriterion("PROMOTER_NAME not between", value1, value2, "promoterName");
            return (Criteria) this;
        }

        public Criteria andApplyDatetimeIsNull() {
            addCriterion("APPLY_DATETIME is null");
            return (Criteria) this;
        }

        public Criteria andApplyDatetimeIsNotNull() {
            addCriterion("APPLY_DATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDatetimeEqualTo(Date value) {
            addCriterion("APPLY_DATETIME =", value, "applyDatetime");
            return (Criteria) this;
        }

        public Criteria andApplyDatetimeNotEqualTo(Date value) {
            addCriterion("APPLY_DATETIME <>", value, "applyDatetime");
            return (Criteria) this;
        }

        public Criteria andApplyDatetimeGreaterThan(Date value) {
            addCriterion("APPLY_DATETIME >", value, "applyDatetime");
            return (Criteria) this;
        }

        public Criteria andApplyDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("APPLY_DATETIME >=", value, "applyDatetime");
            return (Criteria) this;
        }

        public Criteria andApplyDatetimeLessThan(Date value) {
            addCriterion("APPLY_DATETIME <", value, "applyDatetime");
            return (Criteria) this;
        }

        public Criteria andApplyDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("APPLY_DATETIME <=", value, "applyDatetime");
            return (Criteria) this;
        }

        public Criteria andApplyDatetimeIn(List<Date> values) {
            addCriterion("APPLY_DATETIME in", values, "applyDatetime");
            return (Criteria) this;
        }

        public Criteria andApplyDatetimeNotIn(List<Date> values) {
            addCriterion("APPLY_DATETIME not in", values, "applyDatetime");
            return (Criteria) this;
        }

        public Criteria andApplyDatetimeBetween(Date value1, Date value2) {
            addCriterion("APPLY_DATETIME between", value1, value2, "applyDatetime");
            return (Criteria) this;
        }

        public Criteria andApplyDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("APPLY_DATETIME not between", value1, value2, "applyDatetime");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andFeeRatioIsNull() {
            addCriterion("FEE_RATIO is null");
            return (Criteria) this;
        }

        public Criteria andFeeRatioIsNotNull() {
            addCriterion("FEE_RATIO is not null");
            return (Criteria) this;
        }

        public Criteria andFeeRatioEqualTo(String value) {
            addCriterion("FEE_RATIO =", value, "feeRatio");
            return (Criteria) this;
        }

        public Criteria andFeeRatioNotEqualTo(String value) {
            addCriterion("FEE_RATIO <>", value, "feeRatio");
            return (Criteria) this;
        }

        public Criteria andFeeRatioGreaterThan(String value) {
            addCriterion("FEE_RATIO >", value, "feeRatio");
            return (Criteria) this;
        }

        public Criteria andFeeRatioGreaterThanOrEqualTo(String value) {
            addCriterion("FEE_RATIO >=", value, "feeRatio");
            return (Criteria) this;
        }

        public Criteria andFeeRatioLessThan(String value) {
            addCriterion("FEE_RATIO <", value, "feeRatio");
            return (Criteria) this;
        }

        public Criteria andFeeRatioLessThanOrEqualTo(String value) {
            addCriterion("FEE_RATIO <=", value, "feeRatio");
            return (Criteria) this;
        }

        public Criteria andFeeRatioLike(String value) {
            addCriterion("FEE_RATIO like", value, "feeRatio");
            return (Criteria) this;
        }

        public Criteria andFeeRatioNotLike(String value) {
            addCriterion("FEE_RATIO not like", value, "feeRatio");
            return (Criteria) this;
        }

        public Criteria andFeeRatioIn(List<String> values) {
            addCriterion("FEE_RATIO in", values, "feeRatio");
            return (Criteria) this;
        }

        public Criteria andFeeRatioNotIn(List<String> values) {
            addCriterion("FEE_RATIO not in", values, "feeRatio");
            return (Criteria) this;
        }

        public Criteria andFeeRatioBetween(String value1, String value2) {
            addCriterion("FEE_RATIO between", value1, value2, "feeRatio");
            return (Criteria) this;
        }

        public Criteria andFeeRatioNotBetween(String value1, String value2) {
            addCriterion("FEE_RATIO not between", value1, value2, "feeRatio");
            return (Criteria) this;
        }

        public Criteria andFeeIsNull() {
            addCriterion("FEE is null");
            return (Criteria) this;
        }

        public Criteria andFeeIsNotNull() {
            addCriterion("FEE is not null");
            return (Criteria) this;
        }

        public Criteria andFeeEqualTo(BigDecimal value) {
            addCriterion("FEE =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(BigDecimal value) {
            addCriterion("FEE <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(BigDecimal value) {
            addCriterion("FEE >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FEE >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(BigDecimal value) {
            addCriterion("FEE <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FEE <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<BigDecimal> values) {
            addCriterion("FEE in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<BigDecimal> values) {
            addCriterion("FEE not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEE between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEE not between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andCreditFosIdIsNull() {
            addCriterion("CREDIT_FOS_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreditFosIdIsNotNull() {
            addCriterion("CREDIT_FOS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreditFosIdEqualTo(Long value) {
            addCriterion("CREDIT_FOS_ID =", value, "creditFosId");
            return (Criteria) this;
        }

        public Criteria andCreditFosIdNotEqualTo(Long value) {
            addCriterion("CREDIT_FOS_ID <>", value, "creditFosId");
            return (Criteria) this;
        }

        public Criteria andCreditFosIdGreaterThan(Long value) {
            addCriterion("CREDIT_FOS_ID >", value, "creditFosId");
            return (Criteria) this;
        }

        public Criteria andCreditFosIdGreaterThanOrEqualTo(Long value) {
            addCriterion("CREDIT_FOS_ID >=", value, "creditFosId");
            return (Criteria) this;
        }

        public Criteria andCreditFosIdLessThan(Long value) {
            addCriterion("CREDIT_FOS_ID <", value, "creditFosId");
            return (Criteria) this;
        }

        public Criteria andCreditFosIdLessThanOrEqualTo(Long value) {
            addCriterion("CREDIT_FOS_ID <=", value, "creditFosId");
            return (Criteria) this;
        }

        public Criteria andCreditFosIdIn(List<Long> values) {
            addCriterion("CREDIT_FOS_ID in", values, "creditFosId");
            return (Criteria) this;
        }

        public Criteria andCreditFosIdNotIn(List<Long> values) {
            addCriterion("CREDIT_FOS_ID not in", values, "creditFosId");
            return (Criteria) this;
        }

        public Criteria andCreditFosIdBetween(Long value1, Long value2) {
            addCriterion("CREDIT_FOS_ID between", value1, value2, "creditFosId");
            return (Criteria) this;
        }

        public Criteria andCreditFosIdNotBetween(Long value1, Long value2) {
            addCriterion("CREDIT_FOS_ID not between", value1, value2, "creditFosId");
            return (Criteria) this;
        }

        public Criteria andCreditChangeIdIsNull() {
            addCriterion("CREDIT_CHANGE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreditChangeIdIsNotNull() {
            addCriterion("CREDIT_CHANGE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreditChangeIdEqualTo(Long value) {
            addCriterion("CREDIT_CHANGE_ID =", value, "creditChangeId");
            return (Criteria) this;
        }

        public Criteria andCreditChangeIdNotEqualTo(Long value) {
            addCriterion("CREDIT_CHANGE_ID <>", value, "creditChangeId");
            return (Criteria) this;
        }

        public Criteria andCreditChangeIdGreaterThan(Long value) {
            addCriterion("CREDIT_CHANGE_ID >", value, "creditChangeId");
            return (Criteria) this;
        }

        public Criteria andCreditChangeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("CREDIT_CHANGE_ID >=", value, "creditChangeId");
            return (Criteria) this;
        }

        public Criteria andCreditChangeIdLessThan(Long value) {
            addCriterion("CREDIT_CHANGE_ID <", value, "creditChangeId");
            return (Criteria) this;
        }

        public Criteria andCreditChangeIdLessThanOrEqualTo(Long value) {
            addCriterion("CREDIT_CHANGE_ID <=", value, "creditChangeId");
            return (Criteria) this;
        }

        public Criteria andCreditChangeIdIn(List<Long> values) {
            addCriterion("CREDIT_CHANGE_ID in", values, "creditChangeId");
            return (Criteria) this;
        }

        public Criteria andCreditChangeIdNotIn(List<Long> values) {
            addCriterion("CREDIT_CHANGE_ID not in", values, "creditChangeId");
            return (Criteria) this;
        }

        public Criteria andCreditChangeIdBetween(Long value1, Long value2) {
            addCriterion("CREDIT_CHANGE_ID between", value1, value2, "creditChangeId");
            return (Criteria) this;
        }

        public Criteria andCreditChangeIdNotBetween(Long value1, Long value2) {
            addCriterion("CREDIT_CHANGE_ID not between", value1, value2, "creditChangeId");
            return (Criteria) this;
        }

        public Criteria andReversalFosIdIsNull() {
            addCriterion("REVERSAL_FOS_ID is null");
            return (Criteria) this;
        }

        public Criteria andReversalFosIdIsNotNull() {
            addCriterion("REVERSAL_FOS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andReversalFosIdEqualTo(Long value) {
            addCriterion("REVERSAL_FOS_ID =", value, "reversalFosId");
            return (Criteria) this;
        }

        public Criteria andReversalFosIdNotEqualTo(Long value) {
            addCriterion("REVERSAL_FOS_ID <>", value, "reversalFosId");
            return (Criteria) this;
        }

        public Criteria andReversalFosIdGreaterThan(Long value) {
            addCriterion("REVERSAL_FOS_ID >", value, "reversalFosId");
            return (Criteria) this;
        }

        public Criteria andReversalFosIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REVERSAL_FOS_ID >=", value, "reversalFosId");
            return (Criteria) this;
        }

        public Criteria andReversalFosIdLessThan(Long value) {
            addCriterion("REVERSAL_FOS_ID <", value, "reversalFosId");
            return (Criteria) this;
        }

        public Criteria andReversalFosIdLessThanOrEqualTo(Long value) {
            addCriterion("REVERSAL_FOS_ID <=", value, "reversalFosId");
            return (Criteria) this;
        }

        public Criteria andReversalFosIdIn(List<Long> values) {
            addCriterion("REVERSAL_FOS_ID in", values, "reversalFosId");
            return (Criteria) this;
        }

        public Criteria andReversalFosIdNotIn(List<Long> values) {
            addCriterion("REVERSAL_FOS_ID not in", values, "reversalFosId");
            return (Criteria) this;
        }

        public Criteria andReversalFosIdBetween(Long value1, Long value2) {
            addCriterion("REVERSAL_FOS_ID between", value1, value2, "reversalFosId");
            return (Criteria) this;
        }

        public Criteria andReversalFosIdNotBetween(Long value1, Long value2) {
            addCriterion("REVERSAL_FOS_ID not between", value1, value2, "reversalFosId");
            return (Criteria) this;
        }

        public Criteria andReversalChangeIdIsNull() {
            addCriterion("REVERSAL_CHANGE_ID is null");
            return (Criteria) this;
        }

        public Criteria andReversalChangeIdIsNotNull() {
            addCriterion("REVERSAL_CHANGE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andReversalChangeIdEqualTo(Long value) {
            addCriterion("REVERSAL_CHANGE_ID =", value, "reversalChangeId");
            return (Criteria) this;
        }

        public Criteria andReversalChangeIdNotEqualTo(Long value) {
            addCriterion("REVERSAL_CHANGE_ID <>", value, "reversalChangeId");
            return (Criteria) this;
        }

        public Criteria andReversalChangeIdGreaterThan(Long value) {
            addCriterion("REVERSAL_CHANGE_ID >", value, "reversalChangeId");
            return (Criteria) this;
        }

        public Criteria andReversalChangeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REVERSAL_CHANGE_ID >=", value, "reversalChangeId");
            return (Criteria) this;
        }

        public Criteria andReversalChangeIdLessThan(Long value) {
            addCriterion("REVERSAL_CHANGE_ID <", value, "reversalChangeId");
            return (Criteria) this;
        }

        public Criteria andReversalChangeIdLessThanOrEqualTo(Long value) {
            addCriterion("REVERSAL_CHANGE_ID <=", value, "reversalChangeId");
            return (Criteria) this;
        }

        public Criteria andReversalChangeIdIn(List<Long> values) {
            addCriterion("REVERSAL_CHANGE_ID in", values, "reversalChangeId");
            return (Criteria) this;
        }

        public Criteria andReversalChangeIdNotIn(List<Long> values) {
            addCriterion("REVERSAL_CHANGE_ID not in", values, "reversalChangeId");
            return (Criteria) this;
        }

        public Criteria andReversalChangeIdBetween(Long value1, Long value2) {
            addCriterion("REVERSAL_CHANGE_ID between", value1, value2, "reversalChangeId");
            return (Criteria) this;
        }

        public Criteria andReversalChangeIdNotBetween(Long value1, Long value2) {
            addCriterion("REVERSAL_CHANGE_ID not between", value1, value2, "reversalChangeId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNull() {
            addCriterion("BATCH_NO is null");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNotNull() {
            addCriterion("BATCH_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("BATCH_NO =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotEqualTo(String value) {
            addCriterion("BATCH_NO <>", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThan(String value) {
            addCriterion("BATCH_NO >", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("BATCH_NO >=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThan(String value) {
            addCriterion("BATCH_NO <", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThanOrEqualTo(String value) {
            addCriterion("BATCH_NO <=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLike(String value) {
            addCriterion("BATCH_NO like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotLike(String value) {
            addCriterion("BATCH_NO not like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoIn(List<String> values) {
            addCriterion("BATCH_NO in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotIn(List<String> values) {
            addCriterion("BATCH_NO not in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoBetween(String value1, String value2) {
            addCriterion("BATCH_NO between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotBetween(String value1, String value2) {
            addCriterion("BATCH_NO not between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andFeeFosIdIsNull() {
            addCriterion("FEE_FOS_ID is null");
            return (Criteria) this;
        }

        public Criteria andFeeFosIdIsNotNull() {
            addCriterion("FEE_FOS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFeeFosIdEqualTo(Long value) {
            addCriterion("FEE_FOS_ID =", value, "feeFosId");
            return (Criteria) this;
        }

        public Criteria andFeeFosIdNotEqualTo(Long value) {
            addCriterion("FEE_FOS_ID <>", value, "feeFosId");
            return (Criteria) this;
        }

        public Criteria andFeeFosIdGreaterThan(Long value) {
            addCriterion("FEE_FOS_ID >", value, "feeFosId");
            return (Criteria) this;
        }

        public Criteria andFeeFosIdGreaterThanOrEqualTo(Long value) {
            addCriterion("FEE_FOS_ID >=", value, "feeFosId");
            return (Criteria) this;
        }

        public Criteria andFeeFosIdLessThan(Long value) {
            addCriterion("FEE_FOS_ID <", value, "feeFosId");
            return (Criteria) this;
        }

        public Criteria andFeeFosIdLessThanOrEqualTo(Long value) {
            addCriterion("FEE_FOS_ID <=", value, "feeFosId");
            return (Criteria) this;
        }

        public Criteria andFeeFosIdIn(List<Long> values) {
            addCriterion("FEE_FOS_ID in", values, "feeFosId");
            return (Criteria) this;
        }

        public Criteria andFeeFosIdNotIn(List<Long> values) {
            addCriterion("FEE_FOS_ID not in", values, "feeFosId");
            return (Criteria) this;
        }

        public Criteria andFeeFosIdBetween(Long value1, Long value2) {
            addCriterion("FEE_FOS_ID between", value1, value2, "feeFosId");
            return (Criteria) this;
        }

        public Criteria andFeeFosIdNotBetween(Long value1, Long value2) {
            addCriterion("FEE_FOS_ID not between", value1, value2, "feeFosId");
            return (Criteria) this;
        }

        public Criteria andRecoveryDateIsNull() {
            addCriterion("RECOVERY_DATE is null");
            return (Criteria) this;
        }

        public Criteria andRecoveryDateIsNotNull() {
            addCriterion("RECOVERY_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andRecoveryDateEqualTo(Date value) {
            addCriterion("RECOVERY_DATE =", value, "recoveryDate");
            return (Criteria) this;
        }

        public Criteria andRecoveryDateNotEqualTo(Date value) {
            addCriterion("RECOVERY_DATE <>", value, "recoveryDate");
            return (Criteria) this;
        }

        public Criteria andRecoveryDateGreaterThan(Date value) {
            addCriterion("RECOVERY_DATE >", value, "recoveryDate");
            return (Criteria) this;
        }

        public Criteria andRecoveryDateGreaterThanOrEqualTo(Date value) {
            addCriterion("RECOVERY_DATE >=", value, "recoveryDate");
            return (Criteria) this;
        }

        public Criteria andRecoveryDateLessThan(Date value) {
            addCriterion("RECOVERY_DATE <", value, "recoveryDate");
            return (Criteria) this;
        }

        public Criteria andRecoveryDateLessThanOrEqualTo(Date value) {
            addCriterion("RECOVERY_DATE <=", value, "recoveryDate");
            return (Criteria) this;
        }

        public Criteria andRecoveryDateIn(List<Date> values) {
            addCriterion("RECOVERY_DATE in", values, "recoveryDate");
            return (Criteria) this;
        }

        public Criteria andRecoveryDateNotIn(List<Date> values) {
            addCriterion("RECOVERY_DATE not in", values, "recoveryDate");
            return (Criteria) this;
        }

        public Criteria andRecoveryDateBetween(Date value1, Date value2) {
            addCriterion("RECOVERY_DATE between", value1, value2, "recoveryDate");
            return (Criteria) this;
        }

        public Criteria andRecoveryDateNotBetween(Date value1, Date value2) {
            addCriterion("RECOVERY_DATE not between", value1, value2, "recoveryDate");
            return (Criteria) this;
        }

        public Criteria andRetryTimes4mspIsNull() {
            addCriterion("RETRY_TIMES_4MSP is null");
            return (Criteria) this;
        }

        public Criteria andRetryTimes4mspIsNotNull() {
            addCriterion("RETRY_TIMES_4MSP is not null");
            return (Criteria) this;
        }

        public Criteria andRetryTimes4mspEqualTo(Integer value) {
            addCriterion("RETRY_TIMES_4MSP =", value, "retryTimes4msp");
            return (Criteria) this;
        }

        public Criteria andRetryTimes4mspNotEqualTo(Integer value) {
            addCriterion("RETRY_TIMES_4MSP <>", value, "retryTimes4msp");
            return (Criteria) this;
        }

        public Criteria andRetryTimes4mspGreaterThan(Integer value) {
            addCriterion("RETRY_TIMES_4MSP >", value, "retryTimes4msp");
            return (Criteria) this;
        }

        public Criteria andRetryTimes4mspGreaterThanOrEqualTo(Integer value) {
            addCriterion("RETRY_TIMES_4MSP >=", value, "retryTimes4msp");
            return (Criteria) this;
        }

        public Criteria andRetryTimes4mspLessThan(Integer value) {
            addCriterion("RETRY_TIMES_4MSP <", value, "retryTimes4msp");
            return (Criteria) this;
        }

        public Criteria andRetryTimes4mspLessThanOrEqualTo(Integer value) {
            addCriterion("RETRY_TIMES_4MSP <=", value, "retryTimes4msp");
            return (Criteria) this;
        }

        public Criteria andRetryTimes4mspIn(List<Integer> values) {
            addCriterion("RETRY_TIMES_4MSP in", values, "retryTimes4msp");
            return (Criteria) this;
        }

        public Criteria andRetryTimes4mspNotIn(List<Integer> values) {
            addCriterion("RETRY_TIMES_4MSP not in", values, "retryTimes4msp");
            return (Criteria) this;
        }

        public Criteria andRetryTimes4mspBetween(Integer value1, Integer value2) {
            addCriterion("RETRY_TIMES_4MSP between", value1, value2, "retryTimes4msp");
            return (Criteria) this;
        }

        public Criteria andRetryTimes4mspNotBetween(Integer value1, Integer value2) {
            addCriterion("RETRY_TIMES_4MSP not between", value1, value2, "retryTimes4msp");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table MC_WITH_CAPITAL_4PROMOTER
     *
     * @mbggenerated do_not_delete_during_merge Mon Jun 08 14:31:48 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table MC_WITH_CAPITAL_4PROMOTER
     * table comment :代理商配资记录表
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
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