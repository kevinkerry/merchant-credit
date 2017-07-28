package com.sdp.mc.intra.web.settle;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.settle.api.dto.PromoterDailyProfitInfoDTO;
import com.sdp.mc.settle.api.dto.SimpleOperateResponse;
import com.sdp.mc.settle.api.dto.req.PromoterDailyProfitRequest;
import com.sdp.mc.settle.api.enums.ReturnCodeEnums;

/**
 * 日分润信息
 */

@Controller
@RequestMapping("/daily/profits")
public class PromoterDailyProfitsAction extends BaseAction{

	private static final Logger logger = LoggerFactory.getLogger(PromoterDailyProfitsAction.class);

	@Autowired
	private ScSettleBaseService scSettleBaseService;

	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.put("queryTime", DateUtil.formatDate(DateUtil.increaseDate(new Date(), -1), DateUtil.date_pattern));
		return "/settle/dailyprofits/dailyProfitsIndex";
	}

	/**
	 * 分页查询
	 * @param reportInfoDTO
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ajaxPaging/profitsList")
	public String queryPage(String queryTime, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		logger.info("queryPage request {}",queryTime);
		try {
			PromoterDailyProfitRequest req=new PromoterDailyProfitRequest();
			req.setStartSettleTime(DateUtil.parseDate(queryTime+DateUtil.date_pattern_begin+".0", DateUtil.default_pattern+".SSS"));
			req.setEndSettleTime(DateUtil.parseDate(queryTime+DateUtil.date_pattern_end+".999", DateUtil.default_pattern+".SSS"));
			List<PromoterDailyProfitInfoDTO> data = scSettleBaseService.getPromoterDailyProfitsAPI().queryPromoterDailyProfits(req);
			model.put("data", data);
		} catch (Exception e) {
			logger.error("queryPromoterDailyProfits error ",e);
		}
		return "/settle/dailyprofits/dailyProfitsList";
	}
	/**
	 * 分页查询
	 * @param reportInfoDTO
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/sendDailyProfits")
	@ResponseBody
	public ErrorMessageVO<Object>  sendDailyProfits(String queryTime, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		logger.info("sendDailyProfits request {}",queryTime);
		try {
			SimpleOperateResponse resp = scSettleBaseService.getPromoterDailyProfitsAPI().sendPromoterDailyProfits(queryTime);
			if(!ReturnCodeEnums.SUCESS.equals(resp.getRespCode())){
				return new ErrorMessageVO<Object>(false, "-1", resp.getRespMsg());
			}
		} catch (Exception e) {
			logger.error("queryPromoterDailyProfits error ",e);
			return new ErrorMessageVO<Object>(false, "-1", "推送发生异常！");
		}
		return new ErrorMessageVO<Object>(true);
	}

	
}
