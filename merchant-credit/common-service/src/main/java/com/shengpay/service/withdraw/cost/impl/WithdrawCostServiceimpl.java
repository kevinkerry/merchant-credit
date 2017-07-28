package com.shengpay.service.withdraw.cost.impl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.config.manager.ConfigOptionManager;
@Service("WithdrawCostServiceimpl")
public class WithdrawCostServiceimpl {
	@Autowired
	private ConfigOptionManager configOptionManager;
	/**
	 * 是否满足T0新费率0.11%+N
	 * @return
	 */
	public boolean t0CostIsState(){
		String configDateStr=ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.T0_COST_DATE);
		if(StringUtils.isBlank(configDateStr))return false;
		Date configDate=DateUtil.str2Date(configDateStr);
		configDateStr=DateUtil.getCurrentDayStrFristTime(configDate);
		Date currentDateStr=new Date();
		if(DateUtil.compareDate(currentDateStr, configDate)>=0) return true;
		return false;
	}
}
