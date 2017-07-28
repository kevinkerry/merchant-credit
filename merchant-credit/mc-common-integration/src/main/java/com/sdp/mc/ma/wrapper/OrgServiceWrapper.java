package com.sdp.mc.ma.wrapper;

public interface OrgServiceWrapper {
	/**
	 * 子商户是否是集团商户 ,调用方：专业版
	 * 
	 * @param merchantNo
	 * **/
	public boolean belongs2Group(final String merchantNo);
}
