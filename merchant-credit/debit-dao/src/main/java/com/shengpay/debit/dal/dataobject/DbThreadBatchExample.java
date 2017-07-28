package com.shengpay.debit.dal.dataobject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbThreadBatchExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DbThreadBatchExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected DbThreadBatchExample(DbThreadBatchExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
        this.distinct = example.distinct;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<String> criteriaWithoutValue;

        protected List<Map<String, Object>> criteriaWithSingleValue;

        protected List<Map<String, Object>> criteriaWithListValue;

        protected List<Map<String, Object>> criteriaWithBetweenValue;

        protected GeneratedCriteria() {
            super();
            criteriaWithoutValue = new ArrayList<String>();
            criteriaWithSingleValue = new ArrayList<Map<String, Object>>();
            criteriaWithListValue = new ArrayList<Map<String, Object>>();
            criteriaWithBetweenValue = new ArrayList<Map<String, Object>>();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List<String> getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List<Map<String, Object>> getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List<Map<String, Object>> getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List<Map<String, Object>> getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List<? extends Object> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List<Object> list = new ArrayList<Object>();
            list.add(value1);
            list.add(value2);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
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

        public Criteria andBatchCodeIsNull() {
            addCriterion("BATCH_CODE is null");
            return (Criteria) this;
        }

        public Criteria andBatchCodeIsNotNull() {
            addCriterion("BATCH_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andBatchCodeEqualTo(String value) {
            addCriterion("BATCH_CODE =", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeNotEqualTo(String value) {
            addCriterion("BATCH_CODE <>", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeGreaterThan(String value) {
            addCriterion("BATCH_CODE >", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeGreaterThanOrEqualTo(String value) {
            addCriterion("BATCH_CODE >=", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeLessThan(String value) {
            addCriterion("BATCH_CODE <", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeLessThanOrEqualTo(String value) {
            addCriterion("BATCH_CODE <=", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeLike(String value) {
            addCriterion("BATCH_CODE like", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeNotLike(String value) {
            addCriterion("BATCH_CODE not like", value, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeIn(List<String> values) {
            addCriterion("BATCH_CODE in", values, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeNotIn(List<String> values) {
            addCriterion("BATCH_CODE not in", values, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeBetween(String value1, String value2) {
            addCriterion("BATCH_CODE between", value1, value2, "batchCode");
            return (Criteria) this;
        }

        public Criteria andBatchCodeNotBetween(String value1, String value2) {
            addCriterion("BATCH_CODE not between", value1, value2, "batchCode");
            return (Criteria) this;
        }

        public Criteria andSerilizeCodeIsNull() {
            addCriterion("SERILIZE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSerilizeCodeIsNotNull() {
            addCriterion("SERILIZE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSerilizeCodeEqualTo(String value) {
            addCriterion("SERILIZE_CODE =", value, "serilizeCode");
            return (Criteria) this;
        }

        public Criteria andSerilizeCodeNotEqualTo(String value) {
            addCriterion("SERILIZE_CODE <>", value, "serilizeCode");
            return (Criteria) this;
        }

        public Criteria andSerilizeCodeGreaterThan(String value) {
            addCriterion("SERILIZE_CODE >", value, "serilizeCode");
            return (Criteria) this;
        }

        public Criteria andSerilizeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SERILIZE_CODE >=", value, "serilizeCode");
            return (Criteria) this;
        }

        public Criteria andSerilizeCodeLessThan(String value) {
            addCriterion("SERILIZE_CODE <", value, "serilizeCode");
            return (Criteria) this;
        }

        public Criteria andSerilizeCodeLessThanOrEqualTo(String value) {
            addCriterion("SERILIZE_CODE <=", value, "serilizeCode");
            return (Criteria) this;
        }

        public Criteria andSerilizeCodeLike(String value) {
            addCriterion("SERILIZE_CODE like", value, "serilizeCode");
            return (Criteria) this;
        }

        public Criteria andSerilizeCodeNotLike(String value) {
            addCriterion("SERILIZE_CODE not like", value, "serilizeCode");
            return (Criteria) this;
        }

        public Criteria andSerilizeCodeIn(List<String> values) {
            addCriterion("SERILIZE_CODE in", values, "serilizeCode");
            return (Criteria) this;
        }

        public Criteria andSerilizeCodeNotIn(List<String> values) {
            addCriterion("SERILIZE_CODE not in", values, "serilizeCode");
            return (Criteria) this;
        }

        public Criteria andSerilizeCodeBetween(String value1, String value2) {
            addCriterion("SERILIZE_CODE between", value1, value2, "serilizeCode");
            return (Criteria) this;
        }

        public Criteria andSerilizeCodeNotBetween(String value1, String value2) {
            addCriterion("SERILIZE_CODE not between", value1, value2, "serilizeCode");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andRetryCountIsNull() {
            addCriterion("RETRY_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andRetryCountIsNotNull() {
            addCriterion("RETRY_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andRetryCountEqualTo(Integer value) {
            addCriterion("RETRY_COUNT =", value, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountNotEqualTo(Integer value) {
            addCriterion("RETRY_COUNT <>", value, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountGreaterThan(Integer value) {
            addCriterion("RETRY_COUNT >", value, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("RETRY_COUNT >=", value, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountLessThan(Integer value) {
            addCriterion("RETRY_COUNT <", value, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountLessThanOrEqualTo(Integer value) {
            addCriterion("RETRY_COUNT <=", value, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountIn(List<Integer> values) {
            addCriterion("RETRY_COUNT in", values, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountNotIn(List<Integer> values) {
            addCriterion("RETRY_COUNT not in", values, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountBetween(Integer value1, Integer value2) {
            addCriterion("RETRY_COUNT between", value1, value2, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountNotBetween(Integer value1, Integer value2) {
            addCriterion("RETRY_COUNT not between", value1, value2, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountIsNull() {
            addCriterion("RECORD_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andRecordCountIsNotNull() {
            addCriterion("RECORD_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andRecordCountEqualTo(Long value) {
            addCriterion("RECORD_COUNT =", value, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountNotEqualTo(Long value) {
            addCriterion("RECORD_COUNT <>", value, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountGreaterThan(Long value) {
            addCriterion("RECORD_COUNT >", value, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountGreaterThanOrEqualTo(Long value) {
            addCriterion("RECORD_COUNT >=", value, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountLessThan(Long value) {
            addCriterion("RECORD_COUNT <", value, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountLessThanOrEqualTo(Long value) {
            addCriterion("RECORD_COUNT <=", value, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountIn(List<Long> values) {
            addCriterion("RECORD_COUNT in", values, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountNotIn(List<Long> values) {
            addCriterion("RECORD_COUNT not in", values, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountBetween(Long value1, Long value2) {
            addCriterion("RECORD_COUNT between", value1, value2, "recordCount");
            return (Criteria) this;
        }

        public Criteria andRecordCountNotBetween(Long value1, Long value2) {
            addCriterion("RECORD_COUNT not between", value1, value2, "recordCount");
            return (Criteria) this;
        }

        public Criteria andExecuteResultIsNull() {
            addCriterion("EXECUTE_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andExecuteResultIsNotNull() {
            addCriterion("EXECUTE_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteResultEqualTo(Integer value) {
            addCriterion("EXECUTE_RESULT =", value, "executeResult");
            return (Criteria) this;
        }

        public Criteria andExecuteResultNotEqualTo(Integer value) {
            addCriterion("EXECUTE_RESULT <>", value, "executeResult");
            return (Criteria) this;
        }

        public Criteria andExecuteResultGreaterThan(Integer value) {
            addCriterion("EXECUTE_RESULT >", value, "executeResult");
            return (Criteria) this;
        }

        public Criteria andExecuteResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXECUTE_RESULT >=", value, "executeResult");
            return (Criteria) this;
        }

        public Criteria andExecuteResultLessThan(Integer value) {
            addCriterion("EXECUTE_RESULT <", value, "executeResult");
            return (Criteria) this;
        }

        public Criteria andExecuteResultLessThanOrEqualTo(Integer value) {
            addCriterion("EXECUTE_RESULT <=", value, "executeResult");
            return (Criteria) this;
        }

        public Criteria andExecuteResultIn(List<Integer> values) {
            addCriterion("EXECUTE_RESULT in", values, "executeResult");
            return (Criteria) this;
        }

        public Criteria andExecuteResultNotIn(List<Integer> values) {
            addCriterion("EXECUTE_RESULT not in", values, "executeResult");
            return (Criteria) this;
        }

        public Criteria andExecuteResultBetween(Integer value1, Integer value2) {
            addCriterion("EXECUTE_RESULT between", value1, value2, "executeResult");
            return (Criteria) this;
        }

        public Criteria andExecuteResultNotBetween(Integer value1, Integer value2) {
            addCriterion("EXECUTE_RESULT not between", value1, value2, "executeResult");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("MEMO is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("MEMO is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("MEMO =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("MEMO <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("MEMO >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("MEMO >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("MEMO <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("MEMO <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("MEMO like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("MEMO not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("MEMO in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("MEMO not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("MEMO between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("MEMO not between", value1, value2, "memo");
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

        public Criteria andRunningStatusIsNull() {
            addCriterion("RUNNING_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andRunningStatusIsNotNull() {
            addCriterion("RUNNING_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andRunningStatusEqualTo(Integer value) {
            addCriterion("RUNNING_STATUS =", value, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusNotEqualTo(Integer value) {
            addCriterion("RUNNING_STATUS <>", value, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusGreaterThan(Integer value) {
            addCriterion("RUNNING_STATUS >", value, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("RUNNING_STATUS >=", value, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusLessThan(Integer value) {
            addCriterion("RUNNING_STATUS <", value, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusLessThanOrEqualTo(Integer value) {
            addCriterion("RUNNING_STATUS <=", value, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusIn(List<Integer> values) {
            addCriterion("RUNNING_STATUS in", values, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusNotIn(List<Integer> values) {
            addCriterion("RUNNING_STATUS not in", values, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusBetween(Integer value1, Integer value2) {
            addCriterion("RUNNING_STATUS between", value1, value2, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("RUNNING_STATUS not between", value1, value2, "runningStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}