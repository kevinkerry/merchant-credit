package com.sdp.mc.common.hessian;

public interface RemotingCallType {
	/**
	 * 以提交http form的方式远程调用服务.
	 */
	public static int RCT_HTTP_POST = 0;

	/**
	 * 以hessian通讯方式远程调用服务.
	 */
	public static int RCT_HTTP_HESSIAN = 1;
}
