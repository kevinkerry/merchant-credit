package com.sdp.withdraw.dao.mapper.ext;

import com.sdp.withdraw.dao.mapper.WithdrawReqFosDetailSqlProvider;


public class ExtWithdrawReqFosDetailSqlProvider extends WithdrawReqFosDetailSqlProvider {

	public String queryCallbackTimeoutData(int callbackTimeoutMinute) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT detail.* ");
		sb.append("FROM MCREDIT.FW_WITHDRAW_REQ_FOS_DETAIL detail, MCREDIT.FW_WITHDRAW_REQ req ");
		sb.append("WHERE DETAIL.REQ_ID = REQ.REQ_ID AND DETAIL.WITHDRAW_STATUS = '2' ");
		sb.append("AND ( (REQ.WITHDRAW_TYPE = 1 AND DETAIL.GMT_BIZ_INITIATE + "+callbackTimeoutMinute+"/1440<sysdate) ");
		sb.append("OR (REQ.WITHDRAW_TYPE = 2 AND  trunc(DETAIL.GMT_BIZ_INITIATE +1)<=trunc(sysdate))) ");
		sb.append("order by DETAIL.GMT_BIZ_INITIATE asc");
		return sb.toString();
	}
}