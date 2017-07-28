package com.sdp.mc.common.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;


/**
 * 数据签名、验签
 * @author xuhongbiao.darren
 * @date 2013-7-25 下午06:03:14
 *
 */
public final class SignHelper {

	private static final Logger log = LoggerFactory.getLogger(SignHelper.class);

	/**
	 * 签名
	 * @param signKey 密钥
	 * @param plainText 需要加签的字符串
	 * @return
	 */
	public static String sign(String signKey,String plainText){
		String signText = null;

		try{
			if(StringUtils.isNotEmpty(signKey) && StringUtils.isNotEmpty(plainText)){
				signText = DigestUtils.md5Hex(plainText + signKey).toUpperCase();
			}
		}catch(Exception e){
			log.error(e.getMessage(), e);
		}

		return signText;
	}

	/**
	 * 验签
	 * @param signKey 密钥
	 * @param plainText 需要验签的字符串
	 * @param signText 需要对比的签名串
	 * @return
	 */
	public static boolean verifySign(String signKey,String plainText,String signText){
		boolean succ = false;

		if(StringUtils.isNotEmpty(signKey) && StringUtils.isNotEmpty(plainText) && StringUtils.isNotEmpty(signText)){
			String signMsg = sign(signKey, plainText);
			succ = StringUtils.equalsIgnoreCase(signMsg, signText);
		}

		return succ;
	}

}
