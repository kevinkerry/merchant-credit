package com.sdp.mc.wallet.web;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.enums.withdraw.WalletWithdrawApplyStatusEnums;
import com.sdp.mc.common.enums.withdraw.WalletWithdrawStatusEnums;
import com.sdp.mc.common.exception.WalletWithdrawRequestException;
import com.sdp.mc.view.dao.ViewMerchantInfoDTO;
import com.sdp.withdraw.dao.WalletWithdrawReqDO;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.sdp.withdraw.enums.ReturnCodeEnums;
import com.sdp.withdraw.vo.wallet.WalletWithdrawQueryRequest;
import com.sdp.withdraw.vo.wallet.WalletWithdrawQueryResponse;
import com.sdp.withdraw.vo.wallet.WalletWithdrawRequest;
import com.sdp.withdraw.vo.wallet.WalletWithdrawResponse;
import com.sdp.withdraw.vo.wallet.WalletWithdrawResult;
import com.shengpay.commons.core.utils.StringUtils;
import com.shengpay.service.view.MerchantInfoService;
import com.shengpay.service.withdraw.wallet.WalletWithdrawService;
import com.shengpay.service.withdraw.wallet.worker.WalletWithdrawHandler;
import com.shengpay.service.withdraw.wallet.worker.WalletWithdrawServiceCallbackHandler;

/**
 *
 * @author liyantao
 *
 */
@Controller
@RequestMapping(value = { "/wallet/withdraw" })
public class WalletWithdrawAction {
	private Logger logger = LoggerFactory.getLogger(WalletWithdrawAction.class);
	@Autowired
	private WalletWithdrawService walletWithdrawService;
	@Autowired
	private MerchantInfoService merchantInfoService;
	@Autowired
	private WalletWithdrawHandler walletWithdrawHandler;
	@Autowired
	private WalletWithdrawServiceCallbackHandler walletWithdrawServiceCallbackHandler;

	@RequestMapping(value="/test",method= RequestMethod.GET)
	public String test(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		return "/test/index";
	}

