package com.sdp.withdraw.service.hessian;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.sdo.common.lang.StringUtil;
import com.sdp.mc.common.bean.newt0.LoaningConfigBean;
import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.dto.WithdrawCoreServiceDTO;
import com.sdp.mc.common.enums.LoaningTypeEnum;
import com.sdp.mc.common.enums.PolicyTypeEnums;
import com.sdp.mc.common.enums.YesNoEnum;
import com.sdp.mc.common.enums.withdraw.WithdrawReqStatusEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawServiceTypeEnums;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.cs.ICSQueryPartyGroup;
import com.sdp.mc.ma.wrapper.UesRemoteServiceClient;
import com.sdp.mc.view.dao.ViewMerchantInfoDTO;
import com.sdp.mc.view.dao.ViewPromoterInfoDTO;
import com.sdp.mc.withdraw.entity.WithdrawQueryResult;
import com.sdp.withdraw.api.WithdrawT0ServiceAPI;
import com.sdp.withdraw.dao.PolicyConfigInfoDO;
import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.dao.PosMerchantInfoDOExample;
import com.sdp.withdraw.dao.WithdrawRatioInfoDO;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqDOExample.Criteria;
import com.sdp.withdraw.dao.ext.ExtWithdrawReqDOExample;
import com.sdp.withdraw.dao.ext.ExtWithdrawReqVO;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.sdp.withdraw.enums.ReturnCodeEnums;
import com.sdp.withdraw.enums.WithdrawPromptEnums;
import com.sdp.withdraw.enums.WithdrawRatioTypeEnums;
import com.sdp.withdraw.manager.PosMerchantInfoManager;
import com.sdp.withdraw.manager.ext.ExtWithdrawRatioInfoManager;
import com.sdp.withdraw.manager.ext.ExtWithdrawReqManager;
import com.sdp.withdraw.service.LimitationService;
import com.sdp.withdraw.service.WithDrawBaseService;
import com.sdp.withdraw.service.WithdrawCallQueueService;
import com.sdp.withdraw.service.WithdrawFailService;
import com.sdp.withdraw.service.WithdrawReqExtraInfoService;
import com.sdp.withdraw.service.WithdrawT0ServiceService;
import com.sdp.withdraw.service.impl.LimitationBaseService;
import com.sdp.withdraw.vo.WithdrawCheckRequest;
import com.sdp.withdraw.vo.WithdrawCheckResponse;
import com.sdp.withdraw.vo.WithdrawProductRequest;
import com.sdp.withdraw.vo.WithdrawProductResponse;
import com.sdp.withdraw.vo.WithdrawProductResult;
import com.sdp.withdraw.vo.WithdrawQueryRequest;
import com.sdp.withdraw.vo.WithdrawQueryResponse;
import com.sdp.withdraw.vo.WithdrawResult;
import com.sdp.withdraw.vo.WithdrawT0ServiceRequest;
import com.sdp.withdraw.vo.WithdrawT0ServiceResponse;
import com.sdp.withdraw.vo.ratio.WithdrawRatioResult;
import com.shengpay.boss.service.crm.query.api.model.DelegationPay2CardInfo;
import com.shengpay.commom.config.GlobalConfig;
import com.shengpay.service.withdraw.PolicyConfigInfoService;
import com.shengpay.service.withdraw.cost.WithdrawCostConfigService;

@Service("withdrawServiceHessian")
public class WithdrawT0Service4HessianImpl extends WithDrawBaseService implements WithdrawT0ServiceAPI {
	private Logger logger = LoggerFactory.getLogger(WithdrawT0Service4HessianImpl.class);
	@Autowired
	private WithdrawFailService withdrawFailService;
	@Autowired
	private WithdrawCallQueueService withdrawCallQueueService;
	@Autowired
	private WithdrawT0ServiceService withdrawT0ServiceService;
	@Autowired
	private ExtWithdrawReqManager extWithdrawReqManager;
	@Autowired
	private PosMerchantInfoManager posMerchantInfoManager;
	@Autowired
	private ExtWithdrawRatioInfoManager extWithdrawRatioInfoManager;
	@Autowired
	private LimitationService limitationService;
	@Autowired
	private LimitationBaseService limitationBaseService;
	// @Autowired
	// private MajorWithdrawServiceImpl majorWithdrawServiceImpl;
	@Autowired
	private UesRemoteServiceClient uesRemoteServiceClient;
	@Autowired
	private WithdrawCostConfigService withdrawCostConfigService;
	@Autowired
	private ICSQueryPartyGroup csQueryPartyGroup;
	@Autowired
	private WithdrawReqExtraInfoService withdrawReqExtraInfoService;
	@Autowired
	private PolicyConfigInfoService policyConfigInfoService;

