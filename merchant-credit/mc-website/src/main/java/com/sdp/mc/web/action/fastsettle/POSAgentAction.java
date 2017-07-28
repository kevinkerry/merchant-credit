package com.sdp.mc.web.action.fastsettle;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mc.service.api.enums.WhiteTypeEnums;
import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.common.bean.newt0.AdjustLimitBean;
import com.sdp.mc.common.bean.newt0.LoaningConfigBean;
import com.sdp.mc.common.bean.newt0.NewT0PromoterInfoServiceBean;
import com.sdp.mc.common.bean.whitelist.WhiteListFeeBean;
import com.sdp.mc.common.constant.MerchantContractCst;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.enums.AuditInfoStateEnum;
import com.sdp.mc.common.enums.LoaningTypeEnum;
import com.sdp.mc.common.enums.MarginOpAddEnums;
import com.sdp.mc.common.enums.OpObjTypeEnums;
import com.sdp.mc.common.enums.OpOpenAndCloseEnums;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.common.enums.PolicyTypeEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawReqStatusEnums;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.util.IPUtils;
import com.sdp.mc.common.util.McBizException;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.vo.MerchantFastSettleVO;
import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.dao.readonly.merchant.CmPosMerchantDAO;
import com.sdp.mc.dao.readonly.promoter.PromoterDAO;
import com.sdp.mc.dao.readonly.promoter.PromoterEO;
import com.sdp.mc.facade.msp.MspFacade;
import com.sdp.mc.ffconfig.dao.FastSettleConfigDO;
import com.sdp.mc.integration.ma.dto.MerchantBalanceDTO;
import com.sdp.mc.integration.msp.MerchantInfoDTO;
import com.sdp.mc.integration.msp.PromoterInfoDTO;
import com.sdp.mc.ma.wrapper.AccountQueryFacadeWrapper;
import com.sdp.mc.margin.dao.MarginOpReqDO;
import com.sdp.mc.margin.dao.MarginOpReqDOExample;
import com.sdp.mc.newt0.dao.AuditInfoDTO;
import com.sdp.mc.newt0.dao.NewT0AuditInfoDOExample;
import com.sdp.mc.newt0.dao.WhiteListInfoDO;
import com.sdp.mc.newt0.manager.ExtNewT0AuditInfoManager;
import com.sdp.mc.newt0.manager.Newt0LoaningConfigManager;
import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDO;
import com.sdp.mc.service.AuditInfoService;
import com.sdp.mc.service.McManagerService;
import com.sdp.mc.service.apply.FastSettleApply;
import com.sdp.mc.service.apply.PromoterFastSettleSwitch;
import com.sdp.mc.service.fastsettle.FastSettle;
import com.sdp.mc.service.fastsettle.adjustLimit.AdjustLimitService;
import com.sdp.mc.service.fastsettle.margin.MarginOpService;
import com.sdp.mc.service.fsconfig.FastSettleConfigService;
import com.sdp.mc.service.msp.posmerchant.PosMerchantService;
import com.sdp.mc.service.newt0.NewT0PromoterInfoService;
import com.sdp.mc.service.newt0.Newt0PromoterService;
import com.sdp.mc.service.newt0.loaning.config.LoaningCongfigService;
import com.sdp.mc.service.op.state.OpStateResponse;
import com.sdp.mc.settle.api.dto.SettleMerchantDTO;
import com.sdp.mc.settle.api.dto.SettleMerchantDplDTO;
import com.sdp.mc.view.dao.ViewMerchantInfoDTO;
import com.sdp.mc.view.dao.ViewPromoterInfoDTO;
import com.sdp.mc.web.action.BaseAction;
import com.sdp.mc.web.dto.AddMarginReqDTO;
import com.sdp.mc.web.util.POSAgentConverterUtil;
import com.sdp.withdraw.dao.PolicyConfigInfoDO;
import com.sdp.withdraw.dao.ext.ExtWithdrawReqDOExample;
import com.sdp.withdraw.dao.ext.ExtWithdrawReqVO;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.sdp.withdraw.enums.WithdrawRatioStatusEnums;
import com.sdp.withdraw.manager.ext.ExtWithdrawReqManager;
import com.sdp.withdraw.vo.ratio.WithdrawRatioResult;
import com.shengpay.commom.config.GlobalConfig;
import com.shengpay.service.fileManager.impl.DFSUtils;
import com.shengpay.service.view.MerchantInfoService;
import com.shengpay.service.view.PromoterInfoService;
import com.shengpay.service.whitelist.WhiteListInfoService;
import com.shengpay.service.withdraw.MerchantLimitRuleService;
import com.shengpay.service.withdraw.PolicyConfigInfoService;
import com.shengpay.service.withdraw.cost.WithdrawCostConfigService;
import com.shengpay.service.withdraw.cost.impl.WithdrawCostServiceimpl;

@Controller
@RequestMapping(value = { "/posPromoter", "/mposPromoter", "/mposPartnerPromoter" })
public class POSAgentAction extends BaseAction {
	private static final Logger log = LoggerFactory.getLogger(POSAgentAction.class);
	@Autowired
	private FastSettleApply fastSettleApply;
	@Autowired
	private PromoterFastSettleSwitch promoterFastSettleSwitch;
	@Autowired
	private AccountQueryFacadeWrapper accountQueryFacadeWrapper;
	@Autowired
	private MarginOpService marginOpService;
	@Autowired
	private MspFacade mspFacade;
	@Autowired
	private FastSettle fastSettle;
	@Autowired
	private Newt0PromoterService newt0PromoterService;
	@Autowired
	private LoaningCongfigService loaningCongfigService;
	@Autowired
	private McManagerService mcManagerService;
	@Autowired
	private NewT0PromoterInfoService newT0PromoterInfoService;
	@Autowired
	private AuditInfoService auditInfoService;
	@Autowired
	private PromoterDAO promoterDAO;
	@Autowired
	private ExtWithdrawReqManager extWithdrawReqManager;
	@Autowired
	private WhiteListInfoService whiteListInfoService;
	@Autowired
	private PosMerchantService posMerchantService;
	@Autowired
	private AdjustLimitService adjustLimitService;
	@Autowired
	private ExtNewT0AuditInfoManager extNewT0AuditInfoManager;
	@Autowired
	private PromoterInfoService promoterInfoService;
	@Autowired
	private MerchantInfoService merchantInfoService;
	@Autowired
	private WithdrawCostServiceimpl withdrawCostServiceimpl;
	@Autowired
	private WithdrawCostConfigService withdrawCostConfigService;
	@Autowired
	private ScSettleBaseService scSettleBaseService;
	@Autowired
	private PolicyConfigInfoService policyConfigInfoService;
	@Autowired
	private FastSettleConfigService fastSettleConfigService;
	@Autowired
	private Newt0LoaningConfigManager newt0LoaningConfigManager;
	@Autowired
	private CmPosMerchantDAO cmPosMerchantDAO;
	@Autowired
	private MerchantLimitRuleService merchantLimitRuleService;

	/**
	 * 进入代理商快速结算申请页面,
	 *
	 * @throws McBizException
	 **/
	@RequestMapping(value = "/agentApply/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws McBizException {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		boolean openFlag = false, closeFlag = false, marginFlag = false;
		String msgCode = "";
		Long promoterId = user.getPromoterId();
		// cloudPaymentType=0101 云收银管理菜单进入
		String promoterType = request.getParameter("promoterType");
		if (StringUtils.isBlank(promoterType)) {
			promoterType = user.getCurrentMcType();
		}
		ViewPromoterInfoDTO viewPromoterInfoDTO = null;
		if (PosMerchantTypeEnums.EASYPAY_PROMOTER.code.equals(promoterType)) {
			viewPromoterInfoDTO = promoterInfoService.queryPromoterInfo(user.getMerchantNo(), promoterType);
			if (viewPromoterInfoDTO != null) {
				promoterId = viewPromoterInfoDTO.getPromoterId();
			} else {
				model.put("msgCode", "3");
				return "/main/fastsettle/fastSettleIndex";
			}
		}

		if (user != null) {
			// TODO:是否保证金已开户
			PromoterFastSettleSwitchDO pfss = this.promoterFastSettleSwitch
					.queryPromoterFastSettleSwitchByPromoterId(promoterId);
			if (pfss != null) {
				int type = pfss.getType();
				int status = pfss.getStatus();
				if (OpTypeEnums.OPEN.code == type && (status == OpOpenAndCloseEnums.INIT.getCode()
						|| status == OpOpenAndCloseEnums.ACCOUNT_OPENING.getCode())) {
					// TODO:处理中,不显示开通,不显示关闭,不显示保证金
					msgCode = "2";
				} else if (OpTypeEnums.OPEN.code == type
						&& (status == OpOpenAndCloseEnums.ACCOUNT_FAILURE.getCode()
								|| status == OpOpenAndCloseEnums.CLOSE_CONFIGURE_FAILURE.getCode())
						|| status == OpOpenAndCloseEnums.CONFIGURE_FAILURE.getCode()) {
					// TODO:处理失败,不显示开通,不显示关闭,不显示保证金
					msgCode = "1";
				} else if (OpTypeEnums.OPEN.code == type && status == OpOpenAndCloseEnums.CONFIGURE_SUCCESS.getCode()) {
					// TODO:显示关闭,显示保证金
					closeFlag = true;
					marginFlag = true;
					// 查询垫资方和配置金额
					model.put("promoterInfo",
							newT0PromoterInfoService.getNewT0PromoterInfoServiceBeanByPromoterId(promoterId));
					// 是否需要审核
					boolean isNeedApproval = adjustLimitService.isNeedApproval(user.getMerchantNo(), promoterId,
							OpTypeEnums.SHENGPAY_PROMPTER_ADJUST_LIMIT.code);
					model.put("adjustAuditFlag", isNeedApproval);
					NewT0PromoterInfoServiceBean promoterBean = (NewT0PromoterInfoServiceBean) model
							.get("promoterInfo");

					// 已使用额度=已用额度+冻结额度=总额度-可用额度

					BigDecimal usedFastSettleLimit = new BigDecimal(
							promoterBean.getPromoterInfoDTO().getFastSettleLimit())
									.subtract(new BigDecimal(promoterBean.getPromoterInfoDTO().getValidCredit()));
					model.put("usedFastSettleLimit", usedFastSettleLimit);
					BigDecimal workDayLimit = mspFacade.queryPmtFastSettleLimit(user.getMerchantNo(), promoterType,
							false);
					BigDecimal holiDayLimit = mspFacade.queryPmtFastSettleLimit(user.getMerchantNo(), promoterType,
							true);
					if (Double.valueOf(promoterBean.getPromoterInfoDTO().getFastSettleLimit()) == 0) {
						model.put("usedRedio", new BigDecimal(0));
					} else {
						BigDecimal limit = new BigDecimal(promoterBean.getPromoterInfoDTO().getFastSettleLimit());
						BigDecimal userRedio = usedFastSettleLimit.divide(limit, 4, BigDecimal.ROUND_HALF_UP);
						model.put("usedRedio",
								userRedio.multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP));
					}
					Integer suplusCount = adjustLimitService.surplusAdjustCount(user.getMerchantNo(), promoterId,
							OpTypeEnums.SHENGPAY_PROMPTER_ADJUST_LIMIT.code, AuditInfoStateEnum.AUDITED.getStatus());
					model.put("surplusCount", suplusCount);
					model.put("workDayLimit", workDayLimit);
					model.put("holiDayLimit", holiDayLimit);
					// 追加且转账成功的金额
					BigDecimal amount = marginOpService.queryMarginOpReqSum(promoterId, OpTypeEnums.ADD.code,
							MarginOpAddEnums.TRANSFER_SUCCESS.code);
					model.put("fastSettleMargin",
							StringUtils.isBlank(promoterBean.getPromoterInfoDTO().getFastSettleMargin()) ? amount
									: amount.add(
											new BigDecimal(promoterBean.getPromoterInfoDTO().getFastSettleMargin())));
					model.put("loaningType", promoterBean.getPromoterInfoDTO().getLoaningType() == null ? -1
							: promoterBean.getPromoterInfoDTO().getLoaningType());
					AuditInfoDTO auditInfo = extNewT0AuditInfoManager
							.selectAuditedTempLimitInfoByMerchantInfo(user.getMerchantNo(), promoterType);
					model.put("auditInfo", auditInfo == null ? true : false);
					try {
						Double configUseRadio = adjustLimitService.getUseLimitRadio();
						model.put("configUseRadio", configUseRadio);
					} catch (McBizException e) {
						log.error("POSAgentAction#index configUseRadio is error ：" + e.getMessage(), e);
						msgCode = "1";
						throw e;
					}

				} else if (OpTypeEnums.CLOSE.code == type && status == OpOpenAndCloseEnums.CLOSE_INIT.getCode()) {
					// TODO:处理中,不显示开通,不显示关闭,不显示保证金
					msgCode = "2";
				} else if (OpTypeEnums.CLOSE.code == type
						&& status == OpOpenAndCloseEnums.CLOSE_CONFIGURE_SUCCESS.getCode()) {
					// TODO:显示开通,不显示保证金
					openFlag = true;
				} else if (OpTypeEnums.CLOSE.code == type
						&& status == OpOpenAndCloseEnums.CLOSE_CONFIGURE_FAILURE.getCode()) {
					// TODO:处理失败,不显示开通,不显示关闭,不显示保证金
					msgCode = "1";
				}
			} else {
				// TODO:未开户,显示开通,不显示关闭,不显示保证金
				openFlag = true;
			}
			model.put("pfss", pfss);
			model.put("openFlag", openFlag);
			model.put("closeFlag", closeFlag);
			model.put("marginFlag", marginFlag);
			model.put("msgCode", msgCode);
			if (user.getCurrentMcType() != null) {
				String protocolType = "";
				String agreementHtml = "";
				if (PosMerchantTypeEnums.EASYPAY_PROMOTER.code.equals(promoterType)) {
					protocolType = "easypay";
					agreementHtml = MerchantContractCst.EASYPAY_FASTSETTLE_AGREEMENT_HTML;
				} else if (PosMerchantTypeEnums.MPOS_PROMOTER.code.equals(promoterType)) {
					protocolType = "mpos";
					agreementHtml = MerchantContractCst.MPOS_FASTSETTLE_AGREEMENT_HTML;
				} else if (PosMerchantTypeEnums.POS_PROMOTER.code.equals(promoterType)) {
					protocolType = "pos";
					agreementHtml = MerchantContractCst.POS_FASTSETTLE_AGREEMENT_HTML;
				}
				model.put("protocolType", protocolType);
				model.put("agreementHtml", GlobalConfig.getString(agreementHtml, ""));
				model.put("promoterType", promoterType);
			}

		}

