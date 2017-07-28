package com.sdp.mc.newt0.dao.mapper;

import com.sdp.mc.newt0.dao.NewT0UserOperaRecordDO;
import com.sdp.mc.newt0.dao.NewT0UserOperaRecordDOExample;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface NewT0UserOperaRecordMapper {
    /**
     * 根据Example对象取得保证金赎回放款操作表【NewT0UserOperaRecordDO】对象count信息
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    @SelectProvider(type=NewT0UserOperaRecordSqlProvider.class, method="countByExample")
    int countByExample(NewT0UserOperaRecordDOExample example);

    /**
     * 根据Example对象删除保证金赎回放款操作表【NewT0UserOperaRecordDO】对象信息
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    @DeleteProvider(type=NewT0UserOperaRecordSqlProvider.class, method="deleteByExample")
    int deleteByExample(NewT0UserOperaRecordDOExample example);

    /**
     * 添加保证金赎回放款操作表【NewT0UserOperaRecordDO】对象信息
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    @Insert({
        "insert into NEWT0_USEROPERA_RECORD (ID, BIZ_ID, ",
        "REALNAME, USERNAME, ",
        "BIZ_TYPE, OPERA_TIME, ",
        "CREATE_TIME, UPDATE_TIME)",
        "values (#{id,jdbcType=DECIMAL}, #{bizId,jdbcType=DECIMAL}, ",
        "#{realname,jdbcType=VARCHAR}, #{username,jdbcType=VARCHAR}, ",
        "#{bizType,jdbcType=DECIMAL}, #{operaTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select SEQ_NEWT0_USEROPERA_RECORD.nextval  from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insert(NewT0UserOperaRecordDO record);

    /**
     * 添加保证金赎回放款操作表【NewT0UserOperaRecordDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    @InsertProvider(type=NewT0UserOperaRecordSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_NEWT0_USEROPERA_RECORD.nextval  from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insertSelective(NewT0UserOperaRecordDO record);

    /**
     * 根据Example对象查询得到保证金赎回放款操作表【NewT0UserOperaRecordDO】对象列表信息
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    @SelectProvider(type=NewT0UserOperaRecordSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL),
        @Result(column="BIZ_ID", property="bizId", jdbcType=JdbcType.DECIMAL),
        @Result(column="REALNAME", property="realname", jdbcType=JdbcType.VARCHAR),
        @Result(column="USERNAME", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="BIZ_TYPE", property="bizType", jdbcType=JdbcType.DECIMAL),
        @Result(column="OPERA_TIME", property="operaTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<NewT0UserOperaRecordDO> selectByExample(NewT0UserOperaRecordDOExample example);

    /**
     * 根据Query对象分页查询保证金赎回放款操作表【NewT0UserOperaRecordDO】对象列表信息
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    @SelectProvider(type=NewT0UserOperaRecordSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL),
        @Result(column="BIZ_ID", property="bizId", jdbcType=JdbcType.DECIMAL),
        @Result(column="REALNAME", property="realname", jdbcType=JdbcType.VARCHAR),
        @Result(column="USERNAME", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="BIZ_TYPE", property="bizType", jdbcType=JdbcType.DECIMAL),
        @Result(column="OPERA_TIME", property="operaTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<NewT0UserOperaRecordDO> selectByQuery(NewT0UserOperaRecordDOExample example);

    /**
     * 根据Example对象更新保证金赎回放款操作表【NewT0UserOperaRecordDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    @UpdateProvider(type=NewT0UserOperaRecordSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") NewT0UserOperaRecordDO record, @Param("example") NewT0UserOperaRecordDOExample example);

    /**
     * 根据Example对象更新保证金赎回放款操作表【NewT0UserOperaRecordDO】对象信息
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    @UpdateProvider(type=NewT0UserOperaRecordSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") NewT0UserOperaRecordDO record, @Param("example") NewT0UserOperaRecordDOExample example);
}