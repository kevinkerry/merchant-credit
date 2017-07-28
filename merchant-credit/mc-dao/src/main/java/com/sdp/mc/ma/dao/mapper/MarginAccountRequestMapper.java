package com.sdp.mc.ma.dao.mapper;

import com.sdp.mc.ma.dao.MarginAccountRequestDO;
import com.sdp.mc.ma.dao.MarginAccountRequestDOExample;
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

public interface MarginAccountRequestMapper {
    /**
     * 根据Example对象取得保证金账户开户记录【MarginAccountRequestDO】对象count信息
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    @SelectProvider(type=MarginAccountRequestSqlProvider.class, method="countByExample")
    int countByExample(MarginAccountRequestDOExample example);

    /**
     * 根据Example对象删除保证金账户开户记录【MarginAccountRequestDO】对象信息
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    @DeleteProvider(type=MarginAccountRequestSqlProvider.class, method="deleteByExample")
    int deleteByExample(MarginAccountRequestDOExample example);

    /**
     * 根据主键删除保证金账户开户记录【MarginAccountRequestDO】对象信息
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    @Delete({
        "delete from TB_MARGIN_ACCOUNT_REQ",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * 添加保证金账户开户记录【MarginAccountRequestDO】对象信息
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    @Insert({
        "insert into TB_MARGIN_ACCOUNT_REQ (ID, STATUS, ",
        "SOURCE_ID, MERCHANT_NO, ",
        "MEMBER_ID, ACCOUNT_ID, ",
        "REQUEST_NO, APP_IP, ",
        "REQUEST_OPERATOR, USER_IP, ",
        "RESPONSE_CODE, RESPONSE_MESSAGE, ",
        "REQUEST_TIME, RESPONSE_TIME, ",
        "ACCOUNT_TYPE)",
        "values (#{id,jdbcType=DECIMAL}, #{status,jdbcType=VARCHAR}, ",
        "#{sourceId,jdbcType=VARCHAR}, #{merchantNo,jdbcType=VARCHAR}, ",
        "#{memberId,jdbcType=VARCHAR}, #{accountId,jdbcType=VARCHAR}, ",
        "#{requestNo,jdbcType=VARCHAR}, #{appIp,jdbcType=VARCHAR}, ",
        "#{requestOperator,jdbcType=VARCHAR}, #{userIp,jdbcType=VARCHAR}, ",
        "#{responseCode,jdbcType=VARCHAR}, #{responseMessage,jdbcType=VARCHAR}, ",
        "#{requestTime,jdbcType=TIMESTAMP}, #{responseTime,jdbcType=TIMESTAMP}, ",
        "#{accountType,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="select SEQ_TB_MARGIN_ACCOUNT_REQ.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insert(MarginAccountRequestDO record);

    /**
     * 添加保证金账户开户记录【MarginAccountRequestDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    @InsertProvider(type=MarginAccountRequestSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_TB_MARGIN_ACCOUNT_REQ.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insertSelective(MarginAccountRequestDO record);

    /**
     * 根据Example对象查询得到保证金账户开户记录【MarginAccountRequestDO】对象列表信息
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    @SelectProvider(type=MarginAccountRequestSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="SOURCE_ID", property="sourceId", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMBER_ID", property="memberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACCOUNT_ID", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="REQUEST_NO", property="requestNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="APP_IP", property="appIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="REQUEST_OPERATOR", property="requestOperator", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_IP", property="userIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="RESPONSE_CODE", property="responseCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="RESPONSE_MESSAGE", property="responseMessage", jdbcType=JdbcType.VARCHAR),
        @Result(column="REQUEST_TIME", property="requestTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="RESPONSE_TIME", property="responseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ACCOUNT_TYPE", property="accountType", jdbcType=JdbcType.DECIMAL)
    })
    List<MarginAccountRequestDO> selectByExample(MarginAccountRequestDOExample example);

    /**
     * 根据Query对象分页查询保证金账户开户记录【MarginAccountRequestDO】对象列表信息
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    @SelectProvider(type=MarginAccountRequestSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="SOURCE_ID", property="sourceId", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMBER_ID", property="memberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACCOUNT_ID", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="REQUEST_NO", property="requestNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="APP_IP", property="appIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="REQUEST_OPERATOR", property="requestOperator", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_IP", property="userIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="RESPONSE_CODE", property="responseCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="RESPONSE_MESSAGE", property="responseMessage", jdbcType=JdbcType.VARCHAR),
        @Result(column="REQUEST_TIME", property="requestTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="RESPONSE_TIME", property="responseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ACCOUNT_TYPE", property="accountType", jdbcType=JdbcType.DECIMAL)
    })
    List<MarginAccountRequestDO> selectByQuery(MarginAccountRequestDOExample example);

    /**
     * 根据主键查询保证金账户开户记录【MarginAccountRequestDO】对象信息
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    @Select({
        "select",
        "ID, STATUS, SOURCE_ID, MERCHANT_NO, MEMBER_ID, ACCOUNT_ID, REQUEST_NO, APP_IP, ",
        "REQUEST_OPERATOR, USER_IP, RESPONSE_CODE, RESPONSE_MESSAGE, REQUEST_TIME, RESPONSE_TIME, ",
        "ACCOUNT_TYPE",
        "from TB_MARGIN_ACCOUNT_REQ",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="SOURCE_ID", property="sourceId", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMBER_ID", property="memberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACCOUNT_ID", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="REQUEST_NO", property="requestNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="APP_IP", property="appIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="REQUEST_OPERATOR", property="requestOperator", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_IP", property="userIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="RESPONSE_CODE", property="responseCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="RESPONSE_MESSAGE", property="responseMessage", jdbcType=JdbcType.VARCHAR),
        @Result(column="REQUEST_TIME", property="requestTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="RESPONSE_TIME", property="responseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ACCOUNT_TYPE", property="accountType", jdbcType=JdbcType.DECIMAL)
    })
    MarginAccountRequestDO selectByPrimaryKey(Long id);

    /**
     * 根据Example对象更新保证金账户开户记录【MarginAccountRequestDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    @UpdateProvider(type=MarginAccountRequestSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MarginAccountRequestDO record, @Param("example") MarginAccountRequestDOExample example);

    /**
     * 根据Example对象更新保证金账户开户记录【MarginAccountRequestDO】对象信息
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    @UpdateProvider(type=MarginAccountRequestSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MarginAccountRequestDO record, @Param("example") MarginAccountRequestDOExample example);

    /**
     * 根据主键更新保证金账户开户记录【MarginAccountRequestDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    @UpdateProvider(type=MarginAccountRequestSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MarginAccountRequestDO record);

    /**
     * 根据主键更新保证金账户开户记录【MarginAccountRequestDO】对象信息
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    @Update({
        "update TB_MARGIN_ACCOUNT_REQ",
        "set STATUS = #{status,jdbcType=VARCHAR},",
          "SOURCE_ID = #{sourceId,jdbcType=VARCHAR},",
          "MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR},",
          "MEMBER_ID = #{memberId,jdbcType=VARCHAR},",
          "ACCOUNT_ID = #{accountId,jdbcType=VARCHAR},",
          "REQUEST_NO = #{requestNo,jdbcType=VARCHAR},",
          "APP_IP = #{appIp,jdbcType=VARCHAR},",
          "REQUEST_OPERATOR = #{requestOperator,jdbcType=VARCHAR},",
          "USER_IP = #{userIp,jdbcType=VARCHAR},",
          "RESPONSE_CODE = #{responseCode,jdbcType=VARCHAR},",
          "RESPONSE_MESSAGE = #{responseMessage,jdbcType=VARCHAR},",
          "REQUEST_TIME = #{requestTime,jdbcType=TIMESTAMP},",
          "RESPONSE_TIME = #{responseTime,jdbcType=TIMESTAMP},",
          "ACCOUNT_TYPE = #{accountType,jdbcType=DECIMAL}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(MarginAccountRequestDO record);
}