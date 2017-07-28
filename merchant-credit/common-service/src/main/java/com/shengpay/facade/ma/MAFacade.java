package com.shengpay.facade.ma;

import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.integration.ma.dto.Promoter4MADTO;


public interface MAFacade {
	/**
	 * 请求创建保证金账户
	 * 
	 * @param merchantNo
	 *            商户号
	 * @param memberId
	 *            商户号对应的memberId
	 * @param requestOperator
	 *            操作员
	 * @param userIp
	 *            用户ip
	 * @return errorMessage
	 * **/
	public MACreateAccountVO createAccount(final String merchantNo, final String memberId, final String requestOperator,final AccountType accountType, final String userIp);
	
	/**
	 * 根据memberId 获得会员手机号码，如无号码或异常返回 null
	 * 
	 * @param memberId
	 * @return
	 */
	public String getMAMobileByMemberId(final String memberId);
	
	/**
	 * 根据商户号查询对应的memberId和默认的操作员id
	 * 
	 * Parameters: merchantNo商户号 merchantNo
	 */
	@Deprecated
	public Promoter4MADTO queryPromoterInfoByMerchantNo(String merchantNo);
}
