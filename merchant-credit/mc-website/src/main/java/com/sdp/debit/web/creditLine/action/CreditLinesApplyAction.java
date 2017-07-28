package com.sdp.debit.web.creditLine.action;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.sdp.debit.web.creditLine.vo.CreditLineSaveResponse;
import com.sdp.debit.web.enums.CreditLineApplyEnums.ApplicantAmountEnum;
import com.sdp.debit.web.enums.CreditLineApplyEnums.MaritalStatusEnum;
import com.sdp.debit.web.enums.CreditLineApplyEnums.OtherPropertyUploadEnum;
import com.sdp.debit.web.enums.CreditLineApplyEnums.SaveOrUpdateEnum;
import com.sdp.debit.web.enums.CreditLineResponseEnum;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.common.web.MerchantPromoterInfo;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.integration.ma.dto.PersionalInfoDTO;
import com.sdp.mc.ma.wrapper.MaOnlineWrapper;
import com.sdp.mc.service.contract.MerchantContractService;
import com.sdp.mc.verify.VerifyQueryServiceClient;
import com.sdp.mc.web.action.BaseAction;
import com.shengpay.debit.common.enums.ConfigEnums;
import com.shengpay.debit.common.enums.DebitOrganizationEnum;
import com.shengpay.debit.common.risk.model.CreditLineApplyRequest;
import com.shengpay.debit.common.risk.model.CreditRiskTypes;
import com.shengpay.debit.common.risk.model.CreditRiskTypesItems;
import com.shengpay.debit.common.risk.model.GetCreditRiskResponseModel;
import com.shengpay.debit.common.service.CreditLineManager;
import com.shengpay.debit.common.service.CreditRiskService;
import com.shengpay.debit.common.service.DebitConfigService;
import com.shengpay.debit.common.service.DoMerchantApplyFailLogService;
import com.shengpay.debit.common.service.MerchantAccountService;
import com.shengpay.debit.common.service.MerchantCreditLinesApplyService;
import com.shengpay.debit.common.service.OrgCreditSettingService;
import com.shengpay.debit.credit.lines.apply.enums.CreditLinesApplyStatusEnums;
import com.shengpay.debit.dal.dataobject.DbOrgCreditSettingPO;
import com.shengpay.debit.dal.dataobject.DmAgentMerchantSettingListPO;
import com.shengpay.debit.dal.dataobject.DmMerchantDebitInfoPO;
import com.shengpay.debit.dal.dataobject.DoMeCreditLinesApplyInfoPO;
import com.shengpay.debit.dal.dataobject.DoMerchantApplyFailLogPO;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;
import com.shengpay.debit.merchant.account.enums.DebitAccountEnums;
import com.shengpay.verify.common.facade.enums.IdCardStatus;
import com.shengpay.verify.common.facade.model.VerifyInfo;

/**
 * 商户额度申请action
 *
 * @author heyi.alex
 *
 */
@RequestMapping(value = { "/posMerchant/credit", "/mposMerchant/credit" })
@Controller
public class CreditLinesApplyAction extends BaseAction {

	private static Logger log = LoggerFactory.getLogger(CreditLinesApplyAction.class);

	/**
	 * 调用风控的服务
	 */
	@Autowired
	protected CreditRiskService creditRiskService;

	/**
	 * 商户负债资产查询
	 */
	@Autowired
	private MerchantAccountService merchantAccountService;

	/**
	 * 商户信用额度申请
	 */
	@Autowired
	protected MerchantCreditLinesApplyService merchantCreditLinesApplyService;

	/**
	 * 配置信息表
	 */
	@Autowired
	private DebitConfigService debitConfigService;
	/**
	 * 配置信息表
	 */
	@Autowired
	private MerchantContractService contractService;
	/**
	 * 查询用户信息
	 */
	@Autowired
	private MaOnlineWrapper maOnlineWrapper;

	@Autowired
	private CreditLineManager creditLineManager;

	@Autowired
	private ConfigOptionManager configOptionManager;
	/**
	 * 企业额度配置
	 */
	@Autowired
	private OrgCreditSettingService orgCreditSettingService;

	@Autowired
	private VerifyQueryServiceClient verifyQueryServiceClient;

	// @Autowired
	// private OpenMerchantWrapper openMerchantWrapper;

	@Autowired
	private DoMerchantApplyFailLogService doMerchantApplyFailLogService;

	@Value("${file.xieyi.dailishang.html}")
	private String chengnuohanHtmlUrl;

	@Value("${file.xieyi.shanghu.doc}")
	private String merchantAgreementUrl;

