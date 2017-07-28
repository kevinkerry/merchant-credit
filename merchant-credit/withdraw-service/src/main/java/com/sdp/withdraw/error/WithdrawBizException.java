package com.sdp.withdraw.error;


public class WithdrawBizException extends Exception {
	/**
	 *
	 */
	private static final long serialVersionUID = -1117204945723055150L;

	public WithdrawBizException(){
		super();
	}
	public WithdrawBizException(String msg){
		super(msg);
	}
}
