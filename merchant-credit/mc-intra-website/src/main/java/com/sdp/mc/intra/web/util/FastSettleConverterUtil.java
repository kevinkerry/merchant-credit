package com.sdp.mc.intra.web.util;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sdo.common.util.DateUtil;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.OpObjTypeEnums;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.common.util.IPUtils;
import com.sdp.mc.common.util.MCAppVarPropsUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.integration.msp.PromoterInfoDTO;
import com.sdp.mc.integration.msp.request.MspModifyRequest;
import com.sdp.mc.margin.dao.MarginOpReqDOExample;
import com.sdp.mc.margin.dao.ext.MarginOpReqDOExampleExt;
import com.sdp.mc.service.op.state.OpContext;
import com.sdp.mc.service.op.state.OpStateResponse;

public class FastSettleConverterUtil {
	private static final Logger logger = LoggerFactory.getLogger(FastSettleConverterUtil.class);
	

	public static OpContext buildOpenAccountOpContext(PromoterInfoDTO promoterDTO, HttpServletRequest httpRequest) {
		MspModifyRequest request = new MspModifyRequest();
		request.setObjId(promoterDTO.getPromoterId());
		request.setObjType(OpObjTypeEnums.PROMOTER.code);
		request.setOpType(OpTypeEnums.OPEN.code);
		request.setPromoterId(promoterDTO.getPromoterId());
		request.setPromoterNo(promoterDTO.getPromoterNo());
		request.setPromoterType(promoterDTO.getPromoterType());
		// 开通
		request.setFastSettleFlag(1);
		OpContext context = new OpContext();
		context.setUserIp(IPUtils.getClientIP(httpRequest));
		context.setMspModifyRequest(request);
		return context;
	}

	/**
	 * 构建追加保证金对象
	 * **/
	public static OpContext buildAddMarginOpContext(PromoterInfoDTO promoterDTO, HttpServletRequest httpRequest) {
		String _amount = httpRequest.getParameter("amount");
		BigDecimal amount = new BigDecimal(_amount);

		MspModifyRequest request = new MspModifyRequest();
		request.setObjId(promoterDTO.getPromoterId());
		request.setObjType(OpObjTypeEnums.PROMOTER.code);
		request.setOpType(OpTypeEnums.ADD.code);
		request.setPromoterId(promoterDTO.getPromoterId());
		request.setPromoterNo(promoterDTO.getPromoterNo());
		request.setPromoterType(promoterDTO.getPromoterType());
		// 开通
		request.setFastSettleFlag(1);
		OpContext context = new OpContext();
		context.setUserIp(IPUtils.getClientIP(httpRequest));
		context.setMspModifyRequest(request);
		context.setAmount(amount);
		return context;
	}

	/**
	 * 构建取回保证金对象
	 * **/
	public static OpContext buildTakeBackMarginOpContext(PromoterInfoDTO promoterDTO, HttpServletRequest httpRequest) {
		String _amount = httpRequest.getParameter("amount");
		BigDecimal amount = new BigDecimal(_amount);
		MspModifyRequest request = new MspModifyRequest();
		request.setObjId(promoterDTO.getPromoterId());
		request.setObjType(OpObjTypeEnums.PROMOTER.code);
		request.setOpType(OpTypeEnums.OPEN.code);
		request.setPromoterId(promoterDTO.getPromoterId());
		request.setPromoterNo(promoterDTO.getPromoterNo());
		request.setPromoterType(promoterDTO.getPromoterType());
		// 开通
		request.setFastSettleFlag(1);
		OpContext context = new OpContext();
		context.setUserIp(IPUtils.getClientIP(httpRequest));
		context.setMspModifyRequest(request);
		context.setAmount(amount);
		return context;
	}

	public static MarginOpReqDOExampleExt buildMarginOpReqDOExample(HttpServletRequest request) {
		String opType = request.getParameter("opType");
		String marginStatus = request.getParameter("marginStatus");
		String createTimeStartStr = request.getParameter("createTimeStartStr");
		String createTimeEndStr = request.getParameter("createTimeEndStr");
		MarginOpReqDOExampleExt query = new MarginOpReqDOExampleExt();
		MarginOpReqDOExample.Criteria criteria = query.createCriteria();
		if (StringUtils.isNotBlank(opType)) {
			criteria.andOpTypeEqualTo(Integer.valueOf(opType));
		}
		if (StringUtils.isNotBlank(marginStatus)) {
			criteria.andStatusEqualTo(Integer.valueOf(marginStatus));
		}
		if (StringUtils.isNotBlank(createTimeStartStr)) {
			Date createTimeStart = DateUtil.parseDateNewFormat(createTimeStartStr);
			criteria.andCreateTimeGreaterThanOrEqualTo(createTimeStart);
		}
		if (StringUtils.isNotBlank(createTimeEndStr)) {
			Date createTimeEnd = DateUtil.parseDateNewFormat(createTimeEndStr);
			criteria.andCreateTimeLessThan(createTimeEnd);
		}
		return query;
	}

	public static ErrorMessageVO buildErrorMessageVO(OpStateResponse response) {
		if (response != null) {
			return new ErrorMessageVO(response.isSuccess(), response.getErrorCode(), response.getMessage());
		}
		return new ErrorMessageVO(false, "-1", "系统繁忙");
	}
	/**
	 * 格式化operting系统链接地址
	 * **/
	public static String formatOperatingURL(String relativeURLPattern) {
		String rootURL = MCAppVarPropsUtil.getStringProp(MerchantCreditConstant.OPERATING_ROOT_URL);
		return MessageFormat.format(relativeURLPattern, rootURL);
	}
}
