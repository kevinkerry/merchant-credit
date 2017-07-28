package com.sdp.mc.service.task.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.service.api.TimedTaskAPI;
import com.mc.service.api.exception.TimedTaskException;
import com.sdp.mc.common.enums.TaskSqlTypeEnums;
import com.sdp.mc.common.enums.TaskStatusEnum;
import com.sdp.mc.common.enums.TaskTypeEnums;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.service.task.TimedTaskInfoService;
import com.sdp.mc.task.dao.TimedTaskExecuteInfoDO;
import com.sdp.mc.task.dao.TimedTaskExecuteInfoDOExample;
import com.sdp.mc.task.dao.TimedTaskInfoDO;
import com.sdp.mc.task.dao.TimedTaskInfoDOExample;
import com.sdp.mc.task.dao.daointerface.ExtTimedTaskInfoDAO;
import com.sdp.mc.task.dao.daointerface.TimedTaskInfoDAO;
import com.sdp.mc.task.manager.TimedTaskExecuteInfoManager;
import com.sdp.mc.task.manager.TimedTaskInfoManager;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;

/**
 * @author: wushiyu
 * @date:2017年4月27日 下午2:20:52
 * @version 1.0
 * @description：定时任务服务接口实现
 */
@Service("timedTaskInfoService")
public class TimedTaskInfoServiceImpl implements TimedTaskInfoService, TimedTaskAPI {

	private Logger log = LoggerFactory.getLogger(TimedTaskInfoServiceImpl.class);

	@Autowired
	private TimedTaskExecuteInfoManager timedTaskExecuteInfoManager;
	@Autowired
	private TimedTaskInfoDAO timedTaskInfoDAO;

	@Autowired
	private TimedTaskInfoManager timedTaskInfoManager;

	@Autowired
	private ExtTimedTaskInfoDAO extTimedTaskInfoDAO;

	/**
	 * 查询任务列表
	 */
	public List<TimedTaskInfoDO> quaryTimeTaskInfo(TimedTaskInfoDOExample query) {
		query.setOrderByClause("ID DESC");
		return timedTaskInfoManager.selectByQuery(query);

	}

	/**
	 * 查询一条任务信息
	 */
	public TimedTaskInfoDO queryTimeTaskDetailInfoByTaskId(long id) {
		log.info("quearyTimeTaskDetailInfo.param：[" + "ID=" + id + "]");

		return timedTaskInfoManager.selectByPrimaryKey(id);

	}

	@Override
	public List<TimedTaskExecuteInfoDO> queryTimeTaskExecuteInfoByTaskId(long id) {
		// TODO Auto-generated method stub
		log.info("queryTimeTaskExecuteInfo.param：[" + "ID==" + id + "]");
		TimedTaskExecuteInfoDOExample example = new TimedTaskExecuteInfoDOExample();
		example.setTaskId(id);
		example.setOrderByClause("ID DESC");
		return timedTaskExecuteInfoManager.selectByExample(example);
	}

	@Override
	public int updateTimedTaskInfo(long id, String effiectTime, String retryTimes, String notifyEmail, String notifyPhone, String retryTimeInterval) {
		// TODO Auto-generated method stub
		log.info("updateTimedTaskInfo.param:[" + "id=" + id + "," + "effiectTime=" + effiectTime + "," + "retryTimes=" + retryTimes + ","
				+ "notifyEmail=" + notifyEmail + "," + "notifyPhone=" + notifyPhone + "," + "retryTimeInterval=" + retryTimeInterval + "]");

		TimedTaskInfoDO timedTaskInfoDO = new TimedTaskInfoDO();

		timedTaskInfoDO = timedTaskInfoManager.selectByPrimaryKey(id);

		timedTaskInfoDO.setEffectiveTime(DateUtil.str2Date(effiectTime));
		timedTaskInfoDO.setRetryTimes(Integer.parseInt(retryTimes));
		timedTaskInfoDO.setNotifyEmail(notifyEmail);
		timedTaskInfoDO.setNotifyPhone(notifyPhone);
		timedTaskInfoDO.setRetryTimeInterval(Integer.parseInt(retryTimeInterval));

		int updateNumber = timedTaskInfoManager.updateByPrimaryKey(timedTaskInfoDO);

		if (updateNumber > 0) {
			log.info("updateTimedTaskInfo.execute.result:[" + "success=" + "true" + "]");
			return 1;
		} else {
			log.info("updateTimedTaskInfo.execute.result:[" + "success=" + "false" + "]");
			return 0;
		}

	}

