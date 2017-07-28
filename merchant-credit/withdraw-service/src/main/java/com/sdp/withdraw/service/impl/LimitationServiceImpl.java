package com.sdp.withdraw.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.drools.core.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.enums.withdraw.FrozenQuotaTypeEnums;
import com.sdp.mc.common.enums.withdraw.LogOPTypeEnums;
import com.sdp.mc.common.enums.withdraw.LogRecordTypeEnums;
import com.sdp.mc.common.enums.withdraw.QuotaOpTypeEnums;
import com.sdp.mc.common.exception.IdentityLimitException;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.newt0.manager.ExtNewt0SdpRemainBalanceManager;
import com.sdp.mc.view.dao.ViewMerchantInfoDTO;
import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.dao.PosMerchantInfoDOExample;
import com.sdp.withdraw.dao.WithdrawInfoDO;
import com.sdp.withdraw.dao.ext.OpLogRecordVO;
import com.sdp.withdraw.dao.ext.QuatoOpreationMsgVo;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.sdp.withdraw.error.QuatoOpreateException;
import com.sdp.withdraw.manager.PosMerchantInfoManager;
import com.sdp.withdraw.manager.WithdrawInfoManager;
import com.sdp.withdraw.service.BaseService;
import com.sdp.withdraw.service.LimitationService;
import com.sdp.withdraw.service.OpLogRecordService;
import com.shengpay.service.view.MerchantInfoService;

@Service("limitationService")
public class LimitationServiceImpl extends BaseService implements LimitationService {

	private static Logger logger = LoggerFactory.getLogger(LimitationServiceImpl.class);

	@Autowired
	private PosMerchantInfoManager posMerchantInfoManager;
	@Autowired
	private WithdrawInfoManager withdrawInfoManager;
	@Autowired
	protected ExtNewt0SdpRemainBalanceManager extNewt0SdpRemainBalanceManager;
	@Autowired
	private LimitationBaseService limitationBaseService;
	@Autowired
	private OpLogRecordService opLogRecordService;
	@Autowired
	private MerchantInfoService merchantInfoService;

	/**
	 * 查询用额度（商户/代理商）
	 * 
	 * @param merchantNo
	 *            商户号
	 * @param mcType
	 *            商户类型
	 */
	@Override
	public BigDecimal findMerchantFastCanUseQuota(String merchantNo, String mcType) {
		List<PosMerchantInfoDO> list = findPosMerchantInfo(merchantNo, mcType);
		if (list == null) { return null; }
		PosMerchantInfoDO posMerchantInfo = list.get(0);

		// 查询商户额度日历信息
		List<WithdrawInfoDO> _list = limitationBaseService.getWithdrawInfoDOByBizId(posMerchantInfo);
		if (_list == null || list.size() > 1) { return null; }
		BigDecimal totalAmount = limitationBaseService.findMerchantFastAmount(merchantNo, mcType);// 总额度
		if (totalAmount.compareTo(BigDecimal.ZERO) <= 0) { return totalAmount; }
		WithdrawInfoDO withdraw = _list.get(0);
		// 可用额度 = 总额度-已使用额度-冻结额度
		BigDecimal usedLimiat = withdraw.getUsedLimitation();
		BigDecimal forzenLimitat = withdraw.getForzenLimitation();
		if (usedLimiat == null) {
			usedLimiat = new BigDecimal(0);
		}
		if (forzenLimitat == null) {
			forzenLimitat = new BigDecimal(0);
		}
		return totalAmount.subtract(usedLimiat).subtract(forzenLimitat);
	}

