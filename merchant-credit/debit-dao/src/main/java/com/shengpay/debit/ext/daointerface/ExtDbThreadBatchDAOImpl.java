package com.shengpay.debit.ext.daointerface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.shengpay.debit.dal.dataobject.DbThreadBatchExample;
import com.shengpay.debit.dal.dataobject.DbThreadBatchPO;
import com.shengpay.debit.dal.ext.dataobject.DbThreadBatchDTO;
import com.shengpay.debit.daointerface.DbThreadBatchDAOImpl;

public class ExtDbThreadBatchDAOImpl extends DbThreadBatchDAOImpl implements  ExtDbThreadBatchDAO {

	  /**
    *
    * @param nextDate
    */
   @Override
   public DbThreadBatchPO queryNextBatchExecute(String serilizeCode){
	   DbThreadBatchExample example = new DbThreadBatchExample();
	   DbThreadBatchExample.Criteria criteria = example.createCriteria();
       criteria.andSerilizeCodeEqualTo(serilizeCode);
       List<DbThreadBatchPO> po = this.selectByExample(example);
       if (po != null && po.size() > 0 ){
           return po.get(0);
       }
       return null;
   }

   @Override
   public DbThreadBatchPO queryRepeatBatchExecute(Date nextDate, String batchCode){
	   DbThreadBatchExample example = new DbThreadBatchExample();
	   DbThreadBatchExample.Criteria criteria = example.createCriteria();
       criteria.andStartTimeEqualTo(nextDate);
       criteria.andBatchCodeEqualTo(batchCode);
       List<DbThreadBatchPO> po = this.selectByExample(example);
       if (po != null && po.size() > 0 ){
           return po.get(0);
       }
       return null;
   }

   /**
    * lock execute
    * @param id
    * @return
    */
   @Override
   @Transactional("debitTransactionManager")
   public void lockBatchExecute(Long id){
       Map<String, Object> params = new HashMap<String, Object>();
       params.put("id", id);
       getSqlMapClientTemplate().queryForList("DB_THREAD_BATCH.lockBatchExecute", params);
   }

   @Override
   public int updateBatchRunningStatus(Map<String, Object> params){
       return getSqlMapClientTemplate().update("DB_THREAD_BATCH.updateBatchRunningStatus", params);
   }

   @Override
   public boolean isBenifitYesterdayComplete() {
	   DbThreadBatchExample example = new DbThreadBatchExample();
	   DbThreadBatchExample.Criteria criteria = example.createCriteria();
       SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
       String dateFormat = sdf.format(new Date());
       String serilizeCode = "001" + dateFormat;
       criteria.andBatchCodeEqualTo("001");
       criteria.andSerilizeCodeEqualTo(serilizeCode);
       criteria.andExecuteResultEqualTo(100);
       List<DbThreadBatchPO>  list = this.selectByExample(example);
       if (list != null && list.size() > 0){
           return true;
       } else{
           return false;
       }
   }

	@Override
	public List<DbThreadBatchPO> queryCanRunnableExecute() {
		DbThreadBatchExample example = new DbThreadBatchExample();
    	DbThreadBatchExample.Criteria criteria = example.createCriteria();
        criteria.andStartTimeLessThan(new Date());
        criteria.andEndTimeIsNull();
        return selectByExample(example);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void selectByQuery(DbThreadBatchDTO query) {
		Integer totalItem = (Integer) getSqlMapClientTemplate().queryForObject("DB_THREAD_BATCH.countByExample", query.getExample());
		query.setTotalItem(totalItem);
		if (query.isNeedQueryAll() && totalItem > 0) {
			query.setPageSize(totalItem);
		}
		if (query.getPageFristItem() <= query.getTotalItem()) {
			List<DbThreadBatchPO> list = (List<DbThreadBatchPO>) this.getSqlMapClientTemplate().queryForList("DB_THREAD_BATCH.selectByQuery", query);
			query.setPageList(list);
		}
	}
}
