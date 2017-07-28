package com.sdp.mc.fos.wrapper.impl;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.fos.model.RemitTransferRequest;
import com.sdp.fos.model.RemitTransferResponse;
import com.sdp.fos.service.RemitTransferService;
import com.sdp.mc.fos.wrapper.RemitTransferServiceWrapper;
import com.sdp.mc.fos.wrapper.utils.FOSTransferUtil;
import com.sdp.mc.integration.fos.dto.request.FundtransOrderDTO;
import com.sdp.mc.integration.fos.dto.request.RemitTransferRequestDTO;
import com.sdp.mc.integration.fos.dto.request.TransferQueryRequestDTO;
import com.sdp.mc.integration.fos.dto.response.BatchFundTransResponseDTO;
import com.sdp.mc.integration.fos.dto.response.RemitTransferResponseDTO;
import com.sdp.mc.integration.fos.dto.response.TransferQueryResponseDTO;
import com.shengpay.commom.config.GlobalConfig;
import com.shengpay.fos.batch.model.BatchFundtransWithTransationRequest;
import com.shengpay.fos.batch.model.BatchPaymentResponse;
import com.shengpay.fos.batch.ws.BatchFundtransService;
import com.shengpay.fos.model.TransferQueryRequest;
import com.shengpay.fos.model.TransferQueryResponse;
import com.shengpay.fos.ws.TransferQueryService;

@Service("RemitTransferServiceWrapper")
public class RemitTransferServiceWrapperImpl implements RemitTransferServiceWrapper {

	private static final Logger log = LoggerFactory.getLogger(RemitTransferServiceWrapperImpl.class);

	@Autowired
	private RemitTransferService remitTransferService;

	@Autowired
	private TransferQueryService transferQueryService;

	@Autowired
	private BatchFundtransService batchFundtransService;

//	@Value("${fos.service.transfer.callback.url}")
//	private String fosCallbackURL;
	private static final String fosCallbackURL = GlobalConfig.getString("fos.service.transfer.callback.url","");

	/**
	 * 构建fos转账请求对象，并设置转账通知地址
	 * **/
	private RemitTransferRequest buildTransferRequestAndSetCallbackAddress(RemitTransferRequestDTO requestDTO) {
		RemitTransferRequest request = FOSTransferUtil.buildRemitTransferRequest(requestDTO);
		request.getTransferOrder().setCallbackAddress(fosCallbackURL);
		return request;
	}

	/**
	 * fos转账,请求接口实时返回,存在处理中的状态，故有callback地址
	 *
	 * @param requestDTO
	 * **/
	public RemitTransferResponseDTO transfer(RemitTransferRequestDTO requestDTO) {
		RemitTransferResponse response = null;
		try {
			RemitTransferRequest request = this.buildTransferRequestAndSetCallbackAddress(requestDTO);
			log.info("RemitTransferServiceWrapperImpl.transfer.request=" + ToStringBuilder.reflectionToString(request));
			response = remitTransferService.transfer(request);
			log.info("RemitTransferServiceWrapperImpl.transfer.response=" + ToStringBuilder.reflectionToString(response));
		} catch (Exception e) {
			log.error("RemitTransferServiceWrapperImpl #transfer:" + ((response != null) ? response.toString() : ""), e);
			if (response == null) {
				return new RemitTransferResponseDTO(false, "-1", "invoke.fos.exception,remitVoucherNo=" + requestDTO.getRemitVoucherNo());
			}
		}
		return FOSTransferUtil.buildRemitTransferResponseDTO(response);
	}

	/**
	 * 根据产品订单号查询转账结果
	 *
	 * @param requestDTO
	 * **/
	public TransferQueryResponseDTO queryTransferResult(TransferQueryRequestDTO requestDTO) {
		TransferQueryRequest request = FOSTransferUtil.buildTransferQueryRequest(requestDTO);
		log.info("RemitTransferServiceWrapperImpl.queryTransferResult.request=" + ToStringBuilder.reflectionToString(request));
		TransferQueryResponse response = transferQueryService.queryTransferResult(request);
		log.info("RemitTransferServiceWrapperImpl.queryTransferResult.response=" + ToStringBuilder.reflectionToString(response));
		return FOSTransferUtil.buildTransferQueryResponseDTO(response);
	}

	public BatchFundTransResponseDTO batchTransfer(String batchNo, List<FundtransOrderDTO> transOrder) {
		BatchPaymentResponse response = null;
		try {
			BatchFundtransWithTransationRequest req = FOSTransferUtil.buildBatchRemitTransferRequest(batchNo, transOrder);
			log.info("RemitTransferServiceWrapperImpl.batchTransfer.request=" + ToStringBuilder.reflectionToString(req));
			response = batchFundtransService.batchFundtransWithTransation(req);
			log.info("RemitTransferServiceWrapperImpl.batchTransfer.response=" + ToStringBuilder.reflectionToString(response));
		} catch (Exception e) {
			log.error("RemitTransferServiceWrapperImpl.batchTransfer,batchNo=" + batchNo, e);
			if (response == null) {
				return new BatchFundTransResponseDTO(false, "-1", "invoke.fos.exception,batchNo=" + batchNo);
			}
		}
		return FOSTransferUtil.buildBatchFundTransResponseDTO(response);
	}
}
