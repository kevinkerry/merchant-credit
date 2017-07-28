/**
 * Shengpay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.sdp.mc.common.enums;

/**
 * 
 * @author liyantao
 */
public enum TaskSqlTypeEnums {
   
	UPDATE("1", "新增"),
	INSERT("2", "修改"),
	;
    
    /** 编码 */
    private final String  code;
    /** 描述 */
    private final String desc;

    TaskSqlTypeEnums(String code,String desc) {
        this.code = code;
        this.desc=desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
		return desc;
	}

	public static TaskSqlTypeEnums getByCode(String code) {
        for (TaskSqlTypeEnums _TaskType : TaskSqlTypeEnums.values()) {
            if (code.equals(_TaskType.getCode())) {
                return _TaskType;
            }
        }
        return null;
    }

}
