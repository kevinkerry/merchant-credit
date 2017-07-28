package com.sdp.withdraw.vo;

import java.io.Serializable;

public class WithdrawCheckResponse  extends BaseResponse implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 791013535067457880L;
	/**
	 * 是否可以发起快速结算
	 */
	private boolean ispass;
	public boolean isIspass() {
		return ispass;
	}
	public void setIspass(boolean ispass) {
		this.ispass = ispass;
	}


}
