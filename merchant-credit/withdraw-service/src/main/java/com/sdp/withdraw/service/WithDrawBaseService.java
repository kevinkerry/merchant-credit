package com.sdp.withdraw.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sdo.ma.ws.api.model.AccountInfo;
import com.sdp.mc.common.bean.newt0.LoaningConfigBean;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.enums.LoaningTypeEnum;
import com.sdp.mc.common.enums.OpOpenAndCloseEnums;
import com.sdp.mc.common.enums.withdraw.ProductCodeEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawReqStatusEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawServiceTypeEnums;
import com.sdp.mc.common.exception.IdentityLimitException;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.util.IPUtils;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.integration.ma.dto.MerchantBaseBalanceDTO;
import com.sdp.mc.ma.wrapper.AccountQueryFacadeWrapper;
import com.sdp.mc.newt0.dao.Newt0PromoterDO;
import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDO;
import com.sdp.mc.newt0.manager.Newt0PromoterManager;
import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDO;
import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDOExample;
import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDOExample.Criteria;
import com.sdp.mc.promoter.manager.PromoterFastSettleSwitchManager;
import com.sdp.mc.view.dao.ViewMerchantInfoDTO;
import com.sdp.mc.view.dao.ViewPromoterInfoDTO;
import com.sdp.withdraw.api.ratio.MerchantWithdrawRatioAPI;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.sdp.withdraw.enums.ReturnCodeEnums;
import com.sdp.withdraw.enums.WithdrawRatioTypeEnums;
import com.sdp.withdraw.error.WithdrawBizException;
import com.sdp.withdraw.service.impl.LimitationBaseService;
import com.sdp.withdraw.vo.WithdrawT0ServiceRequest;
import com.sdp.withdraw.vo.WithdrawT0ServiceResponse;
import com.sdp.withdraw.vo.ratio.WithdrawRatioQueryRequest;
import com.sdp.withdraw.vo.ratio.WithdrawRatioQueryResponse;
import com.sdp.withdraw.vo.ratio.WithdrawRatioRequest;
import com.sdp.withdraw.vo.ratio.WithdrawRatioResult;
import com.shengpay.service.view.MerchantInfoService;
import com.shengpay.service.view.PromoterInfoService;
import com.shengpay.service.withdraw.cost.impl.WithdrawCostServiceimpl;
import com.shengpay.service.workcalendar.WorkCalendarService;

public class WithDrawBaseService extends BaseService {

	private Logger logger = LoggerFactory.getLogger(WithDrawBaseService.class);
	@Autowired
	protected WithdrawReqService withdrawReqService;
	@Autowired
	protected WorkCalendarService workCalendarService;
	@Autowired
	private Newt0PromoterManager newt0PromoterManager;
	@Autowired
	private WithDrawLoaningConfigService withDrawLoaningConfigService;
	@Autowired
	private MerchantWithdrawRatioAPI withdrawRatioService4Hessian;
	@Autowired
	protected LimitationService limitationService;
	@Autowired
	private LimitationBaseService limitationBaseService;
	@Autowired
	private AccountQueryFacadeWrapper accountQueryFacadeWrapper;
	@Autowired
	private PromoterFastSettleSwitchManager promoterFastSettleSwitchManager;
	@Autowired
	protected ConfigOptionManager configOptionManager;
	@Autowired
	protected MerchantInfoService merchantInfoService;
	@Autowired
	private PromoterInfoService promoterInfoService;
	@Autowired
	private WithdrawCostServiceimpl withdrawCostServiceimpl;

	/**
	 * 判断是否执行新费率 11%+N
	 * 
	 * @return
	 */
	protected boolean t0CostIsState() {
		return withdrawCostServiceimpl.t0CostIsState();
	}

	/**
	 * 查询商户信息
	 * 
	 * @param merchantNo
	 * @param mcType
	 * @return
	 */
	protected ViewMerchantInfoDTO queryMerchantInfo(String merchantNo, String mcType) {
		ViewMerchantInfoDTO merchantInfo = merchantInfoService.queryMerchantInfoByMerchantNo(merchantNo, mcType);
		return merchantInfo;
	}

	/**
	 * 查询代理商信息
	 * 
	 * @param merchantNo
	 * @param mcType
	 * @return
	 */
	protected ViewPromoterInfoDTO queryPromoterInfo(String merchantNo, String mcType) {
		ViewMerchantInfoDTO merchantInfo = queryMerchantInfo(merchantNo, mcType);
		if (merchantInfo == null || merchantInfo.getPromoterId() == null) { return null; }
		return promoterInfoService.queryPromoterById(merchantInfo.getPromoterId());
	}

