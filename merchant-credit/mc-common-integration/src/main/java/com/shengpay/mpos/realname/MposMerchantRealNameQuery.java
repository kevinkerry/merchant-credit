package com.shengpay.mpos.realname;

import javax.jws.WebService;

import com.sdp.mc.common.vo.ErrorMessageVO;
@WebService
public interface MposMerchantRealNameQuery {
	public ErrorMessageVO<Object> cntractQueryService(String merchantNo,String zfCode);
}
