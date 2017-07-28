package com.shengpay.debit.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

public class DbOrganizationInfoPO implements Serializable {
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
     * VARCHAR(64)<br>
     * 机构名称
     */
    private String orgnizationName;

    /**
     * VARCHAR(1000)<br>
     * 机构描述
     */
    private String orgnizationDesc;

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
     * VARCHAR(64)<br>
     * 获得 机构名称
     */
    public String getOrgnizationName() {
        return orgnizationName;
    }

    /**
     * VARCHAR(64)<br>
     * 设置 机构名称
     */
    public void setOrgnizationName(String orgnizationName) {
        this.orgnizationName = orgnizationName == null ? null : orgnizationName.trim();
    }

    /**
     * VARCHAR(1000)<br>
     * 获得 机构描述
     */
    public String getOrgnizationDesc() {
        return orgnizationDesc;
    }

    /**
     * VARCHAR(1000)<br>
     * 设置 机构描述
     */
    public void setOrgnizationDesc(String orgnizationDesc) {
        this.orgnizationDesc = orgnizationDesc == null ? null : orgnizationDesc.trim();
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