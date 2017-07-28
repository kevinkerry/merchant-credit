package com.shengpay.debit.dal.ext.dataobject;

import java.util.List;

import com.sdp.emall.common.dao.QueryBase;
import com.shengpay.debit.dal.dataobject.DbOrgCreditSettingExample;
import com.shengpay.debit.dal.dataobject.DbOrgCreditSettingPO;

public class DbOrgCreditSettingDTO extends QueryBase {

	private static final long serialVersionUID = 1L;

	private DbOrgCreditSettingPO po = new DbOrgCreditSettingPO();
	private DbOrgCreditSettingExample example = new DbOrgCreditSettingExample();
	private List<DbOrgCreditSettingPO> pageList;

	public DbOrgCreditSettingPO getPo() {
		return po;
	}

	public void setPo(DbOrgCreditSettingPO po) {
		this.po = po;
	}

	public DbOrgCreditSettingExample getExample() {
		return example;
	}

	public void setExample(DbOrgCreditSettingExample example) {
		this.example = example;
	}

	public List<DbOrgCreditSettingPO> getPageList() {
		return pageList;
	}

	public void setPageList(List<DbOrgCreditSettingPO> pageList) {
		this.pageList = pageList;
	}

}
