package com.sdp.mc.t0.web;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.drools.core.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdp.mc.common.exception.IdentityLimitException;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.t0.facade.WithdrawServiceFacade;
import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.service.LimitationService;
import com.sdp.withdraw.service.impl.LimitationBaseService;
import com.sdp.withdraw.vo.BankCardInfo;
import com.shengpay.service.withdraw.FwPosMerchantInfoService;

/**
 * 出款服务 测试类
 *
 * @author ganquan
 *
 */
@Controller
@RequestMapping(value = { "/withdraw-test" })
public class T0serviceWithdrawTesterAction {
	private Logger logger = LoggerFactory.getLogger(T0serviceWithdrawTesterAction.class);
	@Autowired
	private WithdrawServiceFacade withdrawServiceFacade = null;

	@Autowired
	private LimitationService limitationService;
	@Autowired
	private LimitationBaseService limitationBaseService;
	@Autowired
	private FwPosMerchantInfoService fwPosMerchantInfoService;

	@RequestMapping("/test")
	public String test(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		return "/withdraw/index";
	}

	@RequestMapping("/merchant")
	public String merchant(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		return "/merchant/index";
	}

	@RequestMapping("/applyPosWithdraw")
	public String applyPosWithdraw(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String appId = request.getParameter("appId");
		String withdrawAmount = request.getParameter("withdrawAmount");
		String originalAmount = request.getParameter("originalAmount");
		String mcType = request.getParameter("mcType");
		String withdrawType = request.getParameter("withdrawType");
		String orderNo = request.getParameter("orderNo");

		String resultJson = withdrawServiceFacade.applyPosWithdraw(merchantNo, "1231", withdrawAmount, originalAmount, mcType, withdrawType, orderNo);
		model.put("result", resultJson);
		return "/withdraw/resultInfo";
	}

	@RequestMapping("/applyMPosWithdraw")
	public String applyMPosWithdraw(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String appId = request.getParameter("appId");
		String withdrawAmount = request.getParameter("withdrawAmount");
		String withdrawType = request.getParameter("withdrawType");
		String mcType = request.getParameter("mcType");
		String orderNo = request.getParameter("orderNo");
		String resultJson = withdrawServiceFacade.applyMPosWithdraw(merchantNo, "1231", withdrawAmount, withdrawType, mcType, orderNo);
		model.put("result", resultJson);
		return "/withdraw/resultInfo";
	}
	@RequestMapping("/applyEasypayWithdraw")
	public String applyEasypayWithdraw(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String appId = request.getParameter("appId");
		String withdrawAmount = request.getParameter("withdrawAmount");
		String withdrawType = request.getParameter("withdrawType");
		String mcType = request.getParameter("mcType");
		String orderNo = request.getParameter("orderNo");

		String bankCode = request.getParameter("bankCode");
		String bankName = request.getParameter("bankName");
		String bankBranch = request.getParameter("bankBranch");
		String bankLineNo = request.getParameter("bankLineNo");
		String bankProvince = request.getParameter("bankProvince");
		String bankCity = request.getParameter("bankCity");
		String name = request.getParameter("name");
		String cardNo = request.getParameter("cardNo");
		String cardType = request.getParameter("cardType");
		String companyOrPersonal = request.getParameter("companyOrPersonal");
		BankCardInfo bankCardInfo=new BankCardInfo(bankCode, bankName, bankBranch, bankLineNo, bankProvince, bankCity, name, cardNo, cardType, companyOrPersonal);
		String resultJson = withdrawServiceFacade.applyEasypayWithdraw(merchantNo, "1231", withdrawAmount, withdrawType, mcType, orderNo,bankCardInfo);
		model.put("result", resultJson);
		return "/withdraw/resultInfo";
	}

	@RequestMapping("/queryWithdrawList")
	public String queryValidOrderList(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String traceNo = request.getParameter("traceNo");
		String orderNo = request.getParameter("orderNo");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String withdrawType = request.getParameter("withdrawType");
		String pageSize = request.getParameter("pageSize");
		String pageNo = request.getParameter("pageNo");
		String resultJson = withdrawServiceFacade.queryWithdrawList(merchantNo, traceNo, orderNo, startTime, endTime, withdrawType, pageSize, pageNo);
		model.put("result", resultJson);
		return "/withdraw/resultInfo";
	}

	@RequestMapping("/checkPosWithdraw")
	public String checkPosWithdraw(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String appId = request.getParameter("appId");
		String withdrawAmount = request.getParameter("withdrawAmount");
		String originalAmount = request.getParameter("originalAmount");
		String mcType = request.getParameter("mcType");

		String resultJson = withdrawServiceFacade.checkPosWithdraw(merchantNo, "1231", mcType, originalAmount);
		model.put("result", resultJson);
		return "/withdraw/resultInfo";
	}

	@RequestMapping("/productWithdraw")
	public String productWithdraw(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String mcType = request.getParameter("mcType");

		String resultJson = withdrawServiceFacade.productWithdraw(merchantNo, mcType);
		model.put("result", resultJson);
		return "/withdraw/resultInfo";
	}

