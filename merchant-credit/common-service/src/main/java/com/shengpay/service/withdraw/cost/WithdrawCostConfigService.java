package com.shengpay.service.withdraw.cost;

import java.math.BigDecimal;
import java.util.List;

import com.sdp.withdraw.dao.WithdrawCostConfigDO;
import com.sdp.withdraw.dao.WithdrawCostConfigDOExample;
import com.sdp.withdraw.entity.WithdrawCostConfigDTO;

public interface WithdrawCostConfigService {
    /**
     * 查询提现费用
     * @param query
     * @return
     */
	List<WithdrawCostConfigDO> queryWithdrawCostConfig(WithdrawCostConfigDOExample query);

	/**
	 * 查询提现费用根据ID
	 * @param id
	 * @return
	 */
	WithdrawCostConfigDO selectByPrimaryKey(Long id);
    /**
     * 根据主键更新提现费率配置信息
     * @param infoDo
     * @return
     */
	int updateByPrimaryKeySelective(WithdrawCostConfigDO infoDo);
	/**
	 * 查询提现费用
	 * @param type 类型
	 * @param merchantNo 商户号/代理商商户号
	 * @param merchantType 商户类型
	 * @return
	 */
	WithdrawCostConfigDO queryWithdrawCostConfig(Integer type,String merchantNo,String merchantType);
	/**
	 * 查询提现费用
	 * @param type 类型
	 * @return
	 */
	List<WithdrawCostConfigDO> queryWithdrawCostConfig(Integer type);
	/**
	 * 查询代理商当前的提现费率
	 * @param merchantNo  代理商商户号
	 * @param merchantType 代理商类型
	 * @return
	 */
	WithdrawCostConfigDO queryPromoterCurrentWithdrawCostConfig(String merchantNo,String merchantType);
	/**
	 * 查询商户当前的提现费率
	 * @param merchantNo 商户号
	 * @param merchantType 商户类型
	 * @param promoterMerchantNo 代理商商户号
	 * @param promoterType 代理商类型
	 * @return
	 */
	BigDecimal queryMerchantCurrentWithdrawCostConfig(String merchantNo,String merchantType,String promoterMerchantNo,String promoterType,String mcc);

	Long insert(WithdrawCostConfigDO config);

	int updateLoseEfficacy(Long id,String opId,String opName);

	Long createWithdrawCostConfig(String merchantNo, String mcType,BigDecimal wdCost,BigDecimal wdPromoterSplittingScale,String opId,String opName);

	List<WithdrawCostConfigDO> selectByQuery(WithdrawCostConfigDTO query);



}
