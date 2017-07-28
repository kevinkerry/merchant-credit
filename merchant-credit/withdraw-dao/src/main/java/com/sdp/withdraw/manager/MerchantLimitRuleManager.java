package com.sdp.withdraw.manager;

import com.sdp.withdraw.dao.MerchantLimitRuleDO;
import com.sdp.withdraw.dao.MerchantLimitRuleDOExample;
import java.util.List;

public interface MerchantLimitRuleManager {
    /**
     * 根据主键删除null【MerchantLimitRuleDO】对象信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加null【MerchantLimitRuleDO】对象信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    Long insert(MerchantLimitRuleDO record);

    /**
     * 添加null【MerchantLimitRuleDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    Long insertSelective(MerchantLimitRuleDO record);

    /**
     * 根据Example对象查询得到null【MerchantLimitRuleDO】对象列表信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    List<MerchantLimitRuleDO> selectByExample(MerchantLimitRuleDOExample example);

    /**
     * 根据主键查询null【MerchantLimitRuleDO】对象信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    MerchantLimitRuleDO selectByPrimaryKey(Long id);

    /**
     * 根据主键更新null【MerchantLimitRuleDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    int updateByPrimaryKeySelective(MerchantLimitRuleDO record);

    /**
     * 根据主键更新null【MerchantLimitRuleDO】对象信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    int updateByPrimaryKey(MerchantLimitRuleDO record);

    /**
     * 根据Query对象分页查询null【MerchantLimitRuleDO】对象列表信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    List<MerchantLimitRuleDO> selectByQuery(MerchantLimitRuleDOExample example);
}