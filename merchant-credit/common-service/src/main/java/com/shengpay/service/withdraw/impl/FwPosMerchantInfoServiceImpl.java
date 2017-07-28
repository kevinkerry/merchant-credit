package com.shengpay.service.withdraw.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mc.service.api.enums.WhiteTypeEnums;
import com.sdp.mc.McBaseService;
import com.sdp.mc.common.bean.newt0.LoaningConfigBean;
import com.sdp.mc.common.bean.whitelist.WhiteListFeeBean;
import com.sdp.mc.common.constant.LimitRuleInfoConstant;
import com.sdp.mc.common.constant.MerchantContractCst;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.enums.CommonStatusEnums;
import com.sdp.mc.common.enums.FastSettleOpenTypeEnums;
import com.sdp.mc.common.enums.LoaningTypeEnum;
import com.sdp.mc.common.enums.PolicyTypeEnums;
import com.sdp.mc.common.enums.withdraw.PosMerchantStatusEnums;
import com.sdp.mc.common.exception.OpenFastSettleException;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.vo.MerchantFastSettleVO;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.dao.readonly.msp.mspposmerchant.PmtQueryPosMerchantPO;
import com.sdp.mc.newt0.dao.WhiteListInfoDO;
import com.sdp.mc.view.dao.ViewMerchantInfoDTO;
import com.sdp.withdraw.dao.PolicyConfigInfoDO;
import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.dao.PosMerchantInfoDOExample;
import com.sdp.withdraw.dao.daointerface.PosMerchantInfoDAO;
import com.sdp.withdraw.dao.daointerface.ext.ExtPosMerchantInfoDAO;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.sdp.withdraw.enums.ReturnCodeEnums;
import com.sdp.withdraw.manager.PosMerchantInfoManager;
import com.sdp.withdraw.manager.ext.ExtWithdrawInfoManager;
import com.sdp.withdraw.vo.ratio.WithdrawRatioResponse;
import com.shengpay.commons.core.base.PaginationBaseObject;
import com.shengpay.service.view.MerchantInfoService;
import com.shengpay.service.whitelist.WhiteListInfoService;
import com.shengpay.service.withdraw.FwPosMerchantInfoService;
import com.shengpay.service.withdraw.MerchantLimitRuleService;
import com.shengpay.service.withdraw.PolicyConfigInfoService;
import com.shengpay.service.withdraw.T0WithdrawService;

@Service("FwPosMerchantInfoService")
public class FwPosMerchantInfoServiceImpl implements FwPosMerchantInfoService {
	private Logger logger = LoggerFactory.getLogger(FwPosMerchantInfoServiceImpl.class);

	@Autowired
	private PosMerchantInfoManager posMerchantInfoManager;
	@Autowired
	private ExtPosMerchantInfoDAO extPosMerchantInfoDAO;
	@Autowired
	private PosMerchantInfoDAO posMerchantInfoDAO;
	@Autowired
	private McBaseService mcBaseService;
	@Autowired
	private MerchantInfoService merchantInfoService;
	@Autowired
	private WhiteListInfoService whiteListInfoService;
	@Autowired
	private ConfigOptionManager configOptionManager;
	@Autowired
	private ExtWithdrawInfoManager extWithdrawInfoManager;
	@Autowired
	private T0WithdrawService t0WithdrawService;
	@Autowired
	private PolicyConfigInfoService policyConfigInfoService;
	@Autowired
	private MerchantLimitRuleService merchantLimitRuleService;

	@Override
	public List<PosMerchantInfoDO> selectOpenFastSettlePromoterInfo() {
		logger.info("selectOpenFastSettlePromoterInfo query");
		return this.extPosMerchantInfoDAO.selectOpenFastSettlePromoterInfo();
	}

	@Override
	public List<PosMerchantInfoDO> selectOpenFastSettleMerchantInfoByPromoterId(Long promoterId) {
		if (promoterId == null) { return null; }
		return this.extPosMerchantInfoDAO.selectOpenFastSettleMerchantInfoByPromoterId(promoterId);
	}

	@Override
	public List<PosMerchantInfoDO> queryUnderPromoterInfoByPromoterId(Long promoterId) {
		if (promoterId == null) { return null; }
		PosMerchantInfoDO promoter = getPosMerchantInfoByPosMerchantId(promoterId);
		if (promoter == null) { return null; }
		PosMerchantInfoDOExample example = new PosMerchantInfoDOExample();
		example.createCriteria().andParentPromoterIdEqualTo(promoter.getId())
				.andMerchantTypeEqualTo(PosMerchantTypeEnums.MPOS_SECOND_LEVEL_PROMOTER.code);
		List<PosMerchantInfoDO> list = posMerchantInfoManager.selectByExample(example);
		return list;
	}

