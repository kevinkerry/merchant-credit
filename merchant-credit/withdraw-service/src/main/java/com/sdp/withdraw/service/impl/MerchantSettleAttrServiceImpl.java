package com.sdp.withdraw.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.withdraw.dao.MerchantSettleAttrDO;
import com.sdp.withdraw.dao.MerchantSettleAttrDOExample;
import com.sdp.withdraw.manager.MerchantSettleAttrManager;
import com.sdp.withdraw.service.MerchantSettleAttrService;

@Service("MerchantSettleAttrService")
public class MerchantSettleAttrServiceImpl implements MerchantSettleAttrService {
	private Logger logger = LoggerFactory
			.getLogger(MerchantSettleAttrServiceImpl.class);
   @Autowired
	private MerchantSettleAttrManager merchantSettleAttrManager;
	
	@Override
	public Long createMerchantSettleInfo(Integer settleType, String merchantNo, String merchantType, Long bizId, Date openDate) {
		logger.info("createMerchantSettleInfo init,settleType"+settleType+",merchantNo"+merchantNo+" ,merchantType"+merchantType);
		MerchantSettleAttrDO info=getMerchantSettleInfo(settleType, bizId);
		if(info==null){
			info=new MerchantSettleAttrDO();
			info.setBizId(bizId);
			info.setBizType(settleType);
			info.setCreateTime(new Date());
			info.setFirstOpenTime(openDate);
			info.setMerchantNo(merchantNo);
			info.setMerchantType(merchantType);
			return merchantSettleAttrManager.insert(info);
		}
		return info.getId();
	}

	private MerchantSettleAttrDO getMerchantSettleInfo(Integer settleType, Long bizId) {
		MerchantSettleAttrDOExample example=new MerchantSettleAttrDOExample();
		example.createCriteria().andBizIdEqualTo(bizId).andBizTypeEqualTo(settleType);
		List<MerchantSettleAttrDO> list=merchantSettleAttrManager.selectByExample(example);
		if(list!=null&&!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

}
