package com.sdp.withdraw.dao.mapper.ext;

import com.sdp.withdraw.dao.mapper.WithdrawRatioInfoSqlProvider;
/**
 * 出款sqlProvider扩展
 * @author zhangyulong
 *
 */
public class ExtWithdrawRatioSqlProvider extends WithdrawRatioInfoSqlProvider{
	/**
	 * 根据Query对象分页查询出款列表信息
	 * @param example
	 * @return
	 */
	public String selectRatioInfo(Long bizId) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from (select t.ratio_type from FW_WITHDRAW_RATIO_INFO t where t.status = '1'  and t.effective_time <= sysdate ");
		sb.append(" and t.biz_id="+bizId);
		sb.append(" order by t.effective_time desc ) a group by a.ratio_type");
		return sb.toString();
	}

}
