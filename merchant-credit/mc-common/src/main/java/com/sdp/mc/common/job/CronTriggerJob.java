package com.sdp.mc.common.job;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * cronExpression任务调度注解
 * @author xuhongbiao.darren
 * @date 2013-8-22 下午07:23:37
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface CronTriggerJob {

	String cronExpression();
	
	String jobName();
	
	boolean concurrent() default false;
	
	String targetMethod() default "execute";
	
}
