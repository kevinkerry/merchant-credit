package com.sdp.withdraw.dao.daointerface.ext;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.sdp.mc.common.dto.StatisticsWithdrawInfoDTO;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqDOExample;
import com.sdp.withdraw.dao.daointerface.WithdrawReqDAO;
import com.sdp.withdraw.dao.ext.ExtWithdrawReqDOExample;
import com.sdp.withdraw.dao.ext.ExtWithdrawReqVO;
import com.sdp.withdraw.dao.mapper.WithdrawReqSqlProvider;
import com.sdp.withdraw.dao.mapper.ext.ExtWithdrawReqSqlProvider;

public interface ExtWithdrawReqDAO extends WithdrawReqDAO{


	/**
	 * 根据Query对象分页查询出款列表信息
	 * @param example
	 * @return
	 */
    @SelectProvider(type=ExtWithdrawReqSqlProvider.class, method="selectWithdrawReqByQuery")
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
         @Result(column="TOTAL_COST", property="totalCost", jdbcType=JdbcType.DECIMAL),
         @Result(column="WITHDRAW_COST", property="withdrawCost", jdbcType=JdbcType.DECIMAL),
         @Result(column="WD_COST", property="wdCost", jdbcType=JdbcType.DECIMAL),
         @Result(column="ORIGINAL_AMOUNT", property="originalAmount", jdbcType=JdbcType.DECIMAL),
         @Result(column="SPLITTING_FEE", property="splittingFee", jdbcType=JdbcType.DECIMAL),
         @Result(column="SPLITTING_COST", property="splittingCost", jdbcType=JdbcType.DECIMAL),
         @Result(column="PMT_MEMBER_ID", property="pmtMemberId", jdbcType=JdbcType.VARCHAR),
         @Result(column="PMT_MERCHANT_NO", property="pmtMerchantNo", jdbcType=JdbcType.VARCHAR),
         @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
         @Result(column="RETRY_TIMES", property="retryTimes", jdbcType=JdbcType.DECIMAL),
         @Result(column="ERROR_CODE", property="errorCode", jdbcType=JdbcType.VARCHAR),
         @Result(column="ERROR_MSG", property="errorMsg", jdbcType=JdbcType.VARCHAR),
         @Result(column="wr_CALLBACK_ADDRESS", property="wrCallbackAddress", jdbcType=JdbcType.VARCHAR),
         @Result(column="APPLY_TIME", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
         @Result(column="wr_CREATE_TIME", property="wrCreateTime", jdbcType=JdbcType.TIMESTAMP),
         @Result(column="wr_UPDATE_TIME", property="wrUpdateTime", jdbcType=JdbcType.TIMESTAMP),
         @Result(column="WITHDRAW_TIME", property="withdrawTime", jdbcType=JdbcType.TIMESTAMP),
         @Result(column="SERVICE_TYPE", property="serviceType", jdbcType=JdbcType.DECIMAL),
         @Result(column="HAS_OA_TXN", property="hasOaTxn", jdbcType=JdbcType.VARCHAR),

    	 @Result(column="DETAIL_ID", property="detailId", jdbcType=JdbcType.DECIMAL),
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
         @Result(column="callback_address", property="callbackAddress", jdbcType=JdbcType.VARCHAR),
         @Result(column="MEMO", property="memo", jdbcType=JdbcType.VARCHAR),
         @Result(column="CURRENCY", property="currency", jdbcType=JdbcType.VARCHAR),
         @Result(column="REQ_EXTENTION", property="reqExtention", jdbcType=JdbcType.VARCHAR),
         @Result(column="WITHDRAW_STATUS", property="withdrawStatus", jdbcType=JdbcType.VARCHAR),
         @Result(column="RETURN_CODE", property="returnCode", jdbcType=JdbcType.VARCHAR),
         @Result(column="RETURN_MSG", property="returnMsg", jdbcType=JdbcType.VARCHAR),
         @Result(column="EXTENTION", property="extention", jdbcType=JdbcType.VARCHAR),
         @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
         @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ExtWithdrawReqVO> selectWithdrawReqByQuery(ExtWithdrawReqDOExample example);

	@SelectProvider(type = ExtWithdrawReqSqlProvider.class, method = "countWithdrawReqByQuery")
	int countWithdrawReqByQuery(ExtWithdrawReqDOExample example);



	/**
	 * 根据Query对象分页查询出款列表信息
	 * @param example
	 * @return
	 */
    @SelectProvider(type=ExtWithdrawReqSqlProvider.class, method="selectMerchantFastsettleByQuery")
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
         @Result(column="WD_COST", property="wdCost", jdbcType=JdbcType.DECIMAL),
         @Result(column="TOTAL_COST", property="totalCost", jdbcType=JdbcType.DECIMAL),
         @Result(column="ORIGINAL_AMOUNT", property="originalAmount", jdbcType=JdbcType.DECIMAL),
         @Result(column="SPLITTING_FEE", property="splittingFee", jdbcType=JdbcType.DECIMAL),
         @Result(column="SPLITTING_COST", property="splittingCost", jdbcType=JdbcType.DECIMAL),
         @Result(column="PMT_MEMBER_ID", property="pmtMemberId", jdbcType=JdbcType.VARCHAR),
         @Result(column="PMT_MERCHANT_NO", property="pmtMerchantNo", jdbcType=JdbcType.VARCHAR),
         @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
         @Result(column="RETRY_TIMES", property="retryTimes", jdbcType=JdbcType.DECIMAL),
         @Result(column="ERROR_CODE", property="errorCode", jdbcType=JdbcType.VARCHAR),
         @Result(column="ERROR_MSG", property="errorMsg", jdbcType=JdbcType.VARCHAR),
         @Result(column="wr_CALLBACK_ADDRESS", property="wrCallbackAddress", jdbcType=JdbcType.VARCHAR),
         @Result(column="APPLY_TIME", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
         @Result(column="wr_CREATE_TIME", property="wrCreateTime", jdbcType=JdbcType.TIMESTAMP),
         @Result(column="wr_UPDATE_TIME", property="wrUpdateTime", jdbcType=JdbcType.TIMESTAMP),
         @Result(column="WITHDRAW_TIME", property="withdrawTime", jdbcType=JdbcType.TIMESTAMP),
         @Result(column="SERVICE_TYPE", property="serviceType", jdbcType=JdbcType.DECIMAL),
         @Result(column="MERCHANT_NAME", property="merchantName", jdbcType=JdbcType.VARCHAR),
//         @Result(column="PMT_MERCHANT_NO", property="promoterNo", jdbcType=JdbcType.VARCHAR),
         @Result(column="pmt_bind_operator_name", property="pmtBindOperatorName", jdbcType=JdbcType.VARCHAR),
         @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
         @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
         @Result(column="HAS_OA_TXN", property="hasOaTxn", jdbcType=JdbcType.VARCHAR),
         @Result(column="MCC", property="mcc", jdbcType=JdbcType.VARCHAR)
    })
    List<ExtWithdrawReqVO> selectMerchantFastsettleByQuery(ExtWithdrawReqDOExample example);

