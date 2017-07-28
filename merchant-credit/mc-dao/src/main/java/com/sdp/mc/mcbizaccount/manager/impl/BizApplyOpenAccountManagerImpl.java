package com.sdp.mc.mcbizaccount.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.mcbizaccount.dao.BizApplyOpenAccountDO;
import com.sdp.mc.mcbizaccount.dao.BizApplyOpenAccountDOExample;
import com.sdp.mc.mcbizaccount.dao.daointerface.BizApplyOpenAccountDAO;
import com.sdp.mc.mcbizaccount.manager.BizApplyOpenAccountManager;

@Service("bizApplyOpenAccountManager")
public class BizApplyOpenAccountManagerImpl implements BizApplyOpenAccountManager {
    @Autowired
    private BizApplyOpenAccountDAO bizApplyOpenAccountDAO;

    /**
     * 根据主键删除代理商快速结算 开通/关闭【BizApplyOpenAccountDO】对象信息
     *
     * @mbggenerated Mon Jun 01 12:21:16 CST 2015
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        int rows = bizApplyOpenAccountDAO.deleteByPrimaryKey(id);
        return rows;
    }

    /**
     * 添加代理商快速结算 开通/关闭【BizApplyOpenAccountDO】对象信息
     *
     * @mbggenerated Mon Jun 01 12:21:16 CST 2015
     */
    @Override
    public Long insert(BizApplyOpenAccountDO record) {
        Long id = bizApplyOpenAccountDAO.insert(record);
        return record.getId();
    }

    /**
     * 添加代理商快速结算 开通/关闭【BizApplyOpenAccountDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Jun 01 12:21:16 CST 2015
     */
    @Override
    public Long insertSelective(BizApplyOpenAccountDO record) {
        Long id = bizApplyOpenAccountDAO.insertSelective(record);
        return record.getId();
    }

    /**
     * 根据Example对象查询得到代理商快速结算 开通/关闭【BizApplyOpenAccountDO】对象列表信息
     *
     * @mbggenerated Mon Jun 01 12:21:16 CST 2015
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<BizApplyOpenAccountDO> selectByExample(BizApplyOpenAccountDOExample example) {
        List<BizApplyOpenAccountDO> list = bizApplyOpenAccountDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询代理商快速结算 开通/关闭【BizApplyOpenAccountDO】对象信息
     *
     * @mbggenerated Mon Jun 01 12:21:16 CST 2015
     */
    @Override
    public BizApplyOpenAccountDO selectByPrimaryKey(Long id) {
        BizApplyOpenAccountDO record = bizApplyOpenAccountDAO.selectByPrimaryKey(id);
        return record;
    }

    /**
     * 根据主键更新代理商快速结算 开通/关闭【BizApplyOpenAccountDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Jun 01 12:21:16 CST 2015
     */
    @Override
    public int updateByPrimaryKeySelective(BizApplyOpenAccountDO record) {
        int rows = bizApplyOpenAccountDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新代理商快速结算 开通/关闭【BizApplyOpenAccountDO】对象信息
     *
     * @mbggenerated Mon Jun 01 12:21:16 CST 2015
     */
    @Override
    public int updateByPrimaryKey(BizApplyOpenAccountDO record) {
        int rows = bizApplyOpenAccountDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询代理商快速结算 开通/关闭【BizApplyOpenAccountDO】对象列表信息
     *
     * @mbggenerated Mon Jun 01 12:21:16 CST 2015
     */
    @Override
    public List<BizApplyOpenAccountDO> selectByQuery(BizApplyOpenAccountDOExample example) {
        Integer totalItem = (Integer)bizApplyOpenAccountDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<BizApplyOpenAccountDO> returnList = new ArrayList<BizApplyOpenAccountDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<BizApplyOpenAccountDO> list =bizApplyOpenAccountDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }

    public int updateByExample(BizApplyOpenAccountDO record,BizApplyOpenAccountDOExample example){
    	return this.bizApplyOpenAccountDAO.updateByExample(record, example);
    }
    
	public BizApplyOpenAccountDO getByPromoterIdAndAccountType(Long promoterId, AccountType accountType) {
		BizApplyOpenAccountDOExample example = new BizApplyOpenAccountDOExample();
		BizApplyOpenAccountDOExample.Criteria criteria = example.createCriteria();
		criteria.andPromoterIdEqualTo(promoterId);
		criteria.andAccountTypeEqualTo(accountType.code);
		List<BizApplyOpenAccountDO> list = bizApplyOpenAccountDAO.selectByExample(example);
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	public int updateByExampleSelective(BizApplyOpenAccountDO record, BizApplyOpenAccountDOExample example) {
		return this.bizApplyOpenAccountDAO.updateByExampleSelective(record, example);
	}
}