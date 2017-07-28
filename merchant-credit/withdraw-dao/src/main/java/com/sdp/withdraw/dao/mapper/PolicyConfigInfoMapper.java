package com.sdp.withdraw.dao.mapper;

import com.sdp.withdraw.dao.PolicyConfigInfoDO;
import com.sdp.withdraw.dao.PolicyConfigInfoDOExample;
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

public interface PolicyConfigInfoMapper {
    /**
     * 根据Example对象取得政策配置信息【PolicyConfigInfoDO】对象count信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    @SelectProvider(type=PolicyConfigInfoSqlProvider.class, method="countByExample")
    int countByExample(PolicyConfigInfoDOExample example);

    /**
     * 根据Example对象删除政策配置信息【PolicyConfigInfoDO】对象信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    @DeleteProvider(type=PolicyConfigInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(PolicyConfigInfoDOExample example);

    /**
     * 根据主键删除政策配置信息【PolicyConfigInfoDO】对象信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    @Delete({
        "delete from FW_POLICY_CONFIG_INFO",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * 添加政策配置信息【PolicyConfigInfoDO】对象信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    @Insert({
        "insert into FW_POLICY_CONFIG_INFO (ID, POLICY_ID, ",
        "FAST_SETTLE_FLAG, AUTO_FAST_SETTLE_FLAG, ",
        "FAST_SETTLE_LIMIT, HOLIDAY_RATIO, ",
        "WORKDAY_RATIO, POMOTER_MODIFY_FLAG, ",
        "STATUS, CREATE_TIME, ",
        "UPDATE_TIME, CREATE_OPERATOR, ",
        "UPDATE_OPERATOR, POLICY_NAME, ",
        "POLICY_TYPE, DEPEND_CREDIT_AUTH_FLAG, ",
        "WITHDRAW_COST, QUOTA_TYPE, ",
        "OA_TXN_WITHDRAW_COST)",
        "values (#{id,jdbcType=DECIMAL}, #{policyId,jdbcType=VARCHAR}, ",
        "#{fastSettleFlag,jdbcType=DECIMAL}, #{autoFastSettleFlag,jdbcType=DECIMAL}, ",
        "#{fastSettleLimit,jdbcType=DECIMAL}, #{holidayRatio,jdbcType=DECIMAL}, ",
        "#{workdayRatio,jdbcType=DECIMAL}, #{promoterModifyFlag,jdbcType=DECIMAL}, ",
        "#{status,jdbcType=DECIMAL}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{createOperator,jdbcType=VARCHAR}, ",
        "#{updateOperator,jdbcType=VARCHAR}, #{policyName,jdbcType=VARCHAR}, ",
        "#{policyType,jdbcType=DECIMAL}, #{dependCreditAuthFlag,jdbcType=DECIMAL}, ",
        "#{withdrawCost,jdbcType=DECIMAL}, #{quotaType,jdbcType=DECIMAL}, ",
        "#{oaTxnWithdrawCost,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="select SEQ_FW_POLICY_CONFIG_INFO.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insert(PolicyConfigInfoDO record);

    /**
     * 添加政策配置信息【PolicyConfigInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    @InsertProvider(type=PolicyConfigInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_FW_POLICY_CONFIG_INFO.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insertSelective(PolicyConfigInfoDO record);

    /**
     * 根据Example对象查询得到政策配置信息【PolicyConfigInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    @SelectProvider(type=PolicyConfigInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="POLICY_ID", property="policyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="FAST_SETTLE_FLAG", property="fastSettleFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="AUTO_FAST_SETTLE_FLAG", property="autoFastSettleFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_LIMIT", property="fastSettleLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="HOLIDAY_RATIO", property="holidayRatio", jdbcType=JdbcType.DECIMAL),
        @Result(column="WORKDAY_RATIO", property="workdayRatio", jdbcType=JdbcType.DECIMAL),
        @Result(column="POMOTER_MODIFY_FLAG", property="promoterModifyFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_OPERATOR", property="createOperator", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_OPERATOR", property="updateOperator", jdbcType=JdbcType.VARCHAR),
        @Result(column="POLICY_NAME", property="policyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="POLICY_TYPE", property="policyType", jdbcType=JdbcType.DECIMAL),
        @Result(column="DEPEND_CREDIT_AUTH_FLAG", property="dependCreditAuthFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="WITHDRAW_COST", property="withdrawCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="QUOTA_TYPE", property="quotaType", jdbcType=JdbcType.DECIMAL),
        @Result(column="OA_TXN_WITHDRAW_COST", property="oaTxnWithdrawCost", jdbcType=JdbcType.DECIMAL)
    })
    List<PolicyConfigInfoDO> selectByExample(PolicyConfigInfoDOExample example);

    /**
     * 根据Query对象分页查询政策配置信息【PolicyConfigInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    @SelectProvider(type=PolicyConfigInfoSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="POLICY_ID", property="policyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="FAST_SETTLE_FLAG", property="fastSettleFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="AUTO_FAST_SETTLE_FLAG", property="autoFastSettleFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_LIMIT", property="fastSettleLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="HOLIDAY_RATIO", property="holidayRatio", jdbcType=JdbcType.DECIMAL),
        @Result(column="WORKDAY_RATIO", property="workdayRatio", jdbcType=JdbcType.DECIMAL),
        @Result(column="POMOTER_MODIFY_FLAG", property="promoterModifyFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_OPERATOR", property="createOperator", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_OPERATOR", property="updateOperator", jdbcType=JdbcType.VARCHAR),
        @Result(column="POLICY_NAME", property="policyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="POLICY_TYPE", property="policyType", jdbcType=JdbcType.DECIMAL),
        @Result(column="DEPEND_CREDIT_AUTH_FLAG", property="dependCreditAuthFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="WITHDRAW_COST", property="withdrawCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="QUOTA_TYPE", property="quotaType", jdbcType=JdbcType.DECIMAL),
        @Result(column="OA_TXN_WITHDRAW_COST", property="oaTxnWithdrawCost", jdbcType=JdbcType.DECIMAL)
    })
    List<PolicyConfigInfoDO> selectByQuery(PolicyConfigInfoDOExample example);

    /**
     * 根据主键查询政策配置信息【PolicyConfigInfoDO】对象信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    @Select({
        "select",
        "ID, POLICY_ID, FAST_SETTLE_FLAG, AUTO_FAST_SETTLE_FLAG, FAST_SETTLE_LIMIT, HOLIDAY_RATIO, ",
        "WORKDAY_RATIO, POMOTER_MODIFY_FLAG, STATUS, CREATE_TIME, UPDATE_TIME, CREATE_OPERATOR, ",
        "UPDATE_OPERATOR, POLICY_NAME, POLICY_TYPE, DEPEND_CREDIT_AUTH_FLAG, WITHDRAW_COST, ",
        "QUOTA_TYPE, OA_TXN_WITHDRAW_COST",
        "from FW_POLICY_CONFIG_INFO",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="POLICY_ID", property="policyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="FAST_SETTLE_FLAG", property="fastSettleFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="AUTO_FAST_SETTLE_FLAG", property="autoFastSettleFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_LIMIT", property="fastSettleLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="HOLIDAY_RATIO", property="holidayRatio", jdbcType=JdbcType.DECIMAL),
        @Result(column="WORKDAY_RATIO", property="workdayRatio", jdbcType=JdbcType.DECIMAL),
        @Result(column="POMOTER_MODIFY_FLAG", property="promoterModifyFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_OPERATOR", property="createOperator", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_OPERATOR", property="updateOperator", jdbcType=JdbcType.VARCHAR),
        @Result(column="POLICY_NAME", property="policyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="POLICY_TYPE", property="policyType", jdbcType=JdbcType.DECIMAL),
        @Result(column="DEPEND_CREDIT_AUTH_FLAG", property="dependCreditAuthFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="WITHDRAW_COST", property="withdrawCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="QUOTA_TYPE", property="quotaType", jdbcType=JdbcType.DECIMAL),
        @Result(column="OA_TXN_WITHDRAW_COST", property="oaTxnWithdrawCost", jdbcType=JdbcType.DECIMAL)
    })
    PolicyConfigInfoDO selectByPrimaryKey(Long id);

    /**
     * 根据Example对象更新政策配置信息【PolicyConfigInfoDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    @UpdateProvider(type=PolicyConfigInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PolicyConfigInfoDO record, @Param("example") PolicyConfigInfoDOExample example);

    /**
     * 根据Example对象更新政策配置信息【PolicyConfigInfoDO】对象信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    @UpdateProvider(type=PolicyConfigInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PolicyConfigInfoDO record, @Param("example") PolicyConfigInfoDOExample example);

    /**
     * 根据主键更新政策配置信息【PolicyConfigInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    @UpdateProvider(type=PolicyConfigInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PolicyConfigInfoDO record);

    /**
     * 根据主键更新政策配置信息【PolicyConfigInfoDO】对象信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    @Update({
        "update FW_POLICY_CONFIG_INFO",
        "set POLICY_ID = #{policyId,jdbcType=VARCHAR},",
          "FAST_SETTLE_FLAG = #{fastSettleFlag,jdbcType=DECIMAL},",
          "AUTO_FAST_SETTLE_FLAG = #{autoFastSettleFlag,jdbcType=DECIMAL},",
          "FAST_SETTLE_LIMIT = #{fastSettleLimit,jdbcType=DECIMAL},",
          "HOLIDAY_RATIO = #{holidayRatio,jdbcType=DECIMAL},",
          "WORKDAY_RATIO = #{workdayRatio,jdbcType=DECIMAL},",
          "POMOTER_MODIFY_FLAG = #{promoterModifyFlag,jdbcType=DECIMAL},",
          "STATUS = #{status,jdbcType=DECIMAL},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "CREATE_OPERATOR = #{createOperator,jdbcType=VARCHAR},",
          "UPDATE_OPERATOR = #{updateOperator,jdbcType=VARCHAR},",
          "POLICY_NAME = #{policyName,jdbcType=VARCHAR},",
          "POLICY_TYPE = #{policyType,jdbcType=DECIMAL},",
          "DEPEND_CREDIT_AUTH_FLAG = #{dependCreditAuthFlag,jdbcType=DECIMAL},",
          "WITHDRAW_COST = #{withdrawCost,jdbcType=DECIMAL},",
          "QUOTA_TYPE = #{quotaType,jdbcType=DECIMAL},",
          "OA_TXN_WITHDRAW_COST = #{oaTxnWithdrawCost,jdbcType=DECIMAL}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(PolicyConfigInfoDO record);
}