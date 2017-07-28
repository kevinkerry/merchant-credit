package com.sdp.withdraw.service.hessian;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.enums.withdraw.LogOPTypeEnums;
import com.sdp.mc.common.enums.withdraw.LogRecordTypeEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawServiceTypeEnums;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.withdraw.api.ratio.MerchantWithdrawRatioAPI;
import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.dao.PosMerchantInfoDOExample;
import com.sdp.withdraw.dao.WithdrawRatioInfoDO;
import com.sdp.withdraw.dao.WithdrawRatioInfoDOExample;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.sdp.withdraw.enums.ReturnCodeEnums;
import com.sdp.withdraw.enums.WithdrawRatioStatusEnums;
import com.sdp.withdraw.enums.WithdrawRatioTypeEnums;
import com.sdp.withdraw.manager.PosMerchantInfoManager;
import com.sdp.withdraw.manager.WithdrawRatioInfoManager;
import com.sdp.withdraw.manager.ext.ExtWithdrawRatioInfoManager;
import com.sdp.withdraw.service.BaseService;
import com.sdp.withdraw.service.LimitationService;
import com.sdp.withdraw.service.MerchantSettleAttrService;
import com.sdp.withdraw.service.WithdrawRatioService;
import com.sdp.withdraw.vo.ratio.WithdrawRatioQueryRequest;
import com.sdp.withdraw.vo.ratio.WithdrawRatioQueryResponse;
import com.sdp.withdraw.vo.ratio.WithdrawRatioRequest;
import com.sdp.withdraw.vo.ratio.WithdrawRatioResponse;
import com.sdp.withdraw.vo.ratio.WithdrawRatioResult;

@Service("withdrawRatioService4Hessian")
public class WithdrawRatioService4HessianImpl extends BaseService implements MerchantWithdrawRatioAPI, WithdrawRatioService {

	private Logger logger = LoggerFactory.getLogger(WithdrawRatioService4HessianImpl.class);
	@Autowired
	private ConfigOptionManager configOptionManager;
	@Autowired
	private WithdrawRatioInfoManager withdrawRatioInfoManager;
	@Autowired
	private ExtWithdrawRatioInfoManager extWithdrawRatioInfoManager;
	@Autowired
	private PosMerchantInfoManager posMerchantInfoManager;
	@Autowired
	private LimitationService limitationService;
	@Autowired
	private MerchantSettleAttrService merchantSettleAttrService;

	public boolean withdrawD1Available(WithdrawRatioRequest withdrawRatioRequest) throws Exception {
		logger.info("WithdrawRatioService4HessianImpl#withdrawD1Available withdrawRatioQueryRequest:"
				+ ToStringBuilder.reflectionToString(withdrawRatioRequest));
		String merchantNo = withdrawRatioRequest.getMerchantNo();
		String merchantType = withdrawRatioRequest.getMerchantType();

		// 查询PosMerchant 信息
		PosMerchantInfoDOExample example = new PosMerchantInfoDOExample();
		PosMerchantInfoDOExample.Criteria criteriaPosMerchantInfo = example.createCriteria();
		criteriaPosMerchantInfo.andMerchantNoEqualTo(merchantNo);
		if (StringUtils.isNotBlank(merchantType)) criteriaPosMerchantInfo.andMerchantTypeEqualTo(merchantType);
		List<PosMerchantInfoDO> posMerchantInfoDOs = posMerchantInfoManager.selectByExample(example);
		if (posMerchantInfoDOs == null || posMerchantInfoDOs.isEmpty()) {
			logger.error("WithdrawRatioService4HessianImpl#withdrawD1Available merchant is not exsist,withdrawRatioQueryRequest:"
					+ ToStringBuilder.reflectionToString(withdrawRatioRequest));
			throw new Exception("merchantNo is not exsist");
		}
		// 不唯一返回异常
		if (posMerchantInfoDOs.size() > 1) {
			logger.error("WithdrawRatioService4HessianImpl#withdrawD1Available merchant is not UNIQUE,withdrawRatioQueryRequest:"
					+ ToStringBuilder.reflectionToString(withdrawRatioRequest));
			throw new Exception("merchantNo is not UNIQUE");
		}

		PosMerchantInfoDO posMerchantInfoDO = posMerchantInfoDOs.get(0);
		Long bizId = posMerchantInfoDO.getId();
		WithdrawRatioInfoDOExample ratioInfoDOExample = new WithdrawRatioInfoDOExample();
		ratioInfoDOExample.createCriteria().andBizIdEqualTo(bizId).andRatioTypeEqualTo(WithdrawRatioTypeEnums.MPOS_D1_SETTLE_RATIO.code)
				.andStatusEqualTo(WithdrawRatioStatusEnums.active.code);
		ratioInfoDOExample.setOrderByClause(" EFFECTIVE_TIME desc ");

		List<WithdrawRatioInfoDO> withdrawRatioInfoDOs = withdrawRatioInfoManager.selectByExample(ratioInfoDOExample);
		if (withdrawRatioInfoDOs == null || withdrawRatioInfoDOs.isEmpty()) return false;
		for (WithdrawRatioInfoDO withdrawRatioInfoDO : withdrawRatioInfoDOs) {
			Date activeTime = withdrawRatioInfoDO.getEffectiveTime();
			Date expireTime = withdrawRatioInfoDO.getExpireTime();
			Date current = new Date();
			if (expireTime != null && activeTime.compareTo(current) <= 0 && expireTime.compareTo(current) > 0) return true;
			if (activeTime.compareTo(current) < 0) return true;
		}
		return false;
	}