	/**
	 * 查询商户信息
	 * 
	 * @param merchantNo
	 * @param mcType
	 * @return
	 */
	private List<PosMerchantInfoDO> findPosMerchantInfo(String merchantNo, String mcType) {
		logger.info("LimitationServiceImpl#findPosMerchantInfo,merchantNo:{}, mcType:{}", new Object[] { merchantNo, mcType });
		if (StringUtils.isEmpty(merchantNo) || StringUtils.isEmpty(mcType)) {
			logger.error("LimitationServiceImpl#findPosMerchantInfo,merchantNo or mcType is null");
			return null;
		}
		// 根据商户号查询商户信息
		List<PosMerchantInfoDO> list = findPosMerchantInfoIdByNo(merchantNo, mcType);
		if (list == null || list.isEmpty()) {
			logger.info("LimitationServiceImpl#findPosMerchantInfo,FW_POS_MERCHANT_INFO record is not exsits.merchantNo:{}, mcType:{}", new Object[] {
					merchantNo, mcType });
			ErrorMessageVO<Long> message = syncPosMerchantInfoByMerchantNo(merchantNo, mcType);
			if (!message.isSuccess()) {
				logger.info("LimitationServiceImpl#findPosMerchantInfo,syncPosMerchantInfo failure.");
				return null;
			}
			list = findPosMerchantInfoIdByNo(merchantNo, mcType);
		}
		if (list.size() > 1) {
			logger.info("LimitationServiceImpl#findPosMerchantInfo,error:" + WithdrawConstant.WITHDRAW_QUERY_ERROR_NOT_UNIQUE);
			return null;
		}
		return list;
	}

	/**
	 * 同步POS数据 根据商户号查询商户信息(PCS.CM_POS_MERCHANT)
	 * 
	 * @param merchantNo
	 * @param mcType
	 * @return
	 */
	@Override
	public synchronized ErrorMessageVO<Long> syncPosMerchantInfoByMerchantNo(String merchantNo, String mcType) {
		logger.info("LimitaionServiceImpl#syncPosMerchantInfoByMerchantNo,merchantNo" + merchantNo + ",mcType:" + mcType);
		ErrorMessageVO<Long> message = new ErrorMessageVO<Long>(false);
		if (StringUtils.isEmpty(merchantNo) || StringUtils.isEmpty(mcType)) {
			message.setErrorMessage("参数 商户号或商户类型,不能为空.");
			return message;
		}
		Long values = -1L;
		try {
			// 商户类型
			if (PosMerchantTypeEnums.POS_MERCHANT.code.equals(mcType) || PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(mcType)) {
				ViewMerchantInfoDTO merchantInfo = merchantInfoService.queryMerchantInfoByMerchantNo(merchantNo, mcType);
				if (merchantInfo == null) {
					message.setErrorMessage("根据商户号[" + merchantNo + "]类型[" + mcType + "]查找 代理商/商户信息不存在!");
					logger.info("LimitaionServiceImpl#syncPosMerchantInfoByMerchantNo,merchantNo:{},mcType:{},MSP_POS_MERCHANT is not exsist.",
							new Object[] { merchantNo, mcType });
					return message;
				}
				values = limitationBaseService.insertMerchantInfo(merchantInfo);
			} else if (PosMerchantTypeEnums.POS_PROMOTER.code.equals(mcType) || PosMerchantTypeEnums.MPOS_PROMOTER.code.equals(mcType)) {
				values = limitationBaseService.syncMerchantPromoterInfo(merchantNo, mcType);
			}
		} catch (QuatoOpreateException e) {
			logger.error("LimitaionServiceImpl#syncPosMerchantInfoByMerchantNo,merchantNo:{},mcType:{},{}", new Object[] { merchantNo, mcType, e });
			// return message;
		}

		if (values > 0) {
			message.setSuccess(true);
			message.setEntity(values);
			return message;
		} else {
			message.setErrorMessage("根据商户号[" + merchantNo + "]类型[" + mcType + "]查找 插入商户信息异常");
		}
		return message;
	}

	/**
	 * 根据商户号查询商户信息
	 * 
	 * @param merchantNo
	 * @param mcType
	 * @return
	 */
	private List<PosMerchantInfoDO> findPosMerchantInfoIdByNo(String merchantNo, String mcType) {
		PosMerchantInfoDOExample example = new PosMerchantInfoDOExample();
		PosMerchantInfoDOExample.Criteria criteria = example.createCriteria();
		criteria.andMerchantNoEqualTo(merchantNo);
		criteria.andMerchantTypeEqualTo(mcType);
		return posMerchantInfoManager.selectByExample(example);
	}

