package com.sdp.mc.service.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:applicationContext-dataSource4inte.xml",
		"classpath*:applicationContext_transaction4inte.xml",
		"classpath*:applicationContext_mybatisSessionFactory.xml",
		"classpath:META-INF/spring/mc_dao_mybatis.xml",
		"classpath*:test_mc_service.xml"
		})
public class MCServiceBaseTest {

	
}