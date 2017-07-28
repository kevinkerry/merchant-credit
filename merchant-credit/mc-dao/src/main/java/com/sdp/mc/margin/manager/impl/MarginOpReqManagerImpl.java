package com.sdp.mc.margin.manager.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.MarginOpRedeemEnums;
import com.sdp.mc.margin.dao.MarginOpReqDO;
import com.sdp.mc.margin.dao.MarginOpReqDOExample;
import com.sdp.mc.margin.dao.daointerface.MarginOpReqDAO;
import com.sdp.mc.margin.dao.ext.MarginOpReqDOExampleExt;
import com.sdp.mc.margin.dao.ext.MarginOpReqDOExt;
import com.sdp.mc.margin.dao.ext.RedeemedMarginApplyExampleExt;
import com.sdp.mc.margin.dao.ext.RedeemedMarginApplyExt;
import com.sdp.mc.margin.manager.MarginOpReqManager;

@Service("marginOpReqManager")
public class MarginOpReqManagerImpl implements MarginOpReqManager {
	@Autowired
	private MarginOpReqDAO marginOpReqDAO;

	/**
	 * 根据主键删除代理商保证金追加/退回记录【MarginOpReqDO】对象信息
	 *
	 * @mbggenerated Mon Mar 30 13:57:53 CST 2015
	 */
	@Override
	public int deleteByPrimaryKey(Long morId) {
		int rows = marginOpReqDAO.deleteByPrimaryKey(morId);
		return rows;
	}

	/**
	 * 添加代理商保证金追加/退回记录【MarginOpReqDO】对象信息
	 *
	 * @mbggenerated Mon Mar 30 13:57:53 CST 2015
	 */
	@Override
	public Long insert(MarginOpReqDO record) {
		Long id = marginOpReqDAO.insert(record);
		return record.getMorId();
	}

	/**
	 * 添加代理商保证金追加/退回记录【MarginOpReqDO】对象信息,空值字段不插入
	 *
	 * @mbggenerated Mon Mar 30 13:57:53 CST 2015
	 */
	@Override
	public Long insertSelective(MarginOpReqDO record) {
		Long id = marginOpReqDAO.insertSelective(record);
		return record.getMorId();
	}

	/**
	 * 根据Example对象查询得到代理商保证金追加/退回记录【MarginOpReqDO】对象列表信息
	 *
	 * @mbggenerated Mon Mar 30 13:57:53 CST 2015
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MarginOpReqDO> selectByExample(MarginOpReqDOExample example) {
		List<MarginOpReqDO> list = marginOpReqDAO.selectByExample(example);
		return list;
	}

	/**
	 * 根据主键查询代理商保证金追加/退回记录【MarginOpReqDO】对象信息
	 *
	 * @mbggenerated Mon Mar 30 13:57:53 CST 2015
	 */
	@Override
	public MarginOpReqDO selectByPrimaryKey(Long morId) {
		MarginOpReqDO record = marginOpReqDAO.selectByPrimaryKey(morId);
		return record;
	}

	/**
	 * 批量查询
	 */
	@Override
	public List<MarginOpReqDO> selectByPrimaryKeys(String morIds) {
		// TODO Auto-generated method stub
		MarginOpReqDOExample example = new MarginOpReqDOExample();
		List<Long> morIdsList = new ArrayList<Long>();
		for (int i = 0; i < morIds.split(",").length; i++) {
			Long id = Long.parseLong(morIds.split(",")[i]);
			morIdsList.add(id);
		}
		example.createCriteria().andMorIdIn(morIdsList);
		return marginOpReqDAO.selectByExample(example);
	}

	/**
	 * 根据Example对象更新代理商保证金追加/退回记录【MarginOpReqDO】对象信息，仅更新非空字段
	 *
	 * @mbggenerated Mon Mar 30 13:57:53 CST 2015
	 */
	public int updateByExampleSelective(MarginOpReqDO record, MarginOpReqDOExample example) {
		int rows = marginOpReqDAO.updateByExampleSelective(record, example);
		return rows;
	}

	/**
	 * 根据Example对象更新代理商保证金追加/退回记录【MarginOpReqDO】对象信息
	 *
	 * @mbggenerated Mon Mar 30 13:57:53 CST 2015
	 */
	public int updateByExample(MarginOpReqDO record, MarginOpReqDOExample example) {
		int rows = marginOpReqDAO.updateByExample(record, example);
		return rows;
	}

