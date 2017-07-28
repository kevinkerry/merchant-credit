package com.sdp.mc.task.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimedTaskExecuteInfoDOExample extends QueryBase {
    /**
     * This field corresponds to the database column TB_TIMED_TASK_EXECUTE_INFO.ID
     * column comments ID
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    private Long id;

    /**
     * This field corresponds to the database column TB_TIMED_TASK_EXECUTE_INFO.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    private Date createTime;

    /**
     * This field corresponds to the database column TB_TIMED_TASK_EXECUTE_INFO.UPDATE_TIME
     * column comments 更新时间
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column TB_TIMED_TASK_EXECUTE_INFO.TASK_ID
     * column comments 任务ID
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    private Long taskId;

    /**
     * This field corresponds to the database column TB_TIMED_TASK_EXECUTE_INFO.USE_TIME
     * column comments 执行用时
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    private Integer useTime;

    /**
     * This field corresponds to the database column TB_TIMED_TASK_EXECUTE_INFO.RESULT
     * column comments 执行结果
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    private String result;

    /**
     * This field corresponds to the database column TB_TIMED_TASK_EXECUTE_INFO.REMARK
     * column comments 备注信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    private String remark;

    /**
     * This field corresponds to the database table TB_TIMED_TASK_EXECUTE_INFO
     * table comments 任务执行情况
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table TB_TIMED_TASK_EXECUTE_INFO
     * table comments 任务执行情况
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table TB_TIMED_TASK_EXECUTE_INFO
     * table comments 任务执行情况
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table TB_TIMED_TASK_EXECUTE_INFO
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public TimedTaskExecuteInfoDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column TB_TIMED_TASK_EXECUTE_INFO.ID
     *
     * @return the value of TB_TIMED_TASK_EXECUTE_INFO.ID
     * column comments ID
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column TB_TIMED_TASK_EXECUTE_INFO.ID
     *
     * @param id the value for TB_TIMED_TASK_EXECUTE_INFO.ID
     * column comments ID
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column TB_TIMED_TASK_EXECUTE_INFO.CREATE_TIME
     *
     * @return the value of TB_TIMED_TASK_EXECUTE_INFO.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column TB_TIMED_TASK_EXECUTE_INFO.CREATE_TIME
     *
     * @param createTime the value for TB_TIMED_TASK_EXECUTE_INFO.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column TB_TIMED_TASK_EXECUTE_INFO.UPDATE_TIME
     *
     * @return the value of TB_TIMED_TASK_EXECUTE_INFO.UPDATE_TIME
     * column comments 更新时间
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column TB_TIMED_TASK_EXECUTE_INFO.UPDATE_TIME
     *
     * @param updateTime the value for TB_TIMED_TASK_EXECUTE_INFO.UPDATE_TIME
     * column comments 更新时间
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column TB_TIMED_TASK_EXECUTE_INFO.TASK_ID
     *
     * @return the value of TB_TIMED_TASK_EXECUTE_INFO.TASK_ID
     * column comments 任务ID
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * This method sets the value of the database column TB_TIMED_TASK_EXECUTE_INFO.TASK_ID
     *
     * @param taskId the value for TB_TIMED_TASK_EXECUTE_INFO.TASK_ID
     * column comments 任务ID
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    /**
     * This method returns the value of the database column TB_TIMED_TASK_EXECUTE_INFO.USE_TIME
     *
     * @return the value of TB_TIMED_TASK_EXECUTE_INFO.USE_TIME
     * column comments 执行用时
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public Integer getUseTime() {
        return useTime;
    }

    /**
     * This method sets the value of the database column TB_TIMED_TASK_EXECUTE_INFO.USE_TIME
     *
     * @param useTime the value for TB_TIMED_TASK_EXECUTE_INFO.USE_TIME
     * column comments 执行用时
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public void setUseTime(Integer useTime) {
        this.useTime = useTime;
    }

    /**
     * This method returns the value of the database column TB_TIMED_TASK_EXECUTE_INFO.RESULT
     *
     * @return the value of TB_TIMED_TASK_EXECUTE_INFO.RESULT
     * column comments 执行结果
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public String getResult() {
        return result;
    }

    /**
     * This method sets the value of the database column TB_TIMED_TASK_EXECUTE_INFO.RESULT
     *
     * @param result the value for TB_TIMED_TASK_EXECUTE_INFO.RESULT
     * column comments 执行结果
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    /**
     * This method returns the value of the database column TB_TIMED_TASK_EXECUTE_INFO.REMARK
     *
     * @return the value of TB_TIMED_TASK_EXECUTE_INFO.REMARK
     * column comments 备注信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method sets the value of the database column TB_TIMED_TASK_EXECUTE_INFO.REMARK
     *
     * @param remark the value for TB_TIMED_TASK_EXECUTE_INFO.REMARK
     * column comments 备注信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method corresponds to the database table TB_TIMED_TASK_EXECUTE_INFO
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table TB_TIMED_TASK_EXECUTE_INFO
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table TB_TIMED_TASK_EXECUTE_INFO
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table TB_TIMED_TASK_EXECUTE_INFO
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table TB_TIMED_TASK_EXECUTE_INFO
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table TB_TIMED_TASK_EXECUTE_INFO
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table TB_TIMED_TASK_EXECUTE_INFO
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_TIMED_TASK_EXECUTE_INFO
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_TIMED_TASK_EXECUTE_INFO
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_TIMED_TASK_EXECUTE_INFO
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_TIMED_TASK_EXECUTE_INFO
     * table comment :任务执行情况
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
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

        public Criteria andTaskIdIsNull() {
            addCriterion("TASK_ID is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("TASK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Long value) {
            addCriterion("TASK_ID =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Long value) {
            addCriterion("TASK_ID <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Long value) {
            addCriterion("TASK_ID >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("TASK_ID >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Long value) {
            addCriterion("TASK_ID <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("TASK_ID <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Long> values) {
            addCriterion("TASK_ID in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Long> values) {
            addCriterion("TASK_ID not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Long value1, Long value2) {
            addCriterion("TASK_ID between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("TASK_ID not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andUseTimeIsNull() {
            addCriterion("USE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUseTimeIsNotNull() {
            addCriterion("USE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUseTimeEqualTo(Integer value) {
            addCriterion("USE_TIME =", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotEqualTo(Integer value) {
            addCriterion("USE_TIME <>", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeGreaterThan(Integer value) {
            addCriterion("USE_TIME >", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("USE_TIME >=", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeLessThan(Integer value) {
            addCriterion("USE_TIME <", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeLessThanOrEqualTo(Integer value) {
            addCriterion("USE_TIME <=", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeIn(List<Integer> values) {
            addCriterion("USE_TIME in", values, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotIn(List<Integer> values) {
            addCriterion("USE_TIME not in", values, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeBetween(Integer value1, Integer value2) {
            addCriterion("USE_TIME between", value1, value2, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("USE_TIME not between", value1, value2, "useTime");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("RESULT is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("RESULT =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("RESULT <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("RESULT >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("RESULT >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("RESULT <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("RESULT <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("RESULT like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("RESULT not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("RESULT in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("RESULT not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("RESULT between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("RESULT not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_TIMED_TASK_EXECUTE_INFO
     *
     * @mbggenerated do_not_delete_during_merge Thu Apr 27 09:31:21 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_TIMED_TASK_EXECUTE_INFO
     * table comment :任务执行情况
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
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