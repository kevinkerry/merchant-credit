package com.sdp.mc.common.exception;

public class FastSettleLimitException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long fcmId;
	public FastSettleLimitException(String message) {
		super(message);
	}
	public FastSettleLimitException(String message,long fcmId) {
		super(message);
		this.fcmId=fcmId;
	}
	public long getFcmId() {
		return fcmId;
	}
	public void setFcmId(long fcmId) {
		this.fcmId = fcmId;
	}
	
}
