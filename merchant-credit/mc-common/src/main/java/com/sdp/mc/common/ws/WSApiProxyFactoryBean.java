package com.sdp.mc.common.ws;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.FactoryBean;

/**
 * WebService API代理工厂
 * @author xuhongbiao.darren
 * @date 2013-8-1 上午09:29:41
 *
 */
@SuppressWarnings("rawtypes")
public class WSApiProxyFactoryBean extends JaxWsProxyFactoryBean implements FactoryBean {

	@Override
	public Object getObject() throws Exception {
		return super.create();
	}

	@Override
	public Class getObjectType() {
		return super.getServiceClass();
	}

	@Override
	public boolean isSingleton() {
		return true;
	}


}
