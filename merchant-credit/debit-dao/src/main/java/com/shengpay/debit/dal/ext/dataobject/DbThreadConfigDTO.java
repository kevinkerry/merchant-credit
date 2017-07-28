package com.shengpay.debit.dal.ext.dataobject;

import java.util.List;

import com.sdp.emall.common.dao.QueryBase;
import com.shengpay.debit.dal.dataobject.DbThreadConfigExample;
import com.shengpay.debit.dal.dataobject.DbThreadConfigPO;

public class DbThreadConfigDTO extends QueryBase {

	private static final long serialVersionUID = 1L;

	private DbThreadConfigPO po = new DbThreadConfigPO();
	private DbThreadConfigExample example = new DbThreadConfigExample();
	private List<DbThreadConfigPO> pageList;

	public DbThreadConfigPO getPo() {
		return po;
	}

	public void setPo(DbThreadConfigPO po) {
		this.po = po;
	}

	public DbThreadConfigExample getExample() {
		return example;
	}

	public void setExample(DbThreadConfigExample example) {
		this.example = example;
	}

	public List<DbThreadConfigPO> getPageList() {
		return pageList;
	}

	public void setPageList(List<DbThreadConfigPO> pageList) {
		this.pageList = pageList;
	}

}
