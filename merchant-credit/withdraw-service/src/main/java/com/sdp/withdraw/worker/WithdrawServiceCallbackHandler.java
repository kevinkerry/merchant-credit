package com.sdp.withdraw.worker;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.util.HttpUtils;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDO;
import com.sdp.withdraw.service.WithdrawReqFosDetailService;
import com.sdp.withdraw.service.WithdrawReqService;
import com.sdp.withdraw.service.WithdrawServiceCallbackService;
import com.sdp.withdraw.util.SignUtil;
import com.sdp.withdraw.vo.WithdrawResult;
import com.shengpay.logback.mdc.trace.wrapper.InheritTraceNoRunableWrapper;
import com.snda.toolkit.common.util.StringUtil;

/**
 * 出款服务回掉，如果调用FOS出款服务，有最终的明确状态，调用回掉线程
 *
 * @author liyantao01
 *
 */
@Service("withdrawServiceCallbackHandler")
public class WithdrawServiceCallbackHandler {

	protected final ExecutorService pool = Executors.newFixedThreadPool(5);
	@Autowired
	private WithdrawServiceCallbackService withdrawServiceCallbackService;

	@Autowired
	private WithdrawReqService withdrawReqService;
	@Autowired
	private WithdrawReqFosDetailService withdrawReqFosDetailService;

	private Logger logger = LoggerFactory.getLogger(WithdrawServiceCallbackHandler.class);

	public void execute(Long reqId, String remitVoucherNo) {
		logger.info("WithdrawServiceCallbackHandler #execute.");
		WithdrawServiceCallbackTask transferIngTask = new WithdrawServiceCallbackTask(reqId, remitVoucherNo);
		pool.execute(new InheritTraceNoRunableWrapper(transferIngTask));
	}

	class WithdrawServiceCallbackTask implements Runnable {

		private Logger logger = LoggerFactory.getLogger(WithdrawServiceCallbackTask.class);

		private Long reqId;
		private String remitVoucherNo;

		public WithdrawServiceCallbackTask(Long reqId, String remitVoucherNo) {
			super();
			this.reqId = reqId;
			this.remitVoucherNo = remitVoucherNo;
		}

		public void run() {
			logger.info("WithdrawServiceCallbackTask #run,Callback reqId：" + reqId + ",remitVoucherNo:" + remitVoucherNo);
			Assert.notNull(reqId);
//			Assert.notNull(remitVoucherNo);
			WithdrawReqDO reqDo = withdrawReqService.queryWithdrawReqByReqId(reqId);
			if (reqDo == null) {
				logger.info("WithdrawServiceCallbackTask #run reqDo is null reqId：" + reqId + ",remitVoucherNo:" + remitVoucherNo);
				return;
			}
			WithdrawReqFosDetailDO detailDo = withdrawReqFosDetailService.queryLastDetailByReqId(reqId);
			if (detailDo == null) {
				logger.info("WithdrawServiceCallbackTask #run detailDo is null reqId：" + reqId + ",remitVoucherNo:" + remitVoucherNo);
				return;
			}
			if (StringUtils.isNotBlank(remitVoucherNo)&&!remitVoucherNo.equals(detailDo.getRemitVoucherNo())) { return; }

			if (StringUtil.isEmpty(reqDo.getCallbackAddress()) || !reqDo.getCallbackAddress().startsWith("http")) { return; }
			try {
				detailDo.setExtention(null);
				WithdrawResult result = withdrawReqService.getWithdrawResult(reqDo, detailDo);
				logger.info("WithdrawServiceCallbackTask #run result :"+ToStringBuilder.reflectionToString(result));
				Map<String, String> resultMap = HttpUtils.beanToMap(result);
				String signature = getSignature(resultMap);
				resultMap.put("signature", signature);
				logger.info("WithdrawServiceCallbackTask #run resultMap :"+resultMap);
				HttpUtils.post(reqDo.getCallbackAddress(),resultMap);
			} catch (Exception e) {
				logger.error("WithdrawServiceCallbackTask #run Exception reqId：" + reqId + ",remitVoucherNo:" + remitVoucherNo,e);
			}
		}

	}

	private String getSignature(Map<String, String> resultMap) throws UnsupportedEncodingException {
		String[]  signatureAttrs = new String[] { "returnCode", "returnMsg", "remitVoucherNo", "splittingCost", "splittingFee", "originalAmount",
				"withdrawAmount", "withdrawFee", "withdrawCost", "settlementTime", "extention", "orderNo", "memberId", "merchantNo", "traceNo",
				"appId" };
		StringBuffer sb = new StringBuffer("");
		for (String attr : signatureAttrs) {
			if (null != resultMap.get(attr)) {
				sb.append(resultMap.get(attr));
				sb.append("|");
			} else {
				sb.append("|");
			}
		}
		sb.append(WithdrawConstant.MD5key);
		return SignUtil.signOrderQueryRequest(sb.toString().getBytes("UTF-8"));
	}

	
}
