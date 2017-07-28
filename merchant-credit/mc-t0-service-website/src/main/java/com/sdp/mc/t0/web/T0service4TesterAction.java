package com.sdp.mc.t0.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdp.mc.t0.facade.T0ServiceFacade;
import com.shengpay.mpos.realname.MerchantRealNameMPOS;

/**
 *
 * @author ganquan
 *
 */
@Controller
@RequestMapping(value = { "/test" })
public class T0service4TesterAction {

	@Autowired
	private T0ServiceFacade t0ServiceFacade;
	@Autowired
	private MerchantRealNameMPOS realNameMpos;

	@RequestMapping("/test")
	public String test(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		return "/test/index";
	}

	@RequestMapping("/applyFastSettle")
	public String applyMposFastSettle(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String posMerchantNo = request.getParameter("posMerchantNo");
		String txnIdStr = request.getParameter("txnIds");

		String resultJson = t0ServiceFacade.applyMposFastSettle(merchantNo, posMerchantNo, txnIdStr);
		model.put("result", resultJson);
		return "/test/resultInfo";
	}

	@RequestMapping("/merchantFastSettleCfg")
	public String getMerchantFastSettleCfg(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String posMerchantNo = request.getParameter("posMerchantNo");

		String resultJson = t0ServiceFacade.getMerchantFastSettleCfg(merchantNo, posMerchantNo);
		model.put("result", resultJson);
		return "/test/resultInfo";
	}

	@RequestMapping("/getMposFastSettleInfo")
	public String getMposFastSettleInfo(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String posMerchantNo = request.getParameter("posMerchantNo");
		String resultJson = t0ServiceFacade.getMposFastSettleInfo(merchantNo, posMerchantNo);
		model.put("result", resultJson);
		return "/test/resultInfo";
	}

	@RequestMapping("/queryValidOrderList")
	public String queryValidOrderList(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String posMerchantNo = request.getParameter("posMerchantNo");
//		realNameMpos.authQuery(merchantNo, "zf910");
		String resultJson = t0ServiceFacade.queryValidOrderList(merchantNo, posMerchantNo);
		model.put("result", resultJson);
		return "/test/resultInfo";
	}
	@RequestMapping("/addActiveMQ")
	public String addActiveMQ(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String posMerchantNo = request.getParameter("posMerchantNo");
//		realNameMpos.authQuery(merchantNo, "zf910");
		String resultJson = t0ServiceFacade.queryValidOrderList(merchantNo, posMerchantNo);
		model.put("result", resultJson);
		return "/test/resultInfo";
	}
}