	/**
	 * 协议模板
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/agreeTemp" })
	public String agreeTemp(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		model.put("chengnuohanHtmlUrl", chengnuohanHtmlUrl);
		return "/main/debit/apply/agreeTemp";
	}

	/**
	 * 协议模板
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/agreement" })
	public String agreement(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		String type = request.getParameter("type");
		if (type.equals("0")) {
			// 盛畅
			return "/main/debit/apply/shengchangxieyi";
		} else {
			// 委托
			return "/main/debit/apply/koukuanxieyi";
		}

	}

	/**
	 * 产品说明
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/productDetail" })
	public String productDetail(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		// 罚息利率
		String _overDueRate = this.debitConfigService.getByKey(ConfigEnums.OVER_DUE_RATE);
		BigDecimal overDueRate = new BigDecimal(_overDueRate).divide(BigDecimal.valueOf(100));
		model.put("overDueRate", overDueRate);
		model.put("audit", this.debitConfigService.getByKey(ConfigEnums.CREDIT_PRODUCT_DETAIL_AUDIT));
		model.put("fee", this.debitConfigService.getByKey(ConfigEnums.CREDIT_PRODUCT_DETAIL_FEE));
		model.put("cond", this.debitConfigService.getByKey(ConfigEnums.CREDIT_PRODUCT_DETAIL_CONDITION));
		model.put("material", this.debitConfigService.getByKey(ConfigEnums.CREDIT_PRODUCT_DETAIL_MATERIAL));
		model.put("desc", this.debitConfigService.getByKey(ConfigEnums.CREDIT_PRODUCT_DETAIL_DESC).replace("${overDueRate}", overDueRate.toString()));
		return "/main/debit/apply/productDetail";
	}

	// /**
	// * 页面初始化判断
	// *
	// * @param request
	// * @param response
	// * @param model
	// * @return
	// * @throws Exception
	// */
	// @RequestMapping(value = { "/init" })
	// public String init(HttpServletRequest request, HttpServletResponse
	// response, ModelMap model) throws Exception {
	// // 协议文件下载地址
	// model.put("merchantAgreementUrl", merchantAgreementUrl);
	// MCMerchantUser user =
	// MCMerchantUser.getMCMerchantUser(request.getSession()); //
	// 默认通过filter都存在merchant
	// String merchantNo = user.getMerchantNo();
	// // 根据商户号查询代理商商户号
	// String pro_merchantNo =
	// contractService.selectPromoterNoByPromoterId(user.getPromoterId());
	// // 判断年代理商是否开通担保 0 不能担保 1 可以担保
	// try {
	// DmAgentMerchantSettingListPO dm =
	// merchantCreditLinesApplyService.getAgentMerchant(pro_merchantNo);
	// if (dm == null || dm.getStatus().equals("0")) {
	// String message =
	// this.debitConfigService.getByKey(ConfigEnums.TTD_PROMOTER_GUARANTEE_MESSAGE);
	// model.put("MESSAGE", message);
	// return "/main/debit/apply/userReject";
	// }
	//
	// } catch (Exception e) {
	// log.error("CreditLinesApplyAction->init->error", e);
	// model.put("MESSAGE", "异常，请联系管理员或者技术人员");
	// return "/main/debit/apply/userReject";
	// }
	//
	// // 查询用户借款资产
	// DmMerchantDebitInfoPO debitInfoPO =
	// merchantAccountService.selectByMerchantId(merchantNo);
	// // 查询最近一次申购
	// DoMerchantCreditLinesApplyPO applyPO =
	// merchantCreditLinesApplyService.getLatestCreditLines(merchantNo);
	// // 有申请记录
	// if (applyPO != null) {
	// String applyStatus = applyPO.getApplyStatus();
	// // 判断有没有过期，过期需要需要重新申请
	// if (CreditLinesApplyStatusEnums.APLY_SUCCESS.key.equals(applyStatus)) {
	// if (applyPO.getPolicyEndTime() != null &&
	// applyPO.getPolicyEndTime().before(new Date())) {
	// if (debitInfoPO != null && debitInfoPO.getUsedAmount() != null &&
	// debitInfoPO.getUsedAmount().compareTo(BigDecimal.valueOf(0)) > 0) {
	// return "/main/debit/apply/applyFail";
	// }
	// setUpdateView(model, applyPO);
	// return "/main/debit/apply/updateApply";
	// }
	// }
	// // 用户资料处于编辑中
	// if (CreditLinesApplyStatusEnums.USER_MODIFY.key.equals(applyStatus)) {
	// setUpdateView(model, applyPO);
	// return "/main/debit/apply/updateApply";
	// }
	//
	// // 准备代理商确认中
	// if
	// (CreditLinesApplyStatusEnums.READY_AGENT_SUBMIT.key.equals(applyStatus))
	// {
	// // 判断是否是代理商审核中
	// if ("1".equals(applyPO.getIsNeedAgnetGuarantee())) {
	// String message =
	// this.debitConfigService.getByKey(ConfigEnums.TTD_IN_AGENT_PROMPT_MESSAGE);
	// model.put("MESSAGE", message);
	// }
	// return "/main/debit/apply/userRisk";
	// }
	//
	// // 用户资料提交完毕
	// if (CreditLinesApplyStatusEnums.USER_INFO_SUBMIT.key.equals(applyStatus))
	// {
	// setUpdateView(model, applyPO);
	// if ("1".equals(applyPO.getIsNeedAgnetGuarantee())) {
	// String message =
	// this.debitConfigService.getByKey(ConfigEnums.TTD_IN_SFT_PROMPT_MESSAGE);
	// model.put("MESSAGE", message);
	// }
	// return "/main/debit/apply/userRisk";
	// }
	//
	// // 提交风控完毕
	// if (CreditLinesApplyStatusEnums.RISK_SUBMIT.key.equals(applyStatus)) {
	// return "/main/debit/apply/userRisk";
	// }
	//
	// // 用户资料提交中
	// if (CreditLinesApplyStatusEnums.RISK_NOTIFY.key.equals(applyStatus)) {
	// setAgreementView(request, model, applyPO);
	// return "/main/debit/apply/userSendData";
	// }
	//
	// // 审批失败
	// if (CreditLinesApplyStatusEnums.APPLY_FAIL.key.equals(applyStatus)) {
	// // 判断是否30天申请有效期间已过
	// if (applyPO.getApplyStartTime().before(getCompareDays())) {
	// // 已过的重新申请
	// setInitView(model, applyPO);
	// return "/main/debit/apply/userApply";
	// } else {
	// // 拒绝
	// return "/main/debit/apply/userReject";
	// }
	// }
	//
	// // 审批通过
	// if (CreditLinesApplyStatusEnums.APLY_SUCCESS.key.equals(applyStatus)) {
	// model.put("applySuccess",
	// this.debitConfigService.getByKey(ConfigEnums.CREDIT_INIT_APPLY_SUCCESS));
	// if (debitInfoPO != null) {
	// String status = debitInfoPO.getStatus();
	// // 有资产的情况
	// if (DebitAccountEnums.ACCOUNT_CAN_USE.getKey().equals(status)) {
	// return "main/debit/apply/effective";
	// } else {
	// return "main/debit/apply/overdueStatus";
	// }
	// }
	// return "main/debit/apply/effective";
	// }
	// } else {
	// // 没有申请过的可以重新申请
	// setInitView(model, null);
	// return "/main/debit/apply/userApply";
	// }
	// return "";
	// }
	/**
	 * 页面初始化判断
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/init" })
	public String init(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		// 协议文件下载地址
		model.put("merchantAgreementUrl", merchantAgreementUrl);
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession()); // 默认通过filter都存在merchant
		String merchantNo = user.getMerchantNo();
		// 根据商户号查询代理商商户号
		String pro_merchantNo = contractService.selectPromoterNoByPromoterId(user.getPromoterId());
		// 判断年代理商是否开通担保 0 不能担保 1 可以担保
		try {
			DmAgentMerchantSettingListPO dm = merchantCreditLinesApplyService.getAgentMerchant(pro_merchantNo);
			if (dm == null || dm.getStatus().equals("0")) {
				String message = this.debitConfigService.getByKey(ConfigEnums.TTD_PROMOTER_GUARANTEE_MESSAGE);
				model.put("MESSAGE", message);
				return "/main/debit/apply/userReject";
			}

		} catch (Exception e) {
			log.error("CreditLinesApplyAction->init->error", e);
			model.put("MESSAGE", "异常，请联系管理员或者技术人员");
			return "/main/debit/apply/userReject";
		}

		// 查询用户借款资产
		DmMerchantDebitInfoPO debitInfoPO = merchantAccountService.selectByMerchantId(merchantNo);
		// 查询最近一次申购
		DoMerchantCreditLinesApplyPO applyPO = merchantCreditLinesApplyService.getLatestCreditLines(merchantNo);
		// 有申请记录
		if (applyPO != null) {
			String applyStatus = applyPO.getApplyStatus();
			// 判断有没有过期，过期需要需要重新申请
			if (CreditLinesApplyStatusEnums.APLY_SUCCESS.key.equals(applyStatus)) {
				if (applyPO.getPolicyEndTime() != null && applyPO.getPolicyEndTime().before(new Date())) {
					if (debitInfoPO != null && debitInfoPO.getUsedAmount() != null
							&& debitInfoPO.getUsedAmount().compareTo(BigDecimal.valueOf(0)) > 0) { return "/main/debit/apply/applyFail"; }
					setUpdateView(model, applyPO);
					model.put("saveOrUpdateFlag", SaveOrUpdateEnum.UPDATE.getCode());
					return "/main/debit/apply/applyForCustomized";
				}
			}
			// 用户资料处于编辑中
			if (CreditLinesApplyStatusEnums.USER_MODIFY.key.equals(applyStatus)) {
				setUpdateView(model, applyPO);
				model.put("saveOrUpdateFlag", SaveOrUpdateEnum.UPDATE.getCode());
				return "/main/debit/apply/applyForCustomized";
			}

			// 准备代理商确认中
			if (CreditLinesApplyStatusEnums.READY_AGENT_SUBMIT.key.equals(applyStatus)) {
				// 判断是否是代理商审核中
				if ("1".equals(applyPO.getIsNeedAgnetGuarantee())) {
					String message = this.debitConfigService.getByKey(ConfigEnums.TTD_IN_AGENT_PROMPT_MESSAGE);
					model.put("MESSAGE", message);
				}
				return "/main/debit/apply/userRisk";
			}

			// 用户资料提交完毕
			if (CreditLinesApplyStatusEnums.USER_INFO_SUBMIT.key.equals(applyStatus)) {
				setUpdateView(model, applyPO);
				if ("1".equals(applyPO.getIsNeedAgnetGuarantee())) {
					String message = this.debitConfigService.getByKey(ConfigEnums.TTD_IN_SFT_PROMPT_MESSAGE);
					model.put("MESSAGE", message);
				}
				return "/main/debit/apply/userRisk";
			}

			// 提交风控完毕
			if (CreditLinesApplyStatusEnums.RISK_SUBMIT.key.equals(applyStatus)) { return "/main/debit/apply/userRisk"; }

			// 用户资料提交中
			if (CreditLinesApplyStatusEnums.RISK_NOTIFY.key.equals(applyStatus)) {
				setAgreementView(request, model, applyPO);
				return "/main/debit/apply/userSendData";
			}

			// 审批失败
			if (CreditLinesApplyStatusEnums.APPLY_FAIL.key.equals(applyStatus)) {
				// 判断是否30天申请有效期间已过
				if (applyPO.getApplyStartTime().before(getCompareDays())) {
					// 已过的重新申请
					setInitView(model, applyPO);
					model.put("saveOrUpdateFlag", SaveOrUpdateEnum.SAVE.getCode());
					return "/main/debit/apply/applyForCustomized";
				} else {
					// 拒绝
					return "/main/debit/apply/userReject";
				}
			}

			// 审批通过
			if (CreditLinesApplyStatusEnums.APLY_SUCCESS.key.equals(applyStatus)) {
				model.put("applySuccess", this.debitConfigService.getByKey(ConfigEnums.CREDIT_INIT_APPLY_SUCCESS));
				if (debitInfoPO != null) {
					String status = debitInfoPO.getStatus();
					// 有资产的情况
					if (DebitAccountEnums.ACCOUNT_CAN_USE.getKey().equals(status)) {
						return "main/debit/apply/effective";
					} else {
						return "main/debit/apply/overdueStatus";
					}
				}
				return "main/debit/apply/effective";
			}
		} else {
			// 没有申请过的可以重新申请
			setInitView(model, null);
			model.put("saveOrUpdateFlag", SaveOrUpdateEnum.SAVE.getCode());
			return "/main/debit/apply/applyForCustomized";
		}
		return "";
	}

	/**
	 * 查询申请状态
	 *
	 * @param applyId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/appStatusInfo" })
	public String appStatusInfo(HttpServletRequest request, ModelMap model) {
		DoMerchantCreditLinesApplyPO applyPO = null;
		try {
			MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
			// 查询最近一次申购
			// DoMerchantCreditLinesApplyPO applyPO =
			// merchantCreditLinesApplyService.selectById(applyId);
			applyPO = merchantCreditLinesApplyService.getLatestCreditLines(user.getMerchantNo());
			log.info("CreditLinesApplyAction.appStatusInfo.MerchantNo=" + user.getMerchantNo());
			if (applyPO != null) {
				setUpdateView(model, applyPO);
			} else {
				applyPO = new DoMerchantCreditLinesApplyPO();
			}
			if (null != applyPO.getApplyStatus()) {
				applyPO.setApplyStatus(CreditLinesApplyStatusEnums.parse(applyPO.getApplyStatus()).getDesc());
			}
			model.put("applyPO", applyPO);
			GetCreditRiskResponseModel riskModel = creditRiskService.getCreditRiskModel();
			model.put("riskModel", riskModel);
		} catch (Exception e) {
			log.error("CreditLinesApplyAction.appStatusInfo.error", e);
		}
		return "main/debit/apply/applyStatus";
	}

	/**
	 * 临时保存
	 *
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = { "/tempSave" })
	public synchronized void tempSave(CreditLineApplyRequest query, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Date now = new Date();
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		String persionalLoginName = request.getParameter("persionalLoginName");
		MerchantPromoterInfo merchantPrometerInfo = getMerchantPromoterInfo(request);
		// 判断天天贷服务是否关闭
		Boolean isSwitchOff = ConfigOptionHelper.getBooleanByKey(MerchantCreditConstant.TTD_SWITCH_OFF);
		if (isSwitchOff) {
			returnJsonResponse(response, CreditLineResponseEnum.TTD_SERVICE_SHUT_DOWN);
			return;
		}
		// 查询最近一次申购
		DoMerchantCreditLinesApplyPO existApplyRecord = merchantCreditLinesApplyService.getLatestCreditLines(merchantPrometerInfo.getMerchantNo());
		// 查询用户借款资产判断过期后是否还有贷款未还，没还清的不能再次申请
		DmMerchantDebitInfoPO debitInfoPO = merchantAccountService.selectByMerchantId(merchantPrometerInfo.getMerchantNo());
		if (existApplyRecord != null && existApplyRecord.getPolicyEndTime() != null && existApplyRecord.getPolicyEndTime().before(new Date())) {
			if (debitInfoPO != null && debitInfoPO.getCanUseAmount() != null
					&& debitInfoPO.getCanUseAmount().compareTo(debitInfoPO.getTotalAmount()) != 0) {
				returnJsonResponse(response, CreditLineResponseEnum.EXISTS_UNPAYBACK_RECORD);
				return;
			}
		}

		// 一个商户只能绑定一个钱包,如果钱包账户已被绑定则报错
		boolean flag1 = this.merchantCreditLinesApplyService.existsPersonalWalletBinded(merchantPrometerInfo.getMerchantNo(), persionalLoginName);
		if (flag1) {
			// 数据库已经有数据了
			returnJsonResponse(response, CreditLineResponseEnum.PERSONAL_WALLET_IS_ALREADY_BINDED);
			return;
		}

		DoMerchantCreditLinesApplyPO applyPO = new DoMerchantCreditLinesApplyPO(); // 申请额度订单
		applyPO.setMerchantNo(merchantPrometerInfo.getMerchantNo());
		if (query != null && query.getSaveOrUpdateFlag().equals(SaveOrUpdateEnum.SAVE.getCode())) {
			boolean flag = this.merchantCreditLinesApplyService.existsApplyingRecord(merchantPrometerInfo.getMerchantNo());
			if (flag) {
				// 数据库已经有数据了
				returnJsonResponse(response, CreditLineResponseEnum.EXISTS_APPLYING_RECORD);
				return;
			}
			applyPO.setMerchantName(merchantPrometerInfo.getMerchantName());
			applyPO.setPromoterNo(merchantPrometerInfo.getPromoterNo());
			applyPO.setPromoterName(merchantPrometerInfo.getPromoterName());
			applyPO.setApplyStatus(CreditLinesApplyStatusEnums.USER_MODIFY.key);
			applyPO.setOrganizationCode(DebitOrganizationEnum.SFT.code);
			applyPO.setMerchantMemberid(user.getMemberId());
			// 是否需要代理商承保
			applyPO.setIsNeedAgnetGuarantee(request.getParameter("isNeedAgentGuarantee"));
			applyPO.setLendLoginName(persionalLoginName); // 放款账户登录名
			applyPO.setCreateTime(now);
			applyPO.setUpdateTime(now);
			applyPO.setIsAgnetGuarantee("");// 暂时没有用
			if (query.getOtherPropertyFileInfo() != null && StringUtils.isNotBlank(query.getOtherPropertyFileInfo().getStoreKey())) {
				query.setIsOtherPropertyUpload(OtherPropertyUploadEnum.UPLOAD.getCode());
			} else {
				query.setIsOtherPropertyUpload(OtherPropertyUploadEnum.UNUPLOAD.getCode());
			}
			applyPO.setApplyMerchantInfo(JSONObject.fromObject(query).toString());

			creditLineManager.saveOrUpdateDb(applyPO, SaveOrUpdateEnum.SAVE.getCode());
		} else if (query != null && existApplyRecord != null && query.getSaveOrUpdateFlag().equals(SaveOrUpdateEnum.UPDATE.getCode())) {
			applyPO.setId(existApplyRecord.getId());
			applyPO.setApplyStatus(CreditLinesApplyStatusEnums.USER_MODIFY.key);
			// 是否需要代理商承保
			applyPO.setIsNeedAgnetGuarantee(request.getParameter("isNeedAgentGuarantee"));
			applyPO.setLendLoginName(persionalLoginName); // 放款账户登录名
			applyPO.setUpdateTime(now);
			applyPO.setIsAgnetGuarantee("");// 暂时没有用
			if (query.getOtherPropertyFileInfo() != null && StringUtils.isNotBlank(query.getOtherPropertyFileInfo().getStoreKey())) {
				query.setIsOtherPropertyUpload(OtherPropertyUploadEnum.UPLOAD.getCode());
			} else {
				query.setIsOtherPropertyUpload(OtherPropertyUploadEnum.UNUPLOAD.getCode());
			}
			applyPO.setApplyMerchantInfo(JSONObject.fromObject(query).toString());
			creditLineManager.saveOrUpdateDb(applyPO, SaveOrUpdateEnum.UPDATE.getCode());
		} else {
			returnJsonResponse(response, CreditLineResponseEnum.PARAMETER_NOT_NULL);
		}

		returnJsonResponse(response, CreditLineResponseEnum.SAVE_SUCCESS);
	}

	/**
	 * 用户提交的报文
	 *
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = { "/saveOrUpdate" })
	public synchronized void saveOrUpdate(CreditLineApplyRequest query, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		// 其他征信报告的一些check
		CreditLineResponseEnum msg = checkOtherInputItemsNotNull(request);
		if (msg != null) {
			returnJsonResponse(response, msg);
			return;
		}
		// 页面基本项校验
		CreditLineResponseEnum errorInfo = this.baseCheck(query);
		if (errorInfo != null && StringUtils.isNotBlank(errorInfo.code)) {
			returnJsonResponse(response, errorInfo);
			return;
		}

		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		String persionalLoginName = request.getParameter("persionalLoginName"); // 账户名称
		String merchantNo = user.getMerchantNo();
		// 查询最近一次申购
		DoMerchantCreditLinesApplyPO dbApplyPO = merchantCreditLinesApplyService.getLatestCreditLines(merchantNo);

		Date now = new Date();
		// 判断天天贷服务是否关闭
		Boolean isSwitchOff = ConfigOptionHelper.getBooleanByKey(MerchantCreditConstant.TTD_SWITCH_OFF);
		if (isSwitchOff) {
			returnJsonResponse(response, CreditLineResponseEnum.TTD_SERVICE_SHUT_DOWN);
			return;
		}
		// 查询用户借款资产判断过期后是否还有贷款未还，没还清的不能再次申请
		DmMerchantDebitInfoPO debitInfoPO = merchantAccountService.selectByMerchantId(merchantNo);
		if (dbApplyPO != null && dbApplyPO.getPolicyEndTime() != null && dbApplyPO.getPolicyEndTime().before(new Date())) {
			if (debitInfoPO != null && debitInfoPO.getCanUseAmount() != null
					&& debitInfoPO.getCanUseAmount().compareTo(debitInfoPO.getTotalAmount()) != 0) {
				returnJsonResponse(response, CreditLineResponseEnum.EXISTS_UNPAYBACK_RECORD);
				return;
			}
		}
		// 用户账户名没有输入
		if (StringUtils.isEmpty(persionalLoginName)) {
			returnJsonResponse(response, CreditLineResponseEnum.USER_WALLET_LOGIN_NAME_NOT_NULL);
			return;
		}
		// 个人钱包memberId
		PersionalInfoDTO persionalInfoDTO = maOnlineWrapper.getPersionalMemberId(persionalLoginName);
		// 钱包账户不存在
		if (persionalInfoDTO == null) {
			returnJsonResponse(response, CreditLineResponseEnum.ACCOUNT_NOT_EXISTS);
			return;
		}

		VerifyInfo verifyInfo = verifyQueryServiceClient.queryVerifyInfoByMemberid(persionalInfoDTO.getMemberId());
		if (verifyInfo == null || verifyInfo.getIdCardStatus() != IdCardStatus.IDENTITY_INFO_VERIFIED) {
			log.error("CreditLinesApplyAction.update verifyInfo memberId=" + persionalInfoDTO.getMemberId() + " is not verified.");
			returnJsonResponse(response, debitConfigService.getByKey(ConfigEnums.VERIFY_NO_TIP));
			return;
		}
		if (StringUtils.isBlank(verifyInfo.getTrueName()) || StringUtils.isBlank(verifyInfo.getCertNo())) {
			log.error("CreditLinesApplyAction.update verifyInfo memberId=" + persionalInfoDTO.getMemberId()
					+ " is not verified, TrueName or CertNo is blank.");
			returnJsonResponse(response, debitConfigService.getByKey(ConfigEnums.VERIFY_NO_TIP));
			return;
		}
		// QueryPosMerchantInfoResponse merchantInfo =
		// openMerchantWrapper.QueryPosMerchantInfo(user.getMerchantNo());
		// if (merchantInfo == null || merchantInfo.getMerchantbaseinfo() ==
		// null ||
		// !verifyInfo.getTrueName().equals(merchantInfo.getMerchantbaseinfo().getLegalperson())
		// ||
		// !verifyInfo.getCertNo().equals(merchantInfo.getMerchantbaseinfo().getLegalpersonid()))
		// {
		// log.error("CreditLinesApplyAction.update verifyInfo memberId=" +
		// persionalInfoDTO.getMemberId() +
		// " is not equal(TrueName and CertNo) to PossCertInfo");
		// returnJsonResponse(response,
		// debitConfigService.getByKey(ConfigEnums.VERIFY_DIFFERENCE_TIP));
		// return;
		// }

		// 一个商户只能绑定一个钱包,如果钱包账户已被绑定则报错
		boolean flag = this.merchantCreditLinesApplyService.existsPersonalWalletBinded(merchantNo, persionalLoginName);
		if (flag) {
			// 数据库已经有数据了
			returnJsonResponse(response, CreditLineResponseEnum.PERSONAL_WALLET_IS_ALREADY_BINDED);
			return;
		}
		// 验证支付密码
		ErrorMessageVO msgResult = checkPassword(persionalInfoDTO, request);
		if (msgResult == null) {
			returnJsonResponse(response, CreditLineResponseEnum.SYSTEM_ERROR);
			return;
		}
		// 密码不正确
		if (!msgResult.isSuccess()) {
			returnContentJsonResponse(response, CreditLineResponseEnum.PAY_PASSWORD_ERROR, msgResult.getErrorMessage());
			return;
		}

		// // 风控输入项
		// GetCreditRiskResponseModel riskModel =
		// creditRiskService.getCreditRiskModel();
		// // 输入项
		// CreditRiskTypesItems checkItem = checkInputItemsNotNull(riskModel,
		// request);
		// // 有项目输入为空
		// if (checkItem != null) {
		// returnContentJsonResponse(response,
		// CreditLineResponseEnum.PARAMETER_NOT_NULL, checkItem.getDesc() +
		// "输入项和附件不能为空");
		// return;
		// }
		MerchantPromoterInfo merchantPrometerInfo = getMerchantPromoterInfo(request);
		DoMerchantCreditLinesApplyPO applyPO = new DoMerchantCreditLinesApplyPO(); // 申请额度订单
		applyPO.setMerchantNo(merchantPrometerInfo.getMerchantNo());
		if (query != null && query.getSaveOrUpdateFlag().equals(SaveOrUpdateEnum.SAVE.getCode())) {
			applyPO.setMerchantName(merchantPrometerInfo.getMerchantName());
			applyPO.setPromoterNo(merchantPrometerInfo.getPromoterNo());
			applyPO.setPromoterName(merchantPrometerInfo.getPromoterName());
			applyPO.setMerchantMemberid(user.getMemberId());
			if ("1".equals(request.getParameter("isNeedAgentGuarantee").trim())) {
				applyPO.setApplyStatus(CreditLinesApplyStatusEnums.READY_AGENT_SUBMIT.key);
			} else {
				applyPO.setApplyStatus(CreditLinesApplyStatusEnums.USER_INFO_SUBMIT.key);
			}
			// 是否需要代理商承保
			applyPO.setIsNeedAgnetGuarantee(request.getParameter("isNeedAgentGuarantee"));
			applyPO.setOrganizationCode(DebitOrganizationEnum.SFT.code);
			applyPO.setLendLoginName(persionalLoginName); // 放款账户登录名
			applyPO.setLendMemberId(persionalInfoDTO.getMemberId()); // 个人用户memberId
			applyPO.setLendWallerAccount(persionalInfoDTO.getWalletAccount()); // 个人钱包账户
			if (query.getOtherPropertyFileInfo() != null && StringUtils.isNotBlank(query.getOtherPropertyFileInfo().getStoreKey())) {
				query.setIsOtherPropertyUpload(OtherPropertyUploadEnum.UPLOAD.getCode());
			} else {
				query.setIsOtherPropertyUpload(OtherPropertyUploadEnum.UNUPLOAD.getCode());
			}
			log.info("CreditLinesApplyAction->saveOrUpdate->save->info" + JSONObject.fromObject(query).toString());
			applyPO.setApplyMerchantInfo(JSONObject.fromObject(query).toString());// 录入信息
			applyPO.setApplyStartTime(now);
			applyPO.setCreateTime(now);
			applyPO.setUpdateTime(now);
			creditLineManager.saveOrUpdateDb(applyPO, SaveOrUpdateEnum.SAVE.getCode());
		} else if (query != null && dbApplyPO != null && query.getSaveOrUpdateFlag().equals(SaveOrUpdateEnum.UPDATE.getCode())) {
			// DoMerchantCreditLinesApplyPO applyPO = new
			// DoMerchantCreditLinesApplyPO(); // 申请额度订单
			applyPO.setId(dbApplyPO.getId());
			applyPO.setApplyStatus(CreditLinesApplyStatusEnums.READY_AGENT_SUBMIT.key);
			// 是否需要代理商承保
			applyPO.setIsNeedAgnetGuarantee(request.getParameter("isNeedAgentGuarantee"));
			applyPO.setLendLoginName(persionalLoginName); // 放款账户登录名
			applyPO.setLendMemberId(persionalInfoDTO.getMemberId()); // 个人用户memberId
			applyPO.setLendWallerAccount(persionalInfoDTO.getWalletAccount()); // 个人钱包账户
			applyPO.setOrganizationCode(DebitOrganizationEnum.SFT.code);
			if ("1".equals(request.getParameter("isNeedAgentGuarantee").trim())) {
				applyPO.setApplyStatus(CreditLinesApplyStatusEnums.READY_AGENT_SUBMIT.key);
			} else {
				applyPO.setApplyStatus(CreditLinesApplyStatusEnums.USER_INFO_SUBMIT.key);
			}
			if (query.getOtherPropertyFileInfo() != null && StringUtils.isNotBlank(query.getOtherPropertyFileInfo().getStoreKey())) {
				query.setIsOtherPropertyUpload(OtherPropertyUploadEnum.UPLOAD.getCode());
			} else {
				query.setIsOtherPropertyUpload(OtherPropertyUploadEnum.UNUPLOAD.getCode());
			}
			log.info("CreditLinesApplyAction->saveOrUpdate->update->info" + JSONObject.fromObject(query).toString());
			applyPO.setApplyMerchantInfo(JSONObject.fromObject(query).toString());// 录入信息
			applyPO.setApplyStartTime(now);
			applyPO.setUpdateTime(now);
			creditLineManager.saveOrUpdateDb(applyPO, SaveOrUpdateEnum.UPDATE.getCode());
		} else {
			returnJsonResponse(response, CreditLineResponseEnum.PARAMETER_NOT_NULL);
		}
		returnJsonResponse(response, CreditLineResponseEnum.SAVE_SUCCESS);
	}

	// /**
	// * 用户提交的报文
	// *
	// * @param request
	// * @param response
	// * @param model
	// */
	// @RequestMapping(value = { "/save" })
	// public synchronized void save(HttpServletRequest request,
	// HttpServletResponse response, ModelMap model) {
	// // 其他征信报告的一些check
	// String msg = checkOtherInputItemsNotNull(request);
	// if (StringUtils.isNotBlank(msg)){
	// returnJsonResponse(response, msg);
	// return;
	// }
	// MCMerchantUser user =
	// MCMerchantUser.getMCMerchantUser(request.getSession());
	// // 判断天天贷服务是否关闭
	// Boolean isSwitchOff =
	// this.configOptionManager.getBooleanByKey(MerchantCreditConstant.TTD_SWITCH_OFF);
	// if (isSwitchOff) {
	// returnJsonResponse(response,
	// CreditLineResponseEnum.TTD_SERVICE_SHUT_DOWN);
	// return;
	// }
	// // 查询最近一次申购
	// DoMerchantCreditLinesApplyPO existApplyRecord =
	// merchantCreditLinesApplyService.getLatestCreditLines(user.getMerchantNo());
	// // 查询用户借款资产判断过期后是否还有贷款未还，没还清的不能再次申请
	// DmMerchantDebitInfoPO debitInfoPO =
	// merchantAccountService.selectByMerchantId(user.getMerchantNo());
	// if (existApplyRecord != null && existApplyRecord.getPolicyEndTime() !=
	// null && existApplyRecord.getPolicyEndTime().before(new Date())) {
	// if (debitInfoPO != null && debitInfoPO.getCanUseAmount() != null &&
	// debitInfoPO.getCanUseAmount().compareTo(debitInfoPO.getTotalAmount()) !=
	// 0) {
	// returnJsonResponse(response,
	// CreditLineResponseEnum.EXISTS_UNPAYBACK_RECORD);
	// return;
	// }
	// }
	// boolean flag =
	// this.merchantCreditLinesApplyService.existsApplyingRecord(user.getMerchantNo());
	// if (flag) {
	// // 数据库已经有数据了
	// returnJsonResponse(response,
	// CreditLineResponseEnum.EXISTS_APPLYING_RECORD);
	// return;
	// }

