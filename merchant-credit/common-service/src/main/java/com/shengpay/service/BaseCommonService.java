package com.shengpay.service;

import java.util.Date;

import com.sdp.mc.common.util.DateUtil;
public class BaseCommonService {

	private static Long seq = 0l;
	private static Long seq_max = 9999l;

	public static String generatorSeq() {
		String dateStr = DateUtil.date2Str(new Date(), DateUtil.fosOrderFormat);
		return dateStr + genSeqBySeq();
	}

	private static synchronized  String genSeqBySeq() {
		String result = "";
			if (seq >= seq_max) seq = 0l;
			seq = seq + 1;
			for (int i = 0; i < (String.valueOf(9999l).length() - String.valueOf(seq).length()); i++) {
				result += "0";
			}
			result += seq + "";
		return result;
	}
}
