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
import com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO;
import com.sdp.emall.intra.admin.security.util.SecurityUserHolder;
import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.common.settle.SettleOrderEnums;
import com.sdp.mc.common.settle.SettleReturnCodeEnums;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.service.settleorder.ScSplittingRuleService;
import com.sdp.mc.settle.api.dto.PromoterSettleOrderDTO;
import com.sdp.mc.settle.api.dto.PromoterSettleOrderDplDTO;
import com.sdp.mc.settle.api.dto.SimpleOperateResponse;
import com.sdp.mc.settle.api.dto.req.SplittingComputeLogRequest;
import com.sdp.mc.settle.api.dto.resp.SplittingComputeLogResponse;
import com.sdp.mc.settle.api.enums.ComputeTypeEnums;

/**
 * 结算单管理
 *
 * @author wangmindong
 *
 */
@Controller
@RequestMapping("/splitting/order")
public class SplittingOrderManagerAction {

	private static final Logger logger = LoggerFactory.getLogger(SplittingOrderManagerAction.class);

	@Autowired
	private ScSettleBaseService scSettleBaseService;

	@Autowired
	private ScSplittingRuleService splittingRuleService;

	/**
	 * 结算单查询
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Date tmp = DateUtil.getMothFirstDay(-1);
		model.put("settleQueryBeginTime", DateUtil.formatDate(tmp, DateUtil.monthFormat));
		return "/settle/order/orderIndex";
	}
	@RequestMapping(value = "/redo/index")
	public String redoIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.put("queryStartTime", DateUtil.formatDate( DateUtil.increaseDate(new Date(),-31), DateUtil.date_pattern));
		model.put("queryEndTime", DateUtil.formatDate( DateUtil.increaseDate(new Date(),-1), DateUtil.date_pattern));
		return "/settle/redo/redoIndex";
	}

	/**
	 * 结算单分页查询
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ajaxPaging/orderList")
	public String queryPage(@ModelAttribute("info") PromoterSettleOrderDTO info, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
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
			PromoterSettleOrderDplDTO responseDto = scSettleBaseService.getSettleOrderService().querySettleOrdersByPage(info);
			model.put("page", responseDto);
			model.put("dataList", responseDto.getPromoterSettleOrders());
		} catch (Exception e) {
			logger.error("SplittingOrderManagerAction#queryPage error {},{}", new Object[] { e.getMessage(), e });
		}
		return "/settle/order/orderList";
	}
	@RequestMapping(value = "/ajaxPaging/redoList")
	public String queryRedoListPage(HttpServletRequest request,Integer pageNum, HttpServletResponse response,
			ModelMap model,Long computeType) {
		try {
			SplittingComputeLogRequest info=new SplittingComputeLogRequest();
			info.setPageSize(20);
			info.setPageNum(pageNum);
			if(computeType==null){
				computeType=ComputeTypeEnums.RETRY_CALC_SPLITTING_ORDER_DATE.code;
			}
			info.setSplitProfitType(computeType);
			SplittingComputeLogResponse responseDto = scSettleBaseService.getSplittingComputeLogService().querySplittingComputeLogPage(info);
			model.put("page", responseDto);
			model.put("dataList", responseDto.getQueryList());
		} catch (Exception e) {
			logger.error("SplittingOrderManagerAction#queryPage error {},{}", new Object[] { e.getMessage(), e });
		}
		return "/settle/redo/redoList";
	}

	/**
	 * 导出结算单（导出汇总）
	 *
	 * @param configInfo
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/collect/export")
	@ResponseBody
	public ErrorMessageVO<T> collectExportOrderData(@ModelAttribute("info") PromoterSettleOrderDTO info, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		logger.info("SplittingOrderManagerAction#collectExportOrderData request {}", ToStringBuilder.reflectionToString(info));
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		try {
			ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
			splittingRuleService.collectExportOrderData(info, user.getUserName(), user.getRealName());
			message.setSuccess(true);
			message.setErrorCode(SettleReturnCodeEnums.SUCESS.code);
			message.setErrorMessage("导出成功!");
		} catch (Exception e) {
			logger.error("SplittingOrderManagerAction#collectExportOrderData error {},{}", new Object[] { e.getMessage(), e });
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SYSTEM_PROCESS.msg);
		}
		return message;
	}

	/**
	 * 下载单条结算单
	 *
	 * @param configInfo
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/simple/export")
	@ResponseBody
	public ErrorMessageVO<T> simpleExportOrderData(String id, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		logger.info("SplittingOrderManagerAction#simpleExportOrderData request {}", ToStringBuilder.reflectionToString(id));
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		try {
			ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
			splittingRuleService.simpleExportOrderData(id, user.getUserName(), user.getRealName());
			message.setSuccess(true);
			message.setErrorCode(SettleReturnCodeEnums.SUCESS.code);
			message.setErrorMessage("下载结算单成功!");
		} catch (Exception e) {
			logger.error("SplittingOrderManagerAction#simpleExportOrderData error {},{}", new Object[] { e.getMessage(), e });
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SYSTEM_PROCESS.msg);
		}
		return message;
	}

	/**
	 * 审核结算单/批量审核
	 *
	 * @param settleOrderIds
	 *            结算单ID
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/check/order")
	@ResponseBody
	public ErrorMessageVO<T> checkOrderData(String[] settleOrderIds, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		logger.info("SplittingOrderManagerAction#checkOrderData request {}", ToStringBuilder.reflectionToString(settleOrderIds));
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		try {
			// 保存操作
			ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
			PromoterSettleOrderDTO settleOrder = new PromoterSettleOrderDTO();
			settleOrder.setSettleOrderIds(settleOrderIds);
			settleOrder.setOperatorId(user.getUserName());
			settleOrder.setOperatorName(user.getRealName());
			settleOrder.setSettleStatus(SettleOrderEnums.REVIEWED.code);
			PromoterSettleOrderDTO responseDto = scSettleBaseService.getSettleOrderService().reviewedSettleOrder(settleOrder);
			if (!SettleReturnCodeEnums.SUCESS.code.equals(responseDto.getRespCode())) {
				message.setErrorCode(responseDto.getRespCode());
				message.setErrorMessage(responseDto.getRespMsg());
				return message;
			}
			message.setSuccess(true);
			message.setErrorCode(SettleReturnCodeEnums.SUCESS.code);
			message.setErrorMessage("审核成功!");
		} catch (Exception e) {
			logger.error("SplittingOrderManagerAction#checkOrderData error {},{}", new Object[] { e.getMessage(), e });
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SYSTEM_PROCESS.msg);
		}
		return message;
	}

	/**
	 * 重新计算数据
	 *
	 * @param settleOrderIds
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/recount/data")
	@ResponseBody
	public ErrorMessageVO<T> recountData(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		try {
			// 保存操作
			SimpleOperateResponse responseDto = scSettleBaseService.getCalculateProfitAPIService().retryCalcSplittingDate();
			if (!SettleReturnCodeEnums.SUCESS.code.equals(responseDto.getRespCode())) {
				message.setErrorCode(responseDto.getRespCode());
				message.setErrorMessage(responseDto.getRespMsg());
				return message;
			}
			message.setSuccess(true);
			message.setErrorCode(SettleReturnCodeEnums.SUCESS.code);
			message.setErrorMessage("重新计算数据成功!");
		} catch (Exception e) {
			logger.error("SplittingOrderManagerAction#checkOrderData error {},{}", new Object[] { e.getMessage(), e });
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SYSTEM_PROCESS.msg);
		}
		return message;
	}
	/**
	 * 重新计算数据
	 *
	 * @param settleOrderIds
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/redo/data")
	@ResponseBody
	public ErrorMessageVO<T> redo(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			String queryStartTime,String queryEndTime,String merchantType , String queryPromoterNo) {
		logger.info("redo init,queryStartTime:{},queryEndTime:{},merchantType:{} , queryPromoterNo:{}",new Object[]{queryStartTime,queryEndTime,merchantType , queryPromoterNo});
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		try {
			// 保存操作
			if(StringUtil.isBlank(queryStartTime)||StringUtil.isBlank(queryEndTime)){
				logger.info("redo queryStartTime or queryEndTime is null");
				return new ErrorMessageVO<T>(false, "-1", "时间范围不能为空");
			}
			Date beginTime=DateUtil.parse2Date(queryStartTime);
			Date endTime=DateUtil.parse2Date(queryEndTime);
			SimpleOperateResponse responseDto = scSettleBaseService.getCalculateProfitAPIService().retryCalcSplittingDate(beginTime,endTime,merchantType,queryPromoterNo);
			if (!SettleReturnCodeEnums.SUCESS.code.equals(responseDto.getRespCode())) {
				message.setErrorCode(responseDto.getRespCode());
				message.setErrorMessage(responseDto.getRespMsg());
				return message;
			}
			message.setSuccess(true);
			message.setErrorCode(SettleReturnCodeEnums.SUCESS.code);
			message.setErrorMessage("重新计算数据成功!");
		} catch (Exception e) {
			logger.error("SplittingOrderManagerAction#checkOrderData error {}", e.getMessage(), e );
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SYSTEM_PROCESS.msg);
		}
		return message;
	}
}
