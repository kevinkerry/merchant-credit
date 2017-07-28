package com.sdp.mc.ffconfig.dao.daointerface;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.sdp.mc.ffconfig.dao.ext.FastSettleConfigDOExampleExt;
import com.sdp.mc.ffconfig.dao.ext.FastSettleConfigDOExt;
import com.sdp.mc.ffconfig.dao.mapper.FastSettleConfigMapper;
import com.sdp.mc.ffconfig.dao.mapper.ext.FastSettleConfigSqlProviderExt;

public interface FastSettleConfigDAO extends FastSettleConfigMapper {

	@SelectProvider(type = FastSettleConfigSqlProviderExt.class, method = "selectByQuery4Intra")
	@Results({
		    /*@Result(column = "PFC_ID", property = "pfcId", jdbcType = JdbcType.DECIMAL, id = true),
			@Result(column = "OBJ_ID", property = "objId", jdbcType = JdbcType.DECIMAL),
			@Result(column = "OBJ_TYPE", property = "objType", jdbcType = JdbcType.VARCHAR),*/
			@Result(column = "AUTO_FAST_SETTLE_FLAG", property = "autoFastSettle", jdbcType = JdbcType.DECIMAL),
			@Result(column = "CREATE_TIME", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "UPDATE_TIME", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "MERCHANT_ID", property = "merchantId", jdbcType = JdbcType.DECIMAL),
			@Result(column = "PROMOTER_ID", property = "promoterId", jdbcType = JdbcType.DECIMAL),
			@Result(column = "MERCHANT_NO", property = "mcMerchantNo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "MERCHANT_NAME", property = "mcMerchantName", jdbcType = JdbcType.VARCHAR),
//			@Result(column = "POSM_POS_MERCHANT_NO_C", property = "posMerchantNo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "MC_TYPE", property = "mcType", jdbcType = JdbcType.VARCHAR),
//			@Result(column = "MC_STATUS_C", property = "mcStatus", jdbcType = JdbcType.VARCHAR),
			@Result(column = "MERCHANT_FS_LIMIT", property = "limitAmount", jdbcType = JdbcType.DECIMAL),
			@Result(column = "PROMOTER_NAME", property = "promoterName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "PROMOTER_MERCHANT_NO", property = "promoterMerchantNo", jdbcType = JdbcType.VARCHAR),
			@Result(column = "MERCHANT_fS_flag", property = "fast_settle_flag", jdbcType = JdbcType.NUMERIC),
			@Result(column = "PROMOTER_fS_flag", property = "pmt_fast_settle_flag", jdbcType = JdbcType.NUMERIC),
			@Result(column = "PROMOTER_fs_limit", property = "pmt_fast_settle_limit", jdbcType = JdbcType.NUMERIC),
			@Result(column = "MERCHANT_MCC", property = "mcc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "PROMOTER_fs_margin", property = "pmt_fast_settle_margin", jdbcType = JdbcType.NUMERIC)

	})
	List<FastSettleConfigDOExt> selectByQuery4Intra(FastSettleConfigDOExampleExt example);

	@SelectProvider(type = FastSettleConfigSqlProviderExt.class, method = "countByExample4Intra")
	int countByExample4Intra(FastSettleConfigDOExampleExt example);

	/**
	 * 根据垫资方修改自动快速结算loaningType1,status2;loaningType0,status1
	 * 
	 * @param promoterId
	 * @return
	 */
	@UpdateProvider(type = FastSettleConfigSqlProviderExt.class, method = "updateByPromoterId")
	int updateByPromoterId(Long promoterId);

}