package com.sdp.mc.config.manager;

import com.sdp.mc.config.dao.ConfigOptionDO;
import com.sdp.mc.config.dao.ConfigOptionDOExample;

import java.math.BigDecimal;
import java.util.List;

public interface ConfigOptionManager {
    /**
     * 根据主键删除null【ConfigOptionDO】对象信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    int deleteByPrimaryKey(Long optionId);

    /**
     * 添加null【ConfigOptionDO】对象信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    Long insert(ConfigOptionDO record);

    /**
     * 添加null【ConfigOptionDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    Long insertSelective(ConfigOptionDO record);

    /**
     * 根据Example对象查询得到null【ConfigOptionDO】对象列表信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    List<ConfigOptionDO> selectByExample(ConfigOptionDOExample example);

    /**
     * 根据主键查询null【ConfigOptionDO】对象信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    ConfigOptionDO selectByPrimaryKey(Long optionId);

    /**
     * 根据主键更新null【ConfigOptionDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    int updateByPrimaryKeySelective(ConfigOptionDO record);

    /**
     * 根据主键更新null【ConfigOptionDO】对象信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    int updateByPrimaryKey(ConfigOptionDO record);

    /**
     * 根据Query对象分页查询null【ConfigOptionDO】对象列表信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    List<ConfigOptionDO> selectByQuery(ConfigOptionDOExample example);
    
    /**
     * 根据key查询配置
     * **//*
    public String getConfigByKey(String key);
    *//**
     * 根据key查询配置
     * **//*
    public Long getLongByKey(String key);
    
    *//**
     * 根据key查询配置
     * **//*
    public boolean getBooleanByKey(String key);*/

	void loadConfigOption();

}