package com.sdp.mc.batch.task;

import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.mc.service.api.bean.BaseCustomizedTimedTask;
import com.mc.service.api.exception.TimedTaskException;
import com.sdo.common.lang.StringUtil;
import com.sdp.mc.batch.BaseHandler;
import com.sdp.mc.common.enums.AlertMessageSendTypeEnum;
import com.sdp.mc.common.enums.TaskStatusEnum;
import com.sdp.mc.common.enums.TaskTypeEnums;
import com.sdp.mc.service.task.TimedTaskInfoService;
import com.sdp.mc.task.dao.TimedTaskInfoDO;
import com.sdp.mc.task.dao.daointerface.ExtTimedTaskInfoDAO;
import com.shengpay.logback.mdc.trace.wrapper.InheritTraceNoRunableWrapper;
import com.shengpay.service.alert.factory.AlertMessageSenderFactory;
import com.shengpay.service.mail.AlertMessageSender;
import com.shengpay.service.message.MessageService;

/**
 * @author: wushiyu
 * @date:2017年5月3日 上午11:08:52
 * @version 1.0
 * @description:定制任务执行扶手
 */
@Service("timeTaskHandler")
public class TimeTaskHandler extends BaseHandler {

	private Logger log = LoggerFactory.getLogger(TimeTaskHandler.class);

	private final String EXECUTE_RESULT_SUCCESS = "执行成功!";


	private final String EXECUTE_RESULT_FAIL = "执行失败!";


	@Autowired
	private TimedTaskInfoService timedTaskInfoService;

	@Autowired
	private MessageService messageService;

	@Autowired
	private AlertMessageSenderFactory alertMessageSenderFactory;

	/**
	 * 执行任务的过程，目前处理逻辑是先跑一次，失败的按照重试次数再次跑重试机会
	 */
	public void excuteJob() {
		log.info("-----executeJob.start-----");
		// 查询过滤需要执行的任务，该处目前只用到了时间处理过滤
		List<TimedTaskInfoDO> timeTaskList = timedTaskInfoService.queryWaitExecuteTaskInfo();
		for (TimedTaskInfoDO timedTaskInfoDO : timeTaskList) {
			TimeTaskRun timeTaskRun = new TimeTaskRun(timedTaskInfoDO);
			timedTaskInfoService.updateTaskStatusRunning(timedTaskInfoDO.getId());
			pool.execute(new InheritTraceNoRunableWrapper(timeTaskRun));
		}
		log.info("-------excuteJob.end-------");
	}

	class TimeTaskRun implements Runnable {

		private TimedTaskInfoDO timedTaskInfoDO;

		public TimeTaskRun(TimedTaskInfoDO timedTaskInfoDO) {
			this.timedTaskInfoDO = timedTaskInfoDO;
		}

		@SuppressWarnings("unchecked")
		@Override
		public void run() {

			// 任务执行开始时间
			long startTime = System.currentTimeMillis();
			boolean isExecuteSuccess = true;
			// 执行结果
			String result = null;
			// 备注
			String remark = null;
			// 执行状态
			int taskStatus = TaskStatusEnum.RUNNIING.getCode();
			try {
				Map<String, String> executeTimedTaskParam = JSONObject.fromObject(this.timedTaskInfoDO.getTaskContent());
				String executeBeanName = null;
				if (this.timedTaskInfoDO.getTaskType() == TaskTypeEnums.TASKTYPE_SQL.getCode()) {
					remark = "当前执行sql任务";
					executeBeanName = "sqlTimedTask";
				} else if (this.timedTaskInfoDO.getTaskType() == TaskTypeEnums.TASKTYPE_CUSTOMIZED.getCode()) {
					remark = "当前执行定制化任务";
					executeBeanName = executeTimedTaskParam.get("customizedBeanName");
				}
				WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
				if (!wac.containsBean(executeBeanName)||executeBeanName==null) {
					remark += ",找不到对应的bean实例信息";
					log.info(remark);
					isExecuteSuccess = false;
				} else {
					BaseCustomizedTimedTask bct = (BaseCustomizedTimedTask) wac.getBean(executeBeanName);
					try {
						bct.execute(executeTimedTaskParam);
						// 修改状态执行成功!
					} catch (TimedTaskException e) {
						isExecuteSuccess = false;
						remark += ",执行失败："+e.getErrorMessage();
						log.error("executeTimedTask TimedTaskException", e);
					}
				}
			} catch (Exception e) {
				isExecuteSuccess = false;
				remark += ",执行异常："+e.getMessage();
				log.error("executeTimedTask Exception", e);
			}
			if (isExecuteSuccess) {
				result = EXECUTE_RESULT_SUCCESS;
				taskStatus=TaskStatusEnum.RUNNING_SUCCESS.getCode();
			} else {
				result = EXECUTE_RESULT_FAIL;
				if(timedTaskInfoDO.getRetryTimes()>timedTaskInfoDO.getExecuteTimes()+1){
					taskStatus=TaskStatusEnum.WAIT_RETRY.getCode();
				}else{//重试达到次数
					taskStatus=TaskStatusEnum.RUNNING_FAIL.getCode();
					//邮件通知
					if(StringUtil.isNotBlank(timedTaskInfoDO.getNotifyEmail())){
						sendMailMessage(timedTaskInfoDO.getNotifyEmail(),"定时任务执行失败通知",timedTaskInfoService.getContentDesc(timedTaskInfoDO)+"失败");
					}
					//手机通知 
					if(StringUtil.isNotBlank(timedTaskInfoDO.getNotifyPhone())){
						//TODO 暂时不实现
						//sendMailMessage(timedTaskInfoDO.getNotifyPhone(),"定时任务执行失败通知",getNotifyContent(timedTaskInfoDO));
					}
				}
			}
			long endTime = System.currentTimeMillis();

			long use_time = endTime - startTime;
			// 保存每次执行的详细数据
			long executeId = timedTaskInfoService.saveTimedTaskExecuteInfo(new Date(), new Date(), timedTaskInfoDO.getId(),
					new Long(use_time).intValue(), result, remark);

			// 保存每次执行的任务数据
			timedTaskInfoService.updateTimedTaskExecuteInfo(timedTaskInfoDO.getId(), taskStatus, timedTaskInfoDO.getExecuteTimes() == null ? 1
					: (timedTaskInfoDO.getExecuteTimes() + 1), executeId);

		}


		public TimedTaskInfoDO getTimedTaskInfoDO() {
			return timedTaskInfoDO;
		}

		public void setTimedTaskInfoDO(TimedTaskInfoDO timedTaskInfoDO) {
			this.timedTaskInfoDO = timedTaskInfoDO;
		}
	}

	/**
	 * 发送预警邮件
	 * 
	 * @param email
	 *            邮件地址
	 * @param title
	 *            邮件名称
	 * @param messageContext
	 *            邮件内容
	 */
	public void sendMailMessage(String email, String title, String messageContext) {
		log.info("发送邮件的相关信息：" + "sendMailMessage:" + "title=" + title + "," + "email=" + email + "," + "messageConetxt=" + messageContext);
		// 邮件头

		AlertMessageSender alertMessageSender = alertMessageSenderFactory.getAlertMessageSender(AlertMessageSendTypeEnum.MAIL_ALERT);

		alertMessageSender.sendMessage(title, messageContext, email);
	}
}
