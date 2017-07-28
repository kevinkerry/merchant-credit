package com.sdp.mc.task.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.util.Date;

public class TimedTaskInfoDO extends BaseDO {
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
}