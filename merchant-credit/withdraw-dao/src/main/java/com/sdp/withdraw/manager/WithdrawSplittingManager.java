package com.sdp.withdraw.manager;

import com.sdp.withdraw.dao.WithdrawSplittingDO;
import com.sdp.withdraw.dao.WithdrawSplittingDOExample;
import java.util.List;

public interface WithdrawSplittingManager {
    /**
     * 根据主键删除null【WithdrawSplittingDO】对象信息
     *
     * @mbggenerated Tue Jul 12 11:03:53 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加null【WithdrawSplittingDO】对象信息
     *
     * @mbggenerated Tue Jul 12 11:03:53 CST 2016
     */
    Long insert(WithdrawSplittingDO record);

    /**
     * 添加null【WithdrawSplittingDO】对象信息,空值字段不插入
     *
     * @mbggenerated Tue Jul 12 11:03:53 CST 2016
     */
    Long insertSelective(WithdrawSplittingDO record);

    /**
     * 根据Example对象查询得到null【WithdrawSplittingDO】对象列表信息
     *
     * @mbggenerated Tue Jul 12 11:03:53 CST 2016
     */
    List<WithdrawSplittingDO> selectByExample(WithdrawSplittingDOExample example);

    /**
     * 根据主键查询null【WithdrawSplittingDO】对象信息
     *
     * @mbggenerated Tue Jul 12 11:03:53 CST 2016
     */
    WithdrawSplittingDO selectByPrimaryKey(Long id);

    /**
     * 根据主键更新null【WithdrawSplittingDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Tue Jul 12 11:03:53 CST 2016
     */
    int updateByPrimaryKeySelective(WithdrawSplittingDO record);

    /**
     * 根据主键更新null【WithdrawSplittingDO】对象信息
     *
     * @mbggenerated Tue Jul 12 11:03:53 CST 2016
     */
    int updateByPrimaryKey(WithdrawSplittingDO record);

    /**
     * 根据Query对象分页查询null【WithdrawSplittingDO】对象列表信息
     *
     * @mbggenerated Tue Jul 12 11:03:53 CST 2016
     */
    List<WithdrawSplittingDO> selectByQuery(WithdrawSplittingDOExample example);
}