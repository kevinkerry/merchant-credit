package com.sdp.mc.margin.dao.mapper.ext;

import org.apache.commons.lang.StringUtils;

import com.sdp.mc.common.enums.LoanStatusEnums;
import com.sdp.mc.margin.dao.ext.MarginOpReqDOExampleExt;
import com.sdp.mc.margin.dao.ext.RedeemedMarginApplyExampleExt;
import com.sdp.mc.margin.dao.mapper.MarginOpReqSqlProvider;

public class MarginOpReqSqlProviderExt extends MarginOpReqSqlProvider {
	/**
	 * 根据Query对象分页查询代理商保证金追加/退回记录【MarginOpReqDO】对象列表信息
	 *
	 * @mbggenerated Mon Mar 30 13:57:53 CST 2015
	 */
	public String selectByQuery4Intra(MarginOpReqDOExampleExt example) {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		if (example != null && example.isDistinct()) {
			sb.append("distinct m.MOR_ID,");
		} else {
			sb.append("m.MOR_ID,");
		}
		sb.append("m.PROMOTER_ID,");
		sb.append("m.OP_TYPE,");
		sb.append("m.STATUS,");
		sb.append("m.AMOUNT,");
		sb.append("m.REDEEMED_TIME,");
		sb.append("m.MT_ID,");
		sb.append("m.MT_ID_HIS,");
		sb.append("m.FCM_ID,");
		sb.append("m.FCM_ID_HIS,");
		sb.append("m.CREATE_TIME,");
		sb.append("m.UPDATE_TIME,");

		sb.append("CMC.PROMOTER_MERCHANT_NO MC_MERCHANT_NO_V,");
		sb.append("CMC.PROMOTER_NAME MC_MERCHANT_NAME_V,");
		sb.append("CMC.PROMOTER_TYPE MC_TYPE_C,");
		sb.append("p.STATUS PSTATUS ");
		sb.append("from TB_MARGIN_OP_REQ m,MCREDITUSER.VIEW_PROMOTER_INFO cmc,TB_PROMOTER_FS_REQ p ");
		sb.append("where m.PROMOTER_ID=CMC.PROMOTER_ID AND p.PROMOTER_ID=m.PROMOTER_ID ");
		if(example!=null){
			if (example.getOpType() != null) {
				sb.append(" and  m.OP_TYPE = #{opType,jdbcType=DECIMAL} ");
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
				sb.append(" and CMC.PROMOTER_TYPE = #{promoterType} ");
			}

			if (StringUtils.isNotBlank(example.getPromoterName())) {
				sb.append(" and CMC.PROMOTER_NAME like '%'||#{promoterName}||'%' ");
			}

			if (StringUtils.isNotBlank(example.getPromoterNo())) {
				sb.append(" and CMC.PROMOTER_MERCHANT_NO = #{promoterNo} ");
			}

			if (StringUtils.isNotBlank(example.getPromoterStatus())) {
//				sb.append(" and cmc.MC_STATUS_C in (#{promoterStatus}) ");
			}
		}
		sb.append(" order by m.CREATE_TIME desc ");

		StringBuilder sqlStr = new StringBuilder();
		sqlStr.append("select t.* from (select tt.*, ROWNUM rnum from ( ");
		sqlStr.append(sb.toString());
		sqlStr.append(") tt) t where   t.rnum <= #{pageLastItem,jdbcType=NUMERIC}  and t.rnum >= #{pageFristItem,jdbcType=NUMERIC}");

		return sqlStr.toString();
	}

	public String countByExample4Intra(MarginOpReqDOExampleExt example) {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("count(m.MOR_ID) ");
		sb.append("from TB_MARGIN_OP_REQ m,MCREDITUSER.VIEW_PROMOTER_INFO cmc,TB_PROMOTER_FS_REQ p ");
		sb.append("where m.PROMOTER_ID=CMC.PROMOTER_ID AND p.PROMOTER_ID=m.PROMOTER_ID ");

		if (example.getOpType() != null) {
			sb.append(" and  m.OP_TYPE = #{opType,jdbcType=DECIMAL} ");
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
			sb.append(" and CMC.PROMOTER_TYPE = #{promoterType} ");
		}

		if (StringUtils.isNotBlank(example.getPromoterName())) {
			sb.append(" and CMC.PROMOTER_NAME like '%'||#{promoterName}||'%' ");
		}

		if (StringUtils.isNotBlank(example.getPromoterNo())) {
			sb.append(" and CMC.PROMOTER_MERCHANT_NO = #{promoterNo} ");
		}


		return sb.toString();
	}

