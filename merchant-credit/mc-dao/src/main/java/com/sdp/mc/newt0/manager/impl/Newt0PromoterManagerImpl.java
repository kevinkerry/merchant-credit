package com.sdp.mc.newt0.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.newt0.dao.Newt0PromoterDO;
import com.sdp.mc.newt0.dao.Newt0PromoterDOExample;
import com.sdp.mc.newt0.dao.daointerface.Newt0PromoterDAO;
import com.sdp.mc.newt0.manager.Newt0PromoterManager;

@Service("newt0PromoterManager")
public class Newt0PromoterManagerImpl implements Newt0PromoterManager {
	@Autowired
	private Newt0PromoterDAO newt0PromoterDAO;

	/**
	 * 根据主键删除null【Newt0PromoterDO】对象信息
	 * 
	 * @mbggenerated Thu Sep 17 19:19:28 CST 2015
	 */
	@Override
	public int deleteByPrimaryKey(Long id) {
		int rows = newt0PromoterDAO.deleteByPrimaryKey(id);
		return rows;
	}

	/**
	 * 添加null【Newt0PromoterDO】对象信息
	 * 
	 * @mbggenerated Thu Sep 17 19:19:28 CST 2015
	 */
	@Override
	public Long insert(Newt0PromoterDO record) {
		Long id = newt0PromoterDAO.insert(record);
		return record.getId();
	}

	/**
	 * 添加null【Newt0PromoterDO】对象信息,空值字段不插入
	 * 
	 * @mbggenerated Thu Sep 17 19:19:28 CST 2015
	 */
	@Override
	public Long insertSelective(Newt0PromoterDO record) {
		Long id = newt0PromoterDAO.insertSelective(record);
		return record.getId();
	}

	/**
	 * 根据Example对象查询得到null【Newt0PromoterDO】对象列表信息
	 * 
	 * @mbggenerated Thu Sep 17 19:19:28 CST 2015
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Newt0PromoterDO> selectByExample(Newt0PromoterDOExample example) {
		List<Newt0PromoterDO> list = newt0PromoterDAO.selectByExample(example);
		return list;
	}

	/**
	 * 根据主键查询null【Newt0PromoterDO】对象信息
	 * 
	 * @mbggenerated Thu Sep 17 19:19:28 CST 2015
	 */
	@Override
	public Newt0PromoterDO selectByPrimaryKey(Long id) {
		Newt0PromoterDO record = newt0PromoterDAO.selectByPrimaryKey(id);
		return record;
	}

	/**
	 * 根据主键更新null【Newt0PromoterDO】对象信息，仅更新非空对象
	 * 
	 * @mbggenerated Thu Sep 17 19:19:28 CST 2015
	 */
	@Override
	public int updateByPrimaryKeySelective(Newt0PromoterDO record) {
		int rows = newt0PromoterDAO.updateByPrimaryKeySelective(record);
		return rows;
	}

	/**
	 * 根据主键更新null【Newt0PromoterDO】对象信息
	 * 
	 * @mbggenerated Thu Sep 17 19:19:28 CST 2015
	 */
	@Override
	public int updateByPrimaryKey(Newt0PromoterDO record) {
		int rows = newt0PromoterDAO.updateByPrimaryKey(record);
		return rows;
	}

	/**
	 * 根据Query对象分页查询null【Newt0PromoterDO】对象列表信息
	 * 
	 * @mbggenerated Thu Sep 17 19:19:28 CST 2015
	 */
	@Override
	public List<Newt0PromoterDO> selectByQuery(Newt0PromoterDOExample example) {
		Integer totalItem = (Integer) newt0PromoterDAO.countByExample(example);

		example.setTotalItem(totalItem);

		if (example.isNeedQueryAll() && totalItem > 0) {
			example.setPageSize(totalItem);
		}
		List<Newt0PromoterDO> returnList = new ArrayList<Newt0PromoterDO>();
		if (example.getPageFristItem() <= example.getTotalItem()) {

			List<Newt0PromoterDO> list = newt0PromoterDAO.selectByQuery(example);
			returnList.addAll(list);
		}
		return returnList;
	}

	@Override
	public Newt0PromoterDO getPromoterByMerchantId(Long promoterId) {
		Newt0PromoterDOExample example = new Newt0PromoterDOExample();
		example.createCriteria().andPromoterIdEqualTo(promoterId);
		List<Newt0PromoterDO> list = newt0PromoterDAO.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public int updateByExampleSelective(Newt0PromoterDO record, Newt0PromoterDOExample example) {
		return newt0PromoterDAO.updateByExampleSelective(record, example);
	}

	@Override
	public int deleteByExample(Newt0PromoterDOExample example) {
		return newt0PromoterDAO.deleteByExample(example);
	}
}