	@Override
	/**
	 * 新建/更新 商户提现费率
	 *
	 * merchantNo 商户号，必填
	 * merchantType 商户类型，必填
	 * withDrawRatioType 费率类型，必填
	 * effectiveTime 生效时间，非必填，默认当前系统时间
	 * expireTime	失效时间，非必填
	 * workDayWithDrawRatio holidayWithDrawRatio 工作日费率/非工作日费率，非必填，任意一值为NULL 将形成新的提现记录
	 */
	@Transactional
	public WithdrawRatioResponse createOrUpdateWithrawRatio(WithdrawRatioRequest withdrawRatioRequest) {
		logger.info("WithdrawRatioService4HessianImpl#createOrUpdateWithrawRatio,withdrawRatioRequest:"
				+ ToStringBuilder.reflectionToString(withdrawRatioRequest));
		WithdrawRatioResponse response = new WithdrawRatioResponse();
		String merchantNo = withdrawRatioRequest.getMerchantNo();
		String merchantType = withdrawRatioRequest.getMerchantType();
		// int withDrawRatioType = withdrawRatioRequest.getWithDrawRatioType();
		BigDecimal workDayWithDrawRatio = withdrawRatioRequest.getWorkDayWithDrawRatio();
		BigDecimal holidayWithDrawRatio = withdrawRatioRequest.getHolidayWithDrawRatio();
		Date effectiveTime = withdrawRatioRequest.getEffectiveTime();
		// Date expireTime = withdrawRatioRequest.getExpireTime();
		int withdrawRatioStatus = withdrawRatioRequest.getWithDrawRatioStatus();
		Integer ratioId = withdrawRatioRequest.getRatioId();
		if (StringUtils.isBlank(merchantNo) || StringUtils.isBlank(merchantType)) {
			logger.error("WithdrawRatioService4HessianImpl#createOrUpdateWithrawRatio, merchantNo or merchantType is null,withdrawRatioRequest:");
			response.setErrorCode(ReturnCodeEnums.FW_PARAM_CHECK_IS_FAILL.code);
			response.setErrorMsg(WithdrawConstant.WITHDRAW_QUERY_ERROR_NOT_VALIDATE);
			return response;
		}

		if (withdrawRatioStatus == WithdrawRatioStatusEnums.active.code && (workDayWithDrawRatio == null || holidayWithDrawRatio == null)) {
			logger.error("WithdrawRatioService4HessianImpl#createOrUpdateWithrawRatio,withdrawRatioRequest:"
					+ ToStringBuilder.reflectionToString(withdrawRatioRequest));
			response.setErrorCode(ReturnCodeEnums.FW_PARAM_CHECK_IS_FAILL.code);
			response.setErrorMsg(WithdrawConstant.WITHDRAW_QUERY_ERROR_NOT_VALIDATE);
			return response;
		}

		if ((workDayWithDrawRatio != null && workDayWithDrawRatio.compareTo(new BigDecimal(1)) >= 0)
				|| (holidayWithDrawRatio != null && holidayWithDrawRatio.compareTo(new BigDecimal(1)) >= 0)) {
			logger.error("WithdrawRatioService4HessianImpl#createOrUpdateWithrawRatio,withdrawRatioRequest:"
					+ ToStringBuilder.reflectionToString(withdrawRatioRequest));
			response.setErrorCode(ReturnCodeEnums.FW_SYSTEM_ERROR.code);
			response.setErrorMsg(WithdrawConstant.WITHDRAW_ERROR_RATIO_GREATER_THAN_ONE);
			return response;
		}

		// 判断并重置生效时间
		Date currentTmp = new Date();
		// 当前时间小于生效时间 &&当前时间大于等于生效时间
		if (effectiveTime == null
				|| (DateUtil.generateDawnTimeStamp(currentTmp).compareTo(effectiveTime) <= 0 && DateUtil.generateMidnightTimeStamp(currentTmp)
						.compareTo(effectiveTime) >= 0)) effectiveTime = DateUtil.generateDawnTimeStamp(DateUtil.increaseDate(currentTmp, 1));

		try {
			// TODO:修改提现费率
			if (ratioId != null) {
				modifyWithdrawRatioByRatioId(withdrawRatioRequest);
				response.setErrorCode(ReturnCodeEnums.FW_SUCCESS.code);
				response.setErrorMsg(ReturnCodeEnums.FW_SUCCESS.desc);
				return response;
			} else {
				return createAndUpdateWithrawRatio(withdrawRatioRequest);
			}
		} catch (Exception e) {
			logger.error(
					"WithdrawRatioService4HessianImpl#createOrUpdateWithrawRatio,withdrawRatioQueryRequest:"
							+ ToStringBuilder.reflectionToString(withdrawRatioRequest) + ",error.", e);
			response.setErrorCode(ReturnCodeEnums.FW_SYSTEM_ERROR.code);
			response.setErrorMsg(e.getMessage());
			return response;
		}
	}

	private WithdrawRatioResponse getAvailableRatioExistResponse(WithdrawRatioRequest withdrawRatioRequest, WithdrawRatioInfoDO withdrawRatioInfoDO,
			WithdrawRatioResponse response) {
		logger.error("WithdrawRatioService4HessianImpl#createOrUpdateWithrawRatio, withdraw ratio type is not match ,withdrawRatioRequest:"
				+ ToStringBuilder.reflectionToString(withdrawRatioRequest) + ",withdrawRatioInfoDO:"
				+ ToStringBuilder.reflectionToString(withdrawRatioInfoDO));
		response.setErrorCode(ReturnCodeEnums.FW_SYSTEM_ERROR.code);
		response.setErrorMsg(WithdrawConstant.WITHDRAW_ERROR_AVAILABLE_RATIO_EXIST);
		return response;
	}

