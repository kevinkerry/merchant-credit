package com.sdp.mc.ma.wrapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdo.ma.ws.api.model.OperatorInfo;
import com.sdo.ma.ws.api.model.OperatorWithProfileInfo;
import com.sdo.ma.ws.api.request.osr.GetOperatorsRequest;
import com.sdo.ma.ws.api.response.osr.GetOperatorsResponse;
import com.sdo.ma.ws.api.service.osr.IOperatorWS;
import com.sdp.mc.ma.wrapper.IOperatorWSServiceWrapper;
import com.sdp.mc.ma.wrapper.utils.MaOnlineUtil;

@Service
public class IOperatorWSServiceWrapperImpl implements IOperatorWSServiceWrapper{

	private static final Logger log = LoggerFactory.getLogger(IOperatorWSServiceWrapper.class);

	@Autowired
	private IOperatorWS operatorWSService;




	public void setOperatorWSService(IOperatorWS operatorWSService) {
		this.operatorWSService = operatorWSService;
	}



	@Override
	public List<OperatorInfo> queryOperators(String memberId) {
		log.info("queryOperators.memberId = " + memberId );
		GetOperatorsRequest request = MaOnlineUtil.buildGetOperatorsRequest(memberId);
		OperatorInfo operatorInfo = null;
		List<OperatorInfo> list = new ArrayList<OperatorInfo>();
		try {
			log.info("queryOperators.memberId = "+memberId, "request"+request);
			GetOperatorsResponse response  = operatorWSService.getOperators(request);
			log.info("queryOperators.memberId = "+memberId, "response"+response);
			if (response != null) {
				OperatorWithProfileInfo[] operatorWithProfileInfoList = response.getOperators();
				for (OperatorWithProfileInfo operatorWithProfileInfo : operatorWithProfileInfoList) {
					operatorInfo = operatorWithProfileInfo.getOperator();
					list.add(operatorInfo);
				}
			}
		} catch (Exception e) {
			log.error("queryOperators Exception",e);
		}
		return list;
	}

}
