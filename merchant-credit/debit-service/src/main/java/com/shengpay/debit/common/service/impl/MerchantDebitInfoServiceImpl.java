package com.shengpay.debit.common.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shengpay.debit.common.enums.DebitOrganizationEnum;
import com.shengpay.debit.common.service.MerchantDebitInfoService;
import com.shengpay.debit.dal.dataobject.DmMerchantDebitInfoExample;
import com.shengpay.debit.dal.dataobject.DmMerchantDebitInfoPO;
import com.shengpay.debit.ext.daointerface.ExtDmMerchantDebitInfoDAO;
import com.shengpay.debit.merchant.account.enums.DebitAccountEnums;

/**
 * POS商户负债信息表相关操作
 * 
 * @author wangjingao.william
 * **/
@Service
public class MerchantDebitInfoServiceImpl implements MerchantDebitInfoService {

	@Autowired
	private ExtDmMerchantDebitInfoDAO extDmMerchantDebitInfoDAO;

	public DmMerchantDebitInfoPO selectMerchantDebitInfoByMerchantNo(String merchantNo, DebitOrganizationEnum org) {
		DmMerchantDebitInfoExample example = new DmMerchantDebitInfoExample();
		example.createCriteria().andMerchantNoEqualTo(merchantNo).andOrganizationCodeEqualTo(org.code);
		List<DmMerchantDebitInfoPO> list = this.extDmMerchantDebitInfoDAO.selectByExample(example);
		if (list != null) {
			if (list.size() > 1) { throw new RuntimeException("one merchantNo maps to too many records"); }
			return list.get(0);
		}
		return null;

	}

	/**
	 * 逾期还款后恢复借款申请权限
	 * 
	 * @param merchantNo商户号
	 * @param amount借款本金
	 * @param overdueInterest逾期利息
	 * @param org放款机构
	 * **/
	public boolean recoverBorrowMoney(String merchantNo, DebitOrganizationEnum org, BigDecimal amount, BigDecimal overdueInterest) {
		int rows = this.extDmMerchantDebitInfoDAO.recoverBorrowMoney(merchantNo, DebitAccountEnums.DEBIT_OVER_DUE.getKey(), org.code, amount,
				overdueInterest);
		return rows == 1;
	}

	/**
	 * 更新状态至逾期
	 * 
	 * @author wangjingao.william
	 * **/
	public boolean updateStatus2OverdueById(long id) {
		DmMerchantDebitInfoPO record = new DmMerchantDebitInfoPO();
		record.setStatus(DebitAccountEnums.DEBIT_OVER_DUE.getKey());
		DmMerchantDebitInfoExample example = new DmMerchantDebitInfoExample();
		example.createCriteria().andIdEqualTo(id).andStatusEqualTo(DebitAccountEnums.ACCOUNT_CAN_USE.getKey());
		int rows = this.extDmMerchantDebitInfoDAO.updateByExampleSelective(record, example);
		return rows == 1;
	}

	/**
	 * 累加逾期利息
	 * 
	 * @param merchantNo
	 *            商户号
	 * @param overdueInterest
	 *            每日的逾期利息
	 * **/
	public boolean addOverdueInterest(String merchantNo, BigDecimal overdueInterest) {
		int rows = this.extDmMerchantDebitInfoDAO.addOverdueInterest(merchantNo, overdueInterest);
		return rows == 1;
	}
}
