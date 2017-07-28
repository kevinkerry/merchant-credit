package com.sdp.mc.newt0.dao.mapper;

import com.sdp.mc.newt0.dao.MessageTemplateDO;
import com.sdp.mc.newt0.dao.MessageTemplateDOExample;
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

public interface MessageTemplateMapper {
    /**
     * 根据Example对象取得短信模板表【MessageTemplateDO】对象count信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    @SelectProvider(type=MessageTemplateSqlProvider.class, method="countByExample")
    int countByExample(MessageTemplateDOExample example);

    /**
     * 根据Example对象删除短信模板表【MessageTemplateDO】对象信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    @DeleteProvider(type=MessageTemplateSqlProvider.class, method="deleteByExample")
    int deleteByExample(MessageTemplateDOExample example);

    /**
     * 根据主键删除短信模板表【MessageTemplateDO】对象信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    @Delete({
        "delete from TB_MESSAGE_TEMPLATE",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * 添加短信模板表【MessageTemplateDO】对象信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    @Insert({
        "insert into TB_MESSAGE_TEMPLATE (ID, TEMPLATE_CODE, ",
        "TEMPLATE_INFO, SEND_RULE, ",
        "OPERATOR, OPERATOR_ID, ",
        "CREATED_AT, UPDATED_AT, ",
        "EXT1, EXT2)",
        "values (#{id,jdbcType=DECIMAL}, #{templateCode,jdbcType=VARCHAR}, ",
        "#{templateInfo,jdbcType=VARCHAR}, #{sendRule,jdbcType=VARCHAR}, ",
        "#{operator,jdbcType=VARCHAR}, #{operatorId,jdbcType=VARCHAR}, ",
        "#{createdAt,jdbcType=TIMESTAMP}, #{updatedAt,jdbcType=TIMESTAMP}, ",
        "#{ext1,jdbcType=VARCHAR}, #{ext2,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="select SEQ_TB_MESSAGE_TEMPLATE.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insert(MessageTemplateDO record);

    /**
     * 添加短信模板表【MessageTemplateDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    @InsertProvider(type=MessageTemplateSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_TB_MESSAGE_TEMPLATE.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insertSelective(MessageTemplateDO record);

    /**
     * 根据Example对象查询得到短信模板表【MessageTemplateDO】对象列表信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    @SelectProvider(type=MessageTemplateSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="TEMPLATE_CODE", property="templateCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="TEMPLATE_INFO", property="templateInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="SEND_RULE", property="sendRule", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERATOR", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERATOR_ID", property="operatorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATED_AT", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATED_AT", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="EXT1", property="ext1", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXT2", property="ext2", jdbcType=JdbcType.VARCHAR)
    })
    List<MessageTemplateDO> selectByExample(MessageTemplateDOExample example);

    /**
     * 根据Query对象分页查询短信模板表【MessageTemplateDO】对象列表信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    @SelectProvider(type=MessageTemplateSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="TEMPLATE_CODE", property="templateCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="TEMPLATE_INFO", property="templateInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="SEND_RULE", property="sendRule", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERATOR", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERATOR_ID", property="operatorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATED_AT", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATED_AT", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="EXT1", property="ext1", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXT2", property="ext2", jdbcType=JdbcType.VARCHAR)
    })
    List<MessageTemplateDO> selectByQuery(MessageTemplateDOExample example);

    /**
     * 根据主键查询短信模板表【MessageTemplateDO】对象信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    @Select({
        "select",
        "ID, TEMPLATE_CODE, TEMPLATE_INFO, SEND_RULE, OPERATOR, OPERATOR_ID, CREATED_AT, ",
        "UPDATED_AT, EXT1, EXT2",
        "from TB_MESSAGE_TEMPLATE",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="TEMPLATE_CODE", property="templateCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="TEMPLATE_INFO", property="templateInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="SEND_RULE", property="sendRule", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERATOR", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERATOR_ID", property="operatorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATED_AT", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATED_AT", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="EXT1", property="ext1", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXT2", property="ext2", jdbcType=JdbcType.VARCHAR)
    })
    MessageTemplateDO selectByPrimaryKey(Long id);

    /**
     * 根据Example对象更新短信模板表【MessageTemplateDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    @UpdateProvider(type=MessageTemplateSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MessageTemplateDO record, @Param("example") MessageTemplateDOExample example);

    /**
     * 根据Example对象更新短信模板表【MessageTemplateDO】对象信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    @UpdateProvider(type=MessageTemplateSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MessageTemplateDO record, @Param("example") MessageTemplateDOExample example);

    /**
     * 根据主键更新短信模板表【MessageTemplateDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    @UpdateProvider(type=MessageTemplateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MessageTemplateDO record);

    /**
     * 根据主键更新短信模板表【MessageTemplateDO】对象信息
     *
     * @mbggenerated Mon Oct 12 13:53:07 CST 2015
     */
    @Update({
        "update TB_MESSAGE_TEMPLATE",
        "set TEMPLATE_CODE = #{templateCode,jdbcType=VARCHAR},",
          "TEMPLATE_INFO = #{templateInfo,jdbcType=VARCHAR},",
          "SEND_RULE = #{sendRule,jdbcType=VARCHAR},",
          "OPERATOR = #{operator,jdbcType=VARCHAR},",
          "OPERATOR_ID = #{operatorId,jdbcType=VARCHAR},",
          "CREATED_AT = #{createdAt,jdbcType=TIMESTAMP},",
          "UPDATED_AT = #{updatedAt,jdbcType=TIMESTAMP},",
          "EXT1 = #{ext1,jdbcType=VARCHAR},",
          "EXT2 = #{ext2,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(MessageTemplateDO record);
}