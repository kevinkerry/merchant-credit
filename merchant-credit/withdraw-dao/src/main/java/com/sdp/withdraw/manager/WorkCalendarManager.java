package com.sdp.withdraw.manager;

import com.sdp.withdraw.dao.WorkCalendarDO;
import com.sdp.withdraw.dao.WorkCalendarDOExample;
import java.util.List;

public interface WorkCalendarManager {
    /**
     * 根据主键删除工作日历【WorkCalendarDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加工作日历【WorkCalendarDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    Long insert(WorkCalendarDO record);

    /**
     * 添加工作日历【WorkCalendarDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    Long insertSelective(WorkCalendarDO record);

    /**
     * 根据Example对象查询得到工作日历【WorkCalendarDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    List<WorkCalendarDO> selectByExample(WorkCalendarDOExample example);

    /**
     * 根据主键查询工作日历【WorkCalendarDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    WorkCalendarDO selectByPrimaryKey(Long id);

    /**
     * 根据主键更新工作日历【WorkCalendarDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    int updateByPrimaryKeySelective(WorkCalendarDO record);

    /**
     * 根据主键更新工作日历【WorkCalendarDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    int updateByPrimaryKey(WorkCalendarDO record);

    /**
     * 根据Query对象分页查询工作日历【WorkCalendarDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    List<WorkCalendarDO> selectByQuery(WorkCalendarDOExample example);
}