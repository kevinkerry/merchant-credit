package com.sdp.mc.common.cache.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 *  标识需要使用缓存的类
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE )
public @interface CacheService {
}
