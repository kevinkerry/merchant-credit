package com.shengpay.mpos.realname;

import com.shengpay.poss.service.realname.remote.vo.MerchantRealNameAuthQueryResp;

/**
 * mpos提现实名认证接口
 *
 * @author liutao
 *
 */
public interface MerchantRealNameAuth {

	MerchantRealNameAuthQueryResp authQueryInfo(String merchantNo, String zfCode) throws Exception;

	String getAuthQueryCertNo(String merchantNo);
	
}
