package com.sdp.mc.pcs.manager.impl;

import com.sdp.mc.pcs.dao.WorkCalendar;
import com.sdp.mc.pcs.dao.WorkCalendarExample;
import com.sdp.mc.pcs.dao.daointerface.WorkCalendDAO;
import com.sdp.mc.pcs.manager.WorkCalendManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("workCalendManager")
public class WorkCalendManagerImpl implements WorkCalendManager {
    @Autowired
    private WorkCalendDAO workCalendDAO;



    /**
     * 根据Example对象查询得到工作日历【WorkCalendar】对象列表信息
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<WorkCalendar> selectByExample(WorkCalendarExample example) {
        List<WorkCalendar> list = workCalendDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据Query对象分页查询工作日历【WorkCalendar】对象列表信息
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    @Override
    public List<WorkCalendar> selectByQuery(WorkCalendarExample example) {
        Integer totalItem = (Integer)workCalendDAO.countByExample(example);

        example.setTotalItem(totalItem);

        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<WorkCalendar> returnList = new ArrayList<WorkCalendar>();
        if (example.getPageFristItem() <= example.getTotalItem()) {

            List<WorkCalendar> list =workCalendDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}