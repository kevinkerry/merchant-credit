package com.sdp.mc.ma.wrapper.utils;

import java.util.Date;
import java.util.UUID;

import com.sdo.ma.ws.api.request.RequestHeader;
import com.sdo.ma.ws.api.request.osr.CreateAccountRequest;
import com.sdo.ma.ws.api.request.osr.SetAccountStatusRequest;
import com.sdo.ma.ws.api.response.BaseResponse;
import com.sdo.ma.ws.api.response.osr.CreateAccountResponse;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.util.IPUtils;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.integration.ma.dto.request.MACreateAccountRequestDTO;
import com.sdp.mc.integration.ma.dto.response.MACreateAccountResponseDTO;

public class MACreateAccountUtil {

	public static CreateAccountRequest buildCreateAccountRequest(MACreateAccountRequestDTO requestDTO) {
		RequestHeader header = new RequestHeader();
		header.setSourceId(requestDTO.getSourceId());// 来源ID，系统分配,zf号
		header.setRequestNo(requestDTO.getRequestNo());// 请求序列号
		header.setRequestTime(requestDTO.getRequestTime());
		header.setUserIp(requestDTO.getUserIp());// 用户IP
		header.setAppIp(IPUtils.getLocalIp());// 客户端IP
		header.setVersion("10");// 接口版本号，向下兼容，默认填“10”
		header.setRequestOperator(requestDTO.getRequestOperator());
		// String mac = header.generateMac(maKey, SignType.MD5.getCode());
		// header.setMac(mac);
		CreateAccountRequest request = new CreateAccountRequest();
		request.setHeader(header);
		request.setAccountType(requestDTO.getAccountType().code);
		request.setMemberId(requestDTO.getMemberId());
		request.setCurrencyCode("CNY");
		return request;
	}

	public static MACreateAccountResponseDTO buildMACreateAccountResponseDTO(CreateAccountResponse response) {
		MACreateAccountResponseDTO responseDTO = new MACreateAccountResponseDTO("0".equals(response.getHeader().getResponseCode()));
		responseDTO.setAccountId(response.getAccountId());
		responseDTO.setRequestNo(response.getHeader().getRequestNo());
		responseDTO.setResponseCode(response.getHeader().getResponseCode());
		responseDTO.setResponseMessage(response.getHeader().getResponseMessage());
		return responseDTO;
	}

	
	public static MACreateAccountResponseDTO buildFailureMACreateAccountResponseDTO(String message) {
		MACreateAccountResponseDTO responseDTO = new MACreateAccountResponseDTO(false);
		responseDTO.setResponseCode("-1");
		responseDTO.setResponseMessage(message);
		return responseDTO;
	}

	public static SetAccountStatusRequest buildSetAccountStatusRequest(String memberId, String accountId, Long accountType, Long accountStatus) {
		RequestHeader header = new RequestHeader();
		header.setSourceId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);// 来源ID，系统分配,zf号
		header.setRequestNo(UUID.randomUUID().toString());// 请求序列号
		header.setRequestTime(new Date());
		header.setUserIp(IPUtils.getLocalIp());// 用户IP
		header.setAppIp(IPUtils.getLocalIp());// 客户端IP
		header.setRequestOperator("tiantiandai");
		header.setVersion("10");

		SetAccountStatusRequest request = new SetAccountStatusRequest();
		request.setHeader(header);
		request.setMemberId(memberId);
		request.setAccountId(accountId);
		request.setAccountType(accountType);
		request.setAccountStatus(accountStatus);
		return request;
	}

	public static ErrorMessageVO buildErrorMessage(BaseResponse baseResponse) {
		ErrorMessageVO errorMessage = new ErrorMessageVO("0".equals(baseResponse.getHeader().getResponseCode()));
		errorMessage.setErrorCode(baseResponse.getHeader().getResponseCode());
		errorMessage.setErrorMessage(baseResponse.getHeader().getResponseMessage());
		return errorMessage;
	}
}