	@Override
	/**
	 * 查询提现费率信息
	 * merchantNo 商户号，必填
	 * merchantType 商户类型，必填
	 * withdrawRatioType 提现产品类型，非必填
	 */
	public WithdrawRatioQueryResponse queryWithrawRatioResult(WithdrawRatioQueryRequest withdrawRatioQueryRequest) {
		logger.info("WithdrawRatioService4HessianImpl#queryWithrawRatioResult,withdrawRatioQueryRequest:"
				+ ToStringBuilder.reflectionToString(withdrawRatioQueryRequest));

		WithdrawRatioQueryResponse queryResponse = new WithdrawRatioQueryResponse();
		try {
			String merchantNo = withdrawRatioQueryRequest.getMerchantNo();
			String merchantType = withdrawRatioQueryRequest.getMerchantType();
			Integer withdrawRatioQuery = withdrawRatioQueryRequest.getWithdrawRatioType();
			Date effectiveTime = withdrawRatioQueryRequest.getEffectiveTime();

			PosMerchantInfoDOExample example = new PosMerchantInfoDOExample();
			PosMerchantInfoDOExample.Criteria criteriaPosMerchantInfo = example.createCriteria();
			criteriaPosMerchantInfo.andMerchantNoEqualTo(merchantNo);
			if (StringUtils.isNotBlank(merchantType)) criteriaPosMerchantInfo.andMerchantTypeEqualTo(merchantType);

			List<PosMerchantInfoDO> posMerchantInfoDOs = posMerchantInfoManager.selectByExample(example);
			if (posMerchantInfoDOs != null && posMerchantInfoDOs.size() > 1) {
				logger.error("WithdrawRatioService4HessianImpl#queryWithrawRatioResult is not UNIQUE,withdrawRatioQueryRequest:"
						+ ToStringBuilder.reflectionToString(withdrawRatioQueryRequest));
				queryResponse.setErrorCode(ReturnCodeEnums.FW_SYSTEM_ERROR.code);
				queryResponse.setErrorMsg(WithdrawConstant.WITHDRAW_QUERY_ERROR_NOT_UNIQUE);
				return queryResponse;
			}

			// 不存在则更新
			Long bizId = null;
			// 不存在则更新
			if (posMerchantInfoDOs == null || posMerchantInfoDOs.isEmpty()) {
				ErrorMessageVO<Long> vo = limitationService.syncPosMerchantInfoByMerchantNo(merchantNo, merchantType);
				if (!vo.isSuccess()) {
					logger.error("syncPosMerchantInfoByMerchantNo :[" + merchantNo + "] error:" + vo.getErrorMessage());
					queryResponse.setErrorCode(ReturnCodeEnums.UNKOWN_ERROR.code);
					queryResponse.setErrorMsg(vo.getErrorMessage());
					return queryResponse;
				}
				bizId = vo.getEntity();
				// 创建默认的MPOS T+1 规则
				// genareteMPOSDefualtT1Ratio(bizId);
			} else {
				PosMerchantInfoDO posMerchantInfoDO = posMerchantInfoDOs.get(0);
				bizId = posMerchantInfoDO.getId();
			}
			queryResponse.setErrorCode(ReturnCodeEnums.FW_SUCCESS.code);
			queryResponse.setErrorMsg(ReturnCodeEnums.FW_SUCCESS.desc);

			WithdrawRatioInfoDOExample exampleWithdrawRatioInfo = new WithdrawRatioInfoDOExample();
			exampleWithdrawRatioInfo.setOrderByClause(" EFFECTIVE_TIME desc ");
			WithdrawRatioInfoDOExample.Criteria criteria = exampleWithdrawRatioInfo.createCriteria();
			criteria.andBizIdEqualTo(bizId);
			if (effectiveTime != null) {
				criteria.andEffectiveTimeEqualTo(effectiveTime);
			}
			criteria.andStatusEqualTo(WithdrawRatioStatusEnums.active.code);
			if (withdrawRatioQuery != null) criteria.andRatioTypeEqualTo(withdrawRatioQuery);

			List<WithdrawRatioInfoDO> withdrawRatioInfoDOs = withdrawRatioInfoManager.selectByExample(exampleWithdrawRatioInfo);
			for (WithdrawRatioInfoDO withdrawRatioInfoDO : withdrawRatioInfoDOs) {
				queryResponse.getWithdrawRatioResults().add(beanMapper.map(withdrawRatioInfoDO, WithdrawRatioResult.class));
			}
			queryResponse.setErrorCode(ReturnCodeEnums.FW_SUCCESS.code);
			queryResponse.setErrorMsg(ReturnCodeEnums.FW_SUCCESS.desc);
			return queryResponse;
		} catch (Exception e) {
			logger.error(
					"WithdrawRatioService4HessianImpl#queryWithrawRatioResult,error.withdrawRatioQueryRequest:"
							+ ToStringBuilder.reflectionToString(withdrawRatioQueryRequest), e);
			queryResponse.setErrorCode(ReturnCodeEnums.FW_SYSTEM_ERROR.code);
			queryResponse.setErrorMsg(WithdrawConstant.WITHDRAW_QUERY_ERROR_NOT_UNIQUE);
			return queryResponse;
		}
	}

	/**
	 * 获取商户当前可用的提现费率
	 *
	 * @param queryRequest
	 *            merchantNo 商户号，必填 merchantType 商户类型 必填 withdrawRatioType
	 *            提现费率类型，必填
	 * @return
	 */
	public WithdrawRatioQueryResponse getMerchantCurrentAvaliableWithdrawRatio(WithdrawRatioQueryRequest queryRequest) {
		WithdrawRatioQueryResponse queryResponse = queryWithrawRatioResult(queryRequest);
		if (StringUtils.isNotBlank(queryResponse.getErrorCode()) && !ReturnCodeEnums.FW_SUCCESS.code.equals(queryResponse.getErrorCode())) {
			logger.error("WithdrawRatioService4HessianImpl#getMerchantCurrentAvaliableWithdrawRatio,WithdrawRatioQueryRequest "
					+ ToStringBuilder.reflectionToString(queryRequest) + ",error code:" + queryResponse.getErrorCode());
			return queryResponse;
		}
		// 是否有可用结果
		List<WithdrawRatioResult> resultList = new ArrayList<WithdrawRatioResult>();
		List<WithdrawRatioResult> withdrawRatioResults = queryResponse.getWithdrawRatioResults();
		Date current = new Date();
		resultList = getAvaliableWithdrawRatio(current, withdrawRatioResults);
		/*
		 * if(resultList==null||resultList.isEmpty()){//如果当前没有有效的费率，就获取明天的生效的费率
		 * resultList=getAvaliableWithdrawRatio(DateUtil.increaseDate(current,
		 * 1),withdrawRatioResults); }
		 */
		queryResponse.getWithdrawRatioResults().clear();
		queryResponse.setReturnRows(0);
		if (resultList != null) {
			queryResponse.setWithdrawRatioResults(resultList);
			queryResponse.setReturnRows(resultList.size());
		}
		return queryResponse;
	}

