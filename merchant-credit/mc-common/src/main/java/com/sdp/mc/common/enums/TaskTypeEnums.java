/**
 * Shengpay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.sdp.mc.common.enums;

/**
 * 
 * @author liyantao
 */
public enum TaskTypeEnums {
   
	TASKTYPE_SQL(1, "SQL"),
	TASKTYPE_CUSTOMIZED(2, "定制任务 "),
	TASKTYPE_REST(3, "REST接口");
    
    /** 编码 */
    private final int  code;
    /** 描述 */
    private final String desc;

    TaskTypeEnums(int code,String desc) {
        this.code = code;
        this.desc=desc;
    }

    public int getCode() {
        return code;
    }

    

    public String getDesc() {
		return desc;
	}

	public static TaskTypeEnums getByCode(int code) {
        for (TaskTypeEnums _TaskType : TaskTypeEnums.values()) {
            if (code==_TaskType.getCode()) {
                return _TaskType;
            }
        }
        return null;
    }

}
