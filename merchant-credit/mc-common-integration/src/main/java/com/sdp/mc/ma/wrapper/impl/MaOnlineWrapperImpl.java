package com.sdp.mc.ma.wrapper.impl;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdo.common.lang.StringUtil;
import com.sdo.common.util.DateUtil;
import com.sdo.ma.ws.api.model.AccountInfo;
import com.sdo.ma.ws.api.model.MerchantInfo;
import com.sdo.ma.ws.api.request.RequestHeader;
import com.sdo.ma.ws.api.request.online.CheckPayPwdRequest;
import com.sdo.ma.ws.api.request.online.GetAccountRequest;
import com.sdo.ma.ws.api.request.online.GetMemberInfoRequest;
import com.sdo.ma.ws.api.request.online.GetMemberMappingRequest;
import com.sdo.ma.ws.api.request.online.GetMerchantInfoRequest;
import com.sdo.ma.ws.api.request.online.GetOperatorIntegratedInfoV2Request;
import com.sdo.ma.ws.api.response.online.BaseResponseWithExt;
import com.sdo.ma.ws.api.response.online.GetAccountResponse;
import com.sdo.ma.ws.api.response.online.GetMemberInfoResponse;
import com.sdo.ma.ws.api.response.online.GetMerchantInfoResponse;
import com.sdo.ma.ws.api.response.online.GetOperatorIntegratedInfoResponse;
import com.sdo.ma.ws.api.response.online.MemberMappingResponse;
import com.sdo.ma.ws.api.service.online.IMaOnlineWS;
import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.enums.CheckPayPwdEnums;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.integration.ma.dto.MerchantInfoMADTO;
import com.sdp.mc.integration.ma.dto.PersionalInfoDTO;
import com.sdp.mc.integration.ma.dto.Promoter4MADTO;
import com.sdp.mc.integration.ma.dto.request.CheckPayPwdRequestDTO;
import com.sdp.mc.ma.wrapper.MaOnlineWrapper;
import com.sdp.mc.ma.wrapper.UesRemoteServiceClient;
import com.sdp.mc.ma.wrapper.utils.MaOnlineUtil;
import com.sdp.mc.ues.UESClient;
import com.shengpay.ues.model.UesResult;

@Service("MaOnlineWrapper")
public class MaOnlineWrapperImpl implements MaOnlineWrapper {

	private static final Logger log = LoggerFactory.getLogger(MaOnlineWrapper.class);

	@Autowired
	private IMaOnlineWS maOnline;
	@Autowired
	private UESClient uesClient;

	public void setMaOnline(IMaOnlineWS maOnline) {
		this.maOnline = maOnline;
	}

	public UesResult getCert() {
		return uesClient.getCert();
	}

	/**
	 * 查询储值帐号id，判断帐号是否已经创建成功
	 * @param memberId
	 * @param userIp
	 * **/
	public String queryAccount(final String memberId, final String userIp, final AccountType accountType) {
		GetAccountRequest request = MaOnlineUtil.buildGetAccountRequest(memberId, userIp, accountType.code);
		log.info("MaOnlineWrapperImpl.queryAccount.accountType=" + accountType + ",request=" + ToStringBuilder.reflectionToString(request));
		GetAccountResponse response = this.maOnline.getAccount(request);
		log.info("MaOnlineWrapperImpl.queryAccount.accountType=" + accountType + ",response=" + ToStringBuilder.reflectionToString(response));
		return MaOnlineUtil.getAccountId(response, accountType);
	}
	 public AccountInfo queryBaseAccountInfo(final String memberId, final String userIp) {
		GetAccountRequest request = MaOnlineUtil.buildMaAccountRequest(memberId, userIp);
		log.info("MaOnlineWrapperImpl.queryAccount="  + ",request=" + ToStringBuilder.reflectionToString(request));
		GetAccountResponse response = this.maOnline.getAccount(request);
		log.info("MaOnlineWrapperImpl.queryAccount response=" + ToStringBuilder.reflectionToString(response));
		return MaOnlineUtil.getAccountInfo(response);
	}
	public Long queryAccountType(final String memberId, final String accountId, final String userIp) {
		GetAccountRequest request = MaOnlineUtil.buildGetAccountRequest4QueryAccountType(memberId, accountId, userIp);
		log.info("MaOnlineWrapperImpl.queryAccountType.accountId=" + accountId + ",request=" + ToStringBuilder.reflectionToString(request));
		GetAccountResponse response = this.maOnline.getAccount(request);
		log.info("MaOnlineWrapperImpl.queryAccountType.accountId=" + accountId + ",response=" + ToStringBuilder.reflectionToString(response));
		return MaOnlineUtil.getAccountType(response, accountId);
	}

