package com.mc.service.api;

import java.util.Map;

import com.mc.service.api.exception.TimedTaskException;
/**
 * 定时任务API
 * @author liyantao01
 *
 */
public interface TimedTaskAPI {
	/**
	 * 创建sql定制化任务
	 * @param sqlType sql 的类型 1：insert 2：update 3：delete
	 * @param sqlContext sql的内容
	 * @param effectiveTime 任务生效时间 （开始执行时间）
	 * @param retryTimes 任务重试次数
	 * @param retryTimeInterval 任务重试间隔(s) 
	 * @param notifyPhone 任务失败通知的手机号 多个逗号（,）分隔
	 * @param notifyEmail 任务失败通知的邮箱多个逗号（,）分隔
	 * @return 任务ID
	 * @throws TimedTaskException
	 */
     public Long createSqlTimedTask(int sqlType,String sqlContext,String effectiveTime,int retryTimes,int retryTimeInterval,String notifyPhone,String notifyEmail) throws TimedTaskException;
     /**
      * 
      * @param customizedBeanName 定制化任务的Bean名称，spring容器中可以直接获取的名称
      * @param executeParam  定制化任务需要的参数
      * @param effectiveTime 任务生效时间 （开始执行时间）
	  * @param retryTimes 任务重试次数
	  * @param retryTimeInterval 任务重试间隔(s) 
	  * @param notifyPhone 任务失败通知的手机号 多个逗号（,）分隔
	  * @param notifyEmail 任务失败通知的邮箱多个逗号（,）分隔
      * @return 任务ID
      * @throws TimedTaskException
      */
     public Long createCustomizedTimedTask(String customizedBeanName,Map<String,String> executeParam,String effectiveTime,int retryTimes,int retryTimeInterval,String notifyPhone,String notifyEmail) throws TimedTaskException;
}
