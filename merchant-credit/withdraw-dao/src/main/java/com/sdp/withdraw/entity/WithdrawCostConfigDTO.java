package com.sdp.withdraw.entity;

import java.util.List;

import com.sdp.emall.common.dao.QueryBase;
import com.sdp.withdraw.dao.WithdrawCostConfigDOExample;

public class WithdrawCostConfigDTO extends QueryBase {

	private static final long serialVersionUID = 1L;

	private WithdrawCostConfigPO po = new WithdrawCostConfigPO();
	private WithdrawCostConfigDOExample example = new WithdrawCostConfigDOExample();
	private List<WithdrawCostConfigPO> pageList;
	public WithdrawCostConfigPO getPo() {
		return po;
	}
	public void setPo(WithdrawCostConfigPO po) {
		this.po = po;
	}
	public WithdrawCostConfigDOExample getExample() {
		return example;
	}
	public void setExample(WithdrawCostConfigDOExample example) {
		this.example = example;
	}
	public List<WithdrawCostConfigPO> getPageList() {
		return pageList;
	}
	public void setPageList(List<WithdrawCostConfigPO> pageList) {
		this.pageList = pageList;
	}
	

}
