package com.sdp.debit.web.creditLine.inputitem;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSONObject;

/**
 * 获取连接字符串
 * @author heyi.alex
 *
 */
public class TextConnectItemGetter implements ItemGetter{

	@SuppressWarnings("unused")
	private TextConnectItemGetter(){}

	/**
	 * 输入项名称
	 */
	private volatile String[] keyNames;

	/**
	 * 拼接连接符
	 */
	private volatile char connectChar = '-';

	public TextConnectItemGetter(char connectChar, String ... keyNames){
		this.connectChar = connectChar;
		this.keyNames = keyNames;
	}

	public TextConnectItemGetter(String ... keyNames){
		this.keyNames = keyNames;
	}

	/**
	 * 返回用户输入字段
	 */
	@Override
	public String getUserInputVal(JSONObject json) {
		if (json == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (int i =0 ; i < keyNames.length; i++){
			if (json.containsKey(keyNames[i])){
				if (StringUtils.isNotEmpty(json.getString(keyNames[i]))){
					sb.append(json.get(keyNames[i]));
					if (i != keyNames.length - 1){
						sb.append(connectChar);
					}
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 返回输入类型
	 * @return
	 */
	@Override
	public String getInputType(){
		return ItemGetter.TEXT_TYPE;
	}

	/**
	 * 返回输入扩展字段
	 * @param json
	 * @return
	 */
	@Override
	public String getExtInfo(JSONObject json){
		return "";
	}

}
