package com.sdp.mc.integration.fos.dto.response;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

/**
 * FOS状态回调参数
 * @author wangmindong
 *
 */
public class WithdrawBackOrderStatusDTO implements Serializable{


	private static final long serialVersionUID = -8996567114240156080L;
	private String batchNo ;
    private String payerMemberId ;
    private String totalOrderNum ;
    private String storeKey ;
    private String returnCode ;
    private String returnMsg ;
    private String callbackAddress ;
    private Map<String, Object> extension ;

    private List<OrderResults> orderResults;

    public WithdrawBackOrderStatusDTO(String batchNo, String payerMemberId,
			String totalOrderNum, String storeKey, String returnCode,
			String returnMsg, String callbackAddress,
			Map<String, Object> extension) {
		this.batchNo = batchNo;
		this.payerMemberId = payerMemberId;
		this.totalOrderNum = totalOrderNum;
		this.storeKey = storeKey;
		this.returnCode = returnCode;
		this.returnMsg = returnMsg;
		this.callbackAddress = callbackAddress;
		this.extension = extension;
	}

	public WithdrawBackOrderStatusDTO() {
		super();
	}

	public static WithdrawBackOrderStatusDTO json2Bean(String json) {
		return (WithdrawBackOrderStatusDTO) JSONObject.toBean(JSONObject.fromObject(json), WithdrawBackOrderStatusDTO.class);
	}

	public static String bean2Json(WithdrawBackOrderStatusDTO bean) {
		return JSONObject.fromObject(bean).toString();
	}

	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getPayerMemberId() {
		return payerMemberId;
	}
	public void setPayerMemberId(String payerMemberId) {
		this.payerMemberId = payerMemberId;
	}
	public String getTotalOrderNum() {
		return totalOrderNum;
	}
	public void setTotalOrderNum(String totalOrderNum) {
		this.totalOrderNum = totalOrderNum;
	}

	public List<OrderResults> getOrderResults() {
		return orderResults;
	}

	public void setOrderResults(List<OrderResults> orderResults) {
		this.orderResults = orderResults;
	}

	public String getStoreKey() {
		return storeKey;
	}
	public void setStoreKey(String storeKey) {
		this.storeKey = storeKey;
	}
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getReturnMsg() {
		return returnMsg;
	}
	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	public String getCallbackAddress() {
		return callbackAddress;
	}
	public void setCallbackAddress(String callbackAddress) {
		this.callbackAddress = callbackAddress;
	}
	public Map<String, Object> getExtension() {
		return extension;
	}
	public void setExtension(Map<String, Object> extension) {
		this.extension = extension;
	}

}
