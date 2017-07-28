package com.sdp.withdraw.manager.impl;

import com.sdp.withdraw.dao.WithdrawRatioInfoDO;
import com.sdp.withdraw.dao.WithdrawRatioInfoDOExample;
import com.sdp.withdraw.dao.daointerface.WithdrawRatioInfoDAO;
import com.sdp.withdraw.manager.WithdrawRatioInfoManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("withdrawRatioInfoManager")
public class WithdrawRatioInfoManagerImpl implements WithdrawRatioInfoManager {
    @Autowired
    private WithdrawRatioInfoDAO withdrawRatioInfoDAO;

    /**
     * 根据主键删除提现出款费率信息【WithdrawRatioInfoDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        int rows = withdrawRatioInfoDAO.deleteByPrimaryKey(id);
        return rows;
    }

    /**
     * 添加提现出款费率信息【WithdrawRatioInfoDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    @Override
    public Long insert(WithdrawRatioInfoDO record) {
        Long id = withdrawRatioInfoDAO.insert(record);
        return record.getId();
    }

    /**
     * 添加提现出款费率信息【WithdrawRatioInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    @Override
    public Long insertSelective(WithdrawRatioInfoDO record) {
        Long id = withdrawRatioInfoDAO.insertSelective(record);
        return record.getId();
    }

    /**
     * 根据Example对象查询得到提现出款费率信息【WithdrawRatioInfoDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<WithdrawRatioInfoDO> selectByExample(WithdrawRatioInfoDOExample example) {
        List<WithdrawRatioInfoDO> list = withdrawRatioInfoDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询提现出款费率信息【WithdrawRatioInfoDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    @Override
    public WithdrawRatioInfoDO selectByPrimaryKey(Long id) {
        WithdrawRatioInfoDO record = withdrawRatioInfoDAO.selectByPrimaryKey(id);
        return record;
    }

    /**
     * 根据主键更新提现出款费率信息【WithdrawRatioInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    @Override
    public int updateByPrimaryKeySelective(WithdrawRatioInfoDO record) {
        int rows = withdrawRatioInfoDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新提现出款费率信息【WithdrawRatioInfoDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    @Override
    public int updateByPrimaryKey(WithdrawRatioInfoDO record) {
        int rows = withdrawRatioInfoDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询提现出款费率信息【WithdrawRatioInfoDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    @Override
    public List<WithdrawRatioInfoDO> selectByQuery(WithdrawRatioInfoDOExample example) {
        Integer totalItem = (Integer)withdrawRatioInfoDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<WithdrawRatioInfoDO> returnList = new ArrayList<WithdrawRatioInfoDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<WithdrawRatioInfoDO> list =withdrawRatioInfoDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}