package com.sdp.mc.ffconfig.dao.mapper;

import com.sdp.mc.ffconfig.dao.FastSettleConfigDO;
import com.sdp.mc.ffconfig.dao.FastSettleConfigDOExample;
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

public interface FastSettleConfigMapper {
    /**
     * 根据Example对象取得null【FastSettleConfigDO】对象count信息
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    @SelectProvider(type=FastSettleConfigSqlProvider.class, method="countByExample")
    int countByExample(FastSettleConfigDOExample example);

    /**
     * 根据Example对象删除null【FastSettleConfigDO】对象信息
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    @DeleteProvider(type=FastSettleConfigSqlProvider.class, method="deleteByExample")
    int deleteByExample(FastSettleConfigDOExample example);

    /**
     * 根据主键删除null【FastSettleConfigDO】对象信息
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    @Delete({
        "delete from TB_FAST_SETTLE_CONFIG",
        "where PFC_ID = #{pfcId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long pfcId);

    /**
     * 添加null【FastSettleConfigDO】对象信息
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    @Insert({
        "insert into TB_FAST_SETTLE_CONFIG (PFC_ID, OBJ_ID, ",
        "OBJ_TYPE, AUTO_FAST_SETTLE, ",
        "CREATE_TIME, UPDATE_TIME, ",
        "MERCHANT_PHONE)",
        "values (#{pfcId,jdbcType=DECIMAL}, #{objId,jdbcType=DECIMAL}, ",
        "#{objType,jdbcType=VARCHAR}, #{autoFastSettle,jdbcType=DECIMAL}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{merchantPhone,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="select SEQ_TB_FAST_SETTLE_CONFIG.nextval from dual", keyProperty="pfcId", before=true, resultType=Long.class)
    Long insert(FastSettleConfigDO record);

    /**
     * 添加null【FastSettleConfigDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    @InsertProvider(type=FastSettleConfigSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_TB_FAST_SETTLE_CONFIG.nextval from dual", keyProperty="pfcId", before=true, resultType=Long.class)
    Long insertSelective(FastSettleConfigDO record);

    /**
     * 根据Example对象查询得到null【FastSettleConfigDO】对象列表信息
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    @SelectProvider(type=FastSettleConfigSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="PFC_ID", property="pfcId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="OBJ_ID", property="objId", jdbcType=JdbcType.DECIMAL),
        @Result(column="OBJ_TYPE", property="objType", jdbcType=JdbcType.VARCHAR),
        @Result(column="AUTO_FAST_SETTLE", property="autoFastSettle", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MERCHANT_PHONE", property="merchantPhone", jdbcType=JdbcType.VARCHAR)
    })
    List<FastSettleConfigDO> selectByExample(FastSettleConfigDOExample example);

    /**
     * 根据Query对象分页查询null【FastSettleConfigDO】对象列表信息
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    @SelectProvider(type=FastSettleConfigSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="PFC_ID", property="pfcId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="OBJ_ID", property="objId", jdbcType=JdbcType.DECIMAL),
        @Result(column="OBJ_TYPE", property="objType", jdbcType=JdbcType.VARCHAR),
        @Result(column="AUTO_FAST_SETTLE", property="autoFastSettle", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MERCHANT_PHONE", property="merchantPhone", jdbcType=JdbcType.VARCHAR)
    })
    List<FastSettleConfigDO> selectByQuery(FastSettleConfigDOExample example);

    /**
     * 根据主键查询null【FastSettleConfigDO】对象信息
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    @Select({
        "select",
        "PFC_ID, OBJ_ID, OBJ_TYPE, AUTO_FAST_SETTLE, CREATE_TIME, UPDATE_TIME, MERCHANT_PHONE",
        "from TB_FAST_SETTLE_CONFIG",
        "where PFC_ID = #{pfcId,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="PFC_ID", property="pfcId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="OBJ_ID", property="objId", jdbcType=JdbcType.DECIMAL),
        @Result(column="OBJ_TYPE", property="objType", jdbcType=JdbcType.VARCHAR),
        @Result(column="AUTO_FAST_SETTLE", property="autoFastSettle", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MERCHANT_PHONE", property="merchantPhone", jdbcType=JdbcType.VARCHAR)
    })
    FastSettleConfigDO selectByPrimaryKey(Long pfcId);

    /**
     * 根据Example对象更新null【FastSettleConfigDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    @UpdateProvider(type=FastSettleConfigSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") FastSettleConfigDO record, @Param("example") FastSettleConfigDOExample example);

    /**
     * 根据Example对象更新null【FastSettleConfigDO】对象信息
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    @UpdateProvider(type=FastSettleConfigSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") FastSettleConfigDO record, @Param("example") FastSettleConfigDOExample example);

    /**
     * 根据主键更新null【FastSettleConfigDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    @UpdateProvider(type=FastSettleConfigSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FastSettleConfigDO record);

    /**
     * 根据主键更新null【FastSettleConfigDO】对象信息
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    @Update({
        "update TB_FAST_SETTLE_CONFIG",
        "set OBJ_ID = #{objId,jdbcType=DECIMAL},",
          "OBJ_TYPE = #{objType,jdbcType=VARCHAR},",
          "AUTO_FAST_SETTLE = #{autoFastSettle,jdbcType=DECIMAL},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "MERCHANT_PHONE = #{merchantPhone,jdbcType=VARCHAR}",
        "where PFC_ID = #{pfcId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(FastSettleConfigDO record);
}