package com.sdp.mc.service.newt0.mcmanager.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdo.ma.ws.api.model.MerchantInfo;
import com.sdp.mc.common.constant.LimitRuleInfoConstant;
import com.sdp.mc.common.constant.MerchantContractCst;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.exception.FastSettleLimitException;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.util.HttpUtils;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.vo.MCProductInfo;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.ffconfig.manager.FastSettleConfigManager;
import com.sdp.mc.msp.manager.FsConfigChangeManager;
import com.sdp.mc.service.McManagerService;
import com.sdp.mc.service.dcreport.MCMerchantTradeService;
import com.sdp.mc.service.limitrule.LimitRuleInfoService;
import com.sdp.mc.service.newt0.loaning.config.impl.LoaningCongfigServiceImpl;
import com.sdp.mc.view.dao.ViewMerchantInfoDTO;
import com.sdp.withdraw.manager.ext.ExtWithdrawReqManager;
import com.shengpay.commom.config.GlobalConfig;
import com.shengpay.mpos.realname.MerchantRealNameMPOS;
import com.shengpay.mpos.realname.MposMerchantRealNameQuery;
import com.shengpay.pos.PosExternalService;
import com.shengpay.service.view.MerchantInfoService;

@Service("mcManagerService")
public class McManagerServiceImpl implements McManagerService {
	private Logger logger = LoggerFactory.getLogger(LoaningCongfigServiceImpl.class);
	public static final String MACTH = "1";
	public static final String NOTMATCH = "0";
	// 细化商户日限额标记
	public static final String LIMITFLAG = "1";

	@Autowired
	private MCMerchantTradeService merchantTradeService;
	@Autowired
	private FsConfigChangeManager fsConfigChangeManager;
	@Autowired
	private FastSettleConfigManager fastSettleConfigManager;
	@Autowired
	private MposMerchantRealNameQuery mposMerchantRealNameQuery;
	@Autowired
	private MerchantRealNameMPOS realNameMpos;
	@Autowired
	private LimitRuleInfoService limitRuleInfoService;
	@Autowired
	private PosExternalService posExternalService;
	@Autowired
	private ExtWithdrawReqManager extWithdrawReqManager;
	@Autowired
	private MerchantInfoService merchantInfoService;

	@Override
	public String getChangFeeFlag(String merchantNo) {
		// 入网时间是否大于6个月
		boolean timeFlag = merchantTradeService.selectOPenContract(merchantNo);
		boolean amountFlag = false;
		// 近三个月交易额是否大于十万
		try {
			amountFlag = merchantTradeService.monthTradeAmount(merchantNo);
		} catch (Exception e) {
			logger.error("Them erchantContractService's methods monthTradeAmount has Exception" + e.getMessage(), e);
		}
		if (timeFlag && amountFlag) { return McManagerServiceImpl.MACTH; }
		return McManagerServiceImpl.NOTMATCH;
	}

	@Override
	@Deprecated
	public BigDecimal getDayOfAmount(String merchantNo) {
		/*BigDecimal dayOfAmount = null;
		BigDecimal baseAmount = null;
		try {
			dayOfAmount = merchantTradeService.getDayOfAmount(merchantNo);
		} catch (Exception e) {
			logger.error("Them erchantContractService's methods getDayOfAmount has Exception" + e);
			e.printStackTrace();
		}
		if (StringUtils.isNotBlank(McManagerServiceImpl.LIMITFLAG)) {
			if (dayOfAmount.compareTo(BigDecimal.ZERO) >= 0 && dayOfAmount.compareTo(new BigDecimal(40000)) < 0) {
				return new BigDecimal(20000);
			} else if ((dayOfAmount.compareTo(new BigDecimal(40000)) >= 0 && dayOfAmount.compareTo(new BigDecimal(50000)) < 0)
					|| (dayOfAmount.compareTo(new BigDecimal(100000)) >= 0 && dayOfAmount.compareTo(new BigDecimal(200000)) < 0)) {
				baseAmount = dayOfAmount.divide(new BigDecimal(2));
				return baseAmount;
			} else if (dayOfAmount.compareTo(new BigDecimal(50000)) >= 0 && dayOfAmount.compareTo(new BigDecimal(100000)) < 0) {
				return new BigDecimal(50000);
			} else if (dayOfAmount.compareTo(new BigDecimal(200000)) >= 0) {
				return new BigDecimal(100000);
			} else {
				return BigDecimal.ZERO;
			}
		} else {
			baseAmount = MerchantCreditConstant.MERCHANT_LOANING_TYPE_SHENGPAY_MAX_LIMIT;
			dayOfAmount = dayOfAmount.divide(new BigDecimal(2));
			if (dayOfAmount != null) { return baseAmount.compareTo(dayOfAmount) > 0 ? baseAmount : dayOfAmount; }
			return baseAmount;
		}*/
		return BigDecimal.ZERO;

	}

