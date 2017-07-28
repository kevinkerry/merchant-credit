package com.sdp.withdraw.dao.mapper.ext;

import com.sdp.withdraw.dao.WithdrawReqFosDetailDO;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDOExample;
import com.sdp.withdraw.dao.mapper.WithdrawReqFosDetailSqlProvider;

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

public interface ExtWithdrawReqFosDetailSqlMapper {
   
    /**
     * 根据Example对象查询得到出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:35 CST 2016
     */
    @SelectProvider(type=ExtWithdrawReqFosDetailSqlProvider.class, method="queryCallbackTimeoutData")
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
    List<WithdrawReqFosDetailDO> queryCallbackTimeoutData(int callbackTimeoutMinute);

   
}