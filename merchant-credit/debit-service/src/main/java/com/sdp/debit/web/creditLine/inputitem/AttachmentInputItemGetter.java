package com.sdp.debit.web.creditLine.inputitem;

import org.drools.core.util.StringUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * 带上传附件的用户输入项
 *
 * @author heyi.alex
 *
 */
public class AttachmentInputItemGetter implements ItemGetter {

	/**
	 * 输入项名称
	 */
	private volatile String key = "";

	@SuppressWarnings("unused")
	private AttachmentInputItemGetter() {
	}

	/**
	 *
	 * @param key
	 */
	public AttachmentInputItemGetter(String key) {
		this.key = key;
	}

	@Override
	public String getUserInputVal(JSONObject json) {
		return "";
	}

	/**
	 * 返回上传类型
	 */
	@Override
	public String getInputType() {
		return ItemGetter.ATTACH_TYPE;
	}

	@Override
	public String getExtInfo(JSONObject json) {
		if (json == null) {
			return "";
		}
		if (json.containsKey(key)) {
			JSONObject jfile = JSONObject.parseObject(json.get(key).toString());
			if (jfile.containsKey("storeKey")) {
				if (StringUtils.isEmpty(jfile.getString("storeKey")))
					return "";
			} else {
				return "";
			}
		} else {
			return "";
		}
		return json.get(key).toString();
	}

}
