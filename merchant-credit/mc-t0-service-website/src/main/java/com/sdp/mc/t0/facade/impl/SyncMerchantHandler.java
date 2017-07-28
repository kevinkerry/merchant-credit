package com.sdp.mc.t0.facade.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.dao.readonly.msp.mspposmerchant.MspPosMerchantEO;
import com.sdp.mc.dao.readonly.msp.mspposmerchant.PmtQueryPosMerchantPO;
import com.sdp.mc.dao.readonly.promoter.PromoterEO;
import com.sdp.mc.service.msp.posmerchant.PosMerchantService;
import com.sdp.mc.t0.Constants;
import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.dao.PosMerchantInfoDOExample;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.sdp.withdraw.enums.WithdrawRatioStatusEnums;
import com.sdp.withdraw.enums.WithdrawRatioTypeEnums;
import com.sdp.withdraw.service.WithdrawRatioService;
import com.sdp.withdraw.vo.ratio.WithdrawRatioRequest;
import com.shengpay.logback.mdc.trace.wrapper.InheritTraceNoRunableWrapper;
import com.shengpay.service.withdraw.FwPosMerchantInfoService;
/**
 * 商户快速结算额度试算处理线程
 * @author liyantao01
 *
 */
@Service("SyncMerchantHandler")
public class SyncMerchantHandler  {
	protected final ExecutorService pool = Executors.newFixedThreadPool(50);
	@Autowired
	private FwPosMerchantInfoService fwPosMerchantInfoService;
	@Autowired
	private PosMerchantService posMerchantService;
	@Autowired
	protected Mapper beanMapper;
	@Autowired
	protected WithdrawRatioService merchantWithdrawRatioService;
	


	private Logger logger = LoggerFactory.getLogger(SyncMerchantHandler.class);
	public void execute(PromoterEO promoter,BigDecimal workDayWithDrawRatioT1, BigDecimal holidayWithDrawRatioT1,
			BigDecimal workDayWithDrawRatioD1, BigDecimal holidayWithDrawRatioD1, Date effectiveTime) {
		logger.info("SyncMerchantHandler #execute.");
		SyncMerchantTask transferIngTask = new SyncMerchantTask(promoter, workDayWithDrawRatioT1, holidayWithDrawRatioT1, workDayWithDrawRatioD1, holidayWithDrawRatioD1,effectiveTime);
		pool.execute(new InheritTraceNoRunableWrapper(transferIngTask));
	}


	class SyncMerchantTask implements Runnable {

		private Logger logger = LoggerFactory.getLogger(SyncMerchantTask.class);

		private PromoterEO promoter;
		private BigDecimal workDayWithDrawRatioT1;
		private BigDecimal workDayWithDrawRatioD1;
		private BigDecimal holidayWithDrawRatioT1;
		private BigDecimal holidayWithDrawRatioD1;
		private Date effectiveTime;


		

		public SyncMerchantTask(PromoterEO promoter, BigDecimal workDayWithDrawRatioT1, BigDecimal holidayWithDrawRatioT1,
				BigDecimal workDayWithDrawRatioD1, BigDecimal holidayWithDrawRatioD1, Date effectiveTime) {
			super();
			this.promoter = promoter;
			this.workDayWithDrawRatioT1 = workDayWithDrawRatioT1;
			this.workDayWithDrawRatioD1 = workDayWithDrawRatioD1;
			this.holidayWithDrawRatioT1 = holidayWithDrawRatioT1;
			this.holidayWithDrawRatioD1 = holidayWithDrawRatioD1;
			this.effectiveTime = effectiveTime;
		}


		public void run() {
			PosMerchantInfoDO data=beanMapper.map(promoter, PosMerchantInfoDO.class);
			Long parentPromoterId=getParentPromoterId(promoter);
			if(parentPromoterId!=null){
				data.setParentPromoterId(parentPromoterId);
			}
			PmtQueryPosMerchantPO po=new PmtQueryPosMerchantPO();
			Long promoterBizId = syncMerchantInfo(data);
			po.setPmtMerchantNo(promoter.getMcMerchantNo());
			po.setPmtType(promoter.getMcType());
			//po.setStatus(PosMerchantStatusEnums.MC_STATUS_ACTIVE.code);
			List<MspPosMerchantEO> merchants=posMerchantService.querySyncPosMerchantInfo(po);
			if(merchants!=null&&!merchants.isEmpty()){
				logger.info("merchants size:"+merchants.size());
				for(MspPosMerchantEO merchant:merchants){
					merchant.setCreateTime(null);
					PosMerchantInfoDO merchantData=beanMapper.map(merchant, PosMerchantInfoDO.class);
					merchantData.setParentPromoterId(promoterBizId);
					syncMerchantInfo(merchantData);
				}
			}
			Constants.handleMap.remove(promoter.getPromoterId());
		}

