package com.sdp.mc.intra.worker.limitrule;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.sdp.mc.common.exception.FastSettleLimitException;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeDtlDO;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeReqDO;
import com.sdp.mc.service.limitchange.MerchantLimitChangeService;
import com.shengpay.logback.mdc.trace.wrapper.InheritTraceNoRunableWrapper;
/**
 * 商户快速结算额度批量修改线程
 * @author liyantao01
 *
 */
@Service("merchantLimitBatchChangeHandler")
public class MerchantLimitBatchChangeHandler  {
	
	
	protected final ExecutorService pool = Executors.newFixedThreadPool(2);
	
	@Autowired
	private MerchantLimitChangeService merchantLimitChangeService;
	
	
	private Logger logger = LoggerFactory.getLogger(MerchantLimitBatchChangeHandler.class);
	public void execute(Long reqId,String operatorId) {
		logger.info("MerchantLimitBatchChangeHandler #execute.");
		MerchantLimitBatchChangeTask transferIngTask = new MerchantLimitBatchChangeTask(reqId,operatorId);
		pool.execute(new InheritTraceNoRunableWrapper(transferIngTask));
	}


	class MerchantLimitBatchChangeTask implements Runnable {

		private Logger logger = LoggerFactory.getLogger(MerchantLimitBatchChangeTask.class);

		private Long reqId;
		
		private String operatorId;

	

		public MerchantLimitBatchChangeTask(Long reqId,String operatorId) {
			this.reqId=reqId;
			this.operatorId=operatorId;
		}

		public void run() {
			logger.info("MerchantLimitBatchChangeHandler #run,reqId：" +reqId);
			Assert.notNull(reqId);
			
			Newt0McLimitChangeReqDO reqDo=merchantLimitChangeService.getReqDoByReqId(reqId);
			if(reqDo!=null&&reqDo.getStatus()==0){
				reqDo.setStatus(1);
				updateReqDo(reqDo);
				
				List<Newt0McLimitChangeDtlDO> detailList=merchantLimitChangeService.queryMarchatLimitChangeDetailByReqId(reqId);
				int successNum=0;
				int failNum=0;
				if(detailList!=null&&detailList.size()>0){
					for(Newt0McLimitChangeDtlDO detailDo:detailList){
						if(detailDo!=null&&detailDo.getStatus()==0){
							String message="";
							int result=0;
							long cfmId=0;
							try {
								cfmId= merchantLimitChangeService.changeMerchantLimit(detailDo,operatorId);
								if(cfmId>0){
									result=1;
								}
							} catch (FastSettleLimitException e) {
								result=2;
								if(e.getFcmId()>0){
									cfmId=e.getFcmId();
								}
								message=e.getMessage();
							} catch (Exception e) {
								result=2;
								message="修改额度时发生异常";
								logger.error("MerchantLimitBatchChangeHandler #run,reqId：" +reqId);
							}
						    if(result==1){
						    	successNum++;
						    }else{
						    	failNum++;
						    }
						    detailDo.setCfmId(cfmId);
						    detailDo.setStatus(result);
						    detailDo.setMessage(message);
						    updateDetailDo(detailDo);
						}
					}
				}
				reqDo.setStatus(2);
				reqDo.setSuccessNum(successNum);
				reqDo.setFailNum(failNum);
				updateReqDo(reqDo);
			}
			
			logger.info("MerchantLimitBatchChangeHandler #end,reqId: "+reqId);
			
		}

		private void updateDetailDo(Newt0McLimitChangeDtlDO detailDo) {
			detailDo.setUpdateTime(new Date());
			merchantLimitChangeService.updateDetailDo(detailDo);
			
		}

		private void updateReqDo(Newt0McLimitChangeReqDO reqDo) {
			reqDo.setUpdateTime(new Date());
			merchantLimitChangeService.updateReqDo(reqDo);
		}

		public String getOperatorId() {
			return operatorId;
		}

		public void setOperatorId(String operatorId) {
			this.operatorId = operatorId;
		}
		
		

	}
}
