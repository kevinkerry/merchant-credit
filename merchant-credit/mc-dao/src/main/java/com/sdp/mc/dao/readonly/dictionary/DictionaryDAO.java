package com.sdp.mc.dao.readonly.dictionary;

import java.util.List;

/**
 * 字典表访问接口
 * @description	
 * @usage		
 * @copyright	Copyright 2010 SDO Corporation. All rights reserved.
 * @company		SDOCorporation.
 * @author		liuxi.xiliu <liuxi.xiliu@snda.com>
 * @version		$Id: OprDictionaryDAO.java,v 1.0 2012-11-14 09:40:39 liuxi.xiliu Exp $
 * @create		2012-11-14 09:40:39
 */
@Deprecated
public interface DictionaryDAO {
	/**
	 * 取得所有字典，按分类排序
	 */
	public List<DictionaryEO> queryAllDictionary();
	
	/**
	 * 根据label查询
	 */
	public List<DictionaryEO> queryByLabel(String label);
	
}
