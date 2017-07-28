package com.shengpay.service.withdraw.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.MerchantLimitRuleStatusEnums;
import com.sdp.mc.common.enums.WithdrawCostTypeEnums;
import com.sdp.withdraw.dao.MerchantLimitRuleDO;
import com.sdp.withdraw.dao.MerchantLimitRuleDOExample;
import com.sdp.withdraw.dao.daointerface.MerchantLimitRuleDAO;
import com.sdp.withdraw.entity.MerchantLimitRuleDTO;
import com.sdp.withdraw.entity.MerchantLimitRulePO;
import com.sdp.withdraw.manager.MerchantLimitRuleManager;
import com.shengpay.service.withdraw.MerchantLimitRuleService;
import com.shengpay.service.withdraw.PolicyConfigInfoService;

@Service("MerchantLimitRuleService")
public class MerchantLimitRuleServiceImpl implements MerchantLimitRuleService {

	@Autowired
	private MerchantLimitRuleManager merchantLimitRuleManager;
	@Autowired
	private MerchantLimitRuleDAO merchantLimitRuleDAO;
	@Autowired
	private PolicyConfigInfoService policyConfigInfoService;

	@Override
	public List<MerchantLimitRuleDO> queryMerchantLimitRule(MerchantLimitRuleDOExample query) {
		return merchantLimitRuleManager.selectByExample(query);
	}

	@Override
	public MerchantLimitRuleDO selectByPrimaryKey(Long id) {
		return merchantLimitRuleManager.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(MerchantLimitRuleDO infoDo) {
		return merchantLimitRuleManager.updateByPrimaryKeySelective(infoDo);
	}

	@Override
	public MerchantLimitRuleDO queryMerchantLimitRule(Integer type, String merchantNo, String merchantType) {
		MerchantLimitRuleDOExample query = new MerchantLimitRuleDOExample();
		query.setType(type);
		query.setMerchantNo(merchantNo);
		query.setMerchantType(merchantType);
		query.setStatus(MerchantLimitRuleStatusEnums.EFFECTIVITY.code);
		List<MerchantLimitRuleDO> list = this.merchantLimitRuleManager.selectByExample(query);
		if (list != null && !list.isEmpty()) { return list.get(0); }
		return null;
	}

	@Override
	public List<MerchantLimitRuleDO> queryMerchantLimitRule(Integer type,String merchantType) {
		MerchantLimitRuleDOExample query = new MerchantLimitRuleDOExample();
		query.setType(type);
		query.setMerchantType(merchantType);
		query.setStatus(MerchantLimitRuleStatusEnums.EFFECTIVITY.code);
		return this.merchantLimitRuleManager.selectByExample(query);
	}

	@Override
	public Long insert(MerchantLimitRuleDO config) {
		return this.merchantLimitRuleManager.insert(config);
	}

	@Override
	public int updateLoseEfficacy(Long id, String opId, String opName) {
		MerchantLimitRuleDO config = new MerchantLimitRuleDO();
		config.setOperatorId(opId);
		config.setOperatorName(opName);
		config.setUpdateTime(new Date());
		config.setStatus(MerchantLimitRuleStatusEnums.LOSE_EFFICACY.code);
		MerchantLimitRuleDOExample example = new MerchantLimitRuleDOExample();
		example.createCriteria().andIdEqualTo(id).andStatusEqualTo(MerchantLimitRuleStatusEnums.EFFECTIVITY.code);
		return this.merchantLimitRuleDAO.updateByExampleSelective(config, example);
	}

	@Override
	public Long createMerchantLimitRule(String merchantNo, String mcType, BigDecimal limit,String opId,
			String opName) {
		MerchantLimitRuleDO config = new MerchantLimitRuleDO();
		config.setOperatorId(opId);
		config.setOperatorName(opName);
		config.setUpdateTime(new Date());
		config.setCreateTime(new Date());
		config.setStatus(MerchantLimitRuleStatusEnums.EFFECTIVITY.code);
		config.setLimit(limit);
		config.setType(WithdrawCostTypeEnums.DEFINITIVE.code);
		return this.merchantLimitRuleManager.insert(config);
	}

	@Override
	public BigDecimal queryMerchantCurrentMerchantLimitRule(String promoterMerchantNo, String promoterType) {
		MerchantLimitRuleDOExample query = new MerchantLimitRuleDOExample();
		List<MerchantLimitRuleDO> list = null;
		query.setType(WithdrawCostTypeEnums.DEFINITIVE.code);
		query.setStatus(MerchantLimitRuleStatusEnums.EFFECTIVITY.code);
		query.setMerchantNo(promoterMerchantNo);
		query.setMerchantType(promoterType);
		list = this.merchantLimitRuleManager.selectByExample(query);
		if (list != null && !list.isEmpty()) { return list.get(0).getLimit(); }
		list = this.queryMerchantLimitRule(WithdrawCostTypeEnums.DEFAULT.code,promoterType);
		if (list != null && !list.isEmpty()) { return list.get(0).getLimit(); }
		return null;
	}

	@Override
	public List<MerchantLimitRuleDO> selectByQuery(MerchantLimitRuleDTO query) {
		MerchantLimitRulePO po = query.getPo();
		MerchantLimitRuleDOExample example = query.getExample();
		if (po.getMerchantNo() != null) {
			example.setMerchantNo(po.getMerchantNo());
		}
		if (po.getMerchantType() != null) {
			example.setMerchantType(po.getMerchantType());
		}
		if (po.getStatus() != null) {
			example.setStatus(po.getStatus());
		}
		query.getExample().setStatus(MerchantLimitRuleStatusEnums.EFFECTIVITY.code);
		query.getExample().setOrderByClause(" TYPE ASC,CREATE_TIME DESC");
		List<MerchantLimitRuleDO> list = this.merchantLimitRuleManager.selectByExample(query.getExample());
		return list;
	}
	


}
