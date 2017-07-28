package com.sdp.mc.margin.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.math.BigDecimal;
import java.util.Date;

public class MarginOpReqDO extends BaseDO {
    /**
     * This field corresponds to the database column TB_MARGIN_OP_REQ.MOR_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    private Long morId;

    /**
     * This field corresponds to the database column TB_MARGIN_OP_REQ.PROMOTER_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    private Long promoterId;

    /**
     * This field corresponds to the database column TB_MARGIN_OP_REQ.OP_TYPE
     * column comments 1：追加保证金
2：回退保证金
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    private Integer opType;

    /**
     * This field corresponds to the database column TB_MARGIN_OP_REQ.STATUS
     * column comments 追加：
0：初始化
101：转账成功
-101：转账失败
102：配置更改成功（退款申请成功）
-102：配置更改失败

退回
0：初始化
201：配置更改成功（退款申请成功）
-201：配置更改失败
202：转账成功
-202：转账失败

     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    private Integer status;

    /**
     * This field corresponds to the database column TB_MARGIN_OP_REQ.AMOUNT
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    private BigDecimal amount;

    /**
     * This field corresponds to the database column TB_MARGIN_OP_REQ.REDEEMED_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    private Date redeemedTime;

    /**
     * This field corresponds to the database column TB_MARGIN_OP_REQ.MT_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    private String mtId;

    /**
     * This field corresponds to the database column TB_MARGIN_OP_REQ.MT_ID_HIS
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    private String mtIdHis;

    /**
     * This field corresponds to the database column TB_MARGIN_OP_REQ.FCM_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    private Long fcmId;

    /**
     * This field corresponds to the database column TB_MARGIN_OP_REQ.FCM_ID_HIS
     * column comments 配置更改记录历史
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    private String fcmIdHis;

    /**
     * This field corresponds to the database column TB_MARGIN_OP_REQ.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    private Date createTime;

    /**
     * This field corresponds to the database column TB_MARGIN_OP_REQ.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    private Date updateTime;

    /**
     * This method returns the value of the database column TB_MARGIN_OP_REQ.MOR_ID
     *
     * @return the value of TB_MARGIN_OP_REQ.MOR_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public Long getMorId() {
        return morId;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_OP_REQ.MOR_ID
     *
     * @param morId the value for TB_MARGIN_OP_REQ.MOR_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setMorId(Long morId) {
        this.morId = morId;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_OP_REQ.PROMOTER_ID
     *
     * @return the value of TB_MARGIN_OP_REQ.PROMOTER_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public Long getPromoterId() {
        return promoterId;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_OP_REQ.PROMOTER_ID
     *
     * @param promoterId the value for TB_MARGIN_OP_REQ.PROMOTER_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setPromoterId(Long promoterId) {
        this.promoterId = promoterId;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_OP_REQ.OP_TYPE
     *
     * @return the value of TB_MARGIN_OP_REQ.OP_TYPE
     * column comments 1：追加保证金
2：回退保证金
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public Integer getOpType() {
        return opType;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_OP_REQ.OP_TYPE
     *
     * @param opType the value for TB_MARGIN_OP_REQ.OP_TYPE
     * column comments 1：追加保证金
2：回退保证金
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setOpType(Integer opType) {
        this.opType = opType;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_OP_REQ.STATUS
     *
     * @return the value of TB_MARGIN_OP_REQ.STATUS
     * column comments 追加：
0：初始化
101：转账成功
-101：转账失败
102：配置更改成功（退款申请成功）
-102：配置更改失败

退回
0：初始化
201：配置更改成功（退款申请成功）
-201：配置更改失败
202：转账成功
-202：转账失败

     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_OP_REQ.STATUS
     *
     * @param status the value for TB_MARGIN_OP_REQ.STATUS
     * column comments 追加：
0：初始化
101：转账成功
-101：转账失败
102：配置更改成功（退款申请成功）
-102：配置更改失败

退回
0：初始化
201：配置更改成功（退款申请成功）
-201：配置更改失败
202：转账成功
-202：转账失败

     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_OP_REQ.AMOUNT
     *
     * @return the value of TB_MARGIN_OP_REQ.AMOUNT
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_OP_REQ.AMOUNT
     *
     * @param amount the value for TB_MARGIN_OP_REQ.AMOUNT
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_OP_REQ.REDEEMED_TIME
     *
     * @return the value of TB_MARGIN_OP_REQ.REDEEMED_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public Date getRedeemedTime() {
        return redeemedTime;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_OP_REQ.REDEEMED_TIME
     *
     * @param redeemedTime the value for TB_MARGIN_OP_REQ.REDEEMED_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setRedeemedTime(Date redeemedTime) {
        this.redeemedTime = redeemedTime;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_OP_REQ.MT_ID
     *
     * @return the value of TB_MARGIN_OP_REQ.MT_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public String getMtId() {
        return mtId;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_OP_REQ.MT_ID
     *
     * @param mtId the value for TB_MARGIN_OP_REQ.MT_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setMtId(String mtId) {
        this.mtId = mtId == null ? null : mtId.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_OP_REQ.MT_ID_HIS
     *
     * @return the value of TB_MARGIN_OP_REQ.MT_ID_HIS
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public String getMtIdHis() {
        return mtIdHis;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_OP_REQ.MT_ID_HIS
     *
     * @param mtIdHis the value for TB_MARGIN_OP_REQ.MT_ID_HIS
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setMtIdHis(String mtIdHis) {
        this.mtIdHis = mtIdHis == null ? null : mtIdHis.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_OP_REQ.FCM_ID
     *
     * @return the value of TB_MARGIN_OP_REQ.FCM_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public Long getFcmId() {
        return fcmId;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_OP_REQ.FCM_ID
     *
     * @param fcmId the value for TB_MARGIN_OP_REQ.FCM_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setFcmId(Long fcmId) {
        this.fcmId = fcmId;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_OP_REQ.FCM_ID_HIS
     *
     * @return the value of TB_MARGIN_OP_REQ.FCM_ID_HIS
     * column comments 配置更改记录历史
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public String getFcmIdHis() {
        return fcmIdHis;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_OP_REQ.FCM_ID_HIS
     *
     * @param fcmIdHis the value for TB_MARGIN_OP_REQ.FCM_ID_HIS
     * column comments 配置更改记录历史
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setFcmIdHis(String fcmIdHis) {
        this.fcmIdHis = fcmIdHis == null ? null : fcmIdHis.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_OP_REQ.CREATE_TIME
     *
     * @return the value of TB_MARGIN_OP_REQ.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_OP_REQ.CREATE_TIME
     *
     * @param createTime the value for TB_MARGIN_OP_REQ.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_OP_REQ.UPDATE_TIME
     *
     * @return the value of TB_MARGIN_OP_REQ.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_OP_REQ.UPDATE_TIME
     *
     * @param updateTime the value for TB_MARGIN_OP_REQ.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}