	/**
	 * 统计所有页面申请取回合计金额
	 *
	 * @param example
	 * @return
	 */
	public String totalAmountByNewT0AuditingExample4Intra(MarginOpReqDOExampleExt example) {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("SUM(m.AMOUNT) ");
		sb.append("from TB_MARGIN_OP_REQ m,MCREDITUSER.VIEW_PROMOTER_INFO cmc ,TB_PROMOTER_FS_REQ p ");
		sb.append("where m.PROMOTER_ID=cmc.PROMOTER_ID AND p.PROMOTER_ID=m.PROMOTER_ID ");

		if (example.getOpType() != null) {
			sb.append(" and  m.OP_TYPE = #{opType,jdbcType=DECIMAL} ");
		}

		if (example.getStatus() != null) {
			sb.append(" and  m.STATUS = #{status,jdbcType=DECIMAL} ");
		} else {
			sb.append(" and  m.STATUS in (" + LoanStatusEnums.LOAN_FAILURE.code + "," + LoanStatusEnums.LOAN_INIT.code + "," + LoanStatusEnums.LOAN_REFUSE.code + ","
					+ LoanStatusEnums.LOAN_SUCCESS.code + ") ");
		}

		// 查询预计到账日期时间段
		if (example.getRedeemedTimeStr() != null && example.getRedeemedTimeEnd() != null) {
			sb.append(" and m.REDEEMED_TIME BETWEEN #{redeemedTimeStr,jdbcType=TIMESTAMP} AND #{redeemedTimeEnd,jdbcType=TIMESTAMP}");
		}

		// 查询申请日期时间段
		if (example.getCreateTimeStart() != null && example.getCreateTimeEnd() != null) {
			sb.append(" and m.CREATE_TIME BETWEEN #{createTimeStart,jdbcType=TIMESTAMP} AND #{createTimeEnd,jdbcType=TIMESTAMP}");
		}

		if (StringUtils.isNotBlank(example.getPromoterType())) {
			sb.append(" and CMC.PROMOTER_TYPE = #{promoterType} ");
		}

		if (StringUtils.isNotBlank(example.getPromoterName())) {
			sb.append(" and CMC.PROMOTER_NAME like '%'||#{promoterName}||'%' ");
		}

		if (StringUtils.isNotBlank(example.getPromoterNo())) {
			sb.append(" and CMC.PROMOTER_MERCHANT_NO = #{promoterNo} ");
		}


		return sb.toString();
	}

	/**
	 * 取回保证金审核列表 取配资成功商户列表
	 *
	 * @param example
	 * @return
	 */
	public String selectByNewT0AuditingQuery4Intra(RedeemedMarginApplyExampleExt example) {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		if (example != null && example.isDistinct()) {
			sb.append("distinct m.MOR_ID,");
		} else {
			sb.append("m.MOR_ID,");
		}
		sb.append("m.PROMOTER_ID,");
		sb.append("m.OP_TYPE,");
		sb.append("m.STATUS,");
		sb.append("m.AMOUNT,");
		sb.append("m.REDEEMED_TIME,");
		sb.append("m.MT_ID,");
		sb.append("m.MT_ID_HIS,");
		sb.append("m.FCM_ID,");
		sb.append("m.FCM_ID_HIS,");
		sb.append("m.CREATE_TIME,");
		sb.append("m.UPDATE_TIME,");
		sb.append("ur.REALNAME,");
		sb.append("ur.OPERA_TIME,");
		sb.append("CMC.PROMOTER_MERCHANT_NO MC_MERCHANT_NO_V,");
		sb.append("CMC.PROMOTER_NAME MC_MERCHANT_NAME_V,");
		sb.append("CMC.PROMOTER_TYPE MC_TYPE_C,");
		sb.append("p.STATUS PSTATUS,");
		sb.append("p.MARGIN_MEMBER_ID ");
		sb.append("from TB_MARGIN_OP_REQ m,MCREDITUSER.VIEW_PROMOTER_INFO cmc,TB_PROMOTER_FS_REQ p ,NEWT0_USEROPERA_RECORD ur ");
		sb.append("where m.PROMOTER_ID= CMC.PROMOTER_ID AND p.PROMOTER_ID=m.PROMOTER_ID AND M.MOR_ID=ur.BIZ_ID(+) ");
		if(example!=null){
			if (example.getOpType() != null) {
				sb.append(" and  m.OP_TYPE = #{opType,jdbcType=DECIMAL} ");
			}

			if (example.getStatus() != null) {
				sb.append(" and  m.STATUS = #{status,jdbcType=DECIMAL} ");
			} else {
				sb.append(" and  m.STATUS in (" + LoanStatusEnums.LOAN_FAILURE.code + "," + LoanStatusEnums.LOAN_INIT.code + "," + LoanStatusEnums.LOAN_REFUSE.code + ","
						+ LoanStatusEnums.LOAN_SUCCESS.code + ") ");
			}

			// 查询预计到账日期时间段
			if (example.getRedeemedTimeEnd() != null) {
				sb.append(" and m.REDEEMED_TIME <= #{redeemedTimeEnd,jdbcType=TIMESTAMP}");
			}

			// 查询申请日期时间段
			if (example.getCreateTimeStart() != null && example.getCreateTimeEnd() != null) {
				sb.append(" and m.CREATE_TIME BETWEEN #{createTimeStart,jdbcType=TIMESTAMP} AND #{createTimeEnd,jdbcType=TIMESTAMP}");
			}

			if (StringUtils.isNotBlank(example.getPromoterType())) {
				sb.append(" and CMC.PROMOTER_TYPE = #{promoterType} ");
			}

			if (StringUtils.isNotBlank(example.getPromoterName())) {
				sb.append(" and CMC.PROMOTER_NAME like '%'||#{promoterName}||'%' ");
			}

			if (StringUtils.isNotBlank(example.getPromoterNo())) {
				sb.append(" and CMC.PROMOTER_MERCHANT_NO = #{promoterNo} ");
			}

		}
		sb.append(" order by m.CREATE_TIME desc ");

		StringBuilder sqlStr = new StringBuilder();
		sqlStr.append("select t.* from (select tt.*, ROWNUM rnum from ( ");
		sqlStr.append(sb.toString());
		sqlStr.append(") tt) t where   t.rnum <= #{pageLastItem,jdbcType=NUMERIC}  and t.rnum >= #{pageFristItem,jdbcType=NUMERIC}");

		return sqlStr.toString();
	}

