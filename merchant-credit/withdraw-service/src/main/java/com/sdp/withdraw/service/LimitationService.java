package com.sdp.withdraw.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.dao.PosMerchantInfoDOExample;

public interface LimitationService {

	/**
	 * 根据商户号查询商户快速结算可用额度(T0)
	 * @param merchantNo
	 * @return
	 */
	public BigDecimal findMerchantFastCanUseQuota(String merchantNo,String mcType);

	/**
	 * 查询冻结额度(T0)
	 * @param merchantNo
	 * @return
	 */
	public BigDecimal findFrozenQuota(String merchantNo,String mcType);

	/**
	 * 将额度冻结操作(T0)
	 * @param frozenQuota
	 * @param merchantNo
	 * @return
	 */
	public boolean frozenLimitation(String merchantNo,String mcType,BigDecimal frozenQuota) ;

	/**
	 * 冻结操作(T0) 根据是非共享额度冻结
	 * @param merchantNo
	 * @param mcType
	 * @param frozenQuota
	 * @param begin
	 * @return
	 */
	public boolean frozenLimitationByIsQuotoShare(String merchantNo,String mcType,BigDecimal frozenQuota,Date begin);
	/**
	 * 恢复冻结额度(T0)
	 * @param merchantNo
	 * @param frozenQuota
	 * @return
	 */
	public boolean restoreFrozenQuota(String merchantNo,String mcType,BigDecimal frozenQuota);

	/**
	 * 恢复冻结额度(T0) 根据是非共享恢复冻结额度
	 * @param merchantNo
	 * @param mcType
	 * @param frozenQuota
	 * @param begin
	 * @return
	 */
	public boolean restoreFrozenQuotaByIsQuotoShare(String merchantNo,String mcType,BigDecimal frozenQuota,Date begin) ;
	/**
	 * 将冻结额度处理成已使用(T0)
	 * @param merchantNo
	 * @param frozenQuota
	 * @return
	 */
	public boolean usefrozenQuota(String merchantNo,String mcType,BigDecimal frozenQuota);

	/**
	 * 将冻结额度处理成已使用(T0) 根据是非共享 冻结额度处理成已使用
	 * @param merchantNo
	 * @param frozenQuota
	 * @return
	 */
	public boolean usefrozenQuotaByIsQuotoShare(String merchantNo,String mcType,BigDecimal frozenQuota,Date begin);

	/**
	 * 根据开始结束日期判断额度是否共享(T0)
	 * @param start
	 * @param end
	 * @return
	 */
	public ErrorMessageVO<Object> isQuotoShare(String merchantNo,String mcType,Date reqDate,Date respDate);

	/**
	 * 查询POS商户信息
	 * @param example
	 * @return
	 */
	public List<PosMerchantInfoDO> findPosMerchantInfo(PosMerchantInfoDOExample example);

	/**
	 * 根据POS商户信息、是否是节假日
	 * 同步额度日历
	 * @param posInfo
	 * @return
	 */
	public boolean syncWithdrawInfoBy(PosMerchantInfoDO posInfo);

	/**
	 * 同步商户信息
	 * @param merchantNo
	 * @return
	 */
	public ErrorMessageVO<Long> syncPosMerchantInfoByMerchantNo(String merchantNo,String mcType);

}
