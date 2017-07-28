package com.sdp.mc.newt0.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.util.Date;

public class NewT0UserOperaRecordDO extends BaseDO {
    /**
     * This field corresponds to the database column NEWT0_USEROPERA_RECORD.ID
     * column comments ID
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    private Long id;

    /**
     * This field corresponds to the database column NEWT0_USEROPERA_RECORD.BIZ_ID
     * column comments 业务操作ID
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    private Long bizId;

    /**
     * This field corresponds to the database column NEWT0_USEROPERA_RECORD.REALNAME
     * column comments 放款人名称
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    private String realname;

    /**
     * This field corresponds to the database column NEWT0_USEROPERA_RECORD.USERNAME
     * column comments 放款人ID
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    private String username;

    /**
     * This field corresponds to the database column NEWT0_USEROPERA_RECORD.BIZ_TYPE
     * column comments 业务操作类型(1:保证金取回操作 1:待定义)
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    private Long bizType;

    /**
     * This field corresponds to the database column NEWT0_USEROPERA_RECORD.OPERA_TIME
     * column comments 操作时间
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    private Date operaTime;

    /**
     * This field corresponds to the database column NEWT0_USEROPERA_RECORD.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    private Date createTime;

    /**
     * This field corresponds to the database column NEWT0_USEROPERA_RECORD.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    private Date updateTime;

    /**
     * This method returns the value of the database column NEWT0_USEROPERA_RECORD.ID
     *
     * @return the value of NEWT0_USEROPERA_RECORD.ID
     * column comments ID
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column NEWT0_USEROPERA_RECORD.ID
     *
     * @param id the value for NEWT0_USEROPERA_RECORD.ID
     * column comments ID
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column NEWT0_USEROPERA_RECORD.BIZ_ID
     *
     * @return the value of NEWT0_USEROPERA_RECORD.BIZ_ID
     * column comments 业务操作ID
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public Long getBizId() {
        return bizId;
    }

    /**
     * This method sets the value of the database column NEWT0_USEROPERA_RECORD.BIZ_ID
     *
     * @param bizId the value for NEWT0_USEROPERA_RECORD.BIZ_ID
     * column comments 业务操作ID
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    /**
     * This method returns the value of the database column NEWT0_USEROPERA_RECORD.REALNAME
     *
     * @return the value of NEWT0_USEROPERA_RECORD.REALNAME
     * column comments 放款人名称
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public String getRealname() {
        return realname;
    }

    /**
     * This method sets the value of the database column NEWT0_USEROPERA_RECORD.REALNAME
     *
     * @param realname the value for NEWT0_USEROPERA_RECORD.REALNAME
     * column comments 放款人名称
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * This method returns the value of the database column NEWT0_USEROPERA_RECORD.USERNAME
     *
     * @return the value of NEWT0_USEROPERA_RECORD.USERNAME
     * column comments 放款人ID
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method sets the value of the database column NEWT0_USEROPERA_RECORD.USERNAME
     *
     * @param username the value for NEWT0_USEROPERA_RECORD.USERNAME
     * column comments 放款人ID
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method returns the value of the database column NEWT0_USEROPERA_RECORD.BIZ_TYPE
     *
     * @return the value of NEWT0_USEROPERA_RECORD.BIZ_TYPE
     * column comments 业务操作类型(1:保证金取回操作 1:待定义)
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public Long getBizType() {
        return bizType;
    }

    /**
     * This method sets the value of the database column NEWT0_USEROPERA_RECORD.BIZ_TYPE
     *
     * @param bizType the value for NEWT0_USEROPERA_RECORD.BIZ_TYPE
     * column comments 业务操作类型(1:保证金取回操作 1:待定义)
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public void setBizType(Long bizType) {
        this.bizType = bizType;
    }

    /**
     * This method returns the value of the database column NEWT0_USEROPERA_RECORD.OPERA_TIME
     *
     * @return the value of NEWT0_USEROPERA_RECORD.OPERA_TIME
     * column comments 操作时间
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public Date getOperaTime() {
        return operaTime;
    }

    /**
     * This method sets the value of the database column NEWT0_USEROPERA_RECORD.OPERA_TIME
     *
     * @param operaTime the value for NEWT0_USEROPERA_RECORD.OPERA_TIME
     * column comments 操作时间
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public void setOperaTime(Date operaTime) {
        this.operaTime = operaTime;
    }

    /**
     * This method returns the value of the database column NEWT0_USEROPERA_RECORD.CREATE_TIME
     *
     * @return the value of NEWT0_USEROPERA_RECORD.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column NEWT0_USEROPERA_RECORD.CREATE_TIME
     *
     * @param createTime the value for NEWT0_USEROPERA_RECORD.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column NEWT0_USEROPERA_RECORD.UPDATE_TIME
     *
     * @return the value of NEWT0_USEROPERA_RECORD.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column NEWT0_USEROPERA_RECORD.UPDATE_TIME
     *
     * @param updateTime the value for NEWT0_USEROPERA_RECORD.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}