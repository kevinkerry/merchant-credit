package com.sdp.mc.ma.wrapper.utils;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.sdo.ma.ws.api.model.AccountInfo;
import com.sdo.ma.ws.api.model.MerchantInfo;
import com.sdo.ma.ws.api.model.OperatorIntegratedInfo;
import com.sdo.ma.ws.api.request.RequestHeader;
import com.sdo.ma.ws.api.request.online.CheckPayPwdRequest;
import com.sdo.ma.ws.api.request.online.GetAccountRequest;
import com.sdo.ma.ws.api.request.online.GetMemberInfoRequest;
import com.sdo.ma.ws.api.request.online.GetMemberMappingRequest;
import com.sdo.ma.ws.api.request.online.GetMerchantInfoRequest;
import com.sdo.ma.ws.api.request.online.GetOperatorIntegratedInfoV2Request;
import com.sdo.ma.ws.api.request.osr.GetOperatorsRequest;
import com.sdo.ma.ws.api.response.online.BaseResponseWithExt;
import com.sdo.ma.ws.api.response.online.GetAccountResponse;
import com.sdo.ma.ws.api.response.online.GetMerchantInfoResponse;
import com.sdo.ma.ws.api.response.online.GetOperatorIntegratedInfoResponse;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.util.IPUtils;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.integration.ma.dto.MerchantInfoMADTO;
import com.sdp.mc.integration.ma.dto.Promoter4MADTO;
import com.sdp.mc.integration.ma.dto.request.CheckPayPwdRequestDTO;

public class MaOnlineUtil {

	public static GetAccountRequest buildGetAccountRequest(final String memberId, final String userIp) {
		return buildGetAccountRequest(memberId, userIp, MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN);
	}

