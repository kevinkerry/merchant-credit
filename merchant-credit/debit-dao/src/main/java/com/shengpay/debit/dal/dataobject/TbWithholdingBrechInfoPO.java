package com.shengpay.debit.dal.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbWithholdingBrechInfoPO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * DECIMAL(18) 必填<br>
     * ID
     */
    private Long id;

    /**
     * VARCHAR(100) 必填<br>
     * 批次号
     */
    private String batchNo;

    /**
     * VARCHAR(100)<br>
     * 商户号
     */
    private String merchantNo;

    /**
     * VARCHAR(100)<br>
     * 总笔数
     */
    private String totalCount;

    /**
     * DECIMAL(18,2)<br>
     * 总金额
     */
    private BigDecimal totalAmount;

    /**
     * VARCHAR(100)<br>
     * 成功笔数
     */
    private String sucessCount;

    /**
     * VARCHAR(100)<br>
     * 失败笔数
     */
    private String failCount;

    /**
     * VARCHAR(100)<br>
     * 001-初始 002-代扣中 003-处理中 004-完成 
     */
    private String status;

    /**
     * VARCHAR(100)<br>
     * 请求结果
     */
    private String resultCode;

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
     * TIMESTAMP(11,6)<br>
     * 日期
     */
    private Date batchTime;

    /**
     * VARCHAR(100)<br>
     * 
     */
    private String ext;

    /**
     * VARCHAR(100)<br>
     * 
     */
    private String opernerid;

    /**
     * VARCHAR(100)<br>
     * 
     */
    private String opernername;

    /**
     * VARCHAR(40)<br>
     * 业务类型 1-银行卡代扣  2-钱包代扣
     */
    private String biztype;

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
     * 获得 批次号
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * VARCHAR(100) 必填<br>
     * 设置 批次号
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 商户号
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 商户号
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 总笔数
     */
    public String getTotalCount() {
        return totalCount;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 总笔数
     */
    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount == null ? null : totalCount.trim();
    }

    /**
     * DECIMAL(18,2)<br>
     * 获得 总金额
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 设置 总金额
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * VARCHAR(100)<br>
     * 获得 成功笔数
     */
    public String getSucessCount() {
        return sucessCount;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 成功笔数
     */
    public void setSucessCount(String sucessCount) {
        this.sucessCount = sucessCount == null ? null : sucessCount.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 失败笔数
     */
    public String getFailCount() {
        return failCount;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 失败笔数
     */
    public void setFailCount(String failCount) {
        this.failCount = failCount == null ? null : failCount.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 001-初始 002-代扣中 003-处理中 004-完成 
     */
    public String getStatus() {
        return status;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 001-初始 002-代扣中 003-处理中 004-完成 
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 请求结果
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 请求结果
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode == null ? null : resultCode.trim();
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
     * TIMESTAMP(11,6)<br>
     * 获得 日期
     */
    public Date getBatchTime() {
        return batchTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 日期
     */
    public void setBatchTime(Date batchTime) {
        this.batchTime = batchTime;
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
     * VARCHAR(100)<br>
     */
    public String getOpernerid() {
        return opernerid;
    }

    /**
     * VARCHAR(100)<br>
     */
    public void setOpernerid(String opernerid) {
        this.opernerid = opernerid == null ? null : opernerid.trim();
    }

    /**
     * VARCHAR(100)<br>
     */
    public String getOpernername() {
        return opernername;
    }

    /**
     * VARCHAR(100)<br>
     */
    public void setOpernername(String opernername) {
        this.opernername = opernername == null ? null : opernername.trim();
    }

    /**
     * VARCHAR(40)<br>
     * 获得 业务类型 1-银行卡代扣  2-钱包代扣
     */
    public String getBiztype() {
        return biztype;
    }

    /**
     * VARCHAR(40)<br>
     * 设置 业务类型 1-银行卡代扣  2-钱包代扣
     */
    public void setBiztype(String biztype) {
        this.biztype = biztype == null ? null : biztype.trim();
    }
}