package com.shengpay.debit.common.service;

import java.math.BigDecimal;

import com.shengpay.debit.common.enums.DebitOrganizationEnum;
import com.shengpay.debit.dal.dataobject.DmMerchantDebitInfoPO;

public interface MerchantDebitInfoService {

	/**
	 * 根据商户号查询负债表
	 * 
	 * @param merchantNo
	 *            商户号
	 * @param org
	 *            放款机构
	 * **/
	public DmMerchantDebitInfoPO selectMerchantDebitInfoByMerchantNo(String merchantNo, DebitOrganizationEnum org);

	/**
	 * 逾期还款后恢复借款申请权限
	 * 
	 * @param merchantNo
	 *            商户号
	 * @param amount
	 *            借款本金
	 * @param overdueInterest
	 *            逾期利息
	 * @param org
	 *            放款机构
	 * 
	 * **/
	public boolean recoverBorrowMoney(String merchantNo, DebitOrganizationEnum org, BigDecimal amount, BigDecimal overdueInterest);
	
	/**
	 * 更新状态至逾期
	 * 
	 * @author wangjingao.william
	 * **/
	public boolean updateStatus2OverdueById(long id);
	
	/**
	 * 累加逾期利息
	 * 
	 * @param merchantNo
	 *            商户号
	 * @param overdueInterest
	 *            每日的逾期利息
	 * **/
	public boolean addOverdueInterest(String merchantNo, BigDecimal overdueInterest);

}
