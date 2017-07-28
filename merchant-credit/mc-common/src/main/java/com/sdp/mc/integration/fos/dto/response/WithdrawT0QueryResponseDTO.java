package com.sdp.mc.integration.fos.dto.response;



/**
 * FOS订单查询response
 * @author wangmindong
 *
 */
public class WithdrawT0QueryResponseDTO {

	/**
     * 返回码
     */
    private String returnCode;
    /**
     * 返回描述
     */
    private String returnMsg;
    /**
     * 出款结果
     */
    private WithdrawPaymentResult paymentResult = new WithdrawPaymentResult();

    public WithdrawPaymentResult getPaymentResult() {
		return paymentResult;
	}
	public void setPaymentResult(WithdrawPaymentResult paymentResult) {
		this.paymentResult = paymentResult;
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
}
