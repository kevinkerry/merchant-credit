package com.sdp.mc.dao.readonly.dictionary;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.shengpay.commons.springtools.base.IbatisBaseDAOImpl;



/**
 * 字典表访问接口默认实现
 * @description	
 * @usage		
 * @copyright	Copyright 2010 SDO Corporation. All rights reserved.
 * @company		SDOCorporation.
 * @author		liuxi.xiliu <liuxi.xiliu@snda.com>
 * @version		$Id: OprDictionaryDAOImpl.java,v 1.0 2012-11-14 09:40:39 liuxi.xiliu Exp $
 * @create		2012-11-14 09:40:39
 */
@Repository("dictionaryDAO")
@Deprecated
public class DictionaryDAOImpl implements DictionaryDAO{
	/**
	 * IBatis模板在spring配置文件中的beanId
	 */
	@Resource(name="ibatisTemplate_mc")
	protected IbatisBaseDAOImpl ibatisTemplete;
	
	/**
	 * 取得所有字典，按分类排序
	 */
	public List<DictionaryEO> queryAllDictionary(){
		List<DictionaryEO> list = ibatisTemplete.queryForList( "DictionaryDAO.queryAllDictionary" );
		return list;
	}
	
	/**
	 * 根据label查询
	 */
	public List<DictionaryEO> queryByLabel(String label){
		List<DictionaryEO> list = ibatisTemplete.queryForList( "DictionaryDAO.queryByLabel",label );
		return list;
	}
}
