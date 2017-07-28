package com.sdp.withdraw.manager.impl;

import com.sdp.withdraw.dao.WalletWithdrawReqDO;
import com.sdp.withdraw.dao.WalletWithdrawReqDOExample;
import com.sdp.withdraw.dao.daointerface.WalletWithdrawReqDAO;
import com.sdp.withdraw.manager.WalletWithdrawReqManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("walletWithdrawReqManager")
public class WalletWithdrawReqManagerImpl implements WalletWithdrawReqManager {
    @Autowired
    private WalletWithdrawReqDAO walletWithdrawReqDAO;

    /**
     * 根据主键删除钱包出款请求表【WalletWithdrawReqDO】对象信息
     *
     * @mbggenerated Thu Nov 17 18:06:42 CST 2016
     */
    @Override
    public int deleteByPrimaryKey(Long reqId) {
        int rows = walletWithdrawReqDAO.deleteByPrimaryKey(reqId);
        return rows;
    }

    /**
     * 添加钱包出款请求表【WalletWithdrawReqDO】对象信息
     *
     * @mbggenerated Thu Nov 17 18:06:42 CST 2016
     */
    @Override
    public Long insert(WalletWithdrawReqDO record) {
        Long id = walletWithdrawReqDAO.insert(record);
        return record.getReqId();
    }

    /**
     * 添加钱包出款请求表【WalletWithdrawReqDO】对象信息,空值字段不插入
     *
     * @mbggenerated Thu Nov 17 18:06:42 CST 2016
     */
    @Override
    public Long insertSelective(WalletWithdrawReqDO record) {
        Long id = walletWithdrawReqDAO.insertSelective(record);
        return record.getReqId();
    }

    /**
     * 根据Example对象查询得到钱包出款请求表【WalletWithdrawReqDO】对象列表信息
     *
     * @mbggenerated Thu Nov 17 18:06:42 CST 2016
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<WalletWithdrawReqDO> selectByExample(WalletWithdrawReqDOExample example) {
        List<WalletWithdrawReqDO> list = walletWithdrawReqDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询钱包出款请求表【WalletWithdrawReqDO】对象信息
     *
     * @mbggenerated Thu Nov 17 18:06:42 CST 2016
     */
    @Override
    public WalletWithdrawReqDO selectByPrimaryKey(Long reqId) {
        WalletWithdrawReqDO record = walletWithdrawReqDAO.selectByPrimaryKey(reqId);
        return record;
    }

    /**
     * 根据主键更新钱包出款请求表【WalletWithdrawReqDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Thu Nov 17 18:06:42 CST 2016
     */
    @Override
    public int updateByPrimaryKeySelective(WalletWithdrawReqDO record) {
        int rows = walletWithdrawReqDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新钱包出款请求表【WalletWithdrawReqDO】对象信息
     *
     * @mbggenerated Thu Nov 17 18:06:42 CST 2016
     */
    @Override
    public int updateByPrimaryKey(WalletWithdrawReqDO record) {
        int rows = walletWithdrawReqDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询钱包出款请求表【WalletWithdrawReqDO】对象列表信息
     *
     * @mbggenerated Thu Nov 17 18:06:42 CST 2016
     */
    @Override
    public List<WalletWithdrawReqDO> selectByQuery(WalletWithdrawReqDOExample example) {
        Integer totalItem = (Integer)walletWithdrawReqDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<WalletWithdrawReqDO> returnList = new ArrayList<WalletWithdrawReqDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<WalletWithdrawReqDO> list =walletWithdrawReqDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}