	private List<WithdrawRatioResult> getAvaliableWithdrawRatio(Date current, List<WithdrawRatioResult> withdrawRatioResults) {
		if (withdrawRatioResults == null) { return null; }
		List<WithdrawRatioResult> resultList = new ArrayList<WithdrawRatioResult>();
		;
		for (WithdrawRatioResult withdrawRatioResult : withdrawRatioResults) {
			Date activeTime = withdrawRatioResult.getEffectiveTime();
			Date expireTime = withdrawRatioResult.getExpireTime();
			if ((expireTime != null && activeTime.compareTo(current) <= 0 && expireTime.compareTo(current) > 0)
					|| (expireTime == null && activeTime.compareTo(current) < 0)) {
				resultList.add(withdrawRatioResult);
				break;
			}
		}
		return resultList;
	}

	@Transactional
	private void modifyWithdrawRatioByRatioId(WithdrawRatioRequest withdrawRatioRequest) throws Exception {
		try {
			WithdrawRatioInfoDO withdrawRatioInfoDO = beanMapper.map(withdrawRatioRequest, WithdrawRatioInfoDO.class);
			withdrawRatioInfoDO.setUpdateTime(new Date());
			int rows = withdrawRatioInfoManager.updateByPrimaryKeySelective(withdrawRatioInfoDO);
			if (rows == 1) {
				logger.info("WithdrawRatioService4HessianImpl#expireWithdrawRatio,ratioInfo expire,withdrawRatioQueryRequest:"
						+ ToStringBuilder.reflectionToString(withdrawRatioInfoDO));
				String jsonContent = JSONObject.fromObject(withdrawRatioInfoDO).toString();
				insertOpLogRecord(jsonContent, LogRecordTypeEnums.WITHDRAW_RATIO_MERGE.code, LogOPTypeEnums.UPDATE.code);
			} else {
				logger.error("WithdrawRatioService4HessianImpl#modifyWithdrawRatioByRatioId,withdrawRatioInfoDO:"
						+ ToStringBuilder.reflectionToString(withdrawRatioInfoDO) + ",rows:" + rows);
			}
		} catch (Exception e) {
			logger.error("modifyWithdrawRatioByRatioId is Exception", e);
			throw e;
		}
	}

	/**
	 * 失效规则
	 *
	 * @param withdrawRatioInfoDO
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private void expireWithdrawRatio(WithdrawRatioInfoDO withdrawRatioInfoDO) throws Exception {
		try {
			withdrawRatioInfoDO.setStatus(WithdrawRatioStatusEnums.expire.code);
			withdrawRatioInfoDO.setUpdateTime(new Date());
			int rows = withdrawRatioInfoManager.updateByPrimaryKeySelective(withdrawRatioInfoDO);
			if (rows > 0) {// 记录LOG
				logger.info("WithdrawRatioService4HessianImpl#expireWithdrawRatio,ratioInfo expire,withdrawRatioQueryRequest:"
						+ ToStringBuilder.reflectionToString(withdrawRatioInfoDO));
				String jsonContent = JSONObject.fromObject(withdrawRatioInfoDO).toString();
				insertOpLogRecord(jsonContent, LogRecordTypeEnums.WITHDRAW_RATIO_MERGE.code, LogOPTypeEnums.UPDATE.code);
			}
		} catch (Exception e) {
			logger.error("expireWithdrawRatio is Exception", e);
			throw e;
		}
	}

	/**
	 * 更新失效时间到本日午夜
	 *
	 * @param withdrawRatioInfoDO
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private void expireTime2MidnightTimeWithdrawRatio(WithdrawRatioInfoDO withdrawRatioInfoDO) throws Exception {
		expireTime2MidnightTimeWithdrawRatio(withdrawRatioInfoDO, DateUtil.generateMidnightTimeStamp(new Date()));
	}

	/**
	 * 更新失效时间到本日午夜
	 *
	 * @param withdrawRatioInfoDO
	 * @throws Exception
	 */
	private void expireTime2MidnightTimeWithdrawRatio(WithdrawRatioInfoDO withdrawRatioInfoDO, Date expireDate) throws Exception {
		try {
			withdrawRatioInfoDO.setExpireTime(DateUtil.generateMidnightTimeStamp(expireDate));
			withdrawRatioInfoDO.setUpdateTime(new Date());
			int rows = withdrawRatioInfoManager.updateByPrimaryKeySelective(withdrawRatioInfoDO);
			// 记录LOG
			if (rows > 0) {
				logger.info("WithdrawRatioService4HessianImpl#createOrUpdateWithrawRatio,ratioInfo expire,withdrawRatioQueryRequest:"
						+ ToStringBuilder.reflectionToString(withdrawRatioInfoDO));
				String jsonContent = JSONObject.fromObject(withdrawRatioInfoDO).toString();
				insertOpLogRecord(jsonContent, LogRecordTypeEnums.WITHDRAW_RATIO_MERGE.code, LogOPTypeEnums.UPDATE.code);
			}
		} catch (Exception e) {
			logger.error("expireTime2MidnightTimeWithdrawRatio is Exception", e);
			throw e;
		}
	}

