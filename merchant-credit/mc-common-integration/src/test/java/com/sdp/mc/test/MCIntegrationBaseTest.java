package com.sdp.mc.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:META-INF/spring/mc_integration_service.xml",
		"classpath:mc_property.xml"
		})
public class MCIntegrationBaseTest {

}
