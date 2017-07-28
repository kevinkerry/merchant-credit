package com.sdp.withdraw.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.drools.core.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mc.service.api.enums.WhiteTypeEnums;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.enums.AlertMessageSendTypeEnum;
import com.sdp.mc.common.enums.LoaningTypeEnum;
import com.sdp.mc.common.enums.withdraw.BizTypeEnums;
import com.sdp.mc.common.enums.withdraw.FrozenQuotaTypeEnums;
import com.sdp.mc.common.enums.withdraw.LimitationTypeEnums;
import com.sdp.mc.common.enums.withdraw.LogOPTypeEnums;
import com.sdp.mc.common.enums.withdraw.LogRecordTypeEnums;
import com.sdp.mc.common.enums.withdraw.QuotaOpTypeEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawConfigEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawLimitType;
import com.sdp.mc.common.enums.withdraw.WorkDayTypeEnums;
import com.sdp.mc.common.exception.IdentityLimitException;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.util.NumberUtils;
import com.sdp.mc.config.dao.ConfigOptionDO;
import com.sdp.mc.config.dao.ConfigOptionDOExample;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.newt0.dao.AuditInfoDTO;
import com.sdp.mc.newt0.dao.Newt0PromoterDO;
import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDO;
import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDOExample;
import com.sdp.mc.newt0.dao.WhiteListInfoDO;
import com.sdp.mc.newt0.manager.ExtNewT0AuditInfoManager;
import com.sdp.mc.newt0.manager.ExtNewt0SdpRemainBalanceManager;
import com.sdp.mc.newt0.manager.Newt0PromoterManager;
import com.sdp.mc.view.dao.ViewMerchantInfoDTO;
import com.sdp.mc.view.dao.ViewPromoterInfoDTO;
import com.sdp.withdraw.api.ratio.MerchantWithdrawRatioAPI;
import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.dao.WithdrawInfoDO;
import com.sdp.withdraw.dao.WithdrawInfoDOExample;
import com.sdp.withdraw.dao.WithdrawRatioInfoDO;
import com.sdp.withdraw.dao.WithdrawRatioInfoDOExample;
import com.sdp.withdraw.dao.WorkCalendarDO;
import com.sdp.withdraw.dao.ext.QuatoOpreationMsgVo;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.sdp.withdraw.enums.ReturnCodeEnums;
import com.sdp.withdraw.enums.WithdrawRatioStatusEnums;
import com.sdp.withdraw.error.QuatoOpreateException;
import com.sdp.withdraw.manager.PosMerchantInfoManager;
import com.sdp.withdraw.manager.WithdrawInfoManager;
import com.sdp.withdraw.manager.WithdrawRatioInfoManager;
import com.sdp.withdraw.manager.ext.ExtWithdrawInfoManager;
import com.sdp.withdraw.service.BaseService;
import com.shengpay.service.alert.factory.AlertMessageSenderFactory;
import com.shengpay.service.mail.AlertMessageSender;
import com.shengpay.service.view.MerchantInfoService;
import com.shengpay.service.view.PromoterInfoService;
import com.shengpay.service.whitelist.WhiteListInfoService;
import com.shengpay.service.withdraw.FwPosMerchantInfoService;
import com.shengpay.service.workcalendar.WorkCalendarService;

@Service("LimitationBaseService")
public class LimitationBaseService extends BaseService {

	private static final Logger logger = LoggerFactory.getLogger(LimitationBaseService.class);

	@Autowired
	private PosMerchantInfoManager posMerchantInfoManager;

	@Autowired
	private WithdrawInfoManager withdrawInfoManager;

	@Autowired
	private ExtWithdrawInfoManager extWithdrawInfoManager;

	@Autowired
	protected ExtNewt0SdpRemainBalanceManager extNewt0SdpRemainBalanceManager;

	@Autowired
	private ConfigOptionManager configOptionManager;

	@Autowired
	private WorkCalendarService workCalendarService;

	@Autowired
	private Newt0PromoterManager newt0PromoterManager;

	@Autowired
	private WithdrawRatioInfoManager withdrawRatioInfoManager;

	@Autowired
	private MerchantWithdrawRatioAPI withdrawRatioService4Hessian;

	@Autowired
	private AlertMessageSenderFactory alertMessageSenderFactory;
	@Autowired
	private WhiteListInfoService whiteListInfoService;

	@Autowired
	private MerchantInfoService merchantInfoService;
	@Autowired
	private PromoterInfoService promoterInfoService;
	@Autowired
	private FwPosMerchantInfoService posMerchantInfoService;
	@Autowired
	private ExtNewT0AuditInfoManager extNewT0AuditInfoManager;

	/**
	 * 额度操作type：1 冻结 2：解冻 3:已使用
	 *
	 * @param merchantNo
	 * @param operateQuota
	 *            操作额度
	 * @param list
	 *            商户信息
	 * @param type
	 *            1 冻结 2：解冻 3:已使用
	 * @return
	 * @throws QuatoOpreateException
	 */
	@Transactional
	public boolean quotaOpreate(String merchantNo, BigDecimal operateQuota, List<PosMerchantInfoDO> list, String type, Date begin)
			throws QuatoOpreateException {

		logger.info("LimitationBaseService#quotaOpreate merchantNo:" + merchantNo + " frozenQuota:" + operateQuota + " List<PosMerchantInfoDO>:"
				+ ToStringBuilder.reflectionToString(list) + " type:" + type + " begin:" + begin);

		PosMerchantInfoDO posmerchantInfo = list.get(0);
		String mcType = posmerchantInfo.getMerchantType();
		// 根据商户号查询垫资类型
		// PromoterEO promoterEo = queryPromoterNo(merchantNo, mcType);
		ViewMerchantInfoDTO merchantInfo = merchantInfoService.queryMerchantInfoByMerchantNo(merchantNo, mcType);
		if (merchantInfo == null) {
			logger.error("LimitaionServiceImpl#quotaOpreate queryPromoterNo is null,posmerchantInfo:"
					+ ToStringBuilder.reflectionToString(posmerchantInfo));
			return false;
		}
		// 根据商户号 商户类型查询代理商的id
		LoaningTypeEnum locaingType = getLoaningTypeEnum(merchantInfo.getPromoterId());
		if (locaingType == null) {
			logger.info("LimitationBaseService#quotaOpreate query locaingType is null, posmerchantInfo:"
					+ ToStringBuilder.reflectionToString(posmerchantInfo));
			return false;
		}
		logger.info("LimitationBaseService#quotaOpreate LoaningTypeEnum is : "
				+ ToStringBuilder.reflectionToString(LoaningTypeEnum.getLoaningTypeEnum(locaingType.code)));
		// 冻结/解冻/已使用 盛付通额度
		if (LoaningTypeEnum.SHENGPAY.compareTo(locaingType) == 0) {
			updateSdpRemainBalance(operateQuota, type, begin);
		}

		// 冻结/解冻/已使用 代理商额度
		updatePromoterBalance(merchantNo, posmerchantInfo, operateQuota, type, begin, merchantInfo.getPromoterId());

		// 冻结/解冻/已使用 商户额度
		updateMerchantBalance(merchantNo, posmerchantInfo, operateQuota, type, begin, mcType);

		return true;
	}

