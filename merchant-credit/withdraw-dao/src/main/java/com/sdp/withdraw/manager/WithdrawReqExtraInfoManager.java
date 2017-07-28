package com.sdp.withdraw.manager;

import com.sdp.withdraw.dao.WithdrawReqExtraInfoDO;
import com.sdp.withdraw.dao.WithdrawReqExtraInfoDOExample;
import java.util.List;

public interface WithdrawReqExtraInfoManager {
    /**
     * 根据主键删除出款扩展信息【WithdrawReqExtraInfoDO】对象信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加出款扩展信息【WithdrawReqExtraInfoDO】对象信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    Long insert(WithdrawReqExtraInfoDO record);

    /**
     * 添加出款扩展信息【WithdrawReqExtraInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    Long insertSelective(WithdrawReqExtraInfoDO record);

    /**
     * 根据Example对象查询得到出款扩展信息【WithdrawReqExtraInfoDO】对象列表信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    List<WithdrawReqExtraInfoDO> selectByExample(WithdrawReqExtraInfoDOExample example);

    /**
     * 根据主键查询出款扩展信息【WithdrawReqExtraInfoDO】对象信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    WithdrawReqExtraInfoDO selectByPrimaryKey(Long id);

    /**
     * 根据主键更新出款扩展信息【WithdrawReqExtraInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    int updateByPrimaryKeySelective(WithdrawReqExtraInfoDO record);

    /**
     * 根据主键更新出款扩展信息【WithdrawReqExtraInfoDO】对象信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    int updateByPrimaryKey(WithdrawReqExtraInfoDO record);

    /**
     * 根据Query对象分页查询出款扩展信息【WithdrawReqExtraInfoDO】对象列表信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    List<WithdrawReqExtraInfoDO> selectByQuery(WithdrawReqExtraInfoDOExample example);
}