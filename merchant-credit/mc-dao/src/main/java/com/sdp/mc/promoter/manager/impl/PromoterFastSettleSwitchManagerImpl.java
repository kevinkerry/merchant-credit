package com.sdp.mc.promoter.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDO;
import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDOExample;
import com.sdp.mc.promoter.dao.daointerface.PromoterFastSettleSwitchDAO;
import com.sdp.mc.promoter.dao.ext.PromoterFastSettleSwitchDOExampleExt;
import com.sdp.mc.promoter.dao.ext.PromoterFastSettleSwitchDOExt;
import com.sdp.mc.promoter.dao.ext.PromoterFastSettleSwitchDONewt0Ext;
import com.sdp.mc.promoter.manager.PromoterFastSettleSwitchManager;

@Service("promoterFastSettleSwitchManager")
public class PromoterFastSettleSwitchManagerImpl implements PromoterFastSettleSwitchManager {
	@Autowired
	private PromoterFastSettleSwitchDAO promoterFastSettleSwitchDAO;

	/**
	 * 根据主键删除代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息
	 *
	 * @mbggenerated Tue Mar 31 17:37:57 CST 2015
	 */
	@Override
	public int deleteByPrimaryKey(Long pfrId) {
		int rows = promoterFastSettleSwitchDAO.deleteByPrimaryKey(pfrId);
		return rows;
	}

	/**
	 * 添加代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息
	 *
	 * @mbggenerated Tue Mar 31 17:37:57 CST 2015
	 */
	@Override
	public Long insert(PromoterFastSettleSwitchDO record) {
		Long id = promoterFastSettleSwitchDAO.insert(record);
		return record.getPfrId();
	}

	/**
	 * 添加代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息,空值字段不插入
	 *
	 * @mbggenerated Tue Mar 31 17:37:57 CST 2015
	 */
	@Override
	public Long insertSelective(PromoterFastSettleSwitchDO record) {
		Long id = promoterFastSettleSwitchDAO.insertSelective(record);
		return record.getPfrId();
	}

	/**
	 * 根据Example对象查询得到代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象列表信息
	 *
	 * @mbggenerated Tue Mar 31 17:37:57 CST 2015
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PromoterFastSettleSwitchDO> selectByExample(PromoterFastSettleSwitchDOExample example) {
		List<PromoterFastSettleSwitchDO> list = promoterFastSettleSwitchDAO.selectByExample(example);
		return list;
	}

	/**
	 * 根据主键查询代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息
	 *
	 * @mbggenerated Tue Mar 31 17:37:57 CST 2015
	 */
	@Override
	public PromoterFastSettleSwitchDO selectByPrimaryKey(Long pfrId) {
		PromoterFastSettleSwitchDO record = promoterFastSettleSwitchDAO.selectByPrimaryKey(pfrId);
		return record;
	}

	/**
	 * 根据主键更新代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息，仅更新非空对象
	 *
	 * @mbggenerated Tue Mar 31 17:37:57 CST 2015
	 */
	@Override
	public int updateByPrimaryKeySelective(PromoterFastSettleSwitchDO record) {
		int rows = promoterFastSettleSwitchDAO.updateByPrimaryKeySelective(record);
		return rows;
	}

	/**
	 * 根据主键更新代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息
	 *
	 * @mbggenerated Tue Mar 31 17:37:57 CST 2015
	 */
	@Override
	public int updateByPrimaryKey(PromoterFastSettleSwitchDO record) {
		int rows = promoterFastSettleSwitchDAO.updateByPrimaryKey(record);
		return rows;
	}

	/**
	 * 根据Query对象分页查询代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象列表信息
	 *
	 * @mbggenerated Tue Mar 31 17:37:57 CST 2015
	 */
	@Override
	public List<PromoterFastSettleSwitchDO> selectByQuery(PromoterFastSettleSwitchDOExample example) {
		Integer totalItem = (Integer) promoterFastSettleSwitchDAO.countByExample(example);

		example.setTotalItem(totalItem);

		if (example.isNeedQueryAll() && totalItem > 0) {
			example.setPageSize(totalItem);
		}
		List<PromoterFastSettleSwitchDO> returnList = new ArrayList<PromoterFastSettleSwitchDO>();
		if (example.getPageFristItem() <= example.getTotalItem()) {

			List<PromoterFastSettleSwitchDO> list = promoterFastSettleSwitchDAO.selectByQuery(example);
			returnList.addAll(list);
		}
		return returnList;
	}

	public int updateByExampleSelective(PromoterFastSettleSwitchDO record, PromoterFastSettleSwitchDOExample example) {
		return this.promoterFastSettleSwitchDAO.updateByExampleSelective(record, example);
	}

	public List<PromoterFastSettleSwitchDOExt> selectByQuery4Intra(PromoterFastSettleSwitchDOExampleExt example) {
		Integer totalItem = (Integer) promoterFastSettleSwitchDAO.countByExample4Intra(example);

		example.setTotalItem(totalItem);

		if (example.isNeedQueryAll() && totalItem > 0) {
			example.setPageSize(totalItem);
		}
		List<PromoterFastSettleSwitchDOExt> returnList = new ArrayList<PromoterFastSettleSwitchDOExt>();
		if (example.getPageFristItem() <= example.getTotalItem()) {

			List<PromoterFastSettleSwitchDOExt> list = promoterFastSettleSwitchDAO.selectByQuery4Intra(example);
			returnList.addAll(list);
		}
		return returnList;
	}
	@Deprecated
	public List<PromoterFastSettleSwitchDONewt0Ext> selectByQueryAuditInfo(PromoterFastSettleSwitchDOExampleExt example) {
		Integer totalItem = (Integer) promoterFastSettleSwitchDAO.countByExampleAuditInfo(example);

		example.setTotalItem(totalItem);

		if (example.isNeedQueryAll() && totalItem > 0) {
			example.setPageSize(totalItem);
		}
		List<PromoterFastSettleSwitchDONewt0Ext> returnList = new ArrayList<PromoterFastSettleSwitchDONewt0Ext>();
		if (example.getPageFristItem() <= example.getTotalItem()) {

			List<PromoterFastSettleSwitchDONewt0Ext> list = promoterFastSettleSwitchDAO.selectByQueryAuditInfo(example);
			returnList.addAll(list);
		}
		return returnList;
	}

	/**
	 * 查询盛付通全资商户号
	 * @return
	 */
	public List<PromoterFastSettleSwitchDOExt> getPosOpenFastSettleMerchantIds(){
		return promoterFastSettleSwitchDAO.getPosOpenFastSettleMerchantIds();
	}
	/**
	 * 查询所有代理商
	 */
	public List<PromoterFastSettleSwitchDOExt> getPromoters(Integer loaningType){
		return promoterFastSettleSwitchDAO.getPromoters(loaningType);
	}

	/**
	 * 查询所有商户
	 * @return
	 */
	public List<PromoterFastSettleSwitchDOExt> getAllPosAndMposOpenFastSettleMerchants(){
		return promoterFastSettleSwitchDAO.getAllPosAndMposOpenFastSettleMerchants();
	}
}