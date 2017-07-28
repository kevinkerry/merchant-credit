package com.sdp.mc.common.dto;

import java.io.Serializable;
import java.util.Map;

/**
 * 出款核心服务类
 * @author liyantao01
 *
 */
public class WithdrawCoreServiceDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 66829016183594833L;
	private Long detailId;
	private Long reqId;
	private String productCode; // 产品编码  32  不可空  
	private String appId;// 应用ID 监控ＩＤ  32  不可空  
	private String paymentCode;// 支付编码 监控ＩＤ  32  不可空  
	
	private String remitVoucherNo ;// 出款订单号  32  不可空  productCode+ paymentCode+ transferOrderNo:要求唯一  
	private String payerMemberId  ;//付款人会员ID  32  不可空    
	private String isNeedCountFee  ;//是否需要计费  1  不可空  1：计费；0：不计费  
	private String payerFee  ;//付款人费用  15  不可空  如10.01元 精确度到分  
	private String payeeFee  ;//收款人费用  15  不可空  如10.01元 精确度到分  
	private String isPermitPricingErr  ;//是否允许计费异常  1  不可空  如允许计费异常，在调用计费系统出现异常情况下，将继续支付 1：允许；0：不允许  
	private String payerAccountNo ;// 付款人储值账户ID  32  不可空    
	private String bankCode  ;//开户行  32  不可空    
	private String bankName ;// 开户行名称  128  可空    
	private String bankBranch ;// 支行名称  128  可空    
	private String bankLineNo ;// 支行编码(联行号)  32  可空    
	private String bankProvince ;// 银行所属省份  64  可空    
	private String bankCity  ;//银行所属城市  64  可空    
	private String payeeName ;// 收款人姓名  50  不可空    
	private String payeeCardNo  ;//收款人卡号  30  不可空    
	private String payeePurpose ;// 用途  128  可空    
	private String cardType  ;//卡类型  3  可空    
	private String companyOrPersonal  ;//账户类型  3  可空    
	private String gmtBizInitiate  ;//业务发起时间  14  不可空  数字串，一共14位 格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位] 例如：20071117020101  
	private String gmtPaymentInitiate  ;//支付发起时间  14  不可空  数字串，一共14位  格式为：年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位] 例如：20071117020101  
	private String remitAmount  ;//出款金额  15  不可空  如10.01元 精确度到分  
	private String callbackAddress  ;//支付结果回调地址  256  可为空  MQ队列名或者URL地址 MQ地址示例：mq:sdo.pe.paymentServ Http地址示例：Http://127.0.0.1/payment  
	private String memo  ;//备注信息  300  不可为空  备注信息  
	private String currency  ;//币种  3  可为空  不传默认为CNY  
	private Map<String,Object> reqExtention ;// 扩展信息  List<K,V>  可为空  ?接口扩展字段
	private String withdrawStatus ;// 批次处理状态  1  不可为空  1：申请成功；0：申请失败  
	private String returnCode  ;//返回错误码  7  可空  详细说明见：returnCode说明  
	private String returnMsg  ;//返回错误信息  100  可为空    
	private String extention  ;//扩展信息  List<K,V>  可为空  接口扩展字段  paymentState 支付订单状态 S/F/P.
	private String merchantNo  ;//商户号
	private String mcType  ;//商户类型
	private Integer serviceType  ;//服务类型
	
	
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	public Long getDetailId() {
		return detailId;
	}
	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}
	public Long getReqId() {
		return reqId;
	}
	public void setReqId(Long reqId) {
		this.reqId = reqId;
	}
	public String getRemitVoucherNo() {
		return remitVoucherNo;
	}
	public void setRemitVoucherNo(String remitVoucherNo) {
		this.remitVoucherNo = remitVoucherNo;
	}
	public String getPayerMemberId() {
		return payerMemberId;
	}
	public void setPayerMemberId(String payerMemberId) {
		this.payerMemberId = payerMemberId;
	}
	public String getIsNeedCountFee() {
		return isNeedCountFee;
	}
	public void setIsNeedCountFee(String isNeedCountFee) {
		this.isNeedCountFee = isNeedCountFee;
	}
	public String getPayerFee() {
		return payerFee;
	}
	public void setPayerFee(String payerFee) {
		this.payerFee = payerFee;
	}
	public String getPayeeFee() {
		return payeeFee;
	}
	public void setPayeeFee(String payeeFee) {
		this.payeeFee = payeeFee;
	}
	public String getIsPermitPricingErr() {
		return isPermitPricingErr;
	}
	public void setIsPermitPricingErr(String isPermitPricingErr) {
		this.isPermitPricingErr = isPermitPricingErr;
	}
	public String getPayerAccountNo() {
		return payerAccountNo;
	}
	public void setPayerAccountNo(String payerAccountNo) {
		this.payerAccountNo = payerAccountNo;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	public String getBankLineNo() {
		return bankLineNo;
	}
	public void setBankLineNo(String bankLineNo) {
		this.bankLineNo = bankLineNo;
	}
	public String getBankProvince() {
		return bankProvince;
	}
	public void setBankProvince(String bankProvince) {
		this.bankProvince = bankProvince;
	}
	public String getBankCity() {
		return bankCity;
	}
	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public String getPayeeCardNo() {
		return payeeCardNo;
	}
	public void setPayeeCardNo(String payeeCardNo) {
		this.payeeCardNo = payeeCardNo;
	}
	public String getPayeePurpose() {
		return payeePurpose;
	}
	public void setPayeePurpose(String payeePurpose) {
		this.payeePurpose = payeePurpose;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCompanyOrPersonal() {
		return companyOrPersonal;
	}
	public void setCompanyOrPersonal(String companyOrPersonal) {
		this.companyOrPersonal = companyOrPersonal;
	}
	public String getGmtBizInitiate() {
		return gmtBizInitiate;
	}
	public void setGmtBizInitiate(String gmtBizInitiate) {
		this.gmtBizInitiate = gmtBizInitiate;
	}
	public String getGmtPaymentInitiate() {
		return gmtPaymentInitiate;
	}
	public void setGmtPaymentInitiate(String gmtPaymentInitiate) {
		this.gmtPaymentInitiate = gmtPaymentInitiate;
	}
	public String getRemitAmount() {
		return remitAmount;
	}
	public void setRemitAmount(String remitAmount) {
		this.remitAmount = remitAmount;
	}
	public String getCallbackAddress() {
		return callbackAddress;
	}
	public void setCallbackAddress(String callbackAddress) {
		this.callbackAddress = callbackAddress;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Map<String, Object> getReqExtention() {
		return reqExtention;
	}
	public void setReqExtention(Map<String, Object> reqExtention) {
		this.reqExtention = reqExtention;
	}
	public String getWithdrawStatus() {
		return withdrawStatus;
	}
	public void setWithdrawStatus(String withdrawStatus) {
		this.withdrawStatus = withdrawStatus;
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
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	public String getMcType() {
		return mcType;
	}
	public void setMcType(String mcType) {
		this.mcType = mcType;
	}
	public Integer getServiceType() {
		return serviceType;
	}
	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	
	
	 
}
