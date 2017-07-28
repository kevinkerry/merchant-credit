package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoExample;
import com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoPO;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class TbWithholdingOrderInfoDAOImpl extends SqlMapClientDaoSupport implements TbWithholdingOrderInfoDAO {

    public TbWithholdingOrderInfoDAOImpl() {
        super();
    }

    public int countByExample(TbWithholdingOrderInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("TB_WITHHOLDING_ORDER_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(TbWithholdingOrderInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("TB_WITHHOLDING_ORDER_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        TbWithholdingOrderInfoPO _key = new TbWithholdingOrderInfoPO();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("TB_WITHHOLDING_ORDER_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public Long insert(TbWithholdingOrderInfoPO record) {
        Object newKey = getSqlMapClientTemplate().insert("TB_WITHHOLDING_ORDER_INFO.insert", record);
        return (Long) newKey;
    }

    public Long insertSelective(TbWithholdingOrderInfoPO record) {
        Object newKey = getSqlMapClientTemplate().insert("TB_WITHHOLDING_ORDER_INFO.insertSelective", record);
        return (Long) newKey;
    }

    @SuppressWarnings("unchecked")
    public List<TbWithholdingOrderInfoPO> selectByExample(TbWithholdingOrderInfoExample example) {
        List<TbWithholdingOrderInfoPO> list = getSqlMapClientTemplate().queryForList("TB_WITHHOLDING_ORDER_INFO.selectByExample", example);
        return list;
    }

    public TbWithholdingOrderInfoPO selectByPrimaryKey(Long id) {
        TbWithholdingOrderInfoPO _key = new TbWithholdingOrderInfoPO();
        _key.setId(id);
        TbWithholdingOrderInfoPO record = (TbWithholdingOrderInfoPO) getSqlMapClientTemplate().queryForObject("TB_WITHHOLDING_ORDER_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(TbWithholdingOrderInfoPO record, TbWithholdingOrderInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("TB_WITHHOLDING_ORDER_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TbWithholdingOrderInfoPO record, TbWithholdingOrderInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("TB_WITHHOLDING_ORDER_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TbWithholdingOrderInfoPO record) {
        int rows = getSqlMapClientTemplate().update("TB_WITHHOLDING_ORDER_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TbWithholdingOrderInfoPO record) {
        int rows = getSqlMapClientTemplate().update("TB_WITHHOLDING_ORDER_INFO.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends TbWithholdingOrderInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, TbWithholdingOrderInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}