	/**
	 * 目前手动添加任务只是针对sql(该处还需要明确下来)
	 */
	public int addTimeTaskInfo(String sqlType, String taskContext, String effiectTime, String retryTimes, String notifyEmail, String notifyPhone,
			String retryTimeInterval) {
		log.info("addTimeTaskInfo.param:[" + "sqlType=" + sqlType + "," + "taskContext=" + taskContext + "," + "effiectTime=" + effiectTime + ","
				+ "retryTimes=" + retryTimes + "," + "notifyEmail=" + notifyEmail + "," + "notifyPhone=" + notifyPhone + "," + "retryTimeInterval="
				+ "retryTimeInterval" + "]");
		TimedTaskInfoDO timedTaskInfoDO = new TimedTaskInfoDO();
		Map<String, String> hashmap = new HashMap<String, String>();
		hashmap.put("sqlType", sqlType);
		hashmap.put("sqlContext", taskContext);

		JSONObject jsonObject = JSONObject.fromObject(hashmap);

		timedTaskInfoDO.setTaskType(1);

		timedTaskInfoDO.setTaskContent(jsonObject.toString());

		timedTaskInfoDO.setCreateTime(new Date());

		timedTaskInfoDO.setEffectiveTime(DateUtil.str2Date(effiectTime));

		timedTaskInfoDO.setExecuteTimes(0);

		timedTaskInfoDO.setLastExecuteId(0L);

		timedTaskInfoDO.setNotifyEmail(notifyEmail);

		timedTaskInfoDO.setNotifyPhone(notifyPhone);

		timedTaskInfoDO.setRetryTimes(Integer.parseInt(retryTimes));

		timedTaskInfoDO.setRetryTimeInterval(Integer.parseInt(retryTimeInterval));

		timedTaskInfoDO.setTaskStatus(TaskStatusEnum.WAIT_RUNNING.getCode());

		timedTaskInfoDO.setUpdateTime(new Date());

		long insetNumber = timedTaskInfoManager.insertSelective(timedTaskInfoDO);

		if (insetNumber > 0) {
			log.info("addTimeTaskInfo.execute.result:[" + "success=" + "true" + "]");
			return 1;
		} else {
			log.info("addTimeTaskInfo.execute.result:[" + "success=" + "false" + "]");
			return 0;
		}
	}

	@Override
	public Long createSqlTimedTask(int sqlType, String sqlContext, String effectiveTime, int retryTimes, int retryTimeInterval, String notifyPhone,
			String notifyEmail) throws TimedTaskException {
		log.info("createSqlTimedTask.param：" + "[sqlType=" + sqlType + "," + "sqlContext=" + sqlContext + "," + "effectiveTime=" + effectiveTime
				+ "," + "retryTimes=" + retryTimes + "," + "retryTimeInterval=" + retryTimeInterval + "," + "notifyPhone=" + notifyPhone
				+ "notifyEmail=" + notifyEmail);
		TimedTaskInfoDO timedTaskInfoDO = new TimedTaskInfoDO();
		long inertNumber = 0;
		try {
			if (sqlType == 0 && StringUtils.isNotBlank(sqlContext)) {
				// context内容构造
				Map<String, String> contextMap = new HashMap<String, String>();
				contextMap.put("sqlType", String.valueOf(sqlType));
				contextMap.put("sqlContext", sqlContext);
				JSONObject jsonObject = JSONObject.fromObject(contextMap);

				timedTaskInfoDO = createBaseTimeTaskInfo(1, jsonObject.toString(), effectiveTime, retryTimes, retryTimeInterval, notifyPhone,
						notifyEmail);

				inertNumber = timedTaskInfoManager.insert(timedTaskInfoDO);

			} else {
				log.info("sqlType and sqlContext can not empty");
				return inertNumber;
			}
		} catch (Exception e) {
			log.error("createSqlTimedTask.result.exception:[" + "e==" + e + "]");
		}

		return inertNumber;
	}

