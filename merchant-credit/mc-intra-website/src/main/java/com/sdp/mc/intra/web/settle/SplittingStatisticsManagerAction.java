package com.sdp.mc.intra.web.settle;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
import com.sdp.mc.common.settle.SettleReturnCodeEnums;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.settle.api.dto.PromoterProfitsInfoDTO;
import com.sdp.mc.settle.api.dto.PromoterProfitsInfoDplDTO;
import com.shengpay.logback.mdc.trace.wrapper.InheritTraceNoRunableWrapper;

/**
 * 分润统计管理
 *
 * @author wangmindong
 */
@Controller
@RequestMapping("/splitting/statistics")
public class SplittingStatisticsManagerAction {

	private static final Logger logger = LoggerFactory.getLogger(SplittingStatisticsManagerAction.class);

	@Autowired
	private ScSettleBaseService scSettleBaseService;

	private static ExecutorService executorService = Executors.newFixedThreadPool(5);

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
		model.put("queryStartTime", DateUtil.formatDate(DateUtil.increaseDate(new Date(), -8), DateUtil.date_pattern));
		model.put("queryEndTime", DateUtil.formatDate(DateUtil.increaseDate(new Date(), -1), DateUtil.date_pattern));
		return "/settle/statistics/statisticsIndex";
	}

	/**
	 * 结算单分页查询
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ajaxPaging/statisticsList")
	public String queryPage(@ModelAttribute("info") PromoterProfitsInfoDTO info, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		logger.info("SplittingStatisticsManagerAction#queryPage request {}", ToStringBuilder.reflectionToString(info));
		try {
			if (StringUtil.isBlank(info.getQueryStartTime())) {
				String queryBeginTime = DateUtil.dateFormat4(DateUtil.getMothFirstDay(-1));// 上一个月第一天
				String queryEndTime = DateUtil.dateFormat4(DateUtil.getMothLastDay(-1));// 上一个月最后一天
				info.setQueryStartTime(queryBeginTime);
				info.setQueryEndTime(queryEndTime);
			} else {
//				Date beginDate = DateUtil.formartMoth2MothFirstDay(info.getQueryStartTime().trim());
//				String queryBeginTime = DateUtil.dateFormat4(beginDate);
				info.setQueryStartTime(info.getQueryStartTime()+DateUtil.date_pattern_begin);
				if(StringUtil.isNotBlank(info.getQueryEndTime())){
				    Date endDate = DateUtil.parse2Date(info.getQueryEndTime());
					String queryEndTime;
					if(endDate.compareTo(new Date())>=0){
						endDate=DateUtil.increaseDate(new Date(), -1);
					}
					queryEndTime = DateUtil.getCurrentDayStrEndTime(endDate);
					info.setQueryEndTime(queryEndTime);
				}
			}
			PromoterProfitsInfoDplDTO responseDto = scSettleBaseService.getPromoterProfitsInfoAPI().queryByPage(info);
			model.put("page", responseDto);
			model.put("dataList", responseDto.getPromoterProfitsInfos());
		} catch (Exception e) {
			logger.error("SplittingStatisticsManagerAction#queryPage error {},{}", new Object[] { e.getMessage(), e });
		}
		return "/settle/statistics/statisticsList";
	}

	/**
	 * 导出汇总表
	 *
	 * @param configInfo
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/collect/export")
	@ResponseBody
	public ErrorMessageVO<T> collectExportOrderData(@ModelAttribute("info") PromoterProfitsInfoDTO info, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		logger.info("SplittingStatisticsManagerAction#collectExportOrderData request {}", ToStringBuilder.reflectionToString(info));
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		try {
			// 保存操作
			ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
			if (StringUtil.isBlank(info.getQueryStartTime())) {
				String queryBeginTime = DateUtil.dateFormat4(DateUtil.getMothFirstDay(-1));// 上一个月第一天
				String queryEndTime = DateUtil.dateFormat4(DateUtil.getMothLastDay(-1));// 上一个月最后一天
				info.setQueryStartTime(queryBeginTime);
				info.setQueryEndTime(queryEndTime);
			} else {
				info.setQueryStartTime(info.getQueryStartTime()+DateUtil.date_pattern_begin);
				if(StringUtil.isNotBlank(info.getQueryEndTime())){
				    Date endDate = DateUtil.parse2Date(info.getQueryEndTime());
					String queryEndTime;
					if(endDate.compareTo(new Date())>=0){
						endDate=DateUtil.increaseDate(new Date(), -1);
					}
					queryEndTime = DateUtil.getCurrentDayStrEndTime(endDate);
					info.setQueryEndTime(queryEndTime);
				}
			}
			SplittingStaticsticsThread thread = new SplittingStaticsticsThread(info, user);
			executorService.execute(new InheritTraceNoRunableWrapper(thread));
			message.setSuccess(true);
			message.setErrorCode(SettleReturnCodeEnums.SUCESS.code);
			message.setErrorMessage("导出汇总成功!");
		} catch (Exception e) {
			logger.error("SplittingOrderManagerAction#collectExportOrderData error {},{}", new Object[] { e.getMessage(), e });
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SYSTEM_PROCESS.msg);
		}
		return message;
	}

	/**
	 * 导出结算单（导出汇总）,后台操作
	 */
	class SplittingStaticsticsThread implements Runnable {
		PromoterProfitsInfoDTO settleOrderDTO;
		ActAdminUserDO user;

		public SplittingStaticsticsThread(PromoterProfitsInfoDTO settleOrderDTO, ActAdminUserDO user) {
			this.settleOrderDTO = settleOrderDTO;
			this.user = user;
		}

		@Override
		public void run() {
			try {
				settleOrderDTO.setOperatorId(user.getUserName());
				settleOrderDTO.setOperatorName(user.getRealName());

				PromoterProfitsInfoDTO responseDto = scSettleBaseService.getPromoterProfitsInfoAPI().summary2Info(settleOrderDTO);
				logger.info("SplittingStaticsticsThread response msg {}", responseDto.getRespMsg());
			} catch (Exception e) {
				logger.error("SplittingStaticsticsThread system error:{},{}", new Object[] { e.getMessage(), e });
			}
		}
	}
}
