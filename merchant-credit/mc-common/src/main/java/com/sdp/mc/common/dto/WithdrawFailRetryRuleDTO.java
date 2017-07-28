package com.sdp.mc.common.dto;

import java.util.Date;

public class WithdrawFailRetryRuleDTO {
	private String ruleCode;//重试的CODE
	private String ruleDesc;//重试描述
	private String ruleContent;//重试的规则内容
	private Date executeTime; //重试时间
	private boolean isRetry;// 是否发起重试

	public String getRuleCode() {
		return ruleCode;
	}

	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}

	public String getRuleDesc() {
		return ruleDesc;
	}

	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}

	public String getRuleContent() {
		return ruleContent;
	}

	public void setRuleContent(String ruleContent) {
		this.ruleContent = ruleContent;
	}

	public Date getExecuteTime() {
		return executeTime;
	}

	public void setExecuteTime(Date executeTime) {
		this.executeTime = executeTime;
	}

	public boolean isRetry() {
		return isRetry;
	}

	public void setRetry(boolean isRetry) {
		this.isRetry = isRetry;
	}

	public WithdrawFailRetryRuleDTO(String ruleCode, String ruleDesc, String ruleContent, Date executeTime, boolean isRetry) {
		super();
		this.ruleCode = ruleCode;
		this.ruleDesc = ruleDesc;
		this.ruleContent = ruleContent;
		this.executeTime = executeTime;
		this.isRetry = isRetry;
	}

	public WithdrawFailRetryRuleDTO() {
		super();
	}
	
	
}
