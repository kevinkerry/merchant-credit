package com.sdp.mc.web.interceptor;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sdp.mc.common.util.MCUtil;
import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.service.authorize.AuthHelper;

/**
 * 权限拦截器
 * 
 * @author liuxi.xiliu
 */
public class RuleInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 不需要检验权限的功能(页面地址)
	 */
	private List<String> noNeedCheckRuleFunctionName;

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String functionName = MCUtil.getFunctionName(request);
		MCMerchantUser u = MCMerchantUser.getMCMerchantUser(request.getSession());

		if (MCUtil.getFunctionName(request).indexOf("uploadFile") != -1) { return true; }

		if (!this.functionRuleCheck(functionName, u)) { return false; }
		return true;
	}

	/**
	 * 功能权限拦截
	 */
	private boolean functionRuleCheck(String functionName, MCMerchantUser u) {
		// ----不需要任何权限的页面，通过-------------
		if (noNeedCheckRuleFunctionName.contains(functionName)) { return true; }

		// ----如果是管理员，通过----------------
		if (u.getAdminFlag()) { return true; }

		// ----检验权限，决定能否通过-------------
		if (checkRule(u.getRules(), AuthHelper.getRuleUrl().get(functionName))) {
			return true;
		} else {
			logger.info("====user has no rule, but tries to access function. 【functionName】: " + functionName + ", 【MCMerchantUser】: "
					+ u.getFullInfo());
		}
		return false;
	}

	public void setNoNeedCheckRuleFunctionName(List<String> noNeedCheckRuleFunctionName) {
		this.noNeedCheckRuleFunctionName = noNeedCheckRuleFunctionName;
	}

	private boolean checkRule(Map<String, String> userRule, Set<String> rules) {
		if (rules != null && userRule != null) {
			for (String rule : rules) {
				if (userRule.containsKey(rule)) { return true; }
			}
		}
		return false;
	}
}
