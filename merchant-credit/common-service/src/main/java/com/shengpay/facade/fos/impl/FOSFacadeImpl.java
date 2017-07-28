package com.shengpay.facade.fos.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.enums.AlertMessageSendTypeEnum;
import com.sdp.mc.common.enums.FosPaymentStateEnums;
import com.sdp.mc.common.enums.MarginTransEnum;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.fos.dao.MarginTransDO;
import com.sdp.mc.fos.dao.MarginTransDOExample;
import com.sdp.mc.fos.manager.MarginTransManager;
import com.sdp.mc.fos.wrapper.RemitTransferServiceWrapper;
import com.sdp.mc.fos.wrapper.WithdrawServiceWrapper;
import com.sdp.mc.integration.fos.dto.request.CreditTransferRequestDTO;
import com.sdp.mc.integration.fos.dto.request.FundtransOrderDTO;
import com.sdp.mc.integration.fos.dto.request.RemitTransferRequestDTO;
import com.sdp.mc.integration.fos.dto.request.ReversalTransferRequestDTO;
import com.sdp.mc.integration.fos.dto.request.TransferQueryRequestDTO;
import com.sdp.mc.integration.fos.dto.request.WithdrawT0QueryRequestDTO;
import com.sdp.mc.integration.fos.dto.request.WithdrawT0RequestDTO;
import com.sdp.mc.integration.fos.dto.response.BatchFundTransResponseDTO;
import com.sdp.mc.integration.fos.dto.response.RemitTransferResponseDTO;
import com.sdp.mc.integration.fos.dto.response.TransferQueryResponseDTO;
import com.sdp.mc.integration.fos.dto.response.WithdrawT0QueryResponseDTO;
import com.sdp.mc.integration.fos.dto.response.WithdrawT0ResponseDTO;
import com.sdp.mc.integration.fos.enums.FOSPaymentCodeEnum;
import com.sdp.mc.integration.fos.enums.FOSProductCodeEnum;
import com.shengpay.facade.fos.FOSFacade;
import com.shengpay.service.BaseCommonService;
import com.shengpay.service.alert.factory.AlertMessageSenderFactory;
import com.shengpay.service.mail.AlertMessageSender;

@Service("FOSFacade")
public class FOSFacadeImpl implements FOSFacade {
	private Logger logger = LoggerFactory.getLogger(FOSFacadeImpl.class);

	@Autowired
	private MarginTransManager marginTransManager;
	@Autowired
	private RemitTransferServiceWrapper remitTransferServiceWrapper;

	@Autowired
	private ConfigOptionManager configOptionManager;

	@Autowired
	private AlertMessageSenderFactory alertMessageSenderFactory;

	@Autowired
	private WithdrawServiceWrapper withdrawServiceWrapper;

	@Value("${fos.service.transfer.callback.url}")
	private String fosCallbackURL;

	public TransferQueryResponseDTO transferQuery(Long mtId, TransferQueryRequestDTO requestDTO) {
		MarginTransDO marginTransDO = null;

		TransferQueryResponseDTO queryRequestDTO = remitTransferServiceWrapper.queryTransferResult(requestDTO);
		String paymentState = queryRequestDTO.getPaymentState();
		MarginTransDOExample example = new MarginTransDOExample();
		example.createCriteria().andMtIdEqualTo(mtId).andStatusEqualTo(MarginTransEnum.INIT.code);
		logger.info("FOSFacadeImpl #transferQuery,TransferQueryResponseDTO:" + ToStringBuilder.reflectionToString(queryRequestDTO));
		if (StringUtils.isBlank(paymentState) || paymentState.equalsIgnoreCase(FosPaymentStateEnums.P.code)) {
			return null;
		} else if (paymentState.equalsIgnoreCase(FosPaymentStateEnums.S.code)) {
			// 成功
			List<MarginTransDO> marginTransDOs = marginTransManager.selectByExample(example);
			if (marginTransDOs == null || marginTransDOs.isEmpty())
				return null;
			marginTransDO = marginTransDOs.get(0);
			int rows = modifyMarginTransStatus(marginTransDO, MarginTransEnum.SUCCESS.code);
			if (rows <= 0)
				return null;
		} else {
			// 失败
			List<MarginTransDO> marginTransDOs = marginTransManager.selectByExample(example);
			if (marginTransDOs == null || marginTransDOs.isEmpty())
				return null;
			marginTransDO = marginTransDOs.get(0);
			int rows = modifyMarginTransStatus(marginTransDO, MarginTransEnum.FAILUE.code);
			if (rows <= 0)
				return null;
		}
		return queryRequestDTO;

	}

