package com.sdp.mc.service.msp.dictionary;

import java.util.List;



/**
 * 字典
 * @author liuxi.xiliu
 */
public interface DictionaryService {
	public List<DictionaryRO> queryAllDictionary();
	
	public List<DictionaryRO> queryByLabel(String label);
}
