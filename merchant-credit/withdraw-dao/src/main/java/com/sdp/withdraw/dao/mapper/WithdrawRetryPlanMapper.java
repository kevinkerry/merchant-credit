package com.sdp.withdraw.dao.mapper;

import com.sdp.withdraw.dao.WithdrawRetryPlanDO;
import com.sdp.withdraw.dao.WithdrawRetryPlanDOExample;
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

public interface WithdrawRetryPlanMapper {
    /**
     * 根据Example对象取得出款服务重试计划表【WithdrawRetryPlanDO】对象count信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    @SelectProvider(type=WithdrawRetryPlanSqlProvider.class, method="countByExample")
    int countByExample(WithdrawRetryPlanDOExample example);

    /**
     * 根据Example对象删除出款服务重试计划表【WithdrawRetryPlanDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    @DeleteProvider(type=WithdrawRetryPlanSqlProvider.class, method="deleteByExample")
    int deleteByExample(WithdrawRetryPlanDOExample example);

    /**
     * 根据主键删除出款服务重试计划表【WithdrawRetryPlanDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    @Delete({
        "delete from FW_WITHDRAW_RETRY_PLAN",
        "where PLAN_ID = #{planId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long planId);

    /**
     * 添加出款服务重试计划表【WithdrawRetryPlanDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    @Insert({
        "insert into FW_WITHDRAW_RETRY_PLAN (PLAN_ID, REQ_ID, ",
        "CURRENT_REMIT_VOUCHER_NO, EXECUTE_REMIT_VOUCHER_NO, ",
        "RETRY_RULE, RETRY_EXECUTE_TIMES, ",
        "EXECUTE_START_TIME, EXECUTE_STATUS, ",
        "EXECUTE_TIME, CREATE_TIME, ",
        "UPDATE_TIME)",
        "values (#{planId,jdbcType=DECIMAL}, #{reqId,jdbcType=DECIMAL}, ",
        "#{currentRemitVoucherNo,jdbcType=VARCHAR}, #{executeRemitVoucherNo,jdbcType=VARCHAR}, ",
        "#{retryRule,jdbcType=VARCHAR}, #{retryExecuteTimes,jdbcType=DECIMAL}, ",
        "#{executeStartTime,jdbcType=TIMESTAMP}, #{executeStatus,jdbcType=DECIMAL}, ",
        "#{executeTime,jdbcType=TIMESTAMP}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select SEQ_FW_WITHDRAW_RETRY_PLAN.nextval from dual", keyProperty="planId", before=true, resultType=Long.class)
    Long insert(WithdrawRetryPlanDO record);

    /**
     * 添加出款服务重试计划表【WithdrawRetryPlanDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    @InsertProvider(type=WithdrawRetryPlanSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_FW_WITHDRAW_RETRY_PLAN.nextval from dual", keyProperty="planId", before=true, resultType=Long.class)
    Long insertSelective(WithdrawRetryPlanDO record);

    /**
     * 根据Example对象查询得到出款服务重试计划表【WithdrawRetryPlanDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    @SelectProvider(type=WithdrawRetryPlanSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="PLAN_ID", property="planId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="CURRENT_REMIT_VOUCHER_NO", property="currentRemitVoucherNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXECUTE_REMIT_VOUCHER_NO", property="executeRemitVoucherNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="RETRY_RULE", property="retryRule", jdbcType=JdbcType.VARCHAR),
        @Result(column="RETRY_EXECUTE_TIMES", property="retryExecuteTimes", jdbcType=JdbcType.DECIMAL),
        @Result(column="EXECUTE_START_TIME", property="executeStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="EXECUTE_STATUS", property="executeStatus", jdbcType=JdbcType.DECIMAL),
        @Result(column="EXECUTE_TIME", property="executeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<WithdrawRetryPlanDO> selectByExample(WithdrawRetryPlanDOExample example);

    /**
     * 根据Query对象分页查询出款服务重试计划表【WithdrawRetryPlanDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    @SelectProvider(type=WithdrawRetryPlanSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="PLAN_ID", property="planId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="CURRENT_REMIT_VOUCHER_NO", property="currentRemitVoucherNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXECUTE_REMIT_VOUCHER_NO", property="executeRemitVoucherNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="RETRY_RULE", property="retryRule", jdbcType=JdbcType.VARCHAR),
        @Result(column="RETRY_EXECUTE_TIMES", property="retryExecuteTimes", jdbcType=JdbcType.DECIMAL),
        @Result(column="EXECUTE_START_TIME", property="executeStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="EXECUTE_STATUS", property="executeStatus", jdbcType=JdbcType.DECIMAL),
        @Result(column="EXECUTE_TIME", property="executeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<WithdrawRetryPlanDO> selectByQuery(WithdrawRetryPlanDOExample example);

    /**
     * 根据主键查询出款服务重试计划表【WithdrawRetryPlanDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    @Select({
        "select",
        "PLAN_ID, REQ_ID, CURRENT_REMIT_VOUCHER_NO, EXECUTE_REMIT_VOUCHER_NO, RETRY_RULE, ",
        "RETRY_EXECUTE_TIMES, EXECUTE_START_TIME, EXECUTE_STATUS, EXECUTE_TIME, CREATE_TIME, ",
        "UPDATE_TIME",
        "from FW_WITHDRAW_RETRY_PLAN",
        "where PLAN_ID = #{planId,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="PLAN_ID", property="planId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="CURRENT_REMIT_VOUCHER_NO", property="currentRemitVoucherNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXECUTE_REMIT_VOUCHER_NO", property="executeRemitVoucherNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="RETRY_RULE", property="retryRule", jdbcType=JdbcType.VARCHAR),
        @Result(column="RETRY_EXECUTE_TIMES", property="retryExecuteTimes", jdbcType=JdbcType.DECIMAL),
        @Result(column="EXECUTE_START_TIME", property="executeStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="EXECUTE_STATUS", property="executeStatus", jdbcType=JdbcType.DECIMAL),
        @Result(column="EXECUTE_TIME", property="executeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    WithdrawRetryPlanDO selectByPrimaryKey(Long planId);

    /**
     * 根据Example对象更新出款服务重试计划表【WithdrawRetryPlanDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    @UpdateProvider(type=WithdrawRetryPlanSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WithdrawRetryPlanDO record, @Param("example") WithdrawRetryPlanDOExample example);

    /**
     * 根据Example对象更新出款服务重试计划表【WithdrawRetryPlanDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    @UpdateProvider(type=WithdrawRetryPlanSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") WithdrawRetryPlanDO record, @Param("example") WithdrawRetryPlanDOExample example);

    /**
     * 根据主键更新出款服务重试计划表【WithdrawRetryPlanDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    @UpdateProvider(type=WithdrawRetryPlanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WithdrawRetryPlanDO record);

    /**
     * 根据主键更新出款服务重试计划表【WithdrawRetryPlanDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    @Update({
        "update FW_WITHDRAW_RETRY_PLAN",
        "set REQ_ID = #{reqId,jdbcType=DECIMAL},",
          "CURRENT_REMIT_VOUCHER_NO = #{currentRemitVoucherNo,jdbcType=VARCHAR},",
          "EXECUTE_REMIT_VOUCHER_NO = #{executeRemitVoucherNo,jdbcType=VARCHAR},",
          "RETRY_RULE = #{retryRule,jdbcType=VARCHAR},",
          "RETRY_EXECUTE_TIMES = #{retryExecuteTimes,jdbcType=DECIMAL},",
          "EXECUTE_START_TIME = #{executeStartTime,jdbcType=TIMESTAMP},",
          "EXECUTE_STATUS = #{executeStatus,jdbcType=DECIMAL},",
          "EXECUTE_TIME = #{executeTime,jdbcType=TIMESTAMP},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where PLAN_ID = #{planId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(WithdrawRetryPlanDO record);
}