package com.sdp.withdraw.dao.mapper;

import com.sdp.withdraw.dao.RemitFeeReqDo;
import com.sdp.withdraw.dao.RemitFeeReqDoExample;
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

public interface RemitFeeReqMapper {
    /**
     * 根据Example对象取得退款记录【RemitFeeReqDo】对象count信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    @SelectProvider(type=RemitFeeReqSqlProvider.class, method="countByExample")
    int countByExample(RemitFeeReqDoExample example);

    /**
     * 根据Example对象删除退款记录【RemitFeeReqDo】对象信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    @DeleteProvider(type=RemitFeeReqSqlProvider.class, method="deleteByExample")
    int deleteByExample(RemitFeeReqDoExample example);

    /**
     * 根据主键删除退款记录【RemitFeeReqDo】对象信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    @Delete({
        "delete from FW_REMIT_WITHDRAWFEE_REQ",
        "where REMIT_ID = #{remitId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long remitId);

    /**
     * 添加退款记录【RemitFeeReqDo】对象信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    @Insert({
        "insert into FW_REMIT_WITHDRAWFEE_REQ (REMIT_ID, REQ_ID, ",
        "MT_ID, REMITAMOUNT, ",
        "STATUS, OPERTATOR, ",
        "CREATE_TIME, UPDATE_TIME)",
        "values (#{remitId,jdbcType=DECIMAL}, #{reqId,jdbcType=DECIMAL}, ",
        "#{mtId,jdbcType=DECIMAL}, #{remitamount,jdbcType=DECIMAL}, ",
        "#{status,jdbcType=VARCHAR}, #{opertator,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select SEQ_REMIT_WITHDRAWFEE_REQ.nextval from dual", keyProperty="remitId", before=true, resultType=Long.class)
    Long insert(RemitFeeReqDo record);

    /**
     * 添加退款记录【RemitFeeReqDo】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    @InsertProvider(type=RemitFeeReqSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_REMIT_WITHDRAWFEE_REQ.nextval from dual", keyProperty="remitId", before=true, resultType=Long.class)
    Long insertSelective(RemitFeeReqDo record);

    /**
     * 根据Example对象查询得到退款记录【RemitFeeReqDo】对象列表信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    @SelectProvider(type=RemitFeeReqSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="REMIT_ID", property="remitId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MT_ID", property="mtId", jdbcType=JdbcType.DECIMAL),
        @Result(column="REMITAMOUNT", property="remitamount", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERTATOR", property="opertator", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RemitFeeReqDo> selectByExample(RemitFeeReqDoExample example);

    /**
     * 根据Query对象分页查询退款记录【RemitFeeReqDo】对象列表信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    @SelectProvider(type=RemitFeeReqSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="REMIT_ID", property="remitId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MT_ID", property="mtId", jdbcType=JdbcType.DECIMAL),
        @Result(column="REMITAMOUNT", property="remitamount", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERTATOR", property="opertator", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RemitFeeReqDo> selectByQuery(RemitFeeReqDoExample example);

    /**
     * 根据主键查询退款记录【RemitFeeReqDo】对象信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    @Select({
        "select",
        "REMIT_ID, REQ_ID, MT_ID, REMITAMOUNT, STATUS, OPERTATOR, CREATE_TIME, UPDATE_TIME",
        "from FW_REMIT_WITHDRAWFEE_REQ",
        "where REMIT_ID = #{remitId,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="REMIT_ID", property="remitId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MT_ID", property="mtId", jdbcType=JdbcType.DECIMAL),
        @Result(column="REMITAMOUNT", property="remitamount", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERTATOR", property="opertator", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    RemitFeeReqDo selectByPrimaryKey(Long remitId);

    /**
     * 根据Example对象更新退款记录【RemitFeeReqDo】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    @UpdateProvider(type=RemitFeeReqSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RemitFeeReqDo record, @Param("example") RemitFeeReqDoExample example);

    /**
     * 根据Example对象更新退款记录【RemitFeeReqDo】对象信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    @UpdateProvider(type=RemitFeeReqSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RemitFeeReqDo record, @Param("example") RemitFeeReqDoExample example);

    /**
     * 根据主键更新退款记录【RemitFeeReqDo】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    @UpdateProvider(type=RemitFeeReqSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RemitFeeReqDo record);

    /**
     * 根据主键更新退款记录【RemitFeeReqDo】对象信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    @Update({
        "update FW_REMIT_WITHDRAWFEE_REQ",
        "set REQ_ID = #{reqId,jdbcType=DECIMAL},",
          "MT_ID = #{mtId,jdbcType=DECIMAL},",
          "REMITAMOUNT = #{remitamount,jdbcType=DECIMAL},",
          "STATUS = #{status,jdbcType=VARCHAR},",
          "OPERTATOR = #{opertator,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where REMIT_ID = #{remitId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(RemitFeeReqDo record);
}