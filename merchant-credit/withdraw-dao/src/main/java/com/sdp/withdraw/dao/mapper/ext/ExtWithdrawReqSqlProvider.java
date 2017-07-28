package com.sdp.withdraw.dao.mapper.ext;

import org.apache.commons.lang.StringUtils;

import com.sdp.withdraw.dao.WithdrawReqDOExample;
import com.sdp.withdraw.dao.ext.ExtWithdrawReqDOExample;
import com.sdp.withdraw.dao.mapper.WithdrawReqSqlProvider;

/**
 * 出款sqlProvider扩展
 *
 * @author zhangyulong
 *
 */
public class ExtWithdrawReqSqlProvider extends WithdrawReqSqlProvider {
	/**
	 * 根据Query对象分页查询出款列表信息
	 *
	 * @param example
	 * @return
	 */
	public String selectWithdrawReqByQuery(ExtWithdrawReqDOExample example) {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		if (example != null && example.isDistinct()) {
			sb.append("distinct wr.req_id,");
		} else {
			sb.append("wr.req_id,");
		}
		sb.append("wr.req_type,");
		sb.append("wr.app_id,");
		sb.append("wr.order_no,");
		sb.append("wr.member_id,");
		sb.append("wr.merchant_no,");
		sb.append("wr.mc_type,");
		sb.append("wr.withdraw_type,");
		sb.append("wr.withdraw_amount,");
		sb.append("wr.withdraw_fee,");
		sb.append("nvl(wr.withdraw_cost,0) +  nvl(wr.wd_cost,0) total_cost,");
		sb.append("wr.withdraw_cost, ");
		sb.append("nvl(wr.wd_cost,0) wd_cost, ");
		sb.append("wr.original_amount,");
		sb.append("wr.splitting_fee,");
		sb.append("wr.splitting_cost, ");
		sb.append("wr.pmt_member_id, ");
		sb.append("wr.pmt_merchant_no,");
		sb.append("wr.status,");
		sb.append("wr.retry_times,");
		sb.append("wr.error_code,");
		sb.append("wr.error_msg,");
		sb.append("wr.callback_address as wr_callback_address,");
		sb.append("wr.apply_time,");
		sb.append("wr.create_time as wr_create_time,");
		sb.append("wr.update_time as wr_update_time,");
		sb.append("wr.withdraw_time,");
		sb.append("wr.service_type,");
		sb.append("wr.HAS_OA_TXN,");

		sb.append("wrfd.detail_id, ");
		sb.append("wrfd.product_code,");
		sb.append("wrfd.payment_code,");
		sb.append("wrfd.remit_voucher_no,");
		sb.append("wrfd.payer_member_id, ");
		sb.append("wrfd.is_need_count_fee,");
		sb.append("wrfd.payer_fee,");
		sb.append("wrfd.payee_fee,");
		sb.append("wrfd.is_permit_pricing_err, ");
		sb.append("wrfd.payer_account_no,");
		sb.append("wrfd.bank_code,");
		sb.append("wrfd.bank_name,");
		sb.append("wrfd.bank_branch, ");
		sb.append("wrfd.bank_lineno,");
		sb.append("wrfd.bank_province,");
		sb.append("wrfd.bank_city,");
		sb.append("wrfd.payee_name, ");
		sb.append("wrfd.payee_card_no,");
		sb.append("wrfd.payee_purpose,");
		sb.append("wrfd.card_type,");
		sb.append("wrfd.company_or_personal, ");
		sb.append("wrfd.gmt_biz_initiate,");
		sb.append("wrfd.gmt_payment_initiate,");
		sb.append("wrfd.remit_amount,");
		sb.append("wrfd.memo,");
		sb.append("wrfd.currency,");
		sb.append("wrfd.req_extention,");
		sb.append("wrfd.withdraw_status,");
		sb.append("wrfd.callback_address,");

		sb.append("wrfd.return_code,");
		sb.append("wrfd.return_msg,");
		sb.append("wrfd.extention,");
		sb.append("wr.create_time,");
		sb.append("wr.update_time ");
		sb.append("from mcredit.fw_withdraw_req wr ");
		// sb.append("left join ( select de.req_id,max(de.detail_id) detail_id from mcredit.fw_withdraw_req_fos_detail de group by de.req_id) r ");
		// sb.append("on WR.REQ_ID=r.req_id ");
		// sb.append("LEFT JOIN  mcredit.fw_withdraw_req_fos_detail wrfd ON r.detail_id = wrfd.detail_id ");
		sb.append(" LEFT JOIN MCREDIT.FW_WITHDRAW_REQ_FOS_DETAIL wrfd ON WR.LAST_DETAIL_ID = WRFD.DETAIL_ID ");
		sb.append("where 1 = 1 ");

		if (null != example.getReqId()) {
			sb.append(" and  wr.req_id = #{reqId}");
		}
		if (null != example.getDetailId()) {
			sb.append(" and  wrfd.detail_id = #{detailId}");
		}
		if (StringUtils.isNotBlank(example.getOrderNo())) {
			sb.append(" and  wr.order_no = #{orderNo}");
		}

		if (example.getReqType() != null) {
			sb.append(" and  wr.req_type = #{reqType} ");
		}
		if (example.getStatus() != null) {
			sb.append(" and  wr.status = #{status} ");
		}
		if (example.getWithdrawType() != null) {
			sb.append(" and  wr.withdraw_type = #{withdrawType} ");
		}
		if (example.getServiceType() != null) {
			sb.append(" and  wr.service_type = #{serviceType} ");
		}
		if (StringUtils.isNotBlank(example.getMerchantNo())) {
			sb.append(" and  wr.merchant_no = #{merchantNo} ");
		}

		if (example.getStartApplyTime() != null) {
			sb.append(" and  wr.create_time >= #{startApplyTime,jdbcType=TIMESTAMP} ");
		}
		if (example.getEndApplyTime() != null) {
			sb.append(" and  wr.create_time < #{endApplyTime,jdbcType=TIMESTAMP} ");
		}

		if (example.getStartCreateTime() != null) {
			sb.append(" and  wr.create_time >= #{startCreateTime,jdbcType=TIMESTAMP} ");
		}
		if (example.getEndCreateTime() != null) {
			sb.append(" and  wr.create_time < #{endCreateTime,jdbcType=TIMESTAMP} ");
		}

		sb.append(" order by wr.create_time desc");

		StringBuilder sqlStr = new StringBuilder();
		sqlStr.append("select t.* from (select tt.*, ROWNUM rnum from ( ");
		sqlStr.append(sb.toString());
		sqlStr.append(") tt) t where   t.rnum <= #{pageLastItem,jdbcType=NUMERIC}  and t.rnum >= #{pageFristItem,jdbcType=NUMERIC}");

		return sqlStr.toString();
	}

