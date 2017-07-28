package com.sdp.mc.intra.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdp.mc.common.enums.TaskStatusEnum;
import com.sdp.mc.common.settle.SettleReturnCodeEnums;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.service.task.TimedTaskInfoService;
import com.sdp.mc.task.dao.TimedTaskExecuteInfoDO;
import com.sdp.mc.task.dao.TimedTaskInfoDO;
import com.sdp.mc.task.dao.TimedTaskInfoDOExample;

/**
 * @author: wushiyu
 * @date:2017年4月26日 下午8:20:18
 * @version 1.0
 * @description:定制化操作
 */
@Controller
@RequestMapping("/taskinfo")
public class TimeTaskInfoAction {

	private Logger LOG = LoggerFactory.getLogger(TimeTaskInfoAction.class);

	@Autowired
	private TimedTaskInfoService timedTaskInfoService;

	/**
	 * 任务管理首页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		return "/task/index";
	}

	/**
	 * 新增任务添加界面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/addPageIndex")
	public String addPageIndex(HttpServletRequest request, HttpServletResponse response) {
		return "/task/addTimeTask";
	}

	/**
	 * 查询所有的的任务，按照生效时间进行排序
	 * 
	 * @param query
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/queryTaskList")
	public String queryTaskList(@ModelAttribute("query") TimedTaskInfoDOExample query, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		LOG.info("TimeTaskInfoAction.queryTaskList.start");
		List<TimedTaskInfoDO> datalist = timedTaskInfoService.quaryTimeTaskInfo(query);
		if (datalist != null) {
			for(TimedTaskInfoDO info:datalist){
				info.setTaskContent(timedTaskInfoService.getContentDesc(info));
			}
			model.put("dataList", datalist);
			model.put("query", query);
		} else {
			LOG.info("TimeTaskInfoAction.queryTaskList.end");
			model.put("dataList", null);
		}
		return "/task/timeTaskList";

	}

	/**
	 * 查看一个任务的详细执行信息
	 * 
	 * @param id
	 *            任务编号
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/queryTaskExecuteInfo")
	public String queryTaskExecuteInfoList(Long id, HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		LOG.info("queryTaskExecuteInfo.param[" + "id=" + id + "]");
		if (id!=null) {
			List<TimedTaskExecuteInfoDO> dataExecuteList = timedTaskInfoService.queryTimeTaskExecuteInfoByTaskId(id);
			TimedTaskInfoDO timedTaskInfoDO = timedTaskInfoService.queryTimeTaskDetailInfoByTaskId(id);
			timedTaskInfoDO.setTaskContent(timedTaskInfoService.getContentDesc(timedTaskInfoDO));
			model.put("timedTaskInfoDO", timedTaskInfoDO);
			model.put("dataExecuteList", dataExecuteList);
		} else {
			LOG.error("当前查询的任务记录列表的ID不能为空");
			model.put("timedTaskInfoDO", null);
			model.put("dataExecuteList", null);
		}

		return "/task/timeTaskExecuteList";
	}

	/**
	 * 跳转到更新页面
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/updateTimedTaskInfoPage")
	public String updateTimedTaskInfoPage(Long id, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		LOG.info("updateTimedTaskInfoPage.start====");
		TimedTaskInfoDO timedTaskInfoDO = timedTaskInfoService.queryTimeTaskDetailInfoByTaskId(id);
		model.put("timedTaskInfoDO", timedTaskInfoDO);
		return "/task/updateTimeTask";
	}

	/**
	 * 更新任务信息
	 * 
	 * @param id
	 *            任务号
	 * @param effiectTime
	 *            生效时间
	 * @param retryTimes
	 *            重试次数
	 * @param notifyEmail
	 *            通知邮件
	 * @param notifyPhone通知手机
	 * @param retryTimeInterval
	 *            重试时间间隔
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateTimedTaskInfo")
	@ResponseBody
	public ErrorMessageVO<T> updateTimedTaskInfo(String id, String effiectTime, String retryTimes, String notifyEmail, String notifyPhone,
			String retryTimeInterval, HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		String strEffectiveTime = request.getParameter("effectiveTime");
		int number = timedTaskInfoService.updateTimedTaskInfo(Long.parseLong(id), strEffectiveTime, retryTimes, notifyEmail, notifyPhone,
				retryTimeInterval);
		if (number > 0) {
			message.setSuccess(true);
			message.setErrorCode(SettleReturnCodeEnums.SUCESS.code);
			message.setErrorMessage("更新任务数据成功!");
			return message;
		} else {
			message.setSuccess(false);
			message.setErrorCode(SettleReturnCodeEnums.FAILL.code);
			message.setErrorMessage("更新任务数据失败!");
			return message;
		}
	}

	/**
	 * 增加一个任务，目前考虑到具体的执行情况，目前只新增sql任务
	 * 
	 * @param sqlType
	 *            sql类型
	 * @param taskContext
	 *            任务内容
	 * @param effiectTime
	 *            生效时间
	 * @param retryTimes
	 *            重试次数
	 * @param notifyEmail
	 *            通知邮件
	 * @param notifyPhone
	 *            通知手机
	 * @param retryTimeInterval
	 *            重试时间间隔
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/addTimedTaskInfo")
	@ResponseBody
	public ErrorMessageVO<T> addTimedTaskInfo(String sqlType, String taskContext, String effectiveTime, String retryTimes, String notifyEmail,
			String notifyPhone, String retryTimeInterval, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		String strEffectiveTime = request.getParameter("effectiveTime");
		int number = timedTaskInfoService.addTimeTaskInfo(sqlType, taskContext, strEffectiveTime, retryTimes, notifyEmail, notifyPhone, retryTimeInterval);
		if (number > 0) {
			message.setSuccess(true);
			message.setErrorCode(SettleReturnCodeEnums.SUCESS.code);
			message.setErrorMessage("插入任务数据成功!");
			return message;
		} else {
			message.setSuccess(false);
			message.setErrorCode(SettleReturnCodeEnums.FAILL.code);
			message.setErrorMessage("插入任务数据失败!");
			return message;
		}
	}

	/**
	 * 暂停一个任务，目前考虑到任务的可控项目，目前只是修改任务的状态从运行状态改变到失败状态
	 * 
	 * @param id
	 *            任务编号
	 * @param response
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("/stopTimeTaskJob")
	@ResponseBody
	public ErrorMessageVO<T> stopTimeTaskJob(Long id, HttpServletResponse response, HttpServletRequest request, ModelMap map) {
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		TimedTaskInfoDO timedTaskInfoDO = timedTaskInfoService.queryTimeTaskDetailInfoByTaskId(id);
		LOG.info("#stopTimeTaskJob param[" + "id=" + id + "," + "taskStatus=" + timedTaskInfoDO.getTaskStatus() + "]");
		if (timedTaskInfoDO.getTaskStatus() == TaskStatusEnum.RUNNIING.getCode()) {
			message.setSuccess(false);
			message.setErrorCode(SettleReturnCodeEnums.FAILL.code);
			message.setErrorMessage("当前状态不能停止!");
			return message;
		}
		long number = timedTaskInfoService.stopTimeTask(id);
		if (number > 0) {
			message.setSuccess(true);
			message.setErrorCode(SettleReturnCodeEnums.SUCESS.code);
			message.setErrorMessage("停止任务成功!");
			return message;
		} else {
			message.setSuccess(false);
			message.setErrorCode(SettleReturnCodeEnums.FAILL.code);
			message.setErrorMessage("停止任务失败!");
			return message;
		}

	}

	/**
	 * 开始一个任务，目前只是针对任务状态是待执行，待重试，以及失败的任务可以手动启动，启动次数记为一次
	 * 
	 * @param id
	 *            任务编号
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/startTimedTaskJob")
	@ResponseBody
	public ErrorMessageVO<T> startTimedTaskJob(Long id, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		TimedTaskInfoDO timedTaskInfoDO = timedTaskInfoService.queryTimeTaskDetailInfoByTaskId(id);
		LOG.info("#startTimedTaskJob param[" + "id=" + id + "," + "taskStatus=" + timedTaskInfoDO.getTaskStatus() + "]");
		if (timedTaskInfoDO.getTaskStatus() == TaskStatusEnum.WAIT_RETRY.getCode()
				|| timedTaskInfoDO.getTaskStatus() == TaskStatusEnum.WAIT_RUNNING.getCode()) {
			int number = timedTaskInfoService.startTimeTask(id);
			if (number > 0) {
				message.setSuccess(true);
				message.setErrorCode(SettleReturnCodeEnums.SUCESS.code);
				message.setErrorMessage("启动任务成功!");
				return message;
			} else {
				message.setSuccess(false);
				message.setErrorCode(SettleReturnCodeEnums.FAILL.code);
				message.setErrorMessage("启动任务失败!");
				return message;
			}
		} else {
			message.setSuccess(false);
			message.setErrorCode(SettleReturnCodeEnums.FAILL.code);
			message.setErrorMessage("当前状态不能启动!");
			return message;
		}
	}
}
