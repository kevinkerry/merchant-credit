package com.shengpay.facade.fos.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.enums.MarginTransEnum;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.fos.dao.MarginTransDO;
import com.sdp.mc.integration.fos.dto.request.CreditTransferRequestDTO;
import com.sdp.mc.integration.fos.dto.request.DebitTransferRequestDTO;
import com.sdp.mc.integration.fos.dto.request.FundtransOrderDTO;
import com.sdp.mc.integration.fos.dto.request.RemitTransferRequestDTO;
import com.sdp.mc.integration.fos.enums.FOSPaymentCodeEnum;
import com.sdp.mc.integration.fos.enums.FOSProductCodeEnum;
import com.shengpay.debit.dal.dataobject.DoTransferLogPO;
import com.shengpay.service.BaseCommonService;

public class FOSFacadeUtil {

	/**
	 * 单笔转账参数包装
	 * **/
	public static MarginTransDO createMarginTransDO(RemitTransferRequestDTO remitTransferRequestDTO) {
		MarginTransDO marginTransDO = new MarginTransDO();
		marginTransDO.setProductCode(remitTransferRequestDTO.getProductCode().code);
		marginTransDO.setAppId(remitTransferRequestDTO.getAppId());
		marginTransDO.setPaymentCode(remitTransferRequestDTO.getPaymentCode().code);
		marginTransDO.setRemitVoucherNo(remitTransferRequestDTO.getRemitVoucherNo());
		marginTransDO.setPayerMemberId(remitTransferRequestDTO.getPayerMemberId());
		marginTransDO.setPayeeMemberId(remitTransferRequestDTO.getPayeeMemberId());
		marginTransDO.setIsNeedCountFee(MerchantCreditConstant.FOS_REQUEST_IS_NEED_COUNT_FEE_FALSE);// 是否需要计费,1：计费；0：不计费
		marginTransDO.setPayerFee("0");
		marginTransDO.setPayeeFee("0");
		marginTransDO.setPayerAccountType(remitTransferRequestDTO.getPayerAccountType() + "");
		marginTransDO.setPayerAccountNo(remitTransferRequestDTO.getPayerAccountNo());
		marginTransDO.setPayeeAccountNo(remitTransferRequestDTO.getPayeeAccountNo());

		marginTransDO.setGmtBizInitiate(DateUtil.date2Str(new Date(), DateUtil.fosOrderFormat));// 20071117020101
		marginTransDO.setGmtPaymentInitiate(DateUtil.date2Str(new Date(), DateUtil.fosOrderFormat));
		if (remitTransferRequestDTO.getRemitAmount() != null) {
			marginTransDO.setRemitAmount(remitTransferRequestDTO.getRemitAmount().toString());
		}
		marginTransDO.setCallbackAddress(null);
		marginTransDO.setMemo(remitTransferRequestDTO.getMemo() == null ? "" : remitTransferRequestDTO.getMemo());
		marginTransDO.setCurrency("CNY");
		marginTransDO.setStatus(MarginTransEnum.INIT.code);
		marginTransDO.setCreateTime(new Date());
		marginTransDO.setMemo(remitTransferRequestDTO.getBizId());
		return marginTransDO;
	}

	public static DoTransferLogPO createDoTransferLogPO(RemitTransferRequestDTO remitTransferRequestDTO) {
		DoTransferLogPO record = new DoTransferLogPO();
		record.setOrderId(remitTransferRequestDTO.getBizId());
		record.setOrderType(remitTransferRequestDTO.getBizType());
		record.setFromUser(remitTransferRequestDTO.getPayerMemberId());
		record.setToUser(remitTransferRequestDTO.getPayeeMemberId());
		record.setStatus("INIT");
		record.setCreateTime(new Date());
		record.setUpdateTime(new Date());
		return record;
	}