	// String persionalLoginName = request.getParameter("persionalLoginName");
	// // 账户名称
	// Date now = new Date();
	// // 用户账户名没有输入
	// if (StringUtils.isEmpty(persionalLoginName)) {
	// returnJsonResponse(response,
	// CreditLineResponseEnum.USER_WALLET_LOGIN_NAME_NOT_NULL);
	// return;
	// }
	// // 一个商户只能绑定一个钱包,如果钱包账户已被绑定则报错
	// boolean flag1 =
	// this.merchantCreditLinesApplyService.existsPersonalWalletBinded(user.getMerchantNo(),
	// persionalLoginName);
	// if (flag1) {
	// // 数据库已经有数据了
	// returnJsonResponse(response,
	// CreditLineResponseEnum.PERSONAL_WALLET_IS_ALREADY_BINDED);
	// return;
	// }
	// // 个人钱包memberId
	// PersionalInfoDTO persionalInfoDTO =
	// maOnlineWrapper.getPersionalMemberId(persionalLoginName);
	// // 钱包账户不存在
	// if (persionalInfoDTO == null) {
	// returnJsonResponse(response, CreditLineResponseEnum.ACCOUNT_NOT_EXISTS);
	// return;
	// }
	// VerifyInfo verifyInfo =
	// verifyQueryServiceClient.queryVerifyInfoByMemberid(persionalInfoDTO.getMemberId());
	// if (verifyInfo == null || verifyInfo.getIdCardStatus() !=
	// IdCardStatus.IDENTITY_INFO_VERIFIED) {
	// log.error("CreditLinesApplyAction.update verifyInfo memberId=" +
	// persionalInfoDTO.getMemberId() + " is not verified.");
	// returnJsonResponse(response,
	// debitConfigService.getByKey(ConfigEnums.VERIFY_NO_TIP));
	// return;
	// }
	// if (StringUtils.isBlank(verifyInfo.getTrueName()) ||
	// StringUtils.isBlank(verifyInfo.getCertNo())) {
	// log.error("CreditLinesApplyAction.update verifyInfo memberId=" +
	// persionalInfoDTO.getMemberId() +
	// " is not verified, TrueName or CertNo is blank.");
	// returnJsonResponse(response,
	// debitConfigService.getByKey(ConfigEnums.VERIFY_NO_TIP));
	// return;
	// }
	// QueryPosMerchantInfoResponse merchantInfo =
	// openMerchantWrapper.QueryPosMerchantInfo(user.getMerchantNo());
	// if (merchantInfo == null || merchantInfo.getMerchantbaseinfo() == null ||
	// !verifyInfo.getTrueName().equals(merchantInfo.getMerchantbaseinfo().getLegalperson())
	// ||
	// !verifyInfo.getCertNo().equals(merchantInfo.getMerchantbaseinfo().getLegalpersonid()))
	// {
	// log.error("CreditLinesApplyAction.update verifyInfo memberId=" +
	// persionalInfoDTO.getMemberId() +
	// " is not equal(TrueName and CertNo) to PossCertInfo");
	// returnJsonResponse(response,
	// debitConfigService.getByKey(ConfigEnums.VERIFY_DIFFERENCE_TIP));
	// return;
	// }

