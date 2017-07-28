package com.sdp.mc.ma.test;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Before;
import org.junit.Test;

import com.sdo.ma.ws.api.model.OperatorInfo;
import com.sdo.ma.ws.api.service.osr.IOperatorWS;
import com.sdp.mc.ma.wrapper.impl.IOperatorWSServiceWrapperImpl;

public class TestIOperatorWSService {
	private IOperatorWS iOperatorWS;
	@Before
	public void init() {
		String url = "http://10.132.97.29:9092/ma-osr/OperatorService?wsdl";
		org.apache.cxf.jaxws.JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress(url);
		factory.setServiceClass(IOperatorWS.class);
		iOperatorWS = (IOperatorWS) factory.create();
	}

	@Test
	public void testQuery() {
		IOperatorWSServiceWrapperImpl service = new IOperatorWSServiceWrapperImpl();
		service.setOperatorWSService(iOperatorWS);
		List<OperatorInfo> list = service.queryOperators("203100000000000112649643");
		for (OperatorInfo operatorInfo : list) {
			String name = operatorInfo.getNickName();
			System.out.println(ToStringBuilder.reflectionToString(name));
		}
	}
}
