package com.sdp.mc.t0.web;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdp.mc.t0.facade.T0ServiceFacade;
import com.sdp.mc.t0.facade.WithdrawRatioFacade;
import com.sdp.mc.t0.facade.WithdrawServiceFacade;
import com.shengpay.mpos.realname.MerchantRealNameMPOS;

/**
 * 出款服务 测试类
 *
 * @author ganquan
 *
 */
@Controller
@RequestMapping(value = { "/ratio-test" })
public class WithdrawRatioTesterAction {

	@Autowired
	private WithdrawRatioFacade withdrawRatioFacade = null;

	@RequestMapping("/test")
	public String test(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		return "/ratio/index";
	}

	@RequestMapping("/createOrUpdate")
	public String createOrUpdate(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		String merchantNo = request.getParameter("merchantNo");
		String merchantType= request.getParameter("merchantType");
		String withDrawRatioStatus= request.getParameter("withDrawRatioStatus");
		String withDrawRatioType= request.getParameter("withDrawRatioType");
		String holidayWithDrawRatio= request.getParameter("holidayWithDrawRatio");
		String effectiveTime= request.getParameter("effectiveTime");
		String expireTime= request.getParameter("expireTime");
		String workDayWithDrawRatio= request.getParameter("workDayWithDrawRatio");
		String ratioId= request.getParameter("ratioId");

		String resultJson = withdrawRatioFacade.createOrUpdateWithrawRatio(merchantNo, merchantType, effectiveTime, expireTime, holidayWithDrawRatio, withDrawRatioStatus, withDrawRatioType, workDayWithDrawRatio,ratioId);
		model.put("result", resultJson);
		return "/ratio/resultInfo";
	}
	@RequestMapping("/queryRatio")
	public String queryList(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String merchantNo = request.getParameter("merchantNo");
		String merchantType = request.getParameter("merchantType");
		String queryTime = request.getParameter("queryTime");
		String resultJson = withdrawRatioFacade.queryWithdrawRatio(merchantNo, merchantType);
		model.put("result", resultJson);
		return "/ratio/resultInfo";
	}
	@RequestMapping("/createOrUpdateT1andD1Ratio")
	public String createOrUpdateT1andD1Ratio(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		String merchantNo = request.getParameter("merchantNo");
		String merchantType= request.getParameter("merchantType");
		String resultJson = withdrawRatioFacade.createOrUpdateT1andD1Ratio(merchantNo, merchantType);
		model.put("result", resultJson);
		return "/ratio/resultInfo";
	}

}
