package com.sdp.mc.mcwithfunding.dao.mapper;

import com.sdp.mc.mcwithfunding.dao.WithCapital4PromoterDO;
import com.sdp.mc.mcwithfunding.dao.WithCapital4PromoterDOExample;
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

public interface WithCapital4PromoterMapper {
    /**
     * 根据Example对象取得代理商配资记录表【WithCapital4PromoterDO】对象count信息
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    @SelectProvider(type=WithCapital4PromoterSqlProvider.class, method="countByExample")
    int countByExample(WithCapital4PromoterDOExample example);

    /**
     * 根据Example对象删除代理商配资记录表【WithCapital4PromoterDO】对象信息
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    @DeleteProvider(type=WithCapital4PromoterSqlProvider.class, method="deleteByExample")
    int deleteByExample(WithCapital4PromoterDOExample example);

    /**
     * 根据主键删除代理商配资记录表【WithCapital4PromoterDO】对象信息
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    @Delete({
        "delete from MC_WITH_CAPITAL_4PROMOTER",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * 添加代理商配资记录表【WithCapital4PromoterDO】对象信息
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    @Insert({
        "insert into MC_WITH_CAPITAL_4PROMOTER (ID, MC_TYPE, ",
        "PROMOTER_ID, MERCHANT_NO, ",
        "PROMOTER_NAME, APPLY_DATETIME, ",
        "AMOUNT, FEE_RATIO, ",
        "FEE, CREDIT_FOS_ID, ",
        "CREDIT_CHANGE_ID, REVERSAL_FOS_ID, ",
        "REVERSAL_CHANGE_ID, STATUS, ",
        "UPDATE_TIME, BATCH_NO, ",
        "FEE_FOS_ID, RECOVERY_DATE, ",
        "RETRY_TIMES_4MSP)",
        "values (#{id,jdbcType=DECIMAL}, #{mcType,jdbcType=VARCHAR}, ",
        "#{promoterId,jdbcType=DECIMAL}, #{merchantNo,jdbcType=VARCHAR}, ",
        "#{promoterName,jdbcType=VARCHAR}, #{applyDatetime,jdbcType=TIMESTAMP}, ",
        "#{amount,jdbcType=DECIMAL}, #{feeRatio,jdbcType=VARCHAR}, ",
        "#{fee,jdbcType=DECIMAL}, #{creditFosId,jdbcType=DECIMAL}, ",
        "#{creditChangeId,jdbcType=DECIMAL}, #{reversalFosId,jdbcType=DECIMAL}, ",
        "#{reversalChangeId,jdbcType=DECIMAL}, #{status,jdbcType=DECIMAL}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{batchNo,jdbcType=VARCHAR}, ",
        "#{feeFosId,jdbcType=DECIMAL}, #{recoveryDate,jdbcType=TIMESTAMP}, ",
        "#{retryTimes4msp,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="select SEQ_MC_WITH_CAPITAL_4PROMOTER.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insert(WithCapital4PromoterDO record);

    /**
     * 添加代理商配资记录表【WithCapital4PromoterDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    @InsertProvider(type=WithCapital4PromoterSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_MC_WITH_CAPITAL_4PROMOTER.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insertSelective(WithCapital4PromoterDO record);

    /**
     * 根据Example对象查询得到代理商配资记录表【WithCapital4PromoterDO】对象列表信息
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    @SelectProvider(type=WithCapital4PromoterSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="MC_TYPE", property="mcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_NAME", property="promoterName", jdbcType=JdbcType.VARCHAR),
        @Result(column="APPLY_DATETIME", property="applyDatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="AMOUNT", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="FEE_RATIO", property="feeRatio", jdbcType=JdbcType.VARCHAR),
        @Result(column="FEE", property="fee", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREDIT_FOS_ID", property="creditFosId", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREDIT_CHANGE_ID", property="creditChangeId", jdbcType=JdbcType.DECIMAL),
        @Result(column="REVERSAL_FOS_ID", property="reversalFosId", jdbcType=JdbcType.DECIMAL),
        @Result(column="REVERSAL_CHANGE_ID", property="reversalChangeId", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="BATCH_NO", property="batchNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="FEE_FOS_ID", property="feeFosId", jdbcType=JdbcType.DECIMAL),
        @Result(column="RECOVERY_DATE", property="recoveryDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="RETRY_TIMES_4MSP", property="retryTimes4msp", jdbcType=JdbcType.DECIMAL)
    })
    List<WithCapital4PromoterDO> selectByExample(WithCapital4PromoterDOExample example);

    /**
     * 根据Query对象分页查询代理商配资记录表【WithCapital4PromoterDO】对象列表信息
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    @SelectProvider(type=WithCapital4PromoterSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="MC_TYPE", property="mcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_NAME", property="promoterName", jdbcType=JdbcType.VARCHAR),
        @Result(column="APPLY_DATETIME", property="applyDatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="AMOUNT", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="FEE_RATIO", property="feeRatio", jdbcType=JdbcType.VARCHAR),
        @Result(column="FEE", property="fee", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREDIT_FOS_ID", property="creditFosId", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREDIT_CHANGE_ID", property="creditChangeId", jdbcType=JdbcType.DECIMAL),
        @Result(column="REVERSAL_FOS_ID", property="reversalFosId", jdbcType=JdbcType.DECIMAL),
        @Result(column="REVERSAL_CHANGE_ID", property="reversalChangeId", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="BATCH_NO", property="batchNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="FEE_FOS_ID", property="feeFosId", jdbcType=JdbcType.DECIMAL),
        @Result(column="RECOVERY_DATE", property="recoveryDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="RETRY_TIMES_4MSP", property="retryTimes4msp", jdbcType=JdbcType.DECIMAL)
    })
    List<WithCapital4PromoterDO> selectByQuery(WithCapital4PromoterDOExample example);

    /**
     * 根据主键查询代理商配资记录表【WithCapital4PromoterDO】对象信息
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    @Select({
        "select",
        "ID, MC_TYPE, PROMOTER_ID, MERCHANT_NO, PROMOTER_NAME, APPLY_DATETIME, AMOUNT, ",
        "FEE_RATIO, FEE, CREDIT_FOS_ID, CREDIT_CHANGE_ID, REVERSAL_FOS_ID, REVERSAL_CHANGE_ID, ",
        "STATUS, UPDATE_TIME, BATCH_NO, FEE_FOS_ID, RECOVERY_DATE, RETRY_TIMES_4MSP",
        "from MC_WITH_CAPITAL_4PROMOTER",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="MC_TYPE", property="mcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_NAME", property="promoterName", jdbcType=JdbcType.VARCHAR),
        @Result(column="APPLY_DATETIME", property="applyDatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="AMOUNT", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="FEE_RATIO", property="feeRatio", jdbcType=JdbcType.VARCHAR),
        @Result(column="FEE", property="fee", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREDIT_FOS_ID", property="creditFosId", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREDIT_CHANGE_ID", property="creditChangeId", jdbcType=JdbcType.DECIMAL),
        @Result(column="REVERSAL_FOS_ID", property="reversalFosId", jdbcType=JdbcType.DECIMAL),
        @Result(column="REVERSAL_CHANGE_ID", property="reversalChangeId", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="BATCH_NO", property="batchNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="FEE_FOS_ID", property="feeFosId", jdbcType=JdbcType.DECIMAL),
        @Result(column="RECOVERY_DATE", property="recoveryDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="RETRY_TIMES_4MSP", property="retryTimes4msp", jdbcType=JdbcType.DECIMAL)
    })
    WithCapital4PromoterDO selectByPrimaryKey(Long id);

    /**
     * 根据Example对象更新代理商配资记录表【WithCapital4PromoterDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    @UpdateProvider(type=WithCapital4PromoterSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WithCapital4PromoterDO record, @Param("example") WithCapital4PromoterDOExample example);

    /**
     * 根据Example对象更新代理商配资记录表【WithCapital4PromoterDO】对象信息
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    @UpdateProvider(type=WithCapital4PromoterSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") WithCapital4PromoterDO record, @Param("example") WithCapital4PromoterDOExample example);

    /**
     * 根据主键更新代理商配资记录表【WithCapital4PromoterDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    @UpdateProvider(type=WithCapital4PromoterSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WithCapital4PromoterDO record);

    /**
     * 根据主键更新代理商配资记录表【WithCapital4PromoterDO】对象信息
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    @Update({
        "update MC_WITH_CAPITAL_4PROMOTER",
        "set MC_TYPE = #{mcType,jdbcType=VARCHAR},",
          "PROMOTER_ID = #{promoterId,jdbcType=DECIMAL},",
          "MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR},",
          "PROMOTER_NAME = #{promoterName,jdbcType=VARCHAR},",
          "APPLY_DATETIME = #{applyDatetime,jdbcType=TIMESTAMP},",
          "AMOUNT = #{amount,jdbcType=DECIMAL},",
          "FEE_RATIO = #{feeRatio,jdbcType=VARCHAR},",
          "FEE = #{fee,jdbcType=DECIMAL},",
          "CREDIT_FOS_ID = #{creditFosId,jdbcType=DECIMAL},",
          "CREDIT_CHANGE_ID = #{creditChangeId,jdbcType=DECIMAL},",
          "REVERSAL_FOS_ID = #{reversalFosId,jdbcType=DECIMAL},",
          "REVERSAL_CHANGE_ID = #{reversalChangeId,jdbcType=DECIMAL},",
          "STATUS = #{status,jdbcType=DECIMAL},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "BATCH_NO = #{batchNo,jdbcType=VARCHAR},",
          "FEE_FOS_ID = #{feeFosId,jdbcType=DECIMAL},",
          "RECOVERY_DATE = #{recoveryDate,jdbcType=TIMESTAMP},",
          "RETRY_TIMES_4MSP = #{retryTimes4msp,jdbcType=DECIMAL}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(WithCapital4PromoterDO record);
}