package com.sdp.withdraw.dao.daointerface.ext;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.sdp.withdraw.dao.ext.ExtWalletWithdrawReqDTO;
import com.sdp.withdraw.dao.mapper.ext.ExtWalletWithdrawReqSqlProvider;

public interface ExtWalletWithdrawReqDAO{


	/**
	 * 根据Query对象分页查询出款列表信息
	 * @param example
	 * @return
	 */
    @SelectProvider(type=ExtWalletWithdrawReqSqlProvider.class, method="selectWalletWithdrawByQuery")
    @Results({
    	 @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL, id=true),
         @Result(column="APP_ID", property="appId", jdbcType=JdbcType.VARCHAR),
         @Result(column="ORDER_NO", property="orderNo", jdbcType=JdbcType.VARCHAR),
         @Result(column="MEMBER_ID", property="memberId", jdbcType=JdbcType.VARCHAR),
         @Result(column="MEMBER_NO", property="memberNo", jdbcType=JdbcType.VARCHAR),
         @Result(column="MEMBER_TYPE", property="memberType", jdbcType=JdbcType.VARCHAR),
         @Result(column="WITHDRAW_AMOUNT", property="withdrawAmount", jdbcType=JdbcType.DECIMAL),
         @Result(column="ORIGINAL_AMOUNT", property="originalAmount", jdbcType=JdbcType.DECIMAL),
         @Result(column="TRACE_NO", property="traceNo", jdbcType=JdbcType.DECIMAL),
         @Result(column="EXTENTION", property="extention", jdbcType=JdbcType.VARCHAR),
         @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
         @Result(column="CALLBACK_ADDRESS", property="callbackAddress", jdbcType=JdbcType.VARCHAR),
         @Result(column="WITHDRAW_TYPE", property="withdrawType", jdbcType=JdbcType.DECIMAL),
         @Result(column="WITHDRAW_FEE", property="withdrawFee", jdbcType=JdbcType.DECIMAL),
         @Result(column="WITHDRAW_COST", property="withdrawCost", jdbcType=JdbcType.DECIMAL),
         @Result(column="WD_COST", property="wdCost", jdbcType=JdbcType.DECIMAL),
         @Result(column="ORIGINAL_AMOUNT", property="originalAmount", jdbcType=JdbcType.DECIMAL),
         @Result(column="APPLY_TIME", property="applyTime", jdbcType=JdbcType.TIMESTAMP),
         @Result(column="WITHDRAW_TIME", property="withdrawTime", jdbcType=JdbcType.TIMESTAMP),
         @Result(column="SERVICE_TYPE", property="serviceType", jdbcType=JdbcType.DECIMAL),
         @Result(column="REMIT_VOUCHER_NO", property="remitVoucherNo", jdbcType=JdbcType.VARCHAR),
         @Result(column="BANK_NAME", property="bankName", jdbcType=JdbcType.VARCHAR),
         @Result(column="PAYEE_NAME", property="name", jdbcType=JdbcType.VARCHAR),
         @Result(column="PAYEE_CARD_NO", property="cardNo", jdbcType=JdbcType.VARCHAR),
         @Result(column="RETURN_CODE", property="returnCode", jdbcType=JdbcType.VARCHAR),
         @Result(column="RETURN_MSG", property="returnMsg", jdbcType=JdbcType.VARCHAR),
    })
    List<ExtWalletWithdrawReqDTO> selectWalletWithdrawByQuery(ExtWalletWithdrawReqDTO dto);

	@SelectProvider(type = ExtWalletWithdrawReqSqlProvider.class, method = "countWalletWithdrawByQuery")
	int countWalletWithdrawByQuery(ExtWalletWithdrawReqDTO dto);



}
