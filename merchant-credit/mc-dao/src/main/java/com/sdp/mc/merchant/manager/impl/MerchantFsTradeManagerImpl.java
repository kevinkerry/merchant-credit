package com.sdp.mc.merchant.manager.impl;

import com.sdp.mc.merchant.dao.MerchantFsTradeDO;
import com.sdp.mc.merchant.dao.MerchantFsTradeDOExample;
import com.sdp.mc.merchant.dao.daointerface.MerchantFsTradeDAO;
import com.sdp.mc.merchant.manager.MerchantFsTradeManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("merchantFsTradeManager")
public class MerchantFsTradeManagerImpl implements MerchantFsTradeManager {
	@Autowired
	private MerchantFsTradeDAO merchantFsTradeDAO;

	/**
	 * 根据主键删除null【MerchantFsTradeDO】对象信息
	 * 
	 * @mbggenerated Wed Apr 15 20:57:54 CST 2015
	 */
	@Override
	public int deleteByPrimaryKey(Long mftId) {
		int rows = merchantFsTradeDAO.deleteByPrimaryKey(mftId);
		return rows;
	}

	/**
	 * 添加null【MerchantFsTradeDO】对象信息
	 * 
	 * @mbggenerated Wed Apr 15 20:57:54 CST 2015
	 */
	@Override
	public Long insert(MerchantFsTradeDO record) {
		Long id = merchantFsTradeDAO.insert(record);
		return record.getMftId();
	}

	/**
	 * 添加null【MerchantFsTradeDO】对象信息,空值字段不插入
	 * 
	 * @mbggenerated Wed Apr 15 20:57:54 CST 2015
	 */
	@Override
	public Long insertSelective(MerchantFsTradeDO record) {
		Long id = merchantFsTradeDAO.insertSelective(record);
		return record.getMftId();
	}

	/**
	 * 根据Example对象查询得到null【MerchantFsTradeDO】对象列表信息
	 * 
	 * @mbggenerated Wed Apr 15 20:57:54 CST 2015
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MerchantFsTradeDO> selectByExample(MerchantFsTradeDOExample example) {
		List<MerchantFsTradeDO> list = merchantFsTradeDAO.selectByExample(example);
		return list;
	}

	/**
	 * 根据主键查询null【MerchantFsTradeDO】对象信息
	 * 
	 * @mbggenerated Wed Apr 15 20:57:54 CST 2015
	 */
	@Override
	public MerchantFsTradeDO selectByPrimaryKey(Long mftId) {
		MerchantFsTradeDO record = merchantFsTradeDAO.selectByPrimaryKey(mftId);
		return record;
	}

	/**
	 * 根据主键更新null【MerchantFsTradeDO】对象信息，仅更新非空对象
	 * 
	 * @mbggenerated Wed Apr 15 20:57:54 CST 2015
	 */
	@Override
	public int updateByPrimaryKeySelective(MerchantFsTradeDO record) {
		int rows = merchantFsTradeDAO.updateByPrimaryKeySelective(record);
		return rows;
	}

	/**
	 * 根据主键更新null【MerchantFsTradeDO】对象信息
	 * 
	 * @mbggenerated Wed Apr 15 20:57:54 CST 2015
	 */
	@Override
	public int updateByPrimaryKey(MerchantFsTradeDO record) {
		int rows = merchantFsTradeDAO.updateByPrimaryKey(record);
		return rows;
	}

	/**
	 * 根据Query对象分页查询null【MerchantFsTradeDO】对象列表信息
	 * 
	 * @mbggenerated Wed Apr 15 20:57:54 CST 2015
	 */
	@Override
	public List<MerchantFsTradeDO> selectByQuery(MerchantFsTradeDOExample example) {
		Integer totalItem = (Integer) merchantFsTradeDAO.countByExample(example);

		example.setTotalItem(totalItem);

		if (example.isNeedQueryAll() && totalItem > 0) {
			example.setPageSize(totalItem);
		}
		List<MerchantFsTradeDO> returnList = new ArrayList<MerchantFsTradeDO>();
		if (example.getPageFristItem() <= example.getTotalItem()) {

			List<MerchantFsTradeDO> list = merchantFsTradeDAO.selectByQuery(example);
			returnList.addAll(list);
		}
		return returnList;
	}
}