	/**
	 * 保证金参数包装
	 * **/
	public static MarginTransDO buildMarginTransDO4Credit(CreditTransferRequestDTO creditTransferRequestDTO) {
		MarginTransDO marginTransDO = new MarginTransDO();
		marginTransDO.setProductCode(FOSProductCodeEnum.MC_FOS_CREDIT_PRODUCT_CODE.code);
		marginTransDO.setAppId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		marginTransDO.setPaymentCode(FOSPaymentCodeEnum.CREDIT_PAYMENT_CODE_01.code);
		String remitVoucherNo = FOSProductCodeEnum.MC_FOS_CREDIT_PRODUCT_CODE.code + FOSPaymentCodeEnum.CREDIT_PAYMENT_CODE_01.code
				+ BaseCommonService.generatorSeq();
		marginTransDO.setRemitVoucherNo(remitVoucherNo);
		marginTransDO.setPayerMemberId("shengpay");
		marginTransDO.setPayeeMemberId(creditTransferRequestDTO.getPromoterMemberId());
		marginTransDO.setIsNeedCountFee(MerchantCreditConstant.FOS_REQUEST_IS_NEED_COUNT_FEE_FALSE);// 是否需要计费,1：计费；0：不计费
		marginTransDO.setPayerFee("0");
		marginTransDO.setPayeeFee("0");
		marginTransDO.setPayerAccountType("0");// shengpay对应的accountType为0
		marginTransDO.setPayerAccountNo("");// shengpay对应的accountNo传空
		marginTransDO.setPayeeAccountType(MerchantCreditConstant.ACCOUNT_TYPE_4_CREDIT + "");
		marginTransDO.setPayeeAccountNo(creditTransferRequestDTO.getPromoterCreditAccountId());

		marginTransDO.setGmtBizInitiate(DateUtil.date2Str(new Date(), DateUtil.fosOrderFormat));// 20071117020101
		marginTransDO.setGmtPaymentInitiate(DateUtil.date2Str(new Date(), DateUtil.fosOrderFormat));
		marginTransDO.setRemitAmount(creditTransferRequestDTO.getCreditAmount().toString());
		marginTransDO.setCallbackAddress(null);
		marginTransDO.setMemo("");
		marginTransDO.setCurrency("CNY");
		marginTransDO.setStatus(MarginTransEnum.INIT.code);
		marginTransDO.setCreateTime(new Date());
		marginTransDO.setBatchNo(creditTransferRequestDTO.getBatchNo());
		return marginTransDO;
	}

	/**
	 * 手续费参数包装
	 * **/
	public static MarginTransDO buildMarginTransDO4CreditFee(CreditTransferRequestDTO creditTransferRequestDTO) {
		MarginTransDO marginTransDO = new MarginTransDO();
		marginTransDO.setProductCode(FOSProductCodeEnum.MC_FOS_CREDIT_PRODUCT_CODE.code);
		marginTransDO.setAppId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		marginTransDO.setPaymentCode(FOSPaymentCodeEnum.CREDIT_PAYMENT_CODE_02.code);
		String remitVoucherNo = FOSProductCodeEnum.MC_FOS_CREDIT_PRODUCT_CODE.code + FOSPaymentCodeEnum.CREDIT_PAYMENT_CODE_01.code
				+ BaseCommonService.generatorSeq();
		marginTransDO.setRemitVoucherNo(remitVoucherNo);
		marginTransDO.setPayerMemberId(creditTransferRequestDTO.getPromoterMemberId());
		marginTransDO.setPayeeMemberId("shengpay");
		marginTransDO.setIsNeedCountFee(MerchantCreditConstant.FOS_REQUEST_IS_NEED_COUNT_FEE_FALSE);// 是否需要计费,1：计费；0：不计费
		marginTransDO.setPayerFee("0");
		marginTransDO.setPayeeFee("0");
		marginTransDO.setPayerAccountType(MerchantCreditConstant.ACCOUNT_TYPE_4_PUBLIC + "");
		marginTransDO.setPayerAccountNo(creditTransferRequestDTO.getPromoterPublicAccountId());
		marginTransDO.setPayeeAccountType("0");// shengpay对应的accountType为0
		marginTransDO.setPayeeAccountNo("");// shengpay对应的accountNo传空

		marginTransDO.setGmtBizInitiate(DateUtil.date2Str(new Date(), DateUtil.fosOrderFormat));// 20071117020101
		marginTransDO.setGmtPaymentInitiate(DateUtil.date2Str(new Date(), DateUtil.fosOrderFormat));
		marginTransDO.setRemitAmount(creditTransferRequestDTO.getFee().toString());
		marginTransDO.setCallbackAddress(null);
		marginTransDO.setMemo("");
		marginTransDO.setCurrency("CNY");
		marginTransDO.setStatus(MarginTransEnum.INIT.code);
		marginTransDO.setCreateTime(new Date());
		marginTransDO.setBatchNo(creditTransferRequestDTO.getBatchNo());
		return marginTransDO;
	}

