package com.sdp.mc.msp.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.math.BigDecimal;
import java.util.Date;

public class FsConfigChangeDO extends BaseDO {
    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.FCM_ID
     * column comments null
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private Long fcmId;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.TYPE
     * column comments 0：代理商
1：商户
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private Integer type;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.OBJ_ID
     * column comments null
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private Long objId;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.OP_TYPE
     * column comments 1： "开通"
2： "关闭
3： "追加保证金
4： "退回保证金" 10:“批量修改商户额度”
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private Integer opType;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.VERSION
     * column comments null
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private Integer version;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.STATUS
     * column comments 0：初始化
1：配置成功
-1：配置失败
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private Integer status;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.FAST_SETTLE_FLAG
     * column comments null
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private Integer fastSettleFlag;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.FAST_SETTLE_MARGIN
     * column comments 保证金金额
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private BigDecimal fastSettleMargin;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.FAST_SETTLE_LIMIT
     * column comments 快速结算额度
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private BigDecimal fastSettleLimit;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.FAST_CONFIGURE_LIMIT
     * column comments 快速结算可配置额度
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private BigDecimal fastConfigureLimit;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.FAST_SETTLE_RATIO
     * column comments 商户快速结算比例
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private BigDecimal fastSettleRatio;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.FAST_SETTLE_WORKDAY_FEE
     * column comments 快速结算工作日费率
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private BigDecimal fastSettleWorkdayFee;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.FAST_SETTLE_HOLIDAY_FEE
     * column comments 快速结算非工作日费率
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private BigDecimal fastSettleHolidayFee;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_FLAG
     * column comments null
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private Integer beforeFastSettleFlag;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_MARGIN
     * column comments 保证金金额
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private BigDecimal beforeFastSettleMargin;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_LIMIT
     * column comments 快速结算额度
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private BigDecimal beforeFastSettleLimit;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.BEFORE_FAST_CONFIGURE_LIMIT
     * column comments 快速结算可配置额度
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private BigDecimal beforeFastConfigureLimit;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_RATIO
     * column comments 商户快速结算比例
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private BigDecimal beforeFastSettleRatio;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.BEFOREFAST_SETTLE_WORKDAY_FEE
     * column comments 快速结算工作日费率
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private BigDecimal beforeFastSettleWorkdayFee;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.BEFOREFAST_SETTLE_HOLIDAY_FEE
     * column comments 快速结算非工作日费率
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private BigDecimal beforeFastSettleHolidayFee;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.LOANING_TYPE
     * column comments 垫资方：0代理商全资，1盛付通全资
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private Integer loaningType;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.FAST_SETTLE_MIN_LIMIT
     * column comments 快速结算最小额度
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private BigDecimal fastSettleMinLimit;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_MIN_LIMIT
     * column comments 之前快速结算的额度
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private BigDecimal beforeFastSettleMinLimit;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.AUTO_FAST_SETTLE
     * column comments 是否自动快速结算(0:否,1:是)
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private Integer autoFastSettle;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.BEFORE_AUTO_FAST_SETTLE
     * column comments 变更前是否自动快速结算(0:否,1:是)
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private Integer beforeAutoFastSettle;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.OPERATOR
     * column comments 变更操作者
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private String operator;

