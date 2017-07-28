package com.sdp.mc.newt0.manager.impl;

import com.sdp.mc.newt0.dao.Newt0LoaningConfigDO;
import com.sdp.mc.newt0.dao.Newt0LoaningConfigDOExample;
import com.sdp.mc.newt0.dao.daointerface.Newt0LoaningConfigDAO;
import com.sdp.mc.newt0.manager.Newt0LoaningConfigManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("newt0LoaningConfigManager")
public class Newt0LoaningConfigManagerImpl implements Newt0LoaningConfigManager {
    @Autowired
    private Newt0LoaningConfigDAO newt0LoaningConfigDAO;

    /**
     * 根据主键删除null【Newt0LoaningConfigDO】对象信息
     *
     * @mbggenerated Thu Sep 17 14:25:02 CST 2015
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        int rows = newt0LoaningConfigDAO.deleteByPrimaryKey(id);
        return rows;
    }

    /**
     * 添加null【Newt0LoaningConfigDO】对象信息
     *
     * @mbggenerated Thu Sep 17 14:25:02 CST 2015
     */
    @Override
    public Long insert(Newt0LoaningConfigDO record) {
        Long id = newt0LoaningConfigDAO.insert(record);
        return record.getId();
    }

    /**
     * 添加null【Newt0LoaningConfigDO】对象信息,空值字段不插入
     *
     * @mbggenerated Thu Sep 17 14:25:02 CST 2015
     */
    @Override
    public Long insertSelective(Newt0LoaningConfigDO record) {
        Long id = newt0LoaningConfigDAO.insertSelective(record);
        return record.getId();
    }

    /**
     * 根据Example对象查询得到null【Newt0LoaningConfigDO】对象列表信息
     *
     * @mbggenerated Thu Sep 17 14:25:02 CST 2015
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Newt0LoaningConfigDO> selectByExample(Newt0LoaningConfigDOExample example) {
        List<Newt0LoaningConfigDO> list = newt0LoaningConfigDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询null【Newt0LoaningConfigDO】对象信息
     *
     * @mbggenerated Thu Sep 17 14:25:02 CST 2015
     */
    @Override
    public Newt0LoaningConfigDO selectByPrimaryKey(Long id) {
        Newt0LoaningConfigDO record = newt0LoaningConfigDAO.selectByPrimaryKey(id);
        return record;
    }

    /**
     * 根据主键更新null【Newt0LoaningConfigDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Thu Sep 17 14:25:02 CST 2015
     */
    @Override
    public int updateByPrimaryKeySelective(Newt0LoaningConfigDO record) {
        int rows = newt0LoaningConfigDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新null【Newt0LoaningConfigDO】对象信息
     *
     * @mbggenerated Thu Sep 17 14:25:02 CST 2015
     */
    @Override
    public int updateByPrimaryKey(Newt0LoaningConfigDO record) {
        int rows = newt0LoaningConfigDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询null【Newt0LoaningConfigDO】对象列表信息
     *
     * @mbggenerated Thu Sep 17 14:25:02 CST 2015
     */
    @Override
    public List<Newt0LoaningConfigDO> selectByQuery(Newt0LoaningConfigDOExample example) {
        Integer totalItem = (Integer)newt0LoaningConfigDAO.countByExample(example);

        example.setTotalItem(totalItem);

        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<Newt0LoaningConfigDO> returnList = new ArrayList<Newt0LoaningConfigDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {

            List<Newt0LoaningConfigDO> list =newt0LoaningConfigDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}