	// 验证支付密码
	// ErrorMessageVO msgResult = checkPassword(persionalInfoDTO, request);
	// if (msgResult == null) {
	// returnJsonResponse(response, CreditLineResponseEnum.SYSTEM_ERROR);
	// return;
	// }
	// // 密码不正确
	// if (!msgResult.isSuccess()) {
	// returnContentJsonResponse(response,
	// CreditLineResponseEnum.PAY_PASSWORD_ERROR, msgResult.getErrorMessage());
	// return;
	// }

	// // 风控输入项
	// GetCreditRiskResponseModel riskModel =
	// creditRiskService.getCreditRiskModel();
	// // 输入项
	// CreditRiskTypesItems checkItem = checkInputItemsNotNull(riskModel,
	// request);
	// // 有项目输入为空
	// if (checkItem != null) {
	// returnContentJsonResponse(response,
	// CreditLineResponseEnum.PARAMETER_NOT_NULL, checkItem.getDesc() +
	// "输入项和附件不能为空");
	// return;
	// }
	// DoMerchantCreditLinesApplyPO applyPO = new
	// DoMerchantCreditLinesApplyPO(); // 申请额度订单
	// MerchantPromoterInfo merchantPrometerInfo =
	// getMerchantPromoterInfo(request);
	// applyPO.setMerchantNo(merchantPrometerInfo.getMerchantNo());
	// applyPO.setMerchantName(merchantPrometerInfo.getMerchantName());
	// applyPO.setPromoterNo(merchantPrometerInfo.getPromoterNo());
	// applyPO.setPromoterName(merchantPrometerInfo.getPromoterName());
	// applyPO.setMerchantMemberid(user.getMemberId());
	// if ("1".equals(request.getParameter("isNeedAgentGuarantee").trim())) {
	// applyPO.setApplyStatus(CreditLinesApplyStatusEnums.READY_AGENT_SUBMIT.key);
	// } else {
	// applyPO.setApplyStatus(CreditLinesApplyStatusEnums.USER_INFO_SUBMIT.key);
	// }
	// // 是否需要代理商承保
	// applyPO.setIsNeedAgnetGuarantee(request.getParameter("isNeedAgentGuarantee"));
	// applyPO.setOrganizationCode(DebitOrganizationEnum.SFT.code);
	// applyPO.setLendLoginName(persionalLoginName); // 放款账户登录名
	// applyPO.setLendMemberId(persionalInfoDTO.getMemberId()); // 个人用户memberId
	// applyPO.setLendWallerAccount(persionalInfoDTO.getWalletAccount()); //
	// 个人钱包账户
	// applyPO.setApplyStartTime(now);
	// applyPO.setCreateTime(now);
	// applyPO.setUpdateTime(now);
	//
	// // 用户输入项保存
	// List<CreditRiskTypes> riskTypes = riskModel.getTypes();
	// List<DoMeCreditLinesApplyInfoPO> itemsList = makeItemsList(riskTypes,
	// request);
	// // 保存个人信息
	// creditLineManager.saveDb(applyPO, itemsList);
	// returnJsonResponse(response, CreditLineResponseEnum.SAVE_SUCCESS);
	// }

