package com.sdp.mc.web.action.withfunding;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdp.mc.common.enums.WithCapitalEnums;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.facade.msp.MspFacade;
import com.sdp.mc.integration.msp.PromoterInfoDTO;
import com.sdp.mc.mcwithfunding.dao.WithCapital4PromoterDO;
import com.sdp.mc.mcwithfunding.dao.WithCapital4PromoterDOExample;
import com.sdp.mc.service.mcwithfunding.WithCapital4PromoterService;
import com.sdp.mc.web.action.BaseAction;

/**
 * 代理商配资历史
 */
@Controller
@RequestMapping(value = { "/posPromoter", "/mposPromoter" })
public class WithFundingAction extends BaseAction {
	private static Logger log = LoggerFactory.getLogger(WithFundingAction.class);
	@Autowired
	private WithCapital4PromoterService withCapital4PromoterService;
	@Autowired
	private MspFacade mspFacade;

	@RequestMapping(value = { "/funding/history" })
	public String historyInit(WithCapital4PromoterDOExample query, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		try {
			MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
			// 查询代理商信息
			PromoterInfoDTO promoterInfoDTO = mspFacade.findPromoterInfoByPromoterId(user.getPromoterId());
			// 保证金金额
			String fastSettleMargin = promoterInfoDTO.getFastSettleMargin();
			BigDecimal marginAmount = new BigDecimal(fastSettleMargin);
			// 最高配资不超过50万
			BigDecimal maxMarginAmount = new BigDecimal("500000");
			if (marginAmount.compareTo(maxMarginAmount) > 0) {
				marginAmount = maxMarginAmount;
			}
			BigDecimal usedAmount = withCapital4PromoterService.queryWithCapital4Promoter(user.getPromoterId());
			// 已申请配资金额
			BigDecimal amount = usedAmount == null ? BigDecimal.ZERO : usedAmount;
			// 剩余额度
			BigDecimal validCredit = marginAmount.subtract(amount);

			model.put("fastSettleMargin", marginAmount); // 总额度
			model.put("validCredit", validCredit); // 剩余额度

			String startTimeStr = request.getParameter("startTimeStr");
			String endTimeStr = request.getParameter("endTimeStr");
			String statusStr = request.getParameter("statusStr");

			query.clear();
			query.setStatus(null);

			WithCapital4PromoterDOExample.Criteria criteria = query.createCriteria();
			criteria.andPromoterIdEqualTo(user.getPromoterId());
			if (StringUtils.isNotBlank(startTimeStr) && StringUtils.isNotBlank(endTimeStr)) {
				criteria.andApplyDatetimeBetween(DateUtil.str2Date(startTimeStr), DateUtil.str2Date(endTimeStr));
			}
			if (StringUtils.isNotBlank(statusStr)) {
				List<Integer> sList = new ArrayList<Integer>();
				if ("success".equalsIgnoreCase(statusStr)) {
					sList.add(WithCapitalEnums.MSP_FAST_SETTLE_LIMIT_ADD_SUCCESS.getCode());
					sList.add(WithCapitalEnums.MSP_FAST_SETTLE_LIMIT_RESET_SUCCESS.getCode());
					sList.add(WithCapitalEnums.MSP_FAST_SETTLE_LIMIT_RESET_FAILURE.getCode());
					sList.add(WithCapitalEnums.FOS_REFUND_SUCCESS.getCode());
					sList.add(WithCapitalEnums.FOS_REFUND_FAIL.getCode());
				} else if ("fail".equalsIgnoreCase(statusStr)) {
					sList.add(WithCapitalEnums.MSP_FAST_SETTLE_LIMIT_ADD_FAILURE.getCode());
					sList.add(WithCapitalEnums.FOS_TRANSFER_FAIL.getCode());
					sList.add(WithCapitalEnums.FEE_REFUND_SUCCESS.getCode());
				}
				criteria.andStatusIn(sList);
			}

			query.setPageSize(10);
			query.setOrderByClause(" apply_datetime desc ");
			List<WithCapital4PromoterDO> withCapitalList = this.withCapital4PromoterService.pageQueryWithCapital(query);
			model.put("withCapitalList", withCapitalList);
			model.put("query", query);
			model.put("startTimeStr", startTimeStr);
			model.put("endTimeStr", endTimeStr);
			model.put("statusStr", statusStr);
		} catch (Exception e) {
			log.error("WithFundingAction.pageQueryWithCapital error", e);
		}
		return "/main/withfunding/history";
	}
}
