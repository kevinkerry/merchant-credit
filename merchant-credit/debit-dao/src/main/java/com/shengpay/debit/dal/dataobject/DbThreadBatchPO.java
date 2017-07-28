package com.shengpay.debit.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

public class DbThreadBatchPO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * DECIMAL(18) 必填<br>
     * 
     */
    private Long id;

    /**
     * VARCHAR(32)<br>
     * 批处理编号
     */
    private String batchCode;

    /**
     * VARCHAR(32)<br>
     * 批次号
     */
    private String serilizeCode;

    /**
     * TIMESTAMP(11,6)<br>
     * 开始时间
     */
    private Date startTime;

    /**
     * TIMESTAMP(11,6)<br>
     * 结束时间
     */
    private Date endTime;

    /**
     * DECIMAL(5)<br>
     * 重试次数
     */
    private Integer retryCount;

    /**
     * DECIMAL(18)<br>
     * 影响数量
     */
    private Long recordCount;

    /**
     * DECIMAL(5)<br>
     * 执行结果
     */
    private Integer executeResult;

    /**
     * VARCHAR(200)<br>
     * 备注
     */
    private String memo;

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 创建时间
     */
    private Date createTime;

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 修改时间
     */
    private Date updateTime;

    /**
     * DECIMAL(5)<br>
     * 线程运行状态
     */
    private Integer runningStatus;

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
     * VARCHAR(32)<br>
     * 获得 批处理编号
     */
    public String getBatchCode() {
        return batchCode;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 批处理编号
     */
    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode == null ? null : batchCode.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 批次号
     */
    public String getSerilizeCode() {
        return serilizeCode;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 批次号
     */
    public void setSerilizeCode(String serilizeCode) {
        this.serilizeCode = serilizeCode == null ? null : serilizeCode.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * DECIMAL(5)<br>
     * 获得 重试次数
     */
    public Integer getRetryCount() {
        return retryCount;
    }

    /**
     * DECIMAL(5)<br>
     * 设置 重试次数
     */
    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    /**
     * DECIMAL(18)<br>
     * 获得 影响数量
     */
    public Long getRecordCount() {
        return recordCount;
    }

    /**
     * DECIMAL(18)<br>
     * 设置 影响数量
     */
    public void setRecordCount(Long recordCount) {
        this.recordCount = recordCount;
    }

    /**
     * DECIMAL(5)<br>
     * 获得 执行结果
     */
    public Integer getExecuteResult() {
        return executeResult;
    }

    /**
     * DECIMAL(5)<br>
     * 设置 执行结果
     */
    public void setExecuteResult(Integer executeResult) {
        this.executeResult = executeResult;
    }

    /**
     * VARCHAR(200)<br>
     * 获得 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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
     * 获得 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * TIMESTAMP(11,6) 必填<br>
     * 设置 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * DECIMAL(5)<br>
     * 获得 线程运行状态
     */
    public Integer getRunningStatus() {
        return runningStatus;
    }

    /**
     * DECIMAL(5)<br>
     * 设置 线程运行状态
     */
    public void setRunningStatus(Integer runningStatus) {
        this.runningStatus = runningStatus;
    }
}