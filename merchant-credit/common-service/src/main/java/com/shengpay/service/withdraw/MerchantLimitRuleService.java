package com.shengpay.service.withdraw;

import java.math.BigDecimal;
import java.util.List;

import com.sdp.withdraw.dao.MerchantLimitRuleDO;
import com.sdp.withdraw.dao.MerchantLimitRuleDOExample;
import com.sdp.withdraw.entity.MerchantLimitRuleDTO;


public interface MerchantLimitRuleService {
    /**
     * 查询提现费用
     * @param query
     * @return
     */
	List<MerchantLimitRuleDO> queryMerchantLimitRule(MerchantLimitRuleDOExample query);

	/**
	 * 查询提现费用根据ID
	 * @param id
	 * @return
	 */
	MerchantLimitRuleDO selectByPrimaryKey(Long id);
    /**
     * 根据主键更新提现费率配置信息
     * @param infoDo
     * @return
     */
	int updateByPrimaryKeySelective(MerchantLimitRuleDO infoDo);
	/**
	 * 查询提现费用
	 * @param type 类型
	 * @param merchantNo 商户号/代理商商户号
	 * @param merchantType 商户类型
	 * @return
	 */
	MerchantLimitRuleDO queryMerchantLimitRule(Integer type,String merchantNo,String merchantType);
	/**
	 * 查询提现费用
	 * @param type 类型
	 * @return
	 */
	List<MerchantLimitRuleDO> queryMerchantLimitRule(Integer type,String merchantType);
	


	Long insert(MerchantLimitRuleDO config);

	int updateLoseEfficacy(Long id,String opId,String opName);

	Long createMerchantLimitRule(String merchantNo, String mcType,BigDecimal limit,String opId,String opName);

	List<MerchantLimitRuleDO> selectByQuery(MerchantLimitRuleDTO query);
	/**
	 * 查询代理商当前的提现费率
	 * @param merchantNo  代理商商户号
	 * @param merchantType 代理商类型
	 * @return
	 */
	BigDecimal queryMerchantCurrentMerchantLimitRule(String promoterMerchantNo, String promoterType);




}