	public String countWithdrawReqByQuery(ExtWithdrawReqDOExample example) {
		StringBuilder sb = new StringBuilder();
		sb.append("select count(wr.req_id) ");
		sb.append("from mcredit.fw_withdraw_req wr ");
		sb.append("where 1 = 1 ");
		if (null != example.getReqId()) {
			sb.append(" and  wr.req_id = #{reqId}");
		}
		if (StringUtils.isNotBlank(example.getOrderNo())) {
			sb.append(" and  wr.order_no = #{orderNo}");
		}

		if (example.getReqType() != null) {
			sb.append(" and  wr.req_type = #{reqType} ");
		}

		if (example.getStatus() != null) {
			sb.append(" and  wr.status = #{status} ");
		}
		if (example.getWithdrawType() != null) {
			sb.append(" and  wr.withdraw_type = #{withdrawType} ");
		}
		if (example.getServiceType() != null) {
			sb.append(" and  wr.service_type = #{serviceType} ");
		}
		if (StringUtils.isNotBlank(example.getMerchantNo())) {
			sb.append(" and  wr.merchant_no = #{merchantNo} ");
		}

		if (example.getStartApplyTime() != null) {
			sb.append(" and  wr.create_time >= #{startApplyTime,jdbcType=TIMESTAMP} ");
		}
		if (example.getEndApplyTime() != null) {
			sb.append(" and  wr.create_time < #{endApplyTime,jdbcType=TIMESTAMP} ");
		}
		if (example.getStartCreateTime() != null) {
			sb.append(" and  wr.create_time >= #{startCreateTime,jdbcType=TIMESTAMP} ");
		}
		if (example.getEndCreateTime() != null) {
			sb.append(" and  wr.create_time < #{endCreateTime,jdbcType=TIMESTAMP} ");
		}
		return sb.toString();
	}

