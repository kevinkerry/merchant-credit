package com.sdp.mc.test;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.Test;

import com.sdp.mc.common.util.HttpUtils;
import com.sdp.withdraw.util.SignUtil;
import com.sdp.withdraw.vo.wallet.WalletWithdrawQueryRequest;
import com.sdp.withdraw.vo.wallet.WalletWithdrawRequest;



public class WalletWithdrawTest {

	//@Test
	public void testWalletWithdrawApply(){
		String url="http://127.0.0.1:8080/mc-wallet-withdraw-website/wallet/withdraw/apply.do";
		WalletWithdrawRequest request=new WalletWithdrawRequest();
		request.setAppId("TEST");
		request.setOrderNo(System.currentTimeMillis()+"");
		request.setMemberNo("708855");
		request.setMemberType("0006");
		request.setOriginalAmount(new BigDecimal(100));
		request.setWithdrawAmount(new BigDecimal(102));
		request.setSignature(request.getSignStr("T0PosWithdrawMd5key"));
		Map<String,String> map =HttpUtils.beanToMap(request);
		
		HttpUtils.post(url, map);
	}
	@Test
	public void testSignature(){
		String sign=SignUtil.signOrderQueryRequest("TEST|1479891167666|707903|0006|10|10|T0PosWithdrawMd5key".getBytes());
         System.out.println("ed94b133ec909fbe8e530977ba9b3609="+sign);
	}
	
	
	@Test
	public void testWalletWithdrawQuery(){
		String url="http://127.0.0.1:8080/mc-wallet-withdraw-website/wallet/withdraw/query.do";
		WalletWithdrawQueryRequest request=new WalletWithdrawQueryRequest();
		request.setAppId("TEST");
		request.setMemberNo("708855");
		request.setSignature(request.getSignStr("T0PosWithdrawMd5key"));
		Map<String,String> map =HttpUtils.beanToMap(request);
		
		HttpUtils.post(url, map);
	}
}
