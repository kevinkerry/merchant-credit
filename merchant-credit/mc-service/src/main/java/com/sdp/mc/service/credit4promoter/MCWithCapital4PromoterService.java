package com.sdp.mc.service.credit4promoter;

import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.mcwithfunding.dao.WithCapital4PromoterDO;

public interface MCWithCapital4PromoterService {

	/**
	 * 恢复配资额度job[在补单job retryRecoveryMspFastSettleLimit4Job之前完成]
	 * **/
	public void resetCreditLimit4Job();

	/**
	 * msp配资恢复额度修改失败补单job，只有3次机会，8点之前完成，否则与快速结算追加保证金时间重叠
	 * **/
	public void retryRecoveryMspFastSettleLimit4Job();

	/**
	 * 后台恢复配资和job共用
	 * @param operatorId 
	 *
	 * **/
	public ErrorMessageVO<Object> resetCreditLimit(WithCapital4PromoterDO record, String operatorId);

	/**
	 * 根据id查询配资申请记录
	 *
	 * **/
	public WithCapital4PromoterDO queryWithCapital4PromoterById(Long id);
}
