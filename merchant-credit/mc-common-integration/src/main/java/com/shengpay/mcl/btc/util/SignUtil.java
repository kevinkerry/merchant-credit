package com.shengpay.mcl.btc.util;

import java.security.MessageDigest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sdo.mas.common.api.common.entity.Extension;
import com.sdo.mas.common.api.common.entity.Header;
import com.sdo.mas.common.api.common.entity.Sender;
import com.sdo.mas.common.api.common.entity.SignSource;
import com.sdo.mas.common.api.common.entity.Signature;
import com.sdo.mas.common.api.query.order.entity.syn.single.OrderQueryRequest;

public class SignUtil {
	private static final Logger log = LoggerFactory.getLogger(SignUtil.class);

	public static OrderQueryRequest signOrderQueryRequest(OrderQueryRequest request, String md5Key) throws Exception {

		SignSource signSource = request.buildSignSource();
		signSource.setMd5Key(md5Key);
		try {
			byte[] signBytes = (signSource.getSource() + signSource.getMd5Key()).getBytes(signSource.getCharset());
			MessageDigest msgDigest = MessageDigest.getInstance("MD5");
			msgDigest.update(signBytes);
			byte[] bytes = msgDigest.digest();
			String md5Str = new String(encodeHex(bytes));
			request.getSignature().setSignMsg(md5Str);
			return request;
		} catch (Exception e) {
			log.error("签名异常" + e.getMessage(), e);
			throw e;
		}
//		return null;
	}

	public static char[] encodeHex(byte[] data) {
		char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		int l = data.length;
		char[] out = new char[l << 1];
		for (int i = 0, j = 0; i < l; i++) {
			out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS[0x0F & data[i]];
		}
		return out;
	}

	/**
	 * 代扣查询验签
	 * @param request
	 * @param md5Key
	 * @return
	 * @throws Exception
	 */
	public static OrderQueryRequest signOrderRequest(OrderQueryRequest request, String md5Key) throws Exception {
		try {
			StringBuffer buf = new StringBuffer();
			// 按签名顺序
			if(StringUtils.isNotBlank(request.getHeader().getService().getServiceCode())){
				buf.append(request.getHeader().getService().getServiceCode());
				buf.append("|");
			}
			if(StringUtils.isNotBlank( request.getHeader().getService().getVersion())){
				buf.append( request.getHeader().getService().getVersion());
				buf.append("|");
			}
			if(StringUtils.isNotBlank( request.getHeader().getCharset())){
				buf.append(request.getHeader().getCharset());
				buf.append("|");
			}
			if(StringUtils.isNotBlank( request.getHeader().getTraceNo())){
				buf.append(request.getHeader().getTraceNo());
				buf.append("|");
			}
			if(StringUtils.isNotBlank(request.getHeader().getSender().getSenderId())){
				buf.append(request.getHeader().getSender().getSenderId());
				buf.append("|");
			}
			if(StringUtils.isNotBlank(request.getHeader().getSendTime())){
				buf.append(request.getHeader().getSendTime());
				buf.append("|");
			}
			if(StringUtils.isNotBlank(request.getMerchantNo())){
				buf.append(request.getMerchantNo());
				buf.append("|");
			}
			if(StringUtils.isNotBlank(request.getOrderNo())){
				buf.append(request.getOrderNo());
				buf.append("|");
			}
			if(StringUtils.isNotBlank(request.getTransNo())){
				buf.append(request.getTransNo());
				buf.append("|");
			}
			if(StringUtils.isNotBlank(request.getExtension().getExt1())){
				buf.append(request.getExtension().getExt1());
				buf.append("|");
			}
			if(StringUtils.isNotBlank(request.getExtension().getExt2())){
				buf.append(request.getExtension().getExt2());
				buf.append("|");
			}
			if(StringUtils.isNotBlank(request.getSignature().getSignType())){
				buf.append(request.getSignature().getSignType());
				buf.append("|");
			}
			String signSource =buf.append(md5Key).toString();
			byte[] signBytes = signSource.getBytes("UTF-8");
			MessageDigest msgDigest = MessageDigest.getInstance("MD5");
			msgDigest.update(signBytes);
			byte[] bytes = msgDigest.digest();
			String md5Str = new String(encodeHex(bytes));
			request.getSignature().setSignMsg(md5Str);
			log.info("#signOrderQuery signSource case before:{},end:{}",new Object[]{signSource,md5Str});
			return request;

		} catch (Exception e) {
			log.error("签名异常" + e.getMessage(), e);
			throw e;
		}
	}
	public static void main(String[] args) {
//		String macInfo = "QUERY_ORDER_REQUEST|V4.3.1.1.1|UTF-8|20161012132000|674017|20161012132000|20161012100500268356|MD5|";
////		String mac = MD5.sign(macInfo, "sdpxiaodai", "UTF-8");
//		try {
//			byte[] signBytes = (macInfo + "sdpxiaodai").getBytes("UTF-8");
//			MessageDigest msgDigest = MessageDigest.getInstance("MD5");
//			msgDigest.update(signBytes);
//			byte[] bytes = msgDigest.digest();
//			String md5Str = new String(encodeHex(bytes));
//			System.out.println(md5Str);
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		OrderQueryRequest request = new OrderQueryRequest();

		Header head = new Header();
		Sender sender = new Sender();
		Signature sign = new Signature();
		request.setSignature(sign);
		head.setSender(sender);
		head.getSender().setSenderId("674017");
		head.setCharset("UTF-8");
		request.setHeader(head);
		request.getSignature().setSignType("MD5");
		request.setTransNo("20161011093009599411");
		com.sdo.mas.common.api.common.entity.Service service = new com.sdo.mas.common.api.common.entity.Service();
		head.setService(service);
		Extension ext = new Extension();
		request.setExtension(ext);
		head.getService().setServiceCode("QUERY_ORDER_REQUEST");
		head.getService().setVersion("V4.3.1.1.1");
		head.setSendTime("20161011093009");
		head.setTraceNo("20161011093009");
		try {
			signOrderRequest(request, "sdpxiaodai");
		} catch (Exception e) {
			log.error("SignUtil.signOrderRequest.error", e.getMessage(), e);
		}
	}
}
