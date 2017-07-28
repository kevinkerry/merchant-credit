package com.sdp.mc.ma.wrapper.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.integration.ma.dto.MerchantBalanceDTO;
import com.sdp.mc.integration.ma.dto.MerchantBaseBalanceDTO;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.shengpay.deposit.facade.account.AccountVO;
import com.shengpay.deposit.facade.account.AcctsWithBalanceByMembersQueryRequest;
import com.shengpay.deposit.facade.account.AcctsWithBalanceByMembersQueryResponse;

public class AccountQueryFacadeUtil {

	public static AcctsWithBalanceByMembersQueryRequest buildAcctsWithBalanceByMembersQueryRequest(String merchantMemberId, String promoterType) throws IOException {
		// 101对私基本户,201 对公基本户,216保证金账户
		int[] subAccountTypes = {MerchantCreditConstant.ACCOUNT_TYPE_4_PUBLIC.intValue(), (PosMerchantTypeEnums.EASYPAY_PROMOTER.code.equals(promoterType)?MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN_EASYPAY:PosMerchantTypeEnums.MPOS_PROMOTER.code.equals(promoterType)?MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN_MPOS:MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN).intValue(),
				MerchantCreditConstant.ACCOUNT_TYPE_4_CREDIT.intValue()};
		Set<String> memberIdSet = new HashSet<String>();
		memberIdSet.add(merchantMemberId);
		AcctsWithBalanceByMembersQueryRequest.Body body = new AcctsWithBalanceByMembersQueryRequest.Body();
		body.setMemberIds(memberIdSet);
		body.setSubAccountTypes(subAccountTypes);
		String bodyJsonGzipBase64Text = AcctsWithBalanceByMembersQueryRequest.generateJsonGzipBase64Text(body);

		AcctsWithBalanceByMembersQueryRequest request = new AcctsWithBalanceByMembersQueryRequest();
		request.setAppId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		request.setBodyJsonGzipBase64Text(bodyJsonGzipBase64Text);
		return request;
	}

	/**
	 * 批量操作
	 * @param merchantMemberIdList
	 * @return
	 * @throws IOException
	 */
	public static AcctsWithBalanceByMembersQueryRequest buildAcctsWithBalanceByMembersListQueryRequest(Map<String,String> merchantMemberIdMap) throws IOException {
		// 101对私基本户,201 对公基本户,216保证金账户
		int[] subAccountTypes = {MerchantCreditConstant.ACCOUNT_TYPE_4_PUBLIC.intValue(), MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN.intValue(),
				MerchantCreditConstant.ACCOUNT_TYPE_4_CREDIT.intValue()};
		Set<String> memberIdSet = new HashSet<String>();
		for (Iterator<String> i = merchantMemberIdMap.keySet().iterator(); i.hasNext();) {
			String key = i.next();
			memberIdSet.add(merchantMemberIdMap.get(key));
		} 
//		for(String memberId : merchantMemberIdList) {
//			memberIdSet.add(memberId);
//		}
		AcctsWithBalanceByMembersQueryRequest.Body body = new AcctsWithBalanceByMembersQueryRequest.Body();
		body.setMemberIds(memberIdSet);
		body.setSubAccountTypes(subAccountTypes);
		String bodyJsonGzipBase64Text = AcctsWithBalanceByMembersQueryRequest.generateJsonGzipBase64Text(body);

		AcctsWithBalanceByMembersQueryRequest request = new AcctsWithBalanceByMembersQueryRequest();
		request.setAppId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		request.setBodyJsonGzipBase64Text(bodyJsonGzipBase64Text);
		return request;
	}
	
	public static AcctsWithBalanceByMembersQueryRequest buildAcctsWithBalanceByMembersQueryRequest(String memberId, AccountType accountType) throws IOException {
		// 101对私基本户,201 对公基本户,216保证金账户
		int[] subAccountTypes = {Long.valueOf(accountType.code).intValue()};
		Set<String> memberIdSet = new HashSet<String>();
		memberIdSet.add(memberId);
		AcctsWithBalanceByMembersQueryRequest.Body body = new AcctsWithBalanceByMembersQueryRequest.Body();
		body.setMemberIds(memberIdSet);
		body.setSubAccountTypes(subAccountTypes);
		String bodyJsonGzipBase64Text = AcctsWithBalanceByMembersQueryRequest.generateJsonGzipBase64Text(body);

		AcctsWithBalanceByMembersQueryRequest request = new AcctsWithBalanceByMembersQueryRequest();
		request.setAppId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		request.setBodyJsonGzipBase64Text(bodyJsonGzipBase64Text);
		return request;
	}