	/**
	 * 根据Query对象分页查询出款列表信息
	 *
	 * @param example
	 * @return
	 */
	public String queryWithdrawInfoByQuery(ExtWithdrawReqDOExample example) {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		if (example != null && example.isDistinct()) {
			sb.append("distinct wr.req_id,");
		} else {
			sb.append("wr.req_id,");
		}
		sb.append("wr.req_type,");
		sb.append("wr.app_id,");
		sb.append("wr.order_no,");
		sb.append("wr.member_id,");
		sb.append("wr.merchant_no,");
		sb.append("wr.mc_type,");
		sb.append("wr.withdraw_type,");
		sb.append("wr.withdraw_amount,");
		sb.append("wr.withdraw_fee,");
		sb.append("nvl(wr.withdraw_cost,0) +  nvl(wr.wd_cost,0) total_cost,");
		sb.append("wr.withdraw_cost, ");
		sb.append("nvl(wr.wd_cost,0) wd_cost, ");
		sb.append("wr.original_amount,");
		sb.append("wr.splitting_fee,");
		sb.append("wr.splitting_cost, ");
		sb.append("wr.pmt_member_id, ");
		sb.append("wr.pmt_merchant_no,");
		sb.append("wr.status,");
		sb.append("wr.retry_times,");
		sb.append("wr.error_code,");
		sb.append("wr.error_msg,");
		sb.append("wr.callback_address as wr_callback_address,");
		sb.append("wr.apply_time,");
		sb.append("wr.create_time as wr_create_time,");
		sb.append("wr.update_time as wr_update_time,");
		sb.append("wr.withdraw_time,");
		sb.append("wr.service_type,");
		sb.append("wr.HAS_OA_TXN,");
		sb.append("wrfd.detail_id, ");
		sb.append("wrfd.product_code,");
		sb.append("wrfd.payment_code,");
		sb.append("wrfd.remit_voucher_no,");
		sb.append("wrfd.payer_member_id, ");
		sb.append("wrfd.is_need_count_fee,");
		sb.append("wrfd.payer_fee,");
		sb.append("wrfd.payee_fee,");
		sb.append("wrfd.is_permit_pricing_err, ");
		sb.append("wrfd.payer_account_no,");
		sb.append("wrfd.bank_code,");
		sb.append("wrfd.bank_name,");
		sb.append("wrfd.bank_branch, ");
		sb.append("wrfd.bank_lineno,");
		sb.append("wrfd.bank_province,");
		sb.append("wrfd.bank_city,");
		sb.append("wrfd.payee_name, ");
		sb.append("wrfd.payee_card_no,");
		sb.append("wrfd.payee_purpose,");
		sb.append("wrfd.card_type,");
		sb.append("wrfd.company_or_personal, ");
		sb.append("wrfd.gmt_biz_initiate,");
		sb.append("wrfd.gmt_payment_initiate,");
		sb.append("wrfd.remit_amount,");
		sb.append("wrfd.memo,");
		sb.append("wrfd.currency,");
		sb.append("wrfd.req_extention,");
		sb.append("wrfd.withdraw_status,");
		sb.append("wrfd.callback_address,");

		sb.append("wrfd.return_code,");
		sb.append("wrfd.return_msg,");
		sb.append("wrfd.extention,");
		sb.append("wr.create_time,");
		sb.append("wr.update_time ");
		sb.append("from mcredit.fw_withdraw_req wr ");
		/*
		 * sb.append(
		 * "left join ( select de.req_id,max(de.detail_id) detail_id from mcredit.fw_withdraw_req_fos_detail de group by de.req_id) r "
		 * ); sb.append("on WR.REQ_ID=r.req_id "); sb.append(
		 * "LEFT JOIN  mcredit.fw_withdraw_req_fos_detail wrfd ON r.detail_id = wrfd.detail_id "
		 * );
		 */
		sb.append(" LEFT JOIN MCREDIT.FW_WITHDRAW_REQ_FOS_DETAIL wrfd ON WR.LAST_DETAIL_ID = WRFD.DETAIL_ID ");
		// sb.append("LEFT JOIN MCREDIT.FW_POS_MERCHANT_INFO fmi ON WR.MERCHANT_BIZ_ID = fmi.MERCHANT_BIZ_ID ");
		// sb.append("LEFT JOIN VIEW_MERCHANT_INFO mpm ON WR.MERCHANT_BIZ_ID = mpm.MERCHANT_BIZ_ID ");
		sb.append(createWithdrawInfoWhere(example));
		if(example.getStartCreateTime()!=null||example.getApplyTime()!=null){
			sb.append(" order by wr.create_time desc");
		}
		StringBuilder sqlStr = new StringBuilder();
		sqlStr.append("select t.* from (select tt.*, ROWNUM rnum from ( ");
		sqlStr.append(sb.toString());
		sqlStr.append(") tt) t where   t.rnum <= #{pageLastItem,jdbcType=NUMERIC}  and t.rnum >= #{pageFristItem,jdbcType=NUMERIC}");

		return sqlStr.toString();
	}

