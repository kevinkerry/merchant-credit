package com.sdp.mc.fos.fundout.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.fos.baseservice.FundoutBankQueryFacade;
import com.sdp.fos.baseservice.enums.CompanyOrPersonal;
import com.sdp.fos.baseservice.model.FundoutBankQueryResult;
import com.sdp.mc.fos.fundout.FundoutBankHelper;
import com.sdp.mc.fos.fundout.FundoutBankService;

/**
 * 出款银行
 * 
 */
@Service("fundoutBankService")
public class FundoutBankServiceImpl implements FundoutBankService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 出款的银行查询接口
	 */
	@Autowired
	private FundoutBankQueryFacade fundoutBankQueryFacade;

	/**
	 * 初始化银行列表
	 */
	@PostConstruct
	public void initAllFundoutBank() {
		{
			FundoutBankQueryResult companyResult = fundoutBankQueryFacade.getAvailableBankList(CompanyOrPersonal.COMPANY);
			FundoutBankHelper.initAllCompanyBankList(companyResult.getBanks());
			logger.info("----FundoutBank initAllFundoutBank(COMPANY) complete, size:" + companyResult.getBanks().size());
		}

		{
			FundoutBankQueryResult personalResult = fundoutBankQueryFacade.getAvailableBankList(CompanyOrPersonal.PERSONAL);
			FundoutBankHelper.initAllPersonalBankList(personalResult.getBanks());
			logger.info("----FundoutBank initAllFundoutBank(PERSONAL) complete, size:" + personalResult.getBanks().size());
		}
	}

}