	/**
	 * 代理商额度操作 冻结/解冻/冻结使用
	 * 
	 * @param merchantNo
	 *            商户号
	 * @param info
	 *            商户信息
	 * @param operateQuota
	 *            操作额度
	 * @param type
	 *            操作类型 1 冻结 2：解冻 3:已使用
	 * @param begin
	 * @param promoterId
	 * @return
	 */
	private boolean updatePromoterBalance(String merchantNo, PosMerchantInfoDO info, BigDecimal operateQuota, String type, Date begin, Long promoterId)
			throws QuatoOpreateException {
		PosMerchantInfoDO posPromoterMerchantInfo = posMerchantInfoService.getPosMerchantInfoByPosMerchantId(promoterId);
		if (posPromoterMerchantInfo == null) {
			logger.error("findPmtWithdrawInfoDOForUpdate posMerchantInfo is null,promoterId:" + promoterId);
			throw new QuatoOpreateException("PROMOTER_WITHRAW_INFO_NOT_EXIST", "代理商额度信息不存在", null);
		}
		// 查询代理商的额度
		List<WithdrawInfoDO> _list = findPmtWithdrawInfoDOForUpdate(posPromoterMerchantInfo);
		if (_list == null) { throw new QuatoOpreateException("PROMOTER_WITHRAW_INFO_NOT_EXIST", "代理商额度信息不存在", null); }
		// 查询代理商信息
		WithdrawInfoDO record = _list.get(0);
		String ptmMcType = posPromoterMerchantInfo.getMerchantType();// 代理商类型
		String pmtMerchantNo = posPromoterMerchantInfo.getMerchantNo();// 代理商商户号
		BigDecimal forzenLimitation = record.getForzenLimitation() == null ? new BigDecimal(0) : record.getForzenLimitation();// 冻结额度
		BigDecimal usedLimitation = record.getUsedLimitation() == null ? new BigDecimal(0) : record.getUsedLimitation();// 已使用额度
		// 代理商结算总额度
		BigDecimal totalAmount = findMerchantFastAmount(pmtMerchantNo, ptmMcType);
		// if (totalAmount.compareTo(new BigDecimal(0)) <= 0) { throw new
		// QuatoOpreateException("PMT_MERCHANT_TOTAL_AMOUNT_ERROR",
		// "商户结算总额度小于0",
		// new
		// QuatoOpreationMsgVo(pmtMerchantNo,ptmMcType,totalAmount,forzenLimitation,usedLimitation,QuotaOpTypeEnums.PMT_MERCHANT_QUOTA_OP_TYPE.code));
		// }
		// if (totalAmount.compareTo(operateQuota) < 0) { throw new
		// QuatoOpreateException("PROMOTER_FORZEN_BALANCE_ERROR",
		// "代理商总额度小于冻结额度",new
		// QuatoOpreationMsgVo(pmtMerchantNo,ptmMcType,totalAmount,forzenLimitation,usedLimitation,QuotaOpTypeEnums.PMT_MERCHANT_QUOTA_OP_TYPE.code));
		// }
		// // 代理商结算总额度 < 已冻结 + 已使用
		// if (totalAmount.compareTo(forzenLimitation.add(usedLimitation)) < 0)
		// { throw new QuatoOpreateException("PROMOTER_FORZEN_BALANCE_ERROR",
		// "代理商结算总额度小于已冻结加已使用",new
		// QuatoOpreationMsgVo(pmtMerchantNo,ptmMcType,totalAmount,forzenLimitation,usedLimitation,QuotaOpTypeEnums.PMT_MERCHANT_QUOTA_OP_TYPE.code));
		// }
		BigDecimal _frozenQuota = null;
		if (type.equals(FrozenQuotaTypeEnums.FROZEN_QUOTA_LIMITATION.code)) {
			// 只有冻结额度 再判断
			if (totalAmount.compareTo(new BigDecimal(0)) <= 0) { throw new QuatoOpreateException("PMT_MERCHANT_TOTAL_AMOUNT_ERROR", "商户结算总额度小于0",
					new QuatoOpreationMsgVo(pmtMerchantNo, ptmMcType, totalAmount, forzenLimitation, usedLimitation,
							QuotaOpTypeEnums.PMT_MERCHANT_QUOTA_OP_TYPE.code)); }
			if (totalAmount.compareTo(operateQuota) < 0) { throw new QuatoOpreateException("PROMOTER_FORZEN_BALANCE_ERROR", "代理商总额度小于冻结额度",
					new QuatoOpreationMsgVo(pmtMerchantNo, ptmMcType, totalAmount, forzenLimitation, usedLimitation,
							QuotaOpTypeEnums.PMT_MERCHANT_QUOTA_OP_TYPE.code)); }
			// 代理商结算总额度 < 已冻结 + 已使用
			if (totalAmount.compareTo(forzenLimitation.add(usedLimitation)) < 0) { throw new QuatoOpreateException("PROMOTER_FORZEN_BALANCE_ERROR",
					"代理商结算总额度小于已冻结加已使用", new QuatoOpreationMsgVo(pmtMerchantNo, ptmMcType, totalAmount, forzenLimitation, usedLimitation,
							QuotaOpTypeEnums.PMT_MERCHANT_QUOTA_OP_TYPE.code)); }
			// 冻结额度
			_frozenQuota = forzenLimitation.add(operateQuota);
			if (totalAmount.compareTo(_frozenQuota.add(usedLimitation)) < 0) {
				logger.info("[updatePromoterBalance] totalAmount:[" + totalAmount + "] < _frozenQuota.add(usedLimitation):["
						+ _frozenQuota.add(usedLimitation) + "] ~~");
				throw new QuatoOpreateException("MERCHANT_TOTAL_AMOUNT_ERROR", "商户结算总额小于冻结额度+已使用额度", new QuatoOpreationMsgVo(pmtMerchantNo,
						ptmMcType, totalAmount, forzenLimitation, usedLimitation, QuotaOpTypeEnums.PMT_MERCHANT_QUOTA_OP_TYPE.code));
			}
		} else if (type.equals(FrozenQuotaTypeEnums.FROZEN_QUOTA_RESTORE.code)) {
			if (forzenLimitation.compareTo(operateQuota) < 0) { throw new QuatoOpreateException("PROMOTER_FORZEN_BALANCE_ERROR", "已冻结额度小于解冻额度",
					new QuatoOpreationMsgVo(pmtMerchantNo, ptmMcType, totalAmount, forzenLimitation, usedLimitation,
							QuotaOpTypeEnums.PMT_MERCHANT_QUOTA_OP_TYPE.code)); }
			// 解冻额度
			_frozenQuota = forzenLimitation.subtract(operateQuota);
		} else if (type.equals(FrozenQuotaTypeEnums.FROZEN_QUOTA_USED.code)) {
			if (forzenLimitation.compareTo(operateQuota) < 0) { throw new QuatoOpreateException("PROMOTER_FORZEN_BALANCE_ERROR", "已冻结额度小于冻结使用额度",
					new QuatoOpreationMsgVo(pmtMerchantNo, ptmMcType, totalAmount, forzenLimitation, usedLimitation,
							QuotaOpTypeEnums.PMT_MERCHANT_QUOTA_OP_TYPE.code)); }
			record.setUsedLimitation(usedLimitation.add(operateQuota));
			_frozenQuota = forzenLimitation.subtract(operateQuota);
		}
		if (_frozenQuota == null) { throw new QuatoOpreateException("PROMOTER_FORZEN_BALANCE_ERROR", "代理商额度为空", new QuatoOpreationMsgVo(
				pmtMerchantNo, ptmMcType, totalAmount, forzenLimitation, usedLimitation, QuotaOpTypeEnums.PMT_MERCHANT_QUOTA_OP_TYPE.code)); }
		boolean promoter = updatePosMerchantInfo(record, _frozenQuota, type, begin, WithdrawLimitType.POS_MPOS_PROMOTO_MERCHANT_TYPE.code, ptmMcType);
		if (!promoter) { throw new QuatoOpreateException("PROMOTER_INFO_UPDATE_ERROR", "更新代理商额度信息失败", new QuatoOpreationMsgVo(pmtMerchantNo,
				ptmMcType, totalAmount, forzenLimitation, usedLimitation, QuotaOpTypeEnums.PMT_MERCHANT_QUOTA_OP_TYPE.code)); }
		return true;
	}

	/**
	 * 插入商户信息
	 * 
	 * @param merchantEo
	 *            商户信息
	 * @return
	 */
	public Long insertMerchantInfo(ViewMerchantInfoDTO merchantEo) throws QuatoOpreateException {
		logger.info("LimitaionServiceImpl#insertMerchantInfo: merchantEo" + ToStringBuilder.reflectionToString(merchantEo));
		// 根据代理商ID查询代理商的商户号
		String merchantNo = merchantEo.getMerchantNo(); // 商户的商户号
		String mcType = merchantEo.getMcType();// 商户类型

		String pmtMerchantNo = merchantEo.getPromoterMerchantNo();// 代理商的商户号
		String pmtType = merchantEo.getPromoterType(); // 代理商的商户类型
		if (StringUtils.isEmpty(pmtMerchantNo) || StringUtils.isEmpty(pmtType)) {
			logger.error("LimitaionServiceImpl#insertMerchantInfo by pmtMerchantNo:[" + merchantEo + "] and pmtType:[" + pmtType + "] error");
			return -1L;
		}
		/*
		 * List<PromoterEO> pmtInfoList =
		 * promoterDAO.queryByMerchantNo(pmtMerchantNo, pmtType); if
		 * (pmtInfoList == null || pmtInfoList.isEmpty()) { logger.error(
		 * "LimitaionServiceImpl#insertMerchantInfo SYNC_MERCHANT_QUERY_PMT_INFO_ERROR 同步商户信息-查询代理商信息异常"
		 * + merchantNo + "--" + mcType); return -1L; }
		 */
		Long promoterId = merchantEo.getPromoterId();
		// 判断代理商是否存在
		List<PosMerchantInfoDO> list = posMerchantInfoService.getPosMerchantInfosByMerchantInfo(pmtMerchantNo, pmtType);
		Long value = -1L;
		if (list == null || list.isEmpty()) {
			value = insertPromoterMerchantInfo(promoterId, pmtMerchantNo, pmtType);
		} else if (list.size() > 1) {
			logger.info("LimitaionServiceImpl#insertMerchantInfo query posMerchantInfoDO by [" + pmtMerchantNo + "] error:"
					+ WithdrawConstant.WITHDRAW_QUERY_ERROR_NOT_UNIQUE);
			return -1L;
		} else {
			value = list.get(0).getId();
		}
		if (value.compareTo(-1L) == 0) {
			logger.info("LimitaionServiceImpl#insertMerchantInfo query posMerchantInfoDO id is -1");
			return value;
		}
		// 判断商户是否存在
		List<PosMerchantInfoDO> merchantList = posMerchantInfoService.getPosMerchantInfosByMerchantInfo(merchantNo, mcType);
		if (merchantList != null && merchantList.size() > 1) {
			logger.error("LimitaionServiceImpl#insertMerchantInfo query isExsitMerchant by merchantNo:" + merchantNo + "  mcType" + mcType
					+ WithdrawConstant.WITHDRAW_QUERY_ERROR_NOT_UNIQUE);
			return -1L;
		}
		if (merchantList != null && merchantList.size() == 1) {
			logger.error("LimitaionServiceImpl#insertMerchantInfo isExsitMerchant merchantNo:[" + merchantNo + "] and mcType:[" + mcType
					+ "] was exsit");
			syncRedioData(merchantNo, mcType, merchantList.get(0).getId());
			return -1L;
		}
		// 插入商户信息
		PosMerchantInfoDO record = new PosMerchantInfoDO();
		record.setMerchantNo(merchantNo);// 商户的 商户号
		record.setPosMerchantId(merchantEo.getMerchantId());
		record.setMerchantType(mcType);
		record.setParentPromoterId(value);
		// record = initMaPara(record, merchantNo);
		record.setCreateTime(new Date());
		record.setUpdateTime(new Date());
		Long rows = posMerchantInfoManager.insert(record);
		if (rows > 0) {
			insertWithdrawRecord(record);
			// 同步商户费率数据
			syncRedioData(merchantNo, mcType, rows);
			return rows;
		}
		return -1L;
	}

