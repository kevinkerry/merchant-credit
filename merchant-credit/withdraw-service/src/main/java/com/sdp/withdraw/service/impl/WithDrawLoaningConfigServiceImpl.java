package com.sdp.withdraw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.bean.newt0.LoaningConfigBean;
import com.sdp.mc.common.bean.newt0.PmtMerchantType;
import com.sdp.mc.common.enums.LoaningTypeEnum;
import com.sdp.mc.common.enums.withdraw.PmtTypeEnums;
import com.sdp.mc.newt0.dao.Newt0LoaningConfigDO;
import com.sdp.mc.newt0.dao.Newt0LoaningConfigDOExample;
import com.sdp.mc.newt0.manager.Newt0LoaningConfigManager;
import com.sdp.withdraw.service.WithDrawLoaningConfigService;

@Service("WithDrawLoaningConfigService")
public class WithDrawLoaningConfigServiceImpl implements WithDrawLoaningConfigService {

	private Logger logger = LoggerFactory.getLogger(WithDrawLoaningConfigServiceImpl.class);
	@Autowired
	private Newt0LoaningConfigManager loaningConfigManager;

	@Autowired
	protected Mapper beanMapper;

	@Override
	public LoaningConfigBean getLoaningConfigBeanByLoaningType(LoaningTypeEnum loaningTypeEnum) {
		Newt0LoaningConfigDOExample loaningConfigDOExample = new Newt0LoaningConfigDOExample();
		loaningConfigDOExample.createCriteria().andLoaningTypeEqualTo(loaningTypeEnum.getCode());
		loaningConfigDOExample.setLoaningType(loaningTypeEnum.getCode());
		List<Newt0LoaningConfigDO> list = loaningConfigManager.selectByQuery(loaningConfigDOExample);
		if (list == null || list.isEmpty()) return null;
		if (list.size() > 1) logger.error("LoaningConfigBean,Code:" + loaningTypeEnum.getCode() + ",size greater than 1.");
		Newt0LoaningConfigDO loaningConfigDO = list.get(0);
		return LoaningConfigBean.json2Bean(loaningConfigDO.getContent());
	}

	/**
	 * 根据代理商类型查垫资方
	 * 
	 * @param mcType
	 *            代理商类型 2016年3月15日 14:47:32
	 */
	@SuppressWarnings("static-access")
	@Override
	public LoaningConfigBean getLoaningConfigBeanByLoaningTypeMcType(LoaningConfigBean loaningConfigBean, String mcType) {
		LoaningConfigBean bean = null;
		try {
			PmtTypeEnums pmtTypeEnums = PmtTypeEnums.getPmtTypeEnums(mcType);
			if (pmtTypeEnums == null || loaningConfigBean == null) {
				logger.info("getLoaningConfigBeanByLoaningTypeMcType [" + mcType + "] is null");
				return loaningConfigBean;
			}
			@SuppressWarnings("rawtypes")
			Map<String, Class> classMap = new HashMap<String, Class>();
			classMap.put("pmtMerchantType", PmtMerchantType.class);
			List<PmtMerchantType> pmtList = loaningConfigBean.getPtmMerchantType();
			for (int i = 0; i < pmtList.size(); i++) {
				PmtMerchantType pmtMerchantType = (PmtMerchantType) JSONObject.toBean(JSONObject.fromObject(pmtList.get(i)), PmtMerchantType.class,
						classMap);
				if (pmtMerchantType != null && pmtMerchantType.getMcType() != null && pmtMerchantType.getMcType().equals(mcType)) {
					bean = beanMapper.map(pmtMerchantType, LoaningConfigBean.class);
					break;
				}
			}
			/*
			 * if (pmtTypeEnums.PMT_POS_MERCHANT_TYPE.code.equals(mcType)){ for
			 * (int i=0;i<pmtList.size();i++) { PmtMerchantType pmtMerchantType
			 * = (PmtMerchantType)
			 * JSONObject.toBean(JSONObject.fromObject(pmtList.get(i)),
			 * PmtMerchantType.class, classMap); String pmtType =
			 * pmtMerchantType.getMcType(); if
			 * (pmtTypeEnums.PMT_POS_MERCHANT_TYPE.code.equals(pmtType)){ bean =
			 * beanMapper.map(pmtMerchantType, LoaningConfigBean.class); } }
			 * }else if
			 * (pmtTypeEnums.PMT_MPOS_MERCHANT_TYPE.code.equals(mcType)){ for
			 * (int i=0;i<pmtList.size();i++) { PmtMerchantType pmtMerchantType
			 * = (PmtMerchantType)
			 * JSONObject.toBean(JSONObject.fromObject(pmtList.get(i)),
			 * PmtMerchantType.class, classMap); String pmtType =
			 * pmtMerchantType.getMcType(); if
			 * (pmtTypeEnums.PMT_MPOS_MERCHANT_TYPE.code.equals(pmtType)){ bean
			 * = beanMapper.map(pmtMerchantType, LoaningConfigBean.class); } } }
			 */
		} catch (Exception e) {
			bean = null;
			logger.error("getLoaningConfigBeanByLoaningTypeMcType: [" + mcType + "] error", e);
		}
		if (bean == null)
			return loaningConfigBean;
		else return bean;
	}

}
