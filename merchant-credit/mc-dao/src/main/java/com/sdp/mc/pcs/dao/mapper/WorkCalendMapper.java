package com.sdp.mc.pcs.dao.mapper;

import com.sdp.mc.pcs.dao.WorkCalendar;
import com.sdp.mc.pcs.dao.WorkCalendarExample;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface WorkCalendMapper {
    /**
     * 根据Example对象取得工作日历【WorkCalendar】对象count信息
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    @SelectProvider(type=WorkCalendSqlProvider.class, method="countByExample")
    int countByExample(WorkCalendarExample example);

    /**
     * 根据Example对象删除工作日历【WorkCalendar】对象信息
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    @DeleteProvider(type=WorkCalendSqlProvider.class, method="deleteByExample")
    int deleteByExample(WorkCalendarExample example);

    /**
     * 添加工作日历【WorkCalendar】对象信息
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    @Insert({
        "insert into WORK_CALENDAR (ID, CREATE_TIME, ",
        "UPDATE_TIME, VERSION, ",
        "DATE_STR, IS_WORK_DAY)",
        "values (#{id,jdbcType=DECIMAL}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{version,jdbcType=DECIMAL}, ",
        "#{dateStr,jdbcType=CHAR}, #{isWorkDay,jdbcType=DECIMAL})"
    })
    Long insert(WorkCalendar record);

    /**
     * 添加工作日历【WorkCalendar】对象信息,空值字段不插入
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    @InsertProvider(type=WorkCalendSqlProvider.class, method="insertSelective")
    Long insertSelective(WorkCalendar record);

    /**
     * 根据Example对象查询得到工作日历【WorkCalendar】对象列表信息
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    @SelectProvider(type=WorkCalendSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="VERSION", property="version", jdbcType=JdbcType.DECIMAL),
        @Result(column="DATE_STR", property="dateStr", jdbcType=JdbcType.CHAR),
        @Result(column="IS_WORK_DAY", property="isWorkDay", jdbcType=JdbcType.DECIMAL)
    })
    List<WorkCalendar> selectByExample(WorkCalendarExample example);

    /**
     * 根据Query对象分页查询工作日历【WorkCalendar】对象列表信息
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    @SelectProvider(type=WorkCalendSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="VERSION", property="version", jdbcType=JdbcType.DECIMAL),
        @Result(column="DATE_STR", property="dateStr", jdbcType=JdbcType.CHAR),
        @Result(column="IS_WORK_DAY", property="isWorkDay", jdbcType=JdbcType.DECIMAL)
    })
    List<WorkCalendar> selectByQuery(WorkCalendarExample example);

    /**
     * 根据Example对象更新工作日历【WorkCalendar】对象信息，仅更新非空字段
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    @UpdateProvider(type=WorkCalendSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WorkCalendar record, @Param("example") WorkCalendarExample example);

    /**
     * 根据Example对象更新工作日历【WorkCalendar】对象信息
     *
     * @mbggenerated Tue Jun 02 17:18:25 CST 2015
     */
    @UpdateProvider(type=WorkCalendSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") WorkCalendar record, @Param("example") WorkCalendarExample example);
}