	public String countWithdrawInfoByQuery(ExtWithdrawReqDOExample example) {
		StringBuilder sb = new StringBuilder();
		sb.append("select count(wr.req_id) ");
		sb.append("from mcredit.fw_withdraw_req wr ");
//		sb.append("LEFT JOIN  mcredit.fw_withdraw_req_fos_detail wrfd ON wr.req_id=wrfd.req_id ");
		// sb.append("LEFT JOIN MCREDIT.FW_POS_MERCHANT_INFO fmi ON WR.MC_TYPE = FMI.MERCHANT_TYPE AND WR.MERCHANT_NO = FMI.MERCHANT_NO ");
		// sb.append("LEFT JOIN VIEW_MERCHANT_INFO mpm ON FMI.POS_MERCHANT_ID = MPM.MERCHANT_ID ");
		sb.append(createWithdrawInfoWhere(example));

		return sb.toString();
	}

	private Object createWithdrawInfoWhere(ExtWithdrawReqDOExample example) {
		StringBuffer sb = new StringBuffer();
		sb.append("where 1 = 1 ");
		if (null != example.getReqId()) {
			sb.append(" and  wr.req_id = #{reqId}");
		}
		/*if (null != example.getDetailId()) {
			sb.append(" and  wrfd.detail_id = #{detailId}");
		}*/
		if (StringUtils.isNotBlank(example.getOrderNo())) {
			sb.append(" and  wr.order_no = #{orderNo}");
		}
		if (null != example.getPromoterId()) {
			sb.append(" and WR.PMT_MEMBER_ID=#{promoterId}");
		}

		if (example.getReqType() != null) {
			sb.append(" and  wr.req_type = #{reqType} ");
		}
		if (example.getStatus() != null) {
			sb.append(" and  wr.status = #{status} ");
		}
		if (example.getWithdrawType() != null) {
			sb.append(" and  wr.withdraw_type = #{withdrawType} ");
		}
		if (example.getServiceType() != null) {
			sb.append(" and  wr.service_type = #{serviceType} ");
		}
		if (StringUtils.isNotBlank(example.getMerchantNo())) {
			sb.append(" and  wr.merchant_no = #{merchantNo} ");
		}

		if (example.getStartApplyTime() != null) {
			sb.append(" and  wr.create_time >= #{startApplyTime,jdbcType=TIMESTAMP} ");
		}
		if (example.getEndApplyTime() != null) {
			sb.append(" and  wr.create_time < #{endApplyTime,jdbcType=TIMESTAMP} ");
		}

		if (example.getStartCreateTime() != null) {
			sb.append(" and  wr.create_time >= #{startCreateTime,jdbcType=TIMESTAMP} ");
		}
		if (example.getEndCreateTime() != null) {
			sb.append(" and  wr.create_time < #{endCreateTime,jdbcType=TIMESTAMP} ");
		}
		if (StringUtils.isNotBlank(example.getMcType())) {
			sb.append(" and  WR.MC_TYPE = #{mcType} ");
		}
		if (StringUtils.isNotBlank(example.getPromoterNo())) {
			// sb.append(" and MPM.PROMOTER_MERCHANT_NO= #{promoterNo} ");
			sb.append(" and  WR.PMT_MERCHANT_NO = #{promoterNo} ");
		}
		return sb.toString();
	}

