package com.sdp.mc.ma.response.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class QueryOperatorMemberScopeResponse extends AbstractResponse {

	String[] merchantNo;

	public String[] getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String[] merchantNo) {
		this.merchantNo = merchantNo;
	}

}
