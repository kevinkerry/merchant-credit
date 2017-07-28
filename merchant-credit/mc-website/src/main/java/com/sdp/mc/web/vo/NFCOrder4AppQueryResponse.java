package com.sdp.mc.web.vo;

public class NFCOrder4AppQueryResponse extends BaseResponse {

	private String orderAmount;
	private String orderStatus;
	private String orderNo;
	private String transTime;

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getTransTime() {
		return transTime;
	}

	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}

	public static NFCOrder4AppQueryResponse buildFail(String msg) {
		NFCOrder4AppQueryResponse response = new NFCOrder4AppQueryResponse();
		response.setSuccess(false);
		response.setErrorCode("-1");
		response.setErrorMsg(msg);
		return response;
	}

	public static NFCOrder4AppQueryResponse buildSuccess() {
		NFCOrder4AppQueryResponse response = new NFCOrder4AppQueryResponse();
		response.setSuccess(true);
		response.setErrorCode("0");
		response.setErrorMsg("");
		return response;
	}

	@Override
	public String toString() {
		return "NFCOrder4AppQueryResponse [orderAmount=" + orderAmount + ", orderStatus=" + orderStatus + ", orderNo=" + orderNo + "]";
	}

}
