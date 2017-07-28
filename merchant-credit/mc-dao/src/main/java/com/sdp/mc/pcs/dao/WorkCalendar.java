package com.sdp.mc.pcs.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.util.Date;

public class WorkCalendar extends BaseDO {
    /**
     * This field corresponds to the database column WORK_CALENDAR.ID
     * column comments 主键
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    private Long id;

    /**
     * This field corresponds to the database column WORK_CALENDAR.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    private Date createTime;

    /**
     * This field corresponds to the database column WORK_CALENDAR.UPDATE_TIME
     * column comments 更新时间
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column WORK_CALENDAR.VERSION
     * column comments 版本号
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    private Long version;

    /**
     * This field corresponds to the database column WORK_CALENDAR.DATE_STR
     * column comments 日期字符串(YYYYMMDD)
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    private String dateStr;

    /**
     * This field corresponds to the database column WORK_CALENDAR.IS_WORK_DAY
     * column comments 是否为工作日(1:工作日,0:非工作日)
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    private String isWorkDay;

    /**
     * This method returns the value of the database column WORK_CALENDAR.ID
     *
     * @return the value of WORK_CALENDAR.ID
     * column comments 主键
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column WORK_CALENDAR.ID
     *
     * @param id the value for WORK_CALENDAR.ID
     * column comments 主键
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column WORK_CALENDAR.CREATE_TIME
     *
     * @return the value of WORK_CALENDAR.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column WORK_CALENDAR.CREATE_TIME
     *
     * @param createTime the value for WORK_CALENDAR.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column WORK_CALENDAR.UPDATE_TIME
     *
     * @return the value of WORK_CALENDAR.UPDATE_TIME
     * column comments 更新时间
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column WORK_CALENDAR.UPDATE_TIME
     *
     * @param updateTime the value for WORK_CALENDAR.UPDATE_TIME
     * column comments 更新时间
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column WORK_CALENDAR.VERSION
     *
     * @return the value of WORK_CALENDAR.VERSION
     * column comments 版本号
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    public Long getVersion() {
        return version;
    }

    /**
     * This method sets the value of the database column WORK_CALENDAR.VERSION
     *
     * @param version the value for WORK_CALENDAR.VERSION
     * column comments 版本号
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * This method returns the value of the database column WORK_CALENDAR.DATE_STR
     *
     * @return the value of WORK_CALENDAR.DATE_STR
     * column comments 日期字符串(YYYYMMDD)
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    public String getDateStr() {
        return dateStr;
    }

    /**
     * This method sets the value of the database column WORK_CALENDAR.DATE_STR
     *
     * @param dateStr the value for WORK_CALENDAR.DATE_STR
     * column comments 日期字符串(YYYYMMDD)
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    public void setDateStr(String dateStr) {
        this.dateStr = dateStr == null ? null : dateStr.trim();
    }

    /**
     * This method returns the value of the database column WORK_CALENDAR.IS_WORK_DAY
     *
     * @return the value of WORK_CALENDAR.IS_WORK_DAY
     * column comments 是否为工作日(1:工作日,0:非工作日)
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    public String getIsWorkDay() {
        return isWorkDay;
    }

    /**
     * This method sets the value of the database column WORK_CALENDAR.IS_WORK_DAY
     *
     * @param isWorkDay the value for WORK_CALENDAR.IS_WORK_DAY
     * column comments 是否为工作日(1:工作日,0:非工作日)
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    public void setIsWorkDay(String isWorkDay) {
        this.isWorkDay = isWorkDay == null ? null : isWorkDay.trim();
    }
}