	@Override
	public BigDecimal getPageDayOfAmount(String merchantNo, String mcType) {
		try {
			return limitRuleInfoService.cmoputeFastSettleAmount(merchantNo, mcType, LimitRuleInfoConstant.LIMIT_RULE_COMPUTE_SOURCE_PAGE);
		} catch (FastSettleLimitException e) {
			logger.error(
					"The McManagerServiceImpl methods getPageDayOfAmount ,merchantNo:" + merchantNo + " response ErrorMessageVO" + e.getMessage(), e);
		}
		return BigDecimal.ZERO;
	}

	@Override
	public BigDecimal getAutoUpdateDayOfAmount(String merchantNo, String mcType) throws FastSettleLimitException {
		//return limitRuleInfoService.cmoputeFastSettleAmount(merchantNo, mcType, LimitRuleInfoConstant.LIMIT_RULE_COMPUTE_SOURCE_AOTU_UPDATE);
		return cmoputeFastSettleAmount(merchantNo, mcType);
	}

	private BigDecimal cmoputeFastSettleAmount(String merchantNo, String mcType) {
		logger.info(" cmoputeFastSettleAmount init  merchantNo:{},mcType:{}",new Object[]{merchantNo,mcType});
		//查询商户信息
		ViewMerchantInfoDTO merchantInfo=merchantInfoService.queryMerchantInfoByMerchantNo(merchantNo, mcType);
		logger.info(" cmoputeFastSettleAmount merchantInfo:"+ToStringBuilder.reflectionToString(merchantInfo, ToStringStyle.SIMPLE_STYLE));
		if(merchantInfo==null){
			logger.info("cmoputeFastSettleAmount merchantInfo is null");
			return BigDecimal.ZERO;
		}
		if(merchantInfo.getMerchantFsFlag()!=MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN_INT
				||merchantInfo.getPromoterFsFlag()!=MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN_INT
				||merchantInfo.getMerchantFsLimit()==null
				||BigDecimal.ZERO.compareTo(merchantInfo.getMerchantFsLimit())>=0){
			logger.info("cmoputeFastSettleAmount merchant or promoter not open fast settle");
			return BigDecimal.ZERO;
		}
		//商户当前额度
		BigDecimal merchantLowerLimit=ConfigOptionHelper.getBigDecimalByKey(MerchantCreditConstant.MERCHANT_LOWER_LIMIT_CONFIG,new BigDecimal(5000));
		logger.info("cmoputeFastSettleAmount merchantLowerLimit:"+merchantLowerLimit);
		if(merchantLowerLimit.compareTo(merchantInfo.getMerchantFsLimit())>=0){
			return merchantInfo.getMerchantFsLimit();
		}
		//商户最近三个月的交易额（发起T0的总金额）  若三个月T0交易总额<T0日额度*50%，则T0日额度下降50%（最低5000元）。每季度的1号进行检测并调整
		BigDecimal totalAmount=extWithdrawReqManager.queryWithdrawReqTotalAmount(merchantNo,mcType,DateUtil.getMothFirstDay(-1),DateUtil.getMothLastDay(-4));
		logger.info("cmoputeFastSettleAmount 3 month totalAmount:"+totalAmount);
		if(totalAmount==null||BigDecimal.ZERO.compareTo(totalAmount)>=0||merchantInfo.getMerchantFsLimit().multiply(new BigDecimal(0.5)).compareTo(totalAmount)<0){
			if(merchantInfo.getMerchantFsLimit().multiply(new BigDecimal(0.5)).compareTo(merchantLowerLimit)<0){
				return merchantLowerLimit;
			}else{
				logger.info("cmoputeFastSettleAmount totalAmount/2 > merchantLowerLimit:"+merchantLowerLimit);
				return merchantInfo.getMerchantFsLimit().multiply(new BigDecimal(0.5));
			}
		}
		
		return merchantInfo.getMerchantFsLimit();
	}

	@Override
	public String getChangFeeLimitFlag(long merchantId) {
		int sum = fsConfigChangeManager.selectChangeFeeSum(merchantId);
		// 每月最多2次，否则超限
		/*
		 * if(sum >= 2){//2016-05-23 不再限制修改次数 return
		 * McManagerServiceImpl.NOTMATCH; }
		 */
		return McManagerServiceImpl.MACTH;
	}

	

