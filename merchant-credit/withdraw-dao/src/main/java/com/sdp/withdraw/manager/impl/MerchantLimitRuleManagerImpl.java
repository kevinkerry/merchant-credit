package com.sdp.withdraw.manager.impl;

import com.sdp.withdraw.dao.MerchantLimitRuleDO;
import com.sdp.withdraw.dao.MerchantLimitRuleDOExample;
import com.sdp.withdraw.dao.daointerface.MerchantLimitRuleDAO;
import com.sdp.withdraw.manager.MerchantLimitRuleManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("merchantLimitRuleManager")
public class MerchantLimitRuleManagerImpl implements MerchantLimitRuleManager {
    @Autowired
    private MerchantLimitRuleDAO merchantLimitRuleDAO;

    /**
     * 根据主键删除null【MerchantLimitRuleDO】对象信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        int rows = merchantLimitRuleDAO.deleteByPrimaryKey(id);
        return rows;
    }

    /**
     * 添加null【MerchantLimitRuleDO】对象信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    @Override
    public Long insert(MerchantLimitRuleDO record) {
        Long id = merchantLimitRuleDAO.insert(record);
        return record.getId();
    }

    /**
     * 添加null【MerchantLimitRuleDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    @Override
    public Long insertSelective(MerchantLimitRuleDO record) {
        Long id = merchantLimitRuleDAO.insertSelective(record);
        return record.getId();
    }

    /**
     * 根据Example对象查询得到null【MerchantLimitRuleDO】对象列表信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<MerchantLimitRuleDO> selectByExample(MerchantLimitRuleDOExample example) {
        List<MerchantLimitRuleDO> list = merchantLimitRuleDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询null【MerchantLimitRuleDO】对象信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    @Override
    public MerchantLimitRuleDO selectByPrimaryKey(Long id) {
        MerchantLimitRuleDO record = merchantLimitRuleDAO.selectByPrimaryKey(id);
        return record;
    }

    /**
     * 根据主键更新null【MerchantLimitRuleDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    @Override
    public int updateByPrimaryKeySelective(MerchantLimitRuleDO record) {
        int rows = merchantLimitRuleDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新null【MerchantLimitRuleDO】对象信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    @Override
    public int updateByPrimaryKey(MerchantLimitRuleDO record) {
        int rows = merchantLimitRuleDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询null【MerchantLimitRuleDO】对象列表信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    @Override
    public List<MerchantLimitRuleDO> selectByQuery(MerchantLimitRuleDOExample example) {
        Integer totalItem = (Integer)merchantLimitRuleDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<MerchantLimitRuleDO> returnList = new ArrayList<MerchantLimitRuleDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<MerchantLimitRuleDO> list =merchantLimitRuleDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}