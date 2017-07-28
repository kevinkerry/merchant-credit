package com.sdp.mc.ma.wrapper;

import java.util.Map;

import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.integration.ma.dto.MerchantBalanceDTO;
import com.sdp.mc.integration.ma.dto.MerchantBaseBalanceDTO;

public interface AccountQueryFacadeWrapper {
	/**
	 * 根据商户号对应的memberId查询其[基本户]和[保证金账户]余额
	 * @param promoterType 
	 * 
	 * @param merchantMemberId商户会员号
	 * @return mb
	 * **/
	public MerchantBalanceDTO queryMerchantBalance(String merchantMemberId, String promoterType) throws Exception;
	
	/**
	 * 根据商户号批量查询对应的memberId查询其[基本户]和[保证金账户]余额
	 * @param merchantMemberId
	 * @return
	 * @throws Exception
	 */
	public Map<String,MerchantBalanceDTO> queryBatchMerchantBalance(Map<String,String> merchantMemberIdMap) throws Exception ;

	/**
	 * 根据memberId、accountType查询账户余额
	 * 
	 * @param memberId
	 *            sdp会员号
	 * @return mb
	 * **/
	public MerchantBaseBalanceDTO queryAccountBalanceByAccountType(String memberId, AccountType accountType);
}
