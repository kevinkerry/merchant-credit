package com.sdp.withdraw.manager.impl;

import com.sdp.withdraw.dao.WithdrawInfoDO;
import com.sdp.withdraw.dao.WithdrawInfoDOExample;
import com.sdp.withdraw.dao.daointerface.WithdrawInfoDAO;
import com.sdp.withdraw.manager.WithdrawInfoManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("withdrawInfoManager")
public class WithdrawInfoManagerImpl implements WithdrawInfoManager {
    @Autowired
    private WithdrawInfoDAO withdrawInfoDAO;

    /**
     * 根据主键删除提现出款额度信息【WithdrawInfoDO】对象信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        int rows = withdrawInfoDAO.deleteByPrimaryKey(id);
        return rows;
    }

    /**
     * 添加提现出款额度信息【WithdrawInfoDO】对象信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    @Override
    public Long insert(WithdrawInfoDO record) {
        Long id = withdrawInfoDAO.insert(record);
        return record.getId();
    }

    /**
     * 添加提现出款额度信息【WithdrawInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    @Override
    public Long insertSelective(WithdrawInfoDO record) {
        Long id = withdrawInfoDAO.insertSelective(record);
        return record.getId();
    }

    /**
     * 根据Example对象查询得到提现出款额度信息【WithdrawInfoDO】对象列表信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<WithdrawInfoDO> selectByExample(WithdrawInfoDOExample example) {
        List<WithdrawInfoDO> list = withdrawInfoDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询提现出款额度信息【WithdrawInfoDO】对象信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    @Override
    public WithdrawInfoDO selectByPrimaryKey(Long id) {
        WithdrawInfoDO record = withdrawInfoDAO.selectByPrimaryKey(id);
        return record;
    }

    /**
     * 根据主键更新提现出款额度信息【WithdrawInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    @Override
    public int updateByPrimaryKeySelective(WithdrawInfoDO record) {
        int rows = withdrawInfoDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新提现出款额度信息【WithdrawInfoDO】对象信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    @Override
    public int updateByPrimaryKey(WithdrawInfoDO record) {
        int rows = withdrawInfoDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询提现出款额度信息【WithdrawInfoDO】对象列表信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    @Override
    public List<WithdrawInfoDO> selectByQuery(WithdrawInfoDOExample example) {
        Integer totalItem = (Integer)withdrawInfoDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<WithdrawInfoDO> returnList = new ArrayList<WithdrawInfoDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<WithdrawInfoDO> list =withdrawInfoDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}