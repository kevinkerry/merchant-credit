package com.sdp.mc.msp.dao.mapper;

import com.sdp.mc.msp.dao.FsConfigChangeDO;
import com.sdp.mc.msp.dao.FsConfigChangeDOExample;
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

public interface FsConfigChangeMapper {
    /**
     * 根据Example对象取得配置更改记录【FsConfigChangeDO】对象count信息
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    @SelectProvider(type=FsConfigChangeSqlProvider.class, method="countByExample")
    int countByExample(FsConfigChangeDOExample example);

    /**
     * 根据Example对象删除配置更改记录【FsConfigChangeDO】对象信息
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    @DeleteProvider(type=FsConfigChangeSqlProvider.class, method="deleteByExample")
    int deleteByExample(FsConfigChangeDOExample example);

    /**
     * 根据主键删除配置更改记录【FsConfigChangeDO】对象信息
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    @Delete({
        "delete from TB_FS_CONFIG_CHANGE",
        "where FCM_ID = #{fcmId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long fcmId);

    /**
     * 添加配置更改记录【FsConfigChangeDO】对象信息
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    @Insert({
        "insert into TB_FS_CONFIG_CHANGE (FCM_ID, TYPE, ",
        "OBJ_ID, OP_TYPE, VERSION, ",
        "STATUS, FAST_SETTLE_FLAG, ",
        "FAST_SETTLE_MARGIN, FAST_SETTLE_LIMIT, ",
        "FAST_CONFIGURE_LIMIT, FAST_SETTLE_RATIO, ",
        "FAST_SETTLE_WORKDAY_FEE, FAST_SETTLE_HOLIDAY_FEE, ",
        "BEFORE_FAST_SETTLE_FLAG, BEFORE_FAST_SETTLE_MARGIN, ",
        "BEFORE_FAST_SETTLE_LIMIT, BEFORE_FAST_CONFIGURE_LIMIT, ",
        "BEFORE_FAST_SETTLE_RATIO, BEFOREFAST_SETTLE_WORKDAY_FEE, ",
        "BEFOREFAST_SETTLE_HOLIDAY_FEE, CREATE_TIME, ",
        "UPDATE_TIME, LOANING_TYPE, ",
        "FAST_SETTLE_MIN_LIMIT, BEFORE_FAST_SETTLE_MIN_LIMIT, ",
        "AUTO_FAST_SETTLE, BEFORE_AUTO_FAST_SETTLE, ",
        "OPERATOR, PROMOTER_MIN_MARGIN)",
        "values (#{fcmId,jdbcType=DECIMAL}, #{type,jdbcType=DECIMAL}, ",
        "#{objId,jdbcType=DECIMAL}, #{opType,jdbcType=DECIMAL}, #{version,jdbcType=DECIMAL}, ",
        "#{status,jdbcType=DECIMAL}, #{fastSettleFlag,jdbcType=DECIMAL}, ",
        "#{fastSettleMargin,jdbcType=DECIMAL}, #{fastSettleLimit,jdbcType=DECIMAL}, ",
        "#{fastConfigureLimit,jdbcType=DECIMAL}, #{fastSettleRatio,jdbcType=DECIMAL}, ",
        "#{fastSettleWorkdayFee,jdbcType=DECIMAL}, #{fastSettleHolidayFee,jdbcType=DECIMAL}, ",
        "#{beforeFastSettleFlag,jdbcType=DECIMAL}, #{beforeFastSettleMargin,jdbcType=DECIMAL}, ",
        "#{beforeFastSettleLimit,jdbcType=DECIMAL}, #{beforeFastConfigureLimit,jdbcType=DECIMAL}, ",
        "#{beforeFastSettleRatio,jdbcType=DECIMAL}, #{beforeFastSettleWorkdayFee,jdbcType=DECIMAL}, ",
        "#{beforeFastSettleHolidayFee,jdbcType=DECIMAL}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{loaningType,jdbcType=DECIMAL}, ",
        "#{fastSettleMinLimit,jdbcType=DECIMAL}, #{beforeFastSettleMinLimit,jdbcType=DECIMAL}, ",
        "#{autoFastSettle,jdbcType=DECIMAL}, #{beforeAutoFastSettle,jdbcType=DECIMAL}, ",
        "#{operator,jdbcType=VARCHAR}, #{promoterMinMargin,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="select SEQ_TB_FS_CONFIG_CHANGE.nextval from dual", keyProperty="fcmId", before=true, resultType=Long.class)
    Long insert(FsConfigChangeDO record);

    /**
     * 添加配置更改记录【FsConfigChangeDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    @InsertProvider(type=FsConfigChangeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_TB_FS_CONFIG_CHANGE.nextval from dual", keyProperty="fcmId", before=true, resultType=Long.class)
    Long insertSelective(FsConfigChangeDO record);

    /**
     * 根据Example对象查询得到配置更改记录【FsConfigChangeDO】对象列表信息
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    @SelectProvider(type=FsConfigChangeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="FCM_ID", property="fcmId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.DECIMAL),
        @Result(column="OBJ_ID", property="objId", jdbcType=JdbcType.DECIMAL),
        @Result(column="OP_TYPE", property="opType", jdbcType=JdbcType.DECIMAL),
        @Result(column="VERSION", property="version", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_FLAG", property="fastSettleFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_MARGIN", property="fastSettleMargin", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_LIMIT", property="fastSettleLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_CONFIGURE_LIMIT", property="fastConfigureLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_RATIO", property="fastSettleRatio", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_WORKDAY_FEE", property="fastSettleWorkdayFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_HOLIDAY_FEE", property="fastSettleHolidayFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFORE_FAST_SETTLE_FLAG", property="beforeFastSettleFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFORE_FAST_SETTLE_MARGIN", property="beforeFastSettleMargin", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFORE_FAST_SETTLE_LIMIT", property="beforeFastSettleLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFORE_FAST_CONFIGURE_LIMIT", property="beforeFastConfigureLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFORE_FAST_SETTLE_RATIO", property="beforeFastSettleRatio", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFOREFAST_SETTLE_WORKDAY_FEE", property="beforeFastSettleWorkdayFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFOREFAST_SETTLE_HOLIDAY_FEE", property="beforeFastSettleHolidayFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_MIN_LIMIT", property="fastSettleMinLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFORE_FAST_SETTLE_MIN_LIMIT", property="beforeFastSettleMinLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="AUTO_FAST_SETTLE", property="autoFastSettle", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFORE_AUTO_FAST_SETTLE", property="beforeAutoFastSettle", jdbcType=JdbcType.DECIMAL),
        @Result(column="OPERATOR", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_MIN_MARGIN", property="promoterMinMargin", jdbcType=JdbcType.DECIMAL)
    })
    List<FsConfigChangeDO> selectByExample(FsConfigChangeDOExample example);

    /**
     * 根据Query对象分页查询配置更改记录【FsConfigChangeDO】对象列表信息
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    @SelectProvider(type=FsConfigChangeSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="FCM_ID", property="fcmId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.DECIMAL),
        @Result(column="OBJ_ID", property="objId", jdbcType=JdbcType.DECIMAL),
        @Result(column="OP_TYPE", property="opType", jdbcType=JdbcType.DECIMAL),
        @Result(column="VERSION", property="version", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_FLAG", property="fastSettleFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_MARGIN", property="fastSettleMargin", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_LIMIT", property="fastSettleLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_CONFIGURE_LIMIT", property="fastConfigureLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_RATIO", property="fastSettleRatio", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_WORKDAY_FEE", property="fastSettleWorkdayFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_HOLIDAY_FEE", property="fastSettleHolidayFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFORE_FAST_SETTLE_FLAG", property="beforeFastSettleFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFORE_FAST_SETTLE_MARGIN", property="beforeFastSettleMargin", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFORE_FAST_SETTLE_LIMIT", property="beforeFastSettleLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFORE_FAST_CONFIGURE_LIMIT", property="beforeFastConfigureLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFORE_FAST_SETTLE_RATIO", property="beforeFastSettleRatio", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFOREFAST_SETTLE_WORKDAY_FEE", property="beforeFastSettleWorkdayFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFOREFAST_SETTLE_HOLIDAY_FEE", property="beforeFastSettleHolidayFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_MIN_LIMIT", property="fastSettleMinLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFORE_FAST_SETTLE_MIN_LIMIT", property="beforeFastSettleMinLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="AUTO_FAST_SETTLE", property="autoFastSettle", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFORE_AUTO_FAST_SETTLE", property="beforeAutoFastSettle", jdbcType=JdbcType.DECIMAL),
        @Result(column="OPERATOR", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_MIN_MARGIN", property="promoterMinMargin", jdbcType=JdbcType.DECIMAL)
    })
    List<FsConfigChangeDO> selectByQuery(FsConfigChangeDOExample example);

    /**
     * 根据主键查询配置更改记录【FsConfigChangeDO】对象信息
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    @Select({
        "select",
        "FCM_ID, TYPE, OBJ_ID, OP_TYPE, VERSION, STATUS, FAST_SETTLE_FLAG, FAST_SETTLE_MARGIN, ",
        "FAST_SETTLE_LIMIT, FAST_CONFIGURE_LIMIT, FAST_SETTLE_RATIO, FAST_SETTLE_WORKDAY_FEE, ",
        "FAST_SETTLE_HOLIDAY_FEE, BEFORE_FAST_SETTLE_FLAG, BEFORE_FAST_SETTLE_MARGIN, ",
        "BEFORE_FAST_SETTLE_LIMIT, BEFORE_FAST_CONFIGURE_LIMIT, BEFORE_FAST_SETTLE_RATIO, ",
        "BEFOREFAST_SETTLE_WORKDAY_FEE, BEFOREFAST_SETTLE_HOLIDAY_FEE, CREATE_TIME, UPDATE_TIME, ",
        "LOANING_TYPE, FAST_SETTLE_MIN_LIMIT, BEFORE_FAST_SETTLE_MIN_LIMIT, AUTO_FAST_SETTLE, ",
        "BEFORE_AUTO_FAST_SETTLE, OPERATOR, PROMOTER_MIN_MARGIN",
        "from TB_FS_CONFIG_CHANGE",
        "where FCM_ID = #{fcmId,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="FCM_ID", property="fcmId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.DECIMAL),
        @Result(column="OBJ_ID", property="objId", jdbcType=JdbcType.DECIMAL),
        @Result(column="OP_TYPE", property="opType", jdbcType=JdbcType.DECIMAL),
        @Result(column="VERSION", property="version", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_FLAG", property="fastSettleFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_MARGIN", property="fastSettleMargin", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_LIMIT", property="fastSettleLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_CONFIGURE_LIMIT", property="fastConfigureLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_RATIO", property="fastSettleRatio", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_WORKDAY_FEE", property="fastSettleWorkdayFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_HOLIDAY_FEE", property="fastSettleHolidayFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFORE_FAST_SETTLE_FLAG", property="beforeFastSettleFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFORE_FAST_SETTLE_MARGIN", property="beforeFastSettleMargin", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFORE_FAST_SETTLE_LIMIT", property="beforeFastSettleLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFORE_FAST_CONFIGURE_LIMIT", property="beforeFastConfigureLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFORE_FAST_SETTLE_RATIO", property="beforeFastSettleRatio", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFOREFAST_SETTLE_WORKDAY_FEE", property="beforeFastSettleWorkdayFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFOREFAST_SETTLE_HOLIDAY_FEE", property="beforeFastSettleHolidayFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_MIN_LIMIT", property="fastSettleMinLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFORE_FAST_SETTLE_MIN_LIMIT", property="beforeFastSettleMinLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="AUTO_FAST_SETTLE", property="autoFastSettle", jdbcType=JdbcType.DECIMAL),
        @Result(column="BEFORE_AUTO_FAST_SETTLE", property="beforeAutoFastSettle", jdbcType=JdbcType.DECIMAL),
        @Result(column="OPERATOR", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_MIN_MARGIN", property="promoterMinMargin", jdbcType=JdbcType.DECIMAL)
    })
    FsConfigChangeDO selectByPrimaryKey(Long fcmId);

    /**
     * 根据Example对象更新配置更改记录【FsConfigChangeDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    @UpdateProvider(type=FsConfigChangeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") FsConfigChangeDO record, @Param("example") FsConfigChangeDOExample example);

    /**
     * 根据Example对象更新配置更改记录【FsConfigChangeDO】对象信息
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    @UpdateProvider(type=FsConfigChangeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") FsConfigChangeDO record, @Param("example") FsConfigChangeDOExample example);

    /**
     * 根据主键更新配置更改记录【FsConfigChangeDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    @UpdateProvider(type=FsConfigChangeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FsConfigChangeDO record);

    /**
     * 根据主键更新配置更改记录【FsConfigChangeDO】对象信息
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    @Update({
        "update TB_FS_CONFIG_CHANGE",
        "set TYPE = #{type,jdbcType=DECIMAL},",
          "OBJ_ID = #{objId,jdbcType=DECIMAL},",
          "OP_TYPE = #{opType,jdbcType=DECIMAL},",
          "VERSION = #{version,jdbcType=DECIMAL},",
          "STATUS = #{status,jdbcType=DECIMAL},",
          "FAST_SETTLE_FLAG = #{fastSettleFlag,jdbcType=DECIMAL},",
          "FAST_SETTLE_MARGIN = #{fastSettleMargin,jdbcType=DECIMAL},",
          "FAST_SETTLE_LIMIT = #{fastSettleLimit,jdbcType=DECIMAL},",
          "FAST_CONFIGURE_LIMIT = #{fastConfigureLimit,jdbcType=DECIMAL},",
          "FAST_SETTLE_RATIO = #{fastSettleRatio,jdbcType=DECIMAL},",
          "FAST_SETTLE_WORKDAY_FEE = #{fastSettleWorkdayFee,jdbcType=DECIMAL},",
          "FAST_SETTLE_HOLIDAY_FEE = #{fastSettleHolidayFee,jdbcType=DECIMAL},",
          "BEFORE_FAST_SETTLE_FLAG = #{beforeFastSettleFlag,jdbcType=DECIMAL},",
          "BEFORE_FAST_SETTLE_MARGIN = #{beforeFastSettleMargin,jdbcType=DECIMAL},",
          "BEFORE_FAST_SETTLE_LIMIT = #{beforeFastSettleLimit,jdbcType=DECIMAL},",
          "BEFORE_FAST_CONFIGURE_LIMIT = #{beforeFastConfigureLimit,jdbcType=DECIMAL},",
          "BEFORE_FAST_SETTLE_RATIO = #{beforeFastSettleRatio,jdbcType=DECIMAL},",
          "BEFOREFAST_SETTLE_WORKDAY_FEE = #{beforeFastSettleWorkdayFee,jdbcType=DECIMAL},",
          "BEFOREFAST_SETTLE_HOLIDAY_FEE = #{beforeFastSettleHolidayFee,jdbcType=DECIMAL},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "LOANING_TYPE = #{loaningType,jdbcType=DECIMAL},",
          "FAST_SETTLE_MIN_LIMIT = #{fastSettleMinLimit,jdbcType=DECIMAL},",
          "BEFORE_FAST_SETTLE_MIN_LIMIT = #{beforeFastSettleMinLimit,jdbcType=DECIMAL},",
          "AUTO_FAST_SETTLE = #{autoFastSettle,jdbcType=DECIMAL},",
          "BEFORE_AUTO_FAST_SETTLE = #{beforeAutoFastSettle,jdbcType=DECIMAL},",
          "OPERATOR = #{operator,jdbcType=VARCHAR},",
          "PROMOTER_MIN_MARGIN = #{promoterMinMargin,jdbcType=DECIMAL}",
        "where FCM_ID = #{fcmId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(FsConfigChangeDO record);
}