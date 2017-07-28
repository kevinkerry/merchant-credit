package com.shengpay.debit.common.risk.model;

/**
 * 风控评级查询接口结果,
 * 因接口分"异常应答","正确应答"两类所以此类继承自CreditRiskErrorMessageVO,这样做的目的是json转java
 * bean的时候可以兼容
 * 
 * @author wangjingao.william
 * **/
public class CreditRiskResult extends CreditRiskErrorMessageVO {
	private static final long serialVersionUID = 1L;
	// 商户号
	private String code;
	// 评分策略
	private String policy;
	// //商户的评级状态，processing:处理中;failed:评审不通过;success:评审通过;expired:过期
	private String status;
	// 商户的评级结果，如果该商户处于评审通过则返回 A，B，C，D等。 如果处于非success状态则返回none
	private String level;
	// 过期时间
	private String expireDate;
	
	public CreditRiskResult() {
	}

	public CreditRiskResult(String errorCode, String errorMsg) {
		super(errorCode, errorMsg);
	}

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

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
}
