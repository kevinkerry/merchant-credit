package com.shengpay.debit.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

public class DbRiskRequestLogPO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * DECIMAL(18) 必填<br>
     * 
     */
    private Long id;

    /**
     * DECIMAL(18)<br>
     * 申请订单号
     */
    private Long lineApplyOrderId;

    /**
     * VARCHAR(4000)<br>
     * 发送报文
     */
    private String requestMsg;

    /**
     * VARCHAR(4000)<br>
     * 响应报文
     */
    private String responseMsg;

    /**
     * VARCHAR(32)<br>
     * 响应状态
     */
    private String responseStatus;

    /**
     * VARCHAR(4000)<br>
     * 通知报文
     */
    private String notifyMsg;

    /**
     * VARCHAR(32)<br>
     * 通知状态
     */
    private String notifyStatus;

    /**
     * TIMESTAMP(11,6)<br>
     * 通知时间
     */
    private Date notifyTime;

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
     * DECIMAL(18)<br>
     * 获得 申请订单号
     */
    public Long getLineApplyOrderId() {
        return lineApplyOrderId;
    }

    /**
     * DECIMAL(18)<br>
     * 设置 申请订单号
     */
    public void setLineApplyOrderId(Long lineApplyOrderId) {
        this.lineApplyOrderId = lineApplyOrderId;
    }

    /**
     * VARCHAR(4000)<br>
     * 获得 发送报文
     */
    public String getRequestMsg() {
        return requestMsg;
    }

    /**
     * VARCHAR(4000)<br>
     * 设置 发送报文
     */
    public void setRequestMsg(String requestMsg) {
        this.requestMsg = requestMsg == null ? null : requestMsg.trim();
    }

    /**
     * VARCHAR(4000)<br>
     * 获得 响应报文
     */
    public String getResponseMsg() {
        return responseMsg;
    }

    /**
     * VARCHAR(4000)<br>
     * 设置 响应报文
     */
    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg == null ? null : responseMsg.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 响应状态
     */
    public String getResponseStatus() {
        return responseStatus;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 响应状态
     */
    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus == null ? null : responseStatus.trim();
    }

    /**
     * VARCHAR(4000)<br>
     * 获得 通知报文
     */
    public String getNotifyMsg() {
        return notifyMsg;
    }

    /**
     * VARCHAR(4000)<br>
     * 设置 通知报文
     */
    public void setNotifyMsg(String notifyMsg) {
        this.notifyMsg = notifyMsg == null ? null : notifyMsg.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 通知状态
     */
    public String getNotifyStatus() {
        return notifyStatus;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 通知状态
     */
    public void setNotifyStatus(String notifyStatus) {
        this.notifyStatus = notifyStatus == null ? null : notifyStatus.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 通知时间
     */
    public Date getNotifyTime() {
        return notifyTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 通知时间
     */
    public void setNotifyTime(Date notifyTime) {
        this.notifyTime = notifyTime;
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