package com.shengpay.service.withdraw.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.CommonStatusEnums;
import com.sdp.mc.common.enums.PolicyTypeEnums;
import com.sdp.withdraw.dao.PolicyConfigInfoDO;
import com.sdp.withdraw.dao.PolicyConfigInfoDOExample;
import com.sdp.withdraw.entity.PolicyConfigInfoDTO;
import com.sdp.withdraw.entity.PolicyConfigInfoPO;
import com.sdp.withdraw.manager.PolicyConfigInfoManager;
import com.shengpay.service.withdraw.PolicyConfigInfoService;

@Service
public class PolicyConfigInfoServiceImpl implements PolicyConfigInfoService {

	private static Logger logger = LoggerFactory.getLogger(PolicyConfigInfoServiceImpl.class);
	@Autowired
	private PolicyConfigInfoManager policyConfigInfoManager;

	@Override
	public List<PolicyConfigInfoDO> selectByQuery(PolicyConfigInfoDTO query) {
		PolicyConfigInfoPO po = query.getPo();
		PolicyConfigInfoDOExample example = query.getExample();
		if (po.getPolicyId() != null) {
			example.setPolicyId(po.getPolicyId());
		}
		if (po.getPolicyType() != null) {
			example.setPolicyType(po.getPolicyType());
		}
		if (po.getStatus() != null) {
			example.setStatus(po.getStatus());
		}
		if (StringUtils.isNotBlank(po.getPolicyName())) {
			example.createCriteria().andPolicyNameLike("%" + po.getPolicyName() + "%");
		}

		query.getExample().setOrderByClause("CREATE_TIME DESC");
		List<PolicyConfigInfoDO> list = policyConfigInfoManager.selectByQuery(example);
		return list;
	}

	@Override
	public PolicyConfigInfoDO selectByPrimaryKey(Long id) {
		return policyConfigInfoManager.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(PolicyConfigInfoPO config) {
		return policyConfigInfoManager.updateByPrimaryKeySelective(config);
	}
	@Override
	public int updateByPrimaryKey(PolicyConfigInfoPO config) {
		return policyConfigInfoManager.updateByPrimaryKey(config);
	}

	@Override
	public Long insert(PolicyConfigInfoPO config) {
		return policyConfigInfoManager.insert(config);
	}

	@Override
	public PolicyConfigInfoDO queryPolicyConfigInfo(String policyId) {
		return queryPolicyConfigInfo(PolicyTypeEnums.POLICY.type, policyId);
	}
	@Override
	public PolicyConfigInfoDO queryPolicyConfigInfo(int policyType,String policyId) {
		logger.info("queryPolicyConfigInfo ,policyType:{},policyId:{}",new Object[]{policyType,policyId});
		if(StringUtils.isBlank(policyId)||policyType<=0){
			return null;
		}
		PolicyConfigInfoDOExample example = new PolicyConfigInfoDOExample();
		example.setPolicyId(policyId);
		example.setPolicyType(policyType);
		example.setStatus(CommonStatusEnums.TAKE_EFFECT.code);
		List<PolicyConfigInfoDO> list = policyConfigInfoManager.selectByQuery(example);
		return list != null && !list.isEmpty() ? list.get(0) : null;
	}

}
