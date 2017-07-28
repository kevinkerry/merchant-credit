package com.sdp.withdraw.manager.impl;

import com.sdp.withdraw.dao.WithdrawRetryPlanDO;
import com.sdp.withdraw.dao.WithdrawRetryPlanDOExample;
import com.sdp.withdraw.dao.daointerface.WithdrawRetryPlanDAO;
import com.sdp.withdraw.manager.WithdrawRetryPlanManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("withdrawRetryPlanManager")
public class WithdrawRetryPlanManagerImpl implements WithdrawRetryPlanManager {
    @Autowired
    private WithdrawRetryPlanDAO withdrawRetryPlanDAO;

    /**
     * 根据主键删除出款服务重试计划表【WithdrawRetryPlanDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    @Override
    public int deleteByPrimaryKey(Long planId) {
        int rows = withdrawRetryPlanDAO.deleteByPrimaryKey(planId);
        return rows;
    }

    /**
     * 添加出款服务重试计划表【WithdrawRetryPlanDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    @Override
    public Long insert(WithdrawRetryPlanDO record) {
        Long id = withdrawRetryPlanDAO.insert(record);
        return record.getPlanId();
    }

    /**
     * 添加出款服务重试计划表【WithdrawRetryPlanDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    @Override
    public Long insertSelective(WithdrawRetryPlanDO record) {
        Long id = withdrawRetryPlanDAO.insertSelective(record);
        return record.getPlanId();
    }

    /**
     * 根据Example对象查询得到出款服务重试计划表【WithdrawRetryPlanDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<WithdrawRetryPlanDO> selectByExample(WithdrawRetryPlanDOExample example) {
        List<WithdrawRetryPlanDO> list = withdrawRetryPlanDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询出款服务重试计划表【WithdrawRetryPlanDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    @Override
    public WithdrawRetryPlanDO selectByPrimaryKey(Long planId) {
        WithdrawRetryPlanDO record = withdrawRetryPlanDAO.selectByPrimaryKey(planId);
        return record;
    }

    /**
     * 根据主键更新出款服务重试计划表【WithdrawRetryPlanDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    @Override
    public int updateByPrimaryKeySelective(WithdrawRetryPlanDO record) {
        int rows = withdrawRetryPlanDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新出款服务重试计划表【WithdrawRetryPlanDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    @Override
    public int updateByPrimaryKey(WithdrawRetryPlanDO record) {
        int rows = withdrawRetryPlanDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询出款服务重试计划表【WithdrawRetryPlanDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    @Override
    public List<WithdrawRetryPlanDO> selectByQuery(WithdrawRetryPlanDOExample example) {
        Integer totalItem = (Integer)withdrawRetryPlanDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<WithdrawRetryPlanDO> returnList = new ArrayList<WithdrawRetryPlanDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<WithdrawRetryPlanDO> list =withdrawRetryPlanDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}