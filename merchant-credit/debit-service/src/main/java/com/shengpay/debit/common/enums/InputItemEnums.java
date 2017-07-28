package com.shengpay.debit.common.enums;

import com.sdp.debit.web.creditLine.inputitem.AttachmentInputItemGetter;
import com.sdp.debit.web.creditLine.inputitem.EnumInputItemGetter;
import com.sdp.debit.web.creditLine.inputitem.ItemGetter;
import com.sdp.debit.web.creditLine.inputitem.TextConnectItemGetter;
import com.sdp.debit.web.creditLine.inputitem.TextInputItemGetter;

public enum InputItemEnums {

	/**
	 * 天天贷-基础信息
	 */
	BASE_NAME("tianttiandaijichuxinxi", "A", new TextInputItemGetter("applicantName"), "姓名"),
	BASE_IDCARD("tianttiandaijichuxinxi", "B", new TextInputItemGetter("applicantIdNo"), "身份证信息"),
	BASE_SEX("tianttiandaijichuxinxi", "E", new EnumInputItemGetter("applicantSex"), "性别"),
	BASE_MARITAL("tianttiandaijichuxinxi", "F", new EnumInputItemGetter("maritalStatus"), "婚姻状况"),
	BASE_CHILD("tianttiandaijichuxinxi", "G", new TextInputItemGetter("quantityOfChildren"), "子女数量"),
	BASE_ATTACH_ID_A("tianttiandaijichuxinxi", "C", new AttachmentInputItemGetter("positiveCardFileInfo"), "身份证正面照"),
	BASE_ATTACH_ID_B("tianttiandaijichuxinxi", "D", new AttachmentInputItemGetter("backCardFileInfo"), "身份证背面照"),

	/**
	 * 天天贷-征信信息
	 */
	CREDIT_BUSINRSS_LICENSE("tiantiandaizhengxin", "A", new AttachmentInputItemGetter("businessLicenseFileInfo"), "营业执照"),
	CREDIT_PERSONAL_REPORT("tiantiandaizhengxin", "B", new AttachmentInputItemGetter("creditReportFileInfo"),"人行征信报告"),
	CREDIT_HOUSE_NUMBER("tiantiandaizhengxin", "E", new TextInputItemGetter("qiantityOfHouse"), "房产数量"),
	CREDIT_HOUSE_CERT("tiantiandaizhengxin", "F", new AttachmentInputItemGetter("housePropertyFileInfo"), "上传房产证明"),
	CREDIT_OTHER_PROPERTY("tiantiandaizhengxin", "G", new EnumInputItemGetter("isOtherPropertyUpload"), "其他财产"),
	CREDIT_OTHER_PROPERTY_CERT("tiantiandaizhengxin", "H", new AttachmentInputItemGetter("otherPropertyFileInfo"), "上传其他财产证明"),

	/**
	 * 天天贷-联系信息
	 */
	CONNECT_APPLY_MOBILE("tiantiandailianxi", "A" ,new TextInputItemGetter("applicantPhone"),"申请人手机"),
	CONNECT_APPLY_OFFICE_PHONE("tiantiandailianxi", "B", new TextConnectItemGetter("telephoneAreaCode", "telephone", "extensionTelephone"),"申请人办公电话"),
	CONNECT_APPLY_LIVE_ADDRESS("tiantiandailianxi","C", new TextConnectItemGetter("residentialProvice", "residentialCity", "residentialStreet"), "申请人居住地址"),
	CONNECT_APPLY_BUSINESS_ADDRESS("tiantiandailianxi", "D",  new TextConnectItemGetter("manageProvice", "manageCity", "manageStreet"), "申请人经营地址"),
	CONNECT_APPLY_EMAIL("tiantiandailianxi", "E", new TextInputItemGetter("email"), "申请人电子邮箱"),
	CONNECT_APPLY_QQ("tiantiandailianxi", "F", new TextInputItemGetter("qqNo"), "申请人QQ号码"),
	CONNECT_APPLY_WEIXIN("tiantiandailianxi", "G", new TextInputItemGetter("weChatNo"), "申请人微信号"),
	CONNECT_SPOUSE_NAME("tiantiandailianxi", "I", new TextInputItemGetter("spouseName"), "配偶姓名"),
	CONNECT_SPOUSE_MOBILE("tiantiandailianxi", "J", new TextInputItemGetter("spousePhone"), "配偶手机号码"),
	CONNECT_SPOUSE_IDCARD("tiantiandailianxi", "K", new TextInputItemGetter("spouseIdNo"), "配偶身份证号码"),
	CONNECT_OTHER_NAME1("tiantiandailianxi", "H", new TextInputItemGetter("relativeName1"), "其他联系人姓名1"),
	CONNECT_OTHER_NAME2("tiantiandailianxi", "M", new TextInputItemGetter("relativeName2"), "其他联系人姓名2"),
	CONNECT_OTHER_MOBILE1("tiantiandailianxi", "N", new TextInputItemGetter("relativePhone1"), "其他联系人姓名1手机号码"),
	CONNECT_OTHER_MOBILE2("tiantiandailianxi", "O", new TextInputItemGetter("relativePhone2"), "其他联系人姓名2手机号码")
	;

	public final String inputKind;
	public final String inputCode;
	public final ItemGetter itemGetter;
	public final String desc;


	InputItemEnums(final String inputKind, final String inputCode,
			final ItemGetter itemGetter, String desc) {
		this.inputKind =  inputKind;
		this.inputCode = inputCode;
		this.itemGetter = itemGetter;
		this.desc = desc;
	}

}
