package com.sdp.mc.newt0.manager;

import java.util.List;

import com.sdp.mc.newt0.dao.Newt0PromoterDO;
import com.sdp.mc.newt0.dao.Newt0PromoterDOExample;

public interface Newt0PromoterManager {
	/**
	 * 根据主键删除null【Newt0PromoterDO】对象信息
	 * 
	 * @mbggenerated Thu Sep 17 19:19:28 CST 2015
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * 添加null【Newt0PromoterDO】对象信息
	 * 
	 * @mbggenerated Thu Sep 17 19:19:28 CST 2015
	 */
	Long insert(Newt0PromoterDO record);

	/**
	 * 添加null【Newt0PromoterDO】对象信息,空值字段不插入
	 * 
	 * @mbggenerated Thu Sep 17 19:19:28 CST 2015
	 */
	Long insertSelective(Newt0PromoterDO record);

	/**
	 * 根据Example对象查询得到null【Newt0PromoterDO】对象列表信息
	 * 
	 * @mbggenerated Thu Sep 17 19:19:28 CST 2015
	 */
	List<Newt0PromoterDO> selectByExample(Newt0PromoterDOExample example);

	/**
	 * 根据主键查询null【Newt0PromoterDO】对象信息
	 * 
	 * @mbggenerated Thu Sep 17 19:19:28 CST 2015
	 */
	Newt0PromoterDO selectByPrimaryKey(Long id);

	/**
	 * 根据主键更新null【Newt0PromoterDO】对象信息，仅更新非空对象
	 * 
	 * @mbggenerated Thu Sep 17 19:19:28 CST 2015
	 */
	int updateByPrimaryKeySelective(Newt0PromoterDO record);

	/**
	 * 根据主键更新null【Newt0PromoterDO】对象信息
	 * 
	 * @mbggenerated Thu Sep 17 19:19:28 CST 2015
	 */
	int updateByPrimaryKey(Newt0PromoterDO record);

	/**
	 * 根据Query对象分页查询null【Newt0PromoterDO】对象列表信息
	 * 
	 * @mbggenerated Thu Sep 17 19:19:28 CST 2015
	 */
	List<Newt0PromoterDO> selectByQuery(Newt0PromoterDOExample example);

	Newt0PromoterDO getPromoterByMerchantId(Long merchantId);

	int updateByExampleSelective(Newt0PromoterDO record, Newt0PromoterDOExample example);

	int deleteByExample(Newt0PromoterDOExample example);
}