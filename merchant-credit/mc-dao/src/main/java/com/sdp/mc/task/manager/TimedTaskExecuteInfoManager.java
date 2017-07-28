package com.sdp.mc.task.manager;

import com.sdp.mc.task.dao.TimedTaskExecuteInfoDO;
import com.sdp.mc.task.dao.TimedTaskExecuteInfoDOExample;
import java.util.List;

public interface TimedTaskExecuteInfoManager {
    /**
     * 根据主键删除任务执行情况【TimedTaskExecuteInfoDO】对象信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加任务执行情况【TimedTaskExecuteInfoDO】对象信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    Long insert(TimedTaskExecuteInfoDO record);

    /**
     * 添加任务执行情况【TimedTaskExecuteInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    Long insertSelective(TimedTaskExecuteInfoDO record);

    /**
     * 根据Example对象查询得到任务执行情况【TimedTaskExecuteInfoDO】对象列表信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    List<TimedTaskExecuteInfoDO> selectByExample(TimedTaskExecuteInfoDOExample example);

    /**
     * 根据主键查询任务执行情况【TimedTaskExecuteInfoDO】对象信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    TimedTaskExecuteInfoDO selectByPrimaryKey(Long id);

    /**
     * 根据主键更新任务执行情况【TimedTaskExecuteInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    int updateByPrimaryKeySelective(TimedTaskExecuteInfoDO record);

    /**
     * 根据主键更新任务执行情况【TimedTaskExecuteInfoDO】对象信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    int updateByPrimaryKey(TimedTaskExecuteInfoDO record);

    /**
     * 根据Query对象分页查询任务执行情况【TimedTaskExecuteInfoDO】对象列表信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    List<TimedTaskExecuteInfoDO> selectByQuery(TimedTaskExecuteInfoDOExample example);
}