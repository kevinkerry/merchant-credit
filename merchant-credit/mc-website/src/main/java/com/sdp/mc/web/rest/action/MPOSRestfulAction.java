package com.sdp.mc.web.rest.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdp.mc.common.constant.MerchantContractCst;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.OpObjTypeEnums;
import com.sdp.mc.common.util.IPUtils;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.vo.MerchantFastSettleVO;
import com.sdp.mc.facade.msp.MspFacade;
import com.sdp.mc.ffconfig.dao.FastSettleConfigDO;
import com.sdp.mc.integration.msp.MerchantInfoDTO;
import com.sdp.mc.service.fastsettle.FastSettle;
import com.sdp.mc.web.vo.AppFastSettleRequest;
import com.sdp.mc.web.vo.AppFastSettleResponse;
import com.sdp.mc.web.vo.NFCOrder4AppRequest;
import com.sdp.mc.web.vo.NFCOrder4AppResponse;
import com.shengpay.pos.pcs.api.settle.StraightlyCfg;

@Controller
public class MPOSRestfulAction {
	private static final Log logger = LogFactory.getLog(MPOSRestfulAction.class);

	@Autowired
	private FastSettle fastSettle;
	@Autowired
	private MspFacade mspFacade;

	/**
	 * 提供给手机客户端下单,并生成token,前提是用户必须登录
	 * **/
	@RequestMapping(value = "/app/order")
	@ResponseBody
	public NFCOrder4AppResponse order(NFCOrder4AppRequest request, HttpServletRequest httpRequest) {
		logger.info("/app/order,ip=" + IPUtils.getClientIP(httpRequest) + ",request=" + request);
		return null;
	}

	/**
	 * 获取自动结算信息
	 */
	@RequestMapping(value = "/app/toSaveAutoFastSettle")
	@ResponseBody
	public AppFastSettleResponse toSaveAutoFastSettle(AppFastSettleRequest appFastSettleRequest, HttpServletRequest request) {
		String merchantId = appFastSettleRequest.getMerchantId();
		String merchantNo = appFastSettleRequest.getMerchantNo();
		String mcType = appFastSettleRequest.getMcType();

		if (StringUtils.isEmpty(merchantId)) {
			if (StringUtils.isEmpty(mcType) || StringUtils.isEmpty(merchantNo))
				return new AppFastSettleResponse(false, null, "merchantId or (merchantNo & mcType) is not null.");
		}

		if (StringUtils.isEmpty(merchantId)) {
			MerchantInfoDTO merchantInfoDTO = mspFacade.findMerchantInfoByMerchantNo(merchantNo, mcType);
			merchantId = merchantInfoDTO.getMerchantId();
		}

		FastSettleConfigDO fastSettleConfigDO;
		try {
			fastSettleConfigDO = fastSettle.getFastSettleConfig(Long.parseLong(merchantId), OpObjTypeEnums.MERCHANT.code);
		} catch (Exception e) {
			logger.error("MPOSRestfulAction #getAutoFastSettle:" + e);
			return new AppFastSettleResponse(false, null, e.toString());
		}
		AppFastSettleResponse response = new AppFastSettleResponse(true);
		response.setAutoFastSettle(fastSettleConfigDO.getAutoFastSettle().toString());
		response.setMcType(mcType);
		response.setMerchantId(merchantId);
		response.setMerchantNo(merchantNo);
		response.setSuccess(true);
		return response;
	}

	/**
	 * 申请自动结算
	 */
	@RequestMapping(value = "/app/saveAutoFastSettle")
	@ResponseBody
	public AppFastSettleResponse saveAutoFastSettle(AppFastSettleRequest appFastSettleRequest, HttpServletRequest request) {
		String merchantId = appFastSettleRequest.getMerchantId();
		String merchantNo = appFastSettleRequest.getMerchantNo();
		String mcType = appFastSettleRequest.getMcType();
		String autoFastSettle = appFastSettleRequest.getAutoFastSettle();

		if (StringUtils.isEmpty(merchantId)) {
			if (StringUtils.isEmpty(mcType) || StringUtils.isEmpty(merchantNo))
				return new AppFastSettleResponse(false, null, "merchantId or (merchantNo & mcType) is not null.");
		}

		if (StringUtils.isEmpty(autoFastSettle)) return new AppFastSettleResponse(false, null, "autoFastSettle is not null.");

		if (StringUtils.isEmpty(merchantId)) {
			MerchantInfoDTO merchantInfoDTO = mspFacade.findMerchantInfoByMerchantNo(merchantNo, mcType);
			merchantId = merchantInfoDTO.getMerchantId();
		}
		MerchantFastSettleVO fastSettleVO = new MerchantFastSettleVO();
		fastSettleVO.setMerchantId(merchantId);

		// 验证商户快速结算配置
		StraightlyCfg straightlyCfg = mspFacade.queryStraightlyCfg(Long.valueOf(merchantId));
		if (!straightlyCfg.isStraightFlag()) { return new AppFastSettleResponse(false, null, "对不起，你还未开通快速结算服务功能，请致电您的代理商为您开通"); }

		int autoSettle = MerchantCreditConstant.MERCHANT_AUTO_FASTSETTLE_OFF;
		FastSettleConfigDO fastSettleConfigDO = fastSettle.getFastSettleConfig(Long.parseLong(merchantId), OpObjTypeEnums.MERCHANT.code);
		if (fastSettleConfigDO != null)
			autoSettle = fastSettleConfigDO.getAutoFastSettle() == MerchantCreditConstant.MERCHANT_AUTO_FASTSETTLE_ON_LOANING_PROMOTER ? MerchantCreditConstant.MERCHANT_AUTO_FASTSETTLE_OFF
					: MerchantCreditConstant.MERCHANT_AUTO_FASTSETTLE_ON_LOANING_PROMOTER;

		fastSettleVO.setAutoFastSettle(autoSettle + "");
		fastSettleVO.setMerchantId(merchantId + "");

		ErrorMessageVO errorMessageVO = fastSettle.setMerchantAutoSettle(fastSettleVO,MerchantContractCst.SYSTEM_DEFAULT_USER);
		logger.info("MerchantAction #saveAutoSettleFast:" + errorMessageVO.toString());
		if (!errorMessageVO.isSuccess()) { return new AppFastSettleResponse(false, null, "系统异常，请联系技术人员解决"); }
		return new AppFastSettleResponse(true);

	}

}
