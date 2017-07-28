package com.sdp.withdraw.manager;

import com.sdp.withdraw.dao.MerchantSettleAttrDO;
import com.sdp.withdraw.dao.MerchantSettleAttrDOExample;
import java.util.List;

public interface MerchantSettleAttrManager {
    /**
     * 根据主键删除业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    Long insert(MerchantSettleAttrDO record);

    /**
     * 添加业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    Long insertSelective(MerchantSettleAttrDO record);

    /**
     * 根据Example对象查询得到业务首次开通时间配置信息【MerchantSettleAttrDO】对象列表信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    List<MerchantSettleAttrDO> selectByExample(MerchantSettleAttrDOExample example);

    /**
     * 根据主键查询业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    MerchantSettleAttrDO selectByPrimaryKey(Long id);

    /**
     * 根据主键更新业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    int updateByPrimaryKeySelective(MerchantSettleAttrDO record);

    /**
     * 根据主键更新业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    int updateByPrimaryKey(MerchantSettleAttrDO record);

    /**
     * 根据Query对象分页查询业务首次开通时间配置信息【MerchantSettleAttrDO】对象列表信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    List<MerchantSettleAttrDO> selectByQuery(MerchantSettleAttrDOExample example);
}