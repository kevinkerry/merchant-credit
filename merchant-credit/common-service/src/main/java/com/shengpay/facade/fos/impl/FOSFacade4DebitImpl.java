package com.shengpay.facade.fos.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sdp.fos.model.RemitTransferRequest;
import com.sdp.fos.model.RemitTransferResponse;
import com.sdp.fos.service.RemitTransferService;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.enums.AlertMessageSendTypeEnum;
import com.sdp.mc.common.enums.FosPaymentStateEnums;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.common.util.StringUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.fos.wrapper.utils.FOSTransferUtil;
import com.sdp.mc.integration.fos.dto.request.DebitTransferRequestDTO;
import com.sdp.mc.integration.fos.dto.request.FundtransOrderDTO;
import com.sdp.mc.integration.fos.dto.request.RemitTransferRequestDTO;
import com.sdp.mc.integration.fos.dto.response.BatchFundTransResponseDTO;
import com.sdp.mc.integration.fos.dto.response.RemitTransferResponseDTO;
import com.sdp.mc.integration.fos.enums.DebitTransferLogBizTypeEnum;
import com.sdp.mc.integration.fos.enums.FOSPaymentCodeEnum;
import com.sdp.mc.integration.fos.enums.FOSProductCodeEnum;
import com.shengpay.debit.dal.dataobject.DoTransferLogPO;
import com.shengpay.debit.ext.daointerface.ExtDoTransferLogDAO;
import com.shengpay.facade.fos.FOSFacade4Debit;
import com.shengpay.fos.batch.model.BatchFundtransWithTransationRequest;
import com.shengpay.fos.batch.model.BatchPaymentResponse;
import com.shengpay.fos.batch.ws.BatchFundtransService;
import com.shengpay.service.BaseCommonService;
import com.shengpay.service.alert.factory.AlertMessageSenderFactory;
import com.shengpay.service.mail.AlertMessageSender;

@Service("FOSFacade4DebitImpl")
public class FOSFacade4DebitImpl implements FOSFacade4Debit {
	private Logger logger = LoggerFactory.getLogger(FOSFacade4DebitImpl.class);
	@Autowired
	private RemitTransferService remitTransferService;
	@Autowired
	private BatchFundtransService batchFundtransService;
	@Autowired(required=false)
	private ExtDoTransferLogDAO extDoTransferLogDAO;
	@Autowired
	private ConfigOptionManager configOptionManager;
	@Autowired
	private AlertMessageSenderFactory alertMessageSenderFactory;

	@Value("${fos.service.transfer.callback.url}")
	private String fosCallbackURL;

	private static ExecutorService executorService = Executors.newFixedThreadPool(5);

