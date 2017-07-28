package com.sdp.mc.merchant.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.merchant.dao.MerchantFsReq;
import com.sdp.mc.merchant.dao.MerchantFsReqExample;
import com.sdp.mc.merchant.dao.daointerface.MerchantFsRDAO;
import com.sdp.mc.merchant.manager.MerchantFsRManager;

@Service("merchantFsRManager")
public class MerchantFsRManagerImpl implements MerchantFsRManager {
    @Autowired
    private MerchantFsRDAO merchantFsRDAO;

    /**
     * 根据主键删除商户快速结算申请记录【MerchantFsReq】对象信息
     *
     * @mbggenerated Tue Dec 15 15:47:17 CST 2015
     */
    @Override
    public int deleteByPrimaryKey(Long mfqId) {
        int rows = merchantFsRDAO.deleteByPrimaryKey(mfqId);
        return rows;
    }

    /**
     * 添加商户快速结算申请记录【MerchantFsReq】对象信息
     *
     * @mbggenerated Tue Dec 15 15:47:17 CST 2015
     */
    @Override
    public Long insert(MerchantFsReq record) {
        Long id = merchantFsRDAO.insert(record);
        return record.getMfqId();
    }

    /**
     * 添加商户快速结算申请记录【MerchantFsReq】对象信息,空值字段不插入
     *
     * @mbggenerated Tue Dec 15 15:47:17 CST 2015
     */
    @Override
    public Long insertSelective(MerchantFsReq record) {
        Long id = merchantFsRDAO.insertSelective(record);
        return record.getMfqId();
    }

    /**
     * 根据Example对象查询得到商户快速结算申请记录【MerchantFsReq】对象列表信息
     *
     * @mbggenerated Tue Dec 15 15:47:17 CST 2015
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<MerchantFsReq> selectByExample(MerchantFsReqExample example) {
        List<MerchantFsReq> list = merchantFsRDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询商户快速结算申请记录【MerchantFsReq】对象信息
     *
     * @mbggenerated Tue Dec 15 15:47:17 CST 2015
     */
    @Override
    public MerchantFsReq selectByPrimaryKey(Long mfqId) {
        MerchantFsReq record = merchantFsRDAO.selectByPrimaryKey(mfqId);
        return record;
    }

    /**
     * 根据主键更新商户快速结算申请记录【MerchantFsReq】对象信息，仅更新非空对象
     *
     * @mbggenerated Tue Dec 15 15:47:17 CST 2015
     */
    @Override
    public int updateByPrimaryKeySelective(MerchantFsReq record) {
        int rows = merchantFsRDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新商户快速结算申请记录【MerchantFsReq】对象信息
     *
     * @mbggenerated Tue Dec 15 15:47:17 CST 2015
     */
    @Override
    public int updateByPrimaryKey(MerchantFsReq record) {
        int rows = merchantFsRDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询商户快速结算申请记录【MerchantFsReq】对象列表信息
     *
     * @mbggenerated Tue Dec 15 15:47:17 CST 2015
     */
    @Override
    public List<MerchantFsReq> selectByQuery(MerchantFsReqExample example) {
        Integer totalItem = (Integer)merchantFsRDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<MerchantFsReq> returnList = new ArrayList<MerchantFsReq>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
            List<MerchantFsReq> list =merchantFsRDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
    
    public int updateByExampleSelective(MerchantFsReq record, MerchantFsReqExample example) {
		return this.merchantFsRDAO.updateByExampleSelective(record, example);
	}
}