	/**
	 * 根据Query对象分页查询出款列表信息
	 *
	 * @param example
	 * @return
	 */
	public String selectMerchantFastsettleByQuery(ExtWithdrawReqDOExample example) {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		if (example != null && example.isDistinct()) {
			sb.append("distinct wr.req_id,");
		} else {
			sb.append("wr.req_id,");
		}
		sb.append("wr.req_type,");
		sb.append("wr.app_id,");
		sb.append("wr.order_no,");
		sb.append("wr.member_id,");
		sb.append("wr.merchant_no,");
		sb.append("wr.mc_type,");
		sb.append("wr.withdraw_type,");
		sb.append("wr.withdraw_amount,");
		sb.append("wr.withdraw_fee,");
		sb.append("wr.withdraw_cost,");
		sb.append("wr.wd_cost,");
		sb.append(" nvl(wr.withdraw_cost,0) +  nvl(wr.wd_cost,0) total_cost, ");
		sb.append("wr.original_amount,");
		sb.append("wr.splitting_fee,");
		sb.append("wr.splitting_cost, ");
		sb.append("wr.pmt_member_id, ");
		sb.append("wr.pmt_merchant_no,");
		sb.append("wr.status,");
		sb.append("wr.retry_times,");
		sb.append("wr.error_code,");
		sb.append("wr.error_msg,");
		sb.append("wr.callback_address as wr_callback_address,");
		sb.append("wr.apply_time,");
		sb.append("wr.create_time as wr_create_time,");
		sb.append("wr.update_time as wr_update_time,");
		sb.append("wr.withdraw_time,");
		sb.append("wr.service_type,");
		sb.append("msp.MERCHANT_NAME,");
		sb.append("msp.pmt_bind_operator_name,");
		sb.append("wr.create_time,");
		sb.append("wr.mcc,");
		sb.append("wr.HAS_OA_TXN,");
		sb.append("wr.update_time ");
		sb.append("from mcredit.fw_withdraw_req wr ");

		sb.append("left join VIEW_MERCHANT_INFO msp ON WR.MERCHANT_BIZ_ID = MSP.MERCHANT_BIZ_ID ");
		sb.append("where 1 = 1 ");

		if (null != example.getReqId()) {
			sb.append(" and  wr.req_id = #{reqId}");
		}
		if (null != example.getPromoterId()) {
			// sb.append(" and MSP.PROMOTER_ID=#{promoterId}");
			sb.append(" and WR.PMT_MEMBER_ID=#{promoterId}");
		}
		if (StringUtils.isNotBlank(example.getOrderNo())) {
			sb.append(" and  wr.order_no = #{orderNo}");
		}
		if (StringUtils.isNotBlank(example.getMcc())) {
			sb.append(" and  wr.mcc = #{mcc}");
		}

		if (example.getReqType() != null) {
			sb.append(" and  wr.req_type = #{reqType} ");
		}
		if (example.getStatus() != null) {
			sb.append(" and  wr.status = #{status} ");
		}
		if (example.getWithdrawType() != null) {
			sb.append(" and  wr.withdraw_type = #{withdrawType} ");
		}
		if (example.getServiceType() != null) {
			sb.append(" and  wr.service_type = #{serviceType} ");
		}
		if (StringUtils.isNotBlank(example.getMerchantNo())) {
			sb.append(" and  wr.merchant_no = #{merchantNo} ");
		}
		if (StringUtils.isNotBlank(example.getPromoterNo())) {
			// sb.append(" and  msp.PROMOTER_MERCHANT_NO = #{promoterNo} ");
			sb.append(" and  WR.PMT_MERCHANT_NO = #{promoterNo} ");
		}

		if (example.getStartApplyTime() != null) {
			sb.append(" and  wr.apply_time >= #{startApplyTime,jdbcType=TIMESTAMP} ");
		}
		if (example.getEndApplyTime() != null) {
			sb.append(" and  wr.apply_time < #{endApplyTime,jdbcType=TIMESTAMP} ");
		}

		if (example.getStartCreateTime() != null) {
			sb.append(" and  wr.create_time >= #{startCreateTime,jdbcType=TIMESTAMP} ");
		}
		if (example.getEndCreateTime() != null) {
			sb.append(" and  wr.create_time < #{endCreateTime,jdbcType=TIMESTAMP} ");
		}

		if (example.getStartWithdrawTime() != null) {
			sb.append(" and  wr.withdraw_time >= #{startWithdrawTime,jdbcType=TIMESTAMP} ");
		}
		if (example.getEndWithdrawTime() != null) {
			sb.append(" and  wr.withdraw_time < #{endWithdrawTime,jdbcType=TIMESTAMP} ");
		}
		if (StringUtils.isNotBlank(example.getPmtType())) {
			sb.append(" and msp.promoter_type = #{pmtType} ");
		}
		if (StringUtils.isNotBlank(example.getMerchantName())) {
			sb.append(" and  msp.MERCHANT_NAME = #{merchantName} ");
		}
		sb.append(" order by wr.create_time desc ");

		StringBuilder sqlStr = new StringBuilder();
		sqlStr.append("select t.* from (select tt.*, ROWNUM rnum from ( ");
		sqlStr.append(sb.toString());
		sqlStr.append(") tt) t where   t.rnum <= #{pageLastItem,jdbcType=NUMERIC}  and t.rnum >= #{pageFristItem,jdbcType=NUMERIC}");

		return sqlStr.toString();
	}

