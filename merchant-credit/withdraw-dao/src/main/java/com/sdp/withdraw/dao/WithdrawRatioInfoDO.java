package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.math.BigDecimal;
import java.util.Date;

public class WithdrawRatioInfoDO extends BaseDO {
    /**
     * This field corresponds to the database column FW_WITHDRAW_RATIO_INFO.ID
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    private Long id;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RATIO_INFO.BIZ_ID
     * column comments 业务ID
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    private Long bizId;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RATIO_INFO.RATIO_TYPE
     * column comments 费率类型
POS/T+0结算费率：10；
MPOS/T+0结算费率：20；
MPOS/T+1结算费率：21；
MPOS/D+1结算费率：22；

     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    private Integer ratioType;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RATIO_INFO.STATUS
     * column comments 状态
生效：1；
失效：0；
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    private Integer status;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RATIO_INFO.WORK_DAY_RATIO
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    private BigDecimal workDayRatio;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RATIO_INFO.HOLIDAY_RATIO
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    private BigDecimal holidayRatio;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RATIO_INFO.EFFECTIVE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    private Date effectiveTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RATIO_INFO.EXPIRE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    private Date expireTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RATIO_INFO.CRETE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    private Date creteTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_RATIO_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    private Date updateTime;

    /**
     * This method returns the value of the database column FW_WITHDRAW_RATIO_INFO.ID
     *
     * @return the value of FW_WITHDRAW_RATIO_INFO.ID
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RATIO_INFO.ID
     *
     * @param id the value for FW_WITHDRAW_RATIO_INFO.ID
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RATIO_INFO.BIZ_ID
     *
     * @return the value of FW_WITHDRAW_RATIO_INFO.BIZ_ID
     * column comments 业务ID
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public Long getBizId() {
        return bizId;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RATIO_INFO.BIZ_ID
     *
     * @param bizId the value for FW_WITHDRAW_RATIO_INFO.BIZ_ID
     * column comments 业务ID
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RATIO_INFO.RATIO_TYPE
     *
     * @return the value of FW_WITHDRAW_RATIO_INFO.RATIO_TYPE
     * column comments 费率类型
POS/T+0结算费率：10；
MPOS/T+0结算费率：20；
MPOS/T+1结算费率：21；
MPOS/D+1结算费率：22；

     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public Integer getRatioType() {
        return ratioType;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RATIO_INFO.RATIO_TYPE
     *
     * @param ratioType the value for FW_WITHDRAW_RATIO_INFO.RATIO_TYPE
     * column comments 费率类型
POS/T+0结算费率：10；
MPOS/T+0结算费率：20；
MPOS/T+1结算费率：21；
MPOS/D+1结算费率：22；

     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public void setRatioType(Integer ratioType) {
        this.ratioType = ratioType;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RATIO_INFO.STATUS
     *
     * @return the value of FW_WITHDRAW_RATIO_INFO.STATUS
     * column comments 状态
生效：1；
失效：0；
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RATIO_INFO.STATUS
     *
     * @param status the value for FW_WITHDRAW_RATIO_INFO.STATUS
     * column comments 状态
生效：1；
失效：0；
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RATIO_INFO.WORK_DAY_RATIO
     *
     * @return the value of FW_WITHDRAW_RATIO_INFO.WORK_DAY_RATIO
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public BigDecimal getWorkDayRatio() {
        return workDayRatio;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RATIO_INFO.WORK_DAY_RATIO
     *
     * @param workDayRatio the value for FW_WITHDRAW_RATIO_INFO.WORK_DAY_RATIO
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public void setWorkDayRatio(BigDecimal workDayRatio) {
        this.workDayRatio = workDayRatio;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RATIO_INFO.HOLIDAY_RATIO
     *
     * @return the value of FW_WITHDRAW_RATIO_INFO.HOLIDAY_RATIO
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public BigDecimal getHolidayRatio() {
        return holidayRatio;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RATIO_INFO.HOLIDAY_RATIO
     *
     * @param holidayRatio the value for FW_WITHDRAW_RATIO_INFO.HOLIDAY_RATIO
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public void setHolidayRatio(BigDecimal holidayRatio) {
        this.holidayRatio = holidayRatio;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RATIO_INFO.EFFECTIVE_TIME
     *
     * @return the value of FW_WITHDRAW_RATIO_INFO.EFFECTIVE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public Date getEffectiveTime() {
        return effectiveTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RATIO_INFO.EFFECTIVE_TIME
     *
     * @param effectiveTime the value for FW_WITHDRAW_RATIO_INFO.EFFECTIVE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RATIO_INFO.EXPIRE_TIME
     *
     * @return the value of FW_WITHDRAW_RATIO_INFO.EXPIRE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RATIO_INFO.EXPIRE_TIME
     *
     * @param expireTime the value for FW_WITHDRAW_RATIO_INFO.EXPIRE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RATIO_INFO.CRETE_TIME
     *
     * @return the value of FW_WITHDRAW_RATIO_INFO.CRETE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public Date getCreteTime() {
        return creteTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RATIO_INFO.CRETE_TIME
     *
     * @param creteTime the value for FW_WITHDRAW_RATIO_INFO.CRETE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public void setCreteTime(Date creteTime) {
        this.creteTime = creteTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_RATIO_INFO.UPDATE_TIME
     *
     * @return the value of FW_WITHDRAW_RATIO_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_RATIO_INFO.UPDATE_TIME
     *
     * @param updateTime the value for FW_WITHDRAW_RATIO_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}