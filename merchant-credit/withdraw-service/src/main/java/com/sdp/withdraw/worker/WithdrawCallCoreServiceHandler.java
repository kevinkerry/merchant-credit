package com.sdp.withdraw.worker;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.dto.WithdrawCoreServiceDTO;
import com.sdp.mc.common.enums.withdraw.WithdrawReqStatusEnums;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.service.LimitationService;
import com.sdp.withdraw.service.WithdrawFailService;
import com.sdp.withdraw.service.WithdrawT0ServiceService;
import com.shengpay.logback.mdc.trace.wrapper.InheritTraceNoRunableWrapper;

/**
 * 出款服务回掉，如果调用FOS出款服务，有最终的明确状态，调用回掉线程
 *
 * @author liyantao01
 *
 */
@Service("WithdrawCallCoreServiceHandler")
public class WithdrawCallCoreServiceHandler {

	protected final ExecutorService pool = Executors.newFixedThreadPool(10);
	@Autowired
	private WithdrawT0ServiceService withdrawT0ServiceService = null;
	@Autowired
	private WithdrawFailService withdrawFailService = null;
	@Autowired
	private LimitationService limitationService = null;

	private Logger logger = LoggerFactory.getLogger(WithdrawCallCoreServiceHandler.class);

	public void execute(WithdrawCoreServiceDTO serviceDTO, WithdrawReqDO reqDo) {
		logger.info("WithdrawServiceCallbackHandler #execute.");
		WithdrawCallCoreServiceTask transferIngTask = new WithdrawCallCoreServiceTask(serviceDTO, reqDo);
		pool.execute(new InheritTraceNoRunableWrapper(transferIngTask));
	}

	class WithdrawCallCoreServiceTask implements Runnable {

		private Logger logger = LoggerFactory.getLogger(WithdrawCallCoreServiceTask.class);

		private WithdrawCoreServiceDTO serviceDTO;
	    //调用核心服务
		private WithdrawReqDO reqDo;

		public WithdrawCallCoreServiceTask(WithdrawCoreServiceDTO serviceDTO, WithdrawReqDO reqDo) {
			super();
			this.reqDo = reqDo;
			this.serviceDTO = serviceDTO;
		}

		public void run() {
			logger.info("WithdrawCallCoreServiceTask #run,reqDo:" + ToStringBuilder.reflectionToString(reqDo) + ",serviceDTO:" + ToStringBuilder.reflectionToString(serviceDTO));
			try {
			    //调用核心服务
				if(reqDo!=null&&WithdrawReqStatusEnums.WAITTING.code.equals(reqDo.getStatus())){
					ErrorMessageVO<Object> message=withdrawT0ServiceService.withdrawCoreService(serviceDTO);
					if(!message.isSuccess()){//申请非成功
						//释放额度
						if(reqDo.getWithdrawType()!=null&&WithdrawConstant.withdrawTypeRealTime.equals(reqDo.getWithdrawType().toString())){//实时出款，操作额度，普通出款占用额度
							// 判断额度是否共享
							Date applyDay = reqDo.getCreateTime();
							ErrorMessageVO<Object> quotaShareMessage = limitationService.isQuotoShare(reqDo.getMerchantNo(), reqDo.getMcType(), applyDay, new Date());;
							if(quotaShareMessage!=null&&quotaShareMessage.isSuccess()){
						       limitationService.restoreFrozenQuota(reqDo.getMerchantNo(), reqDo.getMcType(), reqDo.getWithdrawAmount());
							}
						}
						withdrawFailService.withdrawFailDealWith(serviceDTO,message.getErrorCode(),message.getErrorMessage());
					}
				}else{
					logger.info("WithdrawCallCoreServiceTask #handleMessage WithdrawReqDO is null,request:"+ToStringBuilder.reflectionToString(serviceDTO));
				}
			} catch (Exception e) {
				logger.error("WithdrawCallCoreServiceTask #handleMessage exception  ,request:"+ToStringBuilder.reflectionToString(serviceDTO),e);
			}
		}

	}


}
