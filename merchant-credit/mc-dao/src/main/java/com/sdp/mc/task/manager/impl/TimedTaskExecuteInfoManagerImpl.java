package com.sdp.mc.task.manager.impl;

import com.sdp.mc.task.dao.TimedTaskExecuteInfoDO;
import com.sdp.mc.task.dao.TimedTaskExecuteInfoDOExample;
import com.sdp.mc.task.dao.daointerface.TimedTaskExecuteInfoDAO;
import com.sdp.mc.task.manager.TimedTaskExecuteInfoManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("timedTaskExecuteInfoManager")
public class TimedTaskExecuteInfoManagerImpl implements TimedTaskExecuteInfoManager {
    @Autowired
    private TimedTaskExecuteInfoDAO timedTaskExecuteInfoDAO;

    /**
     * 根据主键删除任务执行情况【TimedTaskExecuteInfoDO】对象信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        int rows = timedTaskExecuteInfoDAO.deleteByPrimaryKey(id);
        return rows;
    }

    /**
     * 添加任务执行情况【TimedTaskExecuteInfoDO】对象信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    @Override
    public Long insert(TimedTaskExecuteInfoDO record) {
        Long id = timedTaskExecuteInfoDAO.insert(record);
        return record.getId();
    }

    /**
     * 添加任务执行情况【TimedTaskExecuteInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    @Override
    public Long insertSelective(TimedTaskExecuteInfoDO record) {
        Long id = timedTaskExecuteInfoDAO.insertSelective(record);
        return record.getId();
    }

    /**
     * 根据Example对象查询得到任务执行情况【TimedTaskExecuteInfoDO】对象列表信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<TimedTaskExecuteInfoDO> selectByExample(TimedTaskExecuteInfoDOExample example) {
        List<TimedTaskExecuteInfoDO> list = timedTaskExecuteInfoDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询任务执行情况【TimedTaskExecuteInfoDO】对象信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    @Override
    public TimedTaskExecuteInfoDO selectByPrimaryKey(Long id) {
        TimedTaskExecuteInfoDO record = timedTaskExecuteInfoDAO.selectByPrimaryKey(id);
        return record;
    }

    /**
     * 根据主键更新任务执行情况【TimedTaskExecuteInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    @Override
    public int updateByPrimaryKeySelective(TimedTaskExecuteInfoDO record) {
        int rows = timedTaskExecuteInfoDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新任务执行情况【TimedTaskExecuteInfoDO】对象信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    @Override
    public int updateByPrimaryKey(TimedTaskExecuteInfoDO record) {
        int rows = timedTaskExecuteInfoDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询任务执行情况【TimedTaskExecuteInfoDO】对象列表信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    @Override
    public List<TimedTaskExecuteInfoDO> selectByQuery(TimedTaskExecuteInfoDOExample example) {
        Integer totalItem = (Integer)timedTaskExecuteInfoDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<TimedTaskExecuteInfoDO> returnList = new ArrayList<TimedTaskExecuteInfoDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<TimedTaskExecuteInfoDO> list =timedTaskExecuteInfoDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}