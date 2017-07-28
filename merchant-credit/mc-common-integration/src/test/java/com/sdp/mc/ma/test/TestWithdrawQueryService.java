package com.sdp.mc.ma.test;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Before;
import org.junit.Test;

import com.shengpay.fos.model.WithdrawQueryRequest;
import com.shengpay.fos.model.WithdrawQueryResponse;
import com.shengpay.fos.ws.WithdrawQueryService;

/**
 * FOS订单状态查询
 * 2016年3月2日 15:39:11
 */
public class TestWithdrawQueryService {

	private WithdrawQueryService withdrawQueryService;

	@Before
	public void init(){
		//订单状态查询（集测环境）
		String url = "http://10.132.97.67:8081/fos/services/WithdrawQueryService?wsdl";
		org.apache.cxf.jaxws.JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress(url);
		factory.setServiceClass(WithdrawQueryService.class);
		withdrawQueryService = (WithdrawQueryService) factory.create();
	}

	@Test
	public void testTransferQuery(){
		WithdrawQueryRequest queryRequest = buildWithQuery();
		WithdrawQueryResponse withResponse = withdrawQueryService.queryWithdrawResult(queryRequest);
		System.out.println("FOS订单查询:"+ToStringBuilder.reflectionToString(withResponse));
	}

	private WithdrawQueryRequest buildWithQuery() {
		// TODO Auto-generated method stub
		WithdrawQueryRequest queryReq = new WithdrawQueryRequest();
		queryReq.setPaymentCode("123456");
		queryReq.setProductCode("123456");
		queryReq.setRemitVoucherNo("123456");
		queryReq.setSourceCode("1564");
		return null;
	}

}
