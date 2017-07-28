package com.sdp.mc.service.fastsettle.margin.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.mc.service.api.enums.WhiteTypeEnums;
import com.sdp.mc.common.bean.newt0.LoaningConfigBean;
import com.sdp.mc.common.constant.MerchantContractCst;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.AccountStatus;
import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.enums.AlertMessageSendTypeEnum;
import com.sdp.mc.common.enums.LoaningTypeEnum;
import com.sdp.mc.common.enums.MarginBalanceType;
import com.sdp.mc.common.enums.MarginOpAddEnums;
import com.sdp.mc.common.enums.MarginOpRedeemEnums;
import com.sdp.mc.common.enums.MessageTemplateCodeEnum;
import com.sdp.mc.common.enums.OpObjTypeEnums;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.config.dao.ConfigOptionDO;
import com.sdp.mc.config.dao.ConfigOptionDOExample;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.facade.msp.MspFacade;
import com.sdp.mc.integration.fos.dto.request.RemitTransferRequestDTO;
import com.sdp.mc.integration.fos.enums.FOSPaymentCodeEnum;
import com.sdp.mc.integration.ma.dto.MerchantBalanceDTO;
import com.sdp.mc.integration.ma.dto.MerchantBaseBalanceDTO;
import com.sdp.mc.integration.msp.PromoterInfoDTO;
import com.sdp.mc.integration.msp.request.MspModifyRequest;
import com.sdp.mc.ma.wrapper.AccountQueryFacadeWrapper;
import com.sdp.mc.margin.dao.MarginOpReqDO;
import com.sdp.mc.margin.dao.MarginOpReqDOExample;
import com.sdp.mc.margin.manager.MarginOpReqManager;
import com.sdp.mc.newt0.dao.WhiteListInfoDO;
import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDO;
import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDOExample;
import com.sdp.mc.promoter.manager.PromoterFastSettleSwitchManager;
import com.sdp.mc.service.AuditInfoService;
import com.sdp.mc.service.fastsettle.margin.MarginOpService;
import com.sdp.mc.service.mcwithfunding.WithCapital4PromoterService;
import com.sdp.mc.service.newt0.Newt0PromoterService;
import com.sdp.mc.service.newt0.loaning.config.LoaningCongfigService;
import com.sdp.mc.service.op.OpService;
import com.sdp.mc.service.op.state.OpContext;
import com.sdp.mc.service.op.state.OpStateResponse;
import com.sdp.mc.view.dao.ViewPromoterInfoDTO;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.shengpay.commom.config.GlobalConfig;
import com.shengpay.service.BaseCommonService;
import com.shengpay.service.alert.factory.AlertMessageSenderFactory;
import com.shengpay.service.mail.AlertMessageSender;
import com.shengpay.service.message.MessageService;
import com.shengpay.service.view.MerchantInfoService;
import com.shengpay.service.view.PromoterInfoService;
import com.shengpay.service.whitelist.WhiteListInfoService;
import com.shengpay.service.withdraw.T0WithdrawService;

@Service("MarginOpService")
public class MarginOpServiceImpl extends BaseCommonService implements MarginOpService {
	private static final Logger logger = LoggerFactory.getLogger(MarginOpServiceImpl.class);
	@Autowired
	private PromoterInfoService promoterInfoService;
	@Autowired
	private MarginOpReqManager marginOpReqManager;
	@Autowired
	private MspFacade mspFacade;
	@Autowired
	private OpService opService;
	@Autowired
	private PromoterFastSettleSwitchManager promoterFastSettleSwitchManager;
	@Autowired
	private ConfigOptionManager configOptionManager;
	@Autowired
	private AccountQueryFacadeWrapper accountQueryFacadeWrapper;
	@Autowired
	private LoaningCongfigService loaningCongfigService;
	@Autowired
	private Newt0PromoterService newt0PromoterService;
	@Autowired
	private AuditInfoService auditInfoService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private WithCapital4PromoterService withCapital4PromoterService;
	@Autowired
	private T0WithdrawService t0WithdrawService;
	// 向BD、清算及业务负责人发邮件
	private static ExecutorService executorService = Executors.newFixedThreadPool(5);
	@Autowired
	private AlertMessageSenderFactory alertMessageSenderFactory;
	@Autowired
	private MerchantInfoService merchantInfoService;
	@Autowired
	private WhiteListInfoService whiteListInfoService;

	public List<MarginOpReqDO> pageQueryMarginTrans(MarginOpReqDOExample query) {
		return this.marginOpReqManager.selectByQuery(query);
	}

