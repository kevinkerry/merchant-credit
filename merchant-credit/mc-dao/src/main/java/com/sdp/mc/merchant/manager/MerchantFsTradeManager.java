package com.sdp.mc.merchant.manager;

import com.sdp.mc.merchant.dao.MerchantFsTradeDO;
import com.sdp.mc.merchant.dao.MerchantFsTradeDOExample;
import java.util.List;

public interface MerchantFsTradeManager {
    /**
     * 根据主键删除null【MerchantFsTradeDO】对象信息
     *
     * @mbggenerated Wed Apr 15 20:57:54 CST 2015
     */
    int deleteByPrimaryKey(Long mftId);

    /**
     * 添加null【MerchantFsTradeDO】对象信息
     *
     * @mbggenerated Wed Apr 15 20:57:54 CST 2015
     */
    Long insert(MerchantFsTradeDO record);

    /**
     * 添加null【MerchantFsTradeDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Apr 15 20:57:54 CST 2015
     */
    Long insertSelective(MerchantFsTradeDO record);

    /**
     * 根据Example对象查询得到null【MerchantFsTradeDO】对象列表信息
     *
     * @mbggenerated Wed Apr 15 20:57:54 CST 2015
     */
    List<MerchantFsTradeDO> selectByExample(MerchantFsTradeDOExample example);

    /**
     * 根据主键查询null【MerchantFsTradeDO】对象信息
     *
     * @mbggenerated Wed Apr 15 20:57:54 CST 2015
     */
    MerchantFsTradeDO selectByPrimaryKey(Long mftId);

    /**
     * 根据主键更新null【MerchantFsTradeDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Apr 15 20:57:54 CST 2015
     */
    int updateByPrimaryKeySelective(MerchantFsTradeDO record);

    /**
     * 根据主键更新null【MerchantFsTradeDO】对象信息
     *
     * @mbggenerated Wed Apr 15 20:57:54 CST 2015
     */
    int updateByPrimaryKey(MerchantFsTradeDO record);

    /**
     * 根据Query对象分页查询null【MerchantFsTradeDO】对象列表信息
     *
     * @mbggenerated Wed Apr 15 20:57:54 CST 2015
     */
    List<MerchantFsTradeDO> selectByQuery(MerchantFsTradeDOExample example);
}