	/**
	 * 贷款参数包装
	 * **/
	public static List<MarginTransDO> buildMarginTransDO4Debit(DebitTransferRequestDTO debitTransferRequest) {
		List<MarginTransDO> transList = new ArrayList<MarginTransDO>();
		// 贷款额度,授信账户到个人基本户
		MarginTransDO debitLimit = new MarginTransDO();
		debitLimit.setProductCode(FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE.code);
		debitLimit.setAppId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		debitLimit.setPaymentCode(FOSPaymentCodeEnum.POS_LOAN_PAYMENT_CODE_01.code);
		String remitVoucherNo = FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE.code + FOSPaymentCodeEnum.POS_LOAN_PAYMENT_CODE_01.code
				+ BaseCommonService.generatorSeq();
		debitLimit.setRemitVoucherNo(remitVoucherNo);
		debitLimit.setPayerMemberId(debitTransferRequest.getMemberId());
		debitLimit.setPayeeMemberId(debitTransferRequest.getMemberId());
		debitLimit.setIsNeedCountFee(MerchantCreditConstant.FOS_REQUEST_IS_NEED_COUNT_FEE_FALSE);// 是否需要计费,1：计费；0：不计费
		debitLimit.setPayerFee("0");
		debitLimit.setPayeeFee(debitTransferRequest.getFee().toString());// 手续费
		debitLimit.setPayerAccountType(AccountType.TTD_CREDIT_SPECIAL_ACCOUNT.code + "");
		debitLimit.setPayerAccountNo(debitTransferRequest.getCreditAccountId());
		debitLimit.setPayeeAccountType(AccountType.C_BASE_ACCOUNT.code + "");
		debitLimit.setPayeeAccountNo(debitTransferRequest.getPublicAccountId());
		debitLimit.setGmtBizInitiate(DateUtil.date2Str(new Date(), DateUtil.fosOrderFormat));// 20071117020101
		debitLimit.setGmtPaymentInitiate(DateUtil.date2Str(new Date(), DateUtil.fosOrderFormat));
		debitLimit.setRemitAmount(debitTransferRequest.getDebitLimitAmount().toString());// 贷款金额
		debitLimit.setCallbackAddress(null);
		debitLimit.setMemo("");
		debitLimit.setCurrency("CNY");
		debitLimit.setStatus(MarginTransEnum.INIT.code);
		debitLimit.setCreateTime(new Date());
		debitLimit.setBatchNo(debitTransferRequest.getBatchNo());

		// 计应收利息,应收利息户到shengpay
		MarginTransDO interest = new MarginTransDO();
		interest.setProductCode(FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE.code);
		interest.setAppId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		interest.setPaymentCode(FOSPaymentCodeEnum.POS_LOAN_PAYMENT_CODE_03.code);
		String remitVoucherNo2 = FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE.code + FOSPaymentCodeEnum.POS_LOAN_PAYMENT_CODE_03.code
				+ BaseCommonService.generatorSeq();
		interest.setRemitVoucherNo(remitVoucherNo2);
		interest.setPayerMemberId(debitTransferRequest.getMemberId());
		interest.setPayeeMemberId("shengpay");
		interest.setIsNeedCountFee(MerchantCreditConstant.FOS_REQUEST_IS_NEED_COUNT_FEE_FALSE);// 是否需要计费,1：计费；0：不计费
		interest.setPayerFee("0");
		interest.setPayeeFee("0");
		interest.setPayerAccountType(AccountType.TTD_CREDIT_INTEREST_ACCOUNT.code + "");
		interest.setPayerAccountNo(debitTransferRequest.getInterestAccountId());
		interest.setPayeeAccountType("0");// shengpay对应的accountType为0
		interest.setPayeeAccountNo("");// shengpay对应的accountNo传空
		interest.setGmtBizInitiate(DateUtil.date2Str(new Date(), DateUtil.fosOrderFormat));// 20071117020101
		interest.setGmtPaymentInitiate(DateUtil.date2Str(new Date(), DateUtil.fosOrderFormat));
		interest.setRemitAmount(debitTransferRequest.getInterest().toString());// 利息
		interest.setCallbackAddress(null);
		interest.setMemo("");
		interest.setCurrency("CNY");
		interest.setStatus(MarginTransEnum.INIT.code);
		interest.setCreateTime(new Date());
		interest.setBatchNo(debitTransferRequest.getBatchNo());

		// 还应收利息,基本户到应收利息户
		MarginTransDO payInterest = new MarginTransDO();
		payInterest.setProductCode(FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE.code);
		payInterest.setAppId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		payInterest.setPaymentCode(FOSPaymentCodeEnum.POS_LOAN_PAYMENT_CODE_04.code);
		String remitVoucherNo3 = FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE.code + FOSPaymentCodeEnum.POS_LOAN_PAYMENT_CODE_04.code
				+ BaseCommonService.generatorSeq();
		payInterest.setRemitVoucherNo(remitVoucherNo3);
		payInterest.setPayerMemberId(debitTransferRequest.getMemberId());
		payInterest.setPayeeMemberId(debitTransferRequest.getMemberId());
		payInterest.setIsNeedCountFee(MerchantCreditConstant.FOS_REQUEST_IS_NEED_COUNT_FEE_FALSE);// 是否需要计费,1：计费；0：不计费
		payInterest.setPayerFee("0");
		payInterest.setPayeeFee("0");
		payInterest.setPayerAccountType(AccountType.C_BASE_ACCOUNT.code + "");
		payInterest.setPayerAccountNo(debitTransferRequest.getPublicAccountId());
		payInterest.setPayeeAccountType(AccountType.TTD_CREDIT_INTEREST_ACCOUNT.code + "");
		payInterest.setPayeeAccountNo(debitTransferRequest.getInterestAccountId());
		payInterest.setGmtBizInitiate(DateUtil.date2Str(new Date(), DateUtil.fosOrderFormat));// 20071117020101
		payInterest.setGmtPaymentInitiate(DateUtil.date2Str(new Date(), DateUtil.fosOrderFormat));
		payInterest.setRemitAmount(debitTransferRequest.getInterest().toString());// 利息
		payInterest.setCallbackAddress(null);
		payInterest.setMemo("");
		payInterest.setCurrency("CNY");
		payInterest.setStatus(MarginTransEnum.INIT.code);
		payInterest.setCreateTime(new Date());
		payInterest.setBatchNo(debitTransferRequest.getBatchNo());

		transList.add(debitLimit);
		transList.add(interest);
		transList.add(payInterest);
		return transList;
	}

