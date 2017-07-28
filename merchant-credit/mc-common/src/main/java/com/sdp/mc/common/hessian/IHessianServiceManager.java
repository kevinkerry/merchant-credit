package com.sdp.mc.common.hessian;

import java.util.List;

import org.springframework.remoting.caucho.HessianServiceExporter;


public interface IHessianServiceManager {
	/**
	 * 注册一个服务.这个服务必须有一个interface
	 *
	 * @param obj
	 */
	void registerService(Object obj);

	/**
	 * 把多个服务注册发布为hessian的远程调用服务.
	 *
	 * @param objects
	 */
	void registerServices(List<Object> objects);

	/**
	 * 取消一个HessianService服务.
	 * @param service
	 */
	void unregisterService(HessianService service);

	/**
	 * 根据HessianService服务的id获取HessianServiceExporter对象.
	 * @param serviceId
	 * @return
	 */
	HessianServiceExporter findService(String serviceId);
}