	/**
	 * 定制化任务
	 */
	public Long createCustomizedTimedTask(String customizedBeanName, Map<String, String> executeParam, String effectiveTime, int retryTimes,
			int retryTimeInterval, String notifyPhone, String notifyEmail) throws TimedTaskException {
		log.info("createCustomizedTimedTask.param:" + "[ customizedBeanName=" + customizedBeanName + "," + "executeParam=" + executeParam + ","
				+ "effectiveTime=" + effectiveTime + "," + "retryTimes=" + retryTimes + "," + "retryTimeInterval=" + retryTimeInterval
				+ "notifyPhone=" + notifyPhone + "," + "notifyEmail=" + notifyEmail);
		TimedTaskInfoDO timedTaskInfoDO = new TimedTaskInfoDO();
		long inserNumber = 0;
		try {

			if (StringUtils.isEmpty(customizedBeanName)) {
				log.info("createCustomizedTimedTask.param:[" + "customizedBeanName=" + customizedBeanName + "]");
				return inserNumber;
			}
			if (executeParam == null) {
				log.info("createCustomizedTimedTask.param:[" + "executeParam=" + executeParam + "]");
				return inserNumber;
			}
			Map<String, String> paramMap = new HashMap<String, String>();

			paramMap = executeParam;

			paramMap.put("customizedBeanName", customizedBeanName);

			JSONObject jsonObject = JSONObject.fromObject(paramMap);

			timedTaskInfoDO = createBaseTimeTaskInfo(2, jsonObject.toString(), effectiveTime, retryTimes, retryTimeInterval, notifyPhone, notifyEmail);

			inserNumber = timedTaskInfoManager.insert(timedTaskInfoDO);

		} catch (Exception e) {
			log.error("createCustomizedTimedTask.result.Exception:[" + "e==" + e + "]");
		}
		return inserNumber;

	}

	/**
	 * 创建公用taskinfo信息
	 * 
	 * @param taskType
	 * @param TaskContext
	 * @param effectiveTime
	 * @param retryTimes
	 * @param retryTimeInterval
	 * @param notifyPhone
	 * @param notifyEmail
	 * @return
	 */
	public TimedTaskInfoDO createBaseTimeTaskInfo(int taskType, String taskContext, String effectiveTime, int retryTimes, int retryTimeInterval,
			String notifyPhone, String notifyEmail) {
		TimedTaskInfoDO timedTaskInfoDO = new TimedTaskInfoDO();
		timedTaskInfoDO.setExecuteTimes(0);
		timedTaskInfoDO.setLastExecuteId(0L);
		timedTaskInfoDO.setLastExecuteTime(null);
		timedTaskInfoDO.setNotifyEmail(notifyEmail);
		timedTaskInfoDO.setTaskContent(taskContext);
		timedTaskInfoDO.setNotifyPhone(notifyPhone);
		timedTaskInfoDO.setCreateTime(new Date());
		timedTaskInfoDO.setEffectiveTime(DateUtil.str2Date(effectiveTime));
		timedTaskInfoDO.setTaskStatus(TaskStatusEnum.WAIT_RUNNING.getCode());
		timedTaskInfoDO.setRetryTimeInterval(retryTimeInterval);
		timedTaskInfoDO.setRetryTimes(retryTimes);
		timedTaskInfoDO.setTaskType(taskType);
		timedTaskInfoDO.setUpdateTime(new Date());
		return timedTaskInfoDO;

	}

	@Override
	public long stopTimeTask(long id) {
		TimedTaskInfoDO timedTaskInfoDO = new TimedTaskInfoDO();
		timedTaskInfoDO.setTaskStatus(TaskStatusEnum.RUNNING_STOPPED.getCode());
		timedTaskInfoDO.setId(id);
		timedTaskInfoDO.setUpdateTime(new Date());
		long number = timedTaskInfoManager.updateByPrimaryKeySelective(timedTaskInfoDO);
		log.info("stopTimeTask.result[" + "number==" + number + "]");
		return number;
	}

	@Override
	public int startTimeTask(long id) {
		TimedTaskInfoDO timedTaskInfoDO = new TimedTaskInfoDO();
		timedTaskInfoDO.setEffectiveTime(new Date());
		timedTaskInfoDO.setUpdateTime(new Date());
		timedTaskInfoDO.setId(id);
		return timedTaskInfoManager.updateByPrimaryKeySelective(timedTaskInfoDO);
	}

