package com.sdp.mc.integration.receipt.dto.request;

public class FundOutReceiptSubmitRequestDTO {
	 /**
     * 凭证库分配的APP代码, 每个请求凭证库的应用必须传appCode来标识来源
     * 必传
     */
    private String appCode;
    /**
     * 请直接填写productCode
     * 必传
     */
    private String bizCode;
    /**
     * 业务系统订单号
     * 必传
     */
    private String appOrderNo;
    /**
     * 业务系统里的订单号字段
     * 必传
     */
    private String appOrderNoRef;
    /**
     * 收款方盛付通会员ID
     */
    private String payeeMemberId;
    /**
     * 收款方盛付通钱包帐号
     */
    private String payeeAccountNo;
    /**
     * 银行账户名称
     * 必传
     */
    private String bankAccountName;
    /**
     * 银行账户
     * 必传
     */
    private String bankAccountNo;
    /**
     * 出款金额(厘)
     * 必传
     */
    private Long payableAmount;
    /**
     * JSON格式的扩展信息
     */
    private String extendInfo;
    
    public FundOutReceiptSubmitRequestDTO(){
    	
    }
    
	public FundOutReceiptSubmitRequestDTO(String appCode, String appOrderNoRef) {
		this.appCode = appCode;
		this.appOrderNoRef = appOrderNoRef;
	}
    
	public String getAppCode() {
		return appCode;
	}
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	public String getBizCode() {
		return bizCode;
	}
	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}
	public String getAppOrderNo() {
		return appOrderNo;
	}
	public void setAppOrderNo(String appOrderNo) {
		this.appOrderNo = appOrderNo;
	}
	public String getAppOrderNoRef() {
		return appOrderNoRef;
	}
	public void setAppOrderNoRef(String appOrderNoRef) {
		this.appOrderNoRef = appOrderNoRef;
	}
	public String getPayeeMemberId() {
		return payeeMemberId;
	}
	public void setPayeeMemberId(String payeeMemberId) {
		this.payeeMemberId = payeeMemberId;
	}
	public String getPayeeAccountNo() {
		return payeeAccountNo;
	}
	public void setPayeeAccountNo(String payeeAccountNo) {
		this.payeeAccountNo = payeeAccountNo;
	}
	public String getBankAccountName() {
		return bankAccountName;
	}
	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}
	public String getBankAccountNo() {
		return bankAccountNo;
	}
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}
	public Long getPayableAmount() {
		return payableAmount;
	}
	public void setPayableAmount(Long payableAmount) {
		this.payableAmount = payableAmount;
	}
	public String getExtendInfo() {
		return extendInfo;
	}
	public void setExtendInfo(String extendInfo) {
		this.extendInfo = extendInfo;
	}
    
    
}
