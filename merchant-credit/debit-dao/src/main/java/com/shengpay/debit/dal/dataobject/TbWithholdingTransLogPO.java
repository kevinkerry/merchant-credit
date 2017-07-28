package com.shengpay.debit.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

public class TbWithholdingTransLogPO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * DECIMAL(18) 必填<br>
     * ID
     */
    private Long id;

    /**
     * VARCHAR(100) 必填<br>
     * 订单号
     */
    private String merchantOrderNo;

    /**
     * VARCHAR(100)<br>
     * 批次号
     */
    private String batchNo;

    /**
     * TIMESTAMP(11,6)<br>
     * 请求时间
     */
    private Date requestTime;

    /**
     * VARCHAR(4000)<br>
     * 请求内容
     */
    private String requestData;

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
     * VARCHAR(100)<br>
     * 
     */
    private String ext;

    /**
     * VARCHAR(3)<br>
     * 请求类型（0-扣款  1-返回 2-回调）
     */
    private String resulttype;

    /**
     * VARCHAR(50)<br>
     * 卡号
     */
    private String cardNo;

    /**
     * VARCHAR(4000)<br>
     * 返回数据
     */
    private String responsedate;

    /**
     * DECIMAL(18) 必填<br>
     * 获得 ID
     */
    public Long getId() {
        return id;
    }

    /**
     * DECIMAL(18) 必填<br>
     * 设置 ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * VARCHAR(100) 必填<br>
     * 获得 订单号
     */
    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    /**
     * VARCHAR(100) 必填<br>
     * 设置 订单号
     */
    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo == null ? null : merchantOrderNo.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 批次号
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 批次号
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 请求时间
     */
    public Date getRequestTime() {
        return requestTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 请求时间
     */
    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    /**
     * VARCHAR(4000)<br>
     * 获得 请求内容
     */
    public String getRequestData() {
        return requestData;
    }

    /**
     * VARCHAR(4000)<br>
     * 设置 请求内容
     */
    public void setRequestData(String requestData) {
        this.requestData = requestData == null ? null : requestData.trim();
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

    /**
     * VARCHAR(100)<br>
     */
    public String getExt() {
        return ext;
    }

    /**
     * VARCHAR(100)<br>
     */
    public void setExt(String ext) {
        this.ext = ext == null ? null : ext.trim();
    }

    /**
     * VARCHAR(3)<br>
     * 获得 请求类型（0-扣款  1-返回 2-回调）
     */
    public String getResulttype() {
        return resulttype;
    }

    /**
     * VARCHAR(3)<br>
     * 设置 请求类型（0-扣款  1-返回 2-回调）
     */
    public void setResulttype(String resulttype) {
        this.resulttype = resulttype == null ? null : resulttype.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 卡号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 卡号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * VARCHAR(4000)<br>
     * 获得 返回数据
     */
    public String getResponsedate() {
        return responsedate;
    }

    /**
     * VARCHAR(4000)<br>
     * 设置 返回数据
     */
    public void setResponsedate(String responsedate) {
        this.responsedate = responsedate == null ? null : responsedate.trim();
    }
}