	@SuppressWarnings("unused")
	private void genareteMPOSDefualtT1Ratio(Long bizId) {
		PosMerchantInfoDO merchantInfoDO = posMerchantInfoManager.selectByPrimaryKey(bizId);
		String merchantType = merchantInfoDO.getMerchantType();
		if (StringUtils.isBlank(merchantType) || !PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(merchantType)) return;

		WithdrawRatioInfoDOExample example = new WithdrawRatioInfoDOExample();
		example.createCriteria().andBizIdEqualTo(bizId).andStatusEqualTo(WithdrawRatioStatusEnums.active.code)
				.andRatioTypeEqualTo(WithdrawRatioTypeEnums.POS_T1_SETTLE_RATIO.code);
		List<WithdrawRatioInfoDO> list = withdrawRatioInfoManager.selectByExample(example);
		if (list != null && !list.isEmpty()) return;

		WithdrawRatioInfoDO ratioInfoDO = new WithdrawRatioInfoDO();
		ratioInfoDO.setBizId(bizId);
		ratioInfoDO.setCreteTime(new Date());
		ratioInfoDO.setEffectiveTime(DateUtil.generateDawnTimeStamp(new Date()));
		ratioInfoDO.setHolidayRatio(new BigDecimal(0));
		ratioInfoDO.setWorkDayRatio(new BigDecimal(0));
		ratioInfoDO.setRatioType(WithdrawRatioTypeEnums.POS_T1_SETTLE_RATIO.code);
		ratioInfoDO.setStatus(WithdrawRatioStatusEnums.active.code);
		withdrawRatioInfoManager.insertSelective(ratioInfoDO);
	}

	@Override
	public WithdrawRatioResponse createAndUpdateWithrawRatio(WithdrawRatioRequest withdrawRatioRequest) {
		logger.info("WithdrawRatioService4HessianImpl#createAndUpdateWithrawRatio,withdrawRatioRequest:"
				+ ToStringBuilder.reflectionToString(withdrawRatioRequest));
		WithdrawRatioResponse response = new WithdrawRatioResponse();
		String merchantNo = withdrawRatioRequest.getMerchantNo();
		String merchantType = withdrawRatioRequest.getMerchantType();
		int withDrawRatioType = withdrawRatioRequest.getWithDrawRatioType();
		BigDecimal workDayWithDrawRatio = withdrawRatioRequest.getWorkDayWithDrawRatio();
		BigDecimal holidayWithDrawRatio = withdrawRatioRequest.getHolidayWithDrawRatio();
		Date effectiveTime = withdrawRatioRequest.getEffectiveTime();
		Date expireTime = withdrawRatioRequest.getExpireTime();
		int ratioStatus = withdrawRatioRequest.getWithDrawRatioStatus();

		if (StringUtils.isBlank(merchantNo) || StringUtils.isBlank(merchantType)) {
			logger.error("WithdrawRatioService4HessianImpl#createOrUpdateWithrawRatio, merchantNo or merchantType is null,withdrawRatioRequest:");
			response.setErrorCode(ReturnCodeEnums.FW_PARAM_CHECK_IS_FAILL.code);
			response.setErrorMsg(WithdrawConstant.WITHDRAW_QUERY_ERROR_NOT_VALIDATE);
			return response;
		}

		if ((workDayWithDrawRatio != null && workDayWithDrawRatio.compareTo(new BigDecimal(1)) >= 0)
				|| (holidayWithDrawRatio != null && holidayWithDrawRatio.compareTo(new BigDecimal(1)) >= 0)) {
			logger.error("WithdrawRatioService4HessianImpl#createOrUpdateWithrawRatio,withdrawRatioRequest:"
					+ ToStringBuilder.reflectionToString(withdrawRatioRequest));
			response.setErrorCode(ReturnCodeEnums.FW_PARAM_CHECK_IS_FAILL.code);
			response.setErrorMsg(WithdrawConstant.WITHDRAW_ERROR_RATIO_GREATER_THAN_ONE);
			return response;
		}
		// 判断并重置生效时间
		try {
			PosMerchantInfoDO posMerchantInfoDO = queryPosMerchantInfo(withdrawRatioRequest, response, merchantNo, merchantType, withDrawRatioType);
			if (posMerchantInfoDO == null) { return response; }
			return buildWithrawRatio(withdrawRatioRequest, posMerchantInfoDO.getId());
		} catch (Exception e) {
			logger.error(
					"WithdrawRatioService4HessianImpl#createOrUpdateWithrawRatio,withdrawRatioQueryRequest:"
							+ ToStringBuilder.reflectionToString(withdrawRatioRequest) + ",error.", e);
			response.setErrorCode(ReturnCodeEnums.FW_SYSTEM_ERROR.code);
			response.setErrorMsg(e.getMessage());
			return response;
		}
	}

