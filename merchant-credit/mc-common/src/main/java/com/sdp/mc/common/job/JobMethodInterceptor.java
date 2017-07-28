package com.sdp.mc.common.job;

import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;

import com.sdo.common.util.DateUtil;

/**
 * 调度方法拦截器
 * @author xuhongbiao.darren
 * @date 2013-8-22 下午04:55:30
 *
 */
public class JobMethodInterceptor implements MethodInterceptor {

	private static final Logger log = LoggerFactory.getLogger(JobMethodInterceptor.class);


	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		CronTriggerJob cronTriggerJob = AnnotationUtils.findAnnotation(invocation.getThis().getClass(), CronTriggerJob.class);
		SimpleTriggerJob simpleTriggerJob = AnnotationUtils.findAnnotation(invocation.getThis().getClass(), SimpleTriggerJob.class);
		String jobName = cronTriggerJob != null ? cronTriggerJob.jobName() : simpleTriggerJob.jobName();
		String dateFormat = "yyyy-MM-dd HH:mm:ss.SSS";

		log.info(jobName + " Job begin at: " + DateUtil.format(new Date(), dateFormat));
		log.info("executing method: " + invocation.getMethod().toString());

		Object result = invocation.proceed();

		log.info(jobName + " Job end at: " + DateUtil.format(new Date(), dateFormat));

		return result;
	}

}
