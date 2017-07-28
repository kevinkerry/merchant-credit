package com.sdp.mc.fos.manager.impl;

import com.sdp.mc.fos.dao.MarginTransDO;
import com.sdp.mc.fos.dao.MarginTransDOExample;
import com.sdp.mc.fos.dao.daointerface.MarginTransDAO;
import com.sdp.mc.fos.dao.mapper.MarginTransSqlProvider;
import com.sdp.mc.fos.manager.MarginTransManager;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("marginTransManager")
public class MarginTransManagerImpl implements MarginTransManager {
    @Autowired
    private MarginTransDAO marginTransDAO;

    /**
     * 根据主键删除保证金转账记录【MarginTransDO】对象信息
     *
     * @mbggenerated Mon Mar 30 13:57:58 CST 2015
     */
    @Override
    public int deleteByPrimaryKey(Long mtId) {
        int rows = marginTransDAO.deleteByPrimaryKey(mtId);
        return rows;
    }

    /**
     * 添加保证金转账记录【MarginTransDO】对象信息
     *
     * @mbggenerated Mon Mar 30 13:57:58 CST 2015
     */
    @Override
    public Long insert(MarginTransDO record) {
        Long id = marginTransDAO.insert(record);
        return record.getMtId();
    }

    /**
     * 添加保证金转账记录【MarginTransDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Mar 30 13:57:58 CST 2015
     */
    @Override
    public Long insertSelective(MarginTransDO record) {
        Long id = marginTransDAO.insertSelective(record);
        return record.getMtId();
    }

    /**
     * 根据Example对象查询得到保证金转账记录【MarginTransDO】对象列表信息
     *
     * @mbggenerated Mon Mar 30 13:57:58 CST 2015
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<MarginTransDO> selectByExample(MarginTransDOExample example) {
        List<MarginTransDO> list = marginTransDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询保证金转账记录【MarginTransDO】对象信息
     *
     * @mbggenerated Mon Mar 30 13:57:58 CST 2015
     */
    @Override
    public MarginTransDO selectByPrimaryKey(Long mtId) {
        MarginTransDO record = marginTransDAO.selectByPrimaryKey(mtId);
        return record;
    }

    
    /**
     * 根据Example对象更新保证金转账记录【MarginTransDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Mar 30 13:57:58 CST 2015
     */
    public int updateByExampleSelective(MarginTransDO record, MarginTransDOExample example){
    	 int rows = marginTransDAO.updateByExampleSelective(record, example);
    	 return rows;
    }

    /**
     * 根据Example对象更新保证金转账记录【MarginTransDO】对象信息
     *
     * @mbggenerated Mon Mar 30 13:57:58 CST 2015
     */
   public int updateByExample(MarginTransDO record, MarginTransDOExample example){
    	int rows = marginTransDAO.updateByExample(record, example);
    	return rows;
    }
    
    /**
     * 根据主键更新保证金转账记录【MarginTransDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Mar 30 13:57:58 CST 2015
     */
    @Override
    public int updateByPrimaryKeySelective(MarginTransDO record) {
        int rows = marginTransDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新保证金转账记录【MarginTransDO】对象信息
     *
     * @mbggenerated Mon Mar 30 13:57:58 CST 2015
     */
    @Override
    public int updateByPrimaryKey(MarginTransDO record) {
        int rows = marginTransDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询保证金转账记录【MarginTransDO】对象列表信息
     *
     * @mbggenerated Mon Mar 30 13:57:58 CST 2015
     */
    @Override
    public List<MarginTransDO> selectByQuery(MarginTransDOExample example) {
        Integer totalItem = (Integer)marginTransDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<MarginTransDO> returnList = new ArrayList<MarginTransDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<MarginTransDO> list =marginTransDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}