	/**
	 * 查询冻结额度
	 * 
	 * @param merchantNo
	 * @param mcType
	 * @return
	 */
	@Override
	public BigDecimal findFrozenQuota(String merchantNo, String mcType) {
		// TODO Auto-generated method stub
		List<PosMerchantInfoDO> list = findPosMerchantInfo(merchantNo, mcType);
		if (list == null) { return null; }
		PosMerchantInfoDO posMerchantInfo = list.get(0);
		List<WithdrawInfoDO> _list = limitationBaseService.getWithdrawInfoDOByBizId(posMerchantInfo);
		if (_list == null || _list.size() > 1) { return null; }
		return _list.get(0).getForzenLimitation();
	}

	/**
	 * 冻结操作
	 * 
	 * @param merchantNo
	 * @param mcType
	 * @param frozenQuota
	 *            冻结额度
	 * @throws QuatoOpreateException
	 */
	public  boolean frozenLimitation(String merchantNo, String mcType, BigDecimal frozenQuota) {
		// TODO Auto-generated method stub
		if (frozenQuota == null || frozenQuota.compareTo(new BigDecimal(0)) < 0) {
			logger.info("LimitationServiceImpl #frozenLimitation frozenQuota 为{}" + frozenQuota);
			return false;
		}
		List<PosMerchantInfoDO> list = findPosMerchantInfo(merchantNo, mcType);
		if (list == null) {
			logger.info("LimitationServiceImpl #frozenLimitation findPosMerchantInfo list = " + list);
			return false;
		}
		boolean value = false;
		try {
			value = quotaOpreate(merchantNo, frozenQuota, list, FrozenQuotaTypeEnums.FROZEN_QUOTA_LIMITATION.code, null);
			logger.info("LimitationServiceImpl #frozenLimitation quotaOpreate value = " + value);
		} catch (QuatoOpreateException e) {
			logger.error("LimitationBaseService #frozenLimitation merchantNo:" + merchantNo + " mcType:" + mcType + " frozenQuota:" + frozenQuota
					+ " error: " + e.getErrorMsg());
			value = false;
		}catch (IdentityLimitException e) {
			logger.error("LimitationBaseService #frozenLimitation merchantNo:" + merchantNo + " mcType:" + mcType + " frozenQuota:" + frozenQuota
					+ " error: " + e.getErrorMessage());
			value = false;
		} catch (Exception e) {
			logger.error("LimitationBaseService #frozenLimitation Exception error : merchantNo:" + merchantNo + " mcType:" + mcType
					+ " frozenQuota: " + frozenQuota + " error: " + e.getMessage(), e);
			limitationBaseService.sendMailMsg("冻结操作异常", initErrorMsgContent(merchantNo, mcType, frozenQuota, e));
			value = false;
		}
		return value;
	}

