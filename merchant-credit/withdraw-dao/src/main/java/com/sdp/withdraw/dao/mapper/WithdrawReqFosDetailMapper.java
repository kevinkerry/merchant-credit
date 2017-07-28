package com.sdp.withdraw.dao.mapper;

import com.sdp.withdraw.dao.WithdrawReqFosDetailDO;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDOExample;
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

public interface WithdrawReqFosDetailMapper {
    /**
     * 根据Example对象取得出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象count信息
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    @SelectProvider(type=WithdrawReqFosDetailSqlProvider.class, method="countByExample")
    int countByExample(WithdrawReqFosDetailDOExample example);

    /**
     * 根据Example对象删除出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    @DeleteProvider(type=WithdrawReqFosDetailSqlProvider.class, method="deleteByExample")
    int deleteByExample(WithdrawReqFosDetailDOExample example);

    /**
     * 根据主键删除出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    @Delete({
        "delete from FW_WITHDRAW_REQ_FOS_DETAIL",
        "where DETAIL_ID = #{detailId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long detailId);

    /**
     * 添加出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    @Insert({
        "insert into FW_WITHDRAW_REQ_FOS_DETAIL (DETAIL_ID, REQ_ID, ",
        "PRODUCT_CODE, PAYMENT_CODE, ",
        "REMIT_VOUCHER_NO, PAYER_MEMBER_ID, ",
        "IS_NEED_COUNT_FEE, PAYER_FEE, ",
        "PAYEE_FEE, IS_PERMIT_PRICING_ERR, ",
        "PAYER_ACCOUNT_NO, BANK_CODE, ",
        "BANK_NAME, BANK_BRANCH, ",
        "BANK_LINENO, BANK_PROVINCE, ",
        "BANK_CITY, PAYEE_NAME, ",
        "PAYEE_CARD_NO, PAYEE_PURPOSE, ",
        "CARD_TYPE, COMPANY_OR_PERSONAL, ",
        "GMT_BIZ_INITIATE, GMT_PAYMENT_INITIATE, ",
        "REMIT_AMOUNT, CALLBACK_ADDRESS, ",
        "MEMO, CURRENCY, ",
        "REQ_EXTENTION, WITHDRAW_STATUS, ",
        "RETURN_CODE, RETURN_MSG, ",
        "EXTENTION, CREATE_TIME, ",
        "UPDATE_TIME)",
        "values (#{detailId,jdbcType=DECIMAL}, #{reqId,jdbcType=DECIMAL}, ",
        "#{productCode,jdbcType=VARCHAR}, #{paymentCode,jdbcType=VARCHAR}, ",
        "#{remitVoucherNo,jdbcType=VARCHAR}, #{payerMemberId,jdbcType=VARCHAR}, ",
        "#{isNeedCountFee,jdbcType=DECIMAL}, #{payerFee,jdbcType=DECIMAL}, ",
        "#{payeeFee,jdbcType=DECIMAL}, #{isPermitPricingErr,jdbcType=DECIMAL}, ",
        "#{payerAccountNo,jdbcType=VARCHAR}, #{bankCode,jdbcType=VARCHAR}, ",
        "#{bankName,jdbcType=VARCHAR}, #{bankBranch,jdbcType=VARCHAR}, ",
        "#{bankLineno,jdbcType=VARCHAR}, #{bankProvince,jdbcType=VARCHAR}, ",
        "#{bankCity,jdbcType=VARCHAR}, #{payeeName,jdbcType=VARCHAR}, ",
        "#{payeeCardNo,jdbcType=VARCHAR}, #{payeePurpose,jdbcType=VARCHAR}, ",
        "#{cardType,jdbcType=VARCHAR}, #{companyOrPersonal,jdbcType=VARCHAR}, ",
        "#{gmtBizInitiate,jdbcType=TIMESTAMP}, #{gmtPaymentInitiate,jdbcType=TIMESTAMP}, ",
        "#{remitAmount,jdbcType=DECIMAL}, #{callbackAddress,jdbcType=VARCHAR}, ",
        "#{memo,jdbcType=VARCHAR}, #{currency,jdbcType=VARCHAR}, ",
        "#{reqExtention,jdbcType=VARCHAR}, #{withdrawStatus,jdbcType=VARCHAR}, ",
        "#{returnCode,jdbcType=VARCHAR}, #{returnMsg,jdbcType=VARCHAR}, ",
        "#{extention,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select SEQ_FW_WITHDRAW_REQ_FOS_DETAIL.nextval from dual", keyProperty="detailId", before=true, resultType=Long.class)
    Long insert(WithdrawReqFosDetailDO record);

    /**
     * 添加出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    @InsertProvider(type=WithdrawReqFosDetailSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_FW_WITHDRAW_REQ_FOS_DETAIL.nextval from dual", keyProperty="detailId", before=true, resultType=Long.class)
    Long insertSelective(WithdrawReqFosDetailDO record);

    /**
     * 根据Example对象查询得到出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    @SelectProvider(type=WithdrawReqFosDetailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="DETAIL_ID", property="detailId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="PRODUCT_CODE", property="productCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYMENT_CODE", property="paymentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMIT_VOUCHER_NO", property="remitVoucherNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYER_MEMBER_ID", property="payerMemberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_NEED_COUNT_FEE", property="isNeedCountFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="PAYER_FEE", property="payerFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="PAYEE_FEE", property="payeeFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="IS_PERMIT_PRICING_ERR", property="isPermitPricingErr", jdbcType=JdbcType.DECIMAL),
        @Result(column="PAYER_ACCOUNT_NO", property="payerAccountNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="BANK_CODE", property="bankCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="BANK_NAME", property="bankName", jdbcType=JdbcType.VARCHAR),
        @Result(column="BANK_BRANCH", property="bankBranch", jdbcType=JdbcType.VARCHAR),
        @Result(column="BANK_LINENO", property="bankLineno", jdbcType=JdbcType.VARCHAR),
        @Result(column="BANK_PROVINCE", property="bankProvince", jdbcType=JdbcType.VARCHAR),
        @Result(column="BANK_CITY", property="bankCity", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYEE_NAME", property="payeeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYEE_CARD_NO", property="payeeCardNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYEE_PURPOSE", property="payeePurpose", jdbcType=JdbcType.VARCHAR),
        @Result(column="CARD_TYPE", property="cardType", jdbcType=JdbcType.VARCHAR),
        @Result(column="COMPANY_OR_PERSONAL", property="companyOrPersonal", jdbcType=JdbcType.VARCHAR),
        @Result(column="GMT_BIZ_INITIATE", property="gmtBizInitiate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="GMT_PAYMENT_INITIATE", property="gmtPaymentInitiate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REMIT_AMOUNT", property="remitAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="CALLBACK_ADDRESS", property="callbackAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMO", property="memo", jdbcType=JdbcType.VARCHAR),
        @Result(column="CURRENCY", property="currency", jdbcType=JdbcType.VARCHAR),
        @Result(column="REQ_EXTENTION", property="reqExtention", jdbcType=JdbcType.VARCHAR),
        @Result(column="WITHDRAW_STATUS", property="withdrawStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="RETURN_CODE", property="returnCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="RETURN_MSG", property="returnMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTENTION", property="extention", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<WithdrawReqFosDetailDO> selectByExample(WithdrawReqFosDetailDOExample example);

    /**
     * 根据Query对象分页查询出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    @SelectProvider(type=WithdrawReqFosDetailSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="DETAIL_ID", property="detailId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="PRODUCT_CODE", property="productCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYMENT_CODE", property="paymentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMIT_VOUCHER_NO", property="remitVoucherNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYER_MEMBER_ID", property="payerMemberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_NEED_COUNT_FEE", property="isNeedCountFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="PAYER_FEE", property="payerFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="PAYEE_FEE", property="payeeFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="IS_PERMIT_PRICING_ERR", property="isPermitPricingErr", jdbcType=JdbcType.DECIMAL),
        @Result(column="PAYER_ACCOUNT_NO", property="payerAccountNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="BANK_CODE", property="bankCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="BANK_NAME", property="bankName", jdbcType=JdbcType.VARCHAR),
        @Result(column="BANK_BRANCH", property="bankBranch", jdbcType=JdbcType.VARCHAR),
        @Result(column="BANK_LINENO", property="bankLineno", jdbcType=JdbcType.VARCHAR),
        @Result(column="BANK_PROVINCE", property="bankProvince", jdbcType=JdbcType.VARCHAR),
        @Result(column="BANK_CITY", property="bankCity", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYEE_NAME", property="payeeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYEE_CARD_NO", property="payeeCardNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYEE_PURPOSE", property="payeePurpose", jdbcType=JdbcType.VARCHAR),
        @Result(column="CARD_TYPE", property="cardType", jdbcType=JdbcType.VARCHAR),
        @Result(column="COMPANY_OR_PERSONAL", property="companyOrPersonal", jdbcType=JdbcType.VARCHAR),
        @Result(column="GMT_BIZ_INITIATE", property="gmtBizInitiate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="GMT_PAYMENT_INITIATE", property="gmtPaymentInitiate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REMIT_AMOUNT", property="remitAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="CALLBACK_ADDRESS", property="callbackAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMO", property="memo", jdbcType=JdbcType.VARCHAR),
        @Result(column="CURRENCY", property="currency", jdbcType=JdbcType.VARCHAR),
        @Result(column="REQ_EXTENTION", property="reqExtention", jdbcType=JdbcType.VARCHAR),
        @Result(column="WITHDRAW_STATUS", property="withdrawStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="RETURN_CODE", property="returnCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="RETURN_MSG", property="returnMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTENTION", property="extention", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<WithdrawReqFosDetailDO> selectByQuery(WithdrawReqFosDetailDOExample example);

    /**
     * 根据主键查询出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    @Select({
        "select",
        "DETAIL_ID, REQ_ID, PRODUCT_CODE, PAYMENT_CODE, REMIT_VOUCHER_NO, PAYER_MEMBER_ID, ",
        "IS_NEED_COUNT_FEE, PAYER_FEE, PAYEE_FEE, IS_PERMIT_PRICING_ERR, PAYER_ACCOUNT_NO, ",
        "BANK_CODE, BANK_NAME, BANK_BRANCH, BANK_LINENO, BANK_PROVINCE, BANK_CITY, PAYEE_NAME, ",
        "PAYEE_CARD_NO, PAYEE_PURPOSE, CARD_TYPE, COMPANY_OR_PERSONAL, GMT_BIZ_INITIATE, ",
        "GMT_PAYMENT_INITIATE, REMIT_AMOUNT, CALLBACK_ADDRESS, MEMO, CURRENCY, REQ_EXTENTION, ",
        "WITHDRAW_STATUS, RETURN_CODE, RETURN_MSG, EXTENTION, CREATE_TIME, UPDATE_TIME",
        "from FW_WITHDRAW_REQ_FOS_DETAIL",
        "where DETAIL_ID = #{detailId,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="DETAIL_ID", property="detailId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="PRODUCT_CODE", property="productCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYMENT_CODE", property="paymentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMIT_VOUCHER_NO", property="remitVoucherNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYER_MEMBER_ID", property="payerMemberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_NEED_COUNT_FEE", property="isNeedCountFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="PAYER_FEE", property="payerFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="PAYEE_FEE", property="payeeFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="IS_PERMIT_PRICING_ERR", property="isPermitPricingErr", jdbcType=JdbcType.DECIMAL),
        @Result(column="PAYER_ACCOUNT_NO", property="payerAccountNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="BANK_CODE", property="bankCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="BANK_NAME", property="bankName", jdbcType=JdbcType.VARCHAR),
        @Result(column="BANK_BRANCH", property="bankBranch", jdbcType=JdbcType.VARCHAR),
        @Result(column="BANK_LINENO", property="bankLineno", jdbcType=JdbcType.VARCHAR),
        @Result(column="BANK_PROVINCE", property="bankProvince", jdbcType=JdbcType.VARCHAR),
        @Result(column="BANK_CITY", property="bankCity", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYEE_NAME", property="payeeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYEE_CARD_NO", property="payeeCardNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAYEE_PURPOSE", property="payeePurpose", jdbcType=JdbcType.VARCHAR),
        @Result(column="CARD_TYPE", property="cardType", jdbcType=JdbcType.VARCHAR),
        @Result(column="COMPANY_OR_PERSONAL", property="companyOrPersonal", jdbcType=JdbcType.VARCHAR),
        @Result(column="GMT_BIZ_INITIATE", property="gmtBizInitiate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="GMT_PAYMENT_INITIATE", property="gmtPaymentInitiate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REMIT_AMOUNT", property="remitAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="CALLBACK_ADDRESS", property="callbackAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMO", property="memo", jdbcType=JdbcType.VARCHAR),
        @Result(column="CURRENCY", property="currency", jdbcType=JdbcType.VARCHAR),
        @Result(column="REQ_EXTENTION", property="reqExtention", jdbcType=JdbcType.VARCHAR),
        @Result(column="WITHDRAW_STATUS", property="withdrawStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="RETURN_CODE", property="returnCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="RETURN_MSG", property="returnMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTENTION", property="extention", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    WithdrawReqFosDetailDO selectByPrimaryKey(Long detailId);

    /**
     * 根据Example对象更新出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    @UpdateProvider(type=WithdrawReqFosDetailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WithdrawReqFosDetailDO record, @Param("example") WithdrawReqFosDetailDOExample example);

    /**
     * 根据Example对象更新出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    @UpdateProvider(type=WithdrawReqFosDetailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") WithdrawReqFosDetailDO record, @Param("example") WithdrawReqFosDetailDOExample example);

    /**
     * 根据主键更新出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    @UpdateProvider(type=WithdrawReqFosDetailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WithdrawReqFosDetailDO record);

    /**
     * 根据主键更新出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    @Update({
        "update FW_WITHDRAW_REQ_FOS_DETAIL",
        "set REQ_ID = #{reqId,jdbcType=DECIMAL},",
          "PRODUCT_CODE = #{productCode,jdbcType=VARCHAR},",
          "PAYMENT_CODE = #{paymentCode,jdbcType=VARCHAR},",
          "REMIT_VOUCHER_NO = #{remitVoucherNo,jdbcType=VARCHAR},",
          "PAYER_MEMBER_ID = #{payerMemberId,jdbcType=VARCHAR},",
          "IS_NEED_COUNT_FEE = #{isNeedCountFee,jdbcType=DECIMAL},",
          "PAYER_FEE = #{payerFee,jdbcType=DECIMAL},",
          "PAYEE_FEE = #{payeeFee,jdbcType=DECIMAL},",
          "IS_PERMIT_PRICING_ERR = #{isPermitPricingErr,jdbcType=DECIMAL},",
          "PAYER_ACCOUNT_NO = #{payerAccountNo,jdbcType=VARCHAR},",
          "BANK_CODE = #{bankCode,jdbcType=VARCHAR},",
          "BANK_NAME = #{bankName,jdbcType=VARCHAR},",
          "BANK_BRANCH = #{bankBranch,jdbcType=VARCHAR},",
          "BANK_LINENO = #{bankLineno,jdbcType=VARCHAR},",
          "BANK_PROVINCE = #{bankProvince,jdbcType=VARCHAR},",
          "BANK_CITY = #{bankCity,jdbcType=VARCHAR},",
          "PAYEE_NAME = #{payeeName,jdbcType=VARCHAR},",
          "PAYEE_CARD_NO = #{payeeCardNo,jdbcType=VARCHAR},",
          "PAYEE_PURPOSE = #{payeePurpose,jdbcType=VARCHAR},",
          "CARD_TYPE = #{cardType,jdbcType=VARCHAR},",
          "COMPANY_OR_PERSONAL = #{companyOrPersonal,jdbcType=VARCHAR},",
          "GMT_BIZ_INITIATE = #{gmtBizInitiate,jdbcType=TIMESTAMP},",
          "GMT_PAYMENT_INITIATE = #{gmtPaymentInitiate,jdbcType=TIMESTAMP},",
          "REMIT_AMOUNT = #{remitAmount,jdbcType=DECIMAL},",
          "CALLBACK_ADDRESS = #{callbackAddress,jdbcType=VARCHAR},",
          "MEMO = #{memo,jdbcType=VARCHAR},",
          "CURRENCY = #{currency,jdbcType=VARCHAR},",
          "REQ_EXTENTION = #{reqExtention,jdbcType=VARCHAR},",
          "WITHDRAW_STATUS = #{withdrawStatus,jdbcType=VARCHAR},",
          "RETURN_CODE = #{returnCode,jdbcType=VARCHAR},",
          "RETURN_MSG = #{returnMsg,jdbcType=VARCHAR},",
          "EXTENTION = #{extention,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where DETAIL_ID = #{detailId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(WithdrawReqFosDetailDO record);
}