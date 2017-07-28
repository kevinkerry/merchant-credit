package com.sdp.mc.intra.web;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mc.service.api.enums.WhiteTypeEnums;
import com.sdo.common.util.DateUtil;
import com.sdp.emall.intra.admin.security.util.SecurityUserHolder;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.enums.AuditInfoStateEnum;
import com.sdp.mc.common.enums.FsConfigChangeStatusEnum;
import com.sdp.mc.common.enums.LoaningTypeEnum;
import com.sdp.mc.common.enums.MarginOpAddEnums;
import com.sdp.mc.common.enums.MessageTemplateCodeEnum;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.common.enums.WithCapitalEnums;
import com.sdp.mc.common.model.AuditInfoRequestAdustLog;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.vo.MerchantFastSettleVO;
import com.sdp.mc.facade.msp.MspFacade;
import com.sdp.mc.ffconfig.dao.FastSettleConfigDO;
import com.sdp.mc.ffconfig.dao.ext.FastSettleConfigDOExampleExt;
import com.sdp.mc.ffconfig.dao.ext.FastSettleConfigDOExt;
import com.sdp.mc.ffconfig.manager.FastSettleConfigManager;
import com.sdp.mc.integration.ma.dto.MerchantBalanceDTO;
import com.sdp.mc.integration.ma.dto.Promoter4MADTO;
import com.sdp.mc.integration.msp.MerchantInfoDTO;
import com.sdp.mc.integration.msp.PromoterInfoDTO;
import com.sdp.mc.intra.web.util.FastSettleConverterUtil;
import com.sdp.mc.ma.wrapper.AccountQueryFacadeWrapper;
import com.sdp.mc.margin.dao.MarginOpReqDO;
import com.sdp.mc.margin.dao.ext.MarginOpReqDOExampleExt;
import com.sdp.mc.margin.dao.ext.MarginOpReqDOExt;
import com.sdp.mc.margin.manager.MarginOpReqManager;
import com.sdp.mc.mcwithfunding.dao.WithCapital4PromoterDO;
import com.sdp.mc.mcwithfunding.dao.ext.WithCapitalReqDOExampleExt;
import com.sdp.mc.mcwithfunding.manager.WithCapital4PromoterManager;
import com.sdp.mc.msp.dao.FsConfigChangeDO;
import com.sdp.mc.msp.manager.FsConfigChangeManager;
import com.sdp.mc.newt0.dao.AuditInfoDTO;
import com.sdp.mc.newt0.dao.ExtNewT0AuditInfoDOExample;
import com.sdp.mc.newt0.dao.Newt0PromoterDO;
import com.sdp.mc.newt0.dao.WhiteListInfoDO;
import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDO;
import com.sdp.mc.promoter.manager.PromoterFastSettleSwitchManager;
import com.sdp.mc.service.AuditInfoService;
import com.sdp.mc.service.apply.FastSettleApply;
import com.sdp.mc.service.apply.PromoterFastSettleSwitch;
import com.sdp.mc.service.credit4promoter.MCWithCapital4PromoterService;
import com.sdp.mc.service.fastsettle.FastSettle;
import com.sdp.mc.service.fastsettle.margin.MarginOpService;
import com.sdp.mc.service.mcbizaccount.BizApplyOpenAccountService;
import com.sdp.mc.service.msp.promoter.PromoterPO;
import com.sdp.mc.service.msp.promoter.PromoterRO;
import com.sdp.mc.service.msp.promoter.PromoterService;
import com.sdp.mc.service.newt0.Newt0PromoterService;
import com.sdp.mc.service.op.state.OpContext;
import com.sdp.mc.service.op.state.margin.OpTransferSuccessState;
import com.sdp.mc.view.dao.ViewPromoterInfoDTO;
import com.sdp.withdraw.service.LimitationService;
import com.sdp.withdraw.service.WithdrawReqService;
import com.shengpay.commons.core.base.PaginationBaseObject;
import com.shengpay.facade.ma.MAFacade;
import com.shengpay.pos.pcs.api.settle.StraightlyCfg;
import com.shengpay.service.view.PromoterInfoService;
import com.shengpay.service.whitelist.WhiteListInfoService;
import com.shengpay.service.withdraw.T0WithdrawService;

/**
 * 快速结算大菜单
 * **/
@Controller
@RequestMapping("/fastSettle")
public class FastSettleIntraAction {

	private static final Logger log = LoggerFactory.getLogger(FastSettleIntraAction.class);

	@Autowired
	private PromoterService promoterService;

	@Autowired
	private MspFacade mspFacade;

	@Autowired
	private MarginOpReqManager marginOpReqManager;

	@Autowired
	private PromoterFastSettleSwitchManager promoterFastSettleSwitchManager;

	@Autowired
	private FastSettleConfigManager fastSettleConfigManager;

	@Autowired
	private FastSettleApply fastSettleApply;

	@Autowired
	private AccountQueryFacadeWrapper accountQueryFacadeWrapper;

	@Autowired
	private PromoterFastSettleSwitch promoterFastSettleSwitch;

	@Autowired
	private MarginOpService marginOpService;

	@Autowired
	private FastSettle fastSettle;

	@Autowired
	private BizApplyOpenAccountService bizApplyOpenAccountService;

	@Autowired
	private MCWithCapital4PromoterService mcWithCapital4PromoterService;

	@Autowired
	private WithCapital4PromoterManager withCapital4PromoterManager;

	@Autowired
	private AuditInfoService auditInfoService;

	@Autowired
	private OpTransferSuccessState transferSuccessState;

	@Autowired
	private FsConfigChangeManager fsConfigChangeManager;

	@Autowired
	private Newt0PromoterService newt0PromoterService;

	@Autowired
	private MAFacade maFacade;

	@Autowired
	private LimitationService limitationService;
	@Autowired
	private WithdrawReqService withdrawReqService;
	@Autowired
	private T0WithdrawService  t0WithdrawService;
	@Autowired
	private WhiteListInfoService  whiteListInfoService;
	@Autowired
	private PromoterInfoService  promoterInfoService;

