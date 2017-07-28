package com.shengpay.debit.daointerface;

import com.shengpay.debit.dal.dataobject.TbWithholdingFileInfoExample;
import com.shengpay.debit.dal.dataobject.TbWithholdingFileInfoPO;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class TbWithholdingFileInfoDAOImpl extends SqlMapClientDaoSupport implements TbWithholdingFileInfoDAO {

    public TbWithholdingFileInfoDAOImpl() {
        super();
    }

    public int countByExample(TbWithholdingFileInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("TB_WITHHOLDING_FILE_INFO.countByExample", example);
        return count;
    }

    public int deleteByExample(TbWithholdingFileInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("TB_WITHHOLDING_FILE_INFO.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        TbWithholdingFileInfoPO _key = new TbWithholdingFileInfoPO();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("TB_WITHHOLDING_FILE_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    public Long insert(TbWithholdingFileInfoPO record) {
        Object newKey = getSqlMapClientTemplate().insert("TB_WITHHOLDING_FILE_INFO.insert", record);
        return (Long) newKey;
    }

    public Long insertSelective(TbWithholdingFileInfoPO record) {
        Object newKey = getSqlMapClientTemplate().insert("TB_WITHHOLDING_FILE_INFO.insertSelective", record);
        return (Long) newKey;
    }

    @SuppressWarnings("unchecked")
    public List<TbWithholdingFileInfoPO> selectByExample(TbWithholdingFileInfoExample example) {
        List<TbWithholdingFileInfoPO> list = getSqlMapClientTemplate().queryForList("TB_WITHHOLDING_FILE_INFO.selectByExample", example);
        return list;
    }

    public TbWithholdingFileInfoPO selectByPrimaryKey(Long id) {
        TbWithholdingFileInfoPO _key = new TbWithholdingFileInfoPO();
        _key.setId(id);
        TbWithholdingFileInfoPO record = (TbWithholdingFileInfoPO) getSqlMapClientTemplate().queryForObject("TB_WITHHOLDING_FILE_INFO.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(TbWithholdingFileInfoPO record, TbWithholdingFileInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("TB_WITHHOLDING_FILE_INFO.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(TbWithholdingFileInfoPO record, TbWithholdingFileInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("TB_WITHHOLDING_FILE_INFO.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TbWithholdingFileInfoPO record) {
        int rows = getSqlMapClientTemplate().update("TB_WITHHOLDING_FILE_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TbWithholdingFileInfoPO record) {
        int rows = getSqlMapClientTemplate().update("TB_WITHHOLDING_FILE_INFO.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends TbWithholdingFileInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, TbWithholdingFileInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}