	/**
	 * 根据主键更新代理商保证金追加/退回记录【MarginOpReqDO】对象信息，仅更新非空对象
	 *
	 * @mbggenerated Mon Mar 30 13:57:53 CST 2015
	 */
	@Override
	public int updateByPrimaryKeySelective(MarginOpReqDO record) {
		int rows = marginOpReqDAO.updateByPrimaryKeySelective(record);
		return rows;
	}

	/**
	 * 根据主键更新代理商保证金追加/退回记录【MarginOpReqDO】对象信息
	 *
	 * @mbggenerated Mon Mar 30 13:57:53 CST 2015
	 */
	@Override
	public int updateByPrimaryKey(MarginOpReqDO record) {
		int rows = marginOpReqDAO.updateByPrimaryKey(record);
		return rows;
	}

	/**
	 * 根据Query对象分页查询代理商保证金追加/退回记录【MarginOpReqDO】对象列表信息
	 *
	 * @mbggenerated Mon Mar 30 13:57:53 CST 2015
	 */
	@Override
	public List<MarginOpReqDO> selectByQuery(MarginOpReqDOExample example) {
		Integer totalItem = (Integer) marginOpReqDAO.countByExample(example);

		example.setTotalItem(totalItem);

		if (example.isNeedQueryAll() && totalItem > 0) {
			example.setPageSize(totalItem);
		}
		List<MarginOpReqDO> returnList = new ArrayList<MarginOpReqDO>();
		if (example.getPageFristItem() <= example.getTotalItem()) {

			List<MarginOpReqDO> list = marginOpReqDAO.selectByQuery(example);
			returnList.addAll(list);
		}
		return returnList;
	}

	/**
	 * 退款审核列表
	 */
	public List<MarginOpReqDOExt> selectByQuery4Intra(MarginOpReqDOExampleExt example) {
		Integer totalItem = (Integer) marginOpReqDAO.countByExample4Intra(example);

		example.setTotalItem(totalItem);
		if (example.isNeedQueryAll() && totalItem > 0) {
			example.setPageSize(totalItem);
		}
		List<MarginOpReqDOExt> returnList = new ArrayList<MarginOpReqDOExt>();
		if (example.getPageFristItem() <= example.getTotalItem()) {

			List<MarginOpReqDOExt> list = marginOpReqDAO.selectByQuery4Intra(example);
			returnList.addAll(list);
		}
		return returnList;
	}

	public List<RedeemedMarginApplyExt> selectByNewT0AuditingQuery4Intra(RedeemedMarginApplyExampleExt example) {

		Integer totalItem = (Integer) marginOpReqDAO.countByNewT0AuditingExample4Intra(example);

		example.setTotalItem(totalItem);

		if (example.isNeedQueryAll() && totalItem > 0) {
			example.setPageSize(totalItem);
		}
		List<RedeemedMarginApplyExt> returnList = new ArrayList<RedeemedMarginApplyExt>();
		if (example.getPageFristItem() <= example.getTotalItem()) {

			List<RedeemedMarginApplyExt> list = marginOpReqDAO.selectByNewT0AuditingQuery4Intra(example);
			returnList.addAll(list);
		}
		return returnList;
	}

	@Override
	public List<MarginOpReqDO> queryMarginOpReq(Long promoterId, Integer opType, Integer status) {
		MarginOpReqDOExample example = new MarginOpReqDOExample();
		example.createCriteria().andPromoterIdEqualTo(promoterId).andOpTypeEqualTo(opType).andStatusEqualTo(status);
		return selectByExample(example);
	}

	@Override
	public BigDecimal queryMarginOpReqSum(Long promoterId, Integer opType, Integer status) {
		BigDecimal amount = new BigDecimal(0);
		List<MarginOpReqDO> list = queryMarginOpReq(promoterId, opType, status);
		for (MarginOpReqDO marginOpReqDO : list) {
			amount = amount.add(marginOpReqDO.getAmount());
		}
		return amount;
	}

	/**
	 * 统计取回金额
	 */
	@Override
	public BigDecimal totalAmount(RedeemedMarginApplyExampleExt example) {
		return marginOpReqDAO.totalAmountByNewT0AuditingExample4Intra(example);
	}
}