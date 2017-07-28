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
public enum CompareTypeEnums {
   
	CompareTypeMin("min", "较小值","空"),
	CompareTypeMax("max", " 较大值 ","大于"),
	CompareTypeEq("eq", "固定值","大于等于");
    
    /** 编码 */
    private final String  code;
    /** 信息 */
    private final String label;
    /** 描述 */
    private final String desc;

    CompareTypeEnums(String code, String lebel,String desc) {
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

	public static CompareTypeEnums getByCode(String code) {
        for (CompareTypeEnums _AccountStatus : CompareTypeEnums.values()) {
            if (code.equals(_AccountStatus.getCode())) {
                return _AccountStatus;
            }
        }
        return null;
    }

}
