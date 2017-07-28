package com.sdp.mc.service.limitrule;

import java.math.BigDecimal;
import java.util.List;

import com.sdp.mc.common.exception.FastSettleLimitException;
import com.sdp.mc.newt0.dao.Newt0LimitRuleInfoDO;


public interface LimitRuleInfoService {
    /**
     * 查询所有的规则信息
     * @return
     */
	List<Newt0LimitRuleInfoDO> queryLimitRuleInfo();
    /**
     * 查询规则信息通过规则ID
     * @param id 规则ID
     * @return
     */
	Newt0LimitRuleInfoDO getLimitRuleInfoById(String id);
	/**
	 * 查询规则信息通过规则ID
	 * @param id 规则ID
	 * @return
	 */
	Newt0LimitRuleInfoDO getLimitRuleInfoById(Long id);
    /**
     * 更新规则信息
     * @param entity
     * @return
     */
	int updateByPrimaryKeySelective(Newt0LimitRuleInfoDO entity);
	/**
	 * 计算快速结算的额度
	 * @param ruleId 计算的规则ID
	 * @param dailyAmount 上个月交易日日均刷卡金额：
	 * @param activeDay 上个月活跃天数
	 * @param totalAmount 代理商总额度
	 * @return
	 * @throws FastSettleLimitException 
	 */
	BigDecimal cmoputeFastSettleAmount(Long ruleId,BigDecimal dailyAmount,int activeDay,BigDecimal totalAmount) throws FastSettleLimitException;
	
	/**
	 * 计算快速结算的额度
	 * @param ruleId 计算的规则ID
	 * @param merchantNo 商户号
	 * @param posMerchantType pos商户类型
	 * @return
	 * @throws Exception 
	 */
	BigDecimal cmoputeFastSettleAmount(String ruleId, String merchantNo,String posMerchantType) throws Exception;
	/**
	 * 计算快速结算的额度
	 * @param merchantNo 商户号
	 * @param posMerchantType pos商户类型
	 * @return
	 * @throws FastSettleLimitException 
	 * @throws Exception 
	 */
	BigDecimal cmoputeFastSettleAmount(String merchantNo,String posMerchantType,int source) throws FastSettleLimitException;
	
}