	public static GetAccountRequest buildMaAccountRequest(final String memberId, final String userIp) {
		RequestHeader header = new RequestHeader();
		header.setSourceId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);// 来源ID，系统分配,zf号
		header.setRequestNo(UUID.randomUUID().toString());// 请求序列号
		header.setRequestTime(new Date());
		header.setUserIp(userIp);// 用户IP
		header.setAppIp(IPUtils.getLocalIp());// 客户端IP
		header.setVersion("10");// 接口版本号，向下兼容，默认填“10”
		GetAccountRequest request = new GetAccountRequest();
		request.setHeader(header);
		request.setMemberId(memberId);
		return request;
	}
	public static GetAccountRequest buildGetAccountRequest(final String memberId, final String userIp, Long accountType) {
		RequestHeader header = new RequestHeader();
		header.setSourceId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);// 来源ID，系统分配,zf号
		header.setRequestNo(UUID.randomUUID().toString());// 请求序列号
		header.setRequestTime(new Date());
		header.setUserIp(userIp);// 用户IP
		header.setAppIp(IPUtils.getLocalIp());// 客户端IP
		header.setVersion("10");// 接口版本号，向下兼容，默认填“10”
		// String mac = header.generateMac(maKey, SignType.MD5.getCode());
		// header.setMac(mac);

		GetAccountRequest request = new GetAccountRequest();
		request.setHeader(header);
		// request.setAccountId(accountId);
		// request.setAccountType(MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN);
		request.setAccountType(accountType);
		request.setMemberId(memberId);
		// request.setOriginalRequestNo(originalRequestNo);
		return request;
	}

	public static GetAccountRequest buildGetAccountRequest4QueryAccountType(final String memberId, final String accountId, final String userIp) {
		RequestHeader header = new RequestHeader();
		header.setSourceId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);// 来源ID，系统分配,zf号
		header.setRequestNo(UUID.randomUUID().toString());// 请求序列号
		header.setRequestTime(new Date());
		header.setUserIp(userIp);// 用户IP
		header.setAppIp(IPUtils.getLocalIp());// 客户端IP
		header.setVersion("10");// 接口版本号，向下兼容，默认填“10”
		// String mac = header.generateMac(maKey, SignType.MD5.getCode());
		// header.setMac(mac);

		GetAccountRequest request = new GetAccountRequest();
		request.setHeader(header);
		request.setAccountId(accountId);
		request.setMemberId(memberId);
		// request.setAccountType(MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN);
		// request.setOriginalRequestNo(originalRequestNo);
		return request;
	}

	public static Long getAccountType(GetAccountResponse response, final String accountId) {
		if ("0".equals(response.getHeader().getResponseCode())) {
			if (response.getAccountInfoList() != null) {
				for (AccountInfo ai : response.getAccountInfoList()) {
					if (accountId.equals(ai.getAccountId())) {
						return ai.getAccountType();
					}
				}
			}
		}
		return null;
	}

	public static String getAccountId(GetAccountResponse response, final AccountType accountType) {
		if ("0".equals(response.getHeader().getResponseCode())) {
			if (response.getAccountInfoList() != null) {
				for (AccountInfo ai : response.getAccountInfoList()) {
					if (accountType.code == ai.getAccountType().longValue()) {
						return ai.getAccountId();
					}
				}
			}
		}
		return null;
	}
	public static AccountInfo getAccountInfo(GetAccountResponse response) {
		if ("0".equals(response.getHeader().getResponseCode())) {
			if (response.getAccountInfoList() != null) {
				for (AccountInfo ai : response.getAccountInfoList()) {
					if(AccountType.B_BASE_ACCOUNT.code==ai.getAccountType()||AccountType.C_BASE_ACCOUNT.code==ai.getAccountType())
						return ai;
				}
			}
		}
		return null;
	}
	public static GetMerchantInfoRequest buildGetMerchantInfoRequest(final String userMemberId, final String userIp) {
		RequestHeader header = new RequestHeader();
		header.setVersion("10");
		header.setSourceId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		header.setRequestTime(new Date());
		header.setRequestNo(UUID.randomUUID().toString());
		header.setAppIp(IPUtils.getLocalIp());
		header.setUserIp(userIp);

		GetMerchantInfoRequest gmiRequest = new GetMerchantInfoRequest();
		gmiRequest.setHeader(header);
		// 操作员memberId
		gmiRequest.setMemberId(userMemberId);
		return gmiRequest;
	}

	public static GetOperatorsRequest buildGetOperatorsRequest(final String userMemberId) {
		RequestHeader header = new RequestHeader();
		header.setVersion("10");
		header.setSourceId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		header.setRequestTime(new Date());
		header.setRequestNo(UUID.randomUUID().toString());
		header.setAppIp(IPUtils.getLocalIp());

		GetOperatorsRequest gmiRequest = new GetOperatorsRequest();
		gmiRequest.setHeader(header);
		// 操作员memberId
		gmiRequest.setMemberId(userMemberId);
		return gmiRequest;
	}

	public static GetMerchantInfoRequest buildGetMerchantInfoRequest(final String merchantNo) {
		RequestHeader header = new RequestHeader();
		header.setVersion("10");
		header.setSourceId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		header.setRequestTime(new Date());
		header.setRequestNo(UUID.randomUUID().toString());
		header.setAppIp(IPUtils.getLocalIp());
		header.setUserIp(IPUtils.getLocalIp());

		GetMerchantInfoRequest gmiRequest = new GetMerchantInfoRequest();
		gmiRequest.setHeader(header);
		// 操作员memberId
		gmiRequest.setMerchantId(merchantNo);
		return gmiRequest;
	}

	public static GetOperatorIntegratedInfoV2Request buildGetOperatorIntegratedInfoV2Request(String merchantNo) {
		RequestHeader header = new RequestHeader();
		header.setVersion("10");
		header.setSourceId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		header.setRequestTime(new Date());
		header.setRequestNo(UUID.randomUUID().toString());
		header.setAppIp(IPUtils.getLocalIp());
		header.setUserIp(IPUtils.getLocalIp());

		GetOperatorIntegratedInfoV2Request request = new GetOperatorIntegratedInfoV2Request();
		request.setHeader(header);
		request.setMerchantId(merchantNo);
		return request;
	}

	public static Promoter4MADTO buildPromoter4MADTO(GetOperatorIntegratedInfoResponse response) {
		if (response != null && "0".equals(response.getHeader().getResponseCode())) {
			OperatorIntegratedInfo oi = response.getOperatorIntegratedInfo();
			Promoter4MADTO p = new Promoter4MADTO();
			p.setMemberId(oi.getBaseMemberInfo().getMemberId());
			p.setDefaultOperatorId(oi.getOperatorInfo().getOperatorId());
			return p;
		}
		return null;
	}

	public static CheckPayPwdRequest buildCheckPayPwdRequest(CheckPayPwdRequestDTO requestDTO) {
		RequestHeader header = new RequestHeader();
		header.setVersion("10");
		header.setSourceId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		header.setRequestTime(new Date());
		header.setRequestNo(UUID.randomUUID().toString());
		header.setAppIp(IPUtils.getLocalIp());
		header.setUserIp(requestDTO.getUserIp());

		CheckPayPwdRequest request = new CheckPayPwdRequest();
		request.setHeader(header);
		request.setAccountId(requestDTO.getAccountId());
		request.setOperatorId(requestDTO.getOperatorId());
		request.setLoginName(requestDTO.getLoginName());
		request.setPassword(requestDTO.getPassword());
		return request;
	}

	@SuppressWarnings("rawtypes")
	public static ErrorMessageVO buildErrorMessageVO(BaseResponseWithExt response) {
		boolean isSuccess = "0".equals(response.getHeader().getResponseCode());
		return new ErrorMessageVO(isSuccess, response.getHeader().getResponseCode(), response.getHeader().getResponseMessage());
	}

	public static MerchantInfoMADTO buildMerchantInfoMADTO(GetMerchantInfoResponse response) {
		if (response != null && "0".equals(response.getHeader().getResponseCode())) {
			MerchantInfo[] merchantInfos = response.getMerchants();
			if(merchantInfos!=null&&merchantInfos.length>0){
				MerchantInfo merchantInfo=merchantInfos[0];
				MerchantInfoMADTO dto=new MerchantInfoMADTO();
				dto.setMemberId(merchantInfo.getMemberId());
				dto.setMerchantId(merchantInfo.getMerchantId());
				dto.setMerchantName(merchantInfo.getMerchantName());
				dto.setMerchantStatus(merchantInfo.getMerchantStatus());
				dto.setMerchantType(merchantInfo.getMerchantType());
				dto.setPtid(merchantInfo.getPtid());
				return dto;
			}
		}
		return null;
	}
	/**
	 * 会员基本信息查询。memberId和identity二选一。
	 * @param identity
	 * @param memberId
	 * @return
	 */
	public static GetMemberInfoRequest bulidGetMemberInfoRequest(String identity,String memberId){
		GetMemberInfoRequest request=new GetMemberInfoRequest();
		RequestHeader header = new RequestHeader();
		header.setVersion("10");
		header.setSourceId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		header.setRequestTime(new Date());
		header.setRequestNo(UUID.randomUUID().toString());
		header.setAppIp(IPUtils.getLocalIp());
		header.setUserIp(IPUtils.getLocalIp());
		request.setHeader(header);
		if(StringUtils.isNotBlank(identity)){
			request.setIdentity(identity);
		}
		if(StringUtils.isNotBlank(memberId)){
			request.setMemberId(memberId);
		}
		return request;
	}
	/**
	 * 会员基本信息查询。memberId和identity二选一。
	 * @param identity
	 * @param memberId
	 * @return
	 */
	public static GetMemberMappingRequest bulidGetMemberMappingRequest(String id,Long idType){
		GetMemberMappingRequest request=new GetMemberMappingRequest();
		RequestHeader header = new RequestHeader();
		header.setVersion("10");
		header.setSourceId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		header.setRequestTime(new Date());
		header.setRequestNo(UUID.randomUUID().toString());
		header.setAppIp(IPUtils.getLocalIp());
		header.setUserIp(IPUtils.getLocalIp());
		request.setHeader(header);
		request.setId(id);
		request.setIdType(idType);
		return request;
	}
}
