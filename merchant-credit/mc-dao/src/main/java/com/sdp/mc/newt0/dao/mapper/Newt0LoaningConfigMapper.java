package com.sdp.mc.newt0.dao.mapper;

import com.sdp.mc.newt0.dao.Newt0LoaningConfigDO;
import com.sdp.mc.newt0.dao.Newt0LoaningConfigDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface Newt0LoaningConfigMapper {
    /**
     * 根据Example对象取得垫资方配置信息【Newt0LoaningConfigDO】对象count信息
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    @SelectProvider(type=Newt0LoaningConfigSqlProvider.class, method="countByExample")
    int countByExample(Newt0LoaningConfigDOExample example);

    /**
     * 根据Example对象删除垫资方配置信息【Newt0LoaningConfigDO】对象信息
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    @DeleteProvider(type=Newt0LoaningConfigSqlProvider.class, method="deleteByExample")
    int deleteByExample(Newt0LoaningConfigDOExample example);

    /**
     * 根据主键删除垫资方配置信息【Newt0LoaningConfigDO】对象信息
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    @Delete({
        "delete from NEWT0_LOANING_CONFIG",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * 添加垫资方配置信息【Newt0LoaningConfigDO】对象信息
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    @Insert({
        "insert into NEWT0_LOANING_CONFIG (ID, LOANING_TYPE, ",
        "CONTENT, CREATE_TIME, ",
        "UPDATE_TIME)",
        "values (#{id,jdbcType=DECIMAL}, #{loaningType,jdbcType=DECIMAL}, ",
        "#{content,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    Long insert(Newt0LoaningConfigDO record);

    /**
     * 添加垫资方配置信息【Newt0LoaningConfigDO】对象信息,空值字段不插入
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    @InsertProvider(type=Newt0LoaningConfigSqlProvider.class, method="insertSelective")
    Long insertSelective(Newt0LoaningConfigDO record);

    /**
     * 根据Example对象查询得到垫资方配置信息【Newt0LoaningConfigDO】对象列表信息
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    @SelectProvider(type=Newt0LoaningConfigSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="CONTENT", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Newt0LoaningConfigDO> selectByExample(Newt0LoaningConfigDOExample example);

    /**
     * 根据Query对象分页查询垫资方配置信息【Newt0LoaningConfigDO】对象列表信息
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    @SelectProvider(type=Newt0LoaningConfigSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="CONTENT", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Newt0LoaningConfigDO> selectByQuery(Newt0LoaningConfigDOExample example);

    /**
     * 根据主键查询垫资方配置信息【Newt0LoaningConfigDO】对象信息
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    @Select({
        "select",
        "ID, LOANING_TYPE, CONTENT, CREATE_TIME, UPDATE_TIME",
        "from NEWT0_LOANING_CONFIG",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="CONTENT", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Newt0LoaningConfigDO selectByPrimaryKey(Long id);

    /**
     * 根据Example对象更新垫资方配置信息【Newt0LoaningConfigDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    @UpdateProvider(type=Newt0LoaningConfigSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Newt0LoaningConfigDO record, @Param("example") Newt0LoaningConfigDOExample example);

    /**
     * 根据Example对象更新垫资方配置信息【Newt0LoaningConfigDO】对象信息
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    @UpdateProvider(type=Newt0LoaningConfigSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Newt0LoaningConfigDO record, @Param("example") Newt0LoaningConfigDOExample example);

    /**
     * 根据主键更新垫资方配置信息【Newt0LoaningConfigDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    @UpdateProvider(type=Newt0LoaningConfigSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Newt0LoaningConfigDO record);

    /**
     * 根据主键更新垫资方配置信息【Newt0LoaningConfigDO】对象信息
     *
     * @mbggenerated Thu Oct 01 17:46:18 CST 2015
     */
    @Update({
        "update NEWT0_LOANING_CONFIG",
        "set LOANING_TYPE = #{loaningType,jdbcType=DECIMAL},",
          "CONTENT = #{content,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(Newt0LoaningConfigDO record);
}