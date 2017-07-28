package com.shengpay.service.ma;

import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.integration.ma.dto.request.MACreateAccountRequestDTO;
import com.sdp.mc.integration.ma.dto.response.MACreateAccountResponseDTO;
import com.sdp.mc.ma.dao.MarginAccountRequestDO;

public interface MAService {
	/**
	 * 插入保证金账户请求记录
	 * **/
	public Long insert(MACreateAccountRequestDTO req, String merchantNo);
	
	public boolean update(MACreateAccountRequestDTO req, MarginAccountRequestDO originalMerchantAccount);
	
	public boolean updateStatusFromInitById(Long id, MACreateAccountResponseDTO res);
	
	public boolean updateStatusFromFailueById(Long id, MACreateAccountResponseDTO res);
	
	public MarginAccountRequestDO getMarginAccountByMerchantNo(String merchantNo,AccountType accountType);
}
