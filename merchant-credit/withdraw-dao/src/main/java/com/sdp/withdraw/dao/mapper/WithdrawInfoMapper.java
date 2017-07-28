package com.sdp.withdraw.dao.mapper;

import com.sdp.withdraw.dao.WithdrawInfoDO;
import com.sdp.withdraw.dao.WithdrawInfoDOExample;
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

public interface WithdrawInfoMapper {
    /**
     * 根据Example对象取得提现出款额度信息【WithdrawInfoDO】对象count信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    @SelectProvider(type=WithdrawInfoSqlProvider.class, method="countByExample")
    int countByExample(WithdrawInfoDOExample example);

    /**
     * 根据Example对象删除提现出款额度信息【WithdrawInfoDO】对象信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    @DeleteProvider(type=WithdrawInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(WithdrawInfoDOExample example);

    /**
     * 根据主键删除提现出款额度信息【WithdrawInfoDO】对象信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    @Delete({
        "delete from FW_WITHDRAW_INFO",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * 添加提现出款额度信息【WithdrawInfoDO】对象信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    @Insert({
        "insert into FW_WITHDRAW_INFO (ID, LIMITATION_TYPE, ",
        "BIZ_ID, BIZ_TYPE, ",
        "LIMITATION, FORZEN_LIMITATION, ",
        "USED_LIMITATION, CREATE_TIME, ",
        "UPDATE_TIME)",
        "values (#{id,jdbcType=DECIMAL}, #{limitationType,jdbcType=DECIMAL}, ",
        "#{bizId,jdbcType=DECIMAL}, #{bizType,jdbcType=DECIMAL}, ",
        "#{limitation,jdbcType=DECIMAL}, #{forzenLimitation,jdbcType=DECIMAL}, ",
        "#{usedLimitation,jdbcType=DECIMAL}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select SEQ_FW_WITHDRAW_INFO.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insert(WithdrawInfoDO record);

    /**
     * 添加提现出款额度信息【WithdrawInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    @InsertProvider(type=WithdrawInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_FW_WITHDRAW_INFO.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insertSelective(WithdrawInfoDO record);

    /**
     * 根据Example对象查询得到提现出款额度信息【WithdrawInfoDO】对象列表信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    @SelectProvider(type=WithdrawInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="LIMITATION_TYPE", property="limitationType", jdbcType=JdbcType.DECIMAL),
        @Result(column="BIZ_ID", property="bizId", jdbcType=JdbcType.DECIMAL),
        @Result(column="BIZ_TYPE", property="bizType", jdbcType=JdbcType.DECIMAL),
        @Result(column="LIMITATION", property="limitation", jdbcType=JdbcType.DECIMAL),
        @Result(column="FORZEN_LIMITATION", property="forzenLimitation", jdbcType=JdbcType.DECIMAL),
        @Result(column="USED_LIMITATION", property="usedLimitation", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<WithdrawInfoDO> selectByExample(WithdrawInfoDOExample example);

    /**
     * 根据Query对象分页查询提现出款额度信息【WithdrawInfoDO】对象列表信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    @SelectProvider(type=WithdrawInfoSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="LIMITATION_TYPE", property="limitationType", jdbcType=JdbcType.DECIMAL),
        @Result(column="BIZ_ID", property="bizId", jdbcType=JdbcType.DECIMAL),
        @Result(column="BIZ_TYPE", property="bizType", jdbcType=JdbcType.DECIMAL),
        @Result(column="LIMITATION", property="limitation", jdbcType=JdbcType.DECIMAL),
        @Result(column="FORZEN_LIMITATION", property="forzenLimitation", jdbcType=JdbcType.DECIMAL),
        @Result(column="USED_LIMITATION", property="usedLimitation", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<WithdrawInfoDO> selectByQuery(WithdrawInfoDOExample example);

    /**
     * 根据主键查询提现出款额度信息【WithdrawInfoDO】对象信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    @Select({
        "select",
        "ID, LIMITATION_TYPE, BIZ_ID, BIZ_TYPE, LIMITATION, FORZEN_LIMITATION, USED_LIMITATION, ",
        "CREATE_TIME, UPDATE_TIME",
        "from FW_WITHDRAW_INFO",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="LIMITATION_TYPE", property="limitationType", jdbcType=JdbcType.DECIMAL),
        @Result(column="BIZ_ID", property="bizId", jdbcType=JdbcType.DECIMAL),
        @Result(column="BIZ_TYPE", property="bizType", jdbcType=JdbcType.DECIMAL),
        @Result(column="LIMITATION", property="limitation", jdbcType=JdbcType.DECIMAL),
        @Result(column="FORZEN_LIMITATION", property="forzenLimitation", jdbcType=JdbcType.DECIMAL),
        @Result(column="USED_LIMITATION", property="usedLimitation", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    WithdrawInfoDO selectByPrimaryKey(Long id);

    /**
     * 根据Example对象更新提现出款额度信息【WithdrawInfoDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    @UpdateProvider(type=WithdrawInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WithdrawInfoDO record, @Param("example") WithdrawInfoDOExample example);

    /**
     * 根据Example对象更新提现出款额度信息【WithdrawInfoDO】对象信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    @UpdateProvider(type=WithdrawInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") WithdrawInfoDO record, @Param("example") WithdrawInfoDOExample example);

    /**
     * 根据主键更新提现出款额度信息【WithdrawInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    @UpdateProvider(type=WithdrawInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WithdrawInfoDO record);

    /**
     * 根据主键更新提现出款额度信息【WithdrawInfoDO】对象信息
     *
     * @mbggenerated Mon Mar 14 10:34:42 CST 2016
     */
    @Update({
        "update FW_WITHDRAW_INFO",
        "set LIMITATION_TYPE = #{limitationType,jdbcType=DECIMAL},",
          "BIZ_ID = #{bizId,jdbcType=DECIMAL},",
          "BIZ_TYPE = #{bizType,jdbcType=DECIMAL},",
          "LIMITATION = #{limitation,jdbcType=DECIMAL},",
          "FORZEN_LIMITATION = #{forzenLimitation,jdbcType=DECIMAL},",
          "USED_LIMITATION = #{usedLimitation,jdbcType=DECIMAL},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(WithdrawInfoDO record);
}