	public String countMerchantFastsettleByQuery(ExtWithdrawReqDOExample example) {
		StringBuilder sb = new StringBuilder();
		sb.append("select count(wr.req_id) ");
		sb.append("from mcredit.fw_withdraw_req wr ");
		sb.append("left join VIEW_MERCHANT_INFO msp ON WR.MERCHANT_BIZ_ID = MSP.MERCHANT_BIZ_ID ");
		sb.append("where 1 = 1 ");
		if (null != example.getReqId()) {
			sb.append(" and  wr.req_id = #{reqId}");
		}
		if (StringUtils.isNotBlank(example.getOrderNo())) {
			sb.append(" and  wr.order_no = #{orderNo}");
		}

		if (example.getReqType() != null) {
			sb.append(" and  wr.req_type = #{reqType} ");
		}
		if (null != example.getPromoterId()) {
			// sb.append(" and MSP.PROMOTER_ID=#{promoterId}");
			sb.append(" and WR.PMT_MEMBER_ID=#{promoterId}");
		}
		if (StringUtils.isNotBlank(example.getPmtType())) {
			sb.append(" and msp.promoter_type = #{pmtType} ");
		}
		if (StringUtils.isNotBlank(example.getMerchantName())) {
			sb.append(" and  msp.MERCHANT_NAME = #{merchantName} ");
		}
		if (StringUtils.isNotBlank(example.getMcc())) {
			sb.append(" and  wr.mcc = #{mcc} ");
		}

		if (example.getStatus() != null) {
			sb.append(" and  wr.status = #{status} ");
		}
		if (example.getWithdrawType() != null) {
			sb.append(" and  wr.withdraw_type = #{withdrawType} ");
		}
		if (example.getServiceType() != null) {
			sb.append(" and  wr.service_type = #{serviceType} ");
		}
		if (StringUtils.isNotBlank(example.getMerchantNo())) {
			sb.append(" and  wr.merchant_no = #{merchantNo} ");
		}
		if (StringUtils.isNotBlank(example.getPromoterNo())) {
			// sb.append(" and  wr.PMT_MERCHANT_NO = #{promoterNo} ");
			sb.append(" and  WR.PMT_MERCHANT_NO = #{promoterNo} ");
		}
		if (example.getStartApplyTime() != null) {
			sb.append(" and  wr.apply_time >= #{startApplyTime,jdbcType=TIMESTAMP} ");
		}
		if (example.getEndApplyTime() != null) {
			sb.append(" and  wr.apply_time < #{endApplyTime,jdbcType=TIMESTAMP} ");
		}
		if (example.getStartCreateTime() != null) {
			sb.append(" and  wr.create_time >= #{startCreateTime,jdbcType=TIMESTAMP} ");
		}
		if (example.getEndCreateTime() != null) {
			sb.append(" and  wr.create_time < #{endCreateTime,jdbcType=TIMESTAMP} ");
		}
		if (example.getStartWithdrawTime() != null) {
			sb.append(" and  wr.withdraw_time >= #{startWithdrawTime,jdbcType=TIMESTAMP} ");
		}
		if (example.getEndWithdrawTime() != null) {
			sb.append(" and  wr.withdraw_time < #{endWithdrawTime,jdbcType=TIMESTAMP} ");
		}
		return sb.toString();
	}