	/**
	 * 将用户输入项打包
	 *
	 * @param riskTypes
	 * @param request
	 */
	private List<DoMeCreditLinesApplyInfoPO> makeItemsList(List<CreditRiskTypes> riskTypes, HttpServletRequest request) {
		Date now = new Date();
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		List<DoMeCreditLinesApplyInfoPO> itemsList = new ArrayList<DoMeCreditLinesApplyInfoPO>();
		for (int i = 0; i < riskTypes.size(); i++) {
			CreditRiskTypes types = riskTypes.get(i);
			List<CreditRiskTypesItems> items = types.getItems();
			for (int j = 0; j < items.size(); j++) {
				DoMeCreditLinesApplyInfoPO po = new DoMeCreditLinesApplyInfoPO();
				CreditRiskTypesItems item = items.get(j);
				po = makeCreditLineApply(types, item, request);
				po.setCreateTime(now);
				po.setUpdateTime(now);
				po.setMerchantNo(user.getMerchantNo());
				po.setOrgnizationCode("SFT");
				itemsList.add(po);
			}
		}
		itemsList.addAll(otherCreditLineApply(request));
		return itemsList;
	}

	/**
	 * 将用户的其他输入信息打包
	 *
	 * @param request
	 * @return
	 */
	private List<DoMeCreditLinesApplyInfoPO> otherCreditLineApply(HttpServletRequest request) {
		Date now = new Date();
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		List<DoMeCreditLinesApplyInfoPO> list = new ArrayList<DoMeCreditLinesApplyInfoPO>();
		// 用户名
		DoMeCreditLinesApplyInfoPO creditUserName = new DoMeCreditLinesApplyInfoPO();
		creditUserName.setInputKind("otherInput"); // 设置大的分类
		creditUserName.setInputCode("creditUserName");// 输入项的code
		creditUserName.setInputType("text"); // 输入项的类型
		creditUserName.setInputValue(request.getParameter("creditUserName"));
		creditUserName.setUpdateTime(now);
		creditUserName.setCreateTime(now);
		creditUserName.setMerchantNo(user.getMerchantNo());
		creditUserName.setOrgnizationCode("SFT");

		// 密码
		DoMeCreditLinesApplyInfoPO creditPassword = new DoMeCreditLinesApplyInfoPO();
		creditPassword.setInputKind("otherInput"); // 设置大的分类
		creditPassword.setInputCode("creditPassword");// 输入项的code
		creditPassword.setInputType("text"); // 输入项的类型
		creditPassword.setInputValue(request.getParameter("creditPassword"));
		creditPassword.setUpdateTime(now);
		creditPassword.setCreateTime(now);
		creditPassword.setMerchantNo(user.getMerchantNo());
		creditPassword.setOrgnizationCode("SFT");

		list.add(creditUserName);
		list.add(creditPassword);
		return list;
	}

