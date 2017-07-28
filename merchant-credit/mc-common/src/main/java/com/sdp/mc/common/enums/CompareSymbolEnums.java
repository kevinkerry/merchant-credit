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
public enum CompareSymbolEnums {
   
	CompareSymbolEmpty("empty", "","空"),
	CompareSymbolGt("gt", " > ","大于"),
	CompareSymbolGteq("gteq", ">=","大于等于"),
	CompareSymbolLt("lt", "<","小于"),
	CompareSymbolLteq("lteq", "<=","小于等于"),
	CompareSymbolEq("eq", "=","等于");
    
    /** 编码 */
    private final String  code;
    /** 信息 */
    private final String label;
    /** 描述 */
    private final String desc;

    CompareSymbolEnums(String code, String lebel,String desc) {
        this.code = code;
        this.label = lebel;
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

	public static CompareSymbolEnums getByCode(String code) {
        for (CompareSymbolEnums _AccountStatus : CompareSymbolEnums.values()) {
            if (code.equals(_AccountStatus.getCode())) {
                return _AccountStatus;
            }
        }
        return null;
    }

}
