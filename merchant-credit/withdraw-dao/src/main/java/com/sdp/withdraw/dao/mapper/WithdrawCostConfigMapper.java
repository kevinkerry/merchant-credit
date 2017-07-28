package com.sdp.withdraw.dao.mapper;

import com.sdp.withdraw.dao.WithdrawCostConfigDO;
import com.sdp.withdraw.dao.WithdrawCostConfigDOExample;
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

public interface WithdrawCostConfigMapper {
    /**
     * 根据Example对象取得null【WithdrawCostConfigDO】对象count信息
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    @SelectProvider(type=WithdrawCostConfigSqlProvider.class, method="countByExample")
    int countByExample(WithdrawCostConfigDOExample example);

    /**
     * 根据Example对象删除null【WithdrawCostConfigDO】对象信息
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    @DeleteProvider(type=WithdrawCostConfigSqlProvider.class, method="deleteByExample")
    int deleteByExample(WithdrawCostConfigDOExample example);

    /**
     * 根据主键删除null【WithdrawCostConfigDO】对象信息
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    @Delete({
        "delete from FW_WITHDRAW_COST_CONFIG",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * 添加null【WithdrawCostConfigDO】对象信息
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    @Insert({
        "insert into FW_WITHDRAW_COST_CONFIG (ID, TYPE, ",
        "MERCHANT_TYPE, MERCHANT_NO, ",
        "WD_COST, WD_PROMOTER_SPLITTING_SCALE, ",
        "STATUS, OPERATOR_ID, ",
        "OPERATOR_NAME, CREATE_TIME, ",
        "UPDATE_TIME)",
        "values (#{id,jdbcType=DECIMAL}, #{type,jdbcType=DECIMAL}, ",
        "#{merchantType,jdbcType=VARCHAR}, #{merchantNo,jdbcType=VARCHAR}, ",
        "#{wdCost,jdbcType=DECIMAL}, #{wdPromoterSplittingScale,jdbcType=DECIMAL}, ",
        "#{status,jdbcType=DECIMAL}, #{operatorId,jdbcType=VARCHAR}, ",
        "#{operatorName,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select SEQ_FW_WITHDRAW_COST_CONFIG.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insert(WithdrawCostConfigDO record);

    /**
     * 添加null【WithdrawCostConfigDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    @InsertProvider(type=WithdrawCostConfigSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_FW_WITHDRAW_COST_CONFIG.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insertSelective(WithdrawCostConfigDO record);

    /**
     * 根据Example对象查询得到null【WithdrawCostConfigDO】对象列表信息
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    @SelectProvider(type=WithdrawCostConfigSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_TYPE", property="merchantType", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="WD_COST", property="wdCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="WD_PROMOTER_SPLITTING_SCALE", property="wdPromoterSplittingScale", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="OPERATOR_ID", property="operatorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERATOR_NAME", property="operatorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<WithdrawCostConfigDO> selectByExample(WithdrawCostConfigDOExample example);

    /**
     * 根据Query对象分页查询null【WithdrawCostConfigDO】对象列表信息
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    @SelectProvider(type=WithdrawCostConfigSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_TYPE", property="merchantType", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="WD_COST", property="wdCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="WD_PROMOTER_SPLITTING_SCALE", property="wdPromoterSplittingScale", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="OPERATOR_ID", property="operatorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERATOR_NAME", property="operatorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<WithdrawCostConfigDO> selectByQuery(WithdrawCostConfigDOExample example);

    /**
     * 根据主键查询null【WithdrawCostConfigDO】对象信息
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    @Select({
        "select",
        "ID, TYPE, MERCHANT_TYPE, MERCHANT_NO, WD_COST, WD_PROMOTER_SPLITTING_SCALE, ",
        "STATUS, OPERATOR_ID, OPERATOR_NAME, CREATE_TIME, UPDATE_TIME",
        "from FW_WITHDRAW_COST_CONFIG",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_TYPE", property="merchantType", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="WD_COST", property="wdCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="WD_PROMOTER_SPLITTING_SCALE", property="wdPromoterSplittingScale", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="OPERATOR_ID", property="operatorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERATOR_NAME", property="operatorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    WithdrawCostConfigDO selectByPrimaryKey(Long id);

    /**
     * 根据Example对象更新null【WithdrawCostConfigDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    @UpdateProvider(type=WithdrawCostConfigSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WithdrawCostConfigDO record, @Param("example") WithdrawCostConfigDOExample example);

    /**
     * 根据Example对象更新null【WithdrawCostConfigDO】对象信息
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    @UpdateProvider(type=WithdrawCostConfigSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") WithdrawCostConfigDO record, @Param("example") WithdrawCostConfigDOExample example);

    /**
     * 根据主键更新null【WithdrawCostConfigDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    @UpdateProvider(type=WithdrawCostConfigSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WithdrawCostConfigDO record);

    /**
     * 根据主键更新null【WithdrawCostConfigDO】对象信息
     *
     * @mbggenerated Mon Jul 11 16:59:00 CST 2016
     */
    @Update({
        "update FW_WITHDRAW_COST_CONFIG",
        "set TYPE = #{type,jdbcType=DECIMAL},",
          "MERCHANT_TYPE = #{merchantType,jdbcType=VARCHAR},",
          "MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR},",
          "WD_COST = #{wdCost,jdbcType=DECIMAL},",
          "WD_PROMOTER_SPLITTING_SCALE = #{wdPromoterSplittingScale,jdbcType=DECIMAL},",
          "STATUS = #{status,jdbcType=DECIMAL},",
          "OPERATOR_ID = #{operatorId,jdbcType=VARCHAR},",
          "OPERATOR_NAME = #{operatorName,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(WithdrawCostConfigDO record);
}