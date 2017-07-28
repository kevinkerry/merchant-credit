package com.sdp.mc.newt0.manager.impl;

import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDO;
import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDOExample;
import com.sdp.mc.newt0.dao.daointerface.Newt0SdpRemainBalanceDAO;
import com.sdp.mc.newt0.manager.Newt0SdpRemainBalanceManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("newt0SdpRemainBalanceManager")
public class Newt0SdpRemainBalanceManagerImpl implements Newt0SdpRemainBalanceManager {
    @Autowired
    private Newt0SdpRemainBalanceDAO newt0SdpRemainBalanceDAO;

    /**
     * 添加null【Newt0SdpRemainBalanceDO】对象信息
     *
     * @mbggenerated Thu Sep 17 14:47:15 CST 2015
     */
    @Override
    public Long insert(Newt0SdpRemainBalanceDO record) {
        Long id = newt0SdpRemainBalanceDAO.insert(record);
        return record.getId();
    }

    /**
     * 添加null【Newt0SdpRemainBalanceDO】对象信息,空值字段不插入
     *
     * @mbggenerated Thu Sep 17 14:47:15 CST 2015
     */
    @Override
    public Long insertSelective(Newt0SdpRemainBalanceDO record) {
        Long id = newt0SdpRemainBalanceDAO.insertSelective(record);
        return record.getId();
    }

    /**
     * 根据Example对象查询得到null【Newt0SdpRemainBalanceDO】对象列表信息
     *
     * @mbggenerated Thu Sep 17 14:47:15 CST 2015
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Newt0SdpRemainBalanceDO> selectByExample(Newt0SdpRemainBalanceDOExample example) {
        List<Newt0SdpRemainBalanceDO> list = newt0SdpRemainBalanceDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据Query对象分页查询null【Newt0SdpRemainBalanceDO】对象列表信息
     *
     * @mbggenerated Thu Sep 17 14:47:15 CST 2015
     */
    @Override
    public List<Newt0SdpRemainBalanceDO> selectByQuery(Newt0SdpRemainBalanceDOExample example) {
        Integer totalItem = (Integer)newt0SdpRemainBalanceDAO.countByExample(example);

        example.setTotalItem(totalItem);

        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<Newt0SdpRemainBalanceDO> returnList = new ArrayList<Newt0SdpRemainBalanceDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {

            List<Newt0SdpRemainBalanceDO> list =newt0SdpRemainBalanceDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }

	@Override
	public int updateByPrimaryKey(Newt0SdpRemainBalanceDO record) {
		// TODO Auto-generated method stub
		return newt0SdpRemainBalanceDAO.updateByPrimaryKey(record);
		
	}
	
	public int updateByPrimaryKeySelective(Newt0SdpRemainBalanceDO record) {
		// TODO Auto-generated method stub
		return newt0SdpRemainBalanceDAO.updateByPrimaryKeySelective(record);
		
	}
	
}