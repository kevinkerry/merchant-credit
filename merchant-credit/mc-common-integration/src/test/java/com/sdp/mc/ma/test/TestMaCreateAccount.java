package com.sdp.mc.ma.test;

import java.util.Date;
import java.util.UUID;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

import com.sdo.ma.ws.api.service.osr.IMaOsrFullWS;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.util.IPUtils;
import com.sdp.mc.integration.ma.dto.request.MACreateAccountRequestDTO;
import com.sdp.mc.ma.wrapper.impl.MaOsrFullServiceWrapperImpl;

/**
 * 测试创建储值帐号接口
 * **/
public class TestMaCreateAccount {

	private MACreateAccountRequestDTO buildMACreateAccountRequestDTO(String memberId) {
		MACreateAccountRequestDTO req = new MACreateAccountRequestDTO();
		req.setSourceId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);// 来源ID，系统分配,zf号
		req.setRequestNo(UUID.randomUUID().toString());// 请求序列号
		req.setRequestTime(new Date());
		req.setUserIp(IPUtils.getLocalIp());// 用户IP
		req.setAppIp(IPUtils.getLocalIp());// 客户端IP
		req.setMemberId(memberId);
		return req;
	}

	@Test
	public void testCreateAccount() {
		String url = "http://10.132.97.29:9092/ma-osr/MaOsrFullService?wsdl";
		org.apache.cxf.jaxws.JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress(url);
		factory.setServiceClass(IMaOsrFullWS.class);
		IMaOsrFullWS service = (IMaOsrFullWS) factory.create();

		MaOsrFullServiceWrapperImpl m = new MaOsrFullServiceWrapperImpl();
		m.setMaOsrFullService(service);

		String memberId = "203100000000000036613674";
		m.createAccount(this.buildMACreateAccountRequestDTO(memberId));
	}
}