	/**
	 * 根据登录用户查询商户号
	 *
	 * @param loginUserMemberId
	 * @param userIp
	 * **/
	public String queryMerchantNoByUserMemberId(final String loginUserMemberId, final String userIp) {
		GetMerchantInfoRequest gmiRequest = MaOnlineUtil.buildGetMerchantInfoRequest(loginUserMemberId, userIp);
		log.info("MaOnlineWrapperImpl.queryMerchantNoByUserMemberId.request=" + ToStringBuilder.reflectionToString(gmiRequest));
		GetMerchantInfoResponse gmiResponse = this.maOnline.getMerchantInfo(gmiRequest);
		log.info("MaOnlineWrapperImpl.queryMerchantNoByUserMemberId.response=" + ToStringBuilder.reflectionToString(gmiResponse));
		if (gmiResponse == null || gmiResponse.getMerchants() == null || gmiResponse.getMerchants().length == 0) {
			return null;
		}
		MerchantInfo[] merchantInfos = gmiResponse.getMerchants();
		return merchantInfos[0].getMerchantId();
	}

	/**
	 * 验证支付密码；如果密码错误返回扩展信息。
	 *
	 * @param requestDTO
	 * @return #ErrorMessageVO
	 */
	@SuppressWarnings("rawtypes")
	public ErrorMessageVO checkPayPwd(final CheckPayPwdRequestDTO requestDTO) {
		requestDTO.setPassword(getPayPwd(requestDTO.getEnKey(), requestDTO.getCertNo(), requestDTO.getPassword()));
		CheckPayPwdRequest request = MaOnlineUtil.buildCheckPayPwdRequest(requestDTO);
		log.info("MaOnlineWrapperImpl.checkPayPwd.request=" + ToStringBuilder.reflectionToString(request));
		// 李旭阳建议用扩展方法
		BaseResponseWithExt response = this.maOnline.checkPayPwdWithExt(request);
		log.info("MaOnlineWrapperImpl.checkPayPwd.response=" + ToStringBuilder.reflectionToString(response));
		ErrorMessageVO errorMessageVO = MaOnlineUtil.buildErrorMessageVO(response);
		CheckPayPwdEnums payPwdEnums = CheckPayPwdEnums.getEnumsByCode(errorMessageVO.getErrorCode());
		if (payPwdEnums != null)
			errorMessageVO.setErrorMessage(payPwdEnums.desc);
		return errorMessageVO;
	}

	private String getPayPwd(String enKey, String certNo, String password) {
		String maPwd = null;
		try {
			if (StringUtil.isNotBlank(enKey)) {
				// 通过ues加密支付密码
				// String ticket = uesRemoteServiceClient.encryptData(password);
				String ticket = uesClient.getCtrlPassword(enKey, password, certNo);
				maPwd = UesRemoteServiceClient.PAYPWD_PREFIX + ticket;
			} else {
				// 控件不支持苹果系列的操作系统
				// maPwd = uesRemoteServiceClient.encryptData(password);
				maPwd = uesClient.encryptPassword(password);
			}
		} catch (Exception e) {
			log.error("MaOnlineWrapper #getPayPwd(),enKey:" + enKey + ",certNo:" + certNo + ",password:" + password);
			return null;
		}
		return maPwd;
	}