	@RequestMapping("/findCanUseQuota")
	public String findCanUseQuota(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String mcType = request.getParameter("mcType");

		BigDecimal canUseQuota = withdrawServiceFacade.findCanUseQuota(merchantNo, mcType);
		StringBuffer sb = new StringBuffer();
		sb.append("可用额度: [ " + canUseQuota + " ] ");
		model.put("result", sb.toString());
		return "/withdraw/resultInfo";
	}

	@RequestMapping("/findTotalAmount")
	public String findTotalAmount(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String mcType = request.getParameter("mcType");

		BigDecimal totalAmount = withdrawServiceFacade.findTotalAmount(merchantNo, mcType);
		StringBuffer sb = new StringBuffer();
		sb.append("出款结算总金额: [ " + totalAmount + " ] ");
		model.put("result", sb.toString());
		return "/withdraw/resultInfo";
	}

	@RequestMapping("/queryPromoterInfo")
	public String queryPromoterInfo(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String mcType = request.getParameter("mcType");

		String resultJson = withdrawServiceFacade.queryPromoterInfo(merchantNo, mcType);
		model.put("result", resultJson);
		return "/withdraw/resultInfo";
	}

	@RequestMapping("/queryMerchantInfo")
	public String queryMerchantInfo(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String mcType = request.getParameter("mcType");
		StringBuffer sb = new StringBuffer();
		if (StringUtils.isEmpty(merchantNo) || StringUtils.isEmpty(mcType)) {
			sb.append("请输入正确的商户号、类型、冻结额度");
			model.put("result", sb.toString());
			return "/withdraw/resultInfo";
		}
		String resultJson = withdrawServiceFacade.queryMerchantInfo(merchantNo, mcType);
		model.put("result", resultJson);
		return "/withdraw/resultInfo";
	}

	@RequestMapping("/getIdentityLimit")
	public String getIdentityLimit(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String mcType = request.getParameter("mcType");
		StringBuffer sb = new StringBuffer();
		if (StringUtils.isEmpty(merchantNo) || StringUtils.isEmpty(mcType)) {
			sb.append("请输入正确的商户号、类型");
			model.put("result", sb.toString());
			return "/withdraw/resultInfo";
		}
		try {
			BigDecimal limit = limitationBaseService.getIdentityLimit(merchantNo, mcType);
			model.put("result", limit);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("getIdentityLimit", e);
			model.put("result", e.getMessage());
		}
		return "/withdraw/resultInfo";
	}

	@RequestMapping("/getIdentityMerchantInfo")
	public String getIdentityMerchantInfo(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String mcType = request.getParameter("mcType");
		StringBuffer sb = new StringBuffer();
		if (StringUtils.isEmpty(merchantNo) || StringUtils.isEmpty(mcType)) {
			sb.append("请输入正确的商户号、类型");
			model.put("result", sb.toString());
			return "/withdraw/resultInfo";
		}
		try {
			List<PosMerchantInfoDO> list = limitationBaseService.getIdentityMerchantInfo(merchantNo, mcType);
			model.put("result", result2Json(list));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("getIdentityMerchantInfo", e);
			model.put("result", e.getMessage());
		}
		return "/withdraw/resultInfo";
	}

