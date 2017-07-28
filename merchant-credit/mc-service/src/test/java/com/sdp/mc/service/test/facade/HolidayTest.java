package com.sdp.mc.service.test.facade;

import java.net.MalformedURLException;
import java.util.Date;

import org.junit.Test;

import com.caucho.hessian.client.HessianProxyFactory;
import com.mc.service.api.McISholidayAPI;

public class HolidayTest {
	@Test
	public void testHoliday(){
		HessianProxyFactory factory = new HessianProxyFactory();
		factory.setOverloadEnabled(true);
		McISholidayAPI bcISholidayAPI;
		try {
			bcISholidayAPI = (McISholidayAPI) factory.create(McISholidayAPI.class, "http://127.0.0.1:8086/mc-service-website/hessian/mcIsHolidayServiceApi");
			boolean falg=bcISholidayAPI.isHolidayTime(new Date());
			Date ldate=bcISholidayAPI.lastWorkingDay(new Date());
			Date ndate=bcISholidayAPI.nextWorkingDay(new Date());
			System.out.println(falg);
			System.out.println(ldate);
			System.out.println(ndate);
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		
	}
}
