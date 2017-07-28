package com.shengpay.debit.ext.daointerface;

import java.util.List;

import com.shengpay.debit.dal.dataobject.DmMerchantCreditBaseInfoExample;
import com.shengpay.debit.dal.dataobject.DmMerchantCreditBaseInfoPO;
import com.shengpay.debit.daointerface.DmMerchantCreditBaseInfoDAOImpl;

public class ExtDmMerchantCreditBaseInfoDAOImpl extends DmMerchantCreditBaseInfoDAOImpl implements ExtDmMerchantCreditBaseInfoDAO {

	public DmMerchantCreditBaseInfoPO selectMerchantCreditBaseInfoByMerchantNo(String merchantNo) {
		DmMerchantCreditBaseInfoExample example = new DmMerchantCreditBaseInfoExample();
		example.createCriteria().andMerchantNoEqualTo(merchantNo);
		List<DmMerchantCreditBaseInfoPO> merchantCreditBaseInfos = this.selectByExample(example);
		return merchantCreditBaseInfos.get(0);
	}

}
