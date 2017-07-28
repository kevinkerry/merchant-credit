package com.sdp.mc;

import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.mc.service.api.TimedTaskAPI;
import com.sdp.mc.common.constant.HessianServiceUrlConstant;
import com.sdp.mc.common.hessian.RemotingCallUtil;
import com.sdp.mc.service.McManagerService;
import com.sdp.mc.service.fastsettle.FastSettle;
import com.sdp.mc.service.newt0.loaning.config.LoaningCongfigService;

@Service("McBaseService")
public class McBaseService {
	
	private FastSettle fastSettle; 
	
	private LoaningCongfigService loaningCongfigService;
	
	private TimedTaskAPI timedTaskAPI;
	
	private McManagerService mcManagerService;
	
	public FastSettle getFastSettle() {
		try {//先从容器中获取对象
			if (fastSettle == null){
				WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
				fastSettle=(FastSettle) wac.getBean("fastSettle");
			}
		} catch (Exception e) {
		}
		//容器中没有，调用接口获取
		if (fastSettle == null) {
			fastSettle = RemotingCallUtil.getHessianServiceUrlWithoutCanonicalName(HessianServiceUrlConstant.MC_SERIVCE_FAST_SETTLE,
					FastSettle.class);
		}
		return fastSettle;
	}

	public TimedTaskAPI getTimedTaskService() {
		try {//先从容器中获取对象
			if (timedTaskAPI == null){
				WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
				timedTaskAPI=(TimedTaskAPI) wac.getBean("timedTaskInfoService");
			}
		} catch (Exception e) {
		}
		//容器中没有，调用接口获取
		if (timedTaskAPI == null) {
			timedTaskAPI = RemotingCallUtil.getHessianServiceUrlWithoutCanonicalName(HessianServiceUrlConstant.MC_SERIVCE_TIMED_TASK_API,
					TimedTaskAPI.class);
		}
		return timedTaskAPI;
	}
	
	public LoaningCongfigService getLoaningCongfigService() {
		try {//先从容器中获取对象
			if (loaningCongfigService == null){
				WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
				loaningCongfigService=(LoaningCongfigService) wac.getBean("loaningCongfigService");
			}
		} catch (Exception e) {
		}
		//容器中没有，调用接口获取
		if (loaningCongfigService == null) {
			loaningCongfigService = RemotingCallUtil.getHessianServiceUrlWithoutCanonicalName(HessianServiceUrlConstant.MC_SERIVCE_LOANING_CONGFIG_SERVICE,
					LoaningCongfigService.class);
		}
		return loaningCongfigService;
	}
	
	public McManagerService getMcManagerService() {
		try {//先从容器中获取对象
			if (mcManagerService == null){
				WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
				mcManagerService=(McManagerService) wac.getBean("mcManagerService");
			}
		} catch (Exception e) {
		}
		//容器中没有，调用接口获取
		if (mcManagerService == null) {
			mcManagerService = RemotingCallUtil.getHessianServiceUrlWithoutCanonicalName(HessianServiceUrlConstant.MC_SERIVCE_MANAGER_SERVICE,
					McManagerService.class);
		}
		return mcManagerService;
	}
	

}
