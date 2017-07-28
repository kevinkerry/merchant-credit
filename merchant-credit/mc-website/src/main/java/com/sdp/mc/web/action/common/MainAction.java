package com.sdp.mc.web.action.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdp.mc.common.web.MCMerchantUser;
import com.shengpay.spa.msso.client.filter.callback.HttpSessionCasMerchantFilterCallback;

@Controller
@RequestMapping("/common/main")
public class MainAction {

	@Value("${msp.root.path}")
	private String mspRootPath;
	/**
	 * 默认首页
	 * **/
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "redirect:" + this.mspRootPath + "/common/main/index.do";
		// return "/main/index";
	}

	/**
	 * sso回调地址,用于清除session内容
	 * **/
	@RequestMapping(value = "/quit")
	public String quit(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		request.getSession().removeAttribute(HttpSessionCasMerchantFilterCallback.USER_SESSION_KEY);
		request.getSession().removeAttribute(MCMerchantUser.MC_MERCHANT_USER);
		request.getSession().invalidate();
		model.put("jsonResult", "{\"success\":true}");
		return "/control/json_result";
	}

	@RequestMapping(value = "/gotoEmpty")
	public String gotoEmpty(Long merchantId, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/main/fastsettle/empty";
	}
}
