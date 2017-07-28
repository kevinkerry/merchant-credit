package com.sdp.mc.ffconfig.dao.mapper.ext;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import org.apache.commons.lang.StringUtils;

import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.ffconfig.dao.ext.FastSettleConfigDOExampleExt;
import com.sdp.mc.ffconfig.dao.mapper.FastSettleConfigSqlProvider;

public class FastSettleConfigSqlProviderExt extends FastSettleConfigSqlProvider {
	/**
	 * 根据Query对象分页查询代理商保证金追加/退回记录【MarginOpReqDO】对象列表信息
	 *
	 * @mbggenerated Mon Mar 30 13:57:53 CST 2015
	 */
	public String selectByQuery4Intra(FastSettleConfigDOExampleExt example) {
		StringBuilder sb = new StringBuilder();
		sb.append("select INFO.*");
		if (example != null && example.isDistinct()) {
//			sb.append("distinct ffc.PFC_ID,");
		} else {
//			sb.append("ffc.PFC_ID,");
		}

		sb.append("FROM VIEW_MERCHANT_INFO info ");
		sb.append("WHERE 1=1 ");
		// 开启自动快速结算 0：关闭  1：老TO（代理商垫资）开通 2：新T0 (盛付通垫资) 开通
		if(example!=null){
			if (example.getAutoFastSettle() != null) {
				if(example.getAutoFastSettle()!=0){
					sb.append(" and  info.AUTO_FAST_SETTLE_FLAG >0 ");
				}else{
					sb.append(" and  (info.AUTO_FAST_SETTLE_FLAG = 0 or info.AUTO_FAST_SETTLE_FLAG is null )");
				}
			}
			if (example.getCreateTimeStart() != null) {
				sb.append(" and  info.CREATE_TIME >= #{createTimeStart,jdbcType=TIMESTAMP} ");
			}
			if (example.getCreateTimeEnd() != null) {
				sb.append(" and  info.CREATE_TIME < #{createTimeEnd,jdbcType=TIMESTAMP} ");
			}
			// 商户
			if (StringUtils.isNotBlank(example.getMerchantType())) {
				sb.append(" and info.MC_TYPE = #{merchantType} ");
			}
			// 商户名称
			if (StringUtils.isNotBlank(example.getMerchantName())) {
				sb.append(" and info.MERCHANT_NAME like '%'||#{merchantName}||'%' ");
			}
			// 商户号
			if (StringUtils.isNotBlank(example.getMerchantNo())) {
				sb.append(" and info.MERCHANT_NO = #{merchantNo}");
			}
			// 拓展方-名称
			if (StringUtils.isNotBlank(example.getPromoterName())) {
				sb.append(" and info.PROMOTER_NAME like '%'||#{promoterName}||'%' ");
			}
			// 拓展方pos商户号
			if (StringUtils.isNotBlank(example.getPromoterMerchantNo())) {
				sb.append(" and info.PROMOTER_MERCHANT_NO= #{promoterMerchantNo} ");
			}
			// 限额
			if (example.getMaxLimitAmountStart() != null) {
				sb.append(" and info.MERCHANT_FS_LIMIT >= #{maxLimitAmountStart} ");
			}
			// 限额
			if (example.getMaxLimitAmountEnd() != null) {
				sb.append(" and info.MERCHANT_FS_LIMIT < #{maxLimitAmountEnd} ");
			}
			//是否开通快速结算
			if (StringUtils.isNotBlank(example.getMerchantFastSettleFlag())) {
				if(MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN.equals(example.getMerchantFastSettleFlag())){
					sb.append(" and info.PROMOTER_FS_FLAG = 1 ");
					sb.append(" and info.MERCHANT_FS_FLAG = 1 ");
				}else{
					sb.append(" and (NVL(info.PROMOTER_FS_FLAG,0) = 0 or NVL(info.MERCHANT_FS_FLAG,0) = 0) ");
				}
			}
		}
		sb.append(" order by INFO.CREATE_TIME desc nulls last , INFO.MERCHANT_BIZ_ID");

		StringBuilder sqlStr = new StringBuilder();
		sqlStr.append("select t.* from (select tt.*, ROWNUM rnum from ( ");
		sqlStr.append(sb.toString());
		sqlStr.append(") tt) t where   t.rnum <= #{pageLastItem,jdbcType=NUMERIC}  and t.rnum >= #{pageFristItem,jdbcType=NUMERIC}");

		return sqlStr.toString();
	}