	@Override
	public WithdrawRatioResponse buildWithrawRatio(WithdrawRatioRequest withdrawRatioRequest, Long bizId) {
		WithdrawRatioResponse response = new WithdrawRatioResponse();
		int withDrawRatioType = withdrawRatioRequest.getWithDrawRatioType();
		BigDecimal workDayWithDrawRatio = withdrawRatioRequest.getWorkDayWithDrawRatio();
		BigDecimal holidayWithDrawRatio = withdrawRatioRequest.getHolidayWithDrawRatio();
		Date effectiveTime = withdrawRatioRequest.getEffectiveTime();
		Date expireTime = withdrawRatioRequest.getExpireTime();
		int ratioStatus = withdrawRatioRequest.getWithDrawRatioStatus();
		// 失效老规则
		WithdrawRatioInfoDOExample exampleWithdrawRatioInfo = new WithdrawRatioInfoDOExample();
		exampleWithdrawRatioInfo.createCriteria().andBizIdEqualTo(bizId).andRatioTypeEqualTo(withDrawRatioType)
				.andStatusEqualTo(WithdrawRatioStatusEnums.active.code);
		if (WithdrawRatioStatusEnums.expire.code == ratioStatus) {// 如果是失效操作，失效所有的规则
			WithdrawRatioInfoDO record = new WithdrawRatioInfoDO();
			record.setStatus(ratioStatus);
			record.setUpdateTime(new Date());
			extWithdrawRatioInfoManager.updateByExampleSelective(record, exampleWithdrawRatioInfo);
		} else {// 生效操作
			boolean isFirstOpen = isFirstOpen(withDrawRatioType, bizId);
			Date currentTmp = new Date();
			if (effectiveTime == null
					|| (DateUtil.generateDawnTimeStamp(currentTmp).compareTo(effectiveTime) <= 0 && DateUtil.generateMidnightTimeStamp(currentTmp)
							.compareTo(effectiveTime) >= 0))
				effectiveTime = DateUtil.generateDawnTimeStamp(isFirstOpen ? currentTmp : DateUtil.increaseDate(currentTmp, 1));
			List<WithdrawRatioInfoDO> withdrawRatioInfoDOs = withdrawRatioInfoManager.selectByExample(exampleWithdrawRatioInfo);
			WithdrawRatioInfoDO tomorrowEffectiveRatioInfoDO = null;// 明天生效的费率
			WithdrawRatioInfoDO currentEffectiveRatioInfoDO = null;// 当前生效的费率
			for (WithdrawRatioInfoDO withdrawRatioInfoDO : withdrawRatioInfoDOs) {
				Date activeTime = withdrawRatioInfoDO.getEffectiveTime();
				Date expTime = withdrawRatioInfoDO.getExpireTime();
				if (expireTime != null) {
					if (expTime != null
							&& ((activeTime.compareTo(effectiveTime) <= 0 && expTime.compareTo(expireTime) >= 0)
									|| (activeTime.compareTo(effectiveTime) <= 0 && expTime.compareTo(effectiveTime) >= 0) || (activeTime
									.compareTo(expireTime) <= 0 && expTime.compareTo(expireTime) >= 0))) {
						// 提示时间交叉
						return getAvailableRatioExistResponse(withdrawRatioRequest, withdrawRatioInfoDO, response);
					} else if (expTime == null
							&& (activeTime.compareTo(effectiveTime) <= 0 || (effectiveTime.compareTo(activeTime) <= 0 && expireTime
									.compareTo(activeTime) >= 0))) {
						// 提示时间交叉
						return getAvailableRatioExistResponse(withdrawRatioRequest, withdrawRatioInfoDO, response);
					}
				} else {
					int effectiveTimeDifferenceValue = DateUtil.daysBetween(activeTime, currentTmp);
					if (expTime != null
							&& ((activeTime.compareTo(effectiveTime) <= 0 && expTime.compareTo(effectiveTime) >= 0) || effectiveTime
									.compareTo(activeTime) <= 0)) {
						// 提示时间交叉
						return getAvailableRatioExistResponse(withdrawRatioRequest, withdrawRatioInfoDO, response);
					} else if (expTime == null && effectiveTimeDifferenceValue >= -1) {
						if (effectiveTimeDifferenceValue >= 0 && currentEffectiveRatioInfoDO == null) {
							withdrawRatioInfoDO.setExpireTime(DateUtil.generateMidnightTimeStamp(new Date()));
							currentEffectiveRatioInfoDO = withdrawRatioInfoDO;
						} else if (effectiveTimeDifferenceValue == -1
								&& activeTime.compareTo(DateUtil.generateDawnTimeStamp(DateUtil.increaseDate(currentTmp, 1))) == 0
								&& tomorrowEffectiveRatioInfoDO == null) {
							tomorrowEffectiveRatioInfoDO = withdrawRatioInfoDO;
						} else {
							return getAvailableRatioExistResponse(withdrawRatioRequest, withdrawRatioInfoDO, response);
						}
					} else if (expTime == null && effectiveTimeDifferenceValue < -1) {
						// 提示时间交叉
						return getAvailableRatioExistResponse(withdrawRatioRequest, withdrawRatioInfoDO, response);
					}
				}

			}

			if (currentEffectiveRatioInfoDO != null) {
				updateWithdrawRatioInfo(currentEffectiveRatioInfoDO);
			}

			if (tomorrowEffectiveRatioInfoDO != null) {
				tomorrowEffectiveRatioInfoDO.setHolidayRatio(holidayWithDrawRatio);
				tomorrowEffectiveRatioInfoDO.setWorkDayRatio(workDayWithDrawRatio);
				updateWithdrawRatioInfo(tomorrowEffectiveRatioInfoDO);
			} else {
				// 创建新规则,如果不传入
				insertWithdrawRatioInfo(withDrawRatioType, workDayWithDrawRatio, holidayWithDrawRatio, effectiveTime, expireTime, bizId);
				if (isFirstOpen) {// 如果首次开通 添加首次开通的需求
					Integer settleType = getServiceTypeByRatioType(withDrawRatioType);
					if (settleType != null) {
						long id=merchantSettleAttrService.createMerchantSettleInfo(settleType, withdrawRatioRequest.getMerchantNo(),
								withdrawRatioRequest.getMerchantType(), bizId, new Date());
						logger.info("createMerchantSettleInfo id:"+id);
					}

				}
			}
		}
		response.setErrorCode(ReturnCodeEnums.FW_SUCCESS.code);
		response.setErrorMsg(ReturnCodeEnums.FW_SUCCESS.desc);
		return response;
	}

