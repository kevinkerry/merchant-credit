package com.sdp.mc.fos.wrapper.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.sdp.fos.model.AppRemitWithdrawOrder;
import com.sdp.fos.model.RemitTransferRequest;
import com.sdp.fos.model.RemitTransferResponse;
import com.sdp.fos.model.TransferOrderOrigApplication;
import com.sdp.fos.model.WithdrawRequest;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.FosPaymentStateEnums;
import com.sdp.mc.integration.fos.dto.request.FundtransOrderDTO;
import com.sdp.mc.integration.fos.dto.request.RemitTransferRequestDTO;
import com.sdp.mc.integration.fos.dto.request.TransferQueryRequestDTO;
import com.sdp.mc.integration.fos.dto.request.WithdrawT0QueryRequestDTO;
import com.sdp.mc.integration.fos.dto.request.WithdrawT0RequestDTO;
import com.sdp.mc.integration.fos.dto.response.BatchFundTransResponseDTO;
import com.sdp.mc.integration.fos.dto.response.RemitTransferResponseDTO;
import com.sdp.mc.integration.fos.dto.response.TransferQueryResponseDTO;
import com.shengpay.fos.batch.model.BatchFundtransWithTransationRequest;
import com.shengpay.fos.batch.model.BatchPaymentResponse;
import com.shengpay.fos.batch.model.FundtransOrder;
import com.shengpay.fos.batch.model.PaymentResult;
import com.shengpay.fos.model.TransferQueryRequest;
import com.shengpay.fos.model.TransferQueryResponse;
import com.shengpay.fos.model.WithdrawQueryRequest;

public class FOSTransferUtil {
	private static final Logger log = LoggerFactory.getLogger(FOSTransferUtil.class);

	public static RemitTransferRequest buildRemitTransferRequest(RemitTransferRequestDTO requestDTO) {
		TransferOrderOrigApplication tooa = new TransferOrderOrigApplication();
		if (requestDTO.getProductCode() != null) {
			tooa.setProductCode(requestDTO.getProductCode().code);// 产品编码
		} else {
			tooa.setProductCode(MerchantCreditConstant.MC_FOS_MARGIN_PRODUCT_CODE);// 产品编码
		}
		if (!"".equals(requestDTO.getAppId()) && requestDTO.getAppId() != null) {
			tooa.setSourceCode(requestDTO.getAppId());
		} else {
			tooa.setSourceCode(requestDTO.getAppId());
		}
		// 支付编码,2001:基本户到子账户,2101:子账户到基本户
		tooa.setPaymentCode(requestDTO.getPaymentCode().code);
		// TODO:根据 PaymentCode 判断 payerAccountType payeeAccountType
		// productCode+ paymentCode+ remitVoucherNo:要求唯一
		tooa.setRemitVoucherNo(requestDTO.getRemitVoucherNo());// 转账订单号,32位
		tooa.setPayerMemberId(requestDTO.getPayerMemberId());// 付款人会员ID
		tooa.setPayeeMemberId(requestDTO.getPayeeMemberId());// 收款人会员ID
		tooa.setNeedCountFee(false);// 是否需要计费,1：计费；0：不计费
		tooa.setPayerFee(BigDecimal.valueOf(0));// 付款人费用
		tooa.setPayeeFee(BigDecimal.valueOf(0));// 收款人费用

		tooa.setPayerAccountType(requestDTO.getPayerAccountType());// 付款方账户类型
		tooa.setPayerAccountNo(requestDTO.getPayerAccountNo());// 付款人储值账户ID
		tooa.setPayeeAccountType(requestDTO.getPayeeAccountType());// 收款人账户类型
		tooa.setPayeeAccountNo(requestDTO.getPayeeAccountNo());// 收款人储值账户ID

		tooa.setGmtBizInitiate(new Date());// 业务发起时间,例如：20071117020101
		tooa.setGmtPaymentInitiate(new Date());// 支付发起时间
		tooa.setRemitAmount(requestDTO.getRemitAmount());// 转账金额
		tooa.setMemo(requestDTO.getMemo());// 备注信息,储值系统要求不能为空
		tooa.setPemitPricingErr(false);// 是否允许计费异常
		tooa.setCurrency("CNY");// 不传默认为CNY
		RemitTransferRequest request = new RemitTransferRequest();
		request.setTransferOrder(tooa);
		return request;
	}

