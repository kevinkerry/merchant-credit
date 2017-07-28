package com.sdp.mc.common.hessian;


public class HessianService {
	/**
	 * hessian服务对应的接口.
	 */
	private Class<?> serviceInterface;

	/**
	 * hessian服务对象.
	 */
	private Object serviceBean;

	/**
	 * 缺省构造函数.
	 * @param serviceInterface
	 * @param serviceBean
	 */
	public HessianService(Class<?> serviceInterface, Object serviceBean) {
		this.serviceInterface = serviceInterface;
		this.serviceBean = serviceBean;
	}

	/**
	 * @return the serviceInterface
	 */
	public Class<?> getServiceInterface() {
		return serviceInterface;
	}

	/**
	 * @return the serviceBean
	 */
	public Object getServiceBean() {
		return serviceBean;
	}
}