	/**
	 * 查询商户信息
	 *
	 * @param withdrawRatioRequest
	 * @param response
	 * @param merchantNo
	 * @param merchantType
	 * @param withDrawRatioType
	 * @return
	 */
	private PosMerchantInfoDO queryPosMerchantInfo(WithdrawRatioRequest withdrawRatioRequest, WithdrawRatioResponse response, String merchantNo,
			String merchantType, int withDrawRatioType) {
		logger.error("WithdrawRatioService4HessianImpl#queryPosMerchantInfo ,withdrawRatioQueryRequest:"
				+ ToStringBuilder.reflectionToString(withdrawRatioRequest));
		// 查询PosMerchant 信息
		PosMerchantInfoDOExample example = new PosMerchantInfoDOExample();
		PosMerchantInfoDOExample.Criteria criteriaPosMerchantInfo = example.createCriteria();
		criteriaPosMerchantInfo.andMerchantNoEqualTo(merchantNo);
		if (StringUtils.isNotBlank(merchantType)) criteriaPosMerchantInfo.andMerchantTypeEqualTo(merchantType);
		List<PosMerchantInfoDO> posMerchantInfoDOs = posMerchantInfoManager.selectByExample(example);
		// 不唯一返回异常
		if (posMerchantInfoDOs != null && posMerchantInfoDOs.size() > 1) {
			logger.error("WithdrawRatioService4HessianImpl#queryPosMerchantInfo merchantNo is not UNIQUE,withdrawRatioQueryRequest:"
					+ ToStringBuilder.reflectionToString(withdrawRatioRequest));
			response.setErrorCode(ReturnCodeEnums.FW_SYSTEM_ERROR.code);
			response.setErrorMsg(WithdrawConstant.WITHDRAW_QUERY_ERROR_NOT_UNIQUE);
			return null;
		}

		PosMerchantInfoDO posMerchantInfoDO = null;
		// 不存在则更新
		if (posMerchantInfoDOs != null && !posMerchantInfoDOs.isEmpty())
			posMerchantInfoDO = posMerchantInfoDOs.get(0);
		else {
			ErrorMessageVO<Long> vo = limitationService.syncPosMerchantInfoByMerchantNo(merchantNo, merchantType);
			if (!vo.isSuccess()) {
				logger.error("syncPosMerchantInfoByMerchantNo :[" + merchantNo + "] error:" + vo.getErrorMessage());
				response.setErrorCode(ReturnCodeEnums.FW_SYSTEM_ERROR.code);
				response.setErrorMsg(vo.getErrorMessage());
				return null;
			}
			Long bizId = vo.getEntity();
			posMerchantInfoDO = posMerchantInfoManager.selectByPrimaryKey(bizId);
			// 创建默认的MPOS T+1 规则
			// genareteMPOSDefualtT1Ratio(bizId);
		}

		String posMerchantInfoMerchantType = posMerchantInfoDO.getMerchantType();
		if ((PosMerchantTypeEnums.POS_MERCHANT.code.equalsIgnoreCase(posMerchantInfoMerchantType) && WithdrawRatioTypeEnums.POS_T0_SETTLE_RATIO.code != withDrawRatioType)
				|| (PosMerchantTypeEnums.MPOS_MERCHANT.code.equalsIgnoreCase(posMerchantInfoMerchantType) && (WithdrawRatioTypeEnums.MPOS_T1_SETTLE_RATIO.code != withDrawRatioType
						&& WithdrawRatioTypeEnums.MPOS_D1_SETTLE_RATIO.code != withDrawRatioType && WithdrawRatioTypeEnums.MPOS_T0_SETTLE_RATIO.code != withDrawRatioType))) {
			logger.error("WithdrawRatioService4HessianImpl#createOrUpdateWithrawRatio, withdraw ratio type is not match ,withdrawRatioRequest:"
					+ ToStringBuilder.reflectionToString(withdrawRatioRequest) + ",posMerchantInfoDO:"
					+ ToStringBuilder.reflectionToString(posMerchantInfoDO));
			response.setErrorCode(ReturnCodeEnums.FW_PARAM_CHECK_IS_FAILL.code);
			response.setErrorMsg(WithdrawConstant.WITHDRAW_ERROR_RATIO_TYPE_NOT_MATCH);
			return null;
		}
		return posMerchantInfoDO;
	}

	// 是否首次开通 当前之前没有生效过的费率就认为是首次开通
	private boolean isFirstOpen(int withDrawRatioType, Long bizId) {
		WithdrawRatioInfoDOExample exampleWithdrawRatioInfo = new WithdrawRatioInfoDOExample();
		exampleWithdrawRatioInfo.createCriteria().andBizIdEqualTo(bizId).andRatioTypeEqualTo(withDrawRatioType).andEffectiveTimeLessThan(new Date());
		List<WithdrawRatioInfoDO> withdrawRatioInfoDOs = withdrawRatioInfoManager.selectByExample(exampleWithdrawRatioInfo);
		if (withdrawRatioInfoDOs != null && !withdrawRatioInfoDOs.isEmpty() && withdrawRatioInfoDOs.size() > 0) { return false; }
		return true;
	}

	private void insertWithdrawRatioInfo(int withDrawRatioType, BigDecimal workDayWithDrawRatio, BigDecimal holidayWithDrawRatio, Date effectiveTime,
			Date expireTime, Long bizId) {
		WithdrawRatioInfoDO record = new WithdrawRatioInfoDO();
		record.setBizId(bizId);
		record.setRatioType(withDrawRatioType);
		record.setStatus(WithdrawRatioStatusEnums.active.code);
		record.setWorkDayRatio(workDayWithDrawRatio);
		record.setHolidayRatio(holidayWithDrawRatio);
		record.setEffectiveTime(effectiveTime);
		if (expireTime != null) record.setExpireTime(expireTime);
		record.setCreteTime(new Date());
		withdrawRatioInfoManager.insert(record);
		String jsonContent = JSONObject.fromObject(record).toString();
		insertOpLogRecord(jsonContent, LogRecordTypeEnums.WITHDRAW_RATIO_MERGE.code, LogOPTypeEnums.CREATE.code);
		logger.info("WithdrawRatioService4HessianImpl#createAndUpdateWithrawRatio,ratioInfo expire,withdrawRatioQueryRequest:"
				+ ToStringBuilder.reflectionToString(record));
	}

	private void updateWithdrawRatioInfo(WithdrawRatioInfoDO withdrawRatioInfoDO) {
		withdrawRatioInfoDO.setUpdateTime(new Date());
		this.withdrawRatioInfoManager.updateByPrimaryKey(withdrawRatioInfoDO);
		String jsonContent = JSONObject.fromObject(withdrawRatioInfoDO).toString();
		insertOpLogRecord(jsonContent, LogRecordTypeEnums.WITHDRAW_RATIO_MERGE.code, LogOPTypeEnums.UPDATE.code);

	}

