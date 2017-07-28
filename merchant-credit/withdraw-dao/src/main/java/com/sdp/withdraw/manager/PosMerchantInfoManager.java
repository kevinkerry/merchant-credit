package com.sdp.withdraw.manager;

import java.util.List;

import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.dao.PosMerchantInfoDOExample;

public interface PosMerchantInfoManager {
    /**
     * 根据主键删除POS商户信息【PosMerchantInfoDO】对象信息
     *
     * @mbggenerated Wed Mar 30 10:08:16 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加POS商户信息【PosMerchantInfoDO】对象信息
     *
     * @mbggenerated Wed Mar 30 10:08:16 CST 2016
     */
    Long insert(PosMerchantInfoDO record);

    /**
     * 添加POS商户信息【PosMerchantInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Mar 30 10:08:16 CST 2016
     */
    Long insertSelective(PosMerchantInfoDO record);

    /**
     * 根据Example对象查询得到POS商户信息【PosMerchantInfoDO】对象列表信息
     *
     * @mbggenerated Wed Mar 30 10:08:16 CST 2016
     */
    List<PosMerchantInfoDO> selectByExample(PosMerchantInfoDOExample example);

    /**
     * 根据主键查询POS商户信息【PosMerchantInfoDO】对象信息
     *
     * @mbggenerated Wed Mar 30 10:08:16 CST 2016
     */
    PosMerchantInfoDO selectByPrimaryKey(Long id);

    /**
     * 根据主键更新POS商户信息【PosMerchantInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Mar 30 10:08:16 CST 2016
     */
    int updateByPrimaryKeySelective(PosMerchantInfoDO record);

    /**
     * 根据主键更新POS商户信息【PosMerchantInfoDO】对象信息
     *
     * @mbggenerated Wed Mar 30 10:08:16 CST 2016
     */
    int updateByPrimaryKey(PosMerchantInfoDO record);

    /**
     * 根据Query对象分页查询POS商户信息【PosMerchantInfoDO】对象列表信息
     *
     * @mbggenerated Wed Mar 30 10:08:16 CST 2016
     */
    List<PosMerchantInfoDO> selectByQuery(PosMerchantInfoDOExample example);
}