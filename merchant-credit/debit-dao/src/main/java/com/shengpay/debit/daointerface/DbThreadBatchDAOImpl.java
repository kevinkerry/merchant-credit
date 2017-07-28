package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DbThreadBatchExample;
import com.shengpay.debit.dal.dataobject.DbThreadBatchPO;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DbThreadBatchDAOImpl extends SqlMapClientDaoSupport implements DbThreadBatchDAO {

    public DbThreadBatchDAOImpl() {
        super();
    }

    public int countByExample(DbThreadBatchExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("DB_THREAD_BATCH.countByExample", example);
        return count;
    }

    public int deleteByExample(DbThreadBatchExample example) {
        int rows = getSqlMapClientTemplate().delete("DB_THREAD_BATCH.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        DbThreadBatchPO _key = new DbThreadBatchPO();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("DB_THREAD_BATCH.deleteByPrimaryKey", _key);
        return rows;
    }

    public Long insert(DbThreadBatchPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DB_THREAD_BATCH.insert", record);
        return (Long) newKey;
    }

    public Long insertSelective(DbThreadBatchPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DB_THREAD_BATCH.insertSelective", record);
        return (Long) newKey;
    }

    @SuppressWarnings("unchecked")
    public List<DbThreadBatchPO> selectByExample(DbThreadBatchExample example) {
        List<DbThreadBatchPO> list = getSqlMapClientTemplate().queryForList("DB_THREAD_BATCH.selectByExample", example);
        return list;
    }

    public DbThreadBatchPO selectByPrimaryKey(Long id) {
        DbThreadBatchPO _key = new DbThreadBatchPO();
        _key.setId(id);
        DbThreadBatchPO record = (DbThreadBatchPO) getSqlMapClientTemplate().queryForObject("DB_THREAD_BATCH.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(DbThreadBatchPO record, DbThreadBatchExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DB_THREAD_BATCH.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(DbThreadBatchPO record, DbThreadBatchExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DB_THREAD_BATCH.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(DbThreadBatchPO record) {
        int rows = getSqlMapClientTemplate().update("DB_THREAD_BATCH.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(DbThreadBatchPO record) {
        int rows = getSqlMapClientTemplate().update("DB_THREAD_BATCH.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends DbThreadBatchExample {
        private Object record;

        public UpdateByExampleParms(Object record, DbThreadBatchExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}