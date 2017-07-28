package com.sdp.mc.web.action.debit;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shengpay.debit.common.enums.CreditLevelStatusEnum;
import com.shengpay.debit.common.risk.model.CreditRiskResult;
import com.shengpay.debit.common.service.CreditLinesApplyService;
import com.shengpay.debit.common.service.MerchantCreditLinesApplyService;
import com.shengpay.debit.credit.lines.apply.enums.CreditLinesApplyStatusEnums;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;

/**
 * 征信系统评级结果通知接口
 * **/
@Controller
@RequestMapping(value = {"/common/merchant"})
public class CreditNotifyAction {
	private static final Logger logger = LoggerFactory.getLogger(CreditNotifyAction.class);

	@Autowired
	private CreditLinesApplyService creditLinesApplyService;

	@Autowired
	private MerchantCreditLinesApplyService merchantCreditLinesApplyService;


	/**
	 * 目前流程修改，不需要
	 * @param request
	 * @param crr
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/recieveCreditLevel")
	public String recieveCreditLevel(HttpServletRequest request, @RequestBody CreditRiskResult crr, HttpServletResponse response, ModelMap model) {
		try {
			logger.info("CreditNotifyAction.recieveCreditLevel.crr=" + ToStringBuilder.reflectionToString(crr));
			String result = "fail";
			if (!CreditLevelStatusEnum.PROCESSING.code.equals(crr.getStatus())) {
				DoMerchantCreditLinesApplyPO creditLineApply = this.merchantCreditLinesApplyService.getLatestCreditLines(crr.getCode());
				if (CreditLinesApplyStatusEnums.RISK_SUBMIT.key.equals(creditLineApply.getApplyStatus())) {
					// this.creditLinesApplyService.syncCreditRiskResult(creditLineApply, crr);
					result = "";
				} else if (CreditLinesApplyStatusEnums.RISK_NOTIFY.key.equals(creditLineApply.getApplyStatus())) {
					result = "";
				} else if (CreditLinesApplyStatusEnums.APLY_SUCCESS.key.equals(creditLineApply.getApplyStatus())) {
					result = "";
				} else if (CreditLinesApplyStatusEnums.APPLY_FAIL.key.equals(creditLineApply.getApplyStatus())) {
					result = "";
				}
				logger.info("merchantNo=" + crr.getCode() + ",status=" + creditLineApply.getApplyStatus() + ",result=" + result);
			}
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
			return null;
		} catch (Exception e) {
			logger.error("CreditNotifyAction.recieveCreditLevel.error", e);
		}
		return null;
	}
}
