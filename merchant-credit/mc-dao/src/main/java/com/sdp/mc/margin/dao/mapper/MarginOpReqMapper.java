package com.sdp.mc.margin.dao.mapper;

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

import com.sdp.mc.margin.dao.MarginOpReqDO;
import com.sdp.mc.margin.dao.MarginOpReqDOExample;

public interface MarginOpReqMapper {
    /**
     * 根据Example对象取得代理商保证金追加/退回记录【MarginOpReqDO】对象count信息
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    @SelectProvider(type=MarginOpReqSqlProvider.class, method="countByExample")
    int countByExample(MarginOpReqDOExample example);

    /**
     * 根据Example对象删除代理商保证金追加/退回记录【MarginOpReqDO】对象信息
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    @DeleteProvider(type=MarginOpReqSqlProvider.class, method="deleteByExample")
    int deleteByExample(MarginOpReqDOExample example);

    /**
     * 根据主键删除代理商保证金追加/退回记录【MarginOpReqDO】对象信息
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    @Delete({
        "delete from TB_MARGIN_OP_REQ",
        "where MOR_ID = #{morId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long morId);

    /**
     * 添加代理商保证金追加/退回记录【MarginOpReqDO】对象信息
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    @Insert({
        "insert into TB_MARGIN_OP_REQ (MOR_ID, PROMOTER_ID, ",
        "OP_TYPE, STATUS, ",
        "AMOUNT, REDEEMED_TIME, ",
        "MT_ID, MT_ID_HIS, FCM_ID, ",
        "FCM_ID_HIS, CREATE_TIME, ",
        "UPDATE_TIME)",
        "values (#{morId,jdbcType=DECIMAL}, #{promoterId,jdbcType=DECIMAL}, ",
        "#{opType,jdbcType=DECIMAL}, #{status,jdbcType=DECIMAL}, ",
        "#{amount,jdbcType=DECIMAL}, #{redeemedTime,jdbcType=TIMESTAMP}, ",
        "#{mtId,jdbcType=DECIMAL}, #{mtIdHis,jdbcType=VARCHAR}, #{fcmId,jdbcType=DECIMAL}, ",
        "#{fcmIdHis,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select SEQ_TB_MARGIN_OP_REQ.nextval from dual", keyProperty="morId", before=true, resultType=Long.class)
    Long insert(MarginOpReqDO record);

    /**
     * 添加代理商保证金追加/退回记录【MarginOpReqDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    @InsertProvider(type=MarginOpReqSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_TB_MARGIN_OP_REQ.nextval from dual", keyProperty="morId", before=true, resultType=Long.class)
    Long insertSelective(MarginOpReqDO record);

    /**
     * 根据Example对象查询得到代理商保证金追加/退回记录【MarginOpReqDO】对象列表信息
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    @SelectProvider(type=MarginOpReqSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="MOR_ID", property="morId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="OP_TYPE", property="opType", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="AMOUNT", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="REDEEMED_TIME", property="redeemedTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MT_ID", property="mtId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MT_ID_HIS", property="mtIdHis", jdbcType=JdbcType.VARCHAR),
        @Result(column="FCM_ID", property="fcmId", jdbcType=JdbcType.DECIMAL),
        @Result(column="FCM_ID_HIS", property="fcmIdHis", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<MarginOpReqDO> selectByExample(MarginOpReqDOExample example);

    /**
     * 根据Query对象分页查询代理商保证金追加/退回记录【MarginOpReqDO】对象列表信息
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    @SelectProvider(type=MarginOpReqSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="MOR_ID", property="morId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="OP_TYPE", property="opType", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="AMOUNT", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="REDEEMED_TIME", property="redeemedTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MT_ID", property="mtId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MT_ID_HIS", property="mtIdHis", jdbcType=JdbcType.VARCHAR),
        @Result(column="FCM_ID", property="fcmId", jdbcType=JdbcType.DECIMAL),
        @Result(column="FCM_ID_HIS", property="fcmIdHis", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<MarginOpReqDO> selectByQuery(MarginOpReqDOExample example);

    /**
     * 根据主键查询代理商保证金追加/退回记录【MarginOpReqDO】对象信息
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    @Select({
        "select",
        "MOR_ID, PROMOTER_ID, OP_TYPE, STATUS, AMOUNT, REDEEMED_TIME, MT_ID, MT_ID_HIS, ",
        "FCM_ID, FCM_ID_HIS, CREATE_TIME, UPDATE_TIME",
        "from TB_MARGIN_OP_REQ",
        "where MOR_ID = #{morId,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="MOR_ID", property="morId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="OP_TYPE", property="opType", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="AMOUNT", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="REDEEMED_TIME", property="redeemedTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MT_ID", property="mtId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MT_ID_HIS", property="mtIdHis", jdbcType=JdbcType.VARCHAR),
        @Result(column="FCM_ID", property="fcmId", jdbcType=JdbcType.DECIMAL),
        @Result(column="FCM_ID_HIS", property="fcmIdHis", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    MarginOpReqDO selectByPrimaryKey(Long morId);

    /**
     * 根据Example对象更新代理商保证金追加/退回记录【MarginOpReqDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    @UpdateProvider(type=MarginOpReqSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MarginOpReqDO record, @Param("example") MarginOpReqDOExample example);

    /**
     * 根据Example对象更新代理商保证金追加/退回记录【MarginOpReqDO】对象信息
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    @UpdateProvider(type=MarginOpReqSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MarginOpReqDO record, @Param("example") MarginOpReqDOExample example);

    /**
     * 根据主键更新代理商保证金追加/退回记录【MarginOpReqDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    @UpdateProvider(type=MarginOpReqSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MarginOpReqDO record);

    /**
     * 根据主键更新代理商保证金追加/退回记录【MarginOpReqDO】对象信息
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    @Update({
        "update TB_MARGIN_OP_REQ",
        "set PROMOTER_ID = #{promoterId,jdbcType=DECIMAL},",
          "OP_TYPE = #{opType,jdbcType=DECIMAL},",
          "STATUS = #{status,jdbcType=DECIMAL},",
          "AMOUNT = #{amount,jdbcType=DECIMAL},",
          "REDEEMED_TIME = #{redeemedTime,jdbcType=TIMESTAMP},",
          "MT_ID = #{mtId,jdbcType=DECIMAL},",
          "MT_ID_HIS = #{mtIdHis,jdbcType=VARCHAR},",
          "FCM_ID = #{fcmId,jdbcType=DECIMAL},",
          "FCM_ID_HIS = #{fcmIdHis,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where MOR_ID = #{morId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(MarginOpReqDO record);
    
}