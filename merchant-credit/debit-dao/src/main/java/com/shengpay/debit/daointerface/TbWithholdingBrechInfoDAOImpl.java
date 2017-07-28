package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.TbWithholdingBrechInfoExample;
import com.shengpay.debit.dal.dataobject.TbWithholdingBrechInfoPO;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class TbWithholdingBrechInfoDAOImpl extends SqlMapClientDaoSupport implements TbWithholdingBrechInfoDAO {

    public TbWithholdingBrechInfoDAOImpl() {
        super();
    }

    public int countByExample(TbWithholdingBrechInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("TB_WITHHOLDING_BRECH_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(TbWithholdingBrechInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("TB_WITHHOLDING_BRECH_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        TbWithholdingBrechInfoPO _key = new TbWithholdingBrechInfoPO();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("TB_WITHHOLDING_BRECH_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public Long insert(TbWithholdingBrechInfoPO record) {
        Object newKey = getSqlMapClientTemplate().insert("TB_WITHHOLDING_BRECH_INFO.insert", record);
        return (Long) newKey;
    }

    public Long insertSelective(TbWithholdingBrechInfoPO record) {
        Object newKey = getSqlMapClientTemplate().insert("TB_WITHHOLDING_BRECH_INFO.insertSelective", record);
        return (Long) newKey;
    }

    @SuppressWarnings("unchecked")
    public List<TbWithholdingBrechInfoPO> selectByExample(TbWithholdingBrechInfoExample example) {
        List<TbWithholdingBrechInfoPO> list = getSqlMapClientTemplate().queryForList("TB_WITHHOLDING_BRECH_INFO.selectByExample", example);
        return list;
    }

    public TbWithholdingBrechInfoPO selectByPrimaryKey(Long id) {
        TbWithholdingBrechInfoPO _key = new TbWithholdingBrechInfoPO();
        _key.setId(id);
        TbWithholdingBrechInfoPO record = (TbWithholdingBrechInfoPO) getSqlMapClientTemplate().queryForObject("TB_WITHHOLDING_BRECH_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(TbWithholdingBrechInfoPO record, TbWithholdingBrechInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("TB_WITHHOLDING_BRECH_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TbWithholdingBrechInfoPO record, TbWithholdingBrechInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("TB_WITHHOLDING_BRECH_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TbWithholdingBrechInfoPO record) {
        int rows = getSqlMapClientTemplate().update("TB_WITHHOLDING_BRECH_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TbWithholdingBrechInfoPO record) {
        int rows = getSqlMapClientTemplate().update("TB_WITHHOLDING_BRECH_INFO.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends TbWithholdingBrechInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, TbWithholdingBrechInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}