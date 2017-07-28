//package com.sdp.mc.fastsettle.thread.model;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import com.sdp.mc.dao.readonly.msptxn.McSettFastTxnRO;
//
//public class FastSettleModel {
//
//	private List<Long> ids = new ArrayList<Long>();
//
//	private BigDecimal totalAmount = new BigDecimal(0);
//
//	private Integer type = 0;
//
//	private Long merchantId;
//
//	private BigDecimal settleFee;
//
//	private String merchantNo;
//	
//	private String merchantName;
//	
//	private String merchantType;
//
//	private String posMerchantNo;
//
//	private List<McSettFastTxnRO> mcSettFastTxnROs;
//
//	private Date createTime;
//
//	private Long promoterId;
//	
//	private String promoterNo;
//	
//	private String promoterName;
//	
//	private String promoterType;
//
//	public Long getPromoterId() {
//		return promoterId;
//	}
//
//	public void setPromoterId(Long promoterId) {
//		this.promoterId = promoterId;
//	}
//
//	public Date getCreateTime() {
//		return createTime;
//	}
//
//	public void setCreateTime(Date createTime) {
//		this.createTime = createTime;
//	}
//
//	public List<McSettFastTxnRO> getMcSettFastTxnROs() {
//		return mcSettFastTxnROs;
//	}
//
//	public void setMcSettFastTxnROs(List<McSettFastTxnRO> mcSettFastTxnROs) {
//		this.mcSettFastTxnROs = mcSettFastTxnROs;
//	}
//
//	public String getMerchantNo() {
//		return merchantNo;
//	}
//
//	public void setMerchantNo(String merchantNo) {
//		this.merchantNo = merchantNo;
//	}
//
//	public String getPosMerchantNo() {
//		return posMerchantNo;
//	}
//
//	public void setPosMerchantNo(String posMerchantNo) {
//		this.posMerchantNo = posMerchantNo;
//	}
//
//	public BigDecimal getSettleFee() {
//		return settleFee;
//	}
//
//	public void setSettleFee(BigDecimal settleFee) {
//		this.settleFee = settleFee;
//	}
//
//	public Long getMerchantId() {
//		return merchantId;
//	}
//
//	public void setMerchantId(Long merchantId) {
//		this.merchantId = merchantId;
//	}
//
//	public Integer getType() {
//		return type;
//	}
//
//	public void setType(Integer type) {
//		this.type = type;
//	}
//
//	public BigDecimal getTotalAmount() {
//		return totalAmount;
//	}
//
//	public void setTotalAmount(BigDecimal totalAmount) {
//		this.totalAmount = totalAmount;
//	}
//
//	public List<Long> getIds() {
//		return ids;
//	}
//
//	public void setIds(List<Long> ids) {
//		this.ids = ids;
//	}
//
//	public void addId(Long id){
//		ids.add(id);
//	}
//
//	public String getMerchantName() {
//		return merchantName;
//	}
//
//	public void setMerchantName(String merchantName) {
//		this.merchantName = merchantName;
//	}
//
//	public String getMerchantType() {
//		return merchantType;
//	}
//
//	public void setMerchantType(String merchantType) {
//		this.merchantType = merchantType;
//	}
//
//	public String getPromoterNo() {
//		return promoterNo;
//	}
//
//	public void setPromoterNo(String promoterNo) {
//		this.promoterNo = promoterNo;
//	}
//
//	public String getPromoterName() {
//		return promoterName;
//	}
//
//	public void setPromoterName(String promoterName) {
//		this.promoterName = promoterName;
//	}
//
//	public String getPromoterType() {
//		return promoterType;
//	}
//
//	public void setPromoterType(String promoterType) {
//		this.promoterType = promoterType;
//	}
//	
//	
//
//
//
//}
