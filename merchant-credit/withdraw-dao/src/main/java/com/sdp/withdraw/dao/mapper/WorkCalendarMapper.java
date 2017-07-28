package com.sdp.withdraw.dao.mapper;

import com.sdp.withdraw.dao.WorkCalendarDO;
import com.sdp.withdraw.dao.WorkCalendarDOExample;
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

public interface WorkCalendarMapper {
    /**
     * 根据Example对象取得工作日历【WorkCalendarDO】对象count信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    @SelectProvider(type=WorkCalendarSqlProvider.class, method="countByExample")
    int countByExample(WorkCalendarDOExample example);

    /**
     * 根据Example对象删除工作日历【WorkCalendarDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    @DeleteProvider(type=WorkCalendarSqlProvider.class, method="deleteByExample")
    int deleteByExample(WorkCalendarDOExample example);

    /**
     * 根据主键删除工作日历【WorkCalendarDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    @Delete({
        "delete from FW_WORK_CALENDAR",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * 添加工作日历【WorkCalendarDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    @Insert({
        "insert into FW_WORK_CALENDAR (ID, WORK_DATE, ",
        "WEEK_DAY, IS_HOLIDAY, ",
        "CREATE_TIME, UPDATE_TIME)",
        "values (#{id,jdbcType=DECIMAL}, #{wordDate,jdbcType=DATE}, ",
        "#{weekDay,jdbcType=DECIMAL}, #{isHoliday,jdbcType=DECIMAL}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select SEQ_FW_WORK_CALENDAR.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insert(WorkCalendarDO record);

    /**
     * 添加工作日历【WorkCalendarDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    @InsertProvider(type=WorkCalendarSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_FW_WORK_CALENDAR.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insertSelective(WorkCalendarDO record);

    /**
     * 根据Example对象查询得到工作日历【WorkCalendarDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    @SelectProvider(type=WorkCalendarSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="WORK_DATE", property="wordDate", jdbcType=JdbcType.DATE),
        @Result(column="WEEK_DAY", property="weekDay", jdbcType=JdbcType.DECIMAL),
        @Result(column="IS_HOLIDAY", property="isHoliday", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<WorkCalendarDO> selectByExample(WorkCalendarDOExample example);

    /**
     * 根据Query对象分页查询工作日历【WorkCalendarDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    @SelectProvider(type=WorkCalendarSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="WORK_DATE", property="wordDate", jdbcType=JdbcType.DATE),
        @Result(column="WEEK_DAY", property="weekDay", jdbcType=JdbcType.DECIMAL),
        @Result(column="IS_HOLIDAY", property="isHoliday", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<WorkCalendarDO> selectByQuery(WorkCalendarDOExample example);

    /**
     * 根据主键查询工作日历【WorkCalendarDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    @Select({
        "select",
        "ID, WORK_DATE, WEEK_DAY, IS_HOLIDAY, CREATE_TIME, UPDATE_TIME",
        "from FW_WORK_CALENDAR",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="WORK_DATE", property="wordDate", jdbcType=JdbcType.DATE),
        @Result(column="WEEK_DAY", property="weekDay", jdbcType=JdbcType.DECIMAL),
        @Result(column="IS_HOLIDAY", property="isHoliday", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    WorkCalendarDO selectByPrimaryKey(Long id);

    /**
     * 根据Example对象更新工作日历【WorkCalendarDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    @UpdateProvider(type=WorkCalendarSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WorkCalendarDO record, @Param("example") WorkCalendarDOExample example);

    /**
     * 根据Example对象更新工作日历【WorkCalendarDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    @UpdateProvider(type=WorkCalendarSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") WorkCalendarDO record, @Param("example") WorkCalendarDOExample example);

    /**
     * 根据主键更新工作日历【WorkCalendarDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    @UpdateProvider(type=WorkCalendarSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WorkCalendarDO record);

    /**
     * 根据主键更新工作日历【WorkCalendarDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:52 CST 2016
     */
    @Update({
        "update FW_WORK_CALENDAR",
        "set WORK_DATE = #{wordDate,jdbcType=DATE},",
          "WEEK_DAY = #{weekDay,jdbcType=DECIMAL},",
          "IS_HOLIDAY = #{isHoliday,jdbcType=DECIMAL},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(WorkCalendarDO record);
}