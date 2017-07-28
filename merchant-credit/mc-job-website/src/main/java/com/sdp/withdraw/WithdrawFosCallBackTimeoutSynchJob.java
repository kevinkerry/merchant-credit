package com.sdp.withdraw;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.drools.core.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.enums.withdraw.WithdrawOrderStatusEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawReqStatusEnums;
import com.sdp.mc.common.job.CronTriggerJob;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.integration.fos.dto.response.WithdrawT0QueryResponseDTO;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDO;
import com.sdp.withdraw.dao.WithdrawRetryPlanDO;
import com.sdp.withdraw.enums.ReturnCodeEnums;
import com.sdp.withdraw.service.LimitationService;
import com.sdp.withdraw.service.WithdrawFailService;
import com.sdp.withdraw.service.WithdrawReqFosDetailService;
import com.sdp.withdraw.service.WithdrawReqService;
import com.sdp.withdraw.service.WithdrawRetryService;
import com.sdp.withdraw.service.WithdrawT0ServiceQueryService;
import com.shengpay.commom.config.GlobalConfig;
import com.shengpay.facade.fos.FOSFacade;
import com.shengpay.logback.mdc.trace.utils.TraceNoUtils;

@CronTriggerJob(cronExpression = "${cron.expression.withdraw.foscallback.timeout.synch}", jobName = "调用FOS等待回掉超时同步任务")
// @CronTriggerJob(cronExpression = "0 * * * * ?", jobName = "调用FOS等待回掉超时同步任务")
public class WithdrawFosCallBackTimeoutSynchJob {

	private Logger logger = LoggerFactory.getLogger(WithdrawFosCallBackTimeoutSynchJob.class);

	@Autowired
	private WithdrawReqFosDetailService withdrawReqFosDetailService = null;
	@Autowired
	private WithdrawReqService withdrawReqService = null;
	@Autowired
	private FOSFacade fosFacade = null;

	@Autowired
	private WithdrawFailService withdrawFailService = null;
	@Autowired
	private LimitationService limitationService = null;
	@Autowired
	private WithdrawT0ServiceQueryService withdrawT0ServiceQueryService = null;
	
	@Autowired
	private ConfigOptionManager configOptionManager;
	@Autowired
	private WithdrawRetryService withdrawRetryService;

	public void execute() {
		try {
			TraceNoUtils.newTraceNo();
			logger.info("WithdrawFosCallBackTimeoutSynchJob execute begin");
			int callbackTimeoutMinute = getCallbackTimeoutMinte();
			List<WithdrawReqFosDetailDO> list = withdrawReqFosDetailService.queryCallbackTimeoutData(callbackTimeoutMinute);
			if (list != null && !list.isEmpty()) {
				for (WithdrawReqFosDetailDO detailDo : list) {
					try {
						dealwithCallBackTimeout(detailDo);
					} catch (Exception e) {
						logger.error("dealwithCallBackTimeout Exception,detailDo:"+ToStringBuilder.reflectionToString(detailDo), e);
					}
				}
			}
			logger.info("WithdrawFosCallBackTimeoutSynchJob execute final");
		} catch (Exception e) {
			logger.error("WithdrawFosCallBackTimeoutSynchJob execute error", e);
		}finally{
			TraceNoUtils.clearTraceNo();
		}
	}

	private int getCallbackTimeoutMinte() {
		try {
			return Integer.valueOf(GlobalConfig.getString(WithdrawConstant.FOS_CALLBACK_TIMEOUT_MINTE,WithdrawConstant.FOS_CALLBACK_TIMEOUT_MINTE_DEFAULT+""));
		} catch (Exception e) {
			
		}
		return WithdrawConstant.FOS_CALLBACK_TIMEOUT_MINTE_DEFAULT;
	}

