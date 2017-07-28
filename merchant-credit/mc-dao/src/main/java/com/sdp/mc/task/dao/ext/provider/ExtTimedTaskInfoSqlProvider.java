package com.sdp.mc.task.dao.ext.provider;


/**
 * @author wushiyi
 * @date:2017年5月10日下午12:31:20
 * @version 1.0
 * @description:
 */

public class ExtTimedTaskInfoSqlProvider {

	/**
	 * 组装查询执行任务的sql
	 * 
	 * @return
	 */
	public String queryWaitExecuteTaskInfo() {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT * FROM mcredit.TB_TIMED_TASK_INFO ti ");
		sb.append(" where TI.TASK_STATUS in (1,3) ");
		sb.append(" and TI.EFFECTIVE_TIME <= sysdate ");
		sb.append(" and (TI.LAST_EXECUTE_TIME is null or TI.LAST_EXECUTE_TIME +(TI.RETRY_TIME_INTERVAL/(24*60*60))<=sysdate) ");
		return sb.toString();
	}

}
