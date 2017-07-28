package com.sdp.mc.service.newt0.loaning.config;

import com.sdp.mc.common.bean.newt0.LoaningConfigBean;
import com.sdp.mc.common.enums.LoaningTypeEnum;

public interface LoaningCongfigService {

	/**
	 * 查询垫资方基础信息
	 *
	 * @param loaningTypeEnum
	 * @return
	 */
	public LoaningConfigBean getLoaningConfigBeanByLoaningType(LoaningTypeEnum loaningTypeEnum);


	/**
	 * 根据商户类型 垫资类型查询
	 * @param loaningConfigBean 垫资类型
	 * @param mcType 代理商的商户号
	 * @return
	 */
	public LoaningConfigBean getLoaningConfigBeanByLoaningTypeMcType(LoaningConfigBean loaningConfigBean,String mcType);

	/**
	 * 根据垫资类型、商户类型取垫资方基础信息
	 * @param loaningTypeEnum
	 * @param mcType
	 * @return
	 */
	public LoaningConfigBean getLoaningConfigBeanByLoaningTypeAndMcType(LoaningTypeEnum loaningTypeEnum,String mcType);


	public LoaningConfigBean getLoaningConfigBean(int loaningType, String promoterType);
}
