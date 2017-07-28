package com.shengpay.debit.common.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shengpay.debit.common.service.BatchConfigService;
import com.shengpay.debit.dal.dataobject.DbThreadBatchExample;
import com.shengpay.debit.dal.dataobject.DbThreadBatchPO;
import com.shengpay.debit.dal.ext.dataobject.DbThreadBatchDTO;
import com.shengpay.debit.ext.daointerface.ExtDbThreadBatchDAO;

@Service
public class BatchConfigServiceImpl implements BatchConfigService {

	@Autowired
	private ExtDbThreadBatchDAO dbThreadBatchDAO;

	@Override
	public void selectByQuery(DbThreadBatchDTO query) {
		this.setCriteria(query.getExample(), query.getPo());
		this.dbThreadBatchDAO.selectByQuery(query);
	}

	/**
	 * 设置查询条件
	 * 
	 * @param example
	 * @param po
	 */
	private void setCriteria(DbThreadBatchExample example, DbThreadBatchPO po) {
		DbThreadBatchExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(po.getBatchCode())) {
			criteria.andBatchCodeEqualTo(po.getBatchCode());
		}
	}

}
