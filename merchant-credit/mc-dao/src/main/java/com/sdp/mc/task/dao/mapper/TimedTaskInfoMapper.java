package com.sdp.mc.task.dao.mapper;

import com.sdp.mc.task.dao.TimedTaskInfoDO;
import com.sdp.mc.task.dao.TimedTaskInfoDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TimedTaskInfoMapper {
    /**
     * 根据Example对象取得定时任务信息表【TimedTaskInfoDO】对象count信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    @SelectProvider(type=TimedTaskInfoSqlProvider.class, method="countByExample")
    int countByExample(TimedTaskInfoDOExample example);

    /**
     * 根据Example对象删除定时任务信息表【TimedTaskInfoDO】对象信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    @DeleteProvider(type=TimedTaskInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(TimedTaskInfoDOExample example);

    /**
     * 根据主键删除定时任务信息表【TimedTaskInfoDO】对象信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    @Delete({
        "delete from TB_TIMED_TASK_INFO",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * 添加定时任务信息表【TimedTaskInfoDO】对象信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    @Insert({
        "insert into TB_TIMED_TASK_INFO (ID, TASK_TYPE, ",
        "TASK_CONTENT, TASK_STATUS, ",
        "EFFECTIVE_TIME, RETRY_TIMES, ",
        "EXECUTE_TIMES, LAST_EXECUTE_TIME, ",
        "CREATE_TIME, UPDATE_TIME, ",
        "NOTIFY_EMAIL, NOTIFY_PHONE, ",
        "LAST_EXECUTE_ID, RETRY_TIME_INTERVAL)",
        "values (#{id,jdbcType=DECIMAL}, #{taskType,jdbcType=DECIMAL}, ",
        "#{taskContent,jdbcType=VARCHAR}, #{taskStatus,jdbcType=DECIMAL}, ",
        "#{effectiveTime,jdbcType=TIMESTAMP}, #{retryTimes,jdbcType=DECIMAL}, ",
        "#{executeTimes,jdbcType=DECIMAL}, #{lastExecuteTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{notifyEmail,jdbcType=VARCHAR}, #{notifyPhone,jdbcType=VARCHAR}, ",
        "#{lastExecuteId,jdbcType=DECIMAL}, #{retryTimeInterval,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="select SEQ_TB_TIMED_TASK_INFO.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insert(TimedTaskInfoDO record);

    /**
     * 添加定时任务信息表【TimedTaskInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    @InsertProvider(type=TimedTaskInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_TB_TIMED_TASK_INFO.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insertSelective(TimedTaskInfoDO record);

    /**
     * 根据Example对象查询得到定时任务信息表【TimedTaskInfoDO】对象列表信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    @SelectProvider(type=TimedTaskInfoSqlProvider.class, method="selectByExample")
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
    List<TimedTaskInfoDO> selectByExample(TimedTaskInfoDOExample example);

    /**
     * 根据Query对象分页查询定时任务信息表【TimedTaskInfoDO】对象列表信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    @SelectProvider(type=TimedTaskInfoSqlProvider.class, method="selectByQuery")
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
    List<TimedTaskInfoDO> selectByQuery(TimedTaskInfoDOExample example);

    /**
     * 根据主键查询定时任务信息表【TimedTaskInfoDO】对象信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    @Select({
        "select",
        "ID, TASK_TYPE, TASK_CONTENT, TASK_STATUS, EFFECTIVE_TIME, RETRY_TIMES, EXECUTE_TIMES, ",
        "LAST_EXECUTE_TIME, CREATE_TIME, UPDATE_TIME, NOTIFY_EMAIL, NOTIFY_PHONE, LAST_EXECUTE_ID, ",
        "RETRY_TIME_INTERVAL",
        "from TB_TIMED_TASK_INFO",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
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
    TimedTaskInfoDO selectByPrimaryKey(Long id);

    /**
     * 根据Example对象更新定时任务信息表【TimedTaskInfoDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    @UpdateProvider(type=TimedTaskInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TimedTaskInfoDO record, @Param("example") TimedTaskInfoDOExample example);

    /**
     * 根据Example对象更新定时任务信息表【TimedTaskInfoDO】对象信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    @UpdateProvider(type=TimedTaskInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TimedTaskInfoDO record, @Param("example") TimedTaskInfoDOExample example);

    /**
     * 根据主键更新定时任务信息表【TimedTaskInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    @UpdateProvider(type=TimedTaskInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TimedTaskInfoDO record);

    /**
     * 根据主键更新定时任务信息表【TimedTaskInfoDO】对象信息
     *
     * @mbggenerated Wed May 10 13:57:18 CST 2017
     */
    @Update({
        "update TB_TIMED_TASK_INFO",
        "set TASK_TYPE = #{taskType,jdbcType=DECIMAL},",
          "TASK_CONTENT = #{taskContent,jdbcType=VARCHAR},",
          "TASK_STATUS = #{taskStatus,jdbcType=DECIMAL},",
          "EFFECTIVE_TIME = #{effectiveTime,jdbcType=TIMESTAMP},",
          "RETRY_TIMES = #{retryTimes,jdbcType=DECIMAL},",
          "EXECUTE_TIMES = #{executeTimes,jdbcType=DECIMAL},",
          "LAST_EXECUTE_TIME = #{lastExecuteTime,jdbcType=TIMESTAMP},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "NOTIFY_EMAIL = #{notifyEmail,jdbcType=VARCHAR},",
          "NOTIFY_PHONE = #{notifyPhone,jdbcType=VARCHAR},",
          "LAST_EXECUTE_ID = #{lastExecuteId,jdbcType=DECIMAL},",
          "RETRY_TIME_INTERVAL = #{retryTimeInterval,jdbcType=DECIMAL}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(TimedTaskInfoDO record);
}