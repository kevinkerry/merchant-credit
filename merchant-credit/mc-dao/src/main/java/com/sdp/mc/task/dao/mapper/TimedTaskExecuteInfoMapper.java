package com.sdp.mc.task.dao.mapper;

import com.sdp.mc.task.dao.TimedTaskExecuteInfoDO;
import com.sdp.mc.task.dao.TimedTaskExecuteInfoDOExample;
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

public interface TimedTaskExecuteInfoMapper {
    /**
     * 根据Example对象取得任务执行情况【TimedTaskExecuteInfoDO】对象count信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    @SelectProvider(type=TimedTaskExecuteInfoSqlProvider.class, method="countByExample")
    int countByExample(TimedTaskExecuteInfoDOExample example);

    /**
     * 根据Example对象删除任务执行情况【TimedTaskExecuteInfoDO】对象信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    @DeleteProvider(type=TimedTaskExecuteInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(TimedTaskExecuteInfoDOExample example);

    /**
     * 根据主键删除任务执行情况【TimedTaskExecuteInfoDO】对象信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    @Delete({
        "delete from TB_TIMED_TASK_EXECUTE_INFO",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * 添加任务执行情况【TimedTaskExecuteInfoDO】对象信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    @Insert({
        "insert into TB_TIMED_TASK_EXECUTE_INFO (ID, CREATE_TIME, ",
        "UPDATE_TIME, TASK_ID, ",
        "USE_TIME, RESULT, ",
        "REMARK)",
        "values (#{id,jdbcType=DECIMAL}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{taskId,jdbcType=DECIMAL}, ",
        "#{useTime,jdbcType=DECIMAL}, #{result,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="select SEQ_TB_TIMED_TASK_EXECUTE_INFO.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insert(TimedTaskExecuteInfoDO record);

    /**
     * 添加任务执行情况【TimedTaskExecuteInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    @InsertProvider(type=TimedTaskExecuteInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_TB_TIMED_TASK_EXECUTE_INFO.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insertSelective(TimedTaskExecuteInfoDO record);

    /**
     * 根据Example对象查询得到任务执行情况【TimedTaskExecuteInfoDO】对象列表信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    @SelectProvider(type=TimedTaskExecuteInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="TASK_ID", property="taskId", jdbcType=JdbcType.DECIMAL),
        @Result(column="USE_TIME", property="useTime", jdbcType=JdbcType.DECIMAL),
        @Result(column="RESULT", property="result", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMARK", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    List<TimedTaskExecuteInfoDO> selectByExample(TimedTaskExecuteInfoDOExample example);

    /**
     * 根据Query对象分页查询任务执行情况【TimedTaskExecuteInfoDO】对象列表信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    @SelectProvider(type=TimedTaskExecuteInfoSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="TASK_ID", property="taskId", jdbcType=JdbcType.DECIMAL),
        @Result(column="USE_TIME", property="useTime", jdbcType=JdbcType.DECIMAL),
        @Result(column="RESULT", property="result", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMARK", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    List<TimedTaskExecuteInfoDO> selectByQuery(TimedTaskExecuteInfoDOExample example);

    /**
     * 根据主键查询任务执行情况【TimedTaskExecuteInfoDO】对象信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    @Select({
        "select",
        "ID, CREATE_TIME, UPDATE_TIME, TASK_ID, USE_TIME, RESULT, REMARK",
        "from TB_TIMED_TASK_EXECUTE_INFO",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="TASK_ID", property="taskId", jdbcType=JdbcType.DECIMAL),
        @Result(column="USE_TIME", property="useTime", jdbcType=JdbcType.DECIMAL),
        @Result(column="RESULT", property="result", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMARK", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    TimedTaskExecuteInfoDO selectByPrimaryKey(Long id);

    /**
     * 根据Example对象更新任务执行情况【TimedTaskExecuteInfoDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    @UpdateProvider(type=TimedTaskExecuteInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TimedTaskExecuteInfoDO record, @Param("example") TimedTaskExecuteInfoDOExample example);

    /**
     * 根据Example对象更新任务执行情况【TimedTaskExecuteInfoDO】对象信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    @UpdateProvider(type=TimedTaskExecuteInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TimedTaskExecuteInfoDO record, @Param("example") TimedTaskExecuteInfoDOExample example);

    /**
     * 根据主键更新任务执行情况【TimedTaskExecuteInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    @UpdateProvider(type=TimedTaskExecuteInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TimedTaskExecuteInfoDO record);

    /**
     * 根据主键更新任务执行情况【TimedTaskExecuteInfoDO】对象信息
     *
     * @mbggenerated Thu Apr 27 09:31:21 CST 2017
     */
    @Update({
        "update TB_TIMED_TASK_EXECUTE_INFO",
        "set CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "TASK_ID = #{taskId,jdbcType=DECIMAL},",
          "USE_TIME = #{useTime,jdbcType=DECIMAL},",
          "RESULT = #{result,jdbcType=VARCHAR},",
          "REMARK = #{remark,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(TimedTaskExecuteInfoDO record);
}