	// //-----------------------------------交易管理------------begin---------------
	/**
	 * 交易管理菜单--首页
	 * **/
	@RequestMapping(value = "/transIndex")
	public String transIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		log.info("transIndex");
		return "/fastSettle/trans/index";
	}

	/**
	 * 交易管理菜单--ajax 分页查询
	 * **/
	/*
	 * @RequestMapping(value = "/ajaxPaging/transQuery") public String
	 * transQuery(@ModelAttribute("params") McQueryMspTxnCond params,
	 * HttpServletRequest request, HttpServletResponse response, ModelMap model)
	 * { if (StringUtils.isNotBlank(params.getCsSettleFlag())) {
	 * params.setMerchantNo(params.getMerchantNo().trim());//暂时先处理了商户号
	 * params.setPmtMerchantNo(params.getPmtMerchantNo().trim());//暂时先处理了商户号
	 * McQueryMspTxnCond po =
	 * FastSettleConverterUtil.queryMspTxnParamsToPo(params); //
	 * PaginationBaseObject<McMspTxnRO> query =
	 * mspTxnService.pagingMcQueryMspTxn(po);
	 * PaginationBaseObject<McFsTradeTxnVO> query =
	 * mspTxnService.pagingMcQueryFsTradeTxn(po); model.put("query", query); }
	 * return "/fastSettle/trans/transList"; }
	 */

	/** 交易详情 **/
	// @RequestMapping(value = "/transDetail")
	// public String transDetail(Long txnNo, HttpServletRequest request,
	// HttpServletResponse response, ModelMap model) {
	// McMspTxnRO o = mspTxnService.getMcMspTxnROByTxnNo(txnNo);
	// model.put("o", o);
	// return "/fastSettle/trans/transDetail";
	// }

	// //-----------------------------------交易管理------------end---------------
	/**
	 * 申请单管理菜单
	 * **/
	@RequestMapping(value = "/applyOrderQuery")
	public String applyOrder(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return FastSettleConverterUtil.formatOperatingURL("redirect:{0}/fsr/toQuery.do");
	}

	/**
	 * 结算单管理菜单
	 * **/
	@RequestMapping(value = "/settleOrderQuery")
	public String settleOrder(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return FastSettleConverterUtil.formatOperatingURL("redirect:{0}/fsr/toQuery.do");
	}

	/**
	 * 商户查询
	 * **/
	@RequestMapping(value = "/merchantQuery")
	public String merchantQuery(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return FastSettleConverterUtil.formatOperatingURL("redirect:{0}/posMerchant/toFastSettleQuery.do");
	}

	// /////////////-----拓展方管理---------------begin---------------
	/**
	 * 拓展方管理--首页
	 * **/
	@RequestMapping(value = "/promoterIndex")
	public String promoterIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		// ----取得所有地区-------------
		/*
		 * List<DistrictRO> countryList = DistrictHelper.getCountryList();
		 * model.put("countryList", countryList);
		 */
		return "/fastSettle/promoter/index";
	}

	/**
	 * 拓展方管理--ajax 分页查询
	 * **/
	@RequestMapping(value = "/ajaxPaging/promoterQuery")
	public String promoterQuery(@ModelAttribute("params") PromoterPO params, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		PaginationBaseObject<PromoterRO> query = this.promoterService.queryPromoter(params);
		model.put("query", query);
		return "/fastSettle/promoter/promoterList";
	}

	/**
	 * 拓展方管理--详情
	 **/
	@RequestMapping(value = "/promoterDetail")
	public String promoterDetail(Long id, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		PromoterRO promoter = promoterService.queryPromoterInfoById(id);
		model.put("promoter", promoter);
		return "/fastSettle/promoter/promoterDetail";
	}

	/**
	 * 拓展方管理--保证金管理
	 **/
	@RequestMapping("/showMargin")
	public String showMargin(Long id, HttpServletRequest request, ModelMap model) {
		// ----取得所有地区-------------
		// List<DistrictRO> provinceList = DistrictHelper.getAllProvince();
		// 获取拓展商信息
		PromoterRO promoter = promoterService.queryPromoterInfoById(id);
		PromoterInfoDTO promoterDTO = this.mspFacade.findPromoterInfoByPromoterId(id);
		if (promoterDTO == null || StringUtils.isBlank(promoterDTO.getPromoterType())) {
			log.error("FastSettleIntraAction.showMargin.error,promoterDTO is null");
			return "/fastSettle/promoter/margin";
		} else {
			BigDecimal canUseQuota = limitationService.findMerchantFastCanUseQuota(promoterDTO.getPromoterNo() + "", promoterDTO.getPromoterType());
			canUseQuota = canUseQuota == null ? new BigDecimal(0) : canUseQuota;
			promoterDTO.setValidCredit(canUseQuota.toString());
		}
		// StraightlyCfg straightlyCfg = mspFacade.getPromoterCredit(id);
		model.put("promoterDTO", promoterDTO);
		// model.put("provinceDistrictList", provinceList);
		model.put("promoter", promoter);
		// 追加且转账成功的金额
		BigDecimal amount = marginOpService.queryMarginOpReqSum(id, OpTypeEnums.ADD.code, MarginOpAddEnums.TRANSFER_SUCCESS.code);
		model.put("amount", amount);
		model.put("fastSettleMargin", promoter.getFastSettleMargin() == null ? amount : amount.add(promoter.getFastSettleMargin()));

		PromoterFastSettleSwitchDO pfss = this.promoterFastSettleSwitch.queryPromoterFastSettleSwitchByPromoterId(id);
		if (pfss != null) {
			try {
				MerchantBalanceDTO merchantBalance = this.accountQueryFacadeWrapper.queryMerchantBalance(pfss.getMarginMemberId(),promoterDTO.getPromoterType());
				model.put("merchantBalance", merchantBalance);
			} catch (Exception e) {
				log.error("FastSettleIntraAction.showMargin.error,promoterId=" + id, e);
			}
		}
		// t+0已申请配资金额
		BigDecimal totalWithCapital = this.withCapital4PromoterManager.sumWithCapitalAmountByPromoterId(id);
		model.put("totalWithCapital", totalWithCapital == null ? BigDecimal.valueOf(0) : totalWithCapital);

		return "/fastSettle/promoter/margin";
	}

	/**
	 * 拓展方管理--初始化开通快速结算、追加保证金
	 **/
	@RequestMapping("/initFastSettleMgt")
	public String initFastSettleMgt(Long id, HttpServletRequest request, ModelMap model) {
		PromoterInfoDTO promoterDTO = this.mspFacade.findPromoterInfoByPromoterId(id);
		model.put("promoter", promoterDTO);
		PromoterFastSettleSwitchDO pfss = this.promoterFastSettleSwitch.queryPromoterFastSettleSwitchByPromoterId(id);
		model.put("pfss", pfss);
		if (pfss != null) {
			try {
				MerchantBalanceDTO merchantBalance = this.accountQueryFacadeWrapper.queryMerchantBalance(pfss.getMarginMemberId(),promoterDTO.getPromoterType());
				model.put("merchantBalance", merchantBalance);
			} catch (Exception e) {
				log.error("FastSettleIntraAction.showMargin.error,promoterId=" + id, e);
			}
		}
		return "/fastSettle/promoter/fastSettleMgt";
	}

	/**
	 * 拓展方管理--开通快速结算账户
	 *
	 * @param id代理商编号
	 **/
	@RequestMapping("/openAccount")
	@ResponseBody
	public ErrorMessageVO openAccount(Long promoterId, HttpServletRequest request, ModelMap model) {
		PromoterInfoDTO promoterDTO = this.mspFacade.findPromoterInfoByPromoterId(promoterId);
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		String operatorId = user.getUserName();
		return this.fastSettleApply.applyOpen4Intra(promoterDTO.getPromoterNo(),promoterId,promoterDTO.getPromoterType(), operatorId);
	}

	/**
	 * 拓展方管理--关闭快速结算账户
	 *
	 * @param id代理商编号
	 **/
	@RequestMapping("/closeAccount")
	@ResponseBody
	public ErrorMessageVO closeAccount(Long promoterId, HttpServletRequest request, ModelMap model) {
		// 为了区分mpos和pos，需要去查询msp表上的保证金金额，不能查询216储值账户余额
		PromoterInfoDTO promoterDTO = this.mspFacade.findPromoterInfoByPromoterId(promoterId);
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		String operatorId = user.getUserName();
		return this.fastSettleApply.applyClose4Intra(promoterDTO, operatorId);
	}

	/**
	 * 拓展方管理--追加保证金
	 **/
	@RequestMapping("/addMargin")
	@ResponseBody
	public ErrorMessageVO<Object> addMargin(Long promoterId, String amount, HttpServletRequest request, ModelMap model) {

		PromoterFastSettleSwitchDO pfss = this.promoterFastSettleSwitch.queryPromoterFastSettleSwitchByPromoterId(promoterId);
		if (pfss != null && (OpTypeEnums.CLOSE.code == pfss.getType() || StringUtils.isEmpty(pfss.getMarginAccount()))) {
			// 开通记录为空，正在执行关闭操作，储值账户未开通，不能操作并提示弹框
			log.info("FastSettleIntraAction #addMargin,promoterId:" + promoterId + " is closing fastsettle.");
			return new ErrorMessageVO<Object>(false, null, "对不起，您还未开通快速结算服务功能，请先开通");
		}

		BigDecimal _amount = new BigDecimal(amount);
		PromoterInfoDTO promoterInfoDTO = mspFacade.findPromoterInfoByPromoterId(promoterId);
		@SuppressWarnings("deprecation")
		Promoter4MADTO promoter4madto = maFacade.queryPromoterInfoByMerchantNo(String.valueOf(promoterInfoDTO.getPromoterNo()));
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		String operatorId = user.getUserName();
		return this.marginOpService.validateAndAddMargin(promoterId, _amount, OpTypeEnums.ADD, promoter4madto.getMemberId(), true, operatorId);
	}
	/**
	 * 拓展方管理--修改保证金
	 **/
	@RequestMapping("/modifyMargin")
	@ResponseBody
	public ErrorMessageVO<Object> modifyMargin(Long promoterId, String amount, HttpServletRequest request, ModelMap model) {
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		log.info("modifyMargin，promoterId:" + promoterId + " ，amount："+amount+"  user:"+ToStringBuilder.reflectionToString(user));
		PromoterFastSettleSwitchDO pfss = this.promoterFastSettleSwitch.queryPromoterFastSettleSwitchByPromoterId(promoterId);
		if (pfss != null && (OpTypeEnums.CLOSE.code == pfss.getType() || StringUtils.isEmpty(pfss.getMarginAccount()))) {
			// 开通记录为空，正在执行关闭操作，储值账户未开通，不能操作并提示弹框
			log.info("FastSettleIntraAction #addMargin,promoterId:" + promoterId + " is closing fastsettle.");
			return new ErrorMessageVO<Object>(false, null, "对不起，您还未开通快速结算服务功能，请先开通");
		}
		BigDecimal _amount = new BigDecimal(amount);
		PromoterInfoDTO promoterInfoDTO = mspFacade.findPromoterInfoByPromoterId(promoterId);
		@SuppressWarnings("deprecation")
		Promoter4MADTO promoter4madto = maFacade.queryPromoterInfoByMerchantNo(String.valueOf(promoterInfoDTO.getPromoterNo()));
		String operatorId = user.getUserName();
		return this.marginOpService.modifyMargin(promoterId, _amount, OpTypeEnums.MODIFY, promoter4madto.getMemberId(), operatorId);
	}

	/**
	 * 拓展方管理--取回保证金
	 **/
	@RequestMapping("/takeBackMargin")
	@ResponseBody
	public ErrorMessageVO<Object> takeBackMargin(Long promoterId, String amount, HttpServletRequest request, ModelMap model) {
		try {
			BigDecimal _amount = new BigDecimal(amount);
			PromoterInfoDTO promoterInfoDTO = mspFacade.findPromoterInfoByPromoterId(promoterId);
			@SuppressWarnings("deprecation")
			Promoter4MADTO promoter4madto = maFacade.queryPromoterInfoByMerchantNo(String.valueOf(promoterInfoDTO.getPromoterNo()));
			com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
			String operatorId = user.getUserName();
			return this.marginOpService.validateAndRedeemMargin(promoterId, _amount, OpTypeEnums.REDEEMED, promoter4madto.getMemberId(), true,
					operatorId);
		} catch (Exception e) {
			log.error("redeemMargin Exception" + e.getMessage(), e);
			return new ErrorMessageVO(false, null, MerchantCreditConstant.MC_MARGIN_REDEEM_EXCEPTION);
		}
	}



	// /////////////-----拓展方管理---------------end---------------
	/**
	 * 商户管理
	 * **/
	@RequestMapping(value = "/merchantMgt")
	public String merchantMgt(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return FastSettleConverterUtil.formatOperatingURL("redirect:{0}/posMerchant/toQuery.do");
	}

	/**
	 * 分润管理
	 * **/
	@RequestMapping(value = "/profitQuery")
	public String profitQuery(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return FastSettleConverterUtil.formatOperatingURL("redirect:{0}/profit/statistic/toQueryStatistic.do");
	}

	// ///----------------------------保证金交易查询--------------begin------------------
	/**
	 * 保证金交易查询--首页
	 * **/
	@RequestMapping(value = "/marginTransIndex")
	public String marginTransIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/fastSettle/margin/index";
	}

	/**
	 * 保证金交易查询--分页查询
	 * **/
	@RequestMapping(value = "/ajaxPaging/marginTransQuery")
	public String marginTransQuery(@ModelAttribute("query") MarginOpReqDOExampleExt query, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		List<MarginOpReqDOExt> dataList = this.marginOpReqManager.selectByQuery4Intra(query);
		model.put("dataList", dataList);
		model.put("query", query);
		return "/fastSettle/margin/marginList";
	}
	/**
	 * 保证金交易查询--分页查询
	 * **/
	@RequestMapping(value = "/modifyRedeemMarginTime")
	@ResponseBody
	public ErrorMessageVO<Object> modifyRedeemMarginTime(Long morId,  HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		log.info("modifyRedeemMarginTime start,morId:"+morId);
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		log.info("user:" + ToStringBuilder.reflectionToString(user,ToStringStyle.SHORT_PREFIX_STYLE));
		String message=null;
		if(morId!=null){
			MarginOpReqDO req=this.marginOpReqManager.selectByPrimaryKey(morId);
			if(req!=null){
				MarginOpReqDO data=new MarginOpReqDO();
				data.setRedeemedTime(new Date());
				data.setMorId(morId);
				data.setUpdateTime(new Date());
				this.marginOpReqManager.updateByPrimaryKeySelective(data);
			}else{
				message="无对应数据";
			}
		}else{
			message="操作数据ID必须条件";
		}
		if(message!=null){
			return new ErrorMessageVO<Object>(false,"-1",message);
		}
		return new ErrorMessageVO<Object>(true);
	}
	
	@RequestMapping(value = "/modifyRedeemMarginStatus")
	@ResponseBody
	public ErrorMessageVO<Object> modifyRedeemMarginStatus(Long morId,Integer sourceStatus,Integer targetStatus,  HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		log.info("modifyRedeemMarginStatus start,morId:{}，sourceStatus：{}，targetStatus：{}",new Object[]{morId,sourceStatus,targetStatus});
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		log.info("user:" + ToStringBuilder.reflectionToString(user,ToStringStyle.SHORT_PREFIX_STYLE));
		String message=null;
		if(morId!=null){
			MarginOpReqDO req=this.marginOpReqManager.selectByPrimaryKey(morId);
			if(req!=null&&req.getStatus().equals(sourceStatus)){
				MarginOpReqDO data=new MarginOpReqDO();
				data.setMorId(morId);
				data.setStatus(targetStatus);
				data.setUpdateTime(new Date());
				int num=this.marginOpReqManager.updateByPrimaryKeySelective(data);
				if(num<1){
					message="无更新数据";
				}
			}else{
				message="无对应数据";
			}
		}else{
			message="操作数据ID必须条件";
		}
		if(message!=null){
			return new ErrorMessageVO<Object>(false,"-1",message);
		}
		return new ErrorMessageVO<Object>(true);
	}

	// ///----------------------------保证金交易查询--------------end------------------
	// ///-------------------------------拓展方在线申请管理-----------begin---------------

	/**
	 * 拓展方在线申请管理--首页
	 * **/
	@RequestMapping(value = "/newt0/applyOnlineIndex")
	public String newT0ApplyOnlineIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/newt0/apply/index";
	}

	/**
	 * 拓展方在线申请管理--分页查询
	 * **/
	@RequestMapping(value = "/newt0/ajaxPaging/applyOnlineQuery")
	public String newT0ApplyOnlineQuery(@ModelAttribute("query") ExtNewT0AuditInfoDOExample query, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		// query.setStatus(OpOpenAndCloseEnums.CONFIGURE_SUCCESS.getCode());//
		// 开通申请成功
		List<AuditInfoDTO> dataList = this.auditInfoService.selectAuditInfoByQuery(query);
		model.put("dataList", dataList);
		model.put("query", query);
		return "/newt0/apply/applyOnlineList";
	}

	/**
	 * 修改代理商快速结算的信息（额度，垫资方类型）
	 * **/
	@RequestMapping(value = "/newt0/fastSettleEdit")
	public String fastSettleEdit(Long mcId, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.put("mcId", mcId);
		Newt0PromoterDO promoter = newt0PromoterService.getPromoterByMerchantId(mcId);
		model.put("promoter", promoter);
		 BigDecimal amount = marginOpService.queryMarginOpReqSum(mcId,
		 OpTypeEnums.ADD.code, MarginOpAddEnums.TRANSFER_SUCCESS.code);
		PromoterInfoDTO promoterInfoDTO = mspFacade.findPromoterInfoByPromoterId(mcId);
		// 保证金金额
		BigDecimal fastSettleMargin = (StringUtils.isEmpty(promoterInfoDTO.getFastSettleMargin()) ? new BigDecimal(0) : new BigDecimal(
				promoterInfoDTO.getFastSettleMargin().trim())).setScale(2, BigDecimal.ROUND_HALF_DOWN);
		// 保证金额度
		// model.put("oldFastSettleMargin", fastSettleMargin);
		model.put("amount", amount);
		model.put("fastSettleMargin", fastSettleMargin);
		model.put("fastSettleLimit", promoterInfoDTO.getFastSettleLimit());
		List<FsConfigChangeDO> dataList = fsConfigChangeManager.selectSpecialPageSizeChanges(mcId, OpTypeEnums.MERCHANT_FASTSETTLE_AUTO_CHANGE.code,
				FsConfigChangeStatusEnum.SUCCESS.code);
		if (dataList != null && dataList.size() > 0) {
			model.put("dataList", dataList);
		}
		WhiteListInfoDO whiteInfo = whiteListInfoService.queryWhiteListInfo(WhiteTypeEnums.PROMOTER_MIN_MARGIN.code,
				promoterInfoDTO.getPromoterNo()+"", promoterInfoDTO.getPromoterType());

		if(whiteInfo!=null&&StringUtils.isNotBlank(whiteInfo.getContent())){
			model.put("promoterMinMargin", whiteInfo.getContent());
		}
		return "/fastSettle/promoter/fastSettleEdit";
	}

	@RequestMapping(value = "/newt0/applyOnlineInitEdit")
	public String applyOnlineInitEdit(Long mcId, Long id, HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		AuditInfoDTO auditInfo = this.auditInfoService.selectAuditInfoById(id);
		if (auditInfo != null && AuditInfoStateEnum.WAIT_AUDIT.getStatus() == auditInfo.getStatus()) {
			model.put("auditInfo", auditInfo);
			model.put("todayLimit", getTodayLimit(auditInfo.getPromoterMerchantNo(),auditInfo.getPromoterType()));
		}
		model.put("mcId", mcId);
		Newt0PromoterDO promoter = newt0PromoterService.getPromoterByMerchantId(mcId);
		model.put("promoter", promoter);
		BigDecimal amount = marginOpService.queryMarginOpReqSum(mcId, OpTypeEnums.ADD.code, MarginOpAddEnums.TRANSFER_SUCCESS.code);
		PromoterInfoDTO promoterInfoDTO = mspFacade.findPromoterInfoByPromoterId(mcId);
		// 保证金金额
		BigDecimal fastSettleMargin = (StringUtils.isEmpty(promoterInfoDTO.getFastSettleMargin()) ? new BigDecimal(0) : new BigDecimal(
				promoterInfoDTO.getFastSettleMargin().trim())).setScale(2, BigDecimal.ROUND_HALF_DOWN);
		// 保证金额度
		model.put("oldFastSettleMargin", fastSettleMargin);
		model.put("amount", amount);
		model.put("fastSettleMargin", fastSettleMargin.add(amount).setScale(2, BigDecimal.ROUND_HALF_DOWN));
		model.put("fastSettleLimit", promoterInfoDTO.getFastSettleLimit());
		// List<FsConfigChangeDO> dataList =
		// fsConfigChangeManager.selectSpecialPageSizeChanges(mcId,
		// OpTypeEnums.MERCHANT_FASTSETTLE_AUTO_CHANGE.code,
		// FsConfigChangeStatusEnum.SUCCESS.code);
		// if (dataList != null && dataList.size() > 0) {
		// model.put("dataList", dataList);
		// }
		// auditInfoService.updateWaitAuditToAuditing(null, mcId, operator,
		// operatorId);
		return "/newt0/apply/audit";
	}

	private BigDecimal getTodayLimit(String promoterMerchantNo, String promoterType) {
		BigDecimal todayLimit=t0WithdrawService.getWithdrawT0ServiceAPI().findTotalAmount(promoterMerchantNo, promoterType);
		return todayLimit==null?BigDecimal.ZERO:todayLimit;
	}

	@RequestMapping(value = "/newt0/applyOnlineDetail")
	public String applyOnlineDetail(Long mcId, Long id, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		AuditInfoDTO auditInfo = this.auditInfoService.selectAuditInfoById(id);
		if (auditInfo != null) {
			model.put("auditInfo", auditInfo);
			model.put("todayLimit", getTodayLimit(auditInfo.getPromoterMerchantNo(),auditInfo.getPromoterType()));
		}

		model.put("mcId", mcId);
		Newt0PromoterDO promoter = newt0PromoterService.getPromoterByMerchantId(mcId);
		model.put("promoter", promoter);
		BigDecimal amount = marginOpService.queryMarginOpReqSum(mcId, OpTypeEnums.ADD.code, MarginOpAddEnums.TRANSFER_SUCCESS.code);
		PromoterInfoDTO promoterInfoDTO = mspFacade.findPromoterInfoByPromoterId(mcId);
		// 保证金金额
		BigDecimal fastSettleMargin = (StringUtils.isEmpty(promoterInfoDTO.getFastSettleMargin()) ? new BigDecimal(0) : new BigDecimal(
				promoterInfoDTO.getFastSettleMargin().trim())).setScale(2, BigDecimal.ROUND_HALF_DOWN);
		// 保证金额度
		model.put("oldFastSettleMargin", fastSettleMargin);
		model.put("amount", amount);
		model.put("fastSettleMargin", fastSettleMargin.add(amount).setScale(2, BigDecimal.ROUND_HALF_DOWN));
		model.put("fastSettleLimit", promoterInfoDTO.getFastSettleLimit());
		return "/newt0/apply/detail";
	}

	/**
	 * 拓展方在线申请管理--修改
	 * **/
	@RequestMapping(value = "/newt0/applyOnlineSaveEdit")
	@ResponseBody
	public ErrorMessageVO<Object> applyOnlineSaveEdit(Long mcId, Long id, Integer loaningType, String auditResult, String auditDesc,
			BigDecimal fastSettleLimit, HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		int opType = OpTypeEnums.ADD.code;
		AuditInfoDTO auditInfo = null;
		if (id == null) { return new ErrorMessageVO<Object>(false, null, "申请数据不存在"); }
		auditInfo = this.auditInfoService.selectAuditInfoById(id);
		if (auditInfo == null) { return new ErrorMessageVO<Object>(false, null, "申请数据不存在"); }
		opType = auditInfo.getOpType();
		if (AuditInfoStateEnum.WAIT_AUDIT.getStatus() != auditInfo.getStatus()) { return new ErrorMessageVO<Object>(false, null, "数据已经审批！请确认"); }
		if (StringUtils.isBlank(auditResult)) { return new ErrorMessageVO<Object>(false, null, "审批结果不能为空"); }
		
		if (StringUtils.isBlank(auditDesc)&&!MerchantCreditConstant.STRING_TRUE.equalsIgnoreCase(auditResult)) { return new ErrorMessageVO<Object>(false, null, "拒绝理由不能为空！"); }

		String operator = SecurityUserHolder.getAuthUser().getUser().getRealName();
		String operatorId = SecurityUserHolder.getAuthUser().getUser().getUserName();
		ErrorMessageVO<Object> messageVO = null;
		ErrorMessageVO<Object> errorMessageVO;
		String messageTemplateCode = null;
		Map<String, String> map = new HashMap<String, String>();
		int auditStatus = MerchantCreditConstant.STRING_TRUE.equalsIgnoreCase(auditResult) ? AuditInfoStateEnum.AUDITED.getStatus()
				: AuditInfoStateEnum.REJECT.getStatus();
		try {
			if (OpTypeEnums.SHENGPAY_PROMPTER_ADJUST_LIMIT.code == opType) {
				AuditInfoRequestAdustLog tempLimitInfo = auditInfo.getTempLimitInfo();
				tempLimitInfo.setAuditDesc(auditDesc);
				tempLimitInfo.setAuditResult(auditResult);
				tempLimitInfo.setAuditLimit(fastSettleLimit);
				messageTemplateCode = MerchantCreditConstant.STRING_TRUE.equalsIgnoreCase(auditResult) ? MessageTemplateCodeEnum.AUDIT_TEMP_LIMIT_SUCCESS
						.getKey() : MessageTemplateCodeEnum.AUDIT_TEMP_LIMIT_FAIL.getKey();
				errorMessageVO = auditInfoService.updateWaitAuditToAudited(id, mcId, auditStatus, operator, operatorId,
						tempLimitInfo.convertToJsonString());
				if (MerchantCreditConstant.STRING_TRUE.equalsIgnoreCase(auditResult)) {
					map.put("amount", fastSettleLimit.toString());
				}else{
					map.put("cause", auditDesc);
				}
			} else {
				if (loaningType==null&&AuditInfoStateEnum.AUDITED.getStatus() == auditStatus) { return new ErrorMessageVO<Object>(false, null, "垫资方类型不能为空"); }
				OpContext context = new OpContext();
				context.setPromoterId(mcId);
				context.setLoaningType(LoaningTypeEnum.getLoaningTypeEnum(AuditInfoStateEnum.REJECT.getStatus() == auditStatus ? auditInfo
						.getLoaningType() : loaningType));
				context.setOpType(OpTypeEnums.PROMOTER_FASTSETTLE_CHANGE.getCode());
				context.setAuditResult(auditResult);
				context.setBizId(id);
				context.setAuditLimit(fastSettleLimit);
				context.setAuditDesc(auditDesc);
				if (LoaningTypeEnum.SHENGPAY == context.getLoaningType()) {// 盛付通全资才允许填写
					context.setFastSettleLimit(AuditInfoStateEnum.REJECT.getStatus() == auditStatus ? auditInfo.getPromoterFsLimit()
							: fastSettleLimit);
				}
				errorMessageVO = transferSuccessState.batchHandlerOpState(context, operator, operatorId);
				messageTemplateCode = MerchantCreditConstant.STRING_TRUE.equalsIgnoreCase(auditResult) ? MessageTemplateCodeEnum.AUDIT_ADDMARGIN_SUCCESS
						.getKey() : null;
				map.put("fastSettleLimit", fastSettleLimit==null?"":fastSettleLimit.toString());
				map.put("date", DateUtil.getWebDateString(new Date()));
				if (!MerchantCreditConstant.STRING_TRUE.equalsIgnoreCase(auditResult)) {
					map.put("cause", auditDesc);
				}
			}
			if (errorMessageVO.isSuccess()) {
				messageVO = new ErrorMessageVO<Object>(true, null, "审核成功！");
				if (messageTemplateCode != null) {
					marginOpService.sendMessage(mcId, messageTemplateCode, map);
				}
			} else {
				messageVO = new ErrorMessageVO<Object>(false, null, "审核失败！");
			}
		} catch (Exception e) {
			log.error("FastSettleIntraAction.applyOnlineSaveEdit.error,mcId=" + mcId, e);
			messageVO = new ErrorMessageVO<Object>(false, null, "系统繁忙");
		}
		return messageVO;
	}
	@RequestMapping(value = "/newt0/applyUndoInit")
	public String applyUndoInit(Long id, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		AuditInfoDTO auditInfo = this.auditInfoService.selectAuditInfoById(id);
		if (auditInfo != null&& AuditInfoStateEnum.AUDITED.getStatus() == auditInfo.getStatus()) {
			model.put("auditInfo", auditInfo);
			model.put("todayLimit", getTodayLimit(auditInfo.getPromoterMerchantNo(),auditInfo.getPromoterType()));
		}
		return "/newt0/apply/undo";
	}

	@RequestMapping("/newt0/saveUndo")
	@ResponseBody
	public ErrorMessageVO<Object> saveUndo(Long id, String undoCause, HttpServletRequest request, ModelMap model) {
		try {
			if (id == null) { return new ErrorMessageVO<Object>(false, null, "撤销数据不存在"); }
			if (StringUtils.isBlank(undoCause)) { return new ErrorMessageVO<Object>(false, null, "撤销理由不能为空！"); }
			AuditInfoDTO auditInfo = this.auditInfoService.selectAuditInfoById(id);
			if (auditInfo == null) { return new ErrorMessageVO<Object>(false, null, "撤销数据不存在"); }
			if (AuditInfoStateEnum.AUDITED.getStatus() != auditInfo.getStatus()) { return new ErrorMessageVO<Object>(false, null, "数据非已经审批！请确认"); }
			if (OpTypeEnums.SHENGPAY_PROMPTER_ADJUST_LIMIT.code != auditInfo.getOpType()) { return new ErrorMessageVO<Object>(false, null, "非临时调额数据！请确认"); }
			String operator = SecurityUserHolder.getAuthUser().getUser().getRealName();
			String operatorId = SecurityUserHolder.getAuthUser().getUser().getUserName();
			AuditInfoRequestAdustLog tempLimitInfo = auditInfo.getTempLimitInfo();
			tempLimitInfo.setUndoCause(undoCause);
			tempLimitInfo.setUndoOperator(operator);
			tempLimitInfo.setUndoOperatorId(operatorId);
			int updateRow = auditInfoService.updateStatus(id,null,null,AuditInfoStateEnum.AUDITED.getStatus(), AuditInfoStateEnum.UNDO.getStatus(), null, null
					,tempLimitInfo.convertToJsonString());
			if(updateRow>0){
				Map<String, String> map = new HashMap<String, String>();
				map.put("amount", auditInfo.getPromoterFsLimit()==null?"0":auditInfo.getPromoterFsLimit().toString());
				map.put("cause", undoCause);
				marginOpService.sendMessage(auditInfo.getPromoterId(), MessageTemplateCodeEnum.AUDIT_TEMP_LIMIT_UNDO.getKey(), map);
			}
			return new ErrorMessageVO(updateRow>0?true:false, null, "撤销"+(updateRow>0?"成功":"失败"));
		} catch (Exception e) {
			log.error("redeemMargin Exception" + e.getMessage(), e);
			return new ErrorMessageVO<Object>(false, null, "系统繁忙");
		}
	}

	@RequestMapping(value = "/newt0/fastSettleSaveEdit")
	@ResponseBody
	public ErrorMessageVO<Object> fastSettleSaveEdit(Long mcId, Integer loaningType, BigDecimal fastSettleLimit, BigDecimal minMargin,HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		if (mcId == null || loaningType == null) {// 均不能为空
			return new ErrorMessageVO<Object>(false, null, "校验不通过");
		}
		if (loaningType == LoaningTypeEnum.SHENGPAY.getCode() && fastSettleLimit == null) { return new ErrorMessageVO<Object>(false, null, "校验不通过"); }
		// 统计代理商下的商户出款情况 如果有出款中的出款，不能修改商户的垫资方的信息，如果修改的额度小于已经使用的额度不允许修改
		/*
		 * StatisticsWithdrawInfoDTO dto =
		 * withdrawReqService.statisticsPromoterMerchantWithdrawInfo(mcId); if
		 * (dto != null) { if (dto.getWithdrawingCnt() > 0) { return new
		 * ErrorMessageVO<Object>(false, null, "代理商的商户当前交易频繁不能修改，请稍后再试！"); } }
		 */
		String operator = SecurityUserHolder.getAuthUser().getUser().getRealName();
		String operatorId = SecurityUserHolder.getAuthUser().getUser().getUserName();
		ErrorMessageVO<Object> messageVO = null;
		ViewPromoterInfoDTO promoterInfo=this.promoterInfoService.queryPromoterById(mcId);
		if(promoterInfo==null){
			return new ErrorMessageVO<Object>(false, null, "修改失败，代理商不存在，请确认！");
		}
		try {
			OpContext context = new OpContext();
			context.setPromoterId(mcId);
			context.setLoaningType(LoaningTypeEnum.getLoaningTypeEnum(loaningType));
			context.setOpType(OpTypeEnums.PROMOTER_FASTSETTLE_CHANGE.getCode());
			if (LoaningTypeEnum.SHENGPAY == context.getLoaningType()) {// 盛付通全资才允许填写
				context.setFastSettleLimit(fastSettleLimit);
			}
			WhiteListInfoDO whiteInfo = whiteListInfoService.queryWhiteListInfo(WhiteTypeEnums.PROMOTER_MIN_MARGIN.code,
					promoterInfo.getPromoterMerchantNo(), promoterInfo.getPromoterType());
			if(minMargin!=null&&minMargin.compareTo(BigDecimal.ZERO)>=0){
				context.setPromoterMinMargin(minMargin);
				if (whiteInfo == null) {// 没有白名单，创建白名单
					this.whiteListInfoService.createWhiteInfo(WhiteTypeEnums.PROMOTER_MIN_MARGIN.code,promoterInfo.getPromoterMerchantNo(), promoterInfo.getPromoterType(), minMargin.toString(), operatorId);
				}else {// 有白名单，关闭白名单
					this.whiteListInfoService.updateWhiteInfo(whiteInfo.getId(),minMargin.toString(),operatorId);
				}
			}else if(whiteInfo!=null){
				this.whiteListInfoService.updateLoseEfficacy(whiteInfo.getId(), operatorId);
			}
			ErrorMessageVO<Object> errorMessageVO = transferSuccessState.batchHandlerOpState(context, operator, operatorId);
			if (errorMessageVO.isSuccess()) {
				messageVO = new ErrorMessageVO<Object>(true, null, "修改成功！");
				Map<String, String> map = new HashMap<String, String>();
				map.put("fastSettleLimit", context.getFastSettleLimit().toString());
				map.put("date", DateUtil.getWebDateString(new Date()));
				marginOpService.sendMessage(mcId, MessageTemplateCodeEnum.AUDIT_ADDMARGIN_SUCCESS.getKey(), map);
			} else {
				messageVO = new ErrorMessageVO<Object>(false, null, "修改失败！");
			}
		} catch (Exception e) {
			log.error("FastSettleIntraAction.applyOnlineSaveEdit.error,mcId=" + mcId, e);
			messageVO = new ErrorMessageVO<Object>(false, null, "系统繁忙");
		}
		return messageVO;
	}

	// ///-------------------------------拓展方在线申请管理-----------end---------------

	// ///-------------------------------自动快速结算商户管理-----------begin---------------
	/**
	 * 自动快速结算商户管理--首页
	 * **/
	@RequestMapping(value = "/autoFastSettleMerchantIndex")
	public String autoFastSettleMerchantIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/fastSettle/merchant/index";
	}

	/**
	 * 自动快速结算商户管理--分页查询
	 * **/
	@RequestMapping(value = "/ajaxPaging/autoFastSettleMerchantQuery")
	public String autoFastSettleMerchantQuery(@ModelAttribute("query") FastSettleConfigDOExampleExt query, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		List<FastSettleConfigDOExt> dataList = this.fastSettleConfigManager.selectByQuery4Intra(query);
		model.put("dataList", dataList);
		model.put("query", query);
		return "/fastSettle/merchant/autoFastSettleMerchantList";
	}

	/**
	 * 自动快速结算商户管理--初始化修改页面
	 * **/
	@RequestMapping(value = "/initAutoFastSettle")
	public String initAutoFastSettle(Long pfcId, Long merchantId, Long promoterId, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		MerchantInfoDTO merchantInfo = this.mspFacade.findMerchantInfoByMerchantId(merchantId);
		model.put("o", merchantInfo);
		PromoterInfoDTO promoterInfo = this.mspFacade.findPromoterInfoByPromoterId(promoterId);
		model.put("p", promoterInfo);
		if (pfcId != null) {
			FastSettleConfigDO fsc = this.fastSettleConfigManager.selectByPrimaryKey(pfcId);
			model.put("fsc", fsc);
		}
		return "/fastSettle/merchant/autoFastSettle";
	}

	/**
	 * 自动快速结算商户管理--提交修改
	 * **/
	@RequestMapping(value = "/modityAutoFastSettle")
	@ResponseBody
	public ErrorMessageVO<Object> modityAutoFastSettle(Long merchantId, String merchantNo, Integer autoFastSettle, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		ErrorMessageVO<Object> errorMessage = new ErrorMessageVO<Object>(false);
		try {
			// 验证商户快速结算配置
			MerchantInfoDTO merchantInfoDTO = mspFacade.findMerchantInfoByMerchantId(merchantId);
			StraightlyCfg straightlyCfg = mspFacade.queryStraightlyCfg(merchantId);
			model.put("straightFlag", straightlyCfg.isStraightFlag());
			if (!straightlyCfg.isStraightFlag()) { return new ErrorMessageVO<Object>(false, null, "代理商未开通快速结算服务"); }

			MerchantFastSettleVO fastSettleVO = new MerchantFastSettleVO();
			fastSettleVO.setAutoFastSettle(autoFastSettle.toString());
			fastSettleVO.setMerchantId(merchantId.toString());
			com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
			String operatorId = user.getUserName();
			ErrorMessageVO<Object> errorMessageVO = fastSettle.setMerchantAutoSettle(fastSettleVO, operatorId);
			if (!errorMessageVO.isSuccess()) {
				errorMessageVO.setErrorMessage("系统异常，请联系技术人员解决\r\n");
			} else {
				String label = autoFastSettle == 1 ? "开通" : "关闭";
				String msg = StringUtils.isNotBlank(errorMessageVO.getErrorMessage()) ? errorMessageVO.getErrorMessage() : "自动快速结算成功";
				errorMessageVO.setErrorMessage(label + msg);
			}
			log.info("FastSettleIntraAction #saveAutoSettleFast:" + errorMessageVO.toString());
			return errorMessageVO;
		} catch (Exception e) {
			log.error("FastSettleIntraAction.modityAutoFastSettle.error,merchantId=" + merchantId + ",autoFastSettle=" + autoFastSettle, e);
			errorMessage.setErrorMessage("系统繁忙");
		}
		return errorMessage;
	}

	// ///-------------------------------自动快速结算商户管理-----------end---------------
	/**
	 * 自动快速结算交易查询
	 * **/
	@RequestMapping(value = "/autoFastSettleTransQuery")
	public String autoFastSettleTransQuery(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return FastSettleConverterUtil.formatOperatingURL("redirect:{0}/profit/rAndp/toQueryRAndP.do");
	}

	// ///-------------------------------代理商申请配资-开通授信账户-----------end---------------

	/**
	 * 开通配资
	 * **/
	@RequestMapping(value = "/openCreditAccount")
	@ResponseBody
	public ErrorMessageVO<Object> openCreditAccount(Long promoterId, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		PromoterInfoDTO promoterInfo = this.mspFacade.findPromoterInfoByPromoterId(promoterId);
		return this.bizApplyOpenAccountService.applyOpenAccount(promoterInfo, AccountType.CREDIT_ACCOUNT);
	}

	/**
	 * 关闭配资
	 * **/
	@RequestMapping(value = "/closeCreditAccount")
	@ResponseBody
	public ErrorMessageVO<Object> closeCreditAccount(Long promoterId, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		PromoterInfoDTO promoterInfo = this.mspFacade.findPromoterInfoByPromoterId(promoterId);
		return this.bizApplyOpenAccountService.applyCloseAccount(promoterInfo, AccountType.CREDIT_ACCOUNT);
	}

	/**
	 * 配资额度重置
	 *
	 * @param id
	 *            代理商配资记录表id
	 * **/
	@RequestMapping(value = "/resetCreditLimit")
	@ResponseBody
	public ErrorMessageVO<Object> resetCreditLimit(Long id, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		try {
			WithCapital4PromoterDO record = this.mcWithCapital4PromoterService.queryWithCapital4PromoterById(id);
			if (record != null) {
				if (record.getStatus() != WithCapitalEnums.MSP_FAST_SETTLE_LIMIT_RESET_FAILURE.code) { return new ErrorMessageVO<Object>(false, null,
						"配资额度恢复失败才能操作"); }
				String today = DateUtil.getWebDateString(new Date());
				String targetDate = DateUtil.getWebDateString(record.getRecoveryDate());
				if (!today.equals(targetDate)) { return new ErrorMessageVO<Object>(false, null, "该配资申请在" + targetDate + "日恢复，请在当日操作"); }

			}
			com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
			String operatorId = user.getUserName();
			return this.mcWithCapital4PromoterService.resetCreditLimit(record, operatorId);
		} catch (Exception e) {
			log.error("FastSettleIntraAction.resetCreditLimit.error,withCapitalId=" + id, e);
		}
		return new ErrorMessageVO<Object>(false, null, "系统繁忙");
	}

	/**
	 * 手续费已退款
	 *
	 * @param id
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/feeRefund")
	@ResponseBody
	public ErrorMessageVO<Object> feeRefund(Long id, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		try {
			WithCapital4PromoterDO record = withCapital4PromoterManager.selectByPrimaryKey(id);
			record.setStatus(WithCapitalEnums.FEE_REFUND_SUCCESS.getCode());
			withCapital4PromoterManager.updateByPrimaryKeySelective(record);
			return new ErrorMessageVO<Object>(true, null, "状态修改成功");
		} catch (Exception e) {
			log.error("FastSettleIntraAction.feeRefund.error,withCapitalId=" + id, e);
			return new ErrorMessageVO<Object>(false, null, "系统繁忙");
		}
	}

	// ///----------------------------t+0配资交易管理--------------begin------------------
	/**
	 * t+0配资交易管理--首页
	 * **/
	@RequestMapping(value = "/withFundingIndex")
	public String withFundingIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/fastSettle/withFunding/index";
	}

	/**
	 * t+0配资交易管理--分页查询
	 * **/
	@RequestMapping(value = "/ajaxPaging/withFundingQuery")
	public String withFundingQuery(@ModelAttribute("query") WithCapitalReqDOExampleExt query, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		List<WithCapital4PromoterDO> dataList = withCapital4PromoterManager.selectByQuery4Intra(query);
		model.put("dataList", dataList);
		model.put("query", query);
		return "/fastSettle/withFunding/withFundingList";
	}

	// ///----------------------------t+0配资交易管理--------------end------------------
}
