package com.sdp.mc.intra.web.settle;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang3.StringUtils;
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
import com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO;
import com.sdp.emall.intra.admin.security.util.SecurityUserHolder;
import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.common.settle.SettleOrderEnums;
import com.sdp.mc.common.settle.SettleReturnCodeEnums;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.service.settleorder.ScSplittingRuleService;
import com.sdp.mc.settle.api.dto.PromoterEasypaySettleOrderDTO;
import com.sdp.mc.settle.api.dto.PromoterEasypaySettleOrderDplDTO;
import com.sdp.mc.settle.api.dto.PromoterSettleOrderDTO;
import com.sdp.mc.settle.api.dto.SimpleOperateResponse;

/**
 * 云收银分润结算单管理（后台）
 *
 */
@Controller
@RequestMapping("/easypaySettleOrder")
public class EasypaySettleOrderAction {
	
	private static final Logger log = LoggerFactory.getLogger(EasypaySettleOrderAction.class);
	
	@Autowired
	private ScSettleBaseService scSettleBaseService;
	
	@Autowired
	private ScSplittingRuleService splittingRuleService;
	
	/**
	 * 分润结算单管理
	 * @param request
	 * @param response
	 * @param model
	 * @return  settleOrderList
	 */
	@RequestMapping("/settleOrderIndex")
	public String settleOrderIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Date tmp = DateUtil.getMothFirstDay(-1);
		model.put("settleQueryBeginTime", DateUtil.formatDate(tmp, DateUtil.monthFormat));
		return "/easypay/settleOrderIndex";
	}
	
	/**
	 * 分润结算单分页查询
	 * @return
	 */
	@RequestMapping("/settleOrderList")
	public String settleOrderList(@ModelAttribute("info") PromoterEasypaySettleOrderDTO info, HttpServletRequest request, HttpServletResponse response,
			ModelMap model){
		try {
			if (StringUtil.isBlank(info.getSettleQueryBeginTime())) {
				String queryBeginTime = DateUtil.dateFormat4(DateUtil.getMothFirstDay(-1));// 上一个月第一天
				String queryEndTime = DateUtil.dateFormat4(DateUtil.getMothLastDay(-1));// 上一个月最后一天
				info.setSettleQueryBeginTime(queryBeginTime);
				info.setSettleQueryEndTime(queryEndTime);
			} else {
				Date beginDate = DateUtil.formartMoth2MothFirstDay(info.getSettleQueryBeginTime().trim());
				String queryBeginTime = DateUtil.dateFormat4(beginDate);
				info.setSettleQueryBeginTime(queryBeginTime);
				Date endDate = DateUtil.getLastDayFromMothFirstDay(beginDate);
				String queryEndTime = DateUtil.dateFormat4(endDate);
				info.setSettleQueryEndTime(queryEndTime);
			}
			info.setPageSize(100);
			PromoterEasypaySettleOrderDplDTO responseDto = scSettleBaseService.getSettleOrderService().queryEasypaySettleOrdersByPage(info);
			model.put("page", responseDto);
			model.put("dataList", responseDto.getPromoterEasypaySettleOrders());
		} catch (Exception e) {
			log.error("EasypaySettleOrderAction#settleOrderList error {},{}", new Object[] { e.getMessage(), e });
		}
		return "/easypay/settleOrderList";
	}
	/**
	 * 审核
	 * settleOrderToExamine
	 */
	@RequestMapping("/settleOrderToExamine")
	@ResponseBody
	public ErrorMessageVO<T> settleOrderToExamine(String[] settleOrderIds, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		log.info("EasypaySettleOrderAction#settleOrderToExamine request {}", ToStringBuilder.reflectionToString(settleOrderIds));
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		try {
			ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
			PromoterEasypaySettleOrderDTO easypaySettleOrderDTO = new PromoterEasypaySettleOrderDTO();
			easypaySettleOrderDTO.setSettleOrderIds(settleOrderIds);
			easypaySettleOrderDTO.setOperatorId(user.getUserName());
			easypaySettleOrderDTO.setOperatorName(user.getRealName());
			easypaySettleOrderDTO.setSettleStatus(SettleOrderEnums.REVIEWED.code);
			PromoterEasypaySettleOrderDTO responseDto = scSettleBaseService.getSettleOrderService().reviewedEasypaySettleOrder(easypaySettleOrderDTO);
			if(!SettleReturnCodeEnums.SUCESS.code.equals(responseDto.getRespCode())){
				message.setErrorCode(responseDto.getRespCode());
				message.setErrorMessage(responseDto.getRespMsg());
				return message;
			}
			message.setSuccess(true);
		} catch (Exception e) {
			log.error("EasypaySettleOrderAction#settleOrderToExamine error {},{}", new Object[] { e.getMessage(), e });
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SYSTEM_PROCESS.msg);
		}
		return message;
	}
	
	/**
	 * 审核不通过
	 * settleOrderNotExamine
	 */
	@RequestMapping("/settleOrderNotExamine")
	@ResponseBody
	public ErrorMessageVO<T> settleOrderNotExamine(String[] settleOrderIds, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		log.info("EasypaySettleOrderAction#settleOrderToExamine request {}", ToStringBuilder.reflectionToString(settleOrderIds));
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		try {
			ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
			PromoterEasypaySettleOrderDTO easypaySettleOrderDTO = new PromoterEasypaySettleOrderDTO();
			easypaySettleOrderDTO.setSettleOrderIds(settleOrderIds);
			easypaySettleOrderDTO.setOperatorId(user.getUserName());
			easypaySettleOrderDTO.setOperatorName(user.getRealName());
			easypaySettleOrderDTO.setSettleStatus(SettleOrderEnums.NOTREVIEWED.code);
			PromoterEasypaySettleOrderDTO responseDto = scSettleBaseService.getSettleOrderService().reviewedEasypaySettleOrder(easypaySettleOrderDTO);
			if(!SettleReturnCodeEnums.SUCESS.code.equals(responseDto.getRespCode())){
				message.setErrorCode(responseDto.getRespCode());
				message.setErrorMessage(responseDto.getRespMsg());
				return message;
			}
			message.setSuccess(true);
		} catch (Exception e) {
			log.error("EasypaySettleOrderAction#settleOrderToExamine error {},{}", new Object[] { e.getMessage(), e });
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SYSTEM_PROCESS.msg);
		}
		return message;
	}
	/**
	 * 下载
	 */
	@RequestMapping(value = "/settleOrderToExport")
	@ResponseBody
	public ErrorMessageVO<T> simpleEasypayExportOrderData(String id, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		log.info("EasypaySettleOrderAction#simpleEasypayExportOrderData request {}", ToStringBuilder.reflectionToString(id));
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		try {
			ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
			splittingRuleService.simpleEasypayExportOrderData(id, user.getUserName(), user.getRealName());
			message.setSuccess(true);
			message.setErrorCode(SettleReturnCodeEnums.SUCESS.code);
			message.setErrorMessage("下载结算单成功!");
		} catch (Exception e) {
			log.error("EasypaySettleOrderAction#simpleEasypayExportOrderData error {},{}",
					new Object[] { e.getMessage(), e });
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SYSTEM_PROCESS.msg);
		}
		return message;
	}
	
	/**
	 * 云收银重新计算数据
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/settleOrderToRecountData")
	@ResponseBody
	public ErrorMessageVO<T> easypayRecountData(@ModelAttribute("info") PromoterEasypaySettleOrderDTO info, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		Date date = null;
		try {
			// 保存操作
			if(StringUtils.isNotBlank(info.getSettleQueryBeginTime())){
				SimpleDateFormat simDate = new SimpleDateFormat("yyyy-MM");
				date = simDate.parse(info.getSettleQueryBeginTime().trim());
			}
			SimpleOperateResponse responseDto = scSettleBaseService.getCalculateProfitAPIService().retryEasypayCalcSplittingDate(date);
			if (!SettleReturnCodeEnums.SUCESS.code.equals(responseDto.getRespCode())) {
				message.setErrorCode(responseDto.getRespCode());
				message.setErrorMessage(responseDto.getRespMsg());
				return message;
			}
			message.setSuccess(true);
			message.setErrorCode(SettleReturnCodeEnums.SUCESS.code);
			message.setErrorMessage("重新计算数据成功!");
		} catch (Exception e) {
			log.error("SplittingOrderManagerAction#checkOrderData error {},{}", new Object[] { e.getMessage(), e });
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SYSTEM_PROCESS.msg);
		}
		return message;
	}
	
}
