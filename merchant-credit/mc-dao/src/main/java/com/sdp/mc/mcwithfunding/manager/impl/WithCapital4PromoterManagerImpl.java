package com.sdp.mc.mcwithfunding.manager.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.mcwithfunding.dao.WithCapital4PromoterDO;
import com.sdp.mc.mcwithfunding.dao.WithCapital4PromoterDOExample;
import com.sdp.mc.mcwithfunding.dao.daointerface.WithCapital4PromoterDAO;
import com.sdp.mc.mcwithfunding.dao.ext.WithCapitalReqDOExampleExt;
import com.sdp.mc.mcwithfunding.manager.WithCapital4PromoterManager;

@Service("withCapital4PromoterManager")
public class WithCapital4PromoterManagerImpl implements WithCapital4PromoterManager {
	@Autowired
	private WithCapital4PromoterDAO withCapital4PromoterDAO;

	/**
	 * 根据主键删除代理商配资记录表【WithCapital4PromoterDO】对象信息
	 *
	 * @mbggenerated Mon Jun 08 14:31:48 CST 2015
	 */
	@Override
	public int deleteByPrimaryKey(Long id) {
		int rows = withCapital4PromoterDAO.deleteByPrimaryKey(id);
		return rows;
	}

	/**
	 * 添加代理商配资记录表【WithCapital4PromoterDO】对象信息
	 *
	 * @mbggenerated Mon Jun 08 14:31:48 CST 2015
	 */
	@Override
	public Long insert(WithCapital4PromoterDO record) {
		Long id = withCapital4PromoterDAO.insert(record);
		return record.getId();
	}

	/**
	 * 添加代理商配资记录表【WithCapital4PromoterDO】对象信息,空值字段不插入
	 *
	 * @mbggenerated Mon Jun 08 14:31:48 CST 2015
	 */
	@Override
	public Long insertSelective(WithCapital4PromoterDO record) {
		Long id = withCapital4PromoterDAO.insertSelective(record);
		return record.getId();
	}

	/**
	 * 根据Example对象查询得到代理商配资记录表【WithCapital4PromoterDO】对象列表信息
	 *
	 * @mbggenerated Mon Jun 08 14:31:48 CST 2015
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<WithCapital4PromoterDO> selectByExample(WithCapital4PromoterDOExample example) {
		List<WithCapital4PromoterDO> list = withCapital4PromoterDAO.selectByExample(example);
		return list;
	}

	/**
	 * 根据主键查询代理商配资记录表【WithCapital4PromoterDO】对象信息
	 *
	 * @mbggenerated Mon Jun 08 14:31:48 CST 2015
	 */
	@Override
	public WithCapital4PromoterDO selectByPrimaryKey(Long id) {
		WithCapital4PromoterDO record = withCapital4PromoterDAO.selectByPrimaryKey(id);
		return record;
	}

	/**
	 * 根据主键更新代理商配资记录表【WithCapital4PromoterDO】对象信息，仅更新非空对象
	 *
	 * @mbggenerated Mon Jun 08 14:31:48 CST 2015
	 */
	@Override
	public int updateByPrimaryKeySelective(WithCapital4PromoterDO record) {
		int rows = withCapital4PromoterDAO.updateByPrimaryKeySelective(record);
		return rows;
	}

	/**
	 * 根据主键更新代理商配资记录表【WithCapital4PromoterDO】对象信息
	 *
	 * @mbggenerated Mon Jun 08 14:31:48 CST 2015
	 */
	@Override
	public int updateByPrimaryKey(WithCapital4PromoterDO record) {
		int rows = withCapital4PromoterDAO.updateByPrimaryKey(record);
		return rows;
	}

	/**
	 * 根据Query对象分页查询代理商配资记录表【WithCapital4PromoterDO】对象列表信息
	 *
	 * @mbggenerated Mon Jun 08 14:31:48 CST 2015
	 */
	@Override
	public List<WithCapital4PromoterDO> selectByQuery(WithCapital4PromoterDOExample example) {
		Integer totalItem = (Integer) withCapital4PromoterDAO.countByExample(example);

		example.setTotalItem(totalItem);

		if (example.isNeedQueryAll() && totalItem > 0) {
			example.setPageSize(totalItem);
		}
		List<WithCapital4PromoterDO> returnList = new ArrayList<WithCapital4PromoterDO>();
		if (example.getPageFristItem() <= example.getTotalItem()) {

			List<WithCapital4PromoterDO> list = withCapital4PromoterDAO.selectByQuery(example);
			returnList.addAll(list);
		}
		return returnList;
	}

    public int updateByExampleSelective(WithCapital4PromoterDO record, WithCapital4PromoterDOExample example){
    	return this.withCapital4PromoterDAO.updateByExampleSelective(record, example);
    }

	public int updateByExample(WithCapital4PromoterDO record, WithCapital4PromoterDOExample example) {
		return this.withCapital4PromoterDAO.updateByExample(record, example);
	}

	public List<WithCapital4PromoterDO> selectByQuery4Intra(WithCapitalReqDOExampleExt example) {
		Integer totalItem = (Integer) withCapital4PromoterDAO.countByExample4Intra(example);

		example.setTotalItem(totalItem);

		if (example.isNeedQueryAll() && totalItem > 0) {
			example.setPageSize(totalItem);
		}
		List<WithCapital4PromoterDO> returnList = new ArrayList<WithCapital4PromoterDO>();
		if (example.getPageFristItem() <= example.getTotalItem()) {

			List<WithCapital4PromoterDO> list = withCapital4PromoterDAO.selectByQuery4Intra(example);
			returnList.addAll(list);
		}
		return returnList;
	}
	
	/**
	 * 统计代理商已配资总额按代理商id统计
	 * **/
	public BigDecimal sumWithCapitalAmountByPromoterId(Long promoterId){
    	return this.withCapital4PromoterDAO.sumWithCapitalAmountByPromoterId(promoterId);
    }
}