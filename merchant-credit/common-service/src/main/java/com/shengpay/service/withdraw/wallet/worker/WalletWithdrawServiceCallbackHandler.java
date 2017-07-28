package com.shengpay.service.withdraw.wallet.worker;

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
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
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
import com.sdp.withdraw.dao.WalletWithdrawReqDO;
import com.sdp.withdraw.util.SignUtil;
import com.sdp.withdraw.vo.WithdrawResult;
import com.sdp.withdraw.vo.wallet.WalletWithdrawResult;
import com.shengpay.logback.mdc.trace.wrapper.InheritTraceNoRunableWrapper;
import com.shengpay.service.withdraw.wallet.WalletWithdrawService;
import com.snda.toolkit.common.util.StringUtil;

/**
 * 出款服务回掉，如果调用FOS出款服务，有最终的明确状态，调用回掉线程
 *
 * @author liyantao01
 *
 */
@Service("walletWithdrawServiceCallbackHandler")
public class WalletWithdrawServiceCallbackHandler {

	@Autowired
	private WalletWithdrawService walletWithdrawService;
	
	protected final ExecutorService pool = Executors.newFixedThreadPool(5);

	private Logger logger = LoggerFactory.getLogger(WalletWithdrawServiceCallbackHandler.class);

	public void execute(Long reqId) {
		logger.info("WithdrawServiceCallbackHandler #execute.");
		WalletWithdrawServiceCallbackTask transferIngTask = new WalletWithdrawServiceCallbackTask(reqId);
		pool.execute(new InheritTraceNoRunableWrapper(transferIngTask));
	}

	class WalletWithdrawServiceCallbackTask implements Runnable {

		private Logger logger = LoggerFactory.getLogger(WalletWithdrawServiceCallbackTask.class);

		private Long reqId;

		public WalletWithdrawServiceCallbackTask(Long reqId) {
			super();
			this.reqId = reqId;
		}

		public void run() {
			logger.info("WalletWithdrawServiceCallbackTask #run,Callback reqId：{}" , reqId );
			Assert.notNull(reqId);
			WalletWithdrawResult result = walletWithdrawService.queryWalletWithdrawInfo(reqId);
			logger.info("WalletWithdrawServiceCallbackTask #run queryWalletWithdrawInfo result:{}",ToStringBuilder.reflectionToString(result,ToStringStyle.SHORT_PREFIX_STYLE));
			if (result == null) {
				logger.info("WalletWithdrawServiceCallbackTask #run reqDo is null reqId：{}" , reqId);
				return;
			}

			if (StringUtil.isEmpty(result.getCallbackAddress()) || !result.getCallbackAddress().startsWith("http")) { 
				logger.info("WalletWithdrawServiceCallbackTask #run not satisfy callback required");
				return; }
			try {
				Map<String, String> resultMap = HttpUtils.beanToMap(result);
				String signature = getSignature(resultMap);
				resultMap.put("signature", signature);
				logger.info("WalletWithdrawServiceCallbackTask #run resultMap :"+resultMap);
				HttpUtils.post(result.getCallbackAddress(),resultMap);
			} catch (Exception e) {
				logger.error("WalletWithdrawServiceCallbackTask #run Exception reqId：{}" , reqId,e);
			}
		}

	}

	private String getSignature(Map<String, String> resultMap) {
		String[]  signatureAttrs = new String[] { "returnCode", "returnMsg", "remitVoucherNo", "originalAmount",
				"withdrawAmount", "withdrawFee", "withdrawCost", "settlementTime", "extention", "orderNo", "memberNo", "memberType", "traceNo",
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
		return SignUtil.signOrderQueryRequest(sb.toString().getBytes());
	}
	
}
