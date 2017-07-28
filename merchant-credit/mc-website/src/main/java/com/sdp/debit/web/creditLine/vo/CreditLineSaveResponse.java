package com.sdp.debit.web.creditLine.vo;

/**
 * 额度申请响应
 * @author heyi.alex
 *
 */
public class CreditLineSaveResponse {

	private String msg = "";

	private String code="";

	private String itemCode = "";

	private String itemDesc = "";

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}



}
