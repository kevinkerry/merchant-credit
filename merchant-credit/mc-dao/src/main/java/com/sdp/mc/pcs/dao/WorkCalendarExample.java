package com.sdp.mc.pcs.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkCalendarExample extends QueryBase {
    /**
     * This field corresponds to the database column WORK_CALENDAR.ID
     * column comments 主键
     *
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
     */
    private Long id;

    /**
     * This field corresponds to the database column WORK_CALENDAR.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
     */
    private Date createTime;

    /**
     * This field corresponds to the database column WORK_CALENDAR.UPDATE_TIME
     * column comments 更新时间
     *
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column WORK_CALENDAR.VERSION
     * column comments 版本号
     *
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
     */
    private Long version;

    /**
     * This field corresponds to the database column WORK_CALENDAR.DATE_STR
     * column comments 日期字符串(YYYYMMDD)
     *
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
     */
    private String dateStr;

    /**
     * This field corresponds to the database column WORK_CALENDAR.IS_WORK_DAY
     * column comments 是否为工作日(1:工作日,0:非工作日)
     *
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
     */
    private String isWorkDay;

    /**
     * This field corresponds to the database table WORK_CALENDAR
     * table comments 工作日历
     *
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table WORK_CALENDAR
     * table comments 工作日历
     *
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table WORK_CALENDAR
     * table comments 工作日历
     *
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table WORK_CALENDAR
     *
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
     */
    public WorkCalendarExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column WORK_CALENDAR.ID
     *
     * @return the value of WORK_CALENDAR.ID
     * column comments 主键
     *
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
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
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
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
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
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
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
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
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
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
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
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
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
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
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
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
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
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
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
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
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
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
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
     */
    public void setIsWorkDay(String isWorkDay) {
        this.isWorkDay = isWorkDay == null ? null : isWorkDay.trim();
    }

    /**
     * This method corresponds to the database table WORK_CALENDAR
     *
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table WORK_CALENDAR
     *
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table WORK_CALENDAR
     *
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table WORK_CALENDAR
     *
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table WORK_CALENDAR
     *
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table WORK_CALENDAR
     *
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table WORK_CALENDAR
     *
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table WORK_CALENDAR
     *
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table WORK_CALENDAR
     *
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table WORK_CALENDAR
     *
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table WORK_CALENDAR
     * table comment :工作日历
     *
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
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

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Long value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Long value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Long value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Long value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Long value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Long> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Long> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Long value1, Long value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Long value1, Long value2) {
            addCriterion("VERSION not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andDateStrIsNull() {
            addCriterion("DATE_STR is null");
            return (Criteria) this;
        }

        public Criteria andDateStrIsNotNull() {
            addCriterion("DATE_STR is not null");
            return (Criteria) this;
        }

        public Criteria andDateStrEqualTo(String value) {
            addCriterion("DATE_STR =", value, "dateStr");
            return (Criteria) this;
        }

        public Criteria andDateStrNotEqualTo(String value) {
            addCriterion("DATE_STR <>", value, "dateStr");
            return (Criteria) this;
        }

        public Criteria andDateStrGreaterThan(String value) {
            addCriterion("DATE_STR >", value, "dateStr");
            return (Criteria) this;
        }

        public Criteria andDateStrGreaterThanOrEqualTo(String value) {
            addCriterion("DATE_STR >=", value, "dateStr");
            return (Criteria) this;
        }

        public Criteria andDateStrLessThan(String value) {
            addCriterion("DATE_STR <", value, "dateStr");
            return (Criteria) this;
        }

        public Criteria andDateStrLessThanOrEqualTo(String value) {
            addCriterion("DATE_STR <=", value, "dateStr");
            return (Criteria) this;
        }

        public Criteria andDateStrLike(String value) {
            addCriterion("DATE_STR like", value, "dateStr");
            return (Criteria) this;
        }

        public Criteria andDateStrNotLike(String value) {
            addCriterion("DATE_STR not like", value, "dateStr");
            return (Criteria) this;
        }

        public Criteria andDateStrIn(List<String> values) {
            addCriterion("DATE_STR in", values, "dateStr");
            return (Criteria) this;
        }

        public Criteria andDateStrNotIn(List<String> values) {
            addCriterion("DATE_STR not in", values, "dateStr");
            return (Criteria) this;
        }

        public Criteria andDateStrBetween(String value1, String value2) {
            addCriterion("DATE_STR between", value1, value2, "dateStr");
            return (Criteria) this;
        }

        public Criteria andDateStrNotBetween(String value1, String value2) {
            addCriterion("DATE_STR not between", value1, value2, "dateStr");
            return (Criteria) this;
        }

        public Criteria andIsWorkDayIsNull() {
            addCriterion("IS_WORK_DAY is null");
            return (Criteria) this;
        }

        public Criteria andIsWorkDayIsNotNull() {
            addCriterion("IS_WORK_DAY is not null");
            return (Criteria) this;
        }

        public Criteria andIsWorkDayEqualTo(String value) {
            addCriterion("IS_WORK_DAY =", value, "isWorkDay");
            return (Criteria) this;
        }

        public Criteria andIsWorkDayNotEqualTo(String value) {
            addCriterion("IS_WORK_DAY <>", value, "isWorkDay");
            return (Criteria) this;
        }

        public Criteria andIsWorkDayGreaterThan(String value) {
            addCriterion("IS_WORK_DAY >", value, "isWorkDay");
            return (Criteria) this;
        }

        public Criteria andIsWorkDayGreaterThanOrEqualTo(String value) {
            addCriterion("IS_WORK_DAY >=", value, "isWorkDay");
            return (Criteria) this;
        }

        public Criteria andIsWorkDayLessThan(String value) {
            addCriterion("IS_WORK_DAY <", value, "isWorkDay");
            return (Criteria) this;
        }

        public Criteria andIsWorkDayLessThanOrEqualTo(String value) {
            addCriterion("IS_WORK_DAY <=", value, "isWorkDay");
            return (Criteria) this;
        }

        public Criteria andIsWorkDayIn(List<String> values) {
            addCriterion("IS_WORK_DAY in", values, "isWorkDay");
            return (Criteria) this;
        }

        public Criteria andIsWorkDayNotIn(List<String> values) {
            addCriterion("IS_WORK_DAY not in", values, "isWorkDay");
            return (Criteria) this;
        }

        public Criteria andIsWorkDayBetween(String value1, String value2) {
            addCriterion("IS_WORK_DAY between", value1, value2, "isWorkDay");
            return (Criteria) this;
        }

        public Criteria andIsWorkDayNotBetween(String value1, String value2) {
            addCriterion("IS_WORK_DAY not between", value1, value2, "isWorkDay");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table WORK_CALENDAR
     *
     * @mbggenerated do_not_delete_during_merge Tue Jun 02 17:18:24 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table WORK_CALENDAR
     * table comment :工作日历
     *
     * @mbggenerated Tue Jun 02 17:18:24 CST 2015
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