	/**
	 * 根据商户号查询对应的memberId和默认的操作员id
	 *
	 * @param merchantNo商户号
	 * **/
	public Promoter4MADTO queryPromoterInfoByMerchantNo(String merchantNo) {
		try {
			GetOperatorIntegratedInfoV2Request request = MaOnlineUtil.buildGetOperatorIntegratedInfoV2Request(merchantNo);
			log.info("MaOnlineWrapperImpl.queryPromoterInfoByMerchantNo.merchantNo=" + merchantNo + ",request=" + ToStringBuilder.reflectionToString(request));
			GetOperatorIntegratedInfoResponse response = this.maOnline.getOperatorIntegratedInfoV2(request);
			log.info("MaOnlineWrapperImpl.queryPromoterInfoByMerchantNo.merchantNo=" + merchantNo + ",response=" + ToStringBuilder.reflectionToString(response));
			Promoter4MADTO p = MaOnlineUtil.buildPromoter4MADTO(response);
			if (p != null) {
				p.setMerchantNo(merchantNo);
			}
			return p;
		} catch (Exception e) {
			log.error("MaOnlineWrapper.queryPromoterInfoByMerchantNo,merchantNo" + merchantNo, e);
		}
		return null;
	}
	/**
	 * 根据商户号查询对应的memberId和默认的操作员id
	 *
	 * @param merchantNo商户号
	 * **/
	public MerchantInfoMADTO queryMAMerchantInfoByMerchantNo(String merchantNo) {
		try {
			GetMerchantInfoRequest request = MaOnlineUtil.buildGetMerchantInfoRequest(merchantNo);
			log.info("MaOnlineWrapperImpl.queryPromoterInfoByMerchantNo.merchantNo=" + merchantNo + ",request=" + ToStringBuilder.reflectionToString(request));
			GetMerchantInfoResponse response = this.maOnline.getMerchantInfo(request);
			log.info("MaOnlineWrapperImpl.queryPromoterInfoByMerchantNo.merchantNo=" + merchantNo + ",response=" + ToStringBuilder.reflectionToString(response));
			MerchantInfoMADTO dto = MaOnlineUtil.buildMerchantInfoMADTO(response);
			if(dto!=null){
				dto.setMerchantNo(merchantNo);
			}
			return dto;
		} catch (Exception e) {
			log.error("MaOnlineWrapper.queryPromoterInfoByMerchantNo,merchantNo" + merchantNo, e);
		}
		return null;
	}

	public PersionalInfoDTO getPersionalMemberId(String loginName) {
		PersionalInfoDTO persionalInfoDTO = new PersionalInfoDTO();
		persionalInfoDTO.setLoginName(loginName);
		RequestHeader header = new RequestHeader();
		header.setRequestNo(DateUtil.format(new Date(), "yyyyMMddHHmmssSSS"));
		header.setRequestTime(new Date());
		header.setSourceId("debit-service");
		header.setVersion("10");

		GetOperatorIntegratedInfoV2Request request = new GetOperatorIntegratedInfoV2Request();
		request.setHeader(header);
		request.setMemberLoginName(loginName);
		request.setRequireAccounts(true);
		request.setAccountTypes(new long[]{101l});
		log.info("fillUserInfo ， request = " + request);
		GetOperatorIntegratedInfoResponse response = maOnline.getOperatorIntegratedInfoV2(request);
		log.info("fillUserInfo ， response = " + response);
		if (response != null && "0".equals(response.getHeader().getResponseCode())) {
			AccountInfo[] accounts = response.getOperatorIntegratedInfo().getAccounts();
			if (accounts != null && accounts.length > 0) {
				persionalInfoDTO.setWalletAccount(accounts[0].getAccountId());
			}
			persionalInfoDTO.setMemberId(response.getOperatorIntegratedInfo().getBaseMemberInfo().getMemberId());
			if (response.getOperatorIntegratedInfo().getOperatorInfo() != null) {
				persionalInfoDTO.setOperatorId(response.getOperatorIntegratedInfo().getOperatorInfo().getOperatorId());
			}
		} else {
			return null;
		}
		return persionalInfoDTO;

	}
	/**
	 * 会员基本信息查询。memberId和identity二选一。
	 * memberId	String	N	会员编号
	 * identity	String	N	登录标识（登录名）
	 *
	 */
	public GetMemberInfoResponse getMemberInfo(final String identity,final String memberId) {
		GetMemberInfoRequest request = MaOnlineUtil.bulidGetMemberInfoRequest(identity,memberId);
		log.info("getMemberInfo.request=" + ToStringBuilder.reflectionToString(request));
		GetMemberInfoResponse gmiResponse = this.maOnline.getMemberInfo(request);
		log.info("getMemberInfo.response=" + ToStringBuilder.reflectionToString(gmiResponse));
		return gmiResponse;
	}
	/**
	 * 会员基本信息查询。memberId和identity二选一。
	 * memberId	String	N	会员编号
	 * identity	String	N	登录标识（登录名）
	 *
	 */
	public MemberMappingResponse getMemberMapping(final String id,final Long idType) {
		GetMemberMappingRequest request = MaOnlineUtil.bulidGetMemberMappingRequest(id,idType);
		log.info("getMemberMapping.request=" + ToStringBuilder.reflectionToString(request));
		MemberMappingResponse gmiResponse = this.maOnline.getMemberMapping(request);
		log.info("getMemberMapping.response=" + ToStringBuilder.reflectionToString(gmiResponse));
		return gmiResponse;
	}
}
