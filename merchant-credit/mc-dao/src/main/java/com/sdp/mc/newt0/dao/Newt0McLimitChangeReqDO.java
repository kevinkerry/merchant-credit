package com.sdp.mc.newt0.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.util.Date;

public class Newt0McLimitChangeReqDO extends BaseDO {
    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_ID
     * column comments 请求ID
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private Long reqId;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_TIME
     * column comments 请求的时间
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private Date reqTime;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_REQ.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_NUM
     * column comments 请求变更数量
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private Integer reqNum;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_REQ.SUCCESS_NUM
     * column comments 变更成功数量
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private Integer successNum;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_REQ.FAIL_NUM
     * column comments 变更失败数量
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private Integer failNum;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_REQ.STATUS
     * column comments 执行状态  0：初始  1：执行中  2：执行完成
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private Integer status;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_FILE_NAME
     * column comments 请求的文件名
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private String reqFileName;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_REQ.UPDATE_TIME
     * column comments 最后更新时间
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_TYPE
     * column comments 请求类型  0：上传文件  1 :月初自动  
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private Integer reqType;

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_ID
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_REQ.REQ_ID
     * column comments 请求ID
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Long getReqId() {
        return reqId;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_ID
     *
     * @param reqId the value for NEWT0_MC_LIMIT_CHANGE_REQ.REQ_ID
     * column comments 请求ID
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_TIME
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_REQ.REQ_TIME
     * column comments 请求的时间
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Date getReqTime() {
        return reqTime;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_TIME
     *
     * @param reqTime the value for NEWT0_MC_LIMIT_CHANGE_REQ.REQ_TIME
     * column comments 请求的时间
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setReqTime(Date reqTime) {
        this.reqTime = reqTime;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.CREATE_TIME
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_REQ.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.CREATE_TIME
     *
     * @param createTime the value for NEWT0_MC_LIMIT_CHANGE_REQ.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_NUM
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_REQ.REQ_NUM
     * column comments 请求变更数量
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Integer getReqNum() {
        return reqNum;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_NUM
     *
     * @param reqNum the value for NEWT0_MC_LIMIT_CHANGE_REQ.REQ_NUM
     * column comments 请求变更数量
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setReqNum(Integer reqNum) {
        this.reqNum = reqNum;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.SUCCESS_NUM
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_REQ.SUCCESS_NUM
     * column comments 变更成功数量
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Integer getSuccessNum() {
        return successNum;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.SUCCESS_NUM
     *
     * @param successNum the value for NEWT0_MC_LIMIT_CHANGE_REQ.SUCCESS_NUM
     * column comments 变更成功数量
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setSuccessNum(Integer successNum) {
        this.successNum = successNum;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.FAIL_NUM
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_REQ.FAIL_NUM
     * column comments 变更失败数量
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Integer getFailNum() {
        return failNum;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.FAIL_NUM
     *
     * @param failNum the value for NEWT0_MC_LIMIT_CHANGE_REQ.FAIL_NUM
     * column comments 变更失败数量
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setFailNum(Integer failNum) {
        this.failNum = failNum;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.STATUS
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_REQ.STATUS
     * column comments 执行状态  0：初始  1：执行中  2：执行完成
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.STATUS
     *
     * @param status the value for NEWT0_MC_LIMIT_CHANGE_REQ.STATUS
     * column comments 执行状态  0：初始  1：执行中  2：执行完成
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_FILE_NAME
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_REQ.REQ_FILE_NAME
     * column comments 请求的文件名
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public String getReqFileName() {
        return reqFileName;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_FILE_NAME
     *
     * @param reqFileName the value for NEWT0_MC_LIMIT_CHANGE_REQ.REQ_FILE_NAME
     * column comments 请求的文件名
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setReqFileName(String reqFileName) {
        this.reqFileName = reqFileName == null ? null : reqFileName.trim();
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.UPDATE_TIME
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_REQ.UPDATE_TIME
     * column comments 最后更新时间
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.UPDATE_TIME
     *
     * @param updateTime the value for NEWT0_MC_LIMIT_CHANGE_REQ.UPDATE_TIME
     * column comments 最后更新时间
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_TYPE
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_REQ.REQ_TYPE
     * column comments 请求类型  0：上传文件  1 :月初自动  
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Integer getReqType() {
        return reqType;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_TYPE
     *
     * @param reqType the value for NEWT0_MC_LIMIT_CHANGE_REQ.REQ_TYPE
     * column comments 请求类型  0：上传文件  1 :月初自动  
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setReqType(Integer reqType) {
        this.reqType = reqType;
    }
}