	/**
	 * 冻结操作(T0)
	 * 
	 * @param merchantNo
	 * @param mcType
	 * @param frozenQuota
	 *            冻结额度
	 * @param begin
	 *            开始时间
	 * @throws QuatoOpreateException
	 */
	@Override
	public  boolean frozenLimitationByIsQuotoShare(String merchantNo, String mcType, BigDecimal frozenQuota, Date begin) {
		// TODO Auto-generated method stub
		if (frozenQuota == null || frozenQuota.compareTo(new BigDecimal(0)) < 0 || begin == null) {
			logger.info("LimitationBaseService #frozenLimitationByIsQuotoShare frozenQuota 为{}" + frozenQuota);
			return false;
		}
		List<PosMerchantInfoDO> list = findPosMerchantInfo(merchantNo, mcType);
		if (list == null) {
			logger.info("LimitationBaseService #frozenLimitationByIsQuotoShare findPosMerchantInfo list = " + list);
			return false;
		}
		boolean value = false;
		try {
			value = quotaOpreate(merchantNo, frozenQuota, list, FrozenQuotaTypeEnums.FROZEN_QUOTA_LIMITATION.code, begin);
			logger.info("LimitationBaseService #frozenLimitationByIsQuotoShare quotaOpreate value = " + value);
		} catch (QuatoOpreateException e) {
			logger.error("LimitationBaseService #frozenLimitationByIsQuotoShare merchantNo:" + merchantNo + " mcType:" + merchantNo
					+ " frozenQuota : " + frozenQuota + " error:" + e.getErrorMsg(), e);
			value = false;
		}catch (IdentityLimitException e) {
			logger.error("LimitationBaseService #frozenLimitationByIsQuotoShare merchantNo:" + merchantNo + " mcType:" + merchantNo
					+ " frozenQuota : " + frozenQuota + " error:" + e.getErrorMessage(), e);
			value = false;
		} catch (Exception e) {
			logger.error("LimitationBaseService #frozenLimitationByIsQuotoShare Exception merchantNo:" + merchantNo + " mcType:" + merchantNo
					+ " frozenQuota : " + frozenQuota + " error:" + e.getMessage(), e);
			limitationBaseService.sendMailMsg("冻结操作(T0)", initErrorMsgContent(merchantNo, mcType, frozenQuota, e));
			value = false;
		}
		return value;
	}

	/**
	 * 解冻
	 * 
	 * @param merchantNo
	 * @param mcType
	 * @param frozenQuota
	 *            解冻额度
	 * @return
	 * @throws QuatoOpreateException
	 */
	@Override
	public  boolean restoreFrozenQuota(String merchantNo, String mcType, BigDecimal frozenQuota) {
		// TODO Auto-generated method stub
		if (frozenQuota == null || frozenQuota.compareTo(new BigDecimal(0)) < 0) {
			logger.info("LimitationBaseService #restoreFrozenQuota frozenQuota : [" + frozenQuota + "]");
			return false;
		}
		List<PosMerchantInfoDO> list = findPosMerchantInfo(merchantNo, mcType);
		if (list == null) {
			logger.info("LimitationBaseService #restoreFrozenQuota findPosMerchantInfo list =" + list);
			return false;
		}
		boolean value = false;
		try {
			value = quotaOpreate(merchantNo, frozenQuota, list, FrozenQuotaTypeEnums.FROZEN_QUOTA_RESTORE.code, null);
			logger.info("LimitationBaseService #restoreFrozenQuota quotaOpreate value =" + value);
		} catch (QuatoOpreateException e) {
			logger.error("LimitationBaseService #restoreFrozenQuota merchantNo:" + merchantNo + " mcType:" + mcType + " frozenQuota: " + frozenQuota
					+ " error: " + e.getErrorMsg(), e);
			limitationBaseService.sendMailMsg("解冻操作异常", initMsgContent(merchantNo, mcType, frozenQuota, e.getErrorMsg(), e.getQuatoOpreationMsgVo()));
			value = false;
		} catch (Exception e) {
			logger.error("LimitationBaseService #restoreFrozenQuota Exception merchantNo:" + merchantNo + " mcType:" + mcType + " frozenQuota: "
					+ frozenQuota + " error: " + e.getMessage(), e);
			limitationBaseService.sendMailMsg("解冻操作异常", initErrorMsgContent(merchantNo, mcType, frozenQuota, e));
			value = false;
		}
		return value;
	}

