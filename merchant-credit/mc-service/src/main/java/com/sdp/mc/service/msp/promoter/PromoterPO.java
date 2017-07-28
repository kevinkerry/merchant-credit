package com.sdp.mc.service.msp.promoter;

import com.sdp.mc.dao.readonly.promoter.PromoterCond;


/**
 * @author zhangguoliang.burt
 *	拓展商PO
 */
public class PromoterPO extends PromoterCond {
	/**
	 * 判断代理商开通or关闭代理权限
	 */
	private String doFlag;

	public String getDoFlag() {
		return doFlag;
	}

	public void setDoFlag(String doFlag) {
		this.doFlag = doFlag;
	}

}