	/**
	 * 输入项包装下
	 *
	 * @param types
	 * @param item
	 * @param request
	 * @return
	 */
	private DoMeCreditLinesApplyInfoPO makeCreditLineApply(CreditRiskTypes types, CreditRiskTypesItems item, HttpServletRequest request) {
		DoMeCreditLinesApplyInfoPO po = new DoMeCreditLinesApplyInfoPO();
		String inputType = item.getInputType();

		po.setInputKind(types.getCode().replace("_", " ")); // 设置大的分类
		po.setInputCode(item.getCode());// 输入项的code
		po.setInputType(inputType); // 输入项的类型

		// 为了便于方便理解，各种类型都分开
		if ("Attachment".equals(inputType)) {
			String inputValue = request.getParameter("hidden_" + types.getCode() + "_" + item.getCode());
			Map<String, String> params = getUrlParams(inputValue);
			Map<String, String> jsonMap = new HashMap<String, String>();
			jsonMap.put("key", params.get("key"));
			jsonMap.put("fileName", params.get("fileName"));
			jsonMap.put("contentType", params.get("contentType"));
			po.setExtInfo(JSON.toJSON(jsonMap).toString());
		} else if ("EnumAttachment".equals(inputType)) {
			String inputValue = request.getParameter("hidden_" + types.getCode() + "_" + item.getCode());
			Map<String, String> params = getUrlParams(inputValue);
			Map<String, String> jsonMap = new HashMap<String, String>();
			jsonMap.put("key", params.get("key"));
			jsonMap.put("fileName", params.get("fileName"));
			jsonMap.put("contentType", params.get("contentType"));
			po.setExtInfo(JSON.toJSON(jsonMap).toString());
			po.setInputValue(request.getParameter("select_" + types.getCode() + "_" + item.getCode()));
		} else if ("Enum".equals(inputType)) {
			po.setInputValue(request.getParameter("select_" + types.getCode() + "_" + item.getCode()));
		} else if ("Text".equals(inputType)) {
			po.setInputValue(request.getParameter(types.getCode() + "_" + item.getCode()));
		} else { // 默认
			po.setInputValue(request.getParameter(types.getCode() + "_" + item.getCode()));
		}
		return po;
	}

	/*
	 * private boolean isBlank(String str) { if (StringUtils.isBlank(str)) {
	 * return true; } if ("none".equals(str)) { return true; } return false; }
	 */

	/**
	 * 其他输入项的一些特殊check
	 * 
	 * @param request
	 * @return
	 */
	private CreditLineResponseEnum checkOtherInputItemsNotNull(HttpServletRequest request) {
		String creditUserName = request.getParameter("creditUserName");
		String creditPassword = request.getParameter("creditPassword");
		String creditAttach = request.getParameter("creditReportFileInfo.storeKey");
		if (StringUtils.isEmpty(creditAttach)) {
			if (StringUtils.isBlank(creditUserName) || StringUtils.isBlank(creditPassword)) { return CreditLineResponseEnum.CREDIT_PARAMETER_NOT_NULL; }
		}
		return null;
	}

	/**
	 * 验证输入内容
	 *
	 * @param riskModel
	 */
	private CreditRiskTypesItems checkInputItemsNotNull(GetCreditRiskResponseModel riskModel, HttpServletRequest request) {
		List<CreditRiskTypes> riskTypes = riskModel.getTypes();

		for (int i = 0; i < riskTypes.size(); i++) {
			CreditRiskTypes types = riskTypes.get(i);
			List<CreditRiskTypesItems> items = types.getItems();
			for (int j = 0; j < items.size(); j++) {
				CreditRiskTypesItems item = items.get(j);
				if ("EnumAttachment".equals(item.getInputType())) {
					String selectValue = request.getParameter("select_" + types.getCode() + "_" + item.getCode());
					String attachValue = request.getParameter("hidden_" + types.getCode() + "_" + item.getCode());
					if (!"none".equals(selectValue) && !"".equals(selectValue) && StringUtils.isBlank(attachValue)) { return item; }
					if (("none".equals(selectValue) || "".equals(selectValue)) && StringUtils.isNotBlank(attachValue)) { return item; }
				}
				if ("true".equals(item.getIsNeed())) {
					String inputType = item.getInputType();
					if ("Attachment".equals(inputType)) {
						String value = request.getParameter("hidden_" + types.getCode() + "_" + item.getCode());
						if (StringUtils.isBlank(value)) { return item; }
					} else if ("EnumAttachment".equals(inputType)) {
						String selectValue = request.getParameter("select_" + types.getCode() + "_" + item.getCode());
						if (StringUtils.isBlank(selectValue)) { return item; }
						String attachValue = request.getParameter("hidden_" + types.getCode() + "_" + item.getCode());
						if (StringUtils.isBlank(attachValue) && !"none".equals(selectValue)) { return item; }
					} else if ("Enum".equals(inputType)) {
						String selectValue = request.getParameter("select_" + types.getCode() + "_" + item.getCode());
						if (StringUtils.isBlank(selectValue)) { return item; }
					} else if ("Text".equals(inputType)) {
						String textValue = request.getParameter(types.getCode() + "_" + item.getCode());
						if (StringUtils.isBlank(textValue)) { return item; }
					} else { // 默认
						String textValue = request.getParameter(types.getCode() + "_" + item.getCode());
						if (StringUtils.isBlank(textValue)) { return item; }
					}
				}
			}
		}
		return null;
	}

