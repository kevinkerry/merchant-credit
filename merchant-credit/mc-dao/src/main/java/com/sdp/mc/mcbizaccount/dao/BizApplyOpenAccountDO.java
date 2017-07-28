package com.sdp.mc.mcbizaccount.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.util.Date;

public class BizApplyOpenAccountDO extends BaseDO {
    /**
     * This field corresponds to the database column MC_APPLY_OPEN_ACCOUNT.ID
     * column comments null
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    private Long id;

    /**
     * This field corresponds to the database column MC_APPLY_OPEN_ACCOUNT.ACCOUNT_TYPE
     * column comments 账户类型(216保证金账户,281授信专户)
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    private Long accountType;

    /**
     * This field corresponds to the database column MC_APPLY_OPEN_ACCOUNT.PROMOTER_ID
     * column comments 代理商编号
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    private Long promoterId;

    /**
     * This field corresponds to the database column MC_APPLY_OPEN_ACCOUNT.MERCHANT_NO
     * column comments 代理商商户号
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    private String merchantNo;

    /**
     * This field corresponds to the database column MC_APPLY_OPEN_ACCOUNT.PROMOTER_NAME
     * column comments 代理商名称
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    private String promoterName;

    /**
     * This field corresponds to the database column MC_APPLY_OPEN_ACCOUNT.ACCOUNT_ID
     * column comments 账户-accountId
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    private String accountId;

    /**
     * This field corresponds to the database column MC_APPLY_OPEN_ACCOUNT.MEMBER_ID
     * column comments 代理商memberId
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    private String memberId;

    /**
     * This field corresponds to the database column MC_APPLY_OPEN_ACCOUNT.STATUS
     * column comments 状态
0初始化,1开户中,2开户成功,3开户失败
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    private Integer status;

    /**
     * This field corresponds to the database column MC_APPLY_OPEN_ACCOUNT.BIZ_ID
     * column comments 开户表id
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    private Long bizId;

    /**
     * This field corresponds to the database column MC_APPLY_OPEN_ACCOUNT.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    private Date createTime;

    /**
     * This field corresponds to the database column MC_APPLY_OPEN_ACCOUNT.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    private Date updateTime;

    /**
     * This method returns the value of the database column MC_APPLY_OPEN_ACCOUNT.ID
     *
     * @return the value of MC_APPLY_OPEN_ACCOUNT.ID
     * column comments null
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column MC_APPLY_OPEN_ACCOUNT.ID
     *
     * @param id the value for MC_APPLY_OPEN_ACCOUNT.ID
     * column comments null
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column MC_APPLY_OPEN_ACCOUNT.ACCOUNT_TYPE
     *
     * @return the value of MC_APPLY_OPEN_ACCOUNT.ACCOUNT_TYPE
     * column comments 账户类型(216保证金账户,281授信专户)
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public Long getAccountType() {
        return accountType;
    }

    /**
     * This method sets the value of the database column MC_APPLY_OPEN_ACCOUNT.ACCOUNT_TYPE
     *
     * @param accountType the value for MC_APPLY_OPEN_ACCOUNT.ACCOUNT_TYPE
     * column comments 账户类型(216保证金账户,281授信专户)
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void setAccountType(Long accountType) {
        this.accountType = accountType;
    }

    /**
     * This method returns the value of the database column MC_APPLY_OPEN_ACCOUNT.PROMOTER_ID
     *
     * @return the value of MC_APPLY_OPEN_ACCOUNT.PROMOTER_ID
     * column comments 代理商编号
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public Long getPromoterId() {
        return promoterId;
    }

    /**
     * This method sets the value of the database column MC_APPLY_OPEN_ACCOUNT.PROMOTER_ID
     *
     * @param promoterId the value for MC_APPLY_OPEN_ACCOUNT.PROMOTER_ID
     * column comments 代理商编号
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void setPromoterId(Long promoterId) {
        this.promoterId = promoterId;
    }

    /**
     * This method returns the value of the database column MC_APPLY_OPEN_ACCOUNT.MERCHANT_NO
     *
     * @return the value of MC_APPLY_OPEN_ACCOUNT.MERCHANT_NO
     * column comments 代理商商户号
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * This method sets the value of the database column MC_APPLY_OPEN_ACCOUNT.MERCHANT_NO
     *
     * @param merchantNo the value for MC_APPLY_OPEN_ACCOUNT.MERCHANT_NO
     * column comments 代理商商户号
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * This method returns the value of the database column MC_APPLY_OPEN_ACCOUNT.PROMOTER_NAME
     *
     * @return the value of MC_APPLY_OPEN_ACCOUNT.PROMOTER_NAME
     * column comments 代理商名称
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public String getPromoterName() {
        return promoterName;
    }

    /**
     * This method sets the value of the database column MC_APPLY_OPEN_ACCOUNT.PROMOTER_NAME
     *
     * @param promoterName the value for MC_APPLY_OPEN_ACCOUNT.PROMOTER_NAME
     * column comments 代理商名称
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void setPromoterName(String promoterName) {
        this.promoterName = promoterName == null ? null : promoterName.trim();
    }

    /**
     * This method returns the value of the database column MC_APPLY_OPEN_ACCOUNT.ACCOUNT_ID
     *
     * @return the value of MC_APPLY_OPEN_ACCOUNT.ACCOUNT_ID
     * column comments 账户-accountId
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * This method sets the value of the database column MC_APPLY_OPEN_ACCOUNT.ACCOUNT_ID
     *
     * @param accountId the value for MC_APPLY_OPEN_ACCOUNT.ACCOUNT_ID
     * column comments 账户-accountId
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * This method returns the value of the database column MC_APPLY_OPEN_ACCOUNT.MEMBER_ID
     *
     * @return the value of MC_APPLY_OPEN_ACCOUNT.MEMBER_ID
     * column comments 代理商memberId
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * This method sets the value of the database column MC_APPLY_OPEN_ACCOUNT.MEMBER_ID
     *
     * @param memberId the value for MC_APPLY_OPEN_ACCOUNT.MEMBER_ID
     * column comments 代理商memberId
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    /**
     * This method returns the value of the database column MC_APPLY_OPEN_ACCOUNT.STATUS
     *
     * @return the value of MC_APPLY_OPEN_ACCOUNT.STATUS
     * column comments 状态
0初始化,1开户中,2开户成功,3开户失败
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column MC_APPLY_OPEN_ACCOUNT.STATUS
     *
     * @param status the value for MC_APPLY_OPEN_ACCOUNT.STATUS
     * column comments 状态
0初始化,1开户中,2开户成功,3开户失败
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column MC_APPLY_OPEN_ACCOUNT.BIZ_ID
     *
     * @return the value of MC_APPLY_OPEN_ACCOUNT.BIZ_ID
     * column comments 开户表id
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public Long getBizId() {
        return bizId;
    }

    /**
     * This method sets the value of the database column MC_APPLY_OPEN_ACCOUNT.BIZ_ID
     *
     * @param bizId the value for MC_APPLY_OPEN_ACCOUNT.BIZ_ID
     * column comments 开户表id
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    /**
     * This method returns the value of the database column MC_APPLY_OPEN_ACCOUNT.CREATE_TIME
     *
     * @return the value of MC_APPLY_OPEN_ACCOUNT.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column MC_APPLY_OPEN_ACCOUNT.CREATE_TIME
     *
     * @param createTime the value for MC_APPLY_OPEN_ACCOUNT.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column MC_APPLY_OPEN_ACCOUNT.UPDATE_TIME
     *
     * @return the value of MC_APPLY_OPEN_ACCOUNT.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column MC_APPLY_OPEN_ACCOUNT.UPDATE_TIME
     *
     * @param updateTime the value for MC_APPLY_OPEN_ACCOUNT.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}