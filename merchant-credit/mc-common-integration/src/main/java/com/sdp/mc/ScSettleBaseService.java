package com.sdp.mc;

import org.springframework.stereotype.Service;

import com.sdp.mc.common.hessian.RemotingCallUtil;
import com.sdp.mc.common.settle.SettleApiConstants;
import com.sdp.mc.settle.api.business.CalculateProfitAPI;
import com.sdp.mc.settle.api.business.DownloadsTaskAPI;
import com.sdp.mc.settle.api.business.GroupingInfoManagerAPI;
import com.sdp.mc.settle.api.business.MccInfoManagerAPI;
import com.sdp.mc.settle.api.business.MerchantGroupManagerAPI;
import com.sdp.mc.settle.api.business.PartnerPromfitConfigAPI;
import com.sdp.mc.settle.api.business.PartnerPromfitQueryAPI;
import com.sdp.mc.settle.api.business.PromoterDailyProfitsAPI;
import com.sdp.mc.settle.api.business.PromoterDailyReportAPI;
import com.sdp.mc.settle.api.business.PromoterProfitsInfoAPI;
import com.sdp.mc.settle.api.business.ScStairAwardConfigAPI;
import com.sdp.mc.settle.api.business.ScUnderPromoterRuleInfoAPI;
import com.sdp.mc.settle.api.business.SettleMerchantInfoAPI;
import com.sdp.mc.settle.api.business.SettleOrderServiceAPI;
import com.sdp.mc.settle.api.business.SplittingComputeLogAPI;
import com.sdp.mc.settle.api.business.SplittingRuleInfoAPI;

@Service
public class ScSettleBaseService {

	/**
	 * 分组维护
	 */
	private GroupingInfoManagerAPI groupInfoAPI;
	/**
	 * 商户分组
	 */
	private MerchantGroupManagerAPI merchantGroupInfoAPI;
	/**
	 * 结算单管理
	 */
	private SettleOrderServiceAPI settleOrderServiceApi;
	/**
	 * 周期奖惩
	 */
	private ScStairAwardConfigAPI stairAwardConfigAPI;
	/**
	 * MCC信息管理
	 */
	private MccInfoManagerAPI mccInfoManagerAPI;

	/**
	 * 下级代理商规则配置接口
	 */
	private ScUnderPromoterRuleInfoAPI underPromoterRuleInfoAPI;
	/**
	 * 阶梯奖惩分润数据计算
	 * 计算数据重算
	 * 阶梯奖惩分润数据计算 计算数据重算
	 */
	private CalculateProfitAPI calculateProfitAPI;

	/**
	 * 下载中心
	 */
	private DownloadsTaskAPI downloadsTaskAPI;

	/**
	 * 分润统计
	 */
	private PromoterProfitsInfoAPI promoterProfitsInfoAPI;
	/**
	 * 分润规则
	 */
	private SplittingRuleInfoAPI splittingRuleInfoAPI;

	/**
	 * 查询商户分润规则
	 */
	private SettleMerchantInfoAPI settleMerchantInfoAPI;
	/**
	 * 合作方分润查询
	 */
	private PartnerPromfitQueryAPI partnerPromfitQueryAPI;

	/**
	 * 清算 日常报表
	 */
	private PromoterDailyReportAPI promoterDailyReportAPI;
	/**
	 * 计算日志
	 */
	private SplittingComputeLogAPI splittingComputeLogAPI;
	
	private PartnerPromfitConfigAPI partnerPromfitConfigAPI; 
	
	private PromoterDailyProfitsAPI promoterDailyProfitsAPI; 

	public PromoterProfitsInfoAPI getPromoterProfitsInfoAPI() {
		if (promoterProfitsInfoAPI == null) {
			promoterProfitsInfoAPI = (PromoterProfitsInfoAPI) RemotingCallUtil.getHessianServiceUrlWithoutCanonicalName(
					SettleApiConstants.PROMOTER_PROFITS_INFO_API_HESSIAN_URL, PromoterProfitsInfoAPI.class);
		}
		return promoterProfitsInfoAPI;
	}

	public GroupingInfoManagerAPI getGroupService() {
		if (groupInfoAPI == null) {
			groupInfoAPI = (GroupingInfoManagerAPI) RemotingCallUtil.getHessianServiceUrlWithoutCanonicalName(
					SettleApiConstants.GROUP_INFO_HESSIAN_URL, GroupingInfoManagerAPI.class);
		}
		return groupInfoAPI;
	}

	public DownloadsTaskAPI getDownloadsTaskAPI() {
		if (downloadsTaskAPI == null) {
			downloadsTaskAPI = (DownloadsTaskAPI) RemotingCallUtil.getHessianServiceUrlWithoutCanonicalName(
					SettleApiConstants.DOWNLOADS_FACADE_HESSIAN_URL, DownloadsTaskAPI.class);
		}
		return downloadsTaskAPI;
	}

	public MerchantGroupManagerAPI getMerchantGroupService() {
		if (merchantGroupInfoAPI == null) {
			merchantGroupInfoAPI = (MerchantGroupManagerAPI) RemotingCallUtil.getHessianServiceUrlWithoutCanonicalName(
					SettleApiConstants.MERCHANT_GROUP_INFO_HESSIAN_URL, MerchantGroupManagerAPI.class);
		}
		return merchantGroupInfoAPI;
	}

	public SettleOrderServiceAPI getSettleOrderService() {
		if (settleOrderServiceApi == null) {
			settleOrderServiceApi = (SettleOrderServiceAPI) RemotingCallUtil.getHessianServiceUrlWithoutCanonicalName(
					SettleApiConstants.SC_SETTLE_ORDER_SERVICE_API, SettleOrderServiceAPI.class);
//			settleOrderServiceApi = (SettleOrderServiceAPI) RemotingCallUtil.getHessianServiceUrlWithoutCanonicalName(
//					"http://127.0.0.1:8080/pfs/hessian/settleOrderServiceAPI", SettleOrderServiceAPI.class);
		}
		return settleOrderServiceApi;
	}
	
