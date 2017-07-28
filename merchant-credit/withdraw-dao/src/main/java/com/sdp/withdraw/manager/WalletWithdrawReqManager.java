package com.sdp.withdraw.manager;

import com.sdp.withdraw.dao.WalletWithdrawReqDO;
import com.sdp.withdraw.dao.WalletWithdrawReqDOExample;
import java.util.List;

public interface WalletWithdrawReqManager {
    /**
     * 根据主键删除钱包出款请求表【WalletWithdrawReqDO】对象信息
     *
     * @mbggenerated Thu Nov 17 18:06:42 CST 2016
     */
    int deleteByPrimaryKey(Long reqId);

    /**
     * 添加钱包出款请求表【WalletWithdrawReqDO】对象信息
     *
     * @mbggenerated Thu Nov 17 18:06:42 CST 2016
     */
    Long insert(WalletWithdrawReqDO record);

    /**
     * 添加钱包出款请求表【WalletWithdrawReqDO】对象信息,空值字段不插入
     *
     * @mbggenerated Thu Nov 17 18:06:42 CST 2016
     */
    Long insertSelective(WalletWithdrawReqDO record);

    /**
     * 根据Example对象查询得到钱包出款请求表【WalletWithdrawReqDO】对象列表信息
     *
     * @mbggenerated Thu Nov 17 18:06:42 CST 2016
     */
    List<WalletWithdrawReqDO> selectByExample(WalletWithdrawReqDOExample example);

    /**
     * 根据主键查询钱包出款请求表【WalletWithdrawReqDO】对象信息
     *
     * @mbggenerated Thu Nov 17 18:06:42 CST 2016
     */
    WalletWithdrawReqDO selectByPrimaryKey(Long reqId);

    /**
     * 根据主键更新钱包出款请求表【WalletWithdrawReqDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Thu Nov 17 18:06:42 CST 2016
     */
    int updateByPrimaryKeySelective(WalletWithdrawReqDO record);

    /**
     * 根据主键更新钱包出款请求表【WalletWithdrawReqDO】对象信息
     *
     * @mbggenerated Thu Nov 17 18:06:42 CST 2016
     */
    int updateByPrimaryKey(WalletWithdrawReqDO record);

    /**
     * 根据Query对象分页查询钱包出款请求表【WalletWithdrawReqDO】对象列表信息
     *
     * @mbggenerated Thu Nov 17 18:06:42 CST 2016
     */
    List<WalletWithdrawReqDO> selectByQuery(WalletWithdrawReqDOExample example);
}