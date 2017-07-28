package com.sdp.mc.t0.web;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.enums.withdraw.WithdrawOrderStatusEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawReqStatusEnums;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.integration.fos.dto.response.OrderResults;
import com.sdp.mc.integration.fos.dto.response.WithdrawBackOrderStatusDTO;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDO;
import com.sdp.withdraw.dao.WithdrawRetryPlanDO;
import com.sdp.withdraw.enums.ReturnCodeEnums;
import com.sdp.withdraw.service.LimitationService;
import com.sdp.withdraw.service.WithdrawFailService;
import com.sdp.withdraw.service.WithdrawReqFosDetailService;
import com.sdp.withdraw.service.WithdrawReqService;
import com.sdp.withdraw.service.WithdrawRetryService;
import com.sdp.withdraw.service.WithdrawServiceCallbackService;
import com.shengpay.commons.core.utils.StringUtils;

/**
 * FOS状态回调
 * @author wangmindong
 * 2016年3月3日16:31:04
 */
@Controller
@RequestMapping("/withdraw")
public class FOSWithdrawCallBackStatusAction {

	private static final Logger logger = LoggerFactory.getLogger(FOSWithdrawCallBackStatusAction.class);

    
	@Autowired
	private WithdrawServiceCallbackService withdrawServiceCallbackService;


	@RequestMapping(value = "/callBackWithdraw")
	public void execute(HttpServletRequest httpRequest,HttpServletResponse httpRresponse){
		if (httpRequest == null) {
			logger.error("[FOSWithdrawCallBackStatusAction] httpRequest is null！");
		    return ;
		}
		try {
			//初始化参数
			WithdrawBackOrderStatusDTO responseDto = initWithdrawParameters(httpRequest);
			if(responseDto==null||responseDto.getOrderResults()==null||responseDto.getOrderResults().get(0)==null){
				logger.info("callBackWithdraw responseDto is null");
				return ;
			}
			this.withdrawServiceCallbackService.dealwithFosCallBack(responseDto);
		} catch (Exception e) {
			logger.error("callBackWithdraw Exception: "+e.getMessage(),e);
		}


	}
	//出款服务的测试地址   模拟调用 POS
	@RequestMapping(value = "/withdrawCallback")
	public void withdrawCallback(HttpServletRequest httpRequest,HttpServletResponse httpRresponse){
		if (httpRequest == null) {
			logger.error("[FOSWithdrawCallBackStatusAction] #withdrawCallback httpRequest is null！");
			return ;
		}
		String paramterMap=httpRequest.getParameterMap() !=null?JSONObject.fromObject(httpRequest.getParameterMap()).toString():"";
		logger.error("[FOSWithdrawCallBackStatusAction] #withdrawCallback httpRequest.ParameterMap："+paramterMap);
	}

	/**
	 * 初始化数据
	 * @param httpRequest
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	private WithdrawBackOrderStatusDTO initWithdrawParameters(HttpServletRequest httpRequest) throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		WithdrawBackOrderStatusDTO dto = new WithdrawBackOrderStatusDTO();
		//出款结果
		String jsonStr = httpRequest.getParameter("remitResult");
		logger.info("[FOSWithdrawCallBackStatusAction] initWithdrawParameters fos withdraw call back paras is : "+jsonStr);
		dto = WithdrawBackOrderStatusDTO.json2Bean(jsonStr);
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("orderResults", OrderResults.class);
		OrderResults orderResult = (OrderResults) JSONObject.toBean(JSONObject.fromObject(dto.getOrderResults().get(0)), OrderResults.class, classMap);
		List<OrderResults> orderResults = new ArrayList<OrderResults>();
		orderResults.add(orderResult);
		dto.setOrderResults(orderResults);
		return dto;
	}


	public static void main(String[] args) {
//		WithdrawBackOrderStatusDTO dto = new WithdrawBackOrderStatusDTO();
		String jsonStr = "{'batchNo':null,'payerMemberId':'603100000000000112047683','totalOrderNum':1,'orderResults':[{'paymentCode':'3002','remitVoucherNo':'10030003300200000000000000000203','prodCode':'10030003','payerMemberId':'603100000000000112047683','payerFee':0,'payeeFee':0,'pocketAmount':101.00,'paymentSeqNo':'201603230207214672','paymentState':'F','callbackAddress':'http://10.132.97.12:8085/mc-t0-service-website/withdraw/callBackWithdraw.do','returnCode':'90005','returnMsg':'出款失败.','extension':{'__amount__':'101.00','__payer_member_id__':'603100000000000112047683','app.callback':'http://10.132.97.12:8085/mc-t0-service-website/withdraw/callBackWithdraw.do','currency':'CNY'}}],'storeKey':null,'returnCode':'0','returnMsg':'出款失败.','callbackAddress':'http://10.132.97.12:8085/mc-t0-service-website/withdraw/callBackWithdraw.do','extension':{}}";
		WithdrawBackOrderStatusDTO dto = WithdrawBackOrderStatusDTO.json2Bean(jsonStr);
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("orderResults", OrderResults.class);
		OrderResults orderResult = (OrderResults) JSONObject.toBean(JSONObject.fromObject(dto.getOrderResults().get(0)), OrderResults.class, classMap);
		List<OrderResults> orderResults = new ArrayList<OrderResults>();
		orderResults.add(orderResult);
		dto.setOrderResults(orderResults);
		System.err.println(dto.getOrderResults().get(0).getReturnMsg());
	}
}
