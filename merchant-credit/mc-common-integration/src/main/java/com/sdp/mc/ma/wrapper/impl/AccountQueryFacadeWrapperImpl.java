package com.sdp.mc.ma.wrapper.impl;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.integration.ma.dto.MerchantBalanceDTO;
import com.sdp.mc.integration.ma.dto.MerchantBaseBalanceDTO;
import com.sdp.mc.ma.wrapper.AccountQueryFacadeWrapper;
import com.sdp.mc.ma.wrapper.utils.AccountQueryFacadeUtil;
import com.shengpay.deposit.facade.account.AccountQueryFacade;
import com.shengpay.deposit.facade.account.AcctsWithBalanceByMembersQueryRequest;
import com.shengpay.deposit.facade.account.AcctsWithBalanceByMembersQueryResponse;

/**
 * 查询商户基本户、保证金账户余额
 * 
 * @author wangjingao.william
 * **/
@Service("AccountQueryFacadeWrapper")
public class AccountQueryFacadeWrapperImpl implements AccountQueryFacadeWrapper {
	private static final Logger log = LoggerFactory.getLogger(AccountQueryFacadeWrapperImpl.class);

	@Autowired
	private AccountQueryFacade accountQueryFacade;

	public void setAccountQueryFacade(AccountQueryFacade accountQueryFacade) {
		this.accountQueryFacade = accountQueryFacade;
	}

	/**
	 * 根据商户号对应的memberId查询其[基本户]和[保证金账户]余额
	 * 
	 * @param merchantMemberId商户会员号
	 * @return mb
	 * **/
	public MerchantBalanceDTO queryMerchantBalance(String merchantMemberId,String promoterType) throws Exception {
		AcctsWithBalanceByMembersQueryRequest request = AccountQueryFacadeUtil.buildAcctsWithBalanceByMembersQueryRequest(merchantMemberId,promoterType);
		log.info("AccountQueryFacadeWrapperImpl.queryMerchantBalance.request=" + ToStringBuilder.reflectionToString(request));
		AcctsWithBalanceByMembersQueryResponse response = this.accountQueryFacade.queryAcctsByMembers(request);
		log.info("AccountQueryFacadeWrapperImpl.queryMerchantBalance.response=" + ToStringBuilder.reflectionToString(response));
		MerchantBalanceDTO mb = AccountQueryFacadeUtil.buildMerchantBalanceDTO(merchantMemberId, response);
		log.info("AccountQueryFacadeWrapperImpl.queryMerchantBalance.mb=" + ToStringBuilder.reflectionToString(mb));
		return mb;
	}

	/**
	 * 根据商户号批量查询对应的memberId查询其[保证金账户]余额
	 * @param merchantMemberId
	 * @return
	 * @throws Exception
	 */
	public Map<String,MerchantBalanceDTO> queryBatchMerchantBalance(Map<String,String> merchantMemberIdMap) throws Exception {
		AcctsWithBalanceByMembersQueryRequest request = AccountQueryFacadeUtil.buildAcctsWithBalanceByMembersListQueryRequest(merchantMemberIdMap);
		log.info("AccountQueryFacadeWrapperImpl.queryBatchMerchantBalance.request.batch=" + ToStringBuilder.reflectionToString(request));
		AcctsWithBalanceByMembersQueryResponse response = this.accountQueryFacade.queryAcctsByMembers(request);
		log.info("AccountQueryFacadeWrapperImpl.queryBatchMerchantBalance.response.batch=" + ToStringBuilder.reflectionToString(response));
		Map<String,MerchantBalanceDTO> mb = AccountQueryFacadeUtil.buildBatchMerchantBalanceDTO(merchantMemberIdMap, response);
		log.info("AccountQueryFacadeWrapperImpl.queryBatchMerchantBalance.mb.batch=" + ToStringBuilder.reflectionToString(mb));
		return mb;
	}
	
	public MerchantBaseBalanceDTO queryAccountBalanceByAccountType(String memberId, AccountType accountType) {
		try {
			AcctsWithBalanceByMembersQueryRequest request = AccountQueryFacadeUtil.buildAcctsWithBalanceByMembersQueryRequest(memberId, accountType);
			log.info("AccountQueryFacadeWrapperImpl.queryMerchantBalanceByAccountType.request=" + ToStringBuilder.reflectionToString(request));
			AcctsWithBalanceByMembersQueryResponse response = this.accountQueryFacade.queryAcctsByMembers(request);
			log.info("AccountQueryFacadeWrapperImpl.queryMerchantBalanceByAccountType.response=" + ToStringBuilder.reflectionToString(response));
			MerchantBaseBalanceDTO mb = AccountQueryFacadeUtil.buildMerchantBalanceDTO(memberId, accountType, response);
			log.info("AccountQueryFacadeWrapperImpl.queryMerchantBalanceByAccountType.mb=" + ToStringBuilder.reflectionToString(mb));
			return mb;
		} catch (Exception e) {
			log.error("AccountQueryFacadeWrapperImpl.queryMerchantBalanceByAccountType.error,memberId=" + memberId, e);
		}
		return null;
	}

}
