package com.sdp.mc.newt0.dao.mapper;

import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDO;
import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDOExample;
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

public interface Newt0SdpRemainBalanceMapper {
    /**
     * 根据Example对象取得盛付通全资日历【Newt0SdpRemainBalanceDO】对象count信息
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    @SelectProvider(type=Newt0SdpRemainBalanceSqlProvider.class, method="countByExample")
    int countByExample(Newt0SdpRemainBalanceDOExample example);

    /**
     * 根据Example对象删除盛付通全资日历【Newt0SdpRemainBalanceDO】对象信息
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    @DeleteProvider(type=Newt0SdpRemainBalanceSqlProvider.class, method="deleteByExample")
    int deleteByExample(Newt0SdpRemainBalanceDOExample example);

    /**
     * 根据主键删除盛付通全资日历【Newt0SdpRemainBalanceDO】对象信息
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    @Delete({
        "delete from NEWT0_SDP_REMAIN_BALANCE",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * 添加盛付通全资日历【Newt0SdpRemainBalanceDO】对象信息
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    @Insert({
        "insert into NEWT0_SDP_REMAIN_BALANCE (ID, START_TIME, ",
        "QUOTA, CREATE_TIME, ",
        "UPDATE_TIME, END_TIME, ",
        "CAN_USE_QUOTA, FROZEN_QUOTA, ",
        "USED_QUOTA)",
        "values (#{id,jdbcType=DECIMAL}, #{startTime,jdbcType=TIMESTAMP}, ",
        "#{quota,jdbcType=DECIMAL}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP}, ",
        "#{canUseQuota,jdbcType=DECIMAL}, #{frozenQuota,jdbcType=DECIMAL}, ",
        "#{usedQuota,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="select SEQ_NEWT0_SDP_REMAIN_BALANCE.nextval  from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insert(Newt0SdpRemainBalanceDO record);

    /**
     * 添加盛付通全资日历【Newt0SdpRemainBalanceDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    @InsertProvider(type=Newt0SdpRemainBalanceSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_NEWT0_SDP_REMAIN_BALANCE.nextval  from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insertSelective(Newt0SdpRemainBalanceDO record);

    /**
     * 根据Example对象查询得到盛付通全资日历【Newt0SdpRemainBalanceDO】对象列表信息
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    @SelectProvider(type=Newt0SdpRemainBalanceSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="START_TIME", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="QUOTA", property="quota", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="END_TIME", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CAN_USE_QUOTA", property="canUseQuota", jdbcType=JdbcType.DECIMAL),
        @Result(column="FROZEN_QUOTA", property="frozenQuota", jdbcType=JdbcType.DECIMAL),
        @Result(column="USED_QUOTA", property="usedQuota", jdbcType=JdbcType.DECIMAL)
    })
    List<Newt0SdpRemainBalanceDO> selectByExample(Newt0SdpRemainBalanceDOExample example);

    /**
     * 根据Query对象分页查询盛付通全资日历【Newt0SdpRemainBalanceDO】对象列表信息
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    @SelectProvider(type=Newt0SdpRemainBalanceSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="START_TIME", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="QUOTA", property="quota", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="END_TIME", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CAN_USE_QUOTA", property="canUseQuota", jdbcType=JdbcType.DECIMAL),
        @Result(column="FROZEN_QUOTA", property="frozenQuota", jdbcType=JdbcType.DECIMAL),
        @Result(column="USED_QUOTA", property="usedQuota", jdbcType=JdbcType.DECIMAL)
    })
    List<Newt0SdpRemainBalanceDO> selectByQuery(Newt0SdpRemainBalanceDOExample example);

    /**
     * 根据主键查询盛付通全资日历【Newt0SdpRemainBalanceDO】对象信息
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    @Select({
        "select",
        "ID, START_TIME, QUOTA, CREATE_TIME, UPDATE_TIME, END_TIME, CAN_USE_QUOTA, FROZEN_QUOTA, ",
        "USED_QUOTA",
        "from NEWT0_SDP_REMAIN_BALANCE",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="START_TIME", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="QUOTA", property="quota", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="END_TIME", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CAN_USE_QUOTA", property="canUseQuota", jdbcType=JdbcType.DECIMAL),
        @Result(column="FROZEN_QUOTA", property="frozenQuota", jdbcType=JdbcType.DECIMAL),
        @Result(column="USED_QUOTA", property="usedQuota", jdbcType=JdbcType.DECIMAL)
    })
    Newt0SdpRemainBalanceDO selectByPrimaryKey(Long id);

    /**
     * 根据Example对象更新盛付通全资日历【Newt0SdpRemainBalanceDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    @UpdateProvider(type=Newt0SdpRemainBalanceSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Newt0SdpRemainBalanceDO record, @Param("example") Newt0SdpRemainBalanceDOExample example);

    /**
     * 根据Example对象更新盛付通全资日历【Newt0SdpRemainBalanceDO】对象信息
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    @UpdateProvider(type=Newt0SdpRemainBalanceSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Newt0SdpRemainBalanceDO record, @Param("example") Newt0SdpRemainBalanceDOExample example);

    /**
     * 根据主键更新盛付通全资日历【Newt0SdpRemainBalanceDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    @UpdateProvider(type=Newt0SdpRemainBalanceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Newt0SdpRemainBalanceDO record);

    /**
     * 根据主键更新盛付通全资日历【Newt0SdpRemainBalanceDO】对象信息
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    @Update({
        "update NEWT0_SDP_REMAIN_BALANCE",
        "set START_TIME = #{startTime,jdbcType=TIMESTAMP},",
          "QUOTA = #{quota,jdbcType=DECIMAL},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "END_TIME = #{endTime,jdbcType=TIMESTAMP},",
          "CAN_USE_QUOTA = #{canUseQuota,jdbcType=DECIMAL},",
          "FROZEN_QUOTA = #{frozenQuota,jdbcType=DECIMAL},",
          "USED_QUOTA = #{usedQuota,jdbcType=DECIMAL}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(Newt0SdpRemainBalanceDO record);
}