package com.sdp.withdraw.service.impl;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.ws.WebServiceException;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdo.common.util.DateUtil;
import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.dto.WithdrawCoreServiceDTO;
import com.sdp.mc.common.enums.FosPaymentStateEnums;
import com.sdp.mc.common.enums.FundOutReceiptSubmitResultCodeEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawOrderStatusEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawServiceTypeEnums;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.crm.MerchantBankCardWrapper;
import com.sdp.mc.integration.fos.dto.request.WithdrawT0RequestDTO;
import com.sdp.mc.integration.fos.dto.response.WithdrawT0QueryResponseDTO;
import com.sdp.mc.integration.fos.dto.response.WithdrawT0ResponseDTO;
import com.sdp.mc.integration.receipt.dto.request.FundOutReceiptSubmitRequestDTO;
import com.sdp.mc.integration.receipt.dto.request.FundOutReceiptSubmitZF946RequestDTO;
import com.sdp.mc.integration.receipt.dto.response.ReceiptResultDTO;
import com.sdp.mc.receipt.ReceiptRemoteService;
import com.sdp.mc.sars.SarsService;
import com.sdp.mc.sars.bean.SarsCP160Bean;
import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDO;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.sdp.withdraw.enums.ReturnCodeEnums;
import com.sdp.withdraw.service.WithDrawBaseService;
import com.sdp.withdraw.service.WithdrawReqFosDetailService;
import com.sdp.withdraw.service.WithdrawT0ServiceQueryService;
import com.sdp.withdraw.service.WithdrawT0ServiceService;
import com.shengpay.boss.service.crm.query.api.model.BankAccountInfo;
import com.shengpay.boss.service.crm.query.api.model.DelegationPay2CardInfo;
import com.shengpay.commons.core.utils.StringUtils;
import com.shengpay.facade.fos.FOSFacade;
import com.shengpay.mpos.realname.MerchantRealNameAuth;
import com.shengpay.poss.service.realname.remote.vo.BankAccountQueryInfo;
import com.shengpay.poss.service.realname.remote.vo.MerchantRealNameAuthQueryResp;
import com.shengpay.poss.service.realname.remote.vo.PersonalAuthInfo;
import com.shengpay.service.withdraw.FwPosMerchantInfoService;

@Service("WithdrawT0ServiceService")
public class WithdrawT0ServiceServiceImpl extends WithDrawBaseService implements WithdrawT0ServiceService {
	private Logger logger = LoggerFactory.getLogger(WithdrawT0ServiceServiceImpl.class);

	@Autowired
	private FOSFacade fosFacade = null;
	@Autowired
	private ReceiptRemoteService receiptRemoteService = null;
	// @Autowired
	// private WithdrawReqService withdrawReqService = null;
	@Autowired
	private WithdrawReqFosDetailService withdrawReqFosDetailService = null;
	@Autowired
	private SarsService sarsService = null;
	@Autowired
	private WithdrawT0ServiceQueryService withdrawT0ServiceQueryService = null;
	@Autowired
	private MerchantBankCardWrapper merchantBankCardWrapper = null;
	@Autowired
	private FwPosMerchantInfoService fwPosMerchantInfoService = null;
	@Autowired
	private MerchantRealNameAuth merchantRealNameAuth = null;