	/**
	 * 查询钱包余额
	 *
	 * @param memberId
	 * @return
	 */
	protected BigDecimal queryWalletBalance(String memberId) {
		AccountInfo accountInfo = maOnlineWrapper.queryBaseAccountInfo(memberId, IPUtils.getLocalIp());
		if (accountInfo == null) {
			logger.error("WithDrawBaseService#checkWallet accountInfo is null, memberId:" + memberId);
			return null;
		}
		AccountType accountType = null;
		if (accountInfo.getAccountType() == null) {
			logger.error("WithDrawBaseService#checkWallet accountInfo accountType is null, memberId:" + memberId);
			return null;
		}
		if (AccountType.B_BASE_ACCOUNT.code == accountInfo.getAccountType())
			accountType = AccountType.B_BASE_ACCOUNT;
		else if (AccountType.C_BASE_ACCOUNT.code == accountInfo.getAccountType())
			accountType = AccountType.C_BASE_ACCOUNT;
		else {
			logger.error("WithDrawBaseService#checkWallet accountInfo accountType " + accountInfo.getAccountType() + ", memberId:" + memberId);
			return null;
		}
		MerchantBaseBalanceDTO balanceDTO = accountQueryFacadeWrapper.queryAccountBalanceByAccountType(memberId, accountType);
		logger.info("WithDrawBaseService#checkWallet balanceDTO:" + ToStringBuilder.reflectionToString(balanceDTO));
		if (balanceDTO == null) {
			logger.error("WithDrawBaseService#checkWallet balanceDTO is null , memberId:" + memberId);
			return null;
		}
		return balanceDTO.getAccountBalance();

	}

	/**
	 * 判断商户是否开通快速结算
	 *
	 * @param merchantNo
	 * @param merchantType
	 * @return
	 */
	protected boolean isOpenFastSettle(String merchantNo, String merchantType) {
		ViewMerchantInfoDTO merchantInfo = merchantInfoService.queryMerchantInfoByMerchantNo(merchantNo, merchantType);
		if (merchantInfo == null) {
			logger.info("WithDrawBaseService#isOpenFastSettle fastSettleInfo is null merchantNo:" + merchantNo);
			return false;
		}
		Integer fastSettleFlag = merchantInfo.getMerchantFsFlag();
		if (fastSettleFlag == null) {
			logger.info("WithDrawBaseService#isOpenFastSettle fastSettleFlag is null merchantNo:" + merchantNo);
			return false;
		}
		return fastSettleFlag.equals(Integer.valueOf(MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN.trim())) ? true : false;
	}

	/**
	 * 判断代理商是否开通过281账户
	 * 
	 * @param stataus
	 * @param promoterId
	 * @return
	 */
	protected boolean promoterIsOpenFastSettle(Integer stataus, Long promoterId) {
		PromoterFastSettleSwitchDOExample example = new PromoterFastSettleSwitchDOExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(stataus);
		criteria.andPromoterIdEqualTo(promoterId);
		List<PromoterFastSettleSwitchDO> list = promoterFastSettleSwitchManager.selectByExample(example);
		if (list == null || list.size() <= 0) {
			logger.info("WithDrawBaseService#promoterIsOpenFastSettle list is null promoterId:" + promoterId + "stataus:" + stataus);
			return false;
		} else {
			logger.info("WithDrawBaseService#promoterIsOpenFastSettle list:" + ToStringBuilder.reflectionToString(list));
			return true;
		}

	}

	/**
	 * 判断代理商是否开通快速结算
	 * 
	 * @param merchantNo
	 * @param mcType
	 * @return
	 */
	protected boolean isPromoterOpenFastSettle(String merchantNo, String mcType) {
		ViewMerchantInfoDTO merchantInfo = merchantInfoService.queryMerchantInfoByMerchantNo(merchantNo, mcType);
		logger.info("isPromoterOpenFastSettle queryMerchantInfoByMerchantNo merchantInfo:" +ToStringBuilder.reflectionToString(merchantInfo,ToStringStyle.SIMPLE_STYLE));
		if (merchantInfo == null) {
			logger.info("WithDrawBaseService#isOpenFastSettle fastSettleInfo is null promoterNo:" + merchantNo);
			return false;
		}
		// PromoterEO promoterEO = promoterInfoList.get(0);
		Integer fastSettleFlag = merchantInfo.getPromoterFsFlag();
		if (fastSettleFlag == null) {
			logger.info("WithDrawBaseService#isOpenFastSettle fastSettleFlag is null promoterNo:" + merchantNo);
			return false;
		}
		boolean isNeedCheck = ConfigOptionHelper.getBooleanByKey(MerchantCreditConstant.PROMOTER_CHECK_IS_OPEN_ACCOUNT);
		// 代理商是否开过281并且并且配置成功
		if (isNeedCheck) {
			boolean isOpenAndGconfig = promoterIsOpenFastSettle(OpOpenAndCloseEnums.CONFIGURE_SUCCESS.getCode(), merchantInfo.getPromoterId());
			if (isOpenAndGconfig) {
				// 代理商是否开通快速结算
				return fastSettleFlag.equals(Integer.valueOf(MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN.trim())) ? true : false;
			} else {
				return isOpenAndGconfig;
			}
		} else {
			return fastSettleFlag.equals(Integer.valueOf(MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN.trim())) ? true : false;
		}

	}