	@Override
	public PaginationBaseObject<PosMerchantInfoDO> pagingUnderPromoterInfo(PmtQueryPosMerchantPO po) {
		if (po.getPromoterId() == null) { return null; }
		PosMerchantInfoDO promoter = getPosMerchantInfoByPosMerchantId(po.getPromoterId());
		if (promoter == null) { return null; }
		PaginationBaseObject<PosMerchantInfoDO> pbo = new PaginationBaseObject<PosMerchantInfoDO>();
		PosMerchantInfoDOExample example = buildExample(po);
		example.setParentPromoterId(promoter.getId());
		example.setMerchantType(PosMerchantTypeEnums.MPOS_SECOND_LEVEL_PROMOTER.code);
		List<PosMerchantInfoDO> list = posMerchantInfoManager.selectByQuery(example);
		pbo.setDataList(list);
		pbo.setPagination(example.getTotalItem(), example.getPageSize(), example.getCurrentPage());
		return pbo;
	}

	private PosMerchantInfoDOExample buildExample(PmtQueryPosMerchantPO po) {
		PosMerchantInfoDOExample example = new PosMerchantInfoDOExample();
		com.sdp.withdraw.dao.PosMerchantInfoDOExample.Criteria cri = example.createCriteria();
		if (StringUtils.isNotBlank(po.getStatus())) {
			if (!PosMerchantStatusEnums.MC_STATUS_ACTIVE.code.equals(po.getStatus())) {
				cri.andStatusIn(PosMerchantStatusEnums.getUnusableStatus());
			} else {
				cri.andStatusEqualTo(PosMerchantStatusEnums.MC_STATUS_ACTIVE.code);
			}
		}
		if (StringUtils.isNotBlank(po.getMerchantNo())) {
			cri.andMerchantNoEqualTo(po.getMerchantNo());
		}
		if (StringUtils.isNotBlank(po.getMerchantName())) {
			cri.andMerchantNameLike("%" + po.getMerchantName() + "%");
		}
		example.setCurrentPage(po.getPageNo());
		example.setPageSize(po.getPageSize());
		return example;
	}

	@Override
	public PosMerchantInfoDO getPosMerchantInfoByPosMerchantId(Long posMerchantId) {
		PosMerchantInfoDOExample example = new PosMerchantInfoDOExample();
		example.setPosMerchantId(posMerchantId);
		List<PosMerchantInfoDO> list = posMerchantInfoManager.selectByExample(example);
		if (list != null && !list.isEmpty()) { return list.get(0); }
		return null;
	}

	@Override
	public Long createInfo(PosMerchantInfoDO info) {

		return this.posMerchantInfoManager.insert(info);
	}

	@Override
	public int updateByExample(PosMerchantInfoDO info, PosMerchantInfoDOExample example) {

		return this.posMerchantInfoDAO.updateByExampleSelective(info, example);
	}

	@Override
	public int updatePromoterFastSettleInfo(String promoterId, Integer fastSettleFlag, String fastSettleLimit, String fastSettleMargin,
			Integer loaningType) {
		logger.info("updatePromoterFastSettleInfo promoterId:" + promoterId);
		try {
			if (StringUtils.isNotBlank(promoterId)) {
				PosMerchantInfoDO info = getPosMerchantInfoByPosMerchantId(Long.valueOf(promoterId));
				if (info != null) {
					info.setFastSettleFlag(fastSettleFlag);
					info.setFastSettleLimit(new BigDecimal(fastSettleLimit));
					info.setFastSettleMargin(new BigDecimal(fastSettleMargin));
					info.setLoaningType(loaningType);
					info.setUpdateTime(new Date());
					return this.posMerchantInfoManager.updateByPrimaryKey(info);
				}
			}
		} catch (Exception e) {
			logger.error("updatePromoterFastSettleInfo is Exception, promoterId:" + promoterId, e);
		}
		return 0;
	}

