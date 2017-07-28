package com.sdp.withdraw.manager.impl;

import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.dao.PosMerchantInfoDOExample;
import com.sdp.withdraw.dao.daointerface.PosMerchantInfoDAO;
import com.sdp.withdraw.manager.PosMerchantInfoManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("posMerchantInfoManager")
public class PosMerchantInfoManagerImpl implements PosMerchantInfoManager {
    @Autowired
    private PosMerchantInfoDAO posMerchantInfoDAO;

    /**
     * 根据主键删除POS商户信息【PosMerchantInfoDO】对象信息
     *
     * @mbggenerated Wed Mar 30 10:08:16 CST 2016
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        int rows = posMerchantInfoDAO.deleteByPrimaryKey(id);
        return rows;
    }

    /**
     * 添加POS商户信息【PosMerchantInfoDO】对象信息
     *
     * @mbggenerated Wed Mar 30 10:08:16 CST 2016
     */
    @Override
    public Long insert(PosMerchantInfoDO record) {
        Long id = posMerchantInfoDAO.insert(record);
        return record.getId();
    }

    /**
     * 添加POS商户信息【PosMerchantInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Mar 30 10:08:16 CST 2016
     */
    @Override
    public Long insertSelective(PosMerchantInfoDO record) {
        Long id = posMerchantInfoDAO.insertSelective(record);
        return record.getId();
    }

    /**
     * 根据Example对象查询得到POS商户信息【PosMerchantInfoDO】对象列表信息
     *
     * @mbggenerated Wed Mar 30 10:08:16 CST 2016
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<PosMerchantInfoDO> selectByExample(PosMerchantInfoDOExample example) {
        List<PosMerchantInfoDO> list = posMerchantInfoDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询POS商户信息【PosMerchantInfoDO】对象信息
     *
     * @mbggenerated Wed Mar 30 10:08:16 CST 2016
     */
    @Override
    public PosMerchantInfoDO selectByPrimaryKey(Long id) {
        PosMerchantInfoDO record = posMerchantInfoDAO.selectByPrimaryKey(id);
        return record;
    }

    /**
     * 根据主键更新POS商户信息【PosMerchantInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Mar 30 10:08:16 CST 2016
     */
    @Override
    public int updateByPrimaryKeySelective(PosMerchantInfoDO record) {
        int rows = posMerchantInfoDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新POS商户信息【PosMerchantInfoDO】对象信息
     *
     * @mbggenerated Wed Mar 30 10:08:16 CST 2016
     */
    @Override
    public int updateByPrimaryKey(PosMerchantInfoDO record) {
        int rows = posMerchantInfoDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询POS商户信息【PosMerchantInfoDO】对象列表信息
     *
     * @mbggenerated Wed Mar 30 10:08:16 CST 2016
     */
    @Override
    public List<PosMerchantInfoDO> selectByQuery(PosMerchantInfoDOExample example) {
        Integer totalItem = (Integer)posMerchantInfoDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<PosMerchantInfoDO> returnList = new ArrayList<PosMerchantInfoDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<PosMerchantInfoDO> list =posMerchantInfoDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}