	public String statisticsPromoterMerchantWithdrawInfo(Long promoterId) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT nvl(SUM(CASE ");
		sb.append("WHEN mi.MC_TYPE = '0001' THEN REQ.ORIGINAL_AMOUNT ");
		sb.append(" ELSE REQ.WITHDRAW_AMOUNT END),0) withdraw_total_amount, ");
		sb.append("nvl(SUM (CASE WHEN REQ.STATUS = 2 THEN 1 ELSE 0 END),0) withdrawing_cnt ");
		sb.append("FROM VIEW_MERCHANT_INFO mi,MCREDIT.FW_WITHDRAW_REQ req  ");
		sb.append("WHERE  REQ.MERCHANT_NO = MI.MERCHANT_NO  AND REQ.MC_TYPE = MI.MC_TYPE AND REQ.STATUS IN (0, 2)  ");
		sb.append("AND REQ.CREATE_TIME >= TRUNC (SYSDATE) ");
		sb.append("AND REQ.WITHDRAW_TYPE=1 ");
		sb.append("AND MI.PROMOTER_ID = " + promoterId);
		return sb.toString();
	}

	public String queryStatusDisagreeInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("select req.* from MCREDIT.FW_WITHDRAW_REQ req,MCREDIT.FW_WITHDRAW_REQ_FOS_DETAIL d  ");
		sb.append("where REQ.REQ_ID=D.REQ_ID  ");
		sb.append("and REQ.STATUS=2 ");
		sb.append("and D.WITHDRAW_STATUS in ('0','9') ");
		sb.append("and REQ.CREATE_TIME <trunc(sysdate) ");
		sb.append("and REQ.CREATE_TIME >trunc(sysdate-30) ");
		return sb.toString();
	}

