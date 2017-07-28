package com.sdp.mc.dao.readonly.dictionary;

import java.util.Date;


/**
 * 字典表实体对象
 * @description	
 * @usage		
 * @copyright	Copyright 2010 SDO Corporation. All rights reserved.
 * @company		SDOCorporation.
 * @author		liuxi.xiliu <liuxi.xiliu@snda.com>
 * @version		$Id: OprDictionaryEO.java,v 1.0 2012-11-14 09:40:39 liuxi.xiliu Exp $
 * @create		2012-11-14 09:40:39
 */
public class DictionaryEO{
	/**
	 * id
	 */
	protected Long id;

	/**
	 * 分类
	 */
	protected String label;

	/**
	 * 分类名称
	 */
	protected String labelName;

	/**
	 * 键
	 */
	protected String key;

	/**
	 * 值
	 */
	protected String value;

	/**
	 * 排序
	 */
	protected Long sort;

	/**
	 * 版本
	 */
	protected Long version;

	/**
	 * 创建时间
	 */
	protected Date createTime;

	/**
	 * 最后更新时间
	 */
	protected Date lastUpdateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
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

	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
}