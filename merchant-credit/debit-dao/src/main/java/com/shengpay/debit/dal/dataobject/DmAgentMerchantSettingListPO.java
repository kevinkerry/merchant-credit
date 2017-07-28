package com.shengpay.debit.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

public class DmAgentMerchantSettingListPO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * DECIMAL(18) 必填<br>
     * 
     */
    private Long id;

    /**
     * VARCHAR(32)<br>
     * 代理商商户NO
     */
    private String agentMerchantNo;

    /**
     * VARCHAR(400)<br>
     * 代理商名称
     */
    private String agentMerchantName;

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
     * VARCHAR(32)<br>
     * 开通状态
     */
    private String status;

    /**
     * VARCHAR(400)<br>
     * 扩展信息
     */
    private String extInfo;

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
     * 获得 代理商商户NO
     */
    public String getAgentMerchantNo() {
        return agentMerchantNo;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 代理商商户NO
     */
    public void setAgentMerchantNo(String agentMerchantNo) {
        this.agentMerchantNo = agentMerchantNo == null ? null : agentMerchantNo.trim();
    }

    /**
     * VARCHAR(400)<br>
     * 获得 代理商名称
     */
    public String getAgentMerchantName() {
        return agentMerchantName;
    }

    /**
     * VARCHAR(400)<br>
     * 设置 代理商名称
     */
    public void setAgentMerchantName(String agentMerchantName) {
        this.agentMerchantName = agentMerchantName == null ? null : agentMerchantName.trim();
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
     * VARCHAR(32)<br>
     * 获得 开通状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 开通状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * VARCHAR(400)<br>
     * 获得 扩展信息
     */
    public String getExtInfo() {
        return extInfo;
    }

    /**
     * VARCHAR(400)<br>
     * 设置 扩展信息
     */
    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo == null ? null : extInfo.trim();
    }
}