	/**
	 * 插入代理商信息
	 * 
	 * @param posmPromoterId
	 *            代理商ID
	 * @param pmtMerchantNo
	 *            代理商商户号
	 * @param pmtType
	 *            代理商类型
	 * @return
	 */
	private Long insertPromoterMerchantInfo(Long posmPromoterId, String pmtMerchantNo, String pmtType) {
		// TODO Auto-generated method stub
		PosMerchantInfoDO record = new PosMerchantInfoDO();
		record.setMerchantNo(pmtMerchantNo);// 代理商的 商户号
		record.setPosMerchantId(posmPromoterId);
		record.setMerchantType(pmtType);
		record.setParentPromoterId(null);
		// record = initMaPara(record, pmtMerchantNo);
		record.setCreateTime(new Date());
		record.setUpdateTime(new Date());
		Long id = posMerchantInfoManager.insert(record);
		if (id > 0) {
			insertWithdrawRecord(record);
			return id;
		} else {
			logger.error("[LimitationBaseService] #insertPromoterMerchantInfo INSERT_PMT_INFO_ERROR 同步商户信息-保存代理商信息异常");
			return -1L;
		}
	}

	/**
	 * 同步商户费率
	 * 
	 * @param merchantNo
	 * @param mcType
	 * @param bizId
	 *            对应商户信息的ID
	 * @return
	 */
	private boolean syncRedioData(String merchantNo, String mcType, Long bizId) throws QuatoOpreateException {
		logger.info("LimitaionBaseService#syncRedioData: merchantNo" + merchantNo + ",mcType:" + mcType + ",bizId:" + bizId);
		// 判断T0是否需要同步 status：1 生效
		ConfigOptionDO config = findConfigOptionDO(WithdrawConfigEnums.T0_POS_RATIO_SYNC.code);
		if (config == null) {
			logger.error("[LimitationBaseService] #syncRedioData T0_POS_RATIO_SYNC T0同步费率配置不存在");
			return false;
		}
		if (config.getOptionValue().equals(WithdrawConfigEnums.NOT_NEED_SYNC_RATIO.code)) {
			logger.error("[LimitationBaseService] #syncRedioData T0_POS_RATIO_SYNC_SWITCH_CLOSED 同步费率开关已经关闭.");
			return false;
		}
		// 同步费率
		return insertRatioByBidType(merchantNo, mcType, bizId);
	}

	/**
	 * 保存费率
	 *
	 * @param merchantNo
	 * @param mcType
	 * @param bizId
	 *            对应商户信息的ID
	 * @return
	 */
	private boolean insertRatioByBidType(String merchantNo, String mcType, Long bizId) throws QuatoOpreateException {
		/*
		 * logger.info("LimitaionBaseService#insertRatioByBidType: merchantNo" +
		 * merchantNo + ",mcType:" + mcType + ",bizId:" + bizId);
		 * List<MerchantSettleItemEO> merchantSettleList =
		 * merchantSettleItemDAO.queryFastSettleItmeByMerchantList(merchantNo +
		 * ""); WithdrawRatioResponse response = null; if (merchantSettleList ==
		 * null || merchantSettleList.isEmpty()) {
		 * logger.error("QUERY_POS_MERCHANT_RATIO_ERROR 根据[" + merchantNo + "、"
		 * + mcType + "]查询商户费率为空"); return false; } for (MerchantSettleItemEO
		 * settle : merchantSettleList) { if
		 * (RatioRulsTypeEnums.T0_RATIO_RULS_SETTLE_RATIO.code.longValue() ==
		 * settle.getMsiSettleRuleId().longValue()) { if
		 * (PosMerchantTypeEnums.POS_MERCHANT.code.equals(mcType)) { // 保存POS
		 * T0费率 response = createOrUpdateWithrawRatio(merchantNo, mcType, bizId,
		 * settle, WithdrawRatioTypeEnums.POS_T0_SETTLE_RATIO.code); if
		 * (response == null) { logger.error(
		 * "LimitationBaseService #insertRatioByBidType INSERT_POS_T0_RATIO_ERROR_EXSIT POS T0保存费率 存在 merchantNo:["
		 * + merchantNo + "] myType:[" + mcType + "]"); continue; }
		 * 
		 * if (!ReturnCodeEnums.FW_SUCCESS.code.equals(response.getErrorCode()))
		 * { logger.error(
		 * "LimitationBaseService #insertRatioByBidType INSERT_POS_T0_RATIO_ERROR POS T0保存费率异常merchantNo:["
		 * + merchantNo + "] myType:[" + mcType + "]"); } } else if
		 * (PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(mcType)) { // 保存MPOS
		 * T0费率 response = createOrUpdateWithrawRatio(merchantNo, mcType, bizId,
		 * settle, WithdrawRatioTypeEnums.MPOS_T0_SETTLE_RATIO.code); if
		 * (response == null) { logger.error(
		 * "LimitationBaseService #insertRatioByBidType INSERT_MPOS_T0_RATIO_ERROR_EXSIT MPOS T0保存费率 存在 merchantNo:["
		 * + merchantNo + "] myType:[" + mcType + "]"); continue; } if
		 * (!ReturnCodeEnums.FW_SUCCESS.code.equals(response.getErrorCode())) {
		 * logger.error(
		 * "LimitationBaseService #insertRatioByBidType INSERT_MPOS_T0_RATIO_ERROR MPOS T0保存费率异常merchantNo:["
		 * + merchantNo + "] myType:[" + mcType + "]"); } } } else if
		 * (RatioRulsTypeEnums.T1_RATIO_RULS_SETTLE_RATIO.code.longValue() ==
		 * settle.getMsiSettleRuleId().longValue()) { if
		 * (PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(mcType)) { // 保存MPOS
		 * T1费率 response = createOrUpdateWithrawRatio(merchantNo, mcType, bizId,
		 * settle, WithdrawRatioTypeEnums.MPOS_T1_SETTLE_RATIO.code); if
		 * (response == null) { logger.error(
		 * "LimitationBaseService #insertRatioByBidType INSERT_MPOS_T1_RATIO_ERROR_EXSIT MPOS T1保存费率存在 merchantNo:["
		 * + merchantNo + "] myType:[" + mcType + "]"); continue; } if
		 * (!ReturnCodeEnums.FW_SUCCESS.code.equals(response.getErrorCode())) {
		 * logger.error(
		 * "LimitationBaseService #insertRatioByBidType INSERT_MPOS_T1_RATIO_ERROR MPOS T1保存费率异常 merchantNo:["
		 * + merchantNo + "] myType:[" + mcType + "]"); } } } else if
		 * (RatioRulsTypeEnums.D1_RATIO_RULS_SETTLE_RATIO.code.longValue() ==
		 * settle.getMsiSettleRuleId().longValue()) { if
		 * (PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(mcType)) { // 保存MPOS
		 * D1费率 response = createOrUpdateWithrawRatio(merchantNo, mcType, bizId,
		 * settle, WithdrawRatioTypeEnums.MPOS_D1_SETTLE_RATIO.code); if
		 * (response == null) { logger.error(
		 * "LimitationBaseService #insertRatioByBidType INSERT_MPOS_D1_RATIO_ERROR_EXSIT MPOS T0保存费率异常 merchantNo:["
		 * + merchantNo + "] myType:[" + mcType + "]"); continue; } if
		 * (!ReturnCodeEnums.FW_SUCCESS.code.equals(response.getErrorCode())) {
		 * logger.error(
		 * "LimitationBaseService #insertRatioByBidType INSERT_MPOS_D1_RATIO_ERROR MPOS T0保存费率异常 merchantNo:["
		 * + merchantNo + "] myType:[" + mcType + "]"); } } } }
		 */
		return true;
	}

	/**
	 * 创建或更新费率
	 * 
	 * @param merchantNo
	 * @param mcType
	 * @param bizId
	 *            对应商户信息的ID
	 * @param settle
	 *            费率信息
	 * @param ratioType
	 *            费率类型
	 * @return
	 */
	/*
	 * private WithdrawRatioResponse createOrUpdateWithrawRatio(String
	 * merchantNo, String mcType, Long bizId, MerchantSettleItemEO settle, int
	 * ratioType) { // 保存POS T0费率 if (isExsitRatioByType(bizId, ratioType)) {
	 * return null; } // 保存MPOS T0费率 WithdrawRatioRequest withdrawRatioRequest =
	 * new WithdrawRatioRequest();
	 * withdrawRatioRequest.setMerchantNo(merchantNo);
	 * withdrawRatioRequest.setMerchantType(mcType);
	 * withdrawRatioRequest.setEffectiveTime(settle.getMsiBeginTime());
	 * withdrawRatioRequest.setExpireTime(settle.getMsiEndTime());
	 * withdrawRatioRequest.setHolidayWithDrawRatio(settle.getMsiHolidayFee());
	 * withdrawRatioRequest.setWorkDayWithDrawRatio(settle.getMsiWorkDayFee());
	 * withdrawRatioRequest
	 * .setWithDrawRatioStatus(RatioStatusEnums.active.code);
	 * withdrawRatioRequest.setWithDrawRatioType(ratioType); return
	 * withdrawRatioService4Hessian
	 * .createOrUpdateWithrawRatio(withdrawRatioRequest); }
	 */

	/**
	 * 根据类型判断费率是否存在
	 *
	 * @param bizId
	 *            对应商户信息的ID
	 * @param withdrawRatioType
	 *            费率类型
	 * @return
	 */
	private boolean isExsitRatioByType(Long bizId, int withdrawRatioType) {

		WithdrawRatioInfoDOExample example = new WithdrawRatioInfoDOExample();
		example.createCriteria().andBizIdEqualTo(bizId).andStatusEqualTo(WithdrawRatioStatusEnums.active.code).andRatioTypeEqualTo(withdrawRatioType);
		List<WithdrawRatioInfoDO> list = withdrawRatioInfoManager.selectByExample(example);
		if (list != null && !list.isEmpty()) return true;
		return false;
	}

