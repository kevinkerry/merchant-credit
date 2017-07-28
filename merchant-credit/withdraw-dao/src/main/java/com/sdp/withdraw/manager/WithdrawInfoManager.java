package com.sdp.withdraw.manager;

import com.sdp.withdraw.dao.WithdrawInfoDO;
import com.sdp.withdraw.dao.WithdrawInfoDOExample;
import java.util.List;

public interface WithdrawInfoManager {
    /**
     * 根据主键删除提现出款额度信息【WithdrawInfoDO】对象信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加提现出款额度信息【WithdrawInfoDO】对象信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    Long insert(WithdrawInfoDO record);

    /**
     * 添加提现出款额度信息【WithdrawInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    Long insertSelective(WithdrawInfoDO record);

    /**
     * 根据Example对象查询得到提现出款额度信息【WithdrawInfoDO】对象列表信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    List<WithdrawInfoDO> selectByExample(WithdrawInfoDOExample example);

    /**
     * 根据主键查询提现出款额度信息【WithdrawInfoDO】对象信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    WithdrawInfoDO selectByPrimaryKey(Long id);

    /**
     * 根据主键更新提现出款额度信息【WithdrawInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    int updateByPrimaryKeySelective(WithdrawInfoDO record);

    /**
     * 根据主键更新提现出款额度信息【WithdrawInfoDO】对象信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    int updateByPrimaryKey(WithdrawInfoDO record);

    /**
     * 根据Query对象分页查询提现出款额度信息【WithdrawInfoDO】对象列表信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    List<WithdrawInfoDO> selectByQuery(WithdrawInfoDOExample example);
}