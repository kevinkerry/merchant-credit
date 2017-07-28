package com.sdp.mc.web.action.auditDebit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.web.action.BaseAction;
import com.shengpay.debit.common.enums.ConfigEnums;
import com.shengpay.debit.common.service.DebitConfigService;
import com.shengpay.debit.dal.ext.dataobject.AgentProfitDTO;
import com.shengpay.debit.dal.ext.dataobject.ExtDoAgentProfitExample;
import com.shengpay.debit.ext.daointerface.ExtDoAgentProfitDAO;

/**
 * 代理商分润查询
 */
@Controller
@RequestMapping(value = {"/posPromoter", "/mposPromoter"})
public class AgentProfitAction extends BaseAction {
	@Autowired
	private DebitConfigService debitConfigService;

	private String getValue(ConfigEnums enums) {
		return debitConfigService.getByKey(enums);
	}
	// private static Logger log = LoggerFactory.getLogger(AgentProfitAction.class);

	@Autowired
	private ExtDoAgentProfitDAO extDoAgentProfitDAO;

	@RequestMapping(value = "/profit/queryAgentProfit")
	public String queryAgentProfit(ExtDoAgentProfitExample query, HttpServletRequest request, ModelMap model) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		query.setPromoterNo(user.getMerchantNo());
		query.setPageSize(10);
		List<AgentProfitDTO> dataList = extDoAgentProfitDAO.pageQueryAgentProfit(query);
		/**
		 * 获取分润配置项
		 */
		BigDecimal profitRate = new BigDecimal(getValue(ConfigEnums.PROFIT_RATE));
		model.put("profitRate", profitRate);
		for (int i = 0; i < dataList.size(); i++) {
			AgentProfitDTO dto = dataList.get(i);
			/* 计算分润金额=2.5%*借款金额*借款期限/365  2.5%配数据库 */
			// BigDecimal profitAmount=
			BigDecimal profitAmount = profitRate.divide(BigDecimal.valueOf(100)).multiply(dto.getDebitAmount()).multiply(dto.getBorrowDays())
					.divide(BigDecimal.valueOf(365), 2, RoundingMode.FLOOR);
			dto.setProfitAmount(profitAmount);
		}
		model.put("dataList", dataList);
		model.put("query", query);
		return "/main/debit/profit/profit";
	}
}
