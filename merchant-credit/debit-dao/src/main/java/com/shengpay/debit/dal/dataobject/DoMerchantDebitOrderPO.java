package com.shengpay.debit.dal.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DoMerchantDebitOrderPO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * DECIMAL(18) 必填<br>
     * 
     */
    private Long id;

    /**
     * VARCHAR(32) 必填<br>
     * 商户号
     */
    private String merchantNo;

    /**
     * VARCHAR(400)<br>
     * 商户名称
     */
    private String merchantName;

    /**
     * VARCHAR(32) 必填<br>
     * 订单状态
     */
    private String status;

    /**
     * DECIMAL(18,2)<br>
     * 借款本金
     */
    private BigDecimal debitAmount;

    /**
     * VARCHAR(1024)<br>
     * 借款用途
     */
    private String purposer;

    /**
     * VARCHAR(32)<br>
     * 代理商商户号
     */
    private String promoterNo;

    /**
     * VARCHAR(400)<br>
     * 
     */
    private String promoterName;

    /**
     * TIMESTAMP(11,6)<br>
     * 申请日期
     */
    private Date applyDate;

    /**
     * TIMESTAMP(11,6)<br>
     * 审批结果日期
     */
    private Date resultTime;

    /**
     * TIMESTAMP(11,6)<br>
     * 放款成功日期
     */
    private Date transferTime;

    /**
     * TIMESTAMP(11,6)<br>
     * 起息日
     */
    private Date startTime;

    /**
     * TIMESTAMP(11,6)<br>
     * 到期日
     */
    private Date endTime;

    /**
     * TIMESTAMP(11,6)<br>
     * 逾期时间（最后还款日）
     */
    private Date overDueTime;

    /**
     * DECIMAL(18,2)<br>
     * 借款利息
     */
    private BigDecimal interestAmount;

    /**
     * DECIMAL(18,2)<br>
     * 借款期限
     */
    private BigDecimal borrowDays;

    /**
     * DECIMAL(18,2)<br>
     * 代扣服务费金额
     */
    private BigDecimal serviceAmount;

    /**
     * DECIMAL(18,2)<br>
     * 日息利率
     */
    private BigDecimal interestRateDay;

    /**
     * DECIMAL(18,2)<br>
     * 实际放款金额
     */
    private BigDecimal realAmount;

    /**
     * DECIMAL(18,2)<br>
     * 逾期滞纳金
     */
    private BigDecimal overDueAmount;

    /**
     * VARCHAR(32)<br>
     * 
     */
    private String organizationCode;

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 创建时间
     */
    private Date createTime;

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 更新时间
     */
    private Date updateTime;

    /**
     * TIMESTAMP(11,6)<br>
     * 成功还款日期
     */
    private Date repaymentTime;

    /**
     * TIMESTAMP(11,6)<br>
     * 逾期成功还款日期
     */
    private Date dueRepaymentTime;

    /**
     * DECIMAL(18) 必填<br>
     */
    public Long getId() {
        return id;
    }

    /**
     * DECIMAL(18) 必填<br>
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 商户号
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 商户号
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * VARCHAR(400)<br>
     * 获得 商户名称
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * VARCHAR(400)<br>
     * 设置 商户名称
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 订单状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 订单状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * DECIMAL(18,2)<br>
     * 获得 借款本金
     */
    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 设置 借款本金
     */
    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    /**
     * VARCHAR(1024)<br>
     * 获得 借款用途
     */
    public String getPurposer() {
        return purposer;
    }

    /**
     * VARCHAR(1024)<br>
     * 设置 借款用途
     */
    public void setPurposer(String purposer) {
        this.purposer = purposer == null ? null : purposer.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 代理商商户号
     */
    public String getPromoterNo() {
        return promoterNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 代理商商户号
     */
    public void setPromoterNo(String promoterNo) {
        this.promoterNo = promoterNo == null ? null : promoterNo.trim();
    }

    /**
     * VARCHAR(400)<br>
     */
    public String getPromoterName() {
        return promoterName;
    }

    /**
     * VARCHAR(400)<br>
     */
    public void setPromoterName(String promoterName) {
        this.promoterName = promoterName == null ? null : promoterName.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 申请日期
     */
    public Date getApplyDate() {
        return applyDate;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 申请日期
     */
    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 审批结果日期
     */
    public Date getResultTime() {
        return resultTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 审批结果日期
     */
    public void setResultTime(Date resultTime) {
        this.resultTime = resultTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 放款成功日期
     */
    public Date getTransferTime() {
        return transferTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 放款成功日期
     */
    public void setTransferTime(Date transferTime) {
        this.transferTime = transferTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 起息日
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 起息日
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 到期日
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 到期日
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 逾期时间（最后还款日）
     */
    public Date getOverDueTime() {
        return overDueTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 逾期时间（最后还款日）
     */
    public void setOverDueTime(Date overDueTime) {
        this.overDueTime = overDueTime;
    }

    /**
     * DECIMAL(18,2)<br>
     * 获得 借款利息
     */
    public BigDecimal getInterestAmount() {
        return interestAmount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 设置 借款利息
     */
    public void setInterestAmount(BigDecimal interestAmount) {
        this.interestAmount = interestAmount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 获得 借款期限
     */
    public BigDecimal getBorrowDays() {
        return borrowDays;
    }

    /**
     * DECIMAL(18,2)<br>
     * 设置 借款期限
     */
    public void setBorrowDays(BigDecimal borrowDays) {
        this.borrowDays = borrowDays;
    }

    /**
     * DECIMAL(18,2)<br>
     * 获得 代扣服务费金额
     */
    public BigDecimal getServiceAmount() {
        return serviceAmount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 设置 代扣服务费金额
     */
    public void setServiceAmount(BigDecimal serviceAmount) {
        this.serviceAmount = serviceAmount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 获得 日息利率
     */
    public BigDecimal getInterestRateDay() {
        return interestRateDay;
    }

    /**
     * DECIMAL(18,2)<br>
     * 设置 日息利率
     */
    public void setInterestRateDay(BigDecimal interestRateDay) {
        this.interestRateDay = interestRateDay;
    }

    /**
     * DECIMAL(18,2)<br>
     * 获得 实际放款金额
     */
    public BigDecimal getRealAmount() {
        return realAmount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 设置 实际放款金额
     */
    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 获得 逾期滞纳金
     */
    public BigDecimal getOverDueAmount() {
        return overDueAmount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 设置 逾期滞纳金
     */
    public void setOverDueAmount(BigDecimal overDueAmount) {
        this.overDueAmount = overDueAmount;
    }

    /**
     * VARCHAR(32)<br>
     */
    public String getOrganizationCode() {
        return organizationCode;
    }

    /**
     * VARCHAR(32)<br>
     */
    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode == null ? null : organizationCode.trim();
    }

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 获得 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 设置 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 获得 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 设置 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 成功还款日期
     */
    public Date getRepaymentTime() {
        return repaymentTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 成功还款日期
     */
    public void setRepaymentTime(Date repaymentTime) {
        this.repaymentTime = repaymentTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 逾期成功还款日期
     */
    public Date getDueRepaymentTime() {
        return dueRepaymentTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 逾期成功还款日期
     */
    public void setDueRepaymentTime(Date dueRepaymentTime) {
        this.dueRepaymentTime = dueRepaymentTime;
    }
}