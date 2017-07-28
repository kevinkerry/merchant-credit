package com.sdp.mc.intra.web.settle;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.common.bean.CalcProfitBean;
import com.sdp.mc.settle.api.dto.SimpleOperateResponse;
import com.sdp.mc.settle.api.enums.ReturnCodeEnums;
import com.shengpay.debit.common.enums.MerchantDebitOrderStatusEnums;

@Controller
@RequestMapping("/settle/calcProfit")
public class CalcWithdrawProfitAction {
	private static final Logger logger = LoggerFactory.getLogger(CalcWithdrawProfitAction.class);

	@Autowired
	private ScSettleBaseService scSettleBaseService;
	/**
	 * 初始化查询页面
	 * **/
	@RequestMapping(value = "index")
	public String index(HttpServletRequest request, ModelMap model) {
		model.put("statusEnums", MerchantDebitOrderStatusEnums.values());
		return "/settle/index";
	}

	/**
	 * 计算合作方数据
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "calcLowerLevelPromoterWdSpliting")
	public String calcLowerLevelPromoterWdSpliting(CalcProfitBean paramBean,HttpServletRequest request, ModelMap model) {
		 SimpleOperateResponse response=new SimpleOperateResponse();
		try {
			  response=scSettleBaseService.getCalculateProfitAPIService().redoCalcPartnerPromoterWdSpliting(paramBean.getPromoterNo(), paramBean.getExectueStatTimeStr(), paramBean.getExectueEndTimeStr(),paramBean.getPartnerPromoterNo());
		} catch (Exception e) {
			logger.error("calcLowerLevelPromoterWdSpliting is error",e.getMessage(),e);
			response.setRespCode(ReturnCodeEnums.SYSTEM_EXCEPTION.code);
			response.setRespMsg(ReturnCodeEnums.SYSTEM_EXCEPTION.msg);
		}
		 model.put("result", response);
		return "/settle/result";
	}
}
