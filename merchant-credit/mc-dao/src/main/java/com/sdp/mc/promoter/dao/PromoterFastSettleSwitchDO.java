package com.sdp.mc.promoter.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.util.Date;
//代理商快速结算开通/关闭
//TB_PROMOTER_FS_REQ
public class PromoterFastSettleSwitchDO extends BaseDO {
    /**
     * This field corresponds to the database column TB_PROMOTER_FS_REQ.PFR_ID
     * column comments null
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    private Long pfrId;

    /**
     * This field corresponds to the database column TB_PROMOTER_FS_REQ.PROMOTER_ID
     * column comments 代理商编号
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    private Long promoterId;

    /**
     * This field corresponds to the database column TB_PROMOTER_FS_REQ.TYPE
     * column comments 操作类型
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    private Integer type;

    /**
     * This field corresponds to the database column TB_PROMOTER_FS_REQ.STATUS
     * column comments 状态
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    private Integer status;

    /**
     * This field corresponds to the database column TB_PROMOTER_FS_REQ.MARGIN_ACCOUNT
     * column comments 保证金账户-accountId
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    private String marginAccount;

    /**
     * This field corresponds to the database column TB_PROMOTER_FS_REQ.MAQ_ID
     * column comments 开户记录ID
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    private Long maqId;

    /**
     * This field corresponds to the database column TB_PROMOTER_FS_REQ.FCM_ID
     * column comments 最新的配置修改记录ID
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    private Long fcmId;

    /**
     * This field corresponds to the database column TB_PROMOTER_FS_REQ.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    private Date createTime;

    /**
     * This field corresponds to the database column TB_PROMOTER_FS_REQ.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column TB_PROMOTER_FS_REQ.MARGIN_MEMBER_ID
     * column comments 代理商memberId
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    private String marginMemberId;

    /**
     * This method returns the value of the database column TB_PROMOTER_FS_REQ.PFR_ID
     *
     * @return the value of TB_PROMOTER_FS_REQ.PFR_ID
     * column comments null
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public Long getPfrId() {
        return pfrId;
    }

    /**
     * This method sets the value of the database column TB_PROMOTER_FS_REQ.PFR_ID
     *
     * @param pfrId the value for TB_PROMOTER_FS_REQ.PFR_ID
     * column comments null
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public void setPfrId(Long pfrId) {
        this.pfrId = pfrId;
    }

    /**
     * This method returns the value of the database column TB_PROMOTER_FS_REQ.PROMOTER_ID
     *
     * @return the value of TB_PROMOTER_FS_REQ.PROMOTER_ID
     * column comments 代理商编号
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public Long getPromoterId() {
        return promoterId;
    }

    /**
     * This method sets the value of the database column TB_PROMOTER_FS_REQ.PROMOTER_ID
     *
     * @param promoterId the value for TB_PROMOTER_FS_REQ.PROMOTER_ID
     * column comments 代理商编号
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public void setPromoterId(Long promoterId) {
        this.promoterId = promoterId;
    }

    /**
     * This method returns the value of the database column TB_PROMOTER_FS_REQ.TYPE
     *
     * @return the value of TB_PROMOTER_FS_REQ.TYPE
     * column comments 操作类型
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method sets the value of the database column TB_PROMOTER_FS_REQ.TYPE
     *
     * @param type the value for TB_PROMOTER_FS_REQ.TYPE
     * column comments 操作类型
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method returns the value of the database column TB_PROMOTER_FS_REQ.STATUS
     *
     * @return the value of TB_PROMOTER_FS_REQ.STATUS
     * column comments 状态
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column TB_PROMOTER_FS_REQ.STATUS
     *
     * @param status the value for TB_PROMOTER_FS_REQ.STATUS
     * column comments 状态
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column TB_PROMOTER_FS_REQ.MARGIN_ACCOUNT
     *
     * @return the value of TB_PROMOTER_FS_REQ.MARGIN_ACCOUNT
     * column comments 保证金账户-accountId
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public String getMarginAccount() {
        return marginAccount;
    }

    /**
     * This method sets the value of the database column TB_PROMOTER_FS_REQ.MARGIN_ACCOUNT
     *
     * @param marginAccount the value for TB_PROMOTER_FS_REQ.MARGIN_ACCOUNT
     * column comments 保证金账户-accountId
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public void setMarginAccount(String marginAccount) {
        this.marginAccount = marginAccount == null ? null : marginAccount.trim();
    }

    /**
     * This method returns the value of the database column TB_PROMOTER_FS_REQ.MAQ_ID
     *
     * @return the value of TB_PROMOTER_FS_REQ.MAQ_ID
     * column comments 开户记录ID
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public Long getMaqId() {
        return maqId;
    }

    /**
     * This method sets the value of the database column TB_PROMOTER_FS_REQ.MAQ_ID
     *
     * @param maqId the value for TB_PROMOTER_FS_REQ.MAQ_ID
     * column comments 开户记录ID
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public void setMaqId(Long maqId) {
        this.maqId = maqId;
    }

    /**
     * This method returns the value of the database column TB_PROMOTER_FS_REQ.FCM_ID
     *
     * @return the value of TB_PROMOTER_FS_REQ.FCM_ID
     * column comments 最新的配置修改记录ID
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public Long getFcmId() {
        return fcmId;
    }

    /**
     * This method sets the value of the database column TB_PROMOTER_FS_REQ.FCM_ID
     *
     * @param fcmId the value for TB_PROMOTER_FS_REQ.FCM_ID
     * column comments 最新的配置修改记录ID
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public void setFcmId(Long fcmId) {
        this.fcmId = fcmId;
    }

    /**
     * This method returns the value of the database column TB_PROMOTER_FS_REQ.CREATE_TIME
     *
     * @return the value of TB_PROMOTER_FS_REQ.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column TB_PROMOTER_FS_REQ.CREATE_TIME
     *
     * @param createTime the value for TB_PROMOTER_FS_REQ.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column TB_PROMOTER_FS_REQ.UPDATE_TIME
     *
     * @return the value of TB_PROMOTER_FS_REQ.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column TB_PROMOTER_FS_REQ.UPDATE_TIME
     *
     * @param updateTime the value for TB_PROMOTER_FS_REQ.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column TB_PROMOTER_FS_REQ.MARGIN_MEMBER_ID
     *
     * @return the value of TB_PROMOTER_FS_REQ.MARGIN_MEMBER_ID
     * column comments 代理商memberId
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public String getMarginMemberId() {
        return marginMemberId;
    }

    /**
     * This method sets the value of the database column TB_PROMOTER_FS_REQ.MARGIN_MEMBER_ID
     *
     * @param marginMemberId the value for TB_PROMOTER_FS_REQ.MARGIN_MEMBER_ID
     * column comments 代理商memberId
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public void setMarginMemberId(String marginMemberId) {
        this.marginMemberId = marginMemberId == null ? null : marginMemberId.trim();
    }
}