package com.shengpay.debit.dal.ext.dataobject;

import java.util.List;

import com.sdp.emall.common.dao.QueryBase;
import com.shengpay.debit.dal.dataobject.DbThreadBatchExample;
import com.shengpay.debit.dal.dataobject.DbThreadBatchPO;

public class DbThreadBatchDTO extends QueryBase {

	private static final long serialVersionUID = 1L;

	private DbThreadBatchPO po = new DbThreadBatchPO();
	private DbThreadBatchExample example = new DbThreadBatchExample();
	private List<DbThreadBatchPO> pageList;

	public DbThreadBatchPO getPo() {
		return po;
	}

	public void setPo(DbThreadBatchPO po) {
		this.po = po;
	}

	public DbThreadBatchExample getExample() {
		return example;
	}

	public void setExample(DbThreadBatchExample example) {
		this.example = example;
	}

	public List<DbThreadBatchPO> getPageList() {
		return pageList;
	}

	public void setPageList(List<DbThreadBatchPO> pageList) {
		this.pageList = pageList;
	}

}
