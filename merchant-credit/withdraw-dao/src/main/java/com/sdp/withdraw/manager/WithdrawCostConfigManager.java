package com.sdp.withdraw.manager;

import com.sdp.withdraw.dao.WithdrawCostConfigDO;
import com.sdp.withdraw.dao.WithdrawCostConfigDOExample;
import java.util.List;

public interface WithdrawCostConfigManager {
    /**
     * 根据主键删除null【WithdrawCostConfigDO】对象信息
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加null【WithdrawCostConfigDO】对象信息
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    Long insert(WithdrawCostConfigDO record);

    /**
     * 添加null【WithdrawCostConfigDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    Long insertSelective(WithdrawCostConfigDO record);

    /**
     * 根据Example对象查询得到null【WithdrawCostConfigDO】对象列表信息
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    List<WithdrawCostConfigDO> selectByExample(WithdrawCostConfigDOExample example);

    /**
     * 根据主键查询null【WithdrawCostConfigDO】对象信息
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    WithdrawCostConfigDO selectByPrimaryKey(Long id);

    /**
     * 根据主键更新null【WithdrawCostConfigDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    int updateByPrimaryKeySelective(WithdrawCostConfigDO record);

    /**
     * 根据主键更新null【WithdrawCostConfigDO】对象信息
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    int updateByPrimaryKey(WithdrawCostConfigDO record);

    /**
     * 根据Query对象分页查询null【WithdrawCostConfigDO】对象列表信息
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    List<WithdrawCostConfigDO> selectByQuery(WithdrawCostConfigDOExample example);
}