	public RemitTransferResponseDTO transfer(Long mtId, RemitTransferRequestDTO remitTransferRequestDTO) {
		logger.info("FOSFacadeImpl #transfer,RemitTransferRequestDTO:" + remitTransferRequestDTO.toString());
		RemitTransferResponseDTO transferResponseDTO = remitTransferServiceWrapper.transfer(remitTransferRequestDTO);
		logger.info("FOSFacadeImpl #transfer,RemitTransferResponseDTO:" + transferResponseDTO.toString());
		if (mtId != null) {
			String paymentState = transferResponseDTO.getPaymentState();
			if (FosPaymentStateEnums.P.code.equalsIgnoreCase(paymentState)) {
				// 处理中
				MarginTransDO marginTransDO = RemitTransferResponseDTO2MarginTransDO(transferResponseDTO, mtId);
				modifyMarginTransStatus(marginTransDO, MarginTransEnum.INIT.code);
			} else if (transferResponseDTO.isSuccess() || FosPaymentStateEnums.S.code.equalsIgnoreCase(paymentState)) {
				// 成功
				MarginTransDO marginTransDO = RemitTransferResponseDTO2MarginTransDO(transferResponseDTO, mtId);
				modifyMarginTransStatus(marginTransDO, MarginTransEnum.SUCCESS.code);
			} else {
				// 成功
				MarginTransDO marginTransDO = RemitTransferResponseDTO2MarginTransDO(transferResponseDTO, mtId);
				modifyMarginTransStatus(marginTransDO, MarginTransEnum.FAILUE.code);
			}
		}
		return transferResponseDTO;
	}

	/**
	 * 转账新接口
	 * **/
	public RemitTransferResponseDTO transfer(RemitTransferRequestDTO remitTransferRequestDTO) {
		Long mtId = null;
		if (remitTransferRequestDTO.getMarginTransId() != null) {
			mtId = remitTransferRequestDTO.getMarginTransId();
		} else {
			MarginTransDO marginTransDO = FOSFacadeUtil.createMarginTransDO(remitTransferRequestDTO);
			marginTransDO.setCallbackAddress(fosCallbackURL);
			mtId = marginTransManager.insert(marginTransDO);
		}
		logger.info("FOSFacadeImpl #transfer,RemitTransferRequestDTO:" + remitTransferRequestDTO.toString());
		RemitTransferResponseDTO transferResponseDTO = remitTransferServiceWrapper.transfer(remitTransferRequestDTO);
		logger.info("FOSFacadeImpl #transfer,RemitTransferResponseDTO:" + transferResponseDTO.toString());
		transferResponseDTO.setMarginTransId(mtId);
		String paymentState = transferResponseDTO.getPaymentState();
		if (FosPaymentStateEnums.P.code.equalsIgnoreCase(paymentState)) {
			// 处理中
			MarginTransDO marginTransDO = RemitTransferResponseDTO2MarginTransDO(transferResponseDTO, mtId);
			modifyMarginTransStatus(marginTransDO, MarginTransEnum.INIT.code);
		} else if (transferResponseDTO.isSuccess() || FosPaymentStateEnums.S.code.equalsIgnoreCase(paymentState)) {
			// 成功
			MarginTransDO marginTransDO = RemitTransferResponseDTO2MarginTransDO(transferResponseDTO, mtId);
			modifyMarginTransStatus(marginTransDO, MarginTransEnum.SUCCESS.code);
		} else {
			// 失败
			MarginTransDO marginTransDO = RemitTransferResponseDTO2MarginTransDO(transferResponseDTO, mtId);
			modifyMarginTransStatus(marginTransDO, MarginTransEnum.FAILUE.code);
		}
		return transferResponseDTO;
	}

