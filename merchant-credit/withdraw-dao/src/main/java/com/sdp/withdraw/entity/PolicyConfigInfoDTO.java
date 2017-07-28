package com.sdp.withdraw.entity;

import java.util.List;

import com.sdp.emall.common.dao.QueryBase;
import com.sdp.withdraw.dao.PolicyConfigInfoDOExample;

public class PolicyConfigInfoDTO extends QueryBase {

	private static final long serialVersionUID = 1L;

	private PolicyConfigInfoPO po = new PolicyConfigInfoPO();
	private PolicyConfigInfoDOExample example = new PolicyConfigInfoDOExample();
	private List<PolicyConfigInfoPO> pageList;
	public PolicyConfigInfoPO getPo() {
		return po;
	}
	public void setPo(PolicyConfigInfoPO po) {
		this.po = po;
	}
	public PolicyConfigInfoDOExample getExample() {
		return example;
	}
	public void setExample(PolicyConfigInfoDOExample example) {
		this.example = example;
	}
	public List<PolicyConfigInfoPO> getPageList() {
		return pageList;
	}
	public void setPageList(List<PolicyConfigInfoPO> pageList) {
		this.pageList = pageList;
	}
	
	
	
	

	

}
