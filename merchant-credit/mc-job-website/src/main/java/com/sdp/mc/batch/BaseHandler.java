package com.sdp.mc.batch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.facade.msp.MspFacade;
import com.sdp.mc.ffconfig.manager.FastSettleConfigManager;
import com.sdp.mc.fos.manager.MarginTransManager;
import com.sdp.mc.margin.manager.MarginOpReqManager;

public class BaseHandler {

	protected final ExecutorService pool = Executors.newFixedThreadPool(20);

	@Autowired
	protected MarginOpReqManager marginOpReqManager;
	@Autowired
	protected MarginTransManager marginTransManager;
	@Autowired
	protected FastSettleConfigManager fastSettleConfigManager;
	@Autowired
	protected MspFacade mspFacade;
	@Autowired
	protected ConfigOptionManager configOptionManager;
}
