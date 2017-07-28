package com.sdp.test.mc.job;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;



@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
@TransactionConfiguration(defaultRollback = true)
public abstract class BaseTestCase extends AbstractJUnit4SpringContextTests {


}