	@Override
	public WithdrawT0ServiceResponse t0WithdrawPos(WithdrawT0ServiceRequest request) {
		logger.info("WithdrawT0Service4HessianImpl#t0WithdrawPos  is init rquest:" + ToStringBuilder.reflectionToString(request));
		ErrorMessageVO<Object> vo = new ErrorMessageVO<Object>(true);
		WithdrawCoreServiceDTO dto = new WithdrawCoreServiceDTO();
		WithdrawReqDO reqDo = null;
		boolean frozenFlag = false;// 冻结额度标识 true 冻结状态 false 非冻结
		try {
			// 判断 是否可以发起（服务时间，参数合法性校验）
			vo = isCanLaunch(request, WithdrawConstant.reqTypePOS);
			if (!vo.isSuccess()) { return withdrawResult(vo, request, WithdrawReqStatusEnums.FAIL.code, null); }
			if ("".equals(request.getWithdrawType()) || null == request.getWithdrawType())
				request.setWithdrawType(WithdrawConstant.withdrawTypeRealTime);
			String memberId = "";
			// 查询会员ID memberId
			boolean isDelayPayFlag = false;
			BigDecimal origWithdrawAmount = null;
			vo = queryMemberIdByMerhantNo(request.getMerchantNo());
			if (!vo.isSuccess()) {
				return withdrawResult(vo, request, WithdrawReqStatusEnums.FAIL.code, null);
			} else {
				memberId = vo.getParams().get("memberId").toString();
				// 判断是否开通后付费
				isDelayPayFlag = csQueryPartyGroup.queryPartyGroupByMemberId(memberId);
				// 如果是后付费 定义两个变量 标示，和源出款金额，并将现有出款金额改成 收单原始金额
				if (isDelayPayFlag) {
					origWithdrawAmount = request.getWithdrawAmount();
					request.setWithdrawAmount(request.getOriginalAmount());
				}
				// 判断额度
				BigDecimal walletBalance = queryWalletBalance(memberId);
				if (walletBalance == null || walletBalance.compareTo(request.getWithdrawAmount()) < 0) {
					vo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_MERCHANT_WALLETBALACE_ISENOUGH.code,
							ReturnCodeEnums.FW_MERCHANT_WALLETBALACE_ISENOUGH.msg);
					return withdrawResult(vo, request, WithdrawReqStatusEnums.FAIL.code, null);
				}
			}
			request.setMemberId(memberId);
			// 判断之前是否发起过
			reqDo = isFirstWithdraw(paramData(request));
			if (null != reqDo) { return dataAlreadyExists(reqDo, request); }
			// 判断最低额度
			if (!lowestAmount(request.getOriginalAmount(), request.getMerchantNo(), request.getMcType())) {
				vo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_LOW_AMOUNT.code, ReturnCodeEnums.FW_LOW_AMOUNT.msg);
				return withdrawResult(vo, request, WithdrawReqStatusEnums.FAIL.code, null);
			}
			// 检查额度 （冻结额度，额度判断）
			vo = checkWithdrawAmount(request.getMerchantNo(), request.getWithdrawAmount(), request.getMcType(), request.getWithdrawType());
			if (!vo.isSuccess()) {
				return withdrawResult(vo, request, WithdrawReqStatusEnums.FAIL.code, null);
			} else {
				frozenFlag = true;
			}
			// 查询费率
			BigDecimal withdrawRate;
			try {
				withdrawRate = withdrawRate(request.getMerchantNo(), request.getMcType(), request.getWithdrawType());
			} catch (Exception e) {
				// 查询费率异常，恢复额度，返回异常信息
				limitationService.restoreFrozenQuota(request.getMerchantNo(), request.getMcType(), request.getWithdrawAmount());
				frozenFlag = false;
				return withdrawResult(new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_MERCHANT_RATE_NOTFOUND.code,
						ReturnCodeEnums.FW_MERCHANT_RATE_NOTFOUND.msg), request, WithdrawReqStatusEnums.FAIL.code, null);
			}
			if (null == withdrawRate) {
				// 费率为空，恢复额度，返回异常信息
				limitationService.restoreFrozenQuota(request.getMerchantNo(), request.getMcType(), request.getWithdrawAmount());
				frozenFlag = false;
				return withdrawResult(new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_MERCHANT_RATE_NOTFOUND.code,
						ReturnCodeEnums.FW_MERCHANT_RATE_NOTFOUND.msg), request, WithdrawReqStatusEnums.FAIL.code, null);
			}
			reqDo = this.buildWithdrawReqDO(request);
			reqDo.setWithdrawFee(withdrawRate);
			reqDo.setWithdrawType(Integer.valueOf(WithdrawConstant.withdrawTypeRealTime));
			reqDo.setMemberId(memberId);
			// 获取服务类型 产品编码 支付编码
			Map<String, Object> promap = getProductTypeInfo(request.getWithdrawType(), request.getMcType(), request.getMerchantNo());
			reqDo.setReqType(WithdrawConstant.reqTypePOS);
			if (promap.containsKey("serverType")) reqDo.setServiceType(Integer.parseInt(promap.get("serverType").toString()));
			if (promap.containsKey("productCode")) reqDo.setProductCode(String.valueOf(promap.get("productCode")));
			if (promap.containsKey("paymentCode")) reqDo.setPaymentCode(String.valueOf(promap.get("paymentCode")));
			if (WithdrawConstant.withdrawTypeRealTime.equals(request.getWithdrawType())) {// 如果实时出款
				LoaningConfigBean loaningBean = queryLoaningConfigBean(request.getMerchantNo(), request.getMcType());
				if (loaningBean == null) { return withdrawResult(new ErrorMessageVO<Object>(false,
						ReturnCodeEnums.FW_LOANINGCONFIGBEAN_NOTFOUND.code, ReturnCodeEnums.FW_LOANINGCONFIGBEAN_NOTFOUND.msg), request,
						WithdrawReqStatusEnums.FAIL.code, null); }
				reqDo.setLoaningType(loaningBean.getLoaingType());
			}
			// 判断是否禁止出款 平台维护中
			if ((reqDo.getLoaningType() != null && LoaningTypeEnum.SHENGPAY.code == reqDo.getLoaningType() && !isInitiateWithdrawDate(WithdrawConstant.FORBID_SHENGPAY_POS_T0_INITIATE_WITHDRAW_DATE))) {
				limitationService.restoreFrozenQuota(request.getMerchantNo(), request.getMcType(), request.getWithdrawAmount());
				frozenFlag = false;
				return withdrawResult(new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_SYSTEM_PLATFORM_MAINTENANCE.code,
						ReturnCodeEnums.FW_SYSTEM_PLATFORM_MAINTENANCE.msg), request, WithdrawReqStatusEnums.FAIL.code, null);
			}

			// 落地数据
			try {
				reqDo = withdrawReqService.insertWithdrawReq(reqDo);
			} catch (DuplicateKeyException e) {
				logger.error("t0WithdrawPos insertWithdrawReq DuplicateKeyException", e);
				limitationService.restoreFrozenQuota(request.getMerchantNo(), request.getMcType(), request.getWithdrawAmount());
				frozenFlag = false;
				return dataAlreadyExists(isFirstWithdraw(paramData(request)), request);
			}
			// 如果是后付费 商户出款，落地 标示和源出款金额
			if (isDelayPayFlag) withdrawReqExtraInfoService.createPostPaidExtraInfo(reqDo.getReqId(), origWithdrawAmount);

			vo = withdrawT0ServiceService.bulidCoreData(reqDo, dto);
			if (!vo.isSuccess()) {
				limitationService.restoreFrozenQuota(reqDo.getMerchantNo(), request.getMcType(), reqDo.getWithdrawAmount());
				frozenFlag = false;
				// 更新状态
				reqDo.setStatus(WithdrawReqStatusEnums.WAITTING.code);
				reqDo.setErrorCode(ReturnCodeEnums.FW_MC_T0_ING.code);
				reqDo.setErrorMsg(ReturnCodeEnums.FW_MC_T0_ING.msg);
				withdrawReqService.updateByPrimaryKeySelective(reqDo);
				// 调用失败方法
				withdrawFailService.withdrawFailDealWith(dto, vo.getErrorCode());
				WithdrawReqDO reqdo = withdrawReqService.queryWithdrawReqByReqId(reqDo.getReqId());
				vo.setErrorCode(reqdo.getErrorCode());
				vo.setErrorMessage(reqdo.getErrorMsg());
				return withdrawResult(vo, request, WithdrawReqStatusEnums.WAITTING.code, reqDo.getReqId());
			} else {
				vo = new ErrorMessageVO<Object>(true, ReturnCodeEnums.FW_MC_T0_ING.code, ReturnCodeEnums.FW_MC_T0_ING.msg);
				// 更新数据状态为处理中
				reqDo.setStatus(WithdrawReqStatusEnums.WAITTING.code);
				withdrawReqService.updateDataMessage(reqDo, vo);
				boolean callFlag = withdrawCallQueueService.addCallWithdrawCoreServiceDate(dto);
				if (!callFlag) {
					limitationService.restoreFrozenQuota(reqDo.getMerchantNo(), request.getMcType(), reqDo.getWithdrawAmount());
					frozenFlag = false;
					withdrawFailService.withdrawFailDealWith(dto, ReturnCodeEnums.FW_CALL_CORE_WITHDRAW_EXCEPTION.code);
				}
				return withdrawResult(vo, request, WithdrawReqStatusEnums.WAITTING.code, reqDo.getReqId());

			}
		} catch (Exception e) {
			logger.error(
					"WithdrawT0Service4HessianImpl#t0WithdrawPos  is error:" + ToStringBuilder.reflectionToString(request) + "," + e.getMessage(), e);
			vo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_SYSTEM_ERROR.code, ReturnCodeEnums.FW_SYSTEM_ERROR.msg);
			if (frozenFlag) {
				limitationService.restoreFrozenQuota(request.getMerchantNo(), request.getMcType(), request.getWithdrawAmount());
			}
			if (reqDo != null && reqDo.getReqId() != null) {
				reqDo.setStatus(WithdrawReqStatusEnums.FAIL.code);
				reqDo.setErrorCode(ReturnCodeEnums.FW_SYSTEM_ERROR.code);
				reqDo.setErrorMsg(ReturnCodeEnums.FW_SYSTEM_ERROR.msg);
				withdrawReqService.updateByPrimaryKeySelective(reqDo);
				return withdrawResult(vo, request, WithdrawReqStatusEnums.FAIL.code, reqDo.getReqId());
			}
			return withdrawResult(vo, request, WithdrawReqStatusEnums.FAIL.code, null);
		}

	}

	@Override
	public WithdrawT0ServiceResponse t0WithdrawBalance(WithdrawT0ServiceRequest request) {
		logger.info("WithdrawT0Service4HessianImpl#t0WithdrawBalance  is init rquest:" + ToStringBuilder.reflectionToString(request));
		ErrorMessageVO<Object> vo = new ErrorMessageVO<Object>(true);
		WithdrawCoreServiceDTO dto = new WithdrawCoreServiceDTO();
		WithdrawReqDO reqDo = null;
		boolean frozenFlag = false;// 冻结额度标识 true 冻结状态 false 非冻结
		try {
			vo = isCanLaunch(request, WithdrawConstant.reqTypeBalance);
			if (!vo.isSuccess()) { return withdrawResult(vo, request, WithdrawReqStatusEnums.FAIL.code, null); }
			// 查询代理商信息
			ViewMerchantInfoDTO merchantInfo = queryMerchantInfo(request.getMerchantNo(), request.getMcType());

			ViewPromoterInfoDTO promoterInfo = this.queryPromoterInfo(request.getMerchantNo(), request.getMcType());
			if (promoterInfo == null) {
				vo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_PROMOTER_NOTFOUND.code, ReturnCodeEnums.FW_PROMOTER_NOTFOUND.msg);
				return withdrawResult(vo, request, WithdrawReqStatusEnums.FAIL.code, null);
			}
			String memberId = "";
			vo = queryMemberIdByMerhantNo(request.getMerchantNo());
			if (!vo.isSuccess()) {
				return withdrawResult(vo, request, WithdrawReqStatusEnums.FAIL.code, null);
			} else {
				memberId = vo.getParams().get("memberId").toString();
				// 判断额度
				BigDecimal walletBalance = queryWalletBalance(memberId);
				if (walletBalance == null || walletBalance.compareTo(request.getWithdrawAmount()) < 0) {
					vo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_MERCHANT_WALLETBALACE_ISENOUGH.code,
							ReturnCodeEnums.FW_MERCHANT_WALLETBALACE_ISENOUGH.msg);
					return withdrawResult(vo, request, WithdrawReqStatusEnums.FAIL.code, null);
				}
			}
			request.setMemberId(memberId);
			vo = checkISCanStart(request);
			if (!vo.isSuccess()) { return withdrawResult(vo, request, WithdrawReqStatusEnums.FAIL.code, null); }
			// 判断之前是否发起过
			reqDo = isFirstWithdraw(paramData(request));
			if (null != reqDo) { return dataAlreadyExists(reqDo, request); }
			if (WithdrawConstant.withdrawTypeRealTime.equals(request.getWithdrawType())) {// 如果实时出款
				// 判断最低额度
				if (!lowestAmount(request.getWithdrawAmount(), request.getMerchantNo(), request.getMcType())) {
					vo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_LOW_AMOUNT.code, ReturnCodeEnums.FW_LOW_AMOUNT.msg);
					return withdrawResult(vo, request, WithdrawReqStatusEnums.FAIL.code, null);
				}
				vo = checkWithdrawAmount(request.getMerchantNo(), request.getWithdrawAmount(), request.getMcType(), request.getWithdrawType());
			}
			if (vo != null && !vo.isSuccess()) {
				return withdrawResult(vo, request, WithdrawReqStatusEnums.FAIL.code, null);
			} else if (vo != null && vo.isSuccess()) {
				if (WithdrawConstant.withdrawTypeRealTime.equals(request.getWithdrawType())) frozenFlag = true;
			}
			BigDecimal withdrawRate;
			try {
				withdrawRate = withdrawRate(request.getMerchantNo(), request.getMcType(), request.getWithdrawType());
			} catch (Exception e) {
				if (WithdrawConstant.withdrawTypeRealTime.equals(request.getWithdrawType())) {
					limitationService.restoreFrozenQuota(request.getMerchantNo(), request.getMcType(), request.getWithdrawAmount());
					frozenFlag = false;
				}
				return withdrawResult(new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_MERCHANT_RATE_NOTFOUND.code,
						ReturnCodeEnums.FW_MERCHANT_RATE_NOTFOUND.msg), request, WithdrawReqStatusEnums.FAIL.code, null);
			}
			if (null == withdrawRate) {
				if (WithdrawConstant.withdrawTypeRealTime.equals(request.getWithdrawType())) {
					limitationService.restoreFrozenQuota(request.getMerchantNo(), request.getMcType(), request.getWithdrawAmount());
					frozenFlag = false;
				}
				return withdrawResult(new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_MERCHANT_RATE_NOTFOUND.code,
						ReturnCodeEnums.FW_MERCHANT_RATE_NOTFOUND.msg), request, WithdrawReqStatusEnums.FAIL.code, null);
			}
			// 20170627 云收银，银行卡信息从crm获取
			/*
			 * if(PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(request.
			 * getMcType())){ BankCardInfo bankCardInfo=(BankCardInfo)
			 * request.getExtention
			 * ().get(WithdrawConstant.WITHDRAW_REQUEST_EXTENTS_KEY_BANK_CARD_INFO
			 * );
			 * logger.info("easypay withdraw bankCardInfo:{}",ToStringBuilder.
			 * reflectionToString(bankCardInfo, ToStringStyle.SIMPLE_STYLE));
			 * if(bankCardInfo.getName()==null||!bankCardInfo.getName().equals(
			 * merchantInfo.getMerchantName())){
			 * limitationService.restoreFrozenQuota(request.getMerchantNo(),
			 * request.getMcType(), request.getWithdrawAmount()); frozenFlag =
			 * false; return withdrawResult(new ErrorMessageVO<Object>(false,
			 * ReturnCodeEnums.FW_BACK_CARD_INFO_NAME_NOT_COINCIDENT.code,
			 * ReturnCodeEnums.FW_BACK_CARD_INFO_NAME_NOT_COINCIDENT.msg),
			 * request, WithdrawReqStatusEnums.FAIL.code, null); }
			 * this.beanMapper.map(bankCardInfo, dto); }
			 */
			reqDo = this.buildWithdrawReqDO(request);
			reqDo.setWithdrawFee(withdrawRate);
			reqDo.setMemberId(memberId);
			reqDo.setReqType(WithdrawConstant.reqTypeBalance);
			Map<String, Object> promap = getProductTypeInfo(request.getWithdrawType(), request.getMcType(), request.getMerchantNo());
			if (promap.containsKey("serverType")) reqDo.setServiceType(Integer.parseInt(promap.get("serverType").toString()));
			if (promap.containsKey("productCode")) reqDo.setProductCode(String.valueOf(promap.get("productCode")));
			if (promap.containsKey("paymentCode")) reqDo.setPaymentCode(String.valueOf(promap.get("paymentCode")));

			// 查询提现费用
			if (WithdrawConstant.withdrawTypeRealTime.equals(request.getWithdrawType())) {// 如果实时出款
				if (PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(request.getMcType())) {
					BigDecimal withdrawCost = BigDecimal.ZERO;
					if (YesNoEnum.YES.code.equals(reqDo.getHasOaTxn())) {
						PolicyConfigInfoDO policyInfo = policyConfigInfoService.queryPolicyConfigInfo(PolicyTypeEnums.MCC.type, reqDo.getMcc());
						if(policyInfo==null||policyInfo.getOaTxnWithdrawCost()==null){//没有配置扫码提现费用，取配置提现费用
							if(policyInfo!=null&&policyInfo.getWithdrawCost()!=null){
								withdrawCost=policyInfo.getWithdrawCost();
							}else{
								withdrawCost =withdrawCostConfigService.queryMerchantCurrentWithdrawCostConfig(request.getMerchantNo(), request.getMcType(),
										promoterInfo.getPromoterMerchantNo(), promoterInfo.getPromoterType(), reqDo.getMcc());
							}
						}else{
							withdrawCost =policyInfo.getOaTxnWithdrawCost();
						}
						
					} else {
						withdrawCost = withdrawCostConfigService.queryMerchantCurrentWithdrawCostConfig(request.getMerchantNo(), request.getMcType(),
								promoterInfo.getPromoterMerchantNo(), promoterInfo.getPromoterType(), reqDo.getMcc());
					}
					reqDo.setWdCost(withdrawCost);
				} else {
					reqDo.setWdCost(BigDecimal.ZERO);
				}
				LoaningConfigBean loaningBean = queryLoaningConfigBean(request.getMerchantNo(), request.getMcType());
				if (loaningBean == null) { return withdrawResult(new ErrorMessageVO<Object>(false,
						ReturnCodeEnums.FW_LOANINGCONFIGBEAN_NOTFOUND.code, ReturnCodeEnums.FW_LOANINGCONFIGBEAN_NOTFOUND.msg), request,
						WithdrawReqStatusEnums.FAIL.code, null); }
				reqDo.setLoaningType(loaningBean.getLoaingType());
			}
			// 判断是否禁止出款 平台维护中
			if ((WithdrawServiceTypeEnums.D1.code.equals(reqDo.getServiceType()) && !isInitiateWithdrawDate(WithdrawConstant.FORBID_MPOS_D1_INITIATE_WITHDRAW_DATE))
					|| (!isInitiateWithdrawPromoterNo(reqDo.getPmtMerchantNo(),
							WithdrawConstant.NOT_FORBID_SHENGPAY_MPOS_T0_INITIATE_WITHDRAW_PROMOTERNO)
							&& reqDo.getLoaningType() != null
							&& LoaningTypeEnum.SHENGPAY.code == reqDo.getLoaningType()
							&& WithdrawServiceTypeEnums.T0.code.equals(reqDo.getServiceType()) && !isInitiateWithdrawDate(WithdrawConstant.FORBID_SHENGPAY_MPOS_T0_INITIATE_WITHDRAW_DATE))) {
				logger.info("t0WithdrawBalance,NOT_FORBID_SHENGPAY_MPOS_T0_INITIATE_WITHDRAW_PROMOTERNO:{}",
						GlobalConfig.getString(WithdrawConstant.NOT_FORBID_SHENGPAY_MPOS_T0_INITIATE_WITHDRAW_PROMOTERNO, ""));
				if (WithdrawConstant.withdrawTypeRealTime.equals(request.getWithdrawType())) {
					limitationService.restoreFrozenQuota(request.getMerchantNo(), request.getMcType(), request.getWithdrawAmount());
					frozenFlag = false;
				}
				return withdrawResult(new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_SYSTEM_PLATFORM_MAINTENANCE.code,
						ReturnCodeEnums.FW_SYSTEM_PLATFORM_MAINTENANCE.msg), request, WithdrawReqStatusEnums.FAIL.code, null);
			}
			try {
				reqDo = withdrawReqService.insertWithdrawReq(reqDo);
			} catch (DuplicateKeyException e) {
				logger.error("t0WithdrawBalance insertWithdrawReq DuplicateKeyException:{}", e.getMessage());
				limitationService.restoreFrozenQuota(request.getMerchantNo(), request.getMcType(), request.getWithdrawAmount());
				frozenFlag = false;
				return dataAlreadyExists(isFirstWithdraw(paramData(request)), request);
			}
			/*
			 * //分润信息由出款成功之后调用 if(withdrawCostConfigDO!=null){
			 * WithdrawSplittingSerivce
			 * .createInitWithdrawSplittingInfo(reqDo.getReqId
			 * (),withdrawCostConfigDO.getWdPromoterSplittingScale()); }
			 */

			vo = withdrawT0ServiceService.bulidCoreData(reqDo, dto);
			if (!vo.isSuccess()) {
				if (WithdrawConstant.withdrawTypeRealTime.equals(request.getWithdrawType())) {
					limitationService.restoreFrozenQuota(reqDo.getMerchantNo(), request.getMcType(), reqDo.getWithdrawAmount());
					frozenFlag = false;
				}
				// 更新状态
				reqDo.setStatus(WithdrawReqStatusEnums.WAITTING.code);
				reqDo.setErrorCode(ReturnCodeEnums.FW_MC_T0_ING.code);
				reqDo.setErrorMsg(ReturnCodeEnums.FW_MC_T0_ING.msg);
				withdrawReqService.updateByPrimaryKeySelective(reqDo);
				// 调用失败方法
				withdrawFailService.withdrawFailDealWith(dto, vo.getErrorCode());
				WithdrawReqDO reqdo = withdrawReqService.queryWithdrawReqByReqId(reqDo.getReqId());
				vo.setErrorCode(reqdo.getErrorCode());
				vo.setErrorMessage(reqdo.getErrorMsg());
				return withdrawResult(vo, request, WithdrawReqStatusEnums.WAITTING.code, null);
			} else {
				vo = new ErrorMessageVO<Object>(true, ReturnCodeEnums.FW_MC_T0_ING.code, ReturnCodeEnums.FW_MC_T0_ING.msg);
				// 更新数据状态为处理中
				reqDo.setStatus(WithdrawReqStatusEnums.WAITTING.code);
				withdrawReqService.updateDataMessage(reqDo, vo);
				boolean callFlag = withdrawCallQueueService.addCallWithdrawCoreServiceDate(dto);
				if (!callFlag) {
					if (WithdrawConstant.withdrawTypeRealTime.equals(request.getWithdrawType())) {
						limitationService.restoreFrozenQuota(reqDo.getMerchantNo(), request.getMcType(), reqDo.getWithdrawAmount());
						frozenFlag = false;
					}
					withdrawFailService.withdrawFailDealWith(dto, ReturnCodeEnums.FW_CALL_CORE_WITHDRAW_EXCEPTION.code);
				}
				return withdrawResult(vo, request, WithdrawReqStatusEnums.WAITTING.code, reqDo.getReqId());

			}
		} catch (Exception e) {
			if (WithdrawConstant.withdrawTypeRealTime.equals(request.getWithdrawType()) && frozenFlag) {
				limitationService.restoreFrozenQuota(request.getMerchantNo(), request.getMcType(), request.getWithdrawAmount());
			}
			logger.error(
					"WithdrawT0Service4HessianImpl#t0WithdrawBalance  is error:" + ToStringBuilder.reflectionToString(request) + "," + e.getMessage(),
					e);
			vo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_SYSTEM_ERROR.code, ReturnCodeEnums.FW_SYSTEM_ERROR.msg);
			if (reqDo != null && reqDo.getReqId() != null) {
				reqDo.setStatus(WithdrawReqStatusEnums.FAIL.code);
				reqDo.setErrorCode(ReturnCodeEnums.FW_SYSTEM_ERROR.code);
				reqDo.setErrorMsg(ReturnCodeEnums.FW_SYSTEM_ERROR.msg);
				withdrawReqService.updateByPrimaryKeySelective(reqDo);
				return withdrawResult(vo, request, WithdrawReqStatusEnums.FAIL.code, reqDo.getReqId());
			}
			return withdrawResult(vo, request, WithdrawReqStatusEnums.FAIL.code, null);
		}

	}

	@Override
	public WithdrawQueryResponse queryT0Withdraw(WithdrawQueryRequest request) {
		logger.info("queryT0Withdraw,request:{}", ToStringBuilder.reflectionToString(request, ToStringStyle.SHORT_PREFIX_STYLE));
		WithdrawQueryResponse response = new WithdrawQueryResponse();
		response.setReturnRows(0);
		response.setWithdrawT0Results(null);
		try {
			if(StringUtils.isBlank(request.getAppId())){
				logger.info("queryT0Withdraw,AppId is null");
				return response;
			}
			if(StringUtils.isBlank(request.getOrderNo())&&StringUtils.isBlank(request.getMerchantNo())){
				logger.info("queryT0Withdraw,OrderNo is null and MerchantNo is null,");
				return response;
			}
            if(request.getStartTime()==null){//时间为空，最多查询一个月
            	request.setStartTime(DateUtil.increaseDate(new Date(), -30));
            }
			List<WithdrawResult> withdrawT0Resul = new ArrayList<WithdrawResult>();
			List<ExtWithdrawReqVO> withdrawList = new ArrayList<ExtWithdrawReqVO>();
			ExtWithdrawReqDOExample example = queryParam(request);
			Integer to0PageNo = 0;
			Integer totalCount = extWithdrawReqManager.queryWithdrawReqCount(example);
			if (totalCount % request.getPageSize() == 0) {
				to0PageNo = totalCount / request.getPageSize();
			} else {
				to0PageNo = (totalCount / request.getPageSize()) + 1;
			}

			logger.info("queryT0Withdraw,is query marjor,{}", ((to0PageNo >= request.getPageNo()) ? "false" : "true"));
			if (to0PageNo >= request.getPageNo()) {
				// logger.info("WithdrawT0ServiceServiceImpl#queryT0Withdraw example"
				// + ToStringBuilder.reflectionToString(example));
				withdrawList = extWithdrawReqManager.queryWithdrawReqInfo(example);
				logger.info("WithdrawT0ServiceServiceImpl#queryT0Withdraw withdrawList" + ToStringBuilder.reflectionToString(withdrawList));
				buildListDTO(withdrawList, withdrawT0Resul);
			} else {// 专业版查询不在提供数据
				/*
				 * request.setPageNo(request.getPageNo() - to0PageNo); //
				 * 查询专业版接口 List<WithdrawQueryResult> majorList =
				 * majorWithdrawServiceImpl.query(request.getMerchantNo(),
				 * request.getStartTime(), request.getEndTime(),
				 * request.getPageNo(), request.getPageSize());
				 * buildMajorListDTO(majorList, withdrawT0Resul);
				 */
			}

			response.setReturnRows(withdrawT0Resul.size());
			response.setWithdrawT0Results(withdrawT0Resul);
			logger.info("queryT0Withdraw,response:{}", ToStringBuilder.reflectionToString(response, ToStringStyle.SHORT_PREFIX_STYLE));
			return response;
		} catch (Exception e) {
			logger.error("queryT0Withdraw error,{}", e.getMessage(), e);
			return response;
		}
	}

	private List<WithdrawResult> buildListDTO(List<ExtWithdrawReqVO> withdrawList, List<WithdrawResult> withdrawT0Resul) {
		for (ExtWithdrawReqVO extWithdrawReqVO : withdrawList) {
			WithdrawResult resultVo = beanMapper.map(extWithdrawReqVO, WithdrawResult.class);
			resultVo.setReturnCode(extWithdrawReqVO.getErrorCode());
			resultVo.setReturnMsg(extWithdrawReqVO.getErrorMsg());
			if (StringUtils.isNotBlank(resultVo.getCardNo())) {
				resultVo.setCardNo(uesRemoteServiceClient.decryptData(resultVo.getCardNo()));
				resultVo.setPrefix6(resultVo.getCardNo().substring(0, 6));
				resultVo.setSuffix4(resultVo.getCardNo().substring(resultVo.getCardNo().length() - 4));
				resultVo.setCardNo(resultVo.getPrefix6() + "******" + resultVo.getSuffix4());
			}
			withdrawT0Resul.add(resultVo);
		}
		return withdrawT0Resul;

	}

	/**
	 * 专业版数据转换
	 * 
	 * @param majorList
	 * @param withdrawT0Resul
	 * @return
	 */
	private List<WithdrawResult> buildMajorListDTO(List<WithdrawQueryResult> majorList, List<WithdrawResult> withdrawT0Resul) {
		for (WithdrawQueryResult withdrawQueryResult : majorList) {
			WithdrawResult w = new WithdrawResult();
			// 付款账号
			if (withdrawQueryResult.getAccountID() != null) w.setPayerAccountNo(withdrawQueryResult.getAccountID().getValue());
			if (withdrawQueryResult.getBankAccountNo() != null) w.setCardNo(withdrawQueryResult.getBankAccountNo().getValue());
			if (withdrawQueryResult.getBankInfo() != null && withdrawQueryResult.getBankInfo().getValue().getBankName() != null)
				w.setBankName((withdrawQueryResult.getBankInfo().getValue()).getBankName().getValue());
			if (withdrawQueryResult.getBankInfo() != null && withdrawQueryResult.getBankInfo().getValue().getBranch() != null)
				w.setBankBranch((withdrawQueryResult.getBankInfo().getValue()).getBranch().getValue());
			if (withdrawQueryResult.getBankInfo() != null && withdrawQueryResult.getBankInfo().getValue().getCity() != null)
				w.setBankCity((withdrawQueryResult.getBankInfo().getValue()).getCity().getValue());
			if (withdrawQueryResult.getBankInfo() != null && withdrawQueryResult.getBankInfo().getValue().getProvince() != null)
				w.setBankProvince((withdrawQueryResult.getBankInfo().getValue()).getProvince().getValue());
			if (withdrawQueryResult.getCreateTime().toGregorianCalendar().getTime() != null)
				w.setApplyTime(DateUtil.parseDate(withdrawQueryResult.getCreateTime().toGregorianCalendar().getTime(), "yyyy-MM-dd HH:mm:ss"));
			if (withdrawQueryResult.getFinishTime().toGregorianCalendar().getTime() != null)
				w.setSettlementTime(DateUtil.parseDate(withdrawQueryResult.getFinishTime().toGregorianCalendar().getTime(), "yyyy-MM-dd HH:mm:ss"));
			if (withdrawQueryResult.getFeeAmount() != null)
				w.setWithdrawCost(new BigDecimal(withdrawQueryResult.getFeeAmount().doubleValue()).setScale(2, BigDecimal.ROUND_HALF_UP));
			if (withdrawQueryResult.getMerchantOrderID().getValue() != null) w.setTraceNo(withdrawQueryResult.getMerchantOrderID().getValue());
			if (withdrawQueryResult.getOrderNo().getValue() != null) w.setOrderNo(withdrawQueryResult.getOrderNo().getValue());
			if (withdrawQueryResult.getPayAmount() != null)
				w.setWithdrawAmount(new BigDecimal(withdrawQueryResult.getPayAmount().doubleValue()).setScale(2, BigDecimal.ROUND_HALF_UP));
			if (withdrawQueryResult.getPayStatus().getValue() != null) w.setStatus(withdrawQueryResult.getPayStatus().getValue());
			if (withdrawQueryResult.getRemark().getValue() != null) w.setExtention(withdrawQueryResult.getRemark().getValue());
			if (withdrawQueryResult.getPrefix6().getValue() != null) w.setPrefix6(withdrawQueryResult.getPrefix6().getValue());
			if (withdrawQueryResult.getSuffix4().getValue() != null) w.setSuffix4(withdrawQueryResult.getSuffix4().getValue());
			if (withdrawQueryResult.getUserID().getValue() != null) w.setMerchantNo(withdrawQueryResult.getUserID().getValue());
			if (withdrawQueryResult.getBankInfo() != null && withdrawQueryResult.getBankInfo().getValue().getBankAccountName() != null)
				w.setName(withdrawQueryResult.getBankInfo().getValue().getBankAccountName().getValue());
			if (StringUtils.isNotBlank(w.getCardNo())) {
				w.setCardNo(w.getPrefix6() + "******" + w.getSuffix4());
			}
			if (withdrawQueryResult.getPayStatus().getValue() != null) {
				String code = parseStatusTOReturnCode(withdrawQueryResult.getPayStatus().getValue());
				w.setReturnCode(code);
				if (!code.equals("05") && !code.equals("99")) {
					w.setReturnMsg(ReturnCodeEnums.getEnumsByCode(code).msg);
				}
			}
			w.setWithdrawType(WithdrawConstant.withdrawTypeOrdinary);
			w.setTotalCost(withdrawQueryResult.getFeeAmount());
			w.setWdCost(BigDecimal.ZERO);
			withdrawT0Resul.add(w);
		}
		return withdrawT0Resul;

	}

	/**
	 * 专业版的状态转成returnCode
	 * 
	 * @param returnCode
	 * @return
	 */
	private String parseStatusTOReturnCode(String status) {
		if ("00".equals(status) || "01".equals(status) || "0".equals(status)) {
			return ReturnCodeEnums.FW_MC_T0_ING.code;
		} else if ("03".equals(status)) {
			return ReturnCodeEnums.FW_SUCCESS.code;
		} else if ("05".equals(status)) {
			return status;
		} else {
			return "99";
		}

	}

	private ExtWithdrawReqDOExample queryParam(WithdrawQueryRequest request) {
		ExtWithdrawReqDOExample example = new ExtWithdrawReqDOExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(request.getAppId())) {
			criteria.andAppIdEqualTo(request.getAppId());
			example.setAppId(request.getAppId());
		}
		if (StringUtils.isNotBlank(request.getOrderNo())) {
			criteria.andOrderNoEqualTo(request.getOrderNo());
			example.setOrderNo(request.getOrderNo());
		}
		if (StringUtils.isNotBlank(request.getTraceNo())) {
			criteria.andReqIdEqualTo(Long.valueOf(request.getTraceNo()));
			example.setReqId(Long.valueOf(request.getTraceNo()));
		}
		if (StringUtils.isNotBlank(request.getMemberId())) {
			criteria.andMemberIdEqualTo(request.getMemberId());
			example.setMemberId(request.getMemberId());
		}
		if (StringUtils.isNotBlank(request.getMerchantNo())) {
			criteria.andMerchantNoEqualTo(request.getMerchantNo());
			example.setMerchantNo(request.getMerchantNo());
		}
		if (null != request.getStartTime()) {
			criteria.andApplyTimeGreaterThanOrEqualTo(request.getStartTime());
			example.setStartApplyTime(request.getStartTime());
		}
		if (null != request.getEndTime()) {
			criteria.andApplyTimeLessThanOrEqualTo(request.getEndTime());
			example.setEndApplyTime(request.getEndTime());
		}
		if (StringUtils.isNotBlank(request.getWithdrawType())) {
			criteria.andWithdrawTypeEqualTo(Integer.valueOf(request.getWithdrawType()));
			example.setWithdrawType(Integer.valueOf(request.getWithdrawType()));
		}
		if (request.getPageSize() != null) {
			example.setPageSize(request.getPageSize());
		} else {
			example.setPageSize(10);
		}
		if (request.getPageNo() != null) {
			example.setCurrentPage(request.getPageNo());
		} else {
			example.setCurrentPage(1);
		}
		return example;
	}

	/**
	 * 是否可以发起服务(包含服务时间、数据合法性检验)
	 * 
	 * @param request
	 * @return
	 */
	private ErrorMessageVO<Object> isCanLaunch(WithdrawT0ServiceRequest request, Integer reqType) {
		ErrorMessageVO<Object> errorVo = null;
		// 检查数据
		String message = checkRequestDate(request, reqType);
		if (StringUtils.isNotBlank(message)) {
			logger.info("WithdrawT0ServiceServiceImpl#withdrawD1Available is error merchantNo:" + request.getMerchantNo() + " error:"
					+ ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.msg + ":" + message);
			errorVo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.code,
					ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.msg + ":" + message);
			return errorVo;
		}

		// 是否在服务时间范围
		if (StringUtils.isNotBlank(request.getWithdrawType()) && WithdrawConstant.withdrawTypeRealTime.equals(request.getWithdrawType())) {
			errorVo = timeFrame(new Date(), request.getMerchantNo(), request.getMcType());
			if (!errorVo.isSuccess()) { return errorVo; }
		}
		errorVo = new ErrorMessageVO<Object>(true);
		return errorVo;
	}

	/**
	 * POS检查出款请求数据
	 * 
	 * @param request
	 * @return
	 */
	private String checkRequestDate(WithdrawT0ServiceRequest request, Integer reqType) {
		String returnMsg = "";
		if (StringUtils.isBlank(request.getSignature())) return WithdrawConstant.WITHDRAW_ERROR_SIGN_NOT_NULL;
		// 验证签名
		if (!request.getSignStr(WithdrawConstant.MD5key).equals(request.getSignature())) {
			logger.error("WithdrawT0Service4HessianImpl#signature" + request.getSignStr(WithdrawConstant.MD5key) + "request.getSignature:"
					+ request.getSignature());
			return WithdrawConstant.WITHDRAW_ERROR_SIGN_NOT_PASS;
		}
		if (StringUtils.isBlank(request.getAppId())) return WithdrawConstant.WITHDRAW_ERROR_APPID_NOT_NULL;
		if (StringUtils.isBlank(request.getOrderNo())) return WithdrawConstant.WITHDRAW_ERROR_ORDERNO_NOT_NULL;
		if (request.getOrderNo().length() > 32) return WithdrawConstant.WITHDRAW_ERROR_ORDERNO_OVERLENGTH;
		if (StringUtils.isBlank(request.getMerchantNo())) return WithdrawConstant.WITHDRAW_ERROR_MERCHANTNO_NOT_NULL;
		if (StringUtils.isBlank(request.getMcType())) return WithdrawConstant.WITHDRAW_ERROR_MERCHANT_TYPE_NOT_NULL;
		if (null == request.getWithdrawAmount()) return WithdrawConstant.WITHDRAW_ERROR_AMOUNT_NOT_NULL;
		if (request.getWithdrawAmount().compareTo(new BigDecimal(0)) <= 0) return WithdrawConstant.WITHDRAW_ERROR_AMOUNT_GREATER_THAN_ZERO;
		String withdrawAmount = String.valueOf(request.getWithdrawAmount());
		if (withdrawAmount.indexOf(".") > 0) {
			int position = withdrawAmount.length() - (withdrawAmount.indexOf(".") + 1);
			if (position > 2) return WithdrawConstant.WITHDRAW_ERROR_AMOUNT_FORMAT_NOTPASS;
		}
		if (reqType == WithdrawConstant.reqTypePOS) {
			if (!isPromoterOpenFastSettle(request.getMerchantNo(), request.getMcType())) { return WithdrawConstant.WITHDRAW_ERROR_PROMOTER_NOTOPEN_FASTSETTLE; }
			if (!isOpenFastSettle(request.getMerchantNo(), request.getMcType())) { return WithdrawConstant.WITHDRAW_ERROR_MERCHANT_NOTOPEN_FASTSETTLE; }
			// pos 出款
			if (!request.getMcType().equals(PosMerchantTypeEnums.POS_MERCHANT.code)) { return WithdrawConstant.WITHDRAW_ERROR_MCTYPE_NOT_PASS; }
			if (null == request.getOriginalAmount()) return WithdrawConstant.WITHDRAW_ERROR_OAMOUNT_NOT_NULL;
			if (request.getOriginalAmount().compareTo(new BigDecimal(0)) <= 0) return WithdrawConstant.WITHDRAW_ERROR_OAMOUNT_GREATER_THAN_ZERO;
			String originalAmount = String.valueOf(request.getOriginalAmount());
			if (originalAmount.indexOf(".") > 0) {
				int oPosition = originalAmount.length() - (originalAmount.indexOf(".") + 1);
				if (oPosition > 2) return WithdrawConstant.WITHDRAW_ERROR_OAMOUNT_FORMAT_NOTPASS;
				;
			}
			if (request.getOriginalAmount().compareTo(request.getWithdrawAmount()) < 0)
				return WithdrawConstant.WITHDRAW_ERROR_OAMOUNT_LESS_THAN_AMOUNT;
			// withdrawType null 1
			if (StringUtils.isNotBlank(request.getWithdrawType()) && !WithdrawConstant.withdrawTypeRealTime.equals(request.getWithdrawType())) { return WithdrawConstant.WITHDRAW_ERROR_TYPE_REAL_WITHDRAW; }

		} else if (reqType == WithdrawConstant.reqTypeBalance) {
			if (WithdrawConstant.withdrawTypeRealTime.equals(request.getWithdrawType())) {
				if (!isPromoterOpenFastSettle(request.getMerchantNo(), request.getMcType())) { return WithdrawConstant.WITHDRAW_ERROR_PROMOTER_NOTOPEN_FASTSETTLE; }
				if (!isOpenFastSettle(request.getMerchantNo(), request.getMcType())) { return WithdrawConstant.WITHDRAW_ERROR_MERCHANT_NOTOPEN_FASTSETTLE; }
			}
			// 余额出款
			if (!(PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(request.getMcType()) || PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(request
					.getMcType()))) { return WithdrawConstant.WITHDRAW_ERROR_MCTYPE_ISMPOS; }
			// withdrawType 1 2
			if (StringUtils.isBlank(request.getWithdrawType())) return WithdrawConstant.WITHDRAW_ERROR_WITHDARWTYPE_NOT_NULL;
			if (!WithdrawConstant.withdrawTypeRealTime.equals(request.getWithdrawType())
					&& !WithdrawConstant.withdrawTypeOrdinary.equals(request.getWithdrawType())) { return WithdrawConstant.WITHDRAW_ERROR_MPOS_WITHDARWTYPE; }
			// 20170627 以后云收银出款银行卡，查询crm
			/*
			 * if(PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(request.
			 * getMcType())&& (request.getExtention()==null
			 * ||request.getExtention
			 * ().get(WithdrawConstant.WITHDRAW_REQUEST_EXTENTS_KEY_BANK_CARD_INFO
			 * )==null)){ return
			 * WithdrawConstant.WITHDRAW_ERROR_EASYPAY_BANK_CART_INFO_IS_NULL; }
			 */}

		return returnMsg;
	}

	/**
	 * 仅限POS
	 */
	@Override
	public WithdrawCheckResponse checkWithdraw(WithdrawCheckRequest request) {
		logger.info("WithdrawT0Service4HessianImpl#checkWithdraw  is init rquest:" + ToStringBuilder.reflectionToString(request));
		ErrorMessageVO<Object> vo = null;
		try {
			if (StringUtils.isBlank(request.getMerchantNo())) { return checkResponse(new ErrorMessageVO<Object>(false,
					ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.code, ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.msg + ":商户号不能为空")); }

			if (StringUtils.isBlank(request.getMcType())) { return checkResponse(new ErrorMessageVO<Object>(false,
					ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.code, ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.msg + ":商户类型不能为空"));

			}
			if (!request.getMcType().equals(PosMerchantTypeEnums.POS_MERCHANT.code)) { return checkResponse(new ErrorMessageVO<Object>(false,
					ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.code, ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.msg
							+ ":商户类型不匹配,此接口只支持POS商户")); }

			if (null == request.getOriginalAmount()) {
				logger.error("WithdrawT0Service4HessianImpl#checkWithdraw rquest is not pass:" + ToStringBuilder.reflectionToString(request));
				return checkResponse(new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.code,
						ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.msg + ":原始收单金额不能为空"));
			}
			if (!isPromoterOpenFastSettle(request.getMerchantNo(), request.getMcType())) { return checkResponse(new ErrorMessageVO<Object>(false,
					ReturnCodeEnums.FW_PROMOTER_FASTSFLAG_ISFALSE.code, ReturnCodeEnums.FW_PROMOTER_FASTSFLAG_ISFALSE.msg)); }
			if (!isOpenFastSettle(request.getMerchantNo(), request.getMcType())) { return checkResponse(new ErrorMessageVO<Object>(false,
					ReturnCodeEnums.FW_MERCHANT_FASTSFLAG_ISFALSE.code, ReturnCodeEnums.FW_MERCHANT_FASTSFLAG_ISFALSE.msg)); }
			vo = timeFrame(new Date(), request.getMerchantNo(), request.getMcType());
			ViewMerchantInfoDTO proEO = merchantInfoService.queryMerchantInfoByMerchantNo(request.getMerchantNo(), request.getMcType());
			// //判断是否禁止出款 平台维护中
			if ((proEO.getLoaningType() != null && LoaningTypeEnum.SHENGPAY.code == proEO.getLoaningType() && !isInitiateWithdrawDate(WithdrawConstant.FORBID_SHENGPAY_POS_T0_INITIATE_WITHDRAW_DATE))) {

			return checkResponse(new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_SYSTEM_PLATFORM_MAINTENANCE.code,
					ReturnCodeEnums.FW_SYSTEM_PLATFORM_MAINTENANCE.msg)); }
			// 检查数据
			if (!vo.isSuccess()) {
				logger.error("WithdrawT0Service4HessianImpl#checkWithdraw  timeFrame is false  merchantNo:" + request.getMerchantNo() + "vo"
						+ ToStringBuilder.reflectionToString(vo));
				return checkResponse(vo);
			}
			// 判断最低额度
			if (!lowestAmount(request.getOriginalAmount(), request.getMerchantNo(), request.getMcType())) {
				vo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_LOW_AMOUNT.code, ReturnCodeEnums.FW_LOW_AMOUNT.msg);
				return checkResponse(vo);
			}
			vo = withdrawAmountIsEnough(request.getMerchantNo(), request.getOriginalAmount(), request.getMcType());
			if (!vo.isSuccess()) {
				logger.error("WithdrawT0Service4HessianImpl#checkWithdraw  withdrawAmountIsEnough is false  merchantNo:" + request.getMerchantNo()
						+ ",vo:" + ToStringBuilder.reflectionToString(vo));
				return checkResponse(vo);
			}

			// 验证费率
			WithdrawRatioResult result = getMerchantWithdrawRatio(request.getMerchantNo(), request.getMcType(),
					WithdrawRatioTypeEnums.POS_T0_SETTLE_RATIO.code);
			if (null == result) {
				logger.error("WithdrawT0Service4HessianImpl#checkWithdraw result is false case by  withdrawRate is null");
				return checkResponse(new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_MERCHANT_RATE_NOTFOUND.code,
						ReturnCodeEnums.FW_MERCHANT_RATE_NOTFOUND.msg));
			}

			String memberID = "";
			vo = queryMemberIdByMerhantNo(request.getMerchantNo());
			if (!vo.isSuccess()) {
				logger.error("WithdrawT0Service4HessianImpl#checkWithdraw  is false  merchantNo:" + request.getMerchantNo() + "vo"
						+ ToStringBuilder.reflectionToString(vo));
				return checkResponse(vo);
			} else {
				memberID = vo.getParams().get("memberId").toString();
			}
			vo = queryAccount(memberID, null);
			if (!vo.isSuccess()) {
				logger.error("WithdrawT0Service4HessianImpl#checkWithdraw  is false  merchantNo:" + request.getMerchantNo() + "vo"
						+ ToStringBuilder.reflectionToString(vo));
				return checkResponse(vo);
			}
			vo = queryCRMbankInfo(request.getMerchantNo());
			if (!vo.isSuccess()) {
				logger.error("WithdrawT0Service4HessianImpl#checkWithdraw  is false  merchantNo:" + request.getMerchantNo() + "vo"
						+ ToStringBuilder.reflectionToString(vo));
				if (vo.getErrorCode().equals(ReturnCodeEnums.FW_CRM_INTERFACE_EXCEPTION.code)) {
					// 如果CRM异常，预缴验放过此异常
					vo = new ErrorMessageVO<Object>(true);
					return checkResponse(vo);
				} else {
					return checkResponse(vo);
				}

			} else {
				DelegationPay2CardInfo cardInfo = (DelegationPay2CardInfo) vo.getParams().get("delegationPay2CardInfo");
				if (!this.validateFastFundOutBank(cardInfo.getBankcode())) { return checkResponse(new ErrorMessageVO<Object>(false,
						ReturnCodeEnums.FW_CARD_NOTIN_DESIGNATED.code, ReturnCodeEnums.FW_CARD_NOTIN_DESIGNATED.msg)); }
			}
			return checkResponse(vo);

		} catch (Exception e) {
			logger.error(
					"WithdrawT0Service4HessianImpl#checkWithdraw  is error:" + ToStringBuilder.reflectionToString(request) + "," + e.getMessage(), e);
			return checkResponse(new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_SYSTEM_ERROR.code, ReturnCodeEnums.FW_SYSTEM_ERROR.msg));
		}

	}

	/**
	 * 检查是否可以发起提现验证
	 * 
	 * @param vo
	 * @return
	 */
	private WithdrawCheckResponse checkResponse(ErrorMessageVO<Object> vo) {
		WithdrawCheckResponse response = new WithdrawCheckResponse();
		response.setIspass(vo.isSuccess());
		response.setErrorCode(vo.getErrorCode());
		response.setErrorMsg(vo.getErrorMessage());
		logger.error("WithdrawT0Service4HessianImpl#WithdrawCheckResponse WithdrawCheckResponse:" + ToStringBuilder.reflectionToString(response));
		return response;
	}

	/**
	 * POS MPOS都可以用
	 */
	@SuppressWarnings("rawtypes")
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sdp.withdraw.api.WithdrawT0ServiceAPI#withdrawProduct(com.sdp.withdraw
	 * .vo.WithdrawProductRequest)
	 */
	@Override
	public WithdrawProductResponse withdrawProduct(WithdrawProductRequest request) {
		WithdrawProductResponse response = null;
		ErrorMessageVO vo = null;
		List<WithdrawProductResult> withdrawProductList = new ArrayList<WithdrawProductResult>();
		try {
			if (StringUtils.isBlank(request.getMerchantNo()))
				return new WithdrawProductResponse(ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.code,
						ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.msg + ":商户号不能为空");

			if (StringUtils.isBlank(request.getMcType()))
				return new WithdrawProductResponse(ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.code,
						ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.msg + ":商户类型不能为空");

			// 根据商户号查询签约的产品类型
			PosMerchantInfoDO PosMerchantInfoDO = queyrMerchantInfo(request.getMerchantNo(), request.getMcType());
			// 查询代理商信息
			ViewPromoterInfoDTO promoterInfo = this.queryPromoterInfo(request.getMerchantNo(), request.getMcType());
			if (PosMerchantInfoDO == null)
				return new WithdrawProductResponse(ReturnCodeEnums.FW_MERCHANT_NOTFOUND.code, ReturnCodeEnums.FW_MERCHANT_NOTFOUND.msg);
			if (promoterInfo == null)
				return new WithdrawProductResponse(ReturnCodeEnums.FW_PROMOTER_NOTFOUND.code, ReturnCodeEnums.FW_PROMOTER_NOTFOUND.msg);
			// 查询提现费用
			BigDecimal withdrawCost = withdrawCostConfigService.queryMerchantCurrentWithdrawCostConfig(request.getMerchantNo(), request.getMcType(),
					promoterInfo.getPromoterMerchantNo(), promoterInfo.getPromoterType(), PosMerchantInfoDO.getMcc());
			// 获取该商户对应的费率类型列表
			List<WithdrawRatioInfoDO> ratioTypeList = queryRatioTypeInfo(PosMerchantInfoDO.getId());
			if (ratioTypeList == null || ratioTypeList.isEmpty())
				return new WithdrawProductResponse(ReturnCodeEnums.FW_MERCHANT_RATE_NOTFOUND.code, ReturnCodeEnums.FW_MERCHANT_RATE_NOTFOUND.msg);
			// 判断是否是节假日 true节假日 fasle 工作日
			boolean isHoliDay = workCalendarService.isHolidayTime(DateUtil.increaseDate(new Date(), 1));
			// 设置费率
			for (WithdrawRatioInfoDO withdrawRatioInfoDO : ratioTypeList) {
				WithdrawProductResult resultVO = null;
				WithdrawRatioResult result = getMerchantWithdrawRatio(request.getMerchantNo(), request.getMcType(),
						withdrawRatioInfoDO.getRatioType());
				if (result == null) continue;
				if (PosMerchantTypeEnums.POS_MERCHANT.code.equals(request.getMcType())
						|| PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(request.getMcType())) {
					// pos目前只有T0出款
					if (WithdrawRatioTypeEnums.POS_T0_SETTLE_RATIO.code == withdrawRatioInfoDO.getRatioType()
							|| WithdrawRatioTypeEnums.EASYPAY_T0_SETTLE_RATIO.code == withdrawRatioInfoDO.getRatioType()) {
						vo = bulidT0ProductVo(isHoliDay, request, result, null);
						if (vo.isSuccess() && vo.getParams().containsKey("resultVO"))
							resultVO = (WithdrawProductResult) vo.getParams().get("resultVO");
					} else {
						continue;
					}
				} else if (request.getMcType().equals(PosMerchantTypeEnums.MPOS_MERCHANT.code)) {
					// isHoliDay =
					// workCalendarService.isHolidayTime(DateUtil.increaseDate(new
					// Date(), 1));
					// 是节假日，不返回T1的出款方式
					if (isHoliDay) {
						if (WithdrawRatioTypeEnums.MPOS_T1_SETTLE_RATIO.code == withdrawRatioInfoDO.getRatioType()) {
							continue;
						}
					} else {
						// 非节假日 不返回D1出款方式
						if (WithdrawRatioTypeEnums.MPOS_D1_SETTLE_RATIO.code == withdrawRatioInfoDO.getRatioType()) {
							continue;
						}
					}
					// MPOS 只有T0 T1 D1
					if (WithdrawRatioTypeEnums.MPOS_T0_SETTLE_RATIO.code == withdrawRatioInfoDO.getRatioType()) {
						vo = bulidT0ProductVo(isHoliDay, request, result, withdrawCost);
						if (vo.isSuccess() && vo.getParams().containsKey("resultVO"))
							resultVO = (WithdrawProductResult) vo.getParams().get("resultVO");
					} else if (WithdrawRatioTypeEnums.MPOS_T1_SETTLE_RATIO.code == withdrawRatioInfoDO.getRatioType()) {
						resultVO = new WithdrawProductResult();
						resultVO.setWithdrawFee(isHoliDay ? result.getHolidayWithDrawRatio() : result.getWorkDayWithDrawRatio());
						vo = bulidProductVo(resultVO, WithdrawPromptEnums.T1_MPOS_PROMPT, WithdrawConstant.withdrawTypeOrdinary, "(免费)");
					} else if (WithdrawRatioTypeEnums.MPOS_D1_SETTLE_RATIO.code == withdrawRatioInfoDO.getRatioType()) {
						resultVO = new WithdrawProductResult();
						BigDecimal withdrawFee = isHoliDay ? result.getHolidayWithDrawRatio() : result.getWorkDayWithDrawRatio();
						resultVO.setWithdrawFee(withdrawFee);
						String withdrawCostInfo = "(手续费:"
								+ withdrawFee.multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "%)";
						vo = bulidProductVo(resultVO, WithdrawPromptEnums.D1_MPOS_PROMPT, WithdrawConstant.withdrawTypeOrdinary, withdrawCostInfo);
					} else {
						// 无法识别
						continue;
					}
				} else {
					// 无法识别
					continue;
				}

				if (vo.isSuccess() && resultVO != null) {
					withdrawProductList.add(resultVO);
				} else {
					logger.info("#withdrawProduct query is error:" + ToStringBuilder.reflectionToString(vo) + ",withdrawRatioInfoDO:"
							+ ToStringBuilder.reflectionToString(withdrawRatioInfoDO));
					continue;
				}
			}
			if (withdrawProductList != null && !withdrawProductList.isEmpty()) {
				response = new WithdrawProductResponse("", "", withdrawProductList);
			}

			if (response == null) {
				// 没有符合条件的产品信息
				response = new WithdrawProductResponse("", "", withdrawProductList);
			}
		} catch (Exception e) {
			logger.error("WithdrawT0Service4HessianImpl#withdrawProduct  is error merchantNo:" + request.getMerchantNo() + e.getMessage(), e);
			response = new WithdrawProductResponse(ReturnCodeEnums.FW_SYSTEM_ERROR.code, ReturnCodeEnums.FW_SYSTEM_ERROR.msg);
		}
		return response;
	}

	// 是否发起代理商商户号 true 可以发起, false 禁止发起
	private boolean isInitiateWithdrawPromoterNo(String promoterNo, String code) {
		String promoterNosConfig = GlobalConfig.getString(code, "");
		logger.info("isInitiateWithdrawPromoterNo init promoterNo:{}，code:{},promoterNoConfigs:{}", new Object[] { promoterNo, code,
				promoterNosConfig });
		if (StringUtil.isNotBlank(promoterNosConfig)) {
			String[] promoterNosArr = promoterNosConfig.replaceAll("，", ",").split(",");
			for (String promoterNoConfig : promoterNosArr) {
				if (StringUtils.isNotBlank(promoterNo) && promoterNo.equalsIgnoreCase(promoterNoConfig)) { return true; }
			}
		}
		return false;
	}

	private boolean isInitiateWithdrawDate(String code) {
		String forbidD1InitiateWithdrawDates = GlobalConfig.getString(code, "");
		logger.info("isInitiateD1Time init forbidD1InitiateWithdrawDates:{}，code:{}", new Object[] { forbidD1InitiateWithdrawDates, code });
		if (StringUtil.isNotBlank(forbidD1InitiateWithdrawDates)) {
			String[] forbidD1InitiateWithdrawDateArr = forbidD1InitiateWithdrawDates.replaceAll("，", ",").split(",");
			for (String forbidD1InitiateWithdrawDateStr : forbidD1InitiateWithdrawDateArr) {
				if (StringUtils.isNotBlank(forbidD1InitiateWithdrawDateStr)) {
					Date forbidD1InitiateWithdrawDate = DateUtil.parse2Date(forbidD1InitiateWithdrawDateStr);
					if (forbidD1InitiateWithdrawDate != null && DateUtil.daysBetween(forbidD1InitiateWithdrawDate) == 0) {
						logger.info("isInitiateD1Time forbidD1InitiateWithdrawDate is forbid. forbidD1InitiateWithdrawDates:{}",
								forbidD1InitiateWithdrawDates);
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * 拼装T0产品对象 首先要开通快速结算
	 * 
	 * @param isHoliDay
	 * @param request
	 * @param result
	 * @param resultVO
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private ErrorMessageVO<Object> bulidT0ProductVo(boolean isHoliDay, WithdrawProductRequest request, WithdrawRatioResult result,
			BigDecimal withdrawCostInfo) {
		LoaningConfigBean loaningConfgiBean = queryLoaningConfigBean(request.getMerchantNo(), request.getMcType());
		if (loaningConfgiBean == null) {
			logger.error("WithDrawBaseService #bulidT0ProductVo  loaningConfgiBean is null.");
			return new ErrorMessageVO(false, ReturnCodeEnums.FW_LOANINGCONFIGBEAN_NOTFOUND.code, ReturnCodeEnums.FW_LOANINGCONFIGBEAN_NOTFOUND.msg);
		}
		//时间暂时不校验
		/*if(!timeFrame(new Date(),loaningConfgiBean).isSuccess()){
			logger.error("WithDrawBaseService #bulidT0ProductVo  timeFrame NOT_RANGE.");
			return new ErrorMessageVO(false,  ReturnCodeEnums.FW_SERVER_NOT_RANGE.code, ReturnCodeEnums.FW_SERVER_NOT_RANGE.msg);
		}*/
		if (!isPromoterOpenFastSettle(request.getMerchantNo(), request.getMcType())) { return new ErrorMessageVO(false,
				ReturnCodeEnums.FW_PROMOTER_FASTSFLAG_ISFALSE.code, ReturnCodeEnums.FW_PROMOTER_FASTSFLAG_ISFALSE.msg); }
		if (!isOpenFastSettle(request.getMerchantNo(), request.getMcType())) { return new ErrorMessageVO(false,
				ReturnCodeEnums.FW_MERCHANT_FASTSFLAG_ISFALSE.code, ReturnCodeEnums.FW_MERCHANT_FASTSFLAG_ISFALSE.msg); }
		
		WithdrawProductResult resultVO = new WithdrawProductResult();
		;
		// 设置费率
		BigDecimal withdrawFee = isHoliDay ? result.getHolidayWithDrawRatio() : result.getWorkDayWithDrawRatio();
		resultVO.setWithdrawFee(withdrawFee);
		// 获取商户额度
		BigDecimal merchantAmount = merchantAmount(request.getMerchantNo(), request.getMcType()) == null ? new BigDecimal(0) : merchantAmount(
				request.getMerchantNo(), request.getMcType());
		// 获取代理商额度
		BigDecimal promoterAmount = promoterAmount(request.getMerchantNo(), request.getMcType()) == null ? new BigDecimal(0) : promoterAmount(
				request.getMerchantNo(), request.getMcType());

		if (LoaningTypeEnum.SHENGPAY.code == loaningConfgiBean.getLoaingType()) {
			// 如果是盛付通垫资，需要在盛付通电子总额度，商户额度，代理商额度 中取最小值
			BigDecimal totalAmount = settlementAmount(request.getMerchantNo(), request.getMcType()) == null ? new BigDecimal(0) : settlementAmount(
					request.getMerchantNo(), request.getMcType());
			BigDecimal[] amounts = { totalAmount, merchantAmount, promoterAmount };
			resultVO.setAmount(sortAmount(amounts, amounts.length - 1));
		} else {
			// 如果是代理商垫资，需要在商户额度，代理商额度 中取最小值
			BigDecimal[] amounts = { merchantAmount, promoterAmount };
			resultVO.setAmount(sortAmount(amounts, amounts.length - 1));
		}
		// 设置最小额度
		BigDecimal floorAmount = loaningConfgiBean.getFloorAmt();
		resultVO.setFloorAmount(floorAmount);
		// 商户当日总额度
		resultVO.setMerchantDayAmount(findTotalAmount(request.getMerchantNo(), request.getMcType()));
		// 设置出款方式
		resultVO.setAmount(resultVO.getAmount() == null ? null : resultVO.getAmount());
		resultVO.setFloorAmount(resultVO.getFloorAmount() == null ? null : resultVO.getFloorAmount());
		resultVO.setWithdrawType(WithdrawConstant.withdrawTypeRealTime);
		WithdrawPromptEnums enums = WithdrawPromptEnums.T0_MPOS_PROMPT;
		if (request.getMcType().equals(PosMerchantTypeEnums.POS_MERCHANT.code)) {
			enums = WithdrawPromptEnums.T0_PROMPT;
		}
		// 费率+提现费用（0.11%+2）
		String extMsg = "(手续费:" + withdrawFee.multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%)";
		if (request.getMcType().equals(PosMerchantTypeEnums.MPOS_MERCHANT.code)) {
			if (t0CostIsState()) {
				if (withdrawCostInfo != null) {
					if (withdrawCostInfo.compareTo(BigDecimal.ZERO) > 0) {
						extMsg = "(手续费:" + withdrawFee.multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP) + "%+" + withdrawCostInfo
								+ "元)";
					}
				}
			}
			// 设置提示信息
			resultVO.setPromptMsg(enums.msg + extMsg);
			// resultVO.setWithdrawCostInfo(extMsg);
		} else {
			resultVO.setPromptMsg(enums.msg);
		}

		resultVO.setProductType(enums.code);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("resultVO", resultVO);
		return new ErrorMessageVO(true, "", "", params);
	}

	/**
	 * 拼装T1 D1参数
	 * 
	 * @param resultVO
	 * @param enums
	 * @param withdrawType
	 */
	@SuppressWarnings("rawtypes")
	private ErrorMessageVO bulidProductVo(WithdrawProductResult resultVO, WithdrawPromptEnums enums, String withdrawType, String withdrawCostInfo) {
		resultVO.setAmount(resultVO.getAmount() == null ? null : resultVO.getAmount());
		resultVO.setFloorAmount(resultVO.getFloorAmount() == null ? null : resultVO.getFloorAmount());
		resultVO.setWithdrawType(withdrawType);
		// 设置提示信息
		resultVO.setPromptMsg(enums.msg + withdrawCostInfo);
		resultVO.setProductType(enums.code);

		return new ErrorMessageVO(true);
	}

	/**
	 * 查询商户信息
	 * 
	 * @param merchantNo
	 * @param merchantType
	 * @return
	 * @throws Exception
	 */
	private PosMerchantInfoDO queyrMerchantInfo(String merchantNo, String merchantType) throws Exception {

		if (StringUtils.isBlank(merchantNo) || StringUtils.isBlank(merchantType)) { return null; }
		// 查询PosMerchant 信息
		PosMerchantInfoDOExample example = new PosMerchantInfoDOExample();
		PosMerchantInfoDOExample.Criteria criteriaPosMerchantInfo = example.createCriteria();
		criteriaPosMerchantInfo.andMerchantNoEqualTo(merchantNo);
		if (StringUtils.isNotBlank(merchantType)) criteriaPosMerchantInfo.andMerchantTypeEqualTo(merchantType);
		List<PosMerchantInfoDO> posMerchantInfoDOs = posMerchantInfoManager.selectByExample(example);
		if (posMerchantInfoDOs == null || posMerchantInfoDOs.isEmpty()) {
			logger.error("WithdrawT0Service4HessianImpl#queyrMerchantInfo merchant is not exsist,merchantNo:" + merchantNo);
			return null;
		}
		// 不唯一返回异常
		if (posMerchantInfoDOs.size() > 1) {
			logger.error("WithdrawRatioService4HessianImpl#queyrMerchantInfo merchant is not:");
			return null;
		}
		PosMerchantInfoDO posMerchantInfoDO = posMerchantInfoDOs.get(0);
		return posMerchantInfoDO;
	}

	/**
	 * 查询费率类型
	 * 
	 * @param paramBizId
	 * @return
	 */
	private List<WithdrawRatioInfoDO> queryRatioTypeInfo(Long paramBizId) {
		List<WithdrawRatioInfoDO> withdrawRatioInfoDOs = extWithdrawRatioInfoManager.selectRatioTypeInfo(paramBizId);
		return withdrawRatioInfoDOs;
	}

	/**
	 * 根据商户号查询[商户/代理商]可用额度(T0)
	 * 
	 * @param merchantNo
	 *            商户/代理商
	 * @param mcType
	 *            商户/代理商 类型
	 * @return
	 */
	@Override
	public BigDecimal findCanUseQuota(String merchantNo, String mcType) {
		logger.info("#findCanUseQuota merchantNo:" + merchantNo + ",mcType:" + mcType);
		return limitationService.findMerchantFastCanUseQuota(merchantNo, mcType);
	}

	/**
	 * 根据商户号查询[商户/代理商]出款总额度(T0) 根据类型查询商户 或者代理商的总额度 POS商户额度节假日乘以50%（配置）
	 * 
	 * @param merchantNo
	 *            商户/代理商
	 * @param mcType
	 *            商户/代理商 类型
	 * @return
	 */
	@Override
	public BigDecimal findTotalAmount(String merchantNo, String mcType) {
		logger.info("#findTotalAmount merchantNo:" + merchantNo + ",mcType:" + mcType);
		return limitationBaseService.findMerchantFastAmount(merchantNo, mcType);
	}

	@Override
	public BigDecimal findTotalAmount(String merchantNo, String mcType, boolean isHoliday) {
		boolean isUseTemporaryLimit = false;
		return limitationBaseService.findMerchantFastAmount(merchantNo, mcType, isHoliday, isUseTemporaryLimit);
	}
}
