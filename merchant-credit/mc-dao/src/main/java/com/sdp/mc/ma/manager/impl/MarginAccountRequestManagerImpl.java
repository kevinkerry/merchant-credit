package com.sdp.mc.ma.manager.impl;

import com.sdp.mc.ma.dao.MarginAccountRequestDO;
import com.sdp.mc.ma.dao.MarginAccountRequestDOExample;
import com.sdp.mc.ma.dao.daointerface.MarginAccountRequestDAO;
import com.sdp.mc.ma.manager.MarginAccountRequestManager;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("marginAccountRequestManager")
public class MarginAccountRequestManagerImpl implements MarginAccountRequestManager {
    @Autowired
    private MarginAccountRequestDAO marginAccountRequestDAO;

    /**
     * 根据主键删除保证金账户开户记录【MarginAccountRequestDO】对象信息
     *
     * @mbggenerated Thu Mar 26 16:14:14 CST 2015
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        int rows = marginAccountRequestDAO.deleteByPrimaryKey(id);
        return rows;
    }

    /**
     * 添加保证金账户开户记录【MarginAccountRequestDO】对象信息
     *
     * @mbggenerated Thu Mar 26 16:14:14 CST 2015
     */
    @Override
    public Long insert(MarginAccountRequestDO record) {
        Long id = marginAccountRequestDAO.insert(record);
        return record.getId();
    }

    /**
     * 添加保证金账户开户记录【MarginAccountRequestDO】对象信息,空值字段不插入
     *
     * @mbggenerated Thu Mar 26 16:14:14 CST 2015
     */
    @Override
    public Long insertSelective(MarginAccountRequestDO record) {
        Long id = marginAccountRequestDAO.insertSelective(record);
        return record.getId();
    }

    /**
     * 根据Example对象查询得到保证金账户开户记录【MarginAccountRequestDO】对象列表信息
     *
     * @mbggenerated Thu Mar 26 16:14:14 CST 2015
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<MarginAccountRequestDO> selectByExample(MarginAccountRequestDOExample example) {
        List<MarginAccountRequestDO> list = marginAccountRequestDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询保证金账户开户记录【MarginAccountRequestDO】对象信息
     *
     * @mbggenerated Thu Mar 26 16:14:14 CST 2015
     */
    @Override
    public MarginAccountRequestDO selectByPrimaryKey(Long id) {
        MarginAccountRequestDO record = marginAccountRequestDAO.selectByPrimaryKey(id);
        return record;
    }

    /**
     * 根据主键更新保证金账户开户记录【MarginAccountRequestDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Thu Mar 26 16:14:14 CST 2015
     */
    @Override
    public int updateByPrimaryKeySelective(MarginAccountRequestDO record) {
        int rows = marginAccountRequestDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新保证金账户开户记录【MarginAccountRequestDO】对象信息
     *
     * @mbggenerated Thu Mar 26 16:14:14 CST 2015
     */
    @Override
    public int updateByPrimaryKey(MarginAccountRequestDO record) {
        int rows = marginAccountRequestDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询保证金账户开户记录【MarginAccountRequestDO】对象列表信息
     *
     * @mbggenerated Thu Mar 26 16:14:14 CST 2015
     */
    @Override
    public List<MarginAccountRequestDO> selectByQuery(MarginAccountRequestDOExample example) {
        Integer totalItem = (Integer)marginAccountRequestDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<MarginAccountRequestDO> returnList = new ArrayList<MarginAccountRequestDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<MarginAccountRequestDO> list =marginAccountRequestDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
    
    public int updateByExampleSelective(MarginAccountRequestDO record, MarginAccountRequestDOExample example){
    	return this.marginAccountRequestDAO.updateByExampleSelective(record, example);
    }
}