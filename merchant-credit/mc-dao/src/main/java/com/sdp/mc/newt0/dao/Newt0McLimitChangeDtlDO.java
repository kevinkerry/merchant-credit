package com.sdp.mc.newt0.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.math.BigDecimal;
import java.util.Date;

public class Newt0McLimitChangeDtlDO extends BaseDO {
    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_DTL.CHANGE_ID
     * column comments 变更ID
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private Long changeId;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_DTL.REQ_ID
     * column comments 请求ID
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private Long reqId;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_DTL.MC_NO
     * column comments 商户号
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private String mcNo;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_DTL.POS_MC_TYPE
     * column comments 商户类型
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private String posMcType;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_DTL.STATUS
     * column comments 变更状态 0：初始  1：变更成功  2：变更失败
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private Integer status;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_DTL.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_DTL.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_DTL.MAX_LIMIT
     * column comments 最高额度
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private BigDecimal maxLimit;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_DTL.MIN_LIMIT
     * column comments 最低额度
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private BigDecimal minLimit;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_DTL.MESSAGE
     * column comments 变更消息
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private String message;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_DTL.CFM_ID
     * column comments 修改变更表的ID
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private Long cfmId;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_DTL.LIMIT_TYPE
     * column comments 额度类型(0 or null:临时额度,1:永久额度)
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    private String limitType;

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.CHANGE_ID
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_DTL.CHANGE_ID
     * column comments 变更ID
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Long getChangeId() {
        return changeId;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.CHANGE_ID
     *
     * @param changeId the value for NEWT0_MC_LIMIT_CHANGE_DTL.CHANGE_ID
     * column comments 变更ID
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setChangeId(Long changeId) {
        this.changeId = changeId;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.REQ_ID
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_DTL.REQ_ID
     * column comments 请求ID
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Long getReqId() {
        return reqId;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.REQ_ID
     *
     * @param reqId the value for NEWT0_MC_LIMIT_CHANGE_DTL.REQ_ID
     * column comments 请求ID
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.MC_NO
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_DTL.MC_NO
     * column comments 商户号
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public String getMcNo() {
        return mcNo;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.MC_NO
     *
     * @param mcNo the value for NEWT0_MC_LIMIT_CHANGE_DTL.MC_NO
     * column comments 商户号
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setMcNo(String mcNo) {
        this.mcNo = mcNo == null ? null : mcNo.trim();
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.POS_MC_TYPE
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_DTL.POS_MC_TYPE
     * column comments 商户类型
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public String getPosMcType() {
        return posMcType;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.POS_MC_TYPE
     *
     * @param posMcType the value for NEWT0_MC_LIMIT_CHANGE_DTL.POS_MC_TYPE
     * column comments 商户类型
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setPosMcType(String posMcType) {
        this.posMcType = posMcType == null ? null : posMcType.trim();
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.STATUS
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_DTL.STATUS
     * column comments 变更状态 0：初始  1：变更成功  2：变更失败
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.STATUS
     *
     * @param status the value for NEWT0_MC_LIMIT_CHANGE_DTL.STATUS
     * column comments 变更状态 0：初始  1：变更成功  2：变更失败
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.CREATE_TIME
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_DTL.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.CREATE_TIME
     *
     * @param createTime the value for NEWT0_MC_LIMIT_CHANGE_DTL.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.UPDATE_TIME
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_DTL.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.UPDATE_TIME
     *
     * @param updateTime the value for NEWT0_MC_LIMIT_CHANGE_DTL.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.MAX_LIMIT
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_DTL.MAX_LIMIT
     * column comments 最高额度
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public BigDecimal getMaxLimit() {
        return maxLimit;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.MAX_LIMIT
     *
     * @param maxLimit the value for NEWT0_MC_LIMIT_CHANGE_DTL.MAX_LIMIT
     * column comments 最高额度
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setMaxLimit(BigDecimal maxLimit) {
        this.maxLimit = maxLimit;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.MIN_LIMIT
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_DTL.MIN_LIMIT
     * column comments 最低额度
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public BigDecimal getMinLimit() {
        return minLimit;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.MIN_LIMIT
     *
     * @param minLimit the value for NEWT0_MC_LIMIT_CHANGE_DTL.MIN_LIMIT
     * column comments 最低额度
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setMinLimit(BigDecimal minLimit) {
        this.minLimit = minLimit;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.MESSAGE
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_DTL.MESSAGE
     * column comments 变更消息
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.MESSAGE
     *
     * @param message the value for NEWT0_MC_LIMIT_CHANGE_DTL.MESSAGE
     * column comments 变更消息
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.CFM_ID
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_DTL.CFM_ID
     * column comments 修改变更表的ID
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Long getCfmId() {
        return cfmId;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.CFM_ID
     *
     * @param cfmId the value for NEWT0_MC_LIMIT_CHANGE_DTL.CFM_ID
     * column comments 修改变更表的ID
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setCfmId(Long cfmId) {
        this.cfmId = cfmId;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.LIMIT_TYPE
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_DTL.LIMIT_TYPE
     * column comments 额度类型(0 or null:临时额度,1:永久额度)
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public String getLimitType() {
        return limitType;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_DTL.LIMIT_TYPE
     *
     * @param limitType the value for NEWT0_MC_LIMIT_CHANGE_DTL.LIMIT_TYPE
     * column comments 额度类型(0 or null:临时额度,1:永久额度)
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    public void setLimitType(String limitType) {
        this.limitType = limitType == null ? null : limitType.trim();
    }
}