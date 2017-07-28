package com.sdp.withdraw.dao.mapper.ext;

import org.apache.commons.lang.StringUtils;

import com.sdp.withdraw.dao.ext.ExtWithdrawReqDOExample;
import com.sdp.withdraw.dao.mapper.RemitFeeReqSqlProvider;

/**
 * 出款sqlProvider扩展
 *
 * @author zhangyulong
 *
 */
public class ExtRefoundReqSqlProvider extends RemitFeeReqSqlProvider {
	/**
	 * 查询条件
	 *
	 * @param example
	 * @return
	 */
	private String paramQuery(ExtWithdrawReqDOExample example) {
		StringBuilder sb = new StringBuilder();
		sb.append("where 1=1 and  req.withdraw_type=1   and  req.status = '0' ");
		sb.append(" and  ((to_date(TO_CHAR( req.withdraw_time, 'yyyy-mm-dd hh24:mi:ss'),'yyyy-mm-dd hh24:mi:ss')  ");
		sb.append("	-  ");
		sb.append("	to_date(TO_CHAR(req.create_time , 'yyyy-mm-dd hh24:mi:ss'), 'YYYY-MM-DD HH24:mi:ss'))*1440)>"+example.getMinutes());
		if (StringUtils.isNotBlank(example.getMerchantNo())) {
			sb.append(" and  req.merchant_no = #{merchantNo} ");
		}
		if (StringUtils.isNotBlank(example.getPromoterNo())) {
			sb.append(" and cmc.mc_merchant_no_v= #{promoterNo} ");
		}
		 if (StringUtils.isNotBlank(example.getPromoterName())) {
			sb.append(" and cmc.mc_merchant_name_v= #{promoterName} ");
		}
		if (StringUtils.isNotBlank(example.getMcType())) {
			sb.append(" and  req.mc_type = #{mcType} ");
		}
		if (StringUtils.isNotBlank(example.getOrderNo())) {
			sb.append(" and  req.order_no = #{orderNo}");
		}
		if (StringUtils.isNotBlank(example.getRemitStatus())) {
			if(example.getRemitStatus().equals("0")){
				sb.append(" and    (remit.status not in  ('1', '3') or   remit.status  is null) ");
			} else{
				sb.append(" and  remit.status = #{remitStatus} ");
			}

		}
		if (example.getStartApplyTime() != null) {
			sb.append(" and  req.create_time >= #{startApplyTime,jdbcType=TIMESTAMP} ");
		}
		if (example.getEndApplyTime() != null) {
			sb.append(" and  req.create_time < #{endApplyTime,jdbcType=TIMESTAMP} ");
		}
		return sb.toString();
	}

	/**
	 * 计数
	 *
	 * @param example
	 * @return
	 */
	public String countRefoundByQuery(ExtWithdrawReqDOExample example) {
		StringBuilder sb = new StringBuilder();
		sb.append("select count(req.req_id) ");
		sb.append(" from mcredit.fw_withdraw_req req ");
		sb.append(" left join mcredit.FW_REMIT_WITHDRAWFEE_REQ remit on req.req_id =remit.req_id ");
		sb.append(" left join mcredit.fw_pos_merchant_info fp on ");
		sb.append(" req.merchant_no=fp.merchant_no and req.mc_type=fp.merchant_type ");
		sb.append(" left join ppcpay.cm_merchant_contract cmc on fp.pos_merchant_id=cmc.mc_id_n ");
		sb.append(paramQuery(example));
		return sb.toString();

	}

	/**
	 * 根据Query对象分页查询列表信息
	 *
	 * @param example
	 * @return
	 */
	public String selectRefoundByQuery(ExtWithdrawReqDOExample example) {
		StringBuilder sb = new StringBuilder();
		sb.append("select req.req_id, ");
		sb.append("req.merchant_no, ");
		sb.append("req.mc_type, ");
		sb.append("req.order_no, ");
		sb.append("req.create_time, ");
		sb.append("req.withdraw_time, ");
		sb.append("req.withdraw_amount, ");
		sb.append(" nvl(req.withdraw_cost,0) +  nvl(req.wd_cost,0) total_cost,");
		sb.append("req.withdraw_cost, ");
		sb.append("nvl(req.wd_cost,0) wd_cost, ");
		sb.append("req.status, ");
		sb.append("remit.status remitStatus, ");
		sb.append("remit.update_time remitTime ");
		sb.append(" from mcredit.fw_withdraw_req req ");
		sb.append(" left join mcredit.FW_REMIT_WITHDRAWFEE_REQ remit on req.req_id =remit.req_id ");
		sb.append(" left join mcredit.fw_pos_merchant_info fp on ");
		sb.append(" req.merchant_no=fp.merchant_no and req.mc_type=fp.merchant_type ");
		sb.append(" left join ppcpay.cm_merchant_contract cmc on fp.pos_merchant_id=cmc.mc_id_n ");
		sb.append(paramQuery(example));
		sb.append(" order by req.create_time desc ");
		StringBuilder sqlStr = new StringBuilder();
		sqlStr.append("select t.* from (select tt.*, ROWNUM rnum from ( ");
		sqlStr.append(sb.toString());
		sqlStr.append(") tt) t where   t.rnum <= #{pageLastItem,jdbcType=NUMERIC}  and t.rnum >= #{pageFristItem,jdbcType=NUMERIC}");

		return sqlStr.toString();
	}

}
