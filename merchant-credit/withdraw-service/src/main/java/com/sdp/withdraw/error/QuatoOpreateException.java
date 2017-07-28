package com.sdp.withdraw.error;

import com.sdp.withdraw.dao.ext.QuatoOpreationMsgVo;

public class QuatoOpreateException extends RuntimeException{

	/**
	 *
	 */
	private static final long serialVersionUID = -5888771300447512349L;

	private String errorCode;
	private String errorMsg;

	private QuatoOpreationMsgVo quatoOpreationMsgVo ;

	public QuatoOpreateException(){
		super();
	}
	public QuatoOpreateException(String errorMsg){
		super(errorMsg);
	}
	public QuatoOpreateException(String errorCode,String errorMsg,QuatoOpreationMsgVo vo){
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.quatoOpreationMsgVo = vo;
	}


	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public QuatoOpreationMsgVo getQuatoOpreationMsgVo() {
		return quatoOpreationMsgVo;
	}
	public void setQuatoOpreationMsgVo(QuatoOpreationMsgVo quatoOpreationMsgVo) {
		this.quatoOpreationMsgVo = quatoOpreationMsgVo;
	}
}
