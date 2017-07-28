package com.sdp.mc.web.vo;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang3.StringUtils;

import com.sdp.emall.common.dao.QueryBase;
import com.sdp.mc.common.util.DateUtil;

public class EasyPayTradeRequest extends QueryBase {

    private String merchantNo ;
	
	private String orderNo;
	
	private String payProduct;
	
	private String payStartTime;
	
	private String payEndTime;
	
	private String payType;
	
	private String parentMerchantNo;
	
	private String secondProxy;

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String payOrderNo) {
		this.orderNo = payOrderNo;
	}

	public String getPayProduct() {
		return payProduct;
	}

	public void setPayProduct(String payProduct) {
		this.payProduct = payProduct;
	}

	public String getPayStartTime() {
		return payStartTime;
	}

	public void setPayStartTime(String payStartTime) {
		this.payStartTime =StringUtils.remove(payStartTime, "-");
		
	}

	public String getPayEndTime() {
		return payEndTime;
	}

	public void setPayEndTime(String payEndTime) {
		this.payEndTime =StringUtils.remove(payEndTime, "-");
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getParentMerchantNo() {
		return parentMerchantNo;
	}

	public void setParentMerchantNo(String parentMerchantNo) {
		this.parentMerchantNo = parentMerchantNo;
	}
	
	public String getSecondProxy() {
		return secondProxy;
	}

	public void setSecondProxy(String secondProxy) {
		this.secondProxy = secondProxy;
	}

	@Override
	public String toString(){
		return  ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
    
}
