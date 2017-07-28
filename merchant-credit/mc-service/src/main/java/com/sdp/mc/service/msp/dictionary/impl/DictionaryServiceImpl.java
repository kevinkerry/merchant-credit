package com.sdp.mc.service.msp.dictionary.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.dao.readonly.dictionary.DictionaryDAO;
import com.sdp.mc.dao.readonly.dictionary.DictionaryEO;
import com.sdp.mc.service.msp.dictionary.DictionaryHelper;
import com.sdp.mc.service.msp.dictionary.DictionaryRO;
import com.sdp.mc.service.msp.dictionary.DictionaryService;

/**
 * 字典
 * 
 * @author liuxi.xiliu
 */
@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {
	private static final Logger logger = LoggerFactory.getLogger(DictionaryServiceImpl.class);
	@Autowired
	private DictionaryDAO dictionaryDAO;

	/**
	 * 初始化
	 */
	@PostConstruct
	public void init(){
		List<DictionaryEO> list = dictionaryDAO.queryAllDictionary();
		DictionaryHelper.init( list );
		logger.info( "----Dictionary init complete, size:" + list.size() );
	}
	
	private List<DictionaryRO> copy(List<DictionaryEO> list) {
		if (list != null) {
			List<DictionaryRO> listRo = new ArrayList<DictionaryRO>();
			for (DictionaryEO eo : list) {
				DictionaryRO ro = new DictionaryRO();
				ro.setKey(eo.getKey());
				ro.setValue(eo.getValue());
				listRo.add(ro);
			}
			return listRo;
		}
		return null;
	}

	public List<DictionaryRO> queryAllDictionary() {
		List<DictionaryEO> list = dictionaryDAO.queryAllDictionary();
		return copy(list);
	}

	public List<DictionaryRO> queryByLabel(String label) {
		List<DictionaryEO> list = dictionaryDAO.queryByLabel(label);
		return copy(list);
	}

}