	/**
	 * 贷款参数包装
	 * **/
	public static List<FundtransOrderDTO> buildFundtransOrderDTOs4Debit(DebitTransferRequestDTO debitTransferRequest) {
		List<FundtransOrderDTO> transList = new ArrayList<FundtransOrderDTO>();
		// 贷款总金额,授信账户到个人基本户
		FundtransOrderDTO debitLimit = new FundtransOrderDTO();
		debitLimit.setProductCode(FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE.code);
		debitLimit.setAppId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		debitLimit.setPaymentCode(FOSPaymentCodeEnum.POS_LOAN_PAYMENT_CODE_01.code);
		String remitVoucherNo = FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE.code + FOSPaymentCodeEnum.POS_LOAN_PAYMENT_CODE_01.code
				+ BaseCommonService.generatorSeq();
		debitLimit.setRemitVoucherNo(remitVoucherNo);
		debitLimit.setPayerMemberId(debitTransferRequest.getMemberId());
		debitLimit.setPayeeMemberId(debitTransferRequest.getMemberId());
		debitLimit.setIsNeedCountFee(MerchantCreditConstant.FOS_REQUEST_IS_NEED_COUNT_FEE_FALSE);// 是否需要计费,1：计费；0：不计费
		debitLimit.setPayerFee("0");
		debitLimit.setPayeeFee(debitTransferRequest.getFee().toString());// 手续费
		debitLimit.setPayerAccountType(AccountType.TTD_CREDIT_SPECIAL_ACCOUNT.code + "");
		debitLimit.setPayerAccountNo(debitTransferRequest.getCreditAccountId());
		debitLimit.setPayeeAccountType(AccountType.C_BASE_ACCOUNT.code + "");
		debitLimit.setPayeeAccountNo(debitTransferRequest.getPublicAccountId());
		debitLimit.setGmtBizInitiate(DateUtil.date2Str(new Date(), DateUtil.fosOrderFormat));// 20071117020101
		debitLimit.setGmtPaymentInitiate(DateUtil.date2Str(new Date(), DateUtil.fosOrderFormat));
		debitLimit.setRemitAmount(debitTransferRequest.getDebitLimitAmount().toString());// 贷款金额
		debitLimit.setCallbackAddress(null);
		debitLimit.setMemo("");
		debitLimit.setCurrency("CNY");
		debitLimit.setStatus(MarginTransEnum.INIT.code);
		debitLimit.setBatchNo(debitTransferRequest.getBatchNo());

		// 计应收利息,应收利息户到shengpay
		FundtransOrderDTO interest = new FundtransOrderDTO();
		interest.setProductCode(FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE.code);
		interest.setAppId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		interest.setPaymentCode(FOSPaymentCodeEnum.POS_LOAN_PAYMENT_CODE_03.code);
		String remitVoucherNo2 = FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE.code + FOSPaymentCodeEnum.POS_LOAN_PAYMENT_CODE_03.code
				+ BaseCommonService.generatorSeq();
		interest.setRemitVoucherNo(remitVoucherNo2);
		interest.setPayerMemberId(debitTransferRequest.getMemberId());
		interest.setPayeeMemberId("shengpay");
		interest.setIsNeedCountFee(MerchantCreditConstant.FOS_REQUEST_IS_NEED_COUNT_FEE_FALSE);// 是否需要计费,1：计费；0：不计费
		interest.setPayerFee("0");
		interest.setPayeeFee("0");
		interest.setPayerAccountType(AccountType.TTD_CREDIT_INTEREST_ACCOUNT.code + "");
		interest.setPayerAccountNo(debitTransferRequest.getInterestAccountId());
		interest.setPayeeAccountType("0");// shengpay对应的accountType为0
		interest.setPayeeAccountNo("");// shengpay对应的accountNo传空
		interest.setGmtBizInitiate(DateUtil.date2Str(new Date(), DateUtil.fosOrderFormat));// 20071117020101
		interest.setGmtPaymentInitiate(DateUtil.date2Str(new Date(), DateUtil.fosOrderFormat));
		interest.setRemitAmount(debitTransferRequest.getInterest().toString());// 利息
		interest.setCallbackAddress(null);
		interest.setMemo("");
		interest.setCurrency("CNY");
		interest.setStatus(MarginTransEnum.INIT.code);
		interest.setBatchNo(debitTransferRequest.getBatchNo());

		// 还应收利息,基本户到应收利息户
		FundtransOrderDTO payInterest = new FundtransOrderDTO();
		payInterest.setProductCode(FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE.code);
		payInterest.setAppId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		payInterest.setPaymentCode(FOSPaymentCodeEnum.POS_LOAN_PAYMENT_CODE_04.code);
		String remitVoucherNo3 = FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE.code + FOSPaymentCodeEnum.POS_LOAN_PAYMENT_CODE_04.code
				+ BaseCommonService.generatorSeq();
		payInterest.setRemitVoucherNo(remitVoucherNo3);
		payInterest.setPayerMemberId(debitTransferRequest.getMemberId());
		payInterest.setPayeeMemberId(debitTransferRequest.getMemberId());
		payInterest.setIsNeedCountFee(MerchantCreditConstant.FOS_REQUEST_IS_NEED_COUNT_FEE_FALSE);// 是否需要计费,1：计费；0：不计费
		payInterest.setPayerFee("0");
		payInterest.setPayeeFee("0");
		payInterest.setPayerAccountType(AccountType.C_BASE_ACCOUNT.code + "");
		payInterest.setPayerAccountNo(debitTransferRequest.getPublicAccountId());
		payInterest.setPayeeAccountType(AccountType.TTD_CREDIT_INTEREST_ACCOUNT.code + "");
		payInterest.setPayeeAccountNo(debitTransferRequest.getInterestAccountId());
		payInterest.setGmtBizInitiate(DateUtil.date2Str(new Date(), DateUtil.fosOrderFormat));// 20071117020101
		payInterest.setGmtPaymentInitiate(DateUtil.date2Str(new Date(), DateUtil.fosOrderFormat));
		payInterest.setRemitAmount(debitTransferRequest.getInterest().toString());// 利息
		payInterest.setCallbackAddress(null);
		payInterest.setMemo("");
		payInterest.setCurrency("CNY");
		payInterest.setStatus(MarginTransEnum.INIT.code);
		payInterest.setBatchNo(debitTransferRequest.getBatchNo());

		transList.add(debitLimit);
		transList.add(interest);
		transList.add(payInterest);
		return transList;
	}

