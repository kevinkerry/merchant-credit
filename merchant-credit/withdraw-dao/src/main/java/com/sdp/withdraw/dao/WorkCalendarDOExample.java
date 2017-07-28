package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WorkCalendarDOExample extends QueryBase {
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
     * This field corresponds to the database table FW_WORK_CALENDAR
     * table comments 工作日历
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table FW_WORK_CALENDAR
     * table comments 工作日历
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table FW_WORK_CALENDAR
     * table comments 工作日历
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table FW_WORK_CALENDAR
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public WorkCalendarDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

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

    /**
     * This method corresponds to the database table FW_WORK_CALENDAR
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table FW_WORK_CALENDAR
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table FW_WORK_CALENDAR
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table FW_WORK_CALENDAR
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table FW_WORK_CALENDAR
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table FW_WORK_CALENDAR
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table FW_WORK_CALENDAR
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WORK_CALENDAR
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WORK_CALENDAR
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WORK_CALENDAR
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WORK_CALENDAR
     * table comment :工作日历
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWordDateIsNull() {
            addCriterion("WORK_DATE is null");
            return (Criteria) this;
        }

        public Criteria andWordDateIsNotNull() {
            addCriterion("WORK_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andWordDateEqualTo(Date value) {
            addCriterionForJDBCDate("WORK_DATE =", value, "wordDate");
            return (Criteria) this;
        }

        public Criteria andWordDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("WORK_DATE <>", value, "wordDate");
            return (Criteria) this;
        }

        public Criteria andWordDateGreaterThan(Date value) {
            addCriterionForJDBCDate("WORK_DATE >", value, "wordDate");
            return (Criteria) this;
        }

        public Criteria andWordDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("WORK_DATE >=", value, "wordDate");
            return (Criteria) this;
        }

        public Criteria andWordDateLessThan(Date value) {
            addCriterionForJDBCDate("WORK_DATE <", value, "wordDate");
            return (Criteria) this;
        }

        public Criteria andWordDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("WORK_DATE <=", value, "wordDate");
            return (Criteria) this;
        }

        public Criteria andWordDateIn(List<Date> values) {
            addCriterionForJDBCDate("WORK_DATE in", values, "wordDate");
            return (Criteria) this;
        }

        public Criteria andWordDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("WORK_DATE not in", values, "wordDate");
            return (Criteria) this;
        }

        public Criteria andWordDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("WORK_DATE between", value1, value2, "wordDate");
            return (Criteria) this;
        }

        public Criteria andWordDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("WORK_DATE not between", value1, value2, "wordDate");
            return (Criteria) this;
        }

        public Criteria andWeekDayIsNull() {
            addCriterion("WEEK_DAY is null");
            return (Criteria) this;
        }

        public Criteria andWeekDayIsNotNull() {
            addCriterion("WEEK_DAY is not null");
            return (Criteria) this;
        }

        public Criteria andWeekDayEqualTo(Integer value) {
            addCriterion("WEEK_DAY =", value, "weekDay");
            return (Criteria) this;
        }

        public Criteria andWeekDayNotEqualTo(Integer value) {
            addCriterion("WEEK_DAY <>", value, "weekDay");
            return (Criteria) this;
        }

        public Criteria andWeekDayGreaterThan(Integer value) {
            addCriterion("WEEK_DAY >", value, "weekDay");
            return (Criteria) this;
        }

        public Criteria andWeekDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("WEEK_DAY >=", value, "weekDay");
            return (Criteria) this;
        }

        public Criteria andWeekDayLessThan(Integer value) {
            addCriterion("WEEK_DAY <", value, "weekDay");
            return (Criteria) this;
        }

        public Criteria andWeekDayLessThanOrEqualTo(Integer value) {
            addCriterion("WEEK_DAY <=", value, "weekDay");
            return (Criteria) this;
        }

        public Criteria andWeekDayIn(List<Integer> values) {
            addCriterion("WEEK_DAY in", values, "weekDay");
            return (Criteria) this;
        }

        public Criteria andWeekDayNotIn(List<Integer> values) {
            addCriterion("WEEK_DAY not in", values, "weekDay");
            return (Criteria) this;
        }

        public Criteria andWeekDayBetween(Integer value1, Integer value2) {
            addCriterion("WEEK_DAY between", value1, value2, "weekDay");
            return (Criteria) this;
        }

        public Criteria andWeekDayNotBetween(Integer value1, Integer value2) {
            addCriterion("WEEK_DAY not between", value1, value2, "weekDay");
            return (Criteria) this;
        }

        public Criteria andIsHolidayIsNull() {
            addCriterion("IS_HOLIDAY is null");
            return (Criteria) this;
        }

        public Criteria andIsHolidayIsNotNull() {
            addCriterion("IS_HOLIDAY is not null");
            return (Criteria) this;
        }

        public Criteria andIsHolidayEqualTo(Integer value) {
            addCriterion("IS_HOLIDAY =", value, "isHoliday");
            return (Criteria) this;
        }

        public Criteria andIsHolidayNotEqualTo(Integer value) {
            addCriterion("IS_HOLIDAY <>", value, "isHoliday");
            return (Criteria) this;
        }

        public Criteria andIsHolidayGreaterThan(Integer value) {
            addCriterion("IS_HOLIDAY >", value, "isHoliday");
            return (Criteria) this;
        }

        public Criteria andIsHolidayGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_HOLIDAY >=", value, "isHoliday");
            return (Criteria) this;
        }

        public Criteria andIsHolidayLessThan(Integer value) {
            addCriterion("IS_HOLIDAY <", value, "isHoliday");
            return (Criteria) this;
        }

        public Criteria andIsHolidayLessThanOrEqualTo(Integer value) {
            addCriterion("IS_HOLIDAY <=", value, "isHoliday");
            return (Criteria) this;
        }

        public Criteria andIsHolidayIn(List<Integer> values) {
            addCriterion("IS_HOLIDAY in", values, "isHoliday");
            return (Criteria) this;
        }

        public Criteria andIsHolidayNotIn(List<Integer> values) {
            addCriterion("IS_HOLIDAY not in", values, "isHoliday");
            return (Criteria) this;
        }

        public Criteria andIsHolidayBetween(Integer value1, Integer value2) {
            addCriterion("IS_HOLIDAY between", value1, value2, "isHoliday");
            return (Criteria) this;
        }

        public Criteria andIsHolidayNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_HOLIDAY not between", value1, value2, "isHoliday");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WORK_CALENDAR
     *
     * @mbggenerated do_not_delete_during_merge Fri Mar 11 19:55:52 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WORK_CALENDAR
     * table comment :工作日历
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
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