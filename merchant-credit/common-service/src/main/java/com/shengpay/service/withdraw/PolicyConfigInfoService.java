package com.shengpay.service.withdraw;

import java.util.List;

import com.sdp.withdraw.dao.PolicyConfigInfoDO;
import com.sdp.withdraw.entity.PolicyConfigInfoDTO;
import com.sdp.withdraw.entity.PolicyConfigInfoPO;

public interface PolicyConfigInfoService {

	List<PolicyConfigInfoDO> selectByQuery(PolicyConfigInfoDTO query);

	PolicyConfigInfoDO selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(PolicyConfigInfoPO config);

	Long insert(PolicyConfigInfoPO config);

	/**
	 * 查询政策的配置信息,默认是政策类的配置
	 * @param policyId
	 * @return
	 */
	PolicyConfigInfoDO queryPolicyConfigInfo(String policyId);
    /**
     * 查询政策的配置信息
     * @param policyType 政策类型
     * @param policyId 政策的编号
     * @return
     */
	PolicyConfigInfoDO queryPolicyConfigInfo(int policyType, String policyId);
	/**
	 * 修改政策配置(工作日费率节假日费率提现费用可为空)
	 * @param config
	 * @return
	 */
	int updateByPrimaryKey(PolicyConfigInfoPO config);


}