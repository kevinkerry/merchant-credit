package com.sdp.mc.msp.api.vo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 可用订单号
 * @author liyantao01
 *
 */
public class ValidOrderResult implements Serializable {

	private static final long serialVersionUID = -8837630952608175191L;
	/**
	 * 可用订单号结果信息
	 */
	private List<MCValidOrders> results=new ArrayList<MCValidOrders>();

	/**
	 * 访问成功标示
	 */
	private String code;

	public List<MCValidOrders> getResults() {
		return results;
	}

	public void setResults(List<MCValidOrders> results) {
		this.results = results;
	}

	/**
	 * 异常信息
	 */
	private String errorMsg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}





}