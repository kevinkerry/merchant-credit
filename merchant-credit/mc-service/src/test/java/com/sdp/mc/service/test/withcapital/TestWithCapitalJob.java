package com.sdp.mc.service.test.withcapital;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.mc.service.credit4promoter.MCWithCapital4PromoterService;
import com.sdp.mc.service.test.MCServiceBaseTest;

public class TestWithCapitalJob extends MCServiceBaseTest {
	private static final Logger log = LoggerFactory.getLogger(TestWithCapitalJob.class);
	@Autowired
	private MCWithCapital4PromoterService mcWithCapital4PromoterService;

	//@Test
	public void resetCreditLimit4Job() {
		try {
			log.info("TestWithCapitalJob.start...");
			this.mcWithCapital4PromoterService.resetCreditLimit4Job();
			log.info("TestWithCapitalJob.finished...");
		} catch (Exception e) {
			log.error("TestWithCapitalJob.error", e);
		}
	}

	@Test
	public void resetRetryRecoveryMspFastSettleLimit4Job() {
		try {
			log.info("TestWithCapitalJob.start...");
			this.mcWithCapital4PromoterService.retryRecoveryMspFastSettleLimit4Job();
			log.info("TestWithCapitalJob.finished...");
		} catch (Exception e) {
			log.error("TestWithCapitalJob.error", e);
		}
	}
	
}
