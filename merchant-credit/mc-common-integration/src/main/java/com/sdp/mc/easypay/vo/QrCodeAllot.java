package com.sdp.mc.easypay.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.sdp.mc.common.util.StringUtil;

public class QrCodeAllot {
    private Long id;

    /**
     * 上级代理商户号
     */
    private String parentMerchantNo;

    /**
     * 起始编号
     */
    private String qrStartCode;

    /**
     * 结束编号
     */
    private String qrEndCode;

    /**
     * 数量
     */
    private Short codeSum;

    /**
     * 下级经销商商户号
     */
    private String childMerchantNo;

    /**
     * 下级经销商名称
     */
    private String childMerchantName;

    /**
     * 费率
     */
    private BigDecimal rate;

    /**
     * 操作员
     */
    private String operatorId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
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
     * 获得 上级代理商户号
     */
    public String getParentMerchantNo() {
        return parentMerchantNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 上级代理商户号
     */
    public void setParentMerchantNo(String parentMerchantNo) {
        this.parentMerchantNo = parentMerchantNo == null ? null : parentMerchantNo.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 起始编号
     */
    public String getQrStartCode() {
        return qrStartCode;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 起始编号
     */
    public void setQrStartCode(String qrStartCode) {
        this.qrStartCode = qrStartCode == null ? null : qrStartCode.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 结束编号
     */
    public String getQrEndCode() {
        return qrEndCode;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 结束编号
     */
    public void setQrEndCode(String qrEndCode) {
        this.qrEndCode = qrEndCode == null ? null : qrEndCode.trim();
    }

    /**
     * DECIMAL<br>
     * 获得 数量
     */
    public Short getCodeSum() {
        return codeSum;
    }

    /**
     * DECIMAL<br>
     * 设置 数量
     */
    public void setCodeSum(Short codeSum) {
        this.codeSum = codeSum;
    }

    /**
     * VARCHAR(32)<br>
     * 获得 下级经销商商户号
     */
    public String getChildMerchantNo() {
        return childMerchantNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 下级经销商商户号
     */
    public void setChildMerchantNo(String childMerchantNo) {
        this.childMerchantNo = childMerchantNo == null ? null : childMerchantNo.trim();
    }

    /**
     * VARCHAR(400)<br>
     * 获得 下级经销商名称
     */
    public String getChildMerchantName() {
        return childMerchantName;
    }

    /**
     * VARCHAR(400)<br>
     * 设置 下级经销商名称
     */
    public void setChildMerchantName(String childMerchantName) {
        this.childMerchantName = childMerchantName == null ? null : childMerchantName.trim();
    }

    /**
     * DECIMAL(3,2)<br>
     * 获得 费率
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * DECIMAL(3,2)<br>
     * 设置 费率
     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * VARCHAR(30)<br>
     * 获得 操作员
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * VARCHAR(30)<br>
     * 设置 操作员
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
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
    
    @Override
	public String toString(){
		return StringUtil.joinUrlParams(this);
	}
}