package com.sdp.mc.newt0.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.math.BigDecimal;
import java.util.Date;

public class Newt0SdpRemainBalanceDO extends BaseDO {
    /**
     * This field corresponds to the database column NEWT0_SDP_REMAIN_BALANCE.ID
     * column comments null
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    private Long id;

    /**
     * This field corresponds to the database column NEWT0_SDP_REMAIN_BALANCE.START_TIME
     * column comments 生效开始日
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    private Date startTime;

    /**
     * This field corresponds to the database column NEWT0_SDP_REMAIN_BALANCE.QUOTA
     * column comments 配资额度
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    private BigDecimal quota;

    /**
     * This field corresponds to the database column NEWT0_SDP_REMAIN_BALANCE.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    private Date createTime;

    /**
     * This field corresponds to the database column NEWT0_SDP_REMAIN_BALANCE.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column NEWT0_SDP_REMAIN_BALANCE.END_TIME
     * column comments 生效结束日
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    private Date endTime;

    /**
     * This field corresponds to the database column NEWT0_SDP_REMAIN_BALANCE.CAN_USE_QUOTA
     * column comments 可使用额度
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    private BigDecimal canUseQuota;

    /**
     * This field corresponds to the database column NEWT0_SDP_REMAIN_BALANCE.FROZEN_QUOTA
     * column comments 冻结额度
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    private BigDecimal frozenQuota;

    /**
     * This field corresponds to the database column NEWT0_SDP_REMAIN_BALANCE.USED_QUOTA
     * column comments 已使用额度
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    private BigDecimal usedQuota;

    /**
     * This method returns the value of the database column NEWT0_SDP_REMAIN_BALANCE.ID
     *
     * @return the value of NEWT0_SDP_REMAIN_BALANCE.ID
     * column comments null
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column NEWT0_SDP_REMAIN_BALANCE.ID
     *
     * @param id the value for NEWT0_SDP_REMAIN_BALANCE.ID
     * column comments null
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column NEWT0_SDP_REMAIN_BALANCE.START_TIME
     *
     * @return the value of NEWT0_SDP_REMAIN_BALANCE.START_TIME
     * column comments 生效开始日
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * This method sets the value of the database column NEWT0_SDP_REMAIN_BALANCE.START_TIME
     *
     * @param startTime the value for NEWT0_SDP_REMAIN_BALANCE.START_TIME
     * column comments 生效开始日
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * This method returns the value of the database column NEWT0_SDP_REMAIN_BALANCE.QUOTA
     *
     * @return the value of NEWT0_SDP_REMAIN_BALANCE.QUOTA
     * column comments 配资额度
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    public BigDecimal getQuota() {
        return quota;
    }

    /**
     * This method sets the value of the database column NEWT0_SDP_REMAIN_BALANCE.QUOTA
     *
     * @param quota the value for NEWT0_SDP_REMAIN_BALANCE.QUOTA
     * column comments 配资额度
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    public void setQuota(BigDecimal quota) {
        this.quota = quota;
    }

    /**
     * This method returns the value of the database column NEWT0_SDP_REMAIN_BALANCE.CREATE_TIME
     *
     * @return the value of NEWT0_SDP_REMAIN_BALANCE.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column NEWT0_SDP_REMAIN_BALANCE.CREATE_TIME
     *
     * @param createTime the value for NEWT0_SDP_REMAIN_BALANCE.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column NEWT0_SDP_REMAIN_BALANCE.UPDATE_TIME
     *
     * @return the value of NEWT0_SDP_REMAIN_BALANCE.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column NEWT0_SDP_REMAIN_BALANCE.UPDATE_TIME
     *
     * @param updateTime the value for NEWT0_SDP_REMAIN_BALANCE.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column NEWT0_SDP_REMAIN_BALANCE.END_TIME
     *
     * @return the value of NEWT0_SDP_REMAIN_BALANCE.END_TIME
     * column comments 生效结束日
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method sets the value of the database column NEWT0_SDP_REMAIN_BALANCE.END_TIME
     *
     * @param endTime the value for NEWT0_SDP_REMAIN_BALANCE.END_TIME
     * column comments 生效结束日
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method returns the value of the database column NEWT0_SDP_REMAIN_BALANCE.CAN_USE_QUOTA
     *
     * @return the value of NEWT0_SDP_REMAIN_BALANCE.CAN_USE_QUOTA
     * column comments 可使用额度
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    public BigDecimal getCanUseQuota() {
        return canUseQuota;
    }

    /**
     * This method sets the value of the database column NEWT0_SDP_REMAIN_BALANCE.CAN_USE_QUOTA
     *
     * @param canUseQuota the value for NEWT0_SDP_REMAIN_BALANCE.CAN_USE_QUOTA
     * column comments 可使用额度
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    public void setCanUseQuota(BigDecimal canUseQuota) {
        this.canUseQuota = canUseQuota;
    }

    /**
     * This method returns the value of the database column NEWT0_SDP_REMAIN_BALANCE.FROZEN_QUOTA
     *
     * @return the value of NEWT0_SDP_REMAIN_BALANCE.FROZEN_QUOTA
     * column comments 冻结额度
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    public BigDecimal getFrozenQuota() {
        return frozenQuota;
    }

    /**
     * This method sets the value of the database column NEWT0_SDP_REMAIN_BALANCE.FROZEN_QUOTA
     *
     * @param frozenQuota the value for NEWT0_SDP_REMAIN_BALANCE.FROZEN_QUOTA
     * column comments 冻结额度
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    public void setFrozenQuota(BigDecimal frozenQuota) {
        this.frozenQuota = frozenQuota;
    }

    /**
     * This method returns the value of the database column NEWT0_SDP_REMAIN_BALANCE.USED_QUOTA
     *
     * @return the value of NEWT0_SDP_REMAIN_BALANCE.USED_QUOTA
     * column comments 已使用额度
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    public BigDecimal getUsedQuota() {
        return usedQuota;
    }

    /**
     * This method sets the value of the database column NEWT0_SDP_REMAIN_BALANCE.USED_QUOTA
     *
     * @param usedQuota the value for NEWT0_SDP_REMAIN_BALANCE.USED_QUOTA
     * column comments 已使用额度
     *
     * @mbggenerated Mon Sep 21 15:21:33 CST 2015
     */
    public void setUsedQuota(BigDecimal usedQuota) {
        this.usedQuota = usedQuota;
    }
}