package com.sdp.mc.common.job;

import java.text.ParseException;
import java.util.TimeZone;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.quartz.CronExpression;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.PlaceholderConfigurerSupport;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.scheduling.quartz.CronTriggerBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerBean;
import org.springframework.util.StringUtils;
import org.springframework.util.StringValueResolver;

/**
 * 注解方式配置Quartz调度任务
 * 
 * @author xuhongbiao.darren
 * @date 2013-8-22 下午05:30:35
 * 
 */
public class TriggerJobPostProcessor extends SchedulerFactoryBean implements BeanPostProcessor, BeanFactoryAware, EmbeddedValueResolverAware {

	private static final Logger log = LoggerFactory.getLogger(TriggerJobPostProcessor.class);

	private BeanFactory beanFactory;

	private String[] interceptorNames;
	
	private StringValueResolver stringValueResolver;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (this.canProcess(bean)) {
			this.registerTriggerJob(bean);
		}
		return bean;
	}

	/**
	 * 是否可处理
	 * 
	 * @param bean
	 * @return
	 */
	private boolean canProcess(Object bean) {
		CronTriggerJob cronTriggerJob = AnnotationUtils.findAnnotation(bean.getClass(), CronTriggerJob.class);
		SimpleTriggerJob simpleTriggerJob = AnnotationUtils.findAnnotation(bean.getClass(), SimpleTriggerJob.class);
		return (cronTriggerJob != null || simpleTriggerJob != null);
	}

	/**
	 * 注册调度任务
	 * 
	 * @param bean
	 */
	private void registerTriggerJob(Object bean) {

		CronTriggerJob cronTriggerJob = AnnotationUtils.findAnnotation(bean.getClass(), CronTriggerJob.class);
		SimpleTriggerJob simpleTriggerJob = AnnotationUtils.findAnnotation(bean.getClass(), SimpleTriggerJob.class);
		try {

			if (cronTriggerJob != null && simpleTriggerJob != null) {
				throw new BeanInitializationException("cronTriggerJob与simpleTriggerJob不能同时使用");
			}

			JobDetail jobDetail = null;
			Trigger trigger = null;
			if (cronTriggerJob != null) {
				
				jobDetail = this.createJobDetail(bean, cronTriggerJob.targetMethod(), cronTriggerJob.concurrent(), cronTriggerJob.jobName());
				
				CronTriggerBean cronTriggerBean = new CronTriggerBean();
				cronTriggerBean.setCronExpression(this.getCronExpression(cronTriggerJob.cronExpression()));
				cronTriggerBean.setJobDetail(jobDetail);
				cronTriggerBean.setName(cronTriggerJob.jobName());
				cronTriggerBean.afterPropertiesSet();
				trigger = cronTriggerBean;

			} else if (simpleTriggerJob != null) {
				
				jobDetail = this.createJobDetail(bean, simpleTriggerJob.targetMethod(), simpleTriggerJob.concurrent(), simpleTriggerJob.jobName());
				
				long startDelay = this.getLongValue(simpleTriggerJob.startDelay());
				long repeatInterval = this.getLongValue(simpleTriggerJob.repeatInterval());
				
				SimpleTriggerBean simpleTriggerBean = new SimpleTriggerBean();
				simpleTriggerBean.setStartDelay(startDelay);
				simpleTriggerBean.setRepeatInterval(repeatInterval);
				simpleTriggerBean.setRepeatCount(simpleTriggerJob.repeatCount());
				simpleTriggerBean.setJobDetail(jobDetail);
				simpleTriggerBean.setName(simpleTriggerJob.jobName());
				simpleTriggerBean.afterPropertiesSet();
				trigger = simpleTriggerBean;
			}

			this.getScheduler().scheduleJob(jobDetail, trigger);

		} catch (Exception e) {
			log.error(e.getMessage() + ",beanClass=" + bean.getClass().getName(), e);
			throw new BeanInitializationException(e.getMessage(), e);
		}

	}

	
	private JobDetail createJobDetail(Object targetObject, String targetMethod, boolean isConcurrent, String jobName) throws Exception{
		if (StringUtils.isEmpty(jobName)) {
			throw new BeanInitializationException("jobName不能为空");
		}
		
		MethodInvokingJobDetailFactoryBean jobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
		jobDetailFactoryBean.setTargetObject(this.getProxyBean(targetObject));
		jobDetailFactoryBean.setTargetMethod(targetMethod);
		jobDetailFactoryBean.setConcurrent(isConcurrent);
		jobDetailFactoryBean.setName(jobName);
		jobDetailFactoryBean.afterPropertiesSet();
		return jobDetailFactoryBean.getObject();
	}

	/**
	 * 如果是placeholder变量取配置文件参数
	 * @param value
	 * @return
	 */
	private long getLongValue(String value){
		if(StringUtils.isEmpty(value)){
			throw new BeanInitializationException("参数不能为空");
		}
		
		long longVal = 0L;
		try {
			
			value = value.trim();
			if(value.startsWith(PlaceholderConfigurerSupport.DEFAULT_PLACEHOLDER_PREFIX) && value.endsWith(PlaceholderConfigurerSupport.DEFAULT_PLACEHOLDER_SUFFIX)){
				// 取配置文件参数
				longVal = Long.valueOf(stringValueResolver.resolveStringValue(value));
			}else{
				longVal = Long.parseLong(value);
			}
			
		} catch (Exception e) {
			throw new BeanInitializationException(e.getMessage(), e);
		}
		
		return longVal;
	}
	
	/**
	 * 获取CronExpression对象
	 * 
	 * @param cronExpression
	 * @return
	 */
	private CronExpression getCronExpression(String cronExpression) {
		CronExpression cronEx = null;
		try {
			if (StringUtils.isEmpty(cronExpression)) {
				throw new BeanInitializationException("cronExpression不能为空");
			}

			cronExpression = cronExpression.trim();
			if (cronExpression.startsWith(PlaceholderConfigurerSupport.DEFAULT_PLACEHOLDER_PREFIX) && cronExpression.endsWith(PlaceholderConfigurerSupport.DEFAULT_PLACEHOLDER_SUFFIX)) {
				// 取配置文件参数
				cronExpression = stringValueResolver.resolveStringValue(cronExpression);
				if (StringUtils.isEmpty(cronExpression)) {
					throw new BeanInitializationException("cronExpression不能为空");
				}
			}

			cronEx = new CronExpression(cronExpression);
			cronEx.setTimeZone(TimeZone.getDefault());
		} catch (ParseException e) {
			throw new BeanInitializationException("cronExpression解析错误[cronExpression=" + cronExpression + "]");
		}
		return cronEx;
	}

	private Object getProxyBean(Object target) {
		if(this.getInterceptorNames() == null || this.getInterceptorNames().length == 0){
			return target;
		}
		ProxyFactoryBean proxy = new ProxyFactoryBean();
		proxy.setBeanFactory(this.beanFactory);
		proxy.setTarget(target);
		proxy.setInterceptorNames(this.getInterceptorNames());
		return proxy.getObject();
	}

	@Override
	public void setBeanFactory(BeanFactory beanfactory) throws BeansException {
		this.beanFactory = beanfactory;

	}

	public String[] getInterceptorNames() {
		return interceptorNames;
	}

	public void setInterceptorNames(String[] interceptorNames) {
		this.interceptorNames = interceptorNames;
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver stringvalueresolver) {
		this.stringValueResolver = stringvalueresolver;
	}

}
