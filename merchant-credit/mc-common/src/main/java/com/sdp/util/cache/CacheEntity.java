package com.sdp.util.cache;

/**
 * 缓存
 */
import java.io.Serializable;

public class CacheEntity<K> implements Serializable{
	private static final long serialVersionUID = -3971709196436977492L;
	private final int DEFUALT_VALIDITY_TIME = 20;//默认过期时间 20秒

	private K cacheContext;
	private int validityTime;//有效期时长，单位：秒
	private long timeoutStamp;//过期时间戳

	private CacheEntity(){
		this.timeoutStamp = System.currentTimeMillis() + DEFUALT_VALIDITY_TIME * 1000;
		this.validityTime = DEFUALT_VALIDITY_TIME;
	}

	public CacheEntity(K cacheContext){
		this();
		this.cacheContext = cacheContext;
	}

	public CacheEntity(String cacheKey, K cacheContext, long timeoutStamp){
		this(cacheContext);
		this.timeoutStamp = timeoutStamp;
	}

	public CacheEntity(String cacheKey, K cacheContext, int validityTime){
		this(cacheContext);
		this.validityTime = validityTime;
		this.timeoutStamp = System.currentTimeMillis() + validityTime * 1000;
	}

	public K getCacheContext() {
		return (K)cacheContext;
	}
	public void setCacheContext(K cacheContext) {
		this.cacheContext = cacheContext;
	}
	public long getTimeoutStamp() {
		return timeoutStamp;
	}
	public void setTimeoutStamp(long timeoutStamp) {
		this.timeoutStamp = timeoutStamp;
	}
	public int getValidityTime() {
		return validityTime;
	}
	public void setValidityTime(int validityTime) {
		this.validityTime = validityTime;
	}
}