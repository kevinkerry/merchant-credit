package com.sdp.mc.newt0.dao.mapper;

import com.sdp.mc.newt0.dao.SendMessageLogDO;
import com.sdp.mc.newt0.dao.SendMessageLogDOExample;
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

public interface SendMessageLogMapper {
    /**
     * 根据Example对象取得短信发送日志表【SendMessageLogDO】对象count信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    @SelectProvider(type=SendMessageLogSqlProvider.class, method="countByExample")
    int countByExample(SendMessageLogDOExample example);

    /**
     * 根据Example对象删除短信发送日志表【SendMessageLogDO】对象信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    @DeleteProvider(type=SendMessageLogSqlProvider.class, method="deleteByExample")
    int deleteByExample(SendMessageLogDOExample example);

    /**
     * 根据主键删除短信发送日志表【SendMessageLogDO】对象信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    @Delete({
        "delete from TB_SEND_MESSAGE_LOG",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * 添加短信发送日志表【SendMessageLogDO】对象信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    @Insert({
        "insert into TB_SEND_MESSAGE_LOG (ID, PHONE, ",
        "TEMPLATE_CODE, MESSAGE_INFO, ",
        "SEND_STATE, SEND_RESULT_INFO, ",
        "OPERATOR, OPERATOR_ID, ",
        "CREATED_AT, UPDATED_AT, ",
        "EXT1, EXT2)",
        "values (#{id,jdbcType=DECIMAL}, #{phone,jdbcType=VARCHAR}, ",
        "#{templateCode,jdbcType=VARCHAR}, #{messageInfo,jdbcType=VARCHAR}, ",
        "#{sendState,jdbcType=VARCHAR}, #{sendResultInfo,jdbcType=VARCHAR}, ",
        "#{operator,jdbcType=VARCHAR}, #{operatorId,jdbcType=VARCHAR}, ",
        "#{createdAt,jdbcType=TIMESTAMP}, #{updatedAt,jdbcType=TIMESTAMP}, ",
        "#{ext1,jdbcType=VARCHAR}, #{ext2,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="select SEQ_TB_SEND_MESSAGE_LOG.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insert(SendMessageLogDO record);

    /**
     * 添加短信发送日志表【SendMessageLogDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    @InsertProvider(type=SendMessageLogSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_TB_SEND_MESSAGE_LOG.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insertSelective(SendMessageLogDO record);

    /**
     * 根据Example对象查询得到短信发送日志表【SendMessageLogDO】对象列表信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    @SelectProvider(type=SendMessageLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="PHONE", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="TEMPLATE_CODE", property="templateCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="MESSAGE_INFO", property="messageInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="SEND_STATE", property="sendState", jdbcType=JdbcType.VARCHAR),
        @Result(column="SEND_RESULT_INFO", property="sendResultInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERATOR", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERATOR_ID", property="operatorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATED_AT", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATED_AT", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="EXT1", property="ext1", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXT2", property="ext2", jdbcType=JdbcType.VARCHAR)
    })
    List<SendMessageLogDO> selectByExample(SendMessageLogDOExample example);

    /**
     * 根据Query对象分页查询短信发送日志表【SendMessageLogDO】对象列表信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    @SelectProvider(type=SendMessageLogSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="PHONE", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="TEMPLATE_CODE", property="templateCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="MESSAGE_INFO", property="messageInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="SEND_STATE", property="sendState", jdbcType=JdbcType.VARCHAR),
        @Result(column="SEND_RESULT_INFO", property="sendResultInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERATOR", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERATOR_ID", property="operatorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATED_AT", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATED_AT", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="EXT1", property="ext1", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXT2", property="ext2", jdbcType=JdbcType.VARCHAR)
    })
    List<SendMessageLogDO> selectByQuery(SendMessageLogDOExample example);

    /**
     * 根据主键查询短信发送日志表【SendMessageLogDO】对象信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    @Select({
        "select",
        "ID, PHONE, TEMPLATE_CODE, MESSAGE_INFO, SEND_STATE, SEND_RESULT_INFO, OPERATOR, ",
        "OPERATOR_ID, CREATED_AT, UPDATED_AT, EXT1, EXT2",
        "from TB_SEND_MESSAGE_LOG",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="PHONE", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="TEMPLATE_CODE", property="templateCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="MESSAGE_INFO", property="messageInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="SEND_STATE", property="sendState", jdbcType=JdbcType.VARCHAR),
        @Result(column="SEND_RESULT_INFO", property="sendResultInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERATOR", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERATOR_ID", property="operatorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATED_AT", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATED_AT", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="EXT1", property="ext1", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXT2", property="ext2", jdbcType=JdbcType.VARCHAR)
    })
    SendMessageLogDO selectByPrimaryKey(Long id);

    /**
     * 根据Example对象更新短信发送日志表【SendMessageLogDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    @UpdateProvider(type=SendMessageLogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SendMessageLogDO record, @Param("example") SendMessageLogDOExample example);

    /**
     * 根据Example对象更新短信发送日志表【SendMessageLogDO】对象信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    @UpdateProvider(type=SendMessageLogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SendMessageLogDO record, @Param("example") SendMessageLogDOExample example);

    /**
     * 根据主键更新短信发送日志表【SendMessageLogDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    @UpdateProvider(type=SendMessageLogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SendMessageLogDO record);

    /**
     * 根据主键更新短信发送日志表【SendMessageLogDO】对象信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    @Update({
        "update TB_SEND_MESSAGE_LOG",
        "set PHONE = #{phone,jdbcType=VARCHAR},",
          "TEMPLATE_CODE = #{templateCode,jdbcType=VARCHAR},",
          "MESSAGE_INFO = #{messageInfo,jdbcType=VARCHAR},",
          "SEND_STATE = #{sendState,jdbcType=VARCHAR},",
          "SEND_RESULT_INFO = #{sendResultInfo,jdbcType=VARCHAR},",
          "OPERATOR = #{operator,jdbcType=VARCHAR},",
          "OPERATOR_ID = #{operatorId,jdbcType=VARCHAR},",
          "CREATED_AT = #{createdAt,jdbcType=TIMESTAMP},",
          "UPDATED_AT = #{updatedAt,jdbcType=TIMESTAMP},",
          "EXT1 = #{ext1,jdbcType=VARCHAR},",
          "EXT2 = #{ext2,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(SendMessageLogDO record);
}