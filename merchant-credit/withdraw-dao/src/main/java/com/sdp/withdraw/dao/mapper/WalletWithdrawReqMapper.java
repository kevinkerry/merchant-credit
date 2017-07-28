package com.sdp.withdraw.dao.mapper;

import com.sdp.withdraw.dao.WalletWithdrawReqDO;
import com.sdp.withdraw.dao.WalletWithdrawReqDOExample;
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

public interface WalletWithdrawReqMapper {
    /**
     * 根据Example对象取得钱包出款请求表【WalletWithdrawReqDO】对象count信息
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    @SelectProvider(type=WalletWithdrawReqSqlProvider.class, method="countByExample")
    int countByExample(WalletWithdrawReqDOExample example);

    /**
     * 根据Example对象删除钱包出款请求表【WalletWithdrawReqDO】对象信息
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    @DeleteProvider(type=WalletWithdrawReqSqlProvider.class, method="deleteByExample")
    int deleteByExample(WalletWithdrawReqDOExample example);

    /**
     * 根据主键删除钱包出款请求表【WalletWithdrawReqDO】对象信息
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    @Delete({
        "delete from FW_WALLET_WITHDRAW_REQ",
        "where REQ_ID = #{reqId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long reqId);

    /**
     * 添加钱包出款请求表【WalletWithdrawReqDO】对象信息
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    @Insert({
        "insert into FW_WALLET_WITHDRAW_REQ (REQ_ID, APP_ID, ",
        "ORDER_NO, MEMBER_ID, ",
        "MEMBER_NO, MEMBER_TYPE, ",
        "WITHDRAW_AMOUNT, ORIGINAL_AMOUNT, ",
        "TRACE_NO, EXTENTION, ",
        "STATUS, CALLBACK_ADDRESS, ",
        "CREATE_TIME, UPDATE_TIME)",
        "values (#{reqId,jdbcType=DECIMAL}, #{appId,jdbcType=VARCHAR}, ",
        "#{orderNo,jdbcType=VARCHAR}, #{memberId,jdbcType=VARCHAR}, ",
        "#{memberNo,jdbcType=VARCHAR}, #{memberType,jdbcType=VARCHAR}, ",
        "#{withdrawAmount,jdbcType=DECIMAL}, #{originalAmount,jdbcType=DECIMAL}, ",
        "#{traceNo,jdbcType=DECIMAL}, #{extention,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=DECIMAL}, #{callbackAddress,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select SEQ_FW_WALLET_WITHDRAW_REQ.nextval from dual", keyProperty="reqId", before=true, resultType=Long.class)
    Long insert(WalletWithdrawReqDO record);

    /**
     * 添加钱包出款请求表【WalletWithdrawReqDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    @InsertProvider(type=WalletWithdrawReqSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_FW_WALLET_WITHDRAW_REQ.nextval from dual", keyProperty="reqId", before=true, resultType=Long.class)
    Long insertSelective(WalletWithdrawReqDO record);

    /**
     * 根据Example对象查询得到钱包出款请求表【WalletWithdrawReqDO】对象列表信息
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    @SelectProvider(type=WalletWithdrawReqSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="APP_ID", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ORDER_NO", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMBER_ID", property="memberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMBER_NO", property="memberNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMBER_TYPE", property="memberType", jdbcType=JdbcType.VARCHAR),
        @Result(column="WITHDRAW_AMOUNT", property="withdrawAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="ORIGINAL_AMOUNT", property="originalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="TRACE_NO", property="traceNo", jdbcType=JdbcType.DECIMAL),
        @Result(column="EXTENTION", property="extention", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="CALLBACK_ADDRESS", property="callbackAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<WalletWithdrawReqDO> selectByExample(WalletWithdrawReqDOExample example);

    /**
     * 根据Query对象分页查询钱包出款请求表【WalletWithdrawReqDO】对象列表信息
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    @SelectProvider(type=WalletWithdrawReqSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="APP_ID", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ORDER_NO", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMBER_ID", property="memberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMBER_NO", property="memberNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMBER_TYPE", property="memberType", jdbcType=JdbcType.VARCHAR),
        @Result(column="WITHDRAW_AMOUNT", property="withdrawAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="ORIGINAL_AMOUNT", property="originalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="TRACE_NO", property="traceNo", jdbcType=JdbcType.DECIMAL),
        @Result(column="EXTENTION", property="extention", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="CALLBACK_ADDRESS", property="callbackAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<WalletWithdrawReqDO> selectByQuery(WalletWithdrawReqDOExample example);

    /**
     * 根据主键查询钱包出款请求表【WalletWithdrawReqDO】对象信息
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    @Select({
        "select",
        "REQ_ID, APP_ID, ORDER_NO, MEMBER_ID, MEMBER_NO, MEMBER_TYPE, WITHDRAW_AMOUNT, ",
        "ORIGINAL_AMOUNT, TRACE_NO, EXTENTION, STATUS, CALLBACK_ADDRESS, CREATE_TIME, ",
        "UPDATE_TIME",
        "from FW_WALLET_WITHDRAW_REQ",
        "where REQ_ID = #{reqId,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="APP_ID", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ORDER_NO", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMBER_ID", property="memberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMBER_NO", property="memberNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMBER_TYPE", property="memberType", jdbcType=JdbcType.VARCHAR),
        @Result(column="WITHDRAW_AMOUNT", property="withdrawAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="ORIGINAL_AMOUNT", property="originalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="TRACE_NO", property="traceNo", jdbcType=JdbcType.DECIMAL),
        @Result(column="EXTENTION", property="extention", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="CALLBACK_ADDRESS", property="callbackAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    WalletWithdrawReqDO selectByPrimaryKey(Long reqId);

    /**
     * 根据Example对象更新钱包出款请求表【WalletWithdrawReqDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    @UpdateProvider(type=WalletWithdrawReqSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WalletWithdrawReqDO record, @Param("example") WalletWithdrawReqDOExample example);

    /**
     * 根据Example对象更新钱包出款请求表【WalletWithdrawReqDO】对象信息
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    @UpdateProvider(type=WalletWithdrawReqSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") WalletWithdrawReqDO record, @Param("example") WalletWithdrawReqDOExample example);

    /**
     * 根据主键更新钱包出款请求表【WalletWithdrawReqDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    @UpdateProvider(type=WalletWithdrawReqSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WalletWithdrawReqDO record);

    /**
     * 根据主键更新钱包出款请求表【WalletWithdrawReqDO】对象信息
     *
     * @mbggenerated Wed Nov 23 10:26:15 CST 2016
     */
    @Update({
        "update FW_WALLET_WITHDRAW_REQ",
        "set APP_ID = #{appId,jdbcType=VARCHAR},",
          "ORDER_NO = #{orderNo,jdbcType=VARCHAR},",
          "MEMBER_ID = #{memberId,jdbcType=VARCHAR},",
          "MEMBER_NO = #{memberNo,jdbcType=VARCHAR},",
          "MEMBER_TYPE = #{memberType,jdbcType=VARCHAR},",
          "WITHDRAW_AMOUNT = #{withdrawAmount,jdbcType=DECIMAL},",
          "ORIGINAL_AMOUNT = #{originalAmount,jdbcType=DECIMAL},",
          "TRACE_NO = #{traceNo,jdbcType=DECIMAL},",
          "EXTENTION = #{extention,jdbcType=VARCHAR},",
          "STATUS = #{status,jdbcType=DECIMAL},",
          "CALLBACK_ADDRESS = #{callbackAddress,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where REQ_ID = #{reqId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(WalletWithdrawReqDO record);
}