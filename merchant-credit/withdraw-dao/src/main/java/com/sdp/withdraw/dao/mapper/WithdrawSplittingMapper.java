package com.sdp.withdraw.dao.mapper;

import com.sdp.withdraw.dao.WithdrawSplittingDO;
import com.sdp.withdraw.dao.WithdrawSplittingDOExample;
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

public interface WithdrawSplittingMapper {
    /**
     * 根据Example对象取得出款分润表【WithdrawSplittingDO】对象count信息
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    @SelectProvider(type=WithdrawSplittingSqlProvider.class, method="countByExample")
    int countByExample(WithdrawSplittingDOExample example);

    /**
     * 根据Example对象删除出款分润表【WithdrawSplittingDO】对象信息
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    @DeleteProvider(type=WithdrawSplittingSqlProvider.class, method="deleteByExample")
    int deleteByExample(WithdrawSplittingDOExample example);

    /**
     * 根据主键删除出款分润表【WithdrawSplittingDO】对象信息
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    @Delete({
        "delete from FW_WITHDRAW_SPLITTING",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * 添加出款分润表【WithdrawSplittingDO】对象信息
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    @Insert({
        "insert into FW_WITHDRAW_SPLITTING (ID, REQ_ID, ",
        "BASE_COST, BASE_COST_SPLITTING_SCALE, ",
        "BASE_COST_SHENGPAY_SPLITTING, BASE_COST_PROMOTER_SPLITTING, ",
        "WD_COST, WD_COST_SPLITTING_SCALE, ",
        "WD_COST_SHENGPAY_SPLITTING, WD_COST_PROMOTER_SPLITTING, ",
        "PLATFORM_COST, SHENGPAY_TOTAL_COST, ",
        "PROMOTER_TOTAL_COST, CREATE_TIME, ",
        "UPDATE_TIME, DAY_SETTLE_AWARD, ",
        "MONTH_ACTIVE_AWARD)",
        "values (#{id,jdbcType=DECIMAL}, #{reqId,jdbcType=DECIMAL}, ",
        "#{baseCost,jdbcType=DECIMAL}, #{baseCostSplittingScale,jdbcType=DECIMAL}, ",
        "#{baseCostShengpaySplitting,jdbcType=DECIMAL}, #{baseCostPromoterSplitting,jdbcType=DECIMAL}, ",
        "#{wdCost,jdbcType=DECIMAL}, #{wdCostSplittingScale,jdbcType=DECIMAL}, ",
        "#{wdCostShengpaySplitting,jdbcType=DECIMAL}, #{wdCostPromoterSplitting,jdbcType=DECIMAL}, ",
        "#{platformCost,jdbcType=DECIMAL}, #{shengpayTotalCost,jdbcType=DECIMAL}, ",
        "#{promoterTotalCost,jdbcType=DECIMAL}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{daySettleAward,jdbcType=DECIMAL}, ",
        "#{monthActiveAward,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="select SEQ_FW_WITHDRAW_SPLITTING.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insert(WithdrawSplittingDO record);

    /**
     * 添加出款分润表【WithdrawSplittingDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    @InsertProvider(type=WithdrawSplittingSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_FW_WITHDRAW_SPLITTING.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insertSelective(WithdrawSplittingDO record);

    /**
     * 根据Example对象查询得到出款分润表【WithdrawSplittingDO】对象列表信息
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    @SelectProvider(type=WithdrawSplittingSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="BASE_COST", property="baseCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="BASE_COST_SPLITTING_SCALE", property="baseCostSplittingScale", jdbcType=JdbcType.DECIMAL),
        @Result(column="BASE_COST_SHENGPAY_SPLITTING", property="baseCostShengpaySplitting", jdbcType=JdbcType.DECIMAL),
        @Result(column="BASE_COST_PROMOTER_SPLITTING", property="baseCostPromoterSplitting", jdbcType=JdbcType.DECIMAL),
        @Result(column="WD_COST", property="wdCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="WD_COST_SPLITTING_SCALE", property="wdCostSplittingScale", jdbcType=JdbcType.DECIMAL),
        @Result(column="WD_COST_SHENGPAY_SPLITTING", property="wdCostShengpaySplitting", jdbcType=JdbcType.DECIMAL),
        @Result(column="WD_COST_PROMOTER_SPLITTING", property="wdCostPromoterSplitting", jdbcType=JdbcType.DECIMAL),
        @Result(column="PLATFORM_COST", property="platformCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="SHENGPAY_TOTAL_COST", property="shengpayTotalCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_TOTAL_COST", property="promoterTotalCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="DAY_SETTLE_AWARD", property="daySettleAward", jdbcType=JdbcType.DECIMAL),
        @Result(column="MONTH_ACTIVE_AWARD", property="monthActiveAward", jdbcType=JdbcType.DECIMAL)
    })
    List<WithdrawSplittingDO> selectByExample(WithdrawSplittingDOExample example);

    /**
     * 根据Query对象分页查询出款分润表【WithdrawSplittingDO】对象列表信息
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    @SelectProvider(type=WithdrawSplittingSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="BASE_COST", property="baseCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="BASE_COST_SPLITTING_SCALE", property="baseCostSplittingScale", jdbcType=JdbcType.DECIMAL),
        @Result(column="BASE_COST_SHENGPAY_SPLITTING", property="baseCostShengpaySplitting", jdbcType=JdbcType.DECIMAL),
        @Result(column="BASE_COST_PROMOTER_SPLITTING", property="baseCostPromoterSplitting", jdbcType=JdbcType.DECIMAL),
        @Result(column="WD_COST", property="wdCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="WD_COST_SPLITTING_SCALE", property="wdCostSplittingScale", jdbcType=JdbcType.DECIMAL),
        @Result(column="WD_COST_SHENGPAY_SPLITTING", property="wdCostShengpaySplitting", jdbcType=JdbcType.DECIMAL),
        @Result(column="WD_COST_PROMOTER_SPLITTING", property="wdCostPromoterSplitting", jdbcType=JdbcType.DECIMAL),
        @Result(column="PLATFORM_COST", property="platformCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="SHENGPAY_TOTAL_COST", property="shengpayTotalCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_TOTAL_COST", property="promoterTotalCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="DAY_SETTLE_AWARD", property="daySettleAward", jdbcType=JdbcType.DECIMAL),
        @Result(column="MONTH_ACTIVE_AWARD", property="monthActiveAward", jdbcType=JdbcType.DECIMAL)
    })
    List<WithdrawSplittingDO> selectByQuery(WithdrawSplittingDOExample example);

    /**
     * 根据主键查询出款分润表【WithdrawSplittingDO】对象信息
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    @Select({
        "select",
        "ID, REQ_ID, BASE_COST, BASE_COST_SPLITTING_SCALE, BASE_COST_SHENGPAY_SPLITTING, ",
        "BASE_COST_PROMOTER_SPLITTING, WD_COST, WD_COST_SPLITTING_SCALE, WD_COST_SHENGPAY_SPLITTING, ",
        "WD_COST_PROMOTER_SPLITTING, PLATFORM_COST, SHENGPAY_TOTAL_COST, PROMOTER_TOTAL_COST, ",
        "CREATE_TIME, UPDATE_TIME, DAY_SETTLE_AWARD, MONTH_ACTIVE_AWARD",
        "from FW_WITHDRAW_SPLITTING",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="BASE_COST", property="baseCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="BASE_COST_SPLITTING_SCALE", property="baseCostSplittingScale", jdbcType=JdbcType.DECIMAL),
        @Result(column="BASE_COST_SHENGPAY_SPLITTING", property="baseCostShengpaySplitting", jdbcType=JdbcType.DECIMAL),
        @Result(column="BASE_COST_PROMOTER_SPLITTING", property="baseCostPromoterSplitting", jdbcType=JdbcType.DECIMAL),
        @Result(column="WD_COST", property="wdCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="WD_COST_SPLITTING_SCALE", property="wdCostSplittingScale", jdbcType=JdbcType.DECIMAL),
        @Result(column="WD_COST_SHENGPAY_SPLITTING", property="wdCostShengpaySplitting", jdbcType=JdbcType.DECIMAL),
        @Result(column="WD_COST_PROMOTER_SPLITTING", property="wdCostPromoterSplitting", jdbcType=JdbcType.DECIMAL),
        @Result(column="PLATFORM_COST", property="platformCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="SHENGPAY_TOTAL_COST", property="shengpayTotalCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_TOTAL_COST", property="promoterTotalCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="DAY_SETTLE_AWARD", property="daySettleAward", jdbcType=JdbcType.DECIMAL),
        @Result(column="MONTH_ACTIVE_AWARD", property="monthActiveAward", jdbcType=JdbcType.DECIMAL)
    })
    WithdrawSplittingDO selectByPrimaryKey(Long id);

    /**
     * 根据Example对象更新出款分润表【WithdrawSplittingDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    @UpdateProvider(type=WithdrawSplittingSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WithdrawSplittingDO record, @Param("example") WithdrawSplittingDOExample example);

    /**
     * 根据Example对象更新出款分润表【WithdrawSplittingDO】对象信息
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    @UpdateProvider(type=WithdrawSplittingSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") WithdrawSplittingDO record, @Param("example") WithdrawSplittingDOExample example);

    /**
     * 根据主键更新出款分润表【WithdrawSplittingDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    @UpdateProvider(type=WithdrawSplittingSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WithdrawSplittingDO record);

    /**
     * 根据主键更新出款分润表【WithdrawSplittingDO】对象信息
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    @Update({
        "update FW_WITHDRAW_SPLITTING",
        "set REQ_ID = #{reqId,jdbcType=DECIMAL},",
          "BASE_COST = #{baseCost,jdbcType=DECIMAL},",
          "BASE_COST_SPLITTING_SCALE = #{baseCostSplittingScale,jdbcType=DECIMAL},",
          "BASE_COST_SHENGPAY_SPLITTING = #{baseCostShengpaySplitting,jdbcType=DECIMAL},",
          "BASE_COST_PROMOTER_SPLITTING = #{baseCostPromoterSplitting,jdbcType=DECIMAL},",
          "WD_COST = #{wdCost,jdbcType=DECIMAL},",
          "WD_COST_SPLITTING_SCALE = #{wdCostSplittingScale,jdbcType=DECIMAL},",
          "WD_COST_SHENGPAY_SPLITTING = #{wdCostShengpaySplitting,jdbcType=DECIMAL},",
          "WD_COST_PROMOTER_SPLITTING = #{wdCostPromoterSplitting,jdbcType=DECIMAL},",
          "PLATFORM_COST = #{platformCost,jdbcType=DECIMAL},",
          "SHENGPAY_TOTAL_COST = #{shengpayTotalCost,jdbcType=DECIMAL},",
          "PROMOTER_TOTAL_COST = #{promoterTotalCost,jdbcType=DECIMAL},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "DAY_SETTLE_AWARD = #{daySettleAward,jdbcType=DECIMAL},",
          "MONTH_ACTIVE_AWARD = #{monthActiveAward,jdbcType=DECIMAL}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(WithdrawSplittingDO record);
}