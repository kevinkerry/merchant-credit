package com.sdp.withdraw.service.impl;

import javax.jms.DeliveryMode;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.dto.WithdrawCoreServiceDTO;
import com.sdp.mc.common.enums.withdraw.WithdrawOrderStatusEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawReqStatusEnums;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.service.LimitationService;
import com.sdp.withdraw.service.WithdrawCallQueueService;
import com.sdp.withdraw.service.WithdrawFailService;
import com.sdp.withdraw.service.WithdrawReqFosDetailService;
import com.sdp.withdraw.service.WithdrawReqService;
import com.sdp.withdraw.service.WithdrawT0ServiceService;
import com.shengpay.commom.config.GlobalConfig;
import com.snda.mq.constant.DestinationType;
import com.snda.mq.core.MQService;
import com.snda.mq.request.notify.DefaultNotifyRequest;
@Service("WithdrawCallQueueService")
public class WithdrawCallQueueServiceImpl implements WithdrawCallQueueService {
	private Logger logger = LoggerFactory
			.getLogger(WithdrawCallQueueServiceImpl.class);

	@Autowired
	@Qualifier("jmsService")
	private MQService jmsService;




	@Override
	public boolean addCallWithdrawCoreServiceDate(WithdrawCoreServiceDTO serviceDTO) {
		try {
			DefaultNotifyRequest<WithdrawCoreServiceDTO> request = new DefaultNotifyRequest<WithdrawCoreServiceDTO>();
			String destination=GlobalConfig.getString(WithdrawConstant.FW_MQ_WITHDRAW_CORE_SERVICE_ADDRESS_KEY,WithdrawConstant.CALL_WITHDRAW_CORE_SERVICE_QUEUE_DESTINATION);
			request.setDestination(destination);
			request.setContent(serviceDTO);
			request.setDestinationType(DestinationType.QUEUE);
			request.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			jmsService.sendMessage(request);
			//不是用MQ 的测试方法
//			handle(serviceDTO);
			logger.info("WithdrawT0ServiceServiceImpl #addCallWithdrawCoreServiceDate is success , serviceDTO:"+ToStringBuilder.reflectionToString(serviceDTO));
			return true;
		} catch (Exception e) {
			logger.error("WithdrawT0ServiceServiceImpl #addCallWithdrawCoreServiceDate:MQException"+e.getMessage(),e);
		}
		return false;

	}

	/**
	 * ======================================mq暂时没有办法使用  直接调用
	 */
	@Autowired
	private  WithdrawT0ServiceService withdrawT0ServiceService;
	@Autowired
	private  WithdrawReqService withdrawReqService;
	@Autowired
	private  WithdrawReqFosDetailService withdrawReqFosDetailService;
	@Autowired
	private  LimitationService limitationService;
	@Autowired
	private  WithdrawFailService withdrawFailService;

	private void handle(WithdrawCoreServiceDTO serviceDTO) {
        if (serviceDTO == null) {
        	logger.info("WithdrawCoreServiceHandler #handleMessage queue object is null");
            return;
        }
        try {
		    //调用核心服务
			WithdrawReqDO reqDo=withdrawReqService.queryWithdrawReqByReqId(serviceDTO.getReqId());
			/*if(reqDo!=null&&WithdrawReqStatusEnums.WAITTING.code.equals(reqDo.getStatus())){
				ErrorMessageVO<Object> message=withdrawT0ServiceService.withdrawCoreService(serviceDTO);
				if(!message.isSuccess()){
					//释放额度
					limitationService.restoreFrozenQuota(reqDo.getMerchantNo(), reqDo.getMcType(), reqDo.getWithdrawAmount());
					withdrawFailService.withdrawFailDealWith(serviceDTO,message.getErrorCode());
				}
			}else{
				logger.info("WithdrawCoreServiceHandler #handleMessage WithdrawReqDO is null,reqId:"+serviceDTO.getReqId());
			}*/
		} catch (Exception e) {
			logger.error("WithdrawCoreServiceHandler #handleMessage exception  "+e.getMessage(),e);
		}
    }


}