	@RequestMapping(method= RequestMethod.POST,value="/apply")
	@ResponseBody
	public WalletWithdrawResponse applyWithdraw(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			WalletWithdrawRequest walletWithdrawRequest) {
		logger.info("applyWithdraw init,walletWithdrawRequest:{}",ToStringBuilder.reflectionToString(walletWithdrawRequest, ToStringStyle.SHORT_PREFIX_STYLE));
		WalletWithdrawResponse res = new WalletWithdrawResponse(WalletWithdrawApplyStatusEnums.SUCCESS.code);
		try {
			// 数据校验
			dataValidate(walletWithdrawRequest);
			res.setOrderNo(walletWithdrawRequest.getOrderNo());
			// 幂等重复校验
			walletWithdrawService.checkRequestUnqiue(walletWithdrawRequest.getAppId(), walletWithdrawRequest.getOrderNo());
			// 入库
			WalletWithdrawReqDO reqDo=walletWithdrawService.createWalletWithdrawData(walletWithdrawRequest);
			logger.info("applyWithdraw insert db ,WalletWithdrawReqDO:{}",ToStringBuilder.reflectionToString(reqDo, ToStringStyle.SHORT_PREFIX_STYLE));
			// 判断是否需要出款
			logger.info("applyWithdraw ,memberNo:{},memberType:{},easypayType equals memberType:{}",new Object[]{walletWithdrawRequest.getMemberNo(),walletWithdrawRequest.getMemberType(),PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(walletWithdrawRequest.getMemberType())});
			if (PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(walletWithdrawRequest.getMemberType())
					|| PosMerchantTypeEnums.POS_MERCHANT.code.equals(walletWithdrawRequest.getMemberType())
					|| PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(walletWithdrawRequest.getMemberType())
					) {
				ViewMerchantInfoDTO merchantInfo= merchantInfoService.queryMerchantInfoByMerchantNo(walletWithdrawRequest.getMemberNo(), walletWithdrawRequest.getMemberType());
				logger.info("applyWithdraw query merchantInfo:{}",ToStringBuilder.reflectionToString(merchantInfo, ToStringStyle.SHORT_PREFIX_STYLE));
				if(merchantInfo==null){
					throw new WalletWithdrawRequestException(ReturnCodeEnums.FW_MERCHANT_NOTFOUND.code,ReturnCodeEnums.FW_MERCHANT_NOTFOUND.msg);
				}
				if(MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN_INT==merchantInfo.getAutoFastSettleFlag()){
					logger.info("applyWithdraw call Wallet withdraw thread");
					walletWithdrawHandler.execute(reqDo,WithdrawConstant.withdrawTypeRealTime);
				}else{
					logger.info("applyWithdraw not apply auto withdraw ,memberNo:{},memberType:{}",new Object[]{walletWithdrawRequest.getMemberNo(),walletWithdrawRequest.getMemberType()});
				}
			}else{
				logger.info("applyWithdraw not apply auto withdraw ,memberType not ,memberNo:{},memberType:{}",new Object[]{walletWithdrawRequest.getMemberNo(),walletWithdrawRequest.getMemberType()});
			}
		} catch (WalletWithdrawRequestException e) {
			logger.info("applyWithdraw WalletWithdrawRequestException,Exception:{}",ToStringBuilder.reflectionToString(e, ToStringStyle.SHORT_PREFIX_STYLE));
			res.setStatus(WalletWithdrawApplyStatusEnums.FAIL.code);
			res.setErrorCode(e.getErrorCode());
			res.setErrorMsg(e.getErrorMessage());
		}catch (Exception e) {
			logger.error("applyWithdraw Exception,Exception:{}",ToStringBuilder.reflectionToString(e, ToStringStyle.SHORT_PREFIX_STYLE),e);
			res.setStatus(WalletWithdrawApplyStatusEnums.FAIL.code);
			res.setErrorCode(ReturnCodeEnums.FW_UNKOWN_ERROR.code);
			res.setErrorMsg(ReturnCodeEnums.FW_UNKOWN_ERROR.msg);
		}
		logger.info("applyWithdraw end,WalletWithdrawResponse:{}",ToStringBuilder.reflectionToString(res, ToStringStyle.SHORT_PREFIX_STYLE));
		// 返回
		return res;
	}
	@RequestMapping(method= RequestMethod.POST,value="/callback")
	public void callback(ModelMap model, HttpServletRequest request, HttpServletResponse response,String appId,String orderNo,Integer status,Long traceNo) {
		logger.info("callback init,appId:{},orderNo:{},status:{}",new Object[]{appId,orderNo,status});
		if(StringUtils.isBlank(appId)
				||StringUtils.isBlank(orderNo)
				||status==null
				||(WalletWithdrawStatusEnums.SUCCESS.code!=status&&WalletWithdrawStatusEnums.FAIL.code!=status)){
			logger.info("callback end, not callback update");
			return;
		}
		WalletWithdrawReqDO reqDo=walletWithdrawService.getWalletWithdrawReqDO(appId, orderNo);
		if(reqDo==null){
			logger.info("callback ,appId:{},orderNo:{},not exists data");
			return;
		}
		if(WalletWithdrawStatusEnums.SUCCESS.code==reqDo.getStatus()){
			logger.info("callback ,appId:{},orderNo:{},Status  is success");
			return;
		}
		int row=walletWithdrawService.updateDataStatus(reqDo.getReqId(), status, traceNo);
		logger.info("callback updateDataStatus row:{}",row);
		walletWithdrawServiceCallbackHandler.execute(reqDo.getReqId());
		logger.info("callback finish!");
	}

	
	private void dataValidate(WalletWithdrawRequest walletWithdrawRequest) {
		Map<String, String> vaildateRequiredMap = new HashMap<String, String>();
		vaildateRequiredMap.put("appId", "应用ID ");
		vaildateRequiredMap.put("orderNo", "业务订单号 ");
		vaildateRequiredMap.put("memberNo", "出款账户号 ");
		vaildateRequiredMap.put("memberType", "出款账户类型");
		vaildateRequiredMap.put("withdrawAmount", "可出款金额");
		vaildateRequiredMap.put("originalAmount", "收单原始金额");
		vaildateRequiredMap.put("signature", "请求签名");
		String errorCode= vaildateServiceRequestRequired(walletWithdrawRequest, vaildateRequiredMap);
		if(StringUtils.notBlank(errorCode)
				||!walletWithdrawRequest.getSignStr(WithdrawConstant.MD5key).equalsIgnoreCase(walletWithdrawRequest.getSignature())){
			throw new WalletWithdrawRequestException(ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.code, ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.msg);
		}
		if(walletWithdrawRequest.getOriginalAmount().compareTo(walletWithdrawRequest.getWithdrawAmount())<0){
			logger.info("#dataValidate OriginalAmount:{} < WithdrawAmount:{}",new Object[]{walletWithdrawRequest.getOriginalAmount(),walletWithdrawRequest.getWithdrawAmount()});
			throw new WalletWithdrawRequestException(ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.code, ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.msg);
		}
	}