	/**
	 * 当日是否有取回保证金记录
	 */
	public boolean todayRedeemMargin(Long promoterId) {
		Date now = new Date();
		MarginOpReqDOExample example = new MarginOpReqDOExample();
		example.createCriteria().andPromoterIdEqualTo(promoterId).andOpTypeEqualTo(OpTypeEnums.REDEEMED.code)
				.andStatusNotEqualTo(MarginOpRedeemEnums.TRANSFER_SUCCESS.code)
				.andCreateTimeGreaterThanOrEqualTo(DateUtil.generateDawnTimeStamp(now))
				.andCreateTimeLessThanOrEqualTo(DateUtil.generateMidnightTimeStamp(now));
		List<MarginOpReqDO> marginOpReqDOs = marginOpReqManager.selectByExample(example);
		if (marginOpReqDOs == null || marginOpReqDOs.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 查询 代理商 当前回退金额
	 *
	 * @param promoterId
	 * @return
	 */
	public String queryCurrentRedeemMargin(Long promoterId) {
		MarginOpReqDOExample example = new MarginOpReqDOExample();
		example.createCriteria().andPromoterIdEqualTo(promoterId).andOpTypeEqualTo(OpTypeEnums.REDEEMED.code)
				.andStatusNotEqualTo(MarginOpRedeemEnums.TRANSFER_SUCCESS.code);
		example.setOrderByClause(" CREATE_TIME DESC ");
		List<MarginOpReqDO> marginOpReqDOs = marginOpReqManager.selectByExample(example);
		if (marginOpReqDOs == null || marginOpReqDOs.isEmpty()) return "0";
		BigDecimal result = new BigDecimal(0);
		for (MarginOpReqDO marginOpReqDO : marginOpReqDOs) {
			result = result.add(marginOpReqDO.getAmount());
		}
		return result.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
	}

	/**
	 * 查询代理商信息
	 *
	 * @param promoterId
	 *            代理商编号
	 * @return
	 */
	public PromoterInfoDTO queryPromoterInfo(Long promoterId) {
		Assert.notNull(promoterId);

		PromoterInfoDTO promoterDTO = mspFacade.findPromoterInfoByPromoterId(promoterId);
		// StraightlyCfg straightlyCfg =
		// mspFacade.getPromoterCredit(promoterId);
		if (promoterDTO == null || StringUtils.isBlank(promoterDTO.getPromoterType())) {
			logger.error("MarginOpServiceImpl.queryPromoterInfo.error,promoterDTO is null");
		} else {
			BigDecimal canUseQuota = t0WithdrawService.getWithdrawT0ServiceAPI().findCanUseQuota(promoterDTO.getPromoterNo() + "",
					promoterDTO.getPromoterType());
			promoterDTO.setValidCredit(canUseQuota == null ? "0.00" : canUseQuota.toString());
		}
		// promoterDTO.setValidCredit(straightlyCfg.getValidCredit().toString());
		return promoterDTO;
	}

	public OpStateResponse addMargin(long promoterId, BigDecimal amount, OpTypeEnums opType, String operatorId) {
		return this.addMargin(promoterId, amount, opType, null, null, operatorId);
	}

	/**
	 * 追加保证金
	 *
	 * @param promoterId
	 *            代理商编号
	 * @param amount
	 *            追加金额
	 * @return
	 */
	public OpStateResponse addMargin(long promoterId, BigDecimal amount, OpTypeEnums opType, LoaningTypeEnum loaningType, Integer key,
			String operatorId) {

		// 取保证金账号
		PromoterFastSettleSwitchDOExample example = new PromoterFastSettleSwitchDOExample();
		example.setPromoterId(promoterId);
		List<PromoterFastSettleSwitchDO> list = promoterFastSettleSwitchManager.selectByExample(example);
		if (list == null || list.isEmpty()) {
			logger.error("MarginOpServiceImpl #addMargin,promoterId:" + promoterId + ",select TB_PROMOTER_FS_RQ is null.");
			return OpStateResponse.genFailureResponse("", "没有保证金开户记录");
		}
		if (!list.isEmpty() && list.size() > 1) {
			logger.error("MarginOpServiceImpl #addMargin,promoterId:" + promoterId + ",select TB_PROMOTER_FS_RQ not unique.");
			return OpStateResponse.genFailureResponse("", MerchantCreditConstant.MC_MARGIN_ADD_EXCEPTION);
		}
		PromoterFastSettleSwitchDO promoterFastSettleSwitchDO = list.get(0);
		String memberId = promoterFastSettleSwitchDO.getMarginMemberId();
		String marginAccount = promoterFastSettleSwitchDO.getMarginAccount();

		// 取代理商类型和商户号，保证金金额
		PromoterInfoDTO promoterInfoDTO = mspFacade.findPromoterInfoByPromoterId(promoterId);
		logger.info("MarginOpServiceImpl #addMargin,promoterIdInfo:" + promoterInfoDTO.toString());
		String promoterNo = promoterInfoDTO.getPromoterNo();
		String promoterType = promoterInfoDTO.getPromoterType();
		// 保证金金额
		BigDecimal fastSettleMargin = (StringUtils.isEmpty(promoterInfoDTO.getFastSettleMargin()) ? new BigDecimal(0) : new BigDecimal(
				promoterInfoDTO.getFastSettleMargin().trim())).setScale(2, BigDecimal.ROUND_HALF_UP);

		// 取扩大倍数
		ConfigOptionDOExample optionDOExample = new ConfigOptionDOExample();
		optionDOExample.createCriteria().andOptionKeyEqualTo(MerchantCreditConstant.MC_MARGIN_2_CONFIGURE_TIMES);
		List<ConfigOptionDO> configOptionDOs = configOptionManager.selectByExample(optionDOExample);
		if (configOptionDOs == null || configOptionDOs.isEmpty()) {
			logger.error("MarginOpServiceImpl #addMargin,MerchantCreditConstant.MC_MARGIN_2_CONFIGURE_TIMES is not unique.");
			return OpStateResponse.genFailureResponse("", MerchantCreditConstant.MC_MARGIN_ADD_EXCEPTION);
		}
		// 取基本户账号
		MerchantBalanceDTO balanceDTO = null;
		try {
			balanceDTO = accountQueryFacadeWrapper.queryMerchantBalance(memberId,promoterType);
		} catch (Exception e) {
			logger.error("MarginOpServiceImpl #addMargin" + e);
			return OpStateResponse.genFailureResponse("", MerchantCreditConstant.MC_MARGIN_ADD_EXCEPTION);
		}
		String marginAccountId = balanceDTO.getMarginAccountId();// 保证金账户id
		String publicAccountId = balanceDTO.getPublicAccountId();// 对公基本户id
		if (!marginAccount.equalsIgnoreCase(marginAccountId)) {
			logger.error("MarginOpServiceImpl #addMargin, database Margin Account not equal MA Margin Account,DB Margin Account:" + marginAccount
					+ ",Ma Margin AccountId:" + marginAccountId);
			return OpStateResponse.genFailureResponse("", MerchantCreditConstant.MC_MARGIN_ADD_EXCEPTION);
		}
		// TODO:追加/取回 金额和账户金额判断
		balanceDTO.getMarginAccountBalance();
		balanceDTO.getPublicAccountBalance();
		if (opType == OpTypeEnums.ADD && balanceDTO.getPublicAccountBalance().compareTo(amount) < 0) {
			logger.error("MarginOpServiceImpl #addMargin: promoterId:" + promoterId + " addMargin ,amount:" + amount
					+ " greater than PublicAccountBalance:" + balanceDTO.getPublicAccountBalance().toString());
			return new OpStateResponse(false, null, MerchantCreditConstant.MC_PROMOTER_ADD_MARGIN_BALANCE_ERROR);
		} else if (opType == OpTypeEnums.REDEEMED && fastSettleMargin.compareTo(amount) < 0) {
			// 如果要取回的保证金金额小于保证金金额，则返回错误消息
			logger.error("MarginOpServiceImpl #addMargin: promoterId:" + promoterId + " redeemedMargin ,amount:" + amount
					+ " greater than mspMarginAccountBalance:" + balanceDTO.getPublicAccountBalance().toString());
			return new OpStateResponse(false, null, MerchantCreditConstant.MC_PROMOTER_REDDEM_MARGIN_BALANCE_ERROR);
		} else if (opType == OpTypeEnums.REDEEMED && balanceDTO.getMarginAccountBalance().compareTo(amount) < 0) {
			logger.error("MarginOpServiceImpl #addMargin: promoterId:" + promoterId + " redeemedMargin ,amount:" + amount
					+ " greater than marginAccountBalance:" + balanceDTO.getPublicAccountBalance().toString());
			return new OpStateResponse(false, null, MerchantCreditConstant.MC_PROMOTER_REDDEM_MARGIN_BALANCE_ERROR);
		}

		OpContext context = new OpContext();
		context.setAppId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		context.setOpType(opType.code);
		context.setAmount(amount);
		context.setPromoterId(promoterId);
		context.setPromoterNo(promoterNo);
		context.setLoaningType(loaningType);// 垫资方
		context.setPromoterType(promoterType);

		RemitTransferRequestDTO transferRequest = new RemitTransferRequestDTO();
		transferRequest.setRemitVoucherNo(generatorSeq());
		transferRequest.setAppId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		if (opType == OpTypeEnums.ADD) {
			transferRequest.setPaymentCode(FOSPaymentCodeEnum.BASE2SUB);
			transferRequest.setPayerAccountNo(publicAccountId);
			transferRequest.setPayerAccountType(MerchantCreditConstant.ACCOUNT_TYPE_4_PUBLIC);
			transferRequest.setPayeeAccountNo(marginAccount);
			transferRequest.setPayeeAccountType(PosMerchantTypeEnums.EASYPAY_PROMOTER.code.equals(context.getPromoterType())?
					MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN_EASYPAY:
						PosMerchantTypeEnums.MPOS_PROMOTER.code.equals(context.getPromoterType())?MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN_MPOS:MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN);
		} else if (opType == OpTypeEnums.REDEEMED) {
			// TODO:退款时间
			context.setRedeemedTime(genrateT0RedeemedDate(key, loaningType, promoterType));
			transferRequest.setPaymentCode(FOSPaymentCodeEnum.SUB2BASE);
			transferRequest.setPayerAccountNo(marginAccount);
			transferRequest.setPayerAccountType(PosMerchantTypeEnums.EASYPAY_PROMOTER.code.equals(context.getPromoterType())?
					MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN_EASYPAY:
					PosMerchantTypeEnums.MPOS_PROMOTER.code.equals(context.getPromoterType())?MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN_MPOS:MerchantCreditConstant.ACCOUNT_TYPE_4_MARGIN);
			transferRequest.setPayeeAccountNo(publicAccountId);
			transferRequest.setPayeeAccountType(MerchantCreditConstant.ACCOUNT_TYPE_4_PUBLIC);
		}
		transferRequest.setRemitAmount(amount);
		transferRequest.setPayerMemberId(memberId);
		transferRequest.setPayeeMemberId(memberId);
		context.setRemitTransferRequest(transferRequest);

		ConfigOptionDO configOptionDO = configOptionDOs.get(0);
		String optionValue = configOptionDO.getOptionValue();
		MspModifyRequest mspModifyRequest = new MspModifyRequest();
		mspModifyRequest.setOpType(opType.code);
		ViewPromoterInfoDTO promoterInfo = this.promoterInfoService.queryPromoterById(promoterId);
		/** 可用额度 **/
		BigDecimal fastSettleLimit = promoterInfo.getPromoterFsLimit() == null ? new BigDecimal(0) : promoterInfo.getPromoterFsLimit().setScale(2,
				BigDecimal.ROUND_HALF_UP);
		if (opType == OpTypeEnums.ADD) {
			if (LoaningTypeEnum.PROMOTER == loaningType) {
				// 如果是代理商垫资 代理商金额额度=保证金金额
				fastSettleLimit = fastSettleMargin.add(amount).setScale(2, BigDecimal.ROUND_HALF_DOWN);
			}
			// 保证金额度
			mspModifyRequest.setFastSettleMargin(fastSettleMargin.add(amount).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
			// 可配置额度
			mspModifyRequest.setFastConfigureLimit((fastSettleMargin.add(amount)).multiply(new BigDecimal(optionValue))
					.setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
			// mspModifyRequest.setFastSettleLimit(fastSettleLimit.add(amount).setScale(2,
			// BigDecimal.ROUND_HALF_DOWN).toString());
			mspModifyRequest.setFastSettleLimit(fastSettleLimit.toString());
		} else if (opType == OpTypeEnums.REDEEMED) {
			if (LoaningTypeEnum.PROMOTER == loaningType) {
				fastSettleLimit = fastSettleMargin;
			}
			// 保证金金额 (保底-取回)
			mspModifyRequest.setFastSettleMargin(fastSettleMargin.subtract(amount).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
			// 可配置额度
			mspModifyRequest.setFastConfigureLimit((fastSettleMargin.subtract(amount)).multiply(new BigDecimal(optionValue))
					.setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
			// 可用额度
			setFastSettleLimit(mspModifyRequest, fastSettleLimit, amount, optionValue, loaningType, key, fastSettleMargin);

		} else if (opType == OpTypeEnums.MODIFY) {
			if (LoaningTypeEnum.PROMOTER == loaningType) {
				fastSettleLimit = amount;
			}
			mspModifyRequest.setFastSettleMargin(amount.setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
			mspModifyRequest.setFastSettleLimit(fastSettleLimit.toString());
		}
		mspModifyRequest.setObjType(OpObjTypeEnums.PROMOTER.code);
		mspModifyRequest.setObjId(promoterId);
		mspModifyRequest.setPromoterId(promoterId);
		mspModifyRequest.setPromoterNo(promoterNo);
		mspModifyRequest.setPromoterType(promoterType);

		context.setMspModifyRequest(mspModifyRequest);
		context.setPromoterType(promoterType);
		return opService.handler(context, MarginOpAddEnums.INIT.code, operatorId);
	}

	/**
	 * 可用额度
	 *
	 * @param mspModifyRequest
	 * @param fastSettleLimit
	 *            可用额度
	 * @param amount
	 *            申请额度
	 * @param optionValue
	 *            配置项值
	 * @param loaningType
	 *            垫资方
	 * @param key
	 *            0:代理商全资 1：盛付通全资
	 * @param fastSettleMargin
	 *            代理商当前保证金
	 */
	private void setFastSettleLimit(MspModifyRequest mspModifyRequest, BigDecimal fastSettleLimit, BigDecimal amount, String optionValue,
			LoaningTypeEnum loaningType, Integer key, BigDecimal fastSettleMargin) {

		int whollyType = loaningType.getCode();
		// 代理商全资 可用额度 1:1
		if (LoaningTypeEnum.PROMOTER.getCode() == whollyType) {
			mspModifyRequest.setFastSettleLimit(fastSettleLimit.subtract(amount).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());

			// 盛付通全资
		} else if (LoaningTypeEnum.SHENGPAY.getCode() == whollyType) {
			if (key == MarginBalanceType.DYNAMICAMOUNT.getState()) {
				// // 可用额度 等比例减少 (额度*配置比例)*(取回/保底)
				// BigDecimal total = fastSettleMargin.multiply(new
				// BigDecimal(optionValue)).setScale(2,
				// BigDecimal.ROUND_HALF_UP);
				// // 取回比例
				// BigDecimal proportion = amount.multiply(new
				// BigDecimal(optionValue)).setScale(2,
				// BigDecimal.ROUND_HALF_UP);
				//
				// mspModifyRequest.setFastSettleLimit(total.subtract(proportion).toString());

				// 可用额度 等比例减少 (额度*配置比例)*(取回/保底)
				BigDecimal newFastSettleLimit = (fastSettleLimit.multiply(fastSettleMargin.subtract(amount))).divide(fastSettleMargin, 2,
						BigDecimal.ROUND_HALF_DOWN);

				mspModifyRequest.setFastSettleLimit(newFastSettleLimit.toString());
			} else if (key == MarginBalanceType.GUARANTEED.getState()) {
				// 取保底部分额度为0
				mspModifyRequest.setFastSettleLimit("0.00");
			}
		}
	}

	/**
	 * 代理商保证金操作生成 MspModifyRequest
	 *
	 * @param opType
	 *            操作类型，追加、退回
	 * @param amount
	 *            操作金额
	 * @param fastSettleMargin
	 *            代理商当前保证金
	 * @param margin2ConfigTimes
	 *            系统扩大倍数
	 * @param promoterId
	 *            代理商ID
	 * @param promoterNo
	 *            代理商商户号
	 * @param promoterType
	 *            代理商类型
	 * @return
	 */
	public MspModifyRequest generatMarginMspModifyRequest(OpTypeEnums opType, BigDecimal amount, BigDecimal fastSettleMargin,
			String margin2ConfigTimes, long promoterId, String promoterNo, String promoterType) {
		MspModifyRequest mspModifyRequest = new MspModifyRequest();
		mspModifyRequest.setOpType(opType.code);
		if (opType == OpTypeEnums.ADD) {
			mspModifyRequest.setFastSettleMargin(fastSettleMargin.add(amount).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
			mspModifyRequest.setFastConfigureLimit((fastSettleMargin.add(amount)).multiply(new BigDecimal(margin2ConfigTimes))
					.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
			mspModifyRequest.setFastSettleLimit(fastSettleMargin.add(amount).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		} else if (opType == OpTypeEnums.REDEEMED) {
			mspModifyRequest.setFastSettleMargin(fastSettleMargin.subtract(amount).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
			mspModifyRequest.setFastConfigureLimit((fastSettleMargin.subtract(amount)).multiply(new BigDecimal(margin2ConfigTimes))
					.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
			mspModifyRequest.setFastSettleLimit(fastSettleMargin.subtract(amount).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		}

		mspModifyRequest.setObjType(OpObjTypeEnums.PROMOTER.code);
		mspModifyRequest.setObjId(promoterId);
		mspModifyRequest.setPromoterId(promoterId);
		mspModifyRequest.setPromoterNo(promoterNo);
		mspModifyRequest.setPromoterType(promoterType);
		logger.info("MarginOpService #generatMarginMspModifyRequest:" + mspModifyRequest.toString());
		return mspModifyRequest;
	}

	/**
	 * NEW T0 计算退款到基本户时间 取回10w元以上部分，30天到账；取回保底的10w元，180天到账 key 0:浮动 1：保底
	 *
	 * @param promoterType
	 *            代理商类型
	 * @return
	 */
	protected Date genrateT0RedeemedDate(int key, LoaningTypeEnum loaingType, String promoterType) {
		LoaningConfigBean configBean = loaningCongfigService.getLoaningConfigBeanByLoaningType(loaingType);
		// TODO LOANING_CONG_BY_MC_TYPE
		if (configBean == null) { return null; }
		configBean = loaningCongfigService.getLoaningConfigBeanByLoaningTypeMcType(configBean, promoterType);
		// 保底保证金取回时间（天）
		int minimumMarginRedeem = configBean.getMinimumMarginRedeem();
		// 浮动保证金取回时间（天）
		int marginRedeem = configBean.getMarginRedeem();
		int sepCnt = -1;
		if (MarginBalanceType.DYNAMICAMOUNT.getState() == key) {
			sepCnt = marginRedeem;
		} else if (MarginBalanceType.GUARANTEED.getState() == key) {
			sepCnt = minimumMarginRedeem;
		}
		return genrateT0Redeemed(sepCnt);
	}

	/**
	 * NEW T0 计算回退日期，T+n（自然日）
	 *
	 * @param sepCnt
	 * @return
	 */
	private Date genrateT0Redeemed(int sepCnt) {
		if (sepCnt == -1) sepCnt = 2;
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, sepCnt);
		return calendar.getTime();
	}

	/**
	 * 计算退款到基本户时间
	 *
	 * @return
	 */
	protected Date genrateRedeemedDate() {
		ConfigOptionDOExample example = new ConfigOptionDOExample();
		example.createCriteria().andOptionKeyEqualTo(MerchantCreditConstant.MC_REDEEMED_ADD_CNT);
		List<ConfigOptionDO> configOptionDOs = configOptionManager.selectByExample(example);
		String sepCnt = (configOptionDOs == null || configOptionDOs.isEmpty()) ? "0" : configOptionDOs.get(0).getOptionValue();

		example.clear();
		example.createCriteria().andOptionKeyEqualTo(MerchantCreditConstant.MC_REDEEMED_EXCLUDES_DATE);
		configOptionDOs = configOptionManager.selectByExample(example);
		String holidayStr = (configOptionDOs == null || configOptionDOs.isEmpty()) ? "" : configOptionDOs.get(0).getOptionValue();
		if (StringUtils.isEmpty(holidayStr)) logger.error("configOption holidayStr is Null.");
		return genrateRedeemedDate(sepCnt);
	}

	/**
	 * 计算回退日期，T+n（自然日）
	 *
	 * @param sepCnt
	 * @return
	 */
	private Date genrateRedeemedDate(String sepCnt) {
		if (StringUtils.isBlank(sepCnt))
			sepCnt = "2";
		else sepCnt = sepCnt.trim();
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, Integer.parseInt(sepCnt.trim()));
		return calendar.getTime();
	}

	/**
	 * T+n 工作日计算方法，需求改自然日故废弃
	 *
	 * @param sepCnt
	 * @param holidayStr
	 * @return
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private Date genrateRedeemedDate(int sepCnt, String holidayStr) {
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, sepCnt);// 周日 1，周六2
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		String disStr = DateUtil.dateFormat1.format(calendar.getTime());
		if (dayOfWeek == 1 || dayOfWeek == 7 || (StringUtils.isNotEmpty(holidayStr) && holidayStr.contains(disStr))) { return genrateRedeemedDate(
				sepCnt + 1, holidayStr); }
		return calendar.getTime();
	}

	public String getRedeemedSepCnt() {
		ConfigOptionDOExample example = new ConfigOptionDOExample();
		example.createCriteria().andOptionKeyEqualTo(MerchantCreditConstant.MC_REDEEMED_ADD_CNT);
		List<ConfigOptionDO> configOptionDOs = configOptionManager.selectByExample(example);
		String sepCnt = (configOptionDOs == null || configOptionDOs.isEmpty()) ? "0" : configOptionDOs.get(0).getOptionValue();
		return sepCnt;
	}

	public ErrorMessageVO<Object> validateAndAddMargin(long promoterId, BigDecimal amount, OpTypeEnums opType, String memberId, boolean isServer,
			String operatorId) {

		if (amount.compareTo(new BigDecimal("0.01")) < 0) { return new ErrorMessageVO<Object>(false, null,
				MerchantCreditConstant.MC_MARGIN_ADD_QUART_ERROR); }

		// if (amount.longValue() % 10000 != 0 || amount.longValue() <= 0) {
		// return new ErrorMessageVO(false, null,
		// "输入金额错误，请重新输入追加金额。金额必须为1万元的整数倍");
		// }
		MerchantBalanceDTO merchantBalance;
		ViewPromoterInfoDTO promoterInfo;
		try {
		    promoterInfo=promoterInfoService.queryPromoterById(promoterId);
		    if(promoterInfo==null){
		    	return new ErrorMessageVO<Object>(false, null, MerchantCreditConstant.MC_NOPERMISSION_EXCEPTION);
		    }
			merchantBalance = this.accountQueryFacadeWrapper.queryMerchantBalance(memberId,promoterInfo.getPromoterType());
		} catch (Exception e) {
			return new ErrorMessageVO<Object>(false, null, MerchantCreditConstant.MC_MARGIN_ADD_EXCEPTION);
		}
		BigDecimal need = BigDecimal.valueOf(0.01).subtract(merchantBalance.getMarginAccountBalance()==null?BigDecimal.ZERO:merchantBalance.getMarginAccountBalance());// 可能为负数
		if (amount.compareTo(need) == -1) {// 注意：amount已经大于0
		// long count = need.longValue() / 100 + (need.longValue() % 100 == 0 ?
		// 0 : 1);// 如999.99必须追加1000
			return new ErrorMessageVO<Object>(false, null, MerchantCreditConstant.MC_MARGIN_ADD_QUART_ERROR);
		}
		if (merchantBalance.getPublicAccountBalance().compareTo(amount) < 0)
			return new ErrorMessageVO<Object>(false, null,
					"盛付通钱包余额不足，请完成充值: <br><a href='https://zhuanye.shengpay.com/Prologin.aspx' target='_blank'>https://zhuanye.shengpay.com/Prologin.aspx</a>");
		MerchantBaseBalanceDTO merchantBaseBalance = accountQueryFacadeWrapper.queryAccountBalanceByAccountType(memberId, AccountType.B_BASE_ACCOUNT);
		if (AccountStatus.AccountStatusActive.getCode() != merchantBaseBalance.getAccountStatus()
				&& AccountStatus.AccountStatusDeniedFundIn.getCode() != merchantBaseBalance.getAccountStatus()) { return new ErrorMessageVO<Object>(
				false, null, "您的钱包状态异常"); }

		LoaningTypeEnum loaningType = LoaningTypeEnum.getLoaningTypeEnum(newt0PromoterService.getLoaningTypeByPromoterId(promoterId));
		if (loaningType == null || LoaningTypeEnum.SHENGPAY == loaningType) {
			boolean b = auditInfoService.hasAuditing(promoterInfo.getPromoterMerchantNo(), promoterId, OpTypeEnums.ADD.getCode());// 追加通过追加状态判断
			if (b) {// 存在审核中的
				return new ErrorMessageVO<Object>(false, "-1", "正在审核中，请您耐心等待，<br/>我们将在2个工作日内对您授予额度，并以短信通知您。");
			}
		}

		OpStateResponse opStateResponse = this.addMargin(promoterId, amount, opType, loaningType, null, operatorId);
		if (opStateResponse.isSuccess()) {
			// 发送邮件
			if ((loaningType == null || LoaningTypeEnum.SHENGPAY == loaningType) && opType == OpTypeEnums.ADD) {
				String title = "【待处理】T0代理商申请保证金调额";
				String content = subContext(promoterInfo.getPromoterName(), promoterInfo.getPromoterMerchantNo(), amount);
				sendMail(title, content);
			}
			if (isServer) {// 后台展现的消息
				if (loaningType == null || LoaningTypeEnum.SHENGPAY == loaningType) { // 无垫资方，盛付通全资
					return new ErrorMessageVO<Object>(true, null, "追加快速结算保证金成功，审核通过后会分配额度，并短信通知代理商。");
				} else {
					return new ErrorMessageVO<Object>(true, null, "快速结算保证金追加成功！");
				}
			} else {// 前台展现的消息
				if (loaningType == null || LoaningTypeEnum.SHENGPAY == loaningType) { // 无垫资方，盛付通全资
					return new ErrorMessageVO<Object>(true, null, "恭喜您追加快速结算保证金成功，<br/>我们将在2个工作日内对您授予额度，并以短信通知您。");
				} else {
					return new ErrorMessageVO<Object>(true, null, "恭喜你追加快速结算保证金成功！");
				}
			}
		} else return new ErrorMessageVO<Object>(false, null, MerchantCreditConstant.MC_MARGIN_ADD_EXCEPTION);
	}

	public ErrorMessageVO<Object> modifyMargin(long promoterId, BigDecimal amount, OpTypeEnums opType, String memberId, String operatorId) {

		LoaningTypeEnum loaningType = LoaningTypeEnum.getLoaningTypeEnum(newt0PromoterService.getLoaningTypeByPromoterId(promoterId));

		OpStateResponse opStateResponse = this.addMargin(promoterId, amount, opType, loaningType, null, operatorId);
		if (opStateResponse.isSuccess()) {
			return new ErrorMessageVO<Object>(true, null, "快速结算保证金修改成功！");
		} else return new ErrorMessageVO<Object>(false, null, "快速结算保证金修改失败！");
	}

	/**
	 * 发送邮件
	 *
	 * @param title
	 * @param content
	 * @param configKey
	 */
	public void sendMail(final String title, final String content) {
		logger.info("MarginOpServiceImpl.addMargin.sendMail title=" + title + "content=" + content);
		final String mailList =ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.ADD_MARGIN_MAIL_LIST);
		if (StringUtils.isBlank(mailList)) {
			logger.error("MarginOpServiceImpl.addMargin.sendMail.error,mail list is not configured");
			return;
		}
		Thread t = new Thread() {
			public void run() {
				try {
					AlertMessageSender sender = alertMessageSenderFactory.getAlertMessageSender(AlertMessageSendTypeEnum.MAIL_ALERT);
					sender.sendHtmlMessage(title, content, mailList);
				} catch (Exception e) {
					logger.error("MarginOpServiceImpl.addMargin.sendMail.error,content=" + content, e);
				}
			}
		};
		executorService.execute(t);
	}

	private String subContext(String promoterName, String prompterNo, BigDecimal marginAccountBalance) {
		StringBuffer sbContext = new StringBuffer();
		String applyTime = DateUtil.date2Str(new Date(), DateUtil.dateFormat4Format);
		sbContext.append("<table width='80%' border='1'>");
		sbContext.append("<caption align='top'>【待处理】T0代理商申请保证金调额</caption>");
		sbContext.append("<tr> ");
		sbContext.append("<th width='20%'>申请时间</th>");
		sbContext.append("<th width='20%'>代理商商户号</th>");
		sbContext.append("<th width='20%'>代理商名称</th>");
		sbContext.append("<th width='20%'>T0保证金(保证金余额)</th>");
		sbContext.append("</tr>");
		sbContext.append("<tr> ");
		sbContext.append("<td width='20%'>" + applyTime + "</th>");
		sbContext.append("<td width='20%'>" + prompterNo + "</td>");
		sbContext.append("<td width='20%'>" + promoterName + "</td>");
		sbContext.append("<td width='20%'>" + marginAccountBalance + "</td>");
		sbContext.append("</tr>");
		sbContext.append("<tr> ");
		sbContext.append("<td colspan='4' width='100%'><a  href='" + GlobalConfig.getString(MerchantContractCst.OPERNER_URL, "")
				+ "'>请登录后台审批</a></td>");
		sbContext.append("</tr>");
		sbContext.append("</table> ");
		return sbContext.toString();
	}

	/**
	 * 保证金取回
	 */
	public ErrorMessageVO<Object> validateAndRedeemMargin(long promoterId, BigDecimal amount, OpTypeEnums opType, String memberId, boolean isServer,
			String operatorId) {
		LoaningTypeEnum loaningType = LoaningTypeEnum.getLoaningTypeEnum(newt0PromoterService.getLoaningTypeByPromoterId(promoterId));
		if (loaningType == null) { return new ErrorMessageVO<Object>(false, null, MerchantCreditConstant.MC_PROMOTER_REDDEM_LOANING_TYPE_T0_ERROR); }
		if (LoaningTypeEnum.SHENGPAY == loaningType) {
			boolean b = auditInfoService.hasNonAudited(null, promoterId, OpTypeEnums.ADD.getCode());// 追加通过追加状态判断
			if (b) {// 存在审核中的
				return new ErrorMessageVO<Object>(false, null, "正在审核中，暂不能取回保证金。");
			}
		}
		ViewPromoterInfoDTO promoterInfo = promoterInfoService.queryPromoterById(promoterId);
		MerchantBalanceDTO merchantBalanceDTO;
		try {
			merchantBalanceDTO = accountQueryFacadeWrapper.queryMerchantBalance(memberId,promoterInfo.getPromoterType());
		} catch (Exception e) {
			return new ErrorMessageVO<Object>(false, null, MerchantCreditConstant.MC_MARGIN_REDEEM_EXCEPTION);
		}
		BigDecimal marginBalance = merchantBalanceDTO.getMarginAccountBalance();// 保证金账户余额
		PromoterInfoDTO promoterInfoDTO = this.queryPromoterInfo(promoterId);
		if (marginBalance.compareTo(BigDecimal.ZERO)<= 0
				|| new BigDecimal(promoterInfoDTO.getFastSettleMargin() == null ? "0" : promoterInfoDTO.getFastSettleMargin())
						.compareTo(BigDecimal.ZERO) <= 0) { return new ErrorMessageVO<Object>(false, null, "您的保证金余额为0,不能进行退回操作."); }
		if (amount.compareTo(marginBalance) >= 1 || amount.compareTo(new BigDecimal(promoterInfoDTO.getFastSettleMargin())) >= 1) { return new ErrorMessageVO<Object>(
				false, null, "对不起，您输入的取回金额超过了您的快速结算保证金余额，请重新输入."); }
		MerchantBaseBalanceDTO merchantBaseBalance = accountQueryFacadeWrapper.queryAccountBalanceByAccountType(memberId, AccountType.B_BASE_ACCOUNT);
		if (AccountStatus.AccountStatusActive.getCode() != merchantBaseBalance.getAccountStatus()
				&& AccountStatus.AccountStatusDeniedFundOut.getCode() != merchantBaseBalance.getAccountStatus()) { return new ErrorMessageVO<Object>(
				false, null, "对不起，您的账户状态不正确"); }

		// 如果今天有申请配资记录[成功的],则不允许进行取回保证金操作
		BigDecimal usedAmount = this.withCapital4PromoterService.queryWithCapital4Promoter(promoterId);
		if (usedAmount != null) { return new ErrorMessageVO<Object>(false, null, "对不起，今天您已配资，请明天再取回保证金."); }

		// 获取保证金取回天数配置
		LoaningConfigBean configBean = loaningCongfigService.getLoaningConfigBeanByLoaningType(loaningType);
		if (configBean == null) { return new ErrorMessageVO<Object>(false, null, MerchantCreditConstant.MC_PROMOTER_REDDEM_LOANING_CONFIG_T0_ERROR); }
		// TODO LOANING_CONG_BY_MC_TYPE
		configBean = loaningCongfigService.getLoaningConfigBeanByLoaningTypeMcType(configBean, promoterInfoDTO.getPromoterType());
		//PromoterInfoDTO promoInfo = this.queryPromoterInfo(promoterId);
		// 保证金(保底+浮动)
		BigDecimal fastSettleMargin = new BigDecimal(promoterInfoDTO.getFastSettleMargin());
		// 保证金杠杆（保底保证金金额）
		BigDecimal minimumMargin = new BigDecimal(configBean.getMinimumMargin());
		WhiteListInfoDO whiteListInfo = this.whiteListInfoService.queryWhiteListInfo(WhiteTypeEnums.PROMOTER_MIN_MARGIN.code,
				promoterInfoDTO.getPromoterNo() + "", promoterInfoDTO.getPromoterType());
		if (whiteListInfo != null && StringUtils.isNotBlank(whiteListInfo.getContent())) {
			minimumMargin = new BigDecimal(whiteListInfo.getContent());
		}
		// 浮动保证金
		BigDecimal floatingMargin = fastSettleMargin.compareTo(minimumMargin) >= 0 ? fastSettleMargin.subtract(minimumMargin) : new BigDecimal(0);

		// amount 大于浮动金额
		if (amount.compareTo(fastSettleMargin) != 0 && amount.compareTo(floatingMargin) > 0) { return new ErrorMessageVO<Object>(false, null,
				MerchantCreditConstant.MC_PROMOTER_REDDEM_MARGIN_BALANCE_T0_ERROR); }
		// amount 小于保底
		if (floatingMargin.compareTo(new BigDecimal(0)) == 0 && amount.compareTo(fastSettleMargin) != 0) { return new ErrorMessageVO<Object>(false,
				null, MerchantCreditConstant.MC_PROMOTER_REDDEM_MARGIN_BALANCE_T0_ERROR); }
	
		// 保底保证金取回时间（天）
		int minimumMarginRedeem = configBean.getMinimumMarginRedeem();
		// 浮动保证金取回时间（天）
		int marginRedeem = configBean.getMarginRedeem();
		StringBuffer msg = new StringBuffer();
		OpStateResponse opStateResponse = new OpStateResponse();
		// 全部取回(保底+浮动)
		if (fastSettleMargin.compareTo(amount) == 0 && floatingMargin.compareTo(new BigDecimal(0)) > 0) {
			// 浮动
			OpStateResponse opStateResponse1 = this.addMargin(promoterId, floatingMargin, opType, loaningType,
					MarginBalanceType.DYNAMICAMOUNT.getState(), operatorId);
			if (opStateResponse1.isSuccess()) {
				msg.append("（ ").append(floatingMargin).append("元").append(marginRedeem).append("天后到账  ）");
			} else {
				return new ErrorMessageVO<Object>(false, null, MerchantCreditConstant.MC_MARGIN_REDEEM_NEWT0_EXCEPTION);
			}
			if (minimumMargin.compareTo(BigDecimal.ZERO) > 0) {//只有设置的保底保证金大于0 再操作
				// 保底
				OpStateResponse opStateResponse2 = this.addMargin(promoterId, minimumMargin, opType, loaningType,
						MarginBalanceType.GUARANTEED.getState(), operatorId);
				if (opStateResponse2.isSuccess()) {
					msg.append("（ ").append(minimumMargin).append("元").append(minimumMarginRedeem).append("天后到账  ） ");
					// 保底部分 短信参数
					Map<String, String> map = new HashMap<String, String>();
					map.put("fastSettleLimit", "0");
					map.put("date", com.sdo.common.util.DateUtil.getWebDateString(new Date()));
					sendMessage(promoterId, MessageTemplateCodeEnum.AUDIT_ADDMARGIN_SUCCESS.getKey(), map);
				} else {
					// 浮动部分 短信参数
					Map<String, String> map = new HashMap<String, String>();
					BigDecimal newFastSettleLimit = this.jsFastSettleLimit(loaningType, promoterInfo, fastSettleMargin, floatingMargin);
					map.put("fastSettleLimit", newFastSettleLimit.toString());
					map.put("date", com.sdo.common.util.DateUtil.getWebDateString(new Date()));
					sendMessage(promoterId, MessageTemplateCodeEnum.AUDIT_ADDMARGIN_SUCCESS.getKey(), map);
				}
			}

			if (isServer) {
				return new ErrorMessageVO<Object>(true, null, "退款申请成功，到账时间如下：" + msg.toString());
			} else {
				return new ErrorMessageVO<Object>(true, null, "你的退款申请已经提交，若审核无误，我们会在规定时间将您的快速结算保证金返回到您的盛付通钱包，请耐心等待！" + msg.toString());
			}
			// 取保底
		} else if (floatingMargin.compareTo(new BigDecimal(0)) == 0 && amount.compareTo(fastSettleMargin) == 0) {
			msg.append(amount).append("元").append(minimumMarginRedeem).append("天后到账） ");
			opStateResponse = this.addMargin(promoterId, amount, opType, loaningType, MarginBalanceType.GUARANTEED.getState(), operatorId);
			if (opStateResponse.isSuccess()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("fastSettleLimit", "0");
				map.put("date", com.sdo.common.util.DateUtil.getWebDateString(new Date()));
				sendMessage(promoterId, MessageTemplateCodeEnum.AUDIT_ADDMARGIN_SUCCESS.getKey(), map);
			}
			// 取浮动部分
		} else if (amount.compareTo(floatingMargin) <= 0) {
			msg.append("（").append(amount);
			msg.append("元").append(marginRedeem).append("天后到账）");
			opStateResponse = this.addMargin(promoterId, amount, opType, loaningType, MarginBalanceType.DYNAMICAMOUNT.getState(), operatorId);
			if (opStateResponse.isSuccess()) {
				Map<String, String> map = new HashMap<String, String>();
				BigDecimal newFastSettleLimit = this.jsFastSettleLimit(loaningType, promoterInfo, fastSettleMargin, amount);
				map.put("fastSettleLimit", newFastSettleLimit.toString());
				map.put("date", com.sdo.common.util.DateUtil.getWebDateString(new Date()));
				sendMessage(promoterId, MessageTemplateCodeEnum.AUDIT_ADDMARGIN_SUCCESS.getKey(), map);
			}
		}
		if (opStateResponse.isSuccess()) {
			if (isServer) {
				return new ErrorMessageVO<Object>(true, null, "退款申请成功，到账时间如下：" + msg.toString());
			} else {
				return new ErrorMessageVO<Object>(true, null, "你的退款申请已经提交，若审核无误，我们会在规定时间将您的快速结算保证金返回到您的盛付通钱包，请耐心等待！" + msg.toString());
			}
		} else return new ErrorMessageVO<Object>(false, null, MerchantCreditConstant.MC_MARGIN_REDEEM_EXCEPTION);
	}

	/**
	 * 计算可用额度
	 *
	 * @param loaningType
	 * @param promoterInfoDTO
	 * @param fastSettleMargin
	 * @param amount
	 * @return
	 */
	private BigDecimal jsFastSettleLimit(LoaningTypeEnum loaningType, ViewPromoterInfoDTO promoterInfoDTO, BigDecimal fastSettleMargin,
			BigDecimal amount) {
		BigDecimal newFastSettleLimit = new BigDecimal(0);
		try {
			int whollyType = loaningType.getCode();
			/** 可用额度 **/
			BigDecimal fastSettleLimit = (promoterInfoDTO.getPromoterFsLimit() == null ? new BigDecimal(0) : promoterInfoDTO.getPromoterFsLimit())
					.setScale(2, BigDecimal.ROUND_HALF_UP);
			// 代理商全资
			if (LoaningTypeEnum.PROMOTER.getCode() == whollyType) {
				newFastSettleLimit = fastSettleLimit.subtract(amount).setScale(2, BigDecimal.ROUND_HALF_DOWN);
				// 盛付通全资
			} else if (LoaningTypeEnum.SHENGPAY.getCode() == whollyType) {
				newFastSettleLimit = (fastSettleLimit.multiply(fastSettleMargin.subtract(amount))).divide(fastSettleMargin, 2,
						BigDecimal.ROUND_HALF_DOWN);
			}
		} catch (Exception e) {
			logger.error("计算可用额度异常：" + e.getMessage());
		}

		return newFastSettleLimit;
	}

	/**
	 * 发送短信
	 *
	 * @param msg
	 */
	// private void sendMessage(long promoterId, String msgCode,BigDecimal
	// amount, int marginRedeem, BigDecimal minimumMargin, int
	// minimumMarginRedeem) {
	// // 短信通知功能
	// if (msgCode == null) {
	// logger.error("Redeem Margin message send msgCode is null , promoterId = "
	// + promoterId);
	// return;
	// }
	// try {
	// String mobile = mspFacade.getPromoterMoileByPromoterId(promoterId);
	// if (mobile == null) {
	// logger.error("Redeem Margin message send mobile is null , promoterId = "
	// + promoterId);
	// return;
	// }
	// Map<String, String> paramMap = new HashMap<String, String>();
	// if
	// (msgCode.equals(MessageTemplateCodeEnum.MARGIN_REDEEM_MESSAGE_MARG.getKey()))
	// {
	// paramMap.put("floatingMargin", amount.toString());
	// paramMap.put("marginRedeem", marginRedeem + "");
	// paramMap.put("minimumMargin", minimumMargin.toString());
	// paramMap.put("minimumMarginRedeem", minimumMarginRedeem + "");
	// } else if
	// (msgCode.equals(MessageTemplateCodeEnum.MARGIN_REDEEM_MESSAGE_FLOAT.getKey()))
	// {
	// paramMap.put("floatingMargin", amount.toString());
	// paramMap.put("marginRedeem", marginRedeem + "");
	// } else if
	// (msgCode.equals(MessageTemplateCodeEnum.MARGIN_REDEEM_MESSAGE_MINIMARGINREDEEM.getKey()))
	// {
	// paramMap.put("minimumMargin", amount.toString());
	// paramMap.put("minimumMarginRedeem", minimumMarginRedeem + "");
	// }
	// messageService.sendOneMessage(mobile, msgCode, paramMap);
	// } catch (Exception e) {
	// logger.error("Redeem Margin message send error: " + e.getMessage(), e);
	// }
	//
	// }

	public void sendMessage(Long promoterId, String key, Map<String, String> map) {
		try {
			String phone = mspFacade.getPromoterMoileByPromoterId(promoterId);
			messageService.sendOneMessage(phone, key, map);
		} catch (Exception e) {
			logger.error("MarginOpServiceImpl.sendMessage.error,promoterId=" + promoterId, e);
		}
	}

	@Override
	public BigDecimal queryMarginOpReqSum(Long promoterId, Integer opType, Integer status) {
		return marginOpReqManager.queryMarginOpReqSum(promoterId, opType, status);
	}

}