	/**
	 * 处理
	 *
	 * @param detailDo
	 */
	private void dealwithCallBackTimeout(WithdrawReqFosDetailDO detailDo) {
		if (detailDo != null) {
			detailDo=withdrawReqFosDetailService.getDetailDOById(detailDo.getDetailId());
			if (!WithdrawOrderStatusEnums.WAITTING.code.equals(detailDo.getWithdrawStatus())) {
				logger.info("dealwithCallBackTimeou:WithdrawStatus is not Watting,   detailDo"+ToStringBuilder.reflectionToString(detailDo));
				return;
			}
			logger.info("WithdrawFosCallBackTimeoutSynchJob #dealwithCallBackTimeout detailDo:"+ToStringBuilder.reflectionToString(detailDo));
			WithdrawT0QueryResponseDTO responseDTO = this.withdrawT0ServiceQueryService.queryWithdrawInfo(detailDo);
			logger.info("WithdrawFosCallBackTimeoutSynchJob #dealwithCallBackTimeout ,WithdrawT0QueryResponseDTO:"+ToStringBuilder.reflectionToString(responseDTO));
			if(responseDTO!=null&&responseDTO.getPaymentResult()!=null){
			    logger.info("WithdrawFosCallBackTimeoutSynchJob #dealwithCallBackTimeout ,PaymentResult:"+ToStringBuilder.reflectionToString(responseDTO.getPaymentResult()));
	      	}
			
			WithdrawReqDO reqDo = withdrawReqService.queryWithdrawReqByReqId(detailDo.getReqId());
			if (!WithdrawReqStatusEnums.WAITTING.code.equals(reqDo.getStatus())) {
				logger.info("#dealwithCallBackTimeout reqDo is not watting  ,reqDo:" + ToStringBuilder.reflectionToString(reqDo)+" ,detailDo:"+ ToStringBuilder.reflectionToString(detailDo));
				return;
			}
		
			// 如果出款成功 更新调用详细的状态 更新出款详细的状态 回掉通知是否回掉
			String withdrawStatus = this.withdrawT0ServiceQueryService.dealwithFosWithdrawQueryResponse(responseDTO, reqDo, detailDo);
			//
			Date applyDay = reqDo.getCreateTime();
			ErrorMessageVO<Object> vo=null;
			if(reqDo.getWithdrawType()!=null&&WithdrawConstant.withdrawTypeRealTime.equals(reqDo.getWithdrawType().toString())){
				WithdrawRetryPlanDO planDO = withdrawRetryService.queryRetryPlanInfoByReqIdAndRemitVoucherNo(detailDo.getReqId(),detailDo.getRemitVoucherNo());
				if(planDO!=null&&StringUtils.isEmpty(planDO.getRetryRule())&&planDO.getExecuteTime()!=null){//手动重试的，判断额度按照当前的任务执行的时间
					applyDay=planDO.getExecuteTime();
				}
			   vo = limitationService.isQuotoShare(reqDo.getMerchantNo(),reqDo.getMcType(),applyDay, new Date());
		    }
			if (WithdrawOrderStatusEnums.SUCCESS.code.equals(withdrawStatus)) {
				// 将额度修改已经使用
				if (vo!=null&&vo.isSuccess()) {
					this.limitationService.usefrozenQuotaByIsQuotoShare(reqDo.getMerchantNo(),reqDo.getMcType(), reqDo.getWithdrawAmount(),applyDay);
				}
			} else if (WithdrawOrderStatusEnums.WAITTING.code.equals(withdrawStatus)) {// 处理中

			} else {// 如果失败，进入出款失败处理流程
				if (vo!=null&&vo.isSuccess()) {
					this.limitationService.restoreFrozenQuotaByIsQuotoShare(reqDo.getMerchantNo(),reqDo.getMcType(), reqDo.getWithdrawAmount(),applyDay);
				}
				String errorCode = null;
				String errorMessage= null;
				if (responseDTO != null && responseDTO.getPaymentResult() != null) {
					errorCode = responseDTO.getPaymentResult().getReturnCode();
					errorMessage = responseDTO.getPaymentResult().getReturnMsg();
				} else {
					errorCode = ReturnCodeEnums.FW_FOS_DATA_FAILS.code;
				}
				withdrawFailService.withdrawFailDealWith(withdrawReqFosDetailService.getWithdrawCoreServiceDTOByDo(detailDo), errorCode,errorMessage);
			}

		}

	}
}