	/**
	 * 配资申请请求
	 * **/
	public static BatchFundtransWithTransationRequest buildBatchRemitTransferRequest(String batchNo, List<FundtransOrderDTO> transOrder) {
		BatchFundtransWithTransationRequest req = new BatchFundtransWithTransationRequest();
		req.setBatchNo(batchNo);
		req.setSourceCode(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		req.setMemo("");
		List<FundtransOrder> fundtransOrderList = new ArrayList<FundtransOrder>();
		for (FundtransOrderDTO fundtransOrderDTO : transOrder) {
			FundtransOrder credit = new FundtransOrder();
			credit.setProductCode(fundtransOrderDTO.getProductCode());
			credit.setPaymentCode(fundtransOrderDTO.getPaymentCode());
			credit.setPaymentOrderNo(fundtransOrderDTO.getRemitVoucherNo());
			credit.setPayerMemberId(fundtransOrderDTO.getPayerMemberId());
			credit.setPayerAccountNo(fundtransOrderDTO.getPayerAccountNo());
			credit.setPayeeMemberId(fundtransOrderDTO.getPayeeMemberId());
			credit.setPayeeAccountNo(fundtransOrderDTO.getPayeeAccountNo());
			credit.setOrderAmount(new BigDecimal(fundtransOrderDTO.getRemitAmount()));
			credit.setPayableAmount(new BigDecimal(fundtransOrderDTO.getRemitAmount()));
			credit.setPayerFeeAmount(new BigDecimal(fundtransOrderDTO.getPayerFee()));
			credit.setPayeeFeeAmount(new BigDecimal(fundtransOrderDTO.getPayeeFee()));
			credit.setNeedCountFee("1".equals(fundtransOrderDTO.getIsNeedCountFee()));
			credit.setGmtBizInitiate(new Date());
			credit.setGmtPaymentInitiate(new Date());
			credit.setMemo("");
			log.info("FOSTransferUtil.buildRemitTransferRequest4ApplyCredit.FundtransOrder=" + ToStringBuilder.reflectionToString(credit));
			fundtransOrderList.add(credit);
		}
		req.setFundtransOrderList(fundtransOrderList);
		return req;
	}

	/**
	 * 配资申请响应
	 * **/
	public static BatchFundTransResponseDTO buildBatchFundTransResponseDTO(BatchPaymentResponse response) {
		boolean isSuccess = response != null && "0".equals(response.getReturnCode());
		if (response != null) {
			BatchFundTransResponseDTO responseDTO = new BatchFundTransResponseDTO(isSuccess, response.getReturnCode(), response.getReturnMsg());
			// 0 - 交易成功
			// 01030 - 重复的请求
			// 01018 - 余额不足
			// 90005 - 支付系统故障
			if (response.getPaymentResultList() != null && !response.getPaymentResultList().isEmpty()) {
				List<RemitTransferResponseDTO> paymentResultList = new ArrayList<RemitTransferResponseDTO>();
				for (PaymentResult paymentResult : response.getPaymentResultList()) {
					if (paymentResult != null) {
						boolean flag = FosPaymentStateEnums.S.code.equals(paymentResult.getPaymentState());
						RemitTransferResponseDTO remitTransferResponseDTO = new RemitTransferResponseDTO(flag);
						BeanUtils.copyProperties(paymentResult, remitTransferResponseDTO);
						if (StringUtils.isBlank(paymentResult.getPaymentState())) {
							remitTransferResponseDTO.setPaymentState("F");
						}
						remitTransferResponseDTO.setRemitVoucherNo(paymentResult.getPaymentOrderNo());
						remitTransferResponseDTO.setPayerFee(paymentResult.getPayerFeeAmount());
						remitTransferResponseDTO.setPayeeFee(paymentResult.getPayeeFeeAmount());
						paymentResultList.add(remitTransferResponseDTO);
					}
				}
				responseDTO.setPaymentResultList(paymentResultList);
			}
			return responseDTO;
		}
		return null;
	}

	public static RemitTransferResponseDTO buildRemitTransferResponseDTO(RemitTransferResponse response) {
		if (response == null || response.getRemitPaymentResult() == null) { return null; }
		boolean isSuccess = FosPaymentStateEnums.S.code.equals(response.getRemitPaymentResult().getPaymentState())
				|| ("0".equals(response.getRemitPaymentResult().getReturnCode()));
		RemitTransferResponseDTO responseDTO = new RemitTransferResponseDTO(isSuccess);
		BeanUtils.copyProperties(response.getRemitPaymentResult(), responseDTO);
		if (StringUtils.isBlank(response.getRemitPaymentResult().getPaymentState())) {
			responseDTO.setPaymentState("F");
		}
		return responseDTO;
	}

	public static TransferQueryRequest buildTransferQueryRequest(TransferQueryRequestDTO requestDTO) {
		TransferQueryRequest request = new TransferQueryRequest();
		request.setBatchNo(null);// 单笔出款的batchNo为空
		request.setProductCode(MerchantCreditConstant.MC_FOS_MARGIN_PRODUCT_CODE);
		// 支付编码
		request.setPaymentCode(requestDTO.getPaymentCode().code);
		// 产品订单号不能为空
		request.setRemitVoucherNo(requestDTO.getRemitVoucherNo());
		// 应用编号
		request.setSourceCode(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		return request;
	}

	public static TransferQueryResponseDTO buildTransferQueryResponseDTO(TransferQueryResponse response) {
		boolean isSuccess = FosPaymentStateEnums.S.code.equals(response.getPaymentResult().getPaymentState()) || "0".equals(response.getReturnCode());
		TransferQueryResponseDTO responseDTO = new TransferQueryResponseDTO(isSuccess);
		BeanUtils.copyProperties(response.getPaymentResult(), responseDTO);
		return responseDTO;
	}

	/**
	 * 封装出款请求参数
	 * 
	 * @param t0request
	 * @return
	 */
	public static WithdrawRequest buildWithdrawRequest(WithdrawT0RequestDTO t0request) {
		AppRemitWithdrawOrder withdrawOrder = new AppRemitWithdrawOrder();
		withdrawOrder.setProductCode(t0request.getProductCode());// 产品编码
		if (!StringUtils.isEmpty(t0request.getAppId())) {
			withdrawOrder.setSourceCode(t0request.getAppId());// 应用ID
		}
		withdrawOrder.setPaymentCode(t0request.getPaymentCode());// 支付编码
		withdrawOrder.setRemitVoucherNo(t0request.getRemitVoucherNo());// 出款订单号,32位
		withdrawOrder.setPayerMemberId(t0request.getPayerMemberId());// 付款人会员ID
		withdrawOrder.setNeedCountFee(t0request.getIsNeedCountFee()); // 是否需要计费
		withdrawOrder.setPayerFee(t0request.getPayerFee());// 付款人费用
		withdrawOrder.setPayeeFee(t0request.getPayeeFee());// 收款人费用
		withdrawOrder.setPemitPricingErr(t0request.isPermitPricingErr());// 是否允许计费异常
		withdrawOrder.setPayerAccountNo(t0request.getPayerAccountNo());// 付款人储值账户ID
		withdrawOrder.setBankCode(t0request.getBankCode());// 开户行
		withdrawOrder.setBankName(t0request.getBankName());// 开户行名称
		if (!StringUtils.isEmpty(t0request.getBankBranch())) {
			withdrawOrder.setBankBranch(t0request.getBankBranch());// 支行名称
		}
		if (!StringUtils.isEmpty(t0request.getBankLineNo())) {
			withdrawOrder.setBankLineNo(t0request.getBankLineNo());// 支行编码(联行号)
		}
		withdrawOrder.setBankProvince(t0request.getBankProvince());// 银行所属省份
		if (!StringUtils.isEmpty(t0request.getBankCity())) {
			withdrawOrder.setBankCity(t0request.getBankCity());// 银行所属城市
		}
		withdrawOrder.setPayeeName(t0request.getPayeeName());// 收款人姓名
		withdrawOrder.setPayeeCardNo(t0request.getPayeeCardNo());// 收款人卡号
		if (!StringUtils.isEmpty(t0request.getPayeePurpose())) {
			withdrawOrder.setPayeePurpose(t0request.getPayeePurpose());// 出款用途描述
		}
		if (!StringUtils.isEmpty(t0request.getCardType())) {
			withdrawOrder.setCardType(t0request.getCardType());// 卡类型
		}
		if (!StringUtils.isEmpty(t0request.getCompanyOrPersonal())) {
			withdrawOrder.setCompanyOrPersonal(t0request.getCompanyOrPersonal());// 账户类型
		}
		withdrawOrder.setGmtBizInitiate(t0request.getGmtBizInitiate());// 业务发起时间
		withdrawOrder.setGmtPaymentInitiate(t0request.getGmtPaymentInitiate());// 支付发起时间
		withdrawOrder.setRemitAmount(t0request.getRemitAmount());// 出款金额

		if (!StringUtils.isEmpty(t0request.getCallbackAddress())) {
			withdrawOrder.setCallbackAddress(t0request.getCallbackAddress());// 支付结果回调地址
		}
		withdrawOrder.setMemo(t0request.getMemo());// 备注信息

		if (StringUtils.isEmpty(t0request.getCurrency())) {
			withdrawOrder.setCurrency("CNY");// 不传默认为CNY
		} else {
			withdrawOrder.setCurrency(t0request.getCurrency());// 不传默认为CNY
		}
		if (!StringUtils.isEmpty(t0request.getExtention())) {
			withdrawOrder.setExtension(t0request.getExtention());// 支付结果回调地址
		}
		if (!StringUtils.isEmpty(t0request.getCallbackAddress())) {
			withdrawOrder.setCallbackAddress(t0request.getCallbackAddress());// 支付结果回调地址
		}

		WithdrawRequest request = new WithdrawRequest();
		if (!StringUtils.isEmpty(t0request.getExtention())) {
			request.setExtension(t0request.getExtention());
		}
		request.setWithdrawOrder(withdrawOrder);
		return request;
	}

	/**
	 * FOS查询参数
	 * 
	 * @param t0request
	 * @return
	 */
	public static WithdrawQueryRequest buildWithdrawQueryRequest(WithdrawT0QueryRequestDTO t0request) {

		WithdrawQueryRequest request = new WithdrawQueryRequest();
		request.setSourceCode(t0request.getSourceCode());// 监控ID
		request.setProductCode(t0request.getProductCode());// 产品编码
		request.setPaymentCode(t0request.getPaymentCode());// 支付编码

		if (!StringUtils.isEmpty(t0request.getBatchNo())) {
			request.setBatchNo(t0request.getBatchNo());// 批次号
		}
		request.setRemitVoucherNo(t0request.getRemitVoucherNo());// 产品订单号, 不能为空,
																	// 长度不能大于32
		return request;
	}
}
