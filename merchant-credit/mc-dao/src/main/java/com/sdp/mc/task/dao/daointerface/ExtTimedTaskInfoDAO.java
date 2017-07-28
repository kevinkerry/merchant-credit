package com.sdp.mc.task.dao.daointerface;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.sdp.mc.task.dao.TimedTaskInfoDO;
import com.sdp.mc.task.dao.ext.provider.ExtTimedTaskInfoSqlProvider;
import com.sdp.mc.task.dao.mapper.TimedTaskInfoMapper;

/**
*@author wushiyi
*@date:2017年5月10日下午12:30:02
*@version 1.0
*@description:
*/

public interface ExtTimedTaskInfoDAO{
	
	@SelectProvider(type = ExtTimedTaskInfoSqlProvider.class, method = "queryWaitExecuteTaskInfo")
	@Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="TASK_TYPE", property="taskType", jdbcType=JdbcType.DECIMAL),
        @Result(column="TASK_CONTENT", property="taskContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="TASK_STATUS", property="taskStatus", jdbcType=JdbcType.DECIMAL),
        @Result(column="EFFECTIVE_TIME", property="effectiveTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="RETRY_TIMES", property="retryTimes", jdbcType=JdbcType.DECIMAL),
        @Result(column="EXECUTE_TIMES", property="executeTimes", jdbcType=JdbcType.DECIMAL),
        @Result(column="LAST_EXECUTE_TIME", property="lastExecuteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="NOTIFY_EMAIL", property="notifyEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="NOTIFY_PHONE", property="notifyPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_EXECUTE_ID", property="lastExecuteId", jdbcType=JdbcType.DECIMAL),
        @Result(column="RETRY_TIME_INTERVAL", property="retryTimeInterval", jdbcType=JdbcType.DECIMAL)
    })
	List<TimedTaskInfoDO> queryWaitExecuteTaskInfo();

}