	@Override
	public boolean isRealNameAuthentication(String merchantNo, String merchantType) {
		try {
			ErrorMessageVO message = realNameMpos.authQuery(merchantNo, MerchantCreditConstant.MC_WEBSITE_ZF_NO);
			if (message != null) {
				logger.info("The McManagerServiceImpl methods isRealNameAuthentication ,merchantNo:" + merchantNo + " response ErrorMessageVO"
						+ message.toString());
				if (message.isSuccess()) {
					if ("0".equals(message.getErrorCode())) {
						Map<String, Object> map = message.getParams();
						if (map == null) return false;
						if (!map.containsKey("authStatus")) return false;
						if (null == map.get("authStatus")) return false;
						if ("20".equals(map.get("authStatus").toString()))
							return true;
						else return false;
					}
				}
			}
		} catch (Exception e) {
			logger.error("The McManagerServiceImpl methods isRealNameAuthentication has Exception" + e.getMessage(), e);
		}
		return false;
	}

	@Override
	public boolean isSatisfyRegistrationDate(String merchantNo, String merchantType) {
		try {
			final String t0MposMcreditCreatetime = ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.T0_MPOS_MCREDIT_CREATETIME);
			final String proCode = ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.T0_MPOS_PRODUCTS_CODE);
			if (StringUtils.isBlank(t0MposMcreditCreatetime)) {
				logger.info("The McManagerServiceImpl methods isSatisfyRegistrationDate t0MposMcreditCreatetime is null ");
				return false;
			}
			if (StringUtils.isBlank(proCode)) {
				logger.info("The McManagerServiceImpl methods isSatisfyRegistrationDate proCode is null ");
				return false;
			}

			Date t0MposMcreditCreateDate = DateUtil.parse2Date(t0MposMcreditCreatetime);
			ErrorMessageVO message = mposMerchantRealNameQuery.cntractQueryService(merchantNo, MerchantCreditConstant.MC_WEBSITE_ZF_NO);
			if (message != null) {
				logger.info("The McManagerServiceImpl methods isSatisfyRegistrationDate ,merchantNo:" + merchantNo + " response ErrorMessageVO"
						+ message.toString());
				if (message.isSuccess()) {
					Map<String, Object> map = message.getParams();
					if ("0".equals(message.getErrorCode())) {
						if (map == null) return false;
						if (!map.containsKey("products")) return false;
						MCProductInfo[] minfos = (MCProductInfo[]) map.get("products");
						for (int i = 0; i < minfos.length; i++) {
							MCProductInfo info = minfos[i];
							Date effectiveDate = DateUtil.parse2Date(info.getBeginTime());
							if (proCode.equals(info.getProductCode())) {
								if (DateUtil.compareDate(effectiveDate, t0MposMcreditCreateDate) >= 0) { return true; }
							}
						}

					}
				}
			}
		} catch (Exception e) {
			logger.error("The McManagerServiceImpl methods isSatisfyRegistrationDate has Exception" + e.getMessage(), e);
		}
		return false;
	}
	@Override
	public boolean isCreditAuthentication(String merchantNo) {
		try {
			//暂时开启使用是否使用信用认证标示
			/*boolean isOpenCreditAuthentication = this.configOptionManager.getBooleanByKey(MerchantCreditConstant.IS_OPEN_CREDIT_AUTHENTICATION);
			if(!isOpenCreditAuthentication){
				logger.info("isCreditAuthentication not OpenCreditAuthentication===================");
				return true;
			}*/
			int num=posExternalService.queryCreditAuthentication(merchantNo);
			return num>=1;
		} catch (Exception e) {
			logger.error("isCreditAuthentication has Exception" + e.getMessage(), e);
		}
		return false;
	}

	@Override
	public boolean isEasypayMerchantCreditAuthentication(String merchantNo) {
		logger.info("isEasypayMerchantCreditAuthentication merchantNo:{}",merchantNo);
		try {
			String url=GlobalConfig.getString(MerchantContractCst.EASYPAY_MERCHANT_CREDIT_AUTHENTICATION_URL);
			if(StringUtils.isBlank(url)){
				logger.info("isEasypayMerchantCreditAuthentication url is null");
				return false;
			}
			Map<String,Object> resultMap=HttpUtils.get2Map(url+"/"+merchantNo);
			logger.info("isEasypayMerchantCreditAuthentication resultMap:{}",ToStringBuilder.reflectionToString(resultMap, ToStringStyle.SIMPLE_STYLE));
			if(resultMap==null||resultMap.get("success")==null){
				logger.info("isEasypayMerchantCreditAuthentication resultMap null");
				return false;
			}
			return new Boolean(resultMap.get("success").toString());
		} catch (Exception e) {
			logger.error("isEasypayMerchantCreditAuthentication Exception",e);
		}
		return false;
	}

}
