package com.shengpay.service.withdraw.cost.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.constant.MerchantContractCst;
import com.sdp.mc.common.enums.PolicyTypeEnums;
import com.sdp.mc.common.enums.WithdrawCostStatusEnums;
import com.sdp.mc.common.enums.WithdrawCostTypeEnums;
import com.sdp.withdraw.dao.PolicyConfigInfoDO;
import com.sdp.withdraw.dao.WithdrawCostConfigDO;
import com.sdp.withdraw.dao.WithdrawCostConfigDOExample;
import com.sdp.withdraw.entity.WithdrawCostConfigDTO;
import com.sdp.withdraw.entity.WithdrawCostConfigPO;
import com.sdp.withdraw.manager.WithdrawCostConfigManager;
import com.sdp.withdraw.manager.ext.ExtWithdrawCostConfigManager;
import com.shengpay.service.whitelist.WhiteListInfoService;
import com.shengpay.service.withdraw.PolicyConfigInfoService;
import com.shengpay.service.withdraw.cost.WithdrawCostConfigService;

@Service("withdrawCostConfigService")
public class WithdrawCostConfigServiceImpl implements WithdrawCostConfigService {

	@Autowired
	private WithdrawCostConfigManager withdrawCostConfigManager;
	@Autowired
	private ExtWithdrawCostConfigManager extWithdrawCostConfigManager;
	@Autowired
	private PolicyConfigInfoService policyConfigInfoService;

	@Override
	public List<WithdrawCostConfigDO> queryWithdrawCostConfig(WithdrawCostConfigDOExample query) {
		return withdrawCostConfigManager.selectByExample(query);
	}

