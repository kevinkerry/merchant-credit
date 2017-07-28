package com.sdp.debit.web.creditLine.inputitem;

import com.alibaba.fastjson.JSONObject;

/**
 * 从普通的文本框中获取输入项
 * @author heyi.alex
 *
 */
public class TextInputItemGetter implements ItemGetter{

	@SuppressWarnings("unused")
	private TextInputItemGetter(){}

	private String key;

	public TextInputItemGetter(String key){
		this.key = key;
	}
	/**
	 * 从普通的文本框中获取输入项
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
		return ItemGetter.TEXT_TYPE;
	}
	@Override
	public String getExtInfo(JSONObject json) {
		return "";
	}
}
