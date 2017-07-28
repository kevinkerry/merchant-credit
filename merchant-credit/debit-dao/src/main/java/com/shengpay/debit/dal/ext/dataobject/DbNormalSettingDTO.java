package com.shengpay.debit.dal.ext.dataobject;

import java.util.List;

import com.sdp.emall.common.dao.QueryBase;
import com.shengpay.debit.dal.dataobject.DbNormalSettingExample;
import com.shengpay.debit.dal.dataobject.DbNormalSettingPO;

public class DbNormalSettingDTO extends QueryBase {

	private static final long serialVersionUID = 1L;

	private DbNormalSettingPO po = new DbNormalSettingPO();
	private DbNormalSettingExample example = new DbNormalSettingExample();
	private List<DbNormalSettingPO> pageList;

	public DbNormalSettingPO getPo() {
		return po;
	}

	public void setPo(DbNormalSettingPO po) {
		this.po = po;
	}

	public DbNormalSettingExample getExample() {
		return example;
	}

	public void setExample(DbNormalSettingExample example) {
		this.example = example;
	}

	public List<DbNormalSettingPO> getPageList() {
		return pageList;
	}

	public void setPageList(List<DbNormalSettingPO> pageList) {
		this.pageList = pageList;
	}

}
