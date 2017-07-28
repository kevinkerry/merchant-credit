package com.sdp.withdraw.dao.mapper.ext;

import org.apache.commons.lang.StringUtils;

import com.sdp.withdraw.dao.ext.ExtWalletWithdrawReqDTO;
import com.sdp.withdraw.dao.ext.ExtWithdrawReqDOExample;
import com.sdp.withdraw.dao.mapper.WithdrawReqSqlProvider;

/**
 * 出款sqlProvider扩展
 * 
 * @author liyantao
 *
 */
public class ExtWalletWithdrawReqSqlProvider {
	/**
	 * 根据Query对象分页查询出款列表信息
	 * 
	 * @param example
	 * @return
	 */
	public String selectWalletWithdrawByQuery(ExtWalletWithdrawReqDTO dto) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT WWR.*, ");
		sb.append("WR.APPLY_TIME, ");
		sb.append("WR.WITHDRAW_TYPE, ");
		sb.append("WR.SERVICE_TYPE, ");
		sb.append("WR.WITHDRAW_FEE, ");
		sb.append("WR.WITHDRAW_COST, ");
		sb.append("WR.WD_COST, ");
		sb.append("WR.ERROR_CODE RETURN_CODE, ");
		sb.append("WR.ERROR_MSG RETURN_MSG, ");
		sb.append("WRFD.BANK_NAME, ");
		sb.append("WRFD.PAYEE_NAME NAME, ");
		sb.append("WRFD.PAYEE_CARD_NO CART_NO, ");
		sb.append("WRFD.REMIT_VOUCHER_NO ");
		sb.append("FROM MCREDIT.FW_WALLET_WITHDRAW_REQ wwr ");
		sb.append("LEFT JOIN MCREDIT.FW_WITHDRAW_REQ wr ");
		sb.append("ON WWR.TRACE_NO = WR.REQ_ID ");
		sb.append("LEFT JOIN MCREDIT.FW_WITHDRAW_REQ_FOS_DETAIL wrfd ");
		sb.append("ON WRFD.REQ_ID = WWR.TRACE_NO ");
		sb.append("where 1 = 1 ");

		if (null != dto.getReqId()) {
			sb.append(" and  wwr.req_id = #{reqId}");
		}
		if (StringUtils.isNotBlank(dto.getOrderNo())) {
			sb.append(" and  wwr.order_no = #{orderNo}");
		}
		if (dto.getTraceNo() != null) {
			sb.append(" and  wwr.TRACE_NO = #{traceNo} ");
		}
		if (dto.getStatus() != null) {
			sb.append(" and  wwr.status = #{status} ");
		}
		if (dto.getWithdrawType() != null) {
			sb.append(" and  wr.withdraw_type = #{withdrawType} ");
		}
		if (StringUtils.isNotBlank(dto.getMemberNo())) {
			sb.append(" and  wwr.member_no = #{memberNo} ");
		}

		if (dto.getStartTime() != null) {
			sb.append(" and  wwr.create_time >= #{startTime,jdbcType=TIMESTAMP} ");
		}
		if (dto.getEndTime() != null) {
			sb.append(" and  wwr.create_time < #{endTime,jdbcType=TIMESTAMP} ");
		}

		sb.append(" order by wwr.create_time desc ");
		if (dto.getPageNo() != null&&dto.getPageSize()!=null) {
			StringBuilder sqlStr = new StringBuilder();
			sqlStr.append("select t.* from (select tt.*, ROWNUM rnum from ( ");
			sqlStr.append(sb.toString());
			sqlStr.append(") tt) t where   t.rnum <= (#{pageNo,jdbcType=NUMERIC})*#{pageSize,jdbcType=NUMERIC}  and t.rnum >= (#{pageNo,jdbcType=NUMERIC}-1)*#{pageSize,jdbcType=NUMERIC}");
			return sqlStr.toString();
		}else{
			return sb.toString();
		}
	}

	public String countWalletWithdrawByQuery(ExtWalletWithdrawReqDTO dto) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT count(1), ");
		sb.append("FROM MCREDIT.FW_WALLET_WITHDRAW_REQ wwr ");
		sb.append("where 1 = 1 ");

		if (null != dto.getReqId()) {
			sb.append(" and  wwr.req_id = #{reqId}");
		}
		if (StringUtils.isNotBlank(dto.getOrderNo())) {
			sb.append(" and  wwr.order_no = #{orderNo}");
		}

		if (dto.getTraceNo() != null) {
			sb.append(" and  wwr.TRACE_NO = #{traceNo} ");
		}
		if (dto.getStatus() != null) {
			sb.append(" and  wwr.status = #{status} ");
		}
		if (StringUtils.isNotBlank(dto.getMemberNo())) {
			sb.append(" and  wwr.member_no = #{memberNo} ");
		}

		if (dto.getStartTime() != null) {
			sb.append(" and  wwr.create_time >= #{startTime,jdbcType=TIMESTAMP} ");
		}
		if (dto.getEndTime() != null) {
			sb.append(" and  wwr.create_time < #{endTime,jdbcType=TIMESTAMP} ");
		}
		return sb.toString();
	}
	

}
