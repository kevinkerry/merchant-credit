package com.sdp.withdraw;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.mc.common.job.CronTriggerJob;
import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.service.LimitationService;
import com.shengpay.logback.mdc.trace.utils.TraceNoUtils;
import com.shengpay.service.withdraw.FwPosMerchantInfoService;

/**
 * 同步额度日历job
 * 
 * @author wangmindong 2016年3月7日 17:28:10
 */
@CronTriggerJob(cronExpression = "${sync.withdraw.calendar}", jobName = "同步额度日历")
// @CronTriggerJob(cronExpression = "0 0/1 * * * ?", jobName = "同步额度日历")
public class SynchWithdrawInfoJob {

	private static final Logger logger = LoggerFactory.getLogger(SynchWithdrawInfoJob.class);
	@Autowired
	private FwPosMerchantInfoService fwPosMerchantInfoService;

	// @Autowired
	// private WorkCalendarService workCalendarService;

	public synchronized void execute() {
		TraceNoUtils.newTraceNo();
		Long start = System.currentTimeMillis();
		try {
			logger.info("sync.withdraw.calendar start...");
		    int updateNum=fwPosMerchantInfoService.updateMerchantWithdrawInfo(true);
			logger.info("sync.withdraw.updateMerchantWithdrawInfo,updateNum:{},useTimes:{}",new Object[]{updateNum,(System.currentTimeMillis()-start)/1000});
			int createNum=fwPosMerchantInfoService.createNewMerchantWithdrawInfo();
			logger.info("sync.withdraw.createNewMerchantWithdrawInfo,createNum:{},useTimes:{}",new Object[]{createNum,(System.currentTimeMillis()-start)/1000});
			logger.info("sync.withdraw.calendar end...耗时:[" + (System.currentTimeMillis() - start)/1000 + "]");
		} catch (Exception e) {
			logger.error("sync.withdraw.calendar is error：", e);
		} finally {
			TraceNoUtils.clearTraceNo();
		}
	}
/*	public synchronized void execute() {
		TraceNoUtils.newTraceNo();
		Long start = System.currentTimeMillis();
		try {
			logger.info("sync.withdraw.calendar start...");
			// TODO 查询所有商户信息
			// List<PosMerchantInfoDO> posList =
			// limitationService.findPosMerchantInfo(new
			// PosMerchantInfoDOExample());
			List<PosMerchantInfoDO> promoterList = fwPosMerchantInfoService.selectOpenFastSettlePromoterInfo();
			if (promoterList == null || promoterList.isEmpty()) { return; }
			// TODO 是否节假日
			// boolean isHoliday = workCalendarService.isHolidayTime(new
			// Date());
			// boolean yestoryIsHoliday =
			// workCalendarService.isHolidayTime(com.sdp.mc.common.util.DateUtil.increaseDate(new
			// Date(), -1));
			// TODO 2、判断是MPOS商户、POS商户、代理商
			for (PosMerchantInfoDO posInfo : promoterList) {
				try {
					limitationService.syncWithdrawInfoBy(posInfo);
					List<PosMerchantInfoDO> merchantList = fwPosMerchantInfoService.selectOpenFastSettleMerchantInfoByPromoterId(posInfo
							.getPosMerchantId());
					synMerchantInfo(merchantList);
				} catch (Exception e) {
					logger.error("syncOpenFastSettlePromoterInfo Exception,PosMerchantInfoDO:"+ToStringBuilder.reflectionToString(posInfo), e);
				}
			}
			Long end = System.currentTimeMillis();
			logger.info("sync.withdraw.calendar end...耗时:[" + (end - start) + "]");
		} catch (Exception e) {
			logger.error("sync.withdraw.calendar is error：", e);
		} finally {
			TraceNoUtils.clearTraceNo();
		}
	}

	private void synMerchantInfo(List<PosMerchantInfoDO> merchantList) {
		if(merchantList!=null){
			for (PosMerchantInfoDO posInfo : merchantList) {
				try {
					limitationService.syncWithdrawInfoBy(posInfo);
				} catch (Exception e) {
					logger.error("syncOpenFastSettleMerchantInfo Exception,PosMerchantInfoDO:"+ToStringBuilder.reflectionToString(posInfo), e);
				}
			}
		}

	}
	*/
}
