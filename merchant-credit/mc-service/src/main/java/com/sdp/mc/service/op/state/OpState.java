package com.sdp.mc.service.op.state;


public interface OpState {

	public int handler(OpContext context,String operatorId);

	/**
	 * handler 操作成功
	 */
	public final static int success = 1;

	/**
	 * handler 操作失败
	 */
	public final static int failure = -1;
	/**
	 * handler 操作处理中....
	 */
	public final static int handling = 0;

}