	/**
	 * 保存每次执行任务的详细信息
	 * 
	 * @param createDate
	 *            创建时间
	 * @param updateDate
	 *            更新时间
	 * @param taskId
	 *            任务编号
	 * @param useTime
	 *            用时
	 * @param result
	 *            结果
	 * @param remark
	 *            备注
	 * @return
	 */
	@Override
	public long saveTimedTaskExecuteInfo(Date createDate, Date updateDate, long taskId, int useTime, String result, String remark) {
		log.info("saveTimedTaskExecuteInfo param [" + "createDate=" + createDate + "," + "updateDate=" + updateDate + "," + "taskId=" + taskId + ","
				+ "useTime=" + useTime + "," + "result=" + result + "," + "remark=" + remark);
		TimedTaskExecuteInfoDO timedTaskExecuteInfoDO = new TimedTaskExecuteInfoDO();
		timedTaskExecuteInfoDO.setCreateTime(createDate);
		timedTaskExecuteInfoDO.setRemark(remark);
		timedTaskExecuteInfoDO.setResult(result);
		timedTaskExecuteInfoDO.setUpdateTime(updateDate);
		timedTaskExecuteInfoDO.setUseTime(useTime);
		timedTaskExecuteInfoDO.setTaskId(taskId);
		long id = timedTaskExecuteInfoManager.insert(timedTaskExecuteInfoDO);
		if (id > 0) {
			log.info("saveTimedTaskExecuteInfo.result[" + "success=" + "true" + "]");
		} else {
			log.info("saveTimedTaskExecuteInfo.result[" + "success=" + "fasle" + "]");
		}
		return id;
	}

	@Override
	public int updateTaskStatusRunning(Long id) {
		TimedTaskInfoDO timedTaskInfoDO = new TimedTaskInfoDO();
		timedTaskInfoDO.setTaskStatus(TaskStatusEnum.RUNNIING.getCode());
		timedTaskInfoDO.setUpdateTime(new Date());
		timedTaskInfoDO.setId(id);
		return timedTaskInfoManager.updateByPrimaryKeySelective(timedTaskInfoDO);

	}

	@Override
	public int updateTimedTaskExecuteInfo(Long id, int taskStatus, int executeTimes, long executeId) {
		TimedTaskInfoDO timedTaskInfoDO = new TimedTaskInfoDO();
		timedTaskInfoDO.setTaskStatus(taskStatus);
		timedTaskInfoDO.setLastExecuteId(executeId);
		timedTaskInfoDO.setExecuteTimes(executeTimes);
		timedTaskInfoDO.setUpdateTime(new Date());
		timedTaskInfoDO.setLastExecuteTime(new Date());
		TimedTaskInfoDOExample example = new TimedTaskInfoDOExample();
		example.createCriteria().andIdEqualTo(id).andTaskStatusEqualTo(TaskStatusEnum.RUNNIING.getCode());
		return timedTaskInfoDAO.updateByExampleSelective(timedTaskInfoDO, example);
	}

	@Override
	public List<TimedTaskInfoDO> queryWaitExecuteTaskInfo() {
		return extTimedTaskInfoDAO.queryWaitExecuteTaskInfo();
	}

	@Override
	public String getContentDesc(TimedTaskInfoDO timedTaskInfoDO) {
		StringBuffer buffer = new StringBuffer();
		Map<String, String> param = JSONObject.fromObject(timedTaskInfoDO.getTaskContent());
		if (TaskTypeEnums.TASKTYPE_CUSTOMIZED.getCode() == timedTaskInfoDO.getTaskType()) {
			String merchantNo = param.get("merchantNo");
			String merchantType = param.get("merchantType");
			String newValue = param.get("newValue");
			String operationName = param.get("operationName") == null ? "更新mcc" : param.get("operationName");
			buffer.append("商户类型：" + PosMerchantTypeEnums.getMerchantTypeByCode(merchantType).desc + "," + "商户号：" + merchantNo + "," + operationName
					+ ",更新为：" + newValue + "");
		}else if(TaskTypeEnums.TASKTYPE_SQL.getCode() == timedTaskInfoDO.getTaskType()){
//			String sqlType = param.get("sqlType");TaskSqlTypeEnums.getByCode(sqlType).getDesc()+":"+
		    buffer.append( param.get("sqlContext"));
		}

		return buffer.toString();
	}
}
