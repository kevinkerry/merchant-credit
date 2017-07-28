package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.util.Date;

public class WorkCalendarDO extends BaseDO {
    /**
     * This field corresponds to the database column FW_WORK_CALENDAR.ID
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    private Long id;

    /**
     * This field corresponds to the database column FW_WORK_CALENDAR.WORK_DATE
     * column comments 工作日期
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    private Date wordDate;

    /**
     * This field corresponds to the database column FW_WORK_CALENDAR.WEEK_DAY
     * column comments 星期日期

周日：1；周一：2；周二：3；周三：4；周四：5；周五：6；周六：7；
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    private Integer weekDay;

    /**
     * This field corresponds to the database column FW_WORK_CALENDAR.IS_HOLIDAY
     * column comments 是否节假日
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    private Integer isHoliday;

    /**
     * This field corresponds to the database column FW_WORK_CALENDAR.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column FW_WORK_CALENDAR.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    private Date updateTime;

    /**
     * This method returns the value of the database column FW_WORK_CALENDAR.ID
     *
     * @return the value of FW_WORK_CALENDAR.ID
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column FW_WORK_CALENDAR.ID
     *
     * @param id the value for FW_WORK_CALENDAR.ID
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column FW_WORK_CALENDAR.WORK_DATE
     *
     * @return the value of FW_WORK_CALENDAR.WORK_DATE
     * column comments 工作日期
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public Date getWordDate() {
        return wordDate;
    }

    /**
     * This method sets the value of the database column FW_WORK_CALENDAR.WORK_DATE
     *
     * @param wordDate the value for FW_WORK_CALENDAR.WORK_DATE
     * column comments 工作日期
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public void setWordDate(Date wordDate) {
        this.wordDate = wordDate;
    }

    /**
     * This method returns the value of the database column FW_WORK_CALENDAR.WEEK_DAY
     *
     * @return the value of FW_WORK_CALENDAR.WEEK_DAY
     * column comments 星期日期

周日：1；周一：2；周二：3；周三：4；周四：5；周五：6；周六：7；
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public Integer getWeekDay() {
        return weekDay;
    }

    /**
     * This method sets the value of the database column FW_WORK_CALENDAR.WEEK_DAY
     *
     * @param weekDay the value for FW_WORK_CALENDAR.WEEK_DAY
     * column comments 星期日期

周日：1；周一：2；周二：3；周三：4；周四：5；周五：6；周六：7；
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public void setWeekDay(Integer weekDay) {
        this.weekDay = weekDay;
    }

    /**
     * This method returns the value of the database column FW_WORK_CALENDAR.IS_HOLIDAY
     *
     * @return the value of FW_WORK_CALENDAR.IS_HOLIDAY
     * column comments 是否节假日
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public Integer getIsHoliday() {
        return isHoliday;
    }

    /**
     * This method sets the value of the database column FW_WORK_CALENDAR.IS_HOLIDAY
     *
     * @param isHoliday the value for FW_WORK_CALENDAR.IS_HOLIDAY
     * column comments 是否节假日
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public void setIsHoliday(Integer isHoliday) {
        this.isHoliday = isHoliday;
    }

    /**
     * This method returns the value of the database column FW_WORK_CALENDAR.CREATE_TIME
     *
     * @return the value of FW_WORK_CALENDAR.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column FW_WORK_CALENDAR.CREATE_TIME
     *
     * @param createTime the value for FW_WORK_CALENDAR.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column FW_WORK_CALENDAR.UPDATE_TIME
     *
     * @return the value of FW_WORK_CALENDAR.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column FW_WORK_CALENDAR.UPDATE_TIME
     *
     * @param updateTime the value for FW_WORK_CALENDAR.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}