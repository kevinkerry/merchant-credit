package com.sdp.withdraw.entity;

import com.sdp.withdraw.dao.WalletWithdrawReqDO;

public class WalletWithdrawReqPO extends WalletWithdrawReqDO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String startApplyTime;
	
	private String endApplyTime;

	public String getStartApplyTime() {
		return startApplyTime;
	}

	public void setStartApplyTime(String startApplyTime) {
		this.startApplyTime = startApplyTime;
	}

	public String getEndApplyTime() {
		return endApplyTime;
	}

	public void setEndApplyTime(String endApplyTime) {
		this.endApplyTime = endApplyTime;
	}
	
	

}
