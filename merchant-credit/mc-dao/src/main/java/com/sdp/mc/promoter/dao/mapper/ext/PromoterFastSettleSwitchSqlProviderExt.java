package com.sdp.mc.promoter.dao.mapper.ext;

import org.apache.commons.lang.StringUtils;

import com.sdp.mc.promoter.dao.ext.PromoterFastSettleSwitchDOExampleExt;
import com.sdp.mc.promoter.dao.mapper.PromoterFastSettleSwitchSqlProvider;

public class PromoterFastSettleSwitchSqlProviderExt extends
		PromoterFastSettleSwitchSqlProvider {
	/**
	 * 根据Query对象分页查询代理商保证金追加/退回记录【MarginOpReqDO】对象列表信息
	 *
	 * @mbggenerated Mon Mar 30 13:57:53 CST 2015
	 */
	public String selectByQuery4Intra(
			PromoterFastSettleSwitchDOExampleExt example) {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		if (example != null && example.isDistinct()) {
			sb.append("distinct m.PFR_ID,");
		} else {
			sb.append("m.PFR_ID,");
		}
		sb.append("m.TYPE,");
		sb.append("m.STATUS,");
		sb.append("m.MARGIN_ACCOUNT,");
		sb.append("m.MAQ_ID,");
		sb.append("m.FCM_ID,");
		sb.append("m.CREATE_TIME,");
		sb.append("m.UPDATE_TIME,");
		sb.append("m.MARGIN_MEMBER_ID,");

		sb.append("cmc.MC_ID_N PROMOTER_ID,");
		sb.append("cmc.MC_MERCHANT_NO_V,");
		sb.append("cmc.MC_MERCHANT_NAME_V,");
		sb.append("cmc.MC_TYPE_C,");
		sb.append("p.PMT_FAST_SETTLE_FLAG ");
		sb.append("FROM TB_PROMOTER_FS_REQ m, CM_MERCHANT_CONTRACT cmc ,CM_PROMOTER p ");
		sb.append("WHERE p.PMT_ID_N = cmc.MC_ID_N");
		sb.append(" AND m.PROMOTER_ID(+)=cmc.MC_ID_N");
		sb.append(" AND cmc.MC_TYPE_C in('0003','0007') ");
		// 不通过cm_pos_merchant的posm_merchant_type_n字段表来判断是代理商还是商户而是通过mcType
		if (example != null) {
			if (example.getType() != null) {
				sb.append(" and  m.TYPE = #{type,jdbcType=DECIMAL} ");
			}

			if (example.getStatus() != null) {
				sb.append(" and  m.STATUS = #{status,jdbcType=DECIMAL} ");
			}

			if (example.getCreateTimeStart() != null) {
				sb.append(" and  m.CREATE_TIME >= #{createTimeStart,jdbcType=TIMESTAMP} ");
			}

			if (example.getCreateTimeEnd() != null) {
				sb.append(" and  m.CREATE_TIME < #{createTimeEnd,jdbcType=TIMESTAMP} ");
			}

			if (StringUtils.isNotBlank(example.getPromoterType())) {
				sb.append(" and cmc.MC_TYPE_C = #{promoterType} ");
			}

			if (StringUtils.isNotBlank(example.getPromoterName())) {
				sb.append(" and cmc.MC_MERCHANT_NAME_V like '%'||#{promoterName}||'%' ");
			}

			if (StringUtils.isNotBlank(example.getPromoterNo())) {
				sb.append(" and cmc.MC_MERCHANT_NO_V = #{promoterNo} ");
			}

			if (StringUtils.isNotBlank(example.getPromoterStatus())) {
				sb.append(" and cmc.MC_STATUS_C = #{promoterStatus} ");
			}
		}

		sb.append(" order by m.CREATE_TIME desc nulls last ");

		StringBuilder sqlStr = new StringBuilder();
		sqlStr.append("select t.* from (select tt.*, ROWNUM rnum from ( ");
		sqlStr.append(sb.toString());
		sqlStr.append(") tt) t where   t.rnum <= #{pageLastItem,jdbcType=NUMERIC}  and t.rnum >= #{pageFristItem,jdbcType=NUMERIC}");

		return sqlStr.toString();
	}

	public String countByExample4Intra(
			PromoterFastSettleSwitchDOExampleExt example) {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("count(cmc.MC_ID_N) ");
		sb.append("FROM TB_PROMOTER_FS_REQ m, CM_MERCHANT_CONTRACT cmc ,CM_PROMOTER p ");
		sb.append("WHERE p.PMT_ID_N = cmc.MC_ID_N");
		sb.append(" AND m.PROMOTER_ID(+)=cmc.MC_ID_N");
		sb.append(" AND cmc.MC_TYPE_C in('0003','0007') ");

		if (example.getType() != null) {
			sb.append(" and  m.TYPE = #{type,jdbcType=DECIMAL} ");
		}

		if (example.getStatus() != null) {
			sb.append(" and  m.STATUS = #{status,jdbcType=DECIMAL} ");
		}

		if (example.getCreateTimeStart() != null) {
			sb.append(" and  m.CREATE_TIME >= #{createTimeStart,jdbcType=TIMESTAMP} ");
		}

		if (example.getCreateTimeEnd() != null) {
			sb.append(" and  m.CREATE_TIME < #{createTimeEnd,jdbcType=TIMESTAMP} ");
		}

		if (StringUtils.isNotBlank(example.getPromoterType())) {
			sb.append(" and cmc.MC_TYPE_C = #{promoterType} ");
		}

		if (StringUtils.isNotBlank(example.getPromoterName())) {
			sb.append(" and cmc.MC_MERCHANT_NAME_V like '%'||#{promoterName}||'%' ");
		}

		if (StringUtils.isNotBlank(example.getPromoterNo())) {
			sb.append(" and cmc.MC_MERCHANT_NO_V = #{promoterNo} ");
		}

		if (StringUtils.isNotBlank(example.getPromoterStatus())) {
			sb.append(" and cmc.MC_STATUS_C = #{promoterStatus} ");
		}

		return sb.toString();
	}

	@Deprecated
	public String selectByQueryAuditInfo(
			PromoterFastSettleSwitchDOExampleExt example) {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		if (example != null && example.isDistinct()) {
			sb.append("distinct m.PFR_ID,");
		} else {
			sb.append("m.PFR_ID,");
		}
		sb.append("m.TYPE,");
		sb.append("m.STATUS,");
		sb.append("m.MARGIN_ACCOUNT,");
		sb.append("m.MAQ_ID,");
		sb.append("m.FCM_ID,");
		sb.append("m.CREATE_TIME,");
		sb.append("m.UPDATE_TIME,");
		sb.append("m.MARGIN_MEMBER_ID,");

		sb.append("cmc.MC_ID_N PROMOTER_ID,");
		sb.append("cmc.MC_MERCHANT_NO_V,");
		sb.append("cmc.MC_MERCHANT_NAME_V,");
		sb.append("cmc.MC_TYPE_C,");
		sb.append("p.PMT_FAST_SETTLE_FLAG,");
		sb.append("p.PMT_FAST_SETTLE_LIMIT,");
		sb.append("np.LOANING_TYPE,");
		sb.append("case when exists(select ai.STATUS from NEWT0_AUDIT_INFO ai where m.PROMOTER_ID=ai.OBJ_ID AND ai.STATUS in('1','2')) then 1 end as audit_status ");
		sb.append("FROM mcredit.TB_PROMOTER_FS_REQ m LEFT JOIN view_promoter_info np");
		sb.append("ON M.PROMOTER_ID = np.promoter_id AND  ");
		sb.append("where np.PROMOTER_TYPE IN ('0003', '0007') ");

		// 不通过cm_pos_merchant的posm_merchant_type_n字段表来判断是代理商还是商户而是通过mcType
		if (example != null) {
			if (example.getType() != null) {
				sb.append(" and  m.TYPE = #{type,jdbcType=DECIMAL} ");
			}

			if (example.getStatus() != null) {
				sb.append(" and  m.STATUS = #{status,jdbcType=DECIMAL} ");
			}

			if (example.getCreateTimeStart() != null) {
				sb.append(" and  m.CREATE_TIME >= #{createTimeStart,jdbcType=TIMESTAMP} ");
			}

			if (example.getCreateTimeEnd() != null) {
				sb.append(" and  m.CREATE_TIME < #{createTimeEnd,jdbcType=TIMESTAMP} ");
			}

			if (StringUtils.isNotBlank(example.getPromoterType())) {
				sb.append(" and cmc.MC_TYPE_C = #{promoterType} ");
			}

			if (StringUtils.isNotBlank(example.getPromoterName())) {
				sb.append(" and cmc.MC_MERCHANT_NAME_V like '%'||#{promoterName}||'%' ");
			}

			if (StringUtils.isNotBlank(example.getPromoterNo())) {
				sb.append(" and cmc.MC_MERCHANT_NO_V = #{promoterNo} ");
			}

			if (StringUtils.isNotBlank(example.getPromoterStatus())) {
				sb.append(" and cmc.MC_STATUS_C = #{promoterStatus} ");
			}

			if (example.getAuditStatus() != null) {// 查询在待审核或审核中的记录
				sb.append(" and exists(select ai.STATUS from NEWT0_AUDIT_INFO ai where m.PROMOTER_ID=ai.OBJ_ID AND ai.STATUS in('1','2')) ");
			}
		}
		sb.append(" order by audit_status desc nulls last,m.type,m.CREATE_TIME desc nulls last ");

		StringBuilder sqlStr = new StringBuilder();
		sqlStr.append("select t.* from (select tt.*, ROWNUM rnum from ( ");
		sqlStr.append(sb.toString());
		sqlStr.append(") tt) t where   t.rnum <= #{pageLastItem,jdbcType=NUMERIC}  and t.rnum >= #{pageFristItem,jdbcType=NUMERIC}");

		return sqlStr.toString();
	}

	@Deprecated
	public String countByExampleAuditInfo(
			PromoterFastSettleSwitchDOExampleExt example) {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("count(cmc.MC_ID_N) ");
		sb.append("FROM TB_PROMOTER_FS_REQ m ");
		sb.append("join CM_MERCHANT_CONTRACT cmc on m.PROMOTER_ID=cmc.MC_ID_N and cmc.MC_TYPE_C in('0003','0007') ");
		sb.append("join CM_PROMOTER p on p.PMT_ID_N = cmc.MC_ID_N ");
		sb.append("left join NEWT0_PROMOTER np on cmc.mc_id_n= np.promoter_id ");
		sb.append("where cmc.MC_TYPE_C in('0003','0007') ");

		if (example.getType() != null) {
			sb.append(" and  m.TYPE = #{type,jdbcType=DECIMAL} ");
		}

		if (example.getStatus() != null) {
			sb.append(" and  m.STATUS = #{status,jdbcType=DECIMAL} ");
		}

		if (example.getCreateTimeStart() != null) {
			sb.append(" and  m.CREATE_TIME >= #{createTimeStart,jdbcType=TIMESTAMP} ");
		}

		if (example.getCreateTimeEnd() != null) {
			sb.append(" and  m.CREATE_TIME < #{createTimeEnd,jdbcType=TIMESTAMP} ");
		}

		if (StringUtils.isNotBlank(example.getPromoterType())) {
			sb.append(" and cmc.MC_TYPE_C = #{promoterType} ");
		}

		if (StringUtils.isNotBlank(example.getPromoterName())) {
			sb.append(" and cmc.MC_MERCHANT_NAME_V like '%'||#{promoterName}||'%' ");
		}

		if (StringUtils.isNotBlank(example.getPromoterNo())) {
			sb.append(" and cmc.MC_MERCHANT_NO_V = #{promoterNo} ");
		}

		if (StringUtils.isNotBlank(example.getPromoterStatus())) {
			sb.append(" and cmc.MC_STATUS_C = #{promoterStatus} ");
		}

		if (example.getAuditStatus() != null) {// 查询在待审核或审核中的记录
			sb.append(" and exists(select ai.STATUS from NEWT0_AUDIT_INFO ai where m.PROMOTER_ID=ai.OBJ_ID AND ai.STATUS in('1','2')) ");
		}

		return sb.toString();
	}

	/**
	 * POS商户
	 * 查询盛付通全资已开通快速结算商户号
	 *
	 * @return
	 */
	public String getPosOpenFastSettleMerchantIds() {
		StringBuilder sb = new StringBuilder();
//		sb.append("select m.MC_ID_N,m.MC_MERCHANT_NO_V,m.MC_TYPE_C,cmp.PMT_ID_N ");
//		sb.append("FROM cm_pos_merchant P ");
//		sb.append("INNER JOIN cm_merchant_contract M ON P.posm_id_n = M.mc_id_n ");// 商户号
//		sb.append("inner join merchant_settle ms on ms.merchant_no = m.mc_merchant_no_v ");// 商户开通快速结算
//		sb.append("inner join newt0_promoter nt0 on nt0.PROMOTER_ID = P.POSM_PROMOTER_ID_N ");
//		sb.append("INNER JOIN cm_promoter cmp ON cmp.PMT_ID_N = p.POSM_PROMOTER_ID_N ");
//		sb.append("where ms.fast_settle_flag = 1 ");// 开通快速结算商户
//		sb.append("and cmp.PMT_FAST_SETTLE_FLAG = 1 ");// 开通快速结算代理商
//		sb.append("and nt0.loaning_type = 1 ");// 盛付通全资
//		sb.append("and m.mc_status_c='3' ");// 合同有效
		sb.append("SELECT MI.POS_MERCHANT_ID MERCHANT_ID,MI.MERCHANT_NO MERCHANT_NO,MI.MERCHANT_TYPE MC_TYPE,PI.POS_MERCHANT_ID PROMOTER_ID ");
		sb.append("FROM MCREDIT.FW_POS_MERCHANT_INFO mi,MCREDIT.FW_POS_MERCHANT_INFO pi ");
		sb.append("WHERE MI.PARENT_PROMOTER_ID=PI.ID ");
		sb.append("and MI.MERCHANT_TYPE in('0001') " );// POS商户
		sb.append("and MI.FAST_SETTLE_FLAG = 1 ");
		sb.append("and PI.FAST_SETTLE_FLAG = 1 ");// 开通快速结算代理商
		sb.append("and PI.LOANING_TYPE = 1 "); // 盛付通全资
		sb.append("and MI.STATUS = 3 ");
		sb.append("and PI.STATUS= 3 ");// 合同有效
		return sb.toString();
	}

	/**
	 * 查询所有开通快速结算的代理商id
	 */
	public String getPromoters(Integer loaningType) {
		StringBuilder sb = new StringBuilder();
		sb.append("select  PI.POS_MERCHANT_ID  PMT_ID_N, PI.MERCHANT_NO  PROMOTER_MERCHANT_NO,PI.MERCHANT_TYPE MC_TYPE_C,PI.MERCHANT_NAME MC_MERCHANT_NAME_V,PI.LOANING_TYPE   loaning_type ");
		sb.append(" from MCREDIT.FW_POS_MERCHANT_INFO pi ");
		sb.append(" where PI.STATUS = '3' ");
		sb.append(" and PI.FAST_SETTLE_FLAG = 1  ");
		sb.append(" and PI.FAST_SETTLE_LIMIT>0 ");
		sb.append("  and PI.MERCHANT_TYPE in ('0003','0007','0101') ");
		if (loaningType != null) {
			sb.append("and PI.LOANING_TYPE = ");
			sb.append(loaningType);
		}
		return sb.toString();
	}

	/**
	 * 查询已开通快速结算商户号
	 *
	 * @return
	 */
	public String getAllPosAndMposOpenFastSettleMerchants() {
		StringBuilder sb = new StringBuilder();
		sb.append("select P.MERCHANT_ID MC_ID_N,P.MERCHANT_NO MC_MERCHANT_NO_V,P.MERCHANT_PHONE_NO HAND_POHNE_NO,P.PROMOTER_ID POSM_PROMOTER_ID_N,P.LOANING_TYPE loaning_type,P.MC_TYPE MC_TYPE_C ");
		sb.append("FROM MCREDITUSER.VIEW_MERCHANT_INFO P  ");
		sb.append(" where P.MERCHANT_FS_FLAG = 1 ");
		sb.append(" and P.MERCHANT_FS_LIMIT>0 ");
		sb.append(" and P.PROMOTER_FS_FLAG = 1 ");
		sb.append(" and P.PROMOTER_FS_LIMIT>0 ");
		sb.append(" and P.MC_TYPE in('0001','0006') ");
		sb.append(" and P.MERCHANT_PHONE_NO is not null");// 手机号不能为空
		return sb.toString();
	}
}
