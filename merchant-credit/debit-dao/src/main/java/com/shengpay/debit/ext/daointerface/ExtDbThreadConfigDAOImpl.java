package com.shengpay.debit.ext.daointerface;

import java.util.List;

import com.shengpay.debit.dal.dataobject.DbThreadConfigExample;
import com.shengpay.debit.dal.dataobject.DbThreadConfigPO;
import com.shengpay.debit.dal.ext.dataobject.DbThreadConfigDTO;
import com.shengpay.debit.daointerface.DbThreadConfigDAOImpl;

public class ExtDbThreadConfigDAOImpl extends DbThreadConfigDAOImpl implements ExtDbThreadConfigDAO{

    @Override
    public List<DbThreadConfigPO> selectConfigByStatus(int status){
    	DbThreadConfigExample example = new DbThreadConfigExample();
    	DbThreadConfigExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(status);
        return this.selectByExample(example);
    }

    @Override
    public DbThreadConfigPO findByBatchCode(String batchCode){
    	DbThreadConfigExample example = new DbThreadConfigExample();
    	DbThreadConfigExample.Criteria criteria = example.createCriteria();
        criteria.andBatchCodeEqualTo(batchCode);
        List<DbThreadConfigPO> poConfigList = selectByExample(example);
        if (poConfigList != null && poConfigList.size() > 0){
            return poConfigList.get(0);
        } else{
            return null;
        }
    }

	@SuppressWarnings("unchecked")
	@Override
	public void selectByQuery(DbThreadConfigDTO query) {
		Integer totalItem = (Integer) getSqlMapClientTemplate().queryForObject("DB_THREAD_CONFIG.countByExample", query.getExample());
		query.setTotalItem(totalItem);
		if (query.isNeedQueryAll() && totalItem > 0) {
			query.setPageSize(totalItem);
		}
		if (query.getPageFristItem() <= query.getTotalItem()) {
			List<DbThreadConfigPO> list = (List<DbThreadConfigPO>) this.getSqlMapClientTemplate().queryForList("DB_THREAD_CONFIG.selectByQuery", query);
			query.setPageList(list);
		}
	}
}
