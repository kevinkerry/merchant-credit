package com.sdp.mc.fos.wrapper.impl;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.fos.model.WithdrawRequest;
import com.sdp.fos.model.WithdrawResponse;
import com.sdp.fos.service.WithdrawService;
import com.sdp.mc.fos.wrapper.WithdrawServiceWrapper;
import com.sdp.mc.fos.wrapper.utils.FOSTransferUtil;
import com.sdp.mc.integration.fos.dto.request.WithdrawT0QueryRequestDTO;
import com.sdp.mc.integration.fos.dto.request.WithdrawT0RequestDTO;
import com.sdp.mc.integration.fos.dto.response.WithdrawT0QueryResponseDTO;
import com.sdp.mc.integration.fos.dto.response.WithdrawT0ResponseDTO;
import com.shengpay.fos.model.WithdrawQueryRequest;
import com.shengpay.fos.model.WithdrawQueryResponse;
import com.shengpay.fos.ws.WithdrawQueryService;

@Service("withdrawServiceWrapper")
public class WithdrawServiceWrapperImpl implements WithdrawServiceWrapper{

	private static final Logger logger = LoggerFactory.getLogger(WithdrawServiceWrapperImpl.class);

	@Autowired
	private WithdrawService withdrawService;
	@Autowired
	private WithdrawQueryService withdrawQueryService;

//	@Value("${fos.service.withdraw.callback.url}")
//	private String fosCallbackURL;



	/**
	 * FOS出款
	 * @param request
	 * @return
	 */
	@Override
	public WithdrawT0ResponseDTO withdraw(WithdrawT0RequestDTO t0request) {
		// TODO Auto-generated method stub
		WithdrawRequest request = this.buildWithRequestAndSetCallbackAddress(t0request);
		logger.info("WithdrawServiceWrapperImpl.withdraw.request=" + ToStringBuilder.reflectionToString(request));
		WithdrawResponse response = withdrawService.withdraw(request);
		logger.info("WithdrawServiceWrapperImpl.withdraw.response=" + ToStringBuilder.reflectionToString(response));
		return new WithdrawT0ResponseDTO(response.getReturnCode(),response.getReturnMsg(),response.getExtention());
	}

	/**
	 * FOS出款状态查询
	 */
	@Override
	public WithdrawT0QueryResponseDTO withdrawQuery(WithdrawT0QueryRequestDTO t0request) {
		// TODO Auto-generated method stub
		WithdrawT0QueryResponseDTO responseDTO = new WithdrawT0QueryResponseDTO();
		WithdrawQueryRequest request = buildWithQueryRequest(t0request);
		logger.info("WithdrawServiceWrapperImpl.withdrawQuery.request=" + ToStringBuilder.reflectionToString(request));
		WithdrawQueryResponse response = withdrawQueryService.queryWithdrawResult(request);
		logger.info("WithdrawServiceWrapperImpl.withdrawQuery.response=" + ToStringBuilder.reflectionToString(response));
		if (response==null) {
			return null;
		}
		if(response.getPaymentResult()!=null){
		    logger.info("WithdrawServiceWrapperImpl.withdrawQuery response.getPaymentResult=" + ToStringBuilder.reflectionToString(response.getPaymentResult()));
		}
		responseDTO.setReturnCode(response.getReturnCode());
		responseDTO.setReturnMsg(response.getReturnMsg());
		BeanUtils.copyProperties(response.getPaymentResult(), responseDTO.getPaymentResult());
		return responseDTO;
	}

	/**
	 * FOS状态查询请求参数
	 * @param t0request
	 * @return
	 */
	private WithdrawQueryRequest buildWithQueryRequest(WithdrawT0QueryRequestDTO t0request) {
		// TODO Auto-generated method stub
		WithdrawQueryRequest request = FOSTransferUtil.buildWithdrawQueryRequest(t0request);
		return request;
	}


	/**
	 * 封装转账数据
	 * @param t0request
	 * @return
	 */
	private WithdrawRequest buildWithRequestAndSetCallbackAddress(WithdrawT0RequestDTO t0request) {
		// TODO Auto-generated method stub
		WithdrawRequest request = FOSTransferUtil.buildWithdrawRequest(t0request);
		return request;
	}


}
