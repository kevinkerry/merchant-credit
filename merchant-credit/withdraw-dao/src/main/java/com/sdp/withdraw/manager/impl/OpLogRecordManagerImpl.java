package com.sdp.withdraw.manager.impl;

import com.sdp.withdraw.dao.OpLogRecordDO;
import com.sdp.withdraw.dao.OpLogRecordDOExample;
import com.sdp.withdraw.dao.daointerface.OpLogRecordDAO;
import com.sdp.withdraw.manager.OpLogRecordManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("opLogRecordManager")
public class OpLogRecordManagerImpl implements OpLogRecordManager {
    @Autowired
    private OpLogRecordDAO opLogRecordDAO;

    /**
     * 根据主键删除操作历史记录【OpLogRecordDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        int rows = opLogRecordDAO.deleteByPrimaryKey(id);
        return rows;
    }

    /**
     * 添加操作历史记录【OpLogRecordDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    @Override
    public Long insert(OpLogRecordDO record) {
        Long id = opLogRecordDAO.insert(record);
        return record.getId();
    }

    /**
     * 添加操作历史记录【OpLogRecordDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    @Override
    public Long insertSelective(OpLogRecordDO record) {
        Long id = opLogRecordDAO.insertSelective(record);
        return record.getId();
    }

    /**
     * 根据Example对象查询得到操作历史记录【OpLogRecordDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<OpLogRecordDO> selectByExample(OpLogRecordDOExample example) {
        List<OpLogRecordDO> list = opLogRecordDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询操作历史记录【OpLogRecordDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    @Override
    public OpLogRecordDO selectByPrimaryKey(Long id) {
        OpLogRecordDO record = opLogRecordDAO.selectByPrimaryKey(id);
        return record;
    }

    /**
     * 根据主键更新操作历史记录【OpLogRecordDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    @Override
    public int updateByPrimaryKeySelective(OpLogRecordDO record) {
        int rows = opLogRecordDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新操作历史记录【OpLogRecordDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    @Override
    public int updateByPrimaryKey(OpLogRecordDO record) {
        int rows = opLogRecordDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询操作历史记录【OpLogRecordDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    @Override
    public List<OpLogRecordDO> selectByQuery(OpLogRecordDOExample example) {
        Integer totalItem = (Integer)opLogRecordDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<OpLogRecordDO> returnList = new ArrayList<OpLogRecordDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<OpLogRecordDO> list =opLogRecordDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}