/**
 * Shengpay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.sdp.mc.common.enums;

/**
 * 
 * @author liyantao
 * @version $Id: AccountStatus.java, v 0.1 2011-8-12 下午4:15:43 sunzhi.tom Exp $
 */
public enum ConditionSymbolEnums {
   
	ConditionSymbolEmpty("empty", "","空"),
	ConditionSymbolAnd("and", "且","并且"),
	ConditionSymbolOr("or", "或","或者");
	
    
    /** 编码 */
    private final String  code;
    /** 信息 */
    private final String label;
    /** 描述 */
    private final String desc;

    ConditionSymbolEnums(String code, String label,String desc) {
        this.code = code;
        this.label = label;
        this.desc=desc;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
    

    public String getDesc() {
		return desc;
	}

	public static ConditionSymbolEnums getByCode(String code) {
        for (ConditionSymbolEnums _AccountStatus : ConditionSymbolEnums.values()) {
            if (code.equals(_AccountStatus.getCode())) {
                return _AccountStatus;
            }
        }
        return null;
    }

}
