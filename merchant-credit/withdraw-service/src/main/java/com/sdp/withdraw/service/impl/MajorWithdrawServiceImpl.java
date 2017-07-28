package com.sdp.withdraw.service.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.withdraw.ProductCodeEnums;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.util.MD5Digest;
import com.sdp.mc.withdraw.IPaymentFacade;
import com.sdp.mc.withdraw.entity.ObjectFactory;
import com.sdp.mc.withdraw.entity.WithdrawQueryRequest;
import com.sdp.mc.withdraw.entity.WithdrawQueryResponse;
import com.sdp.mc.withdraw.entity.WithdrawQueryResult;
import com.shengpay.commom.config.GlobalConfig;

/**
 * 查询mpos专业版提现记录
 * 
 * @author liutao
 * 
 */
//@Service("majorWithdrawServiceImpl")
public class MajorWithdrawServiceImpl {
	// private Logger logger =
	// LoggerFactory.getLogger(MajorWithdrawServiceImpl.class);
	private Logger logger = LoggerFactory.getLogger(MajorWithdrawServiceImpl.class);
	private static final String md5Key = GlobalConfig.getString("withdraw.majorPayment.key", "XYZ!@#$123ABC.h");
	private static final String mjorQueryZfcode = GlobalConfig.getString("mjorQueryZfcode", "zf628");
	@Resource
	IPaymentFacade paymentFacade;

	public List<WithdrawQueryResult> query(String merchantNo, Date beginTime, Date endTime, int pageNo, int pageSize) throws RemoteException,
			UnknownHostException {
		logger.info("majorWithdrawServiceImpl#query,merchantNo:{},beginTIme:{},endTime:{},pageNo:{},pageSize:{}", new Object[] { merchantNo,
				beginTime, endTime, pageNo, pageSize });
		WithdrawQueryRequest request = new WithdrawQueryRequest();
		ObjectFactory o = new ObjectFactory();
		request.setAppID(o.createIRequestAppID(mjorQueryZfcode));
		request.setProductCode(o.createIRequestProductCode(ProductCodeEnums.T0_MPOS_Withdraw.getProductCode()));
		request.setRequestTime(convert(new Date()));
		InetAddress ia = InetAddress.getLocalHost();
		String localip = ia.getHostAddress();
		request.setClientIP(o.createIRequestClientIP(localip));
		request.setBeginTime(o.createWithdrawQueryRequestBeginTime(DateUtil.formatDate(beginTime, "yyyy-MM-dd 00:00:00")));
		request.setEndTime(o.createWithdrawQueryRequestEndTime(DateUtil.formatDate(endTime, "yyyy-MM-dd 23:59:59")));
		request.setIsNeedBankDetail(true);
		request.setPageNo(pageNo);
		request.setPageSize(pageSize);
		request.setUserID(o.createWithdrawQueryRequestUserID(merchantNo));
		request.setMACString(o.createWithdrawQueryRequestMACString(getMac(request)));
		// logger.info("MajorWithdrawServiceImpl#request"+JSON.toJSONString(request));
		logger.info("query,request:{}", ToStringBuilder.reflectionToString(request, ToStringStyle.SHORT_PREFIX_STYLE));
		WithdrawQueryResponse response = (WithdrawQueryResponse) paymentFacade.query(request);
		logger.info("query,response:{}", ToStringBuilder.reflectionToString(response, ToStringStyle.SHORT_PREFIX_STYLE));
		if (0 == response.getRetCode()) {
			if (response.getResult() == null || response.getResult().getValue() == null) {
				return null;
			} else {
				return response.getResult().getValue().getWithdrawQueryResult();
			}
		} else {
			throw new RemoteException("paymentFacade" + response.getRetCode() + response.getMessage().toString());
		}
	}

	private String getMac(WithdrawQueryRequest request) {
		// AppID+UserID+"2012-05-29 14:50:10"+MD5Key
		StringBuffer sb = new StringBuffer();
		sb.append(request.getAppID().getValue());
		sb.append(request.getUserID().getValue());
		Date date = request.getRequestTime().toGregorianCalendar().getTime();
		sb.append(DateUtil.formatDate(date, DateUtil.default_pattern));
		sb.append(md5Key);
		String result = MD5Digest.getDigestString(sb.toString());
		return result;

	}

	private XMLGregorianCalendar convert(Date date) {
		DatatypeFactory dataTypeFactory;
		try {
			dataTypeFactory = DatatypeFactory.newInstance();
		} catch (DatatypeConfigurationException e) {
			throw new RuntimeException(e);
		}
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(date.getTime());
		return dataTypeFactory.newXMLGregorianCalendar(gc);
	}

}