	protected MarginTransDO RemitTransferResponseDTO2MarginTransDO(RemitTransferResponseDTO transferResponseDTO, Long mtId) {
		MarginTransDO marginTransDO = marginTransManager.selectByPrimaryKey(mtId);
		marginTransDO.setPaymentState(transferResponseDTO.getPaymentState());
		if (transferResponseDTO.getPayeeFee() != null)
			marginTransDO.setPayeeFee(transferResponseDTO.getPayeeFee().toString());
		if (transferResponseDTO.getPayerFee() != null)
			marginTransDO.setPayerFee(transferResponseDTO.getPayerFee().toString());
		marginTransDO.setPaymentSeqNo(transferResponseDTO.getPaymentSeqNo());
		if (transferResponseDTO.getPocketAmount() != null)
			marginTransDO.setPocketAmount(transferResponseDTO.getPocketAmount().toString());
		marginTransDO.setSettlementTime(transferResponseDTO.getSettlementTime());
		marginTransDO.setReturnCode(transferResponseDTO.getReturnCode());
		marginTransDO.setReturnMsg(transferResponseDTO.getReturnMsg());
		return marginTransDO;
	}

	private List<FundtransOrderDTO> buildTransOrderList(MarginTransDO credit, MarginTransDO fee) {
		List<FundtransOrderDTO> transOrderList = new ArrayList<FundtransOrderDTO>();
		FundtransOrderDTO fee4dto = new FundtransOrderDTO();
		BeanUtils.copyProperties(fee, fee4dto);
		transOrderList.add(fee4dto);
		FundtransOrderDTO credit4dto = new FundtransOrderDTO();
		BeanUtils.copyProperties(credit, credit4dto);
		transOrderList.add(credit4dto);
		return transOrderList;
	}

	/**
	 * 配资申请
	 *
	 * @param request
	 * @param paymentResultList
	 * **/
	public List<RemitTransferResponseDTO> transfer4Credit(CreditTransferRequestDTO request) {
		logger.info("FOSFacadeImpl.transfer4Credit,request=" + ToStringBuilder.reflectionToString(request));
		MarginTransDO credit = FOSFacadeUtil.buildMarginTransDO4Credit(request);
		credit.setCallbackAddress(fosCallbackURL);
		MarginTransDO fee = FOSFacadeUtil.buildMarginTransDO4CreditFee(request);
		fee.setCallbackAddress(fosCallbackURL);
		Long creditMtId = marginTransManager.insert(credit);
		Long feeMtId = marginTransManager.insert(fee);
		List<FundtransOrderDTO> transOrderList = this.buildTransOrderList(credit, fee);
		BatchFundTransResponseDTO batchFundTransResponseDTO = remitTransferServiceWrapper.batchTransfer(request.getBatchNo(), transOrderList);
		logger.info("FOSFacadeImpl.transfer4Credit,batchFundTransResponseDTO=" + ToStringBuilder.reflectionToString(batchFundTransResponseDTO));
		if (batchFundTransResponseDTO.getPaymentResultList() != null) {
			StringBuilder sb = new StringBuilder();
			for (RemitTransferResponseDTO remitTransferResponseDTO : batchFundTransResponseDTO.getPaymentResultList()) {
				if (remitTransferResponseDTO != null) {
					if (credit.getRemitVoucherNo().equals(remitTransferResponseDTO.getRemitVoucherNo())) {
						remitTransferResponseDTO.setMarginTransId(creditMtId);
						remitTransferResponseDTO.setFee(false);
					}
					if (fee.getRemitVoucherNo().equals(remitTransferResponseDTO.getRemitVoucherNo())) {
						remitTransferResponseDTO.setMarginTransId(feeMtId);
						remitTransferResponseDTO.setFee(true);
					}
					if (remitTransferResponseDTO.getMarginTransId() == null) {
						logger.error("FOSFacadeImpl.transfer4Credit.not.match.transfer.order,remitVoucherNo=" + remitTransferResponseDTO.getRemitVoucherNo());
					}
					String paymentState = remitTransferResponseDTO.getPaymentState();
					if (FosPaymentStateEnums.P.code.equalsIgnoreCase(paymentState)) {
						// 处理中
						MarginTransDO marginTransDO = RemitTransferResponseDTO2MarginTransDO(remitTransferResponseDTO, remitTransferResponseDTO.getMarginTransId());
						modifyMarginTransStatus(marginTransDO, MarginTransEnum.INIT.code);

						sb.append("转账id=").append(remitTransferResponseDTO.getMarginTransId());
						sb.append(",批次号=").append(request.getBatchNo());
						sb.append(",转账流水号=").append(remitTransferResponseDTO.getRemitVoucherNo());
						sb.append(",付款人mermberId").append(remitTransferResponseDTO.getPayerMemberId());
						sb.append(",收款人mermberId").append(remitTransferResponseDTO.getPayeeMemberId());
						sb.append(",交易金额=").append(remitTransferResponseDTO.getPocketAmount());
						sb.append(",isSuccess=").append(remitTransferResponseDTO.isSuccess());
						sb.append(",isFee=").append(remitTransferResponseDTO.isFee());
						sb.append("\r\n");
					} else if (remitTransferResponseDTO.isSuccess() || FosPaymentStateEnums.S.code.equalsIgnoreCase(paymentState)) {
						// 成功
						MarginTransDO marginTransDO = RemitTransferResponseDTO2MarginTransDO(remitTransferResponseDTO, remitTransferResponseDTO.getMarginTransId());
						modifyMarginTransStatus(marginTransDO, MarginTransEnum.SUCCESS.code);
					} else {
						// 失败
						MarginTransDO marginTransDO = RemitTransferResponseDTO2MarginTransDO(remitTransferResponseDTO, remitTransferResponseDTO.getMarginTransId());
						modifyMarginTransStatus(marginTransDO, MarginTransEnum.FAILUE.code);
					}
				}
			}
			// 处理中的配资发邮件提醒线下处理
			if (StringUtils.isNotBlank(sb.toString())) {
				this.sendMail("配资授信调fos接口返回[处理中]的交易,请线下确认是否要做退款处理", sb.toString());
			}
			return batchFundTransResponseDTO.getPaymentResultList();
		}
		return null;
	}

