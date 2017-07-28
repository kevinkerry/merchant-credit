package com.sdp.mc.intra.web;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shengpay.autorepayment.service.WithholdMoneyService;
import com.shengpay.debit.common.enums.WithholdOrderOpStatusEnum;
import com.shengpay.debit.common.enums.WithholdTransStatusEnum;
import com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoPO;
import com.shengpay.debit.dal.dataobject.TbWithholdingTransLogPO;
import com.shengpay.mcl.btc.response.BatchOrderStatusResponse;

/**
 * 银行卡代扣回调
 *
 * @author wangmindong 2015年12月4日 15:25:42
 */

@Controller
@RequestMapping("/withoutAuth")
public class CallBackWithholdAction {
	private static Logger log = LoggerFactory.getLogger(CallBackWithholdAction.class);
	@Autowired
	private WithholdMoneyService withholdMoneyService;
	/**
	 * 回调接口
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/callBackWithhold")
	public void callBackWithhold(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		log.info("callBack Withhold start request:{}", ToStringBuilder.reflectionToString(request, ToStringStyle.SHORT_PREFIX_STYLE));
		try {
			if (request == null || response == null) {
				log.error("callBack request is null");
				return;
			}
			// 初始化参数
			BatchOrderStatusResponse result = initResponseResult(request);
			log.info("callBack Withhold  initResponseResult result:{}", ToStringBuilder.reflectionToString(result, ToStringStyle.SHORT_PREFIX_STYLE));
			// 参数校验
			if (validateResult(result)) {
				log.error("callBack withhold validateResult is false");
				return;
			}

			// 根据订单号查询订单信息
			TbWithholdingOrderInfoPO orderInfo = withholdMoneyService.findOrderInfoByTransNo(result.getTransNo());
			log.info("callBack Withhold  orderInfo:{}", ToStringBuilder.reflectionToString(orderInfo, ToStringStyle.SHORT_PREFIX_STYLE));
			if (orderInfo == null) {
				log.info("callBack Withhold  orderInfo is null, transNo:{}", result.getTransNo());
				return;
			}
			// 保存交易记录
			saveTransLog(request, result, orderInfo);

			if (WithholdOrderOpStatusEnum.ORDER_INVOK_CALLBACK.code.equals(orderInfo.getStatus())) {
				// 更新订单状态
				updateOrderOpStatus(result, orderInfo);
			}
			// 返回状态
			respNoticeResult(response, "OK");

		} catch (Exception e) {
			log.error("callBackWithhold.addTransInfo.error", e);
			respNoticeResult(response, "UNOK");
		}
		log.info("callBack Withhold end...");
	}

	/**
	 * 参数校验
	 *
	 * @param result
	 * @return
	 */
	private boolean validateResult(BatchOrderStatusResponse result) {
		if (StringUtils.isEmpty(result.getTransNo())) {
			return true;
		} else if (StringUtils.isEmpty(result.getPaymentNo())) {
			return true;
		} else if (StringUtils.isEmpty(result.getOrderNo())) {
			return true;
		} else if (StringUtils.isEmpty(result.getTransStatus())) { return true; }
		return false;
	}

