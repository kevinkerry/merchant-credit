package com.shengpay.debit.common.service;

import com.sdp.mc.common.vo.ErrorMessageVO;
import com.shengpay.debit.dal.dataobject.DmAgentMerchantSettingListExample;
import com.shengpay.debit.dal.dataobject.DmAgentMerchantSettingListPO;



/**
 * 代理商担保信息
 *
 * @author liutao
 * **/
public interface GuaranteeService {
	public ErrorMessageVO openOrCloseAgentPower(DmAgentMerchantSettingListPO po);
	public  DmAgentMerchantSettingListPO selectByExample(DmAgentMerchantSettingListExample example);
}
