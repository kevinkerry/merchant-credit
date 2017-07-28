package com.sdp.mc.merchant.dao.mapper;

import com.sdp.mc.merchant.dao.MerchantFsReq;
import com.sdp.mc.merchant.dao.MerchantFsReqExample;
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

public interface MerchantFsRMapper {
    /**
     * 根据Example对象取得商户快速结算申请记录【MerchantFsReq】对象count信息
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    @SelectProvider(type=MerchantFsRSqlProvider.class, method="countByExample")
    int countByExample(MerchantFsReqExample example);

    /**
     * 根据Example对象删除商户快速结算申请记录【MerchantFsReq】对象信息
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    @DeleteProvider(type=MerchantFsRSqlProvider.class, method="deleteByExample")
    int deleteByExample(MerchantFsReqExample example);

    /**
     * 根据主键删除商户快速结算申请记录【MerchantFsReq】对象信息
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    @Delete({
        "delete from TB_MERCHANT_FS_REQ",
        "where MFQ_ID = #{mfqId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long mfqId);

    /**
     * 添加商户快速结算申请记录【MerchantFsReq】对象信息
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    @Insert({
        "insert into TB_MERCHANT_FS_REQ (MFQ_ID, MERCHANT_ID, ",
        "TYPE, STATUS, AMOUNT, ",
        "TRADE_CNT, SETTLE_FEE, ",
        "CREATE_TIME, UPDATE_TIME, ",
        "MERCHANT_NO, SETTLE_BILL_NO, ",
        "FUND_OUT_TIME, SETTLE_STATUS, ",
        "PAYMENT_ORDER_NO, PAYMENT_TIME, ",
        "PAYMENT_STATUS, MERCHANT_MEMBER_ID, ",
        "MERCHANT_ACCOUNT_NO, MERCHANT_ACCOUNT_TYPE, ",
        "SUB_STATUS, FAST_SETTLE_FEE, ",
        "MC_TYPE, MERCHANT_NAME, ",
        "PROMOTER_ID, PROMOTER_NAME, ",
        "PROMOTER_NO, REMIT_FEE_TRANS_ID, ",
        "LOANING_TYPE, APPLY_TIME, ",
        "WITHDRAW_RESPONSE_CODE, WITHDRAW_RESPONSE_MSG, ",
        "WITHDRAW_RESPONSE_TIME)",
        "values (#{mfqId,jdbcType=DECIMAL}, #{merchantId,jdbcType=DECIMAL}, ",
        "#{type,jdbcType=DECIMAL}, #{status,jdbcType=VARCHAR}, #{amount,jdbcType=DECIMAL}, ",
        "#{tradeCnt,jdbcType=DECIMAL}, #{settleFee,jdbcType=DECIMAL}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{merchantNo,jdbcType=VARCHAR}, #{settleBillNo,jdbcType=VARCHAR}, ",
        "#{fundOutTime,jdbcType=TIMESTAMP}, #{settleStatus,jdbcType=VARCHAR}, ",
        "#{paymentOrderNo,jdbcType=VARCHAR}, #{paymentTime,jdbcType=TIMESTAMP}, ",
        "#{paymentStatus,jdbcType=VARCHAR}, #{merchantMemberId,jdbcType=VARCHAR}, ",
        "#{merchantAccountNo,jdbcType=VARCHAR}, #{merchantAccountType,jdbcType=VARCHAR}, ",
        "#{subStatus,jdbcType=VARCHAR}, #{fastSettleFee,jdbcType=DECIMAL}, ",
        "#{mcType,jdbcType=VARCHAR}, #{merchantName,jdbcType=VARCHAR}, ",
        "#{promoterId,jdbcType=DECIMAL}, #{promoterName,jdbcType=VARCHAR}, ",
        "#{promoterNo,jdbcType=VARCHAR}, #{remitFeeTransId,jdbcType=DECIMAL}, ",
        "#{loaningType,jdbcType=DECIMAL}, #{applyTime,jdbcType=TIMESTAMP}, ",
        "#{withdrawResponseCode,jdbcType=VARCHAR}, #{withdrawResponseMsg,jdbcType=VARCHAR}, ",
        "#{withdrawResponseTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select SEQ_TB_MERCHANT_FS_REQ.nextval from dual", keyProperty="mfqId", before=true, resultType=Long.class)
    Long insert(MerchantFsReq record);

    /**
     * 添加商户快速结算申请记录【MerchantFsReq】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    @InsertProvider(type=MerchantFsRSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_TB_MERCHANT_FS_REQ.nextval from dual", keyProperty="mfqId", before=true, resultType=Long.class)
    Long insertSelective(MerchantFsReq record);

    /**
     * 根据Example对象查询得到商户快速结算申请记录【MerchantFsReq】对象列表信息
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    @SelectProvider(type=MerchantFsRSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="MFQ_ID", property="mfqId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="MERCHANT_ID", property="merchantId", jdbcType=JdbcType.DECIMAL),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="AMOUNT", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="TRADE_CNT", property="tradeCnt", jdbcType=JdbcType.DECIMAL),
        @Result(column="SETTLE_FEE", property="settleFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="SETTLE_BILL_NO", property="settleBillNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="FUND_OUT_TIME", property="fundOutTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="SETTLE_STATUS", property="settleStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYMENT_ORDER_NO", property="paymentOrderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYMENT_TIME", property="paymentTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="PAYMENT_STATUS", property="paymentStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_MEMBER_ID", property="merchantMemberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_ACCOUNT_NO", property="merchantAccountNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_ACCOUNT_TYPE", property="merchantAccountType", jdbcType=JdbcType.VARCHAR),
        @Result(column="SUB_STATUS", property="subStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="FAST_SETTLE_FEE", property="fastSettleFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="MC_TYPE", property="mcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_NAME", property="merchantName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_NAME", property="promoterName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_NO", property="promoterNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMIT_FEE_TRANS_ID", property="remitFeeTransId", jdbcType=JdbcType.DECIMAL),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="APPLY_TIME", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="WITHDRAW_RESPONSE_CODE", property="withdrawResponseCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="WITHDRAW_RESPONSE_MSG", property="withdrawResponseMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="WITHDRAW_RESPONSE_TIME", property="withdrawResponseTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<MerchantFsReq> selectByExample(MerchantFsReqExample example);

    /**
     * 根据Query对象分页查询商户快速结算申请记录【MerchantFsReq】对象列表信息
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    @SelectProvider(type=MerchantFsRSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="MFQ_ID", property="mfqId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="MERCHANT_ID", property="merchantId", jdbcType=JdbcType.DECIMAL),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="AMOUNT", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="TRADE_CNT", property="tradeCnt", jdbcType=JdbcType.DECIMAL),
        @Result(column="SETTLE_FEE", property="settleFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="SETTLE_BILL_NO", property="settleBillNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="FUND_OUT_TIME", property="fundOutTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="SETTLE_STATUS", property="settleStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYMENT_ORDER_NO", property="paymentOrderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYMENT_TIME", property="paymentTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="PAYMENT_STATUS", property="paymentStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_MEMBER_ID", property="merchantMemberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_ACCOUNT_NO", property="merchantAccountNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_ACCOUNT_TYPE", property="merchantAccountType", jdbcType=JdbcType.VARCHAR),
        @Result(column="SUB_STATUS", property="subStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="FAST_SETTLE_FEE", property="fastSettleFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="MC_TYPE", property="mcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_NAME", property="merchantName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_NAME", property="promoterName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_NO", property="promoterNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMIT_FEE_TRANS_ID", property="remitFeeTransId", jdbcType=JdbcType.DECIMAL),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="APPLY_TIME", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="WITHDRAW_RESPONSE_CODE", property="withdrawResponseCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="WITHDRAW_RESPONSE_MSG", property="withdrawResponseMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="WITHDRAW_RESPONSE_TIME", property="withdrawResponseTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<MerchantFsReq> selectByQuery(MerchantFsReqExample example);

    /**
     * 根据主键查询商户快速结算申请记录【MerchantFsReq】对象信息
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    @Select({
        "select",
        "MFQ_ID, MERCHANT_ID, TYPE, STATUS, AMOUNT, TRADE_CNT, SETTLE_FEE, CREATE_TIME, ",
        "UPDATE_TIME, MERCHANT_NO, SETTLE_BILL_NO, FUND_OUT_TIME, SETTLE_STATUS, PAYMENT_ORDER_NO, ",
        "PAYMENT_TIME, PAYMENT_STATUS, MERCHANT_MEMBER_ID, MERCHANT_ACCOUNT_NO, MERCHANT_ACCOUNT_TYPE, ",
        "SUB_STATUS, FAST_SETTLE_FEE, MC_TYPE, MERCHANT_NAME, PROMOTER_ID, PROMOTER_NAME, ",
        "PROMOTER_NO, REMIT_FEE_TRANS_ID, LOANING_TYPE, APPLY_TIME, WITHDRAW_RESPONSE_CODE, ",
        "WITHDRAW_RESPONSE_MSG, WITHDRAW_RESPONSE_TIME",
        "from TB_MERCHANT_FS_REQ",
        "where MFQ_ID = #{mfqId,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="MFQ_ID", property="mfqId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="MERCHANT_ID", property="merchantId", jdbcType=JdbcType.DECIMAL),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="AMOUNT", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="TRADE_CNT", property="tradeCnt", jdbcType=JdbcType.DECIMAL),
        @Result(column="SETTLE_FEE", property="settleFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="SETTLE_BILL_NO", property="settleBillNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="FUND_OUT_TIME", property="fundOutTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="SETTLE_STATUS", property="settleStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYMENT_ORDER_NO", property="paymentOrderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYMENT_TIME", property="paymentTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="PAYMENT_STATUS", property="paymentStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_MEMBER_ID", property="merchantMemberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_ACCOUNT_NO", property="merchantAccountNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_ACCOUNT_TYPE", property="merchantAccountType", jdbcType=JdbcType.VARCHAR),
        @Result(column="SUB_STATUS", property="subStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="FAST_SETTLE_FEE", property="fastSettleFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="MC_TYPE", property="mcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_NAME", property="merchantName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_NAME", property="promoterName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_NO", property="promoterNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMIT_FEE_TRANS_ID", property="remitFeeTransId", jdbcType=JdbcType.DECIMAL),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="APPLY_TIME", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="WITHDRAW_RESPONSE_CODE", property="withdrawResponseCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="WITHDRAW_RESPONSE_MSG", property="withdrawResponseMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="WITHDRAW_RESPONSE_TIME", property="withdrawResponseTime", jdbcType=JdbcType.TIMESTAMP)
    })
    MerchantFsReq selectByPrimaryKey(Long mfqId);

    /**
     * 根据Example对象更新商户快速结算申请记录【MerchantFsReq】对象信息，仅更新非空字段
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    @UpdateProvider(type=MerchantFsRSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MerchantFsReq record, @Param("example") MerchantFsReqExample example);

    /**
     * 根据Example对象更新商户快速结算申请记录【MerchantFsReq】对象信息
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    @UpdateProvider(type=MerchantFsRSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MerchantFsReq record, @Param("example") MerchantFsReqExample example);

    /**
     * 根据主键更新商户快速结算申请记录【MerchantFsReq】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    @UpdateProvider(type=MerchantFsRSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MerchantFsReq record);

    /**
     * 根据主键更新商户快速结算申请记录【MerchantFsReq】对象信息
     *
     * @mbggenerated Fri Dec 25 17:57:04 CST 2015
     */
    @Update({
        "update TB_MERCHANT_FS_REQ",
        "set MERCHANT_ID = #{merchantId,jdbcType=DECIMAL},",
          "TYPE = #{type,jdbcType=DECIMAL},",
          "STATUS = #{status,jdbcType=VARCHAR},",
          "AMOUNT = #{amount,jdbcType=DECIMAL},",
          "TRADE_CNT = #{tradeCnt,jdbcType=DECIMAL},",
          "SETTLE_FEE = #{settleFee,jdbcType=DECIMAL},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR},",
          "SETTLE_BILL_NO = #{settleBillNo,jdbcType=VARCHAR},",
          "FUND_OUT_TIME = #{fundOutTime,jdbcType=TIMESTAMP},",
          "SETTLE_STATUS = #{settleStatus,jdbcType=VARCHAR},",
          "PAYMENT_ORDER_NO = #{paymentOrderNo,jdbcType=VARCHAR},",
          "PAYMENT_TIME = #{paymentTime,jdbcType=TIMESTAMP},",
          "PAYMENT_STATUS = #{paymentStatus,jdbcType=VARCHAR},",
          "MERCHANT_MEMBER_ID = #{merchantMemberId,jdbcType=VARCHAR},",
          "MERCHANT_ACCOUNT_NO = #{merchantAccountNo,jdbcType=VARCHAR},",
          "MERCHANT_ACCOUNT_TYPE = #{merchantAccountType,jdbcType=VARCHAR},",
          "SUB_STATUS = #{subStatus,jdbcType=VARCHAR},",
          "FAST_SETTLE_FEE = #{fastSettleFee,jdbcType=DECIMAL},",
          "MC_TYPE = #{mcType,jdbcType=VARCHAR},",
          "MERCHANT_NAME = #{merchantName,jdbcType=VARCHAR},",
          "PROMOTER_ID = #{promoterId,jdbcType=DECIMAL},",
          "PROMOTER_NAME = #{promoterName,jdbcType=VARCHAR},",
          "PROMOTER_NO = #{promoterNo,jdbcType=VARCHAR},",
          "REMIT_FEE_TRANS_ID = #{remitFeeTransId,jdbcType=DECIMAL},",
          "LOANING_TYPE = #{loaningType,jdbcType=DECIMAL},",
          "APPLY_TIME = #{applyTime,jdbcType=TIMESTAMP},",
          "WITHDRAW_RESPONSE_CODE = #{withdrawResponseCode,jdbcType=VARCHAR},",
          "WITHDRAW_RESPONSE_MSG = #{withdrawResponseMsg,jdbcType=VARCHAR},",
          "WITHDRAW_RESPONSE_TIME = #{withdrawResponseTime,jdbcType=TIMESTAMP}",
        "where MFQ_ID = #{mfqId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(MerchantFsReq record);
}