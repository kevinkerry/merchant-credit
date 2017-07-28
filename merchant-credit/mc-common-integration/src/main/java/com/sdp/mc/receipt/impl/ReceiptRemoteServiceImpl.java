package com.sdp.mc.receipt.impl;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.integration.receipt.dto.request.FundOutReceiptSubmitRequestDTO;
import com.sdp.mc.integration.receipt.dto.response.ReceiptResultDTO;
import com.sdp.mc.receipt.ReceiptRemoteService;
import com.sdp.mc.receipt.utils.RceiptTransferUtil;
import com.shengpay.receipt.client.ReceiptClient;
import com.shengpay.receipt.model.FundOutReceiptSubmitRequest;
import com.shengpay.receipt.model.ReceiptResult;
import com.shengpay.receipt.ws.ReceiptRepositoryRemoteService;

@Service
public class ReceiptRemoteServiceImpl implements ReceiptRemoteService {
	private static final Logger log = LoggerFactory.getLogger(ReceiptRemoteServiceImpl.class);
	@Autowired
	ReceiptClient receiptClient;
	@Autowired
	ReceiptRepositoryRemoteService receiptRepositoryRemoteService;
	@Override
	public ReceiptResultDTO submitFundOutReceipt(
			FundOutReceiptSubmitRequestDTO requestDTO) {
		if(requestDTO == null){
			log.info("ReceiptRemoteServiceImpl.submitFundOutReceipt.requestDTO == null");
			return null;
		}
		log.info("ReceiptRemoteServiceImpl.submitFundOutReceipt.requestDTO=" + ToStringBuilder.reflectionToString(requestDTO));
		FundOutReceiptSubmitRequest request = RceiptTransferUtil.buildFundOutReceiptSubmitRequest(requestDTO);
		if(request == null){
			log.info("ReceiptRemoteServiceImpl.submitFundOutReceipt.request== null");
			return null;
		}
		log.info("ReceiptRemoteServiceImpl.submitFundOutReceipt.request=" + ToStringBuilder.reflectionToString(request));
		receiptClient.signature(request);
		log.info("ReceiptRemoteServiceImpl.submitFundOutReceipt.request after signature =" + ToStringBuilder.reflectionToString(request));
		ReceiptResult receiptResult = receiptRepositoryRemoteService.submitFundOutReceipt(request);
		if(receiptResult != null){
			log.info("ReceiptRemoteServiceImpl.submitFundOutReceipt.receiptResult="  + ToStringBuilder.reflectionToString(receiptResult));
			ReceiptResultDTO receiptResultDTO = RceiptTransferUtil.buildReceiptResultDTO(receiptResult);
			return receiptResultDTO;
		}else{
			log.info("ReceiptRemoteServiceImpl.submitFundOutReceipt.receiptResult is null");
			return null;
		}
	}

}
