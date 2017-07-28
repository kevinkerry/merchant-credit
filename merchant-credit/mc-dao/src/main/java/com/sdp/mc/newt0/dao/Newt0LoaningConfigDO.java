package com.sdp.mc.newt0.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.util.Date;

public class Newt0LoaningConfigDO extends BaseDO {
    /**
     * This field corresponds to the database column NEWT0_LOANING_CONFIG.ID
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    private Long id;

    /**
     * This field corresponds to the database column NEWT0_LOANING_CONFIG.LOANING_TYPE
     * column comments 垫资方类型
1：盛付通全资
2：代理商全资
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    private Integer loaningType;

    /**
     * This field corresponds to the database column NEWT0_LOANING_CONFIG.CONTENT
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    private String content;

    /**
     * This field corresponds to the database column NEWT0_LOANING_CONFIG.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    private Date createTime;

    /**
     * This field corresponds to the database column NEWT0_LOANING_CONFIG.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    private Date updateTime;

    /**
     * This method returns the value of the database column NEWT0_LOANING_CONFIG.ID
     *
     * @return the value of NEWT0_LOANING_CONFIG.ID
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column NEWT0_LOANING_CONFIG.ID
     *
     * @param id the value for NEWT0_LOANING_CONFIG.ID
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column NEWT0_LOANING_CONFIG.LOANING_TYPE
     *
     * @return the value of NEWT0_LOANING_CONFIG.LOANING_TYPE
     * column comments 垫资方类型
1：盛付通全资
2：代理商全资
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    public Integer getLoaningType() {
        return loaningType;
    }

    /**
     * This method sets the value of the database column NEWT0_LOANING_CONFIG.LOANING_TYPE
     *
     * @param loaningType the value for NEWT0_LOANING_CONFIG.LOANING_TYPE
     * column comments 垫资方类型
1：盛付通全资
2：代理商全资
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    public void setLoaningType(Integer loaningType) {
        this.loaningType = loaningType;
    }

    /**
     * This method returns the value of the database column NEWT0_LOANING_CONFIG.CONTENT
     *
     * @return the value of NEWT0_LOANING_CONFIG.CONTENT
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    public String getContent() {
        return content;
    }

    /**
     * This method sets the value of the database column NEWT0_LOANING_CONFIG.CONTENT
     *
     * @param content the value for NEWT0_LOANING_CONFIG.CONTENT
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method returns the value of the database column NEWT0_LOANING_CONFIG.CREATE_TIME
     *
     * @return the value of NEWT0_LOANING_CONFIG.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column NEWT0_LOANING_CONFIG.CREATE_TIME
     *
     * @param createTime the value for NEWT0_LOANING_CONFIG.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column NEWT0_LOANING_CONFIG.UPDATE_TIME
     *
     * @return the value of NEWT0_LOANING_CONFIG.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column NEWT0_LOANING_CONFIG.UPDATE_TIME
     *
     * @param updateTime the value for NEWT0_LOANING_CONFIG.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}