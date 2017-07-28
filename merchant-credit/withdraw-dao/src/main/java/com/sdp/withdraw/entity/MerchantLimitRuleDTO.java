package com.sdp.withdraw.entity;

import java.util.List;

import com.sdp.emall.common.dao.QueryBase;
import com.sdp.withdraw.dao.MerchantLimitRuleDOExample;

public class MerchantLimitRuleDTO extends QueryBase {

	private static final long serialVersionUID = 1L;

	private MerchantLimitRulePO po = new MerchantLimitRulePO();
	private MerchantLimitRuleDOExample example = new MerchantLimitRuleDOExample();
	private List<MerchantLimitRulePO> pageList;
	public MerchantLimitRulePO getPo() {
		return po;
	}
	public void setPo(MerchantLimitRulePO po) {
		this.po = po;
	}
	public MerchantLimitRuleDOExample getExample() {
		return example;
	}
	public void setExample(MerchantLimitRuleDOExample example) {
		this.example = example;
	}
	public List<MerchantLimitRulePO> getPageList() {
		return pageList;
	}
	public void setPageList(List<MerchantLimitRulePO> pageList) {
		this.pageList = pageList;
	}
	

}