	/**
	 * 恢复冻结额度(T0) 根据是非共享恢复冻结额度
	 * 
	 * @param merchantNo
	 * @param mcType
	 * @param frozenQuota
	 *            恢复的额度
	 * @param begin
	 *            开始时间
	 * @throws QuatoOpreateException
	 */
	@Override
	public  boolean restoreFrozenQuotaByIsQuotoShare(String merchantNo, String mcType, BigDecimal frozenQuota, Date begin) {
		// TODO Auto-generated method stub
		if (frozenQuota == null || frozenQuota.compareTo(new BigDecimal(0)) < 0 || begin == null) {
			logger.info("LimitationBaseService #restoreFrozenQuota frozenQuota : " + frozenQuota);
			return false;
		}
		List<PosMerchantInfoDO> list = findPosMerchantInfo(merchantNo, mcType);
		if (list == null) {
			logger.info("LimitationBaseService #restoreFrozenQuota findPosMerchantInfo list = " + list);
			return false;
		}
		boolean value = false;
		try {
			value = quotaOpreate(merchantNo, frozenQuota, list, FrozenQuotaTypeEnums.FROZEN_QUOTA_RESTORE.code, begin);
			logger.info("LimitationBaseService #restoreFrozenQuota quotaOpreate value = " + value);
		} catch (QuatoOpreateException e) {
			logger.error("LimitationBaseService #restoreFrozenQuotaByIsQuotoShare merchantNo:" + merchantNo + " mcType:" + mcType + " frozenQuota:"
					+ frozenQuota + " error: " + e.getErrorMsg(), e);
			limitationBaseService.sendMailMsg("解冻操作(T0)异常",
					initMsgContent(merchantNo, mcType, frozenQuota, e.getErrorMsg(), e.getQuatoOpreationMsgVo()));
			value = false;
		} catch (Exception e) {
			logger.error("LimitationBaseService #restoreFrozenQuotaByIsQuotoShare Exception merchantNo:" + merchantNo + " mcType:" + mcType
					+ " frozenQuota:" + frozenQuota + " error: " + e.getMessage(), e);
			limitationBaseService.sendMailMsg("解冻操作(T0)异常", initErrorMsgContent(merchantNo, mcType, frozenQuota, e));
			value = false;
		}
		return value;
	}

	/**
	 * 将冻结额度处理成已使用
	 *
	 * @param merchantNo
	 * @param mcType
	 * @param frozenQuota
	 *            冻结额度
	 * @return
	 * @throws QuatoOpreateException
	 */
	@Override
	public  boolean usefrozenQuota(String merchantNo, String mcType, BigDecimal frozenQuota) {
		// TODO Auto-generated method stub
		if (frozenQuota == null || frozenQuota.compareTo(new BigDecimal(0)) < 0) {
			logger.info("LimitationBaseService #usefrozenQuota frozenQuota : [" + frozenQuota + "] is null or 0");
			return false;
		}
		List<PosMerchantInfoDO> list = findPosMerchantInfo(merchantNo, mcType);
		if (list == null) {
			logger.info("LimitationBaseService #usefrozenQuota findPosMerchantInfo list = " + list);
			return false;
		}
		boolean value = false;
		try {
			value = quotaOpreate(merchantNo, frozenQuota, list, FrozenQuotaTypeEnums.FROZEN_QUOTA_USED.code, null);
			logger.info("LimitationBaseService #usefrozenQuota quotaOpreate value = " + value);
		} catch (QuatoOpreateException e) {
			// TODO: handle exception
			logger.error("LimitationBaseService #usefrozenQuota merchantNo:" + merchantNo + " mcType:" + mcType + " frozenQuota:" + frozenQuota
					+ " error: " + e.getErrorMsg(), e);
			limitationBaseService.sendMailMsg("变已使用异常", initMsgContent(merchantNo, mcType, frozenQuota, e.getErrorMsg(), e.getQuatoOpreationMsgVo()));
			value = false;
		} catch (Exception e) {
			logger.error("LimitationBaseService #usefrozenQuota Exception merchantNo:" + merchantNo + " mcType:" + mcType + " frozenQuota:"
					+ frozenQuota + " error: " + e.getMessage(), e);
			limitationBaseService.sendMailMsg("变已使用异常", initErrorMsgContent(merchantNo, mcType, frozenQuota, e));
			value = false;
		}
		return value;
	}