	/**
	 * 查询总数量
	 *
	 * @param example
	 * @return
	 */
	public String countByNewT0AuditingExample4Intra(RedeemedMarginApplyExampleExt example) {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("count(m.MOR_ID) ");
		sb.append("from TB_MARGIN_OP_REQ m,MCREDITUSER.VIEW_PROMOTER_INFO cmc ,TB_PROMOTER_FS_REQ p ,NEWT0_USEROPERA_RECORD ur ");
		sb.append("where m.PROMOTER_ID=cmc.PROMOTER_ID AND p.PROMOTER_ID=m.PROMOTER_ID AND M.MOR_ID=ur.BIZ_ID(+) AND ur.BIZ_TYPE = 4 ");

		if (example.getOpType() != null) {
			sb.append(" and  m.OP_TYPE = #{opType,jdbcType=DECIMAL} ");
		}

		if (example.getStatus() != null) {
			sb.append(" and  m.STATUS = #{status,jdbcType=DECIMAL} ");
		} else {
			sb.append(" and  m.STATUS in (" + LoanStatusEnums.LOAN_FAILURE.code + "," + LoanStatusEnums.LOAN_INIT.code + "," + LoanStatusEnums.LOAN_REFUSE.code + ","
					+ LoanStatusEnums.LOAN_SUCCESS.code + ") ");
		}

		// 查询预计到账日期时间段
		if (example.getRedeemedTimeStr() != null && example.getRedeemedTimeEnd() != null) {
			sb.append(" and m.REDEEMED_TIME BETWEEN #{redeemedTimeStr,jdbcType=TIMESTAMP} AND #{redeemedTimeEnd,jdbcType=TIMESTAMP}");
		}

		// 查询申请日期时间段
		if (example.getCreateTimeStart() != null && example.getCreateTimeEnd() != null) {
			sb.append(" and m.CREATE_TIME BETWEEN #{createTimeStart,jdbcType=TIMESTAMP} AND #{createTimeEnd,jdbcType=TIMESTAMP}");
		}

		if (StringUtils.isNotBlank(example.getPromoterType())) {
			sb.append(" and CMC.PROMOTER_TYPE = #{promoterType} ");
		}

		if (StringUtils.isNotBlank(example.getPromoterName())) {
			sb.append(" and CMC.PROMOTER_NAME like '%'||#{promoterName}||'%' ");
		}

		if (StringUtils.isNotBlank(example.getPromoterNo())) {
			sb.append(" and CMC.PROMOTER_MERCHANT_NO = #{promoterNo} ");
		}


		return sb.toString();
	}
}