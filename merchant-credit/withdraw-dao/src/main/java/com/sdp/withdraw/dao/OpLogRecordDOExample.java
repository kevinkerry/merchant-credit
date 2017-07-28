package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpLogRecordDOExample extends QueryBase {
    /**
     * This field corresponds to the database column OP_LOG_RECORD.ID
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    private Long id;

    /**
     * This field corresponds to the database column OP_LOG_RECORD.RECORD_TYPE
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    private String recordType;

    /**
     * This field corresponds to the database column OP_LOG_RECORD.OP_TYPE
     * column comments C：CREATE；U：UPDATE；D：DELETE；
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    private String opType;

    /**
     * This field corresponds to the database column OP_LOG_RECORD.OP_RECORD
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    private String opRecord;

    /**
     * This field corresponds to the database column OP_LOG_RECORD.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column OP_LOG_RECORD.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    private Date updateTime;

    /**
     * This field corresponds to the database table OP_LOG_RECORD
     * table comments 操作历史记录
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table OP_LOG_RECORD
     * table comments 操作历史记录
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table OP_LOG_RECORD
     * table comments 操作历史记录
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table OP_LOG_RECORD
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public OpLogRecordDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column OP_LOG_RECORD.ID
     *
     * @return the value of OP_LOG_RECORD.ID
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column OP_LOG_RECORD.ID
     *
     * @param id the value for OP_LOG_RECORD.ID
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column OP_LOG_RECORD.RECORD_TYPE
     *
     * @return the value of OP_LOG_RECORD.RECORD_TYPE
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public String getRecordType() {
        return recordType;
    }

    /**
     * This method sets the value of the database column OP_LOG_RECORD.RECORD_TYPE
     *
     * @param recordType the value for OP_LOG_RECORD.RECORD_TYPE
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public void setRecordType(String recordType) {
        this.recordType = recordType == null ? null : recordType.trim();
    }

    /**
     * This method returns the value of the database column OP_LOG_RECORD.OP_TYPE
     *
     * @return the value of OP_LOG_RECORD.OP_TYPE
     * column comments C：CREATE；U：UPDATE；D：DELETE；
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public String getOpType() {
        return opType;
    }

    /**
     * This method sets the value of the database column OP_LOG_RECORD.OP_TYPE
     *
     * @param opType the value for OP_LOG_RECORD.OP_TYPE
     * column comments C：CREATE；U：UPDATE；D：DELETE；
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public void setOpType(String opType) {
        this.opType = opType == null ? null : opType.trim();
    }

    /**
     * This method returns the value of the database column OP_LOG_RECORD.OP_RECORD
     *
     * @return the value of OP_LOG_RECORD.OP_RECORD
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public String getOpRecord() {
        return opRecord;
    }

    /**
     * This method sets the value of the database column OP_LOG_RECORD.OP_RECORD
     *
     * @param opRecord the value for OP_LOG_RECORD.OP_RECORD
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public void setOpRecord(String opRecord) {
        this.opRecord = opRecord == null ? null : opRecord.trim();
    }

    /**
     * This method returns the value of the database column OP_LOG_RECORD.CREATE_TIME
     *
     * @return the value of OP_LOG_RECORD.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column OP_LOG_RECORD.CREATE_TIME
     *
     * @param createTime the value for OP_LOG_RECORD.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column OP_LOG_RECORD.UPDATE_TIME
     *
     * @return the value of OP_LOG_RECORD.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column OP_LOG_RECORD.UPDATE_TIME
     *
     * @param updateTime the value for OP_LOG_RECORD.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method corresponds to the database table OP_LOG_RECORD
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table OP_LOG_RECORD
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table OP_LOG_RECORD
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table OP_LOG_RECORD
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table OP_LOG_RECORD
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table OP_LOG_RECORD
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table OP_LOG_RECORD
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table OP_LOG_RECORD
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table OP_LOG_RECORD
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table OP_LOG_RECORD
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table OP_LOG_RECORD
     * table comment :操作历史记录
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
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

        public Criteria andRecordTypeIsNull() {
            addCriterion("RECORD_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRecordTypeIsNotNull() {
            addCriterion("RECORD_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTypeEqualTo(String value) {
            addCriterion("RECORD_TYPE =", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeNotEqualTo(String value) {
            addCriterion("RECORD_TYPE <>", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeGreaterThan(String value) {
            addCriterion("RECORD_TYPE >", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RECORD_TYPE >=", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeLessThan(String value) {
            addCriterion("RECORD_TYPE <", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeLessThanOrEqualTo(String value) {
            addCriterion("RECORD_TYPE <=", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeLike(String value) {
            addCriterion("RECORD_TYPE like", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeNotLike(String value) {
            addCriterion("RECORD_TYPE not like", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeIn(List<String> values) {
            addCriterion("RECORD_TYPE in", values, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeNotIn(List<String> values) {
            addCriterion("RECORD_TYPE not in", values, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeBetween(String value1, String value2) {
            addCriterion("RECORD_TYPE between", value1, value2, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeNotBetween(String value1, String value2) {
            addCriterion("RECORD_TYPE not between", value1, value2, "recordType");
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

        public Criteria andOpTypeEqualTo(String value) {
            addCriterion("OP_TYPE =", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotEqualTo(String value) {
            addCriterion("OP_TYPE <>", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeGreaterThan(String value) {
            addCriterion("OP_TYPE >", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeGreaterThanOrEqualTo(String value) {
            addCriterion("OP_TYPE >=", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeLessThan(String value) {
            addCriterion("OP_TYPE <", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeLessThanOrEqualTo(String value) {
            addCriterion("OP_TYPE <=", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeLike(String value) {
            addCriterion("OP_TYPE like", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotLike(String value) {
            addCriterion("OP_TYPE not like", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeIn(List<String> values) {
            addCriterion("OP_TYPE in", values, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotIn(List<String> values) {
            addCriterion("OP_TYPE not in", values, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeBetween(String value1, String value2) {
            addCriterion("OP_TYPE between", value1, value2, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotBetween(String value1, String value2) {
            addCriterion("OP_TYPE not between", value1, value2, "opType");
            return (Criteria) this;
        }

        public Criteria andOpRecordIsNull() {
            addCriterion("OP_RECORD is null");
            return (Criteria) this;
        }

        public Criteria andOpRecordIsNotNull() {
            addCriterion("OP_RECORD is not null");
            return (Criteria) this;
        }

        public Criteria andOpRecordEqualTo(String value) {
            addCriterion("OP_RECORD =", value, "opRecord");
            return (Criteria) this;
        }

        public Criteria andOpRecordNotEqualTo(String value) {
            addCriterion("OP_RECORD <>", value, "opRecord");
            return (Criteria) this;
        }

        public Criteria andOpRecordGreaterThan(String value) {
            addCriterion("OP_RECORD >", value, "opRecord");
            return (Criteria) this;
        }

        public Criteria andOpRecordGreaterThanOrEqualTo(String value) {
            addCriterion("OP_RECORD >=", value, "opRecord");
            return (Criteria) this;
        }

        public Criteria andOpRecordLessThan(String value) {
            addCriterion("OP_RECORD <", value, "opRecord");
            return (Criteria) this;
        }

        public Criteria andOpRecordLessThanOrEqualTo(String value) {
            addCriterion("OP_RECORD <=", value, "opRecord");
            return (Criteria) this;
        }

        public Criteria andOpRecordLike(String value) {
            addCriterion("OP_RECORD like", value, "opRecord");
            return (Criteria) this;
        }

        public Criteria andOpRecordNotLike(String value) {
            addCriterion("OP_RECORD not like", value, "opRecord");
            return (Criteria) this;
        }

        public Criteria andOpRecordIn(List<String> values) {
            addCriterion("OP_RECORD in", values, "opRecord");
            return (Criteria) this;
        }

        public Criteria andOpRecordNotIn(List<String> values) {
            addCriterion("OP_RECORD not in", values, "opRecord");
            return (Criteria) this;
        }

        public Criteria andOpRecordBetween(String value1, String value2) {
            addCriterion("OP_RECORD between", value1, value2, "opRecord");
            return (Criteria) this;
        }

        public Criteria andOpRecordNotBetween(String value1, String value2) {
            addCriterion("OP_RECORD not between", value1, value2, "opRecord");
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
     * This class corresponds to the database table OP_LOG_RECORD
     *
     * @mbggenerated do_not_delete_during_merge Fri Mar 11 19:55:57 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table OP_LOG_RECORD
     * table comment :操作历史记录
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
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