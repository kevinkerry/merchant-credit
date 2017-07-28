package com.sdp.mc.newt0.dao.mapper;

import com.sdp.mc.newt0.dao.WhiteListInfoDO;
import com.sdp.mc.newt0.dao.WhiteListInfoDOExample;
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

public interface WhiteListInfoMapper {
    /**
     * 根据Example对象取得白名单信息表【WhiteListInfoDO】对象count信息
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    @SelectProvider(type=WhiteListInfoSqlProvider.class, method="countByExample")
    int countByExample(WhiteListInfoDOExample example);

    /**
     * 根据Example对象删除白名单信息表【WhiteListInfoDO】对象信息
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    @DeleteProvider(type=WhiteListInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(WhiteListInfoDOExample example);

    /**
     * 根据主键删除白名单信息表【WhiteListInfoDO】对象信息
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    @Delete({
        "delete from TB_WHITE_LIST_INFO",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * 添加白名单信息表【WhiteListInfoDO】对象信息
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    @Insert({
        "insert into TB_WHITE_LIST_INFO (ID, TYPE, ",
        "TYPE_NAME, MERCHANT_NO, ",
        "MERCHANT_TYPE, CONTENT, ",
        "CREATE_TIME, UPDATE_TIME, ",
        "CREATE_USER, UPDATE_USER, ",
        "STATUS)",
        "values (#{id,jdbcType=DECIMAL}, #{type,jdbcType=DECIMAL}, ",
        "#{typeName,jdbcType=VARCHAR}, #{merchantNo,jdbcType=VARCHAR}, ",
        "#{merchantType,jdbcType=VARCHAR}, #{content,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{createUser,jdbcType=VARCHAR}, #{updateUser,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="select SEQ_TB_WHITE_LIST_INFO.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insert(WhiteListInfoDO record);

    /**
     * 添加白名单信息表【WhiteListInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    @InsertProvider(type=WhiteListInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_TB_WHITE_LIST_INFO.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insertSelective(WhiteListInfoDO record);

    /**
     * 根据Example对象查询得到白名单信息表【WhiteListInfoDO】对象列表信息
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    @SelectProvider(type=WhiteListInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.DECIMAL),
        @Result(column="TYPE_NAME", property="typeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_TYPE", property="merchantType", jdbcType=JdbcType.VARCHAR),
        @Result(column="CONTENT", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_USER", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_USER", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL)
    })
    List<WhiteListInfoDO> selectByExample(WhiteListInfoDOExample example);

    /**
     * 根据Query对象分页查询白名单信息表【WhiteListInfoDO】对象列表信息
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    @SelectProvider(type=WhiteListInfoSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.DECIMAL),
        @Result(column="TYPE_NAME", property="typeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_TYPE", property="merchantType", jdbcType=JdbcType.VARCHAR),
        @Result(column="CONTENT", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_USER", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_USER", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL)
    })
    List<WhiteListInfoDO> selectByQuery(WhiteListInfoDOExample example);

    /**
     * 根据主键查询白名单信息表【WhiteListInfoDO】对象信息
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    @Select({
        "select",
        "ID, TYPE, TYPE_NAME, MERCHANT_NO, MERCHANT_TYPE, CONTENT, CREATE_TIME, UPDATE_TIME, ",
        "CREATE_USER, UPDATE_USER, STATUS",
        "from TB_WHITE_LIST_INFO",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.DECIMAL),
        @Result(column="TYPE_NAME", property="typeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_TYPE", property="merchantType", jdbcType=JdbcType.VARCHAR),
        @Result(column="CONTENT", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_USER", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_USER", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL)
    })
    WhiteListInfoDO selectByPrimaryKey(Long id);

    /**
     * 根据Example对象更新白名单信息表【WhiteListInfoDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    @UpdateProvider(type=WhiteListInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WhiteListInfoDO record, @Param("example") WhiteListInfoDOExample example);

    /**
     * 根据Example对象更新白名单信息表【WhiteListInfoDO】对象信息
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    @UpdateProvider(type=WhiteListInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") WhiteListInfoDO record, @Param("example") WhiteListInfoDOExample example);

    /**
     * 根据主键更新白名单信息表【WhiteListInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    @UpdateProvider(type=WhiteListInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WhiteListInfoDO record);

    /**
     * 根据主键更新白名单信息表【WhiteListInfoDO】对象信息
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    @Update({
        "update TB_WHITE_LIST_INFO",
        "set TYPE = #{type,jdbcType=DECIMAL},",
          "TYPE_NAME = #{typeName,jdbcType=VARCHAR},",
          "MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR},",
          "MERCHANT_TYPE = #{merchantType,jdbcType=VARCHAR},",
          "CONTENT = #{content,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "CREATE_USER = #{createUser,jdbcType=VARCHAR},",
          "UPDATE_USER = #{updateUser,jdbcType=VARCHAR},",
          "STATUS = #{status,jdbcType=DECIMAL}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(WhiteListInfoDO record);
}