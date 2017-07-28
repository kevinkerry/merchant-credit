package com.sdp.mc.fos.wrapper;

import java.util.List;

import com.sdp.mc.integration.fos.dto.request.FundtransOrderDTO;
import com.sdp.mc.integration.fos.dto.request.RemitTransferRequestDTO;
import com.sdp.mc.integration.fos.dto.request.TransferQueryRequestDTO;
import com.sdp.mc.integration.fos.dto.request.WithdrawT0RequestDTO;
import com.sdp.mc.integration.fos.dto.response.BatchFundTransResponseDTO;
import com.sdp.mc.integration.fos.dto.response.RemitTransferResponseDTO;
import com.sdp.mc.integration.fos.dto.response.TransferQueryResponseDTO;
import com.sdp.mc.integration.fos.dto.response.WithdrawT0ResponseDTO;

public interface RemitTransferServiceWrapper {
	/**
	 * fos转账,请求接口实时返回,存在处理中的状态，故有callback地址
	 *
	 * @param requestDTO
	 * **/
	public RemitTransferResponseDTO transfer(RemitTransferRequestDTO requestDTO);
	/**
	 * 根据产品订单号查询转账结果
	 *
	 * @param requestDTO
	 * **/
	public TransferQueryResponseDTO queryTransferResult(TransferQueryRequestDTO requestDTO);

	public BatchFundTransResponseDTO batchTransfer(String batchNo, List<FundtransOrderDTO> transOrder);

}
