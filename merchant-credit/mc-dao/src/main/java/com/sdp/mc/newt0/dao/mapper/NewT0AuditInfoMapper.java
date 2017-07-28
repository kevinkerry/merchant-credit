package com.sdp.mc.newt0.dao.mapper;

import com.sdp.mc.newt0.dao.NewT0AuditInfoDO;
import com.sdp.mc.newt0.dao.NewT0AuditInfoDOExample;
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

public interface NewT0AuditInfoMapper {
    /**
     * 根据Example对象取得审核表【NewT0AuditInfoDO】对象count信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    @SelectProvider(type=NewT0AuditInfoSqlProvider.class, method="countByExample")
    int countByExample(NewT0AuditInfoDOExample example);

    /**
     * 根据Example对象删除审核表【NewT0AuditInfoDO】对象信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    @DeleteProvider(type=NewT0AuditInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(NewT0AuditInfoDOExample example);

    /**
     * 根据主键删除审核表【NewT0AuditInfoDO】对象信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    @Delete({
        "delete from NEWT0_AUDIT_INFO",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * 添加审核表【NewT0AuditInfoDO】对象信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    @Insert({
        "insert into NEWT0_AUDIT_INFO (ID, OBJ_NO, ",
        "OBJ_ID, OBJ_TYPE, ",
        "OP_TYPE, REQUEST_LOG, ",
        "STATUS, CREATE_TIME, ",
        "UPDATE_TIME, OPERATOR, ",
        "OPERATOR_ID, EXPIRE_TIME, ",
        "MCTYPE, AUDIT_TIME)",
        "values (#{id,jdbcType=DECIMAL}, #{objNo,jdbcType=VARCHAR}, ",
        "#{objId,jdbcType=DECIMAL}, #{objType,jdbcType=DECIMAL}, ",
        "#{opType,jdbcType=DECIMAL}, #{requestLog,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=DECIMAL}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{operator,jdbcType=VARCHAR}, ",
        "#{operatorId,jdbcType=VARCHAR}, #{expireTime,jdbcType=TIMESTAMP}, ",
        "#{mcType,jdbcType=VARCHAR}, #{auditTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select seq_newt0_audit_info.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insert(NewT0AuditInfoDO record);

    /**
     * 添加审核表【NewT0AuditInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    @InsertProvider(type=NewT0AuditInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select seq_newt0_audit_info.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insertSelective(NewT0AuditInfoDO record);

    /**
     * 根据Example对象查询得到审核表【NewT0AuditInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    @SelectProvider(type=NewT0AuditInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="OBJ_NO", property="objNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="OBJ_ID", property="objId", jdbcType=JdbcType.DECIMAL),
        @Result(column="OBJ_TYPE", property="objType", jdbcType=JdbcType.DECIMAL),
        @Result(column="OP_TYPE", property="opType", jdbcType=JdbcType.DECIMAL),
        @Result(column="REQUEST_LOG", property="requestLog", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="OPERATOR", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERATOR_ID", property="operatorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXPIRE_TIME", property="expireTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MCTYPE", property="mcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="AUDIT_TIME", property="auditTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<NewT0AuditInfoDO> selectByExample(NewT0AuditInfoDOExample example);

    /**
     * 根据Query对象分页查询审核表【NewT0AuditInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    @SelectProvider(type=NewT0AuditInfoSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="OBJ_NO", property="objNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="OBJ_ID", property="objId", jdbcType=JdbcType.DECIMAL),
        @Result(column="OBJ_TYPE", property="objType", jdbcType=JdbcType.DECIMAL),
        @Result(column="OP_TYPE", property="opType", jdbcType=JdbcType.DECIMAL),
        @Result(column="REQUEST_LOG", property="requestLog", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="OPERATOR", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERATOR_ID", property="operatorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXPIRE_TIME", property="expireTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MCTYPE", property="mcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="AUDIT_TIME", property="auditTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<NewT0AuditInfoDO> selectByQuery(NewT0AuditInfoDOExample example);

    /**
     * 根据主键查询审核表【NewT0AuditInfoDO】对象信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    @Select({
        "select",
        "ID, OBJ_NO, OBJ_ID, OBJ_TYPE, OP_TYPE, REQUEST_LOG, STATUS, CREATE_TIME, UPDATE_TIME, ",
        "OPERATOR, OPERATOR_ID, EXPIRE_TIME, MCTYPE, AUDIT_TIME",
        "from NEWT0_AUDIT_INFO",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="OBJ_NO", property="objNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="OBJ_ID", property="objId", jdbcType=JdbcType.DECIMAL),
        @Result(column="OBJ_TYPE", property="objType", jdbcType=JdbcType.DECIMAL),
        @Result(column="OP_TYPE", property="opType", jdbcType=JdbcType.DECIMAL),
        @Result(column="REQUEST_LOG", property="requestLog", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="OPERATOR", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERATOR_ID", property="operatorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXPIRE_TIME", property="expireTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MCTYPE", property="mcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="AUDIT_TIME", property="auditTime", jdbcType=JdbcType.TIMESTAMP)
    })
    NewT0AuditInfoDO selectByPrimaryKey(Long id);

    /**
     * 根据Example对象更新审核表【NewT0AuditInfoDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    @UpdateProvider(type=NewT0AuditInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") NewT0AuditInfoDO record, @Param("example") NewT0AuditInfoDOExample example);

    /**
     * 根据Example对象更新审核表【NewT0AuditInfoDO】对象信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    @UpdateProvider(type=NewT0AuditInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") NewT0AuditInfoDO record, @Param("example") NewT0AuditInfoDOExample example);

    /**
     * 根据主键更新审核表【NewT0AuditInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    @UpdateProvider(type=NewT0AuditInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(NewT0AuditInfoDO record);

    /**
     * 根据主键更新审核表【NewT0AuditInfoDO】对象信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    @Update({
        "update NEWT0_AUDIT_INFO",
        "set OBJ_NO = #{objNo,jdbcType=VARCHAR},",
          "OBJ_ID = #{objId,jdbcType=DECIMAL},",
          "OBJ_TYPE = #{objType,jdbcType=DECIMAL},",
          "OP_TYPE = #{opType,jdbcType=DECIMAL},",
          "REQUEST_LOG = #{requestLog,jdbcType=VARCHAR},",
          "STATUS = #{status,jdbcType=DECIMAL},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "OPERATOR = #{operator,jdbcType=VARCHAR},",
          "OPERATOR_ID = #{operatorId,jdbcType=VARCHAR},",
          "EXPIRE_TIME = #{expireTime,jdbcType=TIMESTAMP},",
          "MCTYPE = #{mcType,jdbcType=VARCHAR},",
          "AUDIT_TIME = #{auditTime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(NewT0AuditInfoDO record);
}