	@Override
	public int updateMerchantFastSettleInfo(String merchantNo, String merchantType, Integer fastSettleFlag, Integer autoFastSettleFlg,
			String fastSettleLimit, BigDecimal fastSettleMinLimit, String phoneNo) {
		logger.info("updateMerchantFastSettleInfo merchantNo:" + merchantNo + ",merchantType=" + merchantType);
		try {
			if (StringUtils.isNotBlank(merchantNo) && StringUtils.isNotBlank(merchantType)) {
				PosMerchantInfoDO info = getPosMerchantInfoByMerchantInfo(merchantNo, merchantType);
				if (info != null) {
					info.setFastSettleFlag(fastSettleFlag);
					if (autoFastSettleFlg != null) {
						info.setAutoFastSettleFlag(autoFastSettleFlg);
					}
					info.setFastSettleLimit(new BigDecimal(fastSettleLimit));
					info.setFastSettleMinLimit(fastSettleMinLimit);
					if (phoneNo != null) {
						info.setMerchantPhone(phoneNo);
					}
					info.setUpdateTime(new Date());
					logger.info("updateMerchantFastSettleInfo info:" + ToStringBuilder.reflectionToString(info));
					return this.posMerchantInfoManager.updateByPrimaryKey(info);
				}
			}
		} catch (Exception e) {
			logger.error("updateMerchantFastSettleInfo is Exception, merchantNo:" + merchantNo + ",merchantType=" + merchantType, e);
		}
		return 0;
	}

	@Override
	public PosMerchantInfoDO getPosMerchantInfoByMerchantInfo(String merchantNo, String merchantType) {
		List<PosMerchantInfoDO> list = getPosMerchantInfosByMerchantInfo(merchantNo, merchantType);
		if (list != null && !list.isEmpty()) { return list.get(0); }
		return null;
	}

	@Override
	public int distinctMerchant() {
		return extPosMerchantInfoDAO.distinctMerchant();
	}

	@Override
	public List<PosMerchantInfoDO> getOpenT0MerchantInfoByMemberIds(List<String> memberIds) {
		PosMerchantInfoDOExample example = new PosMerchantInfoDOExample();
		example.createCriteria().andMerchantMemberIdIn(memberIds).andFastSettleFlagEqualTo(MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN_INT);
		List<PosMerchantInfoDO> list = posMerchantInfoManager.selectByExample(example);
		return list;
	}

