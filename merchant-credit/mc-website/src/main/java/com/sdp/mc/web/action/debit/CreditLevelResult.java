package com.sdp.mc.web.action.debit;

public class CreditLevelResult {

	// 商户号
	private String code;
	// 策略
	private String policy;
	// 商户的评级状态，processing:处理中;failed:评审不通过;success:评审通过;expired:过期  
	private String status;
	// 评级
	private String level;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPolicy() {
		return policy;
	}
	public void setPolicy(String policy) {
		this.policy = policy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
}