	/**
	 * 盛付通垫资额度 冻结/解冻/使用
	 *
	 * @param operateQuota
	 *            操作金额
	 * @param type
	 *            操作的类型 冻结/解冻/使用
	 * @return
	 */
	private boolean updateSdpRemainBalance(BigDecimal operateQuota, String type, Date begin) throws QuatoOpreateException {
		// TODO Auto-generated method stub
		Newt0SdpRemainBalanceDO remainTotalBalanceDO = getNowRemainBalanceForUpdate();
		// 数据延迟异常
		if (remainTotalBalanceDO == null) {
			logger.info("LimitationBaseService#updateForzenSdpRemainBalance remainTotalBalanceDO is null ~~~");
			throw new QuatoOpreateException("SDP_BALANCE_NOT_EXIST", "盛付通垫资总额度不存在", null);
		}
		// SDP总额度
		BigDecimal sdpQuoto = remainTotalBalanceDO.getQuota();
		if (sdpQuoto == null || sdpQuoto.compareTo(new BigDecimal(0)) <= 0) { throw new QuatoOpreateException("SDP_BALANCE_NULL_OR_ZERO",
				"盛付通垫资总额度为空或者为0", new QuatoOpreationMsgVo(null, null, sdpQuoto, null, null, QuotaOpTypeEnums.SDP_MERCHANT_QUOTA_OP_TYPE.code)); }
		// SDP当天剩余的额度
		BigDecimal sdpCanUseQuota = remainTotalBalanceDO.getCanUseQuota() == null ? new BigDecimal(0) : remainTotalBalanceDO.getCanUseQuota();
		// SDP当天的冻结额度
		BigDecimal sdpFrozenQuota = remainTotalBalanceDO.getFrozenQuota() == null ? new BigDecimal(0) : remainTotalBalanceDO.getFrozenQuota();
		// SDP已经使用额度
		BigDecimal sdpUsedQuota = sdpQuoto.subtract(sdpCanUseQuota).subtract(sdpFrozenQuota);

		// if (sdpQuoto.compareTo(operateQuota) < 0) { throw new
		// QuatoOpreateException("SDP_BALANCE_ERROR", "盛付通垫资总额度小于冻结额度",new
		// QuatoOpreationMsgVo(null, null, sdpQuoto, sdpFrozenQuota,
		// sdpUsedQuota,QuotaOpTypeEnums.SDP_MERCHANT_QUOTA_OP_TYPE.code)); }
		// if (sdpQuoto.compareTo(sdpCanUseQuota.add(sdpFrozenQuota)) < 0) {
		// throw new QuatoOpreateException("SDP_BALANCE_ERROR",
		// "盛付通垫资总额度小于当天剩余额度加当天已冻结额度",new QuatoOpreationMsgVo(null, null,
		// sdpQuoto, sdpFrozenQuota,
		// sdpUsedQuota,QuotaOpTypeEnums.SDP_MERCHANT_QUOTA_OP_TYPE.code)); }
		// // 日期跨天
		if (begin != null && DateUtil.whetherEveryDay(begin, new Date())) {
			logger.info("[updateForzenSdpRemainBalance] remainTotalBalanceDO DateUtils.whetherEveryDay is true ~~~");
			throw new QuatoOpreateException("DATE_EVERY_DAY_ERROR", "日期跨天或开始日期为空", new QuatoOpreationMsgVo(null, null, sdpQuoto, sdpFrozenQuota,
					sdpUsedQuota, QuotaOpTypeEnums.SDP_MERCHANT_QUOTA_OP_TYPE.code));
		}
		if (type.equals(FrozenQuotaTypeEnums.FROZEN_QUOTA_LIMITATION.code)) {
			// 只有冻结额度 再判断
			if (sdpQuoto.compareTo(operateQuota) < 0) { throw new QuatoOpreateException("SDP_BALANCE_ERROR", "盛付通垫资总额度小于冻结额度",
					new QuatoOpreationMsgVo(null, null, sdpQuoto, sdpFrozenQuota, sdpUsedQuota, QuotaOpTypeEnums.SDP_MERCHANT_QUOTA_OP_TYPE.code)); }
			if (sdpQuoto.compareTo(sdpCanUseQuota.add(sdpFrozenQuota)) < 0) { throw new QuatoOpreateException("SDP_BALANCE_ERROR",
					"盛付通垫资总额度小于当天剩余额度加当天已冻结额度", new QuatoOpreationMsgVo(null, null, sdpQuoto, sdpFrozenQuota, sdpUsedQuota,
							QuotaOpTypeEnums.SDP_MERCHANT_QUOTA_OP_TYPE.code)); }

			// 盛付通当前时间段余额不足
			if (sdpCanUseQuota.compareTo(new BigDecimal(0)) <= 0) {
				logger.info("[updateForzenSdpRemainBalance] sdpCanUseQuota:[" + sdpCanUseQuota + "] < 0 ");
				throw new QuatoOpreateException("SDP_CAN_USE_BALANCE_ERROR", "盛付通可用额度小于0", new QuatoOpreationMsgVo(null, null, sdpQuoto,
						sdpFrozenQuota, sdpUsedQuota, QuotaOpTypeEnums.SDP_MERCHANT_QUOTA_OP_TYPE.code));
			}
			if (sdpCanUseQuota.compareTo(operateQuota) < 0) {
				logger.info("[updateForzenSdpRemainBalance] sdpFrozenQuota:[" + sdpFrozenQuota + "] > sdpCanUseQuota:[" + sdpCanUseQuota + "]~~~");
				throw new QuatoOpreateException("SDP_CAN_USE_BALANCE_ERROR", "盛付通可用额度小于冻结额度", new QuatoOpreationMsgVo(null, null, sdpQuoto,
						sdpFrozenQuota, sdpUsedQuota, QuotaOpTypeEnums.SDP_MERCHANT_QUOTA_OP_TYPE.code));
			}
			sdpFrozenQuota = sdpFrozenQuota.add(operateQuota);
			remainTotalBalanceDO.setFrozenQuota(sdpFrozenQuota);
			remainTotalBalanceDO.setCanUseQuota(sdpCanUseQuota.subtract(operateQuota));
		} else if (type.equals(FrozenQuotaTypeEnums.FROZEN_QUOTA_RESTORE.code)) {
			if (sdpFrozenQuota.compareTo(operateQuota) < 0) {
				logger.info("[updateForzenSdpRemainBalance] sdpFrozenQuota:[" + sdpFrozenQuota + "] < frozenQuota:[" + operateQuota + "]~~~");
				throw new QuatoOpreateException("SDP_FROZEN_BALANCE_ERROR", "盛付通已冻结额度小于解冻额度", new QuatoOpreationMsgVo(null, null, sdpQuoto,
						sdpFrozenQuota, sdpUsedQuota, QuotaOpTypeEnums.SDP_MERCHANT_QUOTA_OP_TYPE.code));
			}
			BigDecimal _frozenQuota = sdpFrozenQuota.subtract(operateQuota);
			remainTotalBalanceDO.setFrozenQuota(_frozenQuota);
			remainTotalBalanceDO.setCanUseQuota(sdpCanUseQuota.add(operateQuota));
		} else if (type.equals(FrozenQuotaTypeEnums.FROZEN_QUOTA_USED.code)) {
			if (sdpFrozenQuota.compareTo(operateQuota) < 0) {
				logger.info("[updateForzenSdpRemainBalance] sdpFrozenQuota : [" + sdpFrozenQuota + "] < frozenQuota:[" + operateQuota + "]~~~");
				throw new QuatoOpreateException("SDP_CAN_FROZEN_BALANCE_ERROR", "盛付通已冻结额度小于冻结使用额度", new QuatoOpreationMsgVo(null, null, sdpQuoto,
						sdpFrozenQuota, sdpUsedQuota, QuotaOpTypeEnums.SDP_MERCHANT_QUOTA_OP_TYPE.code));
			}
			BigDecimal _frozenQuota = sdpFrozenQuota.subtract(operateQuota);
			remainTotalBalanceDO.setFrozenQuota(_frozenQuota);
			remainTotalBalanceDO.setUsedQuota(remainTotalBalanceDO.getUsedQuota().add(operateQuota));
		}
		remainTotalBalanceDO.setUpdateTime(new Date());
		int rows = extNewt0SdpRemainBalanceManager.updateByPrimaryKeySelective(remainTotalBalanceDO);
		if (rows > 0)
			return true;
		else throw new QuatoOpreateException("SDP_UPDATE_BALANCE_ERROR", "更新额度失败", new QuatoOpreationMsgVo(null, null, sdpQuoto, sdpFrozenQuota,
				sdpUsedQuota, QuotaOpTypeEnums.SDP_MERCHANT_QUOTA_OP_TYPE.code));
	}

	/**
	 * 更新商户/代理商操作
	 * 
	 * @param record
	 *            商户/代理商额度信息
	 * @param operateQuota
	 *            操作额度
	 * @param type
	 *            操作的类型 冻结/解冻/使用
	 * @param begin
	 *            开始时间
	 * @param opType
	 *            "1", "POS商户/MPOS商户" "2", "POS代理商/MPOS代理商"
	 * @param mcType
	 *            商户类型
	 * @return
	 */
	private boolean updatePosMerchantInfo(WithdrawInfoDO record, BigDecimal operateQuota, String type, Date begin, String opType, String mcType) {
		boolean merchantStatus = false;
		if (begin == null) {
			merchantStatus = updateMerchantBalance(record, operateQuota, type);
		} else {
			if (WithdrawLimitType.POS_MPOS_MERCHANT_TYPE.code.equals(opType)) {
				// 商户额度是否共享
				if (merchantIsQuotoShare(mcType, begin, new Date())) {
					merchantStatus = updateMerchantBalance(record, operateQuota, type);
				} else {
					logger.info("LimitationBaseService #updatePosMerchantInfo merchantIsQuotoShare by begin: " + begin + " and BizId: "
							+ record.getBizId() + " is not share");
				}
			} else if (WithdrawLimitType.POS_MPOS_PROMOTO_MERCHANT_TYPE.code.equals(opType)) {
				// 代理商额度是否共享
				if (pmtIsQuotoShare(mcType, begin, new Date())) {
					return updateMerchantBalance(record, operateQuota, type);
				} else {
					logger.info("LimitationBaseService #updatePosMerchantInfo pmtIsQuotoShare by begin: " + begin + " and BizId: "
							+ record.getBizId() + " is not share");
				}
			}
		}
		return merchantStatus;
	}

