package com.sdp.mc.web.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.sdp.emall.common.dao.QueryBase;

public class EasyPayQrCodeAllotRequest  {


    /**
     * 起始编号
     */
    private String qrStartCode;

    /**
     * 结束编号
     */
    private String qrEndCode;


    /**
     * 下级经销商商户号
     */
    private String childMerchant;
    
    
	
	public String getQrStartCode() {
		return qrStartCode;
	}



	public void setQrStartCode(String qrStartCode) {
		this.qrStartCode = qrStartCode;
	}



	public String getQrEndCode() {
		return qrEndCode;
	}



	public void setQrEndCode(String qrEndCode) {
		this.qrEndCode = qrEndCode;
	}



	public String getChildMerchant() {
		return childMerchant;
	}



	public void setChildMerchant(String childMerchant) {
		this.childMerchant = childMerchant;
	}



	@Override
	public String toString(){
		return  ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