	@Override
	public WithdrawRatioResponse createT1andD1Ratio(String merchantNo, String mcType) {
		logger.error("createT1andD1Ratio ,merchantNo:" + merchantNo + ",mcType" + mcType);
		WithdrawRatioResponse response = new WithdrawRatioResponse();
		if (StringUtils.isBlank(mcType) || !mcType.equals(PosMerchantTypeEnums.MPOS_MERCHANT.code)) {
			logger.error("WithdrawRatioService4HessianImpl#createT1andD1Ratio mcType is null");
			response.setErrorCode(ReturnCodeEnums.FW_PARAM_CHECK_IS_FAILL.code);
			response.setErrorMsg(WithdrawConstant.WITHDRAW_QUERY_ERROR_NOT_VALIDATE);
			return response;
		}
		String mposWorkt1 = ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.MPOS_T1_WORKDAY_WITHDRAW_RATIO);
		String mposHoldayt1 = ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.MPOS_T1_HOLDAY_WITHDRAW_RATIO);
		String mposWorkD1 = ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.MPOS_D1_WORKDAY_WITHDRAW_RATIO);
		String mposHoldayD1 = ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.MPOS_D1_HOLDAY_WITHDRAW_RATIO);
		if (StringUtils.isBlank(mposWorkt1)) {
			mposWorkt1 = "0";
		}
		if (StringUtils.isBlank(mposHoldayt1)) {
			mposHoldayt1 = "0";
		}
		if (StringUtils.isBlank(mposWorkD1)) {
			mposWorkD1 = "0";
		}
		if (StringUtils.isBlank(mposHoldayD1)) {
			mposHoldayD1 = "0.0005";
		}
		WithdrawRatioRequest withdrawRatioRequest = new WithdrawRatioRequest();
		withdrawRatioRequest.setMerchantNo(merchantNo);
		withdrawRatioRequest.setMerchantType(mcType);
		// 拼装T1费率数据
		withdrawRatioRequest.setWithDrawRatioStatus(WithdrawRatioStatusEnums.active.code);
		withdrawRatioRequest.setWithDrawRatioType(WithdrawRatioTypeEnums.MPOS_T1_SETTLE_RATIO.code);
		withdrawRatioRequest.setWorkDayWithDrawRatio(new BigDecimal(mposWorkt1));
		withdrawRatioRequest.setHolidayWithDrawRatio(new BigDecimal(mposHoldayt1));
		// 检查费率是否存在
		WithdrawRatioResponse responseT1 = createAndUpdateWithrawRatio(withdrawRatioRequest);
		if (responseT1 == null || responseT1.getErrorCode().isEmpty()) {
			response.setErrorCode(ReturnCodeEnums.FW_RADIO_IS_FAILL.code);
			response.setErrorMsg(ReturnCodeEnums.FW_RADIO_IS_FAILL.desc + "插入mpos t1 费率异常,无返回对象或返回对象为空");
			return response;
		}
		if (!responseT1.getErrorCode().equals("0")) {
			response.setErrorCode(ReturnCodeEnums.FW_RADIO_IS_FAILL.code);
			response.setErrorMsg(ReturnCodeEnums.FW_RADIO_IS_FAILL.desc + "插入mpos t1 费率异常:返回结果异常,返回代码-" + responseT1.getErrorCode() + ",错误信息"
					+ responseT1.getErrorMsg());
			return response;
		}
		// 拼装D1费率数据
		withdrawRatioRequest.setWithDrawRatioStatus(WithdrawRatioStatusEnums.active.code);
		withdrawRatioRequest.setWithDrawRatioType(WithdrawRatioTypeEnums.MPOS_D1_SETTLE_RATIO.code);
		withdrawRatioRequest.setWorkDayWithDrawRatio(new BigDecimal(mposWorkD1));
		withdrawRatioRequest.setHolidayWithDrawRatio(new BigDecimal(mposHoldayD1));
		WithdrawRatioResponse responseD1 = createAndUpdateWithrawRatio(withdrawRatioRequest);
		if (responseD1 == null || responseD1.getErrorCode().isEmpty()) {
			response.setErrorCode(ReturnCodeEnums.FW_RADIO_IS_FAILL.code);
			response.setErrorMsg(ReturnCodeEnums.FW_RADIO_IS_FAILL.desc + "插入mpos d1 费率异常:无返回对象或返回对象为空");
			return response;
		}
		if (!responseD1.getErrorCode().equals("0")) {
			response.setErrorCode(ReturnCodeEnums.FW_RADIO_IS_FAILL.code);
			response.setErrorMsg(ReturnCodeEnums.FW_RADIO_IS_FAILL.desc + "插入mpos d1 费率异常:返回结果异常,返回代码-" + responseD1.getErrorCode() + ",错误信息"
					+ responseD1.getErrorMsg());
			return response;
		}
		response.setErrorCode(ReturnCodeEnums.FW_SUCCESS.code);
		response.setErrorMsg(ReturnCodeEnums.FW_SUCCESS.desc);
		return response;
	}

	@Override
	public Integer getServiceTypeByRatioType(int code) {
		if (WithdrawRatioTypeEnums.MPOS_D1_SETTLE_RATIO.code == code) {return WithdrawServiceTypeEnums.D1.code;
		} else if (WithdrawRatioTypeEnums.MPOS_T0_SETTLE_RATIO.code == code) {return WithdrawServiceTypeEnums.T0.code;
		} else if (WithdrawRatioTypeEnums.MPOS_T1_SETTLE_RATIO.code == code) {return WithdrawServiceTypeEnums.T1.code;
		} else if (WithdrawRatioTypeEnums.POS_T0_SETTLE_RATIO.code == code) { return WithdrawServiceTypeEnums.T0.code; 
	    } else if (WithdrawRatioTypeEnums.EASYPAY_T0_SETTLE_RATIO.code == code) { return WithdrawServiceTypeEnums.T0.code; }
		return null;
	}

}
