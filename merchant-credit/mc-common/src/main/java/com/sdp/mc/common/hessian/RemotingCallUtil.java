package com.sdp.mc.common.hessian;

import java.net.MalformedURLException;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;

import com.caucho.hessian.client.HessianProxyFactory;

public class RemotingCallUtil {
	private static Logger log = LoggerFactory.getLogger(RemotingCallUtil.class);

	/**
	 * 从指定的连接地址创建hessian调用的客户端.
	 * 
	 * @param <V>
	 * @param connectionUrl
	 * @param serviceInterface
	 * @return
	 */
	protected static <V> V getHessianService(String connectionUrl, Class<V> serviceInterface) {
		return getHessianService(connectionUrl, serviceInterface, true);
	}

	/**
	 * 从指定的连接地址创建hessian调用的客户端.
	 * 
	 * @param <V>
	 * @param connectionUrl
	 * @param serviceInterface
	 * @return
	 */
	public static <V> V getHessianServiceUrlWithoutCanonicalName(String connectionUrl, Class<V> serviceInterface) {
		return getHessianService(connectionUrl, serviceInterface, false);
	}

	/**
	 * 从指定的连接地址创建hessian调用的客户端.
	 * 
	 * @param <V>
	 * @param connectionUrl
	 * @param serviceInterface
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected static <V> V getHessianService(String connectionUrl, Class<V> serviceInterface, boolean urlAddCanonicalName) {
		String url = null;
		if (urlAddCanonicalName)
			url = connectionUrl + serviceInterface.getCanonicalName();
		else url = connectionUrl;
		HessianProxyFactory factory = new HessianProxyFactory();

		/*
		 * Hessian默认的情况下使用的分块的方式发送数据，这在有反向代理的情况下 服务器端会返回Http
		 * 411错误（缺少Content-length），因此需要把
		 * ChunkedPost属性设置为False（不采用分块的方式发送，这样就会有Content-length这个参数了）。
		 */
		factory.setChunkedPost(false);

		/*
		 * Hessian默认情况下不支持接口方法重载，需设置
		 */
		factory.setOverloadEnabled(true);

		try {
			Object stub = factory.create(serviceInterface, url, RemotingCallUtil.class.getClassLoader());
			return (V) stub;
		} catch (MalformedURLException e) {
			log.error("Remote service call error", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据模块名获取该模块下的远程调用hessian服务. 这个模块名是在remoting.properties文件中定义的key
	 * 例如：ms-app=192.168.121.128，模块名为ms-app
	 * 
	 * @param <V>
	 * @param module
	 * @param serviceInterface
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <V extends Object> V getHessianServiceByModule(RemotingModuleEnum module, Class<?> serviceInterface) {
		return (V) getHessianService(module.getUniqueUrl(), serviceInterface);
	}

	/**
	 * 根据模块名获取该模块下的远程调用hessian服务. 这个模块名是在remoting.properties文件中定义的key
	 * 例如：ms-app=192.168.121.128，模块名为ms-app
	 * 
	 * @param <V>
	 * @param module
	 * @param serviceInterface
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <V extends Object> V getHessianServiceByModuleWithoutCanonicalName(RemotingModuleEnum module, Class<?> serviceInterface) {
		return (V) getHessianServiceUrlWithoutCanonicalName(module.getUniqueUrl(), serviceInterface);
	}
}
