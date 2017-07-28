package com.sdp.mc.mcwithfunding.dao.daointerface;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.sdp.mc.mcwithfunding.dao.WithCapital4PromoterDO;
import com.sdp.mc.mcwithfunding.dao.ext.WithCapitalReqDOExampleExt;
import com.sdp.mc.mcwithfunding.dao.mapper.WithCapital4PromoterMapper;
import com.sdp.mc.mcwithfunding.dao.mapper.ext.WithCapitalOpReqSqlProviderExt;

public interface WithCapital4PromoterDAO extends WithCapital4PromoterMapper {

	@SelectProvider(type=WithCapitalOpReqSqlProviderExt.class, method="selectByQuery4Intra")
    @Results({
    	@Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="MC_TYPE", property="mcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_NAME", property="promoterName", jdbcType=JdbcType.VARCHAR),
        @Result(column="APPLY_DATETIME", property="applyDatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="AMOUNT", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="FEE_RATIO", property="feeRatio", jdbcType=JdbcType.VARCHAR),
        @Result(column="FEE", property="fee", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREDIT_FOS_ID", property="creditFosId", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREDIT_CHANGE_ID", property="creditChangeId", jdbcType=JdbcType.DECIMAL),
        @Result(column="REVERSAL_FOS_ID", property="reversalFosId", jdbcType=JdbcType.DECIMAL),
        @Result(column="REVERSAL_CHANGE_ID", property="reversalChangeId", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="BATCH_NO", property="batchNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="FEE_FOS_ID", property="feeFosId", jdbcType=JdbcType.DECIMAL),
        @Result(column="RECOVERY_DATE", property="recoveryDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="RETRY_TIMES_4MSP", property="retryTimes4msp", jdbcType=JdbcType.DECIMAL)

    })
    List<WithCapital4PromoterDO> selectByQuery4Intra(WithCapitalReqDOExampleExt example);

	@SelectProvider(type=WithCapitalOpReqSqlProviderExt.class, method="countByExample4Intra")
    int countByExample4Intra(WithCapitalReqDOExampleExt example);
	
	
	
	/**
	 * 统计代理商已配资总额按代理商id统计
	 * **/
	@Select({
        "select sum(amount) from MC_WITH_CAPITAL_4PROMOTER ",
        "where PROMOTER_ID = #{promoterId,jdbcType=DECIMAL} and STATUS=4 "
    })
	BigDecimal sumWithCapitalAmountByPromoterId(Long promoterId);
}