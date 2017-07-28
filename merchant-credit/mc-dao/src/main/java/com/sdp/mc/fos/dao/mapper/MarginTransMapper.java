package com.sdp.mc.fos.dao.mapper;

import com.sdp.mc.fos.dao.MarginTransDO;
import com.sdp.mc.fos.dao.MarginTransDOExample;
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

public interface MarginTransMapper {
    /**
     * 根据Example对象取得保证金转账记录【MarginTransDO】对象count信息
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    @SelectProvider(type=MarginTransSqlProvider.class, method="countByExample")
    int countByExample(MarginTransDOExample example);

    /**
     * 根据Example对象删除保证金转账记录【MarginTransDO】对象信息
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    @DeleteProvider(type=MarginTransSqlProvider.class, method="deleteByExample")
    int deleteByExample(MarginTransDOExample example);

    /**
     * 根据主键删除保证金转账记录【MarginTransDO】对象信息
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    @Delete({
        "delete from TB_MARGIN_TRANS",
        "where MT_ID = #{mtId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long mtId);

    /**
     * 添加保证金转账记录【MarginTransDO】对象信息
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    @Insert({
        "insert into TB_MARGIN_TRANS (MT_ID, STATUS, ",
        "PRODUCT_CODE, APP_ID, ",
        "PAYMENT_CODE, REMIT_VOUCHER_NO, ",
        "PAYMENT_STATE, PAYER_MEMBER_ID, ",
        "PAYEE_MEMBER_ID, IS_NEED_COUNT_FEE, ",
        "PAYER_FEE, PAYEE_FEE, ",
        "PAYER_ACCOUNT_TYPE, PAYER_ACCOUNT_NO, ",
        "PAYEE_ACCOUNT_NO, GMT_BIZ_INITIATE, ",
        "GMT_PAYMENT_INITIATE, REMIT_AMOUNT, ",
        "CALLBACK_ADDRESS, MEMO, ",
        "IS_PEMIT_PRICING_ERR, CURRENCY, ",
        "PAYMENT_SEQ_NO, POCKET_AMOUNT, ",
        "SETTLEMENT_TIME, RETURN_CODE, ",
        "RETURN_MSG, EXTENTION, ",
        "CREATE_TIME, UPDATE_TIME, ",
        "BATCH_NO, PAYEE_ACCOUNT_TYPE)",
        "values (#{mtId,jdbcType=DECIMAL}, #{status,jdbcType=DECIMAL}, ",
        "#{productCode,jdbcType=VARCHAR}, #{appId,jdbcType=VARCHAR}, ",
        "#{paymentCode,jdbcType=VARCHAR}, #{remitVoucherNo,jdbcType=VARCHAR}, ",
        "#{paymentState,jdbcType=VARCHAR}, #{payerMemberId,jdbcType=VARCHAR}, ",
        "#{payeeMemberId,jdbcType=VARCHAR}, #{isNeedCountFee,jdbcType=VARCHAR}, ",
        "#{payerFee,jdbcType=VARCHAR}, #{payeeFee,jdbcType=VARCHAR}, ",
        "#{payerAccountType,jdbcType=VARCHAR}, #{payerAccountNo,jdbcType=VARCHAR}, ",
        "#{payeeAccountNo,jdbcType=VARCHAR}, #{gmtBizInitiate,jdbcType=VARCHAR}, ",
        "#{gmtPaymentInitiate,jdbcType=VARCHAR}, #{remitAmount,jdbcType=VARCHAR}, ",
        "#{callbackAddress,jdbcType=VARCHAR}, #{memo,jdbcType=VARCHAR}, ",
        "#{isPemitPricingErr,jdbcType=VARCHAR}, #{currency,jdbcType=VARCHAR}, ",
        "#{paymentSeqNo,jdbcType=VARCHAR}, #{pocketAmount,jdbcType=VARCHAR}, ",
        "#{settlementTime,jdbcType=VARCHAR}, #{returnCode,jdbcType=VARCHAR}, ",
        "#{returnMsg,jdbcType=VARCHAR}, #{extention,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{batchNo,jdbcType=VARCHAR}, #{payeeAccountType,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="select SEQ_TB_MARGIN_TRANS.nextval from dual", keyProperty="mtId", before=true, resultType=Long.class)
    Long insert(MarginTransDO record);

    /**
     * 添加保证金转账记录【MarginTransDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    @InsertProvider(type=MarginTransSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_TB_MARGIN_TRANS.nextval from dual", keyProperty="mtId", before=true, resultType=Long.class)
    Long insertSelective(MarginTransDO record);

    /**
     * 根据Example对象查询得到保证金转账记录【MarginTransDO】对象列表信息
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    @SelectProvider(type=MarginTransSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="MT_ID", property="mtId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="PRODUCT_CODE", property="productCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="APP_ID", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYMENT_CODE", property="paymentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMIT_VOUCHER_NO", property="remitVoucherNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYMENT_STATE", property="paymentState", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYER_MEMBER_ID", property="payerMemberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYEE_MEMBER_ID", property="payeeMemberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_NEED_COUNT_FEE", property="isNeedCountFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYER_FEE", property="payerFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYEE_FEE", property="payeeFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYER_ACCOUNT_TYPE", property="payerAccountType", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYER_ACCOUNT_NO", property="payerAccountNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYEE_ACCOUNT_NO", property="payeeAccountNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="GMT_BIZ_INITIATE", property="gmtBizInitiate", jdbcType=JdbcType.VARCHAR),
        @Result(column="GMT_PAYMENT_INITIATE", property="gmtPaymentInitiate", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMIT_AMOUNT", property="remitAmount", jdbcType=JdbcType.VARCHAR),
        @Result(column="CALLBACK_ADDRESS", property="callbackAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMO", property="memo", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_PEMIT_PRICING_ERR", property="isPemitPricingErr", jdbcType=JdbcType.VARCHAR),
        @Result(column="CURRENCY", property="currency", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYMENT_SEQ_NO", property="paymentSeqNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="POCKET_AMOUNT", property="pocketAmount", jdbcType=JdbcType.VARCHAR),
        @Result(column="SETTLEMENT_TIME", property="settlementTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="RETURN_CODE", property="returnCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="RETURN_MSG", property="returnMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTENTION", property="extention", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="BATCH_NO", property="batchNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYEE_ACCOUNT_TYPE", property="payeeAccountType", jdbcType=JdbcType.VARCHAR)
    })
    List<MarginTransDO> selectByExample(MarginTransDOExample example);

    /**
     * 根据Query对象分页查询保证金转账记录【MarginTransDO】对象列表信息
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    @SelectProvider(type=MarginTransSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="MT_ID", property="mtId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="PRODUCT_CODE", property="productCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="APP_ID", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYMENT_CODE", property="paymentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMIT_VOUCHER_NO", property="remitVoucherNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYMENT_STATE", property="paymentState", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYER_MEMBER_ID", property="payerMemberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYEE_MEMBER_ID", property="payeeMemberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_NEED_COUNT_FEE", property="isNeedCountFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYER_FEE", property="payerFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYEE_FEE", property="payeeFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYER_ACCOUNT_TYPE", property="payerAccountType", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYER_ACCOUNT_NO", property="payerAccountNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYEE_ACCOUNT_NO", property="payeeAccountNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="GMT_BIZ_INITIATE", property="gmtBizInitiate", jdbcType=JdbcType.VARCHAR),
        @Result(column="GMT_PAYMENT_INITIATE", property="gmtPaymentInitiate", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMIT_AMOUNT", property="remitAmount", jdbcType=JdbcType.VARCHAR),
        @Result(column="CALLBACK_ADDRESS", property="callbackAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMO", property="memo", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_PEMIT_PRICING_ERR", property="isPemitPricingErr", jdbcType=JdbcType.VARCHAR),
        @Result(column="CURRENCY", property="currency", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYMENT_SEQ_NO", property="paymentSeqNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="POCKET_AMOUNT", property="pocketAmount", jdbcType=JdbcType.VARCHAR),
        @Result(column="SETTLEMENT_TIME", property="settlementTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="RETURN_CODE", property="returnCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="RETURN_MSG", property="returnMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTENTION", property="extention", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="BATCH_NO", property="batchNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYEE_ACCOUNT_TYPE", property="payeeAccountType", jdbcType=JdbcType.VARCHAR)
    })
    List<MarginTransDO> selectByQuery(MarginTransDOExample example);

    /**
     * 根据主键查询保证金转账记录【MarginTransDO】对象信息
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    @Select({
        "select",
        "MT_ID, STATUS, PRODUCT_CODE, APP_ID, PAYMENT_CODE, REMIT_VOUCHER_NO, PAYMENT_STATE, ",
        "PAYER_MEMBER_ID, PAYEE_MEMBER_ID, IS_NEED_COUNT_FEE, PAYER_FEE, PAYEE_FEE, PAYER_ACCOUNT_TYPE, ",
        "PAYER_ACCOUNT_NO, PAYEE_ACCOUNT_NO, GMT_BIZ_INITIATE, GMT_PAYMENT_INITIATE, ",
        "REMIT_AMOUNT, CALLBACK_ADDRESS, MEMO, IS_PEMIT_PRICING_ERR, CURRENCY, PAYMENT_SEQ_NO, ",
        "POCKET_AMOUNT, SETTLEMENT_TIME, RETURN_CODE, RETURN_MSG, EXTENTION, CREATE_TIME, ",
        "UPDATE_TIME, BATCH_NO, PAYEE_ACCOUNT_TYPE",
        "from TB_MARGIN_TRANS",
        "where MT_ID = #{mtId,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="MT_ID", property="mtId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="PRODUCT_CODE", property="productCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="APP_ID", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYMENT_CODE", property="paymentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMIT_VOUCHER_NO", property="remitVoucherNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYMENT_STATE", property="paymentState", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYER_MEMBER_ID", property="payerMemberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYEE_MEMBER_ID", property="payeeMemberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_NEED_COUNT_FEE", property="isNeedCountFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYER_FEE", property="payerFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYEE_FEE", property="payeeFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYER_ACCOUNT_TYPE", property="payerAccountType", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYER_ACCOUNT_NO", property="payerAccountNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYEE_ACCOUNT_NO", property="payeeAccountNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="GMT_BIZ_INITIATE", property="gmtBizInitiate", jdbcType=JdbcType.VARCHAR),
        @Result(column="GMT_PAYMENT_INITIATE", property="gmtPaymentInitiate", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMIT_AMOUNT", property="remitAmount", jdbcType=JdbcType.VARCHAR),
        @Result(column="CALLBACK_ADDRESS", property="callbackAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMO", property="memo", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_PEMIT_PRICING_ERR", property="isPemitPricingErr", jdbcType=JdbcType.VARCHAR),
        @Result(column="CURRENCY", property="currency", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYMENT_SEQ_NO", property="paymentSeqNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="POCKET_AMOUNT", property="pocketAmount", jdbcType=JdbcType.VARCHAR),
        @Result(column="SETTLEMENT_TIME", property="settlementTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="RETURN_CODE", property="returnCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="RETURN_MSG", property="returnMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTENTION", property="extention", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="BATCH_NO", property="batchNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYEE_ACCOUNT_TYPE", property="payeeAccountType", jdbcType=JdbcType.VARCHAR)
    })
    MarginTransDO selectByPrimaryKey(Long mtId);

    /**
     * 根据Example对象更新保证金转账记录【MarginTransDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    @UpdateProvider(type=MarginTransSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MarginTransDO record, @Param("example") MarginTransDOExample example);

    /**
     * 根据Example对象更新保证金转账记录【MarginTransDO】对象信息
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    @UpdateProvider(type=MarginTransSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MarginTransDO record, @Param("example") MarginTransDOExample example);

    /**
     * 根据主键更新保证金转账记录【MarginTransDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    @UpdateProvider(type=MarginTransSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MarginTransDO record);

    /**
     * 根据主键更新保证金转账记录【MarginTransDO】对象信息
     *
     * @mbggenerated Wed Jun 03 18:04:23 CST 2015
     */
    @Update({
        "update TB_MARGIN_TRANS",
        "set STATUS = #{status,jdbcType=DECIMAL},",
          "PRODUCT_CODE = #{productCode,jdbcType=VARCHAR},",
          "APP_ID = #{appId,jdbcType=VARCHAR},",
          "PAYMENT_CODE = #{paymentCode,jdbcType=VARCHAR},",
          "REMIT_VOUCHER_NO = #{remitVoucherNo,jdbcType=VARCHAR},",
          "PAYMENT_STATE = #{paymentState,jdbcType=VARCHAR},",
          "PAYER_MEMBER_ID = #{payerMemberId,jdbcType=VARCHAR},",
          "PAYEE_MEMBER_ID = #{payeeMemberId,jdbcType=VARCHAR},",
          "IS_NEED_COUNT_FEE = #{isNeedCountFee,jdbcType=VARCHAR},",
          "PAYER_FEE = #{payerFee,jdbcType=VARCHAR},",
          "PAYEE_FEE = #{payeeFee,jdbcType=VARCHAR},",
          "PAYER_ACCOUNT_TYPE = #{payerAccountType,jdbcType=VARCHAR},",
          "PAYER_ACCOUNT_NO = #{payerAccountNo,jdbcType=VARCHAR},",
          "PAYEE_ACCOUNT_NO = #{payeeAccountNo,jdbcType=VARCHAR},",
          "GMT_BIZ_INITIATE = #{gmtBizInitiate,jdbcType=VARCHAR},",
          "GMT_PAYMENT_INITIATE = #{gmtPaymentInitiate,jdbcType=VARCHAR},",
          "REMIT_AMOUNT = #{remitAmount,jdbcType=VARCHAR},",
          "CALLBACK_ADDRESS = #{callbackAddress,jdbcType=VARCHAR},",
          "MEMO = #{memo,jdbcType=VARCHAR},",
          "IS_PEMIT_PRICING_ERR = #{isPemitPricingErr,jdbcType=VARCHAR},",
          "CURRENCY = #{currency,jdbcType=VARCHAR},",
          "PAYMENT_SEQ_NO = #{paymentSeqNo,jdbcType=VARCHAR},",
          "POCKET_AMOUNT = #{pocketAmount,jdbcType=VARCHAR},",
          "SETTLEMENT_TIME = #{settlementTime,jdbcType=VARCHAR},",
          "RETURN_CODE = #{returnCode,jdbcType=VARCHAR},",
          "RETURN_MSG = #{returnMsg,jdbcType=VARCHAR},",
          "EXTENTION = #{extention,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "BATCH_NO = #{batchNo,jdbcType=VARCHAR},",
          "PAYEE_ACCOUNT_TYPE = #{payeeAccountType,jdbcType=VARCHAR}",
        "where MT_ID = #{mtId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(MarginTransDO record);
}