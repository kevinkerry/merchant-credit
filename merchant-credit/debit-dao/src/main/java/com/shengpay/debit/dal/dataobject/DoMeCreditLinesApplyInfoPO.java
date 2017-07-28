package com.shengpay.debit.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

public class DoMeCreditLinesApplyInfoPO implements Serializable {
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
     * VARCHAR(32)<br>
     * 申请商户号
     */
    private String merchantNo;

    /**
     * VARCHAR(32)<br>
     * 机构编码
     */
    private String orgnizationCode;

    /**
     * VARCHAR(32)<br>
     * 分类
     */
    private String inputKind;

    /**
     * VARCHAR(400)<br>
     * 输入名称
     */
    private String inputCode;

    /**
     * VARCHAR(1000)<br>
     * 输入值
     */
    private String inputValue;

    /**
     * VARCHAR(32)<br>
     * 类型
     */
    private String inputType;

    /**
     * VARCHAR(1000)<br>
     * 扩展信息
     */
    private String extInfo;

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
     * VARCHAR(32)<br>
     * 获得 申请商户号
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 申请商户号
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 机构编码
     */
    public String getOrgnizationCode() {
        return orgnizationCode;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 机构编码
     */
    public void setOrgnizationCode(String orgnizationCode) {
        this.orgnizationCode = orgnizationCode == null ? null : orgnizationCode.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 分类
     */
    public String getInputKind() {
        return inputKind;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 分类
     */
    public void setInputKind(String inputKind) {
        this.inputKind = inputKind == null ? null : inputKind.trim();
    }

    /**
     * VARCHAR(400)<br>
     * 获得 输入名称
     */
    public String getInputCode() {
        return inputCode;
    }

    /**
     * VARCHAR(400)<br>
     * 设置 输入名称
     */
    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }

    /**
     * VARCHAR(1000)<br>
     * 获得 输入值
     */
    public String getInputValue() {
        return inputValue;
    }

    /**
     * VARCHAR(1000)<br>
     * 设置 输入值
     */
    public void setInputValue(String inputValue) {
        this.inputValue = inputValue == null ? null : inputValue.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 类型
     */
    public String getInputType() {
        return inputType;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 类型
     */
    public void setInputType(String inputType) {
        this.inputType = inputType == null ? null : inputType.trim();
    }

    /**
     * VARCHAR(1000)<br>
     * 获得 扩展信息
     */
    public String getExtInfo() {
        return extInfo;
    }

    /**
     * VARCHAR(1000)<br>
     * 设置 扩展信息
     */
    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo == null ? null : extInfo.trim();
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