	/**
	 * 将冻结额度处理成已使用(T0) 根据是非共享 冻结额度处理成已使用
	 * 
	 * @param merchantNo
	 * @param mcType
	 *            商户号
	 * @param frozenQuota
	 *            冻结额度
	 * @param begin
	 *            开始日期
	 * @return
	 * @throws QuatoOpreateException
	 */
	@Override
	public  boolean usefrozenQuotaByIsQuotoShare(String merchantNo, String mcType, BigDecimal frozenQuota, Date begin) {
		// TODO Auto-generated method stub
		if (frozenQuota == null || frozenQuota.compareTo(new BigDecimal(0)) < 0 || begin == null) {
			logger.info("LimitationBaseService #usefrozenQuotaByIsQuotoShare frozenQuota : [" + frozenQuota + "] is null or 0");
			return false;
		}
		List<PosMerchantInfoDO> list = findPosMerchantInfo(merchantNo, mcType);
		if (list == null) {
			logger.info("LimitationBaseService #usefrozenQuotaByIsQuotoShare findPosMerchantInfo list = " + list);
			return false;
		}
		boolean value = false;
		try {
			value = quotaOpreate(merchantNo, frozenQuota, list, FrozenQuotaTypeEnums.FROZEN_QUOTA_USED.code, begin);
			logger.info("LimitationBaseService #usefrozenQuotaByIsQuotoShare  quotaOpreate value = " + value);
		} catch (QuatoOpreateException e) {
			logger.error(
					"LimitationBaseService #usefrozenQuotaByIsQuotoShare merchantNo:" + merchantNo + " mcType:" + mcType + " error: "
							+ e.getErrorMsg(), e);
			limitationBaseService.sendMailMsg("变已使用(T0)异常",
					initMsgContent(merchantNo, mcType, frozenQuota, e.getErrorMsg(), e.getQuatoOpreationMsgVo()));
			value = false;
		} catch (Exception e) {
			logger.error("LimitationBaseService #usefrozenQuotaByIsQuotoShare merchantNo:" + merchantNo + " mcType:" + mcType + " frozenQuota:"
					+ frozenQuota + " error: " + e.getMessage(), e);
			limitationBaseService.sendMailMsg("变已使用(T0)异常", initErrorMsgContent(merchantNo, mcType, frozenQuota, e));
			value = false;
		}
		return value;
	}

	/**
	 * 额度操作status：1 冻结 2：解冻 3:已使用
	 * 
	 * @param merchantNo
	 * @param frozenQuota
	 *            操作额度
	 * @param list
	 *            商户信息
	 * @param status
	 *            1 冻结 2：解冻 3:已使用
	 * @return
	 * @throws QuatoOpreateException
	 */
	private boolean quotaOpreate(String merchantNo, BigDecimal frozenQuota, List<PosMerchantInfoDO> list, String status, Date begin)
			throws QuatoOpreateException {

		return limitationBaseService.quotaOpreate(merchantNo, frozenQuota, list, status, begin);

	}

	/**
	 * 判断额度是否共享
	 * 
	 * @param merchantNo
	 * @param mcType
	 * @param reqDate
	 * @param respDate
	 *            isSuccess true:共享 false:不共享
	 */
	@Override
	public ErrorMessageVO<Object> isQuotoShare(String merchantNo, String mcType, Date reqDate, Date respDate) {
		// TODO Auto-generated method stub
		ErrorMessageVO<Object> message = new ErrorMessageVO<Object>(false);
		if (StringUtils.isEmpty(merchantNo) || StringUtils.isEmpty(mcType)) {
			message.setErrorMessage("商户号或类型为空");
			return message;
		}
		if (reqDate == null || respDate == null || reqDate.compareTo(respDate) > 0) {
			message.setErrorMessage("日期格式不正确");
			return message;
		}
		// 不跨天 共享额度
		if (!DateUtil.whetherEveryDay(reqDate, respDate)) {
			message.setSuccess(true);
			return message;
		}
		// POS商户T0可用额度：节假日每天的额度=1个工作日额度*50%（数值可配置）
		// MPOS商户T0可用额度：周五、六、日三天（节假日及节假日前一天），商户共享1个工作日额度
		// （代理商额度维持现状，五、六、日三天共享）
		// if (PosMerchantTypeEnums.POS_MERCHANT.code.equals(mcType) ||
		// PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(mcType)) {
		// if (limitationBaseService.merchantIsQuotoShare(mcType, reqDate,
		// respDate)) {
		// message.setSuccess(true);// 商户共享
		// return message;
		// }
		// }
		// // 判断代理商是否共享
		// if (!message.isSuccess()) {
		// String pmtMcType = null;
		// if (PosMerchantTypeEnums.POS_MERCHANT.code.equals(mcType)) {
		// pmtMcType =PosMerchantTypeEnums.POS_PROMOTER.code;
		// }else if (PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(mcType)){
		// pmtMcType =PosMerchantTypeEnums.MPOS_PROMOTER.code;
		// }
		// if (pmtMcType==null) {
		// message.setErrorMessage("商户类型不存在");
		// return message;
		// }
		// message.setSuccess(limitationBaseService.pmtIsQuotoShare(pmtMcType,reqDate,
		// respDate));
		// return message;
		// }
		return message;
	}