	public String statisticsPromoterWithdrawInfo(Long promoterId) {
		StringBuilder sb = new StringBuilder();
		sb.append("  SELECT TRUNC (REQ.CREATE_TIME) TIME, ");
		sb.append("  SUM (REQ.WITHDRAW_AMOUNT) WITHDRAW_TOTAL_AMOUNT, ");
		sb.append("  COUNT (1) TOTAL_CNT, ");
		sb.append("  COUNT (DISTINCT REQ.MERCHANT_NO) ACTIVE_MERCHANT_NUM ");
		sb.append("  FROM MCREDIT.FW_WITHDRAW_REQ req ");
		sb.append("   WHERE     REQ.STATUS = 0 ");
		sb.append("  AND REQ.CREATE_TIME < TRUNC (SYSDATE) ");
		sb.append("  AND REQ.CREATE_TIME > TRUNC (SYSDATE - 30) ");
		sb.append("  and REQ.PMT_MEMBER_ID ="+promoterId );
		sb.append("  GROUP BY REQ.PMT_MEMBER_ID, TRUNC (REQ.CREATE_TIME) ");
		sb.append("  ORDER BY time DESC ");
		return sb.toString();
	}

	public String statisticsMerchantWithdrawInfo(Long merchantBizId) {
		StringBuilder sb = new StringBuilder();
		sb.append("  SELECT TRUNC (REQ.CREATE_TIME) TIME, ");
		sb.append("  SUM (REQ.WITHDRAW_AMOUNT) WITHDRAW_TOTAL_AMOUNT, ");
		sb.append("  COUNT (1) TOTAL_CNT, ");
		sb.append("  COUNT (DISTINCT REQ.MERCHANT_NO) ACTIVE_MERCHANT_NUM ");
		sb.append("  FROM MCREDIT.FW_WITHDRAW_REQ req ");
		sb.append("   WHERE  REQ.STATUS = 0 ");
		sb.append("  AND REQ.CREATE_TIME < TRUNC (SYSDATE) ");
		sb.append("  AND REQ.CREATE_TIME > TRUNC (SYSDATE - 30) ");
		sb.append("  and REQ.MERCHANT_BIZ_ID= "+merchantBizId);
		sb.append("  GROUP BY REQ.MERCHANT_BIZ_ID, TRUNC (REQ.CREATE_TIME) ");
		sb.append("  ORDER BY time DESC ");
		return sb.toString();
	}
	public String queryWithdrawReqTotalAmount(ExtWithdrawReqDOExample example) {
		StringBuilder sb = new StringBuilder();
		sb.append("  SELECT ");
		sb.append("  SUM (nvl(wr.WITHDRAW_AMOUNT,0)) WITHDRAW_TOTAL_AMOUNT ");
		sb.append("  FROM MCREDIT.FW_WITHDRAW_REQ wr ");
		sb.append("  WHERE 1=1 ");
		if (example.getStatus() != null) {
			sb.append(" and  wr.status = #{status} ");
		}
		if (example.getServiceType() != null) {
			sb.append(" and  wr.service_type = #{serviceType} ");
		}
		if (StringUtils.isNotBlank(example.getMerchantNo())) {
			sb.append(" and  wr.merchant_no = #{merchantNo} ");
		}
		if (StringUtils.isNotBlank(example.getMcType())) {
			sb.append(" and  wr.mc_type = #{mcType} ");
		}
		if (example.getStartWithdrawTime() != null) {
			sb.append(" and  wr.withdraw_time >= #{startWithdrawTime,jdbcType=TIMESTAMP} ");
		}
		if (example.getEndWithdrawTime() != null) {
			sb.append(" and  wr.withdraw_time <= #{endWithdrawTime,jdbcType=TIMESTAMP} ");
		}
		return sb.toString();
	}

}
