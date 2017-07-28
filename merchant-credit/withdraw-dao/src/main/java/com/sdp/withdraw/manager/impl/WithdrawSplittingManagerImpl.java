package com.sdp.withdraw.manager.impl;

import com.sdp.withdraw.dao.WithdrawSplittingDO;
import com.sdp.withdraw.dao.WithdrawSplittingDOExample;
import com.sdp.withdraw.dao.daointerface.WithdrawSplittingDAO;
import com.sdp.withdraw.manager.WithdrawSplittingManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("withdrawSplittingManager")
public class WithdrawSplittingManagerImpl implements WithdrawSplittingManager {
    @Autowired
    private WithdrawSplittingDAO withdrawSplittingDAO;

    /**
     * 根据主键删除null【WithdrawSplittingDO】对象信息
     *
     * @mbggenerated Tue Jul 12 11:03:53 CST 2016
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        int rows = withdrawSplittingDAO.deleteByPrimaryKey(id);
        return rows;
    }

    /**
     * 添加null【WithdrawSplittingDO】对象信息
     *
     * @mbggenerated Tue Jul 12 11:03:53 CST 2016
     */
    @Override
    public Long insert(WithdrawSplittingDO record) {
        Long id = withdrawSplittingDAO.insert(record);
        return record.getId();
    }

    /**
     * 添加null【WithdrawSplittingDO】对象信息,空值字段不插入
     *
     * @mbggenerated Tue Jul 12 11:03:53 CST 2016
     */
    @Override
    public Long insertSelective(WithdrawSplittingDO record) {
        Long id = withdrawSplittingDAO.insertSelective(record);
        return record.getId();
    }

    /**
     * 根据Example对象查询得到null【WithdrawSplittingDO】对象列表信息
     *
     * @mbggenerated Tue Jul 12 11:03:53 CST 2016
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<WithdrawSplittingDO> selectByExample(WithdrawSplittingDOExample example) {
        List<WithdrawSplittingDO> list = withdrawSplittingDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询null【WithdrawSplittingDO】对象信息
     *
     * @mbggenerated Tue Jul 12 11:03:53 CST 2016
     */
    @Override
    public WithdrawSplittingDO selectByPrimaryKey(Long id) {
        WithdrawSplittingDO record = withdrawSplittingDAO.selectByPrimaryKey(id);
        return record;
    }

    /**
     * 根据主键更新null【WithdrawSplittingDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Tue Jul 12 11:03:53 CST 2016
     */
    @Override
    public int updateByPrimaryKeySelective(WithdrawSplittingDO record) {
        int rows = withdrawSplittingDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新null【WithdrawSplittingDO】对象信息
     *
     * @mbggenerated Tue Jul 12 11:03:53 CST 2016
     */
    @Override
    public int updateByPrimaryKey(WithdrawSplittingDO record) {
        int rows = withdrawSplittingDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询null【WithdrawSplittingDO】对象列表信息
     *
     * @mbggenerated Tue Jul 12 11:03:53 CST 2016
     */
    @Override
    public List<WithdrawSplittingDO> selectByQuery(WithdrawSplittingDOExample example) {
        Integer totalItem = (Integer)withdrawSplittingDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<WithdrawSplittingDO> returnList = new ArrayList<WithdrawSplittingDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<WithdrawSplittingDO> list =withdrawSplittingDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}