package com.sdp.mc.dao.readonly.merchant;

import java.math.BigDecimal;

import com.sdp.mc.margin.dao.MarginOpReqDO;

public class CmPosMerchantFastEOExt extends MarginOpReqDO{
private static final long serialVersionUID = 1L;
//保证金金额
private BigDecimal pmtFastSettleMargin;
//商户号
private String merchantNo;
//会员ID
private String memberId;
private String mctype;
private String promoterIdStr;
private String promoterName;
public String getPromoterName() {
	return promoterName;
}

public void setPromoterName(String promoterName) {
	this.promoterName = promoterName;
}

public String getPromoterIdStr() {
	return promoterIdStr;
}

public void setPromoterIdStr(String promoterIdStr) {
	this.promoterIdStr = promoterIdStr;
}

public String getMctype() {
	return mctype;
}

public void setMctype(String mctype) {
	this.mctype = mctype;
}

public BigDecimal getPmtFastSettleMargin() {
	return pmtFastSettleMargin;
}

public String getMerchantNo() {
	return merchantNo;
}

public void setMerchantNo(String merchantNo) {
	this.merchantNo = merchantNo;
}

public String getMemberId() {
	return memberId;
}

public void setMemberId(String memberId) {
	this.memberId = memberId;
}

public void setPmtFastSettleMargin(BigDecimal pmtFastSettleMargin) {
	this.pmtFastSettleMargin = pmtFastSettleMargin;
}



}
