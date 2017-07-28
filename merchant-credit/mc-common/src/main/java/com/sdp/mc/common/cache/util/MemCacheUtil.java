package com.sdp.mc.common.cache.util;
import java.net.InetSocketAddress;

import net.rubyeye.xmemcached.MemcachedClient;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;

import com.sdp.mc.common.util.SignHelper;
import com.shengpay.commom.config.GlobalConfig;
import com.snda.cache.client.zmemcached.ZmemcachedClientBuilder;
import com.snda.cache.client.zmemcached.ZmemcachedClientFactory;
import com.snda.cache.client.zmemcached.index.DirectSocketIndexFetcher;


public class MemCacheUtil {

	private static MemcachedClient memcachedClient;
	private static final Logger log = LoggerFactory.getLogger( MemCacheUtil.class );
	private static String MD5_KEY="123$@#!@sdasNFC";

	public static MemcachedClient getMemCacheClient(){
		if (memcachedClient == null){
			try{
				String inetSocketAddress = GlobalConfig.getString("zmemcached.client.inetSocketAddress");
				String inetSocketPort = GlobalConfig.getString("zmemcached.client.inetSocketPort");
				InetSocketAddress address = new InetSocketAddress(inetSocketAddress,Integer.valueOf(inetSocketPort).intValue());
				String indexKey = GlobalConfig.getString("zmemcached.client.indexKey");
				String fallbackAddresses = GlobalConfig.getString("zmemcached.client.fallbackAddresses");
				DirectSocketIndexFetcher indexFetcher = new DirectSocketIndexFetcher();
				indexFetcher.setIndexServer(address);

				ZmemcachedClientFactory clientFactory = new ZmemcachedClientFactory();
				clientFactory.setIndexFetcher(indexFetcher);
				clientFactory.setIndexKey(indexKey);
				clientFactory.setFallbackAddresses(fallbackAddresses);

				ZmemcachedClientBuilder clientBuilder = new ZmemcachedClientBuilder();
				clientBuilder.setZmemcachedClientFactory(clientFactory);

				memcachedClient = clientBuilder.build();

				return memcachedClient;
			}catch(Exception e){
				log.error("create memcachedClient error",e);
				return null;
			}
		}else{
			return memcachedClient;
		}

	}


	public static Object getValueFromMemCache(String key){
		String srcKey = key;
		try{
			key = SignHelper.sign(key,MD5_KEY);
			Object oo = getMemCacheClient().get(key);
			return oo;
		}catch(Exception e){
			log.error("MemCacheUtil======getValueFromMemCache error key="+srcKey);
			return null;
		}

	}

	public static boolean putValueIntoMemCache(String key,int time,Object value){
		String srcKey = key;
		try{
			key = SignHelper.sign(key,MD5_KEY);
			getMemCacheClient().set(key, time, value);
			return true;
		}catch(Exception e){
			log.error("MemCacheUtil======putValueIntoMemCache error key="+srcKey);
			return false;
		}


	}

	public static boolean clearAllCache(){
		try{
			getMemCacheClient().flushAll();
			return true;
		}catch(Exception e){
			log.error("MemCacheUtil======putValueIntoMemCache error", e);
			return false;
		}


	}

	public static boolean clearCacheByKey(String key){
		try{
			key = SignHelper.sign(key,MD5_KEY);
			getMemCacheClient().delete(key);
			return true;
		}catch(Exception e){
			log.error("MemCacheUtil======putValueIntoMemCache error", e);
			return false;
		}


	}

}
