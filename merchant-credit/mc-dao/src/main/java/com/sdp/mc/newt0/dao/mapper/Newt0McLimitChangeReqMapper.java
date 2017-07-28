package com.sdp.mc.newt0.dao.mapper;

import com.sdp.mc.newt0.dao.Newt0McLimitChangeReqDO;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeReqDOExample;
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

public interface Newt0McLimitChangeReqMapper {
    /**
     * 根据Example对象取得商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象count信息
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    @SelectProvider(type=Newt0McLimitChangeReqSqlProvider.class, method="countByExample")
    int countByExample(Newt0McLimitChangeReqDOExample example);

    /**
     * 根据Example对象删除商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    @DeleteProvider(type=Newt0McLimitChangeReqSqlProvider.class, method="deleteByExample")
    int deleteByExample(Newt0McLimitChangeReqDOExample example);

    /**
     * 根据主键删除商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    @Delete({
        "delete from NEWT0_MC_LIMIT_CHANGE_REQ",
        "where REQ_ID = #{reqId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long reqId);

    /**
     * 添加商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    @Insert({
        "insert into NEWT0_MC_LIMIT_CHANGE_REQ (REQ_ID, REQ_TIME, ",
        "CREATE_TIME, REQ_NUM, ",
        "SUCCESS_NUM, FAIL_NUM, ",
        "STATUS, REQ_FILE_NAME, ",
        "UPDATE_TIME, REQ_TYPE)",
        "values (#{reqId,jdbcType=DECIMAL}, #{reqTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{reqNum,jdbcType=DECIMAL}, ",
        "#{successNum,jdbcType=DECIMAL}, #{failNum,jdbcType=DECIMAL}, ",
        "#{status,jdbcType=DECIMAL}, #{reqFileName,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{reqType,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="select SEQ_MC_LIMIT_CHANGE_REQ.nextval from dual", keyProperty="reqId", before=true, resultType=Long.class)
    Long insert(Newt0McLimitChangeReqDO record);

    /**
     * 添加商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    @InsertProvider(type=Newt0McLimitChangeReqSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_MC_LIMIT_CHANGE_REQ.nextval from dual", keyProperty="reqId", before=true, resultType=Long.class)
    Long insertSelective(Newt0McLimitChangeReqDO record);

    /**
     * 根据Example对象查询得到商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象列表信息
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    @SelectProvider(type=Newt0McLimitChangeReqSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REQ_TIME", property="reqTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REQ_NUM", property="reqNum", jdbcType=JdbcType.DECIMAL),
        @Result(column="SUCCESS_NUM", property="successNum", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAIL_NUM", property="failNum", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="REQ_FILE_NAME", property="reqFileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REQ_TYPE", property="reqType", jdbcType=JdbcType.DECIMAL)
    })
    List<Newt0McLimitChangeReqDO> selectByExample(Newt0McLimitChangeReqDOExample example);

    /**
     * 根据Query对象分页查询商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象列表信息
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    @SelectProvider(type=Newt0McLimitChangeReqSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REQ_TIME", property="reqTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REQ_NUM", property="reqNum", jdbcType=JdbcType.DECIMAL),
        @Result(column="SUCCESS_NUM", property="successNum", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAIL_NUM", property="failNum", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="REQ_FILE_NAME", property="reqFileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REQ_TYPE", property="reqType", jdbcType=JdbcType.DECIMAL)
    })
    List<Newt0McLimitChangeReqDO> selectByQuery(Newt0McLimitChangeReqDOExample example);

    /**
     * 根据主键查询商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    @Select({
        "select",
        "REQ_ID, REQ_TIME, CREATE_TIME, REQ_NUM, SUCCESS_NUM, FAIL_NUM, STATUS, REQ_FILE_NAME, ",
        "UPDATE_TIME, REQ_TYPE",
        "from NEWT0_MC_LIMIT_CHANGE_REQ",
        "where REQ_ID = #{reqId,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REQ_TIME", property="reqTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REQ_NUM", property="reqNum", jdbcType=JdbcType.DECIMAL),
        @Result(column="SUCCESS_NUM", property="successNum", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAIL_NUM", property="failNum", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="REQ_FILE_NAME", property="reqFileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REQ_TYPE", property="reqType", jdbcType=JdbcType.DECIMAL)
    })
    Newt0McLimitChangeReqDO selectByPrimaryKey(Long reqId);

    /**
     * 根据Example对象更新商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    @UpdateProvider(type=Newt0McLimitChangeReqSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Newt0McLimitChangeReqDO record, @Param("example") Newt0McLimitChangeReqDOExample example);

    /**
     * 根据Example对象更新商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    @UpdateProvider(type=Newt0McLimitChangeReqSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Newt0McLimitChangeReqDO record, @Param("example") Newt0McLimitChangeReqDOExample example);

    /**
     * 根据主键更新商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    @UpdateProvider(type=Newt0McLimitChangeReqSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Newt0McLimitChangeReqDO record);

    /**
     * 根据主键更新商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    @Update({
        "update NEWT0_MC_LIMIT_CHANGE_REQ",
        "set REQ_TIME = #{reqTime,jdbcType=TIMESTAMP},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "REQ_NUM = #{reqNum,jdbcType=DECIMAL},",
          "SUCCESS_NUM = #{successNum,jdbcType=DECIMAL},",
          "FAIL_NUM = #{failNum,jdbcType=DECIMAL},",
          "STATUS = #{status,jdbcType=DECIMAL},",
          "REQ_FILE_NAME = #{reqFileName,jdbcType=VARCHAR},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "REQ_TYPE = #{reqType,jdbcType=DECIMAL}",
        "where REQ_ID = #{reqId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(Newt0McLimitChangeReqDO record);
}