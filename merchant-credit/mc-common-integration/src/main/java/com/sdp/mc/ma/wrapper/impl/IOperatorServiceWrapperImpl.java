package com.sdp.mc.ma.wrapper.impl;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.ma.request.impl.QueryOperatorMemberScopeRequest;
import com.sdp.mc.ma.response.impl.QueryOperatorMemberScopeResponse;
import com.sdp.mc.ma.service.IOperatorService;
import com.sdp.mc.ma.wrapper.IOperatorServiceWrapper;
import com.sdp.mc.ma.wrapper.utils.AuthUtil;

@Service("IOperatorServiceWrapper")
public class IOperatorServiceWrapperImpl implements IOperatorServiceWrapper {
	private static final Logger log = LoggerFactory.getLogger(IOperatorServiceWrapperImpl.class);
	@Autowired
	private IOperatorService operatorService;

	public void setOperatorService(IOperatorService operatorService) {
		this.operatorService = operatorService;
	}

	/**
	 * 查询操作员拥有数据权限范围的商户列表
     * 调用方：POS（java）
	 *
	 * @param operatorId
	 *            操作员id
	 * @return String[]
	 * **/
	public String[] queryMerchantNoByOperatorId(final String operatorId) {
		QueryOperatorMemberScopeRequest request = AuthUtil.buildQueryOperatorMemberScopeRequest(operatorId);
		log.info("IOperatorServiceWrapperImpl.queryMerchantNoByOperatorId.request=" + ToStringBuilder.reflectionToString(request));
		QueryOperatorMemberScopeResponse response = this.operatorService.QueryOperatorMemberScope(request);
		log.info("IOperatorServiceWrapperImpl.queryMerchantNoByOperatorId.response=" + ToStringBuilder.reflectionToString(response));
		if ("0".equals(response.getResponse().getResponseCode())) {
			return response.getMerchantNo();
		} else {
			return null;
		}
	}
	public String[] queryMerchantNoByOperators(final String operatorId) {
		QueryOperatorMemberScopeRequest request = AuthUtil.buildQueryOperatorMemberScopeRequest(operatorId);
		log.info("IOperatorServiceWrapperImpl.queryMerchantNoByOperatorId.request=" + ToStringBuilder.reflectionToString(request));
		QueryOperatorMemberScopeResponse response = this.operatorService.QueryOperatorMemberScope(request);
		log.info("IOperatorServiceWrapperImpl.queryMerchantNoByOperatorId.response=" + ToStringBuilder.reflectionToString(response));
		if ("0".equals(response.getResponse().getResponseCode())) {
			return response.getMerchantNo();
		} else {
			return null;
		}
	}
}
