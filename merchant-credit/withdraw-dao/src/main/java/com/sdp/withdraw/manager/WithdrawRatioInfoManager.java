package com.sdp.withdraw.manager;

import com.sdp.withdraw.dao.WithdrawRatioInfoDO;
import com.sdp.withdraw.dao.WithdrawRatioInfoDOExample;
import java.util.List;

public interface WithdrawRatioInfoManager {
    /**
     * 根据主键删除提现出款费率信息【WithdrawRatioInfoDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加提现出款费率信息【WithdrawRatioInfoDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    Long insert(WithdrawRatioInfoDO record);

    /**
     * 添加提现出款费率信息【WithdrawRatioInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    Long insertSelective(WithdrawRatioInfoDO record);

    /**
     * 根据Example对象查询得到提现出款费率信息【WithdrawRatioInfoDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    List<WithdrawRatioInfoDO> selectByExample(WithdrawRatioInfoDOExample example);

    /**
     * 根据主键查询提现出款费率信息【WithdrawRatioInfoDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    WithdrawRatioInfoDO selectByPrimaryKey(Long id);

    /**
     * 根据主键更新提现出款费率信息【WithdrawRatioInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    int updateByPrimaryKeySelective(WithdrawRatioInfoDO record);

    /**
     * 根据主键更新提现出款费率信息【WithdrawRatioInfoDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    int updateByPrimaryKey(WithdrawRatioInfoDO record);

    /**
     * 根据Query对象分页查询提现出款费率信息【WithdrawRatioInfoDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    List<WithdrawRatioInfoDO> selectByQuery(WithdrawRatioInfoDOExample example);
}