	/**
	 * 查询垫资额度（盛付通电子总额度）
	 *
	 * @return
	 */
	public Newt0SdpRemainBalanceDO getNowRemainBalance() {
		Date now = new Date();
		Newt0SdpRemainBalanceDOExample example = new Newt0SdpRemainBalanceDOExample();
		Newt0SdpRemainBalanceDOExample.Criteria criteria = example.createCriteria();
		criteria.andStartTimeLessThanOrEqualTo(now);
		criteria.andEndTimeGreaterThanOrEqualTo(now);
		criteria.andCanUseQuotaGreaterThan(new BigDecimal(0));
		List<Newt0SdpRemainBalanceDO> list = extNewt0SdpRemainBalanceManager.selectByExample(example);
		if (list != null && list.size() > 0) { return list.get(0); }
		return null;
	}

	/**
	 * 加数据库锁查询 盛付通电子总额度
	 *
	 * @return
	 */
	private Newt0SdpRemainBalanceDO getNowRemainBalanceForUpdate() {
		List<Newt0SdpRemainBalanceDO> list = extNewt0SdpRemainBalanceManager.selectNowRemainBalanceForUpdate();
		if (list != null && list.size() > 0) { return list.get(0); }
		return null;
	}

	/**
	 * 商户额度操作 冻结/解冻/冻结使用
	 * 
	 * @param totalAmount
	 *            总额度
	 * @param record
	 *            商户额度记录
	 * @param operateQuota
	 *            操作额度
	 * @param type
	 *            操作类型 "1", "解冻操作" "2", "冻结操作" "3", "冻结使用操作"
	 * @param begin
	 *            开始时间
	 * @param mcType
	 *            商户类型
	 * @return
	 */
	private boolean updateMerchantBalance(String merchantNo, PosMerchantInfoDO posmerchantInfo, BigDecimal operateQuota, String type, Date begin,
			String mcType) throws QuatoOpreateException {
		// TODO Auto-generated method stub
		List<WithdrawInfoDO> _list = findWithdrawInfoDOForUpdate(posmerchantInfo, true);
		if (_list == null || _list.size() > 1) { throw new QuatoOpreateException("MERCHANT_WITHDRAW_INFO_NOT_EXSIT", "商户额度信息不存在", null); }
		WithdrawInfoDO record = _list.get(0);
		BigDecimal forzenLimitation = record.getForzenLimitation() == null ? new BigDecimal(0) : record.getForzenLimitation();// 冻结额度
		BigDecimal usedLimitation = record.getUsedLimitation() == null ? new BigDecimal(0) : record.getUsedLimitation();// 已使用额度
		BigDecimal totalAmount = findMerchantFastAmount(merchantNo, mcType);
		// if (totalAmount.compareTo(new BigDecimal(0)) <= 0) { throw new
		// QuatoOpreateException("MERCHANT_TOTAL_AMOUNT_ERROR", "商户结算总额度小于0",new
		// QuatoOpreationMsgVo(null, null, totalAmount, forzenLimitation,
		// usedLimitation,QuotaOpTypeEnums.MERCHANT_QUOTA_OP_TYPE.code)); }
		// if (totalAmount.compareTo(operateQuota) < 0) { throw new
		// QuatoOpreateException("MERCHANT_FROZEN_AMOUNT_ERROR",
		// "商户结算总额度小于冻结额度",new QuatoOpreationMsgVo(null, null, totalAmount,
		// forzenLimitation,
		// usedLimitation,QuotaOpTypeEnums.MERCHANT_QUOTA_OP_TYPE.code)); }
		// if (totalAmount.compareTo(forzenLimitation.add(usedLimitation)) < 0)
		// { throw new QuatoOpreateException("MERCHANT_TOTAL_AMOUNT_ERROR",
		// "商户结算总额度小于已冻结额度加已使用额度",new QuatoOpreationMsgVo(null, null,
		// totalAmount, forzenLimitation,
		// usedLimitation,QuotaOpTypeEnums.MERCHANT_QUOTA_OP_TYPE.code)); }
		// // 结算总额度
		BigDecimal _frozenQuota = null;
		if (type.equals(FrozenQuotaTypeEnums.FROZEN_QUOTA_LIMITATION.code)) {
			// 只有冻结额度 再判断
			if (totalAmount.compareTo(new BigDecimal(0)) <= 0) { throw new QuatoOpreateException("MERCHANT_TOTAL_AMOUNT_ERROR", "商户结算总额度小于0",
					new QuatoOpreationMsgVo(null, null, totalAmount, forzenLimitation, usedLimitation, QuotaOpTypeEnums.MERCHANT_QUOTA_OP_TYPE.code)); }
			if (totalAmount.compareTo(operateQuota) < 0) { throw new QuatoOpreateException("MERCHANT_FROZEN_AMOUNT_ERROR", "商户结算总额度小于冻结额度",
					new QuatoOpreationMsgVo(null, null, totalAmount, forzenLimitation, usedLimitation, QuotaOpTypeEnums.MERCHANT_QUOTA_OP_TYPE.code)); }
			if (totalAmount.compareTo(forzenLimitation.add(usedLimitation)) < 0) { throw new QuatoOpreateException("MERCHANT_TOTAL_AMOUNT_ERROR",
					"商户结算总额度小于已冻结额度加已使用额度", new QuatoOpreationMsgVo(null, null, totalAmount, forzenLimitation, usedLimitation,
							QuotaOpTypeEnums.MERCHANT_QUOTA_OP_TYPE.code)); }

			// 冻结商户额度
			_frozenQuota = forzenLimitation.add(operateQuota);
			if (totalAmount.compareTo(_frozenQuota.add(usedLimitation)) < 0) {
				logger.info("[frozenQuotaOpreate] totalAmount:[" + totalAmount + "] < _frozenQuota.add(usedLimitation):["
						+ _frozenQuota.add(usedLimitation) + "] ~~");
				throw new QuatoOpreateException("MERCHANT_TOTAL_AMOUNT_ERROR", "商户结算总额小于冻结额度+已使用额度", new QuatoOpreationMsgVo(null, null, totalAmount,
						forzenLimitation, usedLimitation, QuotaOpTypeEnums.MERCHANT_QUOTA_OP_TYPE.code));
			}
			if (PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(posmerchantInfo.getMerchantType())
					|| PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(posmerchantInfo.getMerchantType())
					|| PosMerchantTypeEnums.POS_MERCHANT.code.equals(posmerchantInfo.getMerchantType())) {// 身份额度判断
				BigDecimal canUseLimit = getIdentityCanUseLimit(posmerchantInfo, forzenLimitation, usedLimitation, totalAmount, true);
				logger.info("frozenQuotaOpreate identityCanUseLimit:" + canUseLimit + " operateQuota:[" + operateQuota + "] ~~");
				if (canUseLimit != null && canUseLimit.compareTo(operateQuota) < 0) { throw new QuatoOpreateException(
						ReturnCodeEnums.FW_IDENTITY_LIMITE_NOT_ENOUGH.code, ReturnCodeEnums.FW_IDENTITY_LIMITE_NOT_ENOUGH.msg,
						new QuatoOpreationMsgVo(null, null, totalAmount, forzenLimitation, usedLimitation,
								QuotaOpTypeEnums.MERCHANT_QUOTA_OP_TYPE.code)); }
			}
		} else if (type.equals(FrozenQuotaTypeEnums.FROZEN_QUOTA_RESTORE.code)) {
			// 解冻商户额度
			if (forzenLimitation.compareTo(operateQuota) < 0) { throw new QuatoOpreateException("MERCHANT_FROZEN_QUOTA_RESTORE_ERROR",
					"商户已冻结额度小于要解冻的额度", new QuatoOpreationMsgVo(null, null, totalAmount, forzenLimitation, usedLimitation,
							QuotaOpTypeEnums.MERCHANT_QUOTA_OP_TYPE.code)); }
			_frozenQuota = forzenLimitation.subtract(operateQuota);
		} else if (type.equals(FrozenQuotaTypeEnums.FROZEN_QUOTA_USED.code)) {
			if (forzenLimitation.compareTo(operateQuota) < 0) { throw new QuatoOpreateException("MERCHANT_FROZEN_QUOTA_USED_ERROR",
					"商户已冻结额度小于要解冻的额度", new QuatoOpreationMsgVo(null, null, totalAmount, forzenLimitation, usedLimitation,
							QuotaOpTypeEnums.MERCHANT_QUOTA_OP_TYPE.code)); }
			// 商户额度冻结使用
			usedLimitation = usedLimitation.add(operateQuota);
			record.setUsedLimitation(usedLimitation);
			_frozenQuota = forzenLimitation.subtract(operateQuota);
		}
		if (_frozenQuota == null) { throw new QuatoOpreateException("MERCHANT_OP_BALANCE_ERROR", "商户要修改的额度为空", new QuatoOpreationMsgVo(null, null,
				totalAmount, forzenLimitation, usedLimitation, QuotaOpTypeEnums.MERCHANT_QUOTA_OP_TYPE.code)); }
		boolean merchantForzen = updatePosMerchantInfo(record, _frozenQuota, type, begin, WithdrawLimitType.POS_MPOS_MERCHANT_TYPE.code, mcType);
		if (!merchantForzen) { throw new QuatoOpreateException("MERCHANT_UP_BALANCE_ERROR", "商户额度修改错误", new QuatoOpreationMsgVo(null, null,
				totalAmount, forzenLimitation, usedLimitation, QuotaOpTypeEnums.MERCHANT_QUOTA_OP_TYPE.code)); }
		return true;
	}

