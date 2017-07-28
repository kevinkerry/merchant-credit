package com.sdp.mc.service.msp.promoter;

import java.math.BigDecimal;

import com.sdp.mc.dao.readonly.promoter.PromoterEO;

public class PromoterRO extends PromoterEO {

	/**
	 * 状态的中文名称
	 */
	public String mcStatusCh;

	/**
	 * 代理商保证金账户的余额
	 */
	public String marginAccountBalance;
	/**
	 * 代理商保证金账户的余额
	 */
	public BigDecimal todayLimit;

	/**
	 * 远程调用状态
	 */
	public String remoteInvocationStatus;


	public String validCredit = String.valueOf(BigDecimal.ZERO) + " 元";

	public String getMcStatusCh() {
		return mcStatusCh;
	}

	public void setMcStatusCh(String mcStatusCh) {
		this.mcStatusCh = mcStatusCh;
	}


	public String getMarginAccountBalance() {
		return marginAccountBalance;
	}

	public void setMarginAccountBalance(String marginAccountBalance) {
		this.marginAccountBalance = marginAccountBalance;
	}

	public String getRemoteInvocationStatus() {
		return remoteInvocationStatus;
	}

	public void setRemoteInvocationStatus(String remoteInvocationStatus) {
		this.remoteInvocationStatus = remoteInvocationStatus;
	}

	public String getValidCredit() {
		return validCredit;
	}

	public void setValidCredit(String validCredit) {
		this.validCredit = validCredit;
	}
	private String agentPower;

	public String getAgentPower() {
		return agentPower;
	}

	public void setAgentPower(String agentPower) {
		this.agentPower = agentPower;
	}

	public BigDecimal getTodayLimit() {
		return todayLimit;
	}

	public void setTodayLimit(BigDecimal todayLimit) {
		this.todayLimit = todayLimit;
	}


	
}
