package com.sdp.withdraw.manager.impl;

import com.sdp.withdraw.dao.WithdrawCostConfigDO;
import com.sdp.withdraw.dao.WithdrawCostConfigDOExample;
import com.sdp.withdraw.dao.daointerface.WithdrawCostConfigDAO;
import com.sdp.withdraw.manager.WithdrawCostConfigManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("withdrawCostConfigManager")
public class WithdrawCostConfigManagerImpl implements WithdrawCostConfigManager {
    @Autowired
    private WithdrawCostConfigDAO withdrawCostConfigDAO;

    /**
     * 根据主键删除null【WithdrawCostConfigDO】对象信息
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        int rows = withdrawCostConfigDAO.deleteByPrimaryKey(id);
        return rows;
    }

    /**
     * 添加null【WithdrawCostConfigDO】对象信息
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    @Override
    public Long insert(WithdrawCostConfigDO record) {
        Long id = withdrawCostConfigDAO.insert(record);
        return record.getId();
    }

    /**
     * 添加null【WithdrawCostConfigDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    @Override
    public Long insertSelective(WithdrawCostConfigDO record) {
        Long id = withdrawCostConfigDAO.insertSelective(record);
        return record.getId();
    }

    /**
     * 根据Example对象查询得到null【WithdrawCostConfigDO】对象列表信息
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<WithdrawCostConfigDO> selectByExample(WithdrawCostConfigDOExample example) {
        List<WithdrawCostConfigDO> list = withdrawCostConfigDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询null【WithdrawCostConfigDO】对象信息
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    @Override
    public WithdrawCostConfigDO selectByPrimaryKey(Long id) {
        WithdrawCostConfigDO record = withdrawCostConfigDAO.selectByPrimaryKey(id);
        return record;
    }

    /**
     * 根据主键更新null【WithdrawCostConfigDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    @Override
    public int updateByPrimaryKeySelective(WithdrawCostConfigDO record) {
        int rows = withdrawCostConfigDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新null【WithdrawCostConfigDO】对象信息
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    @Override
    public int updateByPrimaryKey(WithdrawCostConfigDO record) {
        int rows = withdrawCostConfigDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询null【WithdrawCostConfigDO】对象列表信息
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    @Override
    public List<WithdrawCostConfigDO> selectByQuery(WithdrawCostConfigDOExample example) {
        Integer totalItem = (Integer)withdrawCostConfigDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<WithdrawCostConfigDO> returnList = new ArrayList<WithdrawCostConfigDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<WithdrawCostConfigDO> list =withdrawCostConfigDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}