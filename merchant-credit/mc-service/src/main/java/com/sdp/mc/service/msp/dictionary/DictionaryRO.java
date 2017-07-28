package com.sdp.mc.service.msp.dictionary;

import com.sdp.mc.dao.readonly.dictionary.DictionaryEO;

/**
 * DictionaryRO
 * @author liuxi.xiliu
 */
public class DictionaryRO{
	private String key;
	
	private String value;
	
	
	public DictionaryRO(){
		
	}
	
	public DictionaryRO( DictionaryEO eo ){
		if( eo != null ){
			//this.setId( eo.getId() );
			//this.setLabel( eo.getLabel() );
			//this.setLabelName( eo.getLabelName() );
			this.setKey( eo.getKey() );
			this.setValue( eo.getValue() );
			//this.setSort( eo.getSort() );
			//this.setVersion( eo.getVersion() );
			//this.setCreateTime( eo.getCreateTime() );
			//this.setLastUpdateTime( eo.getLastUpdateTime() );
		}
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
