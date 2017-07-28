package com.sdp.mc.config.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.util.Date;

public class ConfigOptionDO extends BaseDO {
    /**
     * This field corresponds to the database column TB_CONFIG_OPTION.OPTION_ID
     * column comments null
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    private Long optionId;

    /**
     * This field corresponds to the database column TB_CONFIG_OPTION.OPTION_KEY
     * column comments 配置项KEY
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    private String optionKey;

    /**
     * This field corresponds to the database column TB_CONFIG_OPTION.OPTION_VALUE
     * column comments 配置项值
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    private String optionValue;

    /**
     * This field corresponds to the database column TB_CONFIG_OPTION.OPTION_DEF_VALUE
     * column comments 配置默认值
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    private String optionDefValue;

    /**
     * This field corresponds to the database column TB_CONFIG_OPTION.OPTION_DESC
     * column comments 描述
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    private String optionDesc;

    /**
     * This field corresponds to the database column TB_CONFIG_OPTION.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    private Date createTime;

    /**
     * This field corresponds to the database column TB_CONFIG_OPTION.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    private Date updateTime;

    /**
     * This method returns the value of the database column TB_CONFIG_OPTION.OPTION_ID
     *
     * @return the value of TB_CONFIG_OPTION.OPTION_ID
     * column comments null
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public Long getOptionId() {
        return optionId;
    }

    /**
     * This method sets the value of the database column TB_CONFIG_OPTION.OPTION_ID
     *
     * @param optionId the value for TB_CONFIG_OPTION.OPTION_ID
     * column comments null
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    /**
     * This method returns the value of the database column TB_CONFIG_OPTION.OPTION_KEY
     *
     * @return the value of TB_CONFIG_OPTION.OPTION_KEY
     * column comments 配置项KEY
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public String getOptionKey() {
        return optionKey;
    }

    /**
     * This method sets the value of the database column TB_CONFIG_OPTION.OPTION_KEY
     *
     * @param optionKey the value for TB_CONFIG_OPTION.OPTION_KEY
     * column comments 配置项KEY
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public void setOptionKey(String optionKey) {
        this.optionKey = optionKey == null ? null : optionKey.trim();
    }

    /**
     * This method returns the value of the database column TB_CONFIG_OPTION.OPTION_VALUE
     *
     * @return the value of TB_CONFIG_OPTION.OPTION_VALUE
     * column comments 配置项值
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public String getOptionValue() {
        return optionValue;
    }

    /**
     * This method sets the value of the database column TB_CONFIG_OPTION.OPTION_VALUE
     *
     * @param optionValue the value for TB_CONFIG_OPTION.OPTION_VALUE
     * column comments 配置项值
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue == null ? null : optionValue.trim();
    }

    /**
     * This method returns the value of the database column TB_CONFIG_OPTION.OPTION_DEF_VALUE
     *
     * @return the value of TB_CONFIG_OPTION.OPTION_DEF_VALUE
     * column comments 配置默认值
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public String getOptionDefValue() {
        return optionDefValue;
    }

    /**
     * This method sets the value of the database column TB_CONFIG_OPTION.OPTION_DEF_VALUE
     *
     * @param optionDefValue the value for TB_CONFIG_OPTION.OPTION_DEF_VALUE
     * column comments 配置默认值
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public void setOptionDefValue(String optionDefValue) {
        this.optionDefValue = optionDefValue == null ? null : optionDefValue.trim();
    }

    /**
     * This method returns the value of the database column TB_CONFIG_OPTION.OPTION_DESC
     *
     * @return the value of TB_CONFIG_OPTION.OPTION_DESC
     * column comments 描述
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public String getOptionDesc() {
        return optionDesc;
    }

    /**
     * This method sets the value of the database column TB_CONFIG_OPTION.OPTION_DESC
     *
     * @param optionDesc the value for TB_CONFIG_OPTION.OPTION_DESC
     * column comments 描述
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public void setOptionDesc(String optionDesc) {
        this.optionDesc = optionDesc == null ? null : optionDesc.trim();
    }

    /**
     * This method returns the value of the database column TB_CONFIG_OPTION.CREATE_TIME
     *
     * @return the value of TB_CONFIG_OPTION.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column TB_CONFIG_OPTION.CREATE_TIME
     *
     * @param createTime the value for TB_CONFIG_OPTION.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column TB_CONFIG_OPTION.UPDATE_TIME
     *
     * @return the value of TB_CONFIG_OPTION.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column TB_CONFIG_OPTION.UPDATE_TIME
     *
     * @param updateTime the value for TB_CONFIG_OPTION.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}