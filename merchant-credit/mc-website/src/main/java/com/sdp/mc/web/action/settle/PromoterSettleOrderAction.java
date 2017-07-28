package com.sdp.mc.web.action.settle;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdo.common.lang.StringUtil;
import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.common.settle.SettleOrderEnums;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.integration.msp.PromoterInfoDTO;
import com.sdp.mc.settle.api.dto.PromoterSettleOrderDTO;
import com.sdp.mc.settle.api.dto.PromoterSettleOrderDplDTO;
import com.sdp.mc.settle.api.dto.inner.PromoterSettleOrder;
import com.sdp.mc.settle.api.enums.ReturnCodeEnums;
import com.sdp.mc.web.action.BaseAction;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;

/**
 * 代理商分润结算单
 */
@Controller
@RequestMapping(value = { "/posPromoter", "/mposPromoter" })
public class PromoterSettleOrderAction extends BaseAction {
	private static Logger logger = LoggerFactory.getLogger(PromoterSettleOrderAction.class);
	@Autowired
	private ScSettleBaseService scSettleBaseService;

	@RequestMapping(value = { "/settle/order/index" })
	public String settleOrderQuery(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String settleQueryBeginTime = DateUtil.formatDate(DateUtils.addMonths(new Date(), -1), "yyyy-MM");
		model.put("settleQueryBeginTime", settleQueryBeginTime);
		return "/main/settle/settleorder/settleorderIndex";
	}

