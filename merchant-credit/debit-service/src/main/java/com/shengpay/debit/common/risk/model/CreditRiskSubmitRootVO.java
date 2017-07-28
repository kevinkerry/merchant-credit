package com.shengpay.debit.common.risk.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 风控提交接口根类
 * 
 * @author wangjingao.william
 * **/
public class CreditRiskSubmitRootVO implements Serializable {
	private static final long serialVersionUID = 1L;
	// 必填，商户号/身份证号等
	private String code;
	// 必填，商户名称/姓名等
	private String name;
	// 必填，证件类型,e.g. Merchant
	private String type;
	// 必填，评分审核通过后通知业务系统的回调URL
	private String callBackUrl;
	// 必填，信用评估策略，跟上面查询模型接口的策略名称一致,e.g. tiantiandai
	private String policyCode;
	// 评分分类
	private List<ScoreType4Submit> policyTypes = new ArrayList<ScoreType4Submit>();

	public void addAllPolicyTypes(List<ScoreType4Submit> policyTypes) {
		this.policyTypes.addAll(policyTypes);
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCallBackUrl() {
		return callBackUrl;
	}

	public void setCallBackUrl(String callBackUrl) {
		this.callBackUrl = callBackUrl;
	}

	public String getPolicyCode() {
		return policyCode;
	}
	public void setPolicyCode(String policyCode) {
		this.policyCode = policyCode;
	}
	public List<ScoreType4Submit> getPolicyTypes() {
		return policyTypes;
	}
	public void setPolicyTypes(List<ScoreType4Submit> policyTypes) {
		this.policyTypes = policyTypes;
	}
}