	/**
	 * 贷款参数包装
	 * **/
	public static List<FundtransOrderDTO> buildFundtransOrderDTOs4OverduePayback(DebitTransferRequestDTO debitTransferRequest) {
		List<FundtransOrderDTO> transList = new ArrayList<FundtransOrderDTO>();
		// 基本户-->授信户
		FundtransOrderDTO debitLimit = new FundtransOrderDTO();
		debitLimit.setProductCode(FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE.code);
		debitLimit.setAppId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		debitLimit.setPaymentCode(FOSPaymentCodeEnum.POS_LOAN_PAYMENT_CODE_07.code);
		String remitVoucherNo = FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE.code + FOSPaymentCodeEnum.POS_LOAN_PAYMENT_CODE_07.code
				+ BaseCommonService.generatorSeq();
		debitLimit.setRemitVoucherNo(remitVoucherNo);
		debitLimit.setPayerMemberId(debitTransferRequest.getMemberId());
		debitLimit.setPayeeMemberId(debitTransferRequest.getMemberId());
		debitLimit.setIsNeedCountFee(MerchantCreditConstant.FOS_REQUEST_IS_NEED_COUNT_FEE_FALSE);// 是否需要计费,1：计费；0：不计费
		debitLimit.setPayerFee("0");
		debitLimit.setPayeeFee("0");// 手续费
		debitLimit.setPayerAccountType(AccountType.C_BASE_ACCOUNT.code + "");
		debitLimit.setPayerAccountNo(debitTransferRequest.getPublicAccountId());
		debitLimit.setPayeeAccountType(AccountType.TTD_CREDIT_SPECIAL_ACCOUNT.code + "");
		debitLimit.setPayeeAccountNo(debitTransferRequest.getCreditAccountId());
		debitLimit.setGmtBizInitiate(DateUtil.date2Str(new Date(), DateUtil.fosOrderFormat));// 20071117020101
		debitLimit.setGmtPaymentInitiate(DateUtil.date2Str(new Date(), DateUtil.fosOrderFormat));
		debitLimit.setRemitAmount(debitTransferRequest.getDebitLimitAmount().toString());// 还款金额
		debitLimit.setCallbackAddress(null);
		debitLimit.setMemo("");
		debitLimit.setCurrency("CNY");
		debitLimit.setStatus(MarginTransEnum.INIT.code);
		debitLimit.setBatchNo(debitTransferRequest.getBatchNo());

		// 基本户-->利息户
		FundtransOrderDTO interest = new FundtransOrderDTO();
		interest.setProductCode(FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE.code);
		interest.setAppId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		interest.setPaymentCode(FOSPaymentCodeEnum.POS_LOAN_PAYMENT_CODE_06.code);
		String remitVoucherNo2 = FOSProductCodeEnum.MC_FOS_LOAN_PRODUCT_CODE.code + FOSPaymentCodeEnum.POS_LOAN_PAYMENT_CODE_06.code
				+ BaseCommonService.generatorSeq();
		interest.setRemitVoucherNo(remitVoucherNo2);
		interest.setPayerMemberId(debitTransferRequest.getMemberId());
		interest.setPayeeMemberId(debitTransferRequest.getMemberId());
		interest.setIsNeedCountFee(MerchantCreditConstant.FOS_REQUEST_IS_NEED_COUNT_FEE_FALSE);// 是否需要计费,1：计费；0：不计费
		interest.setPayerFee("0");
		interest.setPayeeFee("0");
		interest.setPayerAccountType(AccountType.C_BASE_ACCOUNT.code + "");
		interest.setPayerAccountNo(debitTransferRequest.getPublicAccountId());
		interest.setPayeeAccountType(AccountType.TTD_CREDIT_INTEREST_ACCOUNT.code + "");
		interest.setPayeeAccountNo(debitTransferRequest.getInterestAccountId());
		interest.setGmtBizInitiate(DateUtil.date2Str(new Date(), DateUtil.fosOrderFormat));// 20071117020101
		interest.setGmtPaymentInitiate(DateUtil.date2Str(new Date(), DateUtil.fosOrderFormat));
		interest.setRemitAmount(debitTransferRequest.getInterest().toString());// 利息
		interest.setCallbackAddress(null);
		interest.setMemo("");
		interest.setCurrency("CNY");
		interest.setStatus(MarginTransEnum.INIT.code);
		interest.setBatchNo(debitTransferRequest.getBatchNo());

		transList.add(debitLimit);
		transList.add(interest);
		return transList;
	}
}