	@RequestMapping("/queryUsedIdentityLimit")
	public String queryUsedIdentityLimit(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String mcType = request.getParameter("mcType");
		try {
			BigDecimal limit = limitationBaseService.queryUsedIdentityLimit(merchantNo, mcType);
			model.put("result", limit);
		} catch (IdentityLimitException e) {
			// TODO Auto-generated catch block
			logger.error("queryUsedIdentityLimit", e);
			model.put("result", e.getErrorMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("queryUsedIdentityLimit", e);
			model.put("result", e.getMessage());
		}
		return "/withdraw/resultInfo";
	}

	@RequestMapping("/syncPromoterInfo")
	public String syncPromoterInfo(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String mcType = request.getParameter("mcType");
		String mcId = request.getParameter("mcId");
		String merchantName = request.getParameter("merchantName");
		String status = request.getParameter("status");
		String pmtLevel = request.getParameter("pmtLevel");
		String parentMerchantNo = request.getParameter("parentMerchantNo");
		String parentMerchantType = request.getParameter("parentMerchantType");

		String resultJson = withdrawServiceFacade.syncPromoterInfo(merchantNo, mcType, mcId, merchantName, status, pmtLevel, parentMerchantNo,
				parentMerchantType);
		model.put("result", resultJson);
		return "/withdraw/resultInfo";
	}
	@RequestMapping("/syncEasypayMerchantInfo")
	public String syncEasypayMerchantInfo(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String mcType = request.getParameter("mcType");
		String merchantName = request.getParameter("merchantName");
		String status = request.getParameter("status");
		String certType = request.getParameter("certType");
		String certNo = request.getParameter("certNo");
		String promoterType = request.getParameter("promoterType");
		String promoterNo = request.getParameter("promoterNo");
		String mcc = request.getParameter("mcc");
		
		String resultJson = withdrawServiceFacade.syncEasypayMerchantInfo(merchantNo, mcType, merchantName, status, certType, certNo,
				promoterType,promoterNo,mcc);
		model.put("result", resultJson);
		return "/withdraw/resultInfo";
	}
	@RequestMapping("/modifyMerchantMcc")
	public String modifyMerchantMcc(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String mcType = request.getParameter("mcType");
		String mcc = request.getParameter("mcc");
		
		String resultJson = withdrawServiceFacade.modifyMerchantMcc(merchantNo, mcType, mcc);
		model.put("result", resultJson);
		return "/withdraw/resultInfo";
	}

	@RequestMapping("/syncMerchantInfo")
	public String syncMerchantInfo(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String mcType = request.getParameter("mcType");
		String mcId = request.getParameter("mcId");
		String merchantName = request.getParameter("merchantName");
		String status = request.getParameter("status");
		String promoterId = request.getParameter("promoterId");
		String mcc = request.getParameter("mcc");
		String lastLevelPromoterNo = request.getParameter("lastLevelPromoterNo");
		String lastLevelPromoterType = request.getParameter("lastLevelPromoterType");

		String resultJson = withdrawServiceFacade.syncMerchantInfo(merchantNo, mcType, mcId, merchantName, status, promoterId, mcc,
				lastLevelPromoterNo, lastLevelPromoterType);
		model.put("result", resultJson);
		logger.info("syncMerchantInfo end result:" + resultJson);
		return "/withdraw/resultInfo";
	}

	@RequestMapping("/syncMerchantInfoAll")
	public String syncMerchantInfoAll(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws InterruptedException {
		String resultJson;
			resultJson = withdrawServiceFacade.syncMerchantInfoAll();
		model.put("result", resultJson);
		logger.info("syncMerchantInfoAll end result:" + resultJson);
		return "/withdraw/resultInfo";
	}

	@RequestMapping("/distinctMerchant")
	public String distinctMerchant(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		long t = System.currentTimeMillis();
		int num = fwPosMerchantInfoService.distinctMerchant();
		String resultJson = "use times:" + (System.currentTimeMillis() - t) / 1000 + " 影响行数：" + num;
		model.put("result", resultJson);
		logger.info("distinctMerchant end result:" + resultJson);
		return "/withdraw/resultInfo";
	}

	@RequestMapping("/frozenOption")
	public String frozenOption(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String mcType = request.getParameter("mcType");
		String frozenLimitation = request.getParameter("frozenLimit");
		StringBuffer sb = new StringBuffer();
		if (StringUtils.isEmpty(merchantNo) || StringUtils.isEmpty(mcType) || StringUtils.isEmpty(frozenLimitation)) {
			sb.append("请输入正确的商户号、类型、冻结额度");
			model.put("result", sb.toString());
			return "/withdraw/resultInfo";
		}
		BigDecimal frozenQuato = null;
		try {
			frozenQuato = new BigDecimal(frozenLimitation);
		} catch (Exception e) {
			sb.append("冻结额度输入错误" + e.getMessage());
			model.put("result", sb.toString());
		}
		if (frozenQuato == null) {
			sb.append("冻结额度输入错误");
			return "/withdraw/resultInfo";
		}
		boolean value = limitationService.frozenLimitation(merchantNo, mcType, frozenQuato);
		sb.append("冻结操作: [ " + value + " ] ");
		model.put("result", sb.toString());
		return "/withdraw/resultInfo";
	}

	@RequestMapping("/IsQuotoShare")
	public String IsQuotoShare(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String mcType = request.getParameter("mcType");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		StringBuffer sb = new StringBuffer();
		if (StringUtils.isEmpty(merchantNo)) {
			sb.append("商户号不能为空");
			model.put("result", sb.toString());
			return "/withdraw/resultInfo";
		}
		if (StringUtils.isEmpty(mcType)) {
			sb.append("商户类型不能为空");
			model.put("result", sb.toString());
			return "/withdraw/resultInfo";
		}
		if (StringUtils.isEmpty(startTime)) {
			sb.append("startTime不能为空");
			model.put("result", sb.toString());
			return "/withdraw/resultInfo";
		}
		if (StringUtils.isEmpty(endTime)) {
			sb.append("endTime不能为空");
			model.put("result", sb.toString());
			return "/withdraw/resultInfo";
		}
		Date reqD = null;
		Date respD = null;
		try {
			reqD = DateUtil.parse2Date(startTime);
			respD = DateUtil.parse2Date(endTime);
		} catch (Exception e) {
			sb.append("日期格式不正确,YYYY-MM-DD");
			model.put("result", sb.toString());
			return "/withdraw/resultInfo";
		}

		ErrorMessageVO<Object> message = limitationService.isQuotoShare(merchantNo, mcType, reqD, respD);
		if (message != null && message.isSuccess()) {
			model.put("result", "日期共享");
		} else {
			model.put("result", "日期不共享");
		}
		return "/withdraw/resultInfo";
	}

	protected String result2Json(Object result) {
		String resultJson = null;
		if (result instanceof List) {
			resultJson = JSONArray.fromObject(result).toString();
		} else {
			resultJson = JSONObject.fromObject(result).toString();
		}
		logger.info("#result2Json:" + resultJson);
		return resultJson;
	}

}
