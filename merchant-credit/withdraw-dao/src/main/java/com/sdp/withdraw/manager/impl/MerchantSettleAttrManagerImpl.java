package com.sdp.withdraw.manager.impl;

import com.sdp.withdraw.dao.MerchantSettleAttrDO;
import com.sdp.withdraw.dao.MerchantSettleAttrDOExample;
import com.sdp.withdraw.dao.daointerface.MerchantSettleAttrDAO;
import com.sdp.withdraw.manager.MerchantSettleAttrManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("merchantSettleAttrManager")
public class MerchantSettleAttrManagerImpl implements MerchantSettleAttrManager {
    @Autowired
    private MerchantSettleAttrDAO merchantSettleAttrDAO;

    /**
     * 根据主键删除业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        int rows = merchantSettleAttrDAO.deleteByPrimaryKey(id);
        return rows;
    }

    /**
     * 添加业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    @Override
    public Long insert(MerchantSettleAttrDO record) {
        Long id = merchantSettleAttrDAO.insert(record);
        return record.getId();
    }

    /**
     * 添加业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    @Override
    public Long insertSelective(MerchantSettleAttrDO record) {
        Long id = merchantSettleAttrDAO.insertSelective(record);
        return record.getId();
    }

    /**
     * 根据Example对象查询得到业务首次开通时间配置信息【MerchantSettleAttrDO】对象列表信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<MerchantSettleAttrDO> selectByExample(MerchantSettleAttrDOExample example) {
        List<MerchantSettleAttrDO> list = merchantSettleAttrDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    @Override
    public MerchantSettleAttrDO selectByPrimaryKey(Long id) {
        MerchantSettleAttrDO record = merchantSettleAttrDAO.selectByPrimaryKey(id);
        return record;
    }

    /**
     * 根据主键更新业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    @Override
    public int updateByPrimaryKeySelective(MerchantSettleAttrDO record) {
        int rows = merchantSettleAttrDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    @Override
    public int updateByPrimaryKey(MerchantSettleAttrDO record) {
        int rows = merchantSettleAttrDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询业务首次开通时间配置信息【MerchantSettleAttrDO】对象列表信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    @Override
    public List<MerchantSettleAttrDO> selectByQuery(MerchantSettleAttrDOExample example) {
        Integer totalItem = (Integer)merchantSettleAttrDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<MerchantSettleAttrDO> returnList = new ArrayList<MerchantSettleAttrDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<MerchantSettleAttrDO> list =merchantSettleAttrDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}