	public static MerchantBalanceDTO buildMerchantBalanceDTO(String merchantMemberId, AcctsWithBalanceByMembersQueryResponse response) throws IOException {
		AcctsWithBalanceByMembersQueryResponse.Body resBody = AcctsWithBalanceByMembersQueryResponse.parse(response.getBodyJsonGzipBase64Text());
		if (resBody == null || resBody.getMemberIdAccountsMap() == null || resBody.getMemberIdAccountsMap().size() == 0) {
			return null;
		}
		List<AccountVO> listAccount = resBody.getMemberIdAccountsMap().get(merchantMemberId);
		MerchantBalanceDTO mb = new MerchantBalanceDTO();
		mb.setMemberId(merchantMemberId);
		for (AccountVO account : listAccount) {
			// 对公基本户
			if (MerchantCreditConstant.ACCOUNT_TYPE_4_PUBLIC.intValue() == account.getAccountSubType()) {
				mb.setPublicAccountId(account.getAccountId());
				mb.setPublicAccountBalance(account.getBalance().getAvailableBalance());
				mb.setPublicAccountStatus(account.getStatus().getCode());
			}
			// 保证金账户
			if (MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN.intValue() == account.getAccountSubType()
					||MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN_EASYPAY.intValue() == account.getAccountSubType()
					||MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN_MPOS.intValue() == account.getAccountSubType()) {
				mb.setMarginAccountId(account.getAccountId());
				mb.setMarginAccountBalance(account.getBalance().getAvailableBalance());
				mb.setMarginAccountStatus(account.getStatus().getCode());
			}
			// 配资专户
			if (MerchantCreditConstant.ACCOUNT_TYPE_4_CREDIT.intValue() == account.getAccountSubType()) {
				mb.setCreditAccountId(account.getAccountId());
				mb.setCreditAccountBalance(account.getBalance().getAvailableBalance());
				mb.setCreditAccountStatus(account.getStatus().getCode());
			}
		}
		return mb;
	}
	
	/**
	 * 批量获取
	 * @param merchantMemberId
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public static Map<String,MerchantBalanceDTO> buildBatchMerchantBalanceDTO(Map<String,String> merchantMemberIdMap, AcctsWithBalanceByMembersQueryResponse response) throws IOException {
		AcctsWithBalanceByMembersQueryResponse.Body resBody = AcctsWithBalanceByMembersQueryResponse.parse(response.getBodyJsonGzipBase64Text());
		if (resBody == null || resBody.getMemberIdAccountsMap() == null || resBody.getMemberIdAccountsMap().size() == 0) {
			return null;
		}
		Map<String,MerchantBalanceDTO> map = new HashMap<String,MerchantBalanceDTO>();
		
		for (Iterator<String> i = merchantMemberIdMap.keySet().iterator(); i.hasNext();) {
			String key = i.next();
			List<AccountVO> listAccount = resBody.getMemberIdAccountsMap().get(merchantMemberIdMap.get(key));
			for (AccountVO account : listAccount) {
				MerchantBalanceDTO mb = new MerchantBalanceDTO();
				mb.setMemberId(account.getMemberId());
				// 对公基本户
				if (MerchantCreditConstant.ACCOUNT_TYPE_4_PUBLIC.intValue() == account.getAccountSubType()) {
					mb.setPublicAccountId(account.getAccountId());
					mb.setPublicAccountBalance(account.getBalance().getAvailableBalance());
					mb.setPublicAccountStatus(account.getStatus().getCode());
				}
				// 保证金账户
				if (MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN.intValue() == account.getAccountSubType()) {
					mb.setMarginAccountId(account.getAccountId());
					mb.setMarginAccountBalance(account.getBalance().getAvailableBalance());
					mb.setMarginAccountStatus(account.getStatus().getCode());
					map.put(account.getMemberId(),mb); //将保证金账户余额放入map
				}
				// 配资专户
				if (MerchantCreditConstant.ACCOUNT_TYPE_4_CREDIT.intValue() == account.getAccountSubType()) {
					mb.setCreditAccountId(account.getAccountId());
					mb.setCreditAccountBalance(account.getBalance().getAvailableBalance());
					mb.setCreditAccountStatus(account.getStatus().getCode());
				}
			}
		} 
		return map;
	}
	
	public static MerchantBaseBalanceDTO buildMerchantBalanceDTO(String memberId, AccountType accountType, AcctsWithBalanceByMembersQueryResponse response) throws IOException {
		AcctsWithBalanceByMembersQueryResponse.Body resBody = AcctsWithBalanceByMembersQueryResponse.parse(response.getBodyJsonGzipBase64Text());
		if (resBody == null || resBody.getMemberIdAccountsMap() == null || resBody.getMemberIdAccountsMap().size() == 0) {
			return null;
		}
		List<AccountVO> listAccount = resBody.getMemberIdAccountsMap().get(memberId);
		MerchantBaseBalanceDTO mb = new MerchantBaseBalanceDTO();
		mb.setMemberId(memberId);
		for (AccountVO account : listAccount) {
			if (accountType.code == account.getAccountSubType()) {
				mb.setAccountId(account.getAccountId());
				mb.setAccountBalance(account.getBalance().getAvailableBalance());
				mb.setAccountStatus(account.getStatus().getCode());
				return mb;
			}
		}
		return null;
	}
}
