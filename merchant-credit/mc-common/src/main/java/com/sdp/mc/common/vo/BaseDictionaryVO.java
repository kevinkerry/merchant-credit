package com.sdp.mc.common.vo;

import java.util.List;


/**
 * 基础字典对象
 * @author liuxi.xiliu
 */
public class BaseDictionaryVO {
	/**
	 * 键(key)
	 */
	protected String k;
	
	/**
	 * 值(value)
	 */
	protected String v;
	
	/**
	 * 子对象(subs)
	 */
	protected List<?> s;
	
	public BaseDictionaryVO(){
		
	}
	
	public BaseDictionaryVO( String key, String value ){
		this.k = key;
		this.v = value;
	}
	
	public BaseDictionaryVO( String key, String value, List<?> subs ){
		this.k = key;
		this.v = value;
		this.s = subs;
	}
	
	
	public String getK() {
		return k;
	}

	public void setK(String k) {
		this.k = k;
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	public List<?> getS() {
		return s;
	}

	public void setS(List<?> s) {
		this.s = s;
	}
}