	@Override
	public List<PosMerchantInfoDO> findPosMerchantInfo(PosMerchantInfoDOExample example) {
		// TODO Auto-generated method stub
		PosMerchantInfoDOExample.Criteria criteria = example.createCriteria();
		if (!StringUtils.isEmpty(example.getMerchantNo())) {
			criteria.andMerchantNoEqualTo(example.getMerchantNo());
		}
		if (example.getId() != null) {
			criteria.andIdEqualTo(example.getId());
		}
		if (!StringUtils.isEmpty(example.getMerchantType())) {
			criteria.andMerchantTypeEqualTo(example.getMerchantType());
		}
		return posMerchantInfoManager.selectByExample(example);
	}

	/**
	 * isHoliday true:节假日 false 工作日 yestoryIsHoliday true:节假日 false 工作日
	 */
	@Override
	@Transactional
	public synchronized boolean syncWithdrawInfoBy(PosMerchantInfoDO posInfo) {
		// if
		// (PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(posInfo.getMerchantType())
		// ||
		// PosMerchantTypeEnums.POS_PROMOTER.code.equals(posInfo.getMerchantType()))
		// {
		// //周五是工作日额度，周六、周日两天共享1个工作日额度
		// if (!yestoryIsHoliday || !isHoliday){
		// return upWithdrawByWork(posInfo);
		// }
		// } else if
		// (PosMerchantTypeEnums.POS_MERCHANT.code.equals(posInfo.getMerchantType())
		// ||
		// PosMerchantTypeEnums.MPOS_PROMOTER.code.equals(posInfo.getMerchantType()))
		// {
		// //MPOS每天都是工作日额度,POS周五是工作日额度，周六、周日每天是工作日额度的50%
		// return upWithdrawByWork(posInfo);
		// }
		return upWithdrawByWork(posInfo);
	}