	@Override
	public void mposAutoOpenFastSettleAndUpdateLimit(String merchantNo, String merchantType, int creditCTFCount) throws OpenFastSettleException {
		/*
		 * PosMerchantInfoDO info =
		 * this.getPosMerchantInfoByMerchantInfo(merchantNo, merchantType); if
		 * (info == null) { throw new OpenFastSettleException("商户信息不存在"); }
		 */
		logger.info("mposAutoOpenFastSettleAndUpdateLimit ,merchantNo:{},merchantType:{},creditCTFCount:{}", new Object[] { merchantNo, merchantType,
				creditCTFCount });
		try {
			ViewMerchantInfoDTO merchantInfo = merchantInfoService.queryMerchantInfoByMerchantNo(merchantNo, merchantType);
			if (merchantInfo == null) { throw new OpenFastSettleException("商户信息不存在"); }
			// 检查是否配置了特殊的开通政策
			PolicyConfigInfoDO policyInfo = policyConfigInfoService.queryPolicyConfigInfo(PolicyTypeEnums.MCC.type, merchantInfo.getMerchantMcc());
			if(policyInfo==null){
				throw new OpenFastSettleException("无对应的MCC政策，不能开通T0");
			}
			logger.info("queryPolicyConfigInfo:{}", ToStringBuilder.reflectionToString(policyInfo, ToStringStyle.SHORT_PREFIX_STYLE));
			if (policyInfo.getPromoterModifyFlag()!=null
					&& FastSettleOpenTypeEnums.PROMOTER_OPEN.code == policyInfo.getPromoterModifyFlag()
				   &&(!CommonStatusEnums.TAKE_EFFECT.code.equals(policyInfo.getDependCreditAuthFlag())
						   ||(merchantInfo.getMerchantFsFlag()==null||merchantInfo.getMerchantFsFlag()!=MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN_INT )
				           ||(merchantInfo.getMerchantFsFlag()==MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN_INT&&creditCTFCount > 0))) {
				// mcc策略配置的为代理商开通(政策配置不需要信用认证||商户未开通T0||商户开通T0且已信用认证)
				logger.info("PolicyConfigInfo is PROMOTER OPEN open T0 stopped");
				return;
			}
			if (CommonStatusEnums.TAKE_EFFECT.code.equals(policyInfo.getStatus())
					&& FastSettleOpenTypeEnums.SYSTEM_OPEN.code == policyInfo.getPromoterModifyFlag()) {// 政策不为空
				//
				if (!CommonStatusEnums.TAKE_EFFECT.code.equals(policyInfo.getDependCreditAuthFlag())
						|| (CommonStatusEnums.TAKE_EFFECT.code.equals(policyInfo.getDependCreditAuthFlag()) && creditCTFCount > 0)) {
					LoaningConfigBean loaningConfigBean = this.mcBaseService.getLoaningCongfigService().getLoaningConfigBean(
							LoaningTypeEnum.SHENGPAY.code, PosMerchantTypeEnums.MPOS_PROMOTER.code);
					String workdayRatio = policyInfo.getWorkdayRatio() == null ? loaningConfigBean.getWorkdayFees()[0] : policyInfo.getWorkdayRatio()
							.toString();
					String holidayRatio = policyInfo.getHolidayRatio() == null ? loaningConfigBean.getHolidayFees()[0] : policyInfo.getHolidayRatio()
							.toString();
					BigDecimal fastSettleLimit = policyInfo.getFastSettleLimit() == null ? 
							merchantLimitRuleService.queryMerchantCurrentMerchantLimitRule(merchantInfo.getPromoterMerchantNo(), merchantInfo.getPromoterType()): 
								policyInfo.getFastSettleLimit();
					autoOpenFastSettleAndUpdateLimit(merchantInfo.getMerchantNo(), merchantInfo.getMcType(), merchantInfo, workdayRatio,
							holidayRatio, fastSettleLimit, policyInfo.getFastSettleFlag().toString(), policyInfo.getAutoFastSettleFlag().toString());
					logger.info("use policyConfigInfo autoOpenFastSettleAndUpdateLimit.Open finish,merchantNo:{}", merchantNo);
					return;
				}
			}

			// 无对应的政策 或有策略需要信用认证信息，但是信用认证小于0 并且商户目前是开通T0的状态 进行关闭T0
			if (merchantInfo.getMerchantFsFlag() != null && MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN_INT == merchantInfo.getMerchantFsFlag()) {
				logger.info("close merchant T0,merchantNo:{},merchantType:{}", new Object[] { merchantNo, merchantType });
				// 如果商户开通了T0 关闭T0
				autoOpenFastSettleAndUpdateLimit(merchantInfo.getMerchantNo(), merchantInfo.getMcType(), merchantInfo, WithdrawConstant.FEE_EMPTY,
						WithdrawConstant.FEE_EMPTY, BigDecimal.ZERO, MerchantCreditConstant.FAST_SETTLE_FLAG_CLOSE,
						MerchantCreditConstant.FAST_SETTLE_FLAG_CLOSE);
				return;
			}
		} catch (Exception e) {
			logger.error("mposAutoOpenFastSettleAndUpdateLimit Exception",e);
			throw new OpenFastSettleException("系统发生异常");
		}

		/*
		 * if (policyInfo !=
		 * null&&CommonStatusEnums.TAKE_EFFECT.code.equals(policyInfo
		 * .getStatus())) { if(creditCTFCount>0){
		 * autoOpenFastSettleAndUpdateLimit(merchantInfo.getMerchantNo(),
		 * merchantInfo.getMcType(),merchantInfo,
		 * policyInfo.getWorkdayRatio().toString(),
		 * policyInfo.getHolidayRatio().toString(),
		 * policyInfo.getFastSettleLimit(),
		 * policyInfo.getFastSettleFlag().toString(),
		 * policyInfo.getAutoFastSettleFlag().toString()); logger.info(
		 * "use policyConfigInfo autoOpenFastSettleAndUpdateLimit.Open finish,merchantNo:{}"
		 * ,merchantNo); }else{ logger.info(
		 * "use policyConfigInfo autoOpenFastSettleAndUpdateLimit.creditCTFCount<=0,merchantNo:{}"
		 * ,merchantNo); } return ; }else{
		 * logger.info("#run,not can use policyConfigInfo."); } String
		 * workdayFee = null; String holidayFee = null; BigDecimal
		 * fastSettleLimit = null; if (creditCTFCount < 1 &&
		 * merchantInfo.getMerchantFsFlag() != null &&
		 * MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN_INT ==
		 * merchantInfo.getMerchantFsFlag()) { logger.info(
		 * "autoOpenFastSettleAndUpdateLimit,merchantNo:{},merchantType:{},creditCTFCount:{}; FAST_SETTLE_FLAG_OPEN"
		 * , new Object[] { merchantNo, merchantType, creditCTFCount }); return;
		 * } // 先查询商户的白名单费率，在查询代理商的白名单费率 WhiteListFeeBean feeBean =
		 * whiteListInfoService.queryWhiteFee(WhiteTypeEnums.FEE.code,
		 * merchantNo, merchantType); if (feeBean == null) { feeBean =
		 * whiteListInfoService.queryWhiteFee(WhiteTypeEnums.FEE.code,
		 * merchantInfo.getPromoterMerchantNo(),
		 * merchantInfo.getPromoterType()); } if (feeBean == null) {
		 * LoaningConfigBean loaningConfigBean =
		 * this.mcBaseService.getLoaningCongfigService
		 * ().getLoaningConfigBean(LoaningTypeEnum.SHENGPAY.code,
		 * PosMerchantTypeEnums.MPOS_PROMOTER.code); if (loaningConfigBean !=
		 * null) { workdayFee = loaningConfigBean.getWorkdayFees()[0];
		 * holidayFee = loaningConfigBean.getHolidayFees()[0]; } } else {
		 * workdayFee = feeBean.getWorkdayFees()[0]; holidayFee =
		 * feeBean.getHolidayFees()[0]; } if (creditCTFCount < 1) {// 未信用认证 //
		 * 先取白名单额度，再获取全局的额度 String nonCreditAuthenticationLimit = null;
		 * WhiteListInfoDO whiteInfo =
		 * whiteListInfoService.queryWhiteListInfo(WhiteTypeEnums
		 * .DEFAULT_OPEN_FAST_SETTLE_LIMIT.code, merchantNo, merchantType,
		 * merchantInfo.getPromoterMerchantNo(),
		 * merchantInfo.getPromoterType()); if (whiteInfo != null &&
		 * NumberUtils.isNumber(whiteInfo.getContent())) {
		 * nonCreditAuthenticationLimit = whiteInfo.getContent(); } else {
		 * nonCreditAuthenticationLimit =
		 * configOptionManager.getConfigByKey(MerchantContractCst
		 * .NON_CREDIT_AUTHENTICATION_LIMIT_KEY); } fastSettleLimit =
		 * StringUtils.isNotBlank(nonCreditAuthenticationLimit) &&
		 * NumberUtils.isNumber(nonCreditAuthenticationLimit) ? new BigDecimal(
		 * nonCreditAuthenticationLimit) : BigDecimal.ZERO; } else {// 信用认证 成功
		 * 先取白名单额度，再获取全局的额度 WhiteListInfoDO whiteInfo =
		 * whiteListInfoService.queryWhiteListInfo
		 * (WhiteTypeEnums.CREDIT_AUTHENTICATION_LIMIT.code, merchantNo,
		 * merchantType, merchantInfo.getPromoterMerchantNo(),
		 * merchantInfo.getPromoterType()); if (whiteInfo != null &&
		 * NumberUtils.isNumber(whiteInfo.getContent())) { fastSettleLimit = new
		 * BigDecimal(whiteInfo.getContent()); } else { String
		 * creditAuthenticationLimit =
		 * configOptionManager.getConfigByKey(MerchantContractCst
		 * .CREDIT_AUTHENTICATION_LIMIT_KEY); fastSettleLimit =
		 * StringUtils.isNotBlank(creditAuthenticationLimit) &&
		 * NumberUtils.isNumber(creditAuthenticationLimit) ? new BigDecimal(
		 * creditAuthenticationLimit) : BigDecimal.ZERO; } } //
		 * max（T0信用认证成功额度，当前额度） if (merchantInfo.getMerchantFsLimit() != null &&
		 * fastSettleLimit.compareTo(merchantInfo.getMerchantFsLimit()) < 0) {
		 * fastSettleLimit = merchantInfo.getMerchantFsLimit(); }
		 * autoOpenFastSettleAndUpdateLimit(merchantNo, merchantType,
		 * merchantInfo, workdayFee, holidayFee,
		 * fastSettleLimit,MerchantCreditConstant
		 * .FAST_SETTLE_FLAG_OPEN,MerchantCreditConstant
		 * .FAST_SETTLE_FLAG_CLOSE);
		 */
	}

