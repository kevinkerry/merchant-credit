package com.shengpay.debit.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

public class DoTransferLogPO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * DECIMAL(18) 必填<br>
     * 
     */
    private Long id;

    /**
     * VARCHAR(8)<br>
     * 类型
     */
    private String orderType;

    /**
     * VARCHAR(64)<br>
     * 订单号
     */
    private String orderId;

    /**
     * VARCHAR(32)<br>
     * 状态
     */
    private String status;

    /**
     * VARCHAR(32)<br>
     * 转出账户
     */
    private String fromUser;

    /**
     * VARCHAR(32)<br>
     * 转入账户
     */
    private String toUser;

    /**
     * VARCHAR(4000)<br>
     * 发送报文
     */
    private String requestLog;

    /**
     * VARCHAR(4000)<br>
     * 响应内容
     */
    private String responseLog;

    /**
     * VARCHAR(32)<br>
     * 
     */
    private String sourceId;

    /**
     * VARCHAR(32)<br>
     * 
     */
    private String zfId;

    /**
     * TIMESTAMP(11,6)<br>
     * 创建时间
     */
    private Date createTime;

    /**
     * TIMESTAMP(11,6)<br>
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
     * VARCHAR(8)<br>
     * 获得 类型
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * VARCHAR(8)<br>
     * 设置 类型
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    /**
     * VARCHAR(64)<br>
     * 获得 订单号
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * VARCHAR(64)<br>
     * 设置 订单号
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 转出账户
     */
    public String getFromUser() {
        return fromUser;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 转出账户
     */
    public void setFromUser(String fromUser) {
        this.fromUser = fromUser == null ? null : fromUser.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 转入账户
     */
    public String getToUser() {
        return toUser;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 转入账户
     */
    public void setToUser(String toUser) {
        this.toUser = toUser == null ? null : toUser.trim();
    }

    /**
     * VARCHAR(4000)<br>
     * 获得 发送报文
     */
    public String getRequestLog() {
        return requestLog;
    }

    /**
     * VARCHAR(4000)<br>
     * 设置 发送报文
     */
    public void setRequestLog(String requestLog) {
        this.requestLog = requestLog == null ? null : requestLog.trim();
    }

    /**
     * VARCHAR(4000)<br>
     * 获得 响应内容
     */
    public String getResponseLog() {
        return responseLog;
    }

    /**
     * VARCHAR(4000)<br>
     * 设置 响应内容
     */
    public void setResponseLog(String responseLog) {
        this.responseLog = responseLog == null ? null : responseLog.trim();
    }

    /**
     * VARCHAR(32)<br>
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * VARCHAR(32)<br>
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId == null ? null : sourceId.trim();
    }

    /**
     * VARCHAR(32)<br>
     */
    public String getZfId() {
        return zfId;
    }

    /**
     * VARCHAR(32)<br>
     */
    public void setZfId(String zfId) {
        this.zfId = zfId == null ? null : zfId.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}