package com.sdp.mc.common.dto;

import java.math.BigDecimal;
import java.util.Date;

public class StatisticsWithdrawInfoDTO {
	
	/*
	 * 出款金额（出款成功和出款中的金额）
	 */
	private BigDecimal withdrawTotalAmount;
	/**
	 * 出款中的笔数
	 */
	private int withdrawingCnt;
	
	private int totalCnt;
	
	private Date time;
	
	private int activeMerchantNum;
	
	
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getActiveMerchantNum() {
		return activeMerchantNum;
	}
	public void setActiveMerchantNum(int activeMerchantNum) {
		this.activeMerchantNum = activeMerchantNum;
	}
	public BigDecimal getWithdrawTotalAmount() {
		return withdrawTotalAmount;
	}
	public void setWithdrawTotalAmount(BigDecimal withdrawTotalAmount) {
		this.withdrawTotalAmount = withdrawTotalAmount;
	}
	public int getWithdrawingCnt() {
		return withdrawingCnt;
	}
	public void setWithdrawingCnt(int withdrawingCnt) {
		this.withdrawingCnt = withdrawingCnt;
	}
	
	

}
