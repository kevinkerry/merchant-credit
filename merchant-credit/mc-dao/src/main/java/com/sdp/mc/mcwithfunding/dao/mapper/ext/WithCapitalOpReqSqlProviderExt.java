package com.sdp.mc.mcwithfunding.dao.mapper.ext;

import org.apache.commons.lang.StringUtils;

import com.sdp.mc.mcwithfunding.dao.ext.WithCapitalReqDOExampleExt;
import com.sdp.mc.mcwithfunding.dao.mapper.WithCapital4PromoterSqlProvider;

public class WithCapitalOpReqSqlProviderExt extends WithCapital4PromoterSqlProvider {
	/**
	 * 根据Query对象分页查询代理商t+0配资记录【WithCapital4PromoterDO】对象列表信息
	 *
	 * @mbggenerated Mon Mar 30 13:57:53 CST 2015
	 */
	public String selectByQuery4Intra(WithCapitalReqDOExampleExt example) {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		if (example != null && example.isDistinct()) {
			sb.append("distinct m.id,");
		} else {
			sb.append("m.id,");
		}
		sb.append("m.MC_TYPE,");
		sb.append("m.PROMOTER_ID,");
		sb.append("m.MERCHANT_NO,");
		sb.append("m.PROMOTER_NAME,");
		sb.append("m.APPLY_DATETIME,");
		sb.append("m.AMOUNT,");
		sb.append("m.FEE_RATIO,");
		sb.append("m.FEE,");
		sb.append("m.CREDIT_FOS_ID,");
		sb.append("m.CREDIT_CHANGE_ID,");
		sb.append("m.REVERSAL_FOS_ID,");
		sb.append("m.REVERSAL_CHANGE_ID,");
		sb.append("m.STATUS,");
		sb.append("m.UPDATE_TIME,");
		sb.append("m.BATCH_NO,");
		sb.append("m.FEE_FOS_ID,");
		sb.append("m.RECOVERY_DATE,");
		sb.append("m.RETRY_TIMES_4MSP ");

		sb.append(" from MC_WITH_CAPITAL_4PROMOTER m ");
		sb.append(" where 1=1 ");

		if(example!=null){
			if (StringUtils.isNotBlank(example.getPromoterType())) {
				sb.append(" and m.MC_TYPE = #{promoterType} ");
			}

			if (StringUtils.isNotBlank(example.getPromoterName())) {
				sb.append(" and m.PROMOTER_NAME like '%'||#{promoterName}||'%' ");
			}

			if (StringUtils.isNotBlank(example.getPromoterNo())) {
				sb.append(" and m.MERCHANT_NO = #{promoterNo} ");
			}

			if (example.getCreateTimeStart() != null) {
				sb.append(" and  m.APPLY_DATETIME >= #{createTimeStart,jdbcType=TIMESTAMP} ");
			}

			if (example.getCreateTimeEnd() != null) {
				sb.append(" and  m.APPLY_DATETIME < #{createTimeEnd,jdbcType=TIMESTAMP} ");
			}

			if (example.getStatus() != null) {
				sb.append(" and  m.STATUS = #{status,jdbcType=DECIMAL} ");
			}
		}
		sb.append(" order by m.APPLY_DATETIME desc ");

		StringBuilder sqlStr = new StringBuilder();
		sqlStr.append("select t.* from (select tt.*, ROWNUM rnum from ( ");
		sqlStr.append(sb.toString());
		sqlStr.append(") tt) t where   t.rnum <= #{pageLastItem,jdbcType=NUMERIC}  and t.rnum >= #{pageFristItem,jdbcType=NUMERIC}");

		return sqlStr.toString();
	}

	public String countByExample4Intra(WithCapitalReqDOExampleExt example) {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("count(m.id) ");
		sb.append(" from MC_WITH_CAPITAL_4PROMOTER m ");
		sb.append(" where 1=1 ");

		if (StringUtils.isNotBlank(example.getPromoterType())) {
			sb.append(" and m.MC_TYPE = #{promoterType} ");
		}

		if (StringUtils.isNotBlank(example.getPromoterName())) {
			sb.append(" and m.PROMOTER_NAME like '%'||#{promoterName}||'%' ");
		}

		if (StringUtils.isNotBlank(example.getPromoterNo())) {
			sb.append(" and m.MERCHANT_NO = #{promoterNo} ");
		}

		if (example.getCreateTimeStart() != null) {
			sb.append(" and  m.APPLY_DATETIME >= #{createTimeStart,jdbcType=TIMESTAMP} ");
		}

		if (example.getCreateTimeEnd() != null) {
			sb.append(" and  m.APPLY_DATETIME < #{createTimeEnd,jdbcType=TIMESTAMP} ");
		}

		if (example.getStatus() != null) {
			sb.append(" and  m.STATUS = #{status,jdbcType=DECIMAL} ");
		}

		return sb.toString();
	}
}