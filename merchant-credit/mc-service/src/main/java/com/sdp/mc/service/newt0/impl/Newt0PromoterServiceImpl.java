package com.sdp.mc.service.newt0.impl;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdp.mc.newt0.dao.Newt0PromoterDO;
import com.sdp.mc.newt0.dao.Newt0PromoterDOExample;
import com.sdp.mc.newt0.manager.Newt0PromoterManager;
import com.sdp.mc.service.newt0.Newt0PromoterService;

@Service("newt0PromoterService")
public class Newt0PromoterServiceImpl implements Newt0PromoterService {
	private Logger logger = LoggerFactory.getLogger(Newt0PromoterServiceImpl.class);

	@Autowired
	private Newt0PromoterManager newt0PromoterManager;

	@Override
	public Newt0PromoterDO getPromoterByMerchantId(Long promoterId) {
		return newt0PromoterManager.getPromoterByMerchantId(promoterId);
	}

	@Override
	public int updateByExampleSelective(Newt0PromoterDO record, Newt0PromoterDOExample example) {
		return newt0PromoterManager.updateByExampleSelective(record, example);
	}

	@Override
	public Long insertSelective(Newt0PromoterDO record) {
		return newt0PromoterManager.insertSelective(record);
	}

	@Override
	public Integer getLoaningTypeByPromoterId(Long promoterId) {
		Newt0PromoterDO promoterDO = newt0PromoterManager.getPromoterByMerchantId(promoterId);
		if (promoterDO == null)
			logger.error("Newt0PromoterServiceImpl #getLoaningTypeByPromoterId, promoterId:" + promoterId + ",loaningType is null.");
		return promoterDO == null ? null : promoterDO.getLoaningType();
	}

	@Override
	public int deleteByExample(Newt0PromoterDOExample example) {
		return newt0PromoterManager.deleteByExample(example);
	}

	@Override
	public int deleteByPromoterId(Long promoterId) {
		Newt0PromoterDOExample example = new Newt0PromoterDOExample();
		example.createCriteria().andPromoterIdEqualTo(promoterId);
		return newt0PromoterManager.deleteByExample(example);
	}

}
