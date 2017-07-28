package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.DoAgentProfitExample;
import com.shengpay.debit.dal.dataobject.DoAgentProfitPO;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DoAgentProfitDAOImpl extends SqlMapClientDaoSupport implements DoAgentProfitDAO {

    public DoAgentProfitDAOImpl() {
        super();
    }

    public int countByExample(DoAgentProfitExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("DO_AGENT_PROFIT.countByExample", example);
        return count;
    }

    public int deleteByExample(DoAgentProfitExample example) {
        int rows = getSqlMapClientTemplate().delete("DO_AGENT_PROFIT.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        DoAgentProfitPO _key = new DoAgentProfitPO();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("DO_AGENT_PROFIT.deleteByPrimaryKey", _key);
        return rows;
    }

    public Long insert(DoAgentProfitPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DO_AGENT_PROFIT.insert", record);
        return (Long) newKey;
    }

    public Long insertSelective(DoAgentProfitPO record) {
        Object newKey = getSqlMapClientTemplate().insert("DO_AGENT_PROFIT.insertSelective", record);
        return (Long) newKey;
    }

    @SuppressWarnings("unchecked")
    public List<DoAgentProfitPO> selectByExample(DoAgentProfitExample example) {
        List<DoAgentProfitPO> list = getSqlMapClientTemplate().queryForList("DO_AGENT_PROFIT.selectByExample", example);
        return list;
    }

    public DoAgentProfitPO selectByPrimaryKey(Long id) {
        DoAgentProfitPO _key = new DoAgentProfitPO();
        _key.setId(id);
        DoAgentProfitPO record = (DoAgentProfitPO) getSqlMapClientTemplate().queryForObject("DO_AGENT_PROFIT.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(DoAgentProfitPO record, DoAgentProfitExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DO_AGENT_PROFIT.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(DoAgentProfitPO record, DoAgentProfitExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("DO_AGENT_PROFIT.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(DoAgentProfitPO record) {
        int rows = getSqlMapClientTemplate().update("DO_AGENT_PROFIT.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(DoAgentProfitPO record) {
        int rows = getSqlMapClientTemplate().update("DO_AGENT_PROFIT.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends DoAgentProfitExample {
        private Object record;

        public UpdateByExampleParms(Object record, DoAgentProfitExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}