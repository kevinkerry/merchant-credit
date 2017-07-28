package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.util.Date;

public class WithdrawRetryPlanDO extends BaseDO {
    /**
     * This field corresponds to the database column FW_WITHDRAW_RETRY_PLAN.PLAN_ID
     * column comments 计划ID
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    private Long planId;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RETRY_PLAN.REQ_ID
     * column comments 业务单的请求ID
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    private Long reqId;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RETRY_PLAN.CURRENT_REMIT_VOUCHER_NO
     * column comments 当前的支付订单号
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    private String currentRemitVoucherNo;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RETRY_PLAN.EXECUTE_REMIT_VOUCHER_NO
     * column comments 计划执行的支付订单号
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    private String executeRemitVoucherNo;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RETRY_PLAN.RETRY_RULE
     * column comments 重试规则
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    private String retryRule;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RETRY_PLAN.RETRY_EXECUTE_TIMES
     * column comments 计划执行任务是第几次重试
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    private Integer retryExecuteTimes;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RETRY_PLAN.EXECUTE_START_TIME
     * column comments 执行重试的开始时间点
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    private Date executeStartTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RETRY_PLAN.EXECUTE_STATUS
     * column comments 执行状态0 待执行 1执行中 2 执行结束
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    private Integer executeStatus;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RETRY_PLAN.EXECUTE_TIME
     * column comments 执行时间
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    private Date executeTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RETRY_PLAN.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RETRY_PLAN.UPDATE_TIME
     * column comments 最后修改时间
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    private Date updateTime;

    /**
     * This method returns the value of the database column FW_WITHDRAW_RETRY_PLAN.PLAN_ID
     *
     * @return the value of FW_WITHDRAW_RETRY_PLAN.PLAN_ID
     * column comments 计划ID
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public Long getPlanId() {
        return planId;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RETRY_PLAN.PLAN_ID
     *
     * @param planId the value for FW_WITHDRAW_RETRY_PLAN.PLAN_ID
     * column comments 计划ID
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RETRY_PLAN.REQ_ID
     *
     * @return the value of FW_WITHDRAW_RETRY_PLAN.REQ_ID
     * column comments 业务单的请求ID
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public Long getReqId() {
        return reqId;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RETRY_PLAN.REQ_ID
     *
     * @param reqId the value for FW_WITHDRAW_RETRY_PLAN.REQ_ID
     * column comments 业务单的请求ID
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RETRY_PLAN.CURRENT_REMIT_VOUCHER_NO
     *
     * @return the value of FW_WITHDRAW_RETRY_PLAN.CURRENT_REMIT_VOUCHER_NO
     * column comments 当前的支付订单号
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public String getCurrentRemitVoucherNo() {
        return currentRemitVoucherNo;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RETRY_PLAN.CURRENT_REMIT_VOUCHER_NO
     *
     * @param currentRemitVoucherNo the value for FW_WITHDRAW_RETRY_PLAN.CURRENT_REMIT_VOUCHER_NO
     * column comments 当前的支付订单号
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void setCurrentRemitVoucherNo(String currentRemitVoucherNo) {
        this.currentRemitVoucherNo = currentRemitVoucherNo == null ? null : currentRemitVoucherNo.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RETRY_PLAN.EXECUTE_REMIT_VOUCHER_NO
     *
     * @return the value of FW_WITHDRAW_RETRY_PLAN.EXECUTE_REMIT_VOUCHER_NO
     * column comments 计划执行的支付订单号
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public String getExecuteRemitVoucherNo() {
        return executeRemitVoucherNo;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RETRY_PLAN.EXECUTE_REMIT_VOUCHER_NO
     *
     * @param executeRemitVoucherNo the value for FW_WITHDRAW_RETRY_PLAN.EXECUTE_REMIT_VOUCHER_NO
     * column comments 计划执行的支付订单号
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void setExecuteRemitVoucherNo(String executeRemitVoucherNo) {
        this.executeRemitVoucherNo = executeRemitVoucherNo == null ? null : executeRemitVoucherNo.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RETRY_PLAN.RETRY_RULE
     *
     * @return the value of FW_WITHDRAW_RETRY_PLAN.RETRY_RULE
     * column comments 重试规则
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public String getRetryRule() {
        return retryRule;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RETRY_PLAN.RETRY_RULE
     *
     * @param retryRule the value for FW_WITHDRAW_RETRY_PLAN.RETRY_RULE
     * column comments 重试规则
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void setRetryRule(String retryRule) {
        this.retryRule = retryRule == null ? null : retryRule.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RETRY_PLAN.RETRY_EXECUTE_TIMES
     *
     * @return the value of FW_WITHDRAW_RETRY_PLAN.RETRY_EXECUTE_TIMES
     * column comments 计划执行任务是第几次重试
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public Integer getRetryExecuteTimes() {
        return retryExecuteTimes;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RETRY_PLAN.RETRY_EXECUTE_TIMES
     *
     * @param retryExecuteTimes the value for FW_WITHDRAW_RETRY_PLAN.RETRY_EXECUTE_TIMES
     * column comments 计划执行任务是第几次重试
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void setRetryExecuteTimes(Integer retryExecuteTimes) {
        this.retryExecuteTimes = retryExecuteTimes;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RETRY_PLAN.EXECUTE_START_TIME
     *
     * @return the value of FW_WITHDRAW_RETRY_PLAN.EXECUTE_START_TIME
     * column comments 执行重试的开始时间点
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public Date getExecuteStartTime() {
        return executeStartTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RETRY_PLAN.EXECUTE_START_TIME
     *
     * @param executeStartTime the value for FW_WITHDRAW_RETRY_PLAN.EXECUTE_START_TIME
     * column comments 执行重试的开始时间点
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void setExecuteStartTime(Date executeStartTime) {
        this.executeStartTime = executeStartTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RETRY_PLAN.EXECUTE_STATUS
     *
     * @return the value of FW_WITHDRAW_RETRY_PLAN.EXECUTE_STATUS
     * column comments 执行状态0 待执行 1执行中 2 执行结束
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public Integer getExecuteStatus() {
        return executeStatus;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RETRY_PLAN.EXECUTE_STATUS
     *
     * @param executeStatus the value for FW_WITHDRAW_RETRY_PLAN.EXECUTE_STATUS
     * column comments 执行状态0 待执行 1执行中 2 执行结束
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void setExecuteStatus(Integer executeStatus) {
        this.executeStatus = executeStatus;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RETRY_PLAN.EXECUTE_TIME
     *
     * @return the value of FW_WITHDRAW_RETRY_PLAN.EXECUTE_TIME
     * column comments 执行时间
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public Date getExecuteTime() {
        return executeTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RETRY_PLAN.EXECUTE_TIME
     *
     * @param executeTime the value for FW_WITHDRAW_RETRY_PLAN.EXECUTE_TIME
     * column comments 执行时间
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void setExecuteTime(Date executeTime) {
        this.executeTime = executeTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RETRY_PLAN.CREATE_TIME
     *
     * @return the value of FW_WITHDRAW_RETRY_PLAN.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RETRY_PLAN.CREATE_TIME
     *
     * @param createTime the value for FW_WITHDRAW_RETRY_PLAN.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RETRY_PLAN.UPDATE_TIME
     *
     * @return the value of FW_WITHDRAW_RETRY_PLAN.UPDATE_TIME
     * column comments 最后修改时间
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RETRY_PLAN.UPDATE_TIME
     *
     * @param updateTime the value for FW_WITHDRAW_RETRY_PLAN.UPDATE_TIME
     * column comments 最后修改时间
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}