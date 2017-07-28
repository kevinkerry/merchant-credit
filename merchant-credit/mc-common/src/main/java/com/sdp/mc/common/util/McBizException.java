package com.sdp.mc.common.util;

public class McBizException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String message;
	public McBizException() {
		super();
	}


	public McBizException(String message) {
        super(message);
        this.message = message;
    }
	public McBizException(String code,String msg) {
		super();
		this.code=code;
		this.message=msg;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

}
