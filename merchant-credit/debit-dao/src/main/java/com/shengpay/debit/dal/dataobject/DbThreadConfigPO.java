package com.shengpay.debit.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

public class DbThreadConfigPO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * DECIMAL(18) 必填<br>
     * 
     */
    private Long id;

    /**
     * VARCHAR(32) 必填<br>
     * 机构号
     */
    private String orgnizationCode;

    /**
     * VARCHAR(32) 必填<br>
     * 批处理编号
     */
    private String batchCode;

    /**
     * VARCHAR(32)<br>
     * 执行表达式
     */
    private String executeExpression;

    /**
     * DECIMAL(5)<br>
     * 重试次数
     */
    private Integer retryCount;

    /**
     * DECIMAL(18)<br>
     * 重试间隔(单位秒)
     */
    private Long retryInterval;

    /**
     * DECIMAL(5)<br>
     * 状态
     */
    private Integer status;

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
     * 获得 机构号
     */
    public String getOrgnizationCode() {
        return orgnizationCode;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 机构号
     */
    public void setOrgnizationCode(String orgnizationCode) {
        this.orgnizationCode = orgnizationCode == null ? null : orgnizationCode.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 批处理编号
     */
    public String getBatchCode() {
        return batchCode;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 批处理编号
     */
    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode == null ? null : batchCode.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 执行表达式
     */
    public String getExecuteExpression() {
        return executeExpression;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 执行表达式
     */
    public void setExecuteExpression(String executeExpression) {
        this.executeExpression = executeExpression == null ? null : executeExpression.trim();
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
     * 获得 重试间隔(单位秒)
     */
    public Long getRetryInterval() {
        return retryInterval;
    }

    /**
     * DECIMAL(18)<br>
     * 设置 重试间隔(单位秒)
     */
    public void setRetryInterval(Long retryInterval) {
        this.retryInterval = retryInterval;
    }

    /**
     * DECIMAL(5)<br>
     * 获得 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * DECIMAL(5)<br>
     * 设置 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
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
}