package com.sdp.withdraw.manager.impl;

import com.sdp.withdraw.dao.WorkCalendarDO;
import com.sdp.withdraw.dao.WorkCalendarDOExample;
import com.sdp.withdraw.dao.daointerface.WorkCalendarDAO;
import com.sdp.withdraw.manager.WorkCalendarManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("workCalendarManager")
public class WorkCalendarManagerImpl implements WorkCalendarManager {
    @Autowired
    private WorkCalendarDAO workCalendarDAO;

    /**
     * 根据主键删除工作日历【WorkCalendarDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        int rows = workCalendarDAO.deleteByPrimaryKey(id);
        return rows;
    }

    /**
     * 添加工作日历【WorkCalendarDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    @Override
    public Long insert(WorkCalendarDO record) {
        Long id = workCalendarDAO.insert(record);
        return record.getId();
    }

    /**
     * 添加工作日历【WorkCalendarDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    @Override
    public Long insertSelective(WorkCalendarDO record) {
        Long id = workCalendarDAO.insertSelective(record);
        return record.getId();
    }

    /**
     * 根据Example对象查询得到工作日历【WorkCalendarDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<WorkCalendarDO> selectByExample(WorkCalendarDOExample example) {
        List<WorkCalendarDO> list = workCalendarDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询工作日历【WorkCalendarDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    @Override
    public WorkCalendarDO selectByPrimaryKey(Long id) {
        WorkCalendarDO record = workCalendarDAO.selectByPrimaryKey(id);
        return record;
    }

    /**
     * 根据主键更新工作日历【WorkCalendarDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    @Override
    public int updateByPrimaryKeySelective(WorkCalendarDO record) {
        int rows = workCalendarDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新工作日历【WorkCalendarDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    @Override
    public int updateByPrimaryKey(WorkCalendarDO record) {
        int rows = workCalendarDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询工作日历【WorkCalendarDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    @Override
    public List<WorkCalendarDO> selectByQuery(WorkCalendarDOExample example) {
        Integer totalItem = (Integer)workCalendarDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<WorkCalendarDO> returnList = new ArrayList<WorkCalendarDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<WorkCalendarDO> list =workCalendarDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}