    /**
     * This field corresponds to the database column TB_FS_CONFIG_CHANGE.PROMOTER_MIN_MARGIN
     * column comments 代理商最低保证金
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    private BigDecimal promoterMinMargin;

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.FCM_ID
     *
     * @return the value of TB_FS_CONFIG_CHANGE.FCM_ID
     * column comments null
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public Long getFcmId() {
        return fcmId;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.FCM_ID
     *
     * @param fcmId the value for TB_FS_CONFIG_CHANGE.FCM_ID
     * column comments null
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setFcmId(Long fcmId) {
        this.fcmId = fcmId;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.TYPE
     *
     * @return the value of TB_FS_CONFIG_CHANGE.TYPE
     * column comments 0：代理商
1：商户
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.TYPE
     *
     * @param type the value for TB_FS_CONFIG_CHANGE.TYPE
     * column comments 0：代理商
1：商户
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.OBJ_ID
     *
     * @return the value of TB_FS_CONFIG_CHANGE.OBJ_ID
     * column comments null
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public Long getObjId() {
        return objId;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.OBJ_ID
     *
     * @param objId the value for TB_FS_CONFIG_CHANGE.OBJ_ID
     * column comments null
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setObjId(Long objId) {
        this.objId = objId;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.OP_TYPE
     *
     * @return the value of TB_FS_CONFIG_CHANGE.OP_TYPE
     * column comments 1： "开通"
2： "关闭
3： "追加保证金
4： "退回保证金" 10:“批量修改商户额度”
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public Integer getOpType() {
        return opType;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.OP_TYPE
     *
     * @param opType the value for TB_FS_CONFIG_CHANGE.OP_TYPE
     * column comments 1： "开通"
2： "关闭
3： "追加保证金
4： "退回保证金" 10:“批量修改商户额度”
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setOpType(Integer opType) {
        this.opType = opType;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.VERSION
     *
     * @return the value of TB_FS_CONFIG_CHANGE.VERSION
     * column comments null
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.VERSION
     *
     * @param version the value for TB_FS_CONFIG_CHANGE.VERSION
     * column comments null
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.STATUS
     *
     * @return the value of TB_FS_CONFIG_CHANGE.STATUS
     * column comments 0：初始化
1：配置成功
-1：配置失败
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.STATUS
     *
     * @param status the value for TB_FS_CONFIG_CHANGE.STATUS
     * column comments 0：初始化
1：配置成功
-1：配置失败
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.FAST_SETTLE_FLAG
     *
     * @return the value of TB_FS_CONFIG_CHANGE.FAST_SETTLE_FLAG
     * column comments null
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public Integer getFastSettleFlag() {
        return fastSettleFlag;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.FAST_SETTLE_FLAG
     *
     * @param fastSettleFlag the value for TB_FS_CONFIG_CHANGE.FAST_SETTLE_FLAG
     * column comments null
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setFastSettleFlag(Integer fastSettleFlag) {
        this.fastSettleFlag = fastSettleFlag;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.FAST_SETTLE_MARGIN
     *
     * @return the value of TB_FS_CONFIG_CHANGE.FAST_SETTLE_MARGIN
     * column comments 保证金金额
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public BigDecimal getFastSettleMargin() {
        return fastSettleMargin;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.FAST_SETTLE_MARGIN
     *
     * @param fastSettleMargin the value for TB_FS_CONFIG_CHANGE.FAST_SETTLE_MARGIN
     * column comments 保证金金额
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setFastSettleMargin(BigDecimal fastSettleMargin) {
        this.fastSettleMargin = fastSettleMargin;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.FAST_SETTLE_LIMIT
     *
     * @return the value of TB_FS_CONFIG_CHANGE.FAST_SETTLE_LIMIT
     * column comments 快速结算额度
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public BigDecimal getFastSettleLimit() {
        return fastSettleLimit;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.FAST_SETTLE_LIMIT
     *
     * @param fastSettleLimit the value for TB_FS_CONFIG_CHANGE.FAST_SETTLE_LIMIT
     * column comments 快速结算额度
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setFastSettleLimit(BigDecimal fastSettleLimit) {
        this.fastSettleLimit = fastSettleLimit;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.FAST_CONFIGURE_LIMIT
     *
     * @return the value of TB_FS_CONFIG_CHANGE.FAST_CONFIGURE_LIMIT
     * column comments 快速结算可配置额度
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public BigDecimal getFastConfigureLimit() {
        return fastConfigureLimit;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.FAST_CONFIGURE_LIMIT
     *
     * @param fastConfigureLimit the value for TB_FS_CONFIG_CHANGE.FAST_CONFIGURE_LIMIT
     * column comments 快速结算可配置额度
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setFastConfigureLimit(BigDecimal fastConfigureLimit) {
        this.fastConfigureLimit = fastConfigureLimit;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.FAST_SETTLE_RATIO
     *
     * @return the value of TB_FS_CONFIG_CHANGE.FAST_SETTLE_RATIO
     * column comments 商户快速结算比例
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public BigDecimal getFastSettleRatio() {
        return fastSettleRatio;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.FAST_SETTLE_RATIO
     *
     * @param fastSettleRatio the value for TB_FS_CONFIG_CHANGE.FAST_SETTLE_RATIO
     * column comments 商户快速结算比例
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setFastSettleRatio(BigDecimal fastSettleRatio) {
        this.fastSettleRatio = fastSettleRatio;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.FAST_SETTLE_WORKDAY_FEE
     *
     * @return the value of TB_FS_CONFIG_CHANGE.FAST_SETTLE_WORKDAY_FEE
     * column comments 快速结算工作日费率
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public BigDecimal getFastSettleWorkdayFee() {
        return fastSettleWorkdayFee;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.FAST_SETTLE_WORKDAY_FEE
     *
     * @param fastSettleWorkdayFee the value for TB_FS_CONFIG_CHANGE.FAST_SETTLE_WORKDAY_FEE
     * column comments 快速结算工作日费率
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setFastSettleWorkdayFee(BigDecimal fastSettleWorkdayFee) {
        this.fastSettleWorkdayFee = fastSettleWorkdayFee;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.FAST_SETTLE_HOLIDAY_FEE
     *
     * @return the value of TB_FS_CONFIG_CHANGE.FAST_SETTLE_HOLIDAY_FEE
     * column comments 快速结算非工作日费率
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public BigDecimal getFastSettleHolidayFee() {
        return fastSettleHolidayFee;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.FAST_SETTLE_HOLIDAY_FEE
     *
     * @param fastSettleHolidayFee the value for TB_FS_CONFIG_CHANGE.FAST_SETTLE_HOLIDAY_FEE
     * column comments 快速结算非工作日费率
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setFastSettleHolidayFee(BigDecimal fastSettleHolidayFee) {
        this.fastSettleHolidayFee = fastSettleHolidayFee;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_FLAG
     *
     * @return the value of TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_FLAG
     * column comments null
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public Integer getBeforeFastSettleFlag() {
        return beforeFastSettleFlag;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_FLAG
     *
     * @param beforeFastSettleFlag the value for TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_FLAG
     * column comments null
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setBeforeFastSettleFlag(Integer beforeFastSettleFlag) {
        this.beforeFastSettleFlag = beforeFastSettleFlag;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_MARGIN
     *
     * @return the value of TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_MARGIN
     * column comments 保证金金额
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public BigDecimal getBeforeFastSettleMargin() {
        return beforeFastSettleMargin;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_MARGIN
     *
     * @param beforeFastSettleMargin the value for TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_MARGIN
     * column comments 保证金金额
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setBeforeFastSettleMargin(BigDecimal beforeFastSettleMargin) {
        this.beforeFastSettleMargin = beforeFastSettleMargin;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_LIMIT
     *
     * @return the value of TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_LIMIT
     * column comments 快速结算额度
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public BigDecimal getBeforeFastSettleLimit() {
        return beforeFastSettleLimit;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_LIMIT
     *
     * @param beforeFastSettleLimit the value for TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_LIMIT
     * column comments 快速结算额度
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setBeforeFastSettleLimit(BigDecimal beforeFastSettleLimit) {
        this.beforeFastSettleLimit = beforeFastSettleLimit;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.BEFORE_FAST_CONFIGURE_LIMIT
     *
     * @return the value of TB_FS_CONFIG_CHANGE.BEFORE_FAST_CONFIGURE_LIMIT
     * column comments 快速结算可配置额度
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public BigDecimal getBeforeFastConfigureLimit() {
        return beforeFastConfigureLimit;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.BEFORE_FAST_CONFIGURE_LIMIT
     *
     * @param beforeFastConfigureLimit the value for TB_FS_CONFIG_CHANGE.BEFORE_FAST_CONFIGURE_LIMIT
     * column comments 快速结算可配置额度
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setBeforeFastConfigureLimit(BigDecimal beforeFastConfigureLimit) {
        this.beforeFastConfigureLimit = beforeFastConfigureLimit;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_RATIO
     *
     * @return the value of TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_RATIO
     * column comments 商户快速结算比例
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public BigDecimal getBeforeFastSettleRatio() {
        return beforeFastSettleRatio;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_RATIO
     *
     * @param beforeFastSettleRatio the value for TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_RATIO
     * column comments 商户快速结算比例
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setBeforeFastSettleRatio(BigDecimal beforeFastSettleRatio) {
        this.beforeFastSettleRatio = beforeFastSettleRatio;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.BEFOREFAST_SETTLE_WORKDAY_FEE
     *
     * @return the value of TB_FS_CONFIG_CHANGE.BEFOREFAST_SETTLE_WORKDAY_FEE
     * column comments 快速结算工作日费率
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public BigDecimal getBeforeFastSettleWorkdayFee() {
        return beforeFastSettleWorkdayFee;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.BEFOREFAST_SETTLE_WORKDAY_FEE
     *
     * @param beforeFastSettleWorkdayFee the value for TB_FS_CONFIG_CHANGE.BEFOREFAST_SETTLE_WORKDAY_FEE
     * column comments 快速结算工作日费率
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setBeforeFastSettleWorkdayFee(BigDecimal beforeFastSettleWorkdayFee) {
        this.beforeFastSettleWorkdayFee = beforeFastSettleWorkdayFee;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.BEFOREFAST_SETTLE_HOLIDAY_FEE
     *
     * @return the value of TB_FS_CONFIG_CHANGE.BEFOREFAST_SETTLE_HOLIDAY_FEE
     * column comments 快速结算非工作日费率
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public BigDecimal getBeforeFastSettleHolidayFee() {
        return beforeFastSettleHolidayFee;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.BEFOREFAST_SETTLE_HOLIDAY_FEE
     *
     * @param beforeFastSettleHolidayFee the value for TB_FS_CONFIG_CHANGE.BEFOREFAST_SETTLE_HOLIDAY_FEE
     * column comments 快速结算非工作日费率
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setBeforeFastSettleHolidayFee(BigDecimal beforeFastSettleHolidayFee) {
        this.beforeFastSettleHolidayFee = beforeFastSettleHolidayFee;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.CREATE_TIME
     *
     * @return the value of TB_FS_CONFIG_CHANGE.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.CREATE_TIME
     *
     * @param createTime the value for TB_FS_CONFIG_CHANGE.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.UPDATE_TIME
     *
     * @return the value of TB_FS_CONFIG_CHANGE.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.UPDATE_TIME
     *
     * @param updateTime the value for TB_FS_CONFIG_CHANGE.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.LOANING_TYPE
     *
     * @return the value of TB_FS_CONFIG_CHANGE.LOANING_TYPE
     * column comments 垫资方：0代理商全资，1盛付通全资
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public Integer getLoaningType() {
        return loaningType;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.LOANING_TYPE
     *
     * @param loaningType the value for TB_FS_CONFIG_CHANGE.LOANING_TYPE
     * column comments 垫资方：0代理商全资，1盛付通全资
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setLoaningType(Integer loaningType) {
        this.loaningType = loaningType;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.FAST_SETTLE_MIN_LIMIT
     *
     * @return the value of TB_FS_CONFIG_CHANGE.FAST_SETTLE_MIN_LIMIT
     * column comments 快速结算最小额度
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public BigDecimal getFastSettleMinLimit() {
        return fastSettleMinLimit;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.FAST_SETTLE_MIN_LIMIT
     *
     * @param fastSettleMinLimit the value for TB_FS_CONFIG_CHANGE.FAST_SETTLE_MIN_LIMIT
     * column comments 快速结算最小额度
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setFastSettleMinLimit(BigDecimal fastSettleMinLimit) {
        this.fastSettleMinLimit = fastSettleMinLimit;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_MIN_LIMIT
     *
     * @return the value of TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_MIN_LIMIT
     * column comments 之前快速结算的额度
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public BigDecimal getBeforeFastSettleMinLimit() {
        return beforeFastSettleMinLimit;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_MIN_LIMIT
     *
     * @param beforeFastSettleMinLimit the value for TB_FS_CONFIG_CHANGE.BEFORE_FAST_SETTLE_MIN_LIMIT
     * column comments 之前快速结算的额度
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setBeforeFastSettleMinLimit(BigDecimal beforeFastSettleMinLimit) {
        this.beforeFastSettleMinLimit = beforeFastSettleMinLimit;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.AUTO_FAST_SETTLE
     *
     * @return the value of TB_FS_CONFIG_CHANGE.AUTO_FAST_SETTLE
     * column comments 是否自动快速结算(0:否,1:是)
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public Integer getAutoFastSettle() {
        return autoFastSettle;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.AUTO_FAST_SETTLE
     *
     * @param autoFastSettle the value for TB_FS_CONFIG_CHANGE.AUTO_FAST_SETTLE
     * column comments 是否自动快速结算(0:否,1:是)
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setAutoFastSettle(Integer autoFastSettle) {
        this.autoFastSettle = autoFastSettle;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.BEFORE_AUTO_FAST_SETTLE
     *
     * @return the value of TB_FS_CONFIG_CHANGE.BEFORE_AUTO_FAST_SETTLE
     * column comments 变更前是否自动快速结算(0:否,1:是)
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public Integer getBeforeAutoFastSettle() {
        return beforeAutoFastSettle;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.BEFORE_AUTO_FAST_SETTLE
     *
     * @param beforeAutoFastSettle the value for TB_FS_CONFIG_CHANGE.BEFORE_AUTO_FAST_SETTLE
     * column comments 变更前是否自动快速结算(0:否,1:是)
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setBeforeAutoFastSettle(Integer beforeAutoFastSettle) {
        this.beforeAutoFastSettle = beforeAutoFastSettle;
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.OPERATOR
     *
     * @return the value of TB_FS_CONFIG_CHANGE.OPERATOR
     * column comments 变更操作者
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.OPERATOR
     *
     * @param operator the value for TB_FS_CONFIG_CHANGE.OPERATOR
     * column comments 变更操作者
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * This method returns the value of the database column TB_FS_CONFIG_CHANGE.PROMOTER_MIN_MARGIN
     *
     * @return the value of TB_FS_CONFIG_CHANGE.PROMOTER_MIN_MARGIN
     * column comments 代理商最低保证金
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public BigDecimal getPromoterMinMargin() {
        return promoterMinMargin;
    }

    /**
     * This method sets the value of the database column TB_FS_CONFIG_CHANGE.PROMOTER_MIN_MARGIN
     *
     * @param promoterMinMargin the value for TB_FS_CONFIG_CHANGE.PROMOTER_MIN_MARGIN
     * column comments 代理商最低保证金
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setPromoterMinMargin(BigDecimal promoterMinMargin) {
        this.promoterMinMargin = promoterMinMargin;
    }
}