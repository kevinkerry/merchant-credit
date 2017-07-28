package com.shengpay.facade.fos;

import java.math.BigDecimal;
import java.util.List;

import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.integration.fos.dto.request.CreditTransferRequestDTO;
import com.sdp.mc.integration.fos.dto.request.RemitTransferRequestDTO;
import com.sdp.mc.integration.fos.dto.request.ReversalTransferRequestDTO;
import com.sdp.mc.integration.fos.dto.request.TransferQueryRequestDTO;
import com.sdp.mc.integration.fos.dto.request.WithdrawT0QueryRequestDTO;
import com.sdp.mc.integration.fos.dto.request.WithdrawT0RequestDTO;
import com.sdp.mc.integration.fos.dto.response.RemitTransferResponseDTO;
import com.sdp.mc.integration.fos.dto.response.TransferQueryResponseDTO;
import com.sdp.mc.integration.fos.dto.response.WithdrawT0QueryResponseDTO;
import com.sdp.mc.integration.fos.dto.response.WithdrawT0ResponseDTO;

public interface FOSFacade {

	public RemitTransferResponseDTO transfer(Long mtId, RemitTransferRequestDTO remitTransferRequestDTO);

	public TransferQueryResponseDTO transferQuery(Long mtId, TransferQueryRequestDTO requestDTO);

	/**
	 * 转账新接口
	 * **/
	public RemitTransferResponseDTO transfer(RemitTransferRequestDTO remitTransferRequestDTO);
	/**
	 * 配资申请
	 * **/
	public List<RemitTransferResponseDTO> transfer4Credit(CreditTransferRequestDTO request);
	/**
	 * 配资冲正
	 * **/
	public RemitTransferResponseDTO transfer4Reversal(ReversalTransferRequestDTO request);

	/**
	 * 超时退结算手续费
	 * @param bizId
	 * @param payeeMemberId
	 * @param payeeAccountNo
	 * @param remitAmount
	 * **/
	public RemitTransferResponseDTO remitSettleFee(String bizId,String payeeMemberId,String payeeAccountNo,AccountType accountType,BigDecimal remitAmount);

	/**
	 * 出款接口
	 * @param request
	 * @return
	 */
	public WithdrawT0ResponseDTO withdraw(WithdrawT0RequestDTO request);

	/**
	 * 出款状态查询接口
	 * @param request
	 * @return
	 */
	public WithdrawT0QueryResponseDTO withdrawQuery(WithdrawT0QueryRequestDTO request);

}
