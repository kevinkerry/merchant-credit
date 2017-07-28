package com.sdp.mc.ffconfig.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.util.Date;

public class FastSettleConfigDO extends BaseDO {
    /**
     * This field corresponds to the database column TB_FAST_SETTLE_CONFIG.PFC_ID
     * column comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    private Long pfcId;

    /**
     * This field corresponds to the database column TB_FAST_SETTLE_CONFIG.OBJ_ID
     * column comments 对象(代理商/商户)编号
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    private Long objId;

    /**
     * This field corresponds to the database column TB_FAST_SETTLE_CONFIG.OBJ_TYPE
     * column comments 0：代理商
1：商户
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    private Integer objType;

    /**
     * This field corresponds to the database column TB_FAST_SETTLE_CONFIG.AUTO_FAST_SETTLE
     * column comments 自动快速结算(1:是,0否)
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    private Integer autoFastSettle;

    /**
     * This field corresponds to the database column TB_FAST_SETTLE_CONFIG.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    private Date createTime;

    /**
     * This field corresponds to the database column TB_FAST_SETTLE_CONFIG.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column TB_FAST_SETTLE_CONFIG.MERCHANT_PHONE
     * column comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    private String merchantPhone;

    /**
     * This method returns the value of the database column TB_FAST_SETTLE_CONFIG.PFC_ID
     *
     * @return the value of TB_FAST_SETTLE_CONFIG.PFC_ID
     * column comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public Long getPfcId() {
        return pfcId;
    }

    /**
     * This method sets the value of the database column TB_FAST_SETTLE_CONFIG.PFC_ID
     *
     * @param pfcId the value for TB_FAST_SETTLE_CONFIG.PFC_ID
     * column comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public void setPfcId(Long pfcId) {
        this.pfcId = pfcId;
    }

    /**
     * This method returns the value of the database column TB_FAST_SETTLE_CONFIG.OBJ_ID
     *
     * @return the value of TB_FAST_SETTLE_CONFIG.OBJ_ID
     * column comments 对象(代理商/商户)编号
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public Long getObjId() {
        return objId;
    }

    /**
     * This method sets the value of the database column TB_FAST_SETTLE_CONFIG.OBJ_ID
     *
     * @param objId the value for TB_FAST_SETTLE_CONFIG.OBJ_ID
     * column comments 对象(代理商/商户)编号
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public void setObjId(Long objId) {
        this.objId = objId;
    }

    /**
     * This method returns the value of the database column TB_FAST_SETTLE_CONFIG.OBJ_TYPE
     *
     * @return the value of TB_FAST_SETTLE_CONFIG.OBJ_TYPE
     * column comments 0：代理商
1：商户
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public Integer getObjType() {
        return objType;
    }

    /**
     * This method sets the value of the database column TB_FAST_SETTLE_CONFIG.OBJ_TYPE
     *
     * @param objType the value for TB_FAST_SETTLE_CONFIG.OBJ_TYPE
     * column comments 0：代理商
1：商户
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public void setObjType(Integer objType) {
        this.objType = objType;
    }

    /**
     * This method returns the value of the database column TB_FAST_SETTLE_CONFIG.AUTO_FAST_SETTLE
     *
     * @return the value of TB_FAST_SETTLE_CONFIG.AUTO_FAST_SETTLE
     * column comments 自动快速结算(1:是,0否)
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public Integer getAutoFastSettle() {
        return autoFastSettle;
    }

    /**
     * This method sets the value of the database column TB_FAST_SETTLE_CONFIG.AUTO_FAST_SETTLE
     *
     * @param autoFastSettle the value for TB_FAST_SETTLE_CONFIG.AUTO_FAST_SETTLE
     * column comments 自动快速结算(1:是,0否)
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public void setAutoFastSettle(Integer autoFastSettle) {
        this.autoFastSettle = autoFastSettle;
    }

    /**
     * This method returns the value of the database column TB_FAST_SETTLE_CONFIG.CREATE_TIME
     *
     * @return the value of TB_FAST_SETTLE_CONFIG.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column TB_FAST_SETTLE_CONFIG.CREATE_TIME
     *
     * @param createTime the value for TB_FAST_SETTLE_CONFIG.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column TB_FAST_SETTLE_CONFIG.UPDATE_TIME
     *
     * @return the value of TB_FAST_SETTLE_CONFIG.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column TB_FAST_SETTLE_CONFIG.UPDATE_TIME
     *
     * @param updateTime the value for TB_FAST_SETTLE_CONFIG.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column TB_FAST_SETTLE_CONFIG.MERCHANT_PHONE
     *
     * @return the value of TB_FAST_SETTLE_CONFIG.MERCHANT_PHONE
     * column comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public String getMerchantPhone() {
        return merchantPhone;
    }

    /**
     * This method sets the value of the database column TB_FAST_SETTLE_CONFIG.MERCHANT_PHONE
     *
     * @param merchantPhone the value for TB_FAST_SETTLE_CONFIG.MERCHANT_PHONE
     * column comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public void setMerchantPhone(String merchantPhone) {
        this.merchantPhone = merchantPhone == null ? null : merchantPhone.trim();
    }
}