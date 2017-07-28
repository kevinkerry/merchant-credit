package com.sdp.mc.dao.authorize;

import java.util.Date;

/**
 * rule EO
 * @author zhangmeng.michael
 *
 */
public class RuleEO {
	
	/**
	 * id
	 */
	private long id;
	/**
	 * rule代码
	 */
	private String ruleCode;
	/**
	 * rule名称
	 */
	private String ruleName;
	/**
	 * rule显示顺序
	 */
	private int ruleOrder;
	/**
	 * 所属组
	 */
	private long ruleGroup;
	/**
	 * 所属商户类型
	 */
	private String ruleMerchantType;
	
	/**
	 * 权限优先级，用于处理权限级联问题
	 */
	private long rulePriority;
	/**
	 * 版本
	 */
	private Long version;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 最后更新时间
	 */
	private Date lastUpdateTime;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRuleCode() {
		return ruleCode;
	}
	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public int getRuleOrder() {
		return ruleOrder;
	}
	public void setRuleOrder(int ruleOrder) {
		this.ruleOrder = ruleOrder;
	}
	public long getRuleGroup() {
		return ruleGroup;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public void setRuleGroup(long ruleGroup) {
		this.ruleGroup = ruleGroup;
	}
	public String getRuleMerchantType() {
		return ruleMerchantType;
	}
	public void setRuleMerchantType(String ruleMerchantType) {
		this.ruleMerchantType = ruleMerchantType;
	}
	public long getRulePriority() {
		return rulePriority;
	}
	public void setRulePriority(long rulePriority) {
		this.rulePriority = rulePriority;
	}

}
