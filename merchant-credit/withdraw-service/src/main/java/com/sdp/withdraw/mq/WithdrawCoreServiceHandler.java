package com.sdp.withdraw.mq;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.mc.common.dto.WithdrawCoreServiceDTO;
import com.sdp.mc.common.enums.withdraw.WithdrawReqStatusEnums;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.service.LimitationService;
import com.sdp.withdraw.service.WithdrawFailService;
import com.sdp.withdraw.service.WithdrawReqFosDetailService;
import com.sdp.withdraw.service.WithdrawReqService;
import com.sdp.withdraw.service.WithdrawT0ServiceService;
import com.sdp.withdraw.worker.WithdrawCallCoreServiceHandler;
import com.shengpay.logback.mdc.trace.utils.TraceNoUtils;
import com.snda.mq.handler.notify.AbstractNotifyMessageHandler;

/**
 * 调用核心出款服务的MQ监控类
 * @author liyantao01
 *
 */
public class WithdrawCoreServiceHandler extends AbstractNotifyMessageHandler {

	private Logger logger = LoggerFactory
			.getLogger(WithdrawCoreServiceHandler.class);

    /**
     * fos异步通知并不返回appId
     */
   private final String           appId  = "ZF910";
   @Autowired
   private  WithdrawT0ServiceService withdrawT0ServiceService=null;
   @Autowired
   private  WithdrawFailService withdrawFailService=null;
   @Autowired
   private  WithdrawReqService withdrawReqService=null;
   @Autowired
   private  WithdrawReqFosDetailService withdrawReqFosDetailService=null;
   @Autowired
   private  LimitationService limitationService=null;
   @Autowired
   private  WithdrawCallCoreServiceHandler withdrawCallCoreServiceHandler=null;


    @Override
    public void handleMessage(Object request) throws Exception {
    	TraceNoUtils.newTraceNo();
        if (request == null) {
        	logger.info("WithdrawCoreServiceHandler #handleMessage queue object is null");
            return;
        }
        try {
			WithdrawCoreServiceDTO serviceDTO=(WithdrawCoreServiceDTO) request;
		    //调用核心服务
			WithdrawReqDO reqDo=withdrawReqService.queryWithdrawReqByReqId(serviceDTO.getReqId());
			if(reqDo!=null&&WithdrawReqStatusEnums.WAITTING.code.equals(reqDo.getStatus())){
				/*ErrorMessageVO<Object> message=withdrawT0ServiceService.withdrawCoreService(serviceDTO);
				if(message.isSuccess()){//申请成功  出款状态处理中
					withdrawReqFosDetailService.updateData(serviceDTO.getDetailId(),null,null,WithdrawOrderStatusEnums.WAITTING.code,null);
				}else{
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
				}*/
				//多线程处理mq监听数据  7月12号以后的版本启用
               withdrawCallCoreServiceHandler.execute(serviceDTO, reqDo);
			}else{
				logger.info("WithdrawCoreServiceHandler #handleMessage WithdrawReqDO is null,request:"+ToStringBuilder.reflectionToString(request));
			}
		} catch (Exception e) {
			logger.error("WithdrawCoreServiceHandler #handleMessage exception  ,request:"+ToStringBuilder.reflectionToString(request),e);
		}finally {
			TraceNoUtils.clearTraceNo();
		}
    }

    
}
