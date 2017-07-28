package com.sdp.mc.easypay.vo;

import java.util.Date;

public class MerchantPayChannel {
    /**
     * DECIMAL(18) 必填<br>
     * 
     */
    private Long id;

    /**
     * VARCHAR(50)<br>
     * 商户ID
     */
    private String merchantId;

    /**
     * VARCHAR(50)<br>
     * 支付渠道
     */
    private String payChannel;

    /**
     * VARCHAR(50)<br>
     * 支付渠道名称
     */
    private String payChannelName;

    /**
     * VARCHAR(50)<br>
     * 支付类型
     */
    private String paymentType;

    /**
     * TIMESTAMP(11,6)<br>
     * 起始有效期
     */
    private Date effectBeginTime;

    /**
     * TIMESTAMP(11,6)<br>
     * 结束有效期
     */
    private Date effectEndTime;

    /**
     * VARCHAR(20)<br>
     * 状态
     */
    private String status;

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
     * VARCHAR(50)<br>
     * 获得 商户ID
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 商户ID
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 支付渠道
     */
    public String getPayChannel() {
        return payChannel;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 支付渠道
     */
    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel == null ? null : payChannel.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 支付渠道名称
     */
    public String getPayChannelName() {
        return payChannelName;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 支付渠道名称
     */
    public void setPayChannelName(String payChannelName) {
        this.payChannelName = payChannelName == null ? null : payChannelName.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 支付类型
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 支付类型
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 起始有效期
     */
    public Date getEffectBeginTime() {
        return effectBeginTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 起始有效期
     */
    public void setEffectBeginTime(Date effectBeginTime) {
        this.effectBeginTime = effectBeginTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 结束有效期
     */
    public Date getEffectEndTime() {
        return effectEndTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 结束有效期
     */
    public void setEffectEndTime(Date effectEndTime) {
        this.effectEndTime = effectEndTime;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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