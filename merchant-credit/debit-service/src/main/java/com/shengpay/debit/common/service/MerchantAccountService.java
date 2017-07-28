package com.shengpay.debit.common.service;

import com.sdp.mc.common.vo.ErrorMessageVO;
import com.shengpay.debit.dal.dataobject.DmMerchantDebitInfoPO;

/**
 * 查询账户资产状态
 * 
 * @author heyi.alex
 * 
 */
public interface MerchantAccountService {

	public DmMerchantDebitInfoPO selectByMerchantId(String merchantNo);
	/**
	 * 贷款额度预审通过后，运营拿到商户的邮寄资料确认后再开通授信专户和利息户
	 * @param applyId 贷款申请id
	 * **/
	public ErrorMessageVO openAccount(Long applyId);

}