	// /**
	// * 获取风控输入项
	// *
	// * @return
	// * @throws Exception
	// */
	// private void setInitView(ModelMap model, DoMerchantCreditLinesApplyPO
	// applyPO) throws Exception {
	// // 初始化密码
	// payPwdInit(model);
	// // 风控项初始化
	// GetCreditRiskResponseModel riskModel =
	// creditRiskService.getCreditRiskModel();
	// log.info("print risk content:" + riskModel);
	// model.put("riskModel", riskModel);
	// model.put("showTip",
	// debitConfigService.getByKey(ConfigEnums.VERIFY_SHOW_TIP));
	// DoMerchantApplyFailLogPO failLog = null;
	// if (applyPO != null) {
	// failLog = doMerchantApplyFailLogService.getLastFailLog(applyPO.getId());
	// }
	// model.put("failReason", failLog == null ? null : "上次退件原因（" + new
	// SimpleDateFormat("yyyy年MM月dd日").format(failLog.getCreateTime()) + "）：" +
	// failLog.getFailReason());
	// }

	// /**
	// * 获取更新
	// *
	// * @return
	// * @throws Exception
	// */
	// protected void setUpdateView(ModelMap model, DoMerchantCreditLinesApplyPO
	// applyPo) throws Exception {
	// // 初始化密码
	// payPwdInit(model);
	// // 风控项初始化
	// GetCreditRiskResponseModel riskModel =
	// creditRiskService.getCreditRiskModel();
	// List<CreditRiskTypes> riskTypes = riskModel.getTypes();
	// Map<String, DoMeCreditLinesApplyInfoPO> maps =
	// creditLineManager.selectByDoApplyPO(applyPo);
	//
	// for (int i = 0; i < riskTypes.size(); i++) {
	// CreditRiskTypes types = riskTypes.get(i);
	// List<CreditRiskTypesItems> items = types.getItems();
	// for (int j = 0; j < items.size(); j++) {
	// CreditRiskTypesItems item = items.get(j);
	// String inputType = item.getInputType();
	// DoMeCreditLinesApplyInfoPO infoPo = maps.get(types.getCode() + "_" +
	// item.getCode());
	// if (infoPo != null) {
	// if ("Attachment".equals(inputType)) {
	// // String urlValue =
	// // JSON.parseObject(infoPo.getExtInfo()).getString("url");
	// // item.setUserInputUrl(urlValue);
	// JSONObject json = JSON.parseObject(infoPo.getExtInfo());
	// if (json != null && json.containsKey("key") &&
	// StringUtils.isNotBlank(json.getString("key"))) {
	// String key = json.getString("key");
	// String fileName = json.getString("fileName");
	// String contentType = json.getString("contentType");
	// item.setUserInputUrl("key=" + key + "&fileName=" + fileName +
	// "&contentType=" + contentType);
	// item.setUserInputFileName(fileName);
	// item.setHasAttach("Yes");
	// } else {
	// item.setHasAttach("No");
	// }
	//
	// } else if ("EnumAttachment".equals(inputType)) {
	// JSONObject json = JSON.parseObject(infoPo.getExtInfo());
	// if (json != null && json.containsKey("key") &&
	// StringUtils.isNotBlank(json.getString("key"))) {
	// String key = json.getString("key");
	// String fileName = json.getString("fileName");
	// String contentType = json.getString("contentType");
	// item.setUserInputUrl("key=" + key + "&fileName=" + fileName +
	// "&contentType=" + contentType);
	// item.setUserInputFileName(fileName);
	// item.setHasAttach("Yes");
	// } else {
	// item.setHasAttach("No");
	// }
	// item.setUserInputVal(infoPo.getInputValue());
	// } else if ("Enum".equals(inputType)) {
	// String seletValue = infoPo.getInputValue();
	// item.setUserInputVal(seletValue);
	// } else if ("Text".equals(inputType)) {
	// String seletValue = infoPo.getInputValue();
	// model.put(types.getCode() + "_" + item.getCode(), seletValue);
	// item.setUserInputVal(seletValue);
	// } else { // 默认
	// String seletValue = infoPo.getInputValue();
	// item.setUserInputVal(seletValue);
	// }
	// }
	// }
	// }
	// log.info("print risk content:" + riskModel);
	// model.put("creditUserNameVal",
	// creditLineManager.selectOtherInputByInputCode(applyPo.getMerchantNo(),
	// "creditUserName"));
	// model.put("creditPasswordVal",
	// creditLineManager.selectOtherInputByInputCode(applyPo.getMerchantNo(),
	// "creditPassword"));
	// model.put("applyPo", applyPo);
	// model.put("riskModel", riskModel);
	// DoMerchantApplyFailLogPO failLog = null;
	// if (applyPo != null) {
	// failLog = doMerchantApplyFailLogService.getLastFailLog(applyPo.getId());
	// }
	// model.put("failReason", failLog == null ? null : "上次退件原因（" + new
	// SimpleDateFormat("yyyy年MM月dd日").format(failLog.getCreateTime()) + "）：" +
	// failLog.getFailReason());
	// }
	/**
	 * 获取初始页
	 *
	 * @return
	 * @throws Exception
	 */
	private void setInitView(ModelMap model, DoMerchantCreditLinesApplyPO applyPO) throws Exception {
		// 初始化密码
		payPwdInit(model);
		// // 风控项初始化
		// GetCreditRiskResponseModel riskModel =
		// creditRiskService.getCreditRiskModel();
		// log.info("print risk content:" + riskModel);
		// model.put("riskModel", riskModel);
		model.put("applicantAmounts", ApplicantAmountEnum.values());
		model.put("showTip", debitConfigService.getByKey(ConfigEnums.VERIFY_SHOW_TIP));
		model.put("redisteredUrl", debitConfigService.getByKey(ConfigEnums.VERIFY_REGISTERED_URL));
		model.put("applicationAmounts", ApplicantAmountEnum.values());
		DoMerchantApplyFailLogPO failLog = null;
		if (applyPO != null) {
			failLog = doMerchantApplyFailLogService.getLastFailLog(applyPO.getId());
		}
		model.put("failReason", failLog == null ? null : "上次退件原因（" + new SimpleDateFormat("yyyy年MM月dd日").format(failLog.getCreateTime()) + "）："
				+ failLog.getFailReason());
	}

	/**
	 * 获取更新
	 *
	 * @return
	 * @throws Exception
	 */
	protected void setUpdateView(ModelMap model, DoMerchantCreditLinesApplyPO applyPo) throws Exception {
		// 初始化密码
		payPwdInit(model);
		if (applyPo != null) {
			model.put("showTip", debitConfigService.getByKey(ConfigEnums.VERIFY_SHOW_TIP));
			model.put("redisteredUrl", debitConfigService.getByKey(ConfigEnums.VERIFY_REGISTERED_URL));
			model.put("applicantAmounts", ApplicantAmountEnum.values());
			Map<String, DoMeCreditLinesApplyInfoPO> maps = creditLineManager.selectByDoApplyPO(applyPo);
			model.put("creditUserNameVal", creditLineManager.selectOtherInputByInputCode(applyPo.getMerchantNo(), "creditUserName"));
			model.put("creditPasswordVal", creditLineManager.selectOtherInputByInputCode(applyPo.getMerchantNo(), "creditPassword"));
			model.put("applyPo", applyPo);

			CreditLineApplyRequest creditLineApplyRequest = null;
			if (StringUtils.isNotBlank(applyPo.getApplyMerchantInfo())) {
				JSONObject applyInfo = JSONObject.fromObject(applyPo.getApplyMerchantInfo());
				JSONObject jsonObject = JSONObject.fromObject(applyInfo.toString());
				creditLineApplyRequest = (CreditLineApplyRequest) JSONObject.toBean(jsonObject, CreditLineApplyRequest.class);
			}
			model.put("creditLineApplyRequest", creditLineApplyRequest);
			DoMerchantApplyFailLogPO failLog = null;
			failLog = doMerchantApplyFailLogService.getLastFailLog(applyPo.getId());
			model.put("failReason", failLog == null ? null : "上次退件原因（" + new SimpleDateFormat("yyyy年MM月dd日").format(failLog.getCreateTime()) + "）："
					+ failLog.getFailReason());
		}
	}

