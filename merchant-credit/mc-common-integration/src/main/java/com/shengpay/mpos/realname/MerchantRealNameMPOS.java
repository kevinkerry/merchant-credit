package com.shengpay.mpos.realname;

import com.sdp.mc.common.vo.ErrorMessageVO;
import com.shengpay.poss.service.realname.remote.vo.MerchantRealNameAuthQueryResp;

public interface MerchantRealNameMPOS {
	public ErrorMessageVO<Object> authQuery(String merchantNo,String zfCode) ;

}