	@Override
	public void posAutoOpenFastSettleAndUpdateLimit(String merchantNo, String merchantType, String workdayFee, String holidayFee,
			BigDecimal fastSettleLimit) throws OpenFastSettleException {
		posAutoOpenFastSettleAndUpdateLimit(merchantNo, merchantType, workdayFee, holidayFee, fastSettleLimit,
				MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN, MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN);
	}

	@Override
	public void posAutoOpenFastSettleAndUpdateLimit(String merchantNo, String merchantType, String workdayFee, String holidayFee,
			BigDecimal fastSettleLimit, String fastSettleFlag, String autoFastSettleFlag) throws OpenFastSettleException {
		ViewMerchantInfoDTO merchantInfo = merchantInfoService.queryMerchantInfoByMerchantNo(merchantNo, merchantType);
		if (merchantInfo == null) { throw new OpenFastSettleException("商户信息不存在"); }
		autoOpenFastSettleAndUpdateLimit(merchantNo, merchantType, merchantInfo, workdayFee, holidayFee, fastSettleLimit, fastSettleFlag,
				autoFastSettleFlag);
		addPermanentLimitWhiteList(merchantNo, merchantType);
	}
	@Override
	public void easypayAutoOpenFastSettleAndUpdateLimit(String merchantNo, String merchantType,PolicyConfigInfoDO policyInfo) throws OpenFastSettleException {
		logger.info("easypayAutoOpenFastSettleAndUpdateLimit  init,merchantNo:{},policyInfo:{}", new Object[]{merchantNo,ToStringBuilder.reflectionToString(policyInfo,ToStringStyle.SIMPLE_STYLE)});
		if (CommonStatusEnums.TAKE_EFFECT.code.equals(policyInfo.getStatus())
				&& FastSettleOpenTypeEnums.SYSTEM_OPEN.code == policyInfo.getPromoterModifyFlag()) {// 政策不为空
			ViewMerchantInfoDTO merchantInfo = merchantInfoService.queryMerchantInfoByMerchantNo(merchantNo, merchantType);
			if (merchantInfo == null) { throw new OpenFastSettleException("商户信息不存在"); }
			if (!CommonStatusEnums.TAKE_EFFECT.code.equals(policyInfo.getDependCreditAuthFlag())) {
				LoaningConfigBean loaningConfigBean = this.mcBaseService.getLoaningCongfigService().getLoaningConfigBean(
						LoaningTypeEnum.SHENGPAY.code, PosMerchantTypeEnums.MPOS_PROMOTER.code);
				String workdayRatio = policyInfo.getWorkdayRatio() == null ? loaningConfigBean.getWorkdayFees()[0] : policyInfo.getWorkdayRatio()
						.toString();
				String holidayRatio = policyInfo.getHolidayRatio() == null ? loaningConfigBean.getHolidayFees()[0] : policyInfo.getHolidayRatio()
						.toString();
				BigDecimal fastSettleLimit = policyInfo.getFastSettleLimit() == null ?merchantLimitRuleService.queryMerchantCurrentMerchantLimitRule(merchantInfo.getPromoterMerchantNo(), 
						                            merchantInfo.getPromoterType()) : policyInfo.getFastSettleLimit();
				autoOpenFastSettleAndUpdateLimit(merchantNo, merchantType, merchantInfo, workdayRatio,
						holidayRatio, fastSettleLimit, policyInfo.getFastSettleFlag().toString(), policyInfo.getAutoFastSettleFlag().toString());
				logger.info("use policyConfigInfo easypayAutoOpenFastSettleAndUpdateLimit.Open finish,merchantNo:{}", merchantNo);
				return;
			}
		}
	}

