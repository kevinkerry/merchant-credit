package com.sdp.mc.task.manager;

import com.sdp.mc.task.dao.TimedTaskInfoDO;
import com.sdp.mc.task.dao.TimedTaskInfoDOExample;
import java.util.List;

public interface TimedTaskInfoManager {
    /**
     * 根据主键删除定时任务信息表【TimedTaskInfoDO】对象信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加定时任务信息表【TimedTaskInfoDO】对象信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    Long insert(TimedTaskInfoDO record);

    /**
     * 添加定时任务信息表【TimedTaskInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    Long insertSelective(TimedTaskInfoDO record);

    /**
     * 根据Example对象查询得到定时任务信息表【TimedTaskInfoDO】对象列表信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    List<TimedTaskInfoDO> selectByExample(TimedTaskInfoDOExample example);

    /**
     * 根据主键查询定时任务信息表【TimedTaskInfoDO】对象信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    TimedTaskInfoDO selectByPrimaryKey(Long id);

    /**
     * 根据主键更新定时任务信息表【TimedTaskInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    int updateByPrimaryKeySelective(TimedTaskInfoDO record);

    /**
     * 根据主键更新定时任务信息表【TimedTaskInfoDO】对象信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    int updateByPrimaryKey(TimedTaskInfoDO record);

    /**
     * 根据Query对象分页查询定时任务信息表【TimedTaskInfoDO】对象列表信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    List<TimedTaskInfoDO> selectByQuery(TimedTaskInfoDOExample example);
}