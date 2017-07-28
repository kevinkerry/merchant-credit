package com.sdp.mc.task.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.util.Date;

public class TimedTaskExecuteInfoDO extends BaseDO {
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
}