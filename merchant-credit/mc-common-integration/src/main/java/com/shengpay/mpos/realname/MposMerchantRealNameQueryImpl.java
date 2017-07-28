package com.shengpay.mpos.realname;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.util.MD5Digest;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.vo.MCProductInfo;
import com.shengpay.boss.service.crm.query.api.ContractQueryService;
import com.shengpay.boss.service.crm.query.api.model.ProductInfo;
import com.shengpay.boss.service.crm.query.api.model.ProductQueryRequest;
import com.shengpay.boss.service.crm.query.api.model.ProductQueryResponse;
import com.shengpay.commons.core.utils.DateTimeUtils;
import com.shengpay.boss.service.crm.query.api.model.RetHeader;
@Service
public class MposMerchantRealNameQueryImpl implements MposMerchantRealNameQuery {
	private static final Logger logger = LoggerFactory.getLogger(MposMerchantRealNameQueryImpl.class);
	@Autowired
	ContractQueryService cntractQueryService;

	@Value("${mpos.realname.md5.key}")
	private String realNameMD5Key;

	/**
	 * 商户签约产品查询
	 * @param merchantNo
	 * @return
	 */
	public ErrorMessageVO<Object> cntractQueryService(String merchantNo,String zfCode){
		logger.info("MposMerchantRealNameQuery#cntractQueryService init merchantNo:"+merchantNo);
		ErrorMessageVO<Object> vo = new ErrorMessageVO<Object>(false);
		ProductQueryRequest request=new ProductQueryRequest();
		SimpleDateFormat orderFormat = new SimpleDateFormat("yyyyMMddHHmmsss");
		String requestID=orderFormat.format(new Date());
		Map<String,Object> map=new HashMap<String, Object>();
		try {
			request.setAppId(zfCode);
			request.setRequestId(requestID);
			request.setRequestTime(DateTimeUtils.formatFull2Date(new Date()));
			request.setMerchantId(merchantNo);
			String macorg = zfCode + requestID+ request.getRequestTime() +realNameMD5Key;
			logger.info("MposMerchantRealNameQuery#cntractQueryService.macorg:" + macorg);
			String macresutlt = MD5Digest.getDigestString(macorg);
			request.setMac(macresutlt);
			logger.info("MposMerchantRealNameQuery#cntractQueryService.macresutlt:" + macresutlt);
			JSONObject jsonRequest = JSONObject.fromObject(request);
			logger.info("MposMerchantRealNameQuery#cntractQueryService.jsonRequest:" + jsonRequest);
			ProductQueryResponse response=cntractQueryService.queryProductByMerchantId(request);
			JSONObject jsonResponse = JSONObject.fromObject(response);
			logger.info("MposMerchantRealNameQuery#cntractQueryService.jsonResponse:" + jsonResponse);
			if(response==null){
				vo.setSuccess(false);
				vo.setErrorCode("-99");
				vo.setErrorMessage("MposMerchantRealNameQuery#cntractQueryService.response.is null" );
				return vo;
			}
			RetHeader hander=response.getHeader();
			if(hander==null){
				vo.setSuccess(false);
				vo.setErrorCode("-99");
				vo.setErrorMessage("MposMerchantRealNameQuery#cntractQueryService.response.hander is null" );
				return vo;
			}
			if(hander.getRetCode()==0){
				vo.setSuccess(true);
				vo.setErrorCode("0");
				vo.setErrorMessage(hander.getRetMsg());
				ProductInfo[] products=response.getProducts();
				if(null!=products){
					MCProductInfo[] minfos=new MCProductInfo [products.length];
					for (int i = 0; i < products.length; i++) {
						MCProductInfo mcInfo=new MCProductInfo();
						mcInfo.setBizCode(products[i].getBizCode());
						mcInfo.setPayCode(products[i].getPayCode());
						mcInfo.setProductCode(products[i].getProductCode());
						mcInfo.setEndTime(DateUtil.date2DateStr(products[i].getEndTime()));
						mcInfo.setBeginTime(DateUtil.date2DateStr(products[i].getBeginTime()));
						minfos[i]=mcInfo;
					}
					map.put("products", minfos);
				}

				vo.setParams(map);
			}else{
				vo.setSuccess(false);
				vo.setErrorCode(hander.getRetCode().toString());
				vo.setErrorMessage(hander.getRetMsg());
			}
		} catch (Exception e) {
			logger.error("MposMerchantRealNameQuery#cntractQueryService is error",e);
			vo.setSuccess(false);
			vo.setErrorCode("-99");
			vo.setErrorMessage("MposMerchantRealNameQuery#cntractQueryService is error " );
			return vo;
		}
		return vo;
	}

}
