package com.sdp.mc.ffconfig.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.ffconfig.dao.FastSettleConfigDO;
import com.sdp.mc.ffconfig.dao.FastSettleConfigDOExample;
import com.sdp.mc.ffconfig.dao.daointerface.FastSettleConfigDAO;
import com.sdp.mc.ffconfig.dao.ext.FastSettleConfigDOExampleExt;
import com.sdp.mc.ffconfig.dao.ext.FastSettleConfigDOExt;
import com.sdp.mc.ffconfig.manager.FastSettleConfigManager;

@Service("fastSettleConfigManager")
public class FastSettleConfigManagerImpl implements FastSettleConfigManager {
	@Autowired
	private FastSettleConfigDAO fastSettleConfigDAO;

	/**
	 * 根据主键删除null【FastSettleConfigDO】对象信息
	 * 
	 * @mbggenerated Fri Sep 18 14:49:52 CST 2015
	 */
	@Override
	public int deleteByPrimaryKey(Long pfcId) {
		int rows = fastSettleConfigDAO.deleteByPrimaryKey(pfcId);
		return rows;
	}

	/**
	 * 添加null【FastSettleConfigDO】对象信息
	 * 
	 * @mbggenerated Fri Sep 18 14:49:52 CST 2015
	 */
	@Override
	public Long insert(FastSettleConfigDO record) {
		Long id = fastSettleConfigDAO.insert(record);
		return record.getPfcId();
	}

	/**
	 * 添加null【FastSettleConfigDO】对象信息,空值字段不插入
	 * 
	 * @mbggenerated Fri Sep 18 14:49:52 CST 2015
	 */
	@Override
	public Long insertSelective(FastSettleConfigDO record) {
		Long id = fastSettleConfigDAO.insertSelective(record);
		return record.getPfcId();
	}

	/**
	 * 根据Example对象查询得到null【FastSettleConfigDO】对象列表信息
	 * 
	 * @mbggenerated Fri Sep 18 14:49:52 CST 2015
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<FastSettleConfigDO> selectByExample(FastSettleConfigDOExample example) {
		List<FastSettleConfigDO> list = fastSettleConfigDAO.selectByExample(example);
		return list;
	}

	/**
	 * 根据主键查询null【FastSettleConfigDO】对象信息
	 * 
	 * @mbggenerated Fri Sep 18 14:49:52 CST 2015
	 */
	@Override
	public FastSettleConfigDO selectByPrimaryKey(Long pfcId) {
		FastSettleConfigDO record = fastSettleConfigDAO.selectByPrimaryKey(pfcId);
		return record;
	}

	/**
	 * 根据主键更新null【FastSettleConfigDO】对象信息，仅更新非空对象
	 * 
	 * @mbggenerated Fri Sep 18 14:49:52 CST 2015
	 */
	@Override
	public int updateByPrimaryKeySelective(FastSettleConfigDO record) {
		int rows = fastSettleConfigDAO.updateByPrimaryKeySelective(record);
		return rows;
	}

	/**
	 * 根据主键更新null【FastSettleConfigDO】对象信息
	 * 
	 * @mbggenerated Fri Sep 18 14:49:52 CST 2015
	 */
	@Override
	public int updateByPrimaryKey(FastSettleConfigDO record) {
		int rows = fastSettleConfigDAO.updateByPrimaryKey(record);
		return rows;
	}

	/**
	 * 根据Query对象分页查询null【FastSettleConfigDO】对象列表信息
	 * 
	 * @mbggenerated Fri Sep 18 14:49:52 CST 2015
	 */
	@Override
	public List<FastSettleConfigDO> selectByQuery(FastSettleConfigDOExample example) {
		Integer totalItem = (Integer) fastSettleConfigDAO.countByExample(example);

		example.setTotalItem(totalItem);

		if (example.isNeedQueryAll() && totalItem > 0) {
			example.setPageSize(totalItem);
		}
		List<FastSettleConfigDO> returnList = new ArrayList<FastSettleConfigDO>();
		if (example.getPageFristItem() <= example.getTotalItem()) {

			List<FastSettleConfigDO> list = fastSettleConfigDAO.selectByQuery(example);
			returnList.addAll(list);
		}
		return returnList;
	}

	@Override
	public List<FastSettleConfigDOExt> selectByQuery4Intra(FastSettleConfigDOExampleExt example) {
		Integer totalItem = (Integer) fastSettleConfigDAO.countByExample4Intra(example);

		example.setTotalItem(totalItem);

		if (example.isNeedQueryAll() && totalItem > 0) {
			example.setPageSize(totalItem);
		}
		List<FastSettleConfigDOExt> returnList = new ArrayList<FastSettleConfigDOExt>();
		if (example.getPageFristItem() > example.getTotalItem()) {
			example.setCurrentPage(1);
		}
		List<FastSettleConfigDOExt> list = fastSettleConfigDAO.selectByQuery4Intra(example);
		returnList.addAll(list);
		return returnList;
	}

	@Override
	public int updateByExampleSelective(FastSettleConfigDO record, FastSettleConfigDOExample example) {
		return this.fastSettleConfigDAO.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByPromoterId(Long promoterId) {
		return fastSettleConfigDAO.updateByPromoterId(promoterId);
	}
}