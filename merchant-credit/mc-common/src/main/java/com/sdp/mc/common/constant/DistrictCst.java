package com.sdp.mc.common.constant;

import com.shengpay.commons.core.constants.ConstantTag;

/**
 * 地区，常量
 * @author liuxi.xiliu
 */
public class DistrictCst {
	/**
     * 地区级别:国家级={@value}
     */
    @ConstantTag(name = "国家", type = "DCT_DISTRICT_LEVEL")
    public static final String DCT_DISTRICT_LEVEL_COUNTRY = "0001";
    
    /**
     * 地区级别:省级={@value}
     */
    @ConstantTag(name = "省级", type = "DCT_DISTRICT_LEVEL")
    public static final String DCT_DISTRICT_LEVEL_PROVINCE = "0002";
    
    /**
     * 地区级别:市级={@value}
     */
    @ConstantTag(name = "市级", type = "DCT_DISTRICT_LEVEL")
    public static final String DCT_DISTRICT_LEVEL_CITY = "0003";
    
    /**
     * 地区级别:区级={@value}
     */
    @ConstantTag(name = "区级", type = "DCT_DISTRICT_LEVEL")
    public static final String DCT_DISTRICT_LEVEL_REGION = "0004";
}