		model.put("startTime", DateUtil.date2Str(adjustLimitService.queryAdjustTime(MerchantCreditConstant.START),
				DateUtil.dateFormat6Format));
		model.put("endTime", DateUtil.date2Str(adjustLimitService.queryAdjustTime(MerchantCreditConstant.END),
				DateUtil.dateFormat6Format));
		return "/main/fastsettle/fastSettleIndex";
	}

	private boolean containMerchantType(String merchantTypes, String typePromoter) {
		if (typePromoter != null && merchantTypes != null) {
			for (String merchantType : merchantTypes.split(",")) {
				if (typePromoter.equals(merchantType)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 代理商开通快速结算
	 **/
	@RequestMapping(value = "/applyOpen")
	@ResponseBody
	public ErrorMessageVO applyOpen(Long pfrId, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		ErrorMessageVO errorMessage = new ErrorMessageVO(false);
		try {
			MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
			String promoterType = request.getParameter("promoterType");
			ViewPromoterInfoDTO viewPromoterInfoDTO = null;
			Long promoterId = user.getPromoterId();
			String currentMcType = user.getCurrentMcType();
			if (PosMerchantTypeEnums.EASYPAY_PROMOTER.code.equals(promoterType)) {
				viewPromoterInfoDTO = promoterInfoService.queryPromoterInfo(user.getMerchantNo(), promoterType);
				if (viewPromoterInfoDTO != null) {
					promoterId = viewPromoterInfoDTO.getPromoterId();
					currentMcType = promoterType;
				} else {
					errorMessage.setSuccess(false);
					errorMessage.setErrorCode("-1");
					errorMessage.setErrorMessage("此代理商不具备操作此功能！");
					return errorMessage;
				}
			}
			errorMessage = this.promoterFastSettleSwitch.validateApplyOpen(pfrId, promoterId);
			log.error("POSAgentAction.applyOpen.validate,pfrId=" + pfrId + ",result="
					+ ToStringBuilder.reflectionToString(errorMessage));
			if (errorMessage.isSuccess()) {
				OpStateResponse reponse = this.fastSettleApply.applyOpen(user, pfrId, IPUtils.getClientIP(request),
						user.getAdminLoginName(), currentMcType, promoterId);
				errorMessage = POSAgentConverterUtil.buildErrorMessageVO(reponse);
			}
		} catch (Exception e) {
			log.error("POSAgentAction.applyOpen.error,pfrId=" + pfrId, e);
			errorMessage.setSuccess(false);
			errorMessage.setErrorCode("-1");
			errorMessage.setErrorMessage("很抱歉，系统繁忙，请稍后再试，或致电盛付通客服400-720-8888");
		}
		return errorMessage;
	}

	/**
	 * 代理商关闭快速结算
	 **/
	@RequestMapping(value = "/applyClose")
	@ResponseBody
	public ErrorMessageVO applyClose(Long pfrId, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		ErrorMessageVO errorMessage = new ErrorMessageVO(false);
		try {
			MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
			String promoterType = request.getParameter("promoterType");
			ViewPromoterInfoDTO viewPromoterInfoDTO = null;
			Long promoterId = user.getPromoterId();
			String currentMcType = user.getCurrentMcType();
			if (PosMerchantTypeEnums.EASYPAY_PROMOTER.code.equals(promoterType)) {
				viewPromoterInfoDTO = promoterInfoService.queryPromoterInfo(user.getMerchantNo(), promoterType);
				if (viewPromoterInfoDTO != null) {
					promoterId = viewPromoterInfoDTO.getPromoterId();
					currentMcType = promoterType;
				} else {
					errorMessage.setSuccess(false);
					errorMessage.setErrorCode("-1");
					errorMessage.setErrorMessage("此代理商不具备操作此功能！");
					return errorMessage;
				}
			}
			errorMessage = this.promoterFastSettleSwitch.validateApplyClose(pfrId, promoterId);
			log.error("POSAgentAction.applyClose.validate,pfrId=" + pfrId + ",result="
					+ ToStringBuilder.reflectionToString(errorMessage));
			if (errorMessage.isSuccess()) {
				OpStateResponse reponse = this.fastSettleApply.applyClose(user, pfrId, IPUtils.getClientIP(request),
						user.getAdminLoginName(), currentMcType, promoterId);
				errorMessage = POSAgentConverterUtil.buildErrorMessageVO(reponse);
			}
		} catch (Exception e) {
			log.error("POSAgentAction.applyClose.error,pfrId=" + pfrId, e);
			errorMessage.setSuccess(false);
			errorMessage.setErrorCode("-1");
			errorMessage.setErrorMessage("系统繁忙，关闭失败，请稍后再试或致电盛付通客服400-720-8888");
		}
		return errorMessage;
	}

	/**
	 * 代理商保证金管理
	 **/
	@RequestMapping(value = "/additionalMargin/index")
	public String additionalMarginIndex(String currentListDiv, MarginOpReqDOExample query, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		String promoterType = request.getParameter("promoterType");
		if (StringUtils.isBlank(promoterType)) {
			promoterType = user.getCurrentMcType();
		}
		Long promoterId = user.getPromoterId();
		ViewPromoterInfoDTO viewPromoterInfoDTO = null;
		boolean opFlag = true;
		if (PosMerchantTypeEnums.EASYPAY_PROMOTER.code.equals(promoterType)) {
			viewPromoterInfoDTO = promoterInfoService.queryPromoterInfo(user.getMerchantNo(), promoterType);
			if (viewPromoterInfoDTO != null) {
				promoterId = viewPromoterInfoDTO.getPromoterId();
			} else {
				model.put("msgCode", "3");
				return "/main/fastsettle/fastSettleIndex";
			}
		}
		PromoterFastSettleSwitchDO pfss = this.promoterFastSettleSwitch
				.queryPromoterFastSettleSwitchByPromoterId(promoterId);
		if (pfss == null) {// 开通记录为空，不能操作
			// model.put("opFlag", false);
			opFlag = false;
		} else if (StringUtils.isEmpty(pfss.getMarginAccount())) {// 储值账户未开通，不能操作
			// model.put("opFlag", false);
			opFlag = false;
		} else if ((OpOpenAndCloseEnums.ACCOUNT_OPENING.getCode() == pfss.getStatus()
				|| OpOpenAndCloseEnums.ACCOUNT_FAILURE.getCode() == pfss.getStatus())) {
			// 储值账户未开户中，开户异常，不能操作
			// model.put("opFlag", false);
			opFlag = false;
		} else if ((OpOpenAndCloseEnums.CLOSE_INIT.getCode() == pfss.getStatus()
				|| OpOpenAndCloseEnums.CLOSE_CONFIGURE_SUCCESS.getCode() == pfss.getStatus()
				|| OpOpenAndCloseEnums.CLOSE_CONFIGURE_FAILURE.getCode() == pfss.getStatus())) {
			// 关闭操作中，不能操作
			// model.put("opFlag", false);
			opFlag = false;
		}
		model.put("opFlag", opFlag);
		model.put("promoterType", promoterType);
		if (!opFlag)
			return "/main/fastsettle/additionalMargin";

		try {
			PromoterInfoDTO promoterInfoDTO = marginOpService.queryPromoterInfo(promoterId);
			MarginOpReqDOExample.Criteria criteria = query.createCriteria();
			criteria.andPromoterIdEqualTo(promoterId);
			if ("listDivAdd".equalsIgnoreCase(currentListDiv))
				criteria.andOpTypeEqualTo(OpTypeEnums.ADD.code);
			else if ("listDivRedeem".equalsIgnoreCase(currentListDiv))
				criteria.andOpTypeEqualTo(OpTypeEnums.REDEEMED.code);

			query.setPageSize(10);
			query.setOrderByClause(" create_time desc ");
			List<MarginOpReqDO> marginOpReqList = this.marginOpService.pageQueryMarginTrans(query);
			model.put("marginOpReqList", marginOpReqList);
			model.put("query", query);
			model.put("currentListDiv", currentListDiv);
			MerchantBalanceDTO merchantBalance = this.accountQueryFacadeWrapper.queryMerchantBalance(user.getMemberId(),
					promoterInfoDTO.getPromoterType());
			model.put("merchantBalance", merchantBalance);
			// TODO:填充UES 加密
			payPwdInit(model);

			log.info(promoterInfoDTO.toString());
			model.put("promoterInfo", promoterInfoDTO);
			String currentRedeemMargin = marginOpService.queryCurrentRedeemMargin(promoterId);
			model.put("currentRedeemMargin", currentRedeemMargin);

			// T0新增 获取垫资类型
			LoaningTypeEnum type = LoaningTypeEnum
					.getLoaningTypeEnum(newt0PromoterService.getLoaningTypeByPromoterId(promoterId));
			model.put("loaningType", type == null ? -1 : type.getCode());

			// 追加且转账成功的金额
			BigDecimal amount = marginOpService.queryMarginOpReqSum(promoterId, OpTypeEnums.ADD.code,
					MarginOpAddEnums.TRANSFER_SUCCESS.code);
			model.put("amount", amount);
			model.put("fastSettleMargin", StringUtils.isBlank(promoterInfoDTO.getFastSettleMargin()) ? amount
					: amount.add(new BigDecimal(promoterInfoDTO.getFastSettleMargin())));

			if (type == null) {
				return "/main/fastsettle/additionalMargin";
			}
			// 获取保证金取回天数配置
			LoaningConfigBean configBean = loaningCongfigService.getLoaningConfigBeanByLoaningType(type);
			if (configBean == null) {
				return "/main/fastsettle/additionalMargin";
			}
			PromoterEO promoterEO = promoterDAO.queryPromoterByMcId(promoterId);
			if (promoterEO == null) {
				return "/main/fastsettle/additionalMargin";
			}
			// TODO 1、 LOANING_CONG_BY_MC_TYPE
			configBean = loaningCongfigService.getLoaningConfigBeanByLoaningTypeMcType(configBean,
					promoterEO.getMcType());
			// 保底保证金取回时间（天）
			int minimumMarginRedeem = configBean.getMinimumMarginRedeem();
			// 浮动保证金取回时间（天）
			int marginRedeem = configBean.getMarginRedeem();
			long minimumMargin = configBean.getMinimumMargin();
			// 配置了特殊保底保证金
			WhiteListInfoDO whiteListInfo = this.whiteListInfoService.queryWhiteListInfo(
					WhiteTypeEnums.PROMOTER_MIN_MARGIN.code, promoterInfoDTO.getPromoterNo() + "",
					promoterInfoDTO.getPromoterType());
			if (whiteListInfo != null && StringUtils.isNotBlank(whiteListInfo.getContent())) {
				minimumMargin = new Long(whiteListInfo.getContent());
			}
			model.put("minimumMargin", minimumMargin);
			model.put("minimumMarginRedeem", minimumMarginRedeem);
			model.put("marginRedeem", marginRedeem);
		} catch (Exception e) {
			log.error("POSAgentAction.additionalMargin.merchantMemberId=" + user.getMemberId(), e);
		}
		return "/main/fastsettle/additionalMargin";
	}

	/**
	 * 追加保证金操作
	 **/
	@RequestMapping(value = "/additionalMargin/add")
	@ResponseBody
	public ErrorMessageVO additionalMargin(AddMarginReqDTO addMarginReqDTO, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		String promoterType = request.getParameter("promoterType");
		if (StringUtils.isBlank(promoterType)) {
			promoterType = user.getCurrentMcType();
		}
		Long promoterId = user.getPromoterId();
		ViewPromoterInfoDTO viewPromoterInfoDTO = null;
		if (PosMerchantTypeEnums.EASYPAY_PROMOTER.code.equals(promoterType)) {
			viewPromoterInfoDTO = promoterInfoService.queryPromoterInfo(user.getMerchantNo(), promoterType);
			if (viewPromoterInfoDTO != null) {
				promoterId = viewPromoterInfoDTO.getPromoterId();
			} else {
				return new ErrorMessageVO(false, null, MerchantCreditConstant.MC_NOPERMISSION_EXCEPTION);
			}
		}
		try {
			PromoterFastSettleSwitchDO pfss = this.promoterFastSettleSwitch
					.queryPromoterFastSettleSwitchByPromoterId(user.getPromoterId());
			if (pfss != null
					&& (OpTypeEnums.CLOSE.code == pfss.getType() || StringUtils.isEmpty(pfss.getMarginAccount()))) {
				// 开通记录为空，正在执行关闭操作，储值账户未开通，不能操作并提示弹框
				log.info("POSAgentAction #additionalMargin,promoterId:" + promoterId + " is closing fastsettle.");
				return new ErrorMessageVO(false, null, "对不起，您还未开通快速结算服务功能，请先开通");
			}

			BigDecimal amount = new BigDecimal(addMarginReqDTO.getAmount().trim());
			// 暂时不限定
			/*
			 * if(amount.compareTo(new BigDecimal(10000))<0){ return new
			 * ErrorMessageVO(false, null, "对不起，您单笔追加保证金的金额不能低于10000"); }
			 */
			ErrorMessageVO errorMessage = checkMarginSecPwd(user, addMarginReqDTO, request);
			if (!errorMessage.isSuccess())
				return new ErrorMessageVO(false, null, errorMessage.getErrorMessage());

			return marginOpService.validateAndAddMargin(promoterId, amount, OpTypeEnums.ADD, user.getMemberId(), false,
					user.getAdminLoginName());

		} catch (Exception e) {
			log.error("POSAgentAction.additionalMargin.error,addMarginReq="
					+ ToStringBuilder.reflectionToString(addMarginReqDTO), e);
			return new ErrorMessageVO(false, null, MerchantCreditConstant.MC_MARGIN_ADD_EXCEPTION);
		}
	}

	/**
	 * 退回保证金操作 前台退回保证金
	 **/
	@RequestMapping(value = "/redeemMargin/redeem")
	@ResponseBody
	public ErrorMessageVO redeemMargin(AddMarginReqDTO addMarginReqDTO, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		try {
			BigDecimal amount = new BigDecimal(addMarginReqDTO.getAmount().trim());
			if (amount.compareTo(new BigDecimal("0.01")) < 0) {
				return new ErrorMessageVO(false, null, "输入金额错误，请重新输入取回金额。金额必须大于0.01元");
			}
			MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
			String promoterType = request.getParameter("promoterType");
			if (StringUtils.isBlank(promoterType)) {
				promoterType = user.getCurrentMcType();
			}
			Long promoterId = user.getPromoterId();
			ViewPromoterInfoDTO viewPromoterInfoDTO = null;
			if (PosMerchantTypeEnums.EASYPAY_PROMOTER.code.equals(promoterType)) {
				viewPromoterInfoDTO = promoterInfoService.queryPromoterInfo(user.getMerchantNo(), promoterType);
				if (viewPromoterInfoDTO != null) {
					promoterId = viewPromoterInfoDTO.getPromoterId();
				} else {
					return new ErrorMessageVO(false, null, MerchantCreditConstant.MC_NOPERMISSION_EXCEPTION);
				}
			}
			ErrorMessageVO errorMessage = checkMarginSecPwd(user, addMarginReqDTO, request);
			if (!errorMessage.isSuccess()) {
				return new ErrorMessageVO(false, null, errorMessage.getErrorMessage());
			}

			return marginOpService.validateAndRedeemMargin(promoterId, amount, OpTypeEnums.REDEEMED, user.getMemberId(),
					false, user.getAdminLoginName());

		} catch (Exception e) {
			log.error("redeemMargin Exception" + e.getMessage(), e);
			return new ErrorMessageVO(false, null, MerchantCreditConstant.MC_MARGIN_REDEEM_EXCEPTION);
		}
	}

	/**
	 * 到商户查询页面
	 */
	/*
	 * @RequestMapping(value = "/toQueryPosMerchant") public String
	 * toQueryPosMerchant(HttpServletRequest request, HttpServletResponse
	 * response, ModelMap model) { MCMerchantUser user =
	 * MCMerchantUser.getMCMerchantUser(request.getSession()); Long promoterId =
	 * user.getPromoterId(); PromoterInfoDTO promoterInfoDTO =
	 * mspFacade.findPromoterInfoByPromoterId(promoterId); if
	 * (Integer.parseInt(MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN) !=
	 * promoterInfoDTO.getFastSettleFlag()) { model.put("msg",
	 * "很抱歉，您还没有开通快速结算服务，请先开通！"); return "/main/fastsettle/empty4Promoter"; }
	 * Integer loaningType =
	 * newt0PromoterService.getLoaningTypeByPromoterId(promoterId); if
	 * (loaningType == null) { boolean b = auditInfoService.hasNonAudited(null,
	 * user.getPromoterId(), OpTypeEnums.ADD.getCode());// 追加通过追加状态判断 if (b) {
	 * model.put("msg", "正在审核中，如有疑问请联系盛付通商务BD."); } else { model.put("msg",
	 * "请尽快追加保证金，以便使用快速结算服务."); } return "/main/fastsettle/empty4Promoter"; }
	 * return "/main/fastsettle/queryPosMerchant"; }
	 */

	/**
	 * 结算商户管理页面
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toQueryPosMerchant")
	public String toQueryPosMerchant(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		String promoterType = request.getParameter("promoterType");
		if (StringUtils.isBlank(promoterType)) {
			promoterType = user.getCurrentMcType();
		}
		Long promoterId = user.getPromoterId();
		ViewPromoterInfoDTO viewPromoterInfoDTO = null;
		if (PosMerchantTypeEnums.EASYPAY_PROMOTER.code.equals(promoterType)) {
			viewPromoterInfoDTO = promoterInfoService.queryPromoterInfo(user.getMerchantNo(), promoterType);
			if (viewPromoterInfoDTO != null) {
				promoterId = viewPromoterInfoDTO.getPromoterId();
				model.put("promoterType", promoterType);
			} else {
				model.put("msgCode", "3");
				return "/main/fastsettle/fastSettleIndex";
			}
		}
		ViewPromoterInfoDTO promoterInfo = promoterInfoService.queryPromoterById(promoterId);
		model.put("promoterInfo", promoterInfo);
		if (!user.getIsMposPartnerPromoterType()) {
			if (Integer.parseInt(MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN) != promoterInfo.getPromoterFsFlag()) {
				model.put("msg", "很抱歉，您还没有开通快速结算服务，请先开通！");
				return "/main/fastsettle/empty4Promoter";
			}
			Integer loaningType = promoterInfo.getLoaningType();
			if (loaningType == null) {
				boolean b = auditInfoService.hasNonAudited(null, promoterId, OpTypeEnums.ADD.getCode());// 追加通过追加状态判断
				if (b) {
					model.put("msg", "正在审核中，如有疑问请联系盛付通商务BD.");
				} else {
					model.put("msg", "请尽快追加保证金，以便使用快速结算服务.");
				}
				return "/main/fastsettle/empty4Promoter";
			}
		}
		return "/main/fastsettle/querySettlePosMerchant";
	}

	/**
	 * 到商户查询页面--ajax 分页查询
	 **/
	/*
	 * @RequestMapping(value = "/ajaxPaging/queryPosMerchant") public String
	 * queryPosMerchant(@ModelAttribute("query") PmtQueryPosMerchantPO query,
	 * HttpServletRequest request, HttpServletResponse response, ModelMap model)
	 * { MCMerchantUser user =
	 * MCMerchantUser.getMCMerchantUser(request.getSession());
	 * PmtQueryPosMerchantPO po = this.buildPmtQueryPosMerchantPO(query, user);
	 * PaginationBaseObject<MspPosMerchantRO> pager =
	 * this.posMerchantService.pagingPmtQueryPosMerchant(po); model.put("query",
	 * pager); return "/main/fastsettle/queryPosMerchantList"; }
	 */

	/**
	 * 结算商户查询
	 *
	 * @param query
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ajaxPaging/queryPosMerchant")
	public String queryPosMerchant(@ModelAttribute("query") SettleMerchantDTO query, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		String promoterType = request.getParameter("promoterType");
		if (StringUtils.isBlank(promoterType)) {
			promoterType = user.getCurrentMcType();
		}
		Long promoterId = user.getPromoterId();
		ViewPromoterInfoDTO viewPromoterInfoDTO = null;
		if (PosMerchantTypeEnums.EASYPAY_PROMOTER.code.equals(promoterType)) {
			viewPromoterInfoDTO = promoterInfoService.queryPromoterInfo(user.getMerchantNo(), promoterType);
			if (viewPromoterInfoDTO != null) {
				promoterId = viewPromoterInfoDTO.getPromoterId();
			} else {
				model.put("msgCode", "3");
				return "/main/fastsettle/fastSettleIndex";
			}
		}
		ViewPromoterInfoDTO promoterInfo = promoterInfoService.queryPromoterById(promoterId);
		query.setPromoterBizId(promoterInfo.getPromoterBizId().toString());
		if (user.getIsMposPartnerPromoterType()) {
			query.setPartnerFlag(MerchantCreditConstant.STRING_TRUE);
		}
		model.put("promoterInfo", promoterInfo);
		SettleMerchantDplDTO responseDto = scSettleBaseService.getSettleMerchantInfoAPI().queryByPage(query);
		model.put("dataList", responseDto.getSettleMerchantDatas());
		model.put("query", responseDto);
		return "/main/fastsettle/querySettlePosMerchantList";
	}

	/**
	 * 结算商户提现管理下载
	 *
	 * @param query
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/settleMerchantInfo/downloads.do")
	public String settleMerchantInfoDownloads(@ModelAttribute("query") SettleMerchantDTO query,
			HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		log.info("settleMerchantInfoDownloads,{}",
				ToStringBuilder.reflectionToString(query, ToStringStyle.SHORT_PREFIX_STYLE));
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		String promoterType = request.getParameter("promoterType");
		if (StringUtils.isBlank(promoterType)) {
			promoterType = user.getCurrentMcType();
		}
		Long promoterId = user.getPromoterId();
		ViewPromoterInfoDTO viewPromoterInfoDTO = null;
		if (PosMerchantTypeEnums.EASYPAY_PROMOTER.code.equals(promoterType)) {
			viewPromoterInfoDTO = promoterInfoService.queryPromoterInfo(user.getMerchantNo(), promoterType);
			if (viewPromoterInfoDTO != null) {
				promoterId = viewPromoterInfoDTO.getPromoterId();
			} else {
				model.put("msgCode", "3");
				return "/main/fastsettle/fastSettleIndex";
			}
		}
		ViewPromoterInfoDTO promoterInfo = promoterInfoService.queryPromoterById(promoterId);
		query.setPromoterBizId(promoterInfo.getPromoterBizId().toString());
		query.setPromoterNo(promoterInfo.getPromoterMerchantNo());
		query.setPromoterType(promoterInfo.getPromoterType());
		if (user.getIsMposPartnerPromoterType()) {
			query.setPartnerFlag(MerchantCreditConstant.STRING_TRUE);
		}
		model.put("promoterInfo", promoterInfo);
		SettleMerchantDplDTO responseDto = scSettleBaseService.getSettleMerchantInfoAPI().downloads2Info(query);
		log.info("settleMerchantInfoDownloads,{}",
				ToStringBuilder.reflectionToString(responseDto, ToStringStyle.SHORT_PREFIX_STYLE));
		String fileKey = responseDto.getFileKey();
		String fileName = responseDto.getFileName();
		fileDownloadsView(fileKey, fileName, response, CONTENT_TYPE);
		return null;
	}

	/*
	 * private PmtQueryPosMerchantPO
	 * buildPmtQueryPosMerchantPO(PmtQueryPosMerchantPO query, MCMerchantUser
	 * user) { PmtQueryPosMerchantPO po = new PmtQueryPosMerchantPO();
	 * BeanUtils.copyProperties(query, po);
	 * po.setPmtMerchantNo(user.getMerchantNo());
	 * po.setPmtMemberId(user.getMemberId()); if
	 * (MerchantContractCst.TYPE_PROMOTER.equals(user.getCurrentMcType())) {
	 * po.setType(MerchantContractCst.TYPE_POS_MERCHANT); } else if
	 * (MerchantContractCst.TYPE_MPOS_PROMOTER.equals(user.getCurrentMcType()))
	 * { po.setType(MerchantContractCst.TYPE_MPOS_MERCHANT); } //
	 * po.setType(MerchantContractCst.TYPE_POS_MERCHANT); return po; }
	 */

	/**
	 * 到商户费率、快速结算开关、额度修改页面,即T+0配置页面
	 **/
	@RequestMapping(value = "/initPosMerchantSettings")
	public String initPosMerchantSettings(Long merchantId, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		try {
			MerchantInfoDTO merchantInfoDTO = mspFacade.findMerchantInfoByMerchantId(merchantId);
			ViewMerchantInfoDTO merchantInfo = merchantInfoService.queryMerchantInfoByMerchantId(merchantId);
			if (merchantInfo == null) {
				model.put("msg", "商户信息不存在，请确认信息.");
				return "/main/fastsettle/empty4Promoter";
			}
			PolicyConfigInfoDO policyConfigInfoDO = null;
			if (PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(merchantInfo.getMcType())) {
				if (!StringUtils.isBlank(merchantInfo.getMerchantMcc())) {
					policyConfigInfoDO = policyConfigInfoService.queryPolicyConfigInfo(PolicyTypeEnums.MCC.type,
							merchantInfo.getMerchantMcc());
					if (policyConfigInfoDO == null) {
						model.put("msg", "商户类别不合法，请联系盛付通BD!");
						return "/main/fastsettle/empty4Promoter";
					}
				}
			} else if (PosMerchantTypeEnums.POS_MERCHANT.code.equals(merchantInfo.getMcType())) {
				String policyId = cmPosMerchantDAO.queryPosMerchantPolicyIdByMcId(merchantInfo.getMerchantId());
				if (!StringUtils.isBlank(policyId)) {
					policyConfigInfoDO = policyConfigInfoService.queryPolicyConfigInfo(policyId);
				}
			} else if (PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(merchantInfo.getMcType())&&StringUtils.isNotBlank(merchantInfo.getMerchantMcc())) {
					policyConfigInfoDO = policyConfigInfoService.queryPolicyConfigInfo(PolicyTypeEnums.EASYPAY.type,
							merchantInfo.getMerchantMcc());
			}
			// 查询垫资类型
			MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
			String promoterType = request.getParameter("promoterType");
			model.put("promoterType", promoterType);
			Integer loaningType = merchantInfo.getLoaningType();
			if (loaningType == null) {// -----------------待处理---------------------------------------------
				boolean b = auditInfoService.hasNonAudited(null, merchantInfo.getPromoterId(),
						OpTypeEnums.ADD.getCode());// 追加通过追加状态判断
				if (b) {
					model.put("msg", "正在审核中，如有疑问请联系盛付通商务BD.");
				} else {
					model.put("msg", "请尽快追加保证金，以便使用快速结算服务.");
				}
				return "/main/fastsettle/empty4Promoter";
			}
			if (MerchantContractCst.TYPE_MPOS_MERCHANT.equals(merchantInfo.getMcType())) {
				if (merchantInfo != null && StringUtils.isNotBlank(merchantInfo.getMerchantNo())) {
					String merchantNo = merchantInfo.getMerchantNo();
					String merchantType = merchantInfo.getMcType();
					// 判断是否实名认证
					boolean isRealNameAuthentication = true;
					isRealNameAuthentication = mcManagerService.isRealNameAuthentication(merchantNo, merchantType);
					if (!isRealNameAuthentication) {
						model.put("msg", "该商户不满足开通条件：未绑定提现银行卡。");
						return "/main/fastsettle/empty4Promoter";
					}
					// 如果商户的mcc信息需要信用认证
					if (WithdrawRatioStatusEnums.active.code == policyConfigInfoDO.getDependCreditAuthFlag()) {
						// 如果商户已开通t0
						if (merchantInfo.getMerchantFsFlag() == 0) {
							// 信用认证
							boolean isCreditAuthentication = mcManagerService.isCreditAuthentication(merchantNo);
							if (!isCreditAuthentication) {
								model.put("msg", "该商户不满足开通条件：未通过信用认证。");
								return "/main/fastsettle/empty4Promoter";
							}
						}
					}
					// 判断注册时间是否满足条件
					// boolean isSatisfyRegistrationDate = true;
					// isSatisfyRegistrationDate = mcManagerService.isSatisfyRegistrationDate(merchantNo, merchantType);
				} else {
					model.put("msg", "商户信息不存在，请核实.");
					return "/main/fastsettle/empty4Promoter";
				}
			} else if (PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(merchantInfo.getMcType())&&policyConfigInfoDO==null) {
				// 信用认证
				boolean isCreditAuthentication = mcManagerService
						.isEasypayMerchantCreditAuthentication(merchantInfo.getMerchantNo());
				if (!isCreditAuthentication) {
					model.put("msg", "该商户不满足开通条件：未完成信用卡认证（信用卡必须≥1张，借记卡、准贷记卡不属于信用卡）。");
					return "/main/fastsettle/empty4Promoter";
				}
			}
			model.put("merchantInfo", merchantInfo);
//			model.put("loaningType", loaningType);
			WithdrawRatioResult tomorrowEffectiveRatio = fastSettle
					.getTomorrowEffectiveRatio(merchantInfo.getMerchantNo(), merchantInfo.getMcType());
			if (tomorrowEffectiveRatio != null) {
				model.put("tomorrowEffectiveRatio", tomorrowEffectiveRatio);
			}

			FastSettleConfigDO fastSettleConfigDO = fastSettleConfigService.getFastSettleConfig(merchantId);
			if (fastSettleConfigDO != null) {
				model.put("fastSettleConfig", fastSettleConfigDO);
			}
			LoaningTypeEnum loaningTypeEnum = LoaningTypeEnum.getLoaningTypeEnum(loaningType);
			LoaningConfigBean loaningConfigBean = loaningCongfigService.getLoaningConfigBean(loaningType,
					merchantInfo.getPromoterType());
			//配置项额度
			BigDecimal suggestMaxAmount = policyConfigInfoDO != null && policyConfigInfoDO.getFastSettleLimit() != null && policyConfigInfoDO.getFastSettleLimit().compareTo(BigDecimal.ZERO) > 0
					? policyConfigInfoDO.getFastSettleLimit() : merchantLimitRuleService.queryMerchantCurrentMerchantLimitRule(merchantInfo.getPromoterMerchantNo(), merchantInfo.getPromoterType());
			model.put("suggestMaxAmount", suggestMaxAmount);
			model.put("suggestMinAmount", loaningConfigBean.getFloorAmt());
			if (LoaningTypeEnum.SHENGPAY == loaningTypeEnum) {
				model.put("fsLimit", merchantInfo.getMerchantFsLimit() == null
						|| BigDecimal.ZERO.compareTo(merchantInfo.getMerchantFsLimit()) == 0
								? suggestMaxAmount : merchantInfo.getMerchantFsLimit());
				model.put("fsLimitMax", merchantInfo.getMerchantFsLimit() == null
						|| BigDecimal.ZERO.compareTo(merchantInfo.getMerchantFsLimit()) == 0
								? suggestMaxAmount : merchantInfo.getMerchantFsLimit());
				// 校验商户是否是直连银行
				if (merchantInfo.getMcType().equals(MerchantContractCst.TYPE_POS_MERCHANT)) {
					// 校验商户是否是直连银行
					if (merchantInfo.getMerchantFsFlag() != null && MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN
							.equals(merchantInfo.getMerchantFsFlag().toString())) {
						ErrorMessageVO<Object> errorMessage = this.mspFacade
								.isSupportDirect2Bank4ShengPay(merchantInfo.getMerchantNo());
						if (!errorMessage.isSuccess()) {
							model.put("errorMessage", errorMessage.getErrorMessage());
							model.put("notDirect2Bank4ShengPay", true);
						}
					}
				} else if (PosMerchantTypeEnums.POS_MERCHANT.code.equals(merchantInfo.getMcType())) {
					ErrorMessageVO<Object> eroVo = this.mspFacade.authQuery(merchantInfo.getMerchantNo(), "ZF910");
					if (!eroVo.isSuccess()) {
						model.put("errorMessage", eroVo.getErrorMessage());
						model.put("notDirect2Bank4ShengPay", true);
					}
				}
			} else if (LoaningTypeEnum.PROMOTER == loaningTypeEnum) {
				model.put("fsLimit", merchantInfo.getMerchantFsLimit());
			}
			if (loaningConfigBean != null) {
					// 如果pos商户,先取政策配置信息费率,政策配置如果没有,取白名单配置费率,其次是全局配置费率
				if (PosMerchantTypeEnums.POS_MERCHANT.code.equals(merchantInfo.getMcType())||PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(merchantInfo.getMcType())) {
					if (policyConfigInfoDO != null) {
						if (policyConfigInfoDO.getHolidayRatio() == null
								|| StringUtils.isBlank(policyConfigInfoDO.getHolidayRatio().toString())) {
							String[] holidayFees = loaningConfigBean.getHolidayFees();
							policyConfigInfoDO.setHolidayRatio(new BigDecimal(holidayFees[0]));
						}
						if (policyConfigInfoDO.getWorkdayRatio() == null
								|| StringUtils.isBlank(policyConfigInfoDO.getWorkdayRatio().toString())) {
							String[] workdayFees = loaningConfigBean.getWorkdayFees();
							policyConfigInfoDO.setWorkdayRatio(new BigDecimal(workdayFees[0]));
						}
						String[] strWorkdayRatio = new String[] { policyConfigInfoDO.getWorkdayRatio().toString() };
						String[] strHolidayRatio = new String[] { policyConfigInfoDO.getHolidayRatio().toString() };
						loaningConfigBean.setWorkdayFees(strWorkdayRatio);
						loaningConfigBean.setHolidayFees(strHolidayRatio);
					} else {
						WhiteListFeeBean bean = this.whiteListInfoService.queryWhiteFee(WhiteTypeEnums.FEE.code,
								merchantInfo.getMerchantNo(), merchantInfo.getMcType());
						if (bean == null) {
							bean = this.whiteListInfoService.queryWhiteFee(WhiteTypeEnums.FEE.code,
									merchantInfo.getPromoterMerchantNo(), merchantInfo.getPromoterType());
						}
						if (bean != null) {
							loaningConfigBean.setHolidayFees(bean.getHolidayFees());
							loaningConfigBean.setWorkdayFees(bean.getWorkdayFees());
						}
					}
					// 如果mpos商户,先取mcc配置信息费率,mcc配置如果没有,取全局配置费率
				} else if (PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(merchantInfo.getMcType())) {
					if (policyConfigInfoDO != null) {
						if (policyConfigInfoDO.getHolidayRatio() == null
								|| StringUtils.isBlank(policyConfigInfoDO.getHolidayRatio().toString())) {
							String[] holidayFees = loaningConfigBean.getHolidayFees();
							policyConfigInfoDO.setHolidayRatio(new BigDecimal(holidayFees[0]));
						}
						if (policyConfigInfoDO.getWorkdayRatio() == null
								|| StringUtils.isBlank(policyConfigInfoDO.getWorkdayRatio().toString())) {
							String[] workdayFees = loaningConfigBean.getWorkdayFees();
							policyConfigInfoDO.setWorkdayRatio(new BigDecimal(workdayFees[0]));
						}
						String[] strWorkdayRatio = new String[] { policyConfigInfoDO.getWorkdayRatio().toString() };
						String[] strHolidayRatio = new String[] { policyConfigInfoDO.getHolidayRatio().toString() };
						loaningConfigBean.setWorkdayFees(strWorkdayRatio);
						loaningConfigBean.setHolidayFees(strHolidayRatio);
					}
				}

				model.put("loaningConfigBean", loaningConfigBean);
			}
			// 查询提现费用
			BigDecimal withdrawCost = withdrawCostConfigService.queryMerchantCurrentWithdrawCostConfig(
					merchantInfo.getMerchantNo(), merchantInfo.getMcType(), merchantInfo.getPromoterMerchantNo(),
					merchantInfo.getPromoterType(), merchantInfo.getMerchantMcc());
			model.put("wdCost", withdrawCost.compareTo(BigDecimal.ZERO) == 1 ? "+" + withdrawCost + "元" : "");
			WithdrawRatioResult currentEffectiveRatio = fastSettle.getCurrentEffectiveRatio(merchantInfo.getMerchantNo(), merchantInfo.getMcType());
			if(currentEffectiveRatio!=null){
				model.put("currentEffectiveRatio", currentEffectiveRatio);
				if(currentEffectiveRatio.getWorkDayWithDrawRatio()!=null&&!isContain(currentEffectiveRatio.getWorkDayWithDrawRatio().toString(),loaningConfigBean.getWorkdayFees())){
					model.put("workdayFee", currentEffectiveRatio.getWorkDayWithDrawRatio());
				}
				if(currentEffectiveRatio.getHolidayWithDrawRatio()!=null&&!isContain(currentEffectiveRatio.getHolidayWithDrawRatio().toString(),loaningConfigBean.getHolidayFees())){
					model.put("holidayFee", currentEffectiveRatio.getHolidayWithDrawRatio());
				}
			}
		} catch (Exception e) {
			log.error("POSAgentAction.initPosMerchantSettings.error,addMarginReq,merchantId=" + merchantId, e);
		}
		return "/main/fastsettle/initPosMerchantSettings";
	}

	private boolean isContain(String fastSettleFee, String[] fees) {
		if (fees != null && fees.length > 0) {
			for (String fee : fees) {
				if (fee != null && fee.equals(fastSettleFee)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 保存商户T+0配置
	 **/
	@RequestMapping(value = "/savePosMerchantSettings")
	@ResponseBody
	public ErrorMessageVO<Object> savePosMerchantSettings(MerchantFastSettleVO fastSettleVO, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		try {
			log.info("POSAgentAction #savePosMerchantSettings fastSettleVO:"
					+ ToStringBuilder.reflectionToString(fastSettleVO));
			MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
			ViewMerchantInfoDTO merchantInfo = merchantInfoService.queryMerchantInfoByMerchantId(Long.parseLong(fastSettleVO.getMerchantId()));
			if (merchantInfo == null) {
				return new ErrorMessageVO<Object>(false, null, "很抱歉，商户信息查询繁忙，请稍后再试！");
			}
			PromoterInfoDTO promoterInfoDTO = mspFacade.findPromoterInfoByPromoterId(merchantInfo.getPromoterId());
			String orFastSettleLimit = request.getParameter("fsLimitMax");
			String fastSettleLimit = fastSettleVO.getFastSettleLimit();
			PolicyConfigInfoDO policyConfigInfoDO = null;
			if (PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(merchantInfo.getMcType())) {
				if (!StringUtils.isBlank(merchantInfo.getMerchantMcc())) {
					policyConfigInfoDO = policyConfigInfoService.queryPolicyConfigInfo(PolicyTypeEnums.MCC.type,
							merchantInfo.getMerchantMcc());
					if (policyConfigInfoDO == null) {
						return new ErrorMessageVO<Object>(false, null, "商户类型有误！");
					}
				}
			}else if(PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(merchantInfo.getMcType())&&StringUtils.isNotBlank(merchantInfo.getMerchantMcc())){
				policyConfigInfoDO = policyConfigInfoService.queryPolicyConfigInfo(PolicyTypeEnums.EASYPAY.type,
						merchantInfo.getMerchantMcc());
			}
			fastSettleVO.setPromoterId(merchantInfo.getPromoterId().toString());
			fastSettleVO.setObjType(OpObjTypeEnums.MERCHANT.getCode() + "");
			LoaningTypeEnum loaningTypeEnum = LoaningTypeEnum
					.getLoaningTypeEnum(newt0PromoterService.getLoaningTypeByPromoterId(merchantInfo.getPromoterId()));
			if (Integer.parseInt(MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN) != merchantInfo.getMerchantFsFlag()) {
				return new ErrorMessageVO<Object>(false, null, "很抱歉，您还没有开通快速结算服务，请先开通！");
			}

			fastSettleVO.setMerchantNo(merchantInfo.getMerchantNo());
			BigDecimal holidayFee = new BigDecimal(fastSettleVO.getHolidayFee());
			BigDecimal workdayFee = new BigDecimal(fastSettleVO.getWorkdayFee());
			fastSettleVO.setMcType(merchantInfo.getMcType());
			if (merchantInfo.getMcType().equals(MerchantContractCst.TYPE_MPOS_MERCHANT)) {
				if (StringUtils.isNotBlank(merchantInfo.getMerchantNo())) {
					String merchantNo = merchantInfo.getMerchantNo();
					String merchantType = merchantInfo.getMcType();

					if (fastSettleVO.getFastSettleFlag() != null && MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN
							.equals(fastSettleVO.getFastSettleFlag().trim())) {
						// 判断是否实名认证
						boolean isRealNameAuthentication = mcManagerService.isRealNameAuthentication(merchantNo,
								merchantType);
						if (!isRealNameAuthentication) {
							return new ErrorMessageVO<Object>(false, "-1", "该商户不满足开通条件：未完成信用认证或未绑定提现银行卡。");
						}
						if ("1".equals(fastSettleVO.getFastSettleFlag())) {
							if (WithdrawRatioStatusEnums.active.code == policyConfigInfoDO.getDependCreditAuthFlag()) {
								// 信用认证
								boolean isCreditAuthentication = mcManagerService.isCreditAuthentication(merchantNo);
								if (!isCreditAuthentication) {
									return new ErrorMessageVO<Object>(false, "-1", "该商户不满足开通条件：未完成信用认证。");
								}
							}
						}
						// 判断注册时间是否满足条件
						// boolean isSatisfyRegistrationDate = mcManagerService.isSatisfyRegistrationDate(merchantNo, merchantType);
					}
				} else {
					return new ErrorMessageVO<Object>(false, "-1", "商户信息不存在，请核实.");
				}
			} else if (PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(merchantInfo.getMcType())&&policyConfigInfoDO==null) {
				// 云收银信用认证
				boolean isCreditAuthentication = mcManagerService
						.isEasypayMerchantCreditAuthentication(merchantInfo.getMerchantNo());
				if (!isCreditAuthentication) {
					return new ErrorMessageVO<Object>(false, "-1", "该商户不满足开通条件：未完成信用认证或未绑定提现银行卡。");
				}
			}
			if (fastSettleVO.getFastSettleFlag() != null
					&& MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN.equals(fastSettleVO.getFastSettleFlag().trim())) {
				LoaningConfigBean loaningConfigBean = loaningCongfigService
						.getLoaningConfigBeanByLoaningType(loaningTypeEnum);
				loaningConfigBean = loaningCongfigService.getLoaningConfigBeanByLoaningTypeMcType(loaningConfigBean,
						merchantInfo.getPromoterType());
				if (loaningConfigBean == null) {
					return new ErrorMessageVO<Object>(false, "-1", "代理商垫资方类型配置信息不存在");
				}
				// MPOS 盛付通垫资 取风控建议值
				if (LoaningTypeEnum.SHENGPAY.code == loaningTypeEnum.code) {
					// 风控建议值
//					BigDecimal suggestAmount = new BigDecimal(request.getParameter("suggestMaxAmount"));
					BigDecimal suggestAmount = policyConfigInfoDO != null && policyConfigInfoDO.getFastSettleLimit() != null && policyConfigInfoDO.getFastSettleLimit().compareTo(BigDecimal.ZERO) > 0
							? policyConfigInfoDO.getFastSettleLimit() : merchantLimitRuleService.queryMerchantCurrentMerchantLimitRule(merchantInfo.getPromoterMerchantNo(), merchantInfo.getPromoterType());
					BigDecimal toOrFastSettleLimit = new BigDecimal(orFastSettleLimit);
					// 如果修改的额度有改变
					if (fastSettleLimit != null || !StringUtils.isBlank(fastSettleLimit)) {
						if (new BigDecimal(fastSettleLimit).compareTo(toOrFastSettleLimit) != 0) {
							if (new BigDecimal(fastSettleLimit).compareTo(loaningConfigBean.getFloorAmt()) < 0) {
								return new ErrorMessageVO<Object>(false, "-1", "单日最高额度不能低于" + loaningConfigBean.getFloorAmt() + "元");
							}
							if (new BigDecimal(fastSettleLimit).compareTo(suggestAmount) > 0) {
								return new ErrorMessageVO<Object>(false, "-1", "风控建议金额为" + suggestAmount + "元");
							}
						}
					} else {
						return new ErrorMessageVO<Object>(false, "-1", "规则额度不能为空！");
					}
					if (merchantInfo.getMcType().equals(MerchantContractCst.TYPE_POS_MERCHANT)) {
						// 校验商户是否是直连银行，盛付通全资的情况下是不能让未绑定实时出款银行的商户做快速结算的
						if (fastSettleVO.getFastSettleFlag() != null && MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN
								.equals(fastSettleVO.getFastSettleFlag().trim())) {
							ErrorMessageVO<Object> errorMessage = this.mspFacade
									.isSupportDirect2Bank4ShengPay(merchantInfo.getMerchantNo());
							if (!errorMessage.isSuccess()) {
								return errorMessage;
							}
						}
					} else {
						ErrorMessageVO<Object> eroVo = this.mspFacade.authQuery(merchantInfo.getMerchantNo(), "ZF910");
						if (!eroVo.isSuccess()) {
							return eroVo;
						}
					}
				}else if(LoaningTypeEnum.PROMOTER == loaningTypeEnum){
					//商户的额度不能大于代理商的额度
					if (new BigDecimal(fastSettleLimit).compareTo(merchantInfo.getPromoterFsLimit()) > 0) {
						return new ErrorMessageVO<Object>(false, "-1", "修改商户的单日最高额度不能大于代理商单日总额度！");
					}
				}

			}

			model.put("merchantInfo", merchantInfo);
			ErrorMessageVO<Object> messageVO = fastSettle.setMerchantFastSettleConfig(fastSettleVO,
					user.getAdminLoginName());
			return messageVO;
		} catch (Exception e) {
			log.error("POSAgentAction.savePosMerchantSettings.error,merchantId=" + fastSettleVO.getMerchantId(), e);
			return new ErrorMessageVO<Object>(false, "-1", "系统繁忙，请稍后再试");
		}
	}

	/**
	 * T0出款管理菜单--首页
	 **/
	@RequestMapping(value = "/withdrawIndex")
	public String transIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		log.info("withdrawIndex");
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		model.put("merchantNo", user.getMerchantNo());
		return "/main/fastsettle/withdrawIndex";
	}

	/**
	 * 提现对账单
	 **/

	@RequestMapping(value = "/ajaxPaging/withdrawInfoList")
	public String withdrawInfoList(@ModelAttribute("query") ExtWithdrawReqDOExample query, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		try {
			if (query != null && StringUtils.isNotBlank(query.getMerchantNo())) {
				if (StringUtils.isNotBlank(query.getStartCreateTimeStr())) {
					query.setStartCreateTime(DateUtil.str2Date(query.getStartCreateTimeStr()));
				}

				if (StringUtils.isNotBlank(query.getEndCreateTimeStr())) {
					query.setEndCreateTime(DateUtil.str2Date(query.getEndCreateTimeStr()));
				}
			} else {
				return "/main/fastsettle/withdrawInfoList";
			}
			query.setWithdrawType(Integer.parseInt(WithdrawConstant.withdrawTypeRealTime));
			query.setStatus(WithdrawReqStatusEnums.SUCCESS.code);
			List<ExtWithdrawReqVO> dataList = extWithdrawReqManager.selectWithdrawReqByQuery(query);
			for (ExtWithdrawReqVO extw : dataList) {
				if (extw.getWithdrawAmount() == null || extw.getWithdrawCost() == null) {
					log.error("NewT0IntraAction.withdrawInfoList.WithdrawAmount or WithdrawCost is null,WithdrawAmount:"
							+ extw.getWithdrawAmount() + ",WithdrawCost:" + extw.getWithdrawCost() + ",orderNo:"
							+ extw.getOrderNo());
				} else {
					extw.setBankAccountAmount(extw.getWithdrawAmount().subtract(extw.getTotalCost()));
				}
			}
			model.put("dataList", dataList);
			model.put("query", query);

		} catch (Exception e) {
			log.error("查询快速提现对账单繁忙，请稍后再试：" + e.getMessage(), e);
		}
		return "/main/fastsettle/withdrawInfoList";
	}

	@RequestMapping(value = "/withdrawDownload")
	@ResponseBody
	public void downloadExcel(@ModelAttribute("query") ExtWithdrawReqDOExample query, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		try {
			List<ExtWithdrawReqVO> dataList = new ArrayList<ExtWithdrawReqVO>();
			if (query != null) {
				if (StringUtils.isNotBlank(query.getMerchantNo())) {
					if (StringUtils.isNotBlank(query.getStartCreateTimeStr())) {
						query.setStartCreateTime(DateUtil.str2Date(query.getStartCreateTimeStr()));
					}

					if (StringUtils.isNotBlank(query.getEndCreateTimeStr())) {
						query.setEndCreateTime(DateUtil.str2Date(query.getEndCreateTimeStr()));
					}
				} else {
					doExcel(dataList, request, response);
				}
				query.setWithdrawType(Integer.parseInt(WithdrawConstant.withdrawTypeRealTime));
				query.setStatus(WithdrawReqStatusEnums.SUCCESS.code);
			}
			dataList = extWithdrawReqManager.selectWithdrawReqByQuery(query);
			model.put("query", query);
			for (ExtWithdrawReqVO extw : dataList) {
				if (extw.getWithdrawAmount() == null || extw.getWithdrawCost() == null) {
					log.error("NewT0IntraAction.withdrawInfoList.WithdrawAmount or WithdrawCost is null,WithdrawAmount:"
							+ extw.getWithdrawAmount() + ",WithdrawCost:" + extw.getWithdrawCost() + ",orderNo:"
							+ extw.getOrderNo());
				} else {
					extw.setBankAccountAmount(extw.getWithdrawAmount().subtract(extw.getTotalCost()));
				}
			}
			doExcel(dataList, request, response);
		} catch (Exception e) {
			log.error("POSAgentAction.downloadExcel error：" + e.getMessage(), e);
		}

	}

	/**
	 * 文件下载
	 */
	private void doExcel(List<ExtWithdrawReqVO> dataList, HttpServletRequest request, HttpServletResponse response) {
		String fileName = DateUtil.datefosOrderFormat(new Date()) + ".xls";// yyyyMMddHHmmss
		OutputStream os = null;
		Workbook book = null;
		try {
			// 输出流
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment;filename=" + fileName);
			os = response.getOutputStream();
			// 创建工作区(97-2003)
			book = new HSSFWorkbook();
			// 创建第一个sheet页
			Sheet sheet1 = book.createSheet("sheet1");

			// 单元格宽度
			sheet1.setDefaultColumnWidth(18);

			// 列头的样式
			HSSFCellStyle sheetStyle = (HSSFCellStyle) book.createCellStyle();
			// 左右居中
			sheetStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// 上下居中
			sheetStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			int rowindex = 0;

			String headers[] = "结算时间,结算金额,结算手续费	,结算成功时间,银行卡到账金额".split(",");
			// 设置字体
			HSSFFont columnHeadFont = (HSSFFont) book.createFont();
			columnHeadFont.setFontName("宋体");
			columnHeadFont.setFontHeightInPoints((short) 10);
			columnHeadFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			HSSFFont headfont = (HSSFFont) book.createFont();
			headfont.setFontName("黑体");
			headfont.setFontHeightInPoints((short) 22);// 字体大小
			headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗

			sheetStyle.setFont(columnHeadFont);

			Row row_a = sheet1.createRow(rowindex++);
			for (int hi = 0; hi < headers.length; hi++) {
				// 表头，hi：第几列
				row_a.setHeightInPoints(30);// 设置行高50
				HSSFCell cellhead = (HSSFCell) row_a.createCell(hi);// 每一列单元格
				cellhead.setCellValue(headers[hi]);
				cellhead.setCellStyle(sheetStyle);
			}

			// 单元行样式
			HSSFCellStyle columnHeadStyle = (HSSFCellStyle) book.createCellStyle();
			// 设置字体
			HSSFFont rowFont = (HSSFFont) book.createFont();
			columnHeadFont.setFontName("宋体");
			columnHeadFont.setFontHeightInPoints((short) 10);
			columnHeadFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			columnHeadStyle.setFont(rowFont);
			columnHeadStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
			columnHeadStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中

			for (ExtWithdrawReqVO model : dataList) {
				Row rown = sheet1.createRow(rowindex++);
				rown.setHeightInPoints(30);// 设置行高50
				// 创建每一列单元格样式
				HSSFCell cellhead0 = (HSSFCell) rown.createCell(0); // 每一列单元格
				HSSFCell cellhead1 = (HSSFCell) rown.createCell(1); // 每一列单元格
				HSSFCell cellhead2 = (HSSFCell) rown.createCell(2); // 每一列单元格
				HSSFCell cellhead3 = (HSSFCell) rown.createCell(3); // 每一列单元格
				HSSFCell cellhead4 = (HSSFCell) rown.createCell(4); // 每一列单元格

				/** 每一列单元格样式 **/
				cellhead0.setCellStyle(columnHeadStyle);
				cellhead1.setCellStyle(columnHeadStyle);
				cellhead2.setCellStyle(columnHeadStyle);
				cellhead3.setCellStyle(columnHeadStyle);
				cellhead4.setCellStyle(columnHeadStyle);
				/** 每一列单元格值 **/
				if (model.getCreateTime() != null) {
					cellhead0.setCellValue(DateUtil.dateFormat4(model.getCreateTime()));
				} else {
					cellhead0.setCellValue("");
				}
				cellhead1.setCellValue(model.getWithdrawAmount() + "");
				cellhead2.setCellValue(model.getWithdrawCost() + "");
				if (model.getWithdrawTime() != null) {
					cellhead3.setCellValue(DateUtil.dateFormat4(model.getWithdrawTime()));
				} else {
					cellhead3.setCellValue("");
				}
				cellhead4.setCellValue(model.getBankAccountAmount() + "");
			}

			// 写文件
			book.write(os);
			os.flush();
		} catch (Exception e) {
			log.error("文件生成异常：" + e.getMessage());
		} finally {
			// 关闭输出流
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				log.error("OutputStream关闭异常：" + e.getMessage());
			}
		}

	}

	/**
	 * 商户快速出款记录菜单--首页
	 **/
	@RequestMapping(value = "/merchantFastsettle/index")
	public String fastsettleIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		String promoterType = request.getParameter("promoterType");
		Long promoterId = user.getPromoterId();
		ViewPromoterInfoDTO viewPromoterInfoDTO = null;
		if (PosMerchantTypeEnums.EASYPAY_PROMOTER.code.equals(promoterType)) {
			viewPromoterInfoDTO = promoterInfoService.queryPromoterInfo(user.getMerchantNo(), promoterType);
			if (viewPromoterInfoDTO != null) {
				promoterId = viewPromoterInfoDTO.getPromoterId();
				model.put("promoterType", promoterType);
			} else {
				model.put("msgCode", "3");
				return "/main/fastsettle/fastSettleIndex";
			}
		}
		// PromoterInfoDTO promoterInfoDTO =
		// mspFacade.findPromoterInfoByPromoterId(user.getPromoterId());
		ViewPromoterInfoDTO promoterInfoDTO = promoterInfoService.queryPromoterById(promoterId);
		if (promoterInfoDTO != null) {
			model.put("promoterNo", promoterInfoDTO.getPromoterMerchantNo());
			model.put("promoterId", promoterInfoDTO.getPromoterId());
			if (StringUtils.isNotBlank(promoterInfoDTO.getPromoterType())
					&& promoterInfoDTO.getPromoterType().equals(PosMerchantTypeEnums.POS_PROMOTER.code)) {
				model.put("pmtType", promoterInfoDTO.getPromoterType());
				return "/main/fastsettle/posFastsettleIndex";
			} else if (StringUtils.isNotBlank(promoterInfoDTO.getPromoterType())
					&& promoterInfoDTO.getPromoterType().equals(PosMerchantTypeEnums.MPOS_PROMOTER.code)) {
				model.put("pmtType", promoterInfoDTO.getPromoterType());
				return "/main/fastsettle/mposFastsettleIndex";
			} else if (StringUtils.isNotBlank(promoterInfoDTO.getPromoterType())
					&& promoterInfoDTO.getPromoterType().equals(PosMerchantTypeEnums.EASYPAY_PROMOTER.code)) {
				model.put("pmtType", promoterInfoDTO.getPromoterType());
				return "/main/fastsettle/posFastsettleIndex";
			} else {
				log.error("fastsettleIndex.PromoterType is error,PromoterId:" + promoterId + "PromoterType:"
						+ promoterInfoDTO.getPromoterType());
			}
		} else {
			log.error("fastsettleIndex.promoterInfoDTO is null,PromoterId:" + promoterId);
		}
		return "/main/fastsettle/posFastsettleIndex";
	}

	/**
	 * 商户快速出款记录
	 **/

	@RequestMapping(value = "/merchantFastsettle/fastsettleList")
	public String fastsettleList(@ModelAttribute("query") ExtWithdrawReqDOExample query, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		log.info("fastsettleList query init");
		long time = System.currentTimeMillis();
		try {
			if (query != null && StringUtils.isNotBlank(query.getPromoterNo())
					&& StringUtils.isNotBlank(query.getPmtType())) {
				if (StringUtils.isNotBlank(query.getStartCreateTimeStr())) {
					query.setStartCreateTime(DateUtil.str2Date(query.getStartCreateTimeStr()));
				}

				if (StringUtils.isNotBlank(query.getEndCreateTimeStr())) {
					query.setEndCreateTime(DateUtil.str2Date(query.getEndCreateTimeStr()));
				}
			} else {
				log.error("由于您离开时间过长，请重新登录，谢谢");
				return "/main/fastsettle/posFastsettleList";
			}
			List<ExtWithdrawReqVO> dataList = extWithdrawReqManager.selectMerchantFastsettleByQuery(query);
			for (ExtWithdrawReqVO extw : dataList) {

				if (extw.getWithdrawAmount() == null || extw.getWithdrawCost() == null) {
					log.error("NewT0IntraAction.withdrawInfoList.WithdrawAmount or WithdrawCost is null,WithdrawAmount:"
							+ extw.getWithdrawAmount() + ",WithdrawCost:" + extw.getWithdrawCost() + ",orderNo:"
							+ extw.getOrderNo());
				} else {
					extw.setBankAccountAmount(extw.getWithdrawAmount().subtract(extw.getTotalCost()));
				}
			}
			model.put("dataList", dataList);
			model.put("query", query);
			log.info("fastsettleList query end,use time:" + (System.currentTimeMillis() - time));
		} catch (Exception e) {
			// e.printStackTrace();
			log.error("查询快速提现对账单繁忙，请稍后再试：" + e.getMessage(), e);
		}
		return "/main/fastsettle/posFastsettleList";
	}

	/**
	 * mpos商户提现记录查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/merchantFastsettle/mcfastsettleList")
	public String mcfastsettleList(@ModelAttribute("query") ExtWithdrawReqDOExample query, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		log.info("fastsettleList query init");
		long time = System.currentTimeMillis();
		try {
			if (query != null && StringUtils.isNotBlank(query.getPromoterNo())
					&& StringUtils.isNotBlank(query.getPmtType())) {
				if (StringUtils.isNotBlank(query.getStartCreateTimeStr())) {
					query.setStartCreateTime(DateUtil.str2Date(query.getStartCreateTimeStr()));
				}

				if (StringUtils.isNotBlank(query.getEndCreateTimeStr())) {
					query.setEndCreateTime(DateUtil.str2Date(query.getEndCreateTimeStr()));
				}
				if (StringUtils.isNotBlank(query.getStartWithdrawTimeStr())) {
					query.setStartWithdrawTime(DateUtil.str2Date(query.getStartWithdrawTimeStr()));
				}

				if (StringUtils.isNotBlank(query.getEndWithdrawTimeStr())) {
					query.setEndWithdrawTime(DateUtil.str2Date(query.getEndWithdrawTimeStr()));
				}
			} else {
				log.error("由于您离开时间过长，请重新登录，谢谢");
				return "/main/fastsettle/posFastsettleList";
			}
			List<ExtWithdrawReqVO> dataList = extWithdrawReqManager.selectMerchantFastsettleByQuery(query);
			for (ExtWithdrawReqVO extw : dataList) {

				if (extw.getWithdrawAmount() == null || extw.getWithdrawCost() == null) {
					log.error("NewT0IntraAction.withdrawInfoList.WithdrawAmount or WithdrawCost is null,WithdrawAmount:"
							+ extw.getWithdrawAmount() + ",WithdrawCost:" + extw.getWithdrawCost() + ",orderNo:"
							+ extw.getOrderNo());
				} else {
					extw.setBankAccountAmount(extw.getWithdrawAmount().subtract(extw.getTotalCost()));
				}
			}
			model.put("dataList", dataList);
			model.put("query", query);
			log.info("fastsettleList query end,use time:" + (System.currentTimeMillis() - time));
		} catch (Exception e) {
			// e.printStackTrace();
			log.error("查询快速提现对账单繁忙，请稍后再试：" + e.getMessage(), e);
		}
		return "/main/fastsettle/mposFastsettleList";
	}

	/*
	 * 提现记录下载
	 */
	@RequestMapping(value = "/posfastSettleDownLoad")
	@ResponseBody
	public void posfastSettleDownLoad(@ModelAttribute("query") ExtWithdrawReqDOExample query,
			HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException {
		StringBuffer buff = new StringBuffer();
		if (query != null && StringUtils.isNotBlank(query.getPromoterNo())
				&& StringUtils.isNotBlank(query.getPmtType())) {
			if (StringUtils.isNotBlank(query.getStartCreateTimeStr())) {
				query.setStartCreateTime(DateUtil.str2Date(query.getStartCreateTimeStr()));
			}
			if (StringUtils.isNotBlank(query.getEndCreateTimeStr())) {
				query.setEndCreateTime(DateUtil.str2Date(query.getEndCreateTimeStr()));
			}
			query.setNeedQueryAll(true);
		}
		List<ExtWithdrawReqVO> dataList = extWithdrawReqManager.selectMerchantFastsettleByQuery(query);
		model.put("query", query);

		buff.append("出款发起时间,盛付通商户号,商户名称,出款类型,T0出款金额,总手续费,	T0手续费（x%部分）,T0手续费（x元部分）,银行卡到账金额,出款状态,出款成功时间,操作员\r\n");
		if (dataList.size() > 0) {
			for (ExtWithdrawReqVO doExt : dataList) {
				String rowData = getRowInfo(doExt);
				buff.append(rowData);
				buff.append("\r\n");
			}
		}
		//
		String fileName = "T0出款记录_" + DateUtil.date2Str(new Date(), DateUtil.dateFormat3);
		String zipfileName = fileName + ".zip";
		response.setContentType("application/octet-stream;charset=gbk");
		// response.setHeader("Content-Disposition", "attachment;filename=" +
		// URLEncoder.encode(zipfileName, "gbk"));
		response.setHeader("Content-disposition",
				"attachment; filename=" + new String(zipfileName.getBytes("gbk"), "ISO8859-1"));
		response.setBufferSize(10240);
		byte[] buffer = new byte[4096];// 缓冲区
		OutputStream out = response.getOutputStream();
		try {
			// 数据字节byteData
			byte[] byteData = buff.toString().getBytes("gbk");
			// 将byteDate 写byteZip
			byte[] byteZip = zip(byteData, fileName);
			// 将byeZip 转IO
			InputStream sbs = new ByteArrayInputStream(byteZip);
			// 将 byteZip 用out输出
			int rc = 0;
			while ((rc = sbs.read(buffer, 0, 4096)) > 0) {
				out.write(buffer, 0, rc);
			}
		} catch (Exception e) {
			log.error("POSAgentAction#mposfastSettleDownLoad error" + e.getMessage(), e);
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				log.error("POSAgentAction#mposfastSettleDownLoad final error" + e.getMessage(), e);
			}
		}
	}

	/**
	 * mpos页面提现记录下载
	 */
	@RequestMapping(value = "/mcfastSettleDownLoad")
	@ResponseBody
	public void mcfastSettleDownLoad(@ModelAttribute("query") ExtWithdrawReqDOExample query, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException {
		StringBuffer buff = new StringBuffer();
		if (query != null && StringUtils.isNotBlank(query.getPromoterNo())
				&& StringUtils.isNotBlank(query.getPmtType())) {
			if (StringUtils.isNotBlank(query.getStartCreateTimeStr())) {
				query.setStartCreateTime(DateUtil.str2Date(query.getStartCreateTimeStr()));
			}
			if (StringUtils.isNotBlank(query.getEndCreateTimeStr())) {
				query.setEndCreateTime(DateUtil.str2Date(query.getEndCreateTimeStr()));
			}
			if (StringUtils.isNotBlank(query.getStartWithdrawTimeStr())) {
				query.setStartWithdrawTime(DateUtil.str2Date(query.getStartWithdrawTimeStr()));
			}

			if (StringUtils.isNotBlank(query.getEndWithdrawTimeStr())) {
				query.setEndWithdrawTime(DateUtil.str2Date(query.getEndWithdrawTimeStr()));
			}
			query.setNeedQueryAll(true);
		}
		List<ExtWithdrawReqVO> dataList = extWithdrawReqManager.selectMerchantFastsettleByQuery(query);
		model.put("query", query);

		buff.append("提现时间,盛付通商户号,商户名称,商户类别,提现类型,提现金额,总手续费,提现费（x%部分）,提现费（x元部分）,银行卡到账金额,提现状态,提现成功时间,操作员\r\n");
		if (dataList.size() > 0) {
			for (ExtWithdrawReqVO doExt : dataList) {
				String rowData = getMcRowInfo(doExt);
				buff.append(rowData);
				buff.append("\r\n");
			}
		}
		//
		String fileName = "提现记录_" + DateUtil.date2Str(new Date(), DateUtil.dateFormat3);
		String zipfileName = fileName + ".zip";
		response.setContentType("application/octet-stream;charset=gbk");
		// response.setHeader("Content-Disposition", "attachment;filename=" +
		// URLEncoder.encode(zipfileName, "gbk"));
		response.setHeader("Content-disposition",
				"attachment; filename=" + new String(zipfileName.getBytes("gbk"), "ISO8859-1"));
		response.setBufferSize(10240);
		byte[] buffer = new byte[4096];// 缓冲区
		OutputStream out = response.getOutputStream();
		try {
			// 数据字节byteData
			byte[] byteData = buff.toString().getBytes("gbk");
			// 将byteDate 写byteZip
			byte[] byteZip = zip(byteData, fileName);
			// 将byeZip 转IO
			InputStream sbs = new ByteArrayInputStream(byteZip);
			// 将 byteZip 用out输出
			int rc = 0;
			while ((rc = sbs.read(buffer, 0, 4096)) > 0) {
				out.write(buffer, 0, rc);
			}
		} catch (Exception e) {
			log.error("POSAgentAction#mposfastSettleDownLoad error" + e.getMessage(), e);
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				log.error("POSAgentAction#mposfastSettleDownLoad final error" + e.getMessage(), e);
			}
		}
	}

	/**
	 * 将byte[]压缩 zip , 并拿到zip的byte[]
	 *
	 * @param data
	 * @param zipfileName
	 * @return
	 * @throws IOException
	 */
	private byte[] zip(byte[] data, String zipfileName) throws IOException {
		byte[] b = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(bos);
		ZipEntry entry = new ZipEntry(zipfileName + ".csv");
		zip.setEncoding("gbk");
		entry.setSize(data.length);
		zip.putNextEntry(entry);
		zip.write(data);
		zip.closeEntry();
		zip.close();
		b = bos.toByteArray();
		bos.close();
		return b;
	}

	/**
	 * 拼装行数据
	 *
	 * @param model
	 * @return
	 */
	private String getRowInfo(ExtWithdrawReqVO model) {
		StringBuffer buff = new StringBuffer();
		if (model.getCreateTime() != null)
			buff.append(DateUtil.dateFormat4(model.getCreateTime()) + ",");
		else
			buff.append("" + ",");
		buff.append(model.getMerchantNo() + ",");
		buff.append(model.getMerchantName() + ",");
		if (model.getWithdrawType() != null) {
			if (String.valueOf(model.getWithdrawType()).equals(WithdrawConstant.withdrawTypeRealTime))
				buff.append("T0" + ",");
			else if (String.valueOf(model.getWithdrawType()).equals(WithdrawConstant.withdrawTypeOrdinary))
				buff.append("普通结算" + ",");
			else
				buff.append(model.getWithdrawType() + ",");
		} else {
			buff.append("" + ",");

		}

		if (model.getWithdrawAmount() != null)
			buff.append(model.getWithdrawAmount() + "" + ",");
		else
			buff.append(",");
		if (model.getTotalCost() != null)
			buff.append(model.getTotalCost() + "" + ",");
		else
			buff.append(",");
		if (model.getWithdrawCost() != null)
			buff.append(model.getWithdrawCost() + "" + ",");
		else
			buff.append("" + ",");

		if (model.getWdCost() != null)
			buff.append(model.getWdCost() + "" + ",");
		else
			buff.append("" + ",");
		if (model.getWithdrawAmount() != null || model.getWithdrawCost() != null)
			buff.append(model.getWithdrawAmount().subtract(model.getWithdrawCost()) + "" + ",");
		else
			buff.append("" + ",");

		if (model.getStatus().equals(WithdrawReqStatusEnums.INIT.code))
			buff.append(WithdrawReqStatusEnums.INIT.desc + ",");
		else if (model.getStatus().equals(WithdrawReqStatusEnums.WAITTING.code))
			buff.append(WithdrawReqStatusEnums.WAITTING.desc + ",");
		else if (model.getStatus().equals(WithdrawReqStatusEnums.SUCCESS.code))
			buff.append(WithdrawReqStatusEnums.SUCCESS.desc + ",");
		else if (model.getStatus().equals(WithdrawReqStatusEnums.FAIL.code))
			buff.append(WithdrawReqStatusEnums.FAIL.desc + ",");
		else
			buff.append(model.getStatus() + ",");

		if (model.getWithdrawTime() != null)
			buff.append(DateUtil.dateFormat4(model.getWithdrawTime()) + ",");
		else
			buff.append("" + ",");
		buff.append(model.getPmtBindOperatorName());
		return buff.toString();
	}

	/**
	 * mpos导出拼接数据
	 * 
	 * @return
	 */
	private String getMcRowInfo(ExtWithdrawReqVO model) {
		StringBuffer buff = new StringBuffer();
		if (model.getCreateTime() != null)
			buff.append(DateUtil.dateFormat4(model.getCreateTime()) + ",");
		else
			buff.append("" + ",");
		buff.append(model.getMerchantNo() + ",");
		buff.append(model.getMerchantName() + ",");
		buff.append(model.getMcc() + ",");
		if (model.getWithdrawType() != null) {
			if (String.valueOf(model.getWithdrawType()).equals(WithdrawConstant.withdrawTypeRealTime))
				buff.append("快速提现" + ",");
			else if (String.valueOf(model.getWithdrawType()).equals(WithdrawConstant.withdrawTypeOrdinary))
				buff.append("普通提现" + ",");
			else
				buff.append(model.getWithdrawType() + ",");
		} else {
			buff.append("" + ",");

		}

		if (model.getWithdrawAmount() != null)
			buff.append(model.getWithdrawAmount() + "" + ",");
		else
			buff.append(",");
		if (model.getTotalCost() != null)
			buff.append(model.getTotalCost() + "" + ",");
		else
			buff.append(",");
		if (model.getWithdrawCost() != null)
			buff.append(model.getWithdrawCost() + "" + ",");
		else
			buff.append("" + ",");
		if (model.getWdCost() != null)
			buff.append(model.getWdCost() + "" + ",");
		else
			buff.append("" + ",");
		if (model.getWithdrawAmount() != null || model.getWithdrawCost() != null)
			buff.append(model.getWithdrawAmount().subtract(model.getWithdrawCost()) + "" + ",");
		else
			buff.append("" + ",");

		if (model.getStatus().equals(WithdrawReqStatusEnums.INIT.code))
			buff.append(WithdrawReqStatusEnums.INIT.desc + ",");
		else if (model.getStatus().equals(WithdrawReqStatusEnums.WAITTING.code))
			buff.append(WithdrawReqStatusEnums.WAITTING.desc + ",");
		else if (model.getStatus().equals(WithdrawReqStatusEnums.SUCCESS.code))
			buff.append(WithdrawReqStatusEnums.SUCCESS.desc + ",");
		else if (model.getStatus().equals(WithdrawReqStatusEnums.FAIL.code))
			buff.append(WithdrawReqStatusEnums.FAIL.desc + ",");
		else
			buff.append(model.getStatus() + ",");

		if (model.getWithdrawTime() != null)
			buff.append(DateUtil.dateFormat4(model.getWithdrawTime()) + ",");
		else
			buff.append("" + ",");
		buff.append(model.getPmtBindOperatorName());
		return buff.toString();
	}

	private static final String fileSize = GlobalConfig.getString("maxUploadSize", "104857600");

	/**
	 * 申请临时调额
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/adjustLimit/index")
	public String adjustLimitIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.put("msgCode", "");
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		Long promoterId = user.getPromoterId();
		// promoterType=0101 云收银管理菜单进入
		String promoterType = request.getParameter("promoterType");
		if (StringUtils.isBlank(promoterType)) {
			promoterType = user.getCurrentMcType();
		}
		ViewPromoterInfoDTO viewPromoterInfoDTO = null;
		if (PosMerchantTypeEnums.EASYPAY_PROMOTER.code.equals(promoterType)) {
			viewPromoterInfoDTO = promoterInfoService.queryPromoterInfo(user.getMerchantNo(), promoterType);
			if (viewPromoterInfoDTO != null) {
				promoterId = viewPromoterInfoDTO.getPromoterId();
			} else {
				model.put("msgCode", "很抱歉，当前代理商不能进行此操作。");
				return "/main/fastsettle/adjustLimit/index";
			}
		}
		model.put("promoterType", promoterType);
		// 是否在时间范围内 超出时间范围内不能发起
		if (new Date().compareTo(adjustLimitService.queryAdjustTime(MerchantCreditConstant.START)) == -1
				|| new Date().compareTo(adjustLimitService.queryAdjustTime(MerchantCreditConstant.END)) == 1) {
			model.put("msgCode",
					"申请时间不可晚于" + DateUtil.date2Str(adjustLimitService.queryAdjustTime(MerchantCreditConstant.END),
							DateUtil.dateFormat5Format) + "点");
			return "/main/fastsettle/adjustLimit/index";
		}
		// 是否需要审核
		boolean isNeedApproval = adjustLimitService.isNeedApproval(user.getMerchantNo(), promoterId,
				OpTypeEnums.SHENGPAY_PROMPTER_ADJUST_LIMIT.code);
		if (isNeedApproval) {
			model.put("msgCode", "调额申请已提交，请于1小时后在【申请记录】中查询处理结果");
		}
		// 剩余次数
		Integer suplusCount = adjustLimitService.surplusAdjustCount(user.getMerchantNo(), promoterId,
				OpTypeEnums.SHENGPAY_PROMPTER_ADJUST_LIMIT.code, AuditInfoStateEnum.AUDITED.getStatus());
		if (suplusCount <= 0) {
			model.put("msgCode", "本月临时调额次数已超过上限，无法继续申请。建议您增加快速结算保证金，便可提升额度。");
		}

		model.put("auditFlag", isNeedApproval);
		model.put("promoterInfo", newT0PromoterInfoService.getNewT0PromoterInfoServiceBeanByPromoterId(promoterId));
		model.put("surplusCount", suplusCount);
		model.put("fileSizeCfg", Integer.parseInt(fileSize));
		return "/main/fastsettle/adjustLimit/index";
	}

	/**
	 * 申请临时调额
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@Value("${file.store.url}")
	private String fileStoreUrl;

	@RequestMapping(value = "/adjustLimit/apply")
	public String applyTemporaryAdjustLimit(@RequestParam(value = "file", required = false) MultipartFile file,
			AdjustLimitBean adjust, HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		Long promoterId = user.getPromoterId();
		// promoterType=0101 云收银管理菜单进入
		String promoterType = request.getParameter("promoterType");
		if (StringUtils.isBlank(promoterType)) {
			promoterType = user.getCurrentMcType();
		}
		ViewPromoterInfoDTO viewPromoterInfoDTO = null;
		if (PosMerchantTypeEnums.EASYPAY_PROMOTER.code.equals(promoterType)) {
			viewPromoterInfoDTO = promoterInfoService.queryPromoterInfo(user.getMerchantNo(), promoterType);
			if (viewPromoterInfoDTO != null) {
				promoterId = viewPromoterInfoDTO.getPromoterId();
			} else {
				model.put("msgCode", "很抱歉，当前代理商不能进行此操作。");
				return "/main/fastsettle/adjustLimit/index";
			}
		}
		model.put("promoterType", promoterType);
		// 是否在时间范围内 超出时间范围内不能发起
		if (new Date().compareTo(adjustLimitService.queryAdjustTime(MerchantCreditConstant.START)) == -1
				|| new Date().compareTo(adjustLimitService.queryAdjustTime(MerchantCreditConstant.END)) == 1) {
			model.put("msgCode",
					"申请时间不能早于"
							+ DateUtil.date2Str(adjustLimitService.queryAdjustTime(MerchantCreditConstant.START),
									DateUtil.dateFormat5Format)
							+ "点,晚于" + DateUtil.date2Str(adjustLimitService.queryAdjustTime(MerchantCreditConstant.END),
									DateUtil.dateFormat5Format)
							+ "点");
			return "/main/fastsettle/adjustLimit/index";
		}
		AuditInfoDTO auditInfo = extNewT0AuditInfoManager.selectAuditedTempLimitInfoByMerchantInfo(user.getMerchantNo(),
				promoterType);
		if (auditInfo != null) {
			model.put("msgCode", "今日临时调额次数已超过上限，无法继续申请。建议您增加快速结算保证金，便可提升额度。");
			return "/main/fastsettle/adjustLimit/index";
		}
		// 是否需要审核
		boolean isNeedApproval = adjustLimitService.isNeedApproval(user.getMerchantNo(), promoterId,
				OpTypeEnums.SHENGPAY_PROMPTER_ADJUST_LIMIT.code);
		Integer suplusCount = adjustLimitService.surplusAdjustCount(user.getMerchantNo(), promoterId,
				OpTypeEnums.SHENGPAY_PROMPTER_ADJUST_LIMIT.code, AuditInfoStateEnum.AUDITED.getStatus());
		model.put("promoterInfo", newT0PromoterInfoService.getNewT0PromoterInfoServiceBeanByPromoterId(promoterId));
		if (adjust.getReqBean().getApplyLimit() == null
				|| adjust.getReqBean().getApplyLimit().compareTo(BigDecimal.ZERO) == -1) {
			model.put("msgCode", "操作失败：申请额度为不能为空且不能小于0");
			model.put("auditFlag", isNeedApproval);
			model.put("surplusCount", suplusCount);
			return "/main/fastsettle/adjustLimit/index";
		}
		if (adjust.getReqBean().getApplyCause() == null || StringUtils.isBlank(adjust.getReqBean().getApplyCause())) {
			model.put("msgCode", "操作失败：申请原因不能为空");
			model.put("auditFlag", isNeedApproval);
			model.put("surplusCount", suplusCount);
			return "/main/fastsettle/adjustLimit/index";
		}
		// 只有盛付通垫资才可以发起临时调额
		// T0新增 获取垫资类型
		LoaningTypeEnum loaningType = LoaningTypeEnum
				.getLoaningTypeEnum(newt0PromoterService.getLoaningTypeByPromoterId(promoterId));
		if (loaningType == null) {
			model.put("msgCode", "操作失败：您当前无垫资方类型，无法申请调额，请追加快速结算保证金，系统自动调额。");
			return "/main/fastsettle/adjustLimit/index";
		}
		if (loaningType.code == LoaningTypeEnum.PROMOTER.code) {
			model.put("msgCode", "操作失败：您当前是代理商全资，无法申请调额，请追加快速结算保证金，系统自动调额。");
			return "/main/fastsettle/adjustLimit/index";
		}
		if (suplusCount <= 0) {
			model.put("msgCode", "操作失败：本月临时调额次数已超过上限，无法继续申请。建议您增加快速结算保证金，便可提升额度。");
			return "/main/fastsettle/adjustLimit/index";
		}
		String key = "";
		try {
			if (file.getSize() > 0) {
				key = DFSUtils.postForLocation(fileStoreUrl, file.getBytes());
			}
			adjust.getReqBean().setFileName(file.getOriginalFilename());
			adjust.getReqBean().setContentType(file.getContentType());
			// 上传文件成功
			adjust.getReqBean().setAttachment(key);
		} catch (IOException e) {
			// 上传文件异常
			log.error("POSAgentAction#adjustLimit apply upload is error", e);
			throw e;
		}

		adjust.setObjId(promoterId);
		adjust.setObjNo(user.getMerchantNo());
		adjust.setMcType(promoterType);
		try {
			if (isNeedApproval) {
				model.put("msgCode", "调额申请已提交，请于1小时后在【申请记录】中查询处理结果");
				return "/main/fastsettle/adjustLimit/index";
			}

			adjustLimitService.addAuditInfo(adjust, user.getAdminLoginName());
			model.put("msgCode", "调额申请已提交，请于1小时后在【申请记录】中查询处理结果");
			String title = "【待处理】T0代理商申请临时调额";
			NewT0PromoterInfoServiceBean proInfo = newT0PromoterInfoService
					.getNewT0PromoterInfoServiceBeanByPromoterId(promoterId);
			String context = subContext(proInfo.getPromoterInfoDTO().getName(), user.getMerchantNo(),
					adjust.getReqBean().getApplyCause(), adjust.getReqBean().getApplyLimit().toString());
			marginOpService.sendMail(title, context);
		} catch (Exception e) {
			log.error("POSAgentAction#adjustLimit apply  add is error");
			model.put("msgCode", "操作失败：申请失败");
			throw e;
		}
		return "/main/fastsettle/adjustLimit/index";

	}

	private String subContext(String promoterName, String prompterNo, String applyCause, String applyLimit) {
		StringBuffer sbContext = new StringBuffer();
		String applyTime = DateUtil.date2Str(new Date(), DateUtil.dateFormat4Format);
		sbContext.append("<table width='80%' border='1'>");
		sbContext.append("<caption align='top'>【待处理】T0代理商申请临时调额</caption>");
		sbContext.append("<tr> ");
		sbContext.append("<th width='15%'>申请时间</th>");
		sbContext.append("<th width='15%'>代理商商户号</th>");
		sbContext.append("<th width='15%'>代理商名称</th>");
		sbContext.append("<th width='15%'>申请额度</th>");
		sbContext.append("<th width='20%'>申请原因</th>");
		sbContext.append("</tr>");
		sbContext.append("<tr> ");
		sbContext.append("<td width='15%'>" + applyTime + "</th>");
		sbContext.append("<td width='15%'>" + prompterNo + "</td>");
		sbContext.append("<td width='15%'>" + promoterName + "</td>");
		sbContext.append("<td width='15%'>" + applyLimit + "</td>");
		sbContext.append("<td width='20%'>" + applyCause + "</td>");
		sbContext.append("</tr>");
		sbContext.append("<tr> ");
		sbContext.append("<td colspan='5' width='100%'><a  href='"
				+ GlobalConfig.getString(MerchantContractCst.OPERNER_URL, "") + "'>请登录后台审批</a></td>");
		sbContext.append("</tr>");
		sbContext.append("</table> ");
		return sbContext.toString();
	}

	/**
	 * 查询申请记录
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/adjustLimit/query")
	public String queryAdjustRecord(NewT0AuditInfoDOExample query, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		Long promoterId = user.getPromoterId();
		String promoterType = request.getParameter("promoterType");
		ViewPromoterInfoDTO viewPromoterInfoDTO = null;
		if (PosMerchantTypeEnums.EASYPAY_PROMOTER.code.equals(promoterType)) {
			viewPromoterInfoDTO = promoterInfoService.queryPromoterInfo(user.getMerchantNo(), promoterType);
			if (viewPromoterInfoDTO != null) {
				promoterId = viewPromoterInfoDTO.getPromoterId();
				model.put("promoterType", promoterType);
			}
		}
		query.setObjNo(user.getMerchantNo());
		query.setObjId(promoterId);
		query.setMcType(promoterType);
		query.setPageSize(15);
		List<AdjustLimitBean> dataList = adjustLimitService.pageQueryAdjustTrans(query);
		model.put("dataList", dataList);
		model.put("query", query);
		return "/main/fastsettle/adjustLimit/history";
	}

}
