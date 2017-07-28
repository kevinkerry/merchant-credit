package com.sdp.withdraw.service.impl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.withdraw.dao.WithdrawReqExtraInfoDO;
import com.sdp.withdraw.manager.WithdrawReqExtraInfoManager;
import com.sdp.withdraw.service.WithdrawReqExtraInfoService;

@Service("WithdrawReqExtraInfoService")
public class WithdrawReqExtraInfoServiceImpl  implements WithdrawReqExtraInfoService {
	private Logger logger = LoggerFactory.getLogger(WithdrawReqExtraInfoServiceImpl.class);
    
	@Autowired
	private WithdrawReqExtraInfoManager withdrawReqExtraInfoManager;
	
	@Override
	public Long createPostPaidExtraInfo(Long reqId,BigDecimal initWithdrawAmount){
		logger.info("createPostPaidExtraInfo init,reqId:"+reqId+", initWithdrawAmount:"+initWithdrawAmount);
		WithdrawReqExtraInfoDO info=new WithdrawReqExtraInfoDO();
		info.setReqId(reqId);
		info.setPostPaidFlag(1);
		info.setInitWithdrawAmount(initWithdrawAmount);
		return withdrawReqExtraInfoManager.insert(info);
	}

}
