package com.sdp.mc.ma.wrapper.utils;

import java.util.Date;
import java.util.UUID;

import com.sdo.ma.ws.api.request.RequestHeader;
import com.sdo.ma.ws.api.request.osr.GetContactRequest;
import com.sdo.ma.ws.api.response.osr.GetContactResponse;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.ContactType;
import com.sdp.mc.common.util.IPUtils;
import com.sdp.mc.integration.ma.dto.request.MAGetContactRequestDTO;
import com.sdp.mc.integration.ma.dto.response.MAGetContactResponseDTO;

public class MaOsrUtil {

	public static MAGetContactRequestDTO buildMAGetContactRequestDTO(final String memberId, final String requestOperator, ContactType contactType, final String userIp) {
		MAGetContactRequestDTO req = new MAGetContactRequestDTO();
		req.setSourceId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);// 来源ID，系统分配,zf号
		req.setRequestNo(UUID.randomUUID().toString());// 请求序列号
		req.setRequestTime(new Date());
		req.setUserIp(userIp);// 用户IP
		req.setAppIp(IPUtils.getLocalIp());// 客户端IP
		req.setMemberId(memberId);
		// requestOperator，不是必填项
		req.setRequestOperator(requestOperator);
		req.setContactType(contactType);
		return req;
	}

	public static GetContactRequest buildGetContactRequest(MAGetContactRequestDTO requestDTO) {
		GetContactRequest contactRequest = new GetContactRequest();
		RequestHeader header = new RequestHeader();
		header.setSourceId(requestDTO.getSourceId());// 来源ID，系统分配,zf号
		header.setRequestNo(requestDTO.getRequestNo());// 请求序列号
		header.setRequestTime(requestDTO.getRequestTime());
		header.setUserIp(requestDTO.getUserIp());// 用户IP
		header.setAppIp(IPUtils.getLocalIp());// 客户端IP
		header.setVersion("10");// 接口版本号，向下兼容，默认填“10”
		header.setRequestOperator(requestDTO.getRequestOperator());

		contactRequest.setContactType(requestDTO.getContactType().code);
		contactRequest.setTargetId(requestDTO.getMemberId());
		contactRequest.setHeader(header);
		return contactRequest;
	}

	public static GetContactRequest buildGetContactRequest(final String memberId, final ContactType contactType) {
		MAGetContactRequestDTO maGetContactRequestDTO = buildMAGetContactRequestDTO(memberId, null, contactType, IPUtils.getServerIp());
		return buildGetContactRequest(maGetContactRequestDTO);
	}

	public static MAGetContactResponseDTO buildMAGetContactResponseDTO(GetContactResponse response) {
		MAGetContactResponseDTO responseDTO = new MAGetContactResponseDTO("0".equals(response.getHeader().getResponseCode()));
		responseDTO.setAddress(response.getContact().getAddress());
		responseDTO.setCityCode(response.getContact().getCityCode());
		responseDTO.setContactName(response.getContact().getContactName());
		responseDTO.setCountryCode(response.getContact().getCountryCode());
		responseDTO.setDept(response.getContact().getDept());
		responseDTO.setEmail(response.getContact().getEmail());
		responseDTO.setFax(response.getContact().getFax());
		responseDTO.setMobile(response.getContact().getMobile());
		responseDTO.setMsn(response.getContact().getMsn());
		responseDTO.setPosition(response.getContact().getPosition());
		responseDTO.setPostcode(response.getContact().getPostcode());
		responseDTO.setProvinceCode(response.getContact().getProvinceCode());
		responseDTO.setQq(response.getContact().getQq());
		responseDTO.setTel(response.getContact().getTel());
		responseDTO.setTown(response.getContact().getTown());

		responseDTO.setRequestNo(response.getHeader().getRequestNo());
		responseDTO.setResponseCode(response.getHeader().getResponseCode());
		responseDTO.setResponseMessage(response.getHeader().getResponseMessage());
		return responseDTO;
	}
}
