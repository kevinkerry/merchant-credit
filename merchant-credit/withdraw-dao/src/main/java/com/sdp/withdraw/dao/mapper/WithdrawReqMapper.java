package com.sdp.withdraw.dao.mapper;

import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqDOExample;
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

public interface WithdrawReqMapper {
    /**
     * 根据Example对象取得出款业务请求表【WithdrawReqDO】对象count信息
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    @SelectProvider(type=WithdrawReqSqlProvider.class, method="countByExample")
    int countByExample(WithdrawReqDOExample example);

    /**
     * 根据Example对象删除出款业务请求表【WithdrawReqDO】对象信息
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    @DeleteProvider(type=WithdrawReqSqlProvider.class, method="deleteByExample")
    int deleteByExample(WithdrawReqDOExample example);

    /**
     * 根据主键删除出款业务请求表【WithdrawReqDO】对象信息
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    @Delete({
        "delete from FW_WITHDRAW_REQ",
        "where REQ_ID = #{reqId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long reqId);

    /**
     * 添加出款业务请求表【WithdrawReqDO】对象信息
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    @Insert({
        "insert into FW_WITHDRAW_REQ (REQ_ID, REQ_TYPE, ",
        "APP_ID, ORDER_NO, ",
        "MEMBER_ID, MERCHANT_NO, ",
        "MC_TYPE, WITHDRAW_TYPE, ",
        "WITHDRAW_AMOUNT, WITHDRAW_FEE, ",
        "WITHDRAW_COST, ORIGINAL_AMOUNT, ",
        "SPLITTING_FEE, SPLITTING_COST, ",
        "PMT_MEMBER_ID, PMT_MERCHANT_NO, ",
        "STATUS, RETRY_TIMES, ",
        "ERROR_CODE, ERROR_MSG, ",
        "CALLBACK_ADDRESS, APPLY_TIME, ",
        "CREATE_TIME, UPDATE_TIME, ",
        "SERVICE_TYPE, PRODUCT_CODE, ",
        "PAYMENT_CODE, WITHDRAW_TIME, ",
        "LOANING_TYPE, WD_COST, ",
        "MERCHANT_BIZ_ID, MCC, ",
        "LAST_LEVEL_PROMOTER_ID, LAST_DETAIL_ID, ",
        "HAS_OA_TXN, REQ_EXTENTION)",
        "values (#{reqId,jdbcType=DECIMAL}, #{reqType,jdbcType=DECIMAL}, ",
        "#{appId,jdbcType=VARCHAR}, #{orderNo,jdbcType=VARCHAR}, ",
        "#{memberId,jdbcType=VARCHAR}, #{merchantNo,jdbcType=VARCHAR}, ",
        "#{mcType,jdbcType=VARCHAR}, #{withdrawType,jdbcType=DECIMAL}, ",
        "#{withdrawAmount,jdbcType=DECIMAL}, #{withdrawFee,jdbcType=DECIMAL}, ",
        "#{withdrawCost,jdbcType=DECIMAL}, #{originalAmount,jdbcType=DECIMAL}, ",
        "#{splittingFee,jdbcType=DECIMAL}, #{splittingCost,jdbcType=DECIMAL}, ",
        "#{pmtMemberId,jdbcType=VARCHAR}, #{pmtMerchantNo,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=DECIMAL}, #{retryTimes,jdbcType=DECIMAL}, ",
        "#{errorCode,jdbcType=VARCHAR}, #{errorMsg,jdbcType=VARCHAR}, ",
        "#{callbackAddress,jdbcType=VARCHAR}, #{applyTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{serviceType,jdbcType=DECIMAL}, #{productCode,jdbcType=VARCHAR}, ",
        "#{paymentCode,jdbcType=VARCHAR}, #{withdrawTime,jdbcType=TIMESTAMP}, ",
        "#{loaningType,jdbcType=DECIMAL}, #{wdCost,jdbcType=DECIMAL}, ",
        "#{merchantBizId,jdbcType=DECIMAL}, #{mcc,jdbcType=VARCHAR}, ",
        "#{lastLevelPromoterId,jdbcType=DECIMAL}, #{lastDetailId,jdbcType=DECIMAL}, ",
        "#{hasOaTxn,jdbcType=VARCHAR}, #{reqExtention,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="select SEQ_FW_WITHDRAW_REQ.nextval from dual", keyProperty="reqId", before=true, resultType=Long.class)
    Long insert(WithdrawReqDO record);

    /**
     * 添加出款业务请求表【WithdrawReqDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    @InsertProvider(type=WithdrawReqSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_FW_WITHDRAW_REQ.nextval from dual", keyProperty="reqId", before=true, resultType=Long.class)
    Long insertSelective(WithdrawReqDO record);

    /**
     * 根据Example对象查询得到出款业务请求表【WithdrawReqDO】对象列表信息
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    @SelectProvider(type=WithdrawReqSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REQ_TYPE", property="reqType", jdbcType=JdbcType.DECIMAL),
        @Result(column="APP_ID", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ORDER_NO", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMBER_ID", property="memberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MC_TYPE", property="mcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="WITHDRAW_TYPE", property="withdrawType", jdbcType=JdbcType.DECIMAL),
        @Result(column="WITHDRAW_AMOUNT", property="withdrawAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="WITHDRAW_FEE", property="withdrawFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="WITHDRAW_COST", property="withdrawCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="ORIGINAL_AMOUNT", property="originalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="SPLITTING_FEE", property="splittingFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="SPLITTING_COST", property="splittingCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="PMT_MEMBER_ID", property="pmtMemberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="PMT_MERCHANT_NO", property="pmtMerchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="RETRY_TIMES", property="retryTimes", jdbcType=JdbcType.DECIMAL),
        @Result(column="ERROR_CODE", property="errorCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="ERROR_MSG", property="errorMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="CALLBACK_ADDRESS", property="callbackAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="APPLY_TIME", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="SERVICE_TYPE", property="serviceType", jdbcType=JdbcType.DECIMAL),
        @Result(column="PRODUCT_CODE", property="productCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYMENT_CODE", property="paymentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="WITHDRAW_TIME", property="withdrawTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="WD_COST", property="wdCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_BIZ_ID", property="merchantBizId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MCC", property="mcc", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_LEVEL_PROMOTER_ID", property="lastLevelPromoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="LAST_DETAIL_ID", property="lastDetailId", jdbcType=JdbcType.DECIMAL),
        @Result(column="HAS_OA_TXN", property="hasOaTxn", jdbcType=JdbcType.VARCHAR),
        @Result(column="REQ_EXTENTION", property="reqExtention", jdbcType=JdbcType.VARCHAR)
    })
    List<WithdrawReqDO> selectByExample(WithdrawReqDOExample example);

    /**
     * 根据Query对象分页查询出款业务请求表【WithdrawReqDO】对象列表信息
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    @SelectProvider(type=WithdrawReqSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REQ_TYPE", property="reqType", jdbcType=JdbcType.DECIMAL),
        @Result(column="APP_ID", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ORDER_NO", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMBER_ID", property="memberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MC_TYPE", property="mcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="WITHDRAW_TYPE", property="withdrawType", jdbcType=JdbcType.DECIMAL),
        @Result(column="WITHDRAW_AMOUNT", property="withdrawAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="WITHDRAW_FEE", property="withdrawFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="WITHDRAW_COST", property="withdrawCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="ORIGINAL_AMOUNT", property="originalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="SPLITTING_FEE", property="splittingFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="SPLITTING_COST", property="splittingCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="PMT_MEMBER_ID", property="pmtMemberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="PMT_MERCHANT_NO", property="pmtMerchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="RETRY_TIMES", property="retryTimes", jdbcType=JdbcType.DECIMAL),
        @Result(column="ERROR_CODE", property="errorCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="ERROR_MSG", property="errorMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="CALLBACK_ADDRESS", property="callbackAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="APPLY_TIME", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="SERVICE_TYPE", property="serviceType", jdbcType=JdbcType.DECIMAL),
        @Result(column="PRODUCT_CODE", property="productCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYMENT_CODE", property="paymentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="WITHDRAW_TIME", property="withdrawTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="WD_COST", property="wdCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_BIZ_ID", property="merchantBizId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MCC", property="mcc", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_LEVEL_PROMOTER_ID", property="lastLevelPromoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="LAST_DETAIL_ID", property="lastDetailId", jdbcType=JdbcType.DECIMAL),
        @Result(column="HAS_OA_TXN", property="hasOaTxn", jdbcType=JdbcType.VARCHAR),
        @Result(column="REQ_EXTENTION", property="reqExtention", jdbcType=JdbcType.VARCHAR)
    })
    List<WithdrawReqDO> selectByQuery(WithdrawReqDOExample example);

    /**
     * 根据主键查询出款业务请求表【WithdrawReqDO】对象信息
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    @Select({
        "select",
        "REQ_ID, REQ_TYPE, APP_ID, ORDER_NO, MEMBER_ID, MERCHANT_NO, MC_TYPE, WITHDRAW_TYPE, ",
        "WITHDRAW_AMOUNT, WITHDRAW_FEE, WITHDRAW_COST, ORIGINAL_AMOUNT, SPLITTING_FEE, ",
        "SPLITTING_COST, PMT_MEMBER_ID, PMT_MERCHANT_NO, STATUS, RETRY_TIMES, ERROR_CODE, ",
        "ERROR_MSG, CALLBACK_ADDRESS, APPLY_TIME, CREATE_TIME, UPDATE_TIME, SERVICE_TYPE, ",
        "PRODUCT_CODE, PAYMENT_CODE, WITHDRAW_TIME, LOANING_TYPE, WD_COST, MERCHANT_BIZ_ID, ",
        "MCC, LAST_LEVEL_PROMOTER_ID, LAST_DETAIL_ID, HAS_OA_TXN, REQ_EXTENTION",
        "from FW_WITHDRAW_REQ",
        "where REQ_ID = #{reqId,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REQ_TYPE", property="reqType", jdbcType=JdbcType.DECIMAL),
        @Result(column="APP_ID", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ORDER_NO", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMBER_ID", property="memberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MC_TYPE", property="mcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="WITHDRAW_TYPE", property="withdrawType", jdbcType=JdbcType.DECIMAL),
        @Result(column="WITHDRAW_AMOUNT", property="withdrawAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="WITHDRAW_FEE", property="withdrawFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="WITHDRAW_COST", property="withdrawCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="ORIGINAL_AMOUNT", property="originalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="SPLITTING_FEE", property="splittingFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="SPLITTING_COST", property="splittingCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="PMT_MEMBER_ID", property="pmtMemberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="PMT_MERCHANT_NO", property="pmtMerchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="RETRY_TIMES", property="retryTimes", jdbcType=JdbcType.DECIMAL),
        @Result(column="ERROR_CODE", property="errorCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="ERROR_MSG", property="errorMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="CALLBACK_ADDRESS", property="callbackAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="APPLY_TIME", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="SERVICE_TYPE", property="serviceType", jdbcType=JdbcType.DECIMAL),
        @Result(column="PRODUCT_CODE", property="productCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYMENT_CODE", property="paymentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="WITHDRAW_TIME", property="withdrawTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="WD_COST", property="wdCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_BIZ_ID", property="merchantBizId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MCC", property="mcc", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_LEVEL_PROMOTER_ID", property="lastLevelPromoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="LAST_DETAIL_ID", property="lastDetailId", jdbcType=JdbcType.DECIMAL),
        @Result(column="HAS_OA_TXN", property="hasOaTxn", jdbcType=JdbcType.VARCHAR),
        @Result(column="REQ_EXTENTION", property="reqExtention", jdbcType=JdbcType.VARCHAR)
    })
    WithdrawReqDO selectByPrimaryKey(Long reqId);

    /**
     * 根据Example对象更新出款业务请求表【WithdrawReqDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    @UpdateProvider(type=WithdrawReqSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WithdrawReqDO record, @Param("example") WithdrawReqDOExample example);

    /**
     * 根据Example对象更新出款业务请求表【WithdrawReqDO】对象信息
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    @UpdateProvider(type=WithdrawReqSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") WithdrawReqDO record, @Param("example") WithdrawReqDOExample example);

    /**
     * 根据主键更新出款业务请求表【WithdrawReqDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    @UpdateProvider(type=WithdrawReqSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WithdrawReqDO record);

    /**
     * 根据主键更新出款业务请求表【WithdrawReqDO】对象信息
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    @Update({
        "update FW_WITHDRAW_REQ",
        "set REQ_TYPE = #{reqType,jdbcType=DECIMAL},",
          "APP_ID = #{appId,jdbcType=VARCHAR},",
          "ORDER_NO = #{orderNo,jdbcType=VARCHAR},",
          "MEMBER_ID = #{memberId,jdbcType=VARCHAR},",
          "MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR},",
          "MC_TYPE = #{mcType,jdbcType=VARCHAR},",
          "WITHDRAW_TYPE = #{withdrawType,jdbcType=DECIMAL},",
          "WITHDRAW_AMOUNT = #{withdrawAmount,jdbcType=DECIMAL},",
          "WITHDRAW_FEE = #{withdrawFee,jdbcType=DECIMAL},",
          "WITHDRAW_COST = #{withdrawCost,jdbcType=DECIMAL},",
          "ORIGINAL_AMOUNT = #{originalAmount,jdbcType=DECIMAL},",
          "SPLITTING_FEE = #{splittingFee,jdbcType=DECIMAL},",
          "SPLITTING_COST = #{splittingCost,jdbcType=DECIMAL},",
          "PMT_MEMBER_ID = #{pmtMemberId,jdbcType=VARCHAR},",
          "PMT_MERCHANT_NO = #{pmtMerchantNo,jdbcType=VARCHAR},",
          "STATUS = #{status,jdbcType=DECIMAL},",
          "RETRY_TIMES = #{retryTimes,jdbcType=DECIMAL},",
          "ERROR_CODE = #{errorCode,jdbcType=VARCHAR},",
          "ERROR_MSG = #{errorMsg,jdbcType=VARCHAR},",
          "CALLBACK_ADDRESS = #{callbackAddress,jdbcType=VARCHAR},",
          "APPLY_TIME = #{applyTime,jdbcType=TIMESTAMP},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "SERVICE_TYPE = #{serviceType,jdbcType=DECIMAL},",
          "PRODUCT_CODE = #{productCode,jdbcType=VARCHAR},",
          "PAYMENT_CODE = #{paymentCode,jdbcType=VARCHAR},",
          "WITHDRAW_TIME = #{withdrawTime,jdbcType=TIMESTAMP},",
          "LOANING_TYPE = #{loaningType,jdbcType=DECIMAL},",
          "WD_COST = #{wdCost,jdbcType=DECIMAL},",
          "MERCHANT_BIZ_ID = #{merchantBizId,jdbcType=DECIMAL},",
          "MCC = #{mcc,jdbcType=VARCHAR},",
          "LAST_LEVEL_PROMOTER_ID = #{lastLevelPromoterId,jdbcType=DECIMAL},",
          "LAST_DETAIL_ID = #{lastDetailId,jdbcType=DECIMAL},",
          "HAS_OA_TXN = #{hasOaTxn,jdbcType=VARCHAR},",
          "REQ_EXTENTION = #{reqExtention,jdbcType=VARCHAR}",
        "where REQ_ID = #{reqId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(WithdrawReqDO record);
}