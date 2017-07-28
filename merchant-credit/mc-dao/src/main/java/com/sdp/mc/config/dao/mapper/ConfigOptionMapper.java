package com.sdp.mc.config.dao.mapper;

import com.sdp.mc.config.dao.ConfigOptionDO;
import com.sdp.mc.config.dao.ConfigOptionDOExample;
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

public interface ConfigOptionMapper {
    /**
     * 根据Example对象取得null【ConfigOptionDO】对象count信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    @SelectProvider(type=ConfigOptionSqlProvider.class, method="countByExample")
    int countByExample(ConfigOptionDOExample example);

    /**
     * 根据Example对象删除null【ConfigOptionDO】对象信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    @DeleteProvider(type=ConfigOptionSqlProvider.class, method="deleteByExample")
    int deleteByExample(ConfigOptionDOExample example);

    /**
     * 根据主键删除null【ConfigOptionDO】对象信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    @Delete({
        "delete from TB_CONFIG_OPTION",
        "where OPTION_ID = #{optionId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long optionId);

    /**
     * 添加null【ConfigOptionDO】对象信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    @Insert({
        "insert into TB_CONFIG_OPTION (OPTION_ID, OPTION_KEY, ",
        "OPTION_VALUE, OPTION_DEF_VALUE, ",
        "OPTION_DESC, CREATE_TIME, ",
        "UPDATE_TIME)",
        "values (#{optionId,jdbcType=DECIMAL}, #{optionKey,jdbcType=VARCHAR}, ",
        "#{optionValue,jdbcType=VARCHAR}, #{optionDefValue,jdbcType=VARCHAR}, ",
        "#{optionDesc,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select SEQ_TB_CONFIG_OPTION.nextval from dual", keyProperty="optionId", before=true, resultType=Long.class)
    Long insert(ConfigOptionDO record);

    /**
     * 添加null【ConfigOptionDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    @InsertProvider(type=ConfigOptionSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_TB_CONFIG_OPTION.nextval from dual", keyProperty="optionId", before=true, resultType=Long.class)
    Long insertSelective(ConfigOptionDO record);

    /**
     * 根据Example对象查询得到null【ConfigOptionDO】对象列表信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    @SelectProvider(type=ConfigOptionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="OPTION_ID", property="optionId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="OPTION_KEY", property="optionKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPTION_VALUE", property="optionValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPTION_DEF_VALUE", property="optionDefValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPTION_DESC", property="optionDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ConfigOptionDO> selectByExample(ConfigOptionDOExample example);

    /**
     * 根据Query对象分页查询null【ConfigOptionDO】对象列表信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    @SelectProvider(type=ConfigOptionSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="OPTION_ID", property="optionId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="OPTION_KEY", property="optionKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPTION_VALUE", property="optionValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPTION_DEF_VALUE", property="optionDefValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPTION_DESC", property="optionDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ConfigOptionDO> selectByQuery(ConfigOptionDOExample example);

    /**
     * 根据主键查询null【ConfigOptionDO】对象信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    @Select({
        "select",
        "OPTION_ID, OPTION_KEY, OPTION_VALUE, OPTION_DEF_VALUE, OPTION_DESC, CREATE_TIME, ",
        "UPDATE_TIME",
        "from TB_CONFIG_OPTION",
        "where OPTION_ID = #{optionId,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="OPTION_ID", property="optionId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="OPTION_KEY", property="optionKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPTION_VALUE", property="optionValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPTION_DEF_VALUE", property="optionDefValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPTION_DESC", property="optionDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    ConfigOptionDO selectByPrimaryKey(Long optionId);

    /**
     * 根据Example对象更新null【ConfigOptionDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    @UpdateProvider(type=ConfigOptionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ConfigOptionDO record, @Param("example") ConfigOptionDOExample example);

    /**
     * 根据Example对象更新null【ConfigOptionDO】对象信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    @UpdateProvider(type=ConfigOptionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ConfigOptionDO record, @Param("example") ConfigOptionDOExample example);

    /**
     * 根据主键更新null【ConfigOptionDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    @UpdateProvider(type=ConfigOptionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ConfigOptionDO record);

    /**
     * 根据主键更新null【ConfigOptionDO】对象信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    @Update({
        "update TB_CONFIG_OPTION",
        "set OPTION_KEY = #{optionKey,jdbcType=VARCHAR},",
          "OPTION_VALUE = #{optionValue,jdbcType=VARCHAR},",
          "OPTION_DEF_VALUE = #{optionDefValue,jdbcType=VARCHAR},",
          "OPTION_DESC = #{optionDesc,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where OPTION_ID = #{optionId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(ConfigOptionDO record);
}