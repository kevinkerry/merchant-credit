package com.sdp.mc.ma.wrapper.impl;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdo.ma.ws.api.request.osr.CreateAccountRequest;
import com.sdo.ma.ws.api.request.osr.GetContactRequest;
import com.sdo.ma.ws.api.request.osr.SetAccountStatusRequest;
import com.sdo.ma.ws.api.response.BaseResponse;
import com.sdo.ma.ws.api.response.osr.CreateAccountResponse;
import com.sdo.ma.ws.api.response.osr.GetContactResponse;
import com.sdo.ma.ws.api.service.osr.IMaOsrFullWS;
import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.enums.ContactType;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.integration.ma.dto.request.MACreateAccountRequestDTO;
import com.sdp.mc.integration.ma.dto.response.MACreateAccountResponseDTO;
import com.sdp.mc.integration.ma.dto.response.MAGetContactResponseDTO;
import com.sdp.mc.ma.wrapper.MaOsrFullServiceWrapper;
import com.sdp.mc.ma.wrapper.utils.MACreateAccountUtil;
import com.sdp.mc.ma.wrapper.utils.MaOsrUtil;

@Service("MaOsrFullServiceWrapper")
public class MaOsrFullServiceWrapperImpl implements MaOsrFullServiceWrapper {

	private static final Logger log = LoggerFactory.getLogger(MaOsrFullServiceWrapperImpl.class);

	@Autowired
	private IMaOsrFullWS maOsrFullService;

	public void setMaOsrFullService(IMaOsrFullWS maOsrFullService) {
		this.maOsrFullService = maOsrFullService;
	}

	/**
	 * 创建储值帐号,帐号类型216表示保证金
	 * 
	 * @param memberId
	 * @param userIp
	 * **/
	public MACreateAccountResponseDTO createAccount(MACreateAccountRequestDTO requestDTO) {
		try {
			CreateAccountRequest request = MACreateAccountUtil.buildCreateAccountRequest(requestDTO);
			log.info("MaOsrFullServiceWrapperImpl.createAccount.request=" + ToStringBuilder.reflectionToString(request));
			CreateAccountResponse response = maOsrFullService.createAccount(request);
			log.info("MaOsrFullServiceWrapperImpl.createAccount.response=" + ToStringBuilder.reflectionToString(response));
			if (response != null) {
				return MACreateAccountUtil.buildMACreateAccountResponseDTO(response);
			}
		} catch (Exception e) {
			log.error("MaOsrFullServiceWrapperImpl.createAccount.error,memberId=" + requestDTO.getMemberId(), e);
			return MACreateAccountUtil.buildFailureMACreateAccountResponseDTO("请求开保证金账户异常");
		}
		return null;
	}

	/**
	 * ma设置储值帐号状态
	 * 
	 * @param memberId
	 *            盛付通会员号
	 * @param accountId
	 *            储值帐号id
	 * @param accountType
	 *            储值帐号类型
	 * @param accountStatus
	 *            状态(0:未激活 1:正常 2:锁定 3:止出 4:止入)
	 * **/
	private ErrorMessageVO setAccountStatus(String memberId, String accountId, Long accountType, Long accountStatus) {
		// 状态(0:未激活 1:正常 2:锁定 3:止出 4:止入)
		try {
			SetAccountStatusRequest request = MACreateAccountUtil.buildSetAccountStatusRequest(memberId, accountId, accountType, accountStatus);
			log.info("MaOsrFullServiceWrapperImpl.setAccountStatus.request=" + ToStringBuilder.reflectionToString(request));
			BaseResponse baseResponse = this.maOsrFullService.setAccountStatus(request);
			log.info("MaOsrFullServiceWrapperImpl.setAccountStatus.response=" + ToStringBuilder.reflectionToString(baseResponse));
			if (baseResponse != null) {
				return MACreateAccountUtil.buildErrorMessage(baseResponse);
			} else {
				return new ErrorMessageVO(false, "-1", "ma未返回结果");
			}
		} catch (Exception e) {
			log.error("MaOsrFullServiceWrapperImpl.setAccountStatus.error,memberId=" + memberId, e);
			return new ErrorMessageVO(false, "-1", "调用MA setAccountStatus接口异常");
		}
	}

	/**
	 * 设置201账户资金止出
	 * 
	 * @param memberId
	 *            盛付通会员号
	 * @param accountId
	 *            储值帐号id
	 * @param accountType
	 *            储值帐号类型
	 * **/
	public ErrorMessageVO checkOut(String memberId, String accountId, AccountType accountType) {
		return this.setAccountStatus(memberId, accountId, accountType.code, 3L);
	}

	/**
	 * 设置201账户资金止入
	 * 
	 * @param memberId
	 *            盛付通会员号
	 * @param accountId
	 *            储值帐号id
	 * @param accountType
	 *            储值帐号类型
	 * **/
	public ErrorMessageVO checkIn(String memberId, String accountId, AccountType accountType) {
		return this.setAccountStatus(memberId, accountId, accountType.code, 4L);
	}

	/**
	 * 设置201账户正常使用
	 * 
	 * @param memberId
	 *            盛付通会员号
	 * @param accountId
	 *            储值帐号id
	 * @param accountType
	 *            储值帐号类型
	 * **/
	public ErrorMessageVO reset2Normal(String memberId, String accountId, AccountType accountType) {
		return this.setAccountStatus(memberId, accountId, accountType.code, 1L);
	}

	/**
	 * 通过 MaOsr 获得会员联系方式
	 * 
	 * @param requestDTO
	 *            memberId contactType
	 * @return
	 */
	public MAGetContactResponseDTO getContactByMemberId(final String memberId, final ContactType contactType) {
		try {
			GetContactRequest request = MaOsrUtil.buildGetContactRequest(memberId, contactType);
			log.info("MaOsrFullServiceWrapperImpl.getContact.request=" + ToStringBuilder.reflectionToString(request));
			GetContactResponse response = maOsrFullService.getContact(request);
			log.info("MaOsrFullServiceWrapperImpl.getContact.response=" + ToStringBuilder.reflectionToString(response));
			if (response != null) {
				return MaOsrUtil.buildMAGetContactResponseDTO(response);
			}
		} catch (Exception e) {
			log.error("MaOsrFullServiceWrapperImpl.getContactByMemberId.error,memberId=" + memberId, e);
		}
		return null;
	}
}
