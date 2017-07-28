package com.sdp.withdraw.service;

import com.sdp.mc.common.bean.newt0.LoaningConfigBean;
import com.sdp.mc.common.enums.LoaningTypeEnum;

public interface WithDrawLoaningConfigService {

	/**
	 * 查询垫资方基础信息
	 *
	 * @param loaningTypeEnum
	 * @return
	 */
	public LoaningConfigBean getLoaningConfigBeanByLoaningType(LoaningTypeEnum loaningTypeEnum);


	public LoaningConfigBean getLoaningConfigBeanByLoaningTypeMcType(LoaningConfigBean loaningConfigBean,String mcType);
}