	// @Autowired
	// private WithdrawFailService withdrawFailService;
	@Override
	public ErrorMessageVO<Object> withdrawCoreService(WithdrawCoreServiceDTO serviceDTO) {
		ErrorMessageVO<Object> message = new ErrorMessageVO<Object>(true);
		logger.info("WithdrawT0ServiceServiceImpl #withdrawCoreService: start,serviceDTO:" + ToStringBuilder.reflectionToString(serviceDTO));
		boolean isSuccess = false;
		String errorMessage = null;
		String errorCode = null;
		WithdrawReqFosDetailDO detailDo = null;
		try {
			errorCode = vaildateWithdrawServiceRequestDTO(serviceDTO);
			if (StringUtils.isBlank(errorCode)) {
				serviceDTO.setGmtPaymentInitiate(DateUtil.getLongDateString(new Date()));
				serviceDTO.setCallbackAddress(WithdrawConstant.FOS_CALLBACK_URL);
				// TODO 发起风控系统
				errorCode = initiateSars(serviceDTO);
				if (StringUtils.isBlank(errorCode)) {
					// TODO 发起凭证复核
					errorCode = initiateReceiptRepository(serviceDTO);
					// TODO 形成调用fos接口的初始数据
					detailDo = buildWithdrawFosDetailInitData(serviceDTO);
					// errorCode=null;
					if (StringUtils.isBlank(errorCode)) {
						// TODO 调用FOS出款接口
						try {
							WithdrawT0ResponseDTO response = initiateFosWithdraw(serviceDTO);
							if (ReturnCodeEnums.FW_SUCCESS.code.equals(response.getReturnCode())) {//
								isSuccess = true;
								logger.info("WithdrawT0ServiceServiceImpl #withdrawCoreService: apply FOS withdraw Success,remitVoucherNo:"
										+ serviceDTO.getRemitVoucherNo());
							} else {
								errorCode = response.getReturnCode();
								errorMessage = response.getReturnMsg();
								logger.info("WithdrawT0ServiceServiceImpl #withdrawCoreService: apply FOS withdraw Fail,remitVoucherNo:"
										+ serviceDTO.getRemitVoucherNo() + ",errorCode:" + errorCode + ",errorMessage:" + errorMessage);
							}
						} catch (WebServiceException e) {//调用FOS WEB service 异常  (超时未响应)
							logger.error("withdrawCoreService initiateFosWithdraw,WebServiceException" ,e);
							errorCode = ReturnCodeEnums.FW_CALL_CORE_WITHDRAW_EXCEPTION.code;
							errorMessage = ReturnCodeEnums.getEnumsByCode(errorCode).msg;
							if (detailDo != null) {//调用fos的出款查询
								WithdrawT0QueryResponseDTO responseDTO = this.withdrawT0ServiceQueryService.queryWithdrawInfo(detailDo);
								if (!ReturnCodeEnums.INVALID_ORDER_NO.code.equals(responseDTO.getReturnCode())
										&& responseDTO != null
										&& responseDTO.getPaymentResult() != null
										&& (FosPaymentStateEnums.P.code.equalsIgnoreCase(responseDTO.getPaymentResult().getPaymentState()) || StringUtils
												.isBlank(responseDTO.getPaymentResult().getPaymentState()))) {
									logger.error("withdrawCoreService WebServiceException query exists request RemitVoucherNo:{}" ,detailDo.getRemitVoucherNo(),e);
									isSuccess = true;
									errorCode = ReturnCodeEnums.FW_MC_T0_ING.code;
									errorMessage = ReturnCodeEnums.FW_MC_T0_ING.msg;
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			if (!isSuccess) {
				errorCode = ReturnCodeEnums.FW_CALL_CORE_WITHDRAW_EXCEPTION.code;
				errorMessage = ReturnCodeEnums.getEnumsByCode(errorCode).msg;
			}
			logger.error("WithdrawT0ServiceServiceImpl #withdrawCoreService:" + errorMessage + " exception:" + e.getMessage(), e);
		}
		if (!isSuccess) {
			if (StringUtils.notBlank(errorCode) && StringUtils.isBlank(errorMessage)) {
				errorMessage = ReturnCodeEnums.getEnumsByCode(errorCode).msg;
			}
			if (detailDo != null) {
				this.withdrawReqFosDetailService
						.updateDataForWaiting(detailDo.getDetailId(), errorCode, errorMessage, WithdrawOrderStatusEnums.FAIL.code, null);
			}
			message.setSuccess(isSuccess);
			message.setErrorCode(errorCode);
			message.setErrorMessage(errorMessage);
			logger.info("withdrawCoreService errorMessage:" + errorMessage);
		} else {
			if (detailDo != null)  this.withdrawReqFosDetailService
					.updateDataForWaiting(detailDo.getDetailId(), errorCode, errorMessage, WithdrawOrderStatusEnums.WAITTING.code, null);
		}
		return message;
	}

	/**
	 * 发起FOS出款服务的调用
	 *
	 * @param serviceDTO
	 */
	private WithdrawT0ResponseDTO initiateFosWithdraw(WithdrawCoreServiceDTO serviceDTO) {
		// TODO Auto-generated method stub
		WithdrawT0RequestDTO request = withdrawReqFosDetailService.buildWithdrawT0RequestDTO(serviceDTO);

		WithdrawT0ResponseDTO response = fosFacade.withdraw(request);
		return response;

	}

	/**
	 * 发起凭证复核接口调用
	 *
	 * @param serviceDTO
	 * @return 失败原因 CODE
	 */
	private String initiateReceiptRepository(WithdrawCoreServiceDTO serviceDTO) {
		FundOutReceiptSubmitRequestDTO request = buildFundOutReceiptSubmitRequestDTO(serviceDTO);
		ReceiptResultDTO result = this.receiptRemoteService.submitFundOutReceipt(request);
		if (FundOutReceiptSubmitResultCodeEnums.FAIL.code.equalsIgnoreCase(result.getResultCode())
				|| FundOutReceiptSubmitResultCodeEnums.EXCEPTION.code.equalsIgnoreCase(result.getResultCode())) { return ReturnCodeEnums.FW_RECEIPT_REPOSITORY_FAIL.code; }
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("RECEIPT_NO", result.getReceiptNo());
		serviceDTO.setReqExtention(map);
		return null;
	}

	private FundOutReceiptSubmitRequestDTO buildFundOutReceiptSubmitRequestDTO(WithdrawCoreServiceDTO serviceDTO) {
		FundOutReceiptSubmitRequestDTO request = new FundOutReceiptSubmitZF946RequestDTO();
		request.setAppOrderNo(serviceDTO.getRemitVoucherNo());
		request.setBankAccountName(serviceDTO.getPayeeName());
		request.setBankAccountNo(serviceDTO.getPayeeCardNo());
		request.setBizCode(serviceDTO.getProductCode());
		request.setPayableAmount(new BigDecimal(serviceDTO.getRemitAmount()).multiply(new BigDecimal(1000)).longValue());
		request.setPayeeAccountNo(serviceDTO.getPayerAccountNo());
		request.setPayeeMemberId(serviceDTO.getPayerMemberId());
		return request;
	}

	/**
	 * 发起风控调用
	 *
	 * @param serviceDTO
	 * @return 失败原因 CODE
	 */
	private String initiateSars(WithdrawCoreServiceDTO serviceDTO) {
		// TODO Auto-generated method stub 风控暂时不介入
		if (StringUtils.isBlank(serviceDTO.getMerchantNo())) {
			WithdrawReqDO reqDo = this.withdrawReqService.queryWithdrawReqByReqId(serviceDTO.getReqId());
			if (reqDo != null) {
				serviceDTO.setMcType(reqDo.getMcType());
				serviceDTO.setMerchantNo(reqDo.getMerchantNo());
				serviceDTO.setServiceType(reqDo.getServiceType());
			} else {
				return ReturnCodeEnums.FW_CORE_DATA_ERROR.code;
			}
		}
		SarsCP160Bean bean = new SarsCP160Bean(serviceDTO.getMerchantNo(), PosMerchantTypeEnums.getMerchantTypeByCode(serviceDTO.getMcType()).type,
				WithdrawServiceTypeEnums.getEnumByKey(serviceDTO.getServiceType()).type, serviceDTO.getRemitAmount(), serviceDTO.getRemitVoucherNo());
		boolean flag = this.sarsService.sarsClientVerify(bean.SarsBean2Json(bean));
		if (!flag) { return ReturnCodeEnums.FW_RISK_CONTROL_REFUSE.code; }

		return null;
	}

	/**
	 * 形成调用FOS明细的初始数据
	 *
	 * @param serviceDTO
	 */
	private WithdrawReqFosDetailDO buildWithdrawFosDetailInitData(WithdrawCoreServiceDTO serviceDTO) {

		WithdrawReqFosDetailDO detailDo = this.withdrawReqFosDetailService.createDoByServiceDto(serviceDTO);
		return detailDo;
	}

	/**
	 * 校验调用出款服务的数据
	 *
	 * @param serviceDTO
	 * @return 失败原因 CODE
	 */
	private String vaildateWithdrawServiceRequestDTO(WithdrawCoreServiceDTO serviceDTO) {
		Map<String, String> vaildateRequiredMap = new HashMap<String, String>();
		vaildateRequiredMap.put("productCode", "产品编码 ");
		vaildateRequiredMap.put("paymentCode", "支付编码 ");
		vaildateRequiredMap.put("remitVoucherNo", "出款订单号 ");
		vaildateRequiredMap.put("payerMemberId", "付款人会员ID");
		vaildateRequiredMap.put("isNeedCountFee", "是否需要计费");
		vaildateRequiredMap.put("payerFee", "付款人费用");
		vaildateRequiredMap.put("payeeFee", "收款人费用");
		vaildateRequiredMap.put("isPermitPricingErr", "是否允许计费异常");
		vaildateRequiredMap.put("payerAccountNo", "付款人储值账户ID");
		vaildateRequiredMap.put("bankCode", "开户行");
		vaildateRequiredMap.put("payeeCardNo", "收款人卡号");
		vaildateRequiredMap.put("gmtBizInitiate", "业务发起时间");
		// vaildateRequiredMap.put("gmtPaymentInitiate","支付发起时间");
		vaildateRequiredMap.put("remitAmount", "出款金额");
		vaildateRequiredMap.put("memo", "备注信息");
		return vaildateServiceRequestRequired(serviceDTO, vaildateRequiredMap);

	}

	private String vaildateServiceRequestRequired(WithdrawCoreServiceDTO serviceDTO, Map<String, String> vaildateRequiredMap) {
		if (serviceDTO != null) {
			if (vaildateRequiredMap != null) {
				for (Iterator<String> it = vaildateRequiredMap.keySet().iterator(); it.hasNext();) {
					String key = it.next();
					Object obj = getObjectFieldName(serviceDTO, key);
					if (obj == null || StringUtils.isBlank(obj.toString())) {
						logger.info("WithdrawT0ServiceServiceImpl #vaildateWithdrawServiceRequestDTO:"
								+ ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.msg + vaildateRequiredMap.get(key) + " is NULL");
						return ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.code;
					}
				}
			}
		} else {
			logger.info("WithdrawT0ServiceServiceImpl #vaildateWithdrawServiceRequestDTO:" + ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.msg
					+ "核心服务请求数据NULL");
			return ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.code;
		}

		return null;
	}

	public Object getObjectFieldName(Object object, String fieldName) {
		// 获得对象类型
		try {
			Class classType = object.getClass();
			String firstLetter = fieldName.substring(0, 1).toUpperCase(); // 获得和属性对应的getXXX()方法的名字
			String getMethodName = "get" + firstLetter + fieldName.substring(1); // 获得和属性对应的getXXX()方法的名字
			Method getMethod = classType.getMethod(getMethodName, new Class[] {}); // 获得和属性对应的getXXX()方法
			if (getMethod != null) { return getMethod.invoke(object, new Object[] {});

			}
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * 拼装核心接口所需数据
	 *
	 * @param paramMap
	 * @return
	 */
	public ErrorMessageVO<Object> bulidCoreData(WithdrawReqDO reqDo, WithdrawCoreServiceDTO dto) {
		// Map<String, Object> params = new HashMap<String, Object>();
		ErrorMessageVO<Object> vo = new ErrorMessageVO<Object>(true);
		try {
			String payerAccountNo = "";
			dto.setMerchantNo(reqDo.getMerchantNo());
			dto.setMcType(reqDo.getMcType());
			dto.setServiceType(reqDo.getServiceType());
			dto.setPaymentCode(reqDo.getPaymentCode());
			dto.setProductCode(reqDo.getProductCode());
			dto.setAppId(getAppId());
			dto.setReqId(reqDo.getReqId());
			dto.setRemitVoucherNo(generateRemitVoucherNo(dto.getProductCode(), dto.getPaymentCode(), reqDo.getRetryTimes(), reqDo.getReqId()));
			dto.setPayerMemberId(reqDo.getMemberId());
			dto.setIsNeedCountFee(WithdrawConstant.notNeedCountFee);
			dto.setPayerFee(String.valueOf(0.00));
			if (t0CostIsState()) {
				dto.setPayeeFee(String.valueOf(reqDo.getWithdrawCost().add(reqDo.getWdCost() == null ? BigDecimal.ZERO : reqDo.getWdCost())));
			} else {
				dto.setPayeeFee(String.valueOf(reqDo.getWithdrawCost()));
			}
			dto.setIsPermitPricingErr(WithdrawConstant.notPermitPricingErr);
			dto.setGmtBizInitiate(DateUtil.getLongDateString(new Date()));
			dto.setGmtPaymentInitiate(DateUtil.getLongDateString(new Date()));
			dto.setRemitAmount(String.valueOf(reqDo.getWithdrawAmount()));
			dto.setCallbackAddress(reqDo.getCallbackAddress());
			dto.setMemo(WithdrawServiceTypeEnums.getEnumByKey(reqDo.getServiceType()).desc);
			dto.setCurrency("CNY");
			dto.setWithdrawStatus(WithdrawConstant.withdrawStatusSucess);
			ErrorMessageVO<Object> cardInfoVo = cardInfo(reqDo, dto);
			ErrorMessageVO<Object> queryAccountVo = queryAccount(reqDo.getMemberId(), dto);
			if (!cardInfoVo.isSuccess()) { return cardInfoVo; }
			// vo = queryAccount(reqDo.getMemberId());
			if (!queryAccountVo.isSuccess()) {
				logger.error("BaseService#bulidCoreData queryAccount is not sucess appid:" + reqDo.getAppId() + "  orderNo:" + reqDo.getOrderNo()
						+ "ErrorMessageVO: " + ToStringBuilder.reflectionToString(vo));
				return queryAccountVo;
			}
			return vo;
		} catch (Exception e) {
			logger.error("BaseService#bulidCoreData is error appid:" + reqDo.getAppId() + "  orderNo:" + reqDo.getOrderNo() + e.getMessage(), e);
			return new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_CORE_DATA_ERROR.code, ReturnCodeEnums.FW_CORE_DATA_ERROR.desc);
		}

	}

	/**
	 * 出款银行卡
	 *
	 * @param reqDo
	 * @param dto
	 */
	private ErrorMessageVO<Object> cardInfo(WithdrawReqDO reqDo, WithdrawCoreServiceDTO dto) {
		if (PosMerchantTypeEnums.POS_MERCHANT.code.equals(reqDo.getMcType())) {
			// 调用crm 收款方委托到卡获取银行卡信息
			DelegationPay2CardInfo cardInfo = null;
			ErrorMessageVO<Object> vo = queryCRMbankInfo(reqDo.getMerchantNo());
			if (!vo.isSuccess()) {
				// 调用接口
				logger.error("BaseService#cardInfo is error " + ToStringBuilder.reflectionToString(reqDo) + " vo"
						+ ToStringBuilder.reflectionToString(vo));
				return vo;
			} else {
				cardInfo = (DelegationPay2CardInfo) vo.getParams().get("delegationPay2CardInfo");
				if (cardInfo == null) {
					logger.error("BaseService#cardInfo is error " + ToStringBuilder.reflectionToString(reqDo) + " vo"
							+ ToStringBuilder.reflectionToString(vo));
					vo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_NOT_BACK_CARD_INFO.code, ReturnCodeEnums.FW_NOT_BACK_CARD_INFO.msg);
					return vo;
				}
			}
			dto.setCompanyOrPersonal(cardInfo.getAccounttype() == 2 ? "B" : "C");
			dto.setCardType("DC");
			dto.setBankCode(cardInfo.getBankcode());// 开户行 32 不可空
			dto.setBankName(cardInfo.getBankname());// 开户行名称 128 可空
			dto.setBankBranch(cardInfo.getBranchname());// 支行名称 128 可空
			// dto.setBankLineNo(cardInfo.getBranchcode());// 支行编码(联行号) 32 可空
			dto.setBankProvince(cardInfo.getProvincename());
			dto.setBankCity(cardInfo.getCityname());// 银行所属城市 64 可空
			dto.setPayeeName(cardInfo.getAccountname());// 收款人姓名 50 不可空
			dto.setPayeeCardNo(cardInfo.getBankaccount());// 收款人卡号 30 不可空
		} else if (PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(reqDo.getMcType())) {
			//
			BankAccountQueryInfo bankInfo = null;
			PersonalAuthInfo perInfo = null;
			try {
				MerchantRealNameAuthQueryResp resp = merchantRealNameAuth.authQueryInfo(reqDo.getMerchantNo(), "zf910");
				if (resp!=null&&resp.getAuthInfo()!=null) { 
					bankInfo = resp.getAuthInfo().getBankAccountInfo();
					perInfo = resp.getAuthInfo().getPersonalAuthInfo();
				}else{
					logger.info("merchantRealNameAuth.authQueryInfo fail,MerchantRealNameAuthQueryResp:"+ToStringBuilder.reflectionToString(resp));
				}
			} catch (Exception e) {
				logger.error("merchantRealNameAuth.authQueryInfo is error merchantNo:" + reqDo.getMerchantNo() + e.getMessage(), e);
				return new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_CRM_INTERFACE_EXCEPTION.code,
						ReturnCodeEnums.FW_CRM_INTERFACE_EXCEPTION.msg);
			}

			if (bankInfo == null || perInfo == null) {
				logger.error("BaseService#cardInfo realNamebankInfo is null " + ToStringBuilder.reflectionToString(reqDo));
				return new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_NOT_BACK_CARD_INFO.code, ReturnCodeEnums.FW_NOT_BACK_CARD_INFO.msg);
			}
			dto.setCardType("DC");
			dto.setCompanyOrPersonal("C");
			dto.setBankCode(bankInfo.getBankCode());// 开户行 32 不可空
			dto.setBankName(bankInfo.getBankName());// 开户行名称 128 可空
			dto.setBankBranch(bankInfo.getBranchName());// 支行名称 128 可空
			// dto.setBankLineNo(bankInfo.getBranchCode());// 支行编码(联行号) 32 可空
			dto.setBankProvince(bankInfo.getProvinceName());
			dto.setBankCity(bankInfo.getCityName());// 银行所属城市 64 可空
			dto.setPayeeName(perInfo.getRealName());// 收款人姓名 50 不可空
			dto.setPayeeCardNo(bankInfo.getBankAccount());// 收款人卡号 30 不可空
		} else if (PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(reqDo.getMcType())) {
			//
			BankAccountInfo bankInfo=null;
			try {
				bankInfo=merchantBankCardWrapper.queryMerchantBankByMerchantId(reqDo.getMerchantNo());
			} catch (Exception e) {
				logger.error("BaseService#cardInfo queryMerchantBankByMerchantId is error merchantNo:" + reqDo.getMerchantNo() + e.getMessage(), e);
				return new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_CRM_INTERFACE_EXCEPTION.code,
						ReturnCodeEnums.FW_CRM_INTERFACE_EXCEPTION.msg);
			}
			
			if (bankInfo == null ) {
				logger.error("BaseService#cardInfo queryMerchantBankByMerchantId is null " + ToStringBuilder.reflectionToString(reqDo));
				return new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_NOT_BACK_CARD_INFO.code, ReturnCodeEnums.FW_NOT_BACK_CARD_INFO.msg);
			}
			PosMerchantInfoDO merchantInfo=this.fwPosMerchantInfoService.getPosMerchantInfoByMerchantInfo(reqDo.getMerchantNo(), reqDo.getMcType());
			if(merchantInfo!=null){
				dto.setCompanyOrPersonal("1".equals(merchantInfo.getCertType())?"C":"B");
				dto.setPayeeName(merchantInfo.getMerchantName());// 收款人姓名 50 不可空
			}
			dto.setCardType("DC");
			dto.setBankCode(bankInfo.getBankCode());// 开户行 32 不可空
			dto.setBankName(bankInfo.getBankName());// 开户行名称 128 可空
			dto.setBankBranch(bankInfo.getBranchName());// 支行名称 128 可空
			// dto.setBankLineNo(bankInfo.getBranchCode());// 支行编码(联行号) 32 可空
			dto.setBankProvince(bankInfo.getProvinceName());
			dto.setBankCity(bankInfo.getCityName());// 银行所属城市 64 可空
			dto.setPayeeCardNo(bankInfo.getBankAccount());// 收款人卡号 30 不可空
		}
		// 只有T0出款才判断是否配置委托付款银行卡信息
		if (String.valueOf(reqDo.getWithdrawType()).equals(WithdrawConstant.withdrawTypeRealTime)) {
			if (!this.validateFastFundOutBank(dto.getBankCode())) { return new ErrorMessageVO<Object>(false,
					ReturnCodeEnums.FW_CARD_NOTIN_DESIGNATED.code, ReturnCodeEnums.FW_CARD_NOTIN_DESIGNATED.msg); }
		}
		return new ErrorMessageVO<Object>(true);
	}

}
