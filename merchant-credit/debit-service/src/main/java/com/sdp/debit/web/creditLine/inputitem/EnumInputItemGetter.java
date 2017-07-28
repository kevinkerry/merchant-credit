package com.sdp.debit.web.creditLine.inputitem;

import com.alibaba.fastjson.JSONObject;

/**
 * 下列选择框
 * @author heyi.alex
 *
 */
public class EnumInputItemGetter implements ItemGetter{

	@SuppressWarnings("unused")
	private EnumInputItemGetter(){}

	private String key;

	public EnumInputItemGetter(String key){
		this.key = key;
	}
	/**
	 * 从普通的下拉框中获取输入项
	 * @param name
	 * @param json
	 * @return
	 */
	public String getUserInputVal(JSONObject json){
		if (json != null){
			if (json.containsKey(key)){
				return json.get(key).toString();
			}
		}
		return "";
	}

	@Override
	public String getInputType() {
		return ItemGetter.ENUM_TYPE;
	}
	@Override
	public String getExtInfo(JSONObject json) {
		return "";
	}

}