	/**
	 * 更新[订单/批次]状态
	 *
	 * @param result
	 * @throws Exception
	 */
	private void updateOrderOpStatus(final BatchOrderStatusResponse result, final TbWithholdingOrderInfoPO orderInfo) {

		TbWithholdingOrderInfoPO dataDTO = new TbWithholdingOrderInfoPO();
		dataDTO.setStatus(WithholdOrderOpStatusEnum.ORDER_INVOK_CALLBACK.code);
		dataDTO.setMerchantOrderNo(result.getOrderNo());
		String orderExStatus = "";
		if (WithholdTransStatusEnum.PROCESSING.code.equals(result.getTransStatus())) {
			return;
		} else if (WithholdTransStatusEnum.SUCC.code.equals(result.getTransStatus())) {
			orderExStatus = WithholdOrderOpStatusEnum.ORDER_SUCCESS.code;
		} else if (WithholdTransStatusEnum.FAIL.code.equals(result.getTransStatus())) {
			orderExStatus = WithholdOrderOpStatusEnum.ORDER_FAILL.code;
		} else if (WithholdTransStatusEnum.TIMEOUT.code.equals(result.getTransStatus())) {
			orderExStatus = WithholdOrderOpStatusEnum.ORDER_TIMEOUT.code;
		}

		if (StringUtils.isEmpty(orderExStatus)) {
			log.error("orderNO:{},transNO:{},orderExStatus is empty", new Object[] { result.getOrderNo(), result.getTransNo() });
			return;
		}

		dataDTO.setBatchNo(orderInfo.getBatchNo());
		int updateCount=withholdMoneyService.updateOrderOpStatus(dataDTO, orderExStatus);
		log.error("orderNO:{},transNO:{},orderExStatus:{},updateCount:{} update orderStatus is sucess", new Object[] { result.getOrderNo(), result.getTransNo(),
				orderExStatus,updateCount });
	}

	/**
	 * 保存交易日志
	 *
	 * @param request
	 * @param result
	 */
	@SuppressWarnings("unused")
	private void saveTransLog(HttpServletRequest request, BatchOrderStatusResponse result, TbWithholdingOrderInfoPO orderInfo) {
		try {
			TbWithholdingTransLogPO callbackPo = new TbWithholdingTransLogPO();
			callbackPo.setRequestData(JSONObject.fromObject((request.getParameterMap())).toString());
			callbackPo.setRequestTime(new Date());
			callbackPo.setCreateTime(new Date());
			callbackPo.setMerchantOrderNo(result.getOrderNo());
			callbackPo.setResulttype("2");
			callbackPo.setCardNo(orderInfo.getCardNo());
			callbackPo.setBatchNo(orderInfo.getBatchNo());
			withholdMoneyService.addTransInfo(callbackPo);
			log.info("callBack Withhold  saveTransLog is sucess");
		} catch (Exception e) {
			log.error("callBack Withhold  saveTransLog is  error: " + e);
		}

	}

	/**
	 * 返回通知结果
	 *
	 * @param response
	 * @param msg
	 * @return
	 */
	HttpServletResponse respNoticeResult(HttpServletResponse response, String msg) {
		try {
			response.setContentType("text/html;charset=utf-8");
			Writer writer = response.getWriter();
			writer.write(msg);
			writer.flush();
			writer.close();
			log.info("返回通知结果成功!");
		} catch (Exception e) {
			log.error("返回通知结果异常:" + e);
		}

		return response;
	}

	/**
	 * 封装参数
	 *
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private BatchOrderStatusResponse initResponseResult(HttpServletRequest request) {
		// TODO Auto-generated method stub
		BatchOrderStatusResponse result = new BatchOrderStatusResponse();
		Map<String, String[]> map = request.getParameterMap();
		if (map == null) {
			log.info("request convert map is empty");
			return result;
		}
		log.info("request convert json is " + JSONObject.fromObject(map));

		if (map.get("TransNo").length == 0 || StringUtils.isEmpty(map.get("TransNo")[0])) {
			log.error("TransNo is null");
			return result;
		}
		if (map.get("PaymentNo").length == 0 || StringUtils.isEmpty(map.get("TransNo")[0])) {
			log.error("PaymentNo is null");
			return result;
		}
		if (map.get("TransStatus").length == 0 || StringUtils.isEmpty(map.get("TransStatus")[0])) {
			log.error("TransStatus is null");
			return result;
		}
		if (map.get("OrderNo").length == 0 || StringUtils.isEmpty(map.get("OrderNo")[0])) {
			log.error("OrderNo is null");
			return result;
		}
		result.setTransNo(map.get("TransNo")[0].toString()); // 产品订单号
		result.setPaymentNo(map.get("PaymentNo")[0].toString()); // 支付订单号
		result.setTransStatus(map.get("TransStatus")[0].toString());// 订单状态
		result.setOrderNo(map.get("OrderNo")[0].toString()); // 商户订单号

		return result;
	}
}
