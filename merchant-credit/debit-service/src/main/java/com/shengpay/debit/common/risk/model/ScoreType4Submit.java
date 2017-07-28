package com.shengpay.debit.common.risk.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 评分大类，如MerchantBaseInfo，风控提交接口使用
 *
 * @author wangjingao.william
 * */
public class ScoreType4Submit implements Serializable {
	private static final long serialVersionUID = 1L;

	private String code;

	private List<Item> items = new ArrayList<Item>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void add(Item item) {
		this.items.add(item);
	}

	public static class Item implements Serializable {
		private static final long serialVersionUID = 1L;
		// 你提交的就是 code，value，attachment，如果有附件的话就带上附件,吴伟解释
		private String code;// 项的代码

		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
	}

	public static class ItemValue extends Item {
		private static final long serialVersionUID = 1L;
		private String value;// 页面填写的值
		public ItemValue(String code, String value) {
			super.code = code;
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}

	public static class ItemAttachment extends Item {
		private static final long serialVersionUID = 1L;
		private String attachment;// 页面填写的值
		public ItemAttachment(String code, String attachment) {
			super.code = code;
			this.attachment = attachment;
		}
		public String getAttachment() {
			return attachment;
		}
		public void setAttachment(String attachment) {
			this.attachment = attachment;
		}
	}

	public static class Item4Submit extends Item {
		private static final long serialVersionUID = 1L;
		/**
		 * @TODU,序列化成json串时要考虑attachment没有值的情况下是否要包含其中
		 **/
		private String attachment;// 附件,有就填写

		private String value;// 页面填写的值
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public Item4Submit(String code, String value, String attachment) {
			super.code = code;
			this.value=value;
			this.attachment = attachment;
		}

		public String getAttachment() {
			return attachment;
		}

		public void setAttachment(String attachment) {
			this.attachment = attachment;
		}
	}
}
