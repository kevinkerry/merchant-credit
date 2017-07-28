package com.sdp.withdraw.dao.mapper;

import com.sdp.withdraw.dao.WithdrawRatioInfoDO;
import com.sdp.withdraw.dao.WithdrawRatioInfoDOExample;
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

public interface WithdrawRatioInfoMapper {
    /**
     * 根据Example对象取得提现出款费率信息【WithdrawRatioInfoDO】对象count信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    @SelectProvider(type=WithdrawRatioInfoSqlProvider.class, method="countByExample")
    int countByExample(WithdrawRatioInfoDOExample example);

    /**
     * 根据Example对象删除提现出款费率信息【WithdrawRatioInfoDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    @DeleteProvider(type=WithdrawRatioInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(WithdrawRatioInfoDOExample example);

    /**
     * 根据主键删除提现出款费率信息【WithdrawRatioInfoDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    @Delete({
        "delete from FW_WITHDRAW_RATIO_INFO",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * 添加提现出款费率信息【WithdrawRatioInfoDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    @Insert({
        "insert into FW_WITHDRAW_RATIO_INFO (ID, BIZ_ID, ",
        "RATIO_TYPE, STATUS, ",
        "WORK_DAY_RATIO, HOLIDAY_RATIO, ",
        "EFFECTIVE_TIME, EXPIRE_TIME, ",
        "CRETE_TIME, UPDATE_TIME)",
        "values (#{id,jdbcType=DECIMAL}, #{bizId,jdbcType=DECIMAL}, ",
        "#{ratioType,jdbcType=DECIMAL}, #{status,jdbcType=DECIMAL}, ",
        "#{workDayRatio,jdbcType=DECIMAL}, #{holidayRatio,jdbcType=DECIMAL}, ",
        "#{effectiveTime,jdbcType=TIMESTAMP}, #{expireTime,jdbcType=TIMESTAMP}, ",
        "#{creteTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select SEQ_FW_WITHDRAW_RATIO_INFO.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insert(WithdrawRatioInfoDO record);

    /**
     * 添加提现出款费率信息【WithdrawRatioInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    @InsertProvider(type=WithdrawRatioInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_FW_WITHDRAW_RATIO_INFO.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insertSelective(WithdrawRatioInfoDO record);

    /**
     * 根据Example对象查询得到提现出款费率信息【WithdrawRatioInfoDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    @SelectProvider(type=WithdrawRatioInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="BIZ_ID", property="bizId", jdbcType=JdbcType.DECIMAL),
        @Result(column="RATIO_TYPE", property="ratioType", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="WORK_DAY_RATIO", property="workDayRatio", jdbcType=JdbcType.DECIMAL),
        @Result(column="HOLIDAY_RATIO", property="holidayRatio", jdbcType=JdbcType.DECIMAL),
        @Result(column="EFFECTIVE_TIME", property="effectiveTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="EXPIRE_TIME", property="expireTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CRETE_TIME", property="creteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<WithdrawRatioInfoDO> selectByExample(WithdrawRatioInfoDOExample example);

    /**
     * 根据Query对象分页查询提现出款费率信息【WithdrawRatioInfoDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    @SelectProvider(type=WithdrawRatioInfoSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="BIZ_ID", property="bizId", jdbcType=JdbcType.DECIMAL),
        @Result(column="RATIO_TYPE", property="ratioType", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="WORK_DAY_RATIO", property="workDayRatio", jdbcType=JdbcType.DECIMAL),
        @Result(column="HOLIDAY_RATIO", property="holidayRatio", jdbcType=JdbcType.DECIMAL),
        @Result(column="EFFECTIVE_TIME", property="effectiveTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="EXPIRE_TIME", property="expireTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CRETE_TIME", property="creteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<WithdrawRatioInfoDO> selectByQuery(WithdrawRatioInfoDOExample example);

    /**
     * 根据主键查询提现出款费率信息【WithdrawRatioInfoDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    @Select({
        "select",
        "ID, BIZ_ID, RATIO_TYPE, STATUS, WORK_DAY_RATIO, HOLIDAY_RATIO, EFFECTIVE_TIME, ",
        "EXPIRE_TIME, CRETE_TIME, UPDATE_TIME",
        "from FW_WITHDRAW_RATIO_INFO",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="BIZ_ID", property="bizId", jdbcType=JdbcType.DECIMAL),
        @Result(column="RATIO_TYPE", property="ratioType", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="WORK_DAY_RATIO", property="workDayRatio", jdbcType=JdbcType.DECIMAL),
        @Result(column="HOLIDAY_RATIO", property="holidayRatio", jdbcType=JdbcType.DECIMAL),
        @Result(column="EFFECTIVE_TIME", property="effectiveTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="EXPIRE_TIME", property="expireTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CRETE_TIME", property="creteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    WithdrawRatioInfoDO selectByPrimaryKey(Long id);

    /**
     * 根据Example对象更新提现出款费率信息【WithdrawRatioInfoDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    @UpdateProvider(type=WithdrawRatioInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WithdrawRatioInfoDO record, @Param("example") WithdrawRatioInfoDOExample example);

    /**
     * 根据Example对象更新提现出款费率信息【WithdrawRatioInfoDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    @UpdateProvider(type=WithdrawRatioInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") WithdrawRatioInfoDO record, @Param("example") WithdrawRatioInfoDOExample example);

    /**
     * 根据主键更新提现出款费率信息【WithdrawRatioInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    @UpdateProvider(type=WithdrawRatioInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WithdrawRatioInfoDO record);

    /**
     * 根据主键更新提现出款费率信息【WithdrawRatioInfoDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:30 CST 2016
     */
    @Update({
        "update FW_WITHDRAW_RATIO_INFO",
        "set BIZ_ID = #{bizId,jdbcType=DECIMAL},",
          "RATIO_TYPE = #{ratioType,jdbcType=DECIMAL},",
          "STATUS = #{status,jdbcType=DECIMAL},",
          "WORK_DAY_RATIO = #{workDayRatio,jdbcType=DECIMAL},",
          "HOLIDAY_RATIO = #{holidayRatio,jdbcType=DECIMAL},",
          "EFFECTIVE_TIME = #{effectiveTime,jdbcType=TIMESTAMP},",
          "EXPIRE_TIME = #{expireTime,jdbcType=TIMESTAMP},",
          "CRETE_TIME = #{creteTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(WithdrawRatioInfoDO record);
}