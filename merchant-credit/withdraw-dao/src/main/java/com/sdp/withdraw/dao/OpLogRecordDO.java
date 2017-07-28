package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.util.Date;

public class OpLogRecordDO extends BaseDO {
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
}