package com.sdp.mc.service.newt0.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.bean.newt0.NewT0PromoterInfoServiceBean;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.facade.msp.MspFacade;
import com.sdp.mc.integration.msp.PromoterInfoDTO;
import com.sdp.mc.newt0.dao.NewT0AuditInfoDO;
import com.sdp.mc.service.AuditInfoService;
import com.sdp.mc.service.newt0.NewT0PromoterInfoService;

@Service
public class NewT0PromoterInfoServiceImpl implements NewT0PromoterInfoService {

	@Autowired
	private MspFacade mspFacade;
	@Autowired
	private AuditInfoService auditInfoService;

	@Override
	public NewT0PromoterInfoServiceBean getNewT0PromoterInfoServiceBeanByPromoterId(Long promoterId) {
		NewT0PromoterInfoServiceBean info = new NewT0PromoterInfoServiceBean();
		PromoterInfoDTO promoterInfoDTO = mspFacade.findPromoterInfoByPromoterId(promoterId);
		info.setPromoterInfoDTO(promoterInfoDTO);
		info.setFastSettleLimitFlag(promoterInfoDTO.getFastSettleFlag());
		// 查询审核状态
		List<NewT0AuditInfoDO> list = auditInfoService.queryNonAudited(null, promoterId, OpTypeEnums.ADD.code);
		info.setAuditFlag(list != null && list.size() != 0);
		return info;
	}
}