	private void sendMail(final String title, final String content) {
		try {
			final String mailList = ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.TTD_FOS_PROCESSING_MAIL_LIST);
			if (StringUtils.isBlank(mailList)) {
				logger.error("FOSFacadeImpl.sendMail.error,mail list is not configured");
				return;
			}
			Thread t = new Thread() {
				public void run() {
					AlertMessageSender sender = alertMessageSenderFactory.getAlertMessageSender(AlertMessageSendTypeEnum.MAIL_ALERT);
					sender.sendMessage(title, content, mailList);
				}
			};
			t.start();
		} catch (Exception e) {
			logger.info("FOSFacadeImpl.sendMail.error,content=" + content, e);
		}
	}

	protected int modifyMarginTransStatus(MarginTransDO record, int status) {
		MarginTransDOExample example = new MarginTransDOExample();
		example.createCriteria().andMtIdEqualTo(record.getMtId());
		record.setStatus(status);
		record.setUpdateTime(new Date());
		return marginTransManager.updateByExampleSelective(record, example);
	}

	/**
	 * 配资冲正
	 *
	 * @param request
	 * @param paymentResultList
	 * **/
	public RemitTransferResponseDTO transfer4Reversal(ReversalTransferRequestDTO request) {
		RemitTransferRequestDTO remitTransferRequestDTO = new RemitTransferRequestDTO();
		remitTransferRequestDTO.setAppId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		remitTransferRequestDTO.setProductCode(FOSProductCodeEnum.MC_FOS_CREDIT_PRODUCT_CODE);
		remitTransferRequestDTO.setPaymentCode(FOSPaymentCodeEnum.CREDIT_PAYMENT_CODE_03);
		remitTransferRequestDTO.setRemitVoucherNo(BaseCommonService.generatorSeq());
		remitTransferRequestDTO.setRemitAmount(request.getReversalAmount());
		remitTransferRequestDTO.setPayerMemberId(request.getPromoterMemberId());
		remitTransferRequestDTO.setPayerAccountType(AccountType.CREDIT_ACCOUNT.code);
		remitTransferRequestDTO.setPayerAccountNo(request.getPromoterAccountId());
		remitTransferRequestDTO.setPayeeMemberId("shengpay");
		remitTransferRequestDTO.setPayeeAccountType(0L);
		remitTransferRequestDTO.setPayeeAccountNo("");
		RemitTransferResponseDTO response = this.transfer(remitTransferRequestDTO);
		if (FosPaymentStateEnums.P.code.equalsIgnoreCase(response.getPaymentState())) {
			// 处理中的配资发邮件提醒线下处理
			StringBuilder sb = new StringBuilder();
			sb.append("转账id=").append(response.getMarginTransId());
			sb.append(",转账流水号=").append(response.getRemitVoucherNo());
			sb.append(",付款人mermberId").append(response.getPayerMemberId());
			sb.append(",收款人mermberId").append(response.getPayeeMemberId());
			sb.append(",交易金额=").append(response.getPocketAmount());
			sb.append(",isSuccess=").append(response.isSuccess());
			sb.append(",isFee=").append(response.isFee());
			sb.append("\r\n");
			if (StringUtils.isNotBlank(sb.toString())) {
				this.sendMail("配资冲正调fos接口返回[处理中]的交易,请线下处理", sb.toString());
			}
		}
		return response;
	}

	/**
	 * 超时退结算手续费
	 *
	 * @param payeeMemberId
	 * @param payeeAccountNo
	 * @param remitAmount
	 * **/
	public RemitTransferResponseDTO remitSettleFee(String bizId,String payeeMemberId,String payeeAccountNo,AccountType accountType,BigDecimal remitAmount) {
		RemitTransferRequestDTO remitTransferRequestDTO = new RemitTransferRequestDTO();
		remitTransferRequestDTO.setAppId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		remitTransferRequestDTO.setProductCode(FOSProductCodeEnum.MC_FOS_NEWT0_REMIT_FEE_PRODUCT_CODE);
		remitTransferRequestDTO.setPaymentCode(FOSPaymentCodeEnum.MC_FOS_NEWT0_REMIT_FEE_PAYMENT_CODE);
		remitTransferRequestDTO.setRemitVoucherNo(BaseCommonService.generatorSeq());
		remitTransferRequestDTO.setRemitAmount(remitAmount);
		remitTransferRequestDTO.setPayerMemberId("shengpay");
		remitTransferRequestDTO.setPayerAccountType(0L);
		remitTransferRequestDTO.setPayerAccountNo("");
		remitTransferRequestDTO.setPayeeMemberId(payeeMemberId);
		remitTransferRequestDTO.setPayeeAccountType(accountType.code);
		remitTransferRequestDTO.setPayeeAccountNo(payeeAccountNo);
//		remitTransferRequestDTO.setMemo(bizId);
		remitTransferRequestDTO.setBizId(bizId);
		RemitTransferResponseDTO response = this.transfer(remitTransferRequestDTO);
		if (FosPaymentStateEnums.P.code.equalsIgnoreCase(response.getPaymentState())) {
			// 处理中的配资发邮件提醒线下处理
			StringBuilder sb = new StringBuilder();
			sb.append("转账id=").append(response.getMarginTransId());
			sb.append(",转账流水号=").append(response.getRemitVoucherNo());
			sb.append(",付款人mermberId").append(response.getPayerMemberId());
			sb.append(",收款人mermberId").append(response.getPayeeMemberId());
			sb.append(",交易金额=").append(response.getPocketAmount());
			sb.append(",isSuccess=").append(response.isSuccess());
			sb.append(",isFee=").append(response.isFee());
			sb.append("\r\n");
			if (StringUtils.isNotBlank(sb.toString())) {
				this.sendMail("超时退结算手续费调fos接口返回[处理中]的交易,请线下处理", sb.toString());
			}
		}
		return response;
	}

	@Override
	public WithdrawT0ResponseDTO withdraw(WithdrawT0RequestDTO t0request) {
		// TODO Auto-generated method stub
		WithdrawT0ResponseDTO response = withdrawServiceWrapper.withdraw(t0request);
		return response;
	}

	@Override
	public WithdrawT0QueryResponseDTO withdrawQuery(WithdrawT0QueryRequestDTO request) {
		// TODO Auto-generated method stub
		WithdrawT0QueryResponseDTO response = withdrawServiceWrapper.withdrawQuery(request);
		return response;
	}


}
