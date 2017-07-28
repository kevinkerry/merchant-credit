package com.shengpay.debit.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

public class DbNormalSettingPO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * DECIMAL(18) 必填<br>
     * 
     */
    private Long id;

    /**
     * VARCHAR(32) 必填<br>
     * 配置名
     */
    private String settingKey;

    /**
     * VARCHAR(1024) 必填<br>
     * 配置内容
     */
    private String settingValue;

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
     * VARCHAR(100)<br>
     * 描述
     */
    private String settingDesc;

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
     * 获得 配置名
     */
    public String getSettingKey() {
        return settingKey;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 配置名
     */
    public void setSettingKey(String settingKey) {
        this.settingKey = settingKey == null ? null : settingKey.trim();
    }

    /**
     * VARCHAR(1024) 必填<br>
     * 获得 配置内容
     */
    public String getSettingValue() {
        return settingValue;
    }

    /**
     * VARCHAR(1024) 必填<br>
     * 设置 配置内容
     */
    public void setSettingValue(String settingValue) {
        this.settingValue = settingValue == null ? null : settingValue.trim();
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

    /**
     * VARCHAR(100)<br>
     * 获得 描述
     */
    public String getSettingDesc() {
        return settingDesc;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 描述
     */
    public void setSettingDesc(String settingDesc) {
        this.settingDesc = settingDesc == null ? null : settingDesc.trim();
    }
}