	@RequestMapping(value = { "/settle/order/list" })
	public String settleOrderQuery(PromoterSettleOrderDTO query, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		try {
			MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
			String tempQueryBeginTime = query.getSettleQueryBeginTime();
			// 查询代理商信息
			if (StringUtil.isBlank(tempQueryBeginTime)) {
				String queryBeginTime = DateUtil.dateFormat4(DateUtil.getMothFirstDay(-1));// 上一个月第一天
				String queryEndTime = DateUtil.dateFormat4(DateUtil.getMothLastDay(-1));// 上一个月最后一天
				query.setSettleQueryBeginTime(queryBeginTime);
				query.setSettleQueryEndTime(queryEndTime);
			} else {
				Date beginDate = DateUtil.formartMoth2MothFirstDay(query.getSettleQueryBeginTime().trim());
				String queryBeginTime = DateUtil.dateFormat4(beginDate);
				query.setSettleQueryBeginTime(queryBeginTime);
				Date endDate = DateUtil.getLastDayFromMothFirstDay(beginDate);
				String queryEndTime = DateUtil.dateFormat4(endDate);
				query.setSettleQueryEndTime(queryEndTime);
			}
			PromoterInfoDTO promoterInfoDTO = mspFacade.findPromoterInfoByPromoterId(user.getPromoterId());
			query.setQueryPromoterNo(String.valueOf(promoterInfoDTO.getPromoterNo()));
			query.setQueryPromoterRole(PosMerchantTypeEnums.getMerchantTypeByCode(promoterInfoDTO.getPromoterType()).code);
			query.setQuerySettleStatus(SettleOrderEnums.REVIEWED.code);

			logger.info("settleOrderQuery requestDto{}", ToStringBuilder.reflectionToString(query));
			PromoterSettleOrderDplDTO responDto = scSettleBaseService.getSettleOrderService().querySettleOrdersByPage(query);
			for (PromoterSettleOrder order : responDto.getPromoterSettleOrders()) {
				// =结算手续费分润+提现手续费分润+阶梯奖惩-退费分润减项-退费阶梯奖惩减项
				BigDecimal baseProfits = StringUtil.isBlank(order.getBasePromoterSplitting()) ? BigDecimal.ZERO : new BigDecimal(order
						.getBasePromoterSplitting().trim());
				BigDecimal wdProfits = StringUtil.isBlank(order.getWdPoromoterSplitting()) ? BigDecimal.ZERO : new BigDecimal(order
						.getWdPoromoterSplitting().trim());
				BigDecimal awardProfits = StringUtil.isBlank(order.getAwardAmount()) ? BigDecimal.ZERO
						: new BigDecimal(order.getAwardAmount().trim());
				BigDecimal refundCost = StringUtil.isBlank(order.getCostRefund()) ? BigDecimal.ZERO : new BigDecimal(order.getCostRefund().trim());
				BigDecimal awardRefund = StringUtil.isBlank(order.getAwardRefund()) ? BigDecimal.ZERO : new BigDecimal(order.getAwardRefund().trim());
				order.setPromoterTotalCost(baseProfits.add(wdProfits).add(awardProfits).subtract(refundCost).subtract(awardRefund)
						.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
			}
			logger.info("settleOrderQuery responDto{}", ToStringBuilder.reflectionToString(responDto));
			query.setSettleQueryBeginTime(tempQueryBeginTime);
			model.put("query", responDto);
		} catch (Exception e) {
			model.put("msg", e.getMessage());
			logger.error("settleOrderQuery,{}", e.getMessage(), e);
		}
		return "/main/settle/settleorder/settleorderList";
	}

	/**
	 * 导出
	 * 
	 * @param query
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/settle/order/export" })
	public String settleExport(PromoterSettleOrderDTO query, HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {
		// try {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		PromoterInfoDTO promoterInfoDTO = mspFacade.findPromoterInfoByPromoterId(user.getPromoterId());
		if (promoterInfoDTO == null) {
			model.put("msg", "代理商不存在!");
			return "/main/fastsettle/settleorder/settleorder";
		}
		// 查询代理商信息
		String tempQueryBeginTime = query.getSettleQueryBeginTime();
		// 查询代理商信息
		if (StringUtil.isBlank(tempQueryBeginTime)) {
			String queryBeginTime = DateUtil.dateFormat4(DateUtil.getMothFirstDay(-1));// 上一个月第一天
			String queryEndTime = DateUtil.dateFormat4(DateUtil.getMothLastDay(-1));// 上一个月最后一天
			query.setSettleQueryBeginTime(queryBeginTime);
			query.setSettleQueryEndTime(queryEndTime);
		} else {
			Date beginDate = DateUtil.formartMoth2MothFirstDay(query.getSettleQueryBeginTime().trim());
			String queryBeginTime = DateUtil.dateFormat4(beginDate);
			query.setSettleQueryBeginTime(queryBeginTime);
			Date endDate = DateUtil.getLastDayFromMothFirstDay(beginDate);
			String queryEndTime = DateUtil.dateFormat4(endDate);
			query.setSettleQueryEndTime(queryEndTime);
		}

		query.setQueryPromoterNo(String.valueOf(promoterInfoDTO.getPromoterNo()));
		query.setQueryPromoterRole(PosMerchantTypeEnums.getMerchantTypeByCode(promoterInfoDTO.getPromoterType()).code);
		query.setOperatorId(promoterInfoDTO.getPromoterNo() + "");
		query.setOperatorName(promoterInfoDTO.getPromoterNo() + "");
		logger.info("settleExport requestDto:{}", ToStringBuilder.reflectionToString(query));
		PromoterSettleOrderDplDTO responDto = scSettleBaseService.getSettleOrderService().exportSettleOrder(query);
		logger.info("settleExport responDto:{}", ToStringBuilder.reflectionToString(responDto));
		if (!responDto.getRespCode().equalsIgnoreCase(ReturnCodeEnums.SUCESS.code)) { throw new RuntimeException(responDto.getRespMsg()); }

		String fileKey = responDto.getFileKey();
		String fileName = responDto.getFileName();
		fileDownloadsView(fileKey, fileName, response, CONTENT_TYPE);
		// model.put("query", query);
		// model.put("page", responDto);
		// model.put("respDto", responDto.getPromoterSettleOrders());
		// // } catch (Exception e) {
		// // logger.error("settleExport,{}", e.getMessage(), e);
		// // model.put("msg", e.getMessage());
		// // }
		// return "/main/settle/settleorder/settleorder";
		return null;
	}

	/**
	 * 下载单条结算单
	 * 
	 * @param configInfo
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/settle/order/tosummary")
	@ResponseBody
	public String toSummary(String id, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		logger.info("toSummary {}", ToStringBuilder.reflectionToString(id));
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		PromoterInfoDTO promoterInfoDTO = mspFacade.findPromoterInfoByPromoterId(user.getPromoterId());
		if (promoterInfoDTO == null) {
			model.put("msg", "代理商不存在!");
			throw new RuntimeException("代理商不存在!");
		}
		PromoterSettleOrderDTO settleOrderDTO = new PromoterSettleOrderDTO();
		settleOrderDTO.setOperatorId(promoterInfoDTO.getPromoterNo() + "");
		settleOrderDTO.setOperatorName(promoterInfoDTO.getPromoterNo() + "");
		settleOrderDTO.setSettleOrderId(id);
		logger.info("toSummary,{}", ToStringBuilder.reflectionToString(settleOrderDTO, ToStringStyle.SHORT_PREFIX_STYLE));
		PromoterSettleOrderDTO orderDTO = scSettleBaseService.getSettleOrderService().summary2ExcelInfo4POSPromoter(settleOrderDTO);
		logger.info("toSummary,{}", ToStringBuilder.reflectionToString(orderDTO, ToStringStyle.SHORT_PREFIX_STYLE));

		if (!orderDTO.getRespCode().equalsIgnoreCase(ReturnCodeEnums.SUCESS.code)) throw new RuntimeException(orderDTO.getRespMsg());

		String fileKey = orderDTO.getFileKey();
		String fileName = orderDTO.getFileName();
		fileDownloadsView(fileKey, fileName, response, CONTENT_TYPE);

		return null;
	}
}
