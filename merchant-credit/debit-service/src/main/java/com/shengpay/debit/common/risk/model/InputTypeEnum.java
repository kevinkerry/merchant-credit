package com.shengpay.debit.common.risk.model;


/**
 * 输入类型
 * @author wangjingao.william
 * **/
public enum InputTypeEnum {

	NONE("None","无"),//模型建的有问题--吴伟解释
	TEXT("Text","文本"),
	ENUM("Enum","枚举"),
	ATTACHMENT("Attachment","附件"),
	ENUM_ATTACHMENT("EnumAttachment","枚举+附件")
	;
	public final String code;
	public final String name;
	
	InputTypeEnum(String code,String name){
		this.code= code;
		this.name = name;
	}
	
}