	private void addPermanentLimitWhiteList(String merchantNo, String merchantType) {
		WhiteListInfoDO whiteInfo = whiteListInfoService.queryWhiteListInfo(WhiteTypeEnums.AUTO_UPDATE_MERCHANT_LIMIT.code, merchantNo, merchantType);
		if (whiteInfo == null) {// 没有白名单，创建白名单
			this.whiteListInfoService.createWhiteInfo(WhiteTypeEnums.AUTO_UPDATE_MERCHANT_LIMIT.code, merchantNo, merchantType,
					LimitRuleInfoConstant.AUTO_UPDATE_MERCHANT_LIMIT_MSG, MerchantContractCst.SYSTEM_DEFAULT_USER);
		}
	}

	private void autoOpenFastSettleAndUpdateLimit(String merchantNo, String merchantType, ViewMerchantInfoDTO merchantInfo, String workdayFee,
			String holidayFee, BigDecimal fastSettleLimit, String fastSettleFlag, String autoFastSettleFlag) throws OpenFastSettleException {
		// 开通T0
		MerchantFastSettleVO fastSettleVO = new MerchantFastSettleVO(merchantInfo.getMerchantId().toString(), fastSettleFlag,
				fastSettleLimit.toString(), workdayFee, holidayFee, autoFastSettleFlag, merchantInfo.getMerchantPhoneNo(), merchantType, merchantNo);
		fastSettleVO.setLoaningType(LoaningTypeEnum.SHENGPAY.code);
		fastSettleVO.setPromoterType(PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(merchantType) ? PosMerchantTypeEnums.MPOS_PROMOTER.code
				: PosMerchantTypeEnums.POS_PROMOTER.code);
		fastSettleVO.setPromoterId(merchantInfo.getPromoterId().toString());
		ErrorMessageVO<Object> message = mcBaseService.getFastSettle().setMerchantFastSettleConfig(fastSettleVO,
				MerchantContractCst.SYSTEM_DEFAULT_USER);
		if (!message.isSuccess()) { throw new OpenFastSettleException("开通T0失败：" + message.getErrorMessage()); }
	}