	/**
	 * 获取协议额度内容
	 *
	 * @return
	 * @throws Exception
	 */
	private void setAgreementView(HttpServletRequest request, ModelMap model, DoMerchantCreditLinesApplyPO applyPo) throws Exception {
		if (StringUtils.isNotBlank(applyPo.getRiskLevel())) {
			DbOrgCreditSettingPO dbOrgCreditSettingPO = orgCreditSettingService.selectByRiskLevel(applyPo.getRiskLevel());
			if (dbOrgCreditSettingPO != null) {
				model.put("amountLimit", dbOrgCreditSettingPO.getAmountLimit().toString());
				BigDecimal totalRate = dbOrgCreditSettingPO.getInterestRateDay();
				// 取出利息占比
				// String _rateOfInterestInTotal =
				// this.debitConfigService.getByKey(ConfigEnums.DEBIT_ORDER_INTEREST_IN_TOTAL);
				// BigDecimal rateOfInterestInTotal = new
				// BigDecimal(_rateOfInterestInTotal);

				String serverRate = this.debitConfigService.getByKey(ConfigEnums.DEBIT_ORDER_SERVER_RATE);
				BigDecimal _serverRate = new BigDecimal(serverRate);
				BigDecimal fRate = totalRate.subtract(_serverRate);
				// BigDecimal fRate =
				// totalRate.multiply(rateOfInterestInTotal).setScale(2,
				// RoundingMode.HALF_UP);
				model.put("fRate", fRate.divide(BigDecimal.valueOf(100)));
				model.put("sRate", _serverRate.divide(BigDecimal.valueOf(100)));
			}
		}
	}

	/**
	 * 获取前n天时间
	 *
	 * @return
	 */
	private Date getCompareDays() {
		String days = debitConfigService.getByKey(ConfigEnums.APPLY_AFTER_DAYS);
		Integer intDay = 30;
		try {
			intDay = Integer.parseInt(days);
		} catch (Exception e) {
			log.error("parse int fail");
		}
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -intDay);
		return cal.getTime();
	}

	/**
	 * 报文响应
	 *
	 * @return
	 */
	private void returnJsonResponse(HttpServletResponse response, CreditLineResponseEnum msg) {
		CreditLineSaveResponse jsonResponse = new CreditLineSaveResponse();// 响应
		jsonResponse.setCode(msg.code);
		jsonResponse.setMsg(msg.name);
		writeJson(response, jsonResponse);
	}

	private void returnJsonResponse(HttpServletResponse response, String msg) {
		CreditLineSaveResponse jsonResponse = new CreditLineSaveResponse();// 响应
		jsonResponse.setMsg(msg);
		writeJson(response, jsonResponse);
	}

	/**
	 * 指定内容的报文响应
	 *
	 * @param response
	 * @param msg
	 * @param errorMsg
	 */
	private void returnContentJsonResponse(HttpServletResponse response, CreditLineResponseEnum msg, String errorMsg) {
		CreditLineSaveResponse jsonResponse = new CreditLineSaveResponse();// 响应
		jsonResponse.setCode(msg.code);
		jsonResponse.setMsg(errorMsg);
		writeJson(response, jsonResponse);
	}

	/**
	 * 将url参数转换成map
	 *
	 * @param param
	 *            aa=11&bb=22&cc=33
	 * @return
	 */
	private static Map<String, String> getUrlParams(String param) {
		Map<String, String> map = new HashMap<String, String>(0);
		if (StringUtils.isBlank(param)) { return map; }
		String[] params = param.split("&");
		for (int i = 0; i < params.length; i++) {
			String[] p = params[i].split("=");
			if (p.length == 2) {
				map.put(p[0], p[1]);
			}
		}
		return map;
	}

	// 基本校验
	private CreditLineResponseEnum baseCheck(CreditLineApplyRequest query) {
		if (query != null) {
			if (StringUtils.isBlank(query.getApplicantName())) {
				return CreditLineResponseEnum.APPLICANTNAME;
			} else if (StringUtils.isBlank(query.getApplicantIdNo())) {
				return CreditLineResponseEnum.APPLICANTIDNO;
			} else if (StringUtils.isBlank(query.getPositiveCardFileInfo().getStoreKey())) {
				return CreditLineResponseEnum.POSITIVECARDFILEINFO;
			} else if (StringUtils.isBlank(query.getBackCardFileInfo().getStoreKey())) {
				return CreditLineResponseEnum.BACKCARDFILEINFO;
			} else if (StringUtils.isBlank(query.getQuantityOfChildren())) {
				return CreditLineResponseEnum.QUANTITYOFCHILDREN;
			} else if (StringUtils.isBlank(query.getBusinessLicenseFileInfo().getStoreKey())) {
				return CreditLineResponseEnum.BUSINESSLICENSEFILEINFO;
			} else if (StringUtils.isBlank(query.getApplicantPhone())) {
				return CreditLineResponseEnum.APPLICANTPHONE;
			} else if (StringUtils.isBlank(query.getResidentialProvice()) || StringUtils.isBlank(query.getResidentialCity())
					|| StringUtils.isBlank(query.getResidentialStreet())) {
				return CreditLineResponseEnum.RESIDENTIAL;
			} else if (StringUtils.isBlank(query.getManageProvice()) || StringUtils.isBlank(query.getManageCity())
					|| StringUtils.isBlank(query.getManageStreet())) {
				return CreditLineResponseEnum.MANAGE;
			} else if (StringUtils.isBlank(query.getAccountBookFileInfo().getStoreKey())) {
				return CreditLineResponseEnum.ACCOUNTBOOKFILEINFO;
			} else if (query.getApplicantAmount() == null) { return CreditLineResponseEnum.APPLICANTAMOUNT; }

			// 对于已婚未婚处理
			if (MaritalStatusEnum.MARRIED.getCode().equals(query.getMaritalStatus())) {
				if (StringUtils.isBlank(query.getSpouseName()) || StringUtils.isBlank(query.getSpousePhone())
						|| StringUtils.isBlank(query.getSpouseIdNo())) {
					return CreditLineResponseEnum.RELATIVE;
				} else if (!((StringUtils.isNotBlank(query.getRelativeName1()) && StringUtils.isNotBlank(query.getRelativePhone1())) || (StringUtils
						.isNotBlank(query.getRelativeName2()) && StringUtils.isNotBlank(query.getRelativePhone2())))) {
					return CreditLineResponseEnum.RELATIVE;
				} else if (StringUtils.isNotBlank(query.getRelativeName1()) && StringUtils.isNotBlank(query.getRelativePhone1())) {
					if (query.getRelativeName1().equals(query.getSpouseName()) || query.getRelativePhone1().equals(query.getSpousePhone())) { return CreditLineResponseEnum.RELATIVEREPEAT; }
				} else if (StringUtils.isNotBlank(query.getRelativeName2()) && StringUtils.isNotBlank(query.getRelativePhone2())) {
					if (query.getRelativeName2().equals(query.getSpouseName()) || query.getRelativePhone2().equals(query.getSpousePhone())) { return CreditLineResponseEnum.RELATIVEREPEAT; }
				}
			} else {
				if (!(StringUtils.isNotBlank(query.getRelativeName1()) && StringUtils.isNotBlank(query.getRelativePhone1())
						&& StringUtils.isNotBlank(query.getRelativeName2()) && StringUtils.isNotBlank(query.getRelativePhone2()))) {
					return CreditLineResponseEnum.RELATIVE;
				} else if (query.getRelativeName1().equals(query.getRelativeName2()) && query.getRelativePhone1().equals(query.getRelativePhone2())) { return CreditLineResponseEnum.RELATIVEREPEAT; }
			}

			// 数字处理
			Pattern pattern = Pattern.compile("[0-9]*");
			if (!pattern.matcher(query.getQuantityOfChildren()).matches()) { return CreditLineResponseEnum.QUANTITYOFCHILDREN; }
		}
		return null;
	}

}
