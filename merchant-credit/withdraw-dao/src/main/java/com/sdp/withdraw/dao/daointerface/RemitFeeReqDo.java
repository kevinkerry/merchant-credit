package com.sdp.withdraw.dao.daointerface;

import com.sdp.emall.common.dao.BaseDO;
import java.math.BigDecimal;
import java.util.Date;

public class RemitFeeReqDo extends BaseDO {
    /**
     * This field corresponds to the database column FW_REMIT_WITHDRAWFEE_REQ.REMIT_ID
     * column comments 申请ID
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    private Long remitId;

    /**
     * This field corresponds to the database column FW_REMIT_WITHDRAWFEE_REQ.REQ_ID
     * column comments 出款ID
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    private Long reqId;

    /**
     * This field corresponds to the database column FW_REMIT_WITHDRAWFEE_REQ.MT_ID
     * column comments 转账记录ID
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    private Long mtId;

    /**
     * This field corresponds to the database column FW_REMIT_WITHDRAWFEE_REQ.REMITAMOUNT
     * column comments 退费金额
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    private BigDecimal remitamount;

    /**
     * This field corresponds to the database column FW_REMIT_WITHDRAWFEE_REQ.STATUS
     * column comments 状态（初始-3 退费中-4 退费成功-5 退费失败-99）
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    private String status;

    /**
     * This field corresponds to the database column FW_REMIT_WITHDRAWFEE_REQ.OPERTATOR
     * column comments 操作人
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    private String opertator;

    /**
     * This field corresponds to the database column FW_REMIT_WITHDRAWFEE_REQ.CREATE_TIME
     * column comments 申请时间
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column FW_REMIT_WITHDRAWFEE_REQ.UPDATE_TIME
     * column comments 最后操作时间
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    private Date updateTime;

    /**
     * This method returns the value of the database column FW_REMIT_WITHDRAWFEE_REQ.REMIT_ID
     *
     * @return the value of FW_REMIT_WITHDRAWFEE_REQ.REMIT_ID
     * column comments 申请ID
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public Long getRemitId() {
        return remitId;
    }

    /**
     * This method sets the value of the database column FW_REMIT_WITHDRAWFEE_REQ.REMIT_ID
     *
     * @param remitId the value for FW_REMIT_WITHDRAWFEE_REQ.REMIT_ID
     * column comments 申请ID
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public void setRemitId(Long remitId) {
        this.remitId = remitId;
    }

    /**
     * This method returns the value of the database column FW_REMIT_WITHDRAWFEE_REQ.REQ_ID
     *
     * @return the value of FW_REMIT_WITHDRAWFEE_REQ.REQ_ID
     * column comments 出款ID
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public Long getReqId() {
        return reqId;
    }

    /**
     * This method sets the value of the database column FW_REMIT_WITHDRAWFEE_REQ.REQ_ID
     *
     * @param reqId the value for FW_REMIT_WITHDRAWFEE_REQ.REQ_ID
     * column comments 出款ID
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    /**
     * This method returns the value of the database column FW_REMIT_WITHDRAWFEE_REQ.MT_ID
     *
     * @return the value of FW_REMIT_WITHDRAWFEE_REQ.MT_ID
     * column comments 转账记录ID
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public Long getMtId() {
        return mtId;
    }

    /**
     * This method sets the value of the database column FW_REMIT_WITHDRAWFEE_REQ.MT_ID
     *
     * @param mtId the value for FW_REMIT_WITHDRAWFEE_REQ.MT_ID
     * column comments 转账记录ID
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public void setMtId(Long mtId) {
        this.mtId = mtId;
    }

    /**
     * This method returns the value of the database column FW_REMIT_WITHDRAWFEE_REQ.REMITAMOUNT
     *
     * @return the value of FW_REMIT_WITHDRAWFEE_REQ.REMITAMOUNT
     * column comments 退费金额
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public BigDecimal getRemitamount() {
        return remitamount;
    }

    /**
     * This method sets the value of the database column FW_REMIT_WITHDRAWFEE_REQ.REMITAMOUNT
     *
     * @param remitamount the value for FW_REMIT_WITHDRAWFEE_REQ.REMITAMOUNT
     * column comments 退费金额
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public void setRemitamount(BigDecimal remitamount) {
        this.remitamount = remitamount;
    }

    /**
     * This method returns the value of the database column FW_REMIT_WITHDRAWFEE_REQ.STATUS
     *
     * @return the value of FW_REMIT_WITHDRAWFEE_REQ.STATUS
     * column comments 状态（初始-3 退费中-4 退费成功-5 退费失败-99）
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column FW_REMIT_WITHDRAWFEE_REQ.STATUS
     *
     * @param status the value for FW_REMIT_WITHDRAWFEE_REQ.STATUS
     * column comments 状态（初始-3 退费中-4 退费成功-5 退费失败-99）
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method returns the value of the database column FW_REMIT_WITHDRAWFEE_REQ.OPERTATOR
     *
     * @return the value of FW_REMIT_WITHDRAWFEE_REQ.OPERTATOR
     * column comments 操作人
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public String getOpertator() {
        return opertator;
    }

    /**
     * This method sets the value of the database column FW_REMIT_WITHDRAWFEE_REQ.OPERTATOR
     *
     * @param opertator the value for FW_REMIT_WITHDRAWFEE_REQ.OPERTATOR
     * column comments 操作人
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public void setOpertator(String opertator) {
        this.opertator = opertator == null ? null : opertator.trim();
    }

    /**
     * This method returns the value of the database column FW_REMIT_WITHDRAWFEE_REQ.CREATE_TIME
     *
     * @return the value of FW_REMIT_WITHDRAWFEE_REQ.CREATE_TIME
     * column comments 申请时间
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column FW_REMIT_WITHDRAWFEE_REQ.CREATE_TIME
     *
     * @param createTime the value for FW_REMIT_WITHDRAWFEE_REQ.CREATE_TIME
     * column comments 申请时间
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column FW_REMIT_WITHDRAWFEE_REQ.UPDATE_TIME
     *
     * @return the value of FW_REMIT_WITHDRAWFEE_REQ.UPDATE_TIME
     * column comments 最后操作时间
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column FW_REMIT_WITHDRAWFEE_REQ.UPDATE_TIME
     *
     * @param updateTime the value for FW_REMIT_WITHDRAWFEE_REQ.UPDATE_TIME
     * column comments 最后操作时间
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}