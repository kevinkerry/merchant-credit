package com.sdp.mc.promoter.manager;

import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDO;
import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDOExample;
import com.sdp.mc.promoter.dao.ext.PromoterFastSettleSwitchDOExampleExt;
import com.sdp.mc.promoter.dao.ext.PromoterFastSettleSwitchDOExt;
import com.sdp.mc.promoter.dao.ext.PromoterFastSettleSwitchDONewt0Ext;

import java.util.List;

public interface PromoterFastSettleSwitchManager {
	/**
	 * 根据主键删除代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息
	 *
	 * @mbggenerated Tue Mar 31 17:37:57 CST 2015
	 */
	int deleteByPrimaryKey(Long pfrId);

	/**
	 * 添加代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息
	 *
	 * @mbggenerated Tue Mar 31 17:37:57 CST 2015
	 */
	Long insert(PromoterFastSettleSwitchDO record);

	/**
	 * 添加代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息,空值字段不插入
	 *
	 * @mbggenerated Tue Mar 31 17:37:57 CST 2015
	 */
	Long insertSelective(PromoterFastSettleSwitchDO record);

	/**
	 * 根据Example对象查询得到代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象列表信息
	 *
	 * @mbggenerated Tue Mar 31 17:37:57 CST 2015
	 */
	List<PromoterFastSettleSwitchDO> selectByExample(PromoterFastSettleSwitchDOExample example);

	/**
	 * 根据主键查询代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息
	 *
	 * @mbggenerated Tue Mar 31 17:37:57 CST 2015
	 */
	PromoterFastSettleSwitchDO selectByPrimaryKey(Long pfrId);

	/**
	 * 根据主键更新代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息，仅更新非空对象
	 *
	 * @mbggenerated Tue Mar 31 17:37:57 CST 2015
	 */
	int updateByPrimaryKeySelective(PromoterFastSettleSwitchDO record);

	/**
	 * 根据主键更新代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息
	 *
	 * @mbggenerated Tue Mar 31 17:37:57 CST 2015
	 */
	int updateByPrimaryKey(PromoterFastSettleSwitchDO record);

	/**
	 * 根据Query对象分页查询代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象列表信息
	 *
	 * @mbggenerated Tue Mar 31 17:37:57 CST 2015
	 */
	List<PromoterFastSettleSwitchDO> selectByQuery(PromoterFastSettleSwitchDOExample example);

	public int updateByExampleSelective(PromoterFastSettleSwitchDO record, PromoterFastSettleSwitchDOExample example);

	List<PromoterFastSettleSwitchDOExt> selectByQuery4Intra(PromoterFastSettleSwitchDOExampleExt example);

	@Deprecated
	List<PromoterFastSettleSwitchDONewt0Ext> selectByQueryAuditInfo(PromoterFastSettleSwitchDOExampleExt example);
	/**
	 * 查询所有盛付通全资的商户
	 * @return
	 */
	List<PromoterFastSettleSwitchDOExt> getPosOpenFastSettleMerchantIds();
	/**
	 * 根据垫资方查询所有代理商
	 * @param loaningType
	 * @return
	 */
	List<PromoterFastSettleSwitchDOExt> getPromoters(Integer loaningType);
	/**
	 * 查询所有商户
	 * @return
	 */
	List<PromoterFastSettleSwitchDOExt> getAllPosAndMposOpenFastSettleMerchants();

}