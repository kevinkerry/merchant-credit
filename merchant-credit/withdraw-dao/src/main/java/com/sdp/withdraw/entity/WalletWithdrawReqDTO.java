package com.sdp.withdraw.entity;

import java.util.List;

import com.sdp.emall.common.dao.QueryBase;
import com.sdp.withdraw.dao.WalletWithdrawReqDOExample;

public class WalletWithdrawReqDTO extends QueryBase {

	private static final long serialVersionUID = 1L;

	private WalletWithdrawReqPO po = new WalletWithdrawReqPO();
	private WalletWithdrawReqDOExample example = new WalletWithdrawReqDOExample();
	private List<WalletWithdrawReqPO> pageList;
	public WalletWithdrawReqPO getPo() {
		return po;
	}
	public void setPo(WalletWithdrawReqPO po) {
		this.po = po;
	}
	public WalletWithdrawReqDOExample getExample() {
		return example;
	}
	public void setExample(WalletWithdrawReqDOExample example) {
		this.example = example;
	}
	public List<WalletWithdrawReqPO> getPageList() {
		return pageList;
	}
	public void setPageList(List<WalletWithdrawReqPO> pageList) {
		this.pageList = pageList;
	}
	
	
	
	

	

}
