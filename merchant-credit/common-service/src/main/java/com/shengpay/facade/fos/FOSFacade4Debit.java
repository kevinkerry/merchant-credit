package com.shengpay.facade.fos;

import java.math.BigDecimal;

import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.integration.fos.dto.request.DebitTransferRequestDTO;
import com.sdp.mc.integration.fos.dto.response.RemitTransferResponseDTO;

public interface FOSFacade4Debit {
	/**
	 * 天天贷贷款借款流程转账
	 * **/
	public ErrorMessageVO transfer4Debit(DebitTransferRequestDTO debitTransferRequest);
	/**
	 * 天天贷逾期利息计提
	 * 
	 * @param bizId
	 *            业务订单号
	 * @param memberId
	 *            个人memberId
	 * @param interestAccountId
	 *            应收利息户
	 * @param interestAmount
	 *            逾期利息
	 * **/
	public RemitTransferResponseDTO interestAccrued(Long bizId, String memberId, String interestAccountId, BigDecimal interestAmount);

	/**
	 * 天天贷本金还款,基本户-->授信户
	 * 
	 * @param bizId
	 *            业务订单号
	 * @param memberId
	 *            个人memberId
	 * @param accountId
	 *            个人基本户
	 * @param creditAccountId
	 *            授信专户
	 * @param principalAmount
	 *            本金
	 * **/
	public RemitTransferResponseDTO principalPayBack(Long bizId, String memberId, String baseAccountId, String creditAccountId, BigDecimal principalAmount);

	/***
	 * 逾期还款,还本金及逾期滞纳金
	 * 
	 * @param debitTransferRequest
	 * ***/
	public ErrorMessageVO overdueRepayment(DebitTransferRequestDTO debitTransferRequest);
}
