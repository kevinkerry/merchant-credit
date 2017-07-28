package com.shengpay.debit.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

public class DmMerchantCreditBaseInfoPO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * DECIMAL(18) 必填<br>
     * 
     */
    private Long id;

    /**
     * VARCHAR(32) 必填<br>
     * 商户号
     */
    private String merchantNo;

    /**
     * VARCHAR(32) 必填<br>
     * MEMBER_ID
     */
    private String memberId;

    /**
     * VARCHAR(64)<br>
     * 钱包账户
     */
    private String walletAccount;

    /**
     * VARCHAR(64)<br>
     * 授信账户
     */
    private String creditAccount;

    /**
     * VARCHAR(64)<br>
     * 利息账户
     */
    private String interestAccount;

    /**
     * VARCHAR(1024)<br>
     * 商户扩展信息
     */
    private String merchantExtInfo;

    /**
     * TIMESTAMP(11,6) 必填<br>
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
     * VARCHAR(32) 必填<br>
     * 获得 商户号
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 商户号
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 MEMBER_ID
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 MEMBER_ID
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    /**
     * VARCHAR(64)<br>
     * 获得 钱包账户
     */
    public String getWalletAccount() {
        return walletAccount;
    }

    /**
     * VARCHAR(64)<br>
     * 设置 钱包账户
     */
    public void setWalletAccount(String walletAccount) {
        this.walletAccount = walletAccount == null ? null : walletAccount.trim();
    }

    /**
     * VARCHAR(64)<br>
     * 获得 授信账户
     */
    public String getCreditAccount() {
        return creditAccount;
    }

    /**
     * VARCHAR(64)<br>
     * 设置 授信账户
     */
    public void setCreditAccount(String creditAccount) {
        this.creditAccount = creditAccount == null ? null : creditAccount.trim();
    }

    /**
     * VARCHAR(64)<br>
     * 获得 利息账户
     */
    public String getInterestAccount() {
        return interestAccount;
    }

    /**
     * VARCHAR(64)<br>
     * 设置 利息账户
     */
    public void setInterestAccount(String interestAccount) {
        this.interestAccount = interestAccount == null ? null : interestAccount.trim();
    }

    /**
     * VARCHAR(1024)<br>
     * 获得 商户扩展信息
     */
    public String getMerchantExtInfo() {
        return merchantExtInfo;
    }

    /**
     * VARCHAR(1024)<br>
     * 设置 商户扩展信息
     */
    public void setMerchantExtInfo(String merchantExtInfo) {
        this.merchantExtInfo = merchantExtInfo == null ? null : merchantExtInfo.trim();
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