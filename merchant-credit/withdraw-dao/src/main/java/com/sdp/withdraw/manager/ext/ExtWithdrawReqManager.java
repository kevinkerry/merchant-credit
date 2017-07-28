package com.sdp.withdraw.manager.ext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.sdp.mc.common.dto.StatisticsWithdrawInfoDTO;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqDOExample;
import com.sdp.withdraw.dao.ext.ExtRefoundReqVO;
import com.sdp.withdraw.dao.ext.ExtWithdrawReqDOExample;
import com.sdp.withdraw.dao.ext.ExtWithdrawReqVO;
import com.sdp.withdraw.manager.WithdrawReqManager;
/**
 * 出款申请扩展Manager
 * @author zhangyulong
 *
 */
public interface ExtWithdrawReqManager extends WithdrawReqManager{

	List<ExtWithdrawReqVO> selectWithdrawReqByQuery(ExtWithdrawReqDOExample example);

	public int updateByExampleSelective(WithdrawReqDO record, WithdrawReqDOExample example);

	public int updateByExample(WithdrawReqDO record, WithdrawReqDOExample example);
	/**
	 * 给接口提供分页数据
	 * @param example
	 * @return
	 */
	public List<ExtWithdrawReqVO> queryWithdrawReqInfo(ExtWithdrawReqDOExample example);
	/**
	 * t0总记录数
	 * @param example
	 * @return
	 */
	public Integer queryWithdrawReqCount(ExtWithdrawReqDOExample example);
	
	public List<ExtWithdrawReqVO> selectMerchantFastsettleByQuery(
			ExtWithdrawReqDOExample example);
	/**
	 * 退款
	 * @param example
	 * @return
	 */
	public Integer queryRefoundCount(ExtWithdrawReqDOExample example);
	public List<ExtRefoundReqVO> queryRefoundReqInfo(ExtWithdrawReqDOExample example);

	StatisticsWithdrawInfoDTO statisticsPromoterMerchantWithdrawInfo(Long promoterId);

	List<ExtWithdrawReqVO> queryWithdrawInfoByQuery(ExtWithdrawReqDOExample query);

	List<WithdrawReqDO> queryStatusDisagreeInfo();

	List<StatisticsWithdrawInfoDTO> statisticsPromoterWithdrawInfo(Long promoterId);

	List<StatisticsWithdrawInfoDTO> statisticsMerchantWithdrawInfo(Long merchantBizId);

	BigDecimal queryWithdrawReqTotalAmount(String merchantNo, String mcType, Date mothFirstDay, Date mothLastDay);
}
