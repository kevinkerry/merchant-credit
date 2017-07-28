package com.shengpay.debit.common.enums;


public enum SaveOrUpdateEnum {
	SAVE("0","保存"),
	UPDATE("1","更新");

    private String code;
    private String description;

    SaveOrUpdateEnum(String code, String description){
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static SaveOrUpdateEnum parse(String code) {
        for (SaveOrUpdateEnum temp : values()) {
            if (temp.getCode().equals(code)) { return temp; }
        }
        return null;
    }
}
