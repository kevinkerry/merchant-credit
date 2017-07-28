package com.sdp.mc.common.cache.advice;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;

import com.sdo.common.lang.StringUtil;
import com.sdp.mc.common.cache.annotation.CacheKeyParam;
import com.sdp.mc.common.cache.annotation.CacheMethod;
import com.sdp.mc.common.cache.util.MemCacheUtil;

@Component
@Aspect
public class MemcachedAdvice{

	private static final Logger log = LoggerFactory.getLogger(MemcachedAdvice.class);

	/**
	 * 包含@CacheService的PointCut
	 */
	@Pointcut("@within(com.sdp.mc.common.cache.annotation.CacheService)")
	public void checkService(){

	}

	/**
	 * 包含@CacheMethod的PointCut
	 */
	@Pointcut("@annotation(com.sdp.mc.common.cache.annotation.CacheMethod)")
	public void checkMethod(){

	}

	/**
	 * 包含@CacheService和@CacheMethod的PointCut
	 */
	@Pointcut(value="checkService() && checkMethod()")
	public void dealMemcache(){}


	/**
	 * 对包含@CacheService和@CacheMethod的PointCut进行Around处理
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("dealMemcache()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{

		MethodSignature joinPointObject = (MethodSignature) joinPoint.getSignature();
        Method method = joinPointObject.getMethod();
        //取得真正的method
        Method targetMethod = joinPoint.getTarget().getClass()
    	.getMethod(method.getName(), method.getParameterTypes());
        CacheMethod methodAnnotation = targetMethod.getAnnotation(CacheMethod.class);
        int cacheTime = methodAnnotation.resTime();

        String cacheKey = methodAnnotation.cacheKey();
        if (StringUtil.isEmpty(cacheKey)){
        	cacheKey=joinPoint.getTarget().getClass().getName()+"."+targetMethod.getName();
        }

        //用于生成cacheKey
        StringBuilder sb = new StringBuilder();
        sb.append(cacheKey);
        if (methodAnnotation.keyIncludeParameterValue()){
        	//如果cacheKey包含参数值信息
        	Object[] args = joinPoint.getArgs();
        	for (int i = 0; i < args.length; i++) {
        		MethodParameter methodParameter = new MethodParameter(targetMethod,i);
        		//取得参数的注解
        		Annotation[] aa = methodParameter.getParameterAnnotations();
        		for(Annotation annotation : aa){
        			//判断参数的注解是否是CacheKeyParam，如果是CacheKeyParam则对应的cacheKey需要包含
        			if (annotation.annotationType().equals(CacheKeyParam.class)){
        				CacheKeyParam cacheKeyParam = (CacheKeyParam)annotation;
        				sb.append(";")
        				  .append(cacheKeyParam.value())
        				  .append("=")
        				  .append(args[i].toString());
        			}
        		}
        	}
        }

        cacheKey = sb.toString();
        try{
        	Object cacheObject  = MemCacheUtil.getValueFromMemCache(cacheKey);
        	if (cacheObject == null){
        		//查询结果不在缓存中，调用原始方法进行操作
        		Object returnObject = joinPoint.proceed();
        		MemCacheUtil.putValueIntoMemCache(cacheKey, cacheTime, returnObject);
        		return returnObject;
        	}else{
        		return cacheObject;
        	}
        }catch(Exception e){
        	log.error("memcache aop error method="+method.getName()+" cacheKey="+cacheKey+" errorInfo="+e.getMessage(),e);
        }
		return null;
	}








}