	/**
	 * 获取商户的身份可用额度
	 * 
	 * @param posmerchantInfo
	 *            商户信息
	 * @param forzenLimitation
	 *            商户已冻结金额
	 * @param usedLimitation
	 *            商户已使用金额
	 * @param totalAmount
	 *            商户的总额
	 * @param isLock
	 *            是否对身份额度加锁
	 * @return
	 */
	private BigDecimal getIdentityCanUseLimit(PosMerchantInfoDO posmerchantInfo, BigDecimal forzenLimitation, BigDecimal usedLimitation,
			BigDecimal totalAmount, boolean isLock) {
		logger.info("getIdentityCanUseLimit init,isLock:" + isLock + " posmerchantInfo:" + ToStringBuilder.reflectionToString(posmerchantInfo));
		List<PosMerchantInfoDO> identityList = getIdentityMerchantInfo(posmerchantInfo);
		List<Long> identityBizIds = getIdentityBizIds(identityList, posmerchantInfo.getId());
		if (identityBizIds != null && identityBizIds.size() > 0) {
			BigDecimal identityLimit = getIdentityLimit(identityList);
			BigDecimal useIdentityLimit = getUsedIdentityLimit(identityBizIds, forzenLimitation.add(usedLimitation), isLock);
			logger.info("getIdentityCanUseLimit identityLimit:" + identityLimit + ",useIdentityLimit:" + useIdentityLimit);
			return identityLimit.subtract(useIdentityLimit);
		} else {
			logger.info("getIdentityCanUseLimit not other Identity merchant ");
		}
		return totalAmount.subtract(usedLimitation);
	}

	/**
	 * 获取商户的身份额度
	 * 
	 * @param merchantNo
	 *            商户号
	 * @param mcType
	 *            商户类型
	 * @return
	 */
	public BigDecimal getIdentityLimit(String merchantNo, String mcType) {
		logger.info("getIdentityLimit init,merchantNo:" + merchantNo + ",mcType:" + mcType);
		List<PosMerchantInfoDO> identityList = getIdentityMerchantInfo(merchantNo, mcType);
		List<Long> identityBizIds = getIdentityBizIds(identityList, null);
		if (identityBizIds != null && identityBizIds.size() > 0) {
			BigDecimal identityLimit = getIdentityLimit(identityList);
			logger.info("getIdentityLimit identityLimit:" + identityLimit);
			return identityLimit;
		} else {
			logger.info("getIdentityLimit not Identity merchant ");
		}
		return null;
	}

	/**
	 * 查询商户的身份证关联的商户信息
	 * 
	 * @param posmerchantInfo
	 *            商户信息
	 * @return
	 */
	private List<PosMerchantInfoDO> getIdentityMerchantInfo(PosMerchantInfoDO posmerchantInfo) {

		List<PosMerchantInfoDO> identityList = posMerchantInfoService.getOpenT0IdentityMerchantInfo(posmerchantInfo.getMerchantNo(),
				posmerchantInfo.getMerchantType());
		if (identityList == null || identityList.isEmpty()
				|| (identityList.size() == 1 && !posmerchantInfo.getId().equals(identityList.get(0).getId()))) {
			logger.error("getIdentityCanUseLimit getOpenT0MerchantInfoByMemberIds is null:");
			throw new QuatoOpreateException("MERCHANT_IDENTITY_LIMIT_ERROR", "商户身份信息关联商户信息无数据", null);
		}
		return identityList;
	}

	/**
	 * 查询商户的身份证关联的商户信息
	 * 
	 * @param merchantNo
	 *            商户号
	 * @param mcType
	 *            商户类型
	 * @return
	 */
	public List<PosMerchantInfoDO> getIdentityMerchantInfo(String merchantNo, String mcType) {
		PosMerchantInfoDO posmerchantInfo = this.posMerchantInfoService.getPosMerchantInfoByMerchantInfo(merchantNo, mcType);
		if (posmerchantInfo == null) { return null; }
		return getIdentityMerchantInfo(posmerchantInfo);
	}

	/**
	 * 检查身份额度是否满足出款额度
	 * 
	 * @param merchantNo
	 *            商户号
	 * @param mcType
	 *            商户类型
	 * @param operateQuota
	 *            操作额度
	 * @param isFrozenLimitation
	 *            额度是否已经冻结
	 * @return true ：满足，false：不满足
	 */
	public boolean checkIdentityLimit(String merchantNo, String mcType, BigDecimal operateQuota, boolean isFrozenLimitation) {
		PosMerchantInfoDO posmerchantInfo = this.posMerchantInfoService.getPosMerchantInfoByMerchantInfo(merchantNo, mcType);
		List<WithdrawInfoDO> _list = findWithdrawInfoDOForUpdate(posmerchantInfo, false);
		if (_list == null || _list.size() > 1) { throw new IdentityLimitException(ReturnCodeEnums.FW_IDENTITY_INFO_IS_NULL.code,
				ReturnCodeEnums.FW_IDENTITY_INFO_IS_NULL.msg); }
		WithdrawInfoDO record = _list.get(0);
		BigDecimal forzenLimitation = record.getForzenLimitation() == null ? new BigDecimal(0) : record.getForzenLimitation();// 冻结额度
		BigDecimal usedLimitation = record.getUsedLimitation() == null ? new BigDecimal(0) : record.getUsedLimitation();// 已使用额度
		BigDecimal totalAmount = findMerchantFastAmount(merchantNo, mcType);
		try {
			BigDecimal canUseLimit = getIdentityCanUseLimit(posmerchantInfo, forzenLimitation, usedLimitation, totalAmount, false);
			if (!isFrozenLimitation) {// 如果没有冻结，就减掉要操作的金额
				canUseLimit = canUseLimit.subtract(operateQuota);
			}
			if (canUseLimit != null && canUseLimit.compareTo(BigDecimal.ZERO) < 0) {
				logger.error("checkIdentityLimit return false, merchantNo:{},mcType:{} canUseLimit:{},operateQuota:{}", new Object[] { merchantNo,
						mcType, canUseLimit, operateQuota });
				return false;
			}
		} catch (IdentityLimitException e) {
			logger.error("checkIdentityLimit IdentityLimitException,Exception", e);
			throw e;
		} catch (Exception e) {
			logger.error("checkIdentityLimit #getIdentityCanUseLimit,Exception", e);
			throw new IdentityLimitException(ReturnCodeEnums.FW_IDENTITY_LIMITE_QUERY_ERROR.code, ReturnCodeEnums.FW_IDENTITY_LIMITE_QUERY_ERROR.msg);
		}
		return true;
	}

	/**
	 * 查询已经使用的身份额度
	 * 
	 * @param merchantNo
	 *            商户号
	 * @param merchantType
	 *            商户类型
	 * @return
	 */
	public BigDecimal queryUsedIdentityLimit(String merchantNo, String merchantType) {
		BigDecimal usedLimit = BigDecimal.ZERO;
		PosMerchantInfoDO posmerchantInfo = this.posMerchantInfoService.getPosMerchantInfoByMerchantInfo(merchantNo, merchantType);
		if (MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN_INT == posmerchantInfo.getFastSettleFlag()) {
			List<WithdrawInfoDO> _list = findWithdrawInfoDOForUpdate(posmerchantInfo, false);
			if (_list == null || _list.size() > 1) { throw new IdentityLimitException(ReturnCodeEnums.FW_IDENTITY_INFO_IS_NULL.code,
					ReturnCodeEnums.FW_IDENTITY_INFO_IS_NULL.msg); }
			WithdrawInfoDO record = _list.get(0);
			BigDecimal forzenLimitation = record.getForzenLimitation() == null ? new BigDecimal(0) : record.getForzenLimitation();// 冻结额度
			BigDecimal usedLimitation = record.getUsedLimitation() == null ? new BigDecimal(0) : record.getUsedLimitation();// 已使用额度
			usedLimit = forzenLimitation.add(usedLimitation);
		}
		List<PosMerchantInfoDO> identityList = posMerchantInfoService.getOpenT0IdentityMerchantInfo(merchantNo, merchantType);
		if (identityList == null || identityList.isEmpty()
				|| (identityList.size() == 1 && !posmerchantInfo.getId().equals(identityList.get(0).getId()))) { throw new IdentityLimitException(
				ReturnCodeEnums.FW_IDENTITY_INFO_IS_NULL.code, ReturnCodeEnums.FW_IDENTITY_INFO_IS_NULL.msg); }
		List<Long> identityBizIds = getIdentityBizIds(identityList, posmerchantInfo.getId());
		if (identityBizIds != null && identityBizIds.size() > 0) { return getUsedIdentityLimit(identityBizIds, usedLimit, false); }

		return usedLimit;
	}

	/**
	 * 获取已经使用的身份额度
	 * 
	 * @param identityBizIds
	 *            身份对应信息
	 * @param useLimit
	 *            已使用额度
	 * @param isLock
	 *            是否加锁
	 * @return
	 */
	private BigDecimal getUsedIdentityLimit(List<Long> identityBizIds, BigDecimal useLimit, boolean isLock) {
		if (useLimit == null) {
			useLimit = BigDecimal.ZERO;
		}
		if (identityBizIds.size() > 500) { throw new IdentityLimitException(ReturnCodeEnums.FW_IDENTITY_LIMITE_MERCHANT_TOO_MUCH.code,
				ReturnCodeEnums.FW_IDENTITY_LIMITE_MERCHANT_TOO_MUCH.msg + "，绑定了" + identityBizIds.size() + "商户,大于500个商户"); }
		List<WithdrawInfoDO> list = this.extWithdrawInfoManager.findWithdrawInfoByMemberIds(identityBizIds, isLock);
		if (list != null && !list.isEmpty()) {
			for (WithdrawInfoDO info : list) {
				useLimit = useLimit.add(info.getForzenLimitation() == null ? BigDecimal.ZERO : info.getForzenLimitation());
				useLimit = useLimit.add(info.getUsedLimitation() == null ? BigDecimal.ZERO : info.getUsedLimitation());
			}
		}
		return useLimit;
	}

	/**
	 * 获取身份额度
	 * 
	 * @param identityList
	 * @return
	 */
	private BigDecimal getIdentityLimit(List<PosMerchantInfoDO> identityList) {
		BigDecimal identityLimit = BigDecimal.ZERO;
		for (PosMerchantInfoDO info : identityList) {
			if (identityLimit.compareTo(info.getFastSettleLimit()) < 0) {
				identityLimit = info.getFastSettleLimit();
			}
		}
		return identityLimit;
	}

