package com.shengpay.debit.common.risk.model;

import java.io.Serializable;

import com.sdp.mc.common.vo.ErrorMessageVO;

public class CreditRiskErrorMessageVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMsg;

	public CreditRiskErrorMessageVO(){
	}
	
	public CreditRiskErrorMessageVO(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
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

	public ErrorMessageVO toErrorMessageVO() {
		boolean flag = "-1".equals(this.errorCode);
		return new ErrorMessageVO(flag, this.errorCode, this.errorMsg);
	}
}