	@Override
	public List<PosMerchantInfoDO> getPosMerchantInfosByMerchantInfo(String merchantNo, String merchantType) {
		PosMerchantInfoDOExample example = new PosMerchantInfoDOExample();
		example.setMerchantNo(merchantNo);
		example.setMerchantType(merchantType);
		List<PosMerchantInfoDO> list = posMerchantInfoManager.selectByExample(example);
		return list;
	}

	@Override
	public List<PosMerchantInfoDO> getOpenT0IdentityMerchantInfo(String merchantNo, String merchantType) {
		PosMerchantInfoDOExample example = new PosMerchantInfoDOExample();
		example.setMerchantNo(merchantNo);
		example.setMerchantType(merchantType);
		return this.extPosMerchantInfoDAO.getOpenT0IdentityMerchantInfo(example);
	}

	@Override
	public List<PosMerchantInfoDO> mposUnopenT0MerchantInfo(String merchantNos) {
		logger.info("mposUnopenT0MerchantInfo merchantNos:" + merchantNos);
		PosMerchantInfoDOExample example = new PosMerchantInfoDOExample();
		if (StringUtils.isBlank(merchantNos)) {
			example.createCriteria().andFastSettleFlagNotEqualTo(MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN_INT)
					.andMerchantTypeEqualTo(PosMerchantTypeEnums.MPOS_MERCHANT.code);
		} else {
			String promoterNo[] = merchantNos.replaceAll("，", ",").split(",");
			List<Long> promoterIds = getMerchantIds(promoterNo, PosMerchantTypeEnums.MPOS_PROMOTER.code);
			logger.info("mposUnopenT0MerchantInfo promoterIds:" + promoterIds);
			if (promoterIds == null || promoterIds.isEmpty()) { return null; }
			example.createCriteria().andFastSettleFlagEqualTo(MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN_INT)
					.andMerchantTypeEqualTo(PosMerchantTypeEnums.MPOS_MERCHANT.code).andParentPromoterIdIn(promoterIds);
		}
		return posMerchantInfoManager.selectByExample(example);
	}

