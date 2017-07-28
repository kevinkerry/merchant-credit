package com.sdp.withdraw.manager;

import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqDOExample;
import java.util.List;

public interface WithdrawReqManager {
    /**
     * 根据主键删除出款业务请求表【WithdrawReqDO】对象信息
     *
     * @mbggenerated Tue May 31 10:37:35 CST 2016
     */
    int deleteByPrimaryKey(Long reqId);

    /**
     * 添加出款业务请求表【WithdrawReqDO】对象信息
     *
     * @mbggenerated Tue May 31 10:37:35 CST 2016
     */
    Long insert(WithdrawReqDO record);

    /**
     * 添加出款业务请求表【WithdrawReqDO】对象信息,空值字段不插入
     *
     * @mbggenerated Tue May 31 10:37:35 CST 2016
     */
    Long insertSelective(WithdrawReqDO record);

    /**
     * 根据Example对象查询得到出款业务请求表【WithdrawReqDO】对象列表信息
     *
     * @mbggenerated Tue May 31 10:37:35 CST 2016
     */
    List<WithdrawReqDO> selectByExample(WithdrawReqDOExample example);

    /**
     * 根据主键查询出款业务请求表【WithdrawReqDO】对象信息
     *
     * @mbggenerated Tue May 31 10:37:35 CST 2016
     */
    WithdrawReqDO selectByPrimaryKey(Long reqId);

    /**
     * 根据主键更新出款业务请求表【WithdrawReqDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Tue May 31 10:37:35 CST 2016
     */
    int updateByPrimaryKeySelective(WithdrawReqDO record);

    /**
     * 根据主键更新出款业务请求表【WithdrawReqDO】对象信息
     *
     * @mbggenerated Tue May 31 10:37:35 CST 2016
     */
    int updateByPrimaryKey(WithdrawReqDO record);

    /**
     * 根据Query对象分页查询出款业务请求表【WithdrawReqDO】对象列表信息
     *
     * @mbggenerated Tue May 31 10:37:35 CST 2016
     */
    List<WithdrawReqDO> selectByQuery(WithdrawReqDOExample example);
}