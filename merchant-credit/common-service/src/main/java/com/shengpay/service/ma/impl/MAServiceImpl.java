package com.shengpay.service.ma.impl;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.enums.MarginAccountEnum;
import com.sdp.mc.integration.ma.dto.request.MACreateAccountRequestDTO;
import com.sdp.mc.integration.ma.dto.response.MACreateAccountResponseDTO;
import com.sdp.mc.ma.dao.MarginAccountRequestDO;
import com.sdp.mc.ma.dao.MarginAccountRequestDOExample;
import com.sdp.mc.ma.manager.MarginAccountRequestManager;
import com.shengpay.service.ma.MAService;
import com.shengpay.service.ma.MAServiceUtil;

@Service("MAService")
public class MAServiceImpl implements MAService {

	private static final Logger log = LoggerFactory.getLogger(MAServiceImpl.class);

	@Autowired
	private MarginAccountRequestManager marginAccountRequestManager;

	public Long insert(MACreateAccountRequestDTO req, String merchantNo) {
		MarginAccountRequestDO record = MAServiceUtil.buildMarginAccountRequestDO(req, merchantNo);
		Long id = this.marginAccountRequestManager.insertSelective(record);
		log.info("MAServiceImpl.insert.id=" + id + ",record=" + ToStringBuilder.reflectionToString(record));
		return id;
	}

	public boolean update(MACreateAccountRequestDTO req, MarginAccountRequestDO originalMerchantAccount) {
		MarginAccountRequestDO record = MAServiceUtil.buildMarginAccountRequestDO(req, originalMerchantAccount.getMerchantNo());
		record.setStatus(null);
		MarginAccountRequestDOExample example = new MarginAccountRequestDOExample();
		example.createCriteria().andIdEqualTo(originalMerchantAccount.getId()).andStatusEqualTo(originalMerchantAccount.getStatus());
		int rows = this.marginAccountRequestManager.updateByExampleSelective(record, example);
		log.info("MAServiceImpl.update.rows=" + rows + ",record=" + ToStringBuilder.reflectionToString(record));
		return rows == 1;
	}

	private boolean updateStatusById(Long id, MarginAccountEnum originalStatus, MACreateAccountResponseDTO res) {
		MarginAccountRequestDO record = MAServiceUtil.buildMarginAccountRequestDO(id, res);
		MarginAccountRequestDOExample example = new MarginAccountRequestDOExample();
		example.createCriteria().andIdEqualTo(id).andStatusEqualTo(originalStatus.code);
		int rows = marginAccountRequestManager.updateByExampleSelective(record, example);
		log.info("MAServiceImpl.updateStatusById.id=" + id + ",rows=" + rows + ",record=" + ToStringBuilder.reflectionToString(record));
		return rows == 1;
	}
	
	public boolean updateStatusFromInitById(Long id, MACreateAccountResponseDTO res) {
		return this.updateStatusById(id, MarginAccountEnum.INIT, res);
	}

	public boolean updateStatusFromFailueById(Long id, MACreateAccountResponseDTO res) {
		return this.updateStatusById(id, MarginAccountEnum.FAILUE, res);
	}
	
	public MarginAccountRequestDO getMarginAccountByMerchantNo(String merchantNo,AccountType accountType) {
		MarginAccountRequestDOExample example = new MarginAccountRequestDOExample();
		example.createCriteria().andMerchantNoEqualTo(merchantNo).andAccountTypeEqualTo(accountType.code);
		List<MarginAccountRequestDO> acctList = this.marginAccountRequestManager.selectByExample(example);
		if (acctList != null) {
			if (acctList.size() == 1) {
				return acctList.get(0);
			} else if (acctList.size() > 1) {
				throw new IllegalArgumentException("MAServiceImpl.getMarginAccountByMerchantNo.too.many.merchant.account.in.table,merchantNo=" + merchantNo);
			}
		}
		return null;
	}
}
