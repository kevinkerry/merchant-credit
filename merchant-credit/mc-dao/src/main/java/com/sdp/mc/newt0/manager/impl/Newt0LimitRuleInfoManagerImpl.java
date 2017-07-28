package com.sdp.mc.newt0.manager.impl;

import com.sdp.mc.newt0.dao.Newt0LimitRuleInfoDO;
import com.sdp.mc.newt0.dao.Newt0LimitRuleInfoDOExample;
import com.sdp.mc.newt0.dao.daointerface.Newt0LimitRuleInfoDAO;
import com.sdp.mc.newt0.manager.Newt0LimitRuleInfoManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("newt0LimitRuleInfoManager")
public class Newt0LimitRuleInfoManagerImpl implements Newt0LimitRuleInfoManager {
    @Autowired
    private Newt0LimitRuleInfoDAO newt0LimitRuleInfoDAO;

    /**
     * 根据主键删除商户额度规则信息【Newt0LimitRuleInfoDO】对象信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        int rows = newt0LimitRuleInfoDAO.deleteByPrimaryKey(id);
        return rows;
    }

    /**
     * 添加商户额度规则信息【Newt0LimitRuleInfoDO】对象信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    @Override
    public Long insert(Newt0LimitRuleInfoDO record) {
        Long id = newt0LimitRuleInfoDAO.insert(record);
        return record.getId();
    }

    /**
     * 添加商户额度规则信息【Newt0LimitRuleInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    @Override
    public Long insertSelective(Newt0LimitRuleInfoDO record) {
        Long id = newt0LimitRuleInfoDAO.insertSelective(record);
        return record.getId();
    }

    /**
     * 根据Example对象查询得到商户额度规则信息【Newt0LimitRuleInfoDO】对象列表信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Newt0LimitRuleInfoDO> selectByExample(Newt0LimitRuleInfoDOExample example) {
        List<Newt0LimitRuleInfoDO> list = newt0LimitRuleInfoDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询商户额度规则信息【Newt0LimitRuleInfoDO】对象信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    @Override
    public Newt0LimitRuleInfoDO selectByPrimaryKey(Long id) {
        Newt0LimitRuleInfoDO record = newt0LimitRuleInfoDAO.selectByPrimaryKey(id);
        return record;
    }

    /**
     * 根据主键更新商户额度规则信息【Newt0LimitRuleInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    @Override
    public int updateByPrimaryKeySelective(Newt0LimitRuleInfoDO record) {
        int rows = newt0LimitRuleInfoDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新商户额度规则信息【Newt0LimitRuleInfoDO】对象信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    @Override
    public int updateByPrimaryKey(Newt0LimitRuleInfoDO record) {
        int rows = newt0LimitRuleInfoDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询商户额度规则信息【Newt0LimitRuleInfoDO】对象列表信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    @Override
    public List<Newt0LimitRuleInfoDO> selectByQuery(Newt0LimitRuleInfoDOExample example) {
        Integer totalItem = (Integer)newt0LimitRuleInfoDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<Newt0LimitRuleInfoDO> returnList = new ArrayList<Newt0LimitRuleInfoDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<Newt0LimitRuleInfoDO> list =newt0LimitRuleInfoDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}