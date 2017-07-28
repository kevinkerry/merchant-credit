package com.sdp.debit.web.creditLine.inputitem;

import com.alibaba.fastjson.JSONObject;

/**
 * 获取输入项的接口
 * @author heyi.alex
 *
 */
public interface ItemGetter {

	/**
	 * 文本输入框
	 */
	public final String TEXT_TYPE = "Text";

	/**
	 * 下拉选择框
	 */
	public final String ENUM_TYPE = "Enum";

	/**
	 * 上传附件
	 */
	public final String ATTACH_TYPE = "Attachment";

	/**
	 * 返回用户输入字段
	 * @param json
	 * @return
	 */
	public String getUserInputVal(JSONObject json);

	/**
	 * 返回类型
	 * @return
	 */
	public String getInputType();

	/**
	 * 返回扩展信息
	 * @param json
	 * @return
	 */
	public String getExtInfo(JSONObject json);

}
