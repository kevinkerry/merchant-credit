package com.sdp.mc.task.manager.impl;

import com.sdp.mc.task.dao.TimedTaskInfoDO;
import com.sdp.mc.task.dao.TimedTaskInfoDOExample;
import com.sdp.mc.task.dao.daointerface.TimedTaskInfoDAO;
import com.sdp.mc.task.manager.TimedTaskInfoManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("timedTaskInfoManager")
public class TimedTaskInfoManagerImpl implements TimedTaskInfoManager {
    @Autowired
    private TimedTaskInfoDAO timedTaskInfoDAO;

    /**
     * 根据主键删除定时任务信息表【TimedTaskInfoDO】对象信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        int rows = timedTaskInfoDAO.deleteByPrimaryKey(id);
        return rows;
    }

    /**
     * 添加定时任务信息表【TimedTaskInfoDO】对象信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    @Override
    public Long insert(TimedTaskInfoDO record) {
        Long id = timedTaskInfoDAO.insert(record);
        return record.getId();
    }

    /**
     * 添加定时任务信息表【TimedTaskInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    @Override
    public Long insertSelective(TimedTaskInfoDO record) {
        Long id = timedTaskInfoDAO.insertSelective(record);
        return record.getId();
    }

    /**
     * 根据Example对象查询得到定时任务信息表【TimedTaskInfoDO】对象列表信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<TimedTaskInfoDO> selectByExample(TimedTaskInfoDOExample example) {
        List<TimedTaskInfoDO> list = timedTaskInfoDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询定时任务信息表【TimedTaskInfoDO】对象信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    @Override
    public TimedTaskInfoDO selectByPrimaryKey(Long id) {
        TimedTaskInfoDO record = timedTaskInfoDAO.selectByPrimaryKey(id);
        return record;
    }

    /**
     * 根据主键更新定时任务信息表【TimedTaskInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    @Override
    public int updateByPrimaryKeySelective(TimedTaskInfoDO record) {
        int rows = timedTaskInfoDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新定时任务信息表【TimedTaskInfoDO】对象信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    @Override
    public int updateByPrimaryKey(TimedTaskInfoDO record) {
        int rows = timedTaskInfoDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询定时任务信息表【TimedTaskInfoDO】对象列表信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    @Override
    public List<TimedTaskInfoDO> selectByQuery(TimedTaskInfoDOExample example) {
        Integer totalItem = (Integer)timedTaskInfoDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<TimedTaskInfoDO> returnList = new ArrayList<TimedTaskInfoDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<TimedTaskInfoDO> list =timedTaskInfoDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}