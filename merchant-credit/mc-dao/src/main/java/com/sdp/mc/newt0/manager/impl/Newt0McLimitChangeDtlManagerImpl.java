package com.sdp.mc.newt0.manager.impl;

import com.sdp.mc.newt0.dao.Newt0McLimitChangeDtlDO;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeDtlDOExample;
import com.sdp.mc.newt0.dao.daointerface.Newt0McLimitChangeDtlDAO;
import com.sdp.mc.newt0.manager.Newt0McLimitChangeDtlManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("newt0McLimitChangeDtlManager")
public class Newt0McLimitChangeDtlManagerImpl implements Newt0McLimitChangeDtlManager {
    @Autowired
    private Newt0McLimitChangeDtlDAO newt0McLimitChangeDtlDAO;

    /**
     * 根据主键删除商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    @Override
    public int deleteByPrimaryKey(Long changeId) {
        int rows = newt0McLimitChangeDtlDAO.deleteByPrimaryKey(changeId);
        return rows;
    }

    /**
     * 添加商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    @Override
    public Long insert(Newt0McLimitChangeDtlDO record) {
        Long id = newt0McLimitChangeDtlDAO.insert(record);
        return record.getChangeId();
    }

    /**
     * 添加商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    @Override
    public Long insertSelective(Newt0McLimitChangeDtlDO record) {
        Long id = newt0McLimitChangeDtlDAO.insertSelective(record);
        return record.getChangeId();
    }

    /**
     * 根据Example对象查询得到商户额度变更明细【Newt0McLimitChangeDtlDO】对象列表信息
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Newt0McLimitChangeDtlDO> selectByExample(Newt0McLimitChangeDtlDOExample example) {
        List<Newt0McLimitChangeDtlDO> list = newt0McLimitChangeDtlDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    @Override
    public Newt0McLimitChangeDtlDO selectByPrimaryKey(Long changeId) {
        Newt0McLimitChangeDtlDO record = newt0McLimitChangeDtlDAO.selectByPrimaryKey(changeId);
        return record;
    }

    /**
     * 根据主键更新商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    @Override
    public int updateByPrimaryKeySelective(Newt0McLimitChangeDtlDO record) {
        int rows = newt0McLimitChangeDtlDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    @Override
    public int updateByPrimaryKey(Newt0McLimitChangeDtlDO record) {
        int rows = newt0McLimitChangeDtlDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询商户额度变更明细【Newt0McLimitChangeDtlDO】对象列表信息
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    @Override
    public List<Newt0McLimitChangeDtlDO> selectByQuery(Newt0McLimitChangeDtlDOExample example) {
        Integer totalItem = (Integer)newt0McLimitChangeDtlDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<Newt0McLimitChangeDtlDO> returnList = new ArrayList<Newt0McLimitChangeDtlDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<Newt0McLimitChangeDtlDO> list =newt0McLimitChangeDtlDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}