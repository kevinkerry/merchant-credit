package com.sdp.mc.integration.fos.dto.response;

/**
 * FOS出款响应
 * @author wangmindong
 *
 */
public class WithdrawT0ResponseDTO {

	private String returnCode;
    private String returnMsg;
    /**
     * json 格式
     */
    private String extention;

    public WithdrawT0ResponseDTO(String returnCode,String returnMsg,String extention){
    	this.returnCode = returnCode;
    	this.returnMsg = returnMsg;
    	this.extention = extention;
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
	public String getExtention() {
		return extention;
	}
	public void setExtention(String extention) {
		this.extention = extention;
	}
}
