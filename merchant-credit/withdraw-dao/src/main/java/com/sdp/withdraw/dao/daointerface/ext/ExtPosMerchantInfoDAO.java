package com.sdp.withdraw.dao.daointerface.ext;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.dao.PosMerchantInfoDOExample;
import com.sdp.withdraw.dao.mapper.ext.ExtPosMerchantInfoSqlProvider;

public interface ExtPosMerchantInfoDAO {

	@SelectProvider(type = ExtPosMerchantInfoSqlProvider.class, method = "selectOpenFastSettlePromoterInfo")
	@Results({ @Result(column = "ID", property = "id", jdbcType = JdbcType.DECIMAL, id = true),
			@Result(column = "MERCHANT_NO", property = "merchantNo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "POS_MERCHANT_ID", property = "posMerchantId", jdbcType = JdbcType.DECIMAL),
			@Result(column = "MERCHANT_TYPE", property = "merchantType", jdbcType = JdbcType.VARCHAR),
			@Result(column = "PARENT_PROMOTER_ID", property = "parentPromoterId", jdbcType = JdbcType.DECIMAL),
			@Result(column = "MERCHANT_MEMBER_ID", property = "merchantMemberId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ACCOUNT_TYPE", property = "accountType", jdbcType = JdbcType.VARCHAR),
			@Result(column = "BASE_ACCOUNT_ID", property = "baseAccountId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "CREATE_TIME", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "UPDATE_TIME", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "FAST_SETTLE_LIMIT", property = "fastSettleLimit", jdbcType = JdbcType.DECIMAL),
			@Result(column = "FAST_SETTLE_FLAG", property = "fastSettleFlag", jdbcType = JdbcType.DECIMAL),
			@Result(column = "AUTO_FAST_SETTLE_FLAG", property = "autoFastSettleFlag", jdbcType = JdbcType.DECIMAL),
			@Result(column = "MERCHANT_PHONE", property = "merchantPhone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "FAST_SETTLE_MARGIN", property = "fastSettleMargin", jdbcType = JdbcType.DECIMAL),
			@Result(column = "FAST_SETTLE_MIN_LIMIT", property = "fastSettleMinLimit", jdbcType = JdbcType.DECIMAL),
			@Result(column = "PMT_BIND_OPERATOR_ID", property = "pmtBindOperatorId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "PMT_BIND_OPERATOR_NAME", property = "pmtBindOperatorName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "LOANING_TYPE", property = "loaningType", jdbcType = JdbcType.DECIMAL),
			@Result(column = "STATUS", property = "status", jdbcType = JdbcType.VARCHAR),
			@Result(column = "MERCHANT_NAME", property = "merchantName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "MCC", property = "mcc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "LAST_LEVEL_PROMOTER_ID", property = "lastLevelPromoterId", jdbcType = JdbcType.DECIMAL),
			@Result(column = "PMT_LEVEL", property = "pmtLevel", jdbcType = JdbcType.DECIMAL),
			@Result(column = "CERT_TYPE", property = "certType", jdbcType = JdbcType.VARCHAR),
			@Result(column = "CERT_NO", property = "certNo", jdbcType = JdbcType.VARCHAR) })
	List<PosMerchantInfoDO> selectOpenFastSettlePromoterInfo();

	@SelectProvider(type = ExtPosMerchantInfoSqlProvider.class, method = "selectOpenFastSettleMerchantInfoByPromoterId")
	@Results({ @Result(column = "ID", property = "id", jdbcType = JdbcType.DECIMAL, id = true),
			@Result(column = "MERCHANT_NO", property = "merchantNo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "POS_MERCHANT_ID", property = "posMerchantId", jdbcType = JdbcType.DECIMAL),
			@Result(column = "MERCHANT_TYPE", property = "merchantType", jdbcType = JdbcType.VARCHAR),
			@Result(column = "PARENT_PROMOTER_ID", property = "parentPromoterId", jdbcType = JdbcType.DECIMAL),
			@Result(column = "MERCHANT_MEMBER_ID", property = "merchantMemberId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ACCOUNT_TYPE", property = "accountType", jdbcType = JdbcType.VARCHAR),
			@Result(column = "BASE_ACCOUNT_ID", property = "baseAccountId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "CREATE_TIME", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "UPDATE_TIME", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "FAST_SETTLE_LIMIT", property = "fastSettleLimit", jdbcType = JdbcType.DECIMAL),
			@Result(column = "FAST_SETTLE_FLAG", property = "fastSettleFlag", jdbcType = JdbcType.DECIMAL),
			@Result(column = "AUTO_FAST_SETTLE_FLAG", property = "autoFastSettleFlag", jdbcType = JdbcType.DECIMAL),
			@Result(column = "MERCHANT_PHONE", property = "merchantPhone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "FAST_SETTLE_MARGIN", property = "fastSettleMargin", jdbcType = JdbcType.DECIMAL),
			@Result(column = "FAST_SETTLE_MIN_LIMIT", property = "fastSettleMinLimit", jdbcType = JdbcType.DECIMAL),
			@Result(column = "PMT_BIND_OPERATOR_ID", property = "pmtBindOperatorId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "PMT_BIND_OPERATOR_NAME", property = "pmtBindOperatorName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "LOANING_TYPE", property = "loaningType", jdbcType = JdbcType.DECIMAL),
			@Result(column = "STATUS", property = "status", jdbcType = JdbcType.VARCHAR),
			@Result(column = "MERCHANT_NAME", property = "merchantName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "MCC", property = "mcc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "LAST_LEVEL_PROMOTER_ID", property = "lastLevelPromoterId", jdbcType = JdbcType.DECIMAL),
			@Result(column = "PMT_LEVEL", property = "pmtLevel", jdbcType = JdbcType.DECIMAL),
			@Result(column = "CERT_TYPE", property = "certType", jdbcType = JdbcType.VARCHAR),
			@Result(column = "CERT_NO", property = "certNo", jdbcType = JdbcType.VARCHAR) })
	List<PosMerchantInfoDO> selectOpenFastSettleMerchantInfoByPromoterId(Long promoterId);

	@DeleteProvider(type = ExtPosMerchantInfoSqlProvider.class, method = "distinctMerchant")
	int distinctMerchant();

	@SelectProvider(type = ExtPosMerchantInfoSqlProvider.class, method = "getOpenT0IdentityMerchantInfo")
	@Results({ @Result(column = "ID", property = "id", jdbcType = JdbcType.DECIMAL, id = true),
			@Result(column = "MERCHANT_NO", property = "merchantNo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "POS_MERCHANT_ID", property = "posMerchantId", jdbcType = JdbcType.DECIMAL),
			@Result(column = "MERCHANT_TYPE", property = "merchantType", jdbcType = JdbcType.VARCHAR),
			@Result(column = "PARENT_PROMOTER_ID", property = "parentPromoterId", jdbcType = JdbcType.DECIMAL),
			@Result(column = "MERCHANT_MEMBER_ID", property = "merchantMemberId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ACCOUNT_TYPE", property = "accountType", jdbcType = JdbcType.VARCHAR),
			@Result(column = "BASE_ACCOUNT_ID", property = "baseAccountId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "CREATE_TIME", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "UPDATE_TIME", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "FAST_SETTLE_LIMIT", property = "fastSettleLimit", jdbcType = JdbcType.DECIMAL),
			@Result(column = "FAST_SETTLE_FLAG", property = "fastSettleFlag", jdbcType = JdbcType.DECIMAL),
			@Result(column = "AUTO_FAST_SETTLE_FLAG", property = "autoFastSettleFlag", jdbcType = JdbcType.DECIMAL),
			@Result(column = "MERCHANT_PHONE", property = "merchantPhone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "FAST_SETTLE_MARGIN", property = "fastSettleMargin", jdbcType = JdbcType.DECIMAL),
			@Result(column = "FAST_SETTLE_MIN_LIMIT", property = "fastSettleMinLimit", jdbcType = JdbcType.DECIMAL),
			@Result(column = "PMT_BIND_OPERATOR_ID", property = "pmtBindOperatorId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "PMT_BIND_OPERATOR_NAME", property = "pmtBindOperatorName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "LOANING_TYPE", property = "loaningType", jdbcType = JdbcType.DECIMAL),
			@Result(column = "STATUS", property = "status", jdbcType = JdbcType.VARCHAR),
			@Result(column = "MERCHANT_NAME", property = "merchantName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "MCC", property = "mcc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "LAST_LEVEL_PROMOTER_ID", property = "lastLevelPromoterId", jdbcType = JdbcType.DECIMAL),
			@Result(column = "PMT_LEVEL", property = "pmtLevel", jdbcType = JdbcType.DECIMAL),
			@Result(column = "CERT_TYPE", property = "certType", jdbcType = JdbcType.VARCHAR),
			@Result(column = "CERT_NO", property = "certNo", jdbcType = JdbcType.VARCHAR) })
	List<PosMerchantInfoDO> getOpenT0IdentityMerchantInfo(PosMerchantInfoDOExample example);
	
	@InsertProvider(type = ExtPosMerchantInfoSqlProvider.class, method = "repairFirstOpenDate")
	int repairFirstOpenDate();
	@SelectProvider(type = ExtPosMerchantInfoSqlProvider.class, method = "syncMerchantOperator")
	@Results({ @Result(column = "ID", property = "id", jdbcType = JdbcType.DECIMAL, id = true),
			@Result(column = "PMT_BIND_OPERATOR_ID", property = "pmtBindOperatorId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "PMT_BIND_OPERATOR_NAME", property = "pmtBindOperatorName", jdbcType = JdbcType.VARCHAR)})
	List<PosMerchantInfoDO> syncMerchantOperator();
	
	@UpdateProvider(type = ExtPosMerchantInfoSqlProvider.class, method = "syncOpenAccountTime")
	int syncOpenAccountTime();

	@UpdateProvider(type = ExtPosMerchantInfoSqlProvider.class, method = "executeSql")
	int executeUpdateSql(String updateSql);
	
	@InsertProvider(type = ExtPosMerchantInfoSqlProvider.class, method = "executeSql")
	int executeInsertSql(String insertSql);

	@InsertProvider(type = ExtPosMerchantInfoSqlProvider.class, method = "createNewMerchantWithdrawInfo")
	int createNewMerchantWithdrawInfo();
	
	@UpdateProvider(type = ExtPosMerchantInfoSqlProvider.class, method = "updateMerchantWithdrawInfo")
	int updateMerchantWithdrawInfo();
	
	@SelectProvider(type = ExtPosMerchantInfoSqlProvider.class, method = "selectMerchantWithdrawInfoForUpdate")
	 @Results({
	        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
	        @Result(column="LIMITATION_TYPE", property="limitationType", jdbcType=JdbcType.DECIMAL),
	        @Result(column="BIZ_ID", property="bizId", jdbcType=JdbcType.DECIMAL),
	        @Result(column="BIZ_TYPE", property="bizType", jdbcType=JdbcType.DECIMAL),
	        @Result(column="LIMITATION", property="limitation", jdbcType=JdbcType.DECIMAL),
	        @Result(column="FORZEN_LIMITATION", property="forzenLimitation", jdbcType=JdbcType.DECIMAL),
	        @Result(column="USED_LIMITATION", property="usedLimitation", jdbcType=JdbcType.DECIMAL),
	        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
	    })
	List<Long> selectMerchantWithdrawInfoForUpdate();
	
	

}
