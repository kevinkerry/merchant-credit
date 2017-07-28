package com.sdp.mc.common.job;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * SimpleTrigger任务调度注解
 * @author xuhongbiao.darren
 * @date 2013-8-27 下午03:55:29
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface SimpleTriggerJob {
	
	/**
	 * 启动延迟(毫秒)
	 * @return
	 */
	String startDelay();
	
	/**
	 * 执行间隔时间(毫秒)
	 * @return
	 */
	String repeatInterval();
	
	/**
	 * 重复执行次数，默认无限次
	 * @return
	 */
	int repeatCount() default -1;

	String jobName();
	
	boolean concurrent() default false;
	
	String targetMethod() default "execute";
	
}
