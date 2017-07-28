package com.sdp.mc.promoter.dao.daointerface;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.sdp.mc.promoter.dao.ext.PromoterFastSettleSwitchDOExampleExt;
import com.sdp.mc.promoter.dao.ext.PromoterFastSettleSwitchDOExt;
import com.sdp.mc.promoter.dao.ext.PromoterFastSettleSwitchDONewt0Ext;
import com.sdp.mc.promoter.dao.mapper.PromoterFastSettleSwitchMapper;
import com.sdp.mc.promoter.dao.mapper.ext.PromoterFastSettleSwitchSqlProviderExt;

public interface PromoterFastSettleSwitchDAO extends PromoterFastSettleSwitchMapper {

	@SelectProvider(type=PromoterFastSettleSwitchSqlProviderExt.class, method="selectByQuery4Intra")
    @Results({
        @Result(column="PFR_ID", property="pfrId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="MARGIN_ACCOUNT", property="marginAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="MAQ_ID", property="maqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="FCM_ID", property="fcmId", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MARGIN_MEMBER_ID", property="marginMemberId", jdbcType=JdbcType.VARCHAR),

        @Result(column="MC_MERCHANT_NO_V", property="mcMerchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MC_TYPE_C", property="mcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="MC_MERCHANT_NAME_V", property="promoterName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PMT_FAST_SETTLE_FLAG", property="mspFastSettleFlag", jdbcType=JdbcType.DECIMAL),
    })
    List<PromoterFastSettleSwitchDOExt> selectByQuery4Intra(PromoterFastSettleSwitchDOExampleExt example);

	@SelectProvider(type=PromoterFastSettleSwitchSqlProviderExt.class, method="countByExample4Intra")
    int countByExample4Intra(PromoterFastSettleSwitchDOExampleExt example);

	@SelectProvider(type=PromoterFastSettleSwitchSqlProviderExt.class, method="selectByQueryAuditInfo")
    @Results({
        @Result(column="PFR_ID", property="pfrId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="MARGIN_ACCOUNT", property="marginAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="MAQ_ID", property="maqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="FCM_ID", property="fcmId", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MARGIN_MEMBER_ID", property="marginMemberId", jdbcType=JdbcType.VARCHAR),

        @Result(column="MC_MERCHANT_NO_V", property="mcMerchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MC_TYPE_C", property="mcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="MC_MERCHANT_NAME_V", property="promoterName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PMT_FAST_SETTLE_FLAG", property="mspFastSettleFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="PMT_FAST_SETTLE_LIMIT", property="fastSettleLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="AUDIT_STATUS", property="auditStatus", jdbcType=JdbcType.VARCHAR),
    })
    List<PromoterFastSettleSwitchDONewt0Ext> selectByQueryAuditInfo(PromoterFastSettleSwitchDOExampleExt example);

	@SelectProvider(type=PromoterFastSettleSwitchSqlProviderExt.class, method="countByExampleAuditInfo")
	@Deprecated
    int countByExampleAuditInfo(PromoterFastSettleSwitchDOExampleExt example);

	@SelectProvider(type=PromoterFastSettleSwitchSqlProviderExt.class, method="getPosOpenFastSettleMerchantIds")
    @Results({
        @Result(column="MERCHANT_ID", property="mcMerchantId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="MERCHANT_NO", property="mcMerchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MC_TYPE", property="mcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
    })
	List<PromoterFastSettleSwitchDOExt> getPosOpenFastSettleMerchantIds();


	@SelectProvider(type=PromoterFastSettleSwitchSqlProviderExt.class, method="getPromoters")
    @Results({
        @Result(column="PMT_ID_N", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_MERCHANT_NO", property="promoterNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MC_MERCHANT_NAME_V", property="promoterName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PMT_ID_N", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="MC_TYPE_C", property="mcType", jdbcType=JdbcType.DECIMAL),
    })
	List<PromoterFastSettleSwitchDOExt> getPromoters(Integer loaningType);


	@SelectProvider(type=PromoterFastSettleSwitchSqlProviderExt.class, method="getAllPosAndMposOpenFastSettleMerchants")
    @Results({
        @Result(column="MC_ID_N", property="mcMerchantId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="MC_MERCHANT_NO_V", property="mcMerchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="HAND_POHNE_NO", property="merchantPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="POSM_PROMOTER_ID_N", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="MC_TYPE_C", property="mcType", jdbcType=JdbcType.DECIMAL),
    })
	List<PromoterFastSettleSwitchDOExt> getAllPosAndMposOpenFastSettleMerchants();


}