package com.shengpay.debit.daotest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.shengpay.debit.dal.dataobject.DbNormalSettingPO;
import com.shengpay.debit.dal.dataobject.DoTransferLogPO;
import com.shengpay.debit.dal.ext.dataobject.ExtDoMerchantDebitOrderExample;
import com.shengpay.debit.ext.daointerface.ExtDbNormalSettingDAO;
import com.shengpay.debit.ext.daointerface.ExtDmMerchantDebitInfoDAO;
import com.shengpay.debit.ext.daointerface.ExtDoMerchantDebitOrderDAO;
import com.shengpay.debit.ext.daointerface.ExtDoTransferLogDAO;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-dao-test.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional("debitTransactionManager")
public class ExtFmBenifitAccountDetailDAOImplTest {

	@Autowired
	private ExtDbNormalSettingDAO detailDAO;
	@Autowired
	private ExtDoTransferLogDAO extDoTransferLogDAO;
	@Autowired
	private ExtDoMerchantDebitOrderDAO extDoMerchantDebitOrderDAO;
	@Autowired
	private ExtDmMerchantDebitInfoDAO dmMerchantDebitInfoDAO;
	//@Test
	public void testIsProcessedBenefitAccount() {
		DbNormalSettingPO po = detailDAO.selectByPrimaryKey(1l);
		if (po == null) {
			System.out.println("1");
		}
	}
	//@Test
	public void testExtDoTransferLogDAO() {
		DoTransferLogPO record = this.extDoTransferLogDAO.selectByPrimaryKey(1L);
		System.out.println(record);
	}

	//@Test
	public void testExtDoMerchantDebitOrderDAO() {
		ExtDoMerchantDebitOrderExample query = new ExtDoMerchantDebitOrderExample();
		List<String> statusList = new ArrayList<String>();
		statusList.add("1");
		statusList.add("2");
		query.setStatusList(statusList);
		this.extDoMerchantDebitOrderDAO.pageQueryMerchantDebitOrder(query);
	}
	@Test
	public void testdmMerchantDebitInfoDAO() {
		int rows = this.dmMerchantDebitInfoDAO.freezeMerchantDebit("700797", "100", BigDecimal.valueOf(1000));
		System.out.println("====================row====="+rows);
	}
	
}