	/**
	 * 获取 身份信息对应的商户的业务ID
	 * 
	 * @param identityList
	 *            所有身份信息
	 * @param id
	 *            排除的上商户ID 为空，不排除
	 * @return
	 */
	private List<Long> getIdentityBizIds(List<PosMerchantInfoDO> identityList, Long id) {
		if (identityList == null || identityList.isEmpty()) { return null; }
		List<Long> identityBizIds = new ArrayList<Long>();
		for (PosMerchantInfoDO info : identityList) {
			if (id == null || !info.getId().equals(id)) {
				identityBizIds.add(info.getId());
			}
		}
		return identityBizIds;
	}

	/**
	 * 查询结算总额度
	 * 
	 * @param merchantNo
	 * @param mcType
	 */
	public BigDecimal findMerchantFastAmount(String merchantNo, String mcType) {
		if (StringUtils.isEmpty(merchantNo) || StringUtils.isEmpty(mcType)) {
			logger.info("findTotalAmount merchantNo is null or mcType is null");
			return new BigDecimal(0);
		}

		// 判断是否是节假日
		boolean isHoliday = workCalendarService.isHolidayTime(new Date());
		boolean isUseTemporaryLimit = true;
		return findMerchantFastAmount(merchantNo, mcType, isHoliday, isUseTemporaryLimit);

	}

	/**
	 *
	 * @param merchantNo
	 * @param mcType
	 * @param isHoliday
	 *            true 节假日 false 工作日
	 * @param isUseTemporaryLimit
	 *            true返回临时额度 fase使用数据库中存储的原快速结算额度 注：如果需要查询节假日额度isHoliday true
	 *            ，则isUseTemporaryLimit为false
	 *
	 * @return
	 */
	public BigDecimal findMerchantFastAmount(String merchantNo, String mcType, boolean isHoliday, boolean isUseTemporaryLimit) {
		BigDecimal merchantFastAmount = BigDecimal.ZERO;
		String opType = "";
		if (PosMerchantTypeEnums.POS_MERCHANT.code.equals(mcType) || PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(mcType)
				|| PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(mcType)) {
			ViewMerchantInfoDTO merchantInfo = merchantInfoService.queryMerchantInfoByMerchantNo(merchantNo, mcType);
			if (merchantInfo == null) {
				logger.info("LimitationServiceImpl#findMerchantFastAmount query POS_MERCHANT merchant by merchantNo:[" + merchantNo
						+ "] and mcType: [" + mcType + "] amount is null~~");
				return new BigDecimal(0);
			}

			if (merchantInfo.getMerchantFsLimit() == null) return new BigDecimal(0);
			merchantFastAmount = merchantInfo.getMerchantFsLimit();
			opType = PosMerchantTypeEnums.POS_MERCHANT.code.equals(mcType) ? WithdrawConfigEnums.T0_POS_LIMITATION_PERCENTAGE.code
					: PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(mcType) ? WithdrawConfigEnums.T0_MPOS_MERCHANT_LIMITATION_PERCENTAGE.code
							: WithdrawConfigEnums.T0_EASYPAY_MERCHANT_LIMITATION_PERCENTAGE.code;
		} else if (PosMerchantTypeEnums.POS_PROMOTER.code.equals(mcType) || PosMerchantTypeEnums.MPOS_PROMOTER.code.equals(mcType)
				|| PosMerchantTypeEnums.EASYPAY_PROMOTER.code.equals(mcType)) {
			List<ViewPromoterInfoDTO> promoterList = promoterInfoService.queryPromoterInfoByMerchantInfo(merchantNo, mcType);
			if (promoterList == null || promoterList.isEmpty()) {
				logger.info("LimitationServiceImpl#findMerchantFastAmount query POS_PROMOTER merchant by merchantNo:[" + merchantNo
						+ "] and mcType: [" + mcType + "] amount is null~~");
				return new BigDecimal(0);
			}
			ViewPromoterInfoDTO promoterEo = promoterList.get(0);
			if (promoterEo.getPromoterFsLimit() == null) { return new BigDecimal(0); }
			merchantFastAmount = promoterEo.getPromoterFsLimit();
			opType = PosMerchantTypeEnums.POS_PROMOTER.code.equals(mcType) ? WithdrawConfigEnums.T0_POS_PMT_LIMITATION_PERCENTAGE.code
					: PosMerchantTypeEnums.MPOS_PROMOTER.code.equals(mcType) ? WithdrawConfigEnums.T0_MPOS_PMT_LIMITATION_PERCENTAGE.code
							: WithdrawConfigEnums.T0_EASYPAY_PMT_LIMITATION_PERCENTAGE.code;
		}
		if (StringUtils.isEmpty(opType)) {
			logger.info("LimitationServiceImpl#findTotalAmount opType is null ");
			return new BigDecimal(0);
		}
		BigDecimal tempLimit = null;
		if (isUseTemporaryLimit) {
			// 临时调额
			AuditInfoDTO auditInfo = extNewT0AuditInfoManager.selectAuditedTempLimitInfoByMerchantInfo(merchantNo, mcType);
			if (auditInfo != null && auditInfo.getTempLimitInfo() != null && auditInfo.getTempLimitInfo().getAuditLimit() != null) {
				tempLimit = auditInfo.getTempLimitInfo().getAuditLimit();
			}
		}
		if (isHoliday) {
			String configRatio = null;
			// 节假日白名单
			WhiteListInfoDO whiteInfo = whiteListInfoService.queryWhiteListInfo(WhiteTypeEnums.HOLIDAYS_LIMIT.code, merchantNo, mcType);
			if (whiteInfo != null && NumberUtils.isNumber(whiteInfo.getContent())) {
				configRatio = whiteInfo.getContent();
			}
			if (configRatio == null) {
				ConfigOptionDO config = findConfigOptionDO(opType);
				if (config != null) {
					configRatio = config.getOptionValue();
				}
			}
			merchantFastAmount = calculationFastSettleLimit(merchantFastAmount, configRatio);
		}
		return tempLimit != null && tempLimit.compareTo(merchantFastAmount) > 0 ? tempLimit : merchantFastAmount;
	}

	/**
	 * 更新商户额度操作
	 * 
	 * @param record
	 * @param operateQuota
	 *            操作额度
	 * @param type
	 *            1 冻结 2：解冻 3:已使用
	 * @return
	 */
	private boolean updateMerchantBalance(WithdrawInfoDO record, BigDecimal operateQuota, String type) {
		// TODO Auto-generated method stub
		record.setForzenLimitation(operateQuota);
		record.setUpdateTime(new Date());
		int rows = withdrawInfoManager.updateByPrimaryKey(record);
		if (rows > 0) {
			// TODO 插入LOG
			String jsonContent = JSONObject.fromObject(record).toString();
			if (type.equals(FrozenQuotaTypeEnums.FROZEN_QUOTA_LIMITATION.code)) {
				insertOpLogRecord(jsonContent, LogRecordTypeEnums.FROZEN_QUOTA_LIMITATION.code, LogOPTypeEnums.UPDATE.code);
			} else if (type.equals(FrozenQuotaTypeEnums.FROZEN_QUOTA_RESTORE.code)) {
				insertOpLogRecord(jsonContent, LogRecordTypeEnums.FROZEN_QUOTA_RESTORE.code, LogOPTypeEnums.UPDATE.code);
			} else if (type.equals(FrozenQuotaTypeEnums.FROZEN_QUOTA_USED.code)) {
				insertOpLogRecord(jsonContent, LogRecordTypeEnums.FROZEN_QUOTA_USED.code, LogOPTypeEnums.UPDATE.code);
			}
			return true;
		}
		return false;
	}

	/**
	 * 根据POS商户T0出款额度比例计算 周五是工作日额度，周六、周日每天是工作日额度的50%
	 * 
	 * @param limitation
	 *            出款额度
	 * @return
	 */
	public BigDecimal calculationFastSettleLimit(BigDecimal limitation, String configRatio) {
		// TODO Auto-generated method stub

		BigDecimal calculation = null;
		if (configRatio == null || !NumberUtils.isNumber(configRatio)) {
			calculation = new BigDecimal(1);
		} else {
			calculation = new BigDecimal(configRatio.trim());
		}
		limitation = limitation.multiply(new BigDecimal(100));
		BigDecimal newLimitation = limitation.multiply(calculation).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
		return newLimitation;
	}

	/**
	 * 查询配置
	 *
	 * @param optionKey
	 * @return
	 */
	public ConfigOptionDO findConfigOptionDO(String optionKey) {
		ConfigOptionDOExample configExample = new ConfigOptionDOExample();
		ConfigOptionDOExample.Criteria configCriteria = configExample.createCriteria();
		configCriteria.andOptionKeyEqualTo(optionKey);
		List<ConfigOptionDO> config = configOptionManager.selectByExample(configExample);
		if (config == null || config.isEmpty() || config.get(0).getOptionValue() == null) {
			logger.info("[findConfigOptionDO] findConfigOptionDO by optionKey:[" + optionKey + "] value is null");
			return null;
		}
		return config.get(0);
	}

	/**
	 * 查询额度日历信息根据biz_id
	 *
	 * @param id
	 * @return
	 */
	public List<WithdrawInfoDO> getWithdrawInfoDO(Long id) {
		WithdrawInfoDOExample example = new WithdrawInfoDOExample();
		WithdrawInfoDOExample.Criteria criteria = example.createCriteria();
		criteria.andBizIdEqualTo(id);
		criteria.andBizTypeEqualTo(BizTypeEnums.POS_MERCHANT_TYPE.code);
		List<WithdrawInfoDO> list = withdrawInfoManager.selectByExample(example);
		if (list == null || list.isEmpty()) {
			return null;
		} else if (list.size() > 1) {
			logger.info("查询额度记录 getWithdrawInfoDO 存在多条记录 ID : " + id);
		}
		return list;
	}

	/**
	 * 加数据库锁 查询
	 *
	 * @param example
	 * @return
	 */
	private List<WithdrawInfoDO> getWithdrawInfoDOForUpdate(Long id, boolean isForUpdate) {
		WithdrawInfoDOExample example = new WithdrawInfoDOExample();
		example.setBizId(id);
		example.setBizType(BizTypeEnums.POS_MERCHANT_TYPE.code);
		List<WithdrawInfoDO> list = extWithdrawInfoManager.findWithdrawInfoByExampleForUpdate(example, isForUpdate);
		if (list == null || list.isEmpty()) {
			return null;
		} else if (list.size() > 1) {
			logger.info("查询额度记录 getWithdrawInfoDO 存在多条记录 ID : " + id);
		}
		return list;
	}

