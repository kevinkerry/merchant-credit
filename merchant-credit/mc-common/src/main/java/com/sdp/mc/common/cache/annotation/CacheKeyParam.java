package com.sdp.mc.common.cache.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 当缓存的key里面需要包含参数值时，用来标识参数的名称
 * @author lvguanwei
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface CacheKeyParam {
    public String value();

}

