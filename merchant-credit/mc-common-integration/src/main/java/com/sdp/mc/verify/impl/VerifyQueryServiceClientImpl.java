package com.sdp.mc.verify.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.verify.VerifyQueryServiceClient;
import com.shengpay.mpos.realname.MerchantRealNameAuth;
import com.shengpay.verify.common.facade.VerifyQueryService;
import com.shengpay.verify.common.facade.enums.IdCardStatus;
import com.shengpay.verify.common.facade.model.VerifyInfo;

@Service
public class VerifyQueryServiceClientImpl implements VerifyQueryServiceClient {

	private static Logger logger = LoggerFactory.getLogger(VerifyQueryServiceClientImpl.class);

	@Autowired
	private VerifyQueryService verifyQueryService;
	@Autowired(required=false)
	private MerchantRealNameAuth merchantRealNameAuth;

	@Override
	public boolean authenticateVerifyInfoByMemberid(String memberId) {
		try {
			logger.info("VerifyQueryServiceClientImpl.authenticateVerifyInfoByMemberid memberId=" + memberId);
			VerifyInfo verifyInfo = verifyQueryService.queryVerifyInfoByMemberid(memberId);
			if (verifyInfo != null) {
				String certNo = verifyInfo.getCertNo();
				String bankCardNo = verifyInfo.getBankCardNo();
				verifyInfo.setBankCardNo(null);// log不计入敏感信息
				verifyInfo.setCertNo(certNo == null || certNo.length() < 2 ? null : "****" + certNo.substring(certNo.length() - 2));// log不计入敏感信息
				logger.info("VerifyQueryServiceClientImpl.authenticateVerifyInfoByMemberid memberId=" + memberId + " verifyInfo without BankCardNo and CertNo="
						+ ToStringBuilder.reflectionToString(verifyInfo, ToStringStyle.SHORT_PREFIX_STYLE));
				verifyInfo.setBankCardNo(bankCardNo);
				verifyInfo.setCertNo(certNo);
			} else {
				logger.info("VerifyQueryServiceClientImpl.authenticateVerifyInfoByMemberid memberId=" + memberId + " verifyInfo=null");
			}
			if (verifyInfo != null && verifyInfo.getIdCardStatus() == IdCardStatus.IDENTITY_INFO_VERIFIED) {
				return true;
			}
		} catch (Exception e) {
			logger.error("VerifyQueryServiceClientImpl.authenticateVerifyInfoByMemberid", e);
		}
		return false;
	}

	@Override
	public VerifyInfo queryVerifyInfoByMemberid(String memberId) {
		// 只是简单查询出来，以后如果有业务扩展，方便统一修改
		try {
			logger.info("VerifyQueryServiceClientImpl.queryVerifyInfoByMemberid memberId=" + memberId);
			VerifyInfo verifyInfo = verifyQueryService.queryVerifyInfoByMemberid(memberId);
			if (verifyInfo != null) {
				String certNo = verifyInfo.getCertNo();
				String bankCardNo = verifyInfo.getBankCardNo();
				verifyInfo.setBankCardNo(null);// log不计入敏感信息
				verifyInfo.setCertNo(certNo == null || certNo.length() < 2 ? null : "****" + certNo.substring(certNo.length() - 2));// log不计入敏感信息
				logger.info("VerifyQueryServiceClientImpl.queryVerifyInfoByMemberid memberId=" + memberId + " verifyInfo without BankCardNo and CertNo="
						+ ToStringBuilder.reflectionToString(verifyInfo, ToStringStyle.SHORT_PREFIX_STYLE));
				verifyInfo.setBankCardNo(bankCardNo);
				verifyInfo.setCertNo(certNo);
			} else {
				logger.info("VerifyQueryServiceClientImpl.queryVerifyInfoByMemberid memberId=" + memberId + " verifyInfo=null");
			}
			return verifyInfo;
		} catch (Exception e) {
			logger.error("VerifyQueryServiceClientImpl.queryVerifyInfoByMemberid", e);
		}
		return null;
	}
	@Override
	public List<String> getMemberIdsByMercnhantNo(String merchantNo) {
		// 只是简单查询出来，以后如果有业务扩展，方便统一修改
		try {
			logger.info("getMemberIdsByMercnhantNo merchantNo=" + merchantNo);
			String certNo=merchantRealNameAuth.getAuthQueryCertNo(merchantNo);
			if (StringUtils.isNotBlank(certNo)) {
				return getMemberIdsByIdcardNoNew(certNo);
			} else {
				logger.info("getMemberIdsByMemberId merchantNo=" + merchantNo + " certNo=null");
			}
		} catch (Exception e) {
			logger.error("getMemberIdsByMemberId is Exception", e);
		}
		return null;
	}
	@Override
	public List<String> getMemberIdsByIdcardNoNew(String idcardNo) {
		// 只是简单查询出来，以后如果有业务扩展，方便统一修改
		try {
			logger.info("getMemberIdsByIdcardNoNew idcardNo=" + (idcardNo == null || idcardNo.length() < 2 ? null : "****" + idcardNo.substring(idcardNo.length() - 4)));
			List<String>  memberIds= verifyQueryService.getMemberIdsByIdcardNoNew(idcardNo);
			if (memberIds != null) {
				logger.info("getMemberIdsByIdcardNoNew memberIds="
						+ ToStringBuilder.reflectionToString(memberIds, ToStringStyle.SHORT_PREFIX_STYLE));
			} else {
				logger.info("getMemberIdsByIdcardNoNew memberIds is null");
			}
			return memberIds;
		} catch (Exception e) {
			logger.error("getMemberIdsByIdcardNoNew is Exception", e);
		}
		return null;
	}

	public VerifyQueryService getVerifyQueryService() {
		return verifyQueryService;
	}

	public void setVerifyQueryService(VerifyQueryService verifyQueryService) {
		this.verifyQueryService = verifyQueryService;
	}
	
	
}