	/**
	 * 查询商户快速结算信息
	 *
	 * @param merchantNo
	 * @return
	 */
	/*
	 * protected MerchantSettleEO merchantFasetInfo(String merchantNo) {
	 * MerchantSettleEO settleEo =
	 * merchantSettleDAO.selectEOByMerchantNo(merchantNo); return settleEo;
	 * 
	 * }
	 */

	/**
	 * 拼接入參
	 *
	 * @param request
	 * @return
	 */
	protected Map<String, Object> paramData(WithdrawT0ServiceRequest request) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("appid", request.getAppId());
		paramMap.put("orderNo", request.getOrderNo());
		paramMap.put("withdrawType", request.getWithdrawType());
		return paramMap;
	}

	/**
	 * 返回处理结果
	 *
	 * @param vo
	 * @param request
	 * @param orderStatus
	 * @param traceNo
	 * @return
	 */
	protected WithdrawT0ServiceResponse withdrawResult(ErrorMessageVO<Object> vo, WithdrawT0ServiceRequest request, Integer orderStatus, Long traceNo) {
		logger.info("WithDrawBaseService#withdrawResult  vo:" + ToStringBuilder.reflectionToString(vo));
		WithdrawT0ServiceResponse response = new WithdrawT0ServiceResponse();
		response.setErrorCode(vo.getErrorCode());
		response.setErrorMsg(vo.getErrorMessage());
		response.setMemberId(request.getMemberId());
		response.setMerchantNo(request.getMerchantNo());
		response.setOrderNo(request.getOrderNo());
		response.setOrderStatus(orderStatus != null ? orderStatus.toString() : WithdrawReqStatusEnums.WAITTING.code.toString());
		response.setTraceDate(request.getApplyTime());
		response.setTraceNo(traceNo == null ? "" : traceNo.toString());
		logger.info("WithDrawBaseService#withdrawResult  response:" + ToStringBuilder.reflectionToString(response));
		return response;
	}

	/**
	 * 是首次发起
	 *
	 * @param paramMap
	 *            appid orderNo
	 * @return
	 */
	protected WithdrawReqDO isFirstWithdraw(Map<String, Object> paramMap) {
		try {
			List<WithdrawReqDO> list = withdrawReqService.queryWithdrawByOrderNoAndAppID(paramMap);
			if (null != list && list.size() > 0)
				return list.get(0);
			else return null;
		} catch (Exception e) {
			logger.error("WithDrawBaseService#isFirstWithdraw is error paramMap:" + ToStringBuilder.reflectionToString(paramMap) + e.getMessage(), e);
			return null;
		}

	}

	/**
	 * 验证是否可以发起
	 *
	 * @param request
	 * @return
	 */
	protected ErrorMessageVO<Object> checkISCanStart(WithdrawT0ServiceRequest request) {
		if (!WithdrawConstant.withdrawTypeRealTime.equals(request.getWithdrawType())) {
			// 是否开通D1
			boolean isHoliDay = workCalendarService.isHolidayTime(DateUtil.increaseDate(new Date(), 1));
			try {
				if (isHoliDay) {
					boolean isOpenD1 = withdrawD1Available(request.getMerchantNo(), request.getMcType());
					if (!isOpenD1) { return new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_MERCHANT_NOT_OPEN_D1.code,
							ReturnCodeEnums.FW_MERCHANT_NOT_OPEN_D1.msg); }
				}

			} catch (Exception e) {
				logger.error("WithdrawT0ServiceServiceImpl#checkISCanStart is error merchantNo:" + request.getMerchantNo() + e.getMessage(), e);
				return new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_SYSTEM_ERROR.code, ReturnCodeEnums.FW_SYSTEM_ERROR.msg);
			}
		}
		return new ErrorMessageVO<Object>(true);
	}

	/**
	 * 判断额度是否充足（代理商额度，商户额度，出款总额度）
	 *
	 * @param merchantNo
	 * @param withdrawAmount
	 * @param mctype
	 * @return
	 */
	protected ErrorMessageVO<Object> withdrawAmountIsEnough(String merchantNo, BigDecimal withdrawAmount, String mctype) {
		ErrorMessageVO<Object> vo = null;

		// 商户额度是否满足
		vo = merchantAmount(merchantNo, mctype, withdrawAmount);
		if (!vo.isSuccess()) return vo;
		// 代理商额度是否满足
		vo = promoterAmount(merchantNo, mctype, withdrawAmount);
		if (!vo.isSuccess()) return vo;
		// 判断垫资方类型 如果是盛付通垫资 判断盛付通垫资总额的是否满足要求
		LoaningConfigBean loaningConfgiBean = queryLoaningConfigBean(merchantNo, mctype);
		if (loaningConfgiBean == null) { return new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_LOANINGCONFIGBEAN_NOTFOUND.code,
				ReturnCodeEnums.FW_LOANINGCONFIGBEAN_NOTFOUND.msg); }
		if (LoaningTypeEnum.SHENGPAY.code == loaningConfgiBean.getLoaingType()) {
			BigDecimal totalAmount = settlementAmount(merchantNo, mctype);
			if (null == totalAmount)
				return new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_GET_TOTAL_AMOUNT_ISFAILL.code,
						ReturnCodeEnums.FW_GET_TOTAL_AMOUNT_ISFAILL.msg);
			if (totalAmount.compareTo(withdrawAmount) < 0) {
				// 总额度不足
				return new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_TOTALAMOUNT_INSUFFICIENT.code,
						ReturnCodeEnums.FW_TOTALAMOUNT_INSUFFICIENT.msg);
			}
		}
		if (PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(mctype) ||PosMerchantTypeEnums.POS_MERCHANT.code.equals(mctype) || PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(mctype)) {// 身份额度判断
			// 商户身份额度是否满足
			vo = judgeMerchantIdentityAmount(merchantNo, mctype, withdrawAmount,false);
			if (!vo.isSuccess()) return vo;
		}
		vo = new ErrorMessageVO<Object>(true);
		return vo;
	}

	/**
	 * 
	 * @param merchantNo
	 * @param mctype
	 * @param withdrawAmount
	 * @param isFrozenLimitation 额度是否已经冻结 
	 * @return
	 */
	private ErrorMessageVO<Object> judgeMerchantIdentityAmount(String merchantNo, String mctype, BigDecimal withdrawAmount, boolean isFrozenLimitation) {
		ErrorMessageVO<Object> vo = null;
		try {
			boolean flag = this.limitationBaseService.checkIdentityLimit(merchantNo, mctype, withdrawAmount,isFrozenLimitation);
			if (flag) {
				vo = new ErrorMessageVO<Object>(true);
			} else {
				vo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_IDENTITY_LIMITE_NOT_ENOUGH.code,
						ReturnCodeEnums.FW_IDENTITY_LIMITE_NOT_ENOUGH.msg);
			}
		} catch (IdentityLimitException e) {
			vo = new ErrorMessageVO<Object>(false, e.getErrorCode(), e.getErrorMessage());
			logger.error("judgeMerchantIdentityAmount is error merchantNO:" + merchantNo + e.getMessage(), e);
		} catch (Exception e) {
			vo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_IDENTITY_LIMITE_QUERY_ERROR.code,
					ReturnCodeEnums.FW_IDENTITY_LIMITE_QUERY_ERROR.msg);
			logger.error("judgeMerchantIdentityAmount is error merchantNO:" + merchantNo + e.getMessage(), e);
		}
		return vo;
	}

	/**
	 * 获取费率类型
	 *
	 * @param merchantNo
	 * @param merchantType
	 * @return
	 * @throws Exception
	 */
	protected BigDecimal withdrawRate(String merchantNo, String merchantType, String withdrawType) throws Exception {
		WithdrawRatioResult result = null;
		// 判断明天是否是节假日
		boolean isHoliDay = workCalendarService.isHolidayTime(DateUtil.increaseDate(new Date(), 1));
		if (WithdrawConstant.withdrawTypeRealTime.equals(withdrawType)) {
			// 如果实时出款费率T0
			if (PosMerchantTypeEnums.POS_MERCHANT.code.equals(merchantType)) {
				result = getMerchantWithdrawRatio(merchantNo, merchantType, WithdrawRatioTypeEnums.POS_T0_SETTLE_RATIO.code);
				return !isHoliDay ? result.getWorkDayWithDrawRatio() : result.getHolidayWithDrawRatio();
			}
			if (PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(merchantType)) {
				result = getMerchantWithdrawRatio(merchantNo, merchantType, WithdrawRatioTypeEnums.MPOS_T0_SETTLE_RATIO.code);
				return !isHoliDay ? result.getWorkDayWithDrawRatio() : result.getHolidayWithDrawRatio();
			}
			if (PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(merchantType)) {
				result = getMerchantWithdrawRatio(merchantNo, merchantType, WithdrawRatioTypeEnums.EASYPAY_T0_SETTLE_RATIO.code);
				return !isHoliDay ? result.getWorkDayWithDrawRatio() : result.getHolidayWithDrawRatio();
			}
		} else {
			if (isHoliDay) {
				boolean isOpenD1 = withdrawD1Available(merchantNo, merchantType);
				// 开通D1
				if (isOpenD1) {
					result = getMerchantWithdrawRatio(merchantNo, merchantType, WithdrawRatioTypeEnums.MPOS_D1_SETTLE_RATIO.code);
					return result.getHolidayWithDrawRatio();
				}
			} else {
				// 未开通T1
				result = getMerchantWithdrawRatio(merchantNo, merchantType, WithdrawRatioTypeEnums.MPOS_T1_SETTLE_RATIO.code);
				return result.getWorkDayWithDrawRatio();
			}
		}

		return null;
	}

	/**
	 * 查询费率
	 *
	 * @param merchantNo
	 * @param merchantType
	 * @param withdrawRatioType
	 * @return
	 * @throws Exception
	 * @throws WithdrawBizException
	 */
	protected WithdrawRatioResult getMerchantWithdrawRatio(String merchantNo, String merchantType, Integer withdrawRatioType) throws Exception,
			WithdrawBizException {
		WithdrawRatioQueryRequest queryRequest = new WithdrawRatioQueryRequest(merchantNo, merchantType, withdrawRatioType);
		WithdrawRatioQueryResponse queryResponse = withdrawRatioService4Hessian.getMerchantCurrentAvaliableWithdrawRatio(queryRequest);
		if (StringUtils.isNotBlank(queryResponse.getErrorCode()) && !ReturnCodeEnums.FW_SUCCESS.code.equals(queryResponse.getErrorCode())) {
			logger.error("merchantNo:" + merchantNo + ",merchantType:" + merchantType + ",error code:" + queryResponse.getErrorCode());
			throw new Exception("error code:" + queryResponse.getErrorCode() + ",error msg:" + queryResponse.getErrorMsg());
		}

		List<WithdrawRatioResult> withdrawRatioResults = queryResponse.getWithdrawRatioResults();
		if (withdrawRatioResults != null && !withdrawRatioResults.isEmpty()) return withdrawRatioResults.get(0);
		return null;
	}

	/**
	 * 是否开通D1
	 *
	 * @param merchantNo
	 * @param merchantType
	 * @return 开通-true 未开通-false
	 * @throws Exception
	 */
	public boolean withdrawD1Available(String merchantNo, String merchantType) throws Exception {
		WithdrawRatioRequest withdrawRatioRequest = new WithdrawRatioRequest(merchantNo, merchantType);
		return withdrawRatioService4Hessian.withdrawD1Available(withdrawRatioRequest);
	}

	/**
	 * 是否需要冻结额度 目前只有T0需要冻结额度
	 *
	 * @param withdrawType
	 * @return
	 */
	protected boolean isNeedForzenAmount(String withdrawType) {
		if (WithdrawConstant.withdrawTypeRealTime.equals(withdrawType))
			return true;
		else return false;
	}

	/**
	 * 冻结额度，判断额度放一起 需要加事务 只有T0出款才需要判断额度冻结额度
	 *
	 * @param request
	 * @return
	 */
	@Transactional
	public ErrorMessageVO<Object> checkWithdrawAmount(String merchantNo, BigDecimal withdrawAmount, String mctype, String withdrawType) {
		ErrorMessageVO<Object> vo = null;

		if (WithdrawConstant.withdrawTypeRealTime.equals(withdrawType)) {
			// 冻结额度
			boolean freeAmount = limitationService.frozenLimitation(merchantNo, mctype, withdrawAmount);
			if (!freeAmount) {
				// 判断额度
				vo = withdrawAmountIsEnough(merchantNo, withdrawAmount, mctype);
				if (!vo.isSuccess())
					return vo;
				else {
					// 冻结额度
					freeAmount = limitationService.frozenLimitation(merchantNo, mctype, withdrawAmount);
					if (!freeAmount)
						return new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_FROZENLIMITATION_FAIL.code,
								ReturnCodeEnums.FW_FROZENLIMITATION_FAIL.msg);
					else return new ErrorMessageVO<Object>(true);

				}

			} else {
				/*if (PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(mctype) || PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(mctype)) {// 身份额度判断
					// 商户身份额度是否满足
					vo = judgeMerchantIdentityAmount(merchantNo, mctype, withdrawAmount,true);
					if (!vo.isSuccess()) {
						limitationService.restoreFrozenQuota(merchantNo, mctype, withdrawAmount);
						return vo;
					}
				}*/
				return new ErrorMessageVO<Object>(true);
			}

		} else return new ErrorMessageVO<Object>(true);

	}

	/**
	 * 交易之前已发起过
	 *
	 * @param request
	 * @return
	 */
	protected WithdrawT0ServiceResponse dataAlreadyExists(WithdrawReqDO dto, WithdrawT0ServiceRequest request) {
		ErrorMessageVO<Object> vo = this.withdrawReqService.dealwithExistsWithdraw(dto);
		return withdrawResult(vo, request, dto.getStatus(), dto.getReqId());
	}

	/**
	 * 是否在服务时间范围内
	 *
	 * @return
	 */
	protected ErrorMessageVO<Object> timeFrame(Date date, String merchantNo, String mcType) {
		try {
			LoaningConfigBean loaningConfigBean = queryLoaningConfigBean(merchantNo, mcType);
			if (null == loaningConfigBean)
				return new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_LOANINGCONFIGBEAN_NOTFOUND.code,
						ReturnCodeEnums.FW_LOANINGCONFIGBEAN_NOTFOUND.msg);
			return timeFrame(date,loaningConfigBean);
		} catch (Exception e) {
			logger.error("WithDrawBaseService#timeFrame is error merchantNo:" + merchantNo + e.getMessage(), e);
			return new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_SYSTEM_ERROR.code, ReturnCodeEnums.FW_SYSTEM_ERROR.msg);
		}
	}
	protected ErrorMessageVO<Object> timeFrame(Date date, LoaningConfigBean loaningConfigBean) {
	     	if (null == loaningConfigBean)
			    return new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_LOANINGCONFIGBEAN_NOTFOUND.code,
					ReturnCodeEnums.FW_LOANINGCONFIGBEAN_NOTFOUND.msg);
			if (date.compareTo(loaningConfigBean.findFsBeginDate()) <0 || date.compareTo(loaningConfigBean.findFsEndDate()) >0)
				return new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_SERVER_NOT_RANGE.code, ReturnCodeEnums.FW_SERVER_NOT_RANGE.msg);
			else return new ErrorMessageVO<Object>(true);
	}

	/**
	 * 根据代理商ID查询垫资方信息
	 *
	 * @param loaningType
	 * @return
	 */

	protected LoaningConfigBean queryLoaningConfigBean(String merchantNo, String mcType) {

		// PromoterEO promoterNo = queryPromoterNo(merchantNo, mcType);
		ViewMerchantInfoDTO merchantInfo = merchantInfoService.queryMerchantInfoByMerchantNo(merchantNo, mcType);
		if (merchantInfo == null) return null;
		/*
		 * try { promoterId = merchantInfo.getPromoterId(); promoterDO =
		 * newt0PromoterManager
		 * .getPromoterByMerchantId(merchantInfo.getPromoterId()); if
		 * (promoterDO == null) {
		 * logger.error("WithDrawBaseService #queryLoaningConfigBean, promoterId:"
		 * + promoterId + ",promoterDO is null."); return null; } } catch
		 * (Exception e) { logger.error(
		 * "WithDrawBaseService #queryLoaningConfigBean is error, merchantNo:" +
		 * merchantNo + " promoterDO:" + promoterId + "  " + e.getMessage(), e);
		 * return null; }
		 */
		// 垫资方
		try {
			LoaningTypeEnum loaningTypeEnum = LoaningTypeEnum.getLoaningTypeEnum(merchantInfo.getLoaningType());
			if (loaningTypeEnum == null) {
				logger.error("WithDrawBaseService#queryLoaningConfigBean  The loaningType is not the standard type ");
				return null;
			}
			// 查询垫资方基础信息
			LoaningConfigBean loaningConfigBean = withDrawLoaningConfigService.getLoaningConfigBeanByLoaningType(loaningTypeEnum);
			// TODO 判断商户类型
			loaningConfigBean = withDrawLoaningConfigService.getLoaningConfigBeanByLoaningTypeMcType(loaningConfigBean,
					merchantInfo.getPromoterType());
			return loaningConfigBean;
		} catch (Exception e) {
			logger.error("WithDrawBaseService#queryLoaningConfigBean is error" + e.getMessage(), e);
			return null;
		}

	}

	/**
	 * 获取服务编码
	 *
	 * @param withdrawType
	 * @param mcType
	 * @param merchantNo
	 * @return
	 * @throws Exception
	 */
	protected WithdrawServiceTypeEnums getServerType(String withdrawType, String mcType, String merchantNo) throws Exception {
		boolean isHolidDay = workCalendarService.isHolidayTime(DateUtil.increaseDate(new Date(), 1));
		if (WithdrawConstant.withdrawTypeRealTime.equals(withdrawType)) {
			// 如果实时出款费率T0
			return WithdrawServiceTypeEnums.T0;
		} else {
			boolean isOpenD1 = withdrawD1Available(merchantNo, mcType);
			if (isHolidDay && isOpenD1) {
				// D1
				return WithdrawServiceTypeEnums.D1;
			} else {
				// T1
				return WithdrawServiceTypeEnums.T1;
			}
		}

	}

	/**
	 * 获取产品编码 支付编码 业务类型
	 *
	 * @param withdrawType
	 * @param mcType
	 * @param merchantNo
	 * @return
	 */
	protected Map<String, Object> getProductTypeInfo(String withdrawType, String mcType, String merchantNo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String productCode = null;
		String paymentCode = null;
		try {
			WithdrawServiceTypeEnums enums = this.getServerType(withdrawType, mcType, merchantNo);
			if (WithdrawServiceTypeEnums.T0.code.equals(enums.code)) {
				if (PosMerchantTypeEnums.POS_MERCHANT.code.equals(mcType)) {
					productCode = ProductCodeEnums.T0_POS_Withdraw.getProductCode();
					paymentCode = ProductCodeEnums.T0_POS_Withdraw.getPaymentCode();
				} else if (PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(mcType)) {
					productCode = ProductCodeEnums.T0_MPOS_Withdraw.getProductCode();
					paymentCode = ProductCodeEnums.T0_MPOS_Withdraw.getPaymentCode();
				} else if (PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(mcType)) {
					productCode = ProductCodeEnums.T0_EAYSPAY_Withdraw.getProductCode();
					paymentCode = ProductCodeEnums.T0_EAYSPAY_Withdraw.getPaymentCode();
				}
			} else if (WithdrawServiceTypeEnums.T1.code.equals(enums.code) && PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(mcType)) {
				productCode = ProductCodeEnums.T1_MPOS_Withdraw.getProductCode();
				paymentCode = ProductCodeEnums.T1_MPOS_Withdraw.getPaymentCode();
			} else if (WithdrawServiceTypeEnums.D1.code.equals(enums.code) && PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(mcType)) {
				productCode = ProductCodeEnums.D1_MPOS_Withdraw.getProductCode();
				paymentCode = ProductCodeEnums.D1_MPOS_Withdraw.getPaymentCode();
			}
			resultMap.put("serverType", enums.code);
			resultMap.put("productCode", productCode);
			resultMap.put("paymentCode", paymentCode);
			return resultMap;
		} catch (Exception e) {
			logger.error("getProductTypeInfo is error resultMap is null" + e.getMessage(), e);
			return resultMap;
		}

	}

	/**
	 * 最低额度是否满足
	 *
	 * @param amount
	 * @return
	 */
	protected boolean lowestAmount(BigDecimal amount, String merchantNo, String mcType) {
		try {
			BigDecimal flowAmount = lowestAmount(merchantNo, mcType);
			if (flowAmount == null) {
				logger.error("WithDrawBaseService#lowestAmount flowAmount is null " + merchantNo);
				return false;
			}
			if (amount.compareTo(flowAmount) >= 0)
				return true;
			else return false;
		} catch (Exception e) {
			logger.error("WithDrawBaseService#lowestAmount is error" + e.getMessage(), e);
			return false;
		}
	}

	protected BigDecimal lowestAmount(String merchantNo, String mcType) {
		try {
			LoaningConfigBean loaningConfigBean = queryLoaningConfigBean(merchantNo, mcType);
			if (null == loaningConfigBean) {
				logger.error("WithDrawBaseService#lowestAmount loaningConfigBean is null merchantNo" + merchantNo);
				return null;
			}
			BigDecimal flowAmount = loaningConfigBean.getFloorAmt();
			if (null == flowAmount) {
				logger.error("WithDrawBaseService#lowestAmount flowAmount is null merchantNo" + merchantNo);
				return null;
			}
			return flowAmount;
		} catch (Exception e) {
			logger.error("WithDrawBaseService#lowestAmount is error" + e.getMessage(), e);
			return null;
		}
	}

	/**
	 * 商户额度
	 *
	 * @return
	 */
	protected ErrorMessageVO<Object> merchantAmount(String merchantNO, String mcType, BigDecimal amount) {
		ErrorMessageVO<Object> vo = new ErrorMessageVO<Object>(false);
		try {
			BigDecimal canUserQuota = merchantAmount(merchantNO, mcType);
			if (null == canUserQuota)
				return new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_GET_MERCHANT_AMOUNT_ISFAILL.code,
						ReturnCodeEnums.FW_GET_MERCHANT_AMOUNT_ISFAILL.msg);
			if (canUserQuota.compareTo(amount) >= 0) {
				vo.setSuccess(true);
				return vo;
			} else {
				logger.info("#merchantAmount merchant limit is not enough,amount:{},canUserQuota:{},merchantNO:{}", new Object[] { amount,
						canUserQuota, merchantNO });
				vo.setErrorCode(ReturnCodeEnums.FW_MERCHANT_LIMIT_INSUFFICIENT.code);
				vo.setErrorMessage(ReturnCodeEnums.FW_MERCHANT_LIMIT_INSUFFICIENT.msg);
				return vo;
			}
		} catch (Exception e) {
			vo.setErrorCode(ReturnCodeEnums.FW_SYSTEM_ERROR.code);
			vo.setErrorMessage(ReturnCodeEnums.FW_SYSTEM_ERROR.msg);
			logger.error("BaseService#merchantAmount is error merchantNO:" + merchantNO + e.getMessage(), e);
			return vo;
		}
	}

	protected BigDecimal merchantAmount(String merchantNO, String mcType) {
		try {
			BigDecimal canUserQuota = limitationService.findMerchantFastCanUseQuota(merchantNO, mcType);
			if (null == canUserQuota) {
				logger.error("WithDrawBaseService#merchantAmount canUserQuota is null merchantNo" + merchantNO);
				return null;
			}
			return canUserQuota;
		} catch (Exception e) {
			logger.error("BaseService#merchantAmount is error merchantNO:" + merchantNO + e.getMessage(), e);
			return null;
		}
	}

	/**
	 * 代理商额度
	 *
	 * @param merchantNO
	 * @return
	 */
	protected ErrorMessageVO<Object> promoterAmount(String merchantNO, String mcType, BigDecimal amount) {
		ErrorMessageVO<Object> vo = null;
		try {
			BigDecimal canUserQuota = promoterAmount(merchantNO, mcType);
			if (null == canUserQuota)
				return new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_GET_PROMOTER_AMOUNT_ISFAILL.code,
						ReturnCodeEnums.FW_GET_PROMOTER_AMOUNT_ISFAILL.msg);
			if (canUserQuota.compareTo(amount) >= 0) {
				vo = new ErrorMessageVO<Object>(true);
				return vo;
			} else {
				vo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_PROMOTER_LIMIT_INSUFFICIENT.code,
						ReturnCodeEnums.FW_PROMOTER_LIMIT_INSUFFICIENT.msg);
				return vo;
			}
		} catch (Exception e) {
			vo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_SYSTEM_ERROR.code, ReturnCodeEnums.FW_SYSTEM_ERROR.msg);
			logger.error("BaseService#promoterAmount is error merchantNO:" + merchantNO + e.getMessage(), e);
			return vo;
		}
	}

	/**
	 * 要先根据商户号查询代理商信息
	 *
	 * @param merchantNo
	 * @param mcType
	 * @return
	 */
	protected BigDecimal promoterAmount(String merchantNo, String mcType) {
		try {
			// PromoterEO promoterEO = queryPromoterNo(merchantNo, mcType);
			ViewMerchantInfoDTO merchantInfo = merchantInfoService.queryMerchantInfoByMerchantNo(merchantNo, mcType);
			if (merchantInfo == null) {
				logger.error("WithDrawBaseService#promoterAmount ViewMerchantInfoDTO is null, merchantNo" + merchantNo + "mctype:" + mcType);
				return null;
			}
			if (StringUtils.isBlank(merchantInfo.getPromoterMerchantNo())) {
				logger.error("WithDrawBaseService#promoterAmount promotermerchantNO is null, merchantNo:" + merchantNo);
				return null;
			}
			BigDecimal canUserQuota = limitationService.findMerchantFastCanUseQuota(merchantInfo.getPromoterMerchantNo(),
					merchantInfo.getPromoterType());
			if (null == canUserQuota) {
				logger.error("WithDrawBaseService#promoterAmount canUserQuota is null merchantNo" + merchantNo);
				return null;
			}
			return canUserQuota;
		} catch (Exception e) {
			logger.error("BaseService#promoterAmount is error merchantNO:" + merchantNo + e.getMessage(), e);
			return null;
		}
	}

	/**
	 * 出款总额度
	 *
	 * @return
	 */
	protected ErrorMessageVO<Object> settlementAmount(String merchantNO, String mcType, BigDecimal amount) {
		ErrorMessageVO<Object> vo = null;
		try {
			BigDecimal canUserQuota = settlementAmount(merchantNO, mcType);
			if (null == canUserQuota)
				return new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_GET_TOTAL_AMOUNT_ISFAILL.code,
						ReturnCodeEnums.FW_GET_TOTAL_AMOUNT_ISFAILL.msg);
			if (canUserQuota.compareTo(amount) == 1) {
				vo = new ErrorMessageVO<Object>(true);
				return vo;
			} else {
				vo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_TOTALAMOUNT_INSUFFICIENT.code,
						ReturnCodeEnums.FW_TOTALAMOUNT_INSUFFICIENT.msg);
				return vo;
			}
		} catch (Exception e) {
			vo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_SYSTEM_ERROR.code, ReturnCodeEnums.FW_SYSTEM_ERROR.msg);
			logger.error("BaseService#settlementAmount is error merchantNO:" + merchantNO + e.getMessage(), e);
			return vo;
		}
	}

	protected BigDecimal settlementAmount(String merchantNo, String mctype) {
		try {
			Newt0SdpRemainBalanceDO sdpRemainBalanceDO = limitationBaseService.getNowRemainBalance();
			if (null == sdpRemainBalanceDO || sdpRemainBalanceDO.getCanUseQuota() == null) {
				logger.error("WithDrawBaseService#settlementAmount  is null merchantNo" + merchantNo);
				return null;
			}
			return sdpRemainBalanceDO.getCanUseQuota();
		} catch (Exception e) {
			logger.error("WithDrawBaseService#settlementAmount is error" + e.getMessage(), e);
			return new BigDecimal(0);
		}
	}

	/**
	 * 多个额度比较 拿到最小 最后一个最小 第一个最大
	 *
	 * @param amounts
	 * @return
	 */
	public static BigDecimal sortAmount(BigDecimal[] amounts, int returnAmount) {

		for (int i = 0; i < amounts.length - 1; i++) { // 最多做n-1趟排序
			for (int j = 0; j < amounts.length - i - 1; j++) { // 对当前无序区间score[0......length-i-1]进行排序(j的范围很关键，这个范围是在逐步缩小的)
				if (amounts[j].compareTo(amounts[j + 1]) < 0) { // 把小的值交换到后面
					BigDecimal temp = amounts[j];
					amounts[j] = amounts[j + 1];
					amounts[j + 1] = temp;
				}
			}

		}
		return amounts[returnAmount];
	}
}
