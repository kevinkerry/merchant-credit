package com.sdp.mc.intra.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdp.emall.intra.admin.security.util.SecurityUserHolder;
import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.settle.api.dto.req.PartnerPromfitRuleInfoRequest;
import com.sdp.mc.settle.api.dto.resp.PartnerPromfitConfigResponse;

@Controller
@RequestMapping("/partnerPromfit")
public class PartnerPromfitConfigAction {
	private static final Logger logger = LoggerFactory.getLogger(PartnerPromfitConfigAction.class);

	@Autowired
	private ScSettleBaseService scSettleBaseService;

	@Autowired
	protected Mapper beanMapper;

	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/repair/partnerIndex";
	}

	@RequestMapping("/config")
	public String config(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			BigDecimal t0BaseSplittingScale, BigDecimal t0WdSplitting, BigDecimal d1BaseSplittingScale, Long promoterId,
			String effectiveTime, String expireTime,  String mcc, String ruleIdentify, String status) {
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		logger.info("user:" + user.getUserName());
		long t = System.currentTimeMillis();
		PartnerPromfitRuleInfoRequest ruleInfo=new PartnerPromfitRuleInfoRequest(t0BaseSplittingScale, t0WdSplitting, d1BaseSplittingScale, promoterId, effectiveTime, expireTime, user.getUserName(), user.getRealName(), mcc, ruleIdentify, status);
		List<PartnerPromfitRuleInfoRequest> ruleInfos=new ArrayList<PartnerPromfitRuleInfoRequest>();
		ruleInfos.add(ruleInfo);
		PartnerPromfitConfigResponse res=scSettleBaseService.getPartnerPromfitConfigAPI().createOrUpdatePromfitRule(ruleInfos);
		String resultJson = "use times:" + (System.currentTimeMillis() - t) / 1000 +"response:"+ToStringBuilder.reflectionToString(res, ToStringStyle.SIMPLE_STYLE);
		model.put("result", resultJson);
		logger.info("config end result:" + resultJson);
		return "/repair/resultInfo";
	}

	
}
