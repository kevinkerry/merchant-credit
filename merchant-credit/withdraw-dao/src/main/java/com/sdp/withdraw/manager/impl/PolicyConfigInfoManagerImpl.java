package com.sdp.withdraw.manager.impl;

import com.sdp.withdraw.dao.PolicyConfigInfoDO;
import com.sdp.withdraw.dao.PolicyConfigInfoDOExample;
import com.sdp.withdraw.dao.daointerface.PolicyConfigInfoDAO;
import com.sdp.withdraw.manager.PolicyConfigInfoManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("policyConfigInfoManager")
public class PolicyConfigInfoManagerImpl implements PolicyConfigInfoManager {
    @Autowired
    private PolicyConfigInfoDAO policyConfigInfoDAO;

    /**
     * 根据主键删除政策配置信息【PolicyConfigInfoDO】对象信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        int rows = policyConfigInfoDAO.deleteByPrimaryKey(id);
        return rows;
    }

    /**
     * 添加政策配置信息【PolicyConfigInfoDO】对象信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    @Override
    public Long insert(PolicyConfigInfoDO record) {
        Long id = policyConfigInfoDAO.insert(record);
        return record.getId();
    }

    /**
     * 添加政策配置信息【PolicyConfigInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    @Override
    public Long insertSelective(PolicyConfigInfoDO record) {
        Long id = policyConfigInfoDAO.insertSelective(record);
        return record.getId();
    }

    /**
     * 根据Example对象查询得到政策配置信息【PolicyConfigInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<PolicyConfigInfoDO> selectByExample(PolicyConfigInfoDOExample example) {
        List<PolicyConfigInfoDO> list = policyConfigInfoDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询政策配置信息【PolicyConfigInfoDO】对象信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    @Override
    public PolicyConfigInfoDO selectByPrimaryKey(Long id) {
        PolicyConfigInfoDO record = policyConfigInfoDAO.selectByPrimaryKey(id);
        return record;
    }

    /**
     * 根据主键更新政策配置信息【PolicyConfigInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    @Override
    public int updateByPrimaryKeySelective(PolicyConfigInfoDO record) {
        int rows = policyConfigInfoDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新政策配置信息【PolicyConfigInfoDO】对象信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    @Override
    public int updateByPrimaryKey(PolicyConfigInfoDO record) {
        int rows = policyConfigInfoDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询政策配置信息【PolicyConfigInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    @Override
    public List<PolicyConfigInfoDO> selectByQuery(PolicyConfigInfoDOExample example) {
        Integer totalItem = (Integer)policyConfigInfoDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<PolicyConfigInfoDO> returnList = new ArrayList<PolicyConfigInfoDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<PolicyConfigInfoDO> list =policyConfigInfoDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}