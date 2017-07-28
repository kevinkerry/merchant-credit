package com.sdp.mc.ma.test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Before;
import org.junit.Test;

import com.caucho.hessian.client.HessianProxyFactory;
import com.sdp.mc.common.util.HttpUtils;
import com.sdp.mc.settle.api.business.PartnerPromfitQueryAPI;
import com.sdp.mc.settle.api.dto.req.PartnerPromfitCollectRequest;
import com.sdp.mc.settle.api.dto.resp.PartnerPromfitCollectResponse;
import com.sdp.withdraw.api.WithdrawT0ServiceAPI;
import com.sdp.withdraw.vo.WithdrawT0ServiceRequest;
import com.sdp.withdraw.vo.WithdrawT0ServiceResponse;

public class TestWithdrawHession {

	private WithdrawT0ServiceAPI withdrawT0ServiceAPI;

	//@Before
	public void init() {
		try {
			// String url =
			// "http://10.132.97.12:8085/mc-t0-service-website/hessian/synMerchantInfoService";
//			 String url = "http://127.0.0.1:8080/pfs/hessian/partnerPromfitQueryAPI";
//			 String url = "http://127.0.0.1:8080/pfs/hessian/partnerPromfitQueryAPI";
//			String url = "http://api.mcreit.shengpay.com/mc-t0-service-website/hessian/withdrawServiceHessian";
			String url = "http://10.132.97.12:8085/mc-t0-service-website/hessian/withdrawServiceHessian";
			HessianProxyFactory factory = new HessianProxyFactory();
			// 调用的服务接口，url为hessian服务url
			withdrawT0ServiceAPI = (WithdrawT0ServiceAPI) factory.create(WithdrawT0ServiceAPI.class, url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Test
	public void testunderclerkPromoterProfitsCollectToQuery() throws IOException {
		try {
			String fileName="d:\\walletWithdraw.txt";
			String[] arr=FileUtils.readLineFile(new File(fileName));
			for(int i=1 ;i<arr.length;i++){
				String info=arr[i];
				if(!StringUtils.isNotBlank(info)){
					continue;
				}
//			System.out.println(info);
				String[] merchant=info.split("\\t");
				System.out.print(merchant[1]+","+merchant[2]+","+merchant[3]+","+merchant[4]+",");
				//BigDecimal de =withdrawT0ServiceAPI.findTotalAmount(merchant[1], "0006");
				//System.out.println(ToStringBuilder.reflectionToString(de));
//				String url="http://api.mcreit.shengpay.com/mc-t0-service-website/withdraw-test/applyMPosWithdraw.do";
				String url="";
				Map<String, String> params=new HashMap<String, String>();
				params.put("appId", "zf790");
				params.put("withdrawType", "1");
				params.put("merchantNo", merchant[1]);
				params.put("mcType", "0006");
				params.put("orderNo", merchant[3]);
				params.put("withdrawAmount", merchant[4]);
				/*request.setAppId("zf790");
				request.setApplyTime(new Date());
				request.setCallbackAddress("http://walletwithdraw.shengpay.com/wallet-withdraw-service/wallet/withdraw/callback.do");
				request.setMcType("0006");
				request.setMerchantNo(merchant[i]);
				request.setWithdrawAmount(new BigDecimal(merchant[4]));
				request.setOrderNo(merchant[3]);
				request.setWithdrawType("1");*/
				String rew=HttpUtils.post(url, params);
				System.out.println(ToStringBuilder.reflectionToString(rew));
				
			}
			/*for(int i=1 ;i<arr.length;i++){
				String info=arr[i];
				System.out.println(info);
				String[] merchant=info.split("\\t");
				System.out.println(merchant[1]+","+merchant[2]+","+merchant[3]+","+merchant[4]+",");
				
				WithdrawT0ServiceRequest request=new WithdrawT0ServiceRequest();
				request.setAppId("zf790");
				request.setApplyTime(new Date());
				request.setCallbackAddress("http://walletwithdraw.shengpay.com/wallet-withdraw-service/wallet/withdraw/callback.do");
				request.setMcType("0006");
				request.setMerchantNo(merchant[i]);
				request.setWithdrawAmount(new BigDecimal(merchant[4]));
				request.setOrderNo(merchant[3]);
				request.setWithdrawType("1");
				request.setSignature(request.getSignStr("T0PosWithdrawMd5key"));
				WithdrawT0ServiceResponse response=withdrawT0ServiceAPI.t0WithdrawBalance(request);
				System.out.println(ToStringBuilder.reflectionToString(response));
			}*/
			/*WithdrawT0ServiceRequest request=new WithdrawT0ServiceRequest();
			request.setAppId("zf790");
			request.setApplyTime(new Date());
			request.setCallbackAddress("http://walletwithdraw.shengpay.com/wallet-withdraw-service/wallet/withdraw/callback.do");
			request.setMcType("0006");
			request.setMerchantNo(merchantNo);
			request.setWithdrawAmount(withdrawAmount);
			request.setOrderNo(orderNo);
			request.setWithdrawType("1");
			WithdrawT0ServiceResponse response=withdrawT0ServiceAPI.t0WithdrawBalance(request);
			System.out.println(ToStringBuilder.reflectionToString(response));*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				

	}
	
}
