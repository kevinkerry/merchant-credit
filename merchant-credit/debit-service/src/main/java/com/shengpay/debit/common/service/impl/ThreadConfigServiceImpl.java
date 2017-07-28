package com.shengpay.debit.common.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shengpay.debit.common.service.ThreadConfigService;
import com.shengpay.debit.dal.dataobject.DbThreadConfigExample;
import com.shengpay.debit.dal.dataobject.DbThreadConfigPO;
import com.shengpay.debit.dal.ext.dataobject.DbThreadConfigDTO;
import com.shengpay.debit.ext.daointerface.ExtDbThreadConfigDAO;

@Service
public class ThreadConfigServiceImpl implements ThreadConfigService {

	@Autowired
	private ExtDbThreadConfigDAO dbThreadConfigDAO;

	@Override
	public void selectByQuery(DbThreadConfigDTO query) {
		this.setCriteria(query.getExample(), query.getPo());
		this.dbThreadConfigDAO.selectByQuery(query);
	}

	@Override
	public DbThreadConfigPO selectByPrimaryKey(Long id) {
		return this.dbThreadConfigDAO.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(DbThreadConfigPO config) {
		return this.dbThreadConfigDAO.updateByPrimaryKeySelective(config);
	}

	@Override
	public Long insert(DbThreadConfigPO config) {
		return this.dbThreadConfigDAO.insert(config);
	}

	/**
	 * 设置查询条件
	 * 
	 * @param example
	 * @param po
	 */
	private void setCriteria(DbThreadConfigExample example, DbThreadConfigPO po) {
		DbThreadConfigExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(po.getBatchCode())) {
			criteria.andBatchCodeEqualTo(po.getBatchCode());
		}
	}

}