	private void sendMail(final String title, final String content) {
			final String mailList = ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.CREDIT_FOS_PROCESSING_MAIL_LIST);
			if (StringUtils.isBlank(mailList)) {
				logger.error("FOSFacade4DebitImpl.sendMail.error,mail list is not configured");
				return;
			}
			Thread t = new Thread() {
				public void run() {
					try {
						AlertMessageSender sender = alertMessageSenderFactory.getAlertMessageSender(AlertMessageSendTypeEnum.MAIL_ALERT);
						sender.sendMessage(title, content, mailList);
					} catch (Exception e) {
						logger.error("FOSFacade4DebitImpl.sendMail.error,content=" + content, e);
					}
				}
			};
			executorService.execute(t);
	}

	/**
	 * 通用单笔转账接口
	 * **/
	public RemitTransferResponseDTO transfer(RemitTransferRequestDTO remitTransferRequestDTO) {
		try {
			boolean isTransfering = this.extDoTransferLogDAO.hasTransferingRecord(remitTransferRequestDTO.getBizId(), remitTransferRequestDTO.getBizType());
			logger.info("FOSFacade4DebitImpl.transfer.request=" + ToStringBuilder.reflectionToString(remitTransferRequestDTO) + ",isTransfering=" + isTransfering);
			if (isTransfering) {
				RemitTransferResponseDTO response = new RemitTransferResponseDTO(false);
				response.setPaymentState(FosPaymentStateEnums.P.code);
				response.setReturnCode(FosPaymentStateEnums.P.code);
				response.setReturnMsg("转账中");
				return response;
			}
			boolean isSucceedTransfered = this.extDoTransferLogDAO.hasSucceedTransferedRecord(remitTransferRequestDTO.getBizId(), remitTransferRequestDTO.getBizType());
			logger.info("FOSFacade4DebitImpl.transfer.request=" + ToStringBuilder.reflectionToString(remitTransferRequestDTO) + ",isSucceedTransfered=" + isSucceedTransfered);
			if (isSucceedTransfered) {
				RemitTransferResponseDTO response = new RemitTransferResponseDTO(true);
				response.setPaymentState(FosPaymentStateEnums.S.code);
				response.setReturnCode(FosPaymentStateEnums.S.code);
				response.setReturnMsg("已转账成功");
				return response;
			}
			logger.info("FOSFacade4DebitImpl.transfer,RemitTransferRequestDTO:" + remitTransferRequestDTO.toString());
			// 包装fos转账请求
			RemitTransferRequest request = FOSTransferUtil.buildRemitTransferRequest(remitTransferRequestDTO);
			request.getTransferOrder().setCallbackAddress(fosCallbackURL);

			// 包装日志表参数
			String requestLog = StringUtil.subString(JSONObject.fromObject(request).toString(), 3900);
			DoTransferLogPO record = FOSFacadeUtil.createDoTransferLogPO(remitTransferRequestDTO);
			record.setRequestLog(requestLog);
			// 插入转账日志
			Long id = this.extDoTransferLogDAO.insert(record);
			RemitTransferResponse response = null;
			try {
				logger.info("FOSFacade4DebitImpl.transfer.fos.request=" + JSONObject.fromObject(request).toString());
				response = this.remitTransferService.transfer(request);
				logger.info("FOSFacade4DebitImpl.transfer.fos.response=" + JSONObject.fromObject(response).toString());
			} catch (Exception e) {
				logger.error("FOSFacade4DebitImpl.transfer.fos.error,request=" + ToStringBuilder.reflectionToString(request), e);
				// 更新转账日志状态为异常
				this.extDoTransferLogDAO.updateInit2ResponseLogAndStatus(record.getId(), FosPaymentStateEnums.E.code, "调用fos接口异常");
				// 发邮件提醒
				StringBuilder sb = new StringBuilder();
				sb.append("业务订单号：").append(remitTransferRequestDTO.getBizId());
				sb.append("异常堆栈：\n").append(e.getMessage());
				this.sendMail("调fos单笔转账接口异常，请确认转账是否成功", sb.toString());
				RemitTransferResponseDTO responseDto = new RemitTransferResponseDTO(true);
				responseDto.setPaymentState(FosPaymentStateEnums.E.code);
				responseDto.setReturnCode(FosPaymentStateEnums.E.code);
				responseDto.setReturnMsg("调用fos接口异常");
				return responseDto;
			}
			RemitTransferResponseDTO transferResponseDTO = FOSTransferUtil.buildRemitTransferResponseDTO(response);
			logger.info("FOSFacade4DebitImpl.transfer,RemitTransferResponseDTO:" + transferResponseDTO.toString());
			if (FosPaymentStateEnums.P.code.equalsIgnoreCase(transferResponseDTO.getPaymentState())) {
				// 处理中的配资发邮件提醒线下处理
				StringBuilder sb = new StringBuilder();
				sb.append("转账id=").append(transferResponseDTO.getMarginTransId());
				sb.append(",转账流水号=").append(transferResponseDTO.getRemitVoucherNo());
				sb.append(",付款人mermberId").append(transferResponseDTO.getPayerMemberId());
				sb.append(",收款人mermberId").append(transferResponseDTO.getPayeeMemberId());
				sb.append(",交易金额=").append(transferResponseDTO.getPocketAmount());
				sb.append(",isSuccess=").append(transferResponseDTO.isSuccess());
				sb.append(",isFee=").append(transferResponseDTO.isFee());
				sb.append(",状态=").append(transferResponseDTO.getPaymentState());
				sb.append(",错误码=").append(transferResponseDTO.getReturnCode());
				sb.append(",错误描述=").append(transferResponseDTO.getReturnMsg());
				sb.append("\r\n");
				if (StringUtils.isNotBlank(sb.toString())) {
					this.sendMail("贷款还本金调fos接口返回[处理中、失败、需退款]的交易,请线下处理", sb.toString());
				}
			}
			// 更新响应日志
			String responseLog = StringUtil.subString(JSONObject.fromObject(transferResponseDTO).toString(), 3800);
			boolean flag = this.extDoTransferLogDAO.updateInit2ResponseLogAndStatus(id, transferResponseDTO.getPaymentState(), responseLog);
			logger.info("FOSFacade4DebitImpl.transfer,id=" + id + ",flag=" + flag);
			return transferResponseDTO;
		} catch (Exception e) {
			logger.info("FOSFacade4DebitImpl.transfer.error,request=" + ToStringBuilder.reflectionToString(remitTransferRequestDTO), e);
			return new RemitTransferResponseDTO(false, "-1", "invoke.fos.exception,remitVoucherNo=");
		}
	}

	/**
	 * DebitTransferRequestDTO
	 * **/
	public ErrorMessageVO transfer4Debit(DebitTransferRequestDTO debitTransferRequest) {
		try {
			boolean isTransfering = this.extDoTransferLogDAO.hasTransferingRecord(debitTransferRequest.getBizId(), DebitTransferLogBizTypeEnum.DEBIT_LIMIT_APPLY.code);
			logger.info("FOSFacade4DebitImpl.transfer4Debit.request=" + ToStringBuilder.reflectionToString(debitTransferRequest) + ",isTransfering=" + isTransfering);
			if (isTransfering) {
				return new ErrorMessageVO(false, FosPaymentStateEnums.P.code, "转账中");
			}
			boolean isSucceedTransfered = this.extDoTransferLogDAO.hasSucceedTransferedRecord(debitTransferRequest.getBizId(), DebitTransferLogBizTypeEnum.DEBIT_LIMIT_APPLY.code);
			logger.info("FOSFacade4DebitImpl.transfer4Debit.request=" + ToStringBuilder.reflectionToString(debitTransferRequest) + ",isSucceedTransfered=" + isSucceedTransfered);
			if (isSucceedTransfered) {
				return new ErrorMessageVO(false, FosPaymentStateEnums.S.code, "已转账成功");
			}
			// 缓存日志表记录
			List<FundtransOrderDTO> transOrderList = FOSFacadeUtil.buildFundtransOrderDTOs4Debit(debitTransferRequest);
			// 构造转账请求
			BatchFundtransWithTransationRequest req = FOSTransferUtil.buildBatchRemitTransferRequest(debitTransferRequest.getBatchNo(), transOrderList);
			// 插入转账日志
			String requestLog = StringUtil.subString(JSONObject.fromObject(req).toString(), 3900);
			DoTransferLogPO record = new DoTransferLogPO();
			record.setOrderId(debitTransferRequest.getBizId());
			record.setOrderType(DebitTransferLogBizTypeEnum.DEBIT_LIMIT_APPLY.code);
			record.setFromUser(null);
			record.setToUser(null);
			record.setStatus("INIT");
			record.setRequestLog(requestLog);
			record.setCreateTime(new Date());
			record.setUpdateTime(new Date());
			Long id = extDoTransferLogDAO.insert(record);
			record.setId(id);
			// 请求转账
			BatchPaymentResponse response = null;
			try {
				logger.info("FOSFacade4DebitImpl.transfer4Debit.batchTransfer.request=" + JSONObject.fromObject(req).toString());
				response = batchFundtransService.batchFundtransWithTransation(req);
				logger.info("FOSFacade4DebitImpl.transfer4Debit.batchTransfer.response=" + JSONObject.fromObject(response).toString());
			} catch (Exception e) {
				logger.info("FOSFacade4DebitImpl.transfer4Debit.batchTransfer.error.request=" + JSONObject.fromObject(req).toString(), e);
				// 更新转账日志状态为异常
				this.extDoTransferLogDAO.updateInit2ResponseLogAndStatus(record.getId(), FosPaymentStateEnums.E.code, "调用fos接口异常");
				// 发邮件提醒
				StringBuilder sb = new StringBuilder();
				sb.append("业务订单号：").append(debitTransferRequest.getBizId());
				sb.append("批次号：").append(debitTransferRequest.getBatchNo());
				sb.append("异常堆栈：\n").append(e.getMessage());
				this.sendMail("借款申请调fos批量转账接口异常，请确认转账是否成功", sb.toString());
				return new ErrorMessageVO(false, FosPaymentStateEnums.E.code, "调用fos接口异常");
			}
			BatchFundTransResponseDTO batchFundTransResponseDTO = FOSTransferUtil.buildBatchFundTransResponseDTO(response);
			if (batchFundTransResponseDTO.getPaymentResultList() != null) {
				// 更新状态及发送邮件
				StringBuilder sb = new StringBuilder();
				for (RemitTransferResponseDTO remitTransferResponseDTO : batchFundTransResponseDTO.getPaymentResultList()) {
					if (remitTransferResponseDTO != null) {
						String paymentState = remitTransferResponseDTO.getPaymentState();
						if (FosPaymentStateEnums.P.code.equalsIgnoreCase(paymentState)) {
							// 处理中
							sb.append("转账id=").append(remitTransferResponseDTO.getMarginTransId());
							sb.append(",批次号=").append(debitTransferRequest.getBatchNo());
							sb.append(",转账流水号=").append(remitTransferResponseDTO.getRemitVoucherNo());
							sb.append(",付款人mermberId").append(remitTransferResponseDTO.getPayerMemberId());
							sb.append(",收款人mermberId").append(remitTransferResponseDTO.getPayeeMemberId());
							sb.append(",交易金额=").append(remitTransferResponseDTO.getPocketAmount());
							sb.append(",isSuccess=").append(remitTransferResponseDTO.isSuccess());
							sb.append(",isFee=").append(remitTransferResponseDTO.isFee());
							sb.append(",状态=").append(paymentState);
							sb.append(",错误码=").append(remitTransferResponseDTO.getReturnCode());
							sb.append(",错误描述=").append(remitTransferResponseDTO.getReturnMsg());
							sb.append("\r\n");
						}
					}
				}
				// 徐亮解释fos没有明确的交易中的状态，要拿pe的状态判断
				RemitTransferResponseDTO remitTransferResponseDTO = batchFundTransResponseDTO.getPaymentResultList().get(0);
				// 响应日志json化
				String responseLog = StringUtil.subString(JSONObject.fromObject(response).toString(), 3900);
				this.extDoTransferLogDAO.updateInit2ResponseLogAndStatus(record.getId(), remitTransferResponseDTO.getPaymentState(), responseLog);
				// 处理中的配资发邮件提醒线下处理
				if (StringUtils.isNotBlank(sb.toString())) {
					this.sendMail("借款申请调fos接口返回[处理中、失败、需退款]的交易,请线下确认是否要做退款处理", sb.toString());
				}
				boolean flag = FosPaymentStateEnums.S.code.equalsIgnoreCase(remitTransferResponseDTO.getPaymentState());
				logger.info("FOSFacade4DebitImpl.transfer4Debit,id=" + id + ",flag=" + flag);
				return new ErrorMessageVO(flag, remitTransferResponseDTO.getPaymentState(), remitTransferResponseDTO.getReturnMsg());
			} else {
				return new ErrorMessageVO(false, "-1", "未返回转账明细");
			}
		} catch (Exception e) {
			logger.error("FOSFacade4DebitImpl.transfer4Debit.batchTransfer,batchNo=" + debitTransferRequest.getBatchNo(), e);
			return new ErrorMessageVO(false, FosPaymentStateEnums.E.code, "借款申请转账异常");
		}
	}
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
	public RemitTransferResponseDTO interestAccrued(Long bizId, String memberId, String interestAccountId, BigDecimal interestAmount) {
		RemitTransferRequestDTO remitTransferRequestDTO = new RemitTransferRequestDTO();
		remitTransferRequestDTO.setAppId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		remitTransferRequestDTO.setProductCode(FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE);
		remitTransferRequestDTO.setPaymentCode(FOSPaymentCodeEnum.POS_LOAN_PAYMENT_CODE_05);
		remitTransferRequestDTO.setRemitVoucherNo(BaseCommonService.generatorSeq());
		remitTransferRequestDTO.setRemitAmount(interestAmount);
		remitTransferRequestDTO.setPayerMemberId(memberId);
		remitTransferRequestDTO.setPayerAccountType(AccountType.TTD_CREDIT_INTEREST_ACCOUNT.code);
		remitTransferRequestDTO.setPayerAccountNo(interestAccountId);
		remitTransferRequestDTO.setPayeeMemberId("shengpay");
		remitTransferRequestDTO.setPayeeAccountType(0L);
		remitTransferRequestDTO.setPayeeAccountNo("");
		remitTransferRequestDTO.setBizId(bizId.toString());
		remitTransferRequestDTO.setBizType(DebitTransferLogBizTypeEnum.OVERDUE_INTEREST_ACCRUED.code);
		RemitTransferResponseDTO response = this.transfer(remitTransferRequestDTO);
		return response;
	}

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
	public RemitTransferResponseDTO principalPayBack(Long bizId, String memberId, String baseAccountId, String creditAccountId, BigDecimal principalAmount) {
		RemitTransferRequestDTO remitTransferRequestDTO = new RemitTransferRequestDTO();
		remitTransferRequestDTO.setAppId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		remitTransferRequestDTO.setProductCode(FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE);
		remitTransferRequestDTO.setPaymentCode(FOSPaymentCodeEnum.POS_LOAN_PAYMENT_CODE_02);
		remitTransferRequestDTO.setRemitVoucherNo(BaseCommonService.generatorSeq());
		remitTransferRequestDTO.setRemitAmount(principalAmount);
		remitTransferRequestDTO.setPayerMemberId(memberId);
		remitTransferRequestDTO.setPayerAccountType(AccountType.C_BASE_ACCOUNT.code);
		remitTransferRequestDTO.setPayerAccountNo(baseAccountId);
		remitTransferRequestDTO.setPayeeMemberId(memberId);
		remitTransferRequestDTO.setPayeeAccountType(AccountType.TTD_CREDIT_SPECIAL_ACCOUNT.code);
		remitTransferRequestDTO.setPayeeAccountNo(creditAccountId);
		remitTransferRequestDTO.setBizId(bizId.toString());
		remitTransferRequestDTO.setBizType(DebitTransferLogBizTypeEnum.PRINCIPAL_PAYBACK.code);
		RemitTransferResponseDTO response = this.transfer(remitTransferRequestDTO);
		return response;
	}

	/**
	 * 天天贷逾期还款,本金+滞纳金
	 * **/
	public ErrorMessageVO overdueRepayment(DebitTransferRequestDTO debitTransferRequest) {
		try {
			boolean isTransfering = this.extDoTransferLogDAO.hasTransferingRecord(debitTransferRequest.getBizId(), DebitTransferLogBizTypeEnum.OVERDUE_PAYBACK.code);
			logger.info("FOSFacade4DebitImpl.overdueRepayment.request=" + ToStringBuilder.reflectionToString(debitTransferRequest) + ",isTransfering=" + isTransfering);
			if (isTransfering) {
				return new ErrorMessageVO(false, FosPaymentStateEnums.P.code, "转账中");
			}
			boolean isSucceedTransfered = this.extDoTransferLogDAO.hasSucceedTransferedRecord(debitTransferRequest.getBizId(), DebitTransferLogBizTypeEnum.OVERDUE_PAYBACK.code);
			logger.info("FOSFacade4DebitImpl.overdueRepayment.request=" + ToStringBuilder.reflectionToString(debitTransferRequest) + ",isSucceedTransfered=" + isSucceedTransfered);
			if (isSucceedTransfered) {
				return new ErrorMessageVO(false, FosPaymentStateEnums.S.code, "已转账成功");
			}
			// 缓存日志表记录
			List<FundtransOrderDTO> transOrderList = FOSFacadeUtil.buildFundtransOrderDTOs4OverduePayback(debitTransferRequest);
			// 构造转账请求
			BatchFundtransWithTransationRequest req = FOSTransferUtil.buildBatchRemitTransferRequest(debitTransferRequest.getBatchNo(), transOrderList);
			// 插入转账日志
			String requestLog = StringUtil.subString(JSONObject.fromObject(req).toString(), 3900);
			DoTransferLogPO record = new DoTransferLogPO();
			record.setOrderId(debitTransferRequest.getBizId());
			record.setOrderType(DebitTransferLogBizTypeEnum.OVERDUE_PAYBACK.code);
			record.setFromUser(null);
			record.setToUser(null);
			record.setStatus("INIT");
			record.setRequestLog(requestLog);
			record.setCreateTime(new Date());
			record.setUpdateTime(new Date());
			Long id = extDoTransferLogDAO.insert(record);
			record.setId(id);
			BatchPaymentResponse response = null;
			try {
				// 请求转账
				logger.info("FOSFacade4DebitImpl.overdueRepayment.batchTransfer.request=" + JSONObject.fromObject(req).toString());
				response = batchFundtransService.batchFundtransWithTransation(req);
				logger.info("FOSFacade4DebitImpl.overdueRepayment.batchTransfer.response=" + JSONObject.fromObject(response).toString());
			} catch (Exception e) {
				logger.info("FOSFacade4DebitImpl.overdueRepayment.batchTransfer.error.request=" + JSONObject.fromObject(req).toString(), e);
				// 更新转账日志状态为异常
				this.extDoTransferLogDAO.updateInit2ResponseLogAndStatus(record.getId(), FosPaymentStateEnums.E.code, "调用fos接口异常");
				// 发邮件提醒
				StringBuilder sb = new StringBuilder();
				sb.append("业务订单号：").append(debitTransferRequest.getBizId());
				sb.append("批次号：").append(debitTransferRequest.getBatchNo());
				sb.append("异常堆栈：\n").append(e.getMessage());
				this.sendMail("逾期还款调fos批量转账接口异常，请确认转账是否成功", sb.toString());
				return new ErrorMessageVO(false, FosPaymentStateEnums.E.code, "调用fos接口异常");
			}
			BatchFundTransResponseDTO batchFundTransResponseDTO = FOSTransferUtil.buildBatchFundTransResponseDTO(response);
			if (batchFundTransResponseDTO.getPaymentResultList() != null) {
				// 更新状态及发送邮件
				StringBuilder sb = new StringBuilder();
				for (RemitTransferResponseDTO remitTransferResponseDTO : batchFundTransResponseDTO.getPaymentResultList()) {
					if (remitTransferResponseDTO != null) {
						String paymentState = remitTransferResponseDTO.getPaymentState();
						if (FosPaymentStateEnums.P.code.equalsIgnoreCase(paymentState)) {
							// 处理中
							sb.append("转账id=").append(remitTransferResponseDTO.getMarginTransId());
							sb.append(",批次号=").append(debitTransferRequest.getBatchNo());
							sb.append(",转账流水号=").append(remitTransferResponseDTO.getRemitVoucherNo());
							sb.append(",付款人mermberId").append(remitTransferResponseDTO.getPayerMemberId());
							sb.append(",收款人mermberId").append(remitTransferResponseDTO.getPayeeMemberId());
							sb.append(",交易金额=").append(remitTransferResponseDTO.getPocketAmount());
							sb.append(",isSuccess=").append(remitTransferResponseDTO.isSuccess());
							sb.append(",isFee=").append(remitTransferResponseDTO.isFee());
							sb.append(",状态=").append(paymentState);
							sb.append(",错误码=").append(remitTransferResponseDTO.getReturnCode());
							sb.append(",错误描述=").append(remitTransferResponseDTO.getReturnMsg());
							sb.append("\r\n");
						}
					}
				}
				// 徐亮解释fos没有明确的交易中的状态，要拿pe的状态判断
				RemitTransferResponseDTO remitTransferResponseDTO = batchFundTransResponseDTO.getPaymentResultList().get(0);
				// 响应日志json化
				String responseLog = StringUtil.subString(JSONObject.fromObject(response).toString(), 3900);
				this.extDoTransferLogDAO.updateInit2ResponseLogAndStatus(record.getId(), remitTransferResponseDTO.getPaymentState(), responseLog);
				// 处理中的配资发邮件提醒线下处理
				if (StringUtils.isNotBlank(sb.toString())) {
					this.sendMail("逾期还款调fos接口返回[处理中、失败、需退款]的交易,请线下确认是否要做退款处理", sb.toString());
				}
				boolean flag = FosPaymentStateEnums.S.code.equalsIgnoreCase(remitTransferResponseDTO.getPaymentState());
				return new ErrorMessageVO(flag, remitTransferResponseDTO.getPaymentState(), remitTransferResponseDTO.getReturnMsg());
			} else {
				return new ErrorMessageVO(false, "-1", "未返回转账明细");
			}
		} catch (Exception e) {
			logger.error("FOSFacade4DebitImpl.overdueRepayment.batchTransfer,batchNo=" + debitTransferRequest.getBatchNo(), e);
			return new ErrorMessageVO(false, FosPaymentStateEnums.E.code, "逾期还款转账异常");
		}
	}
}
