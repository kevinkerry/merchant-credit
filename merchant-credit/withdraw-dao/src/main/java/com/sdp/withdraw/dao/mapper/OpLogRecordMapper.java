package com.sdp.withdraw.dao.mapper;

import com.sdp.withdraw.dao.OpLogRecordDO;
import com.sdp.withdraw.dao.OpLogRecordDOExample;
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

public interface OpLogRecordMapper {
    /**
     * 根据Example对象取得操作历史记录【OpLogRecordDO】对象count信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    @SelectProvider(type=OpLogRecordSqlProvider.class, method="countByExample")
    int countByExample(OpLogRecordDOExample example);

    /**
     * 根据Example对象删除操作历史记录【OpLogRecordDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    @DeleteProvider(type=OpLogRecordSqlProvider.class, method="deleteByExample")
    int deleteByExample(OpLogRecordDOExample example);

    /**
     * 根据主键删除操作历史记录【OpLogRecordDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    @Delete({
        "delete from OP_LOG_RECORD",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * 添加操作历史记录【OpLogRecordDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    @Insert({
        "insert into OP_LOG_RECORD (ID, RECORD_TYPE, ",
        "OP_TYPE, OP_RECORD, ",
        "CREATE_TIME, UPDATE_TIME)",
        "values (#{id,jdbcType=DECIMAL}, #{recordType,jdbcType=VARCHAR}, ",
        "#{opType,jdbcType=VARCHAR}, #{opRecord,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select SEQ_OP_LOG_RECORD.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insert(OpLogRecordDO record);

    /**
     * 添加操作历史记录【OpLogRecordDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    @InsertProvider(type=OpLogRecordSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_OP_LOG_RECORD.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insertSelective(OpLogRecordDO record);

    /**
     * 根据Example对象查询得到操作历史记录【OpLogRecordDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    @SelectProvider(type=OpLogRecordSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="RECORD_TYPE", property="recordType", jdbcType=JdbcType.VARCHAR),
        @Result(column="OP_TYPE", property="opType", jdbcType=JdbcType.VARCHAR),
        @Result(column="OP_RECORD", property="opRecord", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpLogRecordDO> selectByExample(OpLogRecordDOExample example);

    /**
     * 根据Query对象分页查询操作历史记录【OpLogRecordDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    @SelectProvider(type=OpLogRecordSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="RECORD_TYPE", property="recordType", jdbcType=JdbcType.VARCHAR),
        @Result(column="OP_TYPE", property="opType", jdbcType=JdbcType.VARCHAR),
        @Result(column="OP_RECORD", property="opRecord", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OpLogRecordDO> selectByQuery(OpLogRecordDOExample example);

    /**
     * 根据主键查询操作历史记录【OpLogRecordDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    @Select({
        "select",
        "ID, RECORD_TYPE, OP_TYPE, OP_RECORD, CREATE_TIME, UPDATE_TIME",
        "from OP_LOG_RECORD",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="RECORD_TYPE", property="recordType", jdbcType=JdbcType.VARCHAR),
        @Result(column="OP_TYPE", property="opType", jdbcType=JdbcType.VARCHAR),
        @Result(column="OP_RECORD", property="opRecord", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OpLogRecordDO selectByPrimaryKey(Long id);

    /**
     * 根据Example对象更新操作历史记录【OpLogRecordDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    @UpdateProvider(type=OpLogRecordSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OpLogRecordDO record, @Param("example") OpLogRecordDOExample example);

    /**
     * 根据Example对象更新操作历史记录【OpLogRecordDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    @UpdateProvider(type=OpLogRecordSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OpLogRecordDO record, @Param("example") OpLogRecordDOExample example);

    /**
     * 根据主键更新操作历史记录【OpLogRecordDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    @UpdateProvider(type=OpLogRecordSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OpLogRecordDO record);

    /**
     * 根据主键更新操作历史记录【OpLogRecordDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    @Update({
        "update OP_LOG_RECORD",
        "set RECORD_TYPE = #{recordType,jdbcType=VARCHAR},",
          "OP_TYPE = #{opType,jdbcType=VARCHAR},",
          "OP_RECORD = #{opRecord,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(OpLogRecordDO record);
}