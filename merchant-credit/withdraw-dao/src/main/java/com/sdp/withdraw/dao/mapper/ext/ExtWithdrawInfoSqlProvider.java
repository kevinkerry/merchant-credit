package com.sdp.withdraw.dao.mapper.ext;

import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.List;

import com.sdp.withdraw.dao.WithdrawInfoDOExample;
import com.sdp.withdraw.dao.WithdrawInfoDOExample.Criteria;
import com.sdp.withdraw.dao.WithdrawInfoDOExample.Criterion;
import com.sdp.withdraw.dao.mapper.WithdrawInfoSqlProvider;

public class ExtWithdrawInfoSqlProvider extends WithdrawInfoSqlProvider {

	/**
	 * 加数据库锁 查询
	 * 
	 * @param example
	 * @return
	 */
	public String selectWithdrawInfoDOForUpdate(WithdrawInfoDOExample example) {
		return selectWithdrawInfo(example, true);
	}

	public String selectWithdrawInfoByExample(WithdrawInfoDOExample example) {
		return selectWithdrawInfo(example, false);
	}

	public String repairWithdrawData() {
		StringBuilder sb = new StringBuilder();
		sb.append(" update MCREDIT.FW_WITHDRAW_REQ req  ");
		sb.append(" set REQ.MCC=(select m.mcc from MCREDIT.FW_POS_MERCHANT_INFO m where M.MERCHANT_NO=req.merchant_no and M.MERCHANT_TYPE=REQ.MC_TYPE)  ");
		sb.append(" , REQ.LAST_LEVEL_PROMOTER_ID=(select M.LAST_LEVEL_PROMOTER_ID from MCREDIT.FW_POS_MERCHANT_INFO m where M.MERCHANT_NO=req.merchant_no and M.MERCHANT_TYPE=REQ.MC_TYPE) ");
		sb.append(" , REQ.MERCHANT_BIZ_ID=(select m.id from MCREDIT.FW_POS_MERCHANT_INFO m where M.MERCHANT_NO=req.merchant_no and M.MERCHANT_TYPE=REQ.MC_TYPE)  ");
		sb.append(" where REQ.MERCHANT_BIZ_ID is null ");
		return sb.toString();
	}

	public String selectWithdrawInfo(WithdrawInfoDOExample example, boolean isForUpdate) {
		StringBuilder sb = new StringBuilder();
		sb.append("select * from FW_WITHDRAW_INFO info ");
		StringBuilder where = new StringBuilder();
		if (example == null) { return sb.toString(); }
		String parmPhrase1;
		String parmPhrase1_th;
		String parmPhrase2;
		String parmPhrase2_th;
		String parmPhrase3;
		String parmPhrase3_th;
		parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
		parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
		parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
		parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
		parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
		parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";

		List<Criteria> oredCriteria = example.getOredCriteria();
		boolean firstCriteria = true;
		for (int i = 0; i < oredCriteria.size(); i++) {
			Criteria criteria = oredCriteria.get(i);
			if (criteria.isValid()) {
				if (firstCriteria) {
					firstCriteria = false;
				} else {
					where.append(" or ");
				}

				where.append('(');
				List<Criterion> criterions = criteria.getAllCriteria();
				boolean firstCriterion = true;
				for (int j = 0; j < criterions.size(); j++) {
					Criterion criterion = criterions.get(j);
					if (firstCriterion) {
						firstCriterion = false;
					} else {
						where.append(" and ");
					}

					if (criterion.isNoValue()) {
						where.append(criterion.getCondition());
					} else if (criterion.isSingleValue()) {
						if (criterion.getTypeHandler() == null) {
							where.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
						} else {
							where.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j, criterion.getTypeHandler()));
						}
					} else if (criterion.isBetweenValue()) {
						if (criterion.getTypeHandler() == null) {
							where.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
						} else {
							where.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j,
									criterion.getTypeHandler()));
						}
					} else if (criterion.isListValue()) {
						where.append(criterion.getCondition());
						where.append(" (");
						List<?> listItems = (List<?>) criterion.getValue();
						boolean comma = false;
						for (int k = 0; k < listItems.size(); k++) {
							if (comma) {
								where.append(", ");
							} else {
								comma = true;
							}
							if (criterion.getTypeHandler() == null) {
								where.append(String.format(parmPhrase3, i, j, k));
							} else {
								where.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
							}
						}
						where.append(')');
					}
				}
				where.append(')');
			}
		}

		if (where.length() == 0) {
			where.append(" (1=1) ");
		}
		if (example.getBizId() != null) {
			where.append(" and info.BIZ_ID	= " + example.getBizId());
		}
		if (isForUpdate) {
			where.append(" for update ");
		}
		sb.append("where " + where.toString());
		return sb.toString();
	}

}