	private List<Long> getMerchantIds(String[] promoterNo, String code) {
		List<String> userList = new ArrayList<String>();
		List<Long> promoterIds = new ArrayList<Long>();
		Collections.addAll(userList, promoterNo);
		PosMerchantInfoDOExample example = new PosMerchantInfoDOExample();
		example.createCriteria().andMerchantTypeEqualTo(code).andMerchantNoIn(userList);
		List<PosMerchantInfoDO> list = posMerchantInfoManager.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			for (PosMerchantInfoDO info : list) {
				promoterIds.add(info.getId());
			}
		}
		return promoterIds;
	}

	@Override
	public PosMerchantInfoDO selectDataById(Long id) {
		return posMerchantInfoManager.selectByPrimaryKey(id);
	}

	@Override
	public int repairWithdrawData() {
		return this.extWithdrawInfoManager.repairWithdrawData();
	}

	@Override
	public int repairFirstOpenDate() {
		return this.extPosMerchantInfoDAO.repairFirstOpenDate();
	}

	@Override
	public String syncMerchantOperator() {
		List<PosMerchantInfoDO> list = this.extPosMerchantInfoDAO.syncMerchantOperator();
		int num = 0;
		if (list != null) {
			for (PosMerchantInfoDO info : list) {
				num++;
				this.posMerchantInfoDAO.updateByPrimaryKeySelective(info);
			}
		}
		return "更新成功，更新记录：" + num;
	}

	@Override
	public String mposBatchUpdateFee(String merchantNo, String merchantType) {
		logger.info("mposBatchUpdateFee merchantNo:{},merchantType:{}", new String[] { merchantNo, merchantType });
		ViewMerchantInfoDTO merchantInfo = merchantInfoService.queryMerchantInfoByMerchantNo(merchantNo, merchantType);
		if (merchantInfo.getMerchantFsFlag() != null && MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN_INT == merchantInfo.getMerchantFsFlag()) {
			String workdayFee = null;
			String holidayFee = null;
			// 先查询商户的白名单费率，在查询代理商的白名单费率
			WhiteListFeeBean feeBean = whiteListInfoService.queryWhiteFee(WhiteTypeEnums.FEE.code, merchantNo, merchantType);
			if (feeBean == null) {
				feeBean = whiteListInfoService.queryWhiteFee(WhiteTypeEnums.FEE.code, merchantInfo.getPromoterMerchantNo(),
						merchantInfo.getPromoterType());
			}
			if (feeBean == null) {
				LoaningConfigBean loaningConfigBean = this.mcBaseService.getLoaningCongfigService().getLoaningConfigBean(
						LoaningTypeEnum.SHENGPAY.code, PosMerchantTypeEnums.MPOS_PROMOTER.code);
				if (loaningConfigBean != null) {
					workdayFee = loaningConfigBean.getWorkdayFees()[0];
					holidayFee = loaningConfigBean.getHolidayFees()[0];
				}
			} else {
				workdayFee = feeBean.getWorkdayFees()[0];
				holidayFee = feeBean.getHolidayFees()[0];
			}
			return mposBatchUpdateFee(merchantNo, merchantType, workdayFee, holidayFee, merchantInfo.getMerchantFsFlag());
		} else {
			logger.info("merchantInfo.getMerchantFsFlag():{}", merchantInfo.getMerchantFsFlag());
			return "商户未开通T0，不更新费率";
		}
	}

	@Override
	public String mposBatchUpdateFee(String merchantNo, String merchantType, String workdayFee, String holidayFee, Integer merchantFsFlag) {
		logger.info("mposBatchUpdateFee merchantNo:{},merchantType:{},workdayFee:{},holidayFee:{},merchantFsFlag:{}", new Object[] { merchantNo,
				merchantType, workdayFee, holidayFee, merchantFsFlag });
		ViewMerchantInfoDTO merchantInfo = merchantInfoService.queryMerchantInfoByMerchantNo(merchantNo, merchantType);
		if (merchantFsFlag != null && MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN_INT == merchantFsFlag) {
			WithdrawRatioResponse response = t0WithdrawService.merchantT0Ratio(merchantNo, merchantType, new BigDecimal(workdayFee), new BigDecimal(
					holidayFee));
			if (response == null || !ReturnCodeEnums.FW_SUCCESS.code.equals(response.getErrorCode())) { return "更新失败"
					+ (response == null ? "" : response.getErrorMsg()); }
		} else {
			logger.info("merchantInfo.getMerchantFsFlag():{}", merchantInfo.getMerchantFsFlag());
			return "商户未开通T0，不更新费率";
		}
		return "更新成功";

	}

	@Override
	public int syncOpenAccountTime() {
		// TODO Auto-generated method stub
		return this.extPosMerchantInfoDAO.syncOpenAccountTime();
	}

	@Override
	public int executeUpdateSql(String updateSql) {
		// TODO Auto-generated method stub
		logger.info("executeUpdateSql init, updateSql:{}", updateSql);
		return this.extPosMerchantInfoDAO.executeUpdateSql(updateSql);
	}

	@Override
	public int executeInsertSql(String insertSql) {
		// TODO Auto-generated method stub
		logger.info("executeInsertSql init, insertSql:{}", insertSql);
		return this.extPosMerchantInfoDAO.executeInsertSql(insertSql);
	}

	@Override
	public int updateMerchantMcc(String merchantNo, String merchantType, String newMccValue) {
		logger.info("updateMerchantMcc init, merchantNo:{},merchantType:{},newMccValue:{}", new Object[] { merchantNo, merchantType, newMccValue });
		try {
			PosMerchantInfoDO info = getPosMerchantInfoByMerchantInfo(merchantNo, merchantType);
			if (info != null) {
				PosMerchantInfoDO data = new PosMerchantInfoDO();
				data.setUpdateTime(new Date());
				data.setId(info.getId());
				data.setMcc(newMccValue);
				return this.posMerchantInfoManager.updateByPrimaryKeySelective(data);
			}
		} catch (Exception e) {
			logger.error("updateMerchantMcc is Exception, merchantNo:{},merchantType:{},newMccValue:{}", new String[] { merchantNo, merchantType,
					newMccValue }, e);
		}
		return 0;
	}

	@Override
	@Transactional
	public int createNewMerchantWithdrawInfo() {
		// TODO Auto-generated method stub
		return this.extPosMerchantInfoDAO.createNewMerchantWithdrawInfo();
	}

	@Override
	@Transactional
	public int updateMerchantWithdrawInfo(boolean isSync) {
		// TODO Auto-generated method stub
		if(isSync){
			this.extPosMerchantInfoDAO.selectMerchantWithdrawInfoForUpdate();
		}
		return this.extPosMerchantInfoDAO.updateMerchantWithdrawInfo();
	}
	
	

}
