package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DoTransferLogExample;
import com.shengpay.debit.dal.dataobject.DoTransferLogPO;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DoTransferLogDAOImpl extends SqlMapClientDaoSupport implements DoTransferLogDAO {

    public DoTransferLogDAOImpl() {
        super();
    }

    public int countByExample(DoTransferLogExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("DO_TRANSFER_LOG.countByExample", example);
        return count;
    }

    public int deleteByExample(DoTransferLogExample example) {
        int rows = getSqlMapClientTemplate().delete("DO_TRANSFER_LOG.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        DoTransferLogPO _key = new DoTransferLogPO();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("DO_TRANSFER_LOG.deleteByPrimaryKey", _key);
        return rows;
    }

    public Long insert(DoTransferLogPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DO_TRANSFER_LOG.insert", record);
        return (Long) newKey;
    }

    public Long insertSelective(DoTransferLogPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DO_TRANSFER_LOG.insertSelective", record);
        return (Long) newKey;
    }

    @SuppressWarnings("unchecked")
    public List<DoTransferLogPO> selectByExample(DoTransferLogExample example) {
        List<DoTransferLogPO> list = getSqlMapClientTemplate().queryForList("DO_TRANSFER_LOG.selectByExample", example);
        return list;
    }

    public DoTransferLogPO selectByPrimaryKey(Long id) {
        DoTransferLogPO _key = new DoTransferLogPO();
        _key.setId(id);
        DoTransferLogPO record = (DoTransferLogPO) getSqlMapClientTemplate().queryForObject("DO_TRANSFER_LOG.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(DoTransferLogPO record, DoTransferLogExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DO_TRANSFER_LOG.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(DoTransferLogPO record, DoTransferLogExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DO_TRANSFER_LOG.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(DoTransferLogPO record) {
        int rows = getSqlMapClientTemplate().update("DO_TRANSFER_LOG.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(DoTransferLogPO record) {
        int rows = getSqlMapClientTemplate().update("DO_TRANSFER_LOG.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends DoTransferLogExample {
        private Object record;

        public UpdateByExampleParms(Object record, DoTransferLogExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}