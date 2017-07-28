package com.shengpay.mcl.btc.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.sdo.mas.common.api.common.enums.TransStatus;
import com.shengpay.mcl.api.common.BaseResponse;

/**
 * 批量委托代收状态响应
 * 2015年12月4日 15:14:40
 */

@XmlType(namespace = "http://response.btc.mcl.shengpay.com")
@XmlAccessorType(XmlAccessType.FIELD)
public class BatchOrderStatusResponse extends BaseResponse {
	private static final long serialVersionUID = 9155046865296713125L;

	private String transNo; // 产品订单号
	private String paymentNo; // 支付订单号
	private String transTime;
	private String orderAmount;
	private String sendTime;
	private String traceNo;
	private String transAmount;
	private String bankSerialNo;
	private String requestCurrency;
	private String charset;
	private String orderNo; // 商户订单号
	private String paymentCurrency;
	private String transType;//
	private String payableFee;//
	private String version;//
	private String ext1;
	private String ext2;
	private String transStatus;// 订单状态
	private String payChannel;
	private String signType;
	private String receivableFee;//应收手续费
	private String name;
	private String requestOrderAmout;
	private String instCode;
	private String outMemberId;
	private String merchantNo;
	private String msgSender;
	private String signMsg;
	private String errorMsg;
	private String errorCode;
	private String fexchangeRate;

	public String getTransNo() {
		return transNo;
	}

	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	public String getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}

	public String getTransTime() {
		return transTime;
	}

	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getTraceNo() {
		return traceNo;
	}

	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}

	public String getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(String transAmount) {
		this.transAmount = transAmount;
	}

	public String getBankSerialNo() {
		return bankSerialNo;
	}

	public void setBankSerialNo(String bankSerialNo) {
		this.bankSerialNo = bankSerialNo;
	}

	public String getRequestCurrency() {
		return requestCurrency;
	}

	public void setRequestCurrency(String requestCurrency) {
		this.requestCurrency = requestCurrency;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getPaymentCurrency() {
		return paymentCurrency;
	}

	public void setPaymentCurrency(String paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getPayableFee() {
		return payableFee;
	}

	public void setPayableFee(String payableFee) {
		this.payableFee = payableFee;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	public String getTransStatus() {
		return transStatus;
	}

	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus;
	}

	public String getPayChannel() {
		return payChannel;
	}

	public void setPayChannel(String payChannel) {
		this.payChannel = payChannel;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getReceivableFee() {
		return receivableFee;
	}

	public void setReceivableFee(String receivableFee) {
		this.receivableFee = receivableFee;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRequestOrderAmout() {
		return requestOrderAmout;
	}

	public void setRequestOrderAmout(String requestOrderAmout) {
		this.requestOrderAmout = requestOrderAmout;
	}

	public String getInstCode() {
		return instCode;
	}

	public void setInstCode(String instCode) {
		this.instCode = instCode;
	}

	public String getOutMemberId() {
		return outMemberId;
	}

	public void setOutMemberId(String outMemberId) {
		this.outMemberId = outMemberId;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getMsgSender() {
		return msgSender;
	}

	public void setMsgSender(String msgSender) {
		this.msgSender = msgSender;
	}

	public String getSignMsg() {
		return signMsg;
	}

	public void setSignMsg(String signMsg) {
		this.signMsg = signMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getFexchangeRate() {
		return fexchangeRate;
	}

	public void setFexchangeRate(String fexchangeRate) {
		this.fexchangeRate = fexchangeRate;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}

	@Override
	public String getSignString() {
		return null;
	}

}
