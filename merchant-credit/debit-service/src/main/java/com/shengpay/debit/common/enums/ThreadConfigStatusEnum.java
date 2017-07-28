package com.shengpay.debit.common.enums;


public enum ThreadConfigStatusEnum {


	VALID(1,"有效")
	,INVALID(2,"无效")
	;
	private Integer value;
	private String text;

	ThreadConfigStatusEnum(Integer value , String text){
		this.value = value;
		this.text = text;
	}

	public Integer getValue() {
		return value;
	}

//	public void setValue(Integer value) {
//		this.value = value;
//	}

	public String getText() {
		return text;
	}

//	public void setText(String text) {
//		this.text = text;
//	}

	public static ThreadConfigStatusEnum findEnumByValue(final Integer value){
		for(ThreadConfigStatusEnum status : ThreadConfigStatusEnum.values()){
			if(status.getValue().intValue() == value){
				return status;
			}
		}
		return null;
	}
}
