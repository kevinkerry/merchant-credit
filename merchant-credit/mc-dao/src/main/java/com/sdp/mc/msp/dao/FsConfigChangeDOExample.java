package com.sdp.mc.msp.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FsConfigChangeDOExample extends QueryBase {
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
     * This field corresponds to the database table TB_FS_CONFIG_CHANGE
     * table comments 配置更改记录
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table TB_FS_CONFIG_CHANGE
     * table comments 配置更改记录
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table TB_FS_CONFIG_CHANGE
     * table comments 配置更改记录
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table TB_FS_CONFIG_CHANGE
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public FsConfigChangeDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

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

    /**
     * This method corresponds to the database table TB_FS_CONFIG_CHANGE
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table TB_FS_CONFIG_CHANGE
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table TB_FS_CONFIG_CHANGE
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table TB_FS_CONFIG_CHANGE
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table TB_FS_CONFIG_CHANGE
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table TB_FS_CONFIG_CHANGE
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table TB_FS_CONFIG_CHANGE
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_FS_CONFIG_CHANGE
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_FS_CONFIG_CHANGE
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_FS_CONFIG_CHANGE
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_FS_CONFIG_CHANGE
     * table comment :配置更改记录
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andFcmIdIsNull() {
            addCriterion("FCM_ID is null");
            return (Criteria) this;
        }

        public Criteria andFcmIdIsNotNull() {
            addCriterion("FCM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFcmIdEqualTo(Long value) {
            addCriterion("FCM_ID =", value, "fcmId");
            return (Criteria) this;
        }

        public Criteria andFcmIdNotEqualTo(Long value) {
            addCriterion("FCM_ID <>", value, "fcmId");
            return (Criteria) this;
        }

        public Criteria andFcmIdGreaterThan(Long value) {
            addCriterion("FCM_ID >", value, "fcmId");
            return (Criteria) this;
        }

        public Criteria andFcmIdGreaterThanOrEqualTo(Long value) {
            addCriterion("FCM_ID >=", value, "fcmId");
            return (Criteria) this;
        }

        public Criteria andFcmIdLessThan(Long value) {
            addCriterion("FCM_ID <", value, "fcmId");
            return (Criteria) this;
        }

        public Criteria andFcmIdLessThanOrEqualTo(Long value) {
            addCriterion("FCM_ID <=", value, "fcmId");
            return (Criteria) this;
        }

        public Criteria andFcmIdIn(List<Long> values) {
            addCriterion("FCM_ID in", values, "fcmId");
            return (Criteria) this;
        }

        public Criteria andFcmIdNotIn(List<Long> values) {
            addCriterion("FCM_ID not in", values, "fcmId");
            return (Criteria) this;
        }

        public Criteria andFcmIdBetween(Long value1, Long value2) {
            addCriterion("FCM_ID between", value1, value2, "fcmId");
            return (Criteria) this;
        }

        public Criteria andFcmIdNotBetween(Long value1, Long value2) {
            addCriterion("FCM_ID not between", value1, value2, "fcmId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andObjIdIsNull() {
            addCriterion("OBJ_ID is null");
            return (Criteria) this;
        }

        public Criteria andObjIdIsNotNull() {
            addCriterion("OBJ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andObjIdEqualTo(Long value) {
            addCriterion("OBJ_ID =", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdNotEqualTo(Long value) {
            addCriterion("OBJ_ID <>", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdGreaterThan(Long value) {
            addCriterion("OBJ_ID >", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdGreaterThanOrEqualTo(Long value) {
            addCriterion("OBJ_ID >=", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdLessThan(Long value) {
            addCriterion("OBJ_ID <", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdLessThanOrEqualTo(Long value) {
            addCriterion("OBJ_ID <=", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdIn(List<Long> values) {
            addCriterion("OBJ_ID in", values, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdNotIn(List<Long> values) {
            addCriterion("OBJ_ID not in", values, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdBetween(Long value1, Long value2) {
            addCriterion("OBJ_ID between", value1, value2, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdNotBetween(Long value1, Long value2) {
            addCriterion("OBJ_ID not between", value1, value2, "objId");
            return (Criteria) this;
        }

        public Criteria andOpTypeIsNull() {
            addCriterion("OP_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOpTypeIsNotNull() {
            addCriterion("OP_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOpTypeEqualTo(Integer value) {
            addCriterion("OP_TYPE =", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotEqualTo(Integer value) {
            addCriterion("OP_TYPE <>", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeGreaterThan(Integer value) {
            addCriterion("OP_TYPE >", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("OP_TYPE >=", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeLessThan(Integer value) {
            addCriterion("OP_TYPE <", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeLessThanOrEqualTo(Integer value) {
            addCriterion("OP_TYPE <=", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeIn(List<Integer> values) {
            addCriterion("OP_TYPE in", values, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotIn(List<Integer> values) {
            addCriterion("OP_TYPE not in", values, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeBetween(Integer value1, Integer value2) {
            addCriterion("OP_TYPE between", value1, value2, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("OP_TYPE not between", value1, value2, "opType");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("VERSION not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagIsNull() {
            addCriterion("FAST_SETTLE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagIsNotNull() {
            addCriterion("FAST_SETTLE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagEqualTo(Integer value) {
            addCriterion("FAST_SETTLE_FLAG =", value, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagNotEqualTo(Integer value) {
            addCriterion("FAST_SETTLE_FLAG <>", value, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagGreaterThan(Integer value) {
            addCriterion("FAST_SETTLE_FLAG >", value, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("FAST_SETTLE_FLAG >=", value, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagLessThan(Integer value) {
            addCriterion("FAST_SETTLE_FLAG <", value, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagLessThanOrEqualTo(Integer value) {
            addCriterion("FAST_SETTLE_FLAG <=", value, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagIn(List<Integer> values) {
            addCriterion("FAST_SETTLE_FLAG in", values, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagNotIn(List<Integer> values) {
            addCriterion("FAST_SETTLE_FLAG not in", values, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagBetween(Integer value1, Integer value2) {
            addCriterion("FAST_SETTLE_FLAG between", value1, value2, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("FAST_SETTLE_FLAG not between", value1, value2, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleMarginIsNull() {
            addCriterion("FAST_SETTLE_MARGIN is null");
            return (Criteria) this;
        }

        public Criteria andFastSettleMarginIsNotNull() {
            addCriterion("FAST_SETTLE_MARGIN is not null");
            return (Criteria) this;
        }

        public Criteria andFastSettleMarginEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_MARGIN =", value, "fastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andFastSettleMarginNotEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_MARGIN <>", value, "fastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andFastSettleMarginGreaterThan(BigDecimal value) {
            addCriterion("FAST_SETTLE_MARGIN >", value, "fastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andFastSettleMarginGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_MARGIN >=", value, "fastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andFastSettleMarginLessThan(BigDecimal value) {
            addCriterion("FAST_SETTLE_MARGIN <", value, "fastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andFastSettleMarginLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_MARGIN <=", value, "fastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andFastSettleMarginIn(List<BigDecimal> values) {
            addCriterion("FAST_SETTLE_MARGIN in", values, "fastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andFastSettleMarginNotIn(List<BigDecimal> values) {
            addCriterion("FAST_SETTLE_MARGIN not in", values, "fastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andFastSettleMarginBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAST_SETTLE_MARGIN between", value1, value2, "fastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andFastSettleMarginNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAST_SETTLE_MARGIN not between", value1, value2, "fastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitIsNull() {
            addCriterion("FAST_SETTLE_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitIsNotNull() {
            addCriterion("FAST_SETTLE_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_LIMIT =", value, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitNotEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_LIMIT <>", value, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitGreaterThan(BigDecimal value) {
            addCriterion("FAST_SETTLE_LIMIT >", value, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_LIMIT >=", value, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitLessThan(BigDecimal value) {
            addCriterion("FAST_SETTLE_LIMIT <", value, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_LIMIT <=", value, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitIn(List<BigDecimal> values) {
            addCriterion("FAST_SETTLE_LIMIT in", values, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitNotIn(List<BigDecimal> values) {
            addCriterion("FAST_SETTLE_LIMIT not in", values, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAST_SETTLE_LIMIT between", value1, value2, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAST_SETTLE_LIMIT not between", value1, value2, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastConfigureLimitIsNull() {
            addCriterion("FAST_CONFIGURE_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andFastConfigureLimitIsNotNull() {
            addCriterion("FAST_CONFIGURE_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andFastConfigureLimitEqualTo(BigDecimal value) {
            addCriterion("FAST_CONFIGURE_LIMIT =", value, "fastConfigureLimit");
            return (Criteria) this;
        }

        public Criteria andFastConfigureLimitNotEqualTo(BigDecimal value) {
            addCriterion("FAST_CONFIGURE_LIMIT <>", value, "fastConfigureLimit");
            return (Criteria) this;
        }

        public Criteria andFastConfigureLimitGreaterThan(BigDecimal value) {
            addCriterion("FAST_CONFIGURE_LIMIT >", value, "fastConfigureLimit");
            return (Criteria) this;
        }

        public Criteria andFastConfigureLimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FAST_CONFIGURE_LIMIT >=", value, "fastConfigureLimit");
            return (Criteria) this;
        }

        public Criteria andFastConfigureLimitLessThan(BigDecimal value) {
            addCriterion("FAST_CONFIGURE_LIMIT <", value, "fastConfigureLimit");
            return (Criteria) this;
        }

        public Criteria andFastConfigureLimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FAST_CONFIGURE_LIMIT <=", value, "fastConfigureLimit");
            return (Criteria) this;
        }

        public Criteria andFastConfigureLimitIn(List<BigDecimal> values) {
            addCriterion("FAST_CONFIGURE_LIMIT in", values, "fastConfigureLimit");
            return (Criteria) this;
        }

        public Criteria andFastConfigureLimitNotIn(List<BigDecimal> values) {
            addCriterion("FAST_CONFIGURE_LIMIT not in", values, "fastConfigureLimit");
            return (Criteria) this;
        }

        public Criteria andFastConfigureLimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAST_CONFIGURE_LIMIT between", value1, value2, "fastConfigureLimit");
            return (Criteria) this;
        }

        public Criteria andFastConfigureLimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAST_CONFIGURE_LIMIT not between", value1, value2, "fastConfigureLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleRatioIsNull() {
            addCriterion("FAST_SETTLE_RATIO is null");
            return (Criteria) this;
        }

        public Criteria andFastSettleRatioIsNotNull() {
            addCriterion("FAST_SETTLE_RATIO is not null");
            return (Criteria) this;
        }

        public Criteria andFastSettleRatioEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_RATIO =", value, "fastSettleRatio");
            return (Criteria) this;
        }

        public Criteria andFastSettleRatioNotEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_RATIO <>", value, "fastSettleRatio");
            return (Criteria) this;
        }

        public Criteria andFastSettleRatioGreaterThan(BigDecimal value) {
            addCriterion("FAST_SETTLE_RATIO >", value, "fastSettleRatio");
            return (Criteria) this;
        }

        public Criteria andFastSettleRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_RATIO >=", value, "fastSettleRatio");
            return (Criteria) this;
        }

        public Criteria andFastSettleRatioLessThan(BigDecimal value) {
            addCriterion("FAST_SETTLE_RATIO <", value, "fastSettleRatio");
            return (Criteria) this;
        }

        public Criteria andFastSettleRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_RATIO <=", value, "fastSettleRatio");
            return (Criteria) this;
        }

        public Criteria andFastSettleRatioIn(List<BigDecimal> values) {
            addCriterion("FAST_SETTLE_RATIO in", values, "fastSettleRatio");
            return (Criteria) this;
        }

        public Criteria andFastSettleRatioNotIn(List<BigDecimal> values) {
            addCriterion("FAST_SETTLE_RATIO not in", values, "fastSettleRatio");
            return (Criteria) this;
        }

        public Criteria andFastSettleRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAST_SETTLE_RATIO between", value1, value2, "fastSettleRatio");
            return (Criteria) this;
        }

        public Criteria andFastSettleRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAST_SETTLE_RATIO not between", value1, value2, "fastSettleRatio");
            return (Criteria) this;
        }

        public Criteria andFastSettleWorkdayFeeIsNull() {
            addCriterion("FAST_SETTLE_WORKDAY_FEE is null");
            return (Criteria) this;
        }

        public Criteria andFastSettleWorkdayFeeIsNotNull() {
            addCriterion("FAST_SETTLE_WORKDAY_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andFastSettleWorkdayFeeEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_WORKDAY_FEE =", value, "fastSettleWorkdayFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleWorkdayFeeNotEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_WORKDAY_FEE <>", value, "fastSettleWorkdayFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleWorkdayFeeGreaterThan(BigDecimal value) {
            addCriterion("FAST_SETTLE_WORKDAY_FEE >", value, "fastSettleWorkdayFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleWorkdayFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_WORKDAY_FEE >=", value, "fastSettleWorkdayFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleWorkdayFeeLessThan(BigDecimal value) {
            addCriterion("FAST_SETTLE_WORKDAY_FEE <", value, "fastSettleWorkdayFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleWorkdayFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_WORKDAY_FEE <=", value, "fastSettleWorkdayFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleWorkdayFeeIn(List<BigDecimal> values) {
            addCriterion("FAST_SETTLE_WORKDAY_FEE in", values, "fastSettleWorkdayFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleWorkdayFeeNotIn(List<BigDecimal> values) {
            addCriterion("FAST_SETTLE_WORKDAY_FEE not in", values, "fastSettleWorkdayFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleWorkdayFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAST_SETTLE_WORKDAY_FEE between", value1, value2, "fastSettleWorkdayFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleWorkdayFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAST_SETTLE_WORKDAY_FEE not between", value1, value2, "fastSettleWorkdayFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleHolidayFeeIsNull() {
            addCriterion("FAST_SETTLE_HOLIDAY_FEE is null");
            return (Criteria) this;
        }

        public Criteria andFastSettleHolidayFeeIsNotNull() {
            addCriterion("FAST_SETTLE_HOLIDAY_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andFastSettleHolidayFeeEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_HOLIDAY_FEE =", value, "fastSettleHolidayFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleHolidayFeeNotEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_HOLIDAY_FEE <>", value, "fastSettleHolidayFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleHolidayFeeGreaterThan(BigDecimal value) {
            addCriterion("FAST_SETTLE_HOLIDAY_FEE >", value, "fastSettleHolidayFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleHolidayFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_HOLIDAY_FEE >=", value, "fastSettleHolidayFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleHolidayFeeLessThan(BigDecimal value) {
            addCriterion("FAST_SETTLE_HOLIDAY_FEE <", value, "fastSettleHolidayFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleHolidayFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_HOLIDAY_FEE <=", value, "fastSettleHolidayFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleHolidayFeeIn(List<BigDecimal> values) {
            addCriterion("FAST_SETTLE_HOLIDAY_FEE in", values, "fastSettleHolidayFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleHolidayFeeNotIn(List<BigDecimal> values) {
            addCriterion("FAST_SETTLE_HOLIDAY_FEE not in", values, "fastSettleHolidayFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleHolidayFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAST_SETTLE_HOLIDAY_FEE between", value1, value2, "fastSettleHolidayFee");
            return (Criteria) this;
        }

        public Criteria andFastSettleHolidayFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAST_SETTLE_HOLIDAY_FEE not between", value1, value2, "fastSettleHolidayFee");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleFlagIsNull() {
            addCriterion("BEFORE_FAST_SETTLE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleFlagIsNotNull() {
            addCriterion("BEFORE_FAST_SETTLE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleFlagEqualTo(Integer value) {
            addCriterion("BEFORE_FAST_SETTLE_FLAG =", value, "beforeFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleFlagNotEqualTo(Integer value) {
            addCriterion("BEFORE_FAST_SETTLE_FLAG <>", value, "beforeFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleFlagGreaterThan(Integer value) {
            addCriterion("BEFORE_FAST_SETTLE_FLAG >", value, "beforeFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("BEFORE_FAST_SETTLE_FLAG >=", value, "beforeFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleFlagLessThan(Integer value) {
            addCriterion("BEFORE_FAST_SETTLE_FLAG <", value, "beforeFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleFlagLessThanOrEqualTo(Integer value) {
            addCriterion("BEFORE_FAST_SETTLE_FLAG <=", value, "beforeFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleFlagIn(List<Integer> values) {
            addCriterion("BEFORE_FAST_SETTLE_FLAG in", values, "beforeFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleFlagNotIn(List<Integer> values) {
            addCriterion("BEFORE_FAST_SETTLE_FLAG not in", values, "beforeFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleFlagBetween(Integer value1, Integer value2) {
            addCriterion("BEFORE_FAST_SETTLE_FLAG between", value1, value2, "beforeFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("BEFORE_FAST_SETTLE_FLAG not between", value1, value2, "beforeFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleMarginIsNull() {
            addCriterion("BEFORE_FAST_SETTLE_MARGIN is null");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleMarginIsNotNull() {
            addCriterion("BEFORE_FAST_SETTLE_MARGIN is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleMarginEqualTo(BigDecimal value) {
            addCriterion("BEFORE_FAST_SETTLE_MARGIN =", value, "beforeFastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleMarginNotEqualTo(BigDecimal value) {
            addCriterion("BEFORE_FAST_SETTLE_MARGIN <>", value, "beforeFastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleMarginGreaterThan(BigDecimal value) {
            addCriterion("BEFORE_FAST_SETTLE_MARGIN >", value, "beforeFastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleMarginGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BEFORE_FAST_SETTLE_MARGIN >=", value, "beforeFastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleMarginLessThan(BigDecimal value) {
            addCriterion("BEFORE_FAST_SETTLE_MARGIN <", value, "beforeFastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleMarginLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BEFORE_FAST_SETTLE_MARGIN <=", value, "beforeFastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleMarginIn(List<BigDecimal> values) {
            addCriterion("BEFORE_FAST_SETTLE_MARGIN in", values, "beforeFastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleMarginNotIn(List<BigDecimal> values) {
            addCriterion("BEFORE_FAST_SETTLE_MARGIN not in", values, "beforeFastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleMarginBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BEFORE_FAST_SETTLE_MARGIN between", value1, value2, "beforeFastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleMarginNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BEFORE_FAST_SETTLE_MARGIN not between", value1, value2, "beforeFastSettleMargin");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleLimitIsNull() {
            addCriterion("BEFORE_FAST_SETTLE_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleLimitIsNotNull() {
            addCriterion("BEFORE_FAST_SETTLE_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleLimitEqualTo(BigDecimal value) {
            addCriterion("BEFORE_FAST_SETTLE_LIMIT =", value, "beforeFastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleLimitNotEqualTo(BigDecimal value) {
            addCriterion("BEFORE_FAST_SETTLE_LIMIT <>", value, "beforeFastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleLimitGreaterThan(BigDecimal value) {
            addCriterion("BEFORE_FAST_SETTLE_LIMIT >", value, "beforeFastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleLimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BEFORE_FAST_SETTLE_LIMIT >=", value, "beforeFastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleLimitLessThan(BigDecimal value) {
            addCriterion("BEFORE_FAST_SETTLE_LIMIT <", value, "beforeFastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleLimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BEFORE_FAST_SETTLE_LIMIT <=", value, "beforeFastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleLimitIn(List<BigDecimal> values) {
            addCriterion("BEFORE_FAST_SETTLE_LIMIT in", values, "beforeFastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleLimitNotIn(List<BigDecimal> values) {
            addCriterion("BEFORE_FAST_SETTLE_LIMIT not in", values, "beforeFastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleLimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BEFORE_FAST_SETTLE_LIMIT between", value1, value2, "beforeFastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleLimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BEFORE_FAST_SETTLE_LIMIT not between", value1, value2, "beforeFastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastConfigureLimitIsNull() {
            addCriterion("BEFORE_FAST_CONFIGURE_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andBeforeFastConfigureLimitIsNotNull() {
            addCriterion("BEFORE_FAST_CONFIGURE_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeFastConfigureLimitEqualTo(BigDecimal value) {
            addCriterion("BEFORE_FAST_CONFIGURE_LIMIT =", value, "beforeFastConfigureLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastConfigureLimitNotEqualTo(BigDecimal value) {
            addCriterion("BEFORE_FAST_CONFIGURE_LIMIT <>", value, "beforeFastConfigureLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastConfigureLimitGreaterThan(BigDecimal value) {
            addCriterion("BEFORE_FAST_CONFIGURE_LIMIT >", value, "beforeFastConfigureLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastConfigureLimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BEFORE_FAST_CONFIGURE_LIMIT >=", value, "beforeFastConfigureLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastConfigureLimitLessThan(BigDecimal value) {
            addCriterion("BEFORE_FAST_CONFIGURE_LIMIT <", value, "beforeFastConfigureLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastConfigureLimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BEFORE_FAST_CONFIGURE_LIMIT <=", value, "beforeFastConfigureLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastConfigureLimitIn(List<BigDecimal> values) {
            addCriterion("BEFORE_FAST_CONFIGURE_LIMIT in", values, "beforeFastConfigureLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastConfigureLimitNotIn(List<BigDecimal> values) {
            addCriterion("BEFORE_FAST_CONFIGURE_LIMIT not in", values, "beforeFastConfigureLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastConfigureLimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BEFORE_FAST_CONFIGURE_LIMIT between", value1, value2, "beforeFastConfigureLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastConfigureLimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BEFORE_FAST_CONFIGURE_LIMIT not between", value1, value2, "beforeFastConfigureLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleRatioIsNull() {
            addCriterion("BEFORE_FAST_SETTLE_RATIO is null");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleRatioIsNotNull() {
            addCriterion("BEFORE_FAST_SETTLE_RATIO is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleRatioEqualTo(BigDecimal value) {
            addCriterion("BEFORE_FAST_SETTLE_RATIO =", value, "beforeFastSettleRatio");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleRatioNotEqualTo(BigDecimal value) {
            addCriterion("BEFORE_FAST_SETTLE_RATIO <>", value, "beforeFastSettleRatio");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleRatioGreaterThan(BigDecimal value) {
            addCriterion("BEFORE_FAST_SETTLE_RATIO >", value, "beforeFastSettleRatio");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BEFORE_FAST_SETTLE_RATIO >=", value, "beforeFastSettleRatio");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleRatioLessThan(BigDecimal value) {
            addCriterion("BEFORE_FAST_SETTLE_RATIO <", value, "beforeFastSettleRatio");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BEFORE_FAST_SETTLE_RATIO <=", value, "beforeFastSettleRatio");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleRatioIn(List<BigDecimal> values) {
            addCriterion("BEFORE_FAST_SETTLE_RATIO in", values, "beforeFastSettleRatio");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleRatioNotIn(List<BigDecimal> values) {
            addCriterion("BEFORE_FAST_SETTLE_RATIO not in", values, "beforeFastSettleRatio");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BEFORE_FAST_SETTLE_RATIO between", value1, value2, "beforeFastSettleRatio");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BEFORE_FAST_SETTLE_RATIO not between", value1, value2, "beforeFastSettleRatio");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleWorkdayFeeIsNull() {
            addCriterion("BEFOREFAST_SETTLE_WORKDAY_FEE is null");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleWorkdayFeeIsNotNull() {
            addCriterion("BEFOREFAST_SETTLE_WORKDAY_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleWorkdayFeeEqualTo(BigDecimal value) {
            addCriterion("BEFOREFAST_SETTLE_WORKDAY_FEE =", value, "beforeFastSettleWorkdayFee");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleWorkdayFeeNotEqualTo(BigDecimal value) {
            addCriterion("BEFOREFAST_SETTLE_WORKDAY_FEE <>", value, "beforeFastSettleWorkdayFee");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleWorkdayFeeGreaterThan(BigDecimal value) {
            addCriterion("BEFOREFAST_SETTLE_WORKDAY_FEE >", value, "beforeFastSettleWorkdayFee");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleWorkdayFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BEFOREFAST_SETTLE_WORKDAY_FEE >=", value, "beforeFastSettleWorkdayFee");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleWorkdayFeeLessThan(BigDecimal value) {
            addCriterion("BEFOREFAST_SETTLE_WORKDAY_FEE <", value, "beforeFastSettleWorkdayFee");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleWorkdayFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BEFOREFAST_SETTLE_WORKDAY_FEE <=", value, "beforeFastSettleWorkdayFee");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleWorkdayFeeIn(List<BigDecimal> values) {
            addCriterion("BEFOREFAST_SETTLE_WORKDAY_FEE in", values, "beforeFastSettleWorkdayFee");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleWorkdayFeeNotIn(List<BigDecimal> values) {
            addCriterion("BEFOREFAST_SETTLE_WORKDAY_FEE not in", values, "beforeFastSettleWorkdayFee");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleWorkdayFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BEFOREFAST_SETTLE_WORKDAY_FEE between", value1, value2, "beforeFastSettleWorkdayFee");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleWorkdayFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BEFOREFAST_SETTLE_WORKDAY_FEE not between", value1, value2, "beforeFastSettleWorkdayFee");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleHolidayFeeIsNull() {
            addCriterion("BEFOREFAST_SETTLE_HOLIDAY_FEE is null");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleHolidayFeeIsNotNull() {
            addCriterion("BEFOREFAST_SETTLE_HOLIDAY_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleHolidayFeeEqualTo(BigDecimal value) {
            addCriterion("BEFOREFAST_SETTLE_HOLIDAY_FEE =", value, "beforeFastSettleHolidayFee");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleHolidayFeeNotEqualTo(BigDecimal value) {
            addCriterion("BEFOREFAST_SETTLE_HOLIDAY_FEE <>", value, "beforeFastSettleHolidayFee");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleHolidayFeeGreaterThan(BigDecimal value) {
            addCriterion("BEFOREFAST_SETTLE_HOLIDAY_FEE >", value, "beforeFastSettleHolidayFee");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleHolidayFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BEFOREFAST_SETTLE_HOLIDAY_FEE >=", value, "beforeFastSettleHolidayFee");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleHolidayFeeLessThan(BigDecimal value) {
            addCriterion("BEFOREFAST_SETTLE_HOLIDAY_FEE <", value, "beforeFastSettleHolidayFee");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleHolidayFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BEFOREFAST_SETTLE_HOLIDAY_FEE <=", value, "beforeFastSettleHolidayFee");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleHolidayFeeIn(List<BigDecimal> values) {
            addCriterion("BEFOREFAST_SETTLE_HOLIDAY_FEE in", values, "beforeFastSettleHolidayFee");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleHolidayFeeNotIn(List<BigDecimal> values) {
            addCriterion("BEFOREFAST_SETTLE_HOLIDAY_FEE not in", values, "beforeFastSettleHolidayFee");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleHolidayFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BEFOREFAST_SETTLE_HOLIDAY_FEE between", value1, value2, "beforeFastSettleHolidayFee");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleHolidayFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BEFOREFAST_SETTLE_HOLIDAY_FEE not between", value1, value2, "beforeFastSettleHolidayFee");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeIsNull() {
            addCriterion("LOANING_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeIsNotNull() {
            addCriterion("LOANING_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeEqualTo(Integer value) {
            addCriterion("LOANING_TYPE =", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeNotEqualTo(Integer value) {
            addCriterion("LOANING_TYPE <>", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeGreaterThan(Integer value) {
            addCriterion("LOANING_TYPE >", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOANING_TYPE >=", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeLessThan(Integer value) {
            addCriterion("LOANING_TYPE <", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeLessThanOrEqualTo(Integer value) {
            addCriterion("LOANING_TYPE <=", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeIn(List<Integer> values) {
            addCriterion("LOANING_TYPE in", values, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeNotIn(List<Integer> values) {
            addCriterion("LOANING_TYPE not in", values, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeBetween(Integer value1, Integer value2) {
            addCriterion("LOANING_TYPE between", value1, value2, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("LOANING_TYPE not between", value1, value2, "loaningType");
            return (Criteria) this;
        }

        public Criteria andFastSettleMinLimitIsNull() {
            addCriterion("FAST_SETTLE_MIN_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andFastSettleMinLimitIsNotNull() {
            addCriterion("FAST_SETTLE_MIN_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andFastSettleMinLimitEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_MIN_LIMIT =", value, "fastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleMinLimitNotEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_MIN_LIMIT <>", value, "fastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleMinLimitGreaterThan(BigDecimal value) {
            addCriterion("FAST_SETTLE_MIN_LIMIT >", value, "fastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleMinLimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_MIN_LIMIT >=", value, "fastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleMinLimitLessThan(BigDecimal value) {
            addCriterion("FAST_SETTLE_MIN_LIMIT <", value, "fastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleMinLimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_MIN_LIMIT <=", value, "fastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleMinLimitIn(List<BigDecimal> values) {
            addCriterion("FAST_SETTLE_MIN_LIMIT in", values, "fastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleMinLimitNotIn(List<BigDecimal> values) {
            addCriterion("FAST_SETTLE_MIN_LIMIT not in", values, "fastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleMinLimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAST_SETTLE_MIN_LIMIT between", value1, value2, "fastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleMinLimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAST_SETTLE_MIN_LIMIT not between", value1, value2, "fastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleMinLimitIsNull() {
            addCriterion("BEFORE_FAST_SETTLE_MIN_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleMinLimitIsNotNull() {
            addCriterion("BEFORE_FAST_SETTLE_MIN_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleMinLimitEqualTo(BigDecimal value) {
            addCriterion("BEFORE_FAST_SETTLE_MIN_LIMIT =", value, "beforeFastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleMinLimitNotEqualTo(BigDecimal value) {
            addCriterion("BEFORE_FAST_SETTLE_MIN_LIMIT <>", value, "beforeFastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleMinLimitGreaterThan(BigDecimal value) {
            addCriterion("BEFORE_FAST_SETTLE_MIN_LIMIT >", value, "beforeFastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleMinLimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BEFORE_FAST_SETTLE_MIN_LIMIT >=", value, "beforeFastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleMinLimitLessThan(BigDecimal value) {
            addCriterion("BEFORE_FAST_SETTLE_MIN_LIMIT <", value, "beforeFastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleMinLimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BEFORE_FAST_SETTLE_MIN_LIMIT <=", value, "beforeFastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleMinLimitIn(List<BigDecimal> values) {
            addCriterion("BEFORE_FAST_SETTLE_MIN_LIMIT in", values, "beforeFastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleMinLimitNotIn(List<BigDecimal> values) {
            addCriterion("BEFORE_FAST_SETTLE_MIN_LIMIT not in", values, "beforeFastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleMinLimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BEFORE_FAST_SETTLE_MIN_LIMIT between", value1, value2, "beforeFastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andBeforeFastSettleMinLimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BEFORE_FAST_SETTLE_MIN_LIMIT not between", value1, value2, "beforeFastSettleMinLimit");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleIsNull() {
            addCriterion("AUTO_FAST_SETTLE is null");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleIsNotNull() {
            addCriterion("AUTO_FAST_SETTLE is not null");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleEqualTo(Integer value) {
            addCriterion("AUTO_FAST_SETTLE =", value, "autoFastSettle");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleNotEqualTo(Integer value) {
            addCriterion("AUTO_FAST_SETTLE <>", value, "autoFastSettle");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleGreaterThan(Integer value) {
            addCriterion("AUTO_FAST_SETTLE >", value, "autoFastSettle");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleGreaterThanOrEqualTo(Integer value) {
            addCriterion("AUTO_FAST_SETTLE >=", value, "autoFastSettle");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleLessThan(Integer value) {
            addCriterion("AUTO_FAST_SETTLE <", value, "autoFastSettle");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleLessThanOrEqualTo(Integer value) {
            addCriterion("AUTO_FAST_SETTLE <=", value, "autoFastSettle");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleIn(List<Integer> values) {
            addCriterion("AUTO_FAST_SETTLE in", values, "autoFastSettle");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleNotIn(List<Integer> values) {
            addCriterion("AUTO_FAST_SETTLE not in", values, "autoFastSettle");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleBetween(Integer value1, Integer value2) {
            addCriterion("AUTO_FAST_SETTLE between", value1, value2, "autoFastSettle");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleNotBetween(Integer value1, Integer value2) {
            addCriterion("AUTO_FAST_SETTLE not between", value1, value2, "autoFastSettle");
            return (Criteria) this;
        }

        public Criteria andBeforeAutoFastSettleIsNull() {
            addCriterion("BEFORE_AUTO_FAST_SETTLE is null");
            return (Criteria) this;
        }

        public Criteria andBeforeAutoFastSettleIsNotNull() {
            addCriterion("BEFORE_AUTO_FAST_SETTLE is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeAutoFastSettleEqualTo(Integer value) {
            addCriterion("BEFORE_AUTO_FAST_SETTLE =", value, "beforeAutoFastSettle");
            return (Criteria) this;
        }

        public Criteria andBeforeAutoFastSettleNotEqualTo(Integer value) {
            addCriterion("BEFORE_AUTO_FAST_SETTLE <>", value, "beforeAutoFastSettle");
            return (Criteria) this;
        }

        public Criteria andBeforeAutoFastSettleGreaterThan(Integer value) {
            addCriterion("BEFORE_AUTO_FAST_SETTLE >", value, "beforeAutoFastSettle");
            return (Criteria) this;
        }

        public Criteria andBeforeAutoFastSettleGreaterThanOrEqualTo(Integer value) {
            addCriterion("BEFORE_AUTO_FAST_SETTLE >=", value, "beforeAutoFastSettle");
            return (Criteria) this;
        }

        public Criteria andBeforeAutoFastSettleLessThan(Integer value) {
            addCriterion("BEFORE_AUTO_FAST_SETTLE <", value, "beforeAutoFastSettle");
            return (Criteria) this;
        }

        public Criteria andBeforeAutoFastSettleLessThanOrEqualTo(Integer value) {
            addCriterion("BEFORE_AUTO_FAST_SETTLE <=", value, "beforeAutoFastSettle");
            return (Criteria) this;
        }

        public Criteria andBeforeAutoFastSettleIn(List<Integer> values) {
            addCriterion("BEFORE_AUTO_FAST_SETTLE in", values, "beforeAutoFastSettle");
            return (Criteria) this;
        }

        public Criteria andBeforeAutoFastSettleNotIn(List<Integer> values) {
            addCriterion("BEFORE_AUTO_FAST_SETTLE not in", values, "beforeAutoFastSettle");
            return (Criteria) this;
        }

        public Criteria andBeforeAutoFastSettleBetween(Integer value1, Integer value2) {
            addCriterion("BEFORE_AUTO_FAST_SETTLE between", value1, value2, "beforeAutoFastSettle");
            return (Criteria) this;
        }

        public Criteria andBeforeAutoFastSettleNotBetween(Integer value1, Integer value2) {
            addCriterion("BEFORE_AUTO_FAST_SETTLE not between", value1, value2, "beforeAutoFastSettle");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("OPERATOR is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("OPERATOR is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("OPERATOR =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("OPERATOR <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("OPERATOR >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATOR >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("OPERATOR <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("OPERATOR <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("OPERATOR like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("OPERATOR not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("OPERATOR in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("OPERATOR not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("OPERATOR between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("OPERATOR not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andPromoterMinMarginIsNull() {
            addCriterion("PROMOTER_MIN_MARGIN is null");
            return (Criteria) this;
        }

        public Criteria andPromoterMinMarginIsNotNull() {
            addCriterion("PROMOTER_MIN_MARGIN is not null");
            return (Criteria) this;
        }

        public Criteria andPromoterMinMarginEqualTo(BigDecimal value) {
            addCriterion("PROMOTER_MIN_MARGIN =", value, "promoterMinMargin");
            return (Criteria) this;
        }

        public Criteria andPromoterMinMarginNotEqualTo(BigDecimal value) {
            addCriterion("PROMOTER_MIN_MARGIN <>", value, "promoterMinMargin");
            return (Criteria) this;
        }

        public Criteria andPromoterMinMarginGreaterThan(BigDecimal value) {
            addCriterion("PROMOTER_MIN_MARGIN >", value, "promoterMinMargin");
            return (Criteria) this;
        }

        public Criteria andPromoterMinMarginGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROMOTER_MIN_MARGIN >=", value, "promoterMinMargin");
            return (Criteria) this;
        }

        public Criteria andPromoterMinMarginLessThan(BigDecimal value) {
            addCriterion("PROMOTER_MIN_MARGIN <", value, "promoterMinMargin");
            return (Criteria) this;
        }

        public Criteria andPromoterMinMarginLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROMOTER_MIN_MARGIN <=", value, "promoterMinMargin");
            return (Criteria) this;
        }

        public Criteria andPromoterMinMarginIn(List<BigDecimal> values) {
            addCriterion("PROMOTER_MIN_MARGIN in", values, "promoterMinMargin");
            return (Criteria) this;
        }

        public Criteria andPromoterMinMarginNotIn(List<BigDecimal> values) {
            addCriterion("PROMOTER_MIN_MARGIN not in", values, "promoterMinMargin");
            return (Criteria) this;
        }

        public Criteria andPromoterMinMarginBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROMOTER_MIN_MARGIN between", value1, value2, "promoterMinMargin");
            return (Criteria) this;
        }

        public Criteria andPromoterMinMarginNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROMOTER_MIN_MARGIN not between", value1, value2, "promoterMinMargin");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_FS_CONFIG_CHANGE
     *
     * @mbggenerated do_not_delete_during_merge Wed Nov 09 15:53:43 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_FS_CONFIG_CHANGE
     * table comment :配置更改记录
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}