	@SelectProvider(type = ExtWithdrawReqSqlProvider.class, method = "countMerchantFastsettleByQuery")
	int countMerchantFastsettleByQuery(ExtWithdrawReqDOExample example);

	@SelectProvider(type = ExtWithdrawReqSqlProvider.class, method = "statisticsPromoterMerchantWithdrawInfo")
	 @Results({
    	 @Result(column="WITHDRAW_TOTAL_AMOUNT", property="withdrawTotalAmount", jdbcType=JdbcType.DECIMAL, id=true),
         @Result(column="WITHDRAWING_CNT", property="withdrawingCnt", jdbcType=JdbcType.DECIMAL),
    })
	StatisticsWithdrawInfoDTO statisticsPromoterMerchantWithdrawInfo(Long promoterId);

	@SelectProvider(type = ExtWithdrawReqSqlProvider.class, method = "countWithdrawInfoByQuery")
	int countWithdrawInfoByQuery(ExtWithdrawReqDOExample example);
	@SelectProvider(type=ExtWithdrawReqSqlProvider.class, method="queryWithdrawInfoByQuery")
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
         @Result(column="TOTAL_COST", property="totalCost", jdbcType=JdbcType.DECIMAL),
         @Result(column="WITHDRAW_COST", property="withdrawCost", jdbcType=JdbcType.DECIMAL),
         @Result(column="WD_COST", property="wdCost", jdbcType=JdbcType.DECIMAL),
         @Result(column="ORIGINAL_AMOUNT", property="originalAmount", jdbcType=JdbcType.DECIMAL),
         @Result(column="SPLITTING_FEE", property="splittingFee", jdbcType=JdbcType.DECIMAL),
         @Result(column="SPLITTING_COST", property="splittingCost", jdbcType=JdbcType.DECIMAL),
         @Result(column="PMT_MEMBER_ID", property="pmtMemberId", jdbcType=JdbcType.VARCHAR),
         @Result(column="PMT_MERCHANT_NO", property="pmtMerchantNo", jdbcType=JdbcType.VARCHAR),
         @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
         @Result(column="RETRY_TIMES", property="retryTimes", jdbcType=JdbcType.DECIMAL),
         @Result(column="ERROR_CODE", property="errorCode", jdbcType=JdbcType.VARCHAR),
         @Result(column="ERROR_MSG", property="errorMsg", jdbcType=JdbcType.VARCHAR),
         @Result(column="wr_CALLBACK_ADDRESS", property="wrCallbackAddress", jdbcType=JdbcType.VARCHAR),
         @Result(column="APPLY_TIME", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
         @Result(column="wr_CREATE_TIME", property="wrCreateTime", jdbcType=JdbcType.TIMESTAMP),
         @Result(column="wr_UPDATE_TIME", property="wrUpdateTime", jdbcType=JdbcType.TIMESTAMP),
         @Result(column="WITHDRAW_TIME", property="withdrawTime", jdbcType=JdbcType.TIMESTAMP),
         @Result(column="SERVICE_TYPE", property="serviceType", jdbcType=JdbcType.DECIMAL),
         @Result(column="HAS_OA_TXN", property="hasOaTxn", jdbcType=JdbcType.VARCHAR),
    	 @Result(column="DETAIL_ID", property="detailId", jdbcType=JdbcType.DECIMAL),
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
         @Result(column="callback_address", property="callbackAddress", jdbcType=JdbcType.VARCHAR),
         @Result(column="MEMO", property="memo", jdbcType=JdbcType.VARCHAR),
         @Result(column="CURRENCY", property="currency", jdbcType=JdbcType.VARCHAR),
         @Result(column="REQ_EXTENTION", property="reqExtention", jdbcType=JdbcType.VARCHAR),
         @Result(column="WITHDRAW_STATUS", property="withdrawStatus", jdbcType=JdbcType.VARCHAR),
         @Result(column="RETURN_CODE", property="returnCode", jdbcType=JdbcType.VARCHAR),
         @Result(column="RETURN_MSG", property="returnMsg", jdbcType=JdbcType.VARCHAR),
         @Result(column="EXTENTION", property="extention", jdbcType=JdbcType.VARCHAR),
         @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
         @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
	List<ExtWithdrawReqVO> queryWithdrawInfoByQuery(ExtWithdrawReqDOExample example);

	 @SelectProvider(type=ExtWithdrawReqSqlProvider.class, method="queryStatusDisagreeInfo")
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
	        @Result(column="HAS_OA_TXN", property="hasOaTxn", jdbcType=JdbcType.VARCHAR),
	        @Result(column="LAST_LEVEL_PROMOTER_ID", property="lastLevelPromoterId", jdbcType=JdbcType.DECIMAL)
	    })
	List<WithdrawReqDO> queryStatusDisagreeInfo();

	 @SelectProvider(type = ExtWithdrawReqSqlProvider.class, method = "statisticsPromoterWithdrawInfo")
	 @Results({
    	 @Result(column="WITHDRAW_TOTAL_AMOUNT", property="withdrawTotalAmount", jdbcType=JdbcType.DECIMAL),
    	 @Result(column="TOTAL_CNT", property="totalCnt", jdbcType=JdbcType.DECIMAL),
    	 @Result(column="TIME", property="time", jdbcType=JdbcType.TIMESTAMP),
    	 @Result(column="ACTIVE_MERCHANT_NUM", property="activeMerchantNum", jdbcType=JdbcType.TIMESTAMP)
    })
	List<StatisticsWithdrawInfoDTO> statisticsPromoterWithdrawInfo(Long promoterId);
	 
	 @SelectProvider(type = ExtWithdrawReqSqlProvider.class, method = "statisticsMerchantWithdrawInfo")
	 @Results({
		 @Result(column="WITHDRAW_TOTAL_AMOUNT", property="withdrawTotalAmount", jdbcType=JdbcType.DECIMAL),
    	 @Result(column="TOTAL_CNT", property="totalCnt", jdbcType=JdbcType.DECIMAL),
    	 @Result(column="TIME", property="time", jdbcType=JdbcType.TIMESTAMP)
    })
	List<StatisticsWithdrawInfoDTO> statisticsMerchantWithdrawInfo(Long merchantBizId);
	 
	@SelectProvider(type = ExtWithdrawReqSqlProvider.class, method = "queryWithdrawReqTotalAmount")
	BigDecimal queryWithdrawReqTotalAmount(ExtWithdrawReqDOExample example);


}