	@Override
	public WithdrawCostConfigDO selectByPrimaryKey(Long id) {
		return withdrawCostConfigManager.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(WithdrawCostConfigDO infoDo) {
		return withdrawCostConfigManager.updateByPrimaryKeySelective(infoDo);
	}

	@Override
	public WithdrawCostConfigDO queryWithdrawCostConfig(Integer type, String merchantNo, String merchantType) {
		WithdrawCostConfigDOExample query = new WithdrawCostConfigDOExample();
		query.setType(type);
		query.setMerchantNo(merchantNo);
		query.setMerchantType(merchantType);
		query.setStatus(WithdrawCostStatusEnums.EFFECTIVITY.code);
		List<WithdrawCostConfigDO> list = this.withdrawCostConfigManager.selectByExample(query);
		if (list != null && !list.isEmpty()) { return list.get(0); }
		return null;
	}

	@Override
	public List<WithdrawCostConfigDO> queryWithdrawCostConfig(Integer type) {
		WithdrawCostConfigDOExample query = new WithdrawCostConfigDOExample();
		query.setType(type);
		query.setStatus(WithdrawCostStatusEnums.EFFECTIVITY.code);
		return this.withdrawCostConfigManager.selectByExample(query);
	}

	@Override
	public WithdrawCostConfigDO queryPromoterCurrentWithdrawCostConfig(String merchantNo, String merchantType) {
		WithdrawCostConfigDOExample query = new WithdrawCostConfigDOExample();
		query.setType(WithdrawCostTypeEnums.DEFINITIVE.code);
		query.setMerchantNo(merchantNo);
		query.setMerchantType(merchantType);
		query.setStatus(WithdrawCostStatusEnums.EFFECTIVITY.code);
		List<WithdrawCostConfigDO> list = this.withdrawCostConfigManager.selectByExample(query);
		if (list != null && !list.isEmpty()) { return list.get(0); }
		list = this.queryWithdrawCostConfig(WithdrawCostTypeEnums.DEFAULT.code);
		if (list != null && !list.isEmpty()) { return list.get(0); }
		return null;
	}

	@Override
	public Long insert(WithdrawCostConfigDO config) {
		return this.withdrawCostConfigManager.insert(config);
	}

	@Override
	public int updateLoseEfficacy(Long id, String opId, String opName) {
		WithdrawCostConfigDO config = new WithdrawCostConfigDO();
		config.setOperatorId(opId);
		config.setOperatorName(opName);
		config.setUpdateTime(new Date());
		config.setStatus(WithdrawCostStatusEnums.LOSE_EFFICACY.code);
		WithdrawCostConfigDOExample example = new WithdrawCostConfigDOExample();
		example.createCriteria().andIdEqualTo(id).andStatusEqualTo(WithdrawCostStatusEnums.EFFECTIVITY.code);
		return this.extWithdrawCostConfigManager.updateByExampleSelective(config, example);
	}

	@Override
	public Long createWithdrawCostConfig(String merchantNo, String mcType, BigDecimal wdCost, BigDecimal wdPromoterSplittingScale, String opId,
			String opName) {
		WithdrawCostConfigDO config = new WithdrawCostConfigDO();
		config.setOperatorId(opId);
		config.setOperatorName(opName);
		config.setUpdateTime(new Date());
		config.setCreateTime(new Date());
		config.setStatus(WithdrawCostStatusEnums.EFFECTIVITY.code);
		config.setWdCost(wdCost);
		config.setWdPromoterSplittingScale(wdPromoterSplittingScale);
		config.setType(WithdrawCostTypeEnums.DEFINITIVE.code);
		return this.withdrawCostConfigManager.insert(config);
	}

	@Override
	public BigDecimal queryMerchantCurrentWithdrawCostConfig(String merchantNo, String merchantType, String promoterMerchantNo, String promoterType,
			String mcc) {
		if (StringUtils.isNotBlank(mcc)) {//根据mcc查询政策对应的提现费用
			PolicyConfigInfoDO policyInfo = policyConfigInfoService.queryPolicyConfigInfo(PolicyTypeEnums.MCC.type, mcc);
			if (policyInfo != null && policyInfo.getWithdrawCost() != null) { return policyInfo.getWithdrawCost(); }
		}

		WithdrawCostConfigDOExample query = new WithdrawCostConfigDOExample();
		List<WithdrawCostConfigDO> list = null;
		query.setType(WithdrawCostTypeEnums.DEFINITIVE.code);
		query.setStatus(WithdrawCostStatusEnums.EFFECTIVITY.code);
		/*if (StringUtils.isNotBlank(mcc)) {
			query.setMerchantNo(mcc);
			query.setMerchantType(MerchantContractCst.WITHDRAW_CONFIG_TYPE_MCC);
			list = this.withdrawCostConfigManager.selectByExample(query);
			if (list != null && !list.isEmpty()) { return list.get(0).getWdCost(); }
		}*/
		query.setMerchantNo(merchantNo);
		query.setMerchantType(merchantType);
		list = this.withdrawCostConfigManager.selectByExample(query);
		if (list != null && !list.isEmpty()) { return list.get(0).getWdCost(); }
		query.setMerchantNo(promoterMerchantNo);
		query.setMerchantType(promoterType);
		list = this.withdrawCostConfigManager.selectByExample(query);
		if (list != null && !list.isEmpty()) { return list.get(0).getWdCost(); }
		list = this.queryWithdrawCostConfig(WithdrawCostTypeEnums.DEFAULT.code);
		if (list != null && !list.isEmpty()) { return list.get(0).getWdCost(); }
		return null;
	}

	@Override
	public List<WithdrawCostConfigDO> selectByQuery(WithdrawCostConfigDTO query) {
		WithdrawCostConfigPO po = query.getPo();
		WithdrawCostConfigDOExample example = query.getExample();
		if (po.getMerchantNo() != null) {
			example.setMerchantNo(po.getMerchantNo());
		}
		if (po.getMerchantType() != null) {
			example.setMerchantType(po.getMerchantType());
		}
		if (po.getStatus() != null) {
			example.setStatus(po.getStatus());
		}
		query.getExample().setStatus(WithdrawCostStatusEnums.EFFECTIVITY.code);
		query.getExample().setOrderByClause(" TYPE ASC,CREATE_TIME DESC");
		List<WithdrawCostConfigDO> list = this.withdrawCostConfigManager.selectByExample(query.getExample());
		return list;
	}


}
