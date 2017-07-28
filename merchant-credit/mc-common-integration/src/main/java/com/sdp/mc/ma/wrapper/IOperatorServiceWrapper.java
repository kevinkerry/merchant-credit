package com.sdp.mc.ma.wrapper;

public interface IOperatorServiceWrapper {
	/**
	 * 查询操作员拥有数据权限范围的商户列表
     * 调用方：POS（java）
	 * 
	 * @param operatorId
	 *            操作员id
	 * @return String[]
	 * **/
	public String[] queryMerchantNoByOperatorId(final String operatorId);
}
