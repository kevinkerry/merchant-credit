package com.sdp.mc.pcs.manager;

import com.sdp.mc.pcs.dao.WorkCalendar;
import com.sdp.mc.pcs.dao.WorkCalendarExample;
import java.util.List;

public interface WorkCalendManager {


    /**
     * 根据Example对象查询得到工作日历【WorkCalendar】对象列表信息
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    List<WorkCalendar> selectByExample(WorkCalendarExample example);

    /**
     * 根据Query对象分页查询工作日历【WorkCalendar】对象列表信息
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    List<WorkCalendar> selectByQuery(WorkCalendarExample example);
}