	public String countByExample4Intra(FastSettleConfigDOExampleExt example) {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("count(info.MERCHANT_ID) ");
		sb.append("FROM VIEW_MERCHANT_INFO info ");
		sb.append("WHERE 1=1 ");
		// 开启自动快速结算 0：关闭  1：老TO（代理商垫资）开通 2：新T0 (盛付通垫资) 开通
		if (example.getAutoFastSettle() != null) {
			if(example.getAutoFastSettle()!=0){
				sb.append(" and  info.AUTO_FAST_SETTLE_FLAG >0 ");
			}else{
				sb.append(" and  (info.AUTO_FAST_SETTLE_FLAG = 0 or info.AUTO_FAST_SETTLE_FLAG is null )");
			}
		}
		if (example.getCreateTimeStart() != null) {
			sb.append(" and  info.CREATE_TIME >= #{createTimeStart,jdbcType=TIMESTAMP} ");
		}
		if (example.getCreateTimeEnd() != null) {
			sb.append(" and  info.CREATE_TIME < #{createTimeEnd,jdbcType=TIMESTAMP} ");
		}
		// 商户
		if (StringUtils.isNotBlank(example.getMerchantType())) {
			sb.append(" and info.MC_TYPE = #{merchantType} ");
		}
		// 商户名称
		if (StringUtils.isNotBlank(example.getMerchantName())) {
			sb.append(" and info.MERCHANT_NAME like '%'||#{merchantName}||'%' ");
		}
		// 商户号
		if (StringUtils.isNotBlank(example.getMerchantNo())) {
			sb.append(" and info.MERCHANT_NO = #{merchantNo}");
		}
		// 拓展方-名称
		if (StringUtils.isNotBlank(example.getPromoterName())) {
			sb.append(" and info.PROMOTER_NAME like '%'||#{promoterName}||'%' ");
		}
		// 拓展方pos商户号
		if (StringUtils.isNotBlank(example.getPromoterMerchantNo())) {
			sb.append(" and info.PROMOTER_MERCHANT_NO= #{promoterMerchantNo} ");
		}
		// 限额
		if (example.getMaxLimitAmountStart() != null) {
			sb.append(" and info.MERCHANT_FS_LIMIT >= #{maxLimitAmountStart} ");
		}
		// 限额
		if (example.getMaxLimitAmountEnd() != null) {
			sb.append(" and info.MERCHANT_FS_LIMIT < #{maxLimitAmountEnd} ");
		}
		//是否开通快速结算
		if (StringUtils.isNotBlank(example.getMerchantFastSettleFlag())) {
			if(MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN.equals(example.getMerchantFastSettleFlag())){
				sb.append(" and info.PROMOTER_FS_FLAG = 1 ");
				sb.append(" and info.MERCHANT_FS_FLAG = 1 ");
			}else{
				sb.append(" and (NVL(info.PROMOTER_FS_FLAG,0) = 0 or NVL(info.MERCHANT_FS_FLAG,0) = 0) ");
			}
		}
		return sb.toString();
	}

	public String updateByPromoterId(Long promoterId) {
		BEGIN();
		UPDATE("tb_fast_settle_config t ");
		SET("t.auto_fast_settle=(select case when loaning_type=1 then 2 when loaning_type=0 then 1 else null end from mcredit.newt0_promoter where promoter_id=#{promoterId}) ");
		SET("t.update_time=sysdate ");
		StringBuilder sb = new StringBuilder();
		sb.append("exists( ");
		sb.append("select 1 from cm_pos_merchant pm ");
		sb.append("join cm_promoter cp on cp.pmt_id_n = pm.POSM_PROMOTER_ID_N and cp.pmt_fast_settle_flag=1 and pm.POSM_PROMOTER_ID_N=#{promoterId} ");
		sb.append("join mcredit.newt0_promoter np on np.promoter_id=pm.POSM_PROMOTER_ID_N ");
		sb.append("where ((t.auto_fast_settle=1 and np.loaning_type=1) or (t.auto_fast_settle=2 and np.loaning_type=0)) and t.obj_id=pm.posm_id_n ");
		sb.append(") ");
		WHERE(sb.toString());
		return SQL();
	}
}
