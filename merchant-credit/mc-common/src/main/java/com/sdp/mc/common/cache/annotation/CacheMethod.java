package com.sdp.mc.common.cache.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 标识需要使用缓存的方法
 * @author lvguanwei
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CacheMethod {
	/**
	 * 用于存Cache中的key
	 * @return
	 */
    public String cacheKey() default "";

    /**
     * 可选值
	 * 用于存Cache中   停留的时间   单位秒
	 * 默认15分钟
	 * @return
	 */
    public int resTime() default 900;

    /**
     * 生成的cacheKey是否包含参数值
     * @return
     */
    public boolean keyIncludeParameterValue() default false;

}