		private Long getParentPromoterId(PromoterEO promot) {
			if(StringUtils.isNotBlank(promot.getPmtParentMerchantNo())){
				String pmtParentType=PosMerchantTypeEnums.MPOS_PROMOTER.code;
				if(promot.getPmtLevel()!=null&&promot.getPmtLevel()>1){
					pmtParentType=PosMerchantTypeEnums.MPOS_SECOND_LEVEL_PROMOTER.code;
				}
				PosMerchantInfoDO info=fwPosMerchantInfoService.getPosMerchantInfoByMerchantInfo(promot.getPmtParentMerchantNo(), pmtParentType);
				if(info!=null){
					return info.getId();
				}
			}
			
			return null;
		}


		private Long syncMerchantInfo(PosMerchantInfoDO data) {
			logger.info("syncMerchantInfo PosMerchantInfoDO:" + ToStringBuilder.reflectionToString(data));
			Long bizId =data.getId();
			if (bizId == null) {
				Long mcId=data.getPosMerchantId();
				PosMerchantInfoDO info = fwPosMerchantInfoService.getPosMerchantInfoByMerchantInfo(data.getMerchantNo(),data.getMerchantType());
				if (info == null) {
					data.setCreateTime(new Date());
					data.setUpdateTime(new Date());
					bizId=fwPosMerchantInfoService.createInfo(data);
				} else {
					bizId = info.getId();
					data.setId(bizId);
					PosMerchantInfoDOExample example=new PosMerchantInfoDOExample();
					example.createCriteria().andIdEqualTo(bizId);
					data.setUpdateTime(new Date());
					fwPosMerchantInfoService.updateByExample(data, example);
				}
				//buildRadioInfo(info);
			}
			return bizId;
		}
		private void buildRadioInfo(PosMerchantInfoDO info) {
			if(info!=null&&PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(info.getMerchantType())){//暂时只处理mpos商户的状态信息
//			     merchantWithdrawRatioService.createT1andD1Ratio(info.getMerchantNo(), info.getMerchantType());
			     WithdrawRatioRequest withdrawRatioRequest=getRadioInfo(info.getMerchantNo(), 
			    		 info.getMerchantType(),
			    		 WithdrawRatioTypeEnums.MPOS_T1_SETTLE_RATIO.code,workDayWithDrawRatioT1,holidayWithDrawRatioT1);
			     merchantWithdrawRatioService.buildWithrawRatio(withdrawRatioRequest,info.getId());
			     WithdrawRatioRequest withdrawRatioRequestD1=getRadioInfo(info.getMerchantNo(), 
			    		 info.getMerchantType(),
			    		 WithdrawRatioTypeEnums.MPOS_D1_SETTLE_RATIO.code,workDayWithDrawRatioD1,holidayWithDrawRatioD1);
			     merchantWithdrawRatioService.buildWithrawRatio(withdrawRatioRequestD1,info.getId());
			}
		}
        private WithdrawRatioRequest getRadioInfo(String merchantNo, String mcType, int code, BigDecimal workDayWithDrawRatio, BigDecimal holidayWithDrawRatio){
        	WithdrawRatioRequest withdrawRatioRequest=new WithdrawRatioRequest();
    		withdrawRatioRequest.setMerchantNo(merchantNo);
    		withdrawRatioRequest.setMerchantType(mcType);
    		//拼装T1费率数据
    		withdrawRatioRequest.setWithDrawRatioStatus(WithdrawRatioStatusEnums.active.code);
    		withdrawRatioRequest.setWithDrawRatioType(code);
    		withdrawRatioRequest.setWorkDayWithDrawRatio(workDayWithDrawRatio);
    		withdrawRatioRequest.setHolidayWithDrawRatio(holidayWithDrawRatio);
    		withdrawRatioRequest.setEffectiveTime(effectiveTime);
    		return withdrawRatioRequest;
        }

	}
}
