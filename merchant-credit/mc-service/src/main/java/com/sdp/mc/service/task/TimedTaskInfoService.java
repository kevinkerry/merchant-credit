package com.sdp.mc.service.task;

import java.util.Date;
import java.util.List;

import com.sdp.mc.task.dao.TimedTaskExecuteInfoDO;
import com.sdp.mc.task.dao.TimedTaskInfoDO;
import com.sdp.mc.task.dao.TimedTaskInfoDOExample;

/**
 * @author: wushiyu
 * @date:2017年4月27日 下午2:20:27
 * @version 1.0
 * @description:定时任务服务接口
 */
public interface TimedTaskInfoService {
	/**
	 * 查询定时任务列表
	 * 
	 * @return
	 */
	public List<TimedTaskInfoDO> quaryTimeTaskInfo(TimedTaskInfoDOExample query);

	/**
	 * 查询一条定时任务详细信息
	 * 
	 * @param id
	 * @return
	 */
	public TimedTaskInfoDO queryTimeTaskDetailInfoByTaskId(long id);

	/**
	 * 查看某一个任务执行的详细信息
	 * 
	 * @param id
	 * @return
	 */
	public List<TimedTaskExecuteInfoDO> queryTimeTaskExecuteInfoByTaskId(long id);

	/**
	 * 手动结束定时任务执行
	 */
	public long stopTimeTask(long id);

	/**
	 * 手动开启定时任务
	 */
	public int startTimeTask(long id);

	/**
	 *
	 * @descrption:更新定制化任务
	 * @parameter
	 * @return
	 */
	public int updateTimedTaskInfo(long id, String effiectTime, String retryTimes, String notifyEmail, String notifyPhone, String retryTimeInterval);

	/**
	 *
	 * @descrption:添加定制化任务
	 * @parameter
	 * @return
	 */
	public int addTimeTaskInfo(String sqlType, String taskContext, String effiectTime, String retryTimes, String notifyEmail, String notifyPhone,
			String retryTimeInterval);

	/**
	 * 保存任务执行信息
	 * 
	 * @param createDate
	 * @param updateDate
	 * @param taskId
	 * @param useTime
	 * @param result
	 * @param remark
	 * @return
	 */
	long saveTimedTaskExecuteInfo(Date createDate, Date updateDate, long taskId, int useTime, String result, String remark);

	/**
	 * 更行任务的状态为执行中
	 * 
	 * @param id
	 * @return
	 */
	public int updateTaskStatusRunning(Long id);

	/**
	 * 更行任务执行的信息
	 * 
	 * @param id
	 * @param taskStatus
	 * @param executeTimes
	 * @param executeId
	 * @return
	 */
	public int updateTimedTaskExecuteInfo(Long id, int taskStatus, int executeTimes, long executeId);

	/**
	 * 查询待执行的任务
	 * 
	 * @return
	 */
	public List<TimedTaskInfoDO> queryWaitExecuteTaskInfo();

	/**
	 * 获取任务的描述信息
	 * 
	 * @param timedTaskInfoDO
	 * @return
	 */
	public String getContentDesc(TimedTaskInfoDO timedTaskInfoDO);

}
