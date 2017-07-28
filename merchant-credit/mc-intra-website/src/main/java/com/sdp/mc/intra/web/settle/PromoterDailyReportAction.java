package com.sdp.mc.intra.web.settle;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdo.common.lang.StringUtil;
import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.settle.api.dto.PromoterDailyReportInfoDTO;
import com.sdp.mc.settle.api.dto.PromoterDailyReportInfoDplDTO;
import com.sdp.mc.settle.api.dto.ResponseDTO;
import com.sdp.mc.settle.api.enums.ReturnCodeEnums;

/**
 * 清算日常报表
 */

@Controller
@RequestMapping("/daily")
public class PromoterDailyReportAction extends BaseAction{

	private static final Logger logger = LoggerFactory.getLogger(PromoterDailyReportAction.class);

	@Autowired
	private ScSettleBaseService scSettleBaseService;

	@RequestMapping(value = "/report/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.put("queryStartTime", DateUtil.formatDate(DateUtil.increaseDate(new Date(), -7), DateUtil.date_pattern));
		model.put("queryEndTime", DateUtil.formatDate(new Date(), DateUtil.date_pattern));
		return "/settle/daliyreport/daliyReportIndex";
	}

	/**
	 * 分页查询
	 * @param reportInfoDTO
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ajaxPaging/reportList")
	public String queryPage(@ModelAttribute("info") PromoterDailyReportInfoDTO reportInfoDTO, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		logger.info("PromoterDailyReportAction#queryPage request {}",ToStringBuilder.reflectionToString(reportInfoDTO));
		try {
			if (StringUtil.isNotBlank(reportInfoDTO.getQueryStartTime())) {
				String startDate = DateUtil.getCurrentDayStrFristTime(DateUtil.parseDate(reportInfoDTO.getQueryStartTime(), DateUtil.date_pattern));
				reportInfoDTO.setQueryStartTime(startDate);
			}
			if (StringUtil.isNotBlank(reportInfoDTO.getQueryEndTime())) {
				String endDate = DateUtil.getCurrentDayStrEndTime(DateUtil.parseDate(reportInfoDTO.getQueryEndTime(), DateUtil.date_pattern));
				reportInfoDTO.setQueryEndTime(endDate);
			}
			PromoterDailyReportInfoDplDTO respDto = scSettleBaseService.getPromoterDailyReportAPI().queryByPage(reportInfoDTO);
			logger.info("PromoterDailyReportAction#queryPage response {}",ToStringBuilder.reflectionToString(respDto));
			model.put("page", respDto);
		} catch (Exception e) {
			logger.error("PromoterDailyReportAction#queryPage error {},{}",new Object[]{e,e.getMessage()});
		}
		return "/settle/daliyreport/daliyReportList";
	}


	/**
	 * 下载
	 * @param reportInfoDTO
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/report/export/data")
	@ResponseBody
	public ErrorMessageVO<T> exportDailyData(@ModelAttribute("info") PromoterDailyReportInfoDTO reportInfoDTO, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		logger.info("PromoterDailyReportAction#exportDailyData request {}",ToStringBuilder.reflectionToString(reportInfoDTO));
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		try {
			if (StringUtil.isNotBlank(reportInfoDTO.getQueryStartTime())) {
				String startDate = DateUtil.getCurrentDayStrFristTime(DateUtil.parseDate(reportInfoDTO.getQueryStartTime(), DateUtil.date_pattern));
				reportInfoDTO.setQueryStartTime(startDate);
			}
			if (StringUtil.isNotBlank(reportInfoDTO.getQueryEndTime())) {
				String endDate = DateUtil.getCurrentDayStrEndTime(DateUtil.parseDate(reportInfoDTO.getQueryEndTime(), DateUtil.date_pattern));
				reportInfoDTO.setQueryEndTime(endDate);
			}
			reportInfoDTO.setOperatorId(getOperatorId());
			reportInfoDTO.setOperatorName(getOperatorName());
			ResponseDTO respDto = scSettleBaseService.getPromoterDailyReportAPI().downloadByQuery(reportInfoDTO);
			if (!ReturnCodeEnums.SUCESS.code.equals(respDto.getRespCode())) {
				message.setErrorCode(respDto.getRespCode());
				message.setErrorMessage(respDto.getRespMsg());
				return message;
			}
			message.setSuccess(true);
			message.setErrorCode(ReturnCodeEnums.SUCESS.code);
			message.setErrorMessage(ReturnCodeEnums.SUCESS.msg);
		} catch (Exception e) {
			logger.error("PromoterDailyReportAction#exportDailyData error {},{}",new Object[]{e,e.getMessage()});
			message.setErrorCode(ReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(ReturnCodeEnums.SYSTEM_PROCESS.msg);
		}
		return message;
	}
}