	/**
	 * 工作日 同步更新额度日历数据
	 *
	 * @param posInfo
	 */
	private boolean upWithdrawByWork(PosMerchantInfoDO posInfo) {
		List<WithdrawInfoDO> list = limitationBaseService.getWithdrawInfoDOByBizId(posInfo);
		if (list == null || list.size() > 1) {
			logger.info("[upWithdrawByWork] #getWithdrawInfoDOByBizId is null");
			return false;
		}
		WithdrawInfoDO record = list.get(0);
		String jsonContent = JSONObject.fromObject(initWithdrawInfoLogVO(record, posInfo.getMerchantType()).toString()).toString();
		insertOpLogRecord(jsonContent, LogRecordTypeEnums.SYNC_MERCHANT_WITHDRAW.code, LogOPTypeEnums.UPDATE.code);
		BigDecimal totalAmount = limitationBaseService.findMerchantFastAmount(posInfo.getMerchantNo(), posInfo.getMerchantType());
		record.setForzenLimitation(null);
		record.setLimitation(totalAmount);
		record.setUsedLimitation(null);
		record.setUpdateTime(new Date());

		int rows = withdrawInfoManager.updateByPrimaryKey(record);
		if (rows > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 初始化log数据+
	 *
	 * @param record
	 * @return
	 */
	private  OpLogRecordVO initWithdrawInfoLogVO(WithdrawInfoDO record, String mcType) {
		// 判断log是否存在
		return opLogRecordService.getOpLogRecordForLastDay(record, mcType, -1);
	}

	/**
	 * @param merchantNo
	 * @param mcType
	 * @param frozenQuota
	 * @param msg
	 * @param e
	 * @return
	 */
	private String initErrorMsgContent(String merchantNo, String mcType, BigDecimal frozenQuota, Exception e) {
		StringBuilder sb = new StringBuilder();
		try {
			sb.append("商户号:" + merchantNo).append("\r\n");
			sb.append("商户类型:" + mcType).append("\r\n");
			sb.append("操作额度:" + frozenQuota).append("\r\n");
			sb.append("异常信息:" + e.getMessage()).append("\r\n");
			sb.append(e);
		} catch (Exception e2) {
			logger.error("LimitationServiceImpl#initErrorMsgContent error" + e2.getMessage(), e2);
		}
		return sb.toString();
	}

	/**
	 * 邮件内容
	 * 
	 * @param merchantNo
	 * @param mcType
	 * @param frozenQuota
	 * @param errorCode
	 * @param errorMsg
	 * @return
	 */
	private String initMsgContent(String merchantNo, String mcType, BigDecimal frozenQuota, String errorMsg, QuatoOpreationMsgVo vo) {
		StringBuilder sb = new StringBuilder();
		try {
			if (vo != null) {
				String titleMsg = "";
				if (QuotaOpTypeEnums.MERCHANT_QUOTA_OP_TYPE.code == vo.getOpType()) {
					sb.append("商户额度操作异常 ").append("\r\n");
					titleMsg = "商户";
				} else if (QuotaOpTypeEnums.PMT_MERCHANT_QUOTA_OP_TYPE.code == vo.getOpType()) {
					sb.append("代理商额度操作异常 ").append("\r\n");
					titleMsg = "代理商";
				} else if (QuotaOpTypeEnums.SDP_MERCHANT_QUOTA_OP_TYPE.code == vo.getOpType()) {
					sb.append("盛付通额度操作异常 ").append("\r\n");
					titleMsg = "盛付通";
				}
				sb.append("商户号:").append(merchantNo).append("\t");
				PosMerchantTypeEnums posMerchantType = PosMerchantTypeEnums.getMerchantTypeByCode(mcType);
				sb.append("商户类型:").append(posMerchantType == null ? "商户类型不存在" : posMerchantType.desc).append("\r\n");

				if (!StringUtils.isEmpty(vo.getPmtMerchantNo()) && !StringUtils.isEmpty(vo.getPmtMcType())) {
					sb.append("代理商商户号:").append(vo.getPmtMerchantNo()).append("\t");
					PosMerchantTypeEnums pmtMerchantType = PosMerchantTypeEnums.getMerchantTypeByCode(vo.getPmtMcType());
					sb.append("代理商类型:").append(pmtMerchantType == null ? "代理商类型不存在" : pmtMerchantType.desc).append("\r\n");
				}

				sb.append("金额:").append(frozenQuota).append("\t");
				sb.append(titleMsg + "总金额:").append(vo.getTotalAmount()).append("\t");
				sb.append(titleMsg + "已冻结金额:").append(vo.getForzenLimitation()).append("\t");
				sb.append(titleMsg + "已使用金额:").append(vo.getUsedLimitation()).append("\r\n");
				sb.append("错误MSG:").append(errorMsg).append("\r\n");
			} else {
				sb.append("金额:").append(frozenQuota).append("\r\n");
				sb.append("错误MSG:").append(errorMsg).append("\r\n");
			}
			logger.info("LimitationServiceImpl #initMsgContent msg content is : " + sb.toString());
		} catch (Exception e) {
			logger.error("LimitationServiceImpl#initMsgContent error" + e.getMessage(), e);
		}
		return sb.toString();
	}
}