	private String vaildateServiceRequestRequired(Object walletWithdrawRequest, Map<String, String> vaildateRequiredMap) {
		if (walletWithdrawRequest != null) {
			if (vaildateRequiredMap != null) {
				for (Iterator<String> it = vaildateRequiredMap.keySet().iterator(); it.hasNext();) {
					String key = it.next();
					Object obj = getObjectFieldName(walletWithdrawRequest, key);
					if (obj == null || StringUtils.isBlank(obj.toString())) {
						logger.info("#vaildateServiceRequestRequired is not pass:"
								+ ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.msg + vaildateRequiredMap.get(key) + " is NULL");
						return ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.code;
					}
				}
			}
		} else {
			logger.info("WithdrawT0ServiceServiceImpl #vaildateWithdrawServiceRequestDTO:{}" , ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.msg
					+ "服务请求数据NULL");
			return ReturnCodeEnums.FW_DATA_FORMAT_VALIDATION_FAILS.code;
		}

		return null;
	}

	public Object getObjectFieldName(Object object, String fieldName) {
		// 获得对象类型
		try {
			Class classType = object.getClass();
			String firstLetter = fieldName.substring(0, 1).toUpperCase(); // 获得和属性对应的getXXX()方法的名字
			String getMethodName = "get" + firstLetter + fieldName.substring(1); // 获得和属性对应的getXXX()方法的名字
			Method getMethod = classType.getMethod(getMethodName, new Class[] {}); // 获得和属性对应的getXXX()方法
			if (getMethod != null) { return getMethod.invoke(object, new Object[] {});}
		} catch (Exception e) {

		}
		return null;
	}

	@RequestMapping(value="/query", method = RequestMethod.POST)
	@ResponseBody
	public WalletWithdrawQueryResponse queryWithdraw(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			WalletWithdrawQueryRequest walletWithdrawQueryRequest) {
		logger.info("queryWithdraw,walletWithdrawQueryRequest:{}", ToStringBuilder.reflectionToString(walletWithdrawQueryRequest, ToStringStyle.SHORT_PREFIX_STYLE));
		WalletWithdrawQueryResponse res=null;
		try {
			if(walletWithdrawQueryRequest.getPageNo()==null||walletWithdrawQueryRequest.getPageNo()<1){
				walletWithdrawQueryRequest.setPageNo(1);
			}
			if(walletWithdrawQueryRequest.getPageSize()==null||walletWithdrawQueryRequest.getPageSize()<1){
				walletWithdrawQueryRequest.setPageSize(10);
			}
			res = walletWithdrawService.queryWalletWithdrawInfo(walletWithdrawQueryRequest);
		}catch(Exception e){
			logger.error("queryWithdraw Exception",e);
			res=new WalletWithdrawQueryResponse(new ArrayList<WalletWithdrawResult>(), 0);
		}
		logger.info("queryWithdraw,WalletWithdrawQueryResponse:{}", ToStringBuilder.reflectionToString(res, ToStringStyle.SHORT_PREFIX_STYLE));
		return res;

			
	}

}
