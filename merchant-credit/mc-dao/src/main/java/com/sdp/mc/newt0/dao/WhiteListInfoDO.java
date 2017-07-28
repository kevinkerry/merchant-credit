package com.sdp.mc.newt0.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.util.Date;

public class WhiteListInfoDO extends BaseDO {
    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.ID
     * column comments 主键ID
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private Long id;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.TYPE
     * column comments 白名单类型
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private Integer type;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.TYPE_NAME
     * column comments 类型名称
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private String typeName;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.MERCHANT_NO
     * column comments 商户号/代理商商户号
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private String merchantNo;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.MERCHANT_TYPE
     * column comments 商户类型/代理商商户类型
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private String merchantType;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.CONTENT
     * column comments 白名单内容
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private String content;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.CREATE_USER
     * column comments 创建的用户
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private String createUser;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.UPDATE_USER
     * column comments 更新的用户
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private String updateUser;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.STATUS
     * column comments 白名单状态 1 生效  0：失效
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private Integer status;

    /**
     * This method returns the value of the database column TB_WHITE_LIST_INFO.ID
     *
     * @return the value of TB_WHITE_LIST_INFO.ID
     * column comments 主键ID
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column TB_WHITE_LIST_INFO.ID
     *
     * @param id the value for TB_WHITE_LIST_INFO.ID
     * column comments 主键ID
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column TB_WHITE_LIST_INFO.TYPE
     *
     * @return the value of TB_WHITE_LIST_INFO.TYPE
     * column comments 白名单类型
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method sets the value of the database column TB_WHITE_LIST_INFO.TYPE
     *
     * @param type the value for TB_WHITE_LIST_INFO.TYPE
     * column comments 白名单类型
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method returns the value of the database column TB_WHITE_LIST_INFO.TYPE_NAME
     *
     * @return the value of TB_WHITE_LIST_INFO.TYPE_NAME
     * column comments 类型名称
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * This method sets the value of the database column TB_WHITE_LIST_INFO.TYPE_NAME
     *
     * @param typeName the value for TB_WHITE_LIST_INFO.TYPE_NAME
     * column comments 类型名称
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * This method returns the value of the database column TB_WHITE_LIST_INFO.MERCHANT_NO
     *
     * @return the value of TB_WHITE_LIST_INFO.MERCHANT_NO
     * column comments 商户号/代理商商户号
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * This method sets the value of the database column TB_WHITE_LIST_INFO.MERCHANT_NO
     *
     * @param merchantNo the value for TB_WHITE_LIST_INFO.MERCHANT_NO
     * column comments 商户号/代理商商户号
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * This method returns the value of the database column TB_WHITE_LIST_INFO.MERCHANT_TYPE
     *
     * @return the value of TB_WHITE_LIST_INFO.MERCHANT_TYPE
     * column comments 商户类型/代理商商户类型
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public String getMerchantType() {
        return merchantType;
    }

    /**
     * This method sets the value of the database column TB_WHITE_LIST_INFO.MERCHANT_TYPE
     *
     * @param merchantType the value for TB_WHITE_LIST_INFO.MERCHANT_TYPE
     * column comments 商户类型/代理商商户类型
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType == null ? null : merchantType.trim();
    }

    /**
     * This method returns the value of the database column TB_WHITE_LIST_INFO.CONTENT
     *
     * @return the value of TB_WHITE_LIST_INFO.CONTENT
     * column comments 白名单内容
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public String getContent() {
        return content;
    }

    /**
     * This method sets the value of the database column TB_WHITE_LIST_INFO.CONTENT
     *
     * @param content the value for TB_WHITE_LIST_INFO.CONTENT
     * column comments 白名单内容
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method returns the value of the database column TB_WHITE_LIST_INFO.CREATE_TIME
     *
     * @return the value of TB_WHITE_LIST_INFO.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column TB_WHITE_LIST_INFO.CREATE_TIME
     *
     * @param createTime the value for TB_WHITE_LIST_INFO.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column TB_WHITE_LIST_INFO.UPDATE_TIME
     *
     * @return the value of TB_WHITE_LIST_INFO.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column TB_WHITE_LIST_INFO.UPDATE_TIME
     *
     * @param updateTime the value for TB_WHITE_LIST_INFO.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column TB_WHITE_LIST_INFO.CREATE_USER
     *
     * @return the value of TB_WHITE_LIST_INFO.CREATE_USER
     * column comments 创建的用户
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * This method sets the value of the database column TB_WHITE_LIST_INFO.CREATE_USER
     *
     * @param createUser the value for TB_WHITE_LIST_INFO.CREATE_USER
     * column comments 创建的用户
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * This method returns the value of the database column TB_WHITE_LIST_INFO.UPDATE_USER
     *
     * @return the value of TB_WHITE_LIST_INFO.UPDATE_USER
     * column comments 更新的用户
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * This method sets the value of the database column TB_WHITE_LIST_INFO.UPDATE_USER
     *
     * @param updateUser the value for TB_WHITE_LIST_INFO.UPDATE_USER
     * column comments 更新的用户
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * This method returns the value of the database column TB_WHITE_LIST_INFO.STATUS
     *
     * @return the value of TB_WHITE_LIST_INFO.STATUS
     * column comments 白名单状态 1 生效  0：失效
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column TB_WHITE_LIST_INFO.STATUS
     *
     * @param status the value for TB_WHITE_LIST_INFO.STATUS
     * column comments 白名单状态 1 生效  0：失效
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}