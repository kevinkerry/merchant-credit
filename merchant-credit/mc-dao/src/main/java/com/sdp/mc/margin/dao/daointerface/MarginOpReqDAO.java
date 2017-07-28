package com.sdp.mc.margin.dao.daointerface;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.sdp.mc.margin.dao.ext.MarginOpReqDOExampleExt;
import com.sdp.mc.margin.dao.ext.MarginOpReqDOExt;
import com.sdp.mc.margin.dao.ext.RedeemedMarginApplyExampleExt;
import com.sdp.mc.margin.dao.ext.RedeemedMarginApplyExt;
import com.sdp.mc.margin.dao.mapper.MarginOpReqMapper;
import com.sdp.mc.margin.dao.mapper.ext.MarginOpReqSqlProviderExt;

public interface MarginOpReqDAO extends MarginOpReqMapper {
	
	@SelectProvider(type=MarginOpReqSqlProviderExt.class, method="selectByQuery4Intra")
    @Results({
        @Result(column="MOR_ID", property="morId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="OP_TYPE", property="opType", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="AMOUNT", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="REDEEMED_TIME", property="redeemedTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MT_ID", property="mtId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MT_ID_HIS", property="mtIdHis", jdbcType=JdbcType.VARCHAR),
        @Result(column="FCM_ID", property="fcmId", jdbcType=JdbcType.DECIMAL),
        @Result(column="FCM_ID_HIS", property="fcmIdHis", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MC_MERCHANT_NO_V", property="mcMerchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MC_MERCHANT_NAME_V", property="mcMerchantName", jdbcType=JdbcType.VARCHAR),
        @Result(column="MC_TYPE_C", property="mcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="PSTATUS", property="pStatus", jdbcType=JdbcType.DECIMAL)
    })
    List<MarginOpReqDOExt> selectByQuery4Intra(MarginOpReqDOExampleExt example);
	
	@SelectProvider(type=MarginOpReqSqlProviderExt.class, method="countByExample4Intra")
    int countByExample4Intra(MarginOpReqDOExampleExt example);
	
	/**
	 * 保证金取回审核列表
	 * @param example
	 * @return
	 */
	
	@SelectProvider(type=MarginOpReqSqlProviderExt.class, method="selectByNewT0AuditingQuery4Intra")
    @Results({
        @Result(column="MOR_ID", property="morId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="OP_TYPE", property="opType", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="AMOUNT", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="REDEEMED_TIME", property="redeemedTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MT_ID", property="mtId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MT_ID_HIS", property="mtIdHis", jdbcType=JdbcType.VARCHAR),
        @Result(column="FCM_ID", property="fcmId", jdbcType=JdbcType.DECIMAL),
        @Result(column="FCM_ID_HIS", property="fcmIdHis", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REALNAME", property="realName", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERA_TIME", property="operaTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MC_MERCHANT_NO_V", property="mcMerchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MC_MERCHANT_NAME_V", property="mcMerchantName", jdbcType=JdbcType.VARCHAR),
        @Result(column="MC_TYPE_C", property="mcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="PSTATUS", property="pStatus", jdbcType=JdbcType.DECIMAL),
        @Result(column="MARGIN_MEMBER_ID", property="marginMemberId", jdbcType=JdbcType.VARCHAR),
    })
    List<RedeemedMarginApplyExt> selectByNewT0AuditingQuery4Intra(MarginOpReqDOExampleExt example);
	
	@SelectProvider(type=MarginOpReqSqlProviderExt.class, method="countByNewT0AuditingExample4Intra")
    int countByNewT0AuditingExample4Intra(RedeemedMarginApplyExampleExt example);
	
	/**
	 * 统计所有页面申请取回合计金额
	 * @param example
	 * @return
	 */
	@SelectProvider(type=MarginOpReqSqlProviderExt.class, method="totalAmountByNewT0AuditingExample4Intra")
	BigDecimal totalAmountByNewT0AuditingExample4Intra(RedeemedMarginApplyExampleExt example);
	
}