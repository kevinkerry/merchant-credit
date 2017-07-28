package com.sdp.mc.newt0.dao.mapper;

import com.sdp.mc.newt0.dao.Newt0McLimitChangeDtlDO;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeDtlDOExample;
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

public interface Newt0McLimitChangeDtlMapper {
    /**
     * 根据Example对象取得商户额度变更明细【Newt0McLimitChangeDtlDO】对象count信息
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    @SelectProvider(type=Newt0McLimitChangeDtlSqlProvider.class, method="countByExample")
    int countByExample(Newt0McLimitChangeDtlDOExample example);

    /**
     * 根据Example对象删除商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    @DeleteProvider(type=Newt0McLimitChangeDtlSqlProvider.class, method="deleteByExample")
    int deleteByExample(Newt0McLimitChangeDtlDOExample example);

    /**
     * 根据主键删除商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    @Delete({
        "delete from NEWT0_MC_LIMIT_CHANGE_DTL",
        "where CHANGE_ID = #{changeId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long changeId);

    /**
     * 添加商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    @Insert({
        "insert into NEWT0_MC_LIMIT_CHANGE_DTL (CHANGE_ID, REQ_ID, ",
        "MC_NO, POS_MC_TYPE, ",
        "STATUS, CREATE_TIME, ",
        "UPDATE_TIME, MAX_LIMIT, ",
        "MIN_LIMIT, MESSAGE, ",
        "CFM_ID, LIMIT_TYPE)",
        "values (#{changeId,jdbcType=DECIMAL}, #{reqId,jdbcType=DECIMAL}, ",
        "#{mcNo,jdbcType=VARCHAR}, #{posMcType,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=DECIMAL}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{maxLimit,jdbcType=DECIMAL}, ",
        "#{minLimit,jdbcType=DECIMAL}, #{message,jdbcType=VARCHAR}, ",
        "#{cfmId,jdbcType=DECIMAL}, #{limitType,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="select SEQ_MC_LIMIT_CHANGE_DTL.nextval from dual", keyProperty="changeId", before=true, resultType=Long.class)
    Long insert(Newt0McLimitChangeDtlDO record);

    /**
     * 添加商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    @InsertProvider(type=Newt0McLimitChangeDtlSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_MC_LIMIT_CHANGE_DTL.nextval from dual", keyProperty="changeId", before=true, resultType=Long.class)
    Long insertSelective(Newt0McLimitChangeDtlDO record);

    /**
     * 根据Example对象查询得到商户额度变更明细【Newt0McLimitChangeDtlDO】对象列表信息
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    @SelectProvider(type=Newt0McLimitChangeDtlSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="CHANGE_ID", property="changeId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MC_NO", property="mcNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="POS_MC_TYPE", property="posMcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MAX_LIMIT", property="maxLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="MIN_LIMIT", property="minLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="MESSAGE", property="message", jdbcType=JdbcType.VARCHAR),
        @Result(column="CFM_ID", property="cfmId", jdbcType=JdbcType.DECIMAL),
        @Result(column="LIMIT_TYPE", property="limitType", jdbcType=JdbcType.VARCHAR)
    })
    List<Newt0McLimitChangeDtlDO> selectByExample(Newt0McLimitChangeDtlDOExample example);

    /**
     * 根据Query对象分页查询商户额度变更明细【Newt0McLimitChangeDtlDO】对象列表信息
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    @SelectProvider(type=Newt0McLimitChangeDtlSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="CHANGE_ID", property="changeId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MC_NO", property="mcNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="POS_MC_TYPE", property="posMcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MAX_LIMIT", property="maxLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="MIN_LIMIT", property="minLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="MESSAGE", property="message", jdbcType=JdbcType.VARCHAR),
        @Result(column="CFM_ID", property="cfmId", jdbcType=JdbcType.DECIMAL),
        @Result(column="LIMIT_TYPE", property="limitType", jdbcType=JdbcType.VARCHAR)
    })
    List<Newt0McLimitChangeDtlDO> selectByQuery(Newt0McLimitChangeDtlDOExample example);

    /**
     * 根据主键查询商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    @Select({
        "select",
        "CHANGE_ID, REQ_ID, MC_NO, POS_MC_TYPE, STATUS, CREATE_TIME, UPDATE_TIME, MAX_LIMIT, ",
        "MIN_LIMIT, MESSAGE, CFM_ID, LIMIT_TYPE",
        "from NEWT0_MC_LIMIT_CHANGE_DTL",
        "where CHANGE_ID = #{changeId,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="CHANGE_ID", property="changeId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MC_NO", property="mcNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="POS_MC_TYPE", property="posMcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MAX_LIMIT", property="maxLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="MIN_LIMIT", property="minLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="MESSAGE", property="message", jdbcType=JdbcType.VARCHAR),
        @Result(column="CFM_ID", property="cfmId", jdbcType=JdbcType.DECIMAL),
        @Result(column="LIMIT_TYPE", property="limitType", jdbcType=JdbcType.VARCHAR)
    })
    Newt0McLimitChangeDtlDO selectByPrimaryKey(Long changeId);

    /**
     * 根据Example对象更新商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    @UpdateProvider(type=Newt0McLimitChangeDtlSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Newt0McLimitChangeDtlDO record, @Param("example") Newt0McLimitChangeDtlDOExample example);

    /**
     * 根据Example对象更新商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    @UpdateProvider(type=Newt0McLimitChangeDtlSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Newt0McLimitChangeDtlDO record, @Param("example") Newt0McLimitChangeDtlDOExample example);

    /**
     * 根据主键更新商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    @UpdateProvider(type=Newt0McLimitChangeDtlSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Newt0McLimitChangeDtlDO record);

    /**
     * 根据主键更新商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息
     *
     * @mbggenerated Mon Aug 08 14:06:22 CST 2016
     */
    @Update({
        "update NEWT0_MC_LIMIT_CHANGE_DTL",
        "set REQ_ID = #{reqId,jdbcType=DECIMAL},",
          "MC_NO = #{mcNo,jdbcType=VARCHAR},",
          "POS_MC_TYPE = #{posMcType,jdbcType=VARCHAR},",
          "STATUS = #{status,jdbcType=DECIMAL},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "MAX_LIMIT = #{maxLimit,jdbcType=DECIMAL},",
          "MIN_LIMIT = #{minLimit,jdbcType=DECIMAL},",
          "MESSAGE = #{message,jdbcType=VARCHAR},",
          "CFM_ID = #{cfmId,jdbcType=DECIMAL},",
          "LIMIT_TYPE = #{limitType,jdbcType=VARCHAR}",
        "where CHANGE_ID = #{changeId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(Newt0McLimitChangeDtlDO record);
}