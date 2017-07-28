package com.sdp.mc.newt0.manager;

import java.util.List;

import com.sdp.mc.newt0.dao.AuditInfoDTO;
import com.sdp.mc.newt0.dao.ExtNewT0AuditInfoDOExample;
import com.sdp.mc.newt0.dao.NewT0AuditInfoDO;
import com.sdp.mc.newt0.dao.NewT0AuditInfoDOExample;

public interface ExtNewT0AuditInfoManager extends NewT0AuditInfoManager{
	int updateByExampleSelective(NewT0AuditInfoDO record, NewT0AuditInfoDOExample example);
	/**
	 * 有多少条记录
	 * @param example
	 * @return
	 */
	Integer countByExample(NewT0AuditInfoDOExample example);
	
	List<AuditInfoDTO> selectAuditInfoByQuery(ExtNewT0AuditInfoDOExample example);
	List<AuditInfoDTO> selectAuditInfoByExample(ExtNewT0AuditInfoDOExample example);
	
	AuditInfoDTO selectAuditedTempLimitInfoByMerchantInfo(String merchantNo, String mcType);
}