	public SplittingComputeLogAPI getSplittingComputeLogService() {
		if (splittingComputeLogAPI == null) {
			splittingComputeLogAPI = (SplittingComputeLogAPI) RemotingCallUtil.getHessianServiceUrlWithoutCanonicalName(
					SettleApiConstants.SC_SPLITTING_COMPUTE_LOG_API, SplittingComputeLogAPI.class);
		}
		return splittingComputeLogAPI;
	}

	public ScStairAwardConfigAPI getScStairAwardConfigService() {
		if (stairAwardConfigAPI == null) {
			stairAwardConfigAPI = (ScStairAwardConfigAPI) RemotingCallUtil.getHessianServiceUrlWithoutCanonicalName(
					SettleApiConstants.SC_STAIR_WAWRD_CONFIG_HESSIAN_URL, ScStairAwardConfigAPI.class);
		}
		return stairAwardConfigAPI;
	}

	public CalculateProfitAPI getCalculateProfitAPIService() {
		if (calculateProfitAPI == null) {
			calculateProfitAPI = (CalculateProfitAPI) RemotingCallUtil.getHessianServiceUrlWithoutCanonicalName(
					SettleApiConstants.CALCULATE_PROFIT_API, CalculateProfitAPI.class);
//			calculateProfitAPI = (CalculateProfitAPI) RemotingCallUtil.getHessianServiceUrlWithoutCanonicalName(
//					"http://127.0.0.1:8080/pfs/hessian/calculateProfitServicAPI", CalculateProfitAPI.class);
		}
		return calculateProfitAPI;
	}

	public MccInfoManagerAPI getMccInfoManagerAPI() {
		if (mccInfoManagerAPI == null) {
			mccInfoManagerAPI = (MccInfoManagerAPI) RemotingCallUtil.getHessianServiceUrlWithoutCanonicalName(
					SettleApiConstants.MCC_INFO_HESSIAN_URL, MccInfoManagerAPI.class);
		}
		return mccInfoManagerAPI;
	}


	public ScUnderPromoterRuleInfoAPI getUnderPromoterRuleInfoAPI() {
		if (underPromoterRuleInfoAPI == null) {
			underPromoterRuleInfoAPI = (ScUnderPromoterRuleInfoAPI) RemotingCallUtil.getHessianServiceUrlWithoutCanonicalName(SettleApiConstants.SC_UNDER_PROMOTER_RULE_INFO_API_HESSIAN_URL, ScUnderPromoterRuleInfoAPI.class);
		}
		return underPromoterRuleInfoAPI;
	}
	public SplittingRuleInfoAPI getSplittingRuleInfoAPI() {
		if (splittingRuleInfoAPI == null) {
			splittingRuleInfoAPI = (SplittingRuleInfoAPI) RemotingCallUtil.getHessianServiceUrlWithoutCanonicalName(SettleApiConstants.SPLTTING_RULE_HESSIAN_URL, SplittingRuleInfoAPI.class);
		}
		return splittingRuleInfoAPI;
	}

	public SettleMerchantInfoAPI getSettleMerchantInfoAPI() {
		if (settleMerchantInfoAPI == null) {
			settleMerchantInfoAPI = (SettleMerchantInfoAPI) RemotingCallUtil.getHessianServiceUrlWithoutCanonicalName(SettleApiConstants.SETTLE_MERCHANT_DPL_RUL, SettleMerchantInfoAPI.class);
		}
		return settleMerchantInfoAPI;
	}
	public PartnerPromfitQueryAPI getPartnerPromfitQueryAPI() {
		if (partnerPromfitQueryAPI == null) {
			partnerPromfitQueryAPI = (PartnerPromfitQueryAPI) RemotingCallUtil.getHessianServiceUrlWithoutCanonicalName(SettleApiConstants.PARTNER_PROMFIT_QUERY_API_RUL, PartnerPromfitQueryAPI.class);
		}
		return partnerPromfitQueryAPI;
	}

	public PromoterDailyReportAPI getPromoterDailyReportAPI() {
		if (promoterDailyReportAPI == null) {
			promoterDailyReportAPI = (PromoterDailyReportAPI) RemotingCallUtil.getHessianServiceUrlWithoutCanonicalName(SettleApiConstants.PROMOTER_DAILY_REPORT_API_RUL, PromoterDailyReportAPI.class);
		}
		return promoterDailyReportAPI;
	}
	
	public PartnerPromfitConfigAPI getPartnerPromfitConfigAPI() {
		//容器中没有，调用接口获取
		if (partnerPromfitConfigAPI == null) {
			partnerPromfitConfigAPI = RemotingCallUtil.getHessianServiceUrlWithoutCanonicalName(SettleApiConstants.PARTNER_PROMFIT_CONFIG_API_RUL,
					PartnerPromfitConfigAPI.class);
		}
		return partnerPromfitConfigAPI;
	}
	
	public PromoterDailyProfitsAPI getPromoterDailyProfitsAPI() {
		//容器中没有，调用接口获取
		if (promoterDailyProfitsAPI == null) {
			promoterDailyProfitsAPI = RemotingCallUtil.getHessianServiceUrlWithoutCanonicalName(SettleApiConstants.PROMOTER_DAILY_PROFITS_API_RUL,
					PromoterDailyProfitsAPI.class);
		}
		return promoterDailyProfitsAPI;
	}


}
