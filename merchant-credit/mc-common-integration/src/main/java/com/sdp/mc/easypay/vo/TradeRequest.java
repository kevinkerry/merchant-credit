package com.sdp.mc.easypay.vo;



import com.sdp.mc.common.util.StringUtil;


public class TradeRequest  {


	private String parentMerchantNo;
	
	private String merchantNo;
	
	private String orderNo;
	
	private String payProduct;
	
	private String payStartTime;
	
	private String payEndTime;
	
	private String payType;
	
	private String secondProxy;
	
	/**
     * 每页记录数
     */
    private Integer pageSize=10;

    /**
     * 当前页码
     */
    private Integer pageNo;

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
		this.payStartTime = payStartTime;
	}

	public String getPayEndTime() {
		return payEndTime;
	}

	public void setPayEndTime(String payEndTime) {
		this.payEndTime = payEndTime;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
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
		return StringUtil.joinUrlParams(this);
	}
    
}
