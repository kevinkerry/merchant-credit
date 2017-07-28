package com.sdp.mc.task.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimedTaskInfoDOExample extends QueryBase {
    /**
     * This field corresponds to the database column TB_TIMED_TASK_INFO.ID
     * column comments 主键ＩＤ
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    private Long id;

    /**
     * This field corresponds to the database column TB_TIMED_TASK_INFO.TASK_TYPE
     * column comments 任务类型　1:sql,2:定制,3:rest
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    private Integer taskType;

    /**
     * This field corresponds to the database column TB_TIMED_TASK_INFO.TASK_CONTENT
     * column comments 任务内容
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    private String taskContent;

    /**
     * This field corresponds to the database column TB_TIMED_TASK_INFO.TASK_STATUS
     * column comments 任务状态 1：待执行 2：执行中，3：待重试，4：执行失败，0：执行成功 
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    private Integer taskStatus;

    /**
     * This field corresponds to the database column TB_TIMED_TASK_INFO.EFFECTIVE_TIME
     * column comments 生效时间
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    private Date effectiveTime;

    /**
     * This field corresponds to the database column TB_TIMED_TASK_INFO.RETRY_TIMES
     * column comments 重试次数
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    private Integer retryTimes;

    /**
     * This field corresponds to the database column TB_TIMED_TASK_INFO.EXECUTE_TIMES
     * column comments 执行次数
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    private Integer executeTimes;

    /**
     * This field corresponds to the database column TB_TIMED_TASK_INFO.LAST_EXECUTE_TIME
     * column comments 最后执行时间
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    private Date lastExecuteTime;

    /**
     * This field corresponds to the database column TB_TIMED_TASK_INFO.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    private Date createTime;

    /**
     * This field corresponds to the database column TB_TIMED_TASK_INFO.UPDATE_TIME
     * column comments 更新时间
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column TB_TIMED_TASK_INFO.NOTIFY_EMAIL
     * column comments 通知的邮件
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    private String notifyEmail;

    /**
     * This field corresponds to the database column TB_TIMED_TASK_INFO.NOTIFY_PHONE
     * column comments 通知的手机
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    private String notifyPhone;

    /**
     * This field corresponds to the database column TB_TIMED_TASK_INFO.LAST_EXECUTE_ID
     * column comments 最后执行的ID
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    private Long lastExecuteId;

    /**
     * This field corresponds to the database column TB_TIMED_TASK_INFO.RETRY_TIME_INTERVAL
     * column comments 重试时间间隔（S）
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    private Integer retryTimeInterval;

    /**
     * This field corresponds to the database table TB_TIMED_TASK_INFO
     * table comments 定时任务信息表
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table TB_TIMED_TASK_INFO
     * table comments 定时任务信息表
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table TB_TIMED_TASK_INFO
     * table comments 定时任务信息表
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table TB_TIMED_TASK_INFO
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public TimedTaskInfoDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column TB_TIMED_TASK_INFO.ID
     *
     * @return the value of TB_TIMED_TASK_INFO.ID
     * column comments 主键ＩＤ
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column TB_TIMED_TASK_INFO.ID
     *
     * @param id the value for TB_TIMED_TASK_INFO.ID
     * column comments 主键ＩＤ
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column TB_TIMED_TASK_INFO.TASK_TYPE
     *
     * @return the value of TB_TIMED_TASK_INFO.TASK_TYPE
     * column comments 任务类型　1:sql,2:定制,3:rest
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public Integer getTaskType() {
        return taskType;
    }

    /**
     * This method sets the value of the database column TB_TIMED_TASK_INFO.TASK_TYPE
     *
     * @param taskType the value for TB_TIMED_TASK_INFO.TASK_TYPE
     * column comments 任务类型　1:sql,2:定制,3:rest
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    /**
     * This method returns the value of the database column TB_TIMED_TASK_INFO.TASK_CONTENT
     *
     * @return the value of TB_TIMED_TASK_INFO.TASK_CONTENT
     * column comments 任务内容
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public String getTaskContent() {
        return taskContent;
    }

    /**
     * This method sets the value of the database column TB_TIMED_TASK_INFO.TASK_CONTENT
     *
     * @param taskContent the value for TB_TIMED_TASK_INFO.TASK_CONTENT
     * column comments 任务内容
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent == null ? null : taskContent.trim();
    }

    /**
     * This method returns the value of the database column TB_TIMED_TASK_INFO.TASK_STATUS
     *
     * @return the value of TB_TIMED_TASK_INFO.TASK_STATUS
     * column comments 任务状态 1：待执行 2：执行中，3：待重试，4：执行失败，0：执行成功 
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public Integer getTaskStatus() {
        return taskStatus;
    }

    /**
     * This method sets the value of the database column TB_TIMED_TASK_INFO.TASK_STATUS
     *
     * @param taskStatus the value for TB_TIMED_TASK_INFO.TASK_STATUS
     * column comments 任务状态 1：待执行 2：执行中，3：待重试，4：执行失败，0：执行成功 
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    /**
     * This method returns the value of the database column TB_TIMED_TASK_INFO.EFFECTIVE_TIME
     *
     * @return the value of TB_TIMED_TASK_INFO.EFFECTIVE_TIME
     * column comments 生效时间
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public Date getEffectiveTime() {
        return effectiveTime;
    }

    /**
     * This method sets the value of the database column TB_TIMED_TASK_INFO.EFFECTIVE_TIME
     *
     * @param effectiveTime the value for TB_TIMED_TASK_INFO.EFFECTIVE_TIME
     * column comments 生效时间
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    /**
     * This method returns the value of the database column TB_TIMED_TASK_INFO.RETRY_TIMES
     *
     * @return the value of TB_TIMED_TASK_INFO.RETRY_TIMES
     * column comments 重试次数
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public Integer getRetryTimes() {
        return retryTimes;
    }

    /**
     * This method sets the value of the database column TB_TIMED_TASK_INFO.RETRY_TIMES
     *
     * @param retryTimes the value for TB_TIMED_TASK_INFO.RETRY_TIMES
     * column comments 重试次数
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public void setRetryTimes(Integer retryTimes) {
        this.retryTimes = retryTimes;
    }

    /**
     * This method returns the value of the database column TB_TIMED_TASK_INFO.EXECUTE_TIMES
     *
     * @return the value of TB_TIMED_TASK_INFO.EXECUTE_TIMES
     * column comments 执行次数
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public Integer getExecuteTimes() {
        return executeTimes;
    }

    /**
     * This method sets the value of the database column TB_TIMED_TASK_INFO.EXECUTE_TIMES
     *
     * @param executeTimes the value for TB_TIMED_TASK_INFO.EXECUTE_TIMES
     * column comments 执行次数
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public void setExecuteTimes(Integer executeTimes) {
        this.executeTimes = executeTimes;
    }

    /**
     * This method returns the value of the database column TB_TIMED_TASK_INFO.LAST_EXECUTE_TIME
     *
     * @return the value of TB_TIMED_TASK_INFO.LAST_EXECUTE_TIME
     * column comments 最后执行时间
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public Date getLastExecuteTime() {
        return lastExecuteTime;
    }

    /**
     * This method sets the value of the database column TB_TIMED_TASK_INFO.LAST_EXECUTE_TIME
     *
     * @param lastExecuteTime the value for TB_TIMED_TASK_INFO.LAST_EXECUTE_TIME
     * column comments 最后执行时间
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public void setLastExecuteTime(Date lastExecuteTime) {
        this.lastExecuteTime = lastExecuteTime;
    }

    /**
     * This method returns the value of the database column TB_TIMED_TASK_INFO.CREATE_TIME
     *
     * @return the value of TB_TIMED_TASK_INFO.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column TB_TIMED_TASK_INFO.CREATE_TIME
     *
     * @param createTime the value for TB_TIMED_TASK_INFO.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column TB_TIMED_TASK_INFO.UPDATE_TIME
     *
     * @return the value of TB_TIMED_TASK_INFO.UPDATE_TIME
     * column comments 更新时间
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column TB_TIMED_TASK_INFO.UPDATE_TIME
     *
     * @param updateTime the value for TB_TIMED_TASK_INFO.UPDATE_TIME
     * column comments 更新时间
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column TB_TIMED_TASK_INFO.NOTIFY_EMAIL
     *
     * @return the value of TB_TIMED_TASK_INFO.NOTIFY_EMAIL
     * column comments 通知的邮件
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public String getNotifyEmail() {
        return notifyEmail;
    }

    /**
     * This method sets the value of the database column TB_TIMED_TASK_INFO.NOTIFY_EMAIL
     *
     * @param notifyEmail the value for TB_TIMED_TASK_INFO.NOTIFY_EMAIL
     * column comments 通知的邮件
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public void setNotifyEmail(String notifyEmail) {
        this.notifyEmail = notifyEmail == null ? null : notifyEmail.trim();
    }

    /**
     * This method returns the value of the database column TB_TIMED_TASK_INFO.NOTIFY_PHONE
     *
     * @return the value of TB_TIMED_TASK_INFO.NOTIFY_PHONE
     * column comments 通知的手机
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public String getNotifyPhone() {
        return notifyPhone;
    }

    /**
     * This method sets the value of the database column TB_TIMED_TASK_INFO.NOTIFY_PHONE
     *
     * @param notifyPhone the value for TB_TIMED_TASK_INFO.NOTIFY_PHONE
     * column comments 通知的手机
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public void setNotifyPhone(String notifyPhone) {
        this.notifyPhone = notifyPhone == null ? null : notifyPhone.trim();
    }

    /**
     * This method returns the value of the database column TB_TIMED_TASK_INFO.LAST_EXECUTE_ID
     *
     * @return the value of TB_TIMED_TASK_INFO.LAST_EXECUTE_ID
     * column comments 最后执行的ID
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public Long getLastExecuteId() {
        return lastExecuteId;
    }

    /**
     * This method sets the value of the database column TB_TIMED_TASK_INFO.LAST_EXECUTE_ID
     *
     * @param lastExecuteId the value for TB_TIMED_TASK_INFO.LAST_EXECUTE_ID
     * column comments 最后执行的ID
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public void setLastExecuteId(Long lastExecuteId) {
        this.lastExecuteId = lastExecuteId;
    }

    /**
     * This method returns the value of the database column TB_TIMED_TASK_INFO.RETRY_TIME_INTERVAL
     *
     * @return the value of TB_TIMED_TASK_INFO.RETRY_TIME_INTERVAL
     * column comments 重试时间间隔（S）
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public Integer getRetryTimeInterval() {
        return retryTimeInterval;
    }

    /**
     * This method sets the value of the database column TB_TIMED_TASK_INFO.RETRY_TIME_INTERVAL
     *
     * @param retryTimeInterval the value for TB_TIMED_TASK_INFO.RETRY_TIME_INTERVAL
     * column comments 重试时间间隔（S）
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public void setRetryTimeInterval(Integer retryTimeInterval) {
        this.retryTimeInterval = retryTimeInterval;
    }

    /**
     * This method corresponds to the database table TB_TIMED_TASK_INFO
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table TB_TIMED_TASK_INFO
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table TB_TIMED_TASK_INFO
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table TB_TIMED_TASK_INFO
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table TB_TIMED_TASK_INFO
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table TB_TIMED_TASK_INFO
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table TB_TIMED_TASK_INFO
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_TIMED_TASK_INFO
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_TIMED_TASK_INFO
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_TIMED_TASK_INFO
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_TIMED_TASK_INFO
     * table comment :定时任务信息表
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
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

        public Criteria andTaskTypeIsNull() {
            addCriterion("TASK_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("TASK_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(Integer value) {
            addCriterion("TASK_TYPE =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(Integer value) {
            addCriterion("TASK_TYPE <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(Integer value) {
            addCriterion("TASK_TYPE >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TASK_TYPE >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(Integer value) {
            addCriterion("TASK_TYPE <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(Integer value) {
            addCriterion("TASK_TYPE <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<Integer> values) {
            addCriterion("TASK_TYPE in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<Integer> values) {
            addCriterion("TASK_TYPE not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(Integer value1, Integer value2) {
            addCriterion("TASK_TYPE between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("TASK_TYPE not between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskContentIsNull() {
            addCriterion("TASK_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andTaskContentIsNotNull() {
            addCriterion("TASK_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andTaskContentEqualTo(String value) {
            addCriterion("TASK_CONTENT =", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotEqualTo(String value) {
            addCriterion("TASK_CONTENT <>", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentGreaterThan(String value) {
            addCriterion("TASK_CONTENT >", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_CONTENT >=", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLessThan(String value) {
            addCriterion("TASK_CONTENT <", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLessThanOrEqualTo(String value) {
            addCriterion("TASK_CONTENT <=", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLike(String value) {
            addCriterion("TASK_CONTENT like", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotLike(String value) {
            addCriterion("TASK_CONTENT not like", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentIn(List<String> values) {
            addCriterion("TASK_CONTENT in", values, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotIn(List<String> values) {
            addCriterion("TASK_CONTENT not in", values, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentBetween(String value1, String value2) {
            addCriterion("TASK_CONTENT between", value1, value2, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotBetween(String value1, String value2) {
            addCriterion("TASK_CONTENT not between", value1, value2, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNull() {
            addCriterion("TASK_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNotNull() {
            addCriterion("TASK_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusEqualTo(Integer value) {
            addCriterion("TASK_STATUS =", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotEqualTo(Integer value) {
            addCriterion("TASK_STATUS <>", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThan(Integer value) {
            addCriterion("TASK_STATUS >", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("TASK_STATUS >=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThan(Integer value) {
            addCriterion("TASK_STATUS <", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThanOrEqualTo(Integer value) {
            addCriterion("TASK_STATUS <=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIn(List<Integer> values) {
            addCriterion("TASK_STATUS in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotIn(List<Integer> values) {
            addCriterion("TASK_STATUS not in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusBetween(Integer value1, Integer value2) {
            addCriterion("TASK_STATUS between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("TASK_STATUS not between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeIsNull() {
            addCriterion("EFFECTIVE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeIsNotNull() {
            addCriterion("EFFECTIVE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEqualTo(Date value) {
            addCriterion("EFFECTIVE_TIME =", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeNotEqualTo(Date value) {
            addCriterion("EFFECTIVE_TIME <>", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeGreaterThan(Date value) {
            addCriterion("EFFECTIVE_TIME >", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EFFECTIVE_TIME >=", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeLessThan(Date value) {
            addCriterion("EFFECTIVE_TIME <", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("EFFECTIVE_TIME <=", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeIn(List<Date> values) {
            addCriterion("EFFECTIVE_TIME in", values, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeNotIn(List<Date> values) {
            addCriterion("EFFECTIVE_TIME not in", values, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeBetween(Date value1, Date value2) {
            addCriterion("EFFECTIVE_TIME between", value1, value2, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("EFFECTIVE_TIME not between", value1, value2, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andRetryTimesIsNull() {
            addCriterion("RETRY_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andRetryTimesIsNotNull() {
            addCriterion("RETRY_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andRetryTimesEqualTo(Integer value) {
            addCriterion("RETRY_TIMES =", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesNotEqualTo(Integer value) {
            addCriterion("RETRY_TIMES <>", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesGreaterThan(Integer value) {
            addCriterion("RETRY_TIMES >", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("RETRY_TIMES >=", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesLessThan(Integer value) {
            addCriterion("RETRY_TIMES <", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesLessThanOrEqualTo(Integer value) {
            addCriterion("RETRY_TIMES <=", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesIn(List<Integer> values) {
            addCriterion("RETRY_TIMES in", values, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesNotIn(List<Integer> values) {
            addCriterion("RETRY_TIMES not in", values, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesBetween(Integer value1, Integer value2) {
            addCriterion("RETRY_TIMES between", value1, value2, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("RETRY_TIMES not between", value1, value2, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesIsNull() {
            addCriterion("EXECUTE_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesIsNotNull() {
            addCriterion("EXECUTE_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesEqualTo(Integer value) {
            addCriterion("EXECUTE_TIMES =", value, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesNotEqualTo(Integer value) {
            addCriterion("EXECUTE_TIMES <>", value, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesGreaterThan(Integer value) {
            addCriterion("EXECUTE_TIMES >", value, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXECUTE_TIMES >=", value, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesLessThan(Integer value) {
            addCriterion("EXECUTE_TIMES <", value, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesLessThanOrEqualTo(Integer value) {
            addCriterion("EXECUTE_TIMES <=", value, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesIn(List<Integer> values) {
            addCriterion("EXECUTE_TIMES in", values, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesNotIn(List<Integer> values) {
            addCriterion("EXECUTE_TIMES not in", values, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesBetween(Integer value1, Integer value2) {
            addCriterion("EXECUTE_TIMES between", value1, value2, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("EXECUTE_TIMES not between", value1, value2, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andLastExecuteTimeIsNull() {
            addCriterion("LAST_EXECUTE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastExecuteTimeIsNotNull() {
            addCriterion("LAST_EXECUTE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastExecuteTimeEqualTo(Date value) {
            addCriterion("LAST_EXECUTE_TIME =", value, "lastExecuteTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuteTimeNotEqualTo(Date value) {
            addCriterion("LAST_EXECUTE_TIME <>", value, "lastExecuteTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuteTimeGreaterThan(Date value) {
            addCriterion("LAST_EXECUTE_TIME >", value, "lastExecuteTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_EXECUTE_TIME >=", value, "lastExecuteTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuteTimeLessThan(Date value) {
            addCriterion("LAST_EXECUTE_TIME <", value, "lastExecuteTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuteTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_EXECUTE_TIME <=", value, "lastExecuteTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuteTimeIn(List<Date> values) {
            addCriterion("LAST_EXECUTE_TIME in", values, "lastExecuteTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuteTimeNotIn(List<Date> values) {
            addCriterion("LAST_EXECUTE_TIME not in", values, "lastExecuteTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuteTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_EXECUTE_TIME between", value1, value2, "lastExecuteTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuteTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_EXECUTE_TIME not between", value1, value2, "lastExecuteTime");
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

        public Criteria andNotifyEmailIsNull() {
            addCriterion("NOTIFY_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andNotifyEmailIsNotNull() {
            addCriterion("NOTIFY_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyEmailEqualTo(String value) {
            addCriterion("NOTIFY_EMAIL =", value, "notifyEmail");
            return (Criteria) this;
        }

        public Criteria andNotifyEmailNotEqualTo(String value) {
            addCriterion("NOTIFY_EMAIL <>", value, "notifyEmail");
            return (Criteria) this;
        }

        public Criteria andNotifyEmailGreaterThan(String value) {
            addCriterion("NOTIFY_EMAIL >", value, "notifyEmail");
            return (Criteria) this;
        }

        public Criteria andNotifyEmailGreaterThanOrEqualTo(String value) {
            addCriterion("NOTIFY_EMAIL >=", value, "notifyEmail");
            return (Criteria) this;
        }

        public Criteria andNotifyEmailLessThan(String value) {
            addCriterion("NOTIFY_EMAIL <", value, "notifyEmail");
            return (Criteria) this;
        }

        public Criteria andNotifyEmailLessThanOrEqualTo(String value) {
            addCriterion("NOTIFY_EMAIL <=", value, "notifyEmail");
            return (Criteria) this;
        }

        public Criteria andNotifyEmailLike(String value) {
            addCriterion("NOTIFY_EMAIL like", value, "notifyEmail");
            return (Criteria) this;
        }

        public Criteria andNotifyEmailNotLike(String value) {
            addCriterion("NOTIFY_EMAIL not like", value, "notifyEmail");
            return (Criteria) this;
        }

        public Criteria andNotifyEmailIn(List<String> values) {
            addCriterion("NOTIFY_EMAIL in", values, "notifyEmail");
            return (Criteria) this;
        }

        public Criteria andNotifyEmailNotIn(List<String> values) {
            addCriterion("NOTIFY_EMAIL not in", values, "notifyEmail");
            return (Criteria) this;
        }

        public Criteria andNotifyEmailBetween(String value1, String value2) {
            addCriterion("NOTIFY_EMAIL between", value1, value2, "notifyEmail");
            return (Criteria) this;
        }

        public Criteria andNotifyEmailNotBetween(String value1, String value2) {
            addCriterion("NOTIFY_EMAIL not between", value1, value2, "notifyEmail");
            return (Criteria) this;
        }

        public Criteria andNotifyPhoneIsNull() {
            addCriterion("NOTIFY_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andNotifyPhoneIsNotNull() {
            addCriterion("NOTIFY_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyPhoneEqualTo(String value) {
            addCriterion("NOTIFY_PHONE =", value, "notifyPhone");
            return (Criteria) this;
        }

        public Criteria andNotifyPhoneNotEqualTo(String value) {
            addCriterion("NOTIFY_PHONE <>", value, "notifyPhone");
            return (Criteria) this;
        }

        public Criteria andNotifyPhoneGreaterThan(String value) {
            addCriterion("NOTIFY_PHONE >", value, "notifyPhone");
            return (Criteria) this;
        }

        public Criteria andNotifyPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("NOTIFY_PHONE >=", value, "notifyPhone");
            return (Criteria) this;
        }

        public Criteria andNotifyPhoneLessThan(String value) {
            addCriterion("NOTIFY_PHONE <", value, "notifyPhone");
            return (Criteria) this;
        }

        public Criteria andNotifyPhoneLessThanOrEqualTo(String value) {
            addCriterion("NOTIFY_PHONE <=", value, "notifyPhone");
            return (Criteria) this;
        }

        public Criteria andNotifyPhoneLike(String value) {
            addCriterion("NOTIFY_PHONE like", value, "notifyPhone");
            return (Criteria) this;
        }

        public Criteria andNotifyPhoneNotLike(String value) {
            addCriterion("NOTIFY_PHONE not like", value, "notifyPhone");
            return (Criteria) this;
        }

        public Criteria andNotifyPhoneIn(List<String> values) {
            addCriterion("NOTIFY_PHONE in", values, "notifyPhone");
            return (Criteria) this;
        }

        public Criteria andNotifyPhoneNotIn(List<String> values) {
            addCriterion("NOTIFY_PHONE not in", values, "notifyPhone");
            return (Criteria) this;
        }

        public Criteria andNotifyPhoneBetween(String value1, String value2) {
            addCriterion("NOTIFY_PHONE between", value1, value2, "notifyPhone");
            return (Criteria) this;
        }

        public Criteria andNotifyPhoneNotBetween(String value1, String value2) {
            addCriterion("NOTIFY_PHONE not between", value1, value2, "notifyPhone");
            return (Criteria) this;
        }

        public Criteria andLastExecuteIdIsNull() {
            addCriterion("LAST_EXECUTE_ID is null");
            return (Criteria) this;
        }

        public Criteria andLastExecuteIdIsNotNull() {
            addCriterion("LAST_EXECUTE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLastExecuteIdEqualTo(Long value) {
            addCriterion("LAST_EXECUTE_ID =", value, "lastExecuteId");
            return (Criteria) this;
        }

        public Criteria andLastExecuteIdNotEqualTo(Long value) {
            addCriterion("LAST_EXECUTE_ID <>", value, "lastExecuteId");
            return (Criteria) this;
        }

        public Criteria andLastExecuteIdGreaterThan(Long value) {
            addCriterion("LAST_EXECUTE_ID >", value, "lastExecuteId");
            return (Criteria) this;
        }

        public Criteria andLastExecuteIdGreaterThanOrEqualTo(Long value) {
            addCriterion("LAST_EXECUTE_ID >=", value, "lastExecuteId");
            return (Criteria) this;
        }

        public Criteria andLastExecuteIdLessThan(Long value) {
            addCriterion("LAST_EXECUTE_ID <", value, "lastExecuteId");
            return (Criteria) this;
        }

        public Criteria andLastExecuteIdLessThanOrEqualTo(Long value) {
            addCriterion("LAST_EXECUTE_ID <=", value, "lastExecuteId");
            return (Criteria) this;
        }

        public Criteria andLastExecuteIdIn(List<Long> values) {
            addCriterion("LAST_EXECUTE_ID in", values, "lastExecuteId");
            return (Criteria) this;
        }

        public Criteria andLastExecuteIdNotIn(List<Long> values) {
            addCriterion("LAST_EXECUTE_ID not in", values, "lastExecuteId");
            return (Criteria) this;
        }

        public Criteria andLastExecuteIdBetween(Long value1, Long value2) {
            addCriterion("LAST_EXECUTE_ID between", value1, value2, "lastExecuteId");
            return (Criteria) this;
        }

        public Criteria andLastExecuteIdNotBetween(Long value1, Long value2) {
            addCriterion("LAST_EXECUTE_ID not between", value1, value2, "lastExecuteId");
            return (Criteria) this;
        }

        public Criteria andRetryTimeIntervalIsNull() {
            addCriterion("RETRY_TIME_INTERVAL is null");
            return (Criteria) this;
        }

        public Criteria andRetryTimeIntervalIsNotNull() {
            addCriterion("RETRY_TIME_INTERVAL is not null");
            return (Criteria) this;
        }

        public Criteria andRetryTimeIntervalEqualTo(Integer value) {
            addCriterion("RETRY_TIME_INTERVAL =", value, "retryTimeInterval");
            return (Criteria) this;
        }

        public Criteria andRetryTimeIntervalNotEqualTo(Integer value) {
            addCriterion("RETRY_TIME_INTERVAL <>", value, "retryTimeInterval");
            return (Criteria) this;
        }

        public Criteria andRetryTimeIntervalGreaterThan(Integer value) {
            addCriterion("RETRY_TIME_INTERVAL >", value, "retryTimeInterval");
            return (Criteria) this;
        }

        public Criteria andRetryTimeIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("RETRY_TIME_INTERVAL >=", value, "retryTimeInterval");
            return (Criteria) this;
        }

        public Criteria andRetryTimeIntervalLessThan(Integer value) {
            addCriterion("RETRY_TIME_INTERVAL <", value, "retryTimeInterval");
            return (Criteria) this;
        }

        public Criteria andRetryTimeIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("RETRY_TIME_INTERVAL <=", value, "retryTimeInterval");
            return (Criteria) this;
        }

        public Criteria andRetryTimeIntervalIn(List<Integer> values) {
            addCriterion("RETRY_TIME_INTERVAL in", values, "retryTimeInterval");
            return (Criteria) this;
        }

        public Criteria andRetryTimeIntervalNotIn(List<Integer> values) {
            addCriterion("RETRY_TIME_INTERVAL not in", values, "retryTimeInterval");
            return (Criteria) this;
        }

        public Criteria andRetryTimeIntervalBetween(Integer value1, Integer value2) {
            addCriterion("RETRY_TIME_INTERVAL between", value1, value2, "retryTimeInterval");
            return (Criteria) this;
        }

        public Criteria andRetryTimeIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("RETRY_TIME_INTERVAL not between", value1, value2, "retryTimeInterval");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_TIMED_TASK_INFO
     *
     * @mbggenerated do_not_delete_during_merge Wed May 10 13:57:18 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_TIMED_TASK_INFO
     * table comment :定时任务信息表
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
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