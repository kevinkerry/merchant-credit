package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.math.BigDecimal;
import java.util.Date;

public class WithdrawInfoDO extends BaseDO {
    /**
     * This field corresponds to the database column FW_WITHDRAW_INFO.ID
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    private Long id;

    /**
     * This field corresponds to the database column FW_WITHDRAW_INFO.LIMITATION_TYPE
     * column comments 额度类型
快速结算提现额度：0；
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    private Integer limitationType;

    /**
     * This field corresponds to the database column FW_WITHDRAW_INFO.BIZ_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    private Long bizId;

    /**
     * This field corresponds to the database column FW_WITHDRAW_INFO.BIZ_TYPE
     * column comments 
POS商户/POS代理商：1；
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    private Integer bizType;

    /**
     * This field corresponds to the database column FW_WITHDRAW_INFO.LIMITATION
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    private BigDecimal limitation;

    /**
     * This field corresponds to the database column FW_WITHDRAW_INFO.FORZEN_LIMITATION
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    private BigDecimal forzenLimitation;

    /**
     * This field corresponds to the database column FW_WITHDRAW_INFO.USED_LIMITATION
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    private BigDecimal usedLimitation;

    /**
     * This field corresponds to the database column FW_WITHDRAW_INFO.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    private Date updateTime;

    /**
     * This method returns the value of the database column FW_WITHDRAW_INFO.ID
     *
     * @return the value of FW_WITHDRAW_INFO.ID
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_INFO.ID
     *
     * @param id the value for FW_WITHDRAW_INFO.ID
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_INFO.LIMITATION_TYPE
     *
     * @return the value of FW_WITHDRAW_INFO.LIMITATION_TYPE
     * column comments 额度类型
快速结算提现额度：0；
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public Integer getLimitationType() {
        return limitationType;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_INFO.LIMITATION_TYPE
     *
     * @param limitationType the value for FW_WITHDRAW_INFO.LIMITATION_TYPE
     * column comments 额度类型
快速结算提现额度：0；
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public void setLimitationType(Integer limitationType) {
        this.limitationType = limitationType;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_INFO.BIZ_ID
     *
     * @return the value of FW_WITHDRAW_INFO.BIZ_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public Long getBizId() {
        return bizId;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_INFO.BIZ_ID
     *
     * @param bizId the value for FW_WITHDRAW_INFO.BIZ_ID
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_INFO.BIZ_TYPE
     *
     * @return the value of FW_WITHDRAW_INFO.BIZ_TYPE
     * column comments 
POS商户/POS代理商：1；
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public Integer getBizType() {
        return bizType;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_INFO.BIZ_TYPE
     *
     * @param bizType the value for FW_WITHDRAW_INFO.BIZ_TYPE
     * column comments 
POS商户/POS代理商：1；
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_INFO.LIMITATION
     *
     * @return the value of FW_WITHDRAW_INFO.LIMITATION
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public BigDecimal getLimitation() {
        return limitation;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_INFO.LIMITATION
     *
     * @param limitation the value for FW_WITHDRAW_INFO.LIMITATION
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public void setLimitation(BigDecimal limitation) {
        this.limitation = limitation;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_INFO.FORZEN_LIMITATION
     *
     * @return the value of FW_WITHDRAW_INFO.FORZEN_LIMITATION
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public BigDecimal getForzenLimitation() {
        return forzenLimitation;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_INFO.FORZEN_LIMITATION
     *
     * @param forzenLimitation the value for FW_WITHDRAW_INFO.FORZEN_LIMITATION
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public void setForzenLimitation(BigDecimal forzenLimitation) {
        this.forzenLimitation = forzenLimitation;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_INFO.USED_LIMITATION
     *
     * @return the value of FW_WITHDRAW_INFO.USED_LIMITATION
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public BigDecimal getUsedLimitation() {
        return usedLimitation;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_INFO.USED_LIMITATION
     *
     * @param usedLimitation the value for FW_WITHDRAW_INFO.USED_LIMITATION
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public void setUsedLimitation(BigDecimal usedLimitation) {
        this.usedLimitation = usedLimitation;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_INFO.CREATE_TIME
     *
     * @return the value of FW_WITHDRAW_INFO.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_INFO.CREATE_TIME
     *
     * @param createTime the value for FW_WITHDRAW_INFO.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_INFO.UPDATE_TIME
     *
     * @return the value of FW_WITHDRAW_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_INFO.UPDATE_TIME
     *
     * @param updateTime the value for FW_WITHDRAW_INFO.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}