	/**
	 * 查询商户额度日历信息
	 *
	 * @param posMerchantInfo
	 *            商户信息
	 * @return
	 */
	public List<WithdrawInfoDO> getWithdrawInfoDOByBizId(PosMerchantInfoDO posMerchantInfo) {
		List<WithdrawInfoDO> _list = getWithdrawInfoDO(posMerchantInfo.getId());
		if (_list == null || _list.isEmpty()) {
			// TODO 同步额度日历数据
			try {
				if (!insertWithdrawRecord(posMerchantInfo)) { return null; }
			} catch (QuatoOpreateException e) {
				logger.error("getWithdrawInfoDOByBizId error:" + e.getErrorMsg());
				return null;
			}
			_list = getWithdrawInfoDO(posMerchantInfo.getId());
		}
		return _list;
	}

	/**
	 * 查询商户额度日历信息 加数据库锁查询
	 *
	 * @param posMerchantInfo
	 *            商户信息
	 * @return
	 */
	private List<WithdrawInfoDO> findWithdrawInfoDOForUpdate(PosMerchantInfoDO posMerchantInfo, boolean isForUpdate) {
		if (posMerchantInfo == null) { return null; }
		List<WithdrawInfoDO> _list = getWithdrawInfoDOForUpdate(posMerchantInfo.getId(), isForUpdate);

		/*if (_list == null || _list.isEmpty()) { // TODO 同步额度日历数据
			try {
				if (!insertWithdrawRecord(posMerchantInfo)) { return null; }
			} catch (QuatoOpreateException e) {
				logger.error("getWithdrawInfoDOForUpdate error:" + e.getErrorMsg());
				return null;
			}
			_list = getWithdrawInfoDOForUpdate(posMerchantInfo.getId(), isForUpdate);
		}*/

		return _list;
	}

	/**
	 * 查找商户信息
	 *
	 * @param example
	 * @return
	 */
	/*
	 * private List<PosMerchantInfoDO>
	 * findPosMerchantInfoByExample(PosMerchantInfoDOExample example) { // TODO
	 * Auto-generated method stub PosMerchantInfoDOExample.Criteria criteria =
	 * example.createCriteria(); if
	 * (!StringUtils.isEmpty(example.getMerchantNo())) {
	 * criteria.andMerchantNoEqualTo(example.getMerchantNo()); } if
	 * (example.getId() != null) { criteria.andIdEqualTo(example.getId()); } if
	 * (!StringUtils.isEmpty(example.getMerchantType())) {
	 * criteria.andMerchantTypeEqualTo(example.getMerchantType()); } return
	 * posMerchantInfoManager.selectByExample(example); }
	 */

	/**
	 * 插入额度日历记录
	 *
	 * @param info
	 *            商户信息
	 * @return
	 */
	public boolean insertWithdrawRecord(PosMerchantInfoDO info) throws QuatoOpreateException {
		List<WithdrawInfoDO> withrawList = getWithdrawInfoDO(info.getId());
		if (withrawList != null && withrawList.size() > 1) {
			logger.error("SYNC_WITHDRAW_INFO_ERROR 同步额度日历数据异常  存在多条记录" + info.getId());
			return false;
		}
		if (withrawList != null && withrawList.size() == 1) {
			logger.error("SYNC_WITHDRAW_INFO_ERROR 同步额度日历数据异常  数据已存在" + info.getId());
			return false;
		}
		WithdrawInfoDO record = new WithdrawInfoDO();
		record.setBizId(info.getId());
		String merchantNo = info.getMerchantNo();
		String mcType = info.getMerchantType();
		record.setBizType(BizTypeEnums.POS_MERCHANT_TYPE.code);
		BigDecimal totalAmount = findMerchantFastAmount(merchantNo, mcType);
		record.setLimitation(totalAmount);
		record.setLimitationType(LimitationTypeEnums.FASTSETTLE_LIMITATION.code);
		record.setCreateTime(new Date());
		record.setUpdateTime(new Date());
		try {
			Long id = withdrawInfoManager.insert(record);
			if (id > 0) {
				// 插入log
				String jsonContent = JSONObject.fromObject(record).toString();
				insertOpLogRecord(jsonContent, LogRecordTypeEnums.SYNC_MERCHANT_WITHDRAW.code, LogOPTypeEnums.CREATE.code);
				return true;
			} else {
				logger.error("INSERT_WITHDRAW_RECORD_ERROR 插入额度日历数据异常");
				return false;
			}
		} catch (DuplicateKeyException e) {
			logger.error("INSERT_WITHDRAW_RECORD_ERROR DuplicateKeyException", e);
			return true;
		}
	}

	/**
	 * 查询代理商额度日历 加数据库锁 查询
	 *
	 * @param posMerchantInfo
	 *            商户信息
	 * @return
	 */
	private List<WithdrawInfoDO> findPmtWithdrawInfoDOForUpdate(PosMerchantInfoDO posMerchantInfo) {

		List<WithdrawInfoDO> _list = getWithdrawInfoDOForUpdate(posMerchantInfo.getId(), true);
		if (_list == null || _list.isEmpty()) {
			// TODO 同步额度日历数据
			try {
				if (!insertWithdrawRecord(posMerchantInfo)) { return null; }
			} catch (QuatoOpreateException e) {
				logger.error("findPmtWithdrawInfoDOForUpdate error:" + e.getErrorMsg());
				return null;
			}
			_list = getWithdrawInfoDOForUpdate(posMerchantInfo.getId(), true);
		}
		return _list;
	}

	/**
	 * 判断商户额度是否共享 true:共享 false：不共享
	 *
	 * @param mcType
	 * @param reqDate
	 *            请求发起日期
	 * @param respDate
	 *            请求回调日期
	 * @return
	 */
	public boolean merchantIsQuotoShare(String mcType, Date reqDate, Date respDate) {
		// if (PosMerchantTypeEnums.POS_MERCHANT.code.equals(mcType)) {
		// if (DateUtil.whetherEveryDay(reqDate, respDate)) { return false; }
		// } else if (PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(mcType)) {
		// return isShareForDay(mcType,reqDate, respDate);
		// }
		// return true;
		if (!DateUtil.whetherEveryDay(reqDate, respDate)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 代理商额度是否共享
	 *
	 * @param reqDate
	 *            请求发起日期
	 * @param respDate
	 *            请求回调日期
	 * @return
	 */
	public boolean pmtIsQuotoShare(String pmtMcType, Date reqDate, Date respDate) {
		// return isShareForDay(pmtMcType,reqDate, respDate);

		if (!DateUtil.whetherEveryDay(reqDate, respDate)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据开始、结束日期判断是否共享
	 *
	 * @param reqDate
	 *            请求发起日期
	 * @param respDate
	 *            请求回调日期
	 * @return
	 */
	public boolean isShareForDay(String mcType, Date reqDate, Date respDate) {
		// 周五是工作日额度，周六、周日两天共享1个工作日额度；（节假日同理）
		if (PosMerchantTypeEnums.POS_PROMOTER.code.equals(mcType) || PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(mcType)) {
			List<WorkCalendarDO> worklist = workCalendarService.findWorkTimelist(reqDate, respDate);
			if (worklist.size() == 1) { return true; }
			boolean yestoryIsHoliday = workCalendarService.isHolidayTime(DateUtil.increaseDate(reqDate, -1));
			for (WorkCalendarDO work : worklist) {
				if (yestoryIsHoliday || WorkDayTypeEnums.UN_HOLIDAY.code == work.getIsHoliday()) { return false; }
			}
			return true;
		} else if (PosMerchantTypeEnums.MPOS_PROMOTER.code.equals(mcType)) {
			// MPOS代理商 每天都是工作日额度
			// 不跨天 共享额度
			if (!DateUtil.whetherEveryDay(reqDate, respDate)) { return true; }
		}
		return false;
	}

	/**
	 * 取垫资方
	 *
	 * @param promoterId
	 * @return
	 */
	private LoaningTypeEnum getLoaningTypeEnum(Long promoterId) {
		Newt0PromoterDO promoterDO = newt0PromoterManager.getPromoterByMerchantId(promoterId);
		if (promoterDO == null) { return null; }
		Integer loaingType = promoterDO.getLoaningType();
		LoaningTypeEnum loaningTypeEnum = LoaningTypeEnum.getLoaningTypeEnum(loaingType);
		return loaningTypeEnum;
	}

	/**
	 * 发送邮件提醒
	 * 
	 * @param title
	 * @param content
	 */
	public void sendMailMsg(final String title, final String content) {
		try {
			final String mailList = ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.T0_QUOTA_OP_ERROR_MAIL_LIST);
			if (StringUtils.isEmpty(mailList)) {
				logger.error("LimitationBaseService.sendMailMsg.error,mail list is not configured");
				return;
			}
			Thread t = new Thread() {
				public void run() {
					AlertMessageSender sender = alertMessageSenderFactory.getAlertMessageSender(AlertMessageSendTypeEnum.MAIL_ALERT);
					sender.sendMessage(title, content, mailList);
				}
			};
			t.start();
		} catch (Exception e) {
			logger.info("LimitationBaseService.sendMailMsg.error,content=" + content, e);
		}
	}

	public Long syncMerchantPromoterInfo(String merchantNo, String mcType) {
		List<PosMerchantInfoDO> list = posMerchantInfoService.getPosMerchantInfosByMerchantInfo(merchantNo, mcType);
		if (list == null || list.isEmpty()) {
			ViewPromoterInfoDTO promoterInfo = promoterInfoService.queryPromoterInfo(merchantNo, mcType);
			if (promoterInfo != null) { return insertPromoterMerchantInfo(promoterInfo.getPromoterId